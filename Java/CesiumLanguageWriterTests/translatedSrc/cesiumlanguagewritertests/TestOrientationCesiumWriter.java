package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
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
public class TestOrientationCesiumWriter extends TestCesiumInterpolatablePropertyWriter<OrientationCesiumWriter> {
    @Test
    public final void testCompleteExample() {
        JulianDate date = new JulianDate(2451545.0);
        final String id = "MyID";
        TimeInterval availability = new TimeInterval(date, date.addDays(2.0));
        TimeInterval interval1 = new TimeInterval(date, date.addDays(1.0));
        Cartesian interval1Position = new Cartesian(1.0, 2.0, 3.0);
        UnitQuaternion interval1Orientation = new UnitQuaternion(1.0, 0.0, 0.0, 0.0);
        TimeInterval interval2 = new TimeInterval(date.addDays(1.0), date.addDays(2.0));
        final ArrayList<JulianDate> tempCollection$0 = new ArrayList<JulianDate>();
        tempCollection$0.add(date.addDays(1.0));
        tempCollection$0.add(date.addDays(1.5));
        tempCollection$0.add(date.addDays(2.0));
        ArrayList<JulianDate> interval2SampleDates = tempCollection$0;
        final ArrayList<Cartographic> tempCollection$1 = new ArrayList<Cartographic>();
        tempCollection$1.add(Cartographic.getZero());
        tempCollection$1.add(new Cartographic(1.0, 0.0, 0.0));
        tempCollection$1.add(new Cartographic(0.0, 1.0, 0.0));
        ArrayList<Cartographic> interval2SamplePositions = tempCollection$1;
        final ArrayList<UnitQuaternion> tempCollection$2 = new ArrayList<UnitQuaternion>();
        tempCollection$2.add(UnitQuaternion.getIdentity());
        tempCollection$2.add(new UnitQuaternion(0.0, 1.0, 0.0, 0.0));
        tempCollection$2.add(new UnitQuaternion(0.0, 0.0, 1.0, 0.0));
        ArrayList<UnitQuaternion> interval2SampleOrientations = tempCollection$2;
        final CesiumInterpolationAlgorithm orientationInterpolationAlgorithm = CesiumInterpolationAlgorithm.LINEAR;
        final int orientationInterpolationDegree = 1;
        StringWriter stringWriter = new StringWriter();
        CesiumOutputStream outputStream = new CesiumOutputStream(stringWriter, true);
        CesiumStreamWriter writer = new CesiumStreamWriter();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(writer.openPacket(outputStream))) {
            final PacketCesiumWriter packet = using$0.resource;
            packet.writeId(id);
            packet.writeAvailability(availability);
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(packet.openPositionProperty())) {
                final PositionCesiumWriter positionWriter = using$1.resource;
                try (Using<CesiumIntervalListWriter<PositionCesiumWriter>> using$2 = new Using<CesiumIntervalListWriter<PositionCesiumWriter>>(positionWriter.openMultipleIntervals())) {
                    final CesiumIntervalListWriter<PositionCesiumWriter> intervalListWriter = using$2.resource;
                    try (Using<PositionCesiumWriter> using$3 = new Using<PositionCesiumWriter>(intervalListWriter.openInterval())) {
                        final PositionCesiumWriter interval = using$3.resource;
                        interval.writeInterval(interval1);
                        interval.writeCartesian(interval1Position);
                    }
                    try (Using<PositionCesiumWriter> using$4 = new Using<PositionCesiumWriter>(intervalListWriter.openInterval(interval2.getStart(), interval2.getStop()))) {
                        final PositionCesiumWriter interval = using$4.resource;
                        interval.writeCartographicRadians(interval2SampleDates, interval2SamplePositions);
                    }
                }
            }
            try (Using<OrientationCesiumWriter> using$5 = new Using<OrientationCesiumWriter>(packet.openOrientationProperty())) {
                final OrientationCesiumWriter orientationWriter = using$5.resource;
                try (Using<CesiumIntervalListWriter<OrientationCesiumWriter>> using$6 = new Using<CesiumIntervalListWriter<OrientationCesiumWriter>>(orientationWriter.openMultipleIntervals())) {
                    final CesiumIntervalListWriter<OrientationCesiumWriter> intervalListWriter = using$6.resource;
                    try (Using<OrientationCesiumWriter> using$7 = new Using<OrientationCesiumWriter>(intervalListWriter.openInterval())) {
                        final OrientationCesiumWriter interval = using$7.resource;
                        interval.writeInterval(interval1);
                        interval.writeUnitQuaternion(interval1Orientation);
                    }
                    try (Using<OrientationCesiumWriter> using$8 = new Using<OrientationCesiumWriter>(intervalListWriter.openInterval(interval2.getStart(), interval2.getStop()))) {
                        final OrientationCesiumWriter interval = using$8.resource;
                        interval.writeInterpolationAlgorithm(orientationInterpolationAlgorithm);
                        interval.writeInterpolationDegree(orientationInterpolationDegree);
                        interval.writeUnitQuaternion(interval2SampleDates, interval2SampleOrientations);
                    }
                }
            }
        }
        ConsoleHelper.writeLine(stringWriter.toString());
    }

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate stop = start.addDays(1.0);
        final String expectedId = "id";
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            getPacket().writeId(expectedId);
            try (Using<OrientationCesiumWriter> using$1 = new Using<OrientationCesiumWriter>(getPacket().openOrientationProperty())) {
                final OrientationCesiumWriter orientation = using$1.resource;
                try (Using<OrientationCesiumWriter> using$2 = new Using<OrientationCesiumWriter>(orientation.openInterval(start, stop))) {
                    final OrientationCesiumWriter interval = using$2.resource;
                    interval.writeDelete(expectedDelete);
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$1, OrientationCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$0, PacketCesiumWriter.OrientationPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void testDeletePropertyWithNoInterval() {
        final String expectedId = "id";
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            getPacket().writeId(expectedId);
            try (Using<OrientationCesiumWriter> using$1 = new Using<OrientationCesiumWriter>(getPacket().openOrientationProperty())) {
                final OrientationCesiumWriter orientation = using$1.resource;
                try (Using<OrientationCesiumWriter> using$2 = new Using<OrientationCesiumWriter>(orientation.openInterval())) {
                    final OrientationCesiumWriter interval = using$2.resource;
                    interval.writeDelete(expectedDelete);
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, OrientationCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$0, PacketCesiumWriter.OrientationPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<OrientationCesiumWriter> createPropertyWriter(String propertyName) {
        return new OrientationCesiumWriter(propertyName);
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