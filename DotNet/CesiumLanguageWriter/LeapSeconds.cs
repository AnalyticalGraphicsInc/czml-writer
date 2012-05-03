using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Manages Leap Seconds.
    /// </summary>
    public class LeapSeconds
    {
        private static LeapSeconds s_leapSeconds = new LeapSeconds();

        /// <summary>
        /// Gets the default (and usually only) instance.
        /// </summary>
        public static LeapSeconds Instance
        {
            get { return s_leapSeconds; }
            set { s_leapSeconds = value; }
        }

        /// <summary>
        /// Initializes a new instance with the list of leap seconds that was available
        /// when the library was released.
        /// </summary>
        public LeapSeconds()
        {
            m_leapSeconds = new List<LeapSecond>();
            m_leapSeconds.Add(new LeapSecond(2441317.5, 10));
            m_leapSeconds.Add(new LeapSecond(2441499.5, 11));
            m_leapSeconds.Add(new LeapSecond(2441683.5, 12));
            m_leapSeconds.Add(new LeapSecond(2442048.5, 13));
            m_leapSeconds.Add(new LeapSecond(2442413.5, 14));
            m_leapSeconds.Add(new LeapSecond(2442778.5, 15));
            m_leapSeconds.Add(new LeapSecond(2443144.5, 16));
            m_leapSeconds.Add(new LeapSecond(2443509.5, 17));
            m_leapSeconds.Add(new LeapSecond(2443874.5, 18));
            m_leapSeconds.Add(new LeapSecond(2444239.5, 19));
            m_leapSeconds.Add(new LeapSecond(2444786.5, 20));
            m_leapSeconds.Add(new LeapSecond(2445151.5, 21));
            m_leapSeconds.Add(new LeapSecond(2445516.5, 22));
            m_leapSeconds.Add(new LeapSecond(2446247.5, 23));
            m_leapSeconds.Add(new LeapSecond(2447161.5, 24));
            m_leapSeconds.Add(new LeapSecond(2447892.5, 25));
            m_leapSeconds.Add(new LeapSecond(2448257.5, 26));
            m_leapSeconds.Add(new LeapSecond(2448804.5, 27));
            m_leapSeconds.Add(new LeapSecond(2449169.5, 28));
            m_leapSeconds.Add(new LeapSecond(2449534.5, 29));
            m_leapSeconds.Add(new LeapSecond(2450083.5, 30));
            m_leapSeconds.Add(new LeapSecond(2450630.5, 31));
            m_leapSeconds.Add(new LeapSecond(2451179.5, 32));
            m_leapSeconds.Add(new LeapSecond(2453736.5, 33));
            m_leapSeconds.Add(new LeapSecond(2454832.5, 34));
            m_leapSeconds.Add(new LeapSecond(2456109.5, 35));
        }

        /// <summary>
        /// Initializes a new instance with the specified list of leap seconds.
        /// </summary>
        /// <param name="leapSeconds">The list of leap seconds.</param>
        public LeapSeconds(IEnumerable<LeapSecond> leapSeconds)
        {
            m_leapSeconds = new List<LeapSecond>(leapSeconds);
            m_leapSeconds.Sort(s_compareLeapSecondDate);
        }

        /// <summary>
        /// Gets the list of leap seconds currently being used by this class.
        /// </summary>
        public ReadOnlyCollection<LeapSecond> LeapSecondList
        {
            get { return m_leapSeconds.AsReadOnly(); }
        }

        /// <summary>
        /// Returns the difference TAI - UTC as of the given date, in seconds.
        /// </summary>
        /// <param name="date">The date.</param>
        /// <returns>The difference.</returns>
        public double GetTaiMinusUtc(JulianDate date)
        {
            LeapSecond toFind = new LeapSecond(date, 0.0);

            // Start by assuming we're working with UTC, we'll check later if we're
            // off by one because we really have TAI.
            int index = m_leapSeconds.BinarySearch(toFind, s_compareLeapSecondDate);
            if (index < 0)
            {
                index = ~index;
                --index;
            }

            // Check if we're off by one because we're really working with TAI.
            // If the requested date minus the most recent previous leap second offset is less than the date
            // for the current leap second, then we haven't quite gotten to that leap second yet.
            // This gets a little tricky because JulianDate and its conversion mechanisms try to outsmart us.
            if (date.Standard == TimeStandard.InternationalAtomicTime)
            {
                JulianDate lastDate = GetDateForIndex(index);
                JulianDate taiCutoff = new JulianDate(lastDate.Day, lastDate.SecondsOfDay, TimeStandard.InternationalAtomicTime);
                taiCutoff += Duration.FromSeconds(GetOffsetForIndex(index));
                if (date < taiCutoff)
                {
                    --index;
                }
            }

            return GetOffsetForIndex(index);
        }

        /// <summary>
        /// Convert <paramref name="date"/> from TAI to UTC, if possible.
        /// </summary>
        /// <param name="date">The date, which must be in the TAI 
        /// <see cref="TimeStandard"/>.</param>
        /// <returns>The resulting UTC 
        /// <see cref="JulianDate"/>, if it was possible to convert.</returns>
        /// <exception cref="ArgumentOutOfRangeException">Thrown if the date could not be
        /// converted to UTC.</exception>
        internal JulianDate ConvertTaiToUtc(JulianDate date)
        {
            JulianDate result;
            if (TryConvertTaiToUtc(date, out result))
                return result;

            throw new ArgumentOutOfRangeException(CesiumLocalization.CannotRepresentLeapSecondAsUTCJulianDate);
        }

        /// <summary>
        /// Try to convert <paramref name="date"/> from TAI to UTC, if possible.
        /// </summary>
        /// <param name="date">The date, which must be in the TAI 
        /// <see cref="TimeStandard"/>.</param>
        /// <param name="result">Out parameter for returning the resulting UTC 
        /// <see cref="JulianDate"/>, if it was possible to convert.</param>
        /// <returns><see langword="true"/> if <paramref name="date"/> could be converted
        /// to UTC, otherwise false.</returns>
        internal bool TryConvertTaiToUtc(JulianDate date, out JulianDate result)
        {
            //treat the request date as if it were UTC, and search for the most recent leap second.
            LeapSecond toFind = new LeapSecond(date, 0.0);
            int index = m_leapSeconds.BinarySearch(toFind, s_compareLeapSecondDate);
            if (index < 0)
            {
                index = ~index;
                --index;
            }

            //now we have the index of the most recent leap second that is after the requested date
            if (index >= 0)
            {
                double mostRecentOffset = GetOffsetForIndex(index);
                JulianDate leapSecondDate = GetDateForIndex(index);

                if (date.Day == leapSecondDate.Day)
                {
                    //if the requested date is on the day of the leap second, we may have to adjust
                    double secondsSinceLeapSecond = date.SecondsOfDay - leapSecondDate.SecondsOfDay;

                    if (secondsSinceLeapSecond >= mostRecentOffset - 1 &&
                        secondsSinceLeapSecond < mostRecentOffset)
                    {
                        //if the requested date is during the moment of a leap second, then we cannot convert to UTC.
                        result = JulianDate.MinValue;
                        return false;
                    }

                    if (secondsSinceLeapSecond < mostRecentOffset)
                    {
                        //The leap second we found is actually after the desired date, as a result of simply treating the
                        //TAI date as if it were UTC.  So, use the next previous leap second instead.
                        --index;
                    }
                }
            }

            result = new JulianDate(date.Day, date.SecondsOfDay - GetOffsetForIndex(index), TimeStandard.CoordinatedUniversalTime);
            return true;
        }

        private JulianDate GetDateForIndex(int index)
        {
            if (index < 0)
            {
                return new JulianDate(0, 0.0, TimeStandard.CoordinatedUniversalTime);
            }
            return m_leapSeconds[index].Date;
        }

        private double GetOffsetForIndex(int index)
        {
            if (index < 0)
            {
                return 10.0;
            }
            return m_leapSeconds[index].TotalTaiOffsetFromUtc;
        }

        /// <summary>
        /// Determines if a given day contains a leap second.
        /// </summary>
        /// <param name="julianDayNumber">The day, specified as a Julian day number.</param>
        /// <returns>true if the day contains a leap second, otherwise false.</returns>
        public bool DoesDayHaveLeapSecond(int julianDayNumber)
        {
            LeapSecond potentialLeapSecond = new LeapSecond(new JulianDate(julianDayNumber, 43200, TimeStandard.CoordinatedUniversalTime), 0.0);
            return m_leapSeconds.BinarySearch(potentialLeapSecond, s_compareLeapSecondDate) >= 0;
        }

        private class CompareLeapSecondDate : IComparer<LeapSecond>
        {
            public int Compare(LeapSecond x, LeapSecond y)
            {
                return x.Date.CompareTo(y.Date);
            }
        }

        private readonly List<LeapSecond> m_leapSeconds;
        private static readonly CompareLeapSecondDate s_compareLeapSecondDate = new CompareLeapSecondDate();
    }
}