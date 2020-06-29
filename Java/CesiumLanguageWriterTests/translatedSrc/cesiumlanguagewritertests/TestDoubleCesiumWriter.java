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
public class TestDoubleCesiumWriter extends TestCesiumPropertyWriter<DoubleCesiumWriter> {
    @Test
    public final void doubleCanBeWrittenAsSimpleNumber() {
        final String expectedPropertyName = "foo";
        final double expectedValue = 1.23;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    DoubleCesiumWriter writer = new DoubleCesiumWriter(expectedPropertyName);
                    try {
                        writer.open(getOutputStream());
                        writer.writeNumber(expectedValue);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, expectedPropertyName, expectedValue);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void doubleCanBeWrittenInsideInterval() {
        JulianDate start = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        JulianDate stop = start.addSeconds(100.0);
        final String expectedPropertyName = "foo";
        final double expectedValue = 1.23;
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    DoubleCesiumWriter writer = new DoubleCesiumWriter(expectedPropertyName);
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(start, stop);
                        writer.writeNumber(expectedValue);
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
        MapHelper.add(tempCollection$1, DoubleCesiumWriter.NumberPropertyName, expectedValue);
        assertExpectedJson(expectedPropertyName, tempCollection$1);
    }

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stop = start.addDays(1.0);
        final String expectedId = "id";
        final String expectedPropertyName = "foo";
        final boolean expectedDelete = true;
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                getPacket().writeId(expectedId);
                {
                    DoubleCesiumWriter writer = new DoubleCesiumWriter(expectedPropertyName);
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(start, stop);
                        writer.writeDelete(expectedDelete);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$3, DoubleCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$2, expectedPropertyName, tempCollection$3);
        assertExpectedJson(tempCollection$2);
    }

    @Test
    public final void testDeletePropertyWithNoInterval() {
        final String expectedId = "id";
        final String expectedPropertyName = "foo";
        final boolean expectedDelete = true;
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                getPacket().writeId(expectedId);
                {
                    DoubleCesiumWriter writer = new DoubleCesiumWriter(expectedPropertyName);
                    try {
                        writer.open(getOutputStream());
                        writer.writeDelete(expectedDelete);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_3);
            }
        }
        final Map<String, Object> tempCollection$5 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$5, DoubleCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$4, expectedPropertyName, tempCollection$5);
        assertExpectedJson(tempCollection$4);
    }

    @Override
    protected CesiumPropertyWriter<DoubleCesiumWriter> createPropertyWriter(String propertyName) {
        return new DoubleCesiumWriter(propertyName);
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