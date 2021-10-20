package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a three-dimensional Cartesian value and its derivative.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumCartesian3VelocityValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value as a three-dimensional Cartesian value and its derivative.
    * @param value The value.
    */
    void writeCartesianVelocity(@Nonnull Motion1<Cartesian> value);

    /**
    * Writes the value as a three-dimensional Cartesian value and its derivative.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values);

    /**
    * Writes the value as a three-dimensional Cartesian value and its derivative.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values, int startIndex, int length);
}