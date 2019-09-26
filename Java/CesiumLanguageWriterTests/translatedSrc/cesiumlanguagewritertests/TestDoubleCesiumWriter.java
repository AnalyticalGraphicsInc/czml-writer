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
public class TestDoubleCesiumWriter extends TestCesiumPropertyWriter<DoubleCesiumWriter> {
    @Test
    public final void doubleCanBeWrittenAsSimpleNumber() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    DoubleCesiumWriter writer = new DoubleCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeNumber(1.23);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"foo\":1.23}", getStringWriter().toString());
    }

    @Test
    public final void doubleCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    DoubleCesiumWriter writer = new DoubleCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(startDate, startDate.addSeconds(100.0));
                        writer.writeNumber(1.23);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"number\":1.23}}", getStringWriter().toString());
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
                    DoubleCesiumWriter writer = new DoubleCesiumWriter("foo");
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
                    DoubleCesiumWriter writer = new DoubleCesiumWriter("foo");
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
    protected CesiumPropertyWriter<DoubleCesiumWriter> createPropertyWriter(String propertyName) {
        return new DoubleCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}