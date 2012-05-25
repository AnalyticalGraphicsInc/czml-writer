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
        /// <param name="output"></param>
        /// <param name="intervals"></param>
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
    }
}
