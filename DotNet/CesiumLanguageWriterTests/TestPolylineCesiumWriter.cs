using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPolylineCesiumWriter : TestCesiumPropertyWriter<PolylineCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.ShowPropertyName, expected);
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
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WritePositionsProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.PositionsPropertyName, expected);
        }

        [Test]
        public void TestArcType()
        {
            const CesiumArcType expected = CesiumArcType.Rhumb;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteArcTypeProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.ArcTypePropertyName, expected);
        }

        [Test]
        public void TestWidth()
        {
            const double expected = 5.0;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteWidthProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.WidthPropertyName, expected);
        }

        [Test]
        public void TestGranularity()
        {
            const double expected = 0.1;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteGranularityProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.GranularityPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(PolylineCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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
        public void TestFollowSurface()
        {
            const bool expected = false;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteFollowSurfaceProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.FollowSurfacePropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDepthFailMaterial()
        {
            var expectedColor = Color.Blue;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            using (var material = interval.OpenDepthFailMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(PolylineCesiumWriter.DepthFailMaterialPropertyName, new Dictionary<string, object>
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
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(10.0, 1234.0);

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestClampToGround()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteClampToGroundProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.ClampToGroundPropertyName, expected);
        }

        [Test]
        public void TestClassificationType()
        {
            const CesiumClassificationType expected = CesiumClassificationType.Terrain;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteClassificationTypeProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.ClassificationTypePropertyName, expected);
        }

        [Test]
        public void TestZIndex()
        {
            const int expected = 5;

            using (var packet = OpenPacket())
            using (var polyline = packet.OpenPolylineProperty())
            using (var interval = polyline.OpenInterval())
            {
                interval.WriteZIndexProperty(expected);
            }

            AssertPropertyJson(PolylineCesiumWriter.ZIndexPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.PolylinePropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<PolylineCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineCesiumWriter(propertyName);
        }
    }
}
