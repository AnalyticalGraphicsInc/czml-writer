using System;
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
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (NodeTransformationsCesiumWriter nodeTransformsWriter = model.OpenNodeTransformationsProperty())
            {
                using (NodeTransformationCesiumWriter nodeTransformWriter = nodeTransformsWriter.OpenNodeTransformationProperty("node1"))
                {
                    nodeTransformWriter.WriteScaleProperty(Cartesian.Zero);
                    nodeTransformWriter.WriteRotationProperty(UnitQuaternion.Identity);
                    nodeTransformWriter.WriteTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
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
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (NodeTransformationsCesiumWriter nodeTransformsWriter = model.OpenNodeTransformationsProperty())
            {
                using (NodeTransformationCesiumWriter nodeTransformWriter = nodeTransformsWriter.OpenNodeTransformationProperty("node1"))
                {
                    nodeTransformWriter.WriteScaleProperty(new Cartesian(1.0, 2.0, 3.0));
                    nodeTransformWriter.WriteRotationProperty(new UnitQuaternion(1.0, 0.0, 0.0, 0.0));
                    nodeTransformWriter.WriteTranslationProperty(new Cartesian(4.0, 5.0, 6.0));
                }

                using (NodeTransformationCesiumWriter nodeTransformWriter = nodeTransformsWriter.OpenNodeTransformationProperty("node2"))
                {
                    nodeTransformWriter.WriteScaleProperty(new Cartesian(4.0, 5.0, 6.0));
                    nodeTransformWriter.WriteRotationProperty(new UnitQuaternion(0.0, 0.0, 0.0, 1.0));
                    nodeTransformWriter.WriteTranslationProperty(new Cartesian(7.0, 8.0, 9.0));
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
        [Explicit]
        public void Sandbox()
        {
            JulianDate date = new JulianDate(2451545.0);

            using (StringWriter sw = new StringWriter())
            {
                CesiumOutputStream output = new CesiumOutputStream(sw);
                output.PrettyFormatting = true;
                CesiumStreamWriter writer = new CesiumStreamWriter();

                using (PacketCesiumWriter packet = writer.OpenPacket(output))
                {
                    packet.WriteId("MyID");
                    packet.WriteAvailability(date, date.AddDays(1.0));

                    using (ModelCesiumWriter model = packet.OpenModelProperty())
                    using (NodeTransformationsCesiumWriter transforms = model.OpenNodeTransformationsProperty())
                    {
                        using (NodeTransformationCesiumWriter transform = transforms.OpenNodeTransformationProperty("node1"))
                        {
                            transform.WriteScaleProperty(Cartesian.Zero);
                            transform.WriteRotationProperty(UnitQuaternion.Identity);
                            transform.WriteTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
                        }

                        using (NodeTransformationCesiumWriter transform = transforms.OpenNodeTransformationProperty("node2"))
                        {
                            transform.WriteScaleProperty(Cartesian.Zero);
                            transform.WriteRotationProperty(UnitQuaternion.Identity);
                            transform.WriteTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
                        }
                    }
                }

                Console.WriteLine(sw.ToString());
            }
        }
    }
}