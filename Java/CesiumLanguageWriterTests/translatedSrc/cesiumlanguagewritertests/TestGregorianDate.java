package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGregorianDate {
	@Test
	public final void canConstructGregorianDate() {
		GregorianDate gd = new GregorianDate(2000, 1, 2, 6, 30, 15D);
		Assert.assertEquals((int) 2000, (int) gd.getYear());
		Assert.assertEquals((int) 1, (int) gd.getMonth());
		Assert.assertEquals((int) 2, (int) gd.getDay());
		Assert.assertEquals((int) 6, (int) gd.getHour());
		Assert.assertEquals((int) 30, (int) gd.getMinute());
		Assert.assertEquals(15, gd.getSecond(), 0d);
		gd = new GregorianDate(2000, 1, 2);
		Assert.assertEquals((int) 2000, (int) gd.getYear());
		Assert.assertEquals((int) 1, (int) gd.getMonth());
		Assert.assertEquals((int) 2, (int) gd.getDay());
		Assert.assertEquals((int) 0, (int) gd.getHour());
		Assert.assertEquals((int) 0, (int) gd.getMinute());
		Assert.assertEquals(0, gd.getSecond(), 0d);
	}

	@Test(expected = ArgumentException.class)
	public final void cannotConstructWithInvalidTime() {
		new GregorianDate(2000, 1, 2, 24, 0, 0D);
	}

	@Test(expected = ArgumentException.class)
	public final void cannotConstructWithInvalidDate() {
		new GregorianDate(2006, 2, 29, 0, 0, 0D);
	}

	@Test
	public final void isValidValidatesProperly() {
		Assert.assertFalse(GregorianDate.isValid(2000, 0, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 2, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 3, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 4, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 5, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 6, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 7, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 8, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 9, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 10, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 11, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 12, 1, 0, 0, 0D));
		Assert.assertFalse(GregorianDate.isValid(2000, 13, 1, 0, 0, 0D));
		Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, -1, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 0, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 23, 0, 0D));
		Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 24, 0, 0D));
		Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 6, -1, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 59, 0D));
		Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 6, 60, 0D));
		Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 6, 0, -1D));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 0D));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 0.00001));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 59D));
		Assert.assertTrue(GregorianDate.isValid(2000, 1, 1, 6, 0, 59.9));
		Assert.assertFalse(GregorianDate.isValid(2000, 1, 1, 6, 0, 60D));
	}

	@Test
	public final void testEquality() {
		GregorianDate first = new GregorianDate(2000, 1, 1, 5, 1, 1D);
		GregorianDate second = new GregorianDate(2000, 1, 1, 5, 1, 1D);
		AssertHelper.assertEquals(first, second);
		Assert.assertTrue(first.equalsType(second));
		Assert.assertTrue(second.equalsType(first));
		Assert.assertEquals((int) 0, (int) first.compareTo(second));
		Assert.assertEquals((int) 0, (int) second.compareTo(first));
		second = new GregorianDate(2000, 1, 1, 6, 1, 1D);
		AssertHelper.assertNotEqual(first, second);
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		AssertHelper.assertNotEqual(0, first.compareTo(second));
		AssertHelper.assertNotEqual(0, second.compareTo(first));
		second = new GregorianDate(2000, 2, 1, 5, 1, 1D);
		AssertHelper.assertNotEqual(first, second);
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		AssertHelper.assertNotEqual(0, first.compareTo(second));
		AssertHelper.assertNotEqual(0, second.compareTo(first));
		AssertHelper.assertNotEqual(first, 5);
	}

	@Test
	public final void testEqualityInTimePortion() {
		GregorianDate first = new GregorianDate(1999, 10, 10, 5, 1, 1D);
		GregorianDate second = new GregorianDate(1999, 10, 10, 5, 1, 1D);
		AssertHelper.assertEquals(first, second);
		Assert.assertTrue(first.equalsType(second));
		Assert.assertTrue(second.equalsType(first));
		Assert.assertEquals((int) 0, (int) first.compareTo(second));
		Assert.assertEquals((int) 0, (int) second.compareTo(first));
		second = new GregorianDate(1999, 10, 10, 6, 1, 1D);
		AssertHelper.assertNotEqual(first, second);
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		AssertHelper.assertNotEqual(0, first.compareTo(second));
		AssertHelper.assertNotEqual(0, second.compareTo(first));
		second = new GregorianDate(1999, 10, 10, 5, 2, 1D);
		AssertHelper.assertNotEqual(first, second);
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		AssertHelper.assertNotEqual(0, first.compareTo(second));
		AssertHelper.assertNotEqual(0, second.compareTo(first));
		second = new GregorianDate(1999, 10, 10, 5, 1, 2D);
		AssertHelper.assertNotEqual(first, second);
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		AssertHelper.assertNotEqual(0, first.compareTo(second));
		AssertHelper.assertNotEqual(0, second.compareTo(first));
		AssertHelper.assertNotEqual(first, 5);
	}

	@Test
	public final void testEqualityWithFractionalSeconds() {
		GregorianDate first = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901234);
		GregorianDate second = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901239);
		GregorianDate equal = new GregorianDate(2009, 6, 30, 5, 25, 13.12345678901234);
		AssertHelper.assertNotEqual(13.12345678901234, 13.12345678901239);
		AssertHelper.assertNotEqual(first, second);
		AssertHelper.assertEquals(first, equal);
	}

	@Test
	public final void testComparisons() {
		GregorianDate date = new GregorianDate(2001, 1, 1, 6, 3, 14D);
		GregorianDate sameDate = new GregorianDate(2001, 1, 1, 6, 3, 14D);
		GregorianDate laterTime = new GregorianDate(2001, 1, 1, 6, 5, 26D);
		GregorianDate laterDay = new GregorianDate(2001, 2, 2, 6, 3, 14D);
		Assert.assertTrue(GregorianDate.equals(date, sameDate));
		Assert.assertTrue(GregorianDate.equals(sameDate, date));
		Assert.assertTrue(GregorianDate.notEquals(date, laterTime));
		Assert.assertTrue(GregorianDate.greaterThanOrEqual(date, sameDate));
		Assert.assertTrue(GregorianDate.lessThanOrEqual(date, sameDate));
		Assert.assertTrue(date.compareTo(sameDate) == 0);
		Assert.assertTrue(date.compareTo(laterDay) < 0);
		Assert.assertTrue(GregorianDate.lessThan(sameDate, laterTime));
		Assert.assertTrue(GregorianDate.lessThanOrEqual(sameDate, laterTime));
		Assert.assertTrue(GregorianDate.greaterThan(laterTime, sameDate));
		Assert.assertTrue(GregorianDate.greaterThanOrEqual(laterTime, sameDate));
		Object dateAsObject = new GregorianDate(2001, 1, 1, 6, 3, 15D);
		AssertHelper.assertNotEqual(date, dateAsObject);
	}

	@Test
	public final void testComparisonsOfTimePortion() {
		GregorianDate gd1 = new GregorianDate(1999, 10, 10, 6, 3, 14D);
		GregorianDate gd2 = new GregorianDate(1999, 10, 10, 6, 3, 14D);
		GregorianDate gd3 = new GregorianDate(1999, 10, 10, 6, 5, 26D);
		Object gd4 = new GregorianDate(1999, 10, 10, 4, 2, 21D);
		Assert.assertTrue(GregorianDate.equals(gd1, gd2));
		Assert.assertTrue(GregorianDate.equals(gd2, gd1));
		Assert.assertTrue(GregorianDate.notEquals(gd1, gd3));
		Assert.assertTrue(GregorianDate.greaterThanOrEqual(gd1, gd2));
		Assert.assertTrue(GregorianDate.lessThanOrEqual(gd1, gd2));
		Assert.assertTrue(gd1.compareTo(gd2) == 0);
		Assert.assertTrue(GregorianDate.lessThan(gd2, gd3));
		Assert.assertTrue(GregorianDate.lessThanOrEqual(gd2, gd3));
		Assert.assertTrue(GregorianDate.greaterThan(gd3, gd2));
		Assert.assertTrue(GregorianDate.greaterThanOrEqual(gd3, gd2));
		AssertHelper.assertNotEqual(gd1, gd4);
	}

	@Test
	public final void testGetHashCode() {
		GregorianDate date = new GregorianDate(2001, 1, 1, 6, 3, 14D);
		GregorianDate sameDate = new GregorianDate(2001, 1, 1, 6, 3, 14D);
		GregorianDate differentTime = new GregorianDate(2001, 1, 1, 6, 5, 26D);
		GregorianDate differentDay = new GregorianDate(2001, 2, 3, 6, 3, 14D);
		Assert.assertEquals((int) date.hashCode(), (int) sameDate.hashCode());
		AssertHelper.assertNotEqual(date.hashCode(), differentTime.hashCode());
		AssertHelper.assertNotEqual(date.hashCode(), differentDay.hashCode());
	}

	@Test
	public final void testToStringFormatProvider() {
		GregorianDate gd1 = new GregorianDate(2001, 1, 1, 6, 3, 14D);
		Assert.assertEquals("1/1/2001 6:03:14 AM", gd1.toString(new Locale("en-US")));
		gd1 = new GregorianDate(2003, 3, 4, 16, 43, 23.23452);
		Assert.assertEquals("3/4/2003 4:43:23 PM", gd1.toString(new Locale("en-US")));
	}

	@Test
	public final void canConstructFromJulianDate() {
		{
			JulianDate jd = new JulianDate(new DateTime(2008, 10, 23, 12, 5, 30, 300, org.joda.time.DateTimeZone.UTC));
			GregorianDate gd = new GregorianDate(jd);
			Assert.assertEquals((int) 2008, (int) gd.getYear());
			Assert.assertEquals((int) 10, (int) gd.getMonth());
			Assert.assertEquals((int) 23, (int) gd.getDay());
			Assert.assertEquals((int) 12, (int) gd.getHour());
			Assert.assertEquals((int) 5, (int) gd.getMinute());
			Assert.assertEquals(30.300, gd.getSecond(), Constants.Epsilon11);
		}
		{
			JulianDate jd = new JulianDate(new DateTime(2008, 10, 23, 0, 0, 0, 0, org.joda.time.DateTimeZone.UTC));
			GregorianDate gd = new GregorianDate(jd);
			Assert.assertEquals((int) 2008, (int) gd.getYear());
			Assert.assertEquals((int) 10, (int) gd.getMonth());
			Assert.assertEquals((int) 23, (int) gd.getDay());
			Assert.assertEquals((int) 0, (int) gd.getHour());
			Assert.assertEquals((int) 0, (int) gd.getMinute());
			Assert.assertEquals(0.0, gd.getSecond(), Constants.Epsilon11);
		}
		{
			JulianDate jd = new JulianDate(new DateTime(2008, 10, 23, 23, 59, 59, 999, org.joda.time.DateTimeZone.UTC));
			GregorianDate gd = new GregorianDate(jd);
			Assert.assertEquals((int) 2008, (int) gd.getYear());
			Assert.assertEquals((int) 10, (int) gd.getMonth());
			Assert.assertEquals((int) 23, (int) gd.getDay());
			Assert.assertEquals((int) 23, (int) gd.getHour());
			Assert.assertEquals((int) 59, (int) gd.getMinute());
			Assert.assertEquals(59.999, gd.getSecond(), Constants.Epsilon11);
		}
	}

	@Test
	public final void canConvertToJulianDate() {
		{
			GregorianDate gregorianDate = new GregorianDate(2008, 10, 23, 23, 59, 59.999);
			JulianDate julianDate = gregorianDate.toJulianDate();
			GregorianDate newGregorianDate = new GregorianDate(julianDate);
			Assert.assertEquals((int) gregorianDate.getYear(), (int) newGregorianDate.getYear());
			Assert.assertEquals((int) gregorianDate.getMonth(), (int) newGregorianDate.getMonth());
			Assert.assertEquals((int) gregorianDate.getDay(), (int) newGregorianDate.getDay());
			Assert.assertEquals((int) gregorianDate.getHour(), (int) newGregorianDate.getHour());
			Assert.assertEquals((int) gregorianDate.getMinute(), (int) newGregorianDate.getMinute());
			Assert.assertEquals(gregorianDate.getSecond(), newGregorianDate.getSecond(), Constants.Epsilon11);
		}
		{
			GregorianDate gregorianDate = new GregorianDate(2008, 10, 23, 1, 1, 1D);
			JulianDate julianDate = gregorianDate.toJulianDate();
			GregorianDate newGregorianDate = new GregorianDate(julianDate);
			Assert.assertEquals((int) gregorianDate.getYear(), (int) newGregorianDate.getYear());
			Assert.assertEquals((int) gregorianDate.getMonth(), (int) newGregorianDate.getMonth());
			Assert.assertEquals((int) gregorianDate.getDay(), (int) newGregorianDate.getDay());
			Assert.assertEquals((int) gregorianDate.getHour(), (int) newGregorianDate.getHour());
			Assert.assertEquals((int) gregorianDate.getMinute(), (int) newGregorianDate.getMinute());
			Assert.assertEquals(gregorianDate.getSecond(), newGregorianDate.getSecond(), Constants.Epsilon11);
		}
	}

	@Test
	public final void canConstructFromDateTime() {
		GregorianDate gregorianDate = new GregorianDate(2008, 10, 23, 23, 59, 59.999);
		GregorianDate constructedFromDateTime = new GregorianDate(new DateTime(2008, 10, 23, 23, 59, 59, 999, org.joda.time.DateTimeZone.UTC));
		AssertHelper.assertEquals(gregorianDate, constructedFromDateTime);
	}

	@Test
	public final void localDateTimesAreConvertedToUTC() {
		DateTime date = new DateTime(2008, 10, 23, 23, 59, 59, 999, DateTimeZone.getDefault());
		GregorianDate constructedFromLocalDateTime = new GregorianDate(date);
		GregorianDate constructedFromUTCDateTime = new GregorianDate(date.withZone(org.joda.time.DateTimeZone.UTC));
		AssertHelper.assertEquals(constructedFromLocalDateTime, constructedFromUTCDateTime);
	}

	@Test
	public final void testMinValue() {
		AssertHelper.assertLess(GregorianDate.MinValue, new GregorianDate(2009, 1, 1));
	}

	@Test
	public final void testMaxValue() {
		AssertHelper.assertGreater(GregorianDate.MaxValue, new GregorianDate(2009, 1, 1));
	}

	@Test
	public final void testJulianSecondsOfDay() {
		double julianSecondsOfDay = 0.05486;
		GregorianDate gd = new GregorianDate(new JulianDate(2046050, julianSecondsOfDay, TimeStandard.COORDINATED_UNIVERSAL_TIME));
		Assert.assertEquals(julianSecondsOfDay, gd.getJulianSecondsOfDay(), Constants.Epsilon11);
	}

	@Test
	public final void testYearDayConstructor() {
		DateTime aTime = new DateTime(2000, 2, 28, 1, 3, 4, 0, org.joda.time.DateTimeZone.UTC);
		Assert.assertEquals((int) 31 + 28, (int) aTime.getDayOfYear());
		//* January has 31 days, so add 28 to that...
		GregorianDate sameDate = new GregorianDate(aTime.getYear(), aTime.getDayOfYear());
		Assert.assertEquals((int) 2000, (int) sameDate.getYear());
		Assert.assertEquals((int) 59, (int) sameDate.getDayOfYear());
		Assert.assertEquals((int) 2, (int) sameDate.getMonth());
		Assert.assertEquals((int) 0, (int) sameDate.getHour());
		Assert.assertEquals((int) 0, (int) sameDate.getMinute());
		Assert.assertEquals(0, sameDate.getSecond(), 0d);
		sameDate = new GregorianDate(2000, 60.6);
		//* 60 days and 14.4 hours, or 14 hours and 24 minutes (1/10 of a day is 2.4 hours, times that by 6)
		Assert.assertEquals((int) 2000, (int) sameDate.getYear());
		Assert.assertEquals((int) 60, (int) sameDate.getDayOfYear());
		Assert.assertEquals((int) 2, (int) sameDate.getMonth());
		//* leap year
		Assert.assertEquals((int) 14, (int) sameDate.getHour());
		Assert.assertEquals((int) 24, (int) sameDate.getMinute());
		Assert.assertEquals(0D, sameDate.getSecond(), Constants.Epsilon9);
		//* Richard and Michael both said this is ok
	}

	@Test
	public final void testDayOfYear() {
		GregorianDate date = new GregorianDate(2000, 1, 1);
		Assert.assertEquals((int) date.getDayOfYear(), (int) 1);
		date = new GregorianDate(2000, 2, 1);
		Assert.assertEquals((int) date.getDayOfYear(), (int) 32);
		date = new GregorianDate(2003, 12, 31);
		Assert.assertEquals((int) date.getDayOfYear(), (int) 365);
		date = new GregorianDate(2004, 12, 31);
		Assert.assertEquals((int) date.getDayOfYear(), (int) 366);
		date = new GregorianDate(2000, 250D);
		Assert.assertEquals((int) date.getDayOfYear(), (int) 250);
		date = new GregorianDate(2000, 250.5);
		Assert.assertEquals((int) date.getDayOfYear(), (int) 250);
	}

	@Test
	public final void testSixtySecondsAreValidIfTheInstantRepresentsALeapSecond() {
		Assert.assertTrue(GregorianDate.isValid(2008, 12, 31, 23, 59, 60D));
		Assert.assertTrue(GregorianDate.isValid(2008, 12, 31, 23, 59, 60.999));
	}

	@Test
	public final void testSixtySecondsAreNotValidIfTheInstantDoesNotRepresentALeapSecond() {
		//12/30/2008 was not the day of a leap second day.
		Assert.assertFalse(GregorianDate.isValid(2008, 12, 30, 23, 59, 60D));
		//23:58 is one minute before a valid leap second.
		Assert.assertFalse(GregorianDate.isValid(2008, 12, 31, 23, 58, 60D));
	}

	@Test
	public final void canConstructGregorianDateRepresentingLeapSecond() {
		GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 60D);
		Assert.assertEquals(60D, date.getSecond(), Constants.Epsilon14);
	}

	@Test(expected = ArgumentException.class)
	public final void cannotConstructGregorianDateRepresentingInvalidLeapSecond() {
		new GregorianDate(2008, 12, 30, 23, 59, 60D);
	}

	@Test
	public final void testConversionToJulianDate() {
		GregorianDate date = new GregorianDate(2008, 12, 31, 23, 59, 0D);
		JulianDate julianDate = date.toJulianDate();
		GregorianDate oneSecondLater = new GregorianDate(2008, 12, 31, 23, 59, 1D);
		GregorianDate oneSecondBefore = new GregorianDate(2008, 12, 31, 23, 58, 59D);
		Assert.assertEquals(1, oneSecondLater.toJulianDate().subtract(julianDate).getSeconds(), 0d);
		Assert.assertEquals(1, julianDate.subtract(oneSecondBefore.toJulianDate()).getSeconds(), 0d);
	}

	@Test
	public final void canConvertGregorianDateRepresentingLeapSecondToJulianDate() {
		GregorianDate leapSecondGregorianDate = new GregorianDate(2008, 12, 31, 23, 59, 60D);
		JulianDate leapSecondJulianDate = leapSecondGregorianDate.toJulianDate();
		AssertHelper.assertEquals(leapSecondGregorianDate, leapSecondJulianDate.toGregorianDate());
		GregorianDate oneSecondLater = new GregorianDate(2009, 1, 1, 0, 0, 0D);
		GregorianDate oneSecondBefore = new GregorianDate(2008, 12, 31, 23, 59, 59D);
		Assert.assertEquals(1, oneSecondLater.toJulianDate().subtract(leapSecondJulianDate).getSeconds(), 0d);
		Assert.assertEquals(1, leapSecondJulianDate.subtract(oneSecondBefore.toJulianDate()).getSeconds(), 0d);
	}

	@Test
	public final void testNonStandardTimeStandard() {
		GregorianDate gregorianDate = new GregorianDate(2008, 12, 31, 23, 59, 40D);
		JulianDate jd = gregorianDate.toJulianDate(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		AssertHelper.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, jd.getStandard());
		GregorianDate roundTrip1 = jd.toGregorianDate(TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		AssertHelper.assertEquals(gregorianDate, roundTrip1);
		GregorianDate roundTrip = new GregorianDate(jd);
		AssertHelper.assertNotEqual(gregorianDate, roundTrip);
		double expectedDifference = LeapSeconds.getInstance().getTaiMinusUtc(jd);
		Assert.assertEquals(expectedDifference, gregorianDate.getSecond() - roundTrip.getSecond(), 0d);
	}

	@Test
	public final void testRoundTripDefaultConstructed() {
		GregorianDate gd = new GregorianDate();
		GregorianDate gd2 = new GregorianDate(gd.toJulianDate());
		AssertHelper.assertEquals(gd, gd2);
	}

	@Rule
	public TestContextRule rule$testContext = new TestContextRule();
}