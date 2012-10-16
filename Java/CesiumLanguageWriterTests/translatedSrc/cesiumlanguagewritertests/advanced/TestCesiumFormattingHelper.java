package cesiumlanguagewritertests.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewritertests.*;
import org.junit.Assert;
import org.junit.Test;

public class TestCesiumFormattingHelper {
	@Test
	public final void passToIso8601Interval() {
		//Since ToIso8601Interval is just a simple wrapper around two calls to
		//CesiumFormattingHelper.ToIso8601, this test is just a smoke screen.
		String expectedBasicInterval = "19800801T000000Z/20720703T000000Z";
		String expectedExtendedInterval = "1980-08-01T00:00:00Z/2072-07-03T00:00:00Z";
		String expectedCompactInterval = "19800801T00Z/20720703T00Z";
		JulianDate start = new GregorianDate(1980, 8, 1).toJulianDate();
		JulianDate stop = new GregorianDate(2072, 7, 3).toJulianDate();
		String basicInterval = CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.BASIC);
		Assert.assertEquals(expectedBasicInterval, basicInterval);
		String extendedInterval = CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.EXTENDED);
		Assert.assertEquals(expectedExtendedInterval, extendedInterval);
		String compactInterval = CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT);
		Assert.assertEquals(expectedCompactInterval, compactInterval);
		TimeInterval interval = new TimeInterval(start, stop);
		basicInterval = CesiumFormattingHelper.toIso8601Interval(interval, Iso8601Format.BASIC);
		Assert.assertEquals(expectedBasicInterval, basicInterval);
		extendedInterval = CesiumFormattingHelper.toIso8601Interval(interval, Iso8601Format.EXTENDED);
		Assert.assertEquals(expectedExtendedInterval, extendedInterval);
		compactInterval = CesiumFormattingHelper.toIso8601Interval(interval, Iso8601Format.COMPACT);
		Assert.assertEquals(expectedCompactInterval, compactInterval);
	}

	@Test
	public final void passClampToIso8601() {
		String expectedMinimumBasic = "00000101T000000Z";
		String minStringBasic = CesiumFormattingHelper.toIso8601(JulianDate.getMinValue(), Iso8601Format.BASIC);
		Assert.assertEquals(expectedMinimumBasic, minStringBasic);
		String expectedMaximumBasic = "99991231T240000Z";
		String maxStringBasic = CesiumFormattingHelper.toIso8601(JulianDate.getMaxValue(), Iso8601Format.BASIC);
		Assert.assertEquals(expectedMaximumBasic, maxStringBasic);
		String expectedMinimumExtended = "0000-01-01T00:00:00Z";
		String minStringExtended = CesiumFormattingHelper.toIso8601(JulianDate.getMinValue(), Iso8601Format.EXTENDED);
		Assert.assertEquals(expectedMinimumExtended, minStringExtended);
		String expectedMaximumExtended = "9999-12-31T24:00:00Z";
		String maxStringExtended = CesiumFormattingHelper.toIso8601(JulianDate.getMaxValue(), Iso8601Format.EXTENDED);
		Assert.assertEquals(expectedMaximumExtended, maxStringExtended);
		String expectedMinimumCompact = "00000101T00Z";
		String minStringCompact = CesiumFormattingHelper.toIso8601(JulianDate.getMinValue(), Iso8601Format.COMPACT);
		Assert.assertEquals(expectedMinimumCompact, minStringCompact);
		String expectedMaximumCompact = "99991231T24Z";
		String maxStringCompact = CesiumFormattingHelper.toIso8601(JulianDate.getMaxValue(), Iso8601Format.COMPACT);
		Assert.assertEquals(expectedMaximumCompact, maxStringCompact);
	}
}