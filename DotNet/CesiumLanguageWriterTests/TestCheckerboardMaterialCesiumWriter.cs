using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCheckerboardMaterialCesiumWriter : TestCesiumPropertyWriter<CheckerboardMaterialCesiumWriter>
    {
        [Test]
        public void TestWriteCheckerboardMaterial()
        {
            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var checkerboardMaterial = material.OpenCheckerboardProperty())
            {
                checkerboardMaterial.WriteEvenColorProperty(Color.Red);
                checkerboardMaterial.WriteOddColorProperty(Color.Blue);
                checkerboardMaterial.WriteRepeatProperty(3.5, 4.5);
            }

            Assert.AreEqual("{\"polyline\":{\"material\":{\"checkerboard\":{\"evenColor\":{\"rgba\":[255,0,0,255]},\"oddColor\":{\"rgba\":[0,0,255,255]},\"repeat\":{\"cartesian2\":[3.5,4.5]}}}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<CheckerboardMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new CheckerboardMaterialCesiumWriter(propertyName);
        }
    }
}