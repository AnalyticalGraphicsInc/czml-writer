#if StkComponents
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Coordinates;
using Cartesian3 = AGI.Foundation.Coordinates.Cartesian;
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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write an eye offset property that
    /// optionally has different values over different intervals of time.  An eye offset specifies the offset
    /// from an origin at which to place an element.  The offset is specified in eye coordinates, which is a
    /// left-handed coordinate system where <code>x</code> points toward the viewer's right, <code>y</code> points
    /// up, and <code>z</code> points into the screen.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class EyeOffsetCesiumWriter : CesiumValuePropertyWriter<Cartesian, EyeOffsetCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public EyeOffsetCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        protected EyeOffsetCesiumWriter(EyeOffsetCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override EyeOffsetCesiumWriter Clone()
        {
            return new EyeOffsetCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value of the property for this interval as a <see cref="Cartesian"/> value.
        /// The position is constant for the entire interval.
        /// </summary>
        /// <param name="position">The position.</param>
        public override void WriteValue(Cartesian position)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("cartesian");
            Output.WriteStartSequence();
            Output.WriteValue(position.X);
            Output.WriteValue(position.Y);
            Output.WriteValue(position.Z);
            Output.WriteEndSequence();
        }
    }
}
