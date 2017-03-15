package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCustomPropertiesCesiumWriter extends TestCesiumPropertyWriter<CustomPropertiesCesiumWriter> {
    @Before
    public final void setUp() {
        m_startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        m_isoStartString = CesiumFormattingHelper.toIso8601(m_startDate, Iso8601Format.COMPACT);
        m_stopDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 1, 0D));
        m_isoIntervalString = CesiumFormattingHelper.toIso8601Interval(m_startDate, m_stopDate, Iso8601Format.COMPACT);
    }

    @Test
    public final void customPropertyBooleanConstant() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_property");
                            try {
                                customPropertyWriter.writeBoolean(true);
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
        Assert.assertEquals("{\"properties\":{\"custom_property\":true}}", getStringWriter().toString());
    }

    @Test
    public final void customPropertyBooleanInterval() {
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_property");
                            try {
                                {
                                    cesiumlanguagewriter.CustomPropertyCesiumWriter intervalWriter = customPropertyWriter.openInterval(m_startDate, m_stopDate);
                                    try {
                                        intervalWriter.writeBoolean(true);
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
        Assert.assertEquals("{\"properties\":{\"custom_property\":{\"interval\":\"" + m_isoIntervalString + "\",\"boolean\":true}}}", getStringWriter().toString());
    }

    @Test
    public final void customPropertyCartesianConstant() {
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_property");
                            try {
                                customPropertyWriter.writeCartesian(new Cartesian(1D, 2D, 3D));
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
        Assert.assertEquals("{\"properties\":{\"custom_property\":{\"cartesian\":[1,2,3]}}}", getStringWriter().toString());
    }

    @Test
    public final void customPropertyCartesianSampled() {
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_property");
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
                    cesiumlanguagewriter.CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_property");
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
        {
            final PacketCesiumWriter usingExpression_5 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.CustomPropertiesCesiumWriter customPropertiesWriter = getPacket().openPropertiesProperty();
                    try {
                        {
                            cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_boolean");
                            try {
                                customPropertyWriter.writeBoolean(true);
                            } finally {
                                DisposeHelper.dispose(customPropertyWriter);
                            }
                        }
                        {
                            cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_cartesian");
                            try {
                                customPropertyWriter.writeCartesian(new Cartesian(1D, 2D, 3D));
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
        Assert.assertEquals("{\"properties\":{\"custom_boolean\":true,\"custom_cartesian\":{\"cartesian\":[1,2,3]}}}", getStringWriter().toString());
    }

    @Test
    public final void createExampleFile() {
        {
            StringWriter stringWriter = new StringWriter();
            try {
                final CesiumOutputStream tempObj$0 = new CesiumOutputStream(stringWriter);
                tempObj$0.setPrettyFormatting(true);
                cesiumlanguagewriter.CesiumOutputStream output = tempObj$0;
                cesiumlanguagewriter.CesiumStreamWriter writer = new CesiumStreamWriter();
                output.writeStartSequence();
                {
                    cesiumlanguagewriter.PacketCesiumWriter documentPacket = writer.openPacket(output);
                    try {
                        documentPacket.writeId("document");
                        documentPacket.writeVersion("1.0");
                        {
                            cesiumlanguagewriter.ClockCesiumWriter clockWriter = documentPacket.openClockProperty();
                            try {
                                {
                                    cesiumlanguagewriter.ClockCesiumWriter intervalClockWriter = clockWriter.openInterval(m_startDate, m_stopDate);
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
                    cesiumlanguagewriter.PacketCesiumWriter packet = writer.openPacket(output);
                    try {
                        packet.writeId("MyID");
                        {
                            cesiumlanguagewriter.CustomPropertiesCesiumWriter customPropertiesWriter = packet.openPropertiesProperty();
                            try {
                                {
                                    cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_boolean");
                                    try {
                                        {
                                            cesiumlanguagewriter.CesiumIntervalListWriter<cesiumlanguagewriter.CustomPropertyCesiumWriter> intervalListWriter = customPropertyWriter
                                                    .openMultipleIntervals();
                                            try {
                                                {
                                                    cesiumlanguagewriter.CustomPropertyCesiumWriter intervalWriter = intervalListWriter.openInterval(m_startDate, m_startDate.addSeconds(1D));
                                                    try {
                                                        intervalWriter.writeBoolean(true);
                                                    } finally {
                                                        DisposeHelper.dispose(intervalWriter);
                                                    }
                                                }
                                                {
                                                    cesiumlanguagewriter.CustomPropertyCesiumWriter intervalWriter = intervalListWriter.openInterval(m_startDate.addSeconds(1D), m_startDate
                                                            .addSeconds(2D));
                                                    try {
                                                        intervalWriter.writeBoolean(false);
                                                    } finally {
                                                        DisposeHelper.dispose(intervalWriter);
                                                    }
                                                }
                                                {
                                                    cesiumlanguagewriter.CustomPropertyCesiumWriter intervalWriter = intervalListWriter.openInterval(m_startDate.addSeconds(2D), m_stopDate);
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
                                    cesiumlanguagewriter.CustomPropertyCesiumWriter customPropertyWriter = customPropertiesWriter.openCustomPropertyProperty("custom_cartesian");
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

    @CS2JInfo("Initialization of C# struct variable 'm_startDate' added by translator.")
    private JulianDate m_startDate = new JulianDate();
    private String m_isoStartString;
    @CS2JInfo("Initialization of C# struct variable 'm_stopDate' added by translator.")
    private JulianDate m_stopDate = new JulianDate();
    private String m_isoIntervalString;
    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}