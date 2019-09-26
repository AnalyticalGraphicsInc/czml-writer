package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.junit.Assert;
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
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    PolygonCesiumWriter polygon = getPacket().openPolygonProperty();
                    try {
                        {
                            PolygonCesiumWriter interval = polygon.openInterval();
                            try {
                                interval.writeShowProperty(true);
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
        Assert.assertEquals("{\"polygon\":{\"show\":true}}", getStringWriter().toString());
    }

    @Test
    public final void testShowPropertyInterval() {
        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        JulianDate stopDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 1, 0D));
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
                                            BooleanCesiumWriter interval = showIntervals.openInterval(startDate, startDate.addSeconds(1D));
                                            try {
                                                interval.writeBoolean(true);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            BooleanCesiumWriter interval = showIntervals.openInterval(startDate.addSeconds(1D), startDate.addSeconds(2D));
                                            try {
                                                interval.writeBoolean(false);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            BooleanCesiumWriter interval = showIntervals.openInterval(startDate.addSeconds(2D), stopDate);
                                            try {
                                                interval.writeBoolean(true);
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
        String interval1String = CesiumFormattingHelper.toIso8601Interval(startDate, startDate.addSeconds(1D), Iso8601Format.COMPACT);
        String interval2String = CesiumFormattingHelper.toIso8601Interval(startDate.addSeconds(1D), startDate.addSeconds(2D), Iso8601Format.COMPACT);
        String interval3String = CesiumFormattingHelper.toIso8601Interval(startDate.addSeconds(2D), stopDate, Iso8601Format.COMPACT);
        Assert.assertEquals("{\"polygon\":{\"show\":[{\"interval\":\"" + interval1String + "\",\"boolean\":true}," + "{\"interval\":\"" + interval2String + "\",\"boolean\":false},"
                + "{\"interval\":\"" + interval3String + "\",\"boolean\":true}" + "]}}", getStringWriter().toString());
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
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$1 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$1.add(new Cartographic(1D, 1D, 0D));
                                tempCollection$1.add(new Cartographic(1D, 2D, 0D));
                                tempCollection$1.add(new Cartographic(2D, 2D, 0D));
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$2 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$2.add(new Cartographic(4D, 4D, 0D));
                                tempCollection$2.add(new Cartographic(4D, 5D, 0D));
                                tempCollection$2.add(new Cartographic(5D, 5D, 0D));
                                tempCollection$2.add(new Cartographic(5D, 4D, 0D));
                                final ArrayList<ArrayList<Cartographic>> tempCollection$0 = new ArrayList<ArrayList<Cartographic>>();
                                tempCollection$0.add(tempCollection$1);
                                tempCollection$0.add(tempCollection$2);
                                ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$0;
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
        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        JulianDate stopDate = new JulianDate(new GregorianDate(2012, 4, 2, 13, 0, 0D));
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
                                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$4 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                                tempCollection$4.add(new Cartographic(1D, 1D, 0D));
                                                tempCollection$4.add(new Cartographic(1D, 2D, 0D));
                                                tempCollection$4.add(new Cartographic(2D, 2D, 0D));
                                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$5 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                                tempCollection$5.add(new Cartographic(4D, 4D, 0D));
                                                tempCollection$5.add(new Cartographic(4D, 5D, 0D));
                                                tempCollection$5.add(new Cartographic(5D, 5D, 0D));
                                                tempCollection$5.add(new Cartographic(5D, 4D, 0D));
                                                final ArrayList<ArrayList<Cartographic>> tempCollection$3 = new ArrayList<ArrayList<Cartographic>>();
                                                tempCollection$3.add(tempCollection$4);
                                                tempCollection$3.add(tempCollection$5);
                                                ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$3;
                                                interval.writeCartographicDegrees(listOfHoles);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            PositionListOfListsCesiumWriter interval = holesIntervals.openInterval(startDate.addSeconds(60 * 30), stopDate);
                                            try {
                                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$7 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                                tempCollection$7.add(new Cartographic(11D, 1D, 0D));
                                                tempCollection$7.add(new Cartographic(11D, 2D, 0D));
                                                tempCollection$7.add(new Cartographic(12D, 2D, 0D));
                                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$8 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                                tempCollection$8.add(new Cartographic(14D, 4D, 0D));
                                                tempCollection$8.add(new Cartographic(14D, 5D, 0D));
                                                tempCollection$8.add(new Cartographic(15D, 5D, 0D));
                                                tempCollection$8.add(new Cartographic(15D, 4D, 0D));
                                                final ArrayList<ArrayList<Cartographic>> tempCollection$6 = new ArrayList<ArrayList<Cartographic>>();
                                                tempCollection$6.add(tempCollection$7);
                                                tempCollection$6.add(tempCollection$8);
                                                ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$6;
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
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$9 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$9.add(new Cartographic(0D, 0D, 0D));
                                tempCollection$9.add(new Cartographic(0D, 10D, 0D));
                                tempCollection$9.add(new Cartographic(10D, 10D, 0D));
                                tempCollection$9.add(new Cartographic(10D, 0D, 0D));
                                ArrayList<cesiumlanguagewriter.Cartographic> listOfPositions = tempCollection$9;
                                positions.writeCartographicDegrees(listOfPositions);
                            } finally {
                                DisposeHelper.dispose(positions);
                            }
                        }
                        {
                            PositionListOfListsCesiumWriter holes = polygon.openHolesProperty();
                            try {
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$11 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$11.add(new Cartographic(1D, 1D, 0D));
                                tempCollection$11.add(new Cartographic(1D, 2D, 0D));
                                tempCollection$11.add(new Cartographic(2D, 2D, 0D));
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$12 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$12.add(new Cartographic(4D, 4D, 0D));
                                tempCollection$12.add(new Cartographic(4D, 5D, 0D));
                                tempCollection$12.add(new Cartographic(5D, 5D, 0D));
                                tempCollection$12.add(new Cartographic(5D, 4D, 0D));
                                final ArrayList<ArrayList<Cartographic>> tempCollection$10 = new ArrayList<ArrayList<Cartographic>>();
                                tempCollection$10.add(tempCollection$11);
                                tempCollection$10.add(tempCollection$12);
                                ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$10;
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
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}