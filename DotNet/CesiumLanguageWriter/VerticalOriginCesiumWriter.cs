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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a <see cref="CesiumVerticalOrigin"/> property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class VerticalOriginCesiumWriter : CesiumValuePropertyWriter<CesiumVerticalOrigin, VerticalOriginCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public VerticalOriginCesiumWriter(string propertyName)
            : base(propertyName) 
        {
        }

        /// <inheritdoc />
        private VerticalOriginCesiumWriter(VerticalOriginCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override VerticalOriginCesiumWriter Clone()
        {
            return new VerticalOriginCesiumWriter(this);
        }

        /// <inheritdoc />
        public override void WriteValue(CesiumVerticalOrigin verticalOrigin)
        {
            if (IsInterval)
                Output.WritePropertyName("verticalOrigin");
            Output.WriteValue(CesiumFormattingHelper.VerticalOriginToString(verticalOrigin));
        }
    }
}
