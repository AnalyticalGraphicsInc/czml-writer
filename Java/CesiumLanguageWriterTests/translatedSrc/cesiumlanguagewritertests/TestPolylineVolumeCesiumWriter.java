package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.ColorHelper;
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
public class TestPolylineVolumeCesiumWriter extends TestCesiumPropertyWriter<PolylineVolumeCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineVolumeCesiumWriter> using$1 = new Using<PolylineVolumeCesiumWriter>(getPacket().openPolylineVolumeProperty())) {
                final PolylineVolumeCesiumWriter polylineVolume = using$1.resource;
                try (Using<PolylineVolumeCesiumWriter> using$2 = new Using<PolylineVolumeCesiumWriter>(polylineVolume.openInterval())) {
                    final PolylineVolumeCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineVolumeCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, tempCollection$0);
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
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineVolumeCesiumWriter> using$1 = new Using<PolylineVolumeCesiumWriter>(getPacket().openPolylineVolumeProperty())) {
                final PolylineVolumeCesiumWriter polylineVolume = using$1.resource;
                try (Using<BooleanCesiumWriter> using$2 = new Using<BooleanCesiumWriter>(polylineVolume.openShowProperty())) {
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
        MapHelper.add(tempCollection$0, PolylineVolumeCesiumWriter.ShowPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, tempCollection$0);
    }

    @Test
    public final void testShape() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineVolumeCesiumWriter> using$1 = new Using<PolylineVolumeCesiumWriter>(getPacket().openPolylineVolumeProperty())) {
                final PolylineVolumeCesiumWriter polylineVolume = using$1.resource;
                final ArrayList<Rectangular> tempCollection$0 = new ArrayList<Rectangular>();
                tempCollection$0.add(new Rectangular(-5.0, -5.0));
                tempCollection$0.add(new Rectangular(6.0, -6.0));
                tempCollection$0.add(new Rectangular(7.0, 7.0));
                tempCollection$0.add(new Rectangular(-8.0, 8.0));
                ArrayList<Rectangular> shape = tempCollection$0;
                polylineVolume.writeShapeProperty(shape);
            }
        }
        AssertHelper.assertEquals("{\"polylineVolume\":{\"shape\":{\"cartesian2\":[-5,-5,6,-6,7,7,-8,8]}}}", getStringWriter().toString());
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expectedBounds = new Bounds(10.0, 1234.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineVolumeCesiumWriter> using$1 = new Using<PolylineVolumeCesiumWriter>(getPacket().openPolylineVolumeProperty())) {
                final PolylineVolumeCesiumWriter polylineVolume = using$1.resource;
                try (Using<PolylineVolumeCesiumWriter> using$2 = new Using<PolylineVolumeCesiumWriter>(polylineVolume.openInterval())) {
                    final PolylineVolumeCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expectedBounds);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
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
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(writer.openPacket(outputStream))) {
            final PacketCesiumWriter packet = using$0.resource;
            packet.writeId("document");
            packet.writeName("CZML Geometries: Polyline Volume");
            packet.writeVersion("1.0");
        }
        try (Using<PacketCesiumWriter> using$1 = new Using<PacketCesiumWriter>(writer.openPacket(outputStream))) {
            final PacketCesiumWriter packet = using$1.resource;
            packet.writeId("greenBox");
            packet.writeName("Green box with beveled corners and outline");
            try (Using<PolylineVolumeCesiumWriter> using$2 = new Using<PolylineVolumeCesiumWriter>(packet.openPolylineVolumeProperty())) {
                final PolylineVolumeCesiumWriter polylineVolume = using$2.resource;
                try (Using<PositionListCesiumWriter> using$3 = new Using<PositionListCesiumWriter>(polylineVolume.openPositionsProperty())) {
                    final PositionListCesiumWriter positions = using$3.resource;
                    final ArrayList<Cartographic> tempCollection$0 = new ArrayList<Cartographic>();
                    tempCollection$0.add(new Cartographic(-90.0, 32.0, 0.0));
                    tempCollection$0.add(new Cartographic(-90.0, 36.0, 100000.0));
                    tempCollection$0.add(new Cartographic(-94.0, 36.0, 0.0));
                    positions.writeCartographicDegrees(tempCollection$0);
                }
                try (Using<ShapeCesiumWriter> using$4 = new Using<ShapeCesiumWriter>(polylineVolume.openShapeProperty())) {
                    final ShapeCesiumWriter shape = using$4.resource;
                    final ArrayList<Rectangular> tempCollection$1 = new ArrayList<Rectangular>();
                    tempCollection$1.add(new Rectangular(-50000.0, -50000.0));
                    tempCollection$1.add(new Rectangular(50000.0, -50000.0));
                    tempCollection$1.add(new Rectangular(50000.0, 50000.0));
                    tempCollection$1.add(new Rectangular(-50000.0, 50000.0));
                    shape.writeCartesian2(tempCollection$1);
                }
                polylineVolume.writeCornerTypeProperty(CesiumCornerType.BEVELED);
                try (Using<MaterialCesiumWriter> using$5 = new Using<MaterialCesiumWriter>(polylineVolume.openMaterialProperty())) {
                    final MaterialCesiumWriter material = using$5.resource;
                    try (Using<SolidColorMaterialCesiumWriter> using$6 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                        final SolidColorMaterialCesiumWriter solidColor = using$6.resource;
                        solidColor.writeColorProperty(ColorHelper.fromArgb(128, ColorHelper.LIME));
                    }
                }
                polylineVolume.writeOutlineProperty(true);
                polylineVolume.writeOutlineColorProperty(Color.BLACK);
            }
        }
        try (Using<PacketCesiumWriter> using$7 = new Using<PacketCesiumWriter>(writer.openPacket(outputStream))) {
            final PacketCesiumWriter packet = using$7.resource;
            packet.writeId("blueStar");
            packet.writeName("Blue star with mitered corners and outline");
            try (Using<PolylineVolumeCesiumWriter> using$8 = new Using<PolylineVolumeCesiumWriter>(packet.openPolylineVolumeProperty())) {
                final PolylineVolumeCesiumWriter polylineVolume = using$8.resource;
                try (Using<PositionListCesiumWriter> using$9 = new Using<PositionListCesiumWriter>(polylineVolume.openPositionsProperty())) {
                    final PositionListCesiumWriter positions = using$9.resource;
                    final ArrayList<Cartographic> tempCollection$2 = new ArrayList<Cartographic>();
                    tempCollection$2.add(new Cartographic(-95.0, 32.0, 0.0));
                    tempCollection$2.add(new Cartographic(-95.0, 36.0, 100000.0));
                    tempCollection$2.add(new Cartographic(-99.0, 36.0, 200000.0));
                    positions.writeCartographicDegrees(tempCollection$2);
                }
                try (Using<ShapeCesiumWriter> using$10 = new Using<ShapeCesiumWriter>(polylineVolume.openShapeProperty())) {
                    final ShapeCesiumWriter shape = using$10.resource;
                    final int arms = 7;
                    final double rOuter = 70000.0;
                    final double rInner = 50000.0;
                    final double angle = Math.PI / arms;
                    ArrayList<Rectangular> vertices = new ArrayList<Rectangular>();
                    for (int i = 0; i < 2 * arms; i++) {
                        double r = i % 2 == 0 ? rOuter : rInner;
                        vertices.add(new Rectangular(Math.cos(i * angle) * r, Math.sin(i * angle) * r));
                    }
                    shape.writeCartesian2(vertices);
                }
                polylineVolume.writeCornerTypeProperty(CesiumCornerType.MITERED);
                try (Using<MaterialCesiumWriter> using$11 = new Using<MaterialCesiumWriter>(polylineVolume.openMaterialProperty())) {
                    final MaterialCesiumWriter material = using$11.resource;
                    try (Using<SolidColorMaterialCesiumWriter> using$12 = new Using<SolidColorMaterialCesiumWriter>(material.openSolidColorProperty())) {
                        final SolidColorMaterialCesiumWriter solidColor = using$12.resource;
                        solidColor.writeColorProperty(Color.BLUE);
                    }
                }
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