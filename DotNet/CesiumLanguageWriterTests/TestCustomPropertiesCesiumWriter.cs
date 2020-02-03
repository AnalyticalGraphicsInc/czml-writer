using System;
using System.Collections.Generic;
using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCustomPropertiesCesiumWriter : TestCesiumPropertyWriter<CustomPropertiesCesiumWriter>
    {
        private JulianDate m_startDate;
        private string m_isoStartString;
        private JulianDate m_stopDate;
        private string m_isoIntervalString;

        [SetUp]
        public void SetUp()
        {
            m_startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            m_isoStartString = CesiumFormattingHelper.ToIso8601(m_startDate, Iso8601Format.Compact);
            m_stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0).ToJulianDate();
            m_isoIntervalString = CesiumFormattingHelper.ToIso8601Interval(m_startDate, m_stopDate, Iso8601Format.Compact);
        }

        [Test]
        public void CustomPropertyBooleanConstant()
        {
            const string expectedName = "custom_property";
            const bool expectedValue = true;

            using (Packet)
            using (var customPropertiesWriter = Packet.OpenPropertiesProperty())
            {
                using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty(expectedName))
                {
                    customPropertyWriter.WriteBoolean(expectedValue);
                }
            }

            AssertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, new Dictionary<string, object>
            {
                { expectedName, expectedValue },
            });
        }

        [Test]
        public void CustomPropertyBooleanInterval()
        {
            const string expectedName = "custom_property";
            const bool expectedValue = true;

            using (Packet)
            using (var customPropertiesWriter = Packet.OpenPropertiesProperty())
            using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty(expectedName))
            using (var intervalWriter = customPropertyWriter.OpenInterval(m_startDate, m_stopDate))
            {
                intervalWriter.WriteBoolean(expectedValue);
            }

            AssertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, new Dictionary<string, object>
            {
                {
                    expectedName, new Dictionary<string, object>
                    {
                        { "interval", m_isoIntervalString },
                        { CustomPropertyCesiumWriter.BooleanPropertyName, expectedValue },
                    }
                },
            });
        }

        [Test]
        public void CustomPropertyCartesianConstant()
        {
            const string expectedName = "custom_property";
            var expectedValue = new Cartesian(1.1, 2.2, 3.3);

            using (Packet)
            using (var customPropertiesWriter = Packet.OpenPropertiesProperty())
            using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty(expectedName))
            {
                customPropertyWriter.WriteCartesian(expectedValue);
            }

            AssertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, new Dictionary<string, object>
            {
                { expectedName, expectedValue },
            });
        }

        [Test]
        public void CustomPropertyCartesianSampled()
        {
            using (Packet)
            using (var customPropertiesWriter = Packet.OpenPropertiesProperty())
            using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty("custom_property"))
            {
                var dates = new List<JulianDate>();
                var values = new List<Cartesian>();

                dates.Add(m_startDate);
                values.Add(new Cartesian(1.0, 2.0, 3.0));

                dates.Add(m_startDate.AddSeconds(60.0));
                values.Add(new Cartesian(4.0, 5.0, 6.0));

                dates.Add(m_startDate.AddSeconds(120.0));
                values.Add(new Cartesian(7.0, 8.0, 9.0));

                customPropertyWriter.WriteCartesian(dates, values);
            }

            Assert.AreEqual("{\"properties\":{\"custom_property\":{\"epoch\":\"" + m_isoStartString + "\",\"cartesian\":[0,1,2,3,60,4,5,6,120,7,8,9]}}}", StringWriter.ToString());
        }

        [Test]
        public void CustomPropertyCartesianSampledInterpolationSettings()
        {
            using (Packet)
            using (var customPropertiesWriter = Packet.OpenPropertiesProperty())
            using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty("custom_property"))
            {
                customPropertyWriter.WriteInterpolationAlgorithm(CesiumInterpolationAlgorithm.Hermite);

                var dates = new List<JulianDate>();
                var values = new List<Cartesian>();

                dates.Add(m_startDate);
                values.Add(new Cartesian(1.0, 2.0, 3.0));

                dates.Add(m_startDate.AddSeconds(60.0));
                values.Add(new Cartesian(4.0, 5.0, 6.0));

                dates.Add(m_startDate.AddSeconds(120.0));
                values.Add(new Cartesian(7.0, 8.0, 9.0));

                customPropertyWriter.WriteCartesian(dates, values);
            }

            Assert.AreEqual("{\"properties\":{\"custom_property\":{\"interpolationAlgorithm\":\"HERMITE\",\"epoch\":\"" + m_isoStartString + "\",\"cartesian\":[0,1,2,3,60,4,5,6,120,7,8,9]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestMultipleProperties()
        {
            const string expectedName1 = "custom_boolean";
            const bool expectedValue1 = true;
            const string expectedName2 = "custom_cartesian";
            var expectedValue2 = new Cartesian(1.1, 2.2, 3.3);

            using (Packet)
            using (var customPropertiesWriter = Packet.OpenPropertiesProperty())
            {
                using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty(expectedName1))
                {
                    customPropertyWriter.WriteBoolean(expectedValue1);
                }

                using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty(expectedName2))
                {
                    customPropertyWriter.WriteCartesian(expectedValue2);
                }
            }

            AssertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, new Dictionary<string, object>
            {
                { expectedName1, expectedValue1 },
                { expectedName2, expectedValue2 },
            });
        }

        [Test]
        public void CreateExampleFile()
        {
            using (var stringWriter = new StringWriter())
            {
                var output = new CesiumOutputStream(stringWriter) { PrettyFormatting = true };
                var writer = new CesiumStreamWriter();

                output.WriteStartSequence();

                using (var documentPacket = writer.OpenPacket(output))
                {
                    documentPacket.WriteId("document");
                    documentPacket.WriteVersion("1.0");
                    using (var clockWriter = documentPacket.OpenClockProperty())
                    using (var intervalClockWriter = clockWriter.OpenInterval(m_startDate, m_stopDate))
                    {
                        intervalClockWriter.WriteCurrentTime(m_startDate);
                    }
                }

                using (var packet = writer.OpenPacket(output))
                {
                    packet.WriteId("MyID");

                    using (var customPropertiesWriter = packet.OpenPropertiesProperty())
                    {
                        using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty("custom_boolean"))
                        using (var intervalListWriter = customPropertyWriter.OpenMultipleIntervals())
                        {
                            using (var intervalWriter = intervalListWriter.OpenInterval(m_startDate, m_startDate.AddSeconds(1)))
                            {
                                intervalWriter.WriteBoolean(true);
                            }

                            using (var intervalWriter = intervalListWriter.OpenInterval(m_startDate.AddSeconds(1), m_startDate.AddSeconds(2)))
                            {
                                intervalWriter.WriteBoolean(false);
                            }

                            using (var intervalWriter = intervalListWriter.OpenInterval(m_startDate.AddSeconds(2), m_stopDate))
                            {
                                intervalWriter.WriteBoolean(true);
                            }
                        }

                        using (var customPropertyWriter = customPropertiesWriter.OpenCustomPropertyProperty("custom_cartesian"))
                        {
                            var dates = new List<JulianDate>();
                            var values = new List<Cartesian>();

                            dates.Add(m_startDate);
                            values.Add(new Cartesian(1.0, 2.0, 3.0));

                            dates.Add(m_startDate.AddSeconds(60.0));
                            values.Add(new Cartesian(4.0, 5.0, 6.0));

                            dates.Add(m_startDate.AddSeconds(120.0));
                            values.Add(new Cartesian(7.0, 8.0, 9.0));

                            customPropertyWriter.WriteCartesian(dates, values);
                        }
                    }
                }

                output.WriteEndSequence();

                Console.WriteLine(stringWriter.ToString());
            }
        }

        protected override CesiumPropertyWriter<CustomPropertiesCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new CustomPropertiesCesiumWriter(propertyName);
        }
    }
}