// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Reference</code> to a <see cref="CesiumOutputStream" />.  A <code>Reference</code> represents a reference to another property.  References can be used to specify that two properties on different objects are in fact, the same property.
    /// </summary>
    public class ReferenceCesiumWriter : CesiumPropertyWriter<ReferenceCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ReferenceCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ReferenceCesiumWriter(ReferenceCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override ReferenceCesiumWriter Clone()
        {
            return new ReferenceCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies the formatted reference string containing the identifier of the target object followed by a hashtag (#) and one or more property names, each separated by a period (.).  Any hash symbols or periods that exist in the reference identifier or property must be properly escaped with a backslash (\) in order for the reference to be valid.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteReference(Reference value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies the formatted reference string containing the identifier of the target object followed by a hashtag (#) and one or more property names, each separated by a period (.).  Any hash symbols or periods that exist in the reference identifier or property must be properly escaped with a backslash (\) in order for the reference to be valid.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteReference(string value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies the formatted reference string containing the identifier of the target object followed by a hashtag (#) and one or more property names, each separated by a period (.).  Any hash symbols or periods that exist in the reference identifier or property must be properly escaped with a backslash (\) in order for the reference to be valid.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteReference(string identifier, string propertyName)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyName);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies the formatted reference string containing the identifier of the target object followed by a hashtag (#) and one or more property names, each separated by a period (.).  Any hash symbols or periods that exist in the reference identifier or property must be properly escaped with a backslash (\) in order for the reference to be valid.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteReference(string identifier, string[] propertyNames)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyNames);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Reference</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<Reference> AsReference()
        {
            return m_asReference.Value;
        }

        private ICesiumValuePropertyWriter<Reference> CreateReferenceAdaptor()
        {
            return new CesiumWriterAdaptor<ReferenceCesiumWriter, Reference>(
                this, (me, value) => me.WriteReference(value));
        }

    }
}
