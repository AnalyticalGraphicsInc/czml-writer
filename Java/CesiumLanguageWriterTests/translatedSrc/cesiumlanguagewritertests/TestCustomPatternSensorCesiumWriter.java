package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.Collection;
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
public class TestCustomPatternSensorCesiumWriter extends TestCesiumPropertyWriter<CustomPatternSensorCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testDirections() {
        final UnitSphericalList tempCollection$0 = new UnitSphericalList();
        tempCollection$0.add(new UnitSpherical(1.0, 0.5));
        tempCollection$0.add(new UnitSpherical(1.1, 0.6));
        UnitSphericalList expected = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    try (Using<DirectionListCesiumWriter> using$3 = new Using<DirectionListCesiumWriter>(interval.openDirectionsProperty())) {
                        final DirectionListCesiumWriter directions = using$3.resource;
                        directions.writeUnitSpherical(expected);
                    }
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.DirectionsPropertyName, expected);
    }

    @Test
    public final void testRadius() {
        final double expected = 1234.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.RadiusPropertyName, expected);
    }

    @Test
    public final void testShowIntersection() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowIntersectionProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowIntersectionPropertyName, expected);
    }

    @Test
    public final void testIntersectionColor() {
        Color expected = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeIntersectionColorProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.IntersectionColorPropertyName, expected);
    }

    @Test
    public final void testIntersectionWidth() {
        final double expected = 2.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeIntersectionWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.IntersectionWidthPropertyName, expected);
    }

    @Test
    public final void testShowLateralSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowLateralSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowLateralSurfacesPropertyName, expected);
    }

    @Test
    public final void testLateralSurfaceMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(CustomPatternSensorCesiumWriter.LateralSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEllipsoidSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEllipsoidSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowEllipsoidSurfacesPropertyName, expected);
    }

    @Test
    public final void testEllipsoidSurfaceMaterial() {
        Color expectedColor = ColorHelper.LIME;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(CustomPatternSensorCesiumWriter.EllipsoidSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEllipsoidHorizonSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEllipsoidHorizonSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowEllipsoidHorizonSurfacesPropertyName, expected);
    }

    @Test
    public final void testEllipsoidHorizonSurfaceMaterial() {
        Color expectedColor = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(CustomPatternSensorCesiumWriter.EllipsoidHorizonSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowDomeSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowDomeSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowDomeSurfacesPropertyName, expected);
    }

    @Test
    public final void testDomeSurfaceMaterial() {
        Color expectedColor = Color.YELLOW;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(CustomPatternSensorCesiumWriter.DomeSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEnvironmentIntersection() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEnvironmentIntersectionProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expected);
    }

    @Test
    public final void testEnvironmentIntersectionColor() {
        Color expected = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentIntersectionColorProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expected);
    }

    @Test
    public final void testEnvironmentIntersectionWidth() {
        final double expected = 3.4;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentIntersectionWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.EnvironmentIntersectionWidthPropertyName, expected);
    }

    @Test
    public final void testShowThroughEllipsoid() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowThroughEllipsoidProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expected);
    }

    @Test
    public final void testPortionToDisplay() {
        final CesiumSensorVolumePortionToDisplay expected = CesiumSensorVolumePortionToDisplay.ABOVE_ELLIPSOID_HORIZON;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writePortionToDisplayProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.PortionToDisplayPropertyName, expected);
    }

    @Test
    public final void testEnvironmentConstraint() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentConstraintProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.EnvironmentConstraintPropertyName, expected);
    }

    @Test
    public final void testShowEnvironmentOcclusion() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEnvironmentOcclusionProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowEnvironmentOcclusionPropertyName, expected);
    }

    @Test
    public final void testEnvironmentOcclusionMaterial() {
        Color expectedColor = Color.MAGENTA;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(CustomPatternSensorCesiumWriter.EnvironmentOcclusionMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowViewshed() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowViewshedProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ShowViewshedPropertyName, expected);
    }

    @Test
    public final void testViewshedVisibleColor() {
        Color expected = ColorHelper.GREEN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedVisibleColorProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ViewshedVisibleColorPropertyName, expected);
    }

    @Test
    public final void testViewshedOccludedColor() {
        Color expected = Color.YELLOW;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedOccludedColorProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ViewshedOccludedColorPropertyName, expected);
    }

    @Test
    public final void testViewshedResolution() {
        final int expected = 256;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPatternSensorCesiumWriter> using$1 = new Using<CustomPatternSensorCesiumWriter>(packet.openCustomPatternSensorProperty())) {
                final CustomPatternSensorCesiumWriter sensor = using$1.resource;
                try (Using<CustomPatternSensorCesiumWriter> using$2 = new Using<CustomPatternSensorCesiumWriter>(sensor.openInterval())) {
                    final CustomPatternSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedResolutionProperty(expected);
                }
            }
        }
        assertPropertyJson(CustomPatternSensorCesiumWriter.ViewshedResolutionPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.CustomPatternSensorPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<CustomPatternSensorCesiumWriter> createPropertyWriter(String propertyName) {
        return new CustomPatternSensorCesiumWriter(propertyName);
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