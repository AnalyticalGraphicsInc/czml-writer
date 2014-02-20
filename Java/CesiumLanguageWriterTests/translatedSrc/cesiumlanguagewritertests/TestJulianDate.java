package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.IEquatable;
import cesiumlanguagewriter.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *  
 A series of tests to exercise this type.
 

 */
public class TestJulianDate {
	/**
	 *  
	Tests that initialization of and access to the structure day and time
	elements is performed correctly.
	

	 */
	@Test
	public final void testRetainValue() {
		JulianDate date = new JulianDate(100, 123.456789012);
		Assert.assertEquals((int) 100, (int) date.getDay());
		Assert.assertEquals(123.456789012, date.getSecondsOfDay(), 0d);
	}

	/**
	 *  
	Tests that initialization of and access to the structure time standard
	element is performed correctly.  Also tests that the default time standard
	is  {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME}.
	

	 */
	@Test
	public final void testTimeStandard() {
		JulianDate date = new JulianDate(0D);
		Assert.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, date.getStandard());
		date = new JulianDate(100, 123.456789012);
		Assert.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, date.getStandard());
		date = new JulianDate(100, 123.456789012, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(TimeStandard.COORDINATED_UNIVERSAL_TIME, date.getStandard());
	}

	/**
	 *  
	Tests that initialization produces a  {@link JulianDate} which is
	normalized with the time element in the range 0.0 <= seconds < 86400.0.
	

	 */
	@Test
	public final void testTimeGreaterThanADay() {
		JulianDate date = new JulianDate(2451545, 107000.0);
		Assert.assertEquals((int) 2451546, (int) date.getDay());
		Assert.assertEquals(20600.0, date.getSecondsOfDay(), 0d);
		date = new JulianDate(2451545, 107000.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		Assert.assertEquals((int) 2451546, (int) date.getDay());
		Assert.assertEquals(20600.0, date.getSecondsOfDay(), 0d);
	}

	/**
	 *  
	Tests that initialization produces a  {@link JulianDate} which is
	normalized with the time element in the range 0.0 <= seconds < 86400.0.
	

	 */
	@Test
	public final void testTimeNegative() {
		JulianDate date = new JulianDate(2451545, -45000.0);
		Assert.assertEquals((int) 2451544, (int) date.getDay());
		Assert.assertEquals(41400.0, date.getSecondsOfDay(), 0d);
		date = new JulianDate(2451545, -45000.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		Assert.assertEquals((int) 2451544, (int) date.getDay());
		Assert.assertEquals(41400.0, date.getSecondsOfDay(), 0d);
	}

	/**
	 *  
	Tests that initialization produces a  {@link JulianDate} which is
	normalized with the time element in the range 0.0 <= seconds < 86400.0.
	

	 */
	@Test
	public final void testTimeExactlyOneDay() {
		JulianDate date = new JulianDate(2451545, 86400.0);
		Assert.assertEquals((int) 2451546, (int) date.getDay());
		Assert.assertEquals(0.0, date.getSecondsOfDay(), 0d);
		date = new JulianDate(2451545, 86400.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		Assert.assertEquals((int) 2451546, (int) date.getDay());
		Assert.assertEquals(0.0, date.getSecondsOfDay(), 0d);
	}

	/**
	 *  
	Tests the check for EXACT equality and the check for equality within a specified tolerance.
	

	 */
	@Test
	public final void testEquality() {
		JulianDate first = new JulianDate(2451545, 0.2);
		JulianDate second = new JulianDate(2451545, 0.2);
		Assert.assertEquals(first, second);
		Assert.assertTrue(first.equalsType(second));
		Assert.assertTrue(second.equalsType(first));
		Assert.assertEquals((int) 0, (int) first.compareTo(second));
		Assert.assertEquals((int) 0, (int) second.compareTo(first));
		AssertHelper.assertNotEqual(first, 5);
		first = new JulianDate(2451545, 0.00001);
		second = new JulianDate(2451544, 86399.99999);
		AssertHelper.assertNotEqual(first, second);
		Assert.assertFalse(first.equalsType(second));
		Assert.assertFalse(second.equalsType(first));
		AssertHelper.assertNotEqual(0, first.compareTo(second));
		AssertHelper.assertNotEqual(0, second.compareTo(first));
		Assert.assertTrue(first.equalsEpsilon(second, 1e-4));
		Assert.assertTrue(second.equalsEpsilon(first, 1e-4));
	}

	/**
	 *  
	Tests the addition operation between a  {@link Duration} with unspecified time standard
	and a  {@link JulianDate}.
	

	 */
	@Test
	public final void testAddition() {
		JulianDate original = new JulianDate(2460000, 1000.0);
		Duration toAdd = Duration.fromSeconds(50.0);
		JulianDate added = original.add(toAdd);
		Assert.assertEquals((int) 2460000, (int) added.getDay());
		Assert.assertEquals(1050.0, added.getSecondsOfDay(), 0d);
		JulianDate subtracted = original.subtract(toAdd);
		Assert.assertEquals((int) 2460000, (int) subtracted.getDay());
		Assert.assertEquals(950.0, subtracted.getSecondsOfDay(), 0d);
		original = new JulianDate(2460000, 8382.1);
		toAdd = new Duration(1, 10.0);
		added = JulianDate.add(original, toAdd);
		Assert.assertEquals((int) 2460001, (int) added.getDay());
		Assert.assertEquals(8392.1, added.getSecondsOfDay(), 0d);
		subtracted = JulianDate.subtract(original, toAdd);
		Assert.assertEquals((int) 2459999, (int) subtracted.getDay());
		Assert.assertEquals(8372.1, subtracted.getSecondsOfDay(), 0d);
		original = new JulianDate(2460000, 86000.0);
		toAdd = Duration.fromSeconds(1000.0);
		added = original.add(toAdd);
		Assert.assertEquals((int) 2460001, (int) added.getDay());
		Assert.assertEquals(600.0, added.getSecondsOfDay(), 0d);
		subtracted = original.subtract(toAdd);
		Assert.assertEquals((int) 2460000, (int) subtracted.getDay());
		Assert.assertEquals(85000.0, subtracted.getSecondsOfDay(), 0d);
	}

	/**
	 *  
	Tests the function that determines the number of seconds between two Julian Dates
	

	 */
	@Test
	public final void testSecondsDifference() {
		// Test same standard - both safe
		JulianDate first = new JulianDate(2451545.0);
		JulianDate second = JulianDate.add(first, Duration.fromSeconds(120000D));
		Assert.assertEquals(120000, first.secondsDifference(second), 0d);
		Assert.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds(), first.secondsDifference(second), 0d);
		//Test same standard - both unsafe
		first = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		second = JulianDate.add(first, Duration.fromSeconds(120000D));
		second = new JulianDate(second.getDay(), second.getSecondsOfDay(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(120000, first.secondsDifference(second), 0d);
		Assert.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds(), first.secondsDifference(second), 0d);
		// Test diff standard - one unsafe, one safe
		first = new JulianDate(2451545.0);
		second = JulianDate.add(first, Duration.fromSeconds(120000D));
		JulianDate secondDiffStandard = second.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(120000, first.secondsDifference(secondDiffStandard), 0d);
		Assert.assertEquals((JulianDate.subtract(secondDiffStandard, first)).getTotalSeconds(), first.secondsDifference(secondDiffStandard), 0d);
	}

	/**
	 *  
	Tests the function that determines the number of seconds between two Julian Dates
	

	 */
	@Test
	public final void testMinutesDifference() {
		double totalElapsedTime = TimeConstants.SecondsPerDay * 2.5;
		double totalElapsedTimeMinutes = totalElapsedTime / TimeConstants.SecondsPerMinute;
		//Test same time standard, both safe
		JulianDate first = new JulianDate(2451545.0);
		JulianDate second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
		Assert.assertEquals(totalElapsedTimeMinutes, first.minutesDifference(second), 0d);
		Assert.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds() / TimeConstants.SecondsPerMinute, first.minutesDifference(second), 0d);
		//Test same time standard, both unsafe
		first = new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
		second = new JulianDate(second.getDay(), second.getSecondsOfDay(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(totalElapsedTimeMinutes, first.minutesDifference(second), 0d);
		Assert.assertEquals((JulianDate.subtract(second, first)).getTotalSeconds() / TimeConstants.SecondsPerMinute, first.minutesDifference(second), 0d);
		//Test diff time standard, one safe, one unsafe
		first = new JulianDate(2451545.0);
		second = JulianDate.add(first, Duration.fromSeconds(totalElapsedTime));
		JulianDate secondDiffStandard = second.toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(totalElapsedTimeMinutes, first.minutesDifference(secondDiffStandard), 0d);
		Assert.assertEquals((JulianDate.subtract(secondDiffStandard, first)).getTotalSeconds() / TimeConstants.SecondsPerMinute, first.minutesDifference(secondDiffStandard), 0d);
	}

	/**
	 *  
	Tests the subtraction operation between Julian dates.
	

	 */
	@Test
	public final void testSubtraction() {
		JulianDate first = new JulianDate(2469477, 1000.0);
		JulianDate second = new JulianDate(2469477, 2000.0);
		Duration difference = JulianDate.subtract(second, first);
		Assert.assertEquals(1000.0, difference.getTotalSeconds(), 0d);
		difference = JulianDate.subtract(first, second);
		Assert.assertEquals(-1000.0, difference.getTotalSeconds(), 0d);
		first = new JulianDate(2469477, 1000.0);
		second = new JulianDate(2469478, 2000.0);
		difference = JulianDate.subtract(second, first);
		Assert.assertEquals((int) 1, (int) difference.getDays());
		Assert.assertEquals(1000.0, difference.getSeconds(), 0d);
		difference = JulianDate.subtract(first, second);
		Assert.assertEquals((int) -1, (int) difference.getDays());
		Assert.assertEquals(-1000.0, difference.getSeconds(), 0d);
		first = new JulianDate(2469477, 86000.0);
		second = new JulianDate(2469478, 100.0);
		difference = JulianDate.subtract(second, first);
		Assert.assertEquals((int) 0, (int) difference.getDays());
		Assert.assertEquals(500.0, difference.getSeconds(), 0d);
		difference = JulianDate.subtract(first, second);
		Assert.assertEquals((int) 0, (int) difference.getDays());
		Assert.assertEquals(-500.0, difference.getSeconds(), 0d);
	}

	/**
	 *  
	Tests the JulianDate.AddSeconds method.
	

	 */
	@Test
	public final void testAddSeconds() {
		// Make sure AddSeconds produces the correct answer in the correct time standard.
		JulianDate test = new JulianDate(2451912, 43200.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		JulianDate result = test.addSeconds(45.123);
		Assert.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, result.getStandard());
		Assert.assertEquals((int) 2451912, (int) result.getDay());
		Assert.assertEquals(43245.123, result.getSecondsOfDay(), 0d);
	}

	/**
	 *  
	Tests the JulianDate.AddDays method.
	

	 */
	@Test
	public final void testAddDays() {
		// Make sure AddDays produces the correct answer in the correct time standard.
		JulianDate test = new JulianDate(2451912, 43200.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		JulianDate result = test.addDays(45.5);
		Assert.assertEquals(TimeStandard.INTERNATIONAL_ATOMIC_TIME, result.getStandard());
		Assert.assertEquals((int) 2451958, (int) result.getDay());
		Assert.assertEquals(0.0, result.getSecondsOfDay(), 0d);
	}

	/**
	 *  
	Tests that JulianDate.GetHashCode returns something at least reasonably random.
	

	 */
	@Test
	public final void testGetHashCode() {
		JulianDate date1 = new JulianDate(2451545, 0.0);
		JulianDate date2 = new JulianDate(2451545, 1.0);
		JulianDate date3 = new JulianDate(2451545, 0.0);
		AssertHelper.assertNotEqual(date1.hashCode(), date2.hashCode());
		Assert.assertEquals((int) date1.hashCode(), (int) date3.hashCode());
		date1 = new JulianDate(2451545, 0.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		date2 = new JulianDate(2451545, 0.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		AssertHelper.assertNotEqual(date1.hashCode(), date2.hashCode());
	}

	/**
	 *  
	Tests the JulianDate override of the  {@link Object#toString} method.
	

	 */
	@Test
	public final void testToString() {
		JulianDate date = new JulianDate(2451545.5);
		Assert.assertEquals("2451545:43200 (TAI)", date.toString());
	}

	/**
	 *  
	Tests for consistency between the comparison operators.
	

	 */
	@Test
	public final void testComparisonConsistency() {
		JulianDate one = new JulianDate(1, 0.0);
		JulianDate two = new JulianDate(1, 1e-11);
		Assert.assertTrue(JulianDate.greaterThan(two, one));
		Assert.assertTrue(JulianDate.greaterThanOrEqual(two, one));
		Assert.assertFalse(JulianDate.greaterThan(one, two));
		Assert.assertFalse(JulianDate.greaterThanOrEqual(one, two));
		Assert.assertFalse(JulianDate.lessThan(two, one));
		Assert.assertFalse(JulianDate.lessThanOrEqual(two, one));
		Assert.assertTrue(JulianDate.lessThan(one, two));
		Assert.assertTrue(JulianDate.lessThanOrEqual(one, two));
		Assert.assertFalse(JulianDate.equals(one, two));
		Assert.assertFalse(JulianDate.equals(two, one));
		Assert.assertTrue(JulianDate.notEquals(one, two));
		Assert.assertTrue(JulianDate.notEquals(two, one));
	}

	/**
	 *  
	Tests construction of a  {@link JulianDate} with a really small negative
	secondsOfDay.  JulianDate will attempt to eliminate the negative SecondsOfDay
	by rolling the Day back one day, but doing so results in setting the SecondsOfDay to
	86400.0 seconds.  This is still not normalized, so JulianDate should bump the Day
	back up and round the SecondsOfDay to 0.0.
	

	 */
	@Test
	public final void testReallySmallNegativeSecondsOfDay() {
		JulianDate date = new JulianDate(2451545, -Constants.Epsilon13);
		Assert.assertEquals((int) date.getDay(), (int) 2451545);
		Assert.assertEquals(0.0, date.getSecondsOfDay(), 0d);
	}

	@Test
	public final void testTryConvertTimeStandard() {
		JulianDate leapSecond = new JulianDate(2453736, 43232D, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		JulianDate afterLeapSecond = new JulianDate(2453736, 43233D, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		@CS2JInfo("Initialization of C# struct variable 'outDate' added by translator.")
		JulianDate outDate = new JulianDate();
		JulianDate[] out$outDate_0 = {
			null
		};
		Assert.assertFalse(leapSecond.tryConvertTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME, out$outDate_0));
		outDate = out$outDate_0[0];
		JulianDate[] out$outDate_1 = {
			null
		};
		Assert.assertTrue(afterLeapSecond.tryConvertTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME, out$outDate_1));
		outDate = out$outDate_1[0];
		Assert.assertEquals(outDate.getStandard(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(outDate, afterLeapSecond);
	}

	@Test
	public final void testEqualityOfLeapSeconds() {
		JulianDate leapSecond = new JulianDate(2453736, 43233D, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		JulianDate utcDate = new JulianDate(2453736, 43233D, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertFalse(utcDate.equalsType(leapSecond));
		Assert.assertFalse(leapSecond.equalsType(utcDate));
	}

	@Test
	public final void testSecondsDifferenceAtLeapSecond() {
		JulianDate leapSecond = new JulianDate(2453736, 43232D, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
		JulianDate utcDate = new JulianDate(2453736, 43232D, TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(-33, utcDate.secondsDifference(leapSecond), 0d);
		Assert.assertEquals(33, leapSecond.secondsDifference(utcDate), 0d);
		JulianDate secondBeforeLeapSecondUTC = leapSecond.subtractSeconds(1D).toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
		JulianDate secondAfterLeapSecondUTC = leapSecond.addSeconds(1D).toTimeStandard(TimeStandard.COORDINATED_UNIVERSAL_TIME);
		Assert.assertEquals(2, secondBeforeLeapSecondUTC.secondsDifference(secondAfterLeapSecondUTC), 0d);
		Assert.assertEquals(2, secondAfterLeapSecondUTC.subtract(secondBeforeLeapSecondUTC).getSeconds(), 0d);
	}

	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}