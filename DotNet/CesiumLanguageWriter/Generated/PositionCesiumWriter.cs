// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Position</code> to a <see cref="CesiumOutputStream" />.  A <code>Position</code> defines a position.  The position can optionally vary over time.
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

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicRadians;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicDegrees;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PositionCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asCartographicRadians = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicRadiansAdaptor, false);
            m_asCartographicDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicDegreesAdaptor, false);
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
        }

        /// <inheritdoc />
        public override PositionCesiumWriter Clone()
        {
            return new PositionCesiumWriter(this);
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
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the position represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
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
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the position represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the position represented as a Cartesian `[X, Y, Z]` in the meters relative to the `referenceFrame`. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
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
        /// Writes the <code>cartographicRadians</code> property.  The <code>cartographicRadians</code> property specifies the position represented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in radians and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
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
        /// Writes the <code>cartographicRadians</code> property.  The <code>cartographicRadians</code> property specifies the position represented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in radians and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values)
        {
            WriteCartographicRadians(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>cartographicRadians</code> property.  The <code>cartographicRadians</code> property specifies the position represented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in radians and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
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
        /// Writes the <code>cartographicDegrees</code> property.  The <code>cartographicDegrees</code> property specifies the position reprsented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in degrees and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
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
        /// Writes the <code>cartographicDegrees</code> property.  The <code>cartographicDegrees</code> property specifies the position reprsented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in degrees and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values)
        {
            WriteCartographicDegrees(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>cartographicDegrees</code> property.  The <code>cartographicDegrees</code> property specifies the position reprsented as a WGS 84 Cartographic `[Longitude, Latitude, Height]` where longitude and latitude are in degrees and height is in meters. If the array has three elements, the position is constant. If it has four or more elements, they are time-tagged samples arranged as `[Time, Longitude, Latitude, Height, Time, Longitude, Latitude, Height, ...]`, where Time is an ISO 8601 date and time string or seconds since `epoch`.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Cartesian</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartesian> AsCartesian()
        {
            return m_asCartesian.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartesian> CreateCartesianAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<PositionCesiumWriter, Cartesian>(
                this, (me, value) => me.WriteCartesian(value), (PositionCesiumWriter me, IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length) => me.WriteCartesian(dates, values, startIndex, length));
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
            return new CesiumInterpolatableWriterAdaptor<PositionCesiumWriter, Cartographic>(
                this, (me, value) => me.WriteCartographicRadians(value), (PositionCesiumWriter me, IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length) => me.WriteCartographicRadians(dates, values, startIndex, length));
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
            return new CesiumInterpolatableWriterAdaptor<PositionCesiumWriter, Cartographic>(
                this, (me, value) => me.WriteCartographicDegrees(value), (PositionCesiumWriter me, IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length) => me.WriteCartographicDegrees(dates, values, startIndex, length));
        }

    }
}
