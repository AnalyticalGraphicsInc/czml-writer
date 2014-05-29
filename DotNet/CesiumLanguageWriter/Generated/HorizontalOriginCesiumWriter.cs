// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>HorizontalOrigin</code> to a <see cref="CesiumOutputStream" />.  A <code>HorizontalOrigin</code> defines the horizontal origin of an element, which can optionally vary over time.  It controls whether the element is left-, center-, or right-aligned with the `position`.
    /// </summary>
    public class HorizontalOriginCesiumWriter : CesiumPropertyWriter<HorizontalOriginCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>horizontalOrigin</code> property.
        /// </summary>
        public const string HorizontalOriginPropertyName = "horizontalOrigin";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>> m_asHorizontalOrigin;
        private readonly Lazy<ReferenceCesiumWriter> m_reference = new Lazy<ReferenceCesiumWriter>(() => new ReferenceCesiumWriter(ReferencePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public HorizontalOriginCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asHorizontalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(CreateHorizontalOriginAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected HorizontalOriginCesiumWriter(HorizontalOriginCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asHorizontalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(CreateHorizontalOriginAdaptor, false);
        }

        /// <inheritdoc />
        public override HorizontalOriginCesiumWriter Clone()
        {
            return new HorizontalOriginCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property specifies the horizontal origin.  Valid values are "LEFT", "CENTER", and "RIGHT".
        /// </summary>
        /// <param name="value">The horizontal origin.</param>
        public void WriteHorizontalOrigin(CesiumHorizontalOrigin value)
        {
            const string PropertyName = HorizontalOriginPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.HorizontalOriginToString(value));
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>HorizontalOrigin</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumHorizontalOrigin> AsHorizontalOrigin()
        {
            return m_asHorizontalOrigin.Value;
        }

        private ICesiumValuePropertyWriter<CesiumHorizontalOrigin> CreateHorizontalOriginAdaptor()
        {
            return new CesiumWriterAdaptor<HorizontalOriginCesiumWriter, CesiumHorizontalOrigin>(
                this, (me, value) => me.WriteHorizontalOrigin(value));
        }

    }
}
