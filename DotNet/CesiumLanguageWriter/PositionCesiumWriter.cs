using System;
using System.Collections.Generic;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Coordinates;
using AGI.Foundation.Time;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a position property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class PositionCesiumWriter : CesiumInterpolatableValuePropertyWriter<Cartesian, PositionCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public PositionCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private PositionCesiumWriter(PositionCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PositionCesiumWriter Clone()
        {
            return new PositionCesiumWriter(this);
        }

        /// <summary>
        /// Writes the identifier of the reference frame in which the position is defined.  If this property is not
        /// specified, the position is assumed to be defined in the Earth Fixed frame.
        /// </summary>
        /// <param name="referenceFrameID"></param>
        public void WriteReferenceFrame(string referenceFrameID)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("referenceFrame");
            Output.WriteValue(referenceFrameID);
        }

        /// <summary>
        /// Writes the value of the property for this interval as a <see cref="Cartesian"/> value specified
        /// in the <see cref="WriteReferenceFrame"/>.  The position is constant for the entire interval.
        /// </summary>
        /// <param name="position">The position.</param>
        public override void WriteValue(Cartesian position)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("Cartesian3");
            Output.WriteStartSequence();
            Output.WriteValue(position.X);
            Output.WriteValue(position.Y);
            Output.WriteValue(position.Z);
            Output.WriteEndSequence();
        }

        /// <summary>
        /// Writes the value of the property for this interval as a WGS84 <see cref="Cartographic"/> value where
        /// <see cref="Cartographic.Longitude"/> and <see cref="Cartographic.Latitude"/> are expressed in radians
        /// and <see cref="Cartographic.Height"/> is meters above the WGS84 ellipsoid.
        /// The position is constant for the entire interval.
        /// </summary>
        /// <param name="position"></param>
        public void WriteCartographicRadiansValue(Cartographic position)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("cartographicRadians");
            Output.WriteStartSequence();
            Output.WriteValue(position.Longitude);
            Output.WriteValue(position.Latitude);
            Output.WriteValue(position.Height);
            Output.WriteEndSequence();
        }

#if StkComponents
        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged positions
        /// expressed in the <see cref="WriteReferenceFrame"/>.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// sample dates need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="positions">The time-tagged positions.</param>
        public void WriteValue(DateMotionCollection<Cartesian3> positions)
        {
            WriteValue(positions.Dates, positions.Values);
        }
#endif

        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged positions
        /// expressed in the <see cref="WriteReferenceFrame"/>.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// <paramref name="dates"/> need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="positions">The corresponding position for each date.</param>
        public void WriteValue(IList<JulianDate> dates, IList<Cartesian> positions)
        {
            WriteValue(dates, positions, 0, dates.Count);
        }

#if StkComponents
        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged positions
        /// expressed in the <see cref="WriteReferenceFrame"/>.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// sample dates need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="positions">The time-tagged positions.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="positions"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="positions"/> collection.</param>
        public void WriteValue(DateMotionCollection<Cartesian3> positions, int startIndex, int length)
        {
            WriteValue(positions.Dates, positions.Values, startIndex, length);
        }
#endif

        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged positions
        /// expressed in the <see cref="WriteReferenceFrame"/>.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// <paramref name="dates"/> need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="positions">The corresponding position for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="positions"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="positions"/> collection.</param>
        public override void WriteValue(IList<JulianDate> dates, IList<Cartesian> positions, int startIndex, int length)
        {
            if (dates.Count != positions.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "positions");

            OpenIntervalIfNecessary();

            JulianDate epoch = GetAndWriteEpoch(dates, startIndex, length);

            Output.WritePropertyName("Cartesian3");
            Output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                Output.WriteValue(epoch.SecondsDifference(dates[i]));
                Cartesian position = positions[i];
                Output.WriteValue(position.X);
                Output.WriteValue(position.Y);
                Output.WriteValue(position.Z);
                Output.WriteLineBreak();
            }

            Output.WriteEndSequence();
        }

#if StkComponents
        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged positions
        /// expressed as WGS84 <see cref="Cartographic"/> values where
        /// <see cref="Cartographic.Longitude"/> and <see cref="Cartographic.Latitude"/> are expressed in radians
        /// and <see cref="Cartographic.Height"/> is meters above the WGS84 ellipsoid.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// sample dates need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="positions">The time-tagged positions.</param>
        public void WriteCartographicRadiansValue(DateMotionCollection<Cartographic> positions)
        {
            WriteCartographicRadiansValue(positions, 0, positions.Count);
        }

        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged positions
        /// expressed as WGS84 <see cref="Cartographic"/> values where
        /// <see cref="Cartographic.Longitude"/> and <see cref="Cartographic.Latitude"/> are expressed in radians
        /// and <see cref="Cartographic.Height"/> is meters above the WGS84 ellipsoid.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// sample dates need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="positions">The time-tagged positions.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="positions"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="positions"/> collection.</param>
        public void WriteCartographicRadiansValue(DateMotionCollection<Cartographic> positions, int startIndex, int length)
        {
            WriteCartographicRadiansValue(positions.Dates, positions.Values, startIndex, length);
        }
#endif

        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged positions
        /// expressed as WGS84 <see cref="Cartographic"/> values where
        /// <see cref="Cartographic.Longitude"/> and <see cref="Cartographic.Latitude"/> are expressed in radians
        /// and <see cref="Cartographic.Height"/> is meters above the WGS84 ellipsoid.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// <paramref name="dates"/> need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="positions">The corresponding position for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="positions"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="positions"/> collection.</param>
        public void WriteCartographicRadiansValue(IList<JulianDate> dates, IList<Cartographic> positions, int startIndex, int length)
        {
            if (dates.Count != positions.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "positions");

            OpenIntervalIfNecessary();

            JulianDate epoch = GetAndWriteEpoch(dates, startIndex, length);

            Output.WritePropertyName("cartographicRadians");
            Output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                Output.WriteValue(epoch.SecondsDifference(dates[i]));
                Cartographic position = positions[i];
                Output.WriteValue(position.Longitude);
                Output.WriteValue(position.Latitude);
                Output.WriteValue(position.Height);
                Output.WriteLineBreak();
            }
            Output.WriteEndSequence();
        }
    }
}
