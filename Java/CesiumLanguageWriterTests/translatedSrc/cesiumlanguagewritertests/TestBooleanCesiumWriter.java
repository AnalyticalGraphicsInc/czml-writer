package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import javax.annotation.Nonnull;
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

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        JulianDate stop = start.addDays(1.0);
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                getPacket().writeId("id");
                {
                    BooleanCesiumWriter writer = new BooleanCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(start, stop);
                        writer.writeDelete(true);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        Assert.assertEquals("{\"id\":\"id\",\"foo\":{\"interval\":\"20120402T12Z/20120403T12Z\",\"delete\":true}}", getStringWriter().toString());
    }

    @Test
    public final void testDeletePropertyWithNoInterval() {
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                getPacket().writeId("id");
                {
                    BooleanCesiumWriter writer = new BooleanCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeDelete(true);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_3);
            }
        }
        Assert.assertEquals("{\"id\":\"id\",\"foo\":{\"delete\":true}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<BooleanCesiumWriter> createPropertyWriter(String propertyName) {
        return new BooleanCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}