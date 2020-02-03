using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestRectangleCesiumWriter : TestCesiumPropertyWriter<RectangleCesiumWriter>
    {
        [Test]
        public void TestHeightReferenceProperties()
        {
            const double expectedExtrudedHeight = 10.0;
            const CesiumHeightReference expectedExtrudedHeightReference = CesiumHeightReference.RelativeToGround;

            using (Packet)
            using (var rectangle = Packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteExtrudedHeightProperty(expectedExtrudedHeight);
                interval.WriteExtrudedHeightReferenceProperty(expectedExtrudedHeightReference);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.ExtrudedHeightPropertyName, expectedExtrudedHeight },
                { RectangleCesiumWriter.ExtrudedHeightReferencePropertyName, CesiumFormattingHelper.HeightReferenceToString(expectedExtrudedHeightReference) },
            });
        }

        protected override CesiumPropertyWriter<RectangleCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new RectangleCesiumWriter(propertyName);
        }
    }
}