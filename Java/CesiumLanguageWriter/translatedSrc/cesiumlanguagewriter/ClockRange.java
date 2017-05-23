package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 Defines the behavior of a clock when its current time reaches its start or end point.
 

 */
@SuppressWarnings("unused")
public enum ClockRange implements Enumeration {
    /**
    *  
    The clock can continue forever in either direction.
    

    */
    UNBOUNDED(0), /**
                  *  
                  The clock stops when either its start or end time is reached.
                  

                  */
    CLAMPED(1), /**
                *  
                The clock stops when its start time is reached, but loops back to start when its end time is reached.
                

                */
    LOOP_STOP(2);
    private final int value;

    ClockRange(int value) {
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
    public static ClockRange getFromValue(int value) {
        switch (value) {
        case 0:
            return UNBOUNDED;
        case 1:
            return CLAMPED;
        case 2:
            return LOOP_STOP;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    public static ClockRange getDefault() {
        return UNBOUNDED;
    }
}