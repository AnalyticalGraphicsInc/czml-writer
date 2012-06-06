package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.StringHelper;
import cesiumlanguagewriter.*;
import java.util.Locale;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGregorianDateParsing {
	private Locale m_cultureInfo;

	@Before
	public void setUp() {
		m_cultureInfo = new Locale("en-US");
	}

	@Test
	public final void testParseISO8601DayOfYear() {
		GregorianDate iso = new GregorianDate(1985, 2, 11, 2, 0, 5.2134);
		GregorianDate result = GregorianDate.parse("1985-042T02:00:05.2134");
		Assert.assertEquals(iso, result);
		iso = new GregorianDate(1985, 2, 11, 2, 0, 5.21345);
		result = GregorianDate.parse("1985-042T02:00:05.21345Z");
		Assert.assertEquals(iso, result);
		iso = new GregorianDate(1985, 2, 11, 2, 0, 5D);
		result = GregorianDate.parse("1985-042T02:00:05");
		Assert.assertEquals(iso, result);
		iso = new GregorianDate(1985, 2, 11);
		result = GregorianDate.parse("1985-042");
		Assert.assertEquals(iso, result);
		// Make sure to check each month to ensure we have it right
		String first = "1986-";
		String last = "T02:01:04Z";
		JulianDate baseDate = new JulianDate(new GregorianDate(1986, 1, 12, 2, 1, 4D));
		for (int i = 1; i < 12; i++) {
			String testString = StringHelper.format(first + "{0:000}" + last, 12 + i * 30);
			GregorianDate expected = baseDate.addDays(i * 30).toGregorianDate();
			Assert.assertEquals(expected, GregorianDate.parse(testString));
		}
	}

	@Test
	public final void testTryParseISO8601DayOfYear() {
		GregorianDate iso = new GregorianDate(1985, 2, 11, 2, 0, 5.2134);
		@CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
		GregorianDate result = new GregorianDate();
		GregorianDate[] out$result_1 = {
			null
		};
		boolean temp_0 = GregorianDate.tryParse("1985-042T02:00:05.2134", out$result_1);
		result = out$result_1[0];
		if (!temp_0) {
			Assert.fail();
		}
		Assert.assertEquals(iso, result);
		iso = new GregorianDate(1985, 2, 11, 2, 0, 5.21345);
		GregorianDate[] out$result_3 = {
			null
		};
		boolean temp_2 = GregorianDate.tryParse("1985-042T02:00:05.21345Z", out$result_3);
		result = out$result_3[0];
		if (!temp_2) {
			Assert.fail();
		}
		Assert.assertEquals(iso, result);
		iso = new GregorianDate(1985, 2, 11, 2, 0, 5D);
		GregorianDate[] out$result_5 = {
			null
		};
		boolean temp_4 = GregorianDate.tryParse("1985-042T02:00:05", out$result_5);
		result = out$result_5[0];
		if (!temp_4) {
			Assert.fail();
		}
		Assert.assertEquals(iso, result);
		iso = new GregorianDate(1985, 2, 11);
		GregorianDate[] out$result_7 = {
			null
		};
		boolean temp_6 = GregorianDate.tryParse("1985-042", out$result_7);
		result = out$result_7[0];
		if (!temp_6) {
			Assert.fail();
		}
		Assert.assertEquals(iso, result);
		GregorianDate[] out$result_8 = {
			null
		};
		Assert.assertFalse(GregorianDate.tryParse("1985-367T02:00:05.2134", out$result_8));
		result = out$result_8[0];
		GregorianDate[] out$result_9 = {
			null
		};
		Assert.assertFalse(GregorianDate.tryParse("1985-12#T02:00:05.2134", out$result_9));
		result = out$result_9[0];
		GregorianDate[] out$result_10 = {
			null
		};
		Assert.assertFalse(GregorianDate.tryParse("21985-167T02:00:05.2134", out$result_10));
		result = out$result_10[0];
	}

	@Test(expected = NumberFormatException.class)
	public final void testParseISO8601DayOfYearOutOfRange() {
		GregorianDate result = GregorianDate.parse("1985-367T02:00:05.2134");
	}

	@Test(expected = NumberFormatException.class)
	public final void testParseISO8601DayOfYearError() {
		GregorianDate result = GregorianDate.parse("1985-12#T02:00:05.2134");
	}

	@Test(expected = NumberFormatException.class)
	public final void testParseISO8601YearOutOfRange() {
		GregorianDate result = GregorianDate.parse("21985-167T02:00:05.2134");
	}

	@Test
	public final void testToISO8601String() {
		// Full format
		String isoString = "1985-04-12T10:15:30Z";
		GregorianDate iso = new GregorianDate(1985, 4, 12, 10, 15, 30D);
		GregorianDate result = GregorianDate.parse(isoString);
		Assert.assertEquals(iso, result);
		String resultString = result.toIso8601String();
		Assert.assertEquals(isoString, resultString);
		Assert.assertEquals(isoString, iso.toIso8601String());
	}

	@Test
	public final void testParseExact() {
		GregorianDate expected = new GregorianDate(2002, 2, 25);
		Assert.assertEquals(expected, GregorianDate.parseExact("02/25/2002", "d", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("Monday, February 25 2002", "D", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 25, 5, 25, 0D);
		Assert.assertEquals(expected, GregorianDate.parseExact("Monday, February 25 2002 05:25 AM", "f", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("02/25/2002 05:25 AM", "g", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 25, 5, 25, 13D);
		Assert.assertEquals(expected, GregorianDate.parseExact("Monday, February 25 2002 05:25:13 AM", "F", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("02/25/2002 05:25:13 AM", "G", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("2002-02-25T05:25:13", "s", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("Monday, 25 February 2002 05:25:13", "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 25, 4, 25, 13D);
		Assert.assertEquals(expected, GregorianDate.parseExact("Monday, February 25 2002 04:25:13 AM", "U", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("2002-02-25 04:25:13Z", "u", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("Mon, 25 Feb 2002 04:25:13 GMT", "r", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("Mon, 25 Feb 2002 04:25:13 GMT", "R", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), 2, 25);
		Assert.assertEquals(expected, GregorianDate.parseExact("February 25", "m", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("February 25", "M", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthOfYear(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 0D);
		Assert.assertEquals(expected, GregorianDate.parseExact("05:25 AM", "t", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthOfYear(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13D);
		Assert.assertEquals(expected, GregorianDate.parseExact("05:25:13 AM", "T", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 1);
		Assert.assertEquals(expected, GregorianDate.parseExact("February, 2002", "y", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("February, 2002", "Y", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), 1, 25);
		Assert.assertEquals(expected, GregorianDate.parseExact("25", "%d", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("25", "dd", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), 2, 1);
		Assert.assertEquals(expected, GregorianDate.parseExact("2", "%M", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("02", "MM", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("Feb", "MMM", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("February", "MMMM", m_cultureInfo));
		expected = new GregorianDate(2005, 1, 1);
		Assert.assertEquals(expected, GregorianDate.parseExact("5", "%y", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("05", "yy", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("2005", "yyyy", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthOfYear(), DateTimeHelper.today().getDayOfMonth(), 5, 0, 0D);
		Assert.assertEquals(expected, GregorianDate.parseExact("5A", "ht", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("05A", "hht", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("5", "%H", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("05", "HH", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthOfYear(), DateTimeHelper.today().getDayOfMonth(), 15, 0, 0D);
		Assert.assertEquals(expected, GregorianDate.parseExact("3P", "ht", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("03P", "hht", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("15", "%H", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parseExact("15", "HH", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 25, 5, 25, 13.444);
		Assert.assertEquals(expected, GregorianDate.parseExact("Monday, 25 February 2002 05:25:13.444", "dddd, dd MMMM yyyy HH:mm:ss.fff", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthOfYear(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13.4444444);
		Assert.assertEquals(expected, GregorianDate.parseExact("05:25:13.4444444", "HH:mm:ss.fffffff", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthOfYear(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13.1234567);
		Assert.assertEquals(expected, GregorianDate.parseExact("05:25:13.1234567", "HH:mm:ss.fffffff", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 13.1234567890);
		Assert.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:13.1234567890", "MM/dd/yyyy HH:mm:ss.ffffffffff", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 13.44444444444444);
		Assert.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:13.44444444444444", "MM/dd/yyyy HH:mm:ss.ffffffffffffff", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901234);
		Assert.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:13.12345678901234", "MM/dd/yyyy HH:mm:ss.ffffffffffffff", m_cultureInfo));
		AssertHelper.assertNotEqual(expected, GregorianDate.parseExact("06/30/2009 05:25:13.123456789012345", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 13.444444444444444);
		Assert.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:13.444444444444444", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));
		AssertHelper.assertNotEqual(expected, GregorianDate.parseExact("06/30/2009 05:25:13.444444444444446", "MM/dd/yyyy HH:mm:ss.fffffffffffffff", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 0.1234567890123456);
		Assert.assertEquals(expected, GregorianDate.parseExact("06/30/2009 05:25:00.1234567890123456", "MM/dd/yyyy HH:mm:ss.ffffffffffffffff", m_cultureInfo));
		AssertHelper.assertNotEqual(expected, GregorianDate.parseExact("06/30/2009 05:25:00.1234567890123459", "MM/dd/yyyy HH:mm:ss.ffffffffffffffff", m_cultureInfo));
	}

	@Test(expected = NumberFormatException.class)
	public final void parseExactThrowsOnInvalidFormat() {
		GregorianDate.parseExact("1/1/2009", "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo);
	}

	@Test(expected = NumberFormatException.class)
	public final void parseExactThrowsOnNullFormat() {
		GregorianDate.parseExact("1/1/2009", (String) null, m_cultureInfo);
	}

	@Test(expected = ArgumentNullException.class)
	public final void parseExactThrowsOnNullInput() {
		GregorianDate.parseExact(null, "dddd, dd MMMM yyyy HH:mm:ss", m_cultureInfo);
	}

	@Test
	public final void testParse() {
		GregorianDate expected = new GregorianDate(2002, 2, 25);
		Assert.assertEquals(expected, GregorianDate.parse("02/25/2002", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2/25/2002", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2002-02-25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2002-2-25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("Monday, 25 February 2002", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("Mon,02/25/2002", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("Mon,2/25/2002", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 25, 5, 25, 0D);
		Assert.assertEquals(expected, GregorianDate.parse("Monday, 25 February 2002 05:25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02/25/2002 05:25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2/25/2002 05:25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2/25/2002 5:25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2002-02-25T05:25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2002-2-25T05:25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2-2002-25 05:25", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2-2002-25 5:25", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 25, 5, 25, 13D);
		Assert.assertEquals(expected, GregorianDate.parse("Monday, 25 February 2002 05:25:13", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02/25/2002 05:25:13", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02/25/2002 5:25:13", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2/25/2002 5:25:13", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2002-02-25T05:25:13", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25T05:25:13", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25:13", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 5:25:13", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25:13 Mon", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 5:25:13 Mon", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25:13 Monday", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 5:25:13 Monday", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 25, 4, 25, 13D);
		Assert.assertEquals(expected, GregorianDate.parse("2002-02-25 04:25:13Z", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("Mon, 25 Feb 2002 04:25:13 GMT", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 25, 5, 25, 13.008);
		Assert.assertEquals(expected, GregorianDate.parse("02/25/2002 05:25:13.008", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02/25/2002 5:25:13.008", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("2002-02-25T05:25:13.008", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25T05:25:13.008", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 05:25:13.008", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("02-2002-25 5:25:13.008", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), 2, 25);
		Assert.assertEquals(expected, GregorianDate.parse("February 25", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), 2, 8);
		Assert.assertEquals(expected, GregorianDate.parse("February 08", m_cultureInfo));
		Assert.assertEquals(expected, GregorianDate.parse("February 8", m_cultureInfo));
		expected = new GregorianDate(2002, 2, 1);
		Assert.assertEquals(expected, GregorianDate.parse("2002 February", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthOfYear(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13.4444444);
		Assert.assertEquals(expected, GregorianDate.parse("05:25:13.4444444", m_cultureInfo));
		expected = new GregorianDate(DateTimeHelper.today().getYear(), DateTimeHelper.today().getMonthOfYear(), DateTimeHelper.today().getDayOfMonth(), 5, 25, 13.1234567);
		Assert.assertEquals(expected, GregorianDate.parse("05:25:13.1234567", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 13.1234567890);
		Assert.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:13.1234567890", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 13.44444444444444);
		Assert.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:13.44444444444444", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901234);
		Assert.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:13.12345678901234", m_cultureInfo));
		AssertHelper.assertNotEqual(expected, GregorianDate.parse("06/30/2009 05:25:13.12345678901239", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 13.444444444444444);
		Assert.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:13.444444444444444", m_cultureInfo));
		AssertHelper.assertNotEqual(expected, GregorianDate.parse("06/30/2009 05:25:13.444444444444446", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 0.1234567890123456);
		Assert.assertEquals(expected, GregorianDate.parse("06/30/2009 05:25:00.1234567890123456", m_cultureInfo));
		AssertHelper.assertNotEqual(expected, GregorianDate.parse("06/30/2009 05:25:00.1234567890123459", m_cultureInfo));
		expected = new GregorianDate(2009, 6, 30, 5, 25, 0.1234567890123456);
		GregorianDate unusedDate = new GregorianDate();
		GregorianDate[] out$unusedDate_11 = {
			null
		};
		GregorianDate.tryParse("06/30/2009 05:25:00.1234567890123456", out$unusedDate_11);
		unusedDate = out$unusedDate_11[0];
		Assert.assertEquals(expected, unusedDate);
	}

	@Test(expected = ArgumentNullException.class)
	public final void parseThrowsOnNullInput() {
		GregorianDate.parse(null, m_cultureInfo);
	}

	@Test(expected = ArgumentNullException.class)
	public final void parseThrowsOnNullInputWithoutCultureInfo() {
		GregorianDate.parse(null);
	}

	@Test(expected = NumberFormatException.class)
	public final void parseThrowsFormatExceptionWhenNoMatch() {
		GregorianDate.parse("February Q, 2009", m_cultureInfo);
	}

	@Test
	public final void testTryParse() {
		GregorianDate expected = new GregorianDate(2002, 2, 25);
		@CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
		GregorianDate result = new GregorianDate();
		GregorianDate[] out$result_12 = {
			null
		};
		Assert.assertEquals(true, GregorianDate.tryParse("02/25/2002", m_cultureInfo, out$result_12));
		result = out$result_12[0];
		Assert.assertEquals(expected, result);
		GregorianDate[] out$result_13 = {
			null
		};
		Assert.assertEquals(false, GregorianDate.tryParse("02/q/2002", m_cultureInfo, out$result_13));
		result = out$result_13[0];
		Assert.assertEquals(GregorianDate.MinValue, result);
		GregorianDate[] out$result_14 = {
			null
		};
		Assert.assertEquals(false, GregorianDate.tryParse(null, m_cultureInfo, out$result_14));
		result = out$result_14[0];
		Assert.assertEquals(GregorianDate.MinValue, result);
	}

	@Test
	public final void testParsingLeapSecond() {
		GregorianDate expected = new GregorianDate(2008, 12, 31, 23, 59, 60.444);
		Assert.assertEquals(expected, GregorianDate.parseExact("31 Dec 2008 23:59:60.444", "dd MMM yyyy HH:mm:ss.fff", m_cultureInfo));
	}

	@Test
	public final void cannotParseInvalidDates() {
		@CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
		GregorianDate result = new GregorianDate();
		GregorianDate[] out$result_15 = {
			null
		};
		Assert.assertEquals(false, GregorianDate.tryParse("02/29/2002", m_cultureInfo, out$result_15));
		result = out$result_15[0];
		Assert.assertEquals(GregorianDate.MinValue, result);
		GregorianDate[] out$result_16 = {
			null
		};
		Assert.assertEquals(false, GregorianDate.tryParse("13/01/2002", m_cultureInfo, out$result_16));
		result = out$result_16[0];
	}
}