package cesiumlanguagewriter;


import agi.foundation.compatibility.*;

/**
 * Contains time-related constants.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public final class TimeConstants {
    private TimeConstants() {}

    /**
    * The number of seconds in a minute.
    */
    public static final double SecondsPerMinute = 60.0;
    /**
    * The number of minutes in an hour.
    */
    public static final double MinutesPerHour = 60.0;
    /**
    * The number of hours in a day.
    */
    public static final double HoursPerDay = 24.0;
    /**
    * The number of seconds in an hour.
    */
    public static final double SecondsPerHour = SecondsPerMinute * MinutesPerHour;
    /**
    * The number of minutes in a day.
    */
    public static final double MinutesPerDay = HoursPerDay * MinutesPerHour;
    /**
    * The number of seconds in a standard day that does not have leap seconds.
    */
    public static final double SecondsPerDay = HoursPerDay * MinutesPerHour * SecondsPerMinute;
    /**
    * The next representable 64-bit double before 86400.0.  This is useful for normalizing
    times that must be less than a day (for example, the {@code SecondsOfDay} ({@link JulianDate#getSecondsOfDay get}) property
    of {@link JulianDate}).
    */
    public static final double NextBefore86400 = 86399.999999999985;
}