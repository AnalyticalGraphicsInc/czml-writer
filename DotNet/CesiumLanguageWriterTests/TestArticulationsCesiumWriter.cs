using System;
using System.Collections.Generic;
using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestArticulationsCesiumWriter : TestCesiumPropertyWriter<ArticulationsCesiumWriter>
    {
        [Test]
        public void SingleArticulation()
        {
            const string expectedName = "articulation1 stage1";
            const double expectedValue = 3.5;

            using (Packet)
            using (var modelWriter = Packet.OpenModelProperty())
            using (var articulationsWriter = modelWriter.OpenArticulationsProperty())
            using (var articulationWriter = articulationsWriter.OpenArticulationProperty(expectedName))
            {
                articulationWriter.WriteNumber(expectedValue);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                {
                    ModelCesiumWriter.ArticulationsPropertyName, new Dictionary<string, object>
                    {
                        { expectedName, expectedValue },
                    }
                },
            });
        }

        [Test]
        public void MultipleArticulations()
        {
            const string expectedName1 = "articulation1 stage1";
            const double expectedValue1 = 4.5;

            const string expectedName2 = "articulation1 stage2";
            const double expectedValue2 = 5.5;

            using (Packet)
            using (var modelWriter = Packet.OpenModelProperty())
            using (var articulationsWriter = modelWriter.OpenArticulationsProperty())
            {
                using (var articulationWriter = articulationsWriter.OpenArticulationProperty(expectedName1))
                {
                    articulationWriter.WriteNumber(expectedValue1);
                }

                using (var articulationWriter = articulationsWriter.OpenArticulationProperty(expectedName2))
                {
                    articulationWriter.WriteNumber(expectedValue2);
                }
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                {
                    ModelCesiumWriter.ArticulationsPropertyName, new Dictionary<string, object>
                    {
                        { expectedName1, expectedValue1 },
                        { expectedName2, expectedValue2 },
                    }
                },
            });
        }

        [Test]
        public void CreateExampleFile()
        {
            using (var stringWriter = new StringWriter())
            {
                var output = new CesiumOutputStream(stringWriter, true);
                var writer = new CesiumStreamWriter();

                using (var packet = writer.OpenPacket(output))
                {
                    packet.WriteId("MyID");

                    var startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
                    var stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0).ToJulianDate();

                    using (var clockWriter = packet.OpenClockProperty())
                    {
                        using (var intervalClockWriter = clockWriter.OpenInterval(startDate, stopDate))
                        {
                            intervalClockWriter.WriteCurrentTime(startDate);
                        }
                    }

                    using (var modelWriter = packet.OpenModelProperty())
                    {
                        modelWriter.WriteGltfProperty(new Uri("example.gltf", UriKind.Relative), CesiumResourceBehavior.LinkTo);

                        using (var articulationsWriter = modelWriter.OpenArticulationsProperty())
                        {
                            using (var articulationWriter = articulationsWriter.OpenArticulationProperty("articulation1 stage1"))
                            {
                                articulationWriter.WriteNumber(45);
                            }

                            using (var articulationWriter = articulationsWriter.OpenArticulationProperty("articulation1 stage2"))
                            {
                                var dates = new List<JulianDate> { startDate, stopDate, };
                                var values = new List<double> { 1.0, 10.0, };
                                articulationWriter.WriteNumber(dates, values);
                            }
                        }
                    }
                }

                Console.WriteLine(stringWriter.ToString());
            }
        }

        protected override CesiumPropertyWriter<ArticulationsCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ArticulationsCesiumWriter(propertyName);
        }
    }
}