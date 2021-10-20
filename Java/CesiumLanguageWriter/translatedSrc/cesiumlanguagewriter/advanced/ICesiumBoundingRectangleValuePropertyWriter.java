package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as a bounding rectangle.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumBoundingRectangleValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value expressed as a bounding rectangle.
    * @param value The value.
    */
    void writeBoundingRectangle(@Nonnull BoundingRectangle value);

    /**
    * Writes the value expressed as a bounding rectangle.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values);

    /**
    * Writes the value expressed as a bounding rectangle.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length);
}