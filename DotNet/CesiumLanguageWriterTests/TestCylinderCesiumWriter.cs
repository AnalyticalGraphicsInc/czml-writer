using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCylinderCesiumWriter : TestCesiumPropertyWriter<CylinderCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestLength()
        {
            const double expected = 123.0;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteLengthProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.LengthPropertyName, expected);
        }

        [Test]
        public void TestTopRadius()
        {
            const double expected = 10.0;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteTopRadiusProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.TopRadiusPropertyName, expected);
        }

        [Test]
        public void TestBottomRadius()
        {
            const double expected = 5.0;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteBottomRadiusProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.BottomRadiusPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(CylinderCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.5;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestNumberOfVerticalLines()
        {
            const int expected = 32;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteNumberOfVerticalLinesProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.NumberOfVerticalLinesPropertyName, expected);
        }

        [Test]
        public void TestSlices()
        {
            const int expected = 256;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteSlicesProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.SlicesPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1.0, 123.0);

            using (var packet = OpenPacket())
            using (var cylinder = packet.OpenCylinderProperty())
            using (var interval = cylinder.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(CylinderCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.CylinderPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<CylinderCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new CylinderCesiumWriter(propertyName);
        }
    }
}
