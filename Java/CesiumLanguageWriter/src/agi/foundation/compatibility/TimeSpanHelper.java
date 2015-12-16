package agi.foundation.compatibility;

import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * Helper methods related to TimeSpan.
 */
public final class TimeSpanHelper {
	private static final int MILLIS_PER_DAY = 86400000;

	/**
	 * Represents the number of ticks in 1 day.
	 */
	public static final long TICKS_PER_DAY = 864000000000L;

	/**
	 * Represents the number of ticks in 1 millisecond.
	 */
	public static final long TICKS_PER_MILLISECOND = 10000L;

	/**
	 * Represents the number of ticks in 1 second.
	 */
	public static final long TICKS_PER_SECOND = 10000000L;

	private TimeSpanHelper() {}

	public static Period fromTicks(long ticks) {
		int days = (int) (ticks / TICKS_PER_DAY);
		long remainingTicks = ticks % TICKS_PER_DAY;
		return new Period(remainingTicks / TICKS_PER_MILLISECOND, PeriodType.dayTime()).plusDays(days);
	}

	public static Period newPeriod(int days, int hours, int minutes, int seconds) {
		return newPeriod(days, hours, minutes, seconds, 0);
	}

	public static Period newPeriod(int days, int hours, int minutes, int seconds, int milliseconds) {
		Period period = new Period(0, 0, 0, days, hours, minutes, seconds, milliseconds);
		return period.normalizedStandard(PeriodType.dayTime());
	}

	public static Period fromDays(double daysWithFraction) {
		long milliseconds = Math.round(daysWithFraction * MILLIS_PER_DAY);
		return new Period(milliseconds, PeriodType.dayTime());
	}

	public static double totalSeconds(Period period) {
		PeriodType periodType = PeriodType.time().withHoursRemoved().withMinutesRemoved();
		Period converted = period.toStandardDuration().toPeriod(periodType);
		double millisInFractionalSeconds = converted.getMillis() / 1000D;
		return converted.getSeconds() + millisInFractionalSeconds;
	}

	public static Period maxValue() {
		return new Period(0, 0, 0, 10675199, 2, 48, 5, 477, PeriodType.dayTime());
	}

	public static Period minValue() {
		return new Period(0, 0, 0, -10675199, -2, -48, -5, -477, PeriodType.dayTime());
	}

	public static Period zero() {
		return new Period(0, PeriodType.dayTime());
	}
}
