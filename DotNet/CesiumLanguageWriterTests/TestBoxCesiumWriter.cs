using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBoxCesiumWriter : TestCesiumPropertyWriter<BoxCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestDimensions()
        {
            var expected = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            using (var dimensions = interval.OpenDimensionsProperty())
            {
                dimensions.WriteCartesian(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.DimensionsPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(BoxCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.5;

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1.0, 123.0);

            using (var packet = OpenPacket())
            using (var box = packet.OpenBoxProperty())
            using (var interval = box.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(BoxCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.BoxPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<BoxCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BoxCesiumWriter(propertyName);
        }
    }
}
