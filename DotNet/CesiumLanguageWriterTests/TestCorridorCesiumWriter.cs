using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCorridorCesiumWriter : TestCesiumPropertyWriter<CorridorCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.ShowPropertyName, expected);
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
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WritePositionsProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.PositionsPropertyName, expected);
        }

        [Test]
        public void TestWidth()
        {
            const double expected = 10.0;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteWidthProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.WidthPropertyName, expected);
        }

        [Test]
        public void TestHeight()
        {
            const double expected = 100.0;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteHeightProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.HeightPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestExtrudedHeight()
        {
            const double expected = 200.0;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteExtrudedHeightProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.ExtrudedHeightPropertyName, expected);
        }

        [Test]
        public void TestExtrudedHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.RelativeToGround;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteExtrudedHeightReferenceProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.ExtrudedHeightReferencePropertyName, expected);
        }

        [Test]
        public void TestCornerType()
        {
            const CesiumCornerType expected = CesiumCornerType.Beveled;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteCornerTypeProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.CornerTypePropertyName, expected);
        }

        [Test]
        public void TestGranularity()
        {
            const double expected = 0.1;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteGranularityProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.GranularityPropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(CorridorCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.5;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1.0, 123.0);

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestClassificationType()
        {
            const CesiumClassificationType expected = CesiumClassificationType.Terrain;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteClassificationTypeProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.ClassificationTypePropertyName, expected);
        }

        [Test]
        public void TestZIndex()
        {
            const int expected = 5;

            using (var packet = OpenPacket())
            using (var corridor = packet.OpenCorridorProperty())
            using (var interval = corridor.OpenInterval())
            {
                interval.WriteZIndexProperty(expected);
            }

            AssertPropertyJson(CorridorCesiumWriter.ZIndexPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.CorridorPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<CorridorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new CorridorCesiumWriter(propertyName);
        }
    }
}
