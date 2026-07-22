using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestWallCesiumWriter : TestCesiumPropertyWriter<WallCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = false;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestPositions()
        {
            var expected = new PositionList
            {
                new Cartesian(1.0, 2.0, 3.0),
                new Cartesian(4.0, 5.0, 6.0),
            };

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WritePositionsProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.PositionsPropertyName, expected);
        }

        [Test]
        public void TestGranularity()
        {
            const double expected = 0.1;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteGranularityProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.GranularityPropertyName, expected);
        }

        [Test]
        public void TestMinimumHeights()
        {
            var expected = new DoubleList { 1.0, 2.0, 3.0 };

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteMinimumHeightsProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.MinimumHeightsPropertyName, expected);
        }

        [Test]
        public void TestMaximumHeights()
        {
            var expected = new DoubleList { 4.0, 5.0, 6.0 };

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteMaximumHeightsProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.MaximumHeightsPropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = false;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestOutline()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(255, 255, 0, 0);

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.0;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1234.0, 5678.0);

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(WallCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(WallCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
            {
                {
                    PolylineMaterialCesiumWriter.SolidColorPropertyName, new Dictionary<string, object>
                    {
                        { SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor },
                    }
                },
            });
        }

        private void AssertPropertyJson(string propertyName, object value)
        {
            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<WallCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new WallCesiumWriter(propertyName);
        }
    }
}
