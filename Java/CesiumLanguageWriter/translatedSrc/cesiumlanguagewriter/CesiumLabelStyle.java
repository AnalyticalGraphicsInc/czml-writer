package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *  
 Specifies how the text of a label is drawn.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public enum CesiumLabelStyle implements Enumeration {
    /**
    *  
    The text of the label is filled, but not outlined.
    

    */
    FILL(0), /**
             *  
             The text of the label is outlined, but not filled.
             

             */
    OUTLINE(1), /**
                *  
                The text of the label is both filled and outlined.
                

                */
    FILL_AND_OUTLINE(2);
    private final int value;

    CesiumLabelStyle(int value) {
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
    public static CesiumLabelStyle getFromValue(int value) {
        switch (value) {
        case 0:
            return FILL;
        case 1:
            return OUTLINE;
        case 2:
            return FILL_AND_OUTLINE;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    @Nonnull
    public static CesiumLabelStyle getDefault() {
        return FILL;
    }
}