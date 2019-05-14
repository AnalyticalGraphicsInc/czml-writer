using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPolylineArrowMaterialCesiumWriter : TestCesiumPropertyWriter<PolylineArrowMaterialCesiumWriter>
    {
        [Test]
        public void TestWritePolylineArrowMaterial()
        {
            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var polylineArrowMaterial = material.OpenPolylineArrowProperty())
            {
                polylineArrowMaterial.WriteColorProperty(Color.Red);
            }

            Assert.AreEqual("{\"polyline\":{\"material\":{\"polylineArrow\":{\"color\":{\"rgba\":[255,0,0,255]}}}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<PolylineArrowMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineArrowMaterialCesiumWriter(propertyName);
        }
    }
}