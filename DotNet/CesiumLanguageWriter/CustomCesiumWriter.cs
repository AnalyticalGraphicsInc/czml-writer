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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write custom properties.  To write custom
    /// properties, create writers of the appropriate type (for example, <see cref="DoubleCesiumWriter"/>)
    /// and with the desired property name.  Then, after opening this <see cref="CustomCesiumWriter"/>,
    /// <see cref="CesiumElementWriter.Open"/> the sub-property writers and use them to write values.
    /// </summary>
    public class CustomCesiumWriter : CesiumPropertyWriter<CustomCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public CustomCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CustomCesiumWriter(CustomCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override CustomCesiumWriter Clone()
        {
            return new CustomCesiumWriter(this);
        }
    }
}
