package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ExpectedExceptionHelper;
import agi.foundation.compatibility.ObjectHelper;
import agi.foundation.compatibility.RegexHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import java.util.Locale;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGregorianDateFormatting {
    @Before
    public void setUp() {
        m_cultureInfo = new Locale("en-US");
    }

    @Test
    public final void testToString() {
        GregorianDate date = new GregorianDate(2002, 2, 25, 5, 25, 13D);
        Assert.assertEquals("2/25/2002", date.toString("d", m_cultureInfo));
        Assert.assertEquals("Monday, February 25, 2002", date.toString("D", m_cultureInfo));
        Assert.assertEquals("Monday, February 25, 2002 5:25 AM", date.toString("f", m_cultureInfo));
        Assert.assertEquals("Monday, February 25, 2002 5:25:13 AM", date.toString("F", m_cultureInfo));
        Assert.assertEquals("2/25/2002 5:25 AM", date.toString("g", m_cultureInfo));
        Assert.assertEquals("2/25/2002 5:25:13 AM", date.toString("G", m_cultureInfo));
        Assert.assertEquals("February 25", date.toString("m", m_cultureInfo));
        Assert.assertEquals("February 25", date.toString("M", m_cultureInfo));
        Assert.assertEquals("Mon, 25 Feb 2002 05:25:13 GMT", date.toString("r", m_cultureInfo));
        Assert.assertEquals("Mon, 25 Feb 2002 05:25:13 GMT", date.toString("R", m_cultureInfo));
        Assert.assertEquals("2002-02-25T05:25:13", date.toString("s", m_cultureInfo));
        Assert.assertEquals("5:25 AM", date.toString("t", m_cultureInfo));
        Assert.assertEquals("5:25:13 AM", date.toString("T", m_cultureInfo));
        Assert.assertEquals("2002-02-25 05:25:13Z", date.toString("u", m_cultureInfo));
        // Windows 8 changed to no longer include a comma after the month.  Either is ok.
        String smallY = date.toString("y", m_cultureInfo);
        Assert.assertTrue(ObjectHelper.equals(smallY, "February, 2002") || ObjectHelper.equals(smallY, "February 2002"));
        String bigY = date.toString("Y", m_cultureInfo);
        Assert.assertTrue(ObjectHelper.equals(bigY, "February, 2002") || ObjectHelper.equals(bigY, "February 2002"));
        Assert.assertEquals("2/25/2002 5:25:13 AM", date.toString("", m_cultureInfo));
        Assert.assertEquals("25", date.toString("%d", m_cultureInfo));
        Assert.assertEquals("25", date.toString("dd", m_cultureInfo));
        Assert.assertEquals("Mon", date.toString("ddd", m_cultureInfo));
        Assert.assertEquals("Monday", date.toString("dddd", m_cultureInfo));
        Assert.assertEquals("2", date.toString("%M", m_cultureInfo));
        Assert.assertEquals("02", date.toString("MM", m_cultureInfo));
        Assert.assertEquals("Feb", date.toString("MMM", m_cultureInfo));
        Assert.assertEquals("February", date.toString("MMMM", m_cultureInfo));
        Assert.assertEquals("2", date.toString("%y", m_cultureInfo));
        Assert.assertEquals("02", date.toString("yy", m_cultureInfo));
        Assert.assertEquals("2002", date.toString("yyyy", m_cultureInfo));
        Assert.assertEquals("5", date.toString("%h", m_cultureInfo));
        Assert.assertEquals("05", date.toString("hh", m_cultureInfo));
        Assert.assertEquals("A", date.toString("%t", m_cultureInfo));
        Assert.assertEquals("AM", date.toString("tt", m_cultureInfo));
        date = new GregorianDate(2009, 6, 10, 0, 30, 0D);
        Assert.assertEquals("12", date.toString("%h", m_cultureInfo));
        Assert.assertEquals("0", date.toString("%H", m_cultureInfo));
        date = new GregorianDate(2002, 2, 25, 15, 25, 13D);
        Assert.assertEquals("3", date.toString("%h", m_cultureInfo));
        Assert.assertEquals("03", date.toString("hh", m_cultureInfo));
        Assert.assertEquals("15", date.toString("%H", m_cultureInfo));
        Assert.assertEquals("15", date.toString("HH", m_cultureInfo));
        Assert.assertEquals("25", date.toString("%m", m_cultureInfo));
        Assert.assertEquals("25", date.toString("mm", m_cultureInfo));
        Assert.assertEquals("13", date.toString("%s", m_cultureInfo));
        Assert.assertEquals("13", date.toString("ss", m_cultureInfo));
        Assert.assertEquals("P", date.toString("%t", m_cultureInfo));
        Assert.assertEquals("PM", date.toString("tt", m_cultureInfo));
        Assert.assertEquals("A.D.", date.toString("%g", m_cultureInfo));
        Assert.assertEquals(" : ", date.toString(" : ", m_cultureInfo));
        Assert.assertEquals(" / ", date.toString(" / ", m_cultureInfo));
        Assert.assertEquals(" yyy ", date.toString(" 'yyy' ", m_cultureInfo));
        Assert.assertEquals(" d", date.toString(" \\d", m_cultureInfo));
        Assert.assertEquals("2002", date.toString("yyy", m_cultureInfo));
        Assert.assertEquals("0002002", date.toString("yyyyyyy", m_cultureInfo));
        date = new GregorianDate(999, 1, 2, 3, 4, 5D);
        Assert.assertEquals("999", date.toString("yyy", m_cultureInfo));
        Assert.assertEquals("0999", date.toString("yyyy", m_cultureInfo));
        // .NET's Double.ToString pads with zeros beyond 15 significant digits.
        // This is kind of obnoxious, but we get the guaranteed precision of
        // a GregorianDate (1e-10 seconds) even so, so it's not worth major
        // heroics to solve.
        date = new GregorianDate(2009, 6, 10, 15, 0, 13.012345678912345);
        String s = date.toString("ss.fffffffffffffff", m_cultureInfo);
        Assert.assertEquals((int) 18, (int) s.length());
        Assert.assertTrue(StringHelper.startsWith(s, "13.0123456789123"));
        date = new GregorianDate(2009, 6, 10, 15, 0, 13.012);
        Assert.assertEquals("13.012000000000000", date.toString("ss.fffffffffffffff", m_cultureInfo));
        Assert.assertEquals("13.012", date.toString("ss.FFFFFFFFFFFFFFF", m_cultureInfo));
    }

    @Test
    public final void toStringThrowsOnInvalidFormatSpecifier() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), NumberFormatException.class);
        String unused = new GregorianDate(2009, 6, 10).toString("X");
    }

    @Test
    public final void cantFormatMoreThan15FractionalSeconds() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), NumberFormatException.class);
        String unused = new GregorianDate(2009, 6, 10).toString("ffffffffffffffff");
    }

    @Test
    public final void cantEndWithAPercent() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), NumberFormatException.class);
        String unused = new GregorianDate(2009, 6, 10).toString("f%");
    }

    @Test
    public final void cantEndWithABackslash() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), NumberFormatException.class);
        String unused = new GregorianDate(2009, 6, 10).toString("f\\");
    }

    @Test
    public final void cantHaveADoublePercent() {
        ExpectedExceptionHelper.expectException(getRule$expectedException(), NumberFormatException.class);
        String unused = new GregorianDate(2009, 6, 10).toString("%%");
    }

    @Test
    public final void testFormattingLeapSecond() {
        GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60.444);
        Assert.assertEquals("31 Dec 2008 23:59:60.444", date.toString("d MMM yyyy H:mm:ss.fff", m_cultureInfo));
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings() {
        String iso = new GregorianDate(2012, 4, 2, 1, 2, 3.12345).toIso8601String(Iso8601Format.EXTENDED);
        Assert.assertEquals("2012-04-02T01:02:03.12345Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 3D).toIso8601String(Iso8601Format.EXTENDED);
        Assert.assertEquals("2012-04-02T01:02:03Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 3D).toIso8601String(Iso8601Format.EXTENDED);
        Assert.assertEquals("2012-04-02T01:02:03Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 0D).toIso8601String(Iso8601Format.EXTENDED);
        Assert.assertEquals("2012-04-02T01:02:00Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 0D).toIso8601String(Iso8601Format.EXTENDED);
        Assert.assertEquals("2012-04-02T01:02:00Z", iso);
        iso = new GregorianDate(2012, 6, 30, 23, 59, 60.123).toIso8601String(Iso8601Format.EXTENDED);
        Assert.assertEquals("2012-06-30T23:59:60.123Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 0, 0D).toIso8601String(Iso8601Format.EXTENDED);
        Assert.assertEquals("2012-04-02T01:00:00Z", iso);
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings() {
        String iso = new GregorianDate(2012, 4, 2, 1, 2, 3.12345).toIso8601String(Iso8601Format.BASIC);
        Assert.assertEquals("20120402T010203.12345Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 3D).toIso8601String(Iso8601Format.BASIC);
        Assert.assertEquals("20120402T010203Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 3D).toIso8601String(Iso8601Format.BASIC);
        Assert.assertEquals("20120402T010203Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 0D).toIso8601String(Iso8601Format.BASIC);
        Assert.assertEquals("20120402T010200Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 0D).toIso8601String(Iso8601Format.BASIC);
        Assert.assertEquals("20120402T010200Z", iso);
        iso = new GregorianDate(2012, 6, 30, 23, 59, 60.123).toIso8601String(Iso8601Format.BASIC);
        Assert.assertEquals("20120630T235960.123Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 0, 0D).toIso8601String(Iso8601Format.BASIC);
        Assert.assertEquals("20120402T010000Z", iso);
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings() {
        String iso = new GregorianDate(2012, 4, 2, 1, 2, 3.12345).toIso8601String(Iso8601Format.COMPACT);
        Assert.assertEquals("20120402T010203.12345Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 3D).toIso8601String(Iso8601Format.COMPACT);
        Assert.assertEquals("20120402T010203Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 3D).toIso8601String(Iso8601Format.COMPACT);
        Assert.assertEquals("20120402T010203Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 0D).toIso8601String(Iso8601Format.COMPACT);
        Assert.assertEquals("20120402T0102Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 2, 0D).toIso8601String(Iso8601Format.COMPACT);
        Assert.assertEquals("20120402T0102Z", iso);
        iso = new GregorianDate(2012, 6, 30, 23, 59, 60.123).toIso8601String(Iso8601Format.COMPACT);
        Assert.assertEquals("20120630T235960.123Z", iso);
        iso = new GregorianDate(2012, 4, 2, 1, 0, 0D).toIso8601String(Iso8601Format.COMPACT);
        Assert.assertEquals("20120402T01Z", iso);
    }

    @Test
    public final void toIso8601Validation() {
        cesiumlanguagewriter.GregorianDate[] dates = new cesiumlanguagewriter.GregorianDate[] {
                new GregorianDate(2012, 4, 2, 1, 2, 3.12345),
                new GregorianDate(2012, 4, 2, 1, 2, 0D),
                new GregorianDate(2012, 4, 2, 1, 0, 0D),
                new GregorianDate(2012, 4, 2, 0, 0, 0D)
        };
        // found this regex online
        Pattern regex = RegexHelper
                .create("^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?$");
        for (final cesiumlanguagewriter.GregorianDate date : dates) {
            String s = date.toIso8601String();
            Assert.assertTrue(RegexHelper.isMatch(regex, s));
            s = date.toIso8601String(Iso8601Format.BASIC);
            Assert.assertTrue(RegexHelper.isMatch(regex, s));
            s = date.toIso8601String(Iso8601Format.COMPACT);
            Assert.assertTrue(RegexHelper.isMatch(regex, s));
            s = date.toIso8601String(Iso8601Format.EXTENDED);
            Assert.assertTrue(RegexHelper.isMatch(regex, s));
            for (int numDigits = 0; numDigits <= 15; ++numDigits) {
                s = date.toIso8601String(Iso8601Format.BASIC, numDigits);
                Assert.assertTrue(RegexHelper.isMatch(regex, s));
                s = date.toIso8601String(Iso8601Format.COMPACT, numDigits);
                Assert.assertTrue(RegexHelper.isMatch(regex, s));
                s = date.toIso8601String(Iso8601Format.EXTENDED, numDigits);
                Assert.assertTrue(RegexHelper.isMatch(regex, s));
            }
        }
    }

    @Test
    public final void secondsAreCorrectlyFormattedToDifferentNumbersOfDigits() {
        GregorianDate first = new GregorianDate(2009, 2, 7, 5, 41, 44.408);
        Assert.assertEquals("44.408", first.toString("ss.fff", m_cultureInfo));
        Assert.assertEquals("44.4080", first.toString("ss.ffff", m_cultureInfo));
        Assert.assertEquals("44.40800", first.toString("ss.fffff", m_cultureInfo));
    }

    @Test
    public final void toStringTruncatesSeconds() {
        GregorianDate gd = new GregorianDate(2012, 8, 7, 13, 59, 59.9999999);
        Assert.assertEquals("2012-08-07 13:59:59.999999", gd.toString("yyyy-MM-dd HH:mm:ss.ffffff", m_cultureInfo));
    }

    @Test
    public final void wholeNumberSecondsIsFormattedCorrectly() {
        GregorianDate gd = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
        Assert.assertEquals("2012-08-07 13:59:55.000000", gd.toString("yyyy-MM-dd HH:mm:ss.ffffff", m_cultureInfo));
        gd = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
        Assert.assertEquals("2012-08-07 13:59:55", gd.toString("yyyy-MM-dd HH:mm:ss", m_cultureInfo));
        gd = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
        Assert.assertEquals("2012-08-07 13:59:55", gd.toString("yyyy-MM-dd HH:mm:ss.FFFFFF", m_cultureInfo));
    }

    @Test
    public final void toIso8601StringWithFractionalSeconds() {
        GregorianDate gd = new GregorianDate(2012, 8, 7, 13, 59, 59.9999999);
        Assert.assertEquals("2012-08-07T13:59:59.999999Z", gd.toIso8601String(Iso8601Format.EXTENDED, 6));
        // Leap second test cases.
        gd = new GregorianDate(2012, 6, 30, 23, 59, 59.999999);
        Assert.assertEquals("2012-06-30T23:59:59.999999Z", gd.toIso8601String(Iso8601Format.EXTENDED, 6));
        gd = new GregorianDate(2012, 6, 30, 23, 59, 59.99999949999999);
        Assert.assertEquals("2012-06-30T23:59:59.999999Z", gd.toIso8601String(Iso8601Format.EXTENDED, 6));
        gd = new GregorianDate(2012, 6, 30, 23, 59, 59.99999950000000);
        Assert.assertEquals("2012-06-30T23:59:59.999999Z", gd.toIso8601String(Iso8601Format.EXTENDED, 6));
        gd = new GregorianDate(2012, 6, 30, 23, 59, 60.0);
        Assert.assertEquals("2012-06-30T23:59:60.000000Z", gd.toIso8601String(Iso8601Format.EXTENDED, 6));
        gd = new GregorianDate(2012, 6, 30, 23, 59, 60.99999949999999);
        Assert.assertEquals("2012-06-30T23:59:60.999999Z", gd.toIso8601String(Iso8601Format.EXTENDED, 6));
        gd = new GregorianDate(2012, 6, 30, 23, 59, 60.99999950000000);
        Assert.assertEquals("2012-06-30T23:59:60.999999Z", gd.toIso8601String(Iso8601Format.EXTENDED, 6));
    }

    @Test
    public final void fractionalSecondsCloseToZeroAreFormattedCorrectly() {
        // Based on BUG71966: GregorianDate.ToString(format) produces incorrect value for fractional seconds
        cesiumlanguagewriter.GregorianDate date = new GregorianDate(2012, 2, 25, 0, 15, 0.000000000014551915228366852);
        Assert.assertEquals("001500.0000000", date.toString("HHmmss.fffffff", m_cultureInfo));
    }

    private Locale m_cultureInfo;
    private final TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }

    private final ExpectedException rule$expectedException = ExpectedException.none();

    @Rule
    public ExpectedException getRule$expectedException() {
        return rule$expectedException;
    }
}