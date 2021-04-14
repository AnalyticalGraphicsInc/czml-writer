using System;
using System.Collections.Generic;
using System.Drawing;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Contains helper methods for writing CZML values.
    /// </summary>
    public static class CesiumWritingHelper
    {
        /// <summary>
        /// The maximum interval of time that can be specified.
        /// </summary>
        [NotNull]
        public static readonly TimeInterval MaximumInterval = new TimeInterval(GregorianDate.MinValue.ToJulianDate(), GregorianDate.MaxValue.ToJulianDate());

        private static Iso8601Format GetIso8601Format([NotNull] CesiumOutputStream output)
        {
            return output.PrettyFormatting ? Iso8601Format.Extended : Iso8601Format.Compact;
        }

        /// <summary>
        /// Writes a <see cref="JulianDate"/> as an ISO 8601 interval string.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="date">The date to write.</param>
        public static void WriteDate([NotNull] CesiumOutputStream output, JulianDate date)
        {
            output.WriteValue(CesiumFormattingHelper.ToIso8601(date, GetIso8601Format(output)));
        }

        /// <summary>
        /// Writes a <see cref="TimeInterval"/> as an ISO 8601 interval string.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="interval">The interval to write.</param>
        public static void WriteTimeInterval([NotNull] CesiumOutputStream output, [NotNull] TimeInterval interval)
        {
            output.WriteValue(CesiumFormattingHelper.ToIso8601Interval(interval.Start, interval.Stop, GetIso8601Format(output)));
        }

        /// <summary>
        /// Writes a list of <see cref="TimeInterval">TimeIntervals</see>.  If the collection has a single
        /// interval, the interval is written as an ISO 8601 interval string.  If it has multiple intervals,
        /// it is written as an array of ISO 8601 interval strings.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="intervals">The intervals to write.</param>
        public static void WriteTimeIntervalCollection([NotNull] CesiumOutputStream output, [NotNull] IList<TimeInterval> intervals)
        {
            if (intervals.Count == 1)
            {
                TimeInterval interval = intervals[0];
                WriteTimeInterval(output, interval);
            }
            else
            {
                output.WriteStartSequence();
                foreach (TimeInterval interval in intervals)
                {
                    WriteTimeInterval(output, interval);
                    output.WriteLineBreak();
                }

                output.WriteEndSequence();
            }
        }

        /// <summary>
        /// Writes a <see cref="Rectangular"/> value as an array in X, Y order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteCartesian2([NotNull] CesiumOutputStream output, Rectangular value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.X);
            output.WriteValue(value.Y);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="Rectangular"/> values as an array in [Time, X, Y] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteCartesian2([NotNull] CesiumOutputStream output,
                                           [NotNull] string propertyName,
                                           [NotNull] IList<JulianDate> dates,
                                           [NotNull] IList<Rectangular> values,
                                           int startIndex,
                                           int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                Rectangular value = values[i];
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="CartographicExtent"/> value as an array in WestLongitude, SouthLatitude, EastLongitude, NorthLatitude order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteCartographicExtent([NotNull] CesiumOutputStream output, [NotNull] CartographicExtent value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.WestLongitude);
            output.WriteValue(value.SouthLatitude);
            output.WriteValue(value.EastLongitude);
            output.WriteValue(value.NorthLatitude);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="CartographicExtent"/> values as an array in [Time, WestLongitude, SouthLatitude, EastLongitude, NorthLatitude] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteCartographicExtent([NotNull] CesiumOutputStream output,
                                                   [NotNull] string propertyName,
                                                   [NotNull] IList<JulianDate> dates,
                                                   [NotNull] IList<CartographicExtent> values,
                                                   int startIndex,
                                                   int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                CartographicExtent value = values[i];
                output.WriteValue(value.WestLongitude);
                output.WriteValue(value.SouthLatitude);
                output.WriteValue(value.EastLongitude);
                output.WriteValue(value.NorthLatitude);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="Cartesian"/> value as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteCartesian3([NotNull] CesiumOutputStream output, Cartesian value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.X);
            output.WriteValue(value.Y);
            output.WriteValue(value.Z);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="Cartesian"/> values as an array in [Time, X, Y, Z] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteCartesian3([NotNull] CesiumOutputStream output,
                                           [NotNull] string propertyName,
                                           [NotNull] IList<JulianDate> dates,
                                           [NotNull] IList<Cartesian> values,
                                           int startIndex,
                                           int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                Cartesian value = values[i];
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteValue(value.Z);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="Motion{Cartesian}"/> value as an array in X, Y, Z, vX, vY, vZ order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteCartesian3Velocity([NotNull] CesiumOutputStream output, Motion<Cartesian> value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.Value.X);
            output.WriteValue(value.Value.Y);
            output.WriteValue(value.Value.Z);
            output.WriteValue(value.FirstDerivative.X);
            output.WriteValue(value.FirstDerivative.Y);
            output.WriteValue(value.FirstDerivative.Z);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="Motion{Cartesian}"/> values as an array in [Time, X, Y, Z, vX, vY, vZ] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteCartesian3Velocity([NotNull] CesiumOutputStream output,
                                                   [NotNull] string propertyName,
                                                   [NotNull] IList<JulianDate> dates,
                                                   [NotNull] IList<Motion<Cartesian>> values,
                                                   int startIndex,
                                                   int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                Cartesian value = values[i].Value;
                Cartesian velocity = values[i].FirstDerivative;
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteValue(value.Z);
                output.WriteValue(velocity.X);
                output.WriteValue(velocity.Y);
                output.WriteValue(velocity.Z);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="UnitCartesian"/> value as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteUnitCartesian3([NotNull] CesiumOutputStream output, UnitCartesian value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.X);
            output.WriteValue(value.Y);
            output.WriteValue(value.Z);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="UnitCartesian"/> values as an array in [Time, X, Y, Z] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteUnitCartesian3([NotNull] CesiumOutputStream output,
                                               [NotNull] string propertyName,
                                               [NotNull] IList<JulianDate> dates,
                                               [NotNull] IList<UnitCartesian> values,
                                               int startIndex,
                                               int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                UnitCartesian value = values[i];
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteValue(value.Z);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="Spherical"/> value as an array in Clock, Cone, Magnitude order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteSpherical([NotNull] CesiumOutputStream output, Spherical value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.Clock);
            output.WriteValue(value.Cone);
            output.WriteValue(value.Magnitude);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="Spherical"/> values as an array in [Time, Clock, Cone, Magnitude] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteSpherical([NotNull] CesiumOutputStream output,
                                          [NotNull] string propertyName,
                                          [NotNull] IList<JulianDate> dates,
                                          [NotNull] IList<Spherical> values,
                                          int startIndex,
                                          int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                Spherical value = values[i];
                output.WriteValue(value.Clock);
                output.WriteValue(value.Cone);
                output.WriteValue(value.Magnitude);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="BoundingRectangle"/> value as an array in X, Y, Width, Height order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteBoundingRectangle([NotNull] CesiumOutputStream output, BoundingRectangle value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.Left);
            output.WriteValue(value.Bottom);
            output.WriteValue(value.Width);
            output.WriteValue(value.Height);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="BoundingRectangle"/> values as an array in [Time, X, Y, Width, Height] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteBoundingRectangle([NotNull] CesiumOutputStream output,
                                                  [NotNull] string propertyName,
                                                  [NotNull] IList<JulianDate> dates,
                                                  [NotNull] IList<BoundingRectangle> values,
                                                  int startIndex,
                                                  int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                BoundingRectangle value = values[i];
                output.WriteValue(value.Left);
                output.WriteValue(value.Bottom);
                output.WriteValue(value.Width);
                output.WriteValue(value.Height);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="NearFarScalar"/> value as an array in NearDistance, NearValue, FarDistance, FarValue order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteNearFarScalar([NotNull] CesiumOutputStream output, NearFarScalar value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.NearDistance);
            output.WriteValue(value.NearValue);
            output.WriteValue(value.FarDistance);
            output.WriteValue(value.FarValue);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="NearFarScalar"/> values as an array in [Time, NearDistance, NearValue, FarDistance, FarValue] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteNearFarScalar([NotNull] CesiumOutputStream output,
                                              [NotNull] string propertyName,
                                              [NotNull] IList<JulianDate> dates,
                                              [NotNull] IList<NearFarScalar> values,
                                              int startIndex,
                                              int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                NearFarScalar value = values[i];
                output.WriteValue(value.NearDistance);
                output.WriteValue(value.NearValue);
                output.WriteValue(value.FarDistance);
                output.WriteValue(value.FarValue);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="Bounds"/> value as an array in LowerBound, UpperBound order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteBounds([NotNull] CesiumOutputStream output, Bounds value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.LowerBound);
            output.WriteValue(value.UpperBound);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="Bounds"/> values as an array in [Time, LowerBound, UpperBound] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteBounds([NotNull] CesiumOutputStream output,
                                       [NotNull] string propertyName,
                                       [NotNull] IList<JulianDate> dates,
                                       [NotNull] IList<Bounds> values,
                                       int startIndex,
                                       int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                Bounds value = values[i];
                output.WriteValue(value.LowerBound);
                output.WriteValue(value.UpperBound);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="UnitSpherical"/> value as an array in Clock, Cone order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteUnitSpherical([NotNull] CesiumOutputStream output, UnitSpherical value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.Clock);
            output.WriteValue(value.Cone);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="UnitSpherical"/> values as an array in [Time, Clock, Cone] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteUnitSpherical([NotNull] CesiumOutputStream output,
                                              [NotNull] string propertyName,
                                              [NotNull] IList<JulianDate> dates,
                                              [NotNull] IList<UnitSpherical> values,
                                              int startIndex,
                                              int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                UnitSpherical value = values[i];
                output.WriteValue(value.Clock);
                output.WriteValue(value.Cone);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="double"/> values as an array.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteDoubleList([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<double> values)
        {
            output.WriteStartSequence();
            foreach (double value in values)
            {
                output.WriteValue(value);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="Rectangular"/> values as an array in X, Y order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteCartesian2List([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<Rectangular> values)
        {
            output.WriteStartSequence();
            foreach (Rectangular value in values)
            {
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="Cartesian"/> values as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteCartesian3List([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<Cartesian> values)
        {
            output.WriteStartSequence();
            foreach (Cartesian value in values)
            {
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteValue(value.Z);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="Cartesian"/> values as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        [CSToJavaUseWildcardGenerics]
        public static void WriteCartesian3ListOfLists([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<IEnumerable<Cartesian>> values)
        {
            output.WriteStartSequence();
            foreach (IEnumerable<Cartesian> list in values)
            {
                output.WriteStartSequence();
                output.WriteLineBreak();
                foreach (Cartesian value in list)
                {
                    output.WriteValue(value.X);
                    output.WriteValue(value.Y);
                    output.WriteValue(value.Z);
                    output.WriteLineBreak();
                }

                output.WriteEndSequence();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="Cartographic"/> value as an array in Longitude, Latitude, Height order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteCartographic([NotNull] CesiumOutputStream output, Cartographic value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.Longitude);
            output.WriteValue(value.Latitude);
            output.WriteValue(value.Height);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged <see cref="Cartographic"/> values as an array in [Time, Longitude, Latitude, Height] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteCartographic([NotNull] CesiumOutputStream output,
                                             [NotNull] string propertyName,
                                             [NotNull] IList<JulianDate> dates,
                                             [NotNull] IList<Cartographic> values,
                                             int startIndex,
                                             int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                Cartographic value = values[i];
                output.WriteValue(value.Longitude);
                output.WriteValue(value.Latitude);
                output.WriteValue(value.Height);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="Cartographic"/> values as an array in Longitude, Latitude, Height order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteCartographicList([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<Cartographic> values)
        {
            output.WriteStartSequence();
            foreach (Cartographic value in values)
            {
                output.WriteValue(value.Longitude);
                output.WriteValue(value.Latitude);
                output.WriteValue(value.Height);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="Cartographic"/> values as an array in Longitude, Latitude, Height order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        [CSToJavaUseWildcardGenerics]
        public static void WriteCartographicListOfLists([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<IEnumerable<Cartographic>> values)
        {
            output.WriteStartSequence();
            foreach (IEnumerable<Cartographic> list in values)
            {
                output.WriteStartSequence();
                output.WriteLineBreak();
                foreach (Cartographic value in list)
                {
                    output.WriteValue(value.Longitude);
                    output.WriteValue(value.Latitude);
                    output.WriteValue(value.Height);
                    output.WriteLineBreak();
                }

                output.WriteEndSequence();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a color value as an array in Red, Green, Blue, Alpha order.
        /// </summary>
        /// <param name="output">The stream to which to write the color.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteRgba([NotNull] CesiumOutputStream output, Color value)
        {
            WriteRgba(output, value.R, value.G, value.B, value.A);
        }

        /// <summary>
        /// Writes a color value as an array in Red, Green, Blue, Alpha order.
        /// </summary>
        /// <param name="output">The stream to which to write the color.</param>
        /// <param name="red">The red component in the range 0-255.</param>
        /// <param name="green">The green component in the range 0-255.</param>
        /// <param name="blue">The blue component in the range 0-255.</param>
        /// <param name="alpha">The alpha component in the range 0-255.</param>
        public static void WriteRgba([NotNull] CesiumOutputStream output, int red, int green, int blue, int alpha)
        {
            output.WriteStartSequence();
            output.WriteValue(red);
            output.WriteValue(green);
            output.WriteValue(blue);
            output.WriteValue(alpha);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged color values as an array in [Time, Red, Green, Blue, Alpha] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteRgba([NotNull] CesiumOutputStream output,
                                     [NotNull] string propertyName,
                                     [NotNull] IList<JulianDate> dates,
                                     [NotNull] IList<Color> values,
                                     int startIndex,
                                     int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                Color value = values[i];
                output.WriteValue(value.R);
                output.WriteValue(value.G);
                output.WriteValue(value.B);
                output.WriteValue(value.A);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a color value as an array in Red, Green, Blue, Alpha order as floating-point values.
        /// </summary>
        /// <param name="output">The stream to which to write the color.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteRgbaf([NotNull] CesiumOutputStream output, Color value)
        {
            WriteRgbaf(output, value.R / 255.0, value.G / 255.0, value.B / 255.0, value.A / 255.0);
        }

        /// <summary>
        /// Writes a color value as an array in Red, Green, Blue, Alpha order as floating-point values.
        /// </summary>
        /// <param name="output">The stream to which to write the color.</param>
        /// <param name="red">The red component in the range 0.0-1.0.</param>
        /// <param name="green">The green component in the range 0.0-1.0.</param>
        /// <param name="blue">The blue component in the range 0.0-1.0.</param>
        /// <param name="alpha">The alpha component in the range 0.0-1.0.</param>
        public static void WriteRgbaf([NotNull] CesiumOutputStream output, double red, double green, double blue, double alpha)
        {
            output.WriteStartSequence();
            output.WriteValue(red);
            output.WriteValue(green);
            output.WriteValue(blue);
            output.WriteValue(alpha);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged color values as an array in [Time, Red, Green, Blue, Alpha] order as floating-point values.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteRgbaf([NotNull] CesiumOutputStream output,
                                      [NotNull] string propertyName,
                                      [NotNull] IList<JulianDate> dates,
                                      [NotNull] IList<Color> values,
                                      int startIndex,
                                      int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                Color value = values[i];
                output.WriteValue(value.R / 255.0);
                output.WriteValue(value.G / 255.0);
                output.WriteValue(value.B / 255.0);
                output.WriteValue(value.A / 255.0);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged floating-point values as an array in [Time, Value] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteDouble([NotNull] CesiumOutputStream output,
                                       [NotNull] string propertyName,
                                       [NotNull] IList<JulianDate> dates,
                                       [NotNull] IList<double> values,
                                       int startIndex,
                                       int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                output.WriteValue(values[i]);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged floating-point values as an array in [Time, Value] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteInteger([NotNull] CesiumOutputStream output,
                                        [NotNull] string propertyName,
                                        [NotNull] IList<JulianDate> dates,
                                        [NotNull] IList<int> values,
                                        int startIndex,
                                        int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                output.WriteValue(values[i]);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="UnitQuaternion"/> as an array in [X, Y, Z, W] order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteUnitQuaternion([NotNull] CesiumOutputStream output, UnitQuaternion value)
        {
            output.WriteStartSequence();
            output.WriteValue(value.X);
            output.WriteValue(value.Y);
            output.WriteValue(value.Z);
            output.WriteValue(value.W);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes the time-tagged <see cref="UnitQuaternion"/> collection as an array in
        /// [Time, X, Y, Z, W] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which the values will be written.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteUnitQuaternion([NotNull] CesiumOutputStream output,
                                               [NotNull] string propertyName,
                                               [NotNull] IList<JulianDate> dates,
                                               [NotNull] IList<UnitQuaternion> values,
                                               int startIndex,
                                               int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(output, dates, startIndex, length);

            output.WritePropertyName(propertyName);
            output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                output.WriteValue(epoch.SecondsDifference(dates[i]));
                UnitQuaternion quaternion = values[i];
                output.WriteValue(quaternion.X);
                output.WriteValue(quaternion.Y);
                output.WriteValue(quaternion.Z);
                output.WriteValue(quaternion.W);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a reference.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteReference([NotNull] CesiumOutputStream output, string value)
        {
            output.WriteValue(value);
        }

        /// <summary>
        /// Writes a reference.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteReference([NotNull] CesiumOutputStream output, [NotNull] Reference value)
        {
            WriteReference(output, value.Value);
        }

        /// <summary>
        /// Writes a reference and an identifier and property name.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="identifier">The identifier of the referenced object.</param>
        /// <param name="propertyName">The property name.</param>
        public static void WriteReference([NotNull] CesiumOutputStream output, string identifier, string propertyName)
        {
            WriteReference(output, new Reference(identifier, propertyName));
        }

        /// <summary>
        /// Writes a reference from an identifier and hierarchy of property names.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="identifier">The identifier of the referenced object.</param>
        /// <param name="propertyNames">The hierarchy of property names, where each name is a subproperty of the previous item.</param>
        public static void WriteReference([NotNull] CesiumOutputStream output, string identifier, string[] propertyNames)
        {
            WriteReference(output, new Reference(identifier, propertyNames));
        }

        /// <summary>
        /// Writes a list of values.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="references">The list of values.</param>
        public static void WriteReferences([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<Reference> references)
        {
            output.WriteStartSequence();
            foreach (var reference in references)
            {
                output.WriteValue(reference.Value);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of values.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The list of lists of values.</param>
        [CSToJavaUseWildcardGenerics]
        public static void WriteReferenceListOfLists([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<IEnumerable<Reference>> values)
        {
            output.WriteStartSequence();
            foreach (var list in values)
            {
                output.WriteStartSequence();
                output.WriteLineBreak();
                foreach (var reference in list)
                {
                    output.WriteValue(reference.Value);
                    output.WriteLineBreak();
                }

                output.WriteEndSequence();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="UnitCartesian"/> values as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteUnitCartesian3List([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<UnitCartesian> values)
        {
            output.WriteStartSequence();
            foreach (UnitCartesian value in values)
            {
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteValue(value.Z);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="Spherical"/> values as an array in Clock, Cone, Magnitude order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteSphericalList([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<Spherical> values)
        {
            output.WriteStartSequence();
            foreach (Spherical value in values)
            {
                output.WriteValue(value.Clock);
                output.WriteValue(value.Cone);
                output.WriteValue(value.Magnitude);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="UnitSpherical"/> values as an array in Clock, Cone order.
        /// </summary>
        /// <param name="output">The stream to which the value will be written.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteUnitSphericalList([NotNull] CesiumOutputStream output, [NotNull] IEnumerable<UnitSpherical> values)
        {
            output.WriteStartSequence();
            foreach (UnitSpherical value in values)
            {
                output.WriteValue(value.Clock);
                output.WriteValue(value.Cone);
                output.WriteLineBreak();
            }

            output.WriteEndSequence();
        }

        /// <summary>
        /// Gets an appropriate epoch from a list of dates and writes it to the <see cref="CesiumOutputStream"/>
        /// as the "epoch" property.  If the <paramref name="dates"/> collection is empty, the <paramref name="startIndex"/>
        /// is past the end of the collection, or the <paramref name="length"/> is zero, this method does not write
        /// the "epoch" property and returns <see cref="JulianDate.MinValue"/>.
        /// </summary>
        /// <param name="output">The stream to which to write the epoch.</param>
        /// <param name="dates">The collection of dates from which to determine the epoch.</param>
        /// <param name="startIndex">The first index in the collection to use.</param>
        /// <param name="length">The number of items from the collection to use.</param>
        /// <returns>A suitable epoch determined from the collection.</returns>
        private static JulianDate GetAndWriteEpoch([NotNull] CesiumOutputStream output, [NotNull] IList<JulianDate> dates, int startIndex, int length)
        {
            if (startIndex >= dates.Count)
                return JulianDate.MinValue;

            JulianDate epoch = dates[startIndex];
            output.WritePropertyName("epoch");
            output.WriteValue(CesiumFormattingHelper.ToIso8601(epoch, GetIso8601Format(output)));
            return epoch;
        }
    }
}