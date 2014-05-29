// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>String</code> to a <see cref="CesiumOutputStream" />.  A <code>String</code> a string value.  The string can optionally vary with time.
    /// </summary>
    public class StringCesiumWriter : CesiumPropertyWriter<StringCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>string</code> property.
        /// </summary>
        public const string StringPropertyName = "string";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumValuePropertyWriter<string>> m_asString;
        private readonly Lazy<ReferenceCesiumWriter> m_reference = new Lazy<ReferenceCesiumWriter>(() => new ReferenceCesiumWriter(ReferencePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public StringCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asString = new Lazy<ICesiumValuePropertyWriter<string>>(CreateStringAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected StringCesiumWriter(StringCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asString = new Lazy<ICesiumValuePropertyWriter<string>>(CreateStringAdaptor, false);
        }

        /// <inheritdoc />
        public override StringCesiumWriter Clone()
        {
            return new StringCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>string</code> property.  The <code>string</code> property specifies the string value.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteString(string value)
        {
            const string PropertyName = StringPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Gets the writer for the <code>reference</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>reference</code> property defines a reference property.
        /// </summary>
        public ReferenceCesiumWriter ReferenceWriter
        {
            get { return m_reference.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>reference</code> property.  The <code>reference</code> property defines a reference property.
        /// </summary>
        public ReferenceCesiumWriter OpenReferenceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ReferenceWriter);
        }

        /// <summary>
        /// Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteReferenceProperty(Reference value)
        {
            using (var writer = OpenReferenceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteReferenceProperty(string value)
        {
            using (var writer = OpenReferenceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteReferenceProperty(string identifier, string propertyName)
        {
            using (var writer = OpenReferenceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteReferenceProperty(string identifier, string[] propertyNames)
        {
            using (var writer = OpenReferenceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>String</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<string> AsString()
        {
            return m_asString.Value;
        }

        private ICesiumValuePropertyWriter<string> CreateStringAdaptor()
        {
            return new CesiumWriterAdaptor<StringCesiumWriter, string>(
                this, (me, value) => me.WriteString(value));
        }

    }
}
