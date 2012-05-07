using System;
using System.Collections.Generic;
#if StkComponents
using AGI.Foundation.Time;
using AGI.Foundation.Coordinates;
using AGI.Foundation.Cesium.Advanced;
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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write an orientation property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class OrientationAxesCesiumWriter : CesiumInterpolatableValuePropertyWriter<UnitQuaternion, OrientationAxesCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public OrientationAxesCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private OrientationAxesCesiumWriter(OrientationAxesCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override OrientationAxesCesiumWriter Clone()
        {
            return new OrientationAxesCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged orientations
        /// expressed in the <see cref="WriteAxes"/>.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// <paramref name="dates"/> need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="orientations">The corresponding orientation for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="orientations"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="orientations"/> collection.</param>
        public override void WriteValue(IList<JulianDate> dates, IList<UnitQuaternion> orientations, int startIndex, int length)
        {
            if (dates.Count != orientations.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            OpenIntervalIfNecessary();

            JulianDate epoch = GetAndWriteEpoch(dates, startIndex, length);

            Output.WritePropertyName(UnitQuaternionPropertyName);
            Output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                Output.WriteValue(epoch.SecondsDifference(dates[i]));
                UnitQuaternion quaternion = orientations[i];
                Output.WriteValue(quaternion.W);
                Output.WriteValue(quaternion.X);
                Output.WriteValue(quaternion.Y);
                Output.WriteValue(quaternion.Z);
                Output.WriteLineBreak();
            }

            Output.WriteEndSequence();
        }

        /// <summary>
        /// Writes the identifier of the axes in which the orientation is defined.  If this property is not
        /// specified, the orientation is assumed to be defined in Earth's EastNorthUp Axes.
        /// </summary>
        /// <param name="axesId"></param>
        public void WriteAxes(string axesId)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("axes");
            Output.WriteValue(axesId);
        }

        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged orientations
        /// expressed in the <see cref="WriteAxes"/>.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// <paramref name="dates"/> need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="orientations">The corresponding orientation for each date.</param>
        public void WriteValue(IList<JulianDate> dates, IList<UnitQuaternion> orientations)
        {
            WriteValue(dates, orientations, 0, dates.Count);
        }

#if StkComponents
        /// <summary>
        /// Writes the value of the property for this interval as a collection of time-tagged orientations
        /// expressed in the <see cref="WriteAxes"/>.
        /// Clients will interpolate over the samples to determine the property value at a given time.  The
        /// sample dates need not all fall within the <see cref="CesiumPropertyWriter{T}.WriteInterval(TimeInterval)"/>,
        /// because having samples outside the interval is often useful for interpolation.  However, the samples
        /// within an interval will never be used to determine the value within another interval.
        /// </summary>
        /// <param name="orientations">The time-tagged orientations.</param>
        public void WriteValue(DateMotionCollection<UnitQuaternion> orientations)
        {
            WriteValue(orientations.Dates, orientations.Values);
        }
#endif

        /// <summary>
        /// Writes the value of the property for this interval as a <see cref="UnitQuaternionPropertyName"/> value specified
        /// in the <see cref="WriteAxes"/>.  The orientation is constant for the entire interval.
        /// </summary>
        /// <param name="orientation">The orientation.</param>
        public override void WriteValue(UnitQuaternion orientation)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName(UnitQuaternionPropertyName);
            Output.WriteStartSequence();
            Output.WriteValue(orientation.W);
            Output.WriteValue(orientation.X);
            Output.WriteValue(orientation.Y);
            Output.WriteValue(orientation.Z);
            Output.WriteEndSequence();
        }

        private const string UnitQuaternionPropertyName = "unitQuaternion";
    }
}
