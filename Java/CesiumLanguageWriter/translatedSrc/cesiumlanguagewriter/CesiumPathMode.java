package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Whether a path property applies to the whole path or portions of the path.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public enum CesiumPathMode implements Enumeration {
    /**
    * The property applies to the whole path.
    */
    WHOLE(0),
    /**
    * The property applies to portions of the path.
    */
    PORTIONS(1);

    private final int value;

    CesiumPathMode(int value) {
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
    public static CesiumPathMode getFromValue(int value) {
        switch (value) {
        case 0:
            return WHOLE;
        case 1:
            return PORTIONS;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    @Nonnull
    public static CesiumPathMode getDefault() {
        return WHOLE;
    }
}