using System.Collections.Generic;
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
            var expectedColor = Color.Red;
            const double expectedGlowPower = 0.7;
            const double expectedTaperPower = 0.2;

            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var polylineGlowMaterial = material.OpenPolylineGlowProperty())
            {
                polylineGlowMaterial.WriteColorProperty(expectedColor);
                polylineGlowMaterial.WriteGlowPowerProperty(expectedGlowPower);
                polylineGlowMaterial.WriteTaperPowerProperty(expectedTaperPower);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.PolylineGlowPropertyName, new Dictionary<string, object>
                            {
                                { PolylineGlowMaterialCesiumWriter.ColorPropertyName, expectedColor },
                                { PolylineGlowMaterialCesiumWriter.GlowPowerPropertyName, expectedGlowPower },
                                { PolylineGlowMaterialCesiumWriter.TaperPowerPropertyName, expectedTaperPower },
                            }
                        },
                    }
                }
            });
        }

        protected override CesiumPropertyWriter<PolylineGlowMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineGlowMaterialCesiumWriter(propertyName);
        }
    }
}