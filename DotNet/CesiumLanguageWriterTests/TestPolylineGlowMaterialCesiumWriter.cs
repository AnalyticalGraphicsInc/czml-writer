using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPolylineGlowMaterialCesiumWriter : TestCesiumPropertyWriter<PolylineGlowMaterialCesiumWriter>
    {
        [Test]
        public void TestWritePolylineGlowMaterial()
        {
            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var polylineGlowMaterial = material.OpenPolylineGlowProperty())
            {
                polylineGlowMaterial.WriteColorProperty(Color.Red);
                polylineGlowMaterial.WriteGlowPowerProperty(0.7);
                polylineGlowMaterial.WriteTaperPowerProperty(0.2);
            }

            Assert.AreEqual("{\"polyline\":{\"material\":{\"polylineGlow\":{\"color\":{\"rgba\":[255,0,0,255]},\"glowPower\":0.7,\"taperPower\":0.2}}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<PolylineGlowMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineGlowMaterialCesiumWriter(propertyName);
        }
    }
}