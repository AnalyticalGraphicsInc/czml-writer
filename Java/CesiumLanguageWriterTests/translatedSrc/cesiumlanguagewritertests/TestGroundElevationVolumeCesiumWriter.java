package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
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
public class TestGroundElevationVolumeCesiumWriter extends TestCesiumPropertyWriter<GroundElevationVolumeCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testMinimumGroundElevationAngle() {
        final double expected = 1.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeMinimumGroundElevationAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.MinimumGroundElevationAnglePropertyName, expected);
    }

    @Test
    public final void testMaximumGroundElevationAngle() {
        final double expected = 1.2;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeMaximumGroundElevationAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.MaximumGroundElevationAnglePropertyName, expected);
    }

    @Test
    public final void testMinimumClockAngle() {
        final double expected = 1.3;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeMinimumClockAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.MinimumClockAnglePropertyName, expected);
    }

    @Test
    public final void testMaximumClockAngle() {
        final double expected = 1.4;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeMaximumClockAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.MaximumClockAnglePropertyName, expected);
    }

    @Test
    public final void testMinimumRadius() {
        final double expected = 123.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeMinimumRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.MinimumRadiusPropertyName, expected);
    }

    @Test
    public final void testMaximumRadius() {
        final double expected = 234.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeMaximumRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.MaximumRadiusPropertyName, expected);
    }

    @Test
    public final void testShowIntersection() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowIntersectionProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowIntersectionPropertyName, expected);
    }

    @Test
    public final void testIntersectionColor() {
        Color expected = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeIntersectionColorProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.IntersectionColorPropertyName, expected);
    }

    @Test
    public final void testIntersectionWidth() {
        final double expected = 2.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeIntersectionWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.IntersectionWidthPropertyName, expected);
    }

    @Test
    public final void testShowLateralSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowLateralSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowLateralSurfacesPropertyName, expected);
    }

    @Test
    public final void testLateralSurfaceMaterial() {
        assertMaterialProperty(GroundElevationVolumeCesiumWriter.LateralSurfaceMaterialPropertyName, Color.RED);
    }

    @Test
    public final void testShowEllipsoidSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowEllipsoidSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowEllipsoidSurfacesPropertyName, expected);
    }

    @Test
    public final void testEllipsoidSurfaceMaterial() {
        assertMaterialProperty(GroundElevationVolumeCesiumWriter.EllipsoidSurfaceMaterialPropertyName, ColorHelper.LIME);
    }

    @Test
    public final void testShowDomeSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowDomeSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowDomeSurfacesPropertyName, expected);
    }

    @Test
    public final void testDomeSurfaceMaterial() {
        assertMaterialProperty(GroundElevationVolumeCesiumWriter.DomeSurfaceMaterialPropertyName, Color.YELLOW);
    }

    @Test
    public final void testEnvironmentConstraint() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentConstraintProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.EnvironmentConstraintPropertyName, expected);
    }

    @Test
    public final void testShowEnvironmentOcclusion() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowEnvironmentOcclusionProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowEnvironmentOcclusionPropertyName, expected);
    }

    @Test
    public final void testEnvironmentOcclusionMaterial() {
        assertMaterialProperty(GroundElevationVolumeCesiumWriter.EnvironmentOcclusionMaterialPropertyName, Color.MAGENTA);
    }

    @Test
    public final void testShowEnvironmentIntersection() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowEnvironmentIntersectionProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowEnvironmentIntersectionPropertyName, expected);
    }

    @Test
    public final void testEnvironmentIntersectionColor() {
        Color expected = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentIntersectionColorProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.EnvironmentIntersectionColorPropertyName, expected);
    }

    @Test
    public final void testEnvironmentIntersectionWidth() {
        final double expected = 2.2;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentIntersectionWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.EnvironmentIntersectionWidthPropertyName, expected);
    }

    @Test
    public final void testShowThroughEllipsoid() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowThroughEllipsoidProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowThroughEllipsoidPropertyName, expected);
    }

    @Test
    public final void testShowViewshed() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowViewshedProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ShowViewshedPropertyName, expected);
    }

    @Test
    public final void testViewshedVisibleColor() {
        Color expected = ColorHelper.GREEN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeViewshedVisibleColorProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ViewshedVisibleColorPropertyName, expected);
    }

    @Test
    public final void testViewshedOccludedColor() {
        Color expected = Color.GRAY;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeViewshedOccludedColorProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ViewshedOccludedColorPropertyName, expected);
    }

    @Test
    public final void testViewshedResolution() {
        final int expected = 256;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    interval.writeViewshedResolutionProperty(expected);
                }
            }
        }
        assertPropertyJson(GroundElevationVolumeCesiumWriter.ViewshedResolutionPropertyName, expected);
    }

    private final void assertMaterialProperty(@Nonnull String propertyName, @Nonnull Color expectedColor) {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<GroundElevationVolumeCesiumWriter> using$1 = new Using<GroundElevationVolumeCesiumWriter>(packet.openGroundElevationVolumeProperty())) {
                final GroundElevationVolumeCesiumWriter volume = using$1.resource;
                try (Using<GroundElevationVolumeCesiumWriter> using$2 = new Using<GroundElevationVolumeCesiumWriter>(volume.openInterval())) {
                    final GroundElevationVolumeCesiumWriter interval = using$2.resource;
                    try (Using<MaterialCesiumWriter> using$3 = new Using<MaterialCesiumWriter>(openMaterialProperty(interval, propertyName))) {
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
        MapHelper.add(tempCollection$0, MaterialCesiumWriter.SolidColorPropertyName, tempCollection$1);
        assertPropertyJson(propertyName, tempCollection$0);
    }

    private static MaterialCesiumWriter openMaterialProperty(GroundElevationVolumeCesiumWriter volume, @Nonnull String propertyName) {
        if (propertyName != null) {
            switch (propertyName) {
            case GroundElevationVolumeCesiumWriter.LateralSurfaceMaterialPropertyName: {
                return volume.openLateralSurfaceMaterialProperty();
            }
            case GroundElevationVolumeCesiumWriter.EllipsoidSurfaceMaterialPropertyName: {
                return volume.openEllipsoidSurfaceMaterialProperty();
            }
            case GroundElevationVolumeCesiumWriter.DomeSurfaceMaterialPropertyName: {
                return volume.openDomeSurfaceMaterialProperty();
            }
            case GroundElevationVolumeCesiumWriter.EnvironmentOcclusionMaterialPropertyName: {
                return volume.openEnvironmentOcclusionMaterialProperty();
            }
            default: {
                throw new ArgumentException();
            }
            }
        } else {
            throw new ArgumentException();
        }
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.GroundElevationVolumePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<GroundElevationVolumeCesiumWriter> createPropertyWriter(String propertyName) {
        return new GroundElevationVolumeCesiumWriter(propertyName);
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