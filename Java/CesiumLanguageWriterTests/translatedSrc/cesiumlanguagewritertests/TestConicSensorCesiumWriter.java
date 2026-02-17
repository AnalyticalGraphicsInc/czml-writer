package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
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
    public final void testBasicProperties() {
        final boolean expectedShow = true;
        final double expectedInnerHalfAngle = 1.1;
        final double expectedOuterHalfAngle = 1.2;
        final double expectedMinimumClockAngle = 1.3;
        final double expectedMaximumClockAngle = 1.4;
        final double expectedRadius = 1234.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter rectangle = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(rectangle.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                    interval.writeInnerHalfAngleProperty(expectedInnerHalfAngle);
                    interval.writeOuterHalfAngleProperty(expectedOuterHalfAngle);
                    interval.writeMinimumClockAngleProperty(expectedMinimumClockAngle);
                    interval.writeMaximumClockAngleProperty(expectedMaximumClockAngle);
                    interval.writeRadiusProperty(expectedRadius);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.ShowPropertyName, expectedShow);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.InnerHalfAnglePropertyName, expectedInnerHalfAngle);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.OuterHalfAnglePropertyName, expectedOuterHalfAngle);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.MinimumClockAnglePropertyName, expectedMinimumClockAngle);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.MaximumClockAnglePropertyName, expectedMaximumClockAngle);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.RadiusPropertyName, expectedRadius);
        assertExpectedJson(PacketCesiumWriter.ConicSensorPropertyName, tempCollection$0);
    }

    @Test
    public final void testIntersectionProperties() {
        final boolean expectedShowIntersection = true;
        Color expectedIntersectionColor = Color.BLUE;
        final double expectedIntersectionWidth = 2.1;
        final boolean expectedShowEnvironmentIntersection = true;
        Color expectedEnvironmentIntersectionColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter rectangle = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(rectangle.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowIntersectionProperty(expectedShowIntersection);
                    interval.writeIntersectionColorProperty(expectedIntersectionColor);
                    interval.writeIntersectionWidthProperty(expectedIntersectionWidth);
                    interval.writeShowEnvironmentIntersectionProperty(expectedShowEnvironmentIntersection);
                    interval.writeEnvironmentIntersectionColorProperty(expectedEnvironmentIntersectionColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.ShowIntersectionPropertyName, expectedShowIntersection);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.IntersectionColorPropertyName, expectedIntersectionColor);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.IntersectionWidthPropertyName, expectedIntersectionWidth);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expectedShowEnvironmentIntersection);
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expectedEnvironmentIntersectionColor);
        assertExpectedJson(PacketCesiumWriter.ConicSensorPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowThroughEllipsoid() {
        final boolean expectedShowThroughEllipsoid = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ConicSensorCesiumWriter> using$1 = new Using<ConicSensorCesiumWriter>(packet.openConicSensorProperty())) {
                final ConicSensorCesiumWriter rectangle = using$1.resource;
                try (Using<ConicSensorCesiumWriter> using$2 = new Using<ConicSensorCesiumWriter>(rectangle.openInterval())) {
                    final ConicSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowThroughEllipsoidProperty(expectedShowThroughEllipsoid);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ConicSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expectedShowThroughEllipsoid);
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