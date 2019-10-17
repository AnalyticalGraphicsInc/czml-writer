package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;

/**
 * A writer that can write a value as an integer.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumIntegerValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value expressed as an integer.
    * @param value The value.
    */
    void writeNumber(int value);

    /**
    * Writes the value expressed as an integer.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeNumber(List<JulianDate> dates, List<Integer> values);

    /**
    * Writes the value expressed as an integer.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeNumber(List<JulianDate> dates, List<Integer> values, int startIndex, int length);
}