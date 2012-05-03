using System.Drawing;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a color property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class ColorCesiumWriter : CesiumValuePropertyWriter<Color, ColorCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public ColorCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        protected ColorCesiumWriter(ColorCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ColorCesiumWriter Clone()
        {
            return new ColorCesiumWriter(this);
        }

        /// <summary>
        /// Writes the color (including alpha) for this interval of time.
        /// </summary>
        /// <param name="color">The color.</param>
        public override void WriteValue(Color color)
        {
            WriteValue(color.R, color.G, color.B, color.A);
        }

        /// <summary>
        /// Writes the color for this interval of time.  The color is expressed as four integer components, red, green, blue,
        /// and alpha, each of which range from 0 (no color) to 255 (full color or full opaqueness).
        /// </summary>
        /// <param name="red">The red component of the color, in the range 0-255.</param>
        /// <param name="green">The green component of the color, in the range 0-255.</param>
        /// <param name="blue">The blue component of the color, in the range 0-255.</param>
        /// <param name="alpha">The alpha (opaqueness) component of the color, in the range 0-255.</param>
        public void WriteValue(int red, int green, int blue, int alpha)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("rgba");
            Output.WriteStartSequence();
            Output.WriteValue(red);
            Output.WriteValue(green);
            Output.WriteValue(blue);
            Output.WriteValue(alpha);
            Output.WriteEndSequence();
        }

        /// <summary>
        /// Writes the color for this interval of time.  The color is expressed as four floating-point components,
        /// red, green, blue, and alpha, each of which range from 0.0 (no color) to 1.0 (full color or full opaqueness).
        /// </summary>
        /// <param name="red">The red component of the color, in the range 0-1.</param>
        /// <param name="green">The green component of the color, in the range 0-1.</param>
        /// <param name="blue">The blue component of the color, in the range 0-1.</param>
        /// <param name="alpha">The alpha (opaqueness) component of the color, in the range 0-1.</param>
        public void WriteValue(float red, float green, float blue, float alpha)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("rgbaf");
            Output.WriteStartSequence();
            Output.WriteValue(red);
            Output.WriteValue(green);
            Output.WriteValue(blue);
            Output.WriteValue(alpha);
            Output.WriteEndSequence();
        }
    }
}
