package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 Provides a means for measuring time by specifying the rate at which time passes and/or points in time.
 

 */
public enum TimeStandard implements Enumeration {
    /**
    *  
    The International Atomic Time (TAI) time standard.
    

    */
    INTERNATIONAL_ATOMIC_TIME(0), /**
                                  *  
                                  The Coordinated Universal Time (UTC) time standard.
                                  
                                  

                                  * <p>
                                  <p>
                                  UTC is related to TAI according to the relationship
                                  {@code UTC = TAI - deltaT},
                                  where {@code deltaT} is the number of leap seconds which have been introduced as of 
                                  the time in TAI.
                                  </p>
                                  
                                  */
    COORDINATED_UNIVERSAL_TIME(1);
    private final int value;

    TimeStandard(int value) {
        this.value = value;
    }

    /**
    * Get the numeric value associated with this enum constant.
    * @return A numeric value.
    */
    public int getValue() {
        return value;
    }

    /**
    * Get the enum constant that is associated with the given numeric value.
    * @return The enum constant associated with value.
    * @param value a numeric value.
    */
    public static TimeStandard getFromValue(int value) {
        switch (value) {
        case 0:
            return INTERNATIONAL_ATOMIC_TIME;
        case 1:
            return COORDINATED_UNIVERSAL_TIME;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    public static TimeStandard getDefault() {
        return INTERNATIONAL_ATOMIC_TIME;
    }
}