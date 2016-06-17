// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ViewFrom</code> to a <see cref="CesiumOutputStream" />.  A <code>ViewFrom</code> is a suggested camera location when viewing an object, specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    /// </summary>
    public class ViewFromCesiumWriter : CesiumInterpolatablePropertyWriter<ViewFromCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>cartesian</code> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ViewFromCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected ViewFromCesiumWriter(ViewFromCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override ViewFromCesiumWriter Clone()
        {
            return new ViewFromCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartesian</code>, which is the camera location specified as a three-dimensional Cartesian value `[X, Y, Z]`, in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCartesian(Cartesian value)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartesian</code>, which is the camera location specified as a three-dimensional Cartesian value `[X, Y, Z]`, in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartesian</code>, which is the camera location specified as a three-dimensional Cartesian value `[X, Y, Z]`, in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <code>reference</code>, which is the camera location specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the camera location specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the camera location specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the camera location specified as a reference to another property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Cartesian</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartesian> AsCartesian()
        {
            return m_asCartesian.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartesian> CreateCartesianAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<ViewFromCesiumWriter, Cartesian>(this, (me, value) => me.WriteCartesian(value), (me, dates, values, startIndex, length) => me.WriteCartesian(dates, values, startIndex, length));
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
            return new CesiumWriterAdaptor<ViewFromCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
