using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCustomPatternSensorCesiumWriter : TestCesiumPropertyWriter<CustomPatternSensorCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestDirections()
        {
            var expected = new UnitSphericalList
            {
                new UnitSpherical(1.0, 0.5),
                new UnitSpherical(1.1, 0.6),
            };

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var directions = interval.OpenDirectionsProperty())
            {
                directions.WriteUnitSpherical(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.DirectionsPropertyName, expected);
        }

        [Test]
        public void TestRadius()
        {
            const double expected = 1234.5;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteRadiusProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.RadiusPropertyName, expected);
        }

        [Test]
        public void TestShowIntersection()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowIntersectionProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowIntersectionPropertyName, expected);
        }

        [Test]
        public void TestIntersectionColor()
        {
            var expected = Color.Blue;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteIntersectionColorProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.IntersectionColorPropertyName, expected);
        }

        [Test]
        public void TestIntersectionWidth()
        {
            const double expected = 2.1;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteIntersectionWidthProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.IntersectionWidthPropertyName, expected);
        }

        [Test]
        public void TestShowLateralSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowLateralSurfacesProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowLateralSurfacesPropertyName, expected);
        }

        [Test]
        public void TestLateralSurfaceMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenLateralSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.LateralSurfaceMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEllipsoidSurfacesProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowEllipsoidSurfacesPropertyName, expected);
        }

        [Test]
        public void TestEllipsoidSurfaceMaterial()
        {
            var expectedColor = Color.Lime;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEllipsoidSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.EllipsoidSurfaceMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEllipsoidHorizonSurfacesProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowEllipsoidHorizonSurfacesPropertyName, expected);
        }

        [Test]
        public void TestEllipsoidHorizonSurfaceMaterial()
        {
            var expectedColor = Color.Blue;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEllipsoidHorizonSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.EllipsoidHorizonSurfaceMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowDomeSurfacesProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowDomeSurfacesPropertyName, expected);
        }

        [Test]
        public void TestDomeSurfaceMaterial()
        {
            var expectedColor = Color.Yellow;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenDomeSurfaceMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.DomeSurfaceMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEnvironmentIntersectionProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentIntersectionColor()
        {
            var expected = Color.Red;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentIntersectionColorProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentIntersectionWidth()
        {
            const double expected = 3.4;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentIntersectionWidthProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.EnvironmentIntersectionWidthPropertyName, expected);
        }

        [Test]
        public void TestShowThroughEllipsoid()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowThroughEllipsoidProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expected);
        }

        [Test]
        public void TestPortionToDisplay()
        {
            const CesiumSensorVolumePortionToDisplay expected = CesiumSensorVolumePortionToDisplay.AboveEllipsoidHorizon;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WritePortionToDisplayProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.PortionToDisplayPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentConstraint()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteEnvironmentConstraintProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.EnvironmentConstraintPropertyName, expected);
        }

        [Test]
        public void TestShowEnvironmentOcclusion()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowEnvironmentOcclusionProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowEnvironmentOcclusionPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentOcclusionMaterial()
        {
            var expectedColor = Color.Magenta;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            using (var material = interval.OpenEnvironmentOcclusionMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.EnvironmentOcclusionMaterialPropertyName, new Dictionary<string, object>
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
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteShowViewshedProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ShowViewshedPropertyName, expected);
        }

        [Test]
        public void TestViewshedVisibleColor()
        {
            var expected = Color.Green;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedVisibleColorProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ViewshedVisibleColorPropertyName, expected);
        }

        [Test]
        public void TestViewshedOccludedColor()
        {
            var expected = Color.Yellow;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedOccludedColorProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ViewshedOccludedColorPropertyName, expected);
        }

        [Test]
        public void TestViewshedResolution()
        {
            const int expected = 256;

            using (var packet = OpenPacket())
            using (var sensor = packet.OpenCustomPatternSensorProperty())
            using (var interval = sensor.OpenInterval())
            {
                interval.WriteViewshedResolutionProperty(expected);
            }

            AssertPropertyJson(CustomPatternSensorCesiumWriter.ViewshedResolutionPropertyName, expected);
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.CustomPatternSensorPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<CustomPatternSensorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new CustomPatternSensorCesiumWriter(propertyName);
        }
    }
}
