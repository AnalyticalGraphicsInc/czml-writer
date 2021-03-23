package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Defines how DateTime values are formatted and displayed, depending on the culture.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class DateTimeFormatInfo {
    @Nonnull
    private static final DateFormats invariantDateFormats;
    @Nonnull
    private static final Map<Locale, DateFormats> s_dateFormatsByLocale;
    @Nonnull
    private final DateFormats m_dateFormats;
    private final String[] m_amPmStrings;
    private final String[] m_shortWeekdays;
    private final String[] m_weekdays;
    private final String[] m_shortMonths;
    private final String[] m_months;

    static {
        invariantDateFormats = new DateFormatsInvariant();

        s_dateFormatsByLocale = new HashMap<>();
        s_dateFormatsByLocale.put(CultureInfoHelper.getInvariantCulture(), invariantDateFormats);

        DateFormatsForLocale enUS = new DateFormatsForLocale(invariantDateFormats);
        enUS.setShortDatePattern("M/d/yyyy");
        enUS.setLongDatePattern("dddd, MMMM d, yyyy");
        enUS.setFullDateTimePattern("dddd, MMMM d, yyyy h:mm:ss tt");
        enUS.setMonthDayPattern("MMMM d");
        enUS.setShortTimePattern("h:mm tt");
        enUS.setLongTimePattern("h:mm:ss tt");
        enUS.setYearMonthPattern("MMMM yyyy");
        s_dateFormatsByLocale.put(CultureInfoHelper.getCultureInfo("en-US"), enUS);
    }

    private DateTimeFormatInfo(Locale locale, DateFormatSymbols dateFormatSymbols) {
        DateFormats dateFormats = s_dateFormatsByLocale.get(locale);
        if (dateFormats == null)
            dateFormats = invariantDateFormats;

        assert dateFormats != null;
        m_dateFormats = dateFormats;
        m_amPmStrings = dateFormatSymbols.getAmPmStrings();
        m_shortWeekdays = dateFormatSymbols.getShortWeekdays();
        m_weekdays = dateFormatSymbols.getWeekdays();
        m_shortMonths = dateFormatSymbols.getShortMonths();
        m_months = dateFormatSymbols.getMonths();
    }

    private interface DateFormats {
        @Nonnull
        String getFullDateTimePattern();

        @Nonnull
        String getLongDatePattern();

        @Nonnull
        String getLongTimePattern();

        @Nonnull
        String getMonthDayPattern();

        @Nonnull
        String getRFC1123Pattern();

        @Nonnull
        String getShortDatePattern();

        @Nonnull
        String getShortTimePattern();

        @Nonnull
        String getSortableDateTimePattern();

        @Nonnull
        String getUniversalSortableDateTimePattern();

        @Nonnull
        String getYearMonthPattern();
    }

    @SuppressWarnings("unused")
    private static final class DateFormatsForLocale implements DateFormats {
        @Nullable
        private String shortDate;
        @Nullable
        private String longDate;
        @Nullable
        private String fullDateTime;
        @Nullable
        private String monthDay;
        @Nullable
        private String rfc1123;
        @Nullable
        private String sortableDateTime;
        @Nullable
        private String shortTime;
        @Nullable
        private String longTime;
        @Nullable
        private String universalSortableDateTime;
        @Nullable
        private String yearMonth;
        @Nonnull
        private final DateFormats defaults;

        public DateFormatsForLocale(@Nonnull DateFormats defaults) {
            this.defaults = defaults;
        }

        @Override
        @Nonnull
        public String getFullDateTimePattern() {
            return fullDateTime != null ? fullDateTime : defaults.getFullDateTimePattern();
        }

        @Override
        @Nonnull
        public String getLongDatePattern() {
            return longDate != null ? longDate : defaults.getLongDatePattern();
        }

        @Override
        @Nonnull
        public String getLongTimePattern() {
            return longTime != null ? longTime : defaults.getLongTimePattern();
        }

        @Override
        @Nonnull
        public String getMonthDayPattern() {
            return monthDay != null ? monthDay : defaults.getMonthDayPattern();
        }

        @Override
        @Nonnull
        public String getRFC1123Pattern() {
            return rfc1123 != null ? rfc1123 : defaults.getRFC1123Pattern();
        }

        @Override
        @Nonnull
        public String getShortDatePattern() {
            return shortDate != null ? shortDate : defaults.getShortDatePattern();
        }

        @Override
        @Nonnull
        public String getShortTimePattern() {
            return shortTime != null ? shortTime : defaults.getShortTimePattern();
        }

        @Override
        @Nonnull
        public String getSortableDateTimePattern() {
            return sortableDateTime != null ? sortableDateTime : defaults.getSortableDateTimePattern();
        }

        @Override
        @Nonnull
        public String getUniversalSortableDateTimePattern() {
            return universalSortableDateTime != null ? universalSortableDateTime : defaults.getUniversalSortableDateTimePattern();
        }

        @Override
        @Nonnull
        public String getYearMonthPattern() {
            return yearMonth != null ? yearMonth : defaults.getYearMonthPattern();
        }

        public void setFullDateTimePattern(@Nonnull String fullDateTimePattern) {
            fullDateTime = fullDateTimePattern;
        }

        public void setLongDatePattern(@Nonnull String longDatePattern) {
            longDate = longDatePattern;
        }

        public void setLongTimePattern(@Nonnull String longTimePattern) {
            longTime = longTimePattern;
        }

        public void setMonthDayPattern(@Nonnull String monthDayPattern) {
            monthDay = monthDayPattern;
        }

        public void setRFC1123Pattern(@Nonnull String rfc1123Pattern) {
            rfc1123 = rfc1123Pattern;
        }

        public void setShortDatePattern(@Nonnull String shortDatePattern) {
            shortDate = shortDatePattern;
        }

        public void setShortTimePattern(@Nonnull String shortTimePattern) {
            shortTime = shortTimePattern;
        }

        public void setSortableDateTimePattern(@Nonnull String sortableDateTimePattern) {
            sortableDateTime = sortableDateTimePattern;
        }

        public void setUniversalSortableDateTimePattern(@Nonnull String universalSortableDateTimePattern) {
            universalSortableDateTime = universalSortableDateTimePattern;
        }

        public void setYearMonthPattern(@Nonnull String yearMonthPattern) {
            yearMonth = yearMonthPattern;
        }
    }

    private static final class DateFormatsInvariant implements DateFormats {
        @Override
        public String getFullDateTimePattern() {
            return "dddd, dd MMMM yyyy HH:mm:ss";
        }

        @Override
        public String getLongDatePattern() {
            return "dddd, dd MMMM yyyy";
        }

        @Override
        public String getLongTimePattern() {
            return "HH:mm:ss";
        }

        @Override
        public String getMonthDayPattern() {
            return "MMMM dd";
        }

        @Override
        public String getRFC1123Pattern() {
            return "ddd, dd MMM yyyy HH':'mm':'ss 'GMT'";
        }

        @Override
        public String getShortDatePattern() {
            return "MM/dd/yyyy";
        }

        @Override
        public String getShortTimePattern() {
            return "HH:mm";
        }

        @Override
        public String getSortableDateTimePattern() {
            return "yyyy'-'MM'-'dd'T'HH':'mm':'ss";
        }

        @Override
        public String getUniversalSortableDateTimePattern() {
            return "yyyy'-'MM'-'dd HH':'mm':'ss'Z'";
        }

        @Override
        public String getYearMonthPattern() {
            return "yyyy MMMM";
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
    @Nonnull
    public static DateTimeFormatInfo getInstance(@Nullable Locale locale) {
        if (locale == null)
            locale = CultureInfoHelper.getCurrentCulture();
        return new DateTimeFormatInfo(locale, DateFormatSymbols.getInstance(locale));
    }

    /**
     * Gets the default read-only DateTimeFormatInfo that is culture-independent
     * (invariant).
     */
    @Nonnull
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

    @Nonnull
    public String getMonthDayPattern() {
        return m_dateFormats.getMonthDayPattern();
    }

    @Nonnull
    public String getYearMonthPattern() {
        return m_dateFormats.getYearMonthPattern();
    }

    @Nonnull
    public String getShortDatePattern() {
        return m_dateFormats.getShortDatePattern();
    }

    @Nonnull
    public String getLongDatePattern() {
        return m_dateFormats.getLongDatePattern();
    }

    @Nonnull
    public String getShortTimePattern() {
        return m_dateFormats.getShortTimePattern();
    }

    @Nonnull
    public String getLongTimePattern() {
        return m_dateFormats.getLongTimePattern();
    }

    @Nonnull
    public String getFullDateTimePattern() {
        return m_dateFormats.getFullDateTimePattern();
    }

    @Nonnull
    public String getRFC1123Pattern() {
        return m_dateFormats.getRFC1123Pattern();
    }

    @Nonnull
    public String getSortableDateTimePattern() {
        return m_dateFormats.getSortableDateTimePattern();
    }

    @Nonnull
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
