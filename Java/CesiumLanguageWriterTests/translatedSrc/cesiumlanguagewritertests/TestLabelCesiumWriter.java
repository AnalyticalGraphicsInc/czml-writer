package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
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
public class TestLabelCesiumWriter extends TestCesiumPropertyWriter<LabelCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeShowProperty(expectedShow);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(label);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testTextProperty() {
        final String expectedText = "asdf";
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeTextProperty(expectedText);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(label);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.TextPropertyName, expectedText);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowBackgroundProperty() {
        final boolean expectedShowBackground = true;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeShowBackgroundProperty(expectedShowBackground);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(label);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.ShowBackgroundPropertyName, expectedShowBackground);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testBackgroundColorProperty() {
        Color expectedBackgroundColor = Color.RED;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeBackgroundColorProperty(expectedBackgroundColor);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(label);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.BackgroundColorPropertyName, expectedBackgroundColor);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testBackgroundPaddingProperty() {
        Rectangular expectedBackgroundPadding = new Rectangular(3D, 4D);
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeBackgroundPaddingProperty(expectedBackgroundPadding);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(label);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.BackgroundPaddingPropertyName, expectedBackgroundPadding);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testTranslucencyByDistanceProperty() {
        NearFarScalar expectedTranslucencyByDistance = new NearFarScalar(100.0, 1.0, 200.0, 2.0);
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeTranslucencyByDistanceProperty(expectedTranslucencyByDistance);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(label);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, LabelCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucencyByDistance);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$0);
    }

    @Test
    public final void testTranslucencyByDistancePropertySamples() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                {
                                    NearFarScalarCesiumWriter scaleByDistance = interval.openTranslucencyByDistanceProperty();
                                    try {
                                        ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                                        ArrayList<NearFarScalar> values = new ArrayList<NearFarScalar>();
                                        dates.add(epoch);
                                        values.add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
                                        dates.add(epoch.addSeconds(60.0));
                                        values.add(new NearFarScalar(200.0, 1.0, 300.0, 2.0));
                                        scaleByDistance.writeNearFarScalar(dates, values);
                                    } finally {
                                        DisposeHelper.dispose(scaleByDistance);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(label);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
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