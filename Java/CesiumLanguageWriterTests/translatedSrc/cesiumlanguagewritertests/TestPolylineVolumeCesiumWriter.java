package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
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
public class TestPolylineVolumeCesiumWriter extends TestCesiumPropertyWriter<PolylineVolumeCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PolylineVolumeCesiumWriter polylineVolume = getPacket().openPolylineVolumeProperty();
                    try {
                        {
                            PolylineVolumeCesiumWriter interval = polylineVolume.openInterval();
                            try {
                                interval.writeShowProperty(expectedShow);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polylineVolume);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineVolumeCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, tempCollection$0);
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
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PolylineVolumeCesiumWriter polylineVolume = getPacket().openPolylineVolumeProperty();
                    try {
                        {
                            BooleanCesiumWriter show = polylineVolume.openShowProperty();
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
                        DisposeHelper.dispose(polylineVolume);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
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
        MapHelper.add(tempCollection$0, PolylineVolumeCesiumWriter.ShowPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, tempCollection$0);
    }

    @Test
    public final void testShape() {
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PolylineVolumeCesiumWriter polylineVolume = getPacket().openPolylineVolumeProperty();
                    try {
                        final ArrayList<cesiumlanguagewriter.Rectangular> tempCollection$0 = new ArrayList<cesiumlanguagewriter.Rectangular>();
                        tempCollection$0.add(new Rectangular(-5D, -5D));
                        tempCollection$0.add(new Rectangular(6D, -6D));
                        tempCollection$0.add(new Rectangular(7D, 7D));
                        tempCollection$0.add(new Rectangular(-8D, 8D));
                        ArrayList<cesiumlanguagewriter.Rectangular> shape = tempCollection$0;
                        polylineVolume.writeShapeProperty(shape);
                    } finally {
                        DisposeHelper.dispose(polylineVolume);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        Assert.assertEquals("{\"polylineVolume\":{\"shape\":{\"cartesian2\":[-5,-5,6,-6,7,7,-8,8]}}}", getStringWriter().toString());
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expectedBounds = new Bounds(10D, 1234D);
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PolylineVolumeCesiumWriter polylineVolume = getPacket().openPolylineVolumeProperty();
                    try {
                        {
                            PolylineVolumeCesiumWriter interval = polylineVolume.openInterval();
                            try {
                                interval.writeDistanceDisplayConditionProperty(expectedBounds);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polylineVolume);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineVolumeCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds);
        assertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, tempCollection$0);
    }

    /**
    * Create the example CZML file included in the Cesium Sandcastle.
    */
    @Test
    public final void testExample() {
        StringWriter stringWriter = new StringWriter();
        final CesiumOutputStream tempObj$0 = new CesiumOutputStream(stringWriter);
        tempObj$0.setPrettyFormatting(true);
        CesiumOutputStream outputStream = tempObj$0;
        CesiumStreamWriter writer = new CesiumStreamWriter();
        outputStream.writeStartSequence();
        {
            PacketCesiumWriter packet = writer.openPacket(outputStream);
            try {
                packet.writeId("document");
                packet.writeName("CZML Geometries: Polyline Volume");
                packet.writeVersion("1.0");
            } finally {
                DisposeHelper.dispose(packet);
            }
        }
        {
            PacketCesiumWriter packet = writer.openPacket(outputStream);
            try {
                packet.writeId("greenBox");
                packet.writeName("Green box with beveled corners and outline");
                {
                    PolylineVolumeCesiumWriter polylineVolume = packet.openPolylineVolumeProperty();
                    try {
                        {
                            PositionListCesiumWriter positions = polylineVolume.openPositionsProperty();
                            try {
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$0 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$0.add(new Cartographic(-90.0, 32.0, 0D));
                                tempCollection$0.add(new Cartographic(-90.0, 36.0, 100000D));
                                tempCollection$0.add(new Cartographic(-94.0, 36.0, 0D));
                                positions.writeCartographicDegrees(tempCollection$0);
                            } finally {
                                DisposeHelper.dispose(positions);
                            }
                        }
                        {
                            ShapeCesiumWriter shape = polylineVolume.openShapeProperty();
                            try {
                                final ArrayList<cesiumlanguagewriter.Rectangular> tempCollection$1 = new ArrayList<cesiumlanguagewriter.Rectangular>();
                                tempCollection$1.add(new Rectangular(-50000D, -50000D));
                                tempCollection$1.add(new Rectangular(50000D, -50000D));
                                tempCollection$1.add(new Rectangular(50000D, 50000D));
                                tempCollection$1.add(new Rectangular(-50000D, 50000D));
                                shape.writeCartesian2(tempCollection$1);
                            } finally {
                                DisposeHelper.dispose(shape);
                            }
                        }
                        polylineVolume.writeCornerTypeProperty(CesiumCornerType.BEVELED);
                        {
                            MaterialCesiumWriter material = polylineVolume.openMaterialProperty();
                            try {
                                {
                                    SolidColorMaterialCesiumWriter solidColor = material.openSolidColorProperty();
                                    try {
                                        solidColor.writeColorProperty(ColorHelper.fromArgb(128, ColorHelper.LIME));
                                    } finally {
                                        DisposeHelper.dispose(solidColor);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(material);
                            }
                        }
                        polylineVolume.writeOutlineProperty(true);
                        polylineVolume.writeOutlineColorProperty(Color.BLACK);
                    } finally {
                        DisposeHelper.dispose(polylineVolume);
                    }
                }
            } finally {
                DisposeHelper.dispose(packet);
            }
        }
        {
            PacketCesiumWriter packet = writer.openPacket(outputStream);
            try {
                packet.writeId("blueStar");
                packet.writeName("Blue star with mitered corners and outline");
                {
                    PolylineVolumeCesiumWriter polylineVolume = packet.openPolylineVolumeProperty();
                    try {
                        {
                            PositionListCesiumWriter positions = polylineVolume.openPositionsProperty();
                            try {
                                final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$2 = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                tempCollection$2.add(new Cartographic(-95.0, 32.0, 0D));
                                tempCollection$2.add(new Cartographic(-95.0, 36.0, 100000D));
                                tempCollection$2.add(new Cartographic(-99.0, 36.0, 200000D));
                                positions.writeCartographicDegrees(tempCollection$2);
                            } finally {
                                DisposeHelper.dispose(positions);
                            }
                        }
                        {
                            ShapeCesiumWriter shape = polylineVolume.openShapeProperty();
                            try {
                                final int arms = 7;
                                final double rOuter = 70000.0;
                                final double rInner = 50000.0;
                                final double angle = Math.PI / arms;
                                ArrayList<cesiumlanguagewriter.Rectangular> vertices = new ArrayList<cesiumlanguagewriter.Rectangular>();
                                for (int i = 0; i < 2 * arms; i++) {
                                    double r = i % 2 == 0 ? rOuter : rInner;
                                    vertices.add(new Rectangular(Math.cos(i * angle) * r, Math.sin(i * angle) * r));
                                }
                                shape.writeCartesian2(vertices);
                            } finally {
                                DisposeHelper.dispose(shape);
                            }
                        }
                        polylineVolume.writeCornerTypeProperty(CesiumCornerType.MITERED);
                        {
                            MaterialCesiumWriter material = polylineVolume.openMaterialProperty();
                            try {
                                {
                                    SolidColorMaterialCesiumWriter solidColor = material.openSolidColorProperty();
                                    try {
                                        solidColor.writeColorProperty(Color.BLUE);
                                    } finally {
                                        DisposeHelper.dispose(solidColor);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(material);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polylineVolume);
                    }
                }
            } finally {
                DisposeHelper.dispose(packet);
            }
        }
        outputStream.writeEndSequence();
        ConsoleHelper.writeLine(stringWriter.toString());
    }

    @Override
    protected CesiumPropertyWriter<PolylineVolumeCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineVolumeCesiumWriter(propertyName);
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