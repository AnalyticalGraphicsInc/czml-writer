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
            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var gridMaterial = material.OpenGridProperty())
            {
                gridMaterial.WriteColorProperty(Color.Red);
                gridMaterial.WriteCellAlphaProperty(0.7);
                gridMaterial.WriteLineCountProperty(6, 3);
                gridMaterial.WriteLineThicknessProperty(3, 4);
                gridMaterial.WriteLineOffsetProperty(5, 9);
            }

            Assert.AreEqual("{\"polyline\":{\"material\":{\"grid\":{\"color\":{\"rgba\":[255,0,0,255]},\"cellAlpha\":0.7,\"lineCount\":{\"cartesian2\":[6,3]},\"lineThickness\":{\"cartesian2\":[3,4]},\"lineOffset\":{\"cartesian2\":[5,9]}}}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<GridMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new GridMaterialCesiumWriter(propertyName);
        }
    }
}