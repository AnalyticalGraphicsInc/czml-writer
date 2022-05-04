using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestLabelCesiumWriter : TestCesiumPropertyWriter<LabelCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.ShowPropertyName, expectedShow },
            });
        }

        [Test]
        public void TestTextProperty()
        {
            const string expectedText = "asdf";

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteTextProperty(expectedText);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.TextPropertyName, expectedText },
            });
        }

        [Test]
        public void TestTextPropertyInterval()
        {
            var startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            var stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0).ToJulianDate();

            var interval1Start = startDate;
            var interval1Stop = startDate.AddSeconds(1);
            var interval2Start = interval1Stop;
            var interval2Stop = startDate.AddSeconds(2);
            var interval3Start = interval2Stop;
            var interval3Stop = stopDate;

            const string interval1Value = "A";
            const string interval2Value = "B";
            const string interval3Value = "C";

            using (Packet)
            using (var billboard = Packet.OpenLabelProperty())
            using (var text = billboard.OpenTextProperty())
            using (var textIntervals = text.OpenMultipleIntervals())
            {
                using (var interval = textIntervals.OpenInterval(interval1Start, interval1Stop))
                {
                    interval.WriteString(interval1Value);
                }

                using (var interval = textIntervals.OpenInterval(interval2Start, interval2Stop))
                {
                    interval.WriteString(interval2Value);
                }

                using (var interval = textIntervals.OpenInterval(interval3Start, interval3Stop))
                {
                    interval.WriteString(interval3Value);
                }
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                {
                    LabelCesiumWriter.TextPropertyName, new List<Dictionary<string, object>>
                    {
                        new Dictionary<string, object>
                        {
                            { "interval", CesiumFormattingHelper.ToIso8601Interval(interval1Start, interval1Stop, Iso8601Format.Compact) },
                            { StringCesiumWriter.StringPropertyName, interval1Value },
                        },
                        new Dictionary<string, object>
                        {
                            { "interval", CesiumFormattingHelper.ToIso8601Interval(interval2Start, interval2Stop, Iso8601Format.Compact) },
                            { StringCesiumWriter.StringPropertyName, interval2Value },
                        },
                        new Dictionary<string, object>
                        {
                            { "interval", CesiumFormattingHelper.ToIso8601Interval(interval3Start, interval3Stop, Iso8601Format.Compact) },
                            { StringCesiumWriter.StringPropertyName, interval3Value },
                        },
                    }
                },
            });
        }

        [Test]
        public void TestShowBackgroundProperty()
        {
            const bool expectedShowBackground = true;

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteShowBackgroundProperty(expectedShowBackground);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.ShowBackgroundPropertyName, expectedShowBackground },
            });
        }

        [Test]
        public void TestBackgroundColorProperty()
        {
            var expectedBackgroundColor = Color.Red;

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteBackgroundColorProperty(expectedBackgroundColor);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.BackgroundColorPropertyName, expectedBackgroundColor },
            });
        }

        [Test]
        public void TestBackgroundPaddingProperty()
        {
            var expectedBackgroundPadding = new Rectangular(3, 4);

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteBackgroundPaddingProperty(expectedBackgroundPadding);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.BackgroundPaddingPropertyName, expectedBackgroundPadding },
            });
        }

        [Test]
        public void TestTranslucencyByDistanceProperty()
        {
            var expectedTranslucencyByDistance = new NearFarScalar(100.0, 1.0, 200.0, 2.0);

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteTranslucencyByDistanceProperty(expectedTranslucencyByDistance);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucencyByDistance },
            });
        }

        [Test]
        public void TestTranslucencyByDistancePropertySamples()
        {
            var epoch = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            using (var scaleByDistance = interval.OpenTranslucencyByDistanceProperty())
            {
                var dates = new List<JulianDate>();
                var values = new List<NearFarScalar>();

                dates.Add(epoch);
                values.Add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));

                dates.Add(epoch.AddSeconds(60.0));
                values.Add(new NearFarScalar(200.0, 1.0, 300.0, 2.0));

                scaleByDistance.WriteNearFarScalar(dates, values);
            }

            Assert.AreEqual("{\"label\":{\"translucencyByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<LabelCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new LabelCesiumWriter(propertyName);
        }
    }
}