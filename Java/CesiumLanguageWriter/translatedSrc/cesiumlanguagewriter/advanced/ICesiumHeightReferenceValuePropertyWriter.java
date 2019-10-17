package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a height reference.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumHeightReferenceValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as a height reference.
    * @param value The height reference.
    */
    void writeHeightReference(@Nonnull CesiumHeightReference value);
}