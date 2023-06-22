package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
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
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testTextProperty() {
        final String expectedText = "asdf";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeTextProperty(expectedText);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.TextPropertyName, expectedText);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testTextPropertyInterval() {
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
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
                final LabelCesiumWriter billboard = using$1.resource;
                try (Using<StringCesiumWriter> using$2 = new Using<StringCesiumWriter>(billboard.openTextProperty())) {
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
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, "interval", CesiumFormattingHelper.toIso8601Interval(interval1Start, interval1Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$2, StringCesiumWriter.StringPropertyName, interval1Value);
        final Map<String, Object> tempCollection$3 = MapHelper.create();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(interval2Start, interval2Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$3, StringCesiumWriter.StringPropertyName, interval2Value);
        final Map<String, Object> tempCollection$4 = MapHelper.create();
        MapHelper.add(tempCollection$4, "interval", CesiumFormattingHelper.toIso8601Interval(interval3Start, interval3Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$4, StringCesiumWriter.StringPropertyName, interval3Value);
        final ArrayList<Map<String, Object>> tempCollection$1 = new ArrayList<Map<String, Object>>();
        tempCollection$1.add(tempCollection$2);
        tempCollection$1.add(tempCollection$3);
        tempCollection$1.add(tempCollection$4);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.TextPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowBackgroundProperty() {
        final boolean expectedShowBackground = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeShowBackgroundProperty(expectedShowBackground);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.ShowBackgroundPropertyName, expectedShowBackground);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testBackgroundColorProperty() {
        Color expectedBackgroundColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeBackgroundColorProperty(expectedBackgroundColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.BackgroundColorPropertyName, expectedBackgroundColor);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testBackgroundPaddingProperty() {
        Rectangular expectedBackgroundPadding = new Rectangular(3.0, 4.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeBackgroundPaddingProperty(expectedBackgroundPadding);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.BackgroundPaddingPropertyName, expectedBackgroundPadding);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testTranslucencyByDistanceProperty() {
        NearFarScalar expectedTranslucencyByDistance = new NearFarScalar(100.0, 1.0, 200.0, 2.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeTranslucencyByDistanceProperty(expectedTranslucencyByDistance);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucencyByDistance);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testTranslucencyByDistancePropertySamples() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
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