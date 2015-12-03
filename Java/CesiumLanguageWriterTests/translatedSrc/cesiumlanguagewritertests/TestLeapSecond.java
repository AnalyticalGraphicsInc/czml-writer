package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

/**
 *  
 Tests the  {@link LeapSecond} type.
 

 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeapSecond {
	/**
	 *  
	Tests equality between leap second instances.
	

	 */
	@Test
	public final void testEquality() {
		LeapSecond ls1 = new LeapSecond(2451545.0, 100.0);
		LeapSecond ls2 = new LeapSecond(2451545.0, 100.0);
		LeapSecond ls3 = new LeapSecond(2451545.0, 101.0);
		LeapSecond ls4 = new LeapSecond(2451546.0, 101.0);
		AssertHelper.assertEquals(ls1, ls2);
		Assert.assertTrue(LeapSecond.equals(ls1, ls2));
		AssertHelper.assertNotEqual(ls1, ls3);
		Assert.assertTrue(LeapSecond.notEquals(ls1, ls3));
		AssertHelper.assertNotEqual(ls1, 5);
		AssertHelper.assertNotEqual(ls3, ls4);
	}

	/**
	 *  
	Tests that JulianDate.GetHashCode returns something at least reasonably random.
	

	 */
	@Test
	public final void testGetHashCode() {
		LeapSecond ls1 = new LeapSecond(2451545.0, 100.0);
		LeapSecond ls2 = new LeapSecond(2451545.0, 100.0);
		LeapSecond ls3 = new LeapSecond(2451545.0, 101.0);
		Assert.assertEquals((int) ls1.hashCode(), (int) ls2.hashCode());
		AssertHelper.assertNotEqual(ls1.hashCode(), ls3.hashCode());
	}

	/**
	 *  
	Tests the ToString of LeapSecond.
	

	 */
	@Test
	public final void testToString() {
		LeapSecond ls1 = new LeapSecond(2451545.0, 100.0);
		Assert.assertEquals("2451545:0 (UTC), 100", ls1.toString());
	}

	@Rule
	public TestContextRule rule$testContext = new TestContextRule();
}