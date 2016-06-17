// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>BoundingRectangle</code> to a <see cref="CesiumOutputStream" />.  A <code>BoundingRectangle</code> is a bounding rectangle specified by a corner, width and height.
    /// </summary>
    public class BoundingRectangleCesiumWriter : CesiumInterpolatablePropertyWriter<BoundingRectangleCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>boundingRectangle</code> property.
        /// </summary>
        public const string BoundingRectanglePropertyName = "boundingRectangle";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>> m_asBoundingRectangle;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public BoundingRectangleCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asBoundingRectangle = new Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(CreateBoundingRectangleAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected BoundingRectangleCesiumWriter(BoundingRectangleCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asBoundingRectangle = new Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(CreateBoundingRectangleAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override BoundingRectangleCesiumWriter Clone()
        {
            return new BoundingRectangleCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>boundingRectangle</code>, which is the bounding rectangle specified as `[X, Y, Width, Height]`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBoundingRectangle(BoundingRectangle value)
        {
            const string PropertyName = BoundingRectanglePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteBoundingRectangle(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>boundingRectangle</code>, which is the bounding rectangle specified as `[X, Y, Width, Height]`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteBoundingRectangle(IList<JulianDate> dates, IList<BoundingRectangle> values)
        {
            WriteBoundingRectangle(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <code>boundingRectangle</code>, which is the bounding rectangle specified as `[X, Y, Width, Height]`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteBoundingRectangle(IList<JulianDate> dates, IList<BoundingRectangle> values, int startIndex, int length)
        {
            const string PropertyName = BoundingRectanglePropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteBoundingRectangle(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <code>reference</code>, which is the bounding rectangle specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the bounding rectangle specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the bounding rectangle specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the bounding rectangle specified as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteReference(string identifier, string[] propertyNames)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyNames);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>BoundingRectangle</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> AsBoundingRectangle()
        {
            return m_asBoundingRectangle.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> CreateBoundingRectangleAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<BoundingRectangleCesiumWriter, BoundingRectangle>(this, (me, value) => me.WriteBoundingRectangle(value), (me, dates, values, startIndex, length) => me.WriteBoundingRectangle(dates, values, startIndex, length));
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
            return new CesiumWriterAdaptor<BoundingRectangleCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
