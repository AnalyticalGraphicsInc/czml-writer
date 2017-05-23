package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLabelCesiumWriter extends TestCesiumPropertyWriter<LabelCesiumWriter> {
    @Test
    public final void testShowProperty() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeShowProperty(true);
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
        Assert.assertEquals("{\"label\":{\"show\":true}}", getStringWriter().toString());
    }

    @Test
    public final void testTextProperty() {
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeTextProperty("asdf");
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
        Assert.assertEquals("{\"label\":{\"text\":\"asdf\"}}", getStringWriter().toString());
    }

    @Test
    public final void testShowBackgroundProperty() {
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeShowBackgroundProperty(true);
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
        Assert.assertEquals("{\"label\":{\"showBackground\":true}}", getStringWriter().toString());
    }

    @Test
    public final void testBackgroundColorProperty() {
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeBackgroundColorProperty(Color.RED);
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
        Assert.assertEquals("{\"label\":{\"backgroundColor\":{\"rgba\":[255,0,0,255]}}}", getStringWriter().toString());
    }

    @Test
    public final void testBackgroundPaddingProperty() {
        {
            final PacketCesiumWriter usingExpression_4 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeBackgroundPaddingProperty(new Rectangular(3D, 4D));
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
        Assert.assertEquals("{\"label\":{\"backgroundPadding\":{\"cartesian2\":[3,4]}}}", getStringWriter().toString());
    }

    @Test
    public final void testTranslucencyByDistanceProperty() {
        {
            final PacketCesiumWriter usingExpression_5 = (getPacket());
            try {
                {
                    LabelCesiumWriter label = getPacket().openLabelProperty();
                    try {
                        {
                            LabelCesiumWriter interval = label.openInterval();
                            try {
                                interval.writeTranslucencyByDistanceProperty(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
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
        Assert.assertEquals("{\"label\":{\"translucencyByDistance\":{\"nearFarScalar\":[100,1,200,2]}}}", getStringWriter().toString());
    }

    @Test
    public final void testTranslucencyByDistancePropertySamples() {
        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
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
                                        dates.add(startDate);
                                        values.add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
                                        dates.add(startDate.addSeconds(60.0));
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

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}