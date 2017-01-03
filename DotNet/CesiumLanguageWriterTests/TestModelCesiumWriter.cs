using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestModelCesiumWriter : TestCesiumPropertyWriter<ModelCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelCesiumWriter interval = model.OpenInterval())
            {
                interval.WriteShowProperty(true);
            }
            Assert.AreEqual("{\"model\":{\"show\":true}}", StringWriter.ToString());
        }

        [Test]
        public void TestGltfProperty()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelCesiumWriter interval = model.OpenInterval())
            {
                interval.WriteGltfProperty("test.gltf", CesiumResourceBehavior.LinkTo);
            }
            Assert.AreEqual("{\"model\":{\"gltf\":\"test.gltf\"}}", StringWriter.ToString());
        }

        [Test]
        public void TestSilhouetteColorProperty()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelCesiumWriter interval = model.OpenInterval())
            {
                interval.WriteSilhouetteColorProperty(Color.Blue);
            }
            Assert.AreEqual("{\"model\":{\"silhouetteColor\":{\"rgba\":[0,0,255,255]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestSilhouetteSizeProperty()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelCesiumWriter interval = model.OpenInterval())
            {
                interval.WriteSilhouetteSizeProperty(0.75);
            }
            Assert.AreEqual("{\"model\":{\"silhouetteSize\":0.75}}", StringWriter.ToString());
        }

        [Test]
        public void TestColorProperty()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelCesiumWriter interval = model.OpenInterval())
            {
                interval.WriteColorProperty(Color.Red);
            }
            Assert.AreEqual("{\"model\":{\"color\":{\"rgba\":[255,0,0,255]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestColorBlendModeProperty()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelCesiumWriter interval = model.OpenInterval())
            {
                interval.WriteColorBlendModeProperty(CesiumColorBlendMode.Replace);
            }
            Assert.AreEqual("{\"model\":{\"colorBlendMode\":\"REPLACE\"}}", StringWriter.ToString());
        }

        [Test]
        public void TestColorBlendAmountProperty()
        {
            using (Packet)
            using (ModelCesiumWriter model = Packet.OpenModelProperty())
            using (ModelCesiumWriter interval = model.OpenInterval())
            {
                interval.WriteColorBlendAmountProperty(0.75);
            }
            Assert.AreEqual("{\"model\":{\"colorBlendAmount\":0.75}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<ModelCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ModelCesiumWriter(propertyName);
        }
    }
}