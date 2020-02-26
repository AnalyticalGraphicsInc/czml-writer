using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestStripeMaterialCesiumWriter : TestCesiumPropertyWriter<StripeMaterialCesiumWriter>
    {
        [Test]
        public void TestWriteStripeMaterial()
        {
            var expectedEvenColor = Color.Red;
            var expectedOddColor = Color.Blue;
            const double expectedOffset = 1.5;
            const CesiumStripeOrientation expectedOrientation = CesiumStripeOrientation.Vertical;
            const double expectedRepeat = 3.5;

            using (Packet)
            using (var polyline = Packet.OpenPolylineProperty())
            using (var material = polyline.OpenMaterialProperty())
            using (var stripeMaterial = material.OpenStripeProperty())
            {
                stripeMaterial.WriteEvenColorProperty(expectedEvenColor);
                stripeMaterial.WriteOddColorProperty(expectedOddColor);
                stripeMaterial.WriteOffsetProperty(expectedOffset);
                stripeMaterial.WriteOrientationProperty(expectedOrientation);
                stripeMaterial.WriteRepeatProperty(expectedRepeat);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.StripePropertyName, new Dictionary<string, object>
                            {
                                { StripeMaterialCesiumWriter.EvenColorPropertyName, expectedEvenColor },
                                { StripeMaterialCesiumWriter.OddColorPropertyName, expectedOddColor },
                                { StripeMaterialCesiumWriter.OffsetPropertyName, expectedOffset },
                                { StripeMaterialCesiumWriter.OrientationPropertyName, CesiumFormattingHelper.StripeOrientationToString(expectedOrientation) },
                                { StripeMaterialCesiumWriter.RepeatPropertyName, expectedRepeat },
                            }
                        },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<StripeMaterialCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new StripeMaterialCesiumWriter(propertyName);
        }
    }
}