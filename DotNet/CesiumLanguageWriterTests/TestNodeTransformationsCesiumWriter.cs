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
        [Test]
        public void SingleNodeTransformation()
        {
            const string expectedNodeName = "node1";
            var expectedScale = Cartesian.Zero;
            var expectedRotation = UnitQuaternion.Identity;
            var expectedTranslation = new Cartesian(3.0, 3.0, 3.0);

            using (Packet)
            using (var modelWriter = Packet.OpenModelProperty())
            using (var nodeTransformationsWriter = modelWriter.OpenNodeTransformationsProperty())
            {
                using (var nodeTransformationWriter = nodeTransformationsWriter.OpenNodeTransformationProperty(expectedNodeName))
                {
                    nodeTransformationWriter.WriteScaleProperty(expectedScale);
                    nodeTransformationWriter.WriteRotationProperty(expectedRotation);
                    nodeTransformationWriter.WriteTranslationProperty(expectedTranslation);
                }
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                {
                    ModelCesiumWriter.NodeTransformationsPropertyName, new Dictionary<string, object>
                    {
                        {
                            expectedNodeName, new Dictionary<string, object>
                            {
                                { NodeTransformationCesiumWriter.ScalePropertyName, expectedScale },
                                { NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation },
                                { NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation },
                            }
                        },
                    }
                },
            });
        }

        [Test]
        public void MultipleNodeTransformations()
        {
            const string expectedNodeName1 = "node1";
            var expectedScale1 = new Cartesian(1.0, 2.0, 3.0);
            var expectedRotation1 = new UnitQuaternion(1.0, 0.0, 0.0, 0.0);
            var expectedTranslation1 = new Cartesian(4.0, 5.0, 6.0);
            const string expectedNodeName2 = "node2";
            var expectedScale2 = new Cartesian(4.0, 5.0, 6.0);
            var expectedRotation2 = new UnitQuaternion(0.0, 0.0, 0.0, 1.0);
            var expectedTranslation2 = new Cartesian(7.0, 8.0, 9.0);

            using (Packet)
            using (var modelWriter = Packet.OpenModelProperty())
            using (var nodeTransformationsWriter = modelWriter.OpenNodeTransformationsProperty())
            {
                using (var nodeTransformationWriter = nodeTransformationsWriter.OpenNodeTransformationProperty(expectedNodeName1))
                {
                    nodeTransformationWriter.WriteScaleProperty(expectedScale1);
                    nodeTransformationWriter.WriteRotationProperty(expectedRotation1);
                    nodeTransformationWriter.WriteTranslationProperty(expectedTranslation1);
                }

                using (var nodeTransformationWriter = nodeTransformationsWriter.OpenNodeTransformationProperty(expectedNodeName2))
                {
                    nodeTransformationWriter.WriteScaleProperty(expectedScale2);
                    nodeTransformationWriter.WriteRotationProperty(expectedRotation2);
                    nodeTransformationWriter.WriteTranslationProperty(expectedTranslation2);
                }
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                {
                    ModelCesiumWriter.NodeTransformationsPropertyName, new Dictionary<string, object>
                    {
                        {
                            expectedNodeName1, new Dictionary<string, object>
                            {
                                { NodeTransformationCesiumWriter.ScalePropertyName, expectedScale1 },
                                { NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation1 },
                                { NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation1 },
                            }
                        },
                        {
                            expectedNodeName2, new Dictionary<string, object>
                            {
                                { NodeTransformationCesiumWriter.ScalePropertyName, expectedScale2 },
                                { NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation2 },
                                { NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation2 },
                            }
                        },
                    }
                },
            });
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

        protected override CesiumPropertyWriter<NodeTransformationsCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new NodeTransformationsCesiumWriter(propertyName);
        }
    }
}