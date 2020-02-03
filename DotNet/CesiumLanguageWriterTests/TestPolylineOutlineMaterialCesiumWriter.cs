using System.Collections.Generic;
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
            var expectedColor = Color.Red;
            var expectedOutlineColor = Color.Blue;

            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var polylineOutlineMaterial = material.OpenPolylineOutlineProperty())
            {
                polylineOutlineMaterial.WriteColorProperty(expectedColor);
                polylineOutlineMaterial.WriteOutlineColorProperty(expectedOutlineColor);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.PolylineOutlinePropertyName, new Dictionary<string, object>
                            {
                                { PolylineOutlineMaterialCesiumWriter.ColorPropertyName, expectedColor },
                                { PolylineOutlineMaterialCesiumWriter.OutlineColorPropertyName, expectedOutlineColor },
                            }
                        },
                    }
                }
            });
        }

        protected override CesiumPropertyWriter<PolylineOutlineMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineOutlineMaterialCesiumWriter(propertyName);
        }
    }
}