package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumUnitQuaternionValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value expressed as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    * @param value The value.
    */
    void writeUnitQuaternion(@Nonnull UnitQuaternion value);

    /**
    * Writes the value expressed as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values);

    /**
    * Writes the value expressed as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length);
}