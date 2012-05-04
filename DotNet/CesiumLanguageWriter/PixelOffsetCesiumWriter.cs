#if StkComponents
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Coordinates;
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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a pixel offset property that
    /// optionally has different values over different intervals of time.  A pixel offset is the number of pixels up
    /// and to the right to place an element, relative to an origin.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class PixelOffsetCesiumWriter : CesiumValuePropertyWriter<Rectangular, PixelOffsetCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The property name.</param>
        public PixelOffsetCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        protected PixelOffsetCesiumWriter(PixelOffsetCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PixelOffsetCesiumWriter Clone()
        {
            return new PixelOffsetCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value of the property for this interval as a <see cref="Rectangular"/> value, where
        /// <see cref="Rectangular.X"/> is to the right and <see cref="Rectangular.Y"/> is up.  The offset is
        /// constant for the entire interval.
        /// </summary>
        /// <param name="position">The position.</param>
        public override void WriteValue(Rectangular position)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("cartesian");
            Output.WriteStartSequence();
            Output.WriteValue(position.X);
            Output.WriteValue(position.Y);
            Output.WriteEndSequence();
        }
    }
}
