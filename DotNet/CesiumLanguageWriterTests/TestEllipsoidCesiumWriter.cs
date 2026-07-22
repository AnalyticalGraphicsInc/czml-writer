using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestEllipsoidCesiumWriter : TestCesiumPropertyWriter<EllipsoidCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestRadii()
        {
            var expected = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            using (var radii = interval.OpenRadiiProperty())
            {
                radii.WriteCartesian(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.RadiiPropertyName, expected);
        }

        [Test]
        public void TestInnerRadii()
        {
            var expected = new Cartesian(0.5, 1.0, 1.5);

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            using (var radii = interval.OpenInnerRadiiProperty())
            {
                radii.WriteCartesian(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.InnerRadiiPropertyName, expected);
        }

        [Test]
        public void TestMinimumClock()
        {
            const double expected = 0.1;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteMinimumClockProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.MinimumClockPropertyName, expected);
        }

        [Test]
        public void TestMaximumClock()
        {
            const double expected = 1.0;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteMaximumClockProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.MaximumClockPropertyName, expected);
        }

        [Test]
        public void TestMinimumCone()
        {
            const double expected = 0.2;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteMinimumConeProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.MinimumConePropertyName, expected);
        }

        [Test]
        public void TestMaximumCone()
        {
            const double expected = 1.5;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteMaximumConeProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.MaximumConePropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.5;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestStackPartitions()
        {
            const int expected = 32;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteStackPartitionsProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.StackPartitionsPropertyName, expected);
        }

        [Test]
        public void TestSlicePartitions()
        {
            const int expected = 32;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteSlicePartitionsProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.SlicePartitionsPropertyName, expected);
        }

        [Test]
        public void TestSubdivisions()
        {
            const int expected = 64;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteSubdivisionsProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.SubdivisionsPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1.0, 123.0);

            using (var packet = OpenPacket())
            using (var ellipsoid = packet.OpenEllipsoidProperty())
            using (var interval = ellipsoid.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(EllipsoidCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.EllipsoidPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<EllipsoidCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new EllipsoidCesiumWriter(propertyName);
        }
    }
}
