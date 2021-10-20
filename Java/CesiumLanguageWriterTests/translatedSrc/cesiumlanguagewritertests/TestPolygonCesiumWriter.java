package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.Assert;
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
public class TestPolygonCesiumWriter extends TestCesiumPropertyWriter<PolygonCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(getPacket().openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolygonCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.PolygonPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowPropertyInterval() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0D).toJulianDate();
        JulianDate interval1Start = startDate;
        JulianDate interval1Stop = startDate.addSeconds(1D);
        JulianDate interval2Start = interval1Stop;
        JulianDate interval2Stop = startDate.addSeconds(2D);
        JulianDate interval3Start = interval2Stop;
        JulianDate interval3Stop = stopDate;
        final boolean interval1Value = true;
        final boolean interval2Value = false;
        final boolean interval3Value = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(getPacket().openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<BooleanCesiumWriter> using$2 = new Using<BooleanCesiumWriter>(polygon.openShowProperty())) {
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
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, "interval", CesiumFormattingHelper.toIso8601Interval(interval1Start, interval1Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$2, BooleanCesiumWriter.BooleanPropertyName, interval1Value);
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(interval2Start, interval2Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$3, BooleanCesiumWriter.BooleanPropertyName, interval2Value);
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, "interval", CesiumFormattingHelper.toIso8601Interval(interval3Start, interval3Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$4, BooleanCesiumWriter.BooleanPropertyName, interval3Value);
        final ArrayList<Map<String, Object>> tempCollection$1 = new ArrayList<Map<String, Object>>();
        tempCollection$1.add(tempCollection$2);
        tempCollection$1.add(tempCollection$3);
        tempCollection$1.add(tempCollection$4);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolygonCesiumWriter.ShowPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolygonPropertyName, tempCollection$0);
    }

    @Test
    public final void testHoles() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(getPacket().openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PositionListOfListsCesiumWriter> using$2 = new Using<PositionListOfListsCesiumWriter>(polygon.openHolesProperty())) {
                    final PositionListOfListsCesiumWriter holes = using$2.resource;
                    final ArrayList<Cartographic> tempCollection$1 = new ArrayList<Cartographic>();
                    tempCollection$1.add(new Cartographic(1D, 1D, 0D));
                    tempCollection$1.add(new Cartographic(1D, 2D, 0D));
                    tempCollection$1.add(new Cartographic(2D, 2D, 0D));
                    final ArrayList<Cartographic> tempCollection$2 = new ArrayList<Cartographic>();
                    tempCollection$2.add(new Cartographic(4D, 4D, 0D));
                    tempCollection$2.add(new Cartographic(4D, 5D, 0D));
                    tempCollection$2.add(new Cartographic(5D, 5D, 0D));
                    tempCollection$2.add(new Cartographic(5D, 4D, 0D));
                    final ArrayList<ArrayList<Cartographic>> tempCollection$0 = new ArrayList<ArrayList<Cartographic>>();
                    tempCollection$0.add(tempCollection$1);
                    tempCollection$0.add(tempCollection$2);
                    ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$0;
                    holes.writeCartographicDegrees(listOfHoles);
                }
            }
        }
        Assert.assertEquals("{\"polygon\":{\"holes\":{\"cartographicDegrees\":[[1,1,0,1,2,0,2,2,0],[4,4,0,4,5,0,5,5,0,5,4,0]]}}}", getStringWriter().toString());
    }

    @Test
    public final void testHolesIntervals() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stopDate = new GregorianDate(2012, 4, 2, 13, 0, 0D).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(getPacket().openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PositionListOfListsCesiumWriter> using$2 = new Using<PositionListOfListsCesiumWriter>(polygon.openHolesProperty())) {
                    final PositionListOfListsCesiumWriter holes = using$2.resource;
                    try (Using<CesiumIntervalListWriter<PositionListOfListsCesiumWriter>> using$3 = new Using<CesiumIntervalListWriter<PositionListOfListsCesiumWriter>>(
                            holes.openMultipleIntervals())) {
                        final CesiumIntervalListWriter<PositionListOfListsCesiumWriter> holesIntervals = using$3.resource;
                        try (Using<PositionListOfListsCesiumWriter> using$4 = new Using<PositionListOfListsCesiumWriter>(holesIntervals.openInterval(startDate, startDate.addSeconds(60 * 30)))) {
                            final PositionListOfListsCesiumWriter interval = using$4.resource;
                            final ArrayList<Cartographic> tempCollection$1 = new ArrayList<Cartographic>();
                            tempCollection$1.add(new Cartographic(1D, 1D, 0D));
                            tempCollection$1.add(new Cartographic(1D, 2D, 0D));
                            tempCollection$1.add(new Cartographic(2D, 2D, 0D));
                            final ArrayList<Cartographic> tempCollection$2 = new ArrayList<Cartographic>();
                            tempCollection$2.add(new Cartographic(4D, 4D, 0D));
                            tempCollection$2.add(new Cartographic(4D, 5D, 0D));
                            tempCollection$2.add(new Cartographic(5D, 5D, 0D));
                            tempCollection$2.add(new Cartographic(5D, 4D, 0D));
                            final ArrayList<ArrayList<Cartographic>> tempCollection$0 = new ArrayList<ArrayList<Cartographic>>();
                            tempCollection$0.add(tempCollection$1);
                            tempCollection$0.add(tempCollection$2);
                            ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$0;
                            interval.writeCartographicDegrees(listOfHoles);
                        }
                        try (Using<PositionListOfListsCesiumWriter> using$5 = new Using<PositionListOfListsCesiumWriter>(holesIntervals.openInterval(startDate.addSeconds(60 * 30), stopDate))) {
                            final PositionListOfListsCesiumWriter interval = using$5.resource;
                            final ArrayList<Cartographic> tempCollection$4 = new ArrayList<Cartographic>();
                            tempCollection$4.add(new Cartographic(11D, 1D, 0D));
                            tempCollection$4.add(new Cartographic(11D, 2D, 0D));
                            tempCollection$4.add(new Cartographic(12D, 2D, 0D));
                            final ArrayList<Cartographic> tempCollection$5 = new ArrayList<Cartographic>();
                            tempCollection$5.add(new Cartographic(14D, 4D, 0D));
                            tempCollection$5.add(new Cartographic(14D, 5D, 0D));
                            tempCollection$5.add(new Cartographic(15D, 5D, 0D));
                            tempCollection$5.add(new Cartographic(15D, 4D, 0D));
                            final ArrayList<ArrayList<Cartographic>> tempCollection$3 = new ArrayList<ArrayList<Cartographic>>();
                            tempCollection$3.add(tempCollection$4);
                            tempCollection$3.add(tempCollection$5);
                            ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$3;
                            interval.writeCartographicDegrees(listOfHoles);
                        }
                    }
                }
            }
        }
        Assert.assertEquals("{\"polygon\":{\"holes\":[" + "{\"interval\":\"20120402T12Z/20120402T1230Z\",\"cartographicDegrees\":[[1,1,0,1,2,0,2,2,0],[4,4,0,4,5,0,5,5,0,5,4,0]]},"
                + "{\"interval\":\"20120402T1230Z/20120402T13Z\",\"cartographicDegrees\":[[11,1,0,11,2,0,12,2,0],[14,4,0,14,5,0,15,5,0,15,4,0]]}" + "]}}", getStringWriter().toString());
    }

    @Test
    public final void testExample() {
        final CesiumOutputStream tempObj$0 = new CesiumOutputStream(getStringWriter());
        tempObj$0.setPrettyFormatting(true);
        CesiumOutputStream outputStream = tempObj$0;
        CesiumStreamWriter writer = new CesiumStreamWriter();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(writer.openPacket(outputStream))) {
            final PacketCesiumWriter packet = using$0.resource;
            packet.writeId("examplePolygon");
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PositionListCesiumWriter> using$2 = new Using<PositionListCesiumWriter>(polygon.openPositionsProperty())) {
                    final PositionListCesiumWriter positions = using$2.resource;
                    final ArrayList<Cartographic> tempCollection$0 = new ArrayList<Cartographic>();
                    tempCollection$0.add(new Cartographic(0D, 0D, 0D));
                    tempCollection$0.add(new Cartographic(0D, 10D, 0D));
                    tempCollection$0.add(new Cartographic(10D, 10D, 0D));
                    tempCollection$0.add(new Cartographic(10D, 0D, 0D));
                    ArrayList<Cartographic> listOfPositions = tempCollection$0;
                    positions.writeCartographicDegrees(listOfPositions);
                }
                try (Using<PositionListOfListsCesiumWriter> using$3 = new Using<PositionListOfListsCesiumWriter>(polygon.openHolesProperty())) {
                    final PositionListOfListsCesiumWriter holes = using$3.resource;
                    final ArrayList<Cartographic> tempCollection$2 = new ArrayList<Cartographic>();
                    tempCollection$2.add(new Cartographic(1D, 1D, 0D));
                    tempCollection$2.add(new Cartographic(1D, 2D, 0D));
                    tempCollection$2.add(new Cartographic(2D, 2D, 0D));
                    final ArrayList<Cartographic> tempCollection$3 = new ArrayList<Cartographic>();
                    tempCollection$3.add(new Cartographic(4D, 4D, 0D));
                    tempCollection$3.add(new Cartographic(4D, 5D, 0D));
                    tempCollection$3.add(new Cartographic(5D, 5D, 0D));
                    tempCollection$3.add(new Cartographic(5D, 4D, 0D));
                    final ArrayList<ArrayList<Cartographic>> tempCollection$1 = new ArrayList<ArrayList<Cartographic>>();
                    tempCollection$1.add(tempCollection$2);
                    tempCollection$1.add(tempCollection$3);
                    ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$1;
                    holes.writeCartographicDegrees(listOfHoles);
                }
                try (Using<MaterialCesiumWriter> using$4 = new Using<MaterialCesiumWriter>(polygon.openMaterialProperty())) {
                    final MaterialCesiumWriter material = using$4.resource;
                    try (Using<SolidColorMaterialCesiumWriter> using$5 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                        final SolidColorMaterialCesiumWriter solidColor = using$5.resource;
                        solidColor.writeColorProperty(Color.RED);
                    }
                }
            }
        }
        ConsoleHelper.writeLine(getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<PolygonCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolygonCesiumWriter(propertyName);
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