package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLeapSecond {
    @Test
    public final void testConstructor() {
        LeapSecond leapSecond = new LeapSecond(2451545.0, 100.0);
        AssertHelper.assertEquals(2451545.0, leapSecond.getDate().getTotalDays());
        AssertHelper.assertEquals(100.0, leapSecond.getTotalTaiOffsetFromUtc());
        AssertHelper.assertEquals(TimeStandard.COORDINATED_UNIVERSAL_TIME, leapSecond.getDate().getStandard());
    }

    @Test
    public final void testConstructorRequiresUTC() {
        ArgumentException exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            LeapSecond unused = new LeapSecond(new JulianDate(2451545.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME), 100.0);
        }));
        AssertHelper.assertStringContains("The given date must be in the UTC time standard", exception.getMessage());
    }

    /**
    * Tests equality between leap second instances.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Test
    public final void testEquality() {
        LeapSecond leapSecond1 = new LeapSecond(2451545.0, 100.0);
        LeapSecond leapSecond2 = new LeapSecond(2451545.0, 100.0);
        LeapSecond leapSecond3 = new LeapSecond(2451545.0, 101.0);
        LeapSecond leapSecond4 = new LeapSecond(2451546.0, 101.0);
        AssertHelper.assertEquals(leapSecond1, leapSecond2);
        Assert.assertTrue(LeapSecond.equals(leapSecond1, leapSecond2));
        AssertHelper.assertNotEqual(leapSecond1, leapSecond3);
        Assert.assertTrue(LeapSecond.notEquals(leapSecond1, leapSecond3));
        Object differentType = 5;
        AssertHelper.assertNotEqual(leapSecond1, differentType);
        AssertHelper.assertNotEqual(leapSecond3, leapSecond4);
    }

    /**
    * Tests that JulianDate.GetHashCode returns something at least reasonably random.
    */
    @Test
    public final void testGetHashCode() {
        LeapSecond leapSecond1 = new LeapSecond(2451545.0, 100.0);
        LeapSecond leapSecond2 = new LeapSecond(2451545.0, 100.0);
        LeapSecond leapSecond3 = new LeapSecond(2451545.0, 101.0);
        AssertHelper.assertEquals(leapSecond1.hashCode(), leapSecond2.hashCode());
        AssertHelper.assertNotEqual(leapSecond1.hashCode(), leapSecond3.hashCode());
    }

    /**
    * Tests the ToString of LeapSecond.
    */
    @Test
    public final void testToString() {
        LeapSecond leapSecond = new LeapSecond(2451545.0, 100.0);
        String expected = StringHelper.format("2451545:0 UTC ({0}), 100", new GregorianDate(new JulianDate(2451545.0, TimeStandard.COORDINATED_UNIVERSAL_TIME)));
        AssertHelper.assertEquals(expected, leapSecond.toString());
    }

    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}