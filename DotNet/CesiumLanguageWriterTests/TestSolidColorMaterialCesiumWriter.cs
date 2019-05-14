using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestSolidColorMaterialCesiumWriter : TestCesiumPropertyWriter<SolidColorMaterialCesiumWriter>
    {
        [Test]
        public void TestWriteSolidColorMaterial()
        {
            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var solidColorMaterial = material.OpenSolidColorProperty())
            {
                solidColorMaterial.WriteColorProperty(Color.Red);
            }

            Assert.AreEqual("{\"polyline\":{\"material\":{\"solidColor\":{\"color\":{\"rgba\":[255,0,0,255]}}}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<SolidColorMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new SolidColorMaterialCesiumWriter(propertyName);
        }
    }
}