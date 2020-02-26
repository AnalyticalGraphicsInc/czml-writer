using System.Collections.Generic;
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
            var expectedEvenColor = Color.Red;
            var expectedOddColor = Color.Blue;
            var expectedRepeat = new Rectangular(3.5, 4.5);

            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var checkerboardMaterial = material.OpenCheckerboardProperty())
            {
                checkerboardMaterial.WriteEvenColorProperty(expectedEvenColor);
                checkerboardMaterial.WriteOddColorProperty(expectedOddColor);
                checkerboardMaterial.WriteRepeatProperty(expectedRepeat);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.CheckerboardPropertyName, new Dictionary<string, object>
                            {
                                { CheckerboardMaterialCesiumWriter.EvenColorPropertyName, expectedEvenColor },
                                { CheckerboardMaterialCesiumWriter.OddColorPropertyName, expectedOddColor },
                                { CheckerboardMaterialCesiumWriter.RepeatPropertyName, expectedRepeat },
                            }
                        },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<CheckerboardMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new CheckerboardMaterialCesiumWriter(propertyName);
        }
    }
}