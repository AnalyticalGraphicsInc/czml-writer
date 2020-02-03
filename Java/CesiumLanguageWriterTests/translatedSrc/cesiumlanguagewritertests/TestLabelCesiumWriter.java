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
            final PacketCesiumWriter usingExpression_0 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_0);
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
            final PacketCesiumWriter usingExpression_1 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, LabelCesiumWriter.TextPropertyName, expectedText);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$1);
    }

    @Test
    public final void testShowBackgroundProperty() {
        final boolean expectedShowBackground = true;
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, LabelCesiumWriter.ShowBackgroundPropertyName, expectedShowBackground);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$2);
    }

    @Test
    public final void testBackgroundColorProperty() {
        Color expectedBackgroundColor = Color.RED;
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_3);
            }
        }
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, LabelCesiumWriter.BackgroundColorPropertyName, expectedBackgroundColor);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$3);
    }

    @Test
    public final void testBackgroundPaddingProperty() {
        Rectangular expectedBackgroundPadding = new Rectangular(3D, 4D);
        {
            final PacketCesiumWriter usingExpression_4 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_4);
            }
        }
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, LabelCesiumWriter.BackgroundPaddingPropertyName, expectedBackgroundPadding);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$4);
    }

    @Test
    public final void testTranslucencyByDistanceProperty() {
        NearFarScalar expectedTranslucencyByDistance = new NearFarScalar(100.0, 1.0, 200.0, 2.0);
        {
            final PacketCesiumWriter usingExpression_5 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_5);
            }
        }
        final Map<String, Object> tempCollection$5 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$5, LabelCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucencyByDistance);
        assertExpectedJson(PacketCesiumWriter.LabelPropertyName, tempCollection$5);
    }

    @Test
    public final void testTranslucencyByDistancePropertySamples() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_6 = (getPacket());
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
                                        ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                        ArrayList<cesiumlanguagewriter.NearFarScalar> values = new ArrayList<cesiumlanguagewriter.NearFarScalar>();
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
                DisposeHelper.dispose(usingExpression_6);
            }
        }
        Assert.assertEquals("{\"label\":{\"translucencyByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<LabelCesiumWriter> createPropertyWriter(String propertyName) {
        return new LabelCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}