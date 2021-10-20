package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.RegexHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGregorianDateFormatting {
    private Locale m_cultureInfo;

    @Before
    public final void setUp() {
        m_cultureInfo = CultureInfoHelper.create("en-US");
    }

    public final void testToStringStandardFormats(String format) {
        ZonedDateTime dateTime = DateTimeHelper.create(2002, 2, 25, 5, 25, 13);
        GregorianDate gregorianDate = new GregorianDate(dateTime);
        // .NET Core on Linux uses different standard formats, so we compare against what DateTime does
        // rather than specific known strings.
        Assert.assertEquals(DateTimeHelper.toString(dateTime, format, m_cultureInfo), gregorianDate.toString(format, m_cultureInfo));
    }

    @Test
    public final void testToStringStandardFormats$TestCase1() {
        testToStringStandardFormats("d");
    }

    @Test
    public final void testToStringStandardFormats$TestCase2() {
        testToStringStandardFormats("D");
    }

    @Test
    public final void testToStringStandardFormats$TestCase3() {
        testToStringStandardFormats("f");
    }

    @Test
    public final void testToStringStandardFormats$TestCase4() {
        testToStringStandardFormats("F");
    }

    @Test
    public final void testToStringStandardFormats$TestCase5() {
        testToStringStandardFormats("g");
    }

    @Test
    public final void testToStringStandardFormats$TestCase6() {
        testToStringStandardFormats("G");
    }

    @Test
    public final void testToStringStandardFormats$TestCase7() {
        testToStringStandardFormats("m");
    }

    @Test
    public final void testToStringStandardFormats$TestCase8() {
        testToStringStandardFormats("M");
    }

    @Test
    public final void testToStringStandardFormats$TestCase9() {
        testToStringStandardFormats("r");
    }

    @Test
    public final void testToStringStandardFormats$TestCase10() {
        testToStringStandardFormats("R");
    }

    @Test
    public final void testToStringStandardFormats$TestCase11() {
        testToStringStandardFormats("s");
    }

    @Test
    public final void testToStringStandardFormats$TestCase12() {
        testToStringStandardFormats("t");
    }

    @Test
    public final void testToStringStandardFormats$TestCase13() {
        testToStringStandardFormats("T");
    }

    @Test
    public final void testToStringStandardFormats$TestCase14() {
        testToStringStandardFormats("u");
    }

    @Test
    public final void testToStringStandardFormats$TestCase15() {
        testToStringStandardFormats("y");
    }

    @Test
    public final void testToStringStandardFormats$TestCase16() {
        testToStringStandardFormats("Y");
    }

    @Test
    public final void testToStringStandardFormats$TestCase17() {
        testToStringStandardFormats("");
    }

    @Test
    public final void testToStringCustomFormats() {
        ZonedDateTime dateTime = DateTimeHelper.create(2002, 2, 25, 5, 25, 13);
        GregorianDate gregorianDate = new GregorianDate(dateTime);
        Assert.assertEquals("25", gregorianDate.toString("%d", m_cultureInfo));
        Assert.assertEquals("25", gregorianDate.toString("dd", m_cultureInfo));
        Assert.assertEquals("Mon", gregorianDate.toString("ddd", m_cultureInfo));
        Assert.assertEquals("Monday", gregorianDate.toString("dddd", m_cultureInfo));
        Assert.assertEquals("2", gregorianDate.toString("%M", m_cultureInfo));
        Assert.assertEquals("02", gregorianDate.toString("MM", m_cultureInfo));
        Assert.assertEquals("Feb", gregorianDate.toString("MMM", m_cultureInfo));
        Assert.assertEquals("February", gregorianDate.toString("MMMM", m_cultureInfo));
        Assert.assertEquals("2", gregorianDate.toString("%y", m_cultureInfo));
        Assert.assertEquals("02", gregorianDate.toString("yy", m_cultureInfo));
        Assert.assertEquals("2002", gregorianDate.toString("yyyy", m_cultureInfo));
        Assert.assertEquals("5", gregorianDate.toString("%h", m_cultureInfo));
        Assert.assertEquals("05", gregorianDate.toString("hh", m_cultureInfo));
        Assert.assertEquals("A", gregorianDate.toString("%t", m_cultureInfo));
        Assert.assertEquals("AM", gregorianDate.toString("tt", m_cultureInfo));
        dateTime = DateTimeHelper.create(2009, 6, 10, 0, 30, 0);
        gregorianDate = new GregorianDate(dateTime);
        Assert.assertEquals("12", gregorianDate.toString("%h", m_cultureInfo));
        Assert.assertEquals("0", gregorianDate.toString("%H", m_cultureInfo));
        dateTime = DateTimeHelper.create(2002, 2, 25, 15, 25, 13);
        gregorianDate = new GregorianDate(dateTime);
        Assert.assertEquals("3", gregorianDate.toString("%h", m_cultureInfo));
        Assert.assertEquals("03", gregorianDate.toString("hh", m_cultureInfo));
        Assert.assertEquals("15", gregorianDate.toString("%H", m_cultureInfo));
        Assert.assertEquals("15", gregorianDate.toString("HH", m_cultureInfo));
        Assert.assertEquals("25", gregorianDate.toString("%m", m_cultureInfo));
        Assert.assertEquals("25", gregorianDate.toString("mm", m_cultureInfo));
        Assert.assertEquals("13", gregorianDate.toString("%s", m_cultureInfo));
        Assert.assertEquals("13", gregorianDate.toString("ss", m_cultureInfo));
        Assert.assertEquals("P", gregorianDate.toString("%t", m_cultureInfo));
        Assert.assertEquals("PM", gregorianDate.toString("tt", m_cultureInfo));
        Assert.assertEquals(" : ", gregorianDate.toString(" : ", m_cultureInfo));
        Assert.assertEquals(" / ", gregorianDate.toString(" / ", m_cultureInfo));
        Assert.assertEquals(" yyy ", gregorianDate.toString(" 'yyy' ", m_cultureInfo));
        Assert.assertEquals(" d", gregorianDate.toString(" \\d", m_cultureInfo));
        Assert.assertEquals("2002", gregorianDate.toString("yyy", m_cultureInfo));
        Assert.assertEquals("0002002", gregorianDate.toString("yyyyyyy", m_cultureInfo));
        gregorianDate = new GregorianDate(999, 1, 2, 3, 4, 5D);
        Assert.assertEquals("999", gregorianDate.toString("yyy", m_cultureInfo));
        Assert.assertEquals("0999", gregorianDate.toString("yyyy", m_cultureInfo));
        // .NET's Double.ToString pads with zeros beyond 15 significant digits.
        // This is kind of obnoxious, but we get the guaranteed precision of
        // a GregorianDate (1e-10 seconds) even so, so it's not worth major
        // heroics to solve.
        gregorianDate = new GregorianDate(2009, 6, 10, 15, 0, 13.012345678912345);
        String s = gregorianDate.toString("ss.fffffffffffffff", m_cultureInfo);
        Assert.assertEquals((int) 18, (int) s.length());
        Assert.assertTrue(StringHelper.startsWith(s, "13.0123456789123"));
        gregorianDate = new GregorianDate(2009, 6, 10, 15, 0, 13.012);
        Assert.assertEquals("13.012000000000000", gregorianDate.toString("ss.fffffffffffffff", m_cultureInfo));
        Assert.assertEquals("13.012", gregorianDate.toString("ss.FFFFFFFFFFFFFFF", m_cultureInfo));
    }

    @Test
    public final void toStringThrowsOnInvalidFormatSpecifier() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                String unused = new GregorianDate(2009, 6, 10).toString("X");
            }
        });
        AssertHelper.assertStringContains("not one of the format specifier characters", exception.getMessage());
    }

    @Test
    public final void cantFormatMoreThan15FractionalSeconds() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                String unused = new GregorianDate(2009, 6, 10).toString("ffffffffffffffff");
            }
        });
        AssertHelper.assertStringContains("Invalid format string", exception.getMessage());
    }

    @Test
    public final void formatSpecifierCantEndWithAPercent() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                String unused = new GregorianDate(2009, 6, 10).toString("f%");
            }
        });
        AssertHelper.assertStringContains("Invalid character % at the end of the format specifier", exception.getMessage());
    }

    @Test
    public final void formatSpecifierCantEndWithABackslash() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                String unused = new GregorianDate(2009, 6, 10).toString("f\\");
            }
        });
        AssertHelper.assertStringContains("Invalid character \\ at the end of the format specifier", exception.getMessage());
    }

    @Test
    public final void formatSpecifierCantHaveADoublePercent() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                String unused = new GregorianDate(2009, 6, 10).toString("%%");
            }
        });
        AssertHelper.assertStringContains("Invalid character %% in format specifier", exception.getMessage());
    }

    @Test
    public final void testFormattingLeapSecond() {
        GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60.444);
        Assert.assertEquals("31 Dec 2008 23:59:60.444", date.toString("d MMM yyyy H:mm:ss.fff", m_cultureInfo));
    }

    public final void toIso8601ExtendedStringProducesCorrectStrings(int year, int month, int day, int hour, int minute, double second, String expectedIsoString) {
        GregorianDate gregorianDate = new GregorianDate(year, month, day, hour, minute, second);
        String isoString = gregorianDate.toIso8601String(Iso8601Format.EXTENDED);
        Assert.assertEquals(expectedIsoString, isoString);
        AssertHelper.assertEquals(gregorianDate, GregorianDate.parse(isoString));
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase1() {
        toIso8601ExtendedStringProducesCorrectStrings(2012, 4, 2, 1, 2, 3.12345, "2012-04-02T01:02:03.12345Z");
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase2() {
        toIso8601ExtendedStringProducesCorrectStrings(2012, 4, 2, 1, 2, 3, "2012-04-02T01:02:03Z");
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase3() {
        toIso8601ExtendedStringProducesCorrectStrings(2012, 4, 2, 1, 2, 0, "2012-04-02T01:02:00Z");
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase4() {
        toIso8601ExtendedStringProducesCorrectStrings(2012, 6, 30, 23, 59, 60.123, "2012-06-30T23:59:60.123Z");
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase5() {
        toIso8601ExtendedStringProducesCorrectStrings(2012, 4, 2, 1, 0, 0, "2012-04-02T01:00:00Z");
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase6() {
        toIso8601ExtendedStringProducesCorrectStrings(2017, 12, 7, 0, 0, 0, "2017-12-07T00:00:00Z");
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase7() {
        toIso8601ExtendedStringProducesCorrectStrings(2017, 12, 7, 0, 1, 0, "2017-12-07T00:01:00Z");
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase8() {
        toIso8601ExtendedStringProducesCorrectStrings(2017, 12, 7, 0, 0, 0.123, "2017-12-07T00:00:00.123Z");
    }

    @Test
    public final void toIso8601ExtendedStringProducesCorrectStrings$TestCase9() {
        toIso8601ExtendedStringProducesCorrectStrings(2017, 12, 7, 2, 0, 32.299, "2017-12-07T02:00:32.299Z");
    }

    public final void toIso8601BasicStringProducesCorrectStrings(int year, int month, int day, int hour, int minute, double second, String expectedIsoString) {
        GregorianDate gregorianDate = new GregorianDate(year, month, day, hour, minute, second);
        String isoString = gregorianDate.toIso8601String(Iso8601Format.BASIC);
        Assert.assertEquals(expectedIsoString, isoString);
        AssertHelper.assertEquals(gregorianDate, GregorianDate.parse(isoString));
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase1() {
        toIso8601BasicStringProducesCorrectStrings(2012, 4, 2, 1, 2, 3.12345, "20120402T010203.12345Z");
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase2() {
        toIso8601BasicStringProducesCorrectStrings(2012, 4, 2, 1, 2, 3, "20120402T010203Z");
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase3() {
        toIso8601BasicStringProducesCorrectStrings(2012, 4, 2, 1, 2, 0, "20120402T010200Z");
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase4() {
        toIso8601BasicStringProducesCorrectStrings(2012, 6, 30, 23, 59, 60.123, "20120630T235960.123Z");
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase5() {
        toIso8601BasicStringProducesCorrectStrings(2012, 4, 2, 1, 0, 0, "20120402T010000Z");
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase6() {
        toIso8601BasicStringProducesCorrectStrings(2017, 12, 7, 0, 0, 0, "20171207T000000Z");
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase7() {
        toIso8601BasicStringProducesCorrectStrings(2017, 12, 7, 0, 1, 0, "20171207T000100Z");
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase8() {
        toIso8601BasicStringProducesCorrectStrings(2017, 12, 7, 0, 0, 0.123, "20171207T000000.123Z");
    }

    @Test
    public final void toIso8601BasicStringProducesCorrectStrings$TestCase9() {
        toIso8601BasicStringProducesCorrectStrings(2017, 12, 7, 2, 0, 32.299, "20171207T020032.299Z");
    }

    public final void toIso8601CompactStringProducesCorrectStrings(int year, int month, int day, int hour, int minute, double second, String expectedIsoString) {
        GregorianDate gregorianDate = new GregorianDate(year, month, day, hour, minute, second);
        String isoString = gregorianDate.toIso8601String(Iso8601Format.COMPACT);
        Assert.assertEquals(expectedIsoString, isoString);
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase1() {
        toIso8601CompactStringProducesCorrectStrings(2012, 4, 2, 1, 2, 3.12345, "20120402T010203.12345Z");
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase2() {
        toIso8601CompactStringProducesCorrectStrings(2012, 4, 2, 1, 2, 3, "20120402T010203Z");
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase3() {
        toIso8601CompactStringProducesCorrectStrings(2012, 4, 2, 1, 2, 0, "20120402T0102Z");
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase4() {
        toIso8601CompactStringProducesCorrectStrings(2012, 6, 30, 23, 59, 60.123, "20120630T235960.123Z");
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase5() {
        toIso8601CompactStringProducesCorrectStrings(2012, 4, 2, 1, 0, 0, "20120402T01Z");
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase6() {
        toIso8601CompactStringProducesCorrectStrings(2017, 12, 7, 0, 0, 0, "20171207T00Z");
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase7() {
        toIso8601CompactStringProducesCorrectStrings(2017, 12, 7, 0, 1, 0, "20171207T0001Z");
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase8() {
        toIso8601CompactStringProducesCorrectStrings(2017, 12, 7, 0, 0, 0.123, "20171207T000000.123Z");
    }

    @Test
    public final void toIso8601CompactStringProducesCorrectStrings$TestCase9() {
        toIso8601CompactStringProducesCorrectStrings(2017, 12, 7, 2, 0, 32.299, "20171207T020032.299Z");
    }

    public final void toIso8601Validation(@Nonnull GregorianDate date) {
        // found this regex online
        Pattern regex = RegexHelper.create(
                "^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?$");
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

    @Test
    public final void toIso8601Validation$TestCase1() {
        for (final GregorianDate date : getToIso8601ValidationValues()) {
            toIso8601Validation(date);
        }
    }

    public static Iterable<GregorianDate> getToIso8601ValidationValues() {
        final ArrayList<GregorianDate> tempCollection$0 = new ArrayList<GregorianDate>();
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 1, 2, 3.12345));
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 1, 2, 0.12345));
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 1, 0, 0.12345));
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 0, 0, 0.12345));
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 1, 2, 0D));
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 1, 0, 0D));
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 0, 0, 0D));
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 0, 1, 0D));
        tempCollection$0.add(new GregorianDate(2012, 4, 2, 0, 0, 1D));
        return tempCollection$0;
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
        GregorianDate gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 59.9999999);
        Assert.assertEquals("2012-08-07 13:59:59.999999", gregorianDate.toString("yyyy-MM-dd HH:mm:ss.ffffff", m_cultureInfo));
    }

    @Test
    public final void wholeNumberSecondsIsFormattedCorrectly() {
        GregorianDate gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
        Assert.assertEquals("2012-08-07 13:59:55.000000", gregorianDate.toString("yyyy-MM-dd HH:mm:ss.ffffff", m_cultureInfo));
        gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
        Assert.assertEquals("2012-08-07 13:59:55", gregorianDate.toString("yyyy-MM-dd HH:mm:ss", m_cultureInfo));
        gregorianDate = new GregorianDate(2012, 8, 7, 13, 59, 55.0);
        Assert.assertEquals("2012-08-07 13:59:55", gregorianDate.toString("yyyy-MM-dd HH:mm:ss.FFFFFF", m_cultureInfo));
    }

    public final void toIso8601StringWithFractionalSeconds(int year, int month, int day, int hour, int minute, double second, String expectedIsoString) {
        GregorianDate gregorianDate = new GregorianDate(year, month, day, hour, minute, second);
        String isoString = gregorianDate.toIso8601String(Iso8601Format.EXTENDED, 6);
        Assert.assertEquals(expectedIsoString, isoString);
    }

    @Test
    public final void toIso8601StringWithFractionalSeconds$TestCase1() {
        toIso8601StringWithFractionalSeconds(2012, 8, 7, 13, 59, 59.9999999, "2012-08-07T13:59:59.999999Z");
    }

    @Test
    public final void toIso8601StringWithFractionalSeconds$TestCase2() {
        toIso8601StringWithFractionalSeconds(2012, 6, 30, 23, 59, 59.999999, "2012-06-30T23:59:59.999999Z");
    }

    @Test
    public final void toIso8601StringWithFractionalSeconds$TestCase3() {
        toIso8601StringWithFractionalSeconds(2012, 6, 30, 23, 59, 59.99999949999999, "2012-06-30T23:59:59.999999Z");
    }

    @Test
    public final void toIso8601StringWithFractionalSeconds$TestCase4() {
        toIso8601StringWithFractionalSeconds(2012, 6, 30, 23, 59, 59.99999950000000, "2012-06-30T23:59:59.999999Z");
    }

    @Test
    public final void toIso8601StringWithFractionalSeconds$TestCase5() {
        toIso8601StringWithFractionalSeconds(2012, 6, 30, 23, 59, 60.0, "2012-06-30T23:59:60.000000Z");
    }

    @Test
    public final void toIso8601StringWithFractionalSeconds$TestCase6() {
        toIso8601StringWithFractionalSeconds(2012, 6, 30, 23, 59, 60.99999949999999, "2012-06-30T23:59:60.999999Z");
    }

    @Test
    public final void toIso8601StringWithFractionalSeconds$TestCase7() {
        toIso8601StringWithFractionalSeconds(2012, 6, 30, 23, 59, 60.99999950000000, "2012-06-30T23:59:60.999999Z");
    }

    @Test
    public final void fractionalSecondsCloseToZeroAreFormattedCorrectly() {
        // Based on BUG71966: GregorianDate.ToString(format) produces incorrect value for fractional seconds
        GregorianDate date = new GregorianDate(2012, 2, 25, 0, 15, 0.000000000014551915228366852);
        Assert.assertEquals("001500.0000000", date.toString("HHmmss.fffffff", m_cultureInfo));
    }

    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }

    @Nonnull
    private final ExpectedException rule$expectedException = ExpectedException.none();

    @Nonnull
    @Rule
    public ExpectedException getRule$expectedException() {
        return rule$expectedException;
    }
}