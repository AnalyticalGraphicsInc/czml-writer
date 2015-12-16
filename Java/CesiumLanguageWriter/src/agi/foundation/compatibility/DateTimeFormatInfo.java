package agi.foundation.compatibility;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Defines how DateTime values are formatted and displayed, depending on the culture.
 */
public final class DateTimeFormatInfo {
	private final DateFormatSymbols dateFormatSymbols;
	private final Locale locale;
	private static final Map<Locale, DateFormats> dateFormats;

	static {
		dateFormats = new HashMap<Locale, DateFormats>();

		DateFormats invariant = new DateFormats();
		dateFormats.put(CultureInfoHelper.getInvariantCulture(), invariant);
		invariant.setShortDatePattern("MM/dd/yyyy");
		invariant.setLongDatePattern("dddd, dd MMMM yyyy");
		invariant.setFullDateTimePattern("dddd, dd MMMM yyyy HH:mm:ss");
		invariant.setMonthDayPattern("MMMM dd");
		invariant.setRFC1123Pattern("ddd, dd MMM yyyy HH':'mm':'ss 'GMT'");
		invariant.setSortableDateTimePattern("yyyy'-'MM'-'dd'T'HH':'mm':'ss");
		invariant.setShortTimePattern("HH:mm");
		invariant.setLongTimePattern("HH:mm:ss");
		invariant.setUniversalSortableDateTimePattern("yyyy'-'MM'-'dd HH':'mm':'ss'Z'");
		invariant.setYearMonthPattern("yyyy MMMM");

		DateFormats enUS = new DateFormats(invariant);
		dateFormats.put(CultureInfoHelper.getCultureInfo("en-US"), enUS);
		enUS.setShortDatePattern("M/d/yyyy");
		enUS.setLongDatePattern("dddd, MMMM dd, yyyy");
		enUS.setFullDateTimePattern("dddd, MMMM dd, yyyy h:mm:ss tt");
		enUS.setShortTimePattern("h:mm tt");
		enUS.setLongTimePattern("h:mm:ss tt");
		enUS.setYearMonthPattern("MMMM, yyyy");
	}

	private static class DateFormats {
		private String shortDate;
		private String longDate;
		private String fullDateTime;
		private String monthDay;
		private String rfc1123;
		private String sortableDateTime;
		private String shortTime;
		private String longTime;
		private String universalSortableDateTime;
		private String yearMonth;
		private DateFormats defaults;

		public DateFormats() {
			defaults = null;
		}

		public DateFormats(DateFormats defaults) {
			this.defaults = defaults;
		}

		public String getFullDateTimePattern() {
			return fullDateTime != null ? fullDateTime : defaults.getFullDateTimePattern();
		}

		public String getLongDatePattern() {
			return longDate != null ? longDate : defaults.getLongDatePattern();
		}

		public String getLongTimePattern() {
			return longTime != null ? longTime : defaults.getLongTimePattern();
		}

		public String getMonthDayPattern() {
			return monthDay != null ? monthDay : defaults.getMonthDayPattern();
		}

		public String getRFC1123Pattern() {
			return rfc1123 != null ? rfc1123 : defaults.getRFC1123Pattern();
		}

		public String getShortDatePattern() {
			return shortDate != null ? shortDate : defaults.getShortDatePattern();
		}

		public String getShortTimePattern() {
			return shortTime != null ? shortTime : defaults.getShortTimePattern();
		}

		public String getSortableDateTimePattern() {
			return sortableDateTime != null ? sortableDateTime : defaults.getSortableDateTimePattern();
		}

		public String getUniversalSortableDateTimePattern() {
			return universalSortableDateTime != null ? universalSortableDateTime : defaults.getUniversalSortableDateTimePattern();
		}

		public String getYearMonthPattern() {
			return yearMonth != null ? yearMonth : defaults.getYearMonthPattern();
		}

		public void setFullDateTimePattern(String fullDateTimePattern) {
			this.fullDateTime = fullDateTimePattern;
		}

		public void setLongDatePattern(String longDatePattern) {
			this.longDate = longDatePattern;
		}

		public void setLongTimePattern(String longTimePattern) {
			this.longTime = longTimePattern;
		}

		public void setMonthDayPattern(String monthDayPattern) {
			this.monthDay = monthDayPattern;
		}

		public void setRFC1123Pattern(String rfc1123Pattern) {
			this.rfc1123 = rfc1123Pattern;
		}

		public void setShortDatePattern(String shortDatePattern) {
			this.shortDate = shortDatePattern;
		}

		public void setShortTimePattern(String shortTimePattern) {
			this.shortTime = shortTimePattern;
		}

		public void setSortableDateTimePattern(String sortableDateTimePattern) {
			this.sortableDateTime = sortableDateTimePattern;
		}

		public void setUniversalSortableDateTimePattern(String universalSortableDateTimePattern) {
			this.universalSortableDateTime = universalSortableDateTimePattern;
		}

		public void setYearMonthPattern(String yearMonthPattern) {
			this.yearMonth = yearMonthPattern;
		}
	}

	/**
	 * Returns the DateTimeFormatInfo associated with the specified Locale.
	 */
	public static DateTimeFormatInfo getInstance(Locale locale) {
		if (locale == null)
			locale = CultureInfoHelper.getCurrentCulture();
		return new DateTimeFormatInfo(locale, DateFormatSymbols.getInstance(locale));
	}

	/**
	 * Gets the default read-only DateTimeFormatInfo that is culture-independent
	 * (invariant).
	 */
	public static DateTimeFormatInfo getInvariantInfo() {
		return getInstance(CultureInfoHelper.getInvariantCulture());
	}

	private DateTimeFormatInfo(Locale locale, DateFormatSymbols dateFormatSymbols) {
		this.locale = locale;
		this.dateFormatSymbols = dateFormatSymbols;
	}

	/**
	 * Gets the string designator for hours that are "ante meridiem" (before noon).
	 */
	public String getAMDesignator() {
		return dateFormatSymbols.getAmPmStrings()[Calendar.AM];
	}

	/**
	 * Gets the string designator for hours that are "post meridiem" (after noon).
	 */
	public String getPMDesignator() {
		return dateFormatSymbols.getAmPmStrings()[Calendar.PM];
	}

	/**
	 * Returns the culture-specific abbreviated name of the specified day of the week
	 * based on the culture associated with the current DateTimeFormatInfo object.
	 */
	public String getAbbreviatedDayName(int dayOfWeek) {
		return dateFormatSymbols.getShortWeekdays()[DayOfWeek.toCalendar(dayOfWeek)];
	}

	/**
	 * Gets a one-dimensional array of type String containing the culture-specific
	 * abbreviated names of the days of the week.
	 */
	public String[] getAbbreviatedDayNames() {
		String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
		return new String[] {
				shortWeekdays[Calendar.SUNDAY],
				shortWeekdays[Calendar.MONDAY],
				shortWeekdays[Calendar.TUESDAY],
				shortWeekdays[Calendar.WEDNESDAY],
				shortWeekdays[Calendar.THURSDAY],
				shortWeekdays[Calendar.FRIDAY],
				shortWeekdays[Calendar.SATURDAY],
		};
	}

	/**
	 * Returns the culture-specific full name of the specified day of the week based on
	 * the culture associated with the current DateTimeFormatInfo object.
	 */
	public String getDayName(int dayOfWeek) {
		return dateFormatSymbols.getWeekdays()[DayOfWeek.toCalendar(dayOfWeek)];
	}

	/**
	 * Gets or sets a one-dimensional array of type String containing the culture-specific
	 * full names of the days of the week.
	 */
	public String[] getDayNames() {
		String[] weekdays = dateFormatSymbols.getWeekdays();
		return new String[] {
				weekdays[Calendar.SUNDAY],
				weekdays[Calendar.MONDAY],
				weekdays[Calendar.TUESDAY],
				weekdays[Calendar.WEDNESDAY],
				weekdays[Calendar.THURSDAY],
				weekdays[Calendar.FRIDAY],
				weekdays[Calendar.SATURDAY],
		};
	}

	/**
	 * Returns the culture-specific abbreviated name of the specified month based on the
	 * culture associated with the current DateTimeFormatInfo object.
	 * 
	 * @param month
	 *            An integer from 1 through 13 representing the name of the month to
	 *            retrieve.
	 * @return The culture-specific abbreviated name of the month represented by month.
	 */
	public String getAbbreviatedMonthName(int month) {
		return dateFormatSymbols.getShortMonths()[month - 1];
	}

	/**
	 * Gets a one-dimensional array of type String containing the culture-specific
	 * abbreviated names of the months.
	 */
	public String[] getAbbreviatedMonthNames() {
		return dateFormatSymbols.getShortMonths();
	}

	/**
	 * Returns the culture-specific full name of the specified month based on the culture
	 * associated with the current DateTimeFormatInfo object.
	 * 
	 * @param month
	 *            An integer from 1 through 13 representing the name of the month to
	 *            retrieve.
	 * @return The culture-specific full name of the month represented by month.
	 */
	public String getMonthName(int month) {
		return dateFormatSymbols.getMonths()[month - 1];
	}

	/**
	 * Gets a one-dimensional array of type String containing the culture-specific full
	 * names of the months.
	 */
	public String[] getMonthNames() {
		return dateFormatSymbols.getMonths();
	}

	/**
	 * Gets the string that separates the components of time, that is, the hour, minutes,
	 * and seconds.
	 */
	public String getTimeSeparator() {
		return ":";
	}

	/**
	 * Gets or sets the string that separates the components of a date, that is, the year,
	 * month, and day.
	 */
	public String getDateSeparator() {
		return "/";
	}

	/**
	 * Returns the string containing the name of the specified era.
	 * 
	 * @param era
	 *            The integer representing the era.
	 * @return A string containing the name of the era.
	 */
	public String getEraName(int era) {
		switch (era) {
		case 1:
			return "A.D.";
		default:
			throw new ArgumentException("Unknown era");
		}
	}

	private DateFormats getDateFormats() {
		DateFormats df = dateFormats.get(locale);
		if (df == null)
			df = dateFormats.get(CultureInfoHelper.getInvariantCulture());
		return df;
	}

	public String getMonthDayPattern() {
		return getDateFormats().getMonthDayPattern();
	}

	public String getYearMonthPattern() {
		return getDateFormats().getYearMonthPattern();
	}

	public String getShortDatePattern() {
		return getDateFormats().getShortDatePattern();
	}

	public String getLongDatePattern() {
		return getDateFormats().getLongDatePattern();
	}

	public String getShortTimePattern() {
		return getDateFormats().getShortTimePattern();
	}

	public String getLongTimePattern() {
		return getDateFormats().getLongTimePattern();
	}

	public String getFullDateTimePattern() {
		return getDateFormats().getFullDateTimePattern();
	}

	public String getRFC1123Pattern() {
		return getDateFormats().getRFC1123Pattern();
	}

	public String getSortableDateTimePattern() {
		return getDateFormats().getSortableDateTimePattern();
	}

	public String getUniversalSortableDateTimePattern() {
		return getDateFormats().getUniversalSortableDateTimePattern();
	}

	public String[] getAllDateTimePatterns() {
		return new String[] {
				getLongDatePattern(),
				getShortDatePattern(),
				getShortDatePattern() + " " + getLongTimePattern(),
				getShortDatePattern() + " " + getShortTimePattern(),
				getLongDatePattern() + " " + getLongTimePattern(),
				getLongDatePattern() + " " + getShortTimePattern(),
				getMonthDayPattern(),
				getRFC1123Pattern(),
				getSortableDateTimePattern(),
				getLongTimePattern(),
				getShortTimePattern(),
				getUniversalSortableDateTimePattern(),
				getYearMonthPattern(),
		};
	}
}
