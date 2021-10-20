package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 * A writer that can write a value as a list of three-dimensional unit magnitude Cartesian values.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumUnitCartesian3ListValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as a list of three-dimensional unit magnitude Cartesian values.
    * @param values The values.
    */
    void writeUnitCartesian(Iterable<UnitCartesian> values);
}