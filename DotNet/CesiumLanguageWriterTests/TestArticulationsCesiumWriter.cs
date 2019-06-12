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
            using (Packet)
            using (var modelWriter = Packet.OpenModelProperty())
            using (var articulationsWriter = modelWriter.OpenArticulationsProperty())
            using (var articulationWriter = articulationsWriter.OpenArticulationProperty("articulation1 stage1"))
            {
                articulationWriter.WriteNumber(3.5);
            }

            const string expected = "{\"model\":{\"articulations\":{\"articulation1 stage1\":3.5}}}";
            Assert.AreEqual(expected, StringWriter.ToString());
        }

        [Test]
        public void MultipleArticulations()
        {
            using (Packet)
            using (var modelWriter = Packet.OpenModelProperty())
            using (var articulationsWriter = modelWriter.OpenArticulationsProperty())
            {
                using (var articulationWriter = articulationsWriter.OpenArticulationProperty("articulation1 stage1"))
                {
                    articulationWriter.WriteNumber(4.0);
                }

                using (var articulationWriter = articulationsWriter.OpenArticulationProperty("articulation1 stage2"))
                {
                    articulationWriter.WriteNumber(5.0);
                }
            }

            const string expected = "{\"model\":{\"articulations\":{\"articulation1 stage1\":4,\"articulation1 stage2\":5}}}";
            Assert.AreEqual(expected, StringWriter.ToString());
        }

        [Test]
        public void CreateExampleFile()
        {
            using (var stringWriter = new StringWriter())
            {
                var output = new CesiumOutputStream(stringWriter) { PrettyFormatting = true };
                var writer = new CesiumStreamWriter();

                using (var packet = writer.OpenPacket(output))
                {
                    packet.WriteId("MyID");

                    var startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));
                    var stopDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 1, 0));

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
                                var dates = new List<JulianDate>
                                {
                                    startDate,
                                    stopDate
                                };
                                var values = new List<double>
                                {
                                    1.0,
                                    10.0
                                };
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