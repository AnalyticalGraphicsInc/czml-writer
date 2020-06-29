package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
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

@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPolygonCesiumWriter extends TestCesiumPropertyWriter<PolygonCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    PolygonCesiumWriter polygon = getPacket().openPolygonProperty();
                    try {
                        {
                            PolygonCesiumWriter interval = polygon.openInterval();
                            try {
                                interval.writeShowProperty(expectedShow);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polygon);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
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
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    PolygonCesiumWriter polygon = getPacket().openPolygonProperty();
                    try {
                        {
                            BooleanCesiumWriter show = polygon.openShowProperty();
                            try {
                                {
                                    CesiumIntervalListWriter<cesiumlanguagewriter.BooleanCesiumWriter> showIntervals = show.openMultipleIntervals();
                                    try {
                                        {
                                            BooleanCesiumWriter interval = showIntervals.openInterval(interval1Start, interval1Stop);
                                            try {
                                                interval.writeBoolean(interval1Value);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            BooleanCesiumWriter interval = showIntervals.openInterval(interval2Start, interval2Stop);
                                            try {
                                                interval.writeBoolean(interval2Value);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            BooleanCesiumWriter interval = showIntervals.openInterval(interval3Start, interval3Stop);
                                            try {
                                                interval.writeBoolean(interval3Value);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                    } finally {
                                        DisposeHelper.dispose(showIntervals);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(show);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polygon);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(interval1Start, interval1Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$3, BooleanCesiumWriter.BooleanPropertyName, interval1Value);
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, "interval", CesiumFormattingHelper.toIso8601Interval(interval2Start, interval2Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$4, BooleanCesiumWriter.BooleanPropertyName, interval2Value);
        final Map<String, Object> tempCollection$5 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$5, "interval", CesiumFormattingHelper.toIso8601Interval(interval3Start, interval3Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$5, BooleanCesiumWriter.BooleanPropertyName, interval3Value);
        final ArrayList<Map<String, Object>> tempCollection$2 = new ArrayList<Map<String, Object>>();
        tempCollection$2.add(tempCollection$3);
        tempCollection$2.add(tempCollection$4);
        tempCollection$2.add(tempCollection$5);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PolygonCesiumWriter.ShowPropertyName, tempCollection$2);
        assertExpectedJson(PacketCesiumWriter.PolygonPropertyName, tempCollection$1);
    }

    @Test
    public final void testHoles() {
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    PolygonCesiumWriter polygon = getPacket().openPolygonProperty();
                    try {
                        {
                            PositionListOfListsCesiumWriter holes = polygon.openHolesProperty();
                            try {
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$7 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$7.add(new Cartographic(1D, 1D, 0D));
                                tempCollection$7.add(new Cartographic(1D, 2D, 0D));
                                tempCollection$7.add(new Cartographic(2D, 2D, 0D));
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$8 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$8.add(new Cartographic(4D, 4D, 0D));
                                tempCollection$8.add(new Cartographic(4D, 5D, 0D));
                                tempCollection$8.add(new Cartographic(5D, 5D, 0D));
                                tempCollection$8.add(new Cartographic(5D, 4D, 0D));
                                final ArrayList<ArrayList<Cartographic>> tempCollection$6 = new ArrayList<ArrayList<Cartographic>>();
                                tempCollection$6.add(tempCollection$7);
                                tempCollection$6.add(tempCollection$8);
                                ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$6;
                                holes.writeCartographicDegrees(listOfHoles);
                            } finally {
                                DisposeHelper.dispose(holes);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polygon);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        Assert.assertEquals("{\"polygon\":{\"holes\":{\"cartographicDegrees\":[[1,1,0,1,2,0,2,2,0],[4,4,0,4,5,0,5,5,0,5,4,0]]}}}", getStringWriter().toString());
    }

    @Test
    public final void testHolesIntervals() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stopDate = new GregorianDate(2012, 4, 2, 13, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                {
                    PolygonCesiumWriter polygon = getPacket().openPolygonProperty();
                    try {
                        {
                            PositionListOfListsCesiumWriter holes = polygon.openHolesProperty();
                            try {
                                {
                                    CesiumIntervalListWriter<cesiumlanguagewriter.PositionListOfListsCesiumWriter> holesIntervals = holes.openMultipleIntervals();
                                    try {
                                        {
                                            PositionListOfListsCesiumWriter interval = holesIntervals.openInterval(startDate, startDate.addSeconds(60 * 30));
                                            try {
                                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$10 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                                tempCollection$10.add(new Cartographic(1D, 1D, 0D));
                                                tempCollection$10.add(new Cartographic(1D, 2D, 0D));
                                                tempCollection$10.add(new Cartographic(2D, 2D, 0D));
                                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$11 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                                tempCollection$11.add(new Cartographic(4D, 4D, 0D));
                                                tempCollection$11.add(new Cartographic(4D, 5D, 0D));
                                                tempCollection$11.add(new Cartographic(5D, 5D, 0D));
                                                tempCollection$11.add(new Cartographic(5D, 4D, 0D));
                                                final ArrayList<ArrayList<Cartographic>> tempCollection$9 = new ArrayList<ArrayList<Cartographic>>();
                                                tempCollection$9.add(tempCollection$10);
                                                tempCollection$9.add(tempCollection$11);
                                                ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$9;
                                                interval.writeCartographicDegrees(listOfHoles);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            PositionListOfListsCesiumWriter interval = holesIntervals.openInterval(startDate.addSeconds(60 * 30), stopDate);
                                            try {
                                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$13 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                                tempCollection$13.add(new Cartographic(11D, 1D, 0D));
                                                tempCollection$13.add(new Cartographic(11D, 2D, 0D));
                                                tempCollection$13.add(new Cartographic(12D, 2D, 0D));
                                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$14 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                                tempCollection$14.add(new Cartographic(14D, 4D, 0D));
                                                tempCollection$14.add(new Cartographic(14D, 5D, 0D));
                                                tempCollection$14.add(new Cartographic(15D, 5D, 0D));
                                                tempCollection$14.add(new Cartographic(15D, 4D, 0D));
                                                final ArrayList<ArrayList<Cartographic>> tempCollection$12 = new ArrayList<ArrayList<Cartographic>>();
                                                tempCollection$12.add(tempCollection$13);
                                                tempCollection$12.add(tempCollection$14);
                                                ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$12;
                                                interval.writeCartographicDegrees(listOfHoles);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                    } finally {
                                        DisposeHelper.dispose(holesIntervals);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(holes);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polygon);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_3);
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
        {
            PacketCesiumWriter packet = writer.openPacket(outputStream);
            try {
                packet.writeId("examplePolygon");
                {
                    PolygonCesiumWriter polygon = packet.openPolygonProperty();
                    try {
                        {
                            PositionListCesiumWriter positions = polygon.openPositionsProperty();
                            try {
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$15 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$15.add(new Cartographic(0D, 0D, 0D));
                                tempCollection$15.add(new Cartographic(0D, 10D, 0D));
                                tempCollection$15.add(new Cartographic(10D, 10D, 0D));
                                tempCollection$15.add(new Cartographic(10D, 0D, 0D));
                                ArrayList<cesiumlanguagewriter.Cartographic> listOfPositions = tempCollection$15;
                                positions.writeCartographicDegrees(listOfPositions);
                            } finally {
                                DisposeHelper.dispose(positions);
                            }
                        }
                        {
                            PositionListOfListsCesiumWriter holes = polygon.openHolesProperty();
                            try {
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$17 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$17.add(new Cartographic(1D, 1D, 0D));
                                tempCollection$17.add(new Cartographic(1D, 2D, 0D));
                                tempCollection$17.add(new Cartographic(2D, 2D, 0D));
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$18 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$18.add(new Cartographic(4D, 4D, 0D));
                                tempCollection$18.add(new Cartographic(4D, 5D, 0D));
                                tempCollection$18.add(new Cartographic(5D, 5D, 0D));
                                tempCollection$18.add(new Cartographic(5D, 4D, 0D));
                                final ArrayList<ArrayList<Cartographic>> tempCollection$16 = new ArrayList<ArrayList<Cartographic>>();
                                tempCollection$16.add(tempCollection$17);
                                tempCollection$16.add(tempCollection$18);
                                ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$16;
                                holes.writeCartographicDegrees(listOfHoles);
                            } finally {
                                DisposeHelper.dispose(holes);
                            }
                        }
                        {
                            MaterialCesiumWriter material = polygon.openMaterialProperty();
                            try {
                                {
                                    SolidColorMaterialCesiumWriter solidColor = material.openSolidColorProperty();
                                    try {
                                        solidColor.writeColorProperty(Color.RED);
                                    } finally {
                                        DisposeHelper.dispose(solidColor);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(material);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polygon);
                    }
                }
            } finally {
                DisposeHelper.dispose(packet);
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