package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 * A writer that can write a value as a list of unit spherical values.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumUnitSphericalListValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as a list of unit spherical values.
    * @param values The values.
    */
    void writeUnitSpherical(Iterable<UnitSpherical> values);
}