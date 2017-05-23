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

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestHorizontalOriginCesiumWriter extends TestCesiumPropertyWriter<HorizontalOriginCesiumWriter> {
    @Test
    public final void horizontalOriginCanBeWrittenAsSimpleString() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    HorizontalOriginCesiumWriter writer = new HorizontalOriginCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeHorizontalOrigin(CesiumHorizontalOrigin.CENTER);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"foo\":\"CENTER\"}", getStringWriter().toString());
    }

    @Test
    public final void horizontalOriginCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    HorizontalOriginCesiumWriter writer = new HorizontalOriginCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(startDate, startDate.addSeconds(100.0));
                        writer.writeHorizontalOrigin(CesiumHorizontalOrigin.CENTER);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"horizontalOrigin\":\"CENTER\"}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<HorizontalOriginCesiumWriter> createPropertyWriter(String propertyName) {
        return new HorizontalOriginCesiumWriter(propertyName);
    }

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}