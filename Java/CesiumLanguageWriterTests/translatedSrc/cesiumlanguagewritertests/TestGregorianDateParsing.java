package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import java.time.ZonedDateTime;
import java.util.Locale;
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
public class TestGregorianDateParsing {
    private Locale m_cultureInfo;

    @Before
    public final void setUp() {
        m_cultureInfo = CultureInfoHelper.create("en-US");
    }

    @Test
    public final void testParseIso8601DayOfYear() {
        GregorianDate iso = new GregorianDate(1985, 2, 11, 2, 0, 5.2134);
        GregorianDate result = GregorianDate.parse("1985-042T02:00:05.2134");
        AssertHelper.assertEquals(iso, result);
        iso = new GregorianDate(1985, 2, 11, 2, 0, 5.21345);
        result = GregorianDate.parse("1985-042T02:00:05.21345Z");
        AssertHelper.assertEquals(iso, result);
        iso = new GregorianDate(1985, 2, 11, 2, 0, 5D);
        result = GregorianDate.parse("1985-042T02:00:05");
        AssertHelper.assertEquals(iso, result);
        iso = new GregorianDate(1985, 2, 11);
        result = GregorianDate.parse("1985-042");
        AssertHelper.assertEquals(iso, result);
        // Make sure to check each month to ensure we have it right
        final String first = "1986-";
        final String last = "T02:01:04Z";
        JulianDate baseDate = new GregorianDate(1986, 1, 12, 2, 1, 4D).toJulianDate();
        for (int i = 1; i < 12; i++) {
            String testString = StringHelper.format(first + "{0:000}" + last, 12 + i * 30);
            GregorianDate expected = baseDate.addDays(i * 30).toGregorianDate();
            AssertHelper.assertEquals(expected, GregorianDate.parse(testString));
        }
    }

    @Test
    public final void testTryParseIso8601DayOfYear() {
        GregorianDate iso = new GregorianDate(1985, 2, 11, 2, 0, 5.2134);
        @CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
        GregorianDate result = new GregorianDate();
        final GregorianDate[] out$result$0 = {
            null
        };
        Assert.assertTrue(GregorianDate.tryParse("1985-042T02:00:05.2134", out$result$0));
        result = out$result$0[0];
        AssertHelper.assertEquals(iso, result);
        iso = new GregorianDate(1985, 2, 11, 2, 0, 5.21345);
        final GregorianDate[] out$result$1 = {
            null
        };
        Assert.assertTrue(GregorianDate.tryParse("1985-042T02:00:05.21345Z", out$result$1));
        result = out$result$1[0];
        AssertHelper.assertEquals(iso, result);
        iso = new GregorianDate(1985, 2, 11, 2, 0, 5D);
        final GregorianDate[] out$result$2 = {
            null
        };
        Assert.assertTrue(GregorianDate.tryParse("1985-042T02:00:05", out$result$2));
        result = out$result$2[0];
        AssertHelper.assertEquals(iso, result);
        iso = new GregorianDate(1985, 2, 11);
        final GregorianDate[] out$result$3 = {
            null
        };
        Assert.assertTrue(GregorianDate.tryParse("1985-042", out$result$3));
        result = out$result$3[0];
        AssertHelper.assertEquals(iso, result);
        final GregorianDate[] out$result$4 = {
            null
        };
        Assert.assertFalse(GregorianDate.tryParse("1985-367T02:00:05.2134", out$result$4));
        result = out$result$4[0];
        final GregorianDate[] out$result$5 = {
            null
        };
        Assert.assertFalse(GregorianDate.tryParse("1985-12#T02:00:05.2134", out$result$5));
        result = out$result$5[0];
        final GregorianDate[] out$result$6 = {
            null
        };
        Assert.assertFalse(GregorianDate.tryParse("21985-167T02:00:05.2134", out$result$6));
        result = out$result$6[0];
    }

    @Test
    public final void testParseIso8601DayOfYearOutOfRange() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                GregorianDate unused = GregorianDate.parse("1985-367T02:00:05.2134");
            }
        });
        AssertHelper.assertStringContains("was not recognized as a valid GregorianDate", exception.getMessage());
    }

    @Test
    public final void testParseIso8601DayOfYearError() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                GregorianDate unused = GregorianDate.parse("1985-12#T02:00:05.2134");
            }
        });
        AssertHelper.assertStringContains("was not recognized as a valid GregorianDate", exception.getMessage());
    }

    @Test
    public final void testParseIso8601YearOutOfRange() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                GregorianDate unused = GregorianDate.parse("21985-167T02:00:05.2134");
            }
        });
        AssertHelper.assertStringContains("was not recognized as a valid GregorianDate", exception.getMessage());
    }

    public final void testParseIso8601Formats(@Nonnull Iso8601Format format) {
        GregorianDate expected = new GregorianDate(1985, 4, 12, 10, 15, 30D);
        AssertHelper.assertEquals(expected, GregorianDate.parse(expected.toIso8601String(format)));
        expected = new GregorianDate(1985, 4, 12, 10, 15, 0D);
        AssertHelper.assertEquals(expected, GregorianDate.parse(expected.toIso8601String(format)));
        expected = new GregorianDate(1985, 4, 12, 10, 0, 0D);
        AssertHelper.assertEquals(expected, GregorianDate.parse(expected.toIso8601String(format)));
        expected = new GregorianDate(1985, 4, 12, 0, 0, 0D);
        AssertHelper.assertEquals(expected, GregorianDate.parse(expected.toIso8601String(format)));
    }

    @Test
    public final void testParseIso8601Formats$TestCase1() {
        testParseIso8601Formats(Iso8601Format.BASIC);
    }

    @Test
    public final void testParseIso8601Formats$TestCase2() {
        testParseIso8601Formats(Iso8601Format.COMPACT);
    }

    @Test
    public final void testParseIso8601Formats$TestCase3() {
        testParseIso8601Formats(Iso8601Format.EXTENDED);
    }

    @Test
    public final void testToIso8601String() {
        // Full format
        final String isoString = "1985-04-12T10:15:30Z";
        GregorianDate iso = new GregorianDate(1985, 4, 12, 10, 15, 30D);
        GregorianDate result = GregorianDate.parse(isoString);
        AssertHelper.assertEquals(iso, result);
        String resultString = result.toIso8601String();
        Assert.assertEquals(isoString, resultString);
        Assert.assertEquals(isoString, iso.toIso8601String());
    }

    @Test
    public final void testParseIso8601InvalidDay() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                GregorianDate unused = GregorianDate.parse("2009-02-30");
            }
        });
        AssertHelper.assertStringContains("was not recognized as a valid GregorianDate", exception.getMessage());
    }

    @Test
    public final void testParseExact() {
        GregorianDate expected = new GregorianDate(2002, 2, 25);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("d", m_cultureInfo), "d", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("D", m_cultureInfo), "D", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 25, 5, 25, 0D);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("f", m_cultureInfo), "f", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("g", m_cultureInfo), "g", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 25, 5, 25, 13D);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("F", m_cultureInfo), "F", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("G", m_cultureInfo), "G", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("s", m_cultureInfo), "s", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("Monday, 25 February 2002 05:25:13", "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 25, 4, 25, 13D);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("U", m_cultureInfo), "U", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("u", m_cultureInfo), "u", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("r", m_cultureInfo), "r", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("R", m_cultureInfo), "R", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), 2, 25);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("m", m_cultureInfo), "m", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("M", m_cultureInfo), "M", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthValue(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 0D);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("t", m_cultureInfo), "t", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthValue(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13D);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("T", m_cultureInfo), "T", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 1);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("y", m_cultureInfo), "y", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact(expected.toString("Y", m_cultureInfo), "Y", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), 1, 25);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("25", "%d", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("25", "dd", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), 2, 1);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("2", "%M", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("02", "MM", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("Feb", "MMM", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("February", "MMMM", m_cultureInfo));
        expected = new GregorianDate(2005, 1, 1);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("5", "%y", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("05", "yy", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("2005", "yyyy", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthValue(), DateTimeHelper.today().getDayOfMonth(), 5, 0, 0D);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("5A", "ht", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("05A", "hht", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("5", "%H", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("05", "HH", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthValue(), DateTimeHelper.today().getDayOfMonth(), 15, 0, 0D);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("3P", "ht", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("03P", "hht", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("15", "%H", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("15", "HH", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 25, 5, 25, 13.444);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("Monday, 25 February 2002 05:25:13.444", "dddd, dd MMMM yyyy HH:mm:ss.fff", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthValue(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13.4444444);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("05:25:13.4444444", "HH:mm:ss.fffffff", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthValue(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13.1234567);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("05:25:13.1234567", "HH:mm:ss.fffffff", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 13.1234567890);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:13.1234567890", "MM/dd/yyyy HH:mm:ss.ffffffffff", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 13.44444444444444);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:13.44444444444444", "MM/dd/yyyy HH:mm:ss.ffffffffffffff", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901234);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:13.12345678901234", "MM/dd/yyyy HH:mm:ss.ffffffffffffff", m_cultureInfo));
        AssertHelper.assertNotEqual(expected, GregorianDate.parseExact("06/30/2009 05:25:13.123456789012345", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 13.444444444444444);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:13.444444444444444", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));
        AssertHelper.assertNotEqual(expected, GregorianDate.parseExact("06/30/2009 05:25:13.444444444444446", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 0.1234567890123456);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:00.1234567890123456", "MM/dd/yyyy HH:mm:ss.ffffffffffffffff", m_cultureInfo));
        AssertHelper.assertNotEqual(expected, GregorianDate.parseExact("06/30/2009 05:25:00.1234567890123459", "MM/dd/yyyy HH:mm:ss.ffffffffffffffff", m_cultureInfo));
    }

    @Test
    public final void parseExactThrowsOnInvalidFormat() {
        AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                GregorianDate.parseExact("1/1/2009", "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo);
            }
        });
    }

    @Test
    public final void parseExactThrowsWithNullFormat() {
        final String format = null;
        // ReSharper disable once AssignNullToNotNullAttribute
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                GregorianDate.parseExact("1/1/2009", format, m_cultureInfo);
            }
        });
        AssertHelper.assertStringContains("Invalid format string", exception.getMessage());
    }

    @Test
    public final void parseExactThrowsWithNullInput() {
        // ReSharper disable once AssignNullToNotNullAttribute
        ArgumentNullException exception = AssertHelper.<ArgumentNullException> assertThrows(new TypeLiteral<ArgumentNullException>() {}, new Action() {
            public void invoke() {
                GregorianDate.parseExact(null, "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo);
            }
        });
        Assert.assertEquals("s", exception.getParamName());
    }

    @Test
    public final void testParse() {
        GregorianDate expected = new GregorianDate(2002, 2, 25);
        AssertHelper.assertEquals(expected, GregorianDate.parse("02/25/2002", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2/25/2002", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2002-02-25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2002-2-25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("Monday, 25 February 2002", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("Mon,02/25/2002", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("Mon,2/25/2002", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 25, 5, 25, 0D);
        AssertHelper.assertEquals(expected, GregorianDate.parse("Monday, 25 February 2002 05:25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02/25/2002 05:25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2/25/2002 05:25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2/25/2002 5:25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2002-02-25T05:25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2002-2-25T05:25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2-2002-25 05:25", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2-2002-25 5:25", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 25, 5, 25, 13D);
        AssertHelper.assertEquals(expected, GregorianDate.parse("Monday, 25 February 2002 05:25:13", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02/25/2002 05:25:13", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02/25/2002 5:25:13", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2/25/2002 5:25:13", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2002-02-25T05:25:13", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25T05:25:13", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25:13", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 5:25:13", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25:13 Mon", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 5:25:13 Mon", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25:13 Monday", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 5:25:13 Monday", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 25, 4, 25, 13D);
        AssertHelper.assertEquals(expected, GregorianDate.parse("2002-02-25 04:25:13Z", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("Mon, 25 Feb 2002 04:25:13 GMT", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 25, 5, 25, 13.008);
        AssertHelper.assertEquals(expected, GregorianDate.parse("02/25/2002 05:25:13.008", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02/25/2002 5:25:13.008", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("2002-02-25T05:25:13.008", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25T05:25:13.008", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25:13.008", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("02-2002-25 5:25:13.008", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), 2, 25);
        AssertHelper.assertEquals(expected, GregorianDate.parse("February 25", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), 2, 8);
        AssertHelper.assertEquals(expected, GregorianDate.parse("February 08", m_cultureInfo));
        AssertHelper.assertEquals(expected, GregorianDate.parse("February 8", m_cultureInfo));
        expected = new GregorianDate(2002, 2, 1);
        AssertHelper.assertEquals(expected, GregorianDate.parse("2002 February", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthValue(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13.4444444);
        AssertHelper.assertEquals(expected, GregorianDate.parse("05:25:13.4444444", m_cultureInfo));
        expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthValue(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13.1234567);
        AssertHelper.assertEquals(expected, GregorianDate.parse("05:25:13.1234567", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 13.1234567890);
        AssertHelper.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:13.1234567890", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 13.44444444444444);
        AssertHelper.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:13.44444444444444", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901234);
        AssertHelper.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:13.12345678901234", m_cultureInfo));
        AssertHelper.assertNotEqual(expected, GregorianDate.parse("06/30/2009 05:25:13.12345678901239", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 13.444444444444444);
        AssertHelper.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:13.444444444444444", m_cultureInfo));
        AssertHelper.assertNotEqual(expected, GregorianDate.parse("06/30/2009 05:25:13.444444444444446", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 0.1234567890123456);
        AssertHelper.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:00.1234567890123456", m_cultureInfo));
        AssertHelper.assertNotEqual(expected, GregorianDate.parse("06/30/2009 05:25:00.1234567890123459", m_cultureInfo));
        expected = new GregorianDate(2009, 6, 30, 5, 25, 0.1234567890123456);
        @CS2JInfo("Initialization of C# struct variable 'parsed' added by translator.")
        GregorianDate parsed = new GregorianDate();
        final GregorianDate[] out$parsed$7 = {
            null
        };
        GregorianDate.tryParse("06/30/2009 05:25:00.1234567890123456", out$parsed$7);
        parsed = out$parsed$7[0];
        AssertHelper.assertEquals(expected, parsed);
    }

    @Test
    public final void parseThrowsWithNullInput() {
        // ReSharper disable once AssignNullToNotNullAttribute
        ArgumentNullException exception = AssertHelper.<ArgumentNullException> assertThrows(new TypeLiteral<ArgumentNullException>() {}, new Action() {
            public void invoke() {
                GregorianDate.parse(null, m_cultureInfo);
            }
        });
        Assert.assertEquals("s", exception.getParamName());
    }

    @Test
    public final void parseThrowsWithNullInputWithoutCultureInfo() {
        // ReSharper disable once AssignNullToNotNullAttribute
        ArgumentNullException exception = AssertHelper.<ArgumentNullException> assertThrows(new TypeLiteral<ArgumentNullException>() {}, new Action() {
            public void invoke() {
                GregorianDate.parse(null);
            }
        });
        Assert.assertEquals("s", exception.getParamName());
    }

    @Test
    public final void parseThrowsFormatExceptionWhenNoMatch() {
        NumberFormatException exception = AssertHelper.<NumberFormatException> assertThrows(new TypeLiteral<NumberFormatException>() {}, new Action() {
            public void invoke() {
                GregorianDate.parse("February Q, 2009", m_cultureInfo);
            }
        });
        AssertHelper.assertStringContains("was not recognized as a valid GregorianDate", exception.getMessage());
    }

    @Test
    public final void testTryParse() {
        GregorianDate expected = new GregorianDate(2002, 2, 25);
        @CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
        GregorianDate result = new GregorianDate();
        final GregorianDate[] out$result$8 = {
            null
        };
        Assert.assertTrue(GregorianDate.tryParse("02/25/2002", m_cultureInfo, out$result$8));
        result = out$result$8[0];
        AssertHelper.assertEquals(expected, result);
        final GregorianDate[] out$result$9 = {
            null
        };
        Assert.assertFalse(GregorianDate.tryParse("02/q/2002", m_cultureInfo, out$result$9));
        result = out$result$9[0];
        AssertHelper.assertEquals(GregorianDate.MinValue, result);
        final GregorianDate[] out$result$10 = {
            null
        };
        // ReSharper disable once ConditionIsAlwaysTrueOrFalse
        Assert.assertFalse(GregorianDate.tryParse(null, m_cultureInfo, out$result$10));
        result = out$result$10[0];
        AssertHelper.assertEquals(GregorianDate.MinValue, result);
    }

    @Test
    public final void testParsingLeapSecond() {
        GregorianDate expected = new GregorianDate(2008, 12, 31, 23, 59, 60.444);
        AssertHelper.assertEquals(expected, GregorianDate.parseExact("31 Dec 2008 23:59:60.444", "dd MMM yyyy HH:mm:ss.fff", m_cultureInfo));
    }

    @Test
    public final void cannotParseInvalidDates() {
        @CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
        GregorianDate result = new GregorianDate();
        final GregorianDate[] out$result$11 = {
            null
        };
        Assert.assertFalse(GregorianDate.tryParse("02/29/2002", m_cultureInfo, out$result$11));
        result = out$result$11[0];
        AssertHelper.assertEquals(GregorianDate.MinValue, result);
        final GregorianDate[] out$result$12 = {
            null
        };
        Assert.assertFalse(GregorianDate.tryParse("13/01/2002", m_cultureInfo, out$result$12));
        result = out$result$12[0];
    }

    @Test
    public final void testParseIso8601FormatBasic() {
        GregorianDate date = new GregorianDate(1985, 4, 12, 10, 15, 30D);
        String isoString = date.toIso8601String(Iso8601Format.BASIC);
        GregorianDate parsed = GregorianDate.parse(isoString);
        AssertHelper.assertEquals(date, parsed);
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