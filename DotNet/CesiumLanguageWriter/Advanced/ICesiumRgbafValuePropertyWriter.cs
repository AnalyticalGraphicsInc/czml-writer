using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
    /// </summary>
    public interface ICesiumRgbafValuePropertyWriter : ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Writes the value as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
        /// </summary>
        /// <param name="color">The color.</param>
        void WriteRgbaf(Color color);

        /// <summary>
        /// Writes the value as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        void WriteRgbaf(float red, float green, float blue, float alpha);

        /// <summary>
        /// Writes the value as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        void WriteRgbaf(IList<JulianDate> dates, IList<Color> values);

        /// <summary>
        /// Writes the value as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        void WriteRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length);
    }
}