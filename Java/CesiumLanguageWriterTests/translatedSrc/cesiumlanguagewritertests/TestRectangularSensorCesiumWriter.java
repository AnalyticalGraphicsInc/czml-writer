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
public class TestRectangularSensorCesiumWriter extends TestCesiumPropertyWriter<RectangularSensorCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testXHalfAngle() {
        final double expected = 1.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeXHalfAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.XHalfAnglePropertyName, expected);
    }

    @Test
    public final void testYHalfAngle() {
        final double expected = 1.2;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeYHalfAngleProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.YHalfAnglePropertyName, expected);
    }

    @Test
    public final void testMinimumRadius() {
        final double expected = 123.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeMinimumRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.MinimumRadiusPropertyName, expected);
    }

    @Test
    public final void testMaximumRadius() {
        final double expected = 234.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeMaximumRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.MaximumRadiusPropertyName, expected);
    }

    @Test
    public final void testRadius() {
        final double expected = 1234.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeRadiusProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.RadiusPropertyName, expected);
    }

    @Test
    public final void testShowIntersection() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowIntersectionProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowIntersectionPropertyName, expected);
    }

    @Test
    public final void testIntersectionColor() {
        Color expected = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeIntersectionColorProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.IntersectionColorPropertyName, expected);
    }

    @Test
    public final void testIntersectionWidth() {
        final double expected = 2.1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeIntersectionWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.IntersectionWidthPropertyName, expected);
    }

    @Test
    public final void testShowLateralSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowLateralSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowLateralSurfacesPropertyName, expected);
    }

    @Test
    public final void testLateralSurfaceMaterial() {
        Color expectedColor = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(RectangularSensorCesiumWriter.LateralSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEllipsoidSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEllipsoidSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowEllipsoidSurfacesPropertyName, expected);
    }

    @Test
    public final void testEllipsoidSurfaceMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(RectangularSensorCesiumWriter.EllipsoidSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEllipsoidHorizonSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEllipsoidHorizonSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowEllipsoidHorizonSurfacesPropertyName, expected);
    }

    @Test
    public final void testEllipsoidHorizonSurfaceMaterial() {
        Color expectedColor = ColorHelper.GREEN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(RectangularSensorCesiumWriter.EllipsoidHorizonSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowDomeSurfaces() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowDomeSurfacesProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowDomeSurfacesPropertyName, expected);
    }

    @Test
    public final void testDomeSurfaceMaterial() {
        Color expectedColor = Color.YELLOW;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(RectangularSensorCesiumWriter.DomeSurfaceMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowEnvironmentIntersection() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEnvironmentIntersectionProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expected);
    }

    @Test
    public final void testEnvironmentIntersectionColor() {
        Color expected = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentIntersectionColorProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expected);
    }

    @Test
    public final void testEnvironmentIntersectionWidth() {
        final double expected = 3.4;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentIntersectionWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.EnvironmentIntersectionWidthPropertyName, expected);
    }

    @Test
    public final void testShowThroughEllipsoid() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowThroughEllipsoidProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expected);
    }

    @Test
    public final void testPortionToDisplay() {
        final CesiumSensorVolumePortionToDisplay expected = CesiumSensorVolumePortionToDisplay.ABOVE_ELLIPSOID_HORIZON;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writePortionToDisplayProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.PortionToDisplayPropertyName, expected);
    }

    @Test
    public final void testEnvironmentConstraint() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeEnvironmentConstraintProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.EnvironmentConstraintPropertyName, expected);
    }

    @Test
    public final void testShowEnvironmentOcclusion() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowEnvironmentOcclusionProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowEnvironmentOcclusionPropertyName, expected);
    }

    @Test
    public final void testEnvironmentOcclusionMaterial() {
        Color expectedColor = Color.CYAN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
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
        assertPropertyJson(RectangularSensorCesiumWriter.EnvironmentOcclusionMaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowViewshed() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowViewshedProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ShowViewshedPropertyName, expected);
    }

    @Test
    public final void testViewshedVisibleColor() {
        Color expected = ColorHelper.GREEN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedVisibleColorProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ViewshedVisibleColorPropertyName, expected);
    }

    @Test
    public final void testViewshedOccludedColor() {
        Color expected = Color.YELLOW;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedOccludedColorProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ViewshedOccludedColorPropertyName, expected);
    }

    @Test
    public final void testViewshedResolution() {
        final int expected = 256;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(packet.openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter sensor = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(sensor.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeViewshedResolutionProperty(expected);
                }
            }
        }
        assertPropertyJson(RectangularSensorCesiumWriter.ViewshedResolutionPropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.RectangularSensorPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<RectangularSensorCesiumWriter> createPropertyWriter(String propertyName) {
        return new RectangularSensorCesiumWriter(propertyName);
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