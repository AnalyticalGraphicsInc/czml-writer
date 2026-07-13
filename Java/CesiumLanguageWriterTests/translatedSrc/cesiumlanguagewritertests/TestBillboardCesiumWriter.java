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
    public final void testImageProperty() {
        final String expectedImage = "image.png";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeImageProperty(expectedImage, CesiumResourceBehavior.LINK_TO);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ImagePropertyName, expectedImage);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testScaleProperty() {
        final double expectedScale = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeScaleProperty(expectedScale);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ScalePropertyName, expectedScale);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testPixelOffsetProperty() {
        Rectangular expectedPixelOffset = new Rectangular(12.5, 3.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writePixelOffsetProperty(expectedPixelOffset);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.PixelOffsetPropertyName, expectedPixelOffset);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testEyeOffsetProperty() {
        Cartesian expectedEyeOffset = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeEyeOffsetProperty(expectedEyeOffset);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.EyeOffsetPropertyName, expectedEyeOffset);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testHorizontalOriginProperty() {
        final CesiumHorizontalOrigin expectedHorizontalOrigin = CesiumHorizontalOrigin.CENTER;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeHorizontalOriginProperty(expectedHorizontalOrigin);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.HorizontalOriginPropertyName, expectedHorizontalOrigin);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testVerticalOriginProperty() {
        final CesiumVerticalOrigin expectedVerticalOrigin = CesiumVerticalOrigin.CENTER;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeVerticalOriginProperty(expectedVerticalOrigin);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.VerticalOriginPropertyName, expectedVerticalOrigin);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testHeightReferenceProperty() {
        final CesiumHeightReference expectedHeightReference = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expectedHeightReference);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.HeightReferencePropertyName, expectedHeightReference);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testColorProperty() {
        Color expectedColor = ColorHelper.fromArgb(0, 255, 0, 255);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeColorProperty(expectedColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ColorPropertyName, expectedColor);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testRotationProperty() {
        final double expectedRotation = 1.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeRotationProperty(expectedRotation);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.RotationPropertyName, expectedRotation);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testAlignedAxisProperty() {
        UnitCartesian expectedAlignedAxis = UnitCartesian.getUnitX();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeAlignedAxisProperty(expectedAlignedAxis);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.AlignedAxisPropertyName, expectedAlignedAxis);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testSizeInMetersProperty() {
        final boolean expectedSizeInMeters = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeSizeInMetersProperty(expectedSizeInMeters);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.SizeInMetersPropertyName, expectedSizeInMeters);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testWidthProperty() {
        final double expectedWidth = 12.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeWidthProperty(expectedWidth);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.WidthPropertyName, expectedWidth);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testHeightProperty() {
        final double expectedHeight = 34.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeHeightProperty(expectedHeight);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.HeightPropertyName, expectedHeight);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testTranslucencyByDistanceProperty() {
        NearFarScalar expectedTranslucencyByDistance = new NearFarScalar(100.0, 1.0, 200.0, 0.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeTranslucencyByDistanceProperty(expectedTranslucencyByDistance);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucencyByDistance);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testPixelOffsetScaleByDistanceProperty() {
        NearFarScalar expectedPixelOffsetScaleByDistance = new NearFarScalar(10.0, 1.0, 20.0, 2.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writePixelOffsetScaleByDistanceProperty(expectedPixelOffsetScaleByDistance);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.PixelOffsetScaleByDistancePropertyName, expectedPixelOffsetScaleByDistance);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testImageSubRegionProperty() {
        BoundingRectangle expectedImageSubRegion = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeImageSubRegionProperty(expectedImageSubRegion);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ImageSubRegionPropertyName, expectedImageSubRegion);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testDistanceDisplayConditionProperty() {
        Bounds expectedDistanceDisplayCondition = new Bounds(10.0, 20.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expectedDistanceDisplayCondition);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.DistanceDisplayConditionPropertyName, expectedDistanceDisplayCondition);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testDisableDepthTestDistanceProperty() {
        final double expectedDisableDepthTestDistance = 1234.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeDisableDepthTestDistanceProperty(expectedDisableDepthTestDistance);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.DisableDepthTestDistancePropertyName, expectedDisableDepthTestDistance);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
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
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ShowPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testScaleByDistanceProperty() {
        NearFarScalar expectedScaleByDistance = new NearFarScalar(100.5, 1.5, 200.5, 2.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(billboard.openInterval())) {
                    final BillboardCesiumWriter interval = using$2.resource;
                    interval.writeScaleByDistanceProperty(expectedScaleByDistance);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ScaleByDistancePropertyName, expectedScaleByDistance);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testScaleByDistancePropertySamples() {
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
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, "delete", true);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.AlignedAxisPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
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
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, "delete", true);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ScalePropertyName, tempCollection$1);
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