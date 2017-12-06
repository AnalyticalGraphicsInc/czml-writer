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
public class TestPropertiesOfSimpleJsonTypes extends TestCesiumPropertyWriter<BillboardCesiumWriter> {
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

    @Test
    public final void doubleCanBeWrittenAsSimpleNumber() {
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        Assert.assertEquals("{\"foo\":1.23}", getStringWriter().toString());
    }

    @Test
    public final void doubleCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_3);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"number\":1.23}}", getStringWriter().toString());
    }

    @Test
    public final void booleanCanBeWrittenAsSimpleBoolean() {
        {
            final PacketCesiumWriter usingExpression_4 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_4);
            }
        }
        Assert.assertEquals("{\"foo\":false}", getStringWriter().toString());
    }

    @Test
    public final void booleanCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_5 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_5);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"boolean\":false}}", getStringWriter().toString());
    }

    @Test
    public final void verticalOriginCanBeWrittenAsSimpleString() {
        {
            final PacketCesiumWriter usingExpression_6 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_6);
            }
        }
        Assert.assertEquals("{\"foo\":\"CENTER\"}", getStringWriter().toString());
    }

    @Test
    public final void verticalOriginCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_7 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_7);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"verticalOrigin\":\"CENTER\"}}", getStringWriter().toString());
    }

    @Test
    public final void horizontalOriginCanBeWrittenAsSimpleString() {
        {
            final PacketCesiumWriter usingExpression_8 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_8);
            }
        }
        Assert.assertEquals("{\"foo\":\"CENTER\"}", getStringWriter().toString());
    }

    @Test
    public final void horizontalOriginCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_9 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_9);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"horizontalOrigin\":\"CENTER\"}}", getStringWriter().toString());
    }

    @Test
    public final void labelStyleCanBeWrittenAsSimpleString() {
        {
            final PacketCesiumWriter usingExpression_10 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_10);
            }
        }
        Assert.assertEquals("{\"foo\":\"FILL_AND_OUTLINE\"}", getStringWriter().toString());
    }

    @Test
    public final void labelStyleCanBeWrittenInsideInterval() {
        JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression_11 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_11);
            }
        }
        Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"labelStyle\":\"FILL_AND_OUTLINE\"}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<BillboardCesiumWriter> createPropertyWriter(String propertyName) {
        return new BillboardCesiumWriter(propertyName);
    }

    private final TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}