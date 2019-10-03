using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPolylineOutlineMaterialCesiumWriter : TestCesiumPropertyWriter<PolylineOutlineMaterialCesiumWriter>
    {
        [Test]
        public void TestWritePolylineOutlineMaterial()
        {
            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var polylineOutlineMaterial = material.OpenPolylineOutlineProperty())
            {
                polylineOutlineMaterial.WriteColorProperty(Color.Red);
                polylineOutlineMaterial.WriteOutlineColorProperty(Color.Blue);
            }

            Assert.AreEqual("{\"polyline\":{\"material\":{\"polylineOutline\":{\"color\":{\"rgba\":[255,0,0,255]},\"outlineColor\":{\"rgba\":[0,0,255,255]}}}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<PolylineOutlineMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineOutlineMaterialCesiumWriter(propertyName);
        }
    }
}