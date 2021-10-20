package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a classification type.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumClassificationTypeValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value expressed as a classification type.
    * @param value The classification type.
    */
    void writeClassificationType(@Nonnull CesiumClassificationType value);
}