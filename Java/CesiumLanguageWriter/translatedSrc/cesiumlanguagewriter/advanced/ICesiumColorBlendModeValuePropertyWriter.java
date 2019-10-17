package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a color blend mode.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumColorBlendModeValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value expressed as a color blend mode.
    * @param value The blend mode.
    */
    void writeColorBlendMode(@Nonnull CesiumColorBlendMode value);
}