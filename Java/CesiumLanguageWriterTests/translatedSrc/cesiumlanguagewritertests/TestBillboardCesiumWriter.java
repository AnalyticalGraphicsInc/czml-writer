package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.ColorHelper;
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
public class TestBillboardCesiumWriter extends TestCesiumPropertyWriter<BillboardCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.ShowPropertyName, expected);
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
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BooleanCesiumWriter> using$2 = new Using<BooleanCesiumWriter>(billboard.openShowProperty())) {
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
        assertPropertyJson(BillboardCesiumWriter.ShowPropertyName, tempCollection$0);
    }

    @Test
    public final void testImage() {
        final String expected = "image.png";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeImageProperty(expected, CesiumResourceBehavior.LINK_TO);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.ImagePropertyName, expected);
    }

    @Test
    public final void testScale() {
        final double expected = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeScaleProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.ScalePropertyName, expected);
    }

    @Test
    public final void testPixelOffset() {
        Rectangular expected = new Rectangular(12.5, 3.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writePixelOffsetProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.PixelOffsetPropertyName, expected);
    }

    @Test
    public final void testEyeOffset() {
        Cartesian expected = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeEyeOffsetProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.EyeOffsetPropertyName, expected);
    }

    @Test
    public final void testHorizontalOrigin() {
        final CesiumHorizontalOrigin expected = CesiumHorizontalOrigin.CENTER;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeHorizontalOriginProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.HorizontalOriginPropertyName, expected);
    }

    @Test
    public final void testVerticalOrigin() {
        final CesiumVerticalOrigin expected = CesiumVerticalOrigin.CENTER;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeVerticalOriginProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.VerticalOriginPropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testColor() {
        Color expected = ColorHelper.fromArgb(0, 255, 0, 255);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeColorProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.ColorPropertyName, expected);
    }

    @Test
    public final void testRotation() {
        final double expected = 1.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeRotationProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.RotationPropertyName, expected);
    }

    @Test
    public final void testAlignedAxis() {
        UnitCartesian expected = UnitCartesian.getUnitX();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeAlignedAxisProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.AlignedAxisPropertyName, expected);
    }

    @Test
    public final void testSizeInMeters() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeSizeInMetersProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.SizeInMetersPropertyName, expected);
    }

    @Test
    public final void testWidth() {
        final double expected = 12.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.WidthPropertyName, expected);
    }

    @Test
    public final void testHeight() {
        final double expected = 34.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeHeightProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.HeightPropertyName, expected);
    }

    @Test
    public final void testTranslucencyByDistance() {
        NearFarScalar expected = new NearFarScalar(100.0, 1.0, 200.0, 0.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeTranslucencyByDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.TranslucencyByDistancePropertyName, expected);
    }

    @Test
    public final void testPixelOffsetScaleByDistance() {
        NearFarScalar expected = new NearFarScalar(10.0, 1.0, 20.0, 2.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writePixelOffsetScaleByDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.PixelOffsetScaleByDistancePropertyName, expected);
    }

    @Test
    public final void testImageSubRegion() {
        BoundingRectangle expected = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeImageSubRegionProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.ImageSubRegionPropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(10.0, 20.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testDisableDepthTestDistance() {
        final double expected = 1234.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeDisableDepthTestDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.DisableDepthTestDistancePropertyName, expected);
    }

    @Test
    public final void testScaleByDistance() {
        NearFarScalar expected = new NearFarScalar(100.5, 1.5, 200.5, 2.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeScaleByDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(BillboardCesiumWriter.ScaleByDistancePropertyName, expected);
    }

    @Test
    public final void testScaleByDistanceSamples() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    try (Using<NearFarScalarCesiumWriter> using$3 = new Using<NearFarScalarCesiumWriter>(interval.openScaleByDistanceProperty())) {
                        final NearFarScalarCesiumWriter scaleByDistance = using$3.resource;
                        ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                        ArrayList<NearFarScalar> values = new ArrayList<NearFarScalar>();
                        dates.add(epoch);
                        values.add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
                        dates.add(epoch.addSeconds(60.0));
                        values.add(new NearFarScalar(200.0, 1.0, 300.0, 2.0));
                        scaleByDistance.writeNearFarScalar(dates, values);
                    }
                }
            }
        }
        AssertHelper.assertEquals("{\"billboard\":{\"scaleByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", getStringWriter().toString());
    }

    @Test
    public final void testDeleteAlignedAxis() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<AlignedAxisCesiumWriter> using$2 = new Using<AlignedAxisCesiumWriter>(billboard.openAlignedAxisProperty())) {
                    final AlignedAxisCesiumWriter alignedAxis = using$2.resource;
                    alignedAxis.writeDelete(true);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "delete", true);
        assertPropertyJson(BillboardCesiumWriter.AlignedAxisPropertyName, tempCollection$0);
    }

    @Test
    public final void testDeleteScale() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<DoubleCesiumWriter> using$2 = new Using<DoubleCesiumWriter>(billboard.openScaleProperty())) {
                    final DoubleCesiumWriter scale = using$2.resource;
                    scale.writeDelete(true);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, "delete", true);
        assertPropertyJson(BillboardCesiumWriter.ScalePropertyName, tempCollection$0);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<BillboardCesiumWriter> createPropertyWriter(String propertyName) {
        return new BillboardCesiumWriter(propertyName);
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