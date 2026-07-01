package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a path mode.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumPathModeValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as a path mode.
    * @param value The path mode.
    */
    void writePathMode(@Nonnull CesiumPathMode value);
}