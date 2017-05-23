package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JWarning;

/**
 *  
 Contains time-related constants.
 

 */
@SuppressWarnings("unused")
public final class TimeConstants {
    private TimeConstants() {}

    /**
    *  
    The number of seconds in a minute.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double SecondsPerMinute = 60.0;
    /**
    *  
    The number of minutes in an hour.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double MinutesPerHour = 60.0;
    /**
    *  
    The number of hours in a day.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double HoursPerDay = 24.0;
    /**
    *  
    The number of seconds in an hour.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double SecondsPerHour = SecondsPerMinute * MinutesPerHour;
    /**
    *  
    The number of minutes in a day.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double MinutesPerDay = HoursPerDay * MinutesPerHour;
    /**
    *  
    The number of seconds in a standard day that does not have leap seconds.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double SecondsPerDay = HoursPerDay * MinutesPerHour * SecondsPerMinute;
    /**
    *  
    The number of standard days in a Julian century.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double DaysPerJulianCentury = 36525.0;
    /**
    *  
    One picosecond
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double PicoSecond = .000000001;
    /**
    *  
    The difference between a Julian date and a modified Julian date.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public static final double ModifiedJulianDateDifference = 2400000.5;
    /**
    *  
    The next representable 64-bit double before 86400.0.  This is useful for normalizing
    times that must be less than a day (for example, the {@code SecondsOfDay} ({@link JulianDate#getSecondsOfDay get}) property
    of {@link JulianDate}).
    

    */
    public static final double NextBefore86400 = 86399.999999999985;
}