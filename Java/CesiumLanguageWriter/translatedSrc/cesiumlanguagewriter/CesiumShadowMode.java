package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 Whether or not an object casts or receives shadows from each light source when shadows are enabled.
 

 */
public enum CesiumShadowMode implements Enumeration {
    /**
    *  
    The object does not cast or receive shadows.
    

    */
    DISABLED(0), /**
                 *  
                 The object casts and receives shadows.
                 

                 */
    ENABLED(1), /**
                *  
                The object casts shadows only.
                

                */
    CAST_ONLY(2), /**
                  *  
                  The object receives shadows only.
                  

                  */
    RECEIVE_ONLY(3);
    private final int value;

    CesiumShadowMode(int value) {
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
    public static CesiumShadowMode getFromValue(int value) {
        switch (value) {
        case 0:
            return DISABLED;
        case 1:
            return ENABLED;
        case 2:
            return CAST_ONLY;
        case 3:
            return RECEIVE_ONLY;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    public static CesiumShadowMode getDefault() {
        return DISABLED;
    }
}