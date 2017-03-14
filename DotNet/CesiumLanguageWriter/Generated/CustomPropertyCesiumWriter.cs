// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>CustomProperty</c> to a <see cref="CesiumOutputStream" />.  A <c>CustomProperty</c> is a custom property.
    /// </summary>
    public class CustomPropertyCesiumWriter : CesiumInterpolatablePropertyWriter<CustomPropertyCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>boolean</c> property.
        /// </summary>
        public const string BooleanPropertyName = "boolean";

        /// <summary>
        /// The name of the <c>boundingRectangle</c> property.
        /// </summary>
        public const string BoundingRectanglePropertyName = "boundingRectangle";

        /// <summary>
        /// The name of the <c>cartesian</c> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <c>cartesian2</c> property.
        /// </summary>
        public const string Cartesian2PropertyName = "cartesian2";

        /// <summary>
        /// The name of the <c>unitCartesian</c> property.
        /// </summary>
        public const string UnitCartesianPropertyName = "unitCartesian";

        /// <summary>
        /// The name of the <c>spherical</c> property.
        /// </summary>
        public const string SphericalPropertyName = "spherical";

        /// <summary>
        /// The name of the <c>unitSpherical</c> property.
        /// </summary>
        public const string UnitSphericalPropertyName = "unitSpherical";

        /// <summary>
        /// The name of the <c>reference</c> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumValuePropertyWriter<bool>> m_asBoolean;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>> m_asBoundingRectangle;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>> m_asCartesian2;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>> m_asUnitCartesian;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>> m_asSpherical;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>> m_asUnitSpherical;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public CustomPropertyCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asBoolean = new Lazy<ICesiumValuePropertyWriter<bool>>(CreateBooleanAdaptor, false);
            m_asBoundingRectangle = new Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(CreateBoundingRectangleAdaptor, false);
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asCartesian2 = new Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>>(CreateCartesian2Adaptor, false);
            m_asUnitCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(CreateUnitCartesianAdaptor, false);
            m_asSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>>(CreateSphericalAdaptor, false);
            m_asUnitSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(CreateUnitSphericalAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CustomPropertyCesiumWriter(CustomPropertyCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asBoolean = new Lazy<ICesiumValuePropertyWriter<bool>>(CreateBooleanAdaptor, false);
            m_asBoundingRectangle = new Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(CreateBoundingRectangleAdaptor, false);
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asCartesian2 = new Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>>(CreateCartesian2Adaptor, false);
            m_asUnitCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(CreateUnitCartesianAdaptor, false);
            m_asSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>>(CreateSphericalAdaptor, false);
            m_asUnitSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(CreateUnitSphericalAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override CustomPropertyCesiumWriter Clone()
        {
            return new CustomPropertyCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>boolean</c>, which is the property specified as a boolean value.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBoolean(bool value)
        {
            const string PropertyName = BooleanPropertyName;
            if (ForceInterval)
            {
                OpenIntervalIfNecessary();
            }
            if (IsInterval)
            {
                Output.WritePropertyName(PropertyName);
            }
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>boundingRectangle</c>, which is the property specified as <c>[X, Y, Width, Height]</c>.
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
        /// Writes the value expressed as a <c>boundingRectangle</c>, which is the property specified as <c>[X, Y, Width, Height]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteBoundingRectangle(IList<JulianDate> dates, IList<BoundingRectangle> values)
        {
            WriteBoundingRectangle(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>boundingRectangle</c>, which is the property specified as <c>[X, Y, Width, Height]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteBoundingRectangle(IList<JulianDate> dates, IList<BoundingRectangle> values, int startIndex, int length)
        {
            const string PropertyName = BoundingRectanglePropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteBoundingRectangle(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the property specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>.
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
        /// Writes the value expressed as a <c>cartesian</c>, which is the property specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the property specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian2</c>, which is the property specified as a two-dimensional Cartesian value <c>[X, Y]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCartesian2(Rectangular value)
        {
            const string PropertyName = Cartesian2PropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian2(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian2</c>, which is the property specified as a two-dimensional Cartesian value <c>[X, Y]</c>.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WriteCartesian2(double x, double y)
        {
            WriteCartesian2(new Rectangular(x, y));
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian2</c>, which is the property specified as a two-dimensional Cartesian value <c>[X, Y]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian2(IList<JulianDate> dates, IList<Rectangular> values)
        {
            WriteCartesian2(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian2</c>, which is the property specified as a two-dimensional Cartesian value <c>[X, Y]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCartesian2(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            const string PropertyName = Cartesian2PropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian2(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the property specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUnitCartesian(UnitCartesian value)
        {
            const string PropertyName = UnitCartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the property specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values)
        {
            WriteUnitCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the property specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values, int startIndex, int length)
        {
            const string PropertyName = UnitCartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the property specified as a spherical value <c>[Clock, Cone, Magnitude]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteSpherical(Spherical value)
        {
            const string PropertyName = SphericalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteSpherical(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the property specified as a spherical value <c>[Clock, Cone, Magnitude]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values)
        {
            WriteSpherical(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the property specified as a spherical value <c>[Clock, Cone, Magnitude]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values, int startIndex, int length)
        {
            const string PropertyName = SphericalPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteSpherical(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the property specified as a unit spherical value <c>[Clock, Cone]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUnitSpherical(UnitSpherical value)
        {
            const string PropertyName = UnitSphericalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitSpherical(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the property specified as a unit spherical value <c>[Clock, Cone]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values)
        {
            WriteUnitSpherical(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the property specified as a unit spherical value <c>[Clock, Cone]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values, int startIndex, int length)
        {
            const string PropertyName = UnitSphericalPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitSpherical(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the property specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the property specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the property specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the property specified as a reference to another property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Boolean</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<bool> AsBoolean()
        {
            return m_asBoolean.Value;
        }

        private ICesiumValuePropertyWriter<bool> CreateBooleanAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, bool>(this, (me, value) => me.WriteBoolean(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>BoundingRectangle</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> AsBoundingRectangle()
        {
            return m_asBoundingRectangle.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> CreateBoundingRectangleAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, BoundingRectangle>(this, (me, value) => me.WriteBoundingRectangle(value), (me, dates, values, startIndex, length) => me.WriteBoundingRectangle(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Cartesian</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartesian> AsCartesian()
        {
            return m_asCartesian.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartesian> CreateCartesianAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Cartesian>(this, (me, value) => me.WriteCartesian(value), (me, dates, values, startIndex, length) => me.WriteCartesian(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Cartesian2</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Rectangular> AsCartesian2()
        {
            return m_asCartesian2.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Rectangular> CreateCartesian2Adaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Rectangular>(this, (me, value) => me.WriteCartesian2(value), (me, dates, values, startIndex, length) => me.WriteCartesian2(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>UnitCartesian</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<UnitCartesian> AsUnitCartesian()
        {
            return m_asUnitCartesian.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<UnitCartesian> CreateUnitCartesianAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, UnitCartesian>(this, (me, value) => me.WriteUnitCartesian(value), (me, dates, values, startIndex, length) => me.WriteUnitCartesian(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Spherical</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Spherical> AsSpherical()
        {
            return m_asSpherical.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Spherical> CreateSphericalAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Spherical>(this, (me, value) => me.WriteSpherical(value), (me, dates, values, startIndex, length) => me.WriteSpherical(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>UnitSpherical</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<UnitSpherical> AsUnitSpherical()
        {
            return m_asUnitSpherical.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<UnitSpherical> CreateUnitSphericalAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, UnitSpherical>(this, (me, value) => me.WriteUnitSpherical(value), (me, dates, values, startIndex, length) => me.WriteUnitSpherical(dates, values, startIndex, length));
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
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
