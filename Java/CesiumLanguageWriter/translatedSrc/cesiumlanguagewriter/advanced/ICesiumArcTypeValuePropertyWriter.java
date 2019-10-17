package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a type of an arc.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumArcTypeValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value expressed as an arc type.
    * @param value The type of an arc.
    */
    void writeArcType(@Nonnull CesiumArcType value);
}