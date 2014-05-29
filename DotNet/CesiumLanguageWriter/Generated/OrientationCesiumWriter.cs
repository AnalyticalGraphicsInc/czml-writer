// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Orientation</code> to a <see cref="CesiumOutputStream" />.  A <code>Orientation</code> defines an orientation.  An orientation is a rotation that takes a vector expressed in the "body" axes of the object and transforms it to the set of axes identified by the `axes` property.
    /// </summary>
    public class OrientationCesiumWriter : CesiumInterpolatablePropertyWriter<OrientationCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>axes</code> property.
        /// </summary>
        public const string AxesPropertyName = "axes";

        /// <summary>
        /// The name of the <code>unitQuaternion</code> property.
        /// </summary>
        public const string UnitQuaternionPropertyName = "unitQuaternion";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>> m_asUnitQuaternion;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public OrientationCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asUnitQuaternion = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(CreateUnitQuaternionAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected OrientationCesiumWriter(OrientationCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asUnitQuaternion = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(CreateUnitQuaternionAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override OrientationCesiumWriter Clone()
        {
            return new OrientationCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>axes</code> property.  The <code>axes</code> property specifies tODO
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteAxes(string value)
        {
            const string PropertyName = AxesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUnitQuaternion(UnitQuaternion value)
        {
            const string PropertyName = UnitQuaternionPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitQuaternion(Output, value);
        }

        /// <summary>
        /// Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
        /// </summary>
        /// <param name="dates">The dates at which the rotation is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitQuaternion(IList<JulianDate> dates, IList<UnitQuaternion> values)
        {
            WriteUnitQuaternion(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
        /// </summary>
        /// <param name="dates">The dates at which the rotation is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteUnitQuaternion(IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length)
        {
            const string PropertyName = UnitQuaternionPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitQuaternion(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
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
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
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
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
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
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>UnitQuaternion</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> AsUnitQuaternion()
        {
            return m_asUnitQuaternion.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> CreateUnitQuaternionAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<OrientationCesiumWriter, UnitQuaternion>(
                this, (me, value) => me.WriteUnitQuaternion(value), (OrientationCesiumWriter me, IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length) => me.WriteUnitQuaternion(dates, values, startIndex, length));
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
            return new CesiumWriterAdaptor<OrientationCesiumWriter, Reference>(
                this, (me, value) => me.WriteReference(value));
        }

    }
}
