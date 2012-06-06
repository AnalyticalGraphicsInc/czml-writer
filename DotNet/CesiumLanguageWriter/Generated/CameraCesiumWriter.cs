// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Camera</code> to a <see cref="CesiumOutputStream" />.  A <code>Camera</code> a camera.
    /// </summary>
    public class CameraCesiumWriter : CesiumPropertyWriter<CameraCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>enable</code> property.
        /// </summary>
        public const string EnablePropertyName = "enable";

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
        /// Gets the writer for the <code>enable</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>enable</code> property defines whether or not the camera is enabled.
        /// </summary>
        public BooleanCesiumWriter EnableWriter
        {
            get { return m_enable.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>enable</code> property.  The <code>enable</code> property defines whether or not the camera is enabled.
        /// </summary>
        public BooleanCesiumWriter OpenEnableProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EnableWriter);
        }

        /// <summary>
        /// Writes a value for the <code>enable</code> property as a <code>boolean</code> value.  The <code>enable</code> property specifies whether or not the camera is enabled.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteEnableProperty(bool value)
        {
            using (var writer = OpenEnableProperty())
            {
                writer.WriteBoolean(value);
            }
        }

    }
}
