package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 * A writer that can write a value as a list of three-dimensional Cartesian values.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumCartesian3ListValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as a list of three-dimensional Cartesian values.
    * @param values The values.
    */
    void writeCartesian(Iterable<Cartesian> values);
}