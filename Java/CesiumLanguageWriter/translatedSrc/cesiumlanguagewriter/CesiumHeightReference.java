package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The height reference of an object, which indicates if the object's position is relative to terrain or not.
 

 */
public enum CesiumHeightReference implements Enumeration {
    /**
    *  
    The position is absolute.
    

    */
    NONE(0), /**
             *  
             The position is clamped to the terrain.
             

             */
    CLAMP_TO_GROUND(1), /**
                        *  
                        The position height is the height above the terrain.
                        

                        */
    RELATIVE_TO_GROUND(2);
    private final int value;

    CesiumHeightReference(int value) {
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
    public static CesiumHeightReference getFromValue(int value) {
        switch (value) {
        case 0:
            return NONE;
        case 1:
            return CLAMP_TO_GROUND;
        case 2:
            return RELATIVE_TO_GROUND;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    public static CesiumHeightReference getDefault() {
        return NONE;
    }
}