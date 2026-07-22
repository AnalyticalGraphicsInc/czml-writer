using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPixelOffsetCesiumWriter : TestCesiumInterpolatablePropertyWriter<PixelOffsetCesiumWriter>
    {
        [Test]
        public void WriteCartesian2()
        {
            var expected = new Rectangular(10.0, 20.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            using (var pixelOffset = interval.OpenPixelOffsetProperty())
            {
                pixelOffset.WriteCartesian2(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.PixelOffsetPropertyName, expected);
        }

        [Test]
        public void WriteReference()
        {
            const string expectedIdentifier = "someId";
            const string expectedPropertyName = "pixelOffset";

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            using (var pixelOffset = interval.OpenPixelOffsetProperty())
            {
                pixelOffset.WriteReference(expectedIdentifier, expectedPropertyName);
            }

            AssertPropertyJson(BillboardCesiumWriter.PixelOffsetPropertyName, new Dictionary<string, object>
            {
                { PixelOffsetCesiumWriter.ReferencePropertyName, expectedIdentifier + "#" + expectedPropertyName },
            });
        }

        [Test]
        public void TestDeleteProperty()
        {
            const bool expectedDelete = true;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            using (var pixelOffset = interval.OpenPixelOffsetProperty())
            {
                pixelOffset.WriteDelete(expectedDelete);
            }

            AssertPropertyJson(BillboardCesiumWriter.PixelOffsetPropertyName, new Dictionary<string, object>
            {
                { PixelOffsetCesiumWriter.DeletePropertyName, expectedDelete },
            });
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<PixelOffsetCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PixelOffsetCesiumWriter(propertyName);
        }
    }
}
