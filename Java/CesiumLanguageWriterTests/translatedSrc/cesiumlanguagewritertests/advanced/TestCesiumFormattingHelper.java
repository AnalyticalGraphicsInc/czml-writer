package cesiumlanguagewritertests.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewritertests.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCesiumFormattingHelper {
    @Test
    public final void passToIso8601Interval() {
        //Since ToIso8601Interval is just a simple wrapper around two calls to
        //CesiumFormattingHelper.ToIso8601, this test is just a smoke screen.
        String expectedBasicInterval = "19800801T000000Z/20720703T000000Z";
        String expectedExtendedInterval = "1980-08-01T00:00:00Z/2072-07-03T00:00:00Z";
        String expectedCompactInterval = "19800801T00Z/20720703T00Z";
        JulianDate start = new GregorianDate(1980, 8, 1).toJulianDate();
        JulianDate stop = new GregorianDate(2072, 7, 3).toJulianDate();
        String basicInterval = CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.BASIC);
        Assert.assertEquals(expectedBasicInterval, basicInterval);
        String extendedInterval = CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.EXTENDED);
        Assert.assertEquals(expectedExtendedInterval, extendedInterval);
        String compactInterval = CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT);
        Assert.assertEquals(expectedCompactInterval, compactInterval);
        TimeInterval interval = new TimeInterval(start, stop);
        basicInterval = CesiumFormattingHelper.toIso8601Interval(interval, Iso8601Format.BASIC);
        Assert.assertEquals(expectedBasicInterval, basicInterval);
        extendedInterval = CesiumFormattingHelper.toIso8601Interval(interval, Iso8601Format.EXTENDED);
        Assert.assertEquals(expectedExtendedInterval, extendedInterval);
        compactInterval = CesiumFormattingHelper.toIso8601Interval(interval, Iso8601Format.COMPACT);
        Assert.assertEquals(expectedCompactInterval, compactInterval);
    }

    @Test
    public final void passClampToIso8601() {
        String expected = GregorianDate.MinValue.toIso8601String(Iso8601Format.BASIC);
        String actual = CesiumFormattingHelper.toIso8601(JulianDate.getMinValue(), Iso8601Format.BASIC);
        Assert.assertEquals(expected, actual);
        actual = CesiumFormattingHelper.toIso8601(GregorianDate.MinValue.toJulianDate(), Iso8601Format.BASIC);
        Assert.assertEquals(expected, actual);
        expected = GregorianDate.MaxValue.toIso8601String(Iso8601Format.BASIC);
        actual = CesiumFormattingHelper.toIso8601(JulianDate.getMaxValue(), Iso8601Format.BASIC);
        Assert.assertEquals(expected, actual);
        actual = CesiumFormattingHelper.toIso8601(GregorianDate.MaxValue.toJulianDate(), Iso8601Format.BASIC);
        Assert.assertEquals(expected, actual);
        expected = GregorianDate.MinValue.toIso8601String(Iso8601Format.EXTENDED);
        actual = CesiumFormattingHelper.toIso8601(JulianDate.getMinValue(), Iso8601Format.EXTENDED);
        Assert.assertEquals(expected, actual);
        expected = GregorianDate.MaxValue.toIso8601String(Iso8601Format.EXTENDED);
        actual = CesiumFormattingHelper.toIso8601(JulianDate.getMaxValue(), Iso8601Format.EXTENDED);
        Assert.assertEquals(expected, actual);
        expected = GregorianDate.MinValue.toIso8601String(Iso8601Format.COMPACT);
        actual = CesiumFormattingHelper.toIso8601(JulianDate.getMinValue(), Iso8601Format.COMPACT);
        Assert.assertEquals(expected, actual);
        expected = GregorianDate.MaxValue.toIso8601String(Iso8601Format.COMPACT);
        actual = CesiumFormattingHelper.toIso8601(JulianDate.getMaxValue(), Iso8601Format.COMPACT);
        Assert.assertEquals(expected, actual);
    }

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}