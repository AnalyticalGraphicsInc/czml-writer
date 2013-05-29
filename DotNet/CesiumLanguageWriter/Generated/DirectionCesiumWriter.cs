// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Direction</code> to a <see cref="CesiumOutputStream" />.  A <code>Direction</code> defines a direction.  The direction can optionally vary over time.
    /// </summary>
    public class DirectionCesiumWriter : CesiumInterpolatablePropertyWriter<DirectionCesiumWriter>
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
        /// The name of the <code>spherical</code> property.
        /// </summary>
        public const string SphericalPropertyName = "spherical";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>> m_asSpherical;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public DirectionCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>>(CreateSphericalAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected DirectionCesiumWriter(DirectionCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>>(CreateSphericalAdaptor, false);
        }

        /// <inheritdoc />
        public override DirectionCesiumWriter Clone()
        {
            return new DirectionCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>referenceFrame</code> property.  The <code>referenceFrame</code> property specifies the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL". In addition, the value of this property can be a hash (#) symbol followed by the ID of another object in the same scope whose "position" and "orientation" properties define the reference frame in which this position is defined.  This property is ignored when specifying position with any type other than cartesian. If this property is not specified, the default reference frame is "FIXED".
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
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the direction represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
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
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the direction represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the direction represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
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
        /// Writes the <code>spherical</code> property.  The <code>spherical</code> property specifies a direction specified as a spherical [Clock, Cone, Magnitude] angles in radians, magnitude in meters. If the array has three elements, the direction is constant. If it has four or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Magnitude, Time, Clock, Cone, Time, Clock, Cone, Magnitude, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
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
        /// Writes the <code>spherical</code> property.  The <code>spherical</code> property specifies a direction specified as a spherical [Clock, Cone, Magnitude] angles in radians, magnitude in meters. If the array has three elements, the direction is constant. If it has four or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Magnitude, Time, Clock, Cone, Time, Clock, Cone, Magnitude, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values)
        {
            WriteSpherical(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>spherical</code> property.  The <code>spherical</code> property specifies a direction specified as a spherical [Clock, Cone, Magnitude] angles in radians, magnitude in meters. If the array has three elements, the direction is constant. If it has four or more elements, they are time-tagged samples arranged as [Time, Clock, Cone, Magnitude, Time, Clock, Cone, Time, Clock, Cone, Magnitude, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values, int startIndex, int length)
        {
            const string PropertyName = SphericalPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteSpherical(Output, PropertyName, dates, values, startIndex, length);
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
            return new CesiumInterpolatableWriterAdaptor<DirectionCesiumWriter, Cartesian>(
                this, (me, value) => me.WriteCartesian(value), (DirectionCesiumWriter me, IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length) => me.WriteCartesian(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Spherical</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Spherical> AsSpherical()
        {
            return m_asSpherical.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Spherical> CreateSphericalAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<DirectionCesiumWriter, Spherical>(
                this, (me, value) => me.WriteSpherical(value), (DirectionCesiumWriter me, IList<JulianDate> dates, IList<Spherical> values, int startIndex, int length) => me.WriteSpherical(dates, values, startIndex, length));
        }

    }
}
