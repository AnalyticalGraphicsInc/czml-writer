// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ExternalDocumentSourceType</code> to a <see cref="CesiumOutputStream" />.  A <code>ExternalDocumentSourceType</code> defines the type of data to retrieve.
    /// </summary>
    public class ExternalDocumentSourceTypeCesiumWriter : CesiumPropertyWriter<ExternalDocumentSourceTypeCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>sourceType</code> property.
        /// </summary>
        public const string SourceTypePropertyName = "sourceType";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType>> m_asSourceType;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ExternalDocumentSourceTypeCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asSourceType = new Lazy<ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType>>(CreateSourceTypeAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ExternalDocumentSourceTypeCesiumWriter(ExternalDocumentSourceTypeCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asSourceType = new Lazy<ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType>>(CreateSourceTypeAdaptor, false);
        }

        /// <inheritdoc />
        public override ExternalDocumentSourceTypeCesiumWriter Clone()
        {
            return new ExternalDocumentSourceTypeCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>sourceType</code> property.  The <code>sourceType</code> property specifies defines the type of data to retrieve. Valid values are "json" and "eventstream".
        /// </summary>
        /// <param name="value">The data transport type to use.</param>
        public void WriteSourceType(CesiumExternalDocumentSourceType value)
        {
            const string PropertyName = SourceTypePropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.ExternalDocumentSourceTypeToString(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>SourceType</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType> AsSourceType()
        {
            return m_asSourceType.Value;
        }

        private ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType> CreateSourceTypeAdaptor()
        {
            return new CesiumWriterAdaptor<ExternalDocumentSourceTypeCesiumWriter, CesiumExternalDocumentSourceType>(
                this, (me, value) => me.WriteSourceType(value));
        }

    }
}
