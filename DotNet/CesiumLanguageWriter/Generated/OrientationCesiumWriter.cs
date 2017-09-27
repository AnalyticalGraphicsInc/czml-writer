// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>Orientation</c> to a <see cref="CesiumOutputStream" />.  A <c>Orientation</c> is defines an orientation.  An orientation is a rotation that takes a vector expressed in the "body" axes of the object and transforms it to the Earth fixed axes.
    /// </summary>
    public class OrientationCesiumWriter : CesiumInterpolatablePropertyWriter<OrientationCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>unitQuaternion</c> property.
        /// </summary>
        public const string UnitQuaternionPropertyName = "unitQuaternion";

        /// <summary>
        /// The name of the <c>reference</c> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        /// <summary>
        /// The name of the <c>velocityReference</c> property.
        /// </summary>
        public const string VelocityReferencePropertyName = "velocityReference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>> m_asUnitQuaternion;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asVelocityReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public OrientationCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asUnitQuaternion = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(CreateUnitQuaternionAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
            m_asVelocityReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateVelocityReferenceAdaptor, false);
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
            m_asVelocityReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateVelocityReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override OrientationCesiumWriter Clone()
        {
            return new OrientationCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitQuaternion</c>, which is the orientation specified as a 4-dimensional unit magnitude quaternion, specified as <c>[X, Y, Z, W]</c>.
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
        /// Writes the value expressed as a <c>unitQuaternion</c>, which is the orientation specified as a 4-dimensional unit magnitude quaternion, specified as <c>[X, Y, Z, W]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitQuaternion(IList<JulianDate> dates, IList<UnitQuaternion> values)
        {
            WriteUnitQuaternion(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitQuaternion</c>, which is the orientation specified as a 4-dimensional unit magnitude quaternion, specified as <c>[X, Y, Z, W]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteUnitQuaternion(IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length)
        {
            const string PropertyName = UnitQuaternionPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitQuaternion(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the orientation specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the orientation specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the orientation specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the orientation specified as a reference to another property.
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
        /// Writes the value expressed as a <c>velocityReference</c>, which is the orientation specified as the normalized velocity vector of a position property. The reference must be to a <c>position</c> property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteVelocityReference(Reference value)
        {
            const string PropertyName = VelocityReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>velocityReference</c>, which is the orientation specified as the normalized velocity vector of a position property. The reference must be to a <c>position</c> property.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteVelocityReference(string value)
        {
            const string PropertyName = VelocityReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>velocityReference</c>, which is the orientation specified as the normalized velocity vector of a position property. The reference must be to a <c>position</c> property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteVelocityReference(string identifier, string propertyName)
        {
            const string PropertyName = VelocityReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyName);
        }

        /// <summary>
        /// Writes the value expressed as a <c>velocityReference</c>, which is the orientation specified as the normalized velocity vector of a position property. The reference must be to a <c>position</c> property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteVelocityReference(string identifier, string[] propertyNames)
        {
            const string PropertyName = VelocityReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyNames);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>UnitQuaternion</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> AsUnitQuaternion()
        {
            return m_asUnitQuaternion.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> CreateUnitQuaternionAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<OrientationCesiumWriter, UnitQuaternion>(this, (me, value) => me.WriteUnitQuaternion(value), (me, dates, values, startIndex, length) => me.WriteUnitQuaternion(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Reference</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<Reference> AsReference()
        {
            return m_asReference.Value;
        }

        private ICesiumValuePropertyWriter<Reference> CreateReferenceAdaptor()
        {
            return new CesiumWriterAdaptor<OrientationCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>VelocityReference</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<Reference> AsVelocityReference()
        {
            return m_asVelocityReference.Value;
        }

        private ICesiumValuePropertyWriter<Reference> CreateVelocityReferenceAdaptor()
        {
            return new CesiumWriterAdaptor<OrientationCesiumWriter, Reference>(this, (me, value) => me.WriteVelocityReference(value));
        }

    }
}
