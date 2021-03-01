package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 * A writer that can write a value as a list of two-dimensional Cartesian values.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumCartesian2ListValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as a list of two-dimensional Cartesian values.
    * @param values The values.
    */
    void writeCartesian2(Iterable<Rectangular> values);
}