package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Specifies the type of an arc.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public enum CesiumArcType implements Enumeration {
    /**
    * The arc is a straight line that does not conform to the surface of an ellipsoid.
    */
    NONE(0), /**
             * The arc is a geodesic, which is the shortest path conforming to the surface of an ellipsoid.
             */
    GEODESIC(1), /**
                 * The arc is a rhumb line, or loxodrome, which is the path of constant heading conforming to the surface of an ellipsoid.
                 */
    RHUMB(2);
    private final int value;

    CesiumArcType(int value) {
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
    public static CesiumArcType getFromValue(int value) {
        switch (value) {
        case 0:
            return NONE;
        case 1:
            return GEODESIC;
        case 2:
            return RHUMB;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    @Nonnull
    public static CesiumArcType getDefault() {
        return NONE;
    }
}