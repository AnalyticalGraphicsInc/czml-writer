using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestEyeOffsetCesiumWriter : TestCesiumInterpolatablePropertyWriter<EyeOffsetCesiumWriter>
    {
        [Test]
        public void WriteCartesian()
        {
            var expected = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            using (var eyeOffset = interval.OpenEyeOffsetProperty())
            {
                eyeOffset.WriteCartesian(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.EyeOffsetPropertyName, expected);
        }

        [Test]
        public void WriteReference()
        {
            const string expectedIdentifier = "someId";
            const string expectedPropertyName = "eyeOffset";

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            using (var eyeOffset = interval.OpenEyeOffsetProperty())
            {
                eyeOffset.WriteReference(expectedIdentifier, expectedPropertyName);
            }

            AssertPropertyJson(BillboardCesiumWriter.EyeOffsetPropertyName, new Dictionary<string, object>
            {
                { EyeOffsetCesiumWriter.ReferencePropertyName, expectedIdentifier + "#" + expectedPropertyName },
            });
        }

        [Test]
        public void TestDeleteProperty()
        {
            const bool expectedDelete = true;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            using (var eyeOffset = interval.OpenEyeOffsetProperty())
            {
                eyeOffset.WriteDelete(expectedDelete);
            }

            AssertPropertyJson(BillboardCesiumWriter.EyeOffsetPropertyName, new Dictionary<string, object>
            {
                { EyeOffsetCesiumWriter.DeletePropertyName, expectedDelete },
            });
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<EyeOffsetCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new EyeOffsetCesiumWriter(propertyName);
        }
    }
}
