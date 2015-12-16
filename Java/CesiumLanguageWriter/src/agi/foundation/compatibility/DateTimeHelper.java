package agi.foundation.compatibility;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Helper methods related to DateTime.
 */
public final class DateTimeHelper {
	/**
	 * represents the number of 100 nanosecond ticks between the .NET epoch of 12:00:00
	 * midnight, January 1, 0001 and the Joda epoch of 1970-01-01T00:00:00Z
	 */
	private static final long ticksBetweenNETandJodaEpochs = 621355968000000000L;
	private static final int ticksPerMillisecond = 10000;

	private DateTimeHelper() {}

	public static DateTime today() {
		return new DateTime(new DateMidnight());
	}

	public static DateTime now() {
		return new DateTime();
	}

	public static DateTime utcNow() {
		return new DateTime(DateTimeZone.UTC);
	}

	public static int daysInMonth(int year, int month) {
		return new DateTime(year, month, 1, 0, 0, 0, 0).dayOfMonth().getMaximumValue();
	}

	public static DateTime fromTicks(long ticks, DateTimeZone utc) {
		long ticksSinceJodaEpoch = ticks - ticksBetweenNETandJodaEpochs;
		long millis = (long) Math.round(ticksSinceJodaEpoch / (double) ticksPerMillisecond);
		return new DateTime(millis, utc);
	}

	public static long getTicks(DateTime dateTime) {
		return (dateTime.getMillis() * ticksPerMillisecond) + ticksBetweenNETandJodaEpochs;
	}

	public static boolean isLeapYear(int year) {
		return new DateTime(year, 1, 1, 0, 0, 0, 0).year().isLeap();
	}

	public static DateTime minValue() {
		return new DateTime(1, 1, 1, 0, 0, 0, 0, DateTimeZone.UTC);
	}

	public static DateTime maxValue() {
		return new DateTime(9999, 12, 31, 23, 59, 59, 999, DateTimeZone.UTC);
	}
}
