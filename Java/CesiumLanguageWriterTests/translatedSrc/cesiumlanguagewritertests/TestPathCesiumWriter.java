package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
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
public class TestPathCesiumWriter extends TestCesiumPropertyWriter<PathCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PathCesiumWriter> using$1 = new Using<PathCesiumWriter>(packet.openPathProperty())) {
                final PathCesiumWriter path = using$1.resource;
                try (Using<PathCesiumWriter> using$2 = new Using<PathCesiumWriter>(path.openInterval())) {
                    final PathCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PathCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.PathPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowPropertyInterval() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0.0).toJulianDate();
        JulianDate interval1Start = startDate;
        JulianDate interval1Stop = startDate.addSeconds(1.0);
        JulianDate interval2Start = interval1Stop;
        JulianDate interval2Stop = startDate.addSeconds(2.0);
        JulianDate interval3Start = interval2Stop;
        JulianDate interval3Stop = stopDate;
        final boolean interval1Value = true;
        final boolean interval2Value = false;
        final boolean interval3Value = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PathCesiumWriter> using$1 = new Using<PathCesiumWriter>(packet.openPathProperty())) {
                final PathCesiumWriter path = using$1.resource;
                try (Using<BooleanCesiumWriter> using$2 = new Using<BooleanCesiumWriter>(path.openShowProperty())) {
                    final BooleanCesiumWriter show = using$2.resource;
                    try (Using<CesiumIntervalListWriter<BooleanCesiumWriter>> using$3 = new Using<CesiumIntervalListWriter<BooleanCesiumWriter>>(show.openMultipleIntervals())) {
                        final CesiumIntervalListWriter<BooleanCesiumWriter> showIntervals = using$3.resource;
                        try (Using<BooleanCesiumWriter> using$4 = new Using<BooleanCesiumWriter>(showIntervals.openInterval(interval1Start, interval1Stop))) {
                            final BooleanCesiumWriter interval = using$4.resource;
                            interval.writeBoolean(interval1Value);
                        }
                        try (Using<BooleanCesiumWriter> using$5 = new Using<BooleanCesiumWriter>(showIntervals.openInterval(interval2Start, interval2Stop))) {
                            final BooleanCesiumWriter interval = using$5.resource;
                            interval.writeBoolean(interval2Value);
                        }
                        try (Using<BooleanCesiumWriter> using$6 = new Using<BooleanCesiumWriter>(showIntervals.openInterval(interval3Start, interval3Stop))) {
                            final BooleanCesiumWriter interval = using$6.resource;
                            interval.writeBoolean(interval3Value);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, "interval", CesiumFormattingHelper.toIso8601Interval(interval1Start, interval1Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$2, BooleanCesiumWriter.BooleanPropertyName, interval1Value);
        final Map<String, Object> tempCollection$3 = MapHelper.create();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(interval2Start, interval2Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$3, BooleanCesiumWriter.BooleanPropertyName, interval2Value);
        final Map<String, Object> tempCollection$4 = MapHelper.create();
        MapHelper.add(tempCollection$4, "interval", CesiumFormattingHelper.toIso8601Interval(interval3Start, interval3Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$4, BooleanCesiumWriter.BooleanPropertyName, interval3Value);
        final ArrayList<Map<String, Object>> tempCollection$1 = new ArrayList<Map<String, Object>>();
        tempCollection$1.add(tempCollection$2);
        tempCollection$1.add(tempCollection$3);
        tempCollection$1.add(tempCollection$4);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PathCesiumWriter.ShowPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PathPropertyName, tempCollection$0);
    }

    @Test
    public final void testRelativeToProperty() {
        final String expectedRelativeTo = "INERTIAL";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PathCesiumWriter> using$1 = new Using<PathCesiumWriter>(packet.openPathProperty())) {
                final PathCesiumWriter path = using$1.resource;
                try (Using<PathCesiumWriter> using$2 = new Using<PathCesiumWriter>(path.openInterval())) {
                    final PathCesiumWriter interval = using$2.resource;
                    interval.writeRelativeToProperty(expectedRelativeTo);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PathCesiumWriter.RelativeToPropertyName, expectedRelativeTo);
        assertExpectedJson(PacketCesiumWriter.PathPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PathCesiumWriter> createPropertyWriter(String propertyName) {
        return new PathCesiumWriter(propertyName);
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