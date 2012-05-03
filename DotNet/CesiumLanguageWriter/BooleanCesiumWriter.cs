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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a boolean (true/false) property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class BooleanCesiumWriter : CesiumValuePropertyWriter<bool, BooleanCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public BooleanCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private BooleanCesiumWriter(BooleanCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override BooleanCesiumWriter Clone()
        {
            return new BooleanCesiumWriter(this);
        }

        /// <inheritdoc />
        public override void WriteValue(bool value)
        {
            if (IsInterval)
                Output.WritePropertyName("boolean");
            Output.WriteValue(value);
        }
    }
}
