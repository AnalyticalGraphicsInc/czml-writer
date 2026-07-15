package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.PathHelper;
import agi.foundation.compatibility.StreamWriterHelper;
import agi.foundation.compatibility.TestContext;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.OutputStreamWriter;
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
public class TestPolygonCesiumWriter extends TestCesiumPropertyWriter<PolygonCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testPositions() {
        final PositionList tempCollection$0 = new PositionList();
        tempCollection$0.add(new Cartesian(1.0, 2.0, 3.0));
        tempCollection$0.add(new Cartesian(4.0, 5.0, 6.0));
        PositionList expected = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writePositionsProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.PositionsPropertyName, expected);
    }

    @Test
    public final void testShowInterval() {
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
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
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
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, "interval", CesiumFormattingHelper.toIso8601Interval(interval1Start, interval1Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$1, BooleanCesiumWriter.BooleanPropertyName, interval1Value);
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, "interval", CesiumFormattingHelper.toIso8601Interval(interval2Start, interval2Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$2, BooleanCesiumWriter.BooleanPropertyName, interval2Value);
        final Map<String, Object> tempCollection$3 = MapHelper.create();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(interval3Start, interval3Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$3, BooleanCesiumWriter.BooleanPropertyName, interval3Value);
        final ArrayList<Map<String, Object>> tempCollection$0 = new ArrayList<Map<String, Object>>();
        tempCollection$0.add(tempCollection$1);
        tempCollection$0.add(tempCollection$2);
        tempCollection$0.add(tempCollection$3);
        assertPropertyJson(PolygonCesiumWriter.ShowPropertyName, tempCollection$0);
    }

    @Test
    public final void testHoles() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PositionListOfListsCesiumWriter> using$2 = new Using<PositionListOfListsCesiumWriter>(polygon.openHolesProperty())) {
                    final PositionListOfListsCesiumWriter holes = using$2.resource;
                    final ArrayList<Cartographic> tempCollection$1 = new ArrayList<Cartographic>();
                    tempCollection$1.add(new Cartographic(1.0, 1.0, 0.0));
                    tempCollection$1.add(new Cartographic(1.0, 2.0, 0.0));
                    tempCollection$1.add(new Cartographic(2.0, 2.0, 0.0));
                    final ArrayList<Cartographic> tempCollection$2 = new ArrayList<Cartographic>();
                    tempCollection$2.add(new Cartographic(4.0, 4.0, 0.0));
                    tempCollection$2.add(new Cartographic(4.0, 5.0, 0.0));
                    tempCollection$2.add(new Cartographic(5.0, 5.0, 0.0));
                    tempCollection$2.add(new Cartographic(5.0, 4.0, 0.0));
                    final ArrayList<ArrayList<Cartographic>> tempCollection$0 = new ArrayList<ArrayList<Cartographic>>();
                    tempCollection$0.add(tempCollection$1);
                    tempCollection$0.add(tempCollection$2);
                    ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$0;
                    holes.writeCartographicDegrees(listOfHoles);
                }
            }
        }
        AssertHelper.assertEquals("{\"polygon\":{\"holes\":{\"cartographicDegrees\":[[1,1,0,1,2,0,2,2,0],[4,4,0,4,5,0,5,5,0,5,4,0]]}}}", getStringWriter().toString());
    }

    @Test
    public final void testHolesIntervals() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate stopDate = new GregorianDate(2012, 4, 2, 13, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PositionListOfListsCesiumWriter> using$2 = new Using<PositionListOfListsCesiumWriter>(polygon.openHolesProperty())) {
                    final PositionListOfListsCesiumWriter holes = using$2.resource;
                    try (Using<CesiumIntervalListWriter<PositionListOfListsCesiumWriter>> using$3 = new Using<CesiumIntervalListWriter<PositionListOfListsCesiumWriter>>(
                            holes.openMultipleIntervals())) {
                        final CesiumIntervalListWriter<PositionListOfListsCesiumWriter> holesIntervals = using$3.resource;
                        try (Using<PositionListOfListsCesiumWriter> using$4 = new Using<PositionListOfListsCesiumWriter>(holesIntervals.openInterval(startDate, startDate.addSeconds(60 * 30)))) {
                            final PositionListOfListsCesiumWriter interval = using$4.resource;
                            final ArrayList<Cartographic> tempCollection$1 = new ArrayList<Cartographic>();
                            tempCollection$1.add(new Cartographic(1.0, 1.0, 0.0));
                            tempCollection$1.add(new Cartographic(1.0, 2.0, 0.0));
                            tempCollection$1.add(new Cartographic(2.0, 2.0, 0.0));
                            final ArrayList<Cartographic> tempCollection$2 = new ArrayList<Cartographic>();
                            tempCollection$2.add(new Cartographic(4.0, 4.0, 0.0));
                            tempCollection$2.add(new Cartographic(4.0, 5.0, 0.0));
                            tempCollection$2.add(new Cartographic(5.0, 5.0, 0.0));
                            tempCollection$2.add(new Cartographic(5.0, 4.0, 0.0));
                            final ArrayList<ArrayList<Cartographic>> tempCollection$0 = new ArrayList<ArrayList<Cartographic>>();
                            tempCollection$0.add(tempCollection$1);
                            tempCollection$0.add(tempCollection$2);
                            ArrayList<ArrayList<Cartographic>> listOfHoles = tempCollection$0;
                            interval.writeCartographicDegrees(listOfHoles);
                        }
                        try (Using<PositionListOfListsCesiumWriter> using$5 = new Using<PositionListOfListsCesiumWriter>(holesIntervals.openInterval(startDate.addSeconds(60 * 30), stopDate))) {
                            final PositionListOfListsCesiumWriter interval = using$5.resource;
                            final ArrayList<Cartographic> tempCollection$4 = new ArrayList<Cartographic>();
                            tempCollection$4.add(new Cartographic(11.0, 1.0, 0.0));
                            tempCollection$4.add(new Cartographic(11.0, 2.0, 0.0));
                            tempCollection$4.add(new Cartographic(12.0, 2.0, 0.0));
                            final ArrayList<Cartographic> tempCollection$5 = new ArrayList<Cartographic>();
                            tempCollection$5.add(new Cartographic(14.0, 4.0, 0.0));
                            tempCollection$5.add(new Cartographic(14.0, 5.0, 0.0));
                            tempCollection$5.add(new Cartographic(15.0, 5.0, 0.0));
                            tempCollection$5.add(new Cartographic(15.0, 4.0, 0.0));
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
        AssertHelper.assertEquals("{\"polygon\":{\"holes\":[" + "{\"interval\":\"20120402T12Z/20120402T1230Z\",\"cartographicDegrees\":[[1,1,0,1,2,0,2,2,0],[4,4,0,4,5,0,5,5,0,5,4,0]]},"
                + "{\"interval\":\"20120402T1230Z/20120402T13Z\",\"cartographicDegrees\":[[11,1,0,11,2,0,12,2,0],[14,4,0,14,5,0,15,5,0,15,4,0]]}" + "]}}", getStringWriter().toString());
    }

    @Test
    public final void testFill() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeFillProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.FillPropertyName, expected);
    }

    @Test
    public final void testOutline() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeOutlineProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.OutlinePropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testHeight() {
        final double expected = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.HeightPropertyName, expected);
    }

    @Test
    public final void testExtrudedHeight() {
        final double expected = 20.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.ExtrudedHeightPropertyName, expected);
    }

    @Test
    public final void testStRotation() {
        final double expected = 0.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeStRotationProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.StRotationPropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testExtrudedHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.RELATIVE_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.ExtrudedHeightReferencePropertyName, expected);
    }

    @Test
    public final void testPerPositionHeight() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writePerPositionHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.PerPositionHeightPropertyName, expected);
    }

    @Test
    public final void testCloseTop() {
        final boolean expected = false;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeCloseTopProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.CloseTopPropertyName, expected);
    }

    @Test
    public final void testCloseBottom() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeCloseBottomProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.CloseBottomPropertyName, expected);
    }

    @Test
    public final void testShadows() {
        final CesiumShadowMode expected = CesiumShadowMode.ENABLED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeShadowsProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.ShadowsPropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1234.0, 5678.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testClassificationType() {
        final CesiumClassificationType expected = CesiumClassificationType.TERRAIN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeClassificationTypeProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.ClassificationTypePropertyName, expected);
    }

    @Test
    public final void testArcType() {
        final CesiumArcType expected = CesiumArcType.GEODESIC;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeArcTypeProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.ArcTypePropertyName, expected);
    }

    @Test
    public final void testMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    try (Using<MaterialCesiumWriter> using$3 = new Using<MaterialCesiumWriter>(interval.openMaterialProperty())) {
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
        assertPropertyJson(PolygonCesiumWriter.MaterialPropertyName, tempCollection$0);
    }

    @Test
    public final void testZIndex() {
        final int expected = 5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PolygonCesiumWriter> using$2 = new Using<PolygonCesiumWriter>(polygon.openInterval())) {
                    final PolygonCesiumWriter interval = using$2.resource;
                    interval.writeZIndexProperty(expected);
                }
            }
        }
        assertPropertyJson(PolygonCesiumWriter.ZIndexPropertyName, expected);
    }

    @Test
    public final void writeExample() {
        String outputPath = PathHelper.combine(TestContext.getCurrentContext().getTestDirectory(), "PolygonCesiumWriter.czml");
        try (Using<OutputStreamWriter> using$0 = new Using<OutputStreamWriter>(StreamWriterHelper.create(outputPath))) {
            final OutputStreamWriter streamWriter = using$0.resource;
            writeExample(new CesiumOutputStream(streamWriter, true));
        }
    }

    private static void writeExample(@Nonnull CesiumOutputStream output) {
        CesiumStreamWriter writer = new CesiumStreamWriter();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(writer.openPacket(output))) {
            final PacketCesiumWriter packet = using$0.resource;
            packet.writeId("examplePolygon");
            try (Using<PolygonCesiumWriter> using$1 = new Using<PolygonCesiumWriter>(packet.openPolygonProperty())) {
                final PolygonCesiumWriter polygon = using$1.resource;
                try (Using<PositionListCesiumWriter> using$2 = new Using<PositionListCesiumWriter>(polygon.openPositionsProperty())) {
                    final PositionListCesiumWriter positions = using$2.resource;
                    final ArrayList<Cartographic> tempCollection$0 = new ArrayList<Cartographic>();
                    tempCollection$0.add(new Cartographic(0.0, 0.0, 0.0));
                    tempCollection$0.add(new Cartographic(0.0, 10.0, 0.0));
                    tempCollection$0.add(new Cartographic(10.0, 10.0, 0.0));
                    tempCollection$0.add(new Cartographic(10.0, 0.0, 0.0));
                    ArrayList<Cartographic> listOfPositions = tempCollection$0;
                    positions.writeCartographicDegrees(listOfPositions);
                }
                try (Using<PositionListOfListsCesiumWriter> using$3 = new Using<PositionListOfListsCesiumWriter>(polygon.openHolesProperty())) {
                    final PositionListOfListsCesiumWriter holes = using$3.resource;
                    final ArrayList<Cartographic> tempCollection$2 = new ArrayList<Cartographic>();
                    tempCollection$2.add(new Cartographic(1.0, 1.0, 0.0));
                    tempCollection$2.add(new Cartographic(1.0, 2.0, 0.0));
                    tempCollection$2.add(new Cartographic(2.0, 2.0, 0.0));
                    final ArrayList<Cartographic> tempCollection$3 = new ArrayList<Cartographic>();
                    tempCollection$3.add(new Cartographic(4.0, 4.0, 0.0));
                    tempCollection$3.add(new Cartographic(4.0, 5.0, 0.0));
                    tempCollection$3.add(new Cartographic(5.0, 5.0, 0.0));
                    tempCollection$3.add(new Cartographic(5.0, 4.0, 0.0));
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
    }

    private final void assertPropertyJson(String propertyName, Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.PolygonPropertyName, tempCollection$0);
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