package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestConicSensorCesiumWriter extends TestCesiumPropertyWriter<ConicSensorCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testInnerHalfAngle() {
        final double expected = 1.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeInnerHalfAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.InnerHalfAnglePropertyName, expected);
    }

    @Test
    public final void testOuterHalfAngle() {
        final double expected = 1.2;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeOuterHalfAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.OuterHalfAnglePropertyName, expected);
    }

    @Test
    public final void testMinimumClockAngle() {
        final double expected = 1.3;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeMinimumClockAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.MinimumClockAnglePropertyName, expected);
    }

    @Test
    public final void testMaximumClockAngle() {
        final double expected = 1.4;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeMaximumClockAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.MaximumClockAnglePropertyName, expected);
    }

    @Test
    public final void testRadius() {
        final double expected = 150.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.RadiusPropertyName, expected);
    }

    @Test
    public final void testShowIntersection() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowIntersectionProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowIntersectionPropertyName, expected);
    }

    @Test
    public final void testIntersectionColor() {
        Color expected = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeIntersectionColorProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.IntersectionColorPropertyName, expected);
    }

    @Test
    public final void testIntersectionWidth() {
        final double expected = 2.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeIntersectionWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.IntersectionWidthPropertyName, expected);
    }

    @Test
    public final void testShowLateralSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowLateralSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowLateralSurfacesPropertyName, expected);
    }

    @Test
    public final void testLateralSurfaceMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    try (Using<MaterialCesiumWriter> using$3 = new Using<MaterialCesiumWriter>(interval.openLateralSurfaceMaterialProperty())) {
                        final MaterialCesiumWriter material = using$3.resource;
                        try (Using<SolidColorMaterialCesiumWriter> using$4 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                            final SolidColorMaterialCesiumWriter solidColor = using$4.resource;
                            solidColor.writeColorProperty(expectedColor);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineMaterialCesiumWriter.SolidColorPropertyName, tempCollection$1);
        assertPropertyJson(ConicSensorCesiumWriter.LateralSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEllipsoidSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEllipsoidSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowEllipsoidSurfacesPropertyName, expected);
    }

    @Test
    public final void testEllipsoidSurfaceMaterial() {
        Color expectedColor = ColorHelper.LIME;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    try (Using<MaterialCesiumWriter> using$3 = new Using<MaterialCesiumWriter>(interval.openEllipsoidSurfaceMaterialProperty())) {
                        final MaterialCesiumWriter material = using$3.resource;
                        try (Using<SolidColorMaterialCesiumWriter> using$4 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                            final SolidColorMaterialCesiumWriter solidColor = using$4.resource;
                            solidColor.writeColorProperty(expectedColor);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineMaterialCesiumWriter.SolidColorPropertyName, tempCollection$1);
        assertPropertyJson(ConicSensorCesiumWriter.EllipsoidSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEllipsoidHorizonSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEllipsoidHorizonSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowEllipsoidHorizonSurfacesPropertyName, expected);
    }

    @Test
    public final void testEllipsoidHorizonSurfaceMaterial() {
        Color expectedColor = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    try (Using<MaterialCesiumWriter> using$3 = new Using<MaterialCesiumWriter>(interval.openEllipsoidHorizonSurfaceMaterialProperty())) {
                        final MaterialCesiumWriter material = using$3.resource;
                        try (Using<SolidColorMaterialCesiumWriter> using$4 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                            final SolidColorMaterialCesiumWriter solidColor = using$4.resource;
                            solidColor.writeColorProperty(expectedColor);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineMaterialCesiumWriter.SolidColorPropertyName, tempCollection$1);
        assertPropertyJson(ConicSensorCesiumWriter.EllipsoidHorizonSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowDomeSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowDomeSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowDomeSurfacesPropertyName, expected);
    }

    @Test
    public final void testDomeSurfaceMaterial() {
        Color expectedColor = Color.YELLOW;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    try (Using<MaterialCesiumWriter> using$3 = new Using<MaterialCesiumWriter>(interval.openDomeSurfaceMaterialProperty())) {
                        final MaterialCesiumWriter material = using$3.resource;
                        try (Using<SolidColorMaterialCesiumWriter> using$4 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                            final SolidColorMaterialCesiumWriter solidColor = using$4.resource;
                            solidColor.writeColorProperty(expectedColor);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineMaterialCesiumWriter.SolidColorPropertyName, tempCollection$1);
        assertPropertyJson(ConicSensorCesiumWriter.DomeSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEnvironmentIntersection() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEnvironmentIntersectionProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expected);
    }

    @Test
    public final void testEnvironmentIntersectionColor() {
        Color expected = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentIntersectionColorProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expected);
    }

    @Test
    public final void testEnvironmentIntersectionWidth() {
        final double expected = 2.2;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentIntersectionWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.EnvironmentIntersectionWidthPropertyName, expected);
    }

    @Test
    public final void testShowThroughEllipsoid() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowThroughEllipsoidProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expected);
    }

    @Test
    public final void testPortionToDisplay() {
        final CesiumSensorVolumePortionToDisplay expected = CesiumSensorVolumePortionToDisplay.BELOW_ELLIPSOID_HORIZON;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writePortionToDisplayProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.PortionToDisplayPropertyName, expected);
    }

    @Test
    public final void testEnvironmentConstraint() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentConstraintProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.EnvironmentConstraintPropertyName, expected);
    }

    @Test
    public final void testShowEnvironmentOcclusion() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEnvironmentOcclusionProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowEnvironmentOcclusionPropertyName, expected);
    }

    @Test
    public final void testEnvironmentOcclusionMaterial() {
        Color expectedColor = Color.MAGENTA;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    try (Using<MaterialCesiumWriter> using$3 = new Using<MaterialCesiumWriter>(interval.openEnvironmentOcclusionMaterialProperty())) {
                        final MaterialCesiumWriter material = using$3.resource;
                        try (Using<SolidColorMaterialCesiumWriter> using$4 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                            final SolidColorMaterialCesiumWriter solidColor = using$4.resource;
                            solidColor.writeColorProperty(expectedColor);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineMaterialCesiumWriter.SolidColorPropertyName, tempCollection$1);
        assertPropertyJson(ConicSensorCesiumWriter.EnvironmentOcclusionMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowViewshed() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowViewshedProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ShowViewshedPropertyName, expected);
    }

    @Test
    public final void testViewshedVisibleColor() {
        Color expected = ColorHelper.GREEN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedVisibleColorProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ViewshedVisibleColorPropertyName, expected);
    }

    @Test
    public final void testViewshedOccludedColor() {
        Color expected = Color.GRAY;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedOccludedColorProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ViewshedOccludedColorPropertyName, expected);
    }

    @Test
    public final void testViewshedResolution() {
        final int expected = 32;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter sensor = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(sensor.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedResolutionProperty(expected);
                }
            }
        }
        assertPropertyJson(ConicSensorCesiumWriter.ViewshedResolutionPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.ConicSensorPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<ConicSensorCesiumWriter> createPropertyWriter(String propertyName) {
        return new ConicSensorCesiumWriter(propertyName);
    }

    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}