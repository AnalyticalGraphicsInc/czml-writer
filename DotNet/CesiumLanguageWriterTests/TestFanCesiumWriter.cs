using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestFanCesiumWriter : TestCesiumPropertyWriter<FanCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestDirections()
        {
            var expected = new SphericalList
            {
                new Spherical(1.0, 2.0, 10.0),
                new Spherical(3.0, 4.0, 20.0),
            };

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WriteDirectionsProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.DirectionsPropertyName, expected);
        }

        [Test]
        public void TestRadius()
        {
            const double expected = 123.0;

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WriteRadiusProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.RadiusPropertyName, expected);
        }

        [Test]
        public void TestPerDirectionRadius()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WritePerDirectionRadiusProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.PerDirectionRadiusPropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(FanCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
            {
                {
                    PolylineMaterialCesiumWriter.SolidColorPropertyName, new Dictionary<string, object>
                    {
                        { SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor },
                    }
                },
            });
        }

        [Test]
        public void TestOutline()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.5;

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestNumberOfRings()
        {
            const int expected = 3;

            using (var packet = OpenPacket())
            using (var fan = packet.OpenFanProperty())
            using (var interval = fan.OpenInterval())
            {
                interval.WriteNumberOfRingsProperty(expected);
            }

            AssertPropertyJson(FanCesiumWriter.NumberOfRingsPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.FanPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<FanCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new FanCesiumWriter(propertyName);
        }
    }
}
