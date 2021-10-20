package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The format of an image to be embedded in a CZML stream.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public enum CesiumImageFormat implements Enumeration {
    /**
    * The image is in Portable Network Graphics (PNG) format.
    */
    PNG(0),
    /**
    * The image is in Joint Photographic Experts Group (JPEG) format.
    */
    JPEG(1),
    /**
    * The image is in Graphics Interchange Format (GIF) format.
    */
    GIF(2),
    /**
    * The image is in bitmap (BMP) format.
    */
    BMP(3);

    private final int value;

    CesiumImageFormat(int value) {
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
    public static CesiumImageFormat getFromValue(int value) {
        switch (value) {
        case 0:
            return PNG;
        case 1:
            return JPEG;
        case 2:
            return GIF;
        case 3:
            return BMP;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    @Nonnull
    public static CesiumImageFormat getDefault() {
        return PNG;
    }
}