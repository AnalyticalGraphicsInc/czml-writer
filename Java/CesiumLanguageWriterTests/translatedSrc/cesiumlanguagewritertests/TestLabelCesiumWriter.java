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
public class TestLabelCesiumWriter extends TestCesiumPropertyWriter<LabelCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testFont() {
        final String expected = "30px Helvetica";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeFontProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.FontPropertyName, expected);
    }

    @Test
    public final void testStyle() {
        final CesiumLabelStyle expected = CesiumLabelStyle.FILL_AND_OUTLINE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeStyleProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.StylePropertyName, expected);
    }

    @Test
    public final void testScale() {
        final double expected = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeScaleProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.ScalePropertyName, expected);
    }

    @Test
    public final void testPixelOffset() {
        Rectangular expected = new Rectangular(12.5, 3.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writePixelOffsetProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.PixelOffsetPropertyName, expected);
    }

    @Test
    public final void testEyeOffset() {
        Cartesian expected = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeEyeOffsetProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.EyeOffsetPropertyName, expected);
    }

    @Test
    public final void testHorizontalOrigin() {
        final CesiumHorizontalOrigin expected = CesiumHorizontalOrigin.CENTER;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeHorizontalOriginProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.HorizontalOriginPropertyName, expected);
    }

    @Test
    public final void testVerticalOrigin() {
        final CesiumVerticalOrigin expected = CesiumVerticalOrigin.CENTER;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeVerticalOriginProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.VerticalOriginPropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testFillColor() {
        Color expected = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeFillColorProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.FillColorPropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.GREEN;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testPixelOffsetScaleByDistance() {
        NearFarScalar expected = new NearFarScalar(10.0, 1.0, 20.0, 2.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writePixelOffsetScaleByDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.PixelOffsetScaleByDistancePropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(10.0, 20.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testDisableDepthTestDistance() {
        final double expected = 1234.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeDisableDepthTestDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.DisableDepthTestDistancePropertyName, expected);
    }

    @Test
    public final void testScaleByDistance() {
        NearFarScalar expected = new NearFarScalar(100.5, 1.5, 200.5, 2.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeScaleByDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.ScaleByDistancePropertyName, expected);
    }

    @Test
    public final void testText() {
        final String expected = "asdf";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeTextProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.TextPropertyName, expected);
    }

    @Test
    public final void testTextInterval() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0.0).toJulianDate();
        JulianDate interval1Start = startDate;
        JulianDate interval1Stop = startDate.addSeconds(1.0);
        JulianDate interval2Start = interval1Stop;
        JulianDate interval2Stop = startDate.addSeconds(2.0);
        JulianDate interval3Start = interval2Stop;
        JulianDate interval3Stop = stopDate;
        final String interval1Value = "A";
        final String interval2Value = "B";
        final String interval3Value = "C";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<StringCesiumWriter> using$2 = new Using<StringCesiumWriter>(label.openTextProperty())) {
                    final StringCesiumWriter text = using$2.resource;
                    try (Using<CesiumIntervalListWriter<StringCesiumWriter>> using$3 = new Using<CesiumIntervalListWriter<StringCesiumWriter>>(text.openMultipleIntervals())) {
                        final CesiumIntervalListWriter<StringCesiumWriter> textIntervals = using$3.resource;
                        try (Using<StringCesiumWriter> using$4 = new Using<StringCesiumWriter>(textIntervals.openInterval(interval1Start, interval1Stop))) {
                            final StringCesiumWriter interval = using$4.resource;
                            interval.writeString(interval1Value);
                        }
                        try (Using<StringCesiumWriter> using$5 = new Using<StringCesiumWriter>(textIntervals.openInterval(interval2Start, interval2Stop))) {
                            final StringCesiumWriter interval = using$5.resource;
                            interval.writeString(interval2Value);
                        }
                        try (Using<StringCesiumWriter> using$6 = new Using<StringCesiumWriter>(textIntervals.openInterval(interval3Start, interval3Stop))) {
                            final StringCesiumWriter interval = using$6.resource;
                            interval.writeString(interval3Value);
                        }
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, "interval", CesiumFormattingHelper.toIso8601Interval(interval1Start, interval1Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$1, StringCesiumWriter.StringPropertyName, interval1Value);
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, "interval", CesiumFormattingHelper.toIso8601Interval(interval2Start, interval2Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$2, StringCesiumWriter.StringPropertyName, interval2Value);
        final Map<String, Object> tempCollection$3 = MapHelper.create();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(interval3Start, interval3Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$3, StringCesiumWriter.StringPropertyName, interval3Value);
        final ArrayList<Map<String, Object>> tempCollection$0 = new ArrayList<Map<String, Object>>();
        tempCollection$0.add(tempCollection$1);
        tempCollection$0.add(tempCollection$2);
        tempCollection$0.add(tempCollection$3);
        assertPropertyJson(LabelCesiumWriter.TextPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowBackground() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeShowBackgroundProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.ShowBackgroundPropertyName, expected);
    }

    @Test
    public final void testBackgroundColor() {
        Color expected = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeBackgroundColorProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.BackgroundColorPropertyName, expected);
    }

    @Test
    public final void testBackgroundPadding() {
        Rectangular expected = new Rectangular(3.0, 4.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeBackgroundPaddingProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.BackgroundPaddingPropertyName, expected);
    }

    @Test
    public final void testTranslucencyByDistance() {
        NearFarScalar expected = new NearFarScalar(100.0, 1.0, 200.0, 2.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeTranslucencyByDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(LabelCesiumWriter.TranslucencyByDistancePropertyName, expected);
    }

    @Test
    public final void testTranslucencyByDistanceSamples() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(packet.openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    try (Using<NearFarScalarCesiumWriter> using$3 = new Using<NearFarScalarCesiumWriter>(interval.openTranslucencyByDistanceProperty())) {
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
        AssertHelper.assertEquals("{\"label\":{\"translucencyByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", getStringWriter().toString());
    }

    private final void assertPropertyJson(String propertyName, Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<LabelCesiumWriter> createPropertyWriter(String propertyName) {
        return new LabelCesiumWriter(propertyName);
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