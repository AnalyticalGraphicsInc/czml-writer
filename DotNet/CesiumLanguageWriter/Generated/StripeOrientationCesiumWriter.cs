// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>StripeOrientation</code> to a <see cref="CesiumOutputStream" />.  A <code>StripeOrientation</code> defines the orientation of stripes in the stripe material.
    /// </summary>
    public class StripeOrientationCesiumWriter : CesiumPropertyWriter<StripeOrientationCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>StripeOrientation</code> property.
        /// </summary>
        public const string StripeOrientationPropertyName = "StripeOrientation";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>> m_asStripeOrientation;
        private readonly Lazy<ReferenceCesiumWriter> m_reference = new Lazy<ReferenceCesiumWriter>(() => new ReferenceCesiumWriter(ReferencePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public StripeOrientationCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asStripeOrientation = new Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>>(CreateStripeOrientationAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected StripeOrientationCesiumWriter(StripeOrientationCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asStripeOrientation = new Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>>(CreateStripeOrientationAdaptor, false);
        }

        /// <inheritdoc />
        public override StripeOrientationCesiumWriter Clone()
        {
            return new StripeOrientationCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>StripeOrientation</code> property.  The <code>StripeOrientation</code> property specifies the orientation of stripes in the stripe material. Valid values are "HORIZONTAL" or "VERTICAL".
        /// </summary>
        /// <param name="value">The orientation.</param>
        public void WriteStripeOrientation(CesiumStripeOrientation value)
        {
            const string PropertyName = StripeOrientationPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.StripeOrientationToString(value));
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>StripeOrientation</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumStripeOrientation> AsStripeOrientation()
        {
            return m_asStripeOrientation.Value;
        }

        private ICesiumValuePropertyWriter<CesiumStripeOrientation> CreateStripeOrientationAdaptor()
        {
            return new CesiumWriterAdaptor<StripeOrientationCesiumWriter, CesiumStripeOrientation>(
                this, (me, value) => me.WriteStripeOrientation(value));
        }

    }
}
