package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumRgbafValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param color The color.
    */
    void writeRgbaf(@Nonnull Color color);

    /**
    * Writes the value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    void writeRgbaf(float red, float green, float blue, float alpha);

    /**
    * Writes the value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeRgbaf(List<JulianDate> dates, List<Color> values);

    /**
    * Writes the value as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length);
}