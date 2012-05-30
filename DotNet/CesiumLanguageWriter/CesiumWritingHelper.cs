using System;
using System.Collections.Generic;
using CesiumLanguageWriter.Advanced;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Contains helper methods for writing CZML values.
    /// </summary>
    public static class CesiumWritingHelper
    {
        /// <summary>
        /// Writes a <see cref="TimeInterval"/> as an ISO 8601 interval string.
        /// </summary>
        /// <param name="output">The stream to which to write the interval.</param>
        /// <param name="interval">The interval to write.</param>
        public static void WriteValue(CesiumOutputStream output, TimeInterval interval)
        {
            output.WriteValue(CesiumFormattingHelper.ToIso8601Interval(interval.Start, interval.Stop, output.PrettyFormatting ? Iso8601Format.Extended : Iso8601Format.Compact));
        }

        /// <summary>
        /// Writes a list of <see cref="TimeInterval">TimeIntervals</see>.  If the collection has a single
        /// interval, the interval is written as an ISO 8601 interval string.  If it has multiple intervals,
        /// it is written as an array of ISO 8601 interval strings.
        /// </summary>
        /// <param name="output">The stream to which to write the interval.</param>
        /// <param name="intervals">The intervals to write.</param>
        public static void WriteValue(CesiumOutputStream output, IList<TimeInterval> intervals)
        {
            if (intervals.Count == 1)
            {
                TimeInterval interval = intervals[0];
                WriteValue(output, interval);
            }
            else
            {
                output.WriteStartSequence();
                foreach (TimeInterval interval in intervals)
                {
                    WriteValue(output, interval);
                }
                output.WriteEndSequence();
            }
        }

        /// <summary>
        /// Writes a <see cref="Cartesian"/> value as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which to write the interval.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteValue(CesiumOutputStream output, Cartesian value)
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
        /// <param name="output">The stream to which to write the array.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteValue(CesiumOutputStream output, string propertyName, IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
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
        /// Writes a <see cref="Cartographic"/> value as an array in Longitude, Latitude, Height order.
        /// </summary>
        /// <param name="output">The stream to which to write the interval.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteValue(CesiumOutputStream output, Cartographic value)
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
        /// <param name="output">The stream to which to write the array.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteValue(CesiumOutputStream output, string propertyName, IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
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
        private static JulianDate GetAndWriteEpoch(CesiumOutputStream output, IList<JulianDate> dates, int startIndex, int length)
        {
            if (startIndex < dates.Count)
            {
                JulianDate epoch = dates[startIndex];
                output.WritePropertyName("epoch");
                output.WriteValue(CesiumFormattingHelper.ToIso8601(epoch, output.PrettyFormatting ? Iso8601Format.Extended : Iso8601Format.Compact));
                return epoch;
            }
            else
            {
                return JulianDate.MinValue;
            }
        }
    }
}
