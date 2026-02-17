using System.Collections.Generic;
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
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var polylineArrowMaterial = material.OpenPolylineArrowProperty())
            {
                polylineArrowMaterial.WriteColorProperty(expectedColor);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.PolylineArrowPropertyName, new Dictionary<string, object>
                            {
                                { PolylineArrowMaterialCesiumWriter.ColorPropertyName, expectedColor },
                            }
                        },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<PolylineArrowMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineArrowMaterialCesiumWriter(propertyName);
        }
    }
}