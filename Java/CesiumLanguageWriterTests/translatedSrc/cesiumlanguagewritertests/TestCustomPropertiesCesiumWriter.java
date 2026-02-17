package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.Before;
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
        m_startDate = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        m_isoStartString = CesiumFormattingHelper.toIso8601(m_startDate, Iso8601Format.COMPACT);
        m_stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0.0).toJulianDate();
        m_isoIntervalString = CesiumFormattingHelper.toIso8601Interval(m_startDate, m_stopDate, Iso8601Format.COMPACT);
    }

    @Test
    public final void customPropertyBooleanConstant() {
        final String expectedName = "custom_property";
        final boolean expectedValue = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPropertiesCesiumWriter> using$1 = new Using<CustomPropertiesCesiumWriter>(packet.openPropertiesProperty())) {
                final CustomPropertiesCesiumWriter customProperties = using$1.resource;
                try (Using<CustomPropertyCesiumWriter> using$2 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty(expectedName))) {
                    final CustomPropertyCesiumWriter customProperty = using$2.resource;
                    customProperty.writeBoolean(expectedValue);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, expectedName, expectedValue);
        assertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, tempCollection$0);
    }

    @Test
    public final void customPropertyBooleanInterval() {
        final String expectedName = "custom_property";
        final boolean expectedValue = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPropertiesCesiumWriter> using$1 = new Using<CustomPropertiesCesiumWriter>(packet.openPropertiesProperty())) {
                final CustomPropertiesCesiumWriter customProperties = using$1.resource;
                try (Using<CustomPropertyCesiumWriter> using$2 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty(expectedName))) {
                    final CustomPropertyCesiumWriter customProperty = using$2.resource;
                    try (Using<CustomPropertyCesiumWriter> using$3 = new Using<CustomPropertyCesiumWriter>(customProperty.openInterval(m_startDate, m_stopDate))) {
                        final CustomPropertyCesiumWriter interval = using$3.resource;
                        interval.writeBoolean(expectedValue);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, "interval", m_isoIntervalString);
        MapHelper.add(tempCollection$1, CustomPropertyCesiumWriter.BooleanPropertyName, expectedValue);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, expectedName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, tempCollection$0);
    }

    @Test
    public final void customPropertyCartesianConstant() {
        final String expectedName = "custom_property";
        Cartesian expectedValue = new Cartesian(1.1, 2.2, 3.3);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPropertiesCesiumWriter> using$1 = new Using<CustomPropertiesCesiumWriter>(packet.openPropertiesProperty())) {
                final CustomPropertiesCesiumWriter customProperties = using$1.resource;
                try (Using<CustomPropertyCesiumWriter> using$2 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty(expectedName))) {
                    final CustomPropertyCesiumWriter customProperty = using$2.resource;
                    customProperty.writeCartesian(expectedValue);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, expectedName, expectedValue);
        assertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, tempCollection$0);
    }

    @Test
    public final void customPropertyCartesianSampled() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPropertiesCesiumWriter> using$1 = new Using<CustomPropertiesCesiumWriter>(packet.openPropertiesProperty())) {
                final CustomPropertiesCesiumWriter customProperties = using$1.resource;
                try (Using<CustomPropertyCesiumWriter> using$2 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty("custom_property"))) {
                    final CustomPropertyCesiumWriter customProperty = using$2.resource;
                    ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                    ArrayList<Cartesian> values = new ArrayList<Cartesian>();
                    dates.add(m_startDate);
                    values.add(new Cartesian(1.0, 2.0, 3.0));
                    dates.add(m_startDate.addSeconds(60.0));
                    values.add(new Cartesian(4.0, 5.0, 6.0));
                    dates.add(m_startDate.addSeconds(120.0));
                    values.add(new Cartesian(7.0, 8.0, 9.0));
                    customProperty.writeCartesian(dates, values);
                }
            }
        }
        AssertHelper.assertEquals("{\"properties\":{\"custom_property\":{\"epoch\":\"" + m_isoStartString + "\",\"cartesian\":[0,1,2,3,60,4,5,6,120,7,8,9]}}}", getStringWriter().toString());
    }

    @Test
    public final void customPropertyCartesianSampledInterpolationSettings() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPropertiesCesiumWriter> using$1 = new Using<CustomPropertiesCesiumWriter>(packet.openPropertiesProperty())) {
                final CustomPropertiesCesiumWriter customProperties = using$1.resource;
                try (Using<CustomPropertyCesiumWriter> using$2 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty("custom_property"))) {
                    final CustomPropertyCesiumWriter customProperty = using$2.resource;
                    customProperty.writeInterpolationAlgorithm(CesiumInterpolationAlgorithm.HERMITE);
                    ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                    ArrayList<Cartesian> values = new ArrayList<Cartesian>();
                    dates.add(m_startDate);
                    values.add(new Cartesian(1.0, 2.0, 3.0));
                    dates.add(m_startDate.addSeconds(60.0));
                    values.add(new Cartesian(4.0, 5.0, 6.0));
                    dates.add(m_startDate.addSeconds(120.0));
                    values.add(new Cartesian(7.0, 8.0, 9.0));
                    customProperty.writeCartesian(dates, values);
                }
            }
        }
        AssertHelper.assertEquals("{\"properties\":{\"custom_property\":{\"interpolationAlgorithm\":\"HERMITE\",\"epoch\":\"" + m_isoStartString + "\",\"cartesian\":[0,1,2,3,60,4,5,6,120,7,8,9]}}}",
                getStringWriter().toString());
    }

    @Test
    public final void testMultipleProperties() {
        final String expectedName1 = "custom_boolean";
        final boolean expectedValue1 = true;
        final String expectedName2 = "custom_cartesian";
        Cartesian expectedValue2 = new Cartesian(1.1, 2.2, 3.3);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<CustomPropertiesCesiumWriter> using$1 = new Using<CustomPropertiesCesiumWriter>(packet.openPropertiesProperty())) {
                final CustomPropertiesCesiumWriter customProperties = using$1.resource;
                try (Using<CustomPropertyCesiumWriter> using$2 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty(expectedName1))) {
                    final CustomPropertyCesiumWriter customProperty = using$2.resource;
                    customProperty.writeBoolean(expectedValue1);
                }
                try (Using<CustomPropertyCesiumWriter> using$3 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty(expectedName2))) {
                    final CustomPropertyCesiumWriter customProperty = using$3.resource;
                    customProperty.writeCartesian(expectedValue2);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, expectedName1, expectedValue1);
        MapHelper.add(tempCollection$0, expectedName2, expectedValue2);
        assertExpectedJson(PacketCesiumWriter.PropertiesPropertyName, tempCollection$0);
    }

    @Test
    public final void createExampleFile() {
        try (Using<StringWriter> using$0 = new Using<StringWriter>(new StringWriter())) {
            final StringWriter stringWriter = using$0.resource;
            CesiumOutputStream output = new CesiumOutputStream(stringWriter, true);
            CesiumStreamWriter writer = new CesiumStreamWriter();
            output.writeStartSequence();
            try (Using<PacketCesiumWriter> using$1 = new Using<PacketCesiumWriter>(writer.openPacket(output))) {
                final PacketCesiumWriter documentPacket = using$1.resource;
                documentPacket.writeId("document");
                documentPacket.writeVersion("1.0");
                try (Using<ClockCesiumWriter> using$2 = new Using<ClockCesiumWriter>(documentPacket.openClockProperty())) {
                    final ClockCesiumWriter clock = using$2.resource;
                    try (Using<ClockCesiumWriter> using$3 = new Using<ClockCesiumWriter>(clock.openInterval(m_startDate, m_stopDate))) {
                        final ClockCesiumWriter interval = using$3.resource;
                        interval.writeCurrentTime(m_startDate);
                    }
                }
            }
            try (Using<PacketCesiumWriter> using$4 = new Using<PacketCesiumWriter>(writer.openPacket(output))) {
                final PacketCesiumWriter packet = using$4.resource;
                packet.writeId("MyID");
                try (Using<CustomPropertiesCesiumWriter> using$5 = new Using<CustomPropertiesCesiumWriter>(packet.openPropertiesProperty())) {
                    final CustomPropertiesCesiumWriter customProperties = using$5.resource;
                    try (Using<CustomPropertyCesiumWriter> using$6 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty("custom_boolean"))) {
                        final CustomPropertyCesiumWriter customProperty = using$6.resource;
                        try (Using<CesiumIntervalListWriter<CustomPropertyCesiumWriter>> using$7 = new Using<CesiumIntervalListWriter<CustomPropertyCesiumWriter>>(
                                customProperty.openMultipleIntervals())) {
                            final CesiumIntervalListWriter<CustomPropertyCesiumWriter> intervalList = using$7.resource;
                            try (Using<CustomPropertyCesiumWriter> using$8 = new Using<CustomPropertyCesiumWriter>(intervalList.openInterval(m_startDate, m_startDate.addSeconds(1.0)))) {
                                final CustomPropertyCesiumWriter interval = using$8.resource;
                                interval.writeBoolean(true);
                            }
                            try (Using<CustomPropertyCesiumWriter> using$9 = new Using<CustomPropertyCesiumWriter>(
                                    intervalList.openInterval(m_startDate.addSeconds(1.0), m_startDate.addSeconds(2.0)))) {
                                final CustomPropertyCesiumWriter interval = using$9.resource;
                                interval.writeBoolean(false);
                            }
                            try (Using<CustomPropertyCesiumWriter> using$10 = new Using<CustomPropertyCesiumWriter>(intervalList.openInterval(m_startDate.addSeconds(2.0), m_stopDate))) {
                                final CustomPropertyCesiumWriter interval = using$10.resource;
                                interval.writeBoolean(true);
                            }
                        }
                    }
                    try (Using<CustomPropertyCesiumWriter> using$11 = new Using<CustomPropertyCesiumWriter>(customProperties.openCustomPropertyProperty("custom_cartesian"))) {
                        final CustomPropertyCesiumWriter customProperty = using$11.resource;
                        ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                        ArrayList<Cartesian> values = new ArrayList<Cartesian>();
                        dates.add(m_startDate);
                        values.add(new Cartesian(1.0, 2.0, 3.0));
                        dates.add(m_startDate.addSeconds(60.0));
                        values.add(new Cartesian(4.0, 5.0, 6.0));
                        dates.add(m_startDate.addSeconds(120.0));
                        values.add(new Cartesian(7.0, 8.0, 9.0));
                        customProperty.writeCartesian(dates, values);
                    }
                }
            }
            output.writeEndSequence();
            ConsoleHelper.writeLine(stringWriter.toString());
        }
    }

    @Override
    protected CesiumPropertyWriter<CustomPropertiesCesiumWriter> createPropertyWriter(String propertyName) {
        return new CustomPropertiesCesiumWriter(propertyName);
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