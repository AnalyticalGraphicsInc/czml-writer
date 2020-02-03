using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestGridMaterialCesiumWriter : TestCesiumPropertyWriter<GridMaterialCesiumWriter>
    {
        [Test]
        public void TestWriteGridMaterial()
        {
            var expectedColor = Color.Red;
            const double expectedCellAlpha = 0.7;
            var expectedLineCount = new Rectangular(6, 3);
            var expectedLineThickness = new Rectangular(3, 4);
            var expectedLineOffset = new Rectangular(5, 9);

            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var gridMaterial = material.OpenGridProperty())
            {
                gridMaterial.WriteColorProperty(expectedColor);
                gridMaterial.WriteCellAlphaProperty(expectedCellAlpha);
                gridMaterial.WriteLineCountProperty(expectedLineCount);
                gridMaterial.WriteLineThicknessProperty(expectedLineThickness);
                gridMaterial.WriteLineOffsetProperty(expectedLineOffset);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.GridPropertyName, new Dictionary<string, object>
                            {
                                { GridMaterialCesiumWriter.ColorPropertyName, expectedColor },
                                { GridMaterialCesiumWriter.CellAlphaPropertyName, expectedCellAlpha },
                                { GridMaterialCesiumWriter.LineCountPropertyName, expectedLineCount },
                                { GridMaterialCesiumWriter.LineThicknessPropertyName, expectedLineThickness },
                                { GridMaterialCesiumWriter.LineOffsetPropertyName, expectedLineOffset },
                            }
                        },
                    }
                }
            });
        }

        protected override CesiumPropertyWriter<GridMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new GridMaterialCesiumWriter(propertyName);
        }
    }
}