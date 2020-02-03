using System;
using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPolylineDashMaterialCesiumWriter : TestCesiumPropertyWriter<PolylineDashMaterialCesiumWriter>
    {
        [Test]
        public void TestWritePolylineDashMaterial()
        {
            var expectedColor = Color.Red;
            int expectedDashPattern = Convert.ToInt32("0011001100110011", 2);
            var expectedGapColor = Color.Blue;
            const double expectedDashLength = 25;

            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var polylineDashMaterial = material.OpenPolylineDashProperty())
            {
                polylineDashMaterial.WriteColorProperty(expectedColor);
                polylineDashMaterial.WriteDashPatternProperty(expectedDashPattern);
                polylineDashMaterial.WriteGapColorProperty(expectedGapColor);
                polylineDashMaterial.WriteDashLengthProperty(expectedDashLength);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.PolylineDashPropertyName, new Dictionary<string, object>
                            {
                                { PolylineDashMaterialCesiumWriter.ColorPropertyName, expectedColor },
                                { PolylineDashMaterialCesiumWriter.DashPatternPropertyName, expectedDashPattern },
                                { PolylineDashMaterialCesiumWriter.GapColorPropertyName, expectedGapColor },
                                { PolylineDashMaterialCesiumWriter.DashLengthPropertyName, expectedDashLength },
                            }
                        },
                    }
                }
            });
        }

        protected override CesiumPropertyWriter<PolylineDashMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineDashMaterialCesiumWriter(propertyName);
        }
    }
}