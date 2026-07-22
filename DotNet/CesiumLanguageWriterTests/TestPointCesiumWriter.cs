using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPointCesiumWriter : TestCesiumPropertyWriter<PointCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestPixelSize()
        {
            const double expected = 10.0;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WritePixelSizeProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.PixelSizePropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteColorProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.ColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(255, 1, 2, 3);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.0;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestScaleByDistance()
        {
            var expected = new NearFarScalar(1.0, 2.0, 3.0, 4.0);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteScaleByDistanceProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.ScaleByDistancePropertyName, expected);
        }

        [Test]
        public void TestTranslucencyByDistance()
        {
            var expected = new NearFarScalar(1.0, 0.5, 2.0, 0.1);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteTranslucencyByDistanceProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.TranslucencyByDistancePropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1.0, 1324.0);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestDisableDepthTestDistance()
        {
            const double expected = 500.0;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteDisableDepthTestDistanceProperty(expected);
            }

            AssertPropertyJson(PointCesiumWriter.DisableDepthTestDistancePropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<PointCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PointCesiumWriter(propertyName);
        }
    }
}
