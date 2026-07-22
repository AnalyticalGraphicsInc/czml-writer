using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestVectorCesiumWriter : TestCesiumPropertyWriter<VectorCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(VectorCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            {
                interval.WriteColorProperty(expected);
            }

            AssertPropertyJson(VectorCesiumWriter.ColorPropertyName, expected);
        }

        [Test]
        public void TestDirection()
        {
            var expected = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            using (var direction = interval.OpenDirectionProperty())
            {
                direction.WriteCartesian(expected);
            }

            AssertPropertyJson(VectorCesiumWriter.DirectionPropertyName, expected);
        }

        [Test]
        public void TestDirectionUnitSpherical()
        {
            var expected = new UnitSpherical(1.0, 2.0);

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            using (var direction = interval.OpenDirectionProperty())
            {
                direction.WriteUnitSpherical(expected);
            }

            AssertPropertyJson(VectorCesiumWriter.DirectionPropertyName, expected);
        }

        [Test]
        public void TestLength()
        {
            const double expected = 123.0;

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            {
                interval.WriteLengthProperty(expected);
            }

            AssertPropertyJson(VectorCesiumWriter.LengthPropertyName, expected);
        }

        [Test]
        public void TestMinimumLengthInPixels()
        {
            const double expected = 10.0;

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            {
                interval.WriteMinimumLengthInPixelsProperty(expected);
            }

            AssertPropertyJson(VectorCesiumWriter.MinimumLengthInPixelsPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.VectorPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<VectorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new VectorCesiumWriter(propertyName);
        }
    }
}
