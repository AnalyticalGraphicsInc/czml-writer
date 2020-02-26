using System.Collections.Generic;
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
            var expectedColor = Color.Red;

            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var solidColorMaterial = material.OpenSolidColorProperty())
            {
                solidColorMaterial.WriteColorProperty(expectedColor);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.SolidColorPropertyName, new Dictionary<string, object>
                            {
                                { SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor },
                            }
                        },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<SolidColorMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new SolidColorMaterialCesiumWriter(propertyName);
        }
    }
}