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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a font property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class FontCesiumWriter : CesiumValuePropertyWriter<string, FontCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public FontCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        protected FontCesiumWriter(FontCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override FontCesiumWriter Clone()
        {
            return new FontCesiumWriter(this);
        }

        /// <inheritdoc />
        public override void WriteValue(string value)
        {
            if (IsInterval)
                Output.WritePropertyName("font");
            Output.WriteValue(value);
        }
    }
}
