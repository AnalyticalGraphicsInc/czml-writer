package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.LinkedHashMap;
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
    public final void testBasicProperties() {
        final boolean expectedShow = true;
        final double expectedXHalfAngle = 1.1;
        final double expectedYHalfAngle = 1.2;
        final double expectedRadius = 1234.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(getPacket().openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter rectangle = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(rectangle.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                    interval.writeXHalfAngleProperty(expectedXHalfAngle);
                    interval.writeYHalfAngleProperty(expectedYHalfAngle);
                    interval.writeRadiusProperty(expectedRadius);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.ShowPropertyName, expectedShow);
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.XHalfAnglePropertyName, expectedXHalfAngle);
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.YHalfAnglePropertyName, expectedYHalfAngle);
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.RadiusPropertyName, expectedRadius);
        assertExpectedJson(PacketCesiumWriter.RectangularSensorPropertyName, tempCollection$0);
    }

    @Test
    public final void testIntersectionProperties() {
        final boolean expectedShowIntersection = true;
        Color expectedIntersectionColor = Color.BLUE;
        final double expectedIntersectionWidth = 2.1;
        final boolean expectedShowEnvironmentIntersection = true;
        Color expectedEnvironmentIntersectionColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(getPacket().openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter rectangle = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(rectangle.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowIntersectionProperty(expectedShowIntersection);
                    interval.writeIntersectionColorProperty(expectedIntersectionColor);
                    interval.writeIntersectionWidthProperty(expectedIntersectionWidth);
                    interval.writeShowEnvironmentIntersectionProperty(expectedShowEnvironmentIntersection);
                    interval.writeEnvironmentIntersectionColorProperty(expectedEnvironmentIntersectionColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.ShowIntersectionPropertyName, expectedShowIntersection);
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.IntersectionColorPropertyName, expectedIntersectionColor);
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.IntersectionWidthPropertyName, expectedIntersectionWidth);
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expectedShowEnvironmentIntersection);
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expectedEnvironmentIntersectionColor);
        assertExpectedJson(PacketCesiumWriter.RectangularSensorPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowThroughEllipsoid() {
        final boolean expectedShowThroughEllipsoid = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<RectangularSensorCesiumWriter> using$1 = new Using<RectangularSensorCesiumWriter>(getPacket().openRectangularSensorProperty())) {
                final RectangularSensorCesiumWriter rectangle = using$1.resource;
                try (Using<RectangularSensorCesiumWriter> using$2 = new Using<RectangularSensorCesiumWriter>(rectangle.openInterval())) {
                    final RectangularSensorCesiumWriter interval = using$2.resource;
                    interval.writeShowThroughEllipsoidProperty(expectedShowThroughEllipsoid);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, RectangularSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expectedShowThroughEllipsoid);
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