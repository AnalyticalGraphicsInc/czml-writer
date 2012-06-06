// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Font</code> to a <see cref="CesiumOutputStream" />.  A <code>Font</code> tODO
    /// </summary>
    public class FontCesiumWriter : CesiumPropertyWriter<FontCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>font</code> property.
        /// </summary>
        public const string FontPropertyName = "font";

        private readonly Lazy<ICesiumValuePropertyWriter<string>> m_asFont;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public FontCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asFont = new Lazy<ICesiumValuePropertyWriter<string>>(CreateFontAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected FontCesiumWriter(FontCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asFont = new Lazy<ICesiumValuePropertyWriter<string>>(CreateFontAdaptor, false);
        }

        /// <inheritdoc />
        public override FontCesiumWriter Clone()
        {
            return new FontCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>font</code> property.  The <code>font</code> property specifies the font.
        /// </summary>
        /// <param name="font">The font.</param>
        public void WriteFont(string font)
        {
            const string PropertyName = FontPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(font);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Font</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<string> AsFont()
        {
            return m_asFont.Value;
        }

        private ICesiumValuePropertyWriter<string> CreateFontAdaptor()
        {
            return new CesiumWriterAdaptor<FontCesiumWriter, string>(
                this, (me, value) => me.WriteFont(value));
        }

    }
}
