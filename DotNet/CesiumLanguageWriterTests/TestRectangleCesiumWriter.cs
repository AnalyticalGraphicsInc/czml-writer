using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestRectangleCesiumWriter : TestCesiumPropertyWriter<RectangleCesiumWriter>
    {
        [Test]
        public void TestHeightReferenceProperties()
        {
            using (Packet)
            using (var rectangle = Packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteExtrudedHeightProperty(10.0);
                interval.WriteExtrudedHeightReferenceProperty(CesiumHeightReference.RelativeToGround);
            }

            Assert.AreEqual("{\"rectangle\":{\"extrudedHeight\":10,\"extrudedHeightReference\":\"RELATIVE_TO_GROUND\"}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<RectangleCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new RectangleCesiumWriter(propertyName);
        }
    }
}