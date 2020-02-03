package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.Before;
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
public class TestCustomPropertiesCesiumWriter extends TestCesiumPropertyWriter<CustomPropertiesCesiumWriter> {
    @CS2JInfo("Initialization of C# struct variable 'm_startDate' added by translator.")
    @Nonnull
    private JulianDate m_startDate = new JulianDate();
    private String m_isoStartString;
    @CS2JInfo("Initialization of C# struct variable 'm_stopDate' added by translator.")
    @Nonnull
    private JulianDate m_stopDate = new JulianDate();
    private String m_isoIntervalString;

    @Before
    public final void setUp() {
        m_startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        m_isoStartString = CesiumFormattingHelper.toIso8601(m_startDate, Iso8601Format.COMPACT);
        m_stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0D).toJulianDate();
        m_isoIntervalString = CesiumFormattingHelper.toIso8601Interval(m_startDate, m_stopDate, Iso8601Format.COMPACT);
    }

    @Test
    public final void customPropertyBooleanConstant() {
        final String expectedName = "custom_property";
        final boolean expectedValue = true;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty(expectedName);
                            try {
                                customPropertyWriter.writeBoolean(expectedValue);
                            } finally {
                                DisposeHelper.dispose(customPropertyWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(customPropertiesWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, expectedName, expectedValue);
        assertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, tempCollection$0);
    }

    @Test
    public final void customPropertyBooleanInterval() {
        final String expectedName = "custom_property";
        final boolean expectedValue = true;
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty(expectedName);
                            try {
                                {
                                    CustomPropertyCesiumWriter intervalWriter = customPropertyWriter.openInterval(m_startDate, m_stopDate);
                                    try {
                                        intervalWriter.writeBoolean(expectedValue);
                                    } finally {
                                        DisposeHelper.dispose(intervalWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(customPropertyWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(customPropertiesWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, "interval", m_isoIntervalString);
        MapHelper.add(tempCollection$2, CustomPropertyCesiumWriter.BooleanPropertyName, expectedValue);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, expectedName, tempCollection$2);
        assertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, tempCollection$1);
    }

    @Test
    public final void customPropertyCartesianConstant() {
        final String expectedName = "custom_property";
        Cartesian expectedValue = new Cartesian(1.1, 2.2, 3.3);
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty(expectedName);
                            try {
                                customPropertyWriter.writeCartesian(expectedValue);
                            } finally {
                                DisposeHelper.dispose(customPropertyWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(customPropertiesWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, expectedName, expectedValue);
        assertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, tempCollection$3);
    }

    @Test
    public final void customPropertyCartesianSampled() {
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                {
                    CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_property");
                            try {
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartesian> values = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                dates.add(m_startDate);
                                values.add(new Cartesian(1.0, 2.0, 3.0));
                                dates.add(m_startDate.addSeconds(60.0));
                                values.add(new Cartesian(4.0, 5.0, 6.0));
                                dates.add(m_startDate.addSeconds(120.0));
                                values.add(new Cartesian(7.0, 8.0, 9.0));
                                customPropertyWriter.writeCartesian(dates, values);
                            } finally {
                                DisposeHelper.dispose(customPropertyWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(customPropertiesWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_3);
            }
        }
        Assert.assertEquals("{\"properties\":{\"custom_property\":{\"epoch\":\"" + m_isoStartString + "\",\"cartesian\":[0,1,2,3,60,4,5,6,120,7,8,9]}}}", getStringWriter().toString());
    }

    @Test
    public final void customPropertyCartesianSampledInterpolationSettings() {
        {
            final PacketCesiumWriter usingExpression_4 = (getPacket());
            try {
                {
                    CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_property");
                            try {
                                customPropertyWriter.writeInterpolationAlgorithm(CesiumInterpolationAlgorithm.HERMITE);
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartesian> values = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                dates.add(m_startDate);
                                values.add(new Cartesian(1.0, 2.0, 3.0));
                                dates.add(m_startDate.addSeconds(60.0));
                                values.add(new Cartesian(4.0, 5.0, 6.0));
                                dates.add(m_startDate.addSeconds(120.0));
                                values.add(new Cartesian(7.0, 8.0, 9.0));
                                customPropertyWriter.writeCartesian(dates, values);
                            } finally {
                                DisposeHelper.dispose(customPropertyWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(customPropertiesWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_4);
            }
        }
        Assert.assertEquals("{\"properties\":{\"custom_property\":{\"interpolationAlgorithm\":\"HERMITE\",\"epoch\":\"" + m_isoStartString + "\",\"cartesian\":[0,1,2,3,60,4,5,6,120,7,8,9]}}}",
                getStringWriter().toString());
    }

    @Test
    public final void testMultipleProperties() {
        final String expectedName1 = "custom_boolean";
        final boolean expectedValue1 = true;
        final String expectedName2 = "custom_cartesian";
        Cartesian expectedValue2 = new Cartesian(1.1, 2.2, 3.3);
        {
            final PacketCesiumWriter usingExpression_5 = (getPacket());
            try {
                {
                    CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty(expectedName1);
                            try {
                                customPropertyWriter.writeBoolean(expectedValue1);
                            } finally {
                                DisposeHelper.dispose(customPropertyWriter);
                            }
                        }
                        {
                            CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty(expectedName2);
                            try {
                                customPropertyWriter.writeCartesian(expectedValue2);
                            } finally {
                                DisposeHelper.dispose(customPropertyWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(customPropertiesWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_5);
            }
        }
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, expectedName1, expectedValue1);
        MapHelper.add(tempCollection$4, expectedName2, expectedValue2);
        assertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, tempCollection$4);
    }

    @Test
    public final void createExampleFile() {
        {
            StringWriter stringWriter = new StringWriter();
            try {
                final CesiumOutputStream tempObj$0 = new CesiumOutputStream(stringWriter);
                tempObj$0.setPrettyFormatting(true);
                CesiumOutputStream output = tempObj$0;
                CesiumStreamWriter writer = new CesiumStreamWriter();
                output.writeStartSequence();
                {
                    PacketCesiumWriter documentPacket = writer.openPacket(output);
                    try {
                        documentPacket.writeId("document");
                        documentPacket.writeVersion("1.0");
                        {
                            ClockCesiumWriter clockWriter = documentPacket.openClockProperty();
                            try {
                                {
                                    ClockCesiumWriter intervalClockWriter = clockWriter.openInterval(m_startDate, m_stopDate);
                                    try {
                                        intervalClockWriter.writeCurrentTime(m_startDate);
                                    } finally {
                                        DisposeHelper.dispose(intervalClockWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(clockWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(documentPacket);
                    }
                }
                {
                    PacketCesiumWriter packet = writer.openPacket(output);
                    try {
                        packet.writeId("MyID");
                        {
                            CustomPropertiesCesiumWriter customPropertiesWriter = packet.openPropertiesProperty();
                            try {
                                {
                                    CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_boolean");
                                    try {
                                        {
                                            CesiumIntervalListWriter<cesiumlanguagewriter.CustomPropertyCesiumWriter> intervalListWriter = customPropertyWriter.openMultipleIntervals();
                                            try {
                                                {
                                                    CustomPropertyCesiumWriter intervalWriter = intervalListWriter.openInterval(m_startDate, m_startDate.addSeconds(1D));
                                                    try {
                                                        intervalWriter.writeBoolean(true);
                                                    } finally {
                                                        DisposeHelper.dispose(intervalWriter);
                                                    }
                                                }
                                                {
                                                    CustomPropertyCesiumWriter intervalWriter = intervalListWriter.openInterval(m_startDate.addSeconds(1D), m_startDate.addSeconds(2D));
                                                    try {
                                                        intervalWriter.writeBoolean(false);
                                                    } finally {
                                                        DisposeHelper.dispose(intervalWriter);
                                                    }
                                                }
                                                {
                                                    CustomPropertyCesiumWriter intervalWriter = intervalListWriter.openInterval(m_startDate.addSeconds(2D), m_stopDate);
                                                    try {
                                                        intervalWriter.writeBoolean(true);
                                                    } finally {
                                                        DisposeHelper.dispose(intervalWriter);
                                                    }
                                                }
                                            } finally {
                                                DisposeHelper.dispose(intervalListWriter);
                                            }
                                        }
                                    } finally {
                                        DisposeHelper.dispose(customPropertyWriter);
                                    }
                                }
                                {
                                    CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_cartesian");
                                    try {
                                        ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                        ArrayList<cesiumlanguagewriter.Cartesian> values = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                        dates.add(m_startDate);
                                        values.add(new Cartesian(1.0, 2.0, 3.0));
                                        dates.add(m_startDate.addSeconds(60.0));
                                        values.add(new Cartesian(4.0, 5.0, 6.0));
                                        dates.add(m_startDate.addSeconds(120.0));
                                        values.add(new Cartesian(7.0, 8.0, 9.0));
                                        customPropertyWriter.writeCartesian(dates, values);
                                    } finally {
                                        DisposeHelper.dispose(customPropertyWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(customPropertiesWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(packet);
                    }
                }
                output.writeEndSequence();
                ConsoleHelper.writeLine(stringWriter.toString());
            } finally {
                DisposeHelper.dispose(stringWriter);
            }
        }
    }

    @Override
    protected CesiumPropertyWriter<CustomPropertiesCesiumWriter> createPropertyWriter(String propertyName) {
        return new CustomPropertiesCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}