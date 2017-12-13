package agi.foundation.compatibility;

import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nonnull;

/**
 * Defines how DateTime values are formatted and displayed, depending on the culture.
 */
public final class DateTimeFormatInfo {
    @Nonnull
    private static final Map<Locale, DateFormats> s_dateFormatsByLocale;
    private final DateFormats m_dateFormats;
    private final String[] m_amPmStrings;
    private final String[] m_shortWeekdays;
    private final String[] m_weekdays;
    private final String[] m_shortMonths;
    private final String[] m_months;

    static {
        s_dateFormatsByLocale = new HashMap<>();

        DateFormats invariant = new DateFormats();
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
        s_dateFormatsByLocale.put(CultureInfoHelper.getInvariantCulture(), invariant);

        DateFormats enUS = new DateFormats(invariant);
        enUS.setShortDatePattern("M/d/yyyy");
        enUS.setLongDatePattern("dddd, MMMM dd, yyyy");
        enUS.setFullDateTimePattern("dddd, MMMM dd, yyyy h:mm:ss tt");
        enUS.setShortTimePattern("h:mm tt");
        enUS.setLongTimePattern("h:mm:ss tt");
        enUS.setYearMonthPattern("MMMM, yyyy");
        s_dateFormatsByLocale.put(CultureInfoHelper.getCultureInfo("en-US"), enUS);
    }

    private DateTimeFormatInfo(Locale locale, DateFormatSymbols dateFormatSymbols) {
        DateFormats dateFormats = s_dateFormatsByLocale.get(locale);
        if (dateFormats == null)
            dateFormats = s_dateFormatsByLocale.get(CultureInfoHelper.getInvariantCulture());

        m_dateFormats = dateFormats;
        m_amPmStrings = dateFormatSymbols.getAmPmStrings();
        m_shortWeekdays = dateFormatSymbols.getShortWeekdays();
        m_weekdays = dateFormatSymbols.getWeekdays();
        m_shortMonths = dateFormatSymbols.getShortMonths();
        m_months = dateFormatSymbols.getMonths();
    }

    private static final class DateFormats {
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
        private final DateFormats defaults;

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
            fullDateTime = fullDateTimePattern;
        }

        public void setLongDatePattern(String longDatePattern) {
            longDate = longDatePattern;
        }

        public void setLongTimePattern(String longTimePattern) {
            longTime = longTimePattern;
        }

        public void setMonthDayPattern(String monthDayPattern) {
            monthDay = monthDayPattern;
        }

        public void setRFC1123Pattern(String rfc1123Pattern) {
            rfc1123 = rfc1123Pattern;
        }

        public void setShortDatePattern(String shortDatePattern) {
            shortDate = shortDatePattern;
        }

        public void setShortTimePattern(String shortTimePattern) {
            shortTime = shortTimePattern;
        }

        public void setSortableDateTimePattern(String sortableDateTimePattern) {
            sortableDateTime = sortableDateTimePattern;
        }

        public void setUniversalSortableDateTimePattern(String universalSortableDateTimePattern) {
            universalSortableDateTime = universalSortableDateTimePattern;
        }

        public void setYearMonthPattern(String yearMonthPattern) {
            yearMonth = yearMonthPattern;
        }
    }

    private int dayOfWeekToCalendarValue(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
        case SUNDAY:
            return Calendar.SUNDAY;
        case MONDAY:
            return Calendar.MONDAY;
        case TUESDAY:
            return Calendar.TUESDAY;
        case WEDNESDAY:
            return Calendar.WEDNESDAY;
        case THURSDAY:
            return Calendar.THURSDAY;
        case FRIDAY:
            return Calendar.FRIDAY;
        case SATURDAY:
            return Calendar.SATURDAY;
        default:
            throw new IllegalArgumentException();
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

    /**
     * Gets the string designator for hours that are "ante meridiem" (before noon).
     */
    public String getAMDesignator() {
        return m_amPmStrings[Calendar.AM];
    }

    /**
     * Gets the string designator for hours that are "post meridiem" (after noon).
     */
    public String getPMDesignator() {
        return m_amPmStrings[Calendar.PM];
    }

    /**
     * Returns the culture-specific abbreviated name of the specified day of the week
     * based on the culture associated with the current DateTimeFormatInfo object.
     */
    public String getAbbreviatedDayName(DayOfWeek dayOfWeek) {
        return m_shortWeekdays[dayOfWeekToCalendarValue(dayOfWeek)];
    }

    /**
     * Gets a one-dimensional array of type String containing the culture-specific
     * abbreviated names of the days of the week.
     */
    public String[] getAbbreviatedDayNames() {
        return new String[] {
                m_shortWeekdays[Calendar.SUNDAY],
                m_shortWeekdays[Calendar.MONDAY],
                m_shortWeekdays[Calendar.TUESDAY],
                m_shortWeekdays[Calendar.WEDNESDAY],
                m_shortWeekdays[Calendar.THURSDAY],
                m_shortWeekdays[Calendar.FRIDAY],
                m_shortWeekdays[Calendar.SATURDAY],
        };
    }

    /**
     * Returns the culture-specific full name of the specified day of the week based on
     * the culture associated with the current DateTimeFormatInfo object.
     */
    public String getDayName(DayOfWeek dayOfWeek) {
        return m_weekdays[dayOfWeekToCalendarValue(dayOfWeek)];
    }

    /**
     * Gets or sets a one-dimensional array of type String containing the culture-specific
     * full names of the days of the week.
     */
    public String[] getDayNames() {
        return new String[] {
                m_weekdays[Calendar.SUNDAY],
                m_weekdays[Calendar.MONDAY],
                m_weekdays[Calendar.TUESDAY],
                m_weekdays[Calendar.WEDNESDAY],
                m_weekdays[Calendar.THURSDAY],
                m_weekdays[Calendar.FRIDAY],
                m_weekdays[Calendar.SATURDAY],
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
        return m_shortMonths[month - 1];
    }

    /**
     * Gets a one-dimensional array of type String containing the culture-specific
     * abbreviated names of the months.
     */
    public String[] getAbbreviatedMonthNames() {
        return m_shortMonths;
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
        return m_months[month - 1];
    }

    /**
     * Gets a one-dimensional array of type String containing the culture-specific full
     * names of the months.
     */
    public String[] getMonthNames() {
        return m_months;
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

    public String getMonthDayPattern() {
        return m_dateFormats.getMonthDayPattern();
    }

    public String getYearMonthPattern() {
        return m_dateFormats.getYearMonthPattern();
    }

    public String getShortDatePattern() {
        return m_dateFormats.getShortDatePattern();
    }

    public String getLongDatePattern() {
        return m_dateFormats.getLongDatePattern();
    }

    public String getShortTimePattern() {
        return m_dateFormats.getShortTimePattern();
    }

    public String getLongTimePattern() {
        return m_dateFormats.getLongTimePattern();
    }

    public String getFullDateTimePattern() {
        return m_dateFormats.getFullDateTimePattern();
    }

    public String getRFC1123Pattern() {
        return m_dateFormats.getRFC1123Pattern();
    }

    public String getSortableDateTimePattern() {
        return m_dateFormats.getSortableDateTimePattern();
    }

    public String getUniversalSortableDateTimePattern() {
        return m_dateFormats.getUniversalSortableDateTimePattern();
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
