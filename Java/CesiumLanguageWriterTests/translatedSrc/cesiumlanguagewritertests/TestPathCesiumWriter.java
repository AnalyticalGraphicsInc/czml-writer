package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.IterableHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewritertests.data.*;
import java.awt.Color;
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

    @Test
    public final void testMaterialMode() {
        final String expectedMaterialMode = "PORTIONS";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PathCesiumWriter> using$1 = new Using<PathCesiumWriter>(packet.openPathProperty())) {
                final PathCesiumWriter path = using$1.resource;
                try (Using<PathCesiumWriter> using$2 = new Using<PathCesiumWriter>(path.openInterval())) {
                    final PathCesiumWriter interval = using$2.resource;
                    interval.writeMaterialModeProperty(CesiumPathMode.PORTIONS);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PathCesiumWriter.MaterialModePropertyName, expectedMaterialMode);
        assertExpectedJson(PacketCesiumWriter.PathPropertyName, tempCollection$0);
    }

    @Test
    public final void pathPortionMaterialExample() {
        getOutputStream().setPrettyFormatting(true);
        getOutputStream().writeStartSequence();
        JulianDate startDate = GregorianDate.parse("2026/04/01").toJulianDate();
        final ArrayList<JulianDate> tempCollection$0 = new ArrayList<JulianDate>();
        tempCollection$0.add(startDate);
        tempCollection$0.add(startDate.addSeconds(1 * 60.0));
        tempCollection$0.add(startDate.addSeconds(2 * 60.0));
        tempCollection$0.add(startDate.addSeconds(3 * 60.0));
        ArrayList<JulianDate> dates = tempCollection$0;
        final ArrayList<Cartographic> tempCollection$1 = new ArrayList<Cartographic>();
        tempCollection$1.add(new Cartographic(-70.0, 20.0, 150000.0));
        tempCollection$1.add(new Cartographic(-75.0, 15.0, 160000.0));
        tempCollection$1.add(new Cartographic(-78.0, 24.0, 140000.0));
        tempCollection$1.add(new Cartographic(-83.0, 10.0, 170000.0));
        ArrayList<Cartographic> positions = tempCollection$1;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            packet.writeId("document");
            packet.writeVersion("1.0");
            try (Using<ClockCesiumWriter> using$1 = new Using<ClockCesiumWriter>(packet.openClockProperty())) {
                final ClockCesiumWriter clock = using$1.resource;
                try (Using<ClockCesiumWriter> using$2 = new Using<ClockCesiumWriter>(clock.openInterval(IterableHelper.first(dates), IterableHelper.last(dates)))) {
                    final ClockCesiumWriter interval = using$2.resource;
                    interval.writeCurrentTime(IterableHelper.first(dates));
                }
            }
        }
        try (Using<PacketCesiumWriter> using$3 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$3.resource;
            packet.writeAvailability(IterableHelper.first(dates), IterableHelper.last(dates));
            try (Using<PositionCesiumWriter> using$4 = new Using<PositionCesiumWriter>(packet.openPositionProperty())) {
                final PositionCesiumWriter position = using$4.resource;
                position.writeCartographicDegrees(dates, positions);
            }
            try (Using<BillboardCesiumWriter> using$5 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$5.resource;
                billboard.writeImageProperty(CesiumResource.fromStream(EmbeddedData.read("satellite.png"), CesiumImageFormat.PNG));
            }
            try (Using<PathCesiumWriter> using$6 = new Using<PathCesiumWriter>(packet.openPathProperty())) {
                final PathCesiumWriter path = using$6.resource;
                path.writeWidthProperty(8.0);
                path.writeMaterialModeProperty(CesiumPathMode.PORTIONS);
                try (Using<PolylineMaterialCesiumWriter> using$7 = new Using<PolylineMaterialCesiumWriter>(path.openMaterialProperty())) {
                    final PolylineMaterialCesiumWriter material = using$7.resource;
                    try (Using<CesiumIntervalListWriter<PolylineMaterialCesiumWriter>> using$8 = new Using<CesiumIntervalListWriter<PolylineMaterialCesiumWriter>>(material.openMultipleIntervals())) {
                        final CesiumIntervalListWriter<PolylineMaterialCesiumWriter> intervals = using$8.resource;
                        try (Using<PolylineMaterialCesiumWriter> using$9 = new Using<PolylineMaterialCesiumWriter>(intervals.openInterval(dates.get(0), dates.get(1)))) {
                            final PolylineMaterialCesiumWriter interval = using$9.resource;
                            try (Using<SolidColorMaterialCesiumWriter> using$10 = new Using<SolidColorMaterialCesiumWriter>(interval.openSolidColorProperty())) {
                                final SolidColorMaterialCesiumWriter solidColor = using$10.resource;
                                solidColor.writeColorProperty(Color.RED);
                            }
                        }
                        try (Using<PolylineMaterialCesiumWriter> using$11 = new Using<PolylineMaterialCesiumWriter>(intervals.openInterval(dates.get(1), dates.get(2)))) {
                            final PolylineMaterialCesiumWriter interval = using$11.resource;
                            try (Using<PolylineGlowMaterialCesiumWriter> using$12 = new Using<PolylineGlowMaterialCesiumWriter>(interval.openPolylineGlowProperty())) {
                                final PolylineGlowMaterialCesiumWriter polylineGlow = using$12.resource;
                                polylineGlow.writeColorProperty(ColorHelper.PURPLE);
                                final ArrayList<JulianDate> tempCollection$2 = new ArrayList<JulianDate>();
                                tempCollection$2.add(dates.get(1));
                                tempCollection$2.add(dates.get(2));
                                final ArrayList<Double> tempCollection$3 = new ArrayList<Double>();
                                tempCollection$3.add(0.0);
                                tempCollection$3.add(1.0);
                                polylineGlow.writeGlowPowerProperty(tempCollection$2, tempCollection$3);
                            }
                        }
                        try (Using<PolylineMaterialCesiumWriter> using$13 = new Using<PolylineMaterialCesiumWriter>(intervals.openInterval(dates.get(2), dates.get(3)))) {
                            final PolylineMaterialCesiumWriter interval = using$13.resource;
                            try (Using<PolylineDashMaterialCesiumWriter> using$14 = new Using<PolylineDashMaterialCesiumWriter>(interval.openPolylineDashProperty())) {
                                final PolylineDashMaterialCesiumWriter polylineDash = using$14.resource;
                                try (Using<ColorCesiumWriter> using$15 = new Using<ColorCesiumWriter>(polylineDash.openColorProperty())) {
                                    final ColorCesiumWriter color = using$15.resource;
                                    try (Using<CesiumIntervalListWriter<ColorCesiumWriter>> using$16 = new Using<CesiumIntervalListWriter<ColorCesiumWriter>>(color.openMultipleIntervals())) {
                                        final CesiumIntervalListWriter<ColorCesiumWriter> colorIntervals = using$16.resource;
                                        try (Using<ColorCesiumWriter> using$17 = new Using<ColorCesiumWriter>(colorIntervals.openInterval(dates.get(2), dates.get(2).addSeconds(30.0)))) {
                                            final ColorCesiumWriter colorInterval = using$17.resource;
                                            colorInterval.writeRgba(ColorHelper.LIGHTGREEN);
                                        }
                                        try (Using<ColorCesiumWriter> using$18 = new Using<ColorCesiumWriter>(colorIntervals.openInterval(dates.get(2).addSeconds(30.0), dates.get(3)))) {
                                            final ColorCesiumWriter colorInterval = using$18.resource;
                                            colorInterval.writeRgba(ColorHelper.LIGHTCORAL);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        getOutputStream().writeEndSequence();
        ConsoleHelper.writeLine(getStringWriter().toString());
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