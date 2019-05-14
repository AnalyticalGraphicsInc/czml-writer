using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestStripeMaterialCesiumWriter : TestCesiumPropertyWriter<StripeMaterialCesiumWriter>
    {
        [Test]
        public void TestWriteStripeMaterial()
        {
            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var stripeMaterial = material.OpenStripeProperty())
            {
                stripeMaterial.WriteEvenColorProperty(Color.Red);
                stripeMaterial.WriteOddColorProperty(Color.Blue);
                stripeMaterial.WriteOffsetProperty(1.5);
                stripeMaterial.WriteOrientationProperty(CesiumStripeOrientation.Vertical);
                stripeMaterial.WriteRepeatProperty(3.5);
            }

            Assert.AreEqual("{\"polyline\":{\"material\":{\"stripe\":{\"evenColor\":{\"rgba\":[255,0,0,255]},\"oddColor\":{\"rgba\":[0,0,255,255]},\"offset\":1.5,\"orientation\":\"VERTICAL\",\"repeat\":3.5}}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<StripeMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new StripeMaterialCesiumWriter(propertyName);
        }
    }
}