package agi.foundation.compatibility;

import java.util.Calendar;

import org.joda.time.DateTimeConstants;

/**
 * Class storing values for System.DayOfWeek, with static methods to translate
 * either to the Java Calendar API mappings or the Joda mappings.
 * 
 * C# uses 0 through 7 for Sunday through Saturday.
 * 
 * Java Calendar uses 1 through 7 for Sunday through Saturday.
 * 
 * Joda uses 1 through 7 for Monday through Sunday.
 */
public final class DayOfWeek {
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;

	/**
	 * Arrays mapping the numeric values of the days of week between the various
	 * styles. C# uses 0 - 6. Joda and Calendar use 1 - 7 (but with different
	 * meanings).
	 */
	private static final int[] cSharpToCalendar = new int[7];
	private static final int[] jodaToCSharp = new int[8];

	static {
		cSharpToCalendar[SUNDAY] = Calendar.SUNDAY;
		cSharpToCalendar[MONDAY] = Calendar.MONDAY;
		cSharpToCalendar[TUESDAY] = Calendar.TUESDAY;
		cSharpToCalendar[WEDNESDAY] = Calendar.WEDNESDAY;
		cSharpToCalendar[THURSDAY] = Calendar.THURSDAY;
		cSharpToCalendar[FRIDAY] = Calendar.FRIDAY;
		cSharpToCalendar[SATURDAY] = Calendar.SATURDAY;

		jodaToCSharp[DateTimeConstants.SUNDAY] = SUNDAY;
		jodaToCSharp[DateTimeConstants.MONDAY] = MONDAY;
		jodaToCSharp[DateTimeConstants.TUESDAY] = TUESDAY;
		jodaToCSharp[DateTimeConstants.WEDNESDAY] = WEDNESDAY;
		jodaToCSharp[DateTimeConstants.THURSDAY] = THURSDAY;
		jodaToCSharp[DateTimeConstants.FRIDAY] = FRIDAY;
		jodaToCSharp[DateTimeConstants.SATURDAY] = SATURDAY;
	}

	private DayOfWeek() {}

	/**
	 * Get the appropriate C# calendar day of week from a Joda day of week.
	 * 
	 * @param jodaDayOfWeek
	 *            a Joda day of week, using 1 through 7 for Monday through
	 *            Sunday.
	 * @return a C# day of week, using 0 through 7 for Sunday through Saturday.
	 */
	public static int fromJoda(int jodaDayOfWeek) {
		validateBetween(jodaDayOfWeek, 1, 7);
		return jodaToCSharp[jodaDayOfWeek];
	}

	/**
	 * Get the appropriate Java calendar day of week from a C# day of week.
	 * 
	 * @param dayOfWeek
	 *            a C# day of week, using 0 through 7 for Sunday through
	 *            Saturday.
	 * @return a Java Calendar day of week, using 1 through 7 for Sunday through
	 *         Saturday.
	 */
	public static int toCalendar(int dayOfWeek) {
		validateBetween(dayOfWeek, 0, 6);
		return cSharpToCalendar[dayOfWeek];
	}

	private static void validateBetween(int dayOfWeek, int low, int high) {
		if (dayOfWeek < low || dayOfWeek > high)
			throw new IllegalArgumentException("Invalid day of week: " + dayOfWeek);
	}
}
