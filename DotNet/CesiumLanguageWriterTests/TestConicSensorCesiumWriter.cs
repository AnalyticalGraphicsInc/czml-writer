using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestConicSensorCesiumWriter : TestCesiumPropertyWriter<ConicSensorCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestInnerHalfAngle()
        {
            const double expected = 1.1;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteInnerHalfAngleProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.InnerHalfAnglePropertyName, expected);
        }

        [Test]
        public void TestOuterHalfAngle()
        {
            const double expected = 1.2;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteOuterHalfAngleProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.OuterHalfAnglePropertyName, expected);
        }

        [Test]
        public void TestMinimumClockAngle()
        {
            const double expected = 1.3;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteMinimumClockAngleProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.MinimumClockAnglePropertyName, expected);
        }

        [Test]
        public void TestMaximumClockAngle()
        {
            const double expected = 1.4;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteMaximumClockAngleProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.MaximumClockAnglePropertyName, expected);
        }

        [Test]
        public void TestMinimumRadius()
        {
            const double expected = 123.0;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteMinimumRadiusProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.MinimumRadiusPropertyName, expected);
        }

        [Test]
        public void TestMaximumRadius()
        {
            const double expected = 234.0;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteMaximumRadiusProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.MaximumRadiusPropertyName, expected);
        }

        [Test]
        public void TestRadius()
        {
            const double expected = 150.0;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteRadiusProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.RadiusPropertyName, expected);
        }

        [Test]
        public void TestShowIntersection()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowIntersectionProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowIntersectionPropertyName, expected);
        }

        [Test]
        public void TestIntersectionColor()
        {
            var expected = Color.Blue;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteIntersectionColorProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.IntersectionColorPropertyName, expected);
        }

        [Test]
        public void TestIntersectionWidth()
        {
            const double expected = 2.1;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteIntersectionWidthProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.IntersectionWidthPropertyName, expected);
        }

        [Test]
        public void TestShowLateralSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowLateralSurfacesProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowLateralSurfacesPropertyName, expected);
        }

        [Test]
        public void TestLateralSurfaceMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenLateralSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.LateralSurfaceMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEllipsoidSurfacesProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowEllipsoidSurfacesPropertyName, expected);
        }

        [Test]
        public void TestEllipsoidSurfaceMaterial()
        {
            var expectedColor = Color.Lime;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEllipsoidSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.EllipsoidSurfaceMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEllipsoidHorizonSurfacesProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowEllipsoidHorizonSurfacesPropertyName, expected);
        }

        [Test]
        public void TestEllipsoidHorizonSurfaceMaterial()
        {
            var expectedColor = Color.Blue;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEllipsoidHorizonSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.EllipsoidHorizonSurfaceMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowDomeSurfacesProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowDomeSurfacesPropertyName, expected);
        }

        [Test]
        public void TestDomeSurfaceMaterial()
        {
            var expectedColor = Color.Yellow;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenDomeSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.DomeSurfaceMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEnvironmentIntersectionProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentIntersectionColor()
        {
            var expected = Color.Red;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentIntersectionColorProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentIntersectionWidth()
        {
            const double expected = 2.2;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentIntersectionWidthProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.EnvironmentIntersectionWidthPropertyName, expected);
        }

        [Test]
        public void TestShowThroughEllipsoid()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowThroughEllipsoidProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expected);
        }

        [Test]
        public void TestPortionToDisplay()
        {
            const CesiumSensorVolumePortionToDisplay expected = CesiumSensorVolumePortionToDisplay.BelowEllipsoidHorizon;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WritePortionToDisplayProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.PortionToDisplayPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentConstraint()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentConstraintProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.EnvironmentConstraintPropertyName, expected);
        }

        [Test]
        public void TestShowEnvironmentOcclusion()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEnvironmentOcclusionProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowEnvironmentOcclusionPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentOcclusionMaterial()
        {
            var expectedColor = Color.Magenta;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEnvironmentOcclusionMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.EnvironmentOcclusionMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowViewshedProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ShowViewshedPropertyName, expected);
        }

        [Test]
        public void TestViewshedVisibleColor()
        {
            var expected = Color.Green;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedVisibleColorProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ViewshedVisibleColorPropertyName, expected);
        }

        [Test]
        public void TestViewshedOccludedColor()
        {
            var expected = Color.Gray;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedOccludedColorProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ViewshedOccludedColorPropertyName, expected);
        }

        [Test]
        public void TestViewshedResolution()
        {
            const int expected = 32;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenConicSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedResolutionProperty(expected);
            }

            AssertPropertyJson(ConicSensorCesiumWriter.ViewshedResolutionPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.ConicSensorPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<ConicSensorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ConicSensorCesiumWriter(propertyName);
        }
    }
}