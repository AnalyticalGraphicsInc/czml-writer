using System;
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
    /// A <see cref="CesiumPropertyWriter{TDerived}"/> for writing camera-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream. The camera is positioned in the scene
    /// by the <see cref="CesiumPacketWriter.OpenPositionProperty">Position</see> property.  Instances of this class should not be created
    /// directly, but should instead be obtained from a <see cref="CesiumPacketWriter"/>.
    /// </summary>
    public class CameraCesiumWriter : CesiumPropertyWriter<CameraCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>enable</code> property.
        /// </summary>
        public static readonly string EnablePropertyName = "enable";

        private readonly Lazy<BooleanCesiumWriter> m_enable = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(EnablePropertyName), false);
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public CameraCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CameraCesiumWriter(CameraCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override CameraCesiumWriter Clone()
        {
            return new CameraCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>enable</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenEnableProperty"/> method for more information.
        /// </summary>
        public BooleanCesiumWriter EnableWriter
        {
            get { return m_enable.Value; }
        }

        /// <summary>
        /// Opens a property describing whether the camera is enabled. 
        /// </summary>
        /// <returns>The writer that is used to write color information.</returns>
        public BooleanCesiumWriter OpenEnableProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EnableWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>enable</code> property.
        /// See the documentation for the <see cref="OpenEnableProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteEnableProperty(bool value)
        {
            using (var writer = OpenEnableProperty())
            {
                writer.WriteValue(value);
            }
        }
    }
}
