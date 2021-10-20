package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a horizontal origin.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumHorizontalOriginValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value expressed as a horizontal origin.
    * @param value The horizontal origin.
    */
    void writeHorizontalOrigin(@Nonnull CesiumHorizontalOrigin value);
}