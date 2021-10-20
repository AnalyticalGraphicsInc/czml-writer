package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;

/**
 * A writer that can write a value as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumCartographicRectangleDegreesValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value expressed as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param value The value.
    */
    void writeWsenDegrees(CartographicExtent value);

    /**
    * Writes the value expressed as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    void writeWsenDegrees(double west, double south, double east, double north);

    /**
    * Writes the value expressed as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values);

    /**
    * Writes the value expressed as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length);
}