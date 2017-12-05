package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *  
 The vertical origin of an item relative to its position.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public enum CesiumVerticalOrigin implements Enumeration {
    /**
    *  
    The bottom of the item is located at the position.
    

    */
    BOTTOM(0), /**
               *  
               The item is at the vertical center between {@link #BASELINE} and {@link #TOP}.
               

               */
    CENTER(1), /**
               *  
               The top of the item is located at the position.
               

               */
    TOP(2), /**
            *  
            If the object contains text, the origin is at the baseline of the text, otherwise the origin is at the bottom of the object.
            

            */
    BASELINE(3);
    private final int value;

    CesiumVerticalOrigin(int value) {
        this.value = value;
    }

    /**
    * Get the numeric value associated with this enum constant.
    * @return A numeric value.
    */
    @Override
    public int getValue() {
        return value;
    }

    /**
    * Get the enum constant that is associated with the given numeric value.
    * @return The enum constant associated with value.
    * @param value a numeric value.
    */
    @Nonnull
    public static CesiumVerticalOrigin getFromValue(int value) {
        switch (value) {
        case 0:
            return BOTTOM;
        case 1:
            return CENTER;
        case 2:
            return TOP;
        case 3:
            return BASELINE;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    @Nonnull
    public static CesiumVerticalOrigin getDefault() {
        return BOTTOM;
    }
}