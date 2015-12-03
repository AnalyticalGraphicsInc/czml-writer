using System;
using System.Collections.Generic;
using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestNodeTransformationsCesiumWriter : TestCesiumPropertyWriter<NodeTransformationsCesiumWriter>
    {
        protected override CesiumPropertyWriter<NodeTransformationsCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new NodeTransformationsCesiumWriter(propertyName);
        }

        [Test]
        public void SingleNodeTransformation()
        {
            using (Packet)
            using (var modelWriter = Packet.OpenModelProperty())
            using (var nodeTransformationsWriter = modelWriter.OpenNodeTransformationsProperty())
            {
                using (var nodeTransformationWriter = nodeTransformationsWriter.OpenNodeTransformationProperty("node1"))
                {
                    nodeTransformationWriter.WriteScaleProperty(Cartesian.Zero);
                    nodeTransformationWriter.WriteRotationProperty(UnitQuaternion.Identity);
                    nodeTransformationWriter.WriteTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
                }
            }

            Assert.AreEqual("{\"model\":{\"nodeTransformations\":{" +
                            "\"node1\":{\"scale\":{\"cartesian\":[0,0,0]},\"rotation\":{\"unitQuaternion\":[0,0,0,1]},\"translation\":{\"cartesian\":[3,3,3]}}" +
                            "}}}", StringWriter.ToString());
        }

        [Test]
        public void MultipleNodeTransformations()
        {
            using (Packet)
            using (var modelWriter = Packet.OpenModelProperty())
            using (var nodeTransformationsWriter = modelWriter.OpenNodeTransformationsProperty())
            {
                using (var nodeTransformationWriter = nodeTransformationsWriter.OpenNodeTransformationProperty("node1"))
                {
                    nodeTransformationWriter.WriteScaleProperty(new Cartesian(1.0, 2.0, 3.0));
                    nodeTransformationWriter.WriteRotationProperty(new UnitQuaternion(1.0, 0.0, 0.0, 0.0));
                    nodeTransformationWriter.WriteTranslationProperty(new Cartesian(4.0, 5.0, 6.0));
                }

                using (var nodeTransformationWriter = nodeTransformationsWriter.OpenNodeTransformationProperty("node2"))
                {
                    nodeTransformationWriter.WriteScaleProperty(new Cartesian(4.0, 5.0, 6.0));
                    nodeTransformationWriter.WriteRotationProperty(new UnitQuaternion(0.0, 0.0, 0.0, 1.0));
                    nodeTransformationWriter.WriteTranslationProperty(new Cartesian(7.0, 8.0, 9.0));
                }
            }

            string expectedValue =
                "{\"model\":{\"nodeTransformations\":{" +
                "\"node1\":{\"scale\":{\"cartesian\":[1,2,3]},\"rotation\":{\"unitQuaternion\":[0,0,0,1]},\"translation\":{\"cartesian\":[4,5,6]}}," +
                "\"node2\":{\"scale\":{\"cartesian\":[4,5,6]},\"rotation\":{\"unitQuaternion\":[0,0,1,0]},\"translation\":{\"cartesian\":[7,8,9]}}" +
                "}}}";
            Assert.AreEqual(expectedValue, StringWriter.ToString());
        }

        [Test]
        public void CreateExampleFile()
        {
            using (var stringWriter = new StringWriter())
            {
                var output = new CesiumOutputStream(stringWriter);
                output.PrettyFormatting = true;
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

                        using (var nodeTransformationsWriter = modelWriter.OpenNodeTransformationsProperty())
                        {
                            using (var nodeTransformationWriter = nodeTransformationsWriter.OpenNodeTransformationProperty("node1"))
                            {
                                nodeTransformationWriter.WriteScaleProperty(new Cartesian(1.0, 2.0, 3.0));
                                nodeTransformationWriter.WriteRotationProperty(UnitQuaternion.Identity);
                                nodeTransformationWriter.WriteTranslationProperty(new Cartesian(4.0, 5.0, 6.0));
                            }

                            using (var nodeTransformationWriter = nodeTransformationsWriter.OpenNodeTransformationProperty("node2"))
                            {
                                var dates = new List<JulianDate>
                                            {
                                                startDate,
                                                stopDate
                                            };
                                var values = new List<Cartesian>
                                             {
                                                 new Cartesian(1.0, 2.0, 3.0),
                                                 new Cartesian(10.0, 12.0, 14.0)
                                             };
                                nodeTransformationWriter.WriteScaleProperty(dates, values);
                            }
                        }
                    }
                }

                Console.WriteLine(stringWriter.ToString());
            }
        }
    }
}