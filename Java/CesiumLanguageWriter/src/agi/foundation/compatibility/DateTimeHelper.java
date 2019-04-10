package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Helper methods related to DateTime.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class DateTimeHelper {
    private DateTimeHelper() {}

    /**
     * represents the number of 100 nanosecond ticks between the .NET epoch of 00:00:00,
     * January 1, 0001 and the Java time epoch of 1970-01-01T00:00:00Z
     */
    private static final long ticksBetweenDotNetAndJavaEpochs = 621355968000000000L;

    static final int nanosecondsPerMillisecond = 1_000_000;
    static final int millisecondsPerSecond = 1_000;

    static final int nanosecondsPerTick = 100;

    static final int ticksPerMillisecond = nanosecondsPerMillisecond / nanosecondsPerTick;
    static final int ticksPerSecond = ticksPerMillisecond * millisecondsPerSecond;

    @Nonnull
    private static final ZonedDateTime minValue = ZonedDateTime.of(LocalDateTime.of(1, 1, 1, 0, 0, 0), ZoneOffset.UTC);
    @Nonnull
    private static final ZonedDateTime maxValue = ZonedDateTime.of(LocalDateTime.of(9999, 12, 31, 23, 59, 59, 9999999 * nanosecondsPerTick), ZoneOffset.UTC);

    /**
     * The value of this constant is equivalent to 00:00:00.0000000, January 1, 0001.
     */
    @Nonnull
    public static ZonedDateTime minValue() {
        return minValue;
    }

    /**
     * The value of this constant is equivalent to 23:59:59.9999999, December 31, 9999.
     */
    @Nonnull
    public static ZonedDateTime maxValue() {
        return maxValue;
    }

    /**
     * Initializes a new instance from a specified number of ticks and a specified zone.
     *
     * @param ticks
     *            The number of 100-nanosecond ticks that have elapsed since January 1,
     *            0001 at 00:00:00.000.
     * @param kind
     *            Whether ticks specifies a local time or UTC.
     */
    @Nonnull
    public static ZonedDateTime create(long ticks, @Nonnull ZoneId kind) {
        long ticksSinceJavaEpoch = ticks - ticksBetweenDotNetAndJavaEpochs;
        long seconds = ticksSinceJavaEpoch / ticksPerSecond;
        long nanosecondRemainder = (ticksSinceJavaEpoch % ticksPerSecond) * nanosecondsPerTick;
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(seconds, nanosecondRemainder), kind);
    }

    /**
     * Initializes a new instance from a specified year, month and day.
     *
     * @param year
     *            The year (1 through 9999)
     * @param month
     *            The month (1 through 12)
     * @param day
     *            The day (1 through the number of days in month)
     */
    @Nonnull
    public static ZonedDateTime create(int year, int month, int day) {
        return create(year, month, day, 0, 0, 0);
    }

    /**
     * Initializes a new instance from a specified year, month and day.
     *
     * @param year
     *            The year (1 through 9999)
     * @param month
     *            The month (1 through 12)
     * @param day
     *            The day (1 through the number of days in month)
     * @param hour
     *            The hour (0 through 23)
     * @param minute
     *            The minute (0 through 59)
     * @param second
     *            The second (0 through 59)
     */
    @Nonnull
    public static ZonedDateTime create(int year, int month, int day, int hour, int minute, int second) {
        return create(year, month, day, hour, minute, second, ZoneOffset.UTC);
    }

    /**
     * Initializes a new instance from a specified year, month and day.
     *
     * @param year
     *            The year (1 through 9999)
     * @param month
     *            The month (1 through 12)
     * @param day
     *            The day (1 through the number of days in month)
     * @param hour
     *            The hour (0 through 23)
     * @param minute
     *            The minute (0 through 59)
     * @param second
     *            The second (0 through 59)
     * @param kind
     *            Whether the parameters specify a local time or UTC.
     */
    @Nonnull
    public static ZonedDateTime create(int year, int month, int day, int hour, int minute, int second, @Nonnull ZoneId kind) {
        return ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, minute, second), kind);
    }

    /**
     * Initializes a new instance from a specified year, month and day.
     *
     * @param year
     *            The year (1 through 9999)
     * @param month
     *            The month (1 through 12)
     * @param day
     *            The day (1 through the number of days in month)
     * @param hour
     *            The hour (0 through 23)
     * @param minute
     *            The minute (0 through 59)
     * @param second
     *            The second (0 through 59)
     * @param millisecond
     *            The millisecond (0 through 999)
     */
    @Nonnull
    public static ZonedDateTime create(int year, int month, int day, int hour, int minute, int second, int millisecond) {
        return create(year, month, day, hour, minute, second, millisecond, ZoneOffset.UTC);
    }

    /**
     * Initializes a new instance from a specified year, month and day.
     *
     * @param year
     *            The year (1 through 9999)
     * @param month
     *            The month (1 through 12)
     * @param day
     *            The day (1 through the number of days in month)
     * @param hour
     *            The hour (0 through 23)
     * @param minute
     *            The minute (0 through 59)
     * @param second
     *            The second (0 through 59)
     * @param millisecond
     *            The millisecond (0 through 999)
     * @param kind
     *            Whether the parameters specify a local time or UTC.
     */
    @Nonnull
    public static ZonedDateTime create(int year, int month, int day, int hour, int minute, int second, int millisecond, @Nonnull ZoneId kind) {
        return ZonedDateTime.of(LocalDateTime.of(year, month, day, hour, minute, second, millisecond * nanosecondsPerMillisecond), kind);
    }

    /**
     * Gets an instance set to the current date and time on this computer, in local time.
     */
    @Nonnull
    public static ZonedDateTime now() {
        return ZonedDateTime.now();
    }

    /**
     * Gets an instance set to the current date and time on this computer, in UTC.
     */
    @Nonnull
    public static ZonedDateTime utcNow() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }

    /**
     * Gets the current date.
     */
    @Nonnull
    public static ZonedDateTime today() {
        return ZonedDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT, ZoneId.systemDefault());
    }

    /**
     * Returns the number of days in the specified month and year.
     *
     * @param year
     *            The year
     * @param month
     *            The month (from 1 to 12)
     */
    public static int daysInMonth(int year, int month) {
        return YearMonth.of(year, month).lengthOfMonth();
    }

    /**
     * Gets the number of ticks that represent the date and time of a given instance.
     */
    public static long getTicks(@Nonnull ZonedDateTime dateTime) {
        Instant instant = dateTime.toInstant();
        return instant.getEpochSecond() * ticksPerSecond + instant.getNano() / nanosecondsPerTick + ticksBetweenDotNetAndJavaEpochs;
    }

    /**
     * Gets the milliseconds component of the given instance.
     *
     * @return milliseconds (between 0 and 999)
     */
    public static int getMillisecond(@Nonnull ZonedDateTime dateTime) {
        return dateTime.get(ChronoField.MILLI_OF_SECOND);
    }

    /**
     * Returns whether the specified year is a leap year.
     *
     * @param year
     *            The 4-digit year.
     * @return true if year is a leap year, otherwise false.
     */
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    /**
     * Converts the value of the given instance to UTC.
     */
    @Nonnull
    public static ZonedDateTime toUniversalTime(@Nonnull ZonedDateTime dateTime) {
        return dateTime.withZoneSameInstant(ZoneOffset.UTC);
    }

    @Nonnull
    private static String adjustFormatString(@Nullable String format, @Nullable Locale locale) {
        if (StringHelper.isNullOrEmpty(format)) {
            format = "G";
        }
        assert format != null;

        if (format.length() == 1) {
            // standard format specifiers
            format = getStandardFormatSpecifier(format, locale);
        }

        // Custom format string indicator in .NET: '%'. Ignore in Java.
        if (format.startsWith("%")) {
            format = format.substring(1);
        }
        // day of week in .NET: 3 or 4 'd'. In Java: 'E'.
        format = format.replace("dddd", "EEEE").replace("ddd", "EEE");
        // AM/PM in .NET: 'tt'. In Java: 'a'
        // (not supported by Java: .NET single 't' for first character of AM/PM)
        format = format.replace("tt", "a").replace("t", "a");
        // period/era in .NET: 'g'. In Java: 'G'
        format = format.replace("g", "G");
        return format;
    }

    @Nonnull
    private static String getStandardFormatSpecifier(@Nonnull String format, @Nullable Locale locale) {
        DateTimeFormatInfo info = DateTimeFormatInfo.getInstance(locale);
        switch (format) {
        // The Short Date ("d") Format Specifier
        case "d":
            return info.getShortDatePattern();
        // The Long Date ("D") Format Specifier
        case "D":
            return info.getLongDatePattern();
        // The Full Date Short Time ("f") Format Specifier
        case "f":
            return info.getLongDatePattern() + " " + info.getShortTimePattern();
        // The Full Date Long Time ("F") Format Specifier
        case "F":
            return info.getFullDateTimePattern();
        // The General Date Short Time ("g") Format Specifier
        case "g":
            return info.getShortDatePattern() + " " + info.getShortTimePattern();
        // The General Date Long Time ("G") Format Specifier
        case "G":
            return info.getShortDatePattern() + " " + info.getLongTimePattern();
        // The Month ("M", "m") Format Specifier
        case "m":
        case "M":
            return info.getMonthDayPattern();
        // The Round-trip ("O", "o") Format Specifier
        case "o":
        case "O":
            // .NET uses K at the end for time zone info, which in Java is X.
            // f for fractional seconds is S in Java.
            return "yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSSSSSSX";
        // The RFC1123 ("R", "r") Format Specifier
        case "r":
        case "R":
            return info.getRFC1123Pattern();
        // The Sortable ("s") Format Specifier
        case "s":
            return info.getSortableDateTimePattern();
        // The Short Time ("t") Format Specifier
        case "t":
            return info.getShortTimePattern();
        // The Long Time ("T") Format Specifier
        case "T":
            return info.getLongTimePattern();
        // The Universal Sortable ("u") Format Specifier
        case "u":
            return info.getUniversalSortableDateTimePattern();
        // The Year Month ("Y", "y") Format Specifier
        case "Y":
        case "y":
            return info.getYearMonthPattern();
        default:
            // unknown
            return format;
        }
    }

    @Nonnull
    public static String toString(@Nonnull ZonedDateTime dateTime) {
        return toString(dateTime, null, null);
    }

    @Nonnull
    public static String toString(@Nonnull ZonedDateTime dateTime, @Nullable Locale locale) {
        return toString(dateTime, null, locale);
    }

    @Nonnull
    public static String toString(@Nonnull ZonedDateTime dateTime, @Nullable String format) {
        return toString(dateTime, format, null);
    }

    @Nonnull
    public static String toString(@Nonnull ZonedDateTime dateTime, @Nullable String format, @Nullable Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(adjustFormatString(format, locale));
        if (locale != null)
            formatter = formatter.withLocale(locale);
        return formatter.format(dateTime);
    }
}
