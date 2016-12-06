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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBooleanCesiumWriter extends TestCesiumPropertyWriter<BooleanCesiumWriter> {
    @Test
    public final void booleanCanBeWrittenAsSimpleBoolean() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    BooleanCesiumWriter writer = new BooleanCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeBoolean(false);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"foo\":false}", getStringWriter().toString());
    }

    @Test
    public final void booleanCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    BooleanCesiumWriter writer = new BooleanCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(startDate, startDate.addSeconds(100.0));
                        writer.writeBoolean(false);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"boolean\":false}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<BooleanCesiumWriter> createPropertyWriter(String propertyName) {
        return new BooleanCesiumWriter(propertyName);
    }

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}