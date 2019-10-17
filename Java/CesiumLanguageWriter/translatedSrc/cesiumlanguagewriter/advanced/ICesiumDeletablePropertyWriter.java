package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 * A writer that can write an indication that the client should delete existing samples or interval data for this property.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumDeletablePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes an indication that the client should delete existing samples or interval data for this property.
    Data will be deleted for the containing interval, or if there is no containing interval, then all data.
    If true, all other properties in this property will be ignored.
    * @param value The value.
    */
    void writeDelete(boolean value);
}