package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumRgbaValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param color The color.
    */
    void writeRgba(@Nonnull Color color);

    /**
    * Writes the value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    void writeRgba(int red, int green, int blue, int alpha);

    /**
    * Writes the value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeRgba(List<JulianDate> dates, List<Color> values);

    /**
    * Writes the value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeRgba(List<JulianDate> dates, List<Color> colors, int startIndex, int length);
}