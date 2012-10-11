﻿using System;
using System.Collections.Generic;
using System.Drawing;

#if StkComponents
using AGI.Foundation.Coordinates;
using AGI.Foundation.Time;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium.Advanced
#else
namespace CesiumLanguageWriter.Advanced
#endif
{
    /// <summary>
    /// Contains helper methods for writing CZML values.
    /// </summary>
    internal static class CesiumWritingHelper
    {
        /// <summary>
        /// The maximum interval of time that can be specified.
        /// </summary>
        public static readonly TimeInterval MaximumInterval = new TimeInterval(GregorianDate.MinValue.ToJulianDate(), GregorianDate.MaxValue.ToJulianDate());

        /// <summary>
        /// Writes a <see cref="TimeInterval"/> as an ISO 8601 interval string.
        /// </summary>
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="interval">The interval to write.</param>
        public static void WriteTimeInterval(CesiumOutputStream output, TimeInterval interval)
        {
            output.WriteValue(CesiumFormattingHelper.ToIso8601Interval(interval.Start, interval.Stop, output.PrettyFormatting ? Iso8601Format.Extended : Iso8601Format.Compact));
        }

        /// <summary>
        /// Writes a list of <see cref="TimeInterval">TimeIntervals</see>.  If the collection has a single
        /// interval, the interval is written as an ISO 8601 interval string.  If it has multiple intervals,
        /// it is written as an array of ISO 8601 interval strings.
        /// </summary>
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="intervals">The intervals to write.</param>
        public static void WriteTimeIntervalCollection(CesiumOutputStream output, IList<TimeInterval> intervals)
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
                }
                output.WriteEndSequence();
            }
        }

        /// <summary>
        /// Writes a <see cref="Rectangular"/> value as an array in X, Y order.
        /// </summary>
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteCartesian2(CesiumOutputStream output, Rectangular value)
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
        /// <param name="output">The stream to which to write the array.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteCartesian2(CesiumOutputStream output, string propertyName, IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
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
        /// Writes a <see cref="Cartesian"/> value as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteCartesian3(CesiumOutputStream output, Cartesian value)
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
        public static void WriteCartesian3(CesiumOutputStream output, string propertyName, IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
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
        /// Writes a list of <see cref="Cartesian"/> values as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteCartesian3List(CesiumOutputStream output, IEnumerable<Cartesian> values)
        {
            output.WriteStartSequence();
            foreach (Cartesian value in values)
            {
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteValue(value.Z);
            }
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a <see cref="Cartographic"/> value as an array in Longitude, Latitude, Height order.
        /// </summary>
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteCartographic(CesiumOutputStream output, Cartographic value)
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
        public static void WriteCartographic(CesiumOutputStream output, string propertyName, IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
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
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteCartographicList(CesiumOutputStream output, IEnumerable<Cartographic> values)
        {
            output.WriteStartSequence();
            foreach (Cartographic value in values)
            {
                output.WriteValue(value.Longitude);
                output.WriteValue(value.Latitude);
                output.WriteValue(value.Height);
            }
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a color value as an array in Red, Green, Blue, Alpha order.
        /// </summary>
        /// <param name="output">The stream to which to write the color.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteRgba(CesiumOutputStream output, Color value)
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
        public static void WriteRgba(CesiumOutputStream output, int red, int green, int blue, int alpha)
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
        /// <param name="output">The stream to which to write the array.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteRgba(CesiumOutputStream output, string propertyName, IList<JulianDate> dates, IList<Color> values, int startIndex, int length)
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
        /// Writes a color value as an array in Red, Green, Blue, Alpha order.
        /// </summary>
        /// <param name="output">The stream to which to write the color.</param>
        /// <param name="red">The red component in the range 0.0-1.0.</param>
        /// <param name="green">The green component in the range 0.0-1.0.</param>
        /// <param name="blue">The blue component in the range 0.0-1.0.</param>
        /// <param name="alpha">The alpha component in the range 0.0-1.0.</param>
        public static void WriteRgbaf(CesiumOutputStream output, float red, float green, float blue, float alpha)
        {
            output.WriteStartSequence();
            output.WriteValue(red);
            output.WriteValue(green);
            output.WriteValue(blue);
            output.WriteValue(alpha);
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes time-tagged floating-point values as an array in [Time, Value] order.
        /// Times are epoch seconds since an epoch that is determined from the first date to be written.
        /// The epoch property is written as well.
        /// </summary>
        /// <param name="output">The stream to which to write the array.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteDouble(CesiumOutputStream output, string propertyName, IList<JulianDate> dates, IList<double> values, int startIndex, int length)
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
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="value">The value to write.</param>
        public static void WriteUnitQuaternion(CesiumOutputStream output, UnitQuaternion value)
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
        /// <param name="output">The stream to which to write the array.</param>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The corresponding value for each date.</param>
        /// <param name="startIndex">The index of the first element to use in the <paramref name="values"/> collection.</param>
        /// <param name="length">The number of elements to use from the <paramref name="values"/> collection.</param>
        public static void WriteUnitQuaternion(CesiumOutputStream output, string propertyName, IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length)
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
        /// Writes a list of references.
        /// </summary>
        /// <param name="output">The stream to which to write.</param>
        /// <param name="references">The list of references to write.</param>
        public static void WriteReferences(CesiumOutputStream output, IEnumerable<string> references)
        {
            output.WriteStartSequence();
            foreach (string reference in references)
            {
                output.WriteValue(reference);
                output.WriteLineBreak();
            }
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="UnitCartesian"/> values as an array in X, Y, Z order.
        /// </summary>
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteUnitCartesian3List(CesiumOutputStream output, IEnumerable<UnitCartesian> values)
        {
            output.WriteStartSequence();
            foreach (UnitCartesian value in values)
            {
                output.WriteValue(value.X);
                output.WriteValue(value.Y);
                output.WriteValue(value.Z);
            }
            output.WriteEndSequence();
        }

        /// <summary>
        /// Writes a list of <see cref="UnitSpherical"/> values as an array in Clock, Cone order.
        /// </summary>
        /// <param name="output">The stream to which to write the value.</param>
        /// <param name="values">The values to write.</param>
        public static void WriteUnitSphericalList(CesiumOutputStream output, IEnumerable<UnitSpherical> values)
        {
            output.WriteStartSequence();
            foreach (UnitSpherical value in values)
            {
                output.WriteValue(value.Clock);
                output.WriteValue(value.Cone);
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