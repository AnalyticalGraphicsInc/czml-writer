using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPointCesiumWriter : TestCesiumPropertyWriter<PointCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.ShowPropertyName, expectedShow },
            });
        }

        [Test]
        public void TestPixelSizeProperty()
        {
            const double expectedPixelSize = 10.0;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WritePixelSizeProperty(expectedPixelSize);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.PixelSizePropertyName, expectedPixelSize },
            });
        }

        [Test]
        public void TestHeightReferenceProperty()
        {
            const CesiumHeightReference expectedHeightReference = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expectedHeightReference);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.HeightReferencePropertyName, expectedHeightReference },
            });
        }

        [Test]
        public void TestColorProperty()
        {
            var expectedColor = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteColorProperty(expectedColor);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.ColorPropertyName, expectedColor },
            });
        }

        [Test]
        public void TestOutlineColorProperty()
        {
            var expectedOutlineColor = Color.FromArgb(255, 1, 2, 3);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expectedOutlineColor);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.OutlineColorPropertyName, expectedOutlineColor },
            });
        }

        [Test]
        public void TestOutlineWidthProperty()
        {
            const double expectedOutlineWidth = 2.0;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expectedOutlineWidth);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.OutlineWidthPropertyName, expectedOutlineWidth },
            });
        }

        [Test]
        public void TestScaleByDistanceProperty()
        {
            var expectedScale = new NearFarScalar(1.0, 2.0, 3.0, 4.0);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteScaleByDistanceProperty(expectedScale);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.ScaleByDistancePropertyName, expectedScale },
            });
        }

        [Test]
        public void TestTranslucencyByDistanceProperty()
        {
            var expectedTranslucency = new NearFarScalar(1.0, 0.5, 2.0, 0.1);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteTranslucencyByDistanceProperty(expectedTranslucency);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucency },
            });
        }

        [Test]
        public void TestDistanceDisplayConditionProperty()
        {
            var expectedBounds = new Bounds(1.0, 1324.0);

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expectedBounds);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds },
            });
        }

        [Test]
        public void TestDisableDepthTestDistanceProperty()
        {
            const double expectedDisableDepthTestDistance = 500.0;

            using (var packet = OpenPacket())
            using (var point = packet.OpenPointProperty())
            using (var interval = point.OpenInterval())
            {
                interval.WriteDisableDepthTestDistanceProperty(expectedDisableDepthTestDistance);
            }

            AssertExpectedJson(PacketCesiumWriter.PointPropertyName, new Dictionary<string, object>
            {
                { PointCesiumWriter.DisableDepthTestDistancePropertyName, expectedDisableDepthTestDistance },
            });
        }

        protected override CesiumPropertyWriter<PointCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PointCesiumWriter(propertyName);
        }
    }
}
