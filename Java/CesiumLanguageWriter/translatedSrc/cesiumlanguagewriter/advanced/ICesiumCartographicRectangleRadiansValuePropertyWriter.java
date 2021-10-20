package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;

/**
 * A writer that can write a value as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumCartographicRectangleRadiansValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value expressed as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param value The value.
    */
    void writeWsen(CartographicExtent value);

    /**
    * Writes the value expressed as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    void writeWsen(double west, double south, double east, double north);

    /**
    * Writes the value expressed as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeWsen(List<JulianDate> dates, List<CartographicExtent> values);

    /**
    * Writes the value expressed as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeWsen(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length);
}