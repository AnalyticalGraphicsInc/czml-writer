package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.Locale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGregorianDateFormatting {
	private Locale m_cultureInfo;

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
		Assert.assertEquals("February, 2002", date.toString("y", m_cultureInfo));
		Assert.assertEquals("February, 2002", date.toString("Y", m_cultureInfo));
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
		date = new GregorianDate(2009, 6, 10, 15, 0, 13.012345678912345);
		Assert.assertEquals("13.012345678912345", date.toString("ss.fffffffffffffff"));
		date = new GregorianDate(2009, 6, 10, 15, 0, 13.012);
		Assert.assertEquals("13.012000000000000", date.toString("ss.fffffffffffffff"));
		Assert.assertEquals("13.012", date.toString("ss.FFFFFFFFFFFFFFF"));
	}

	@Test(expected = NumberFormatException.class)
	public final void toStringThrowsOnInvalidFormatSpecifier() {
		new GregorianDate(2009, 6, 10).toString("X");
	}

	@Test(expected = NumberFormatException.class)
	public final void cantFormatMoreThan15FractionalSeconds() {
		new GregorianDate(2009, 6, 10).toString("ffffffffffffffff");
	}

	@Test(expected = NumberFormatException.class)
	public final void cantEndWithAPercent() {
		new GregorianDate(2009, 6, 10).toString("f%");
	}

	@Test(expected = NumberFormatException.class)
	public final void cantEndWithABackslash() {
		new GregorianDate(2009, 6, 10).toString("f\\");
	}

	@Test(expected = NumberFormatException.class)
	public final void cantHaveADoublePercent() {
		new GregorianDate(2009, 6, 10).toString("%%");
	}

	@Test
	public final void testFormattingLeapSecond() {
		GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60.444);
		Assert.assertEquals("31 Dec 2008 23:59:60.444", date.toString("d MMM yyyy H:mm:ss.fff", m_cultureInfo));
	}

	@Test
	public final void toIso8601StringProducesCorrectStrings() {
		String iso = new GregorianDate(2012, 4, 2, 1, 2, 3.12345).toIso8601String();
		Assert.assertEquals("2012-04-02T01:02:03.12345Z", iso);
		iso = new GregorianDate(2012, 4, 2, 1, 2, 3D).toIso8601String();
		Assert.assertEquals("2012-04-02T01:02:03Z", iso);
		iso = new GregorianDate(2012, 4, 2, 1, 2, 3D).toIso8601String();
		Assert.assertEquals("2012-04-02T01:02:03Z", iso);
		iso = new GregorianDate(2012, 4, 2, 1, 2, 0D).toIso8601String();
		Assert.assertEquals("2012-04-02T01:02:00Z", iso);
		iso = new GregorianDate(2012, 4, 2, 1, 2, 0D).toIso8601String();
		Assert.assertEquals("2012-04-02T01:02:00Z", iso);
		iso = new GregorianDate(2012, 6, 30, 23, 59, 60.123).toIso8601String();
		Assert.assertEquals("2012-06-30T23:59:60.123Z", iso);
	}

	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}