using System;
using System.Collections.Generic;
using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestModelNodeTransformationCesiumWriter : TestCesiumPropertyWriter<ModelNodeTransformsCesiumWriter>
    {
        protected override CesiumPropertyWriter<ModelNodeTransformsCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ModelNodeTransformsCesiumWriter(propertyName);
        }

        [Test]
        public void SingleNodeTransformation()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelNodeTransformsCesiumWriter nodeTransformsWriter = model.OpenNodeTransformationsProperty())
            {
                using (ModelNodeTransformationCesiumWriter nodeTransformWriter =
                        nodeTransformsWriter.OpenNewNodeTransformation("node1"))
                {
                    nodeTransformWriter.WriteScaleProperty(Cartesian.Zero);
                    nodeTransformWriter.WriteRotationProperty(UnitQuaternion.Identity);
                    nodeTransformWriter.WriteTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
                }
            }

            Assert.AreEqual("{\"model\":{\"nodeTransformations\":{" +
                "\"node1\":{\"scale\":{\"cartesian\":[0,0,0]},\"rotation\":{\"unitQuaternion\":[0,0,0,1]},\"translation\":{\"cartesian\":[3,3,3]}" +
                "}}}}", StringWriter.ToString());
        }

        [Test]
        public void MultipleNodeTransformations()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelNodeTransformsCesiumWriter nodeTransformsWriter = model.OpenNodeTransformationsProperty())
            {
                using (ModelNodeTransformationCesiumWriter nodeTransformWriter =
                        nodeTransformsWriter.OpenNewNodeTransformation("node1"))
                {
                    nodeTransformWriter.WriteScaleProperty(Cartesian.Zero);
                    nodeTransformWriter.WriteRotationProperty(UnitQuaternion.Identity);
                    nodeTransformWriter.WriteTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
                }

                using (ModelNodeTransformationCesiumWriter nodeTransformWriter =
                        nodeTransformsWriter.OpenNewNodeTransformation("node2"))
                {
                    nodeTransformWriter.WriteScaleProperty(Cartesian.Zero);
                    nodeTransformWriter.WriteRotationProperty(UnitQuaternion.Identity);
                    nodeTransformWriter.WriteTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
                }
            }

            string expectedValue =
                "{\"model\":{\"nodeTransformations\":{" +
                "\"node1\":{\"scale\":{\"cartesian\":[0,0,0]},\"rotation\":{\"unitQuaternion\":[0,0,0,1]},\"translation\":{\"cartesian\":[3,3,3]}}," +
                "\"node2\":{\"scale\":{\"cartesian\":[0,0,0]},\"rotation\":{\"unitQuaternion\":[0,0,0,1]},\"translation\":{\"cartesian\":[3,3,3]}}" +
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
                    using (ModelNodeTransformsCesiumWriter transforms = model.OpenNodeTransformationsProperty())
                    {
                        using (ModelNodeTransformationCesiumWriter transform = transforms.OpenNewNodeTransformation("node1"))
                        {
                            transform.WriteScaleProperty(Cartesian.Zero);
                            transform.WriteRotationProperty(UnitQuaternion.Identity);
                            transform.WriteTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
                        }

                        using (ModelNodeTransformationCesiumWriter transform = transforms.OpenNewNodeTransformation("node2"))
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