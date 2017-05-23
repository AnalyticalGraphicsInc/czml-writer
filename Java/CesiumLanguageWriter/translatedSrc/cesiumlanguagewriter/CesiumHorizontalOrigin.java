package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;

/**
 *  
 The horizontal origin of an item relative to its position.
 

 */
@SuppressWarnings("unused")
public enum CesiumHorizontalOrigin implements Enumeration {
    /**
    *  
    The left side of the item is located at the position.
    

    */
    LEFT(0), /**
             *  
             The item is horizontally centered on the position.
             

             */
    CENTER(1), /**
               *  
               The right side of the item is located at the position.
               

               */
    RIGHT(2);
    private final int value;

    CesiumHorizontalOrigin(int value) {
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
    public static CesiumHorizontalOrigin getFromValue(int value) {
        switch (value) {
        case 0:
            return LEFT;
        case 1:
            return CENTER;
        case 2:
            return RIGHT;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    public static CesiumHorizontalOrigin getDefault() {
        return LEFT;
    }
}