package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Whether a classification affects terrain, 3D Tiles, or both.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public enum CesiumClassificationType implements Enumeration {
    /**
    * Only terrain will be classified.
    */
    TERRAIN(0), /**
                * Only 3D Tiles will be classified.
                */
    CESIUM3DTILE(1), /**
                     * Both terrain and 3D Tiles will be classified.
                     */
    BOTH(2);
    private final int value;

    CesiumClassificationType(int value) {
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
    public static CesiumClassificationType getFromValue(int value) {
        switch (value) {
        case 0:
            return TERRAIN;
        case 1:
            return CESIUM3DTILE;
        case 2:
            return BOTH;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    @Nonnull
    public static CesiumClassificationType getDefault() {
        return TERRAIN;
    }
}