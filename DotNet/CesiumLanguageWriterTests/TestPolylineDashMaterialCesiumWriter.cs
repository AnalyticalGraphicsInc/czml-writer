using System;
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
            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var polylineDashMaterial = material.OpenPolylineDashProperty())
            {
                polylineDashMaterial.WriteColorProperty(Color.Red);
                polylineDashMaterial.WriteDashPatternProperty(Convert.ToInt32("0011001100110011", 2));
                polylineDashMaterial.WriteGapColorProperty(Color.Blue);
                polylineDashMaterial.WriteDashLengthProperty(25);
            }

            Assert.AreEqual("{\"polyline\":{\"material\":{\"polylineDash\":{\"color\":{\"rgba\":[255,0,0,255]},\"dashPattern\":13107,\"gapColor\":{\"rgba\":[0,0,255,255]},\"dashLength\":25}}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<PolylineDashMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineDashMaterialCesiumWriter(propertyName);
        }
    }
}