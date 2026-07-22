using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestRectangleCesiumWriter : TestCesiumPropertyWriter<RectangleCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestCoordinates()
        {
            var expected = new CartographicExtent(-1.0, -2.0, 3.0, 4.0);

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteCoordinatesProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.CoordinatesPropertyName, expected);
        }

        [Test]
        public void TestExtrudedHeight()
        {
            const double expected = 10.0;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteExtrudedHeightProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.ExtrudedHeightPropertyName, expected);
        }

        [Test]
        public void TestExtrudedHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.RelativeToGround;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteExtrudedHeightReferenceProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.ExtrudedHeightReferencePropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestOutline()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.5;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestHeight()
        {
            const double expected = 100.0;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteHeightProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.HeightPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestRotation()
        {
            const double expected = 1.234;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteRotationProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.RotationPropertyName, expected);
        }

        [Test]
        public void TestStRotation()
        {
            const double expected = 0.5;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteStRotationProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.StRotationPropertyName, expected);
        }

        [Test]
        public void TestGranularity()
        {
            const double expected = 0.1;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteGranularityProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.GranularityPropertyName, expected);
        }

        [Test]
        public void TestMaterialProperty()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(RectangleCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1.0, 123.0);

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestClassificationType()
        {
            const CesiumClassificationType expected = CesiumClassificationType.Terrain;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteClassificationTypeProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.ClassificationTypePropertyName, expected);
        }

        [Test]
        public void TestZIndex()
        {
            const int expected = 5;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteZIndexProperty(expected);
            }

            AssertPropertyJson(RectangleCesiumWriter.ZIndexPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<RectangleCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new RectangleCesiumWriter(propertyName);
        }
    }
}
