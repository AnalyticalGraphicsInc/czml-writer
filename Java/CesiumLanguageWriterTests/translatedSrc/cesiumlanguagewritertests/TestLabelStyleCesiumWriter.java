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
public class TestLabelStyleCesiumWriter extends TestCesiumPropertyWriter<LabelStyleCesiumWriter> {
    @Test
    public final void labelStyleCanBeWrittenAsSimpleString() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeLabelStyle(CesiumLabelStyle.FILL_AND_OUTLINE);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"foo\":\"FILL_AND_OUTLINE\"}", getStringWriter().toString());
    }

    @Test
    public final void labelStyleCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter("foo");
                    try {
                        writer.open(getOutputStream());
                        writer.writeInterval(startDate, startDate.addSeconds(100.0));
                        writer.writeLabelStyle(CesiumLabelStyle.FILL_AND_OUTLINE);
                    } finally {
                        DisposeHelper.dispose(writer);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"labelStyle\":\"FILL_AND_OUTLINE\"}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<LabelStyleCesiumWriter> createPropertyWriter(String propertyName) {
        return new LabelStyleCesiumWriter(propertyName);
    }

    private final TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}