// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ExternalDocumentScope</code> to a <see cref="CesiumOutputStream" />.  A <code>ExternalDocumentScope</code> defines the scope of the document.  It controls whether the document is shared or private. A shared scope merges all objects with the same id into the parent document. A private scope creates a separate document.
    /// </summary>
    public class ExternalDocumentScopeCesiumWriter : CesiumPropertyWriter<ExternalDocumentScopeCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>scope</code> property.
        /// </summary>
        public const string ScopePropertyName = "scope";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumExternalDocumentScope>> m_asScope;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ExternalDocumentScopeCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asScope = new Lazy<ICesiumValuePropertyWriter<CesiumExternalDocumentScope>>(CreateScopeAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ExternalDocumentScopeCesiumWriter(ExternalDocumentScopeCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asScope = new Lazy<ICesiumValuePropertyWriter<CesiumExternalDocumentScope>>(CreateScopeAdaptor, false);
        }

        /// <inheritdoc />
        public override ExternalDocumentScopeCesiumWriter Clone()
        {
            return new ExternalDocumentScopeCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>scope</code> property.  The <code>scope</code> property specifies the document's scope.  Valid values are "SHARED" and "PRIVATE".
        /// </summary>
        /// <param name="value">The scope of the document.</param>
        public void WriteScope(CesiumExternalDocumentScope value)
        {
            const string PropertyName = ScopePropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.ExternalDocumentScopeToString(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Scope</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumExternalDocumentScope> AsScope()
        {
            return m_asScope.Value;
        }

        private ICesiumValuePropertyWriter<CesiumExternalDocumentScope> CreateScopeAdaptor()
        {
            return new CesiumWriterAdaptor<ExternalDocumentScopeCesiumWriter, CesiumExternalDocumentScope>(
                this, (me, value) => me.WriteScope(value));
        }

    }
}
