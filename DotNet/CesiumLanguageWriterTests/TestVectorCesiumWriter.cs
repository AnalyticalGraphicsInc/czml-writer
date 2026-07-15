using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestVectorCesiumWriter : TestCesiumPropertyWriter<VectorCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expectedShow = true;

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.VectorPropertyName, new Dictionary<string, object>
            {
                { VectorCesiumWriter.ShowPropertyName, expectedShow },
            });
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

            AssertExpectedJson(PacketCesiumWriter.VectorPropertyName, new Dictionary<string, object>
            {
                { VectorCesiumWriter.ColorPropertyName, expected },
            });
        }

        [Test]
        public void TestDirection()
        {
            var expectedDirection = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            using (var direction = interval.OpenDirectionProperty())
            {
                direction.WriteCartesian(expectedDirection);
            }

            AssertExpectedJson(PacketCesiumWriter.VectorPropertyName, new Dictionary<string, object>
            {
                { VectorCesiumWriter.DirectionPropertyName, expectedDirection },
            });
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

            AssertExpectedJson(PacketCesiumWriter.VectorPropertyName, new Dictionary<string, object>
            {
                { VectorCesiumWriter.DirectionPropertyName, expected },
            });
        }

        [Test]
        public void TestLength()
        {
            const double expectedLength = 123.0;

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            {
                interval.WriteLengthProperty(expectedLength);
            }

            AssertExpectedJson(PacketCesiumWriter.VectorPropertyName, new Dictionary<string, object>
            {
                { VectorCesiumWriter.LengthPropertyName, expectedLength },
            });
        }

        [Test]
        public void TestMinimumLengthInPixels()
        {
            const double expectedMinimumLengthInPixels = 10.0;

            using (var packet = OpenPacket())
            using (var vector = packet.OpenVectorProperty())
            using (var interval = vector.OpenInterval())
            {
                interval.WriteMinimumLengthInPixelsProperty(expectedMinimumLengthInPixels);
            }

            AssertExpectedJson(PacketCesiumWriter.VectorPropertyName, new Dictionary<string, object>
            {
                { VectorCesiumWriter.MinimumLengthInPixelsPropertyName, expectedMinimumLengthInPixels },
            });
        }

        protected override CesiumPropertyWriter<VectorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new VectorCesiumWriter(propertyName);
        }
    }
}
