package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The mode to use when blending between a target color and an entity's source color.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public enum CesiumColorBlendMode implements Enumeration {
    /**
    * Multiplies the source color by the target color.
    */
    HIGHLIGHT(0),
    /**
    * Replaces the source color with the target color.
    */
    REPLACE(1),
    /**
    * Blends the source color and target color together.
    */
    MIX(2);

    private final int value;

    CesiumColorBlendMode(int value) {
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
    public static CesiumColorBlendMode getFromValue(int value) {
        switch (value) {
        case 0:
            return HIGHLIGHT;
        case 1:
            return REPLACE;
        case 2:
            return MIX;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    @Nonnull
    public static CesiumColorBlendMode getDefault() {
        return HIGHLIGHT;
    }
}