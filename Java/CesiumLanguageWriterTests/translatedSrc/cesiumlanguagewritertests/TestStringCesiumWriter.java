package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
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
public class TestStringCesiumWriter extends TestCesiumPropertyWriter<StringCesiumWriter> {
    @Test
    public final void stringCanBeWrittenAsSimpleString() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    StringCesiumWriter writer = new StringCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeString("bar");
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"foo\":\"bar\"}", getStringWriter().toString());
    }

    @Test
    public final void stringCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    StringCesiumWriter writer = new StringCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(startDate, startDate.addSeconds(100.0));
                        writer.writeString("bar");
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"string\":\"bar\"}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<StringCesiumWriter> createPropertyWriter(String propertyName) {
        return new StringCesiumWriter(propertyName);
    }

    private final TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}