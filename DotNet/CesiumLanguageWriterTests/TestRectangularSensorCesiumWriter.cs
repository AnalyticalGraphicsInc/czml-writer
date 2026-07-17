using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestRectangularSensorCesiumWriter : TestCesiumPropertyWriter<RectangularSensorCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestXHalfAngle()
        {
            const double expected = 1.1;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteXHalfAngleProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.XHalfAnglePropertyName, expected);
        }

        [Test]
        public void TestYHalfAngle()
        {
            const double expected = 1.2;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteYHalfAngleProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.YHalfAnglePropertyName, expected);
        }

        [Test]
        public void TestMinimumRadius()
        {
            const double expected = 123.0;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteMinimumRadiusProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.MinimumRadiusPropertyName, expected);
        }

        [Test]
        public void TestMaximumRadius()
        {
            const double expected = 234.0;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteMaximumRadiusProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.MaximumRadiusPropertyName, expected);
        }

        [Test]
        public void TestRadius()
        {
            const double expected = 1234.5;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteRadiusProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.RadiusPropertyName, expected);
        }

        [Test]
        public void TestShowIntersection()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowIntersectionProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowIntersectionPropertyName, expected);
        }

        [Test]
        public void TestIntersectionColor()
        {
            var expected = Color.Blue;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteIntersectionColorProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.IntersectionColorPropertyName, expected);
        }

        [Test]
        public void TestIntersectionWidth()
        {
            const double expected = 2.1;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteIntersectionWidthProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.IntersectionWidthPropertyName, expected);
        }

        [Test]
        public void TestShowLateralSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowLateralSurfacesProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowLateralSurfacesPropertyName, expected);
        }

        [Test]
        public void TestLateralSurfaceMaterial()
        {
            var expectedColor = Color.Blue;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenLateralSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.LateralSurfaceMaterialPropertyName, new Dictionary<string, object>
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
        public void TestShowEllipsoidSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEllipsoidSurfacesProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowEllipsoidSurfacesPropertyName, expected);
        }

        [Test]
        public void TestEllipsoidSurfaceMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEllipsoidSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.EllipsoidSurfaceMaterialPropertyName, new Dictionary<string, object>
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
        public void TestShowEllipsoidHorizonSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEllipsoidHorizonSurfacesProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowEllipsoidHorizonSurfacesPropertyName, expected);
        }

        [Test]
        public void TestEllipsoidHorizonSurfaceMaterial()
        {
            var expectedColor = Color.Green;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEllipsoidHorizonSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.EllipsoidHorizonSurfaceMaterialPropertyName, new Dictionary<string, object>
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
        public void TestShowDomeSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowDomeSurfacesProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowDomeSurfacesPropertyName, expected);
        }

        [Test]
        public void TestDomeSurfaceMaterial()
        {
            var expectedColor = Color.Yellow;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenDomeSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.DomeSurfaceMaterialPropertyName, new Dictionary<string, object>
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
        public void TestShowEnvironmentIntersection()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEnvironmentIntersectionProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentIntersectionColor()
        {
            var expected = Color.Red;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentIntersectionColorProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentIntersectionWidth()
        {
            const double expected = 3.4;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentIntersectionWidthProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.EnvironmentIntersectionWidthPropertyName, expected);
        }

        [Test]
        public void TestShowThroughEllipsoid()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowThroughEllipsoidProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expected);
        }

        [Test]
        public void TestPortionToDisplay()
        {
            const CesiumSensorVolumePortionToDisplay expected = CesiumSensorVolumePortionToDisplay.AboveEllipsoidHorizon;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WritePortionToDisplayProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.PortionToDisplayPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentConstraint()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentConstraintProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.EnvironmentConstraintPropertyName, expected);
        }

        [Test]
        public void TestShowEnvironmentOcclusion()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEnvironmentOcclusionProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowEnvironmentOcclusionPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentOcclusionMaterial()
        {
            var expectedColor = Color.Cyan;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEnvironmentOcclusionMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.EnvironmentOcclusionMaterialPropertyName, new Dictionary<string, object>
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
        public void TestShowViewshed()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowViewshedProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ShowViewshedPropertyName, expected);
        }

        [Test]
        public void TestViewshedVisibleColor()
        {
            var expected = Color.Green;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedVisibleColorProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ViewshedVisibleColorPropertyName, expected);
        }

        [Test]
        public void TestViewshedOccludedColor()
        {
            var expected = Color.Yellow;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedOccludedColorProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ViewshedOccludedColorPropertyName, expected);
        }

        [Test]
        public void TestViewshedResolution()
        {
            const int expected = 256;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenRectangularSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedResolutionProperty(expected);
            }

            AssertPropertyJson(RectangularSensorCesiumWriter.ViewshedResolutionPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.RectangularSensorPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<RectangularSensorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new RectangularSensorCesiumWriter(propertyName);
        }
    }
}