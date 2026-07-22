using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestEllipseCesiumWriter : TestCesiumPropertyWriter<EllipseCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestSemiMajorAxis()
        {
            const double expected = 124.0;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteSemiMajorAxisProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.SemiMajorAxisPropertyName, expected);
        }

        [Test]
        public void TestSemiMinorAxis()
        {
            const double expected = 500.0;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteSemiMinorAxisProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.SemiMinorAxisPropertyName, expected);
        }

        [Test]
        public void TestHeight()
        {
            const double expected = 10.0;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteHeightProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.HeightPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestExtrudedHeight()
        {
            const double expected = 20.0;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteExtrudedHeightProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.ExtrudedHeightPropertyName, expected);
        }

        [Test]
        public void TestExtrudedHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteExtrudedHeightReferenceProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.ExtrudedHeightReferencePropertyName, expected);
        }

        [Test]
        public void TestRotation()
        {
            const double expected = 1.0;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteRotationProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.RotationPropertyName, expected);
        }

        [Test]
        public void TestStRotation()
        {
            const double expected = 0.5;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteStRotationProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.StRotationPropertyName, expected);
        }

        [Test]
        public void TestGranularity()
        {
            const double expected = 0.1;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteGranularityProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.GranularityPropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(EllipseCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.5;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestNumberOfVerticalLines()
        {
            const int expected = 32;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteNumberOfVerticalLinesProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.NumberOfVerticalLinesPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1.0, 123.0);

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestClassificationType()
        {
            const CesiumClassificationType expected = CesiumClassificationType.Both;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteClassificationTypeProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.ClassificationTypePropertyName, expected);
        }

        [Test]
        public void TestZIndex()
        {
            const int expected = 5;

            using (var packet = OpenPacket())
            using (var ellipse = packet.OpenEllipseProperty())
            using (var interval = ellipse.OpenInterval())
            {
                interval.WriteZIndexProperty(expected);
            }

            AssertPropertyJson(EllipseCesiumWriter.ZIndexPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.EllipsePropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<EllipseCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new EllipseCesiumWriter(propertyName);
        }
    }
}
