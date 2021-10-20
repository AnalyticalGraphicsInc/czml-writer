package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
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
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
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
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.TextPropertyName, expectedText);
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
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
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
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.BackgroundColorPropertyName, expectedBackgroundColor);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testBackgroundPaddingProperty() {
        Rectangular expectedBackgroundPadding = new Rectangular(3D, 4D);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<LabelCesiumWriter> using$1 = new Using<LabelCesiumWriter>(getPacket().openLabelProperty())) {
                final LabelCesiumWriter label = using$1.resource;
                try (Using<LabelCesiumWriter> using$2 = new Using<LabelCesiumWriter>(label.openInterval())) {
                    final LabelCesiumWriter interval = using$2.resource;
                    interval.writeBackgroundPaddingProperty(expectedBackgroundPadding);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
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
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucencyByDistance);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testTranslucencyByDistancePropertySamples() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
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
        Assert.assertEquals("{\"label\":{\"translucencyByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", getStringWriter().toString());
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