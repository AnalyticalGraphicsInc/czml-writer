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
public class TestVerticalOriginCesiumWriter extends TestCesiumPropertyWriter<VerticalOriginCesiumWriter> {
    @Test
    public final void verticalOriginCanBeWrittenAsSimpleString() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    VerticalOriginCesiumWriter writer = new VerticalOriginCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeVerticalOrigin(CesiumVerticalOrigin.CENTER);
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
    public final void verticalOriginCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    VerticalOriginCesiumWriter writer = new VerticalOriginCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(startDate, startDate.addSeconds(100.0));
                        writer.writeVerticalOrigin(CesiumVerticalOrigin.CENTER);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"verticalOrigin\":\"CENTER\"}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<VerticalOriginCesiumWriter> createPropertyWriter(String propertyName) {
        return new VerticalOriginCesiumWriter(propertyName);
    }

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}