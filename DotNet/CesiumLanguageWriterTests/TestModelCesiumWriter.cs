using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestModelCesiumWriter : TestCesiumPropertyWriter<ModelCesiumWriter>
    {
        protected override CesiumPropertyWriter<ModelCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ModelCesiumWriter(propertyName);
        }

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
    }
}