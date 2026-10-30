using System;
using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestGroundElevationVolumeCesiumWriter : TestCesiumPropertyWriter<GroundElevationVolumeCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestMinimumGroundElevationAngle()
        {
            const double expected = 1.1;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteMinimumGroundElevationAngleProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.MinimumGroundElevationAnglePropertyName, expected);
        }

        [Test]
        public void TestMaximumGroundElevationAngle()
        {
            const double expected = 1.2;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteMaximumGroundElevationAngleProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.MaximumGroundElevationAnglePropertyName, expected);
        }

        [Test]
        public void TestMinimumClockAngle()
        {
            const double expected = 1.3;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteMinimumClockAngleProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.MinimumClockAnglePropertyName, expected);
        }

        [Test]
        public void TestMaximumClockAngle()
        {
            const double expected = 1.4;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteMaximumClockAngleProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.MaximumClockAnglePropertyName, expected);
        }

        [Test]
        public void TestMinimumRadius()
        {
            const double expected = 123.0;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteMinimumRadiusProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.MinimumRadiusPropertyName, expected);
        }

        [Test]
        public void TestMaximumRadius()
        {
            const double expected = 234.0;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteMaximumRadiusProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.MaximumRadiusPropertyName, expected);
        }

        [Test]
        public void TestShowIntersection()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowIntersectionProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowIntersectionPropertyName, expected);
        }

        [Test]
        public void TestIntersectionColor()
        {
            var expected = Color.Blue;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteIntersectionColorProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.IntersectionColorPropertyName, expected);
        }

        [Test]
        public void TestIntersectionWidth()
        {
            const double expected = 2.1;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteIntersectionWidthProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.IntersectionWidthPropertyName, expected);
        }

        [Test]
        public void TestShowLateralSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowLateralSurfacesProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowLateralSurfacesPropertyName, expected);
        }

        [Test]
        public void TestLateralSurfaceMaterial()
        {
            AssertMaterialProperty(GroundElevationVolumeCesiumWriter.LateralSurfaceMaterialPropertyName, Color.Red);
        }

        [Test]
        public void TestShowEllipsoidSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowEllipsoidSurfacesProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowEllipsoidSurfacesPropertyName, expected);
        }

        [Test]
        public void TestEllipsoidSurfaceMaterial()
        {
            AssertMaterialProperty(GroundElevationVolumeCesiumWriter.EllipsoidSurfaceMaterialPropertyName, Color.Lime);
        }

        [Test]
        public void TestShowDomeSurfaces()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowDomeSurfacesProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowDomeSurfacesPropertyName, expected);
        }

        [Test]
        public void TestDomeSurfaceMaterial()
        {
            AssertMaterialProperty(GroundElevationVolumeCesiumWriter.DomeSurfaceMaterialPropertyName, Color.Yellow);
        }

        [Test]
        public void TestEnvironmentConstraint()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteEnvironmentConstraintProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.EnvironmentConstraintPropertyName, expected);
        }

        [Test]
        public void TestShowEnvironmentOcclusion()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowEnvironmentOcclusionProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowEnvironmentOcclusionPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentOcclusionMaterial()
        {
            AssertMaterialProperty(GroundElevationVolumeCesiumWriter.EnvironmentOcclusionMaterialPropertyName, Color.Magenta);
        }

        [Test]
        public void TestShowEnvironmentIntersection()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowEnvironmentIntersectionProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowEnvironmentIntersectionPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentIntersectionColor()
        {
            var expected = Color.Blue;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteEnvironmentIntersectionColorProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.EnvironmentIntersectionColorPropertyName, expected);
        }

        [Test]
        public void TestEnvironmentIntersectionWidth()
        {
            const double expected = 2.2;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteEnvironmentIntersectionWidthProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.EnvironmentIntersectionWidthPropertyName, expected);
        }

        [Test]
        public void TestShowThroughEllipsoid()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowThroughEllipsoidProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowThroughEllipsoidPropertyName, expected);
        }

        [Test]
        public void TestShowViewshed()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteShowViewshedProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ShowViewshedPropertyName, expected);
        }

        [Test]
        public void TestViewshedVisibleColor()
        {
            var expected = Color.Green;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteViewshedVisibleColorProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ViewshedVisibleColorPropertyName, expected);
        }

        [Test]
        public void TestViewshedOccludedColor()
        {
            var expected = Color.Gray;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteViewshedOccludedColorProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ViewshedOccludedColorPropertyName, expected);
        }

        [Test]
        public void TestViewshedResolution()
        {
            const int expected = 256;

            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            {
                interval.WriteViewshedResolutionProperty(expected);
            }

            AssertPropertyJson(GroundElevationVolumeCesiumWriter.ViewshedResolutionPropertyName, expected);
        }

        private void AssertMaterialProperty([NotNull] string propertyName, Color expectedColor)
        {
            using (var packet = OpenPacket())
            using (var volume = packet.OpenGroundElevationVolumeProperty())
            using (var interval = volume.OpenInterval())
            using (var material = OpenMaterialProperty(interval, propertyName))
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(propertyName, new Dictionary<string, object>
            {
                {
                    MaterialCesiumWriter.SolidColorPropertyName, new Dictionary<string, object>
                    {
                        { SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor },
                    }
                },
            });
        }

        private static MaterialCesiumWriter OpenMaterialProperty(GroundElevationVolumeCesiumWriter volume, [NotNull] string propertyName)
        {
            switch (propertyName)
            {
                case GroundElevationVolumeCesiumWriter.LateralSurfaceMaterialPropertyName:
                    return volume.OpenLateralSurfaceMaterialProperty();
                case GroundElevationVolumeCesiumWriter.EllipsoidSurfaceMaterialPropertyName:
                    return volume.OpenEllipsoidSurfaceMaterialProperty();
                case GroundElevationVolumeCesiumWriter.DomeSurfaceMaterialPropertyName:
                    return volume.OpenDomeSurfaceMaterialProperty();
                case GroundElevationVolumeCesiumWriter.EnvironmentOcclusionMaterialPropertyName:
                    return volume.OpenEnvironmentOcclusionMaterialProperty();
                default:
                    throw new ArgumentException();
            }
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.GroundElevationVolumePropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<GroundElevationVolumeCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new GroundElevationVolumeCesiumWriter(propertyName);
        }
    }
}
