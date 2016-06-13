// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Position</code> to a <see cref="CesiumOutputStream" />.  A <code>Position</code> is defines a position.  The position can optionally vary over time.
    /// </summary>
    public class PositionCesiumWriter : CesiumInterpolatablePropertyWriter<PositionCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>referenceFrame</code> property.
        /// </summary>
        public const string ReferenceFramePropertyName = "referenceFrame";

        /// <summary>
        /// The name of the <code>cartesian</code> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <code>cartographicRadians</code> property.
        /// </summary>
        public const string CartographicRadiansPropertyName = "cartographicRadians";

        /// <summary>
        /// The name of the <code>cartographicDegrees</code> property.
        /// </summary>
        public const string CartographicDegreesPropertyName = "cartographicDegrees";

        /// <summary>
        /// The name of the <code>cartesianVelocity</code> property.
        /// </summary>
        public const string CartesianVelocityPropertyName = "cartesianVelocity";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicRadians;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicDegrees;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Motion<Cartesian>>> m_asCartesianVelocity;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PositionCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asCartographicRadians = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicRadiansAdaptor, false);
            m_asCartographicDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicDegreesAdaptor, false);
            m_asCartesianVelocity = new Lazy<ICesiumInterpolatableValuePropertyWriter<Motion<Cartesian>>>(CreateCartesianVelocityAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PositionCesiumWriter(PositionCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asCartographicRadians = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicRadiansAdaptor, false);
            m_asCartographicDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicDegreesAdaptor, false);
            m_asCartesianVelocity = new Lazy<ICesiumInterpolatableValuePropertyWriter<Motion<Cartesian>>>(CreateCartesianVelocityAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override PositionCesiumWriter Clone()
        {
            return new PositionCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>referenceFrame</code>, which is the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL". If this property is not specified, the default reference frame is "FIXED".
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteReferenceFrame(string value)
        {
            const string PropertyName = ReferenceFramePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartesian</code>, which is the position specified as a three-dimensional Cartesian value, `[X, Y, Z]`, in meters relative to the `referenceFrame`.
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
        /// Writes the value expressed as a <code>cartesian</code>, which is the position specified as a three-dimensional Cartesian value, `[X, Y, Z]`, in meters relative to the `referenceFrame`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartesian</code>, which is the position specified as a three-dimensional Cartesian value, `[X, Y, Z]`, in meters relative to the `referenceFrame`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
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
        /// Writes the value expressed as a <code>cartographicRadians</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in radians and Height is in meters.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteCartographicRadians(Cartographic value)
        {
            const string PropertyName = CartographicRadiansPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographic(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartographicRadians</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in radians and Height is in meters.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values)
        {
            WriteCartographicRadians(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartographicRadians</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in radians and Height is in meters.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
        {
            const string PropertyName = CartographicRadiansPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartographic(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartographicDegrees</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in degrees and Height is in meters.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteCartographicDegrees(Cartographic value)
        {
            const string PropertyName = CartographicDegreesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographic(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartographicDegrees</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in degrees and Height is in meters.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values)
        {
            WriteCartographicDegrees(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartographicDegrees</code>, which is the position specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height]`, where Longitude and Latitude are in degrees and Height is in meters.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
        {
            const string PropertyName = CartographicDegreesPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartographic(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartesianVelocity</code>, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, `[X, Y, Z, dX, dY, dZ]`, in meters relative to the `referenceFrame`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCartesianVelocity(Motion<Cartesian> value)
        {
            const string PropertyName = CartesianVelocityPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3Velocity(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartesianVelocity</code>, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, `[X, Y, Z, dX, dY, dZ]`, in meters relative to the `referenceFrame`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesianVelocity(IList<JulianDate> dates, IList<Motion<Cartesian>> values)
        {
            WriteCartesianVelocity(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <code>cartesianVelocity</code>, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, `[X, Y, Z, dX, dY, dZ]`, in meters relative to the `referenceFrame`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteCartesianVelocity(IList<JulianDate> dates, IList<Motion<Cartesian>> values, int startIndex, int length)
        {
            const string PropertyName = CartesianVelocityPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3Velocity(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <code>reference</code>, which is the position specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the position specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the position specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the position specified as a reference to another property.
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
            return new CesiumInterpolatableWriterAdaptor<PositionCesiumWriter, Cartesian>(this, (me, value) => me.WriteCartesian(value), (me, dates, values, startIndex, length) => me.WriteCartesian(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>CartographicRadians</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartographic> AsCartographicRadians()
        {
            return m_asCartographicRadians.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartographic> CreateCartographicRadiansAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<PositionCesiumWriter, Cartographic>(this, (me, value) => me.WriteCartographicRadians(value), (me, dates, values, startIndex, length) => me.WriteCartographicRadians(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>CartographicDegrees</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartographic> AsCartographicDegrees()
        {
            return m_asCartographicDegrees.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartographic> CreateCartographicDegreesAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<PositionCesiumWriter, Cartographic>(this, (me, value) => me.WriteCartographicDegrees(value), (me, dates, values, startIndex, length) => me.WriteCartographicDegrees(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>CartesianVelocity</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Motion<Cartesian>> AsCartesianVelocity()
        {
            return m_asCartesianVelocity.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Motion<Cartesian>> CreateCartesianVelocityAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<PositionCesiumWriter, Motion<Cartesian>>(this, (me, value) => me.WriteCartesianVelocity(value), (me, dates, values, startIndex, length) => me.WriteCartesianVelocity(dates, values, startIndex, length));
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
            return new CesiumWriterAdaptor<PositionCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
