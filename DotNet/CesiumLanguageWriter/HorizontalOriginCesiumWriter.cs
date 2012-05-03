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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a <see cref="CesiumHorizontalOrigin"/> property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class HorizontalOriginCesiumWriter : CesiumValuePropertyWriter<CesiumHorizontalOrigin, HorizontalOriginCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public HorizontalOriginCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private HorizontalOriginCesiumWriter(HorizontalOriginCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override HorizontalOriginCesiumWriter Clone()
        {
            return new HorizontalOriginCesiumWriter(this);
        }

        /// <inheritdoc />
        public override void WriteValue(CesiumHorizontalOrigin horizontalOrigin)
        {
            if (IsInterval)
                Output.WritePropertyName("horizontalOrigin");
            Output.WriteValue(CesiumFormattingHelper.HorizontalOriginToString(horizontalOrigin));
        }
    }
}
