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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a label style property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class LabelStyleCesiumWriter : CesiumValuePropertyWriter<CesiumLabelStyle, LabelStyleCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public LabelStyleCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private LabelStyleCesiumWriter(LabelStyleCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override LabelStyleCesiumWriter Clone()
        {
            return new LabelStyleCesiumWriter(this);
        }

        /// <inheritdoc />
        public override void WriteValue(CesiumLabelStyle value)
        {
            if (IsInterval)
                Output.WritePropertyName("labelStyle");
            Output.WriteValue(CesiumFormattingHelper.LabelStyleToString(value));
        }
    }
}
