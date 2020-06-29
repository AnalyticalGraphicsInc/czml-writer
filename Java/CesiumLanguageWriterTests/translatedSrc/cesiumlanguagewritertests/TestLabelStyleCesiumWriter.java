package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nonnull;
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
public class TestLabelStyleCesiumWriter extends TestCesiumPropertyWriter<LabelStyleCesiumWriter> {
    @Test
    public final void labelStyleCanBeWrittenAsSimpleString() {
        final String expectedPropertyName = "foo";
        final CesiumLabelStyle expectedValue = CesiumLabelStyle.FILL_AND_OUTLINE;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter(expectedPropertyName);
                    try {
                        writer.open(getOutputStream());
                        writer.writeLabelStyle(expectedValue);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, expectedPropertyName, CesiumFormattingHelper.labelStyleToString(expectedValue));
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void labelStyleCanBeWrittenInsideInterval() {
        JulianDate start = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        JulianDate stop = start.addSeconds(100.0);
        final String expectedPropertyName = "foo";
        final CesiumLabelStyle expectedValue = CesiumLabelStyle.FILL_AND_OUTLINE;
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter(expectedPropertyName);
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(start, stop);
                        writer.writeLabelStyle(expectedValue);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$1, LabelStyleCesiumWriter.LabelStylePropertyName, CesiumFormattingHelper.labelStyleToString(expectedValue));
        assertExpectedJson(expectedPropertyName, tempCollection$1);
    }

    @Override
    protected CesiumPropertyWriter<LabelStyleCesiumWriter> createPropertyWriter(String propertyName) {
        return new LabelStyleCesiumWriter(propertyName);
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