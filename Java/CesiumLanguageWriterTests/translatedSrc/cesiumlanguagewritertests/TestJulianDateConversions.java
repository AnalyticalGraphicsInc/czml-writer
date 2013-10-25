package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.DateTimeHelper;
import cesiumlanguagewriter.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.Test;

/**
 *  
 A series of tests to exercise the various date and time types.
 

 */
public class TestJulianDateConversions {
	/**
	 *  
	Tests conversion from a  {@link JulianDate} to a  {@link DateTime}.
	

	 */
	@Test
	public final void julianToDateTime() {
		JulianDate julianDate = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		DateTime dateTime = julianDate.toDateTime();
		Assert.assertEquals((int) 2000, (int) dateTime.getYear());
		Assert.assertEquals((int) 1, (int) dateTime.getMonthOfYear());
		Assert.assertEquals((int) 1, (int) dateTime.getDayOfMonth());
		Assert.assertEquals((int) 12, (int) dateTime.getHourOfDay());
		Assert.assertEquals((int) 0, (int) dateTime.getMinuteOfHour());
		Assert.assertEquals((int) 0, (int) dateTime.getSecondOfMinute());
		Assert.assertEquals((int) 0, (int) dateTime.getMillisOfSecond());
		Assert.assertEquals(DateTimeZone.UTC, dateTime.getZone());
		julianDate = new JulianDate(2453736.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		dateTime = julianDate.toDateTime();
		Assert.assertEquals((int) 2006, (int) dateTime.getYear());
		Assert.assertEquals((int) 1, (int) dateTime.getMonthOfYear());
		Assert.assertEquals((int) 1, (int) dateTime.getDayOfMonth());
		Assert.assertEquals((int) 0, (int) dateTime.getHourOfDay());
		Assert.assertEquals((int) 0, (int) dateTime.getMinuteOfHour());
		Assert.assertEquals((int) 0, (int) dateTime.getSecondOfMinute());
		Assert.assertEquals((int) 0, (int) dateTime.getMillisOfSecond());
		Assert.assertEquals(DateTimeZone.UTC, dateTime.getZone());
		julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		dateTime = julianDate.toDateTime();
		Assert.assertEquals((int) 1973, (int) dateTime.getYear());
		Assert.assertEquals((int) 1, (int) dateTime.getMonthOfYear());
		Assert.assertEquals((int) 1, (int) dateTime.getDayOfMonth());
		Assert.assertEquals((int) 0, (int) dateTime.getHourOfDay());
		Assert.assertEquals((int) 0, (int) dateTime.getMinuteOfHour());
		Assert.assertEquals((int) 0, (int) dateTime.getSecondOfMinute());
		Assert.assertEquals((int) 0, (int) dateTime.getMillisOfSecond());
		Assert.assertEquals(DateTimeZone.UTC, dateTime.getZone());
		julianDate = new JulianDate(2441683.5, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		dateTime = julianDate.toDateTime(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		Assert.assertEquals(DateTimeZone.UTC, dateTime.getZone());
		julianDate = new JulianDate(2441683.5, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		dateTime = julianDate.toDateTime(TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(DateTimeZone.UTC, dateTime.getZone());
	}

	@Test
	public final void julianToGregorianDate() {
		JulianDate julianDate = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		GregorianDate gregorianDate = julianDate.toGregorianDate();
		Assert.assertEquals((int) 2000, (int) gregorianDate.getYear());
		Assert.assertEquals((int) 1, (int) gregorianDate.getMonth());
		Assert.assertEquals((int) 1, (int) gregorianDate.getDay());
		Assert.assertEquals((int) 12, (int) gregorianDate.getHour());
		Assert.assertEquals((int) 0, (int) gregorianDate.getMinute());
		Assert.assertEquals(0, gregorianDate.getSecond(), 0d);
		julianDate = new JulianDate(2453736.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		gregorianDate = julianDate.toGregorianDate();
		Assert.assertEquals((int) 2006, (int) gregorianDate.getYear());
		Assert.assertEquals((int) 1, (int) gregorianDate.getMonth());
		Assert.assertEquals((int) 1, (int) gregorianDate.getDay());
		Assert.assertEquals((int) 0, (int) gregorianDate.getHour());
		Assert.assertEquals((int) 0, (int) gregorianDate.getMinute());
		Assert.assertEquals(0, gregorianDate.getSecond(), 0d);
		julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		gregorianDate = julianDate.toGregorianDate();
		Assert.assertEquals((int) 1973, (int) gregorianDate.getYear());
		Assert.assertEquals((int) 1, (int) gregorianDate.getMonth());
		Assert.assertEquals((int) 1, (int) gregorianDate.getDay());
		Assert.assertEquals((int) 0, (int) gregorianDate.getHour());
		Assert.assertEquals((int) 0, (int) gregorianDate.getMinute());
		Assert.assertEquals(0, gregorianDate.getSecond(), 0d);
		julianDate = new JulianDate(2441683.5, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		GregorianDate internationalTimeGregorianDate = julianDate.toGregorianDate(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		AssertHelper.assertNotEqual(gregorianDate, internationalTimeGregorianDate);
	}

	/**
	 *  
	Tests that an appropriate exception is thrown when attempting to construct a DateTime
	from a JulianDate prior to the earliest possible DateTime.
	

	 */
	@Test(expected = ArgumentOutOfRangeException.class)
	public final void testJulianDateMinimumToDateTime() {
		JulianDate date = JulianDate.getMinValue();
		DateTime dt = date.toDateTime();
	}

	/**
	 *  
	Tests conversion from a  {@link DateTime} to a  {@link JulianDate}.
	

	 */
	@Test
	public final void dateTimeToJulian() {
		DateTime dateTime = new DateTime(2000, 1, 1, 12, 0, 0, 0, org.joda.time.DateTimeZone.UTC);
		JulianDate julianDate = new JulianDate(dateTime);
		Assert.assertEquals(2451545.0, julianDate.getTotalDays(), 0d);
		dateTime = new DateTime(2006, 1, 1, 0, 0, 0, 0, org.joda.time.DateTimeZone.UTC);
		julianDate = new JulianDate(dateTime);
		Assert.assertEquals(2453736.5, julianDate.getTotalDays(), 0d);
		dateTime = new DateTime(1973, 1, 1, 0, 0, 0, 0, org.joda.time.DateTimeZone.UTC);
		julianDate = new JulianDate(dateTime);
		Assert.assertEquals(2441683.5, julianDate.getTotalDays(), 0d);
		DateTime localDateTime = new DateTime(2000, 1, 1, 12, 0, 0, 0, DateTimeZone.getDefault());
		DateTime utc = localDateTime.withZone(org.joda.time.DateTimeZone.UTC);
		julianDate = new JulianDate(localDateTime);
		dateTime = julianDate.toDateTime();
		Assert.assertEquals(utc, dateTime);
	}

	@Test
	public final void gregorianDateToJulian() {
		GregorianDate gregorianDate = new GregorianDate(2000, 1, 1, 12, 0, 0D);
		JulianDate julianDate = new JulianDate(gregorianDate);
		Assert.assertEquals(2451545.0, julianDate.getTotalDays(), 0d);
		gregorianDate = new GregorianDate(2006, 1, 1, 0, 0, 0D);
		julianDate = new JulianDate(gregorianDate);
		Assert.assertEquals(2453736.5, julianDate.getTotalDays(), 0d);
		gregorianDate = new GregorianDate(1973, 1, 1, 0, 0, 0D);
		julianDate = new JulianDate(gregorianDate);
		Assert.assertEquals(2441683.5, julianDate.getTotalDays(), 0d);
		DateTime localDateTime = new DateTime(2000, 1, 1, 12, 0, 0, 0, DateTimeZone.getDefault());
		DateTime utc = localDateTime.withZone(org.joda.time.DateTimeZone.UTC);
		julianDate = new JulianDate(localDateTime);
		gregorianDate = julianDate.toGregorianDate();
		Assert.assertEquals(new GregorianDate(utc), gregorianDate);
	}

	/**
	 *  
	Tests conversion of a  {@link DateTime} to a  {@link JulianDate} when
	the  {@link DateTime} is specified as a local time instead of as UTC.
	

	 */
	@Test
	public final void testLocalDateTimeToJulian() {
		DateTime localNow = DateTimeHelper.now();
		DateTime utcNow = localNow.withZone(org.joda.time.DateTimeZone.UTC);
		JulianDate localJD = new JulianDate(localNow);
		JulianDate utcJD = new JulianDate(utcNow);
		Assert.assertTrue(localJD.equalsEpsilon(utcJD, Constants.Epsilon14));
		localNow = DateTimeHelper.now();
		utcNow = localNow.withZone(org.joda.time.DateTimeZone.UTC);
		localJD = new JulianDate(localNow, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		utcJD = new JulianDate(utcNow, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		Assert.assertTrue(localJD.equalsEpsilon(utcJD, Constants.Epsilon14));
	}

	/**
	 *  
	Tests the "round-trip" conversion between a  {@link DateTime} and a  {@link JulianDate}.
	

	 */
	@Test
	public final void julianDateTimeRoundTrip() {
		DateTime dateTime = DateTimeHelper.utcNow();
		JulianDate julianDate = new JulianDate(dateTime);
		DateTime roundTrip = julianDate.toDateTime();
		Assert.assertEquals((int) dateTime.getYear(), (int) roundTrip.getYear());
		Assert.assertEquals((int) dateTime.getMonthOfYear(), (int) roundTrip.getMonthOfYear());
		Assert.assertEquals((int) dateTime.getDayOfMonth(), (int) roundTrip.getDayOfMonth());
		Assert.assertEquals((int) dateTime.getHourOfDay(), (int) roundTrip.getHourOfDay());
		Assert.assertEquals((int) dateTime.getMinuteOfHour(), (int) roundTrip.getMinuteOfHour());
		Assert.assertEquals((int) dateTime.getSecondOfMinute(), (int) roundTrip.getSecondOfMinute());
		Assert.assertEquals((int) dateTime.getMillisOfSecond(), (int) roundTrip.getMillisOfSecond());
	}

	@Test
	public final void julianDateGregorianDateRoundTrip() {
		GregorianDate gregorianDate = new GregorianDate(2008, 1, 1, 1, 1, 1.00000000008);
		JulianDate julianDate = new JulianDate(gregorianDate);
		GregorianDate roundTrip = julianDate.toGregorianDate();
		Assert.assertEquals((int) gregorianDate.getYear(), (int) roundTrip.getYear());
		Assert.assertEquals((int) gregorianDate.getMonth(), (int) roundTrip.getMonth());
		Assert.assertEquals((int) gregorianDate.getDay(), (int) roundTrip.getDay());
		Assert.assertEquals((int) gregorianDate.getHour(), (int) roundTrip.getHour());
		Assert.assertEquals((int) gregorianDate.getMinute(), (int) roundTrip.getMinute());
		Assert.assertEquals(gregorianDate.getSecond(), roundTrip.getSecond(), Constants.Epsilon13);
	}

	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}