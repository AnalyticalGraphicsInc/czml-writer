using System;
using System.Collections.Generic;
using System.Globalization;
using System.Text;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Represents a calendar date in the Gregorian calendar.  A 
    /// <see cref="GregorianDate"/> does not include a <see cref="TimeStandard"/> as <see cref="JulianDate"/>
    /// does.  However, without explicitly specifying a <see cref="TimeStandard"/> for the date, the <see cref="GregorianDate"/>
    /// is assumed to be represented in <see cref="TimeStandard.CoordinatedUniversalTime"/>. <see cref="GregorianDate"/> is
    /// also capable of representing leap seconds, which are represented as the second measured from 60 to 61.  In this case,
    /// the <see cref="GregorianDate"/> is assumed to be the <see cref="TimeStandard.CoordinatedUniversalTime"/> represented
    /// in <see cref="TimeStandard.InternationalAtomicTime"/> which can represent leap seconds exactly.
    /// </summary>
    [CSToJavaExcludeBase("IComparable")]
    [CSToJavaImmutableValueType]
    public struct GregorianDate : IComparable<GregorianDate>, IComparable, IEquatable<GregorianDate>
    {
        /// <summary>
        /// This class was taken from the Mono <see cref="DateTime"/> class, and
        /// substantially altered to fit the needs of Gregorian Date.  Gregorian Date
        /// assumes UTC, so all time-zone handling was ripped out.  The "f" parsing was
        /// also changed to allow more precision than the 7 digits that 
        /// <see cref="DateTime"/> mandates.
        /// 
        /// Note: any comment from here on is taken from the Mono source, so any references
        /// to bug numbers refer to their bugs.
        /// </summary>
        private static class Parser
        {
            /// <summary>
            /// Build an array of date/time patterns that support up to the number of
            /// fractional second digits specified.  <see cref="DateTime"/> will only parse up
            /// to seven.
            /// </summary>
            /// <param name="patterns">The set of formats to use as a template.</param>
            /// <param name="maximumFractionalSeconds">The maximum number of fractional second
            /// digits to include in the pattern set.</param>
            /// <returns>An array of date/time patterns that can be used for parsing.</returns>
            private static string[] BuildDateTimePatterns(string[] patterns, int maximumFractionalSeconds)
            {
                List<string> result = new List<string>(patterns.Length * (maximumFractionalSeconds + 1));
                foreach (string s in patterns)
                {
                    if (s.EndsWith(".f*"))
                    {
                        result.Add(s.Replace(".f*", ""));
                        StringBuilder newStr = new StringBuilder(maximumFractionalSeconds);
                        for (int i = 1; i <= maximumFractionalSeconds; i++)
                        {
                            newStr.Append("f");
                            result.Add(s.Replace("f*", newStr.ToString()));
                        }
                    }
                    else
                    {
                        result.Add(s);
                    }
                }
                return result.ToArray();
            }

            /// <summary>
            /// Don't use these patterns directly.  Instead get your patterns from 
            /// <see cref="BuildDateTimePatterns"/>.
            /// </summary>
            private static readonly string[] s_extraDateTimePatternTemplates =
                new[]
                {
                    "M/d/yyyy H:mm:ss.f*",
                    "d MMM yyyy H:mm:ss.f*",
                    "yyyy-M-dTHH:mm:ss.f*",
                    "M-yyyy-dTH:mm:ss.f*",
                    "M-yyyy-d H:mm:ss.f*",
                };

            // DateTime.Parse patterns
            // Patterns are divided to date and time patterns. The algorithm will
            // try combinations of these patterns. The algorithm also looks for
            // day of the week, AM/PM GMT and Z independently of the patterns.
            private static readonly string[] s_parseTimeFormatsTemplate =
                new[]
                    {
                        "H:m:s.f*",
                        "H:m:s",
                        "H:m",
                        "H tt", // Specifies AM to disallow '8'.
                        "H'\u6642'm'\u5206's'\u79D2'",
                    };

            private static readonly string[] s_extraDateTimePatterns = BuildDateTimePatterns(s_extraDateTimePatternTemplates, 17);

            private static readonly string[] s_parseTimeFormats = BuildDateTimePatterns(s_parseTimeFormatsTemplate, 17);

            // DateTime.Parse date patterns extend ParseExact patterns as follows:
            //   MMM - month short name or month full name
            //   MMMM - month number or short name or month full name

            // Parse behaves differently according to the ShorDatePattern of the
            // DateTimeFormatInfo. The following define the date patterns for
            // different orders of day, month and year in ShorDatePattern.
            // Note that the year cannot go between the day and the month.
            private static readonly string[] s_parseYearDayMonthFormats =
                new[]
                    {
                        "yyyy/M/dT",
                        "M/yyyy/dT",
                        "yyyy'\u5E74'M'\u6708'd'\u65E5",
                        "yyyy/d/MMMM",
                        "yyyy/MMM/d",
                        "d/MMMM/yyyy",
                        "MMM/d/yyyy",
                        "d/yyyy/MMMM",
                        "MMM/yyyy/d",
                        "yy/d/M",
                    };

            private static readonly string[] s_parseYearMonthDayFormats =
                new[]
                    {
                        "yyyy/M/dT",
                        "M/yyyy/dT",
                        "yyyy'\u5E74'M'\u6708'd'\u65E5",
                        "yyyy/MMMM/d",
                        "yyyy/d/MMM",
                        "MMMM/d/yyyy",
                        "d/MMM/yyyy",
                        "MMMM/yyyy/d",
                        "d/yyyy/MMM",
                        "yy/MMMM/d",
                        "yy/d/MMM",
                        "MMM/yy/d",
                    };

            private static readonly string[] s_parseDayMonthYearFormats =
                new[]
                    {
                        "yyyy/M/dT",
                        "M/yyyy/dT",
                        "yyyy'\u5E74'M'\u6708'd'\u65E5",
                        "yyyy/MMMM/d",
                        "yyyy/d/MMM",
                        "d/MMMM/yyyy",
                        "MMM/d/yyyy",
                        "MMMM/yyyy/d",
                        "d/yyyy/MMM",
                        "d/MMMM/yy",
                        "yy/MMM/d",
                        "d/yy/MMM",
                        "yy/d/MMM",
                        "MMM/d/yy",
                        "MMM/yy/d",
                    };

            private static readonly string[] s_parseMonthDayYearFormats =
                new[]
                    {
                        "yyyy/M/dT",
                        "M/yyyy/dT",
                        "yyyy'\u5E74'M'\u6708'd'\u65E5",
                        "yyyy/MMMM/d",
                        "yyyy/d/MMM",
                        "MMMM/d/yyyy",
                        "d/MMM/yyyy",
                        "MMMM/yyyy/d",
                        "d/yyyy/MMM",
                        "MMMM/d/yy",
                        "MMM/yy/d",
                        "d/MMM/yy",
                        "yy/MMM/d",
                        "d/yy/MMM",
                        "yy/d/MMM",
                    };

            // Patterns influenced by the MonthDayPattern in DateTimeFormatInfo.
            // Note that these patterns cannot be followed by the time.
            private static readonly string[] s_monthDayShortFormats =
                new[]
                    {
                        "MMMM/d",
                        "d/MMM",
                        "yyyy/MMMM",
                    };

            private static readonly string[] s_dayMonthShortFormats =
                new[]
                    {
                        "d/MMMM",
                        "MMM/yy",
                        "yyyy/MMMM",
                    };

            public static GregorianDate Parse(string s, IFormatProvider provider)
            {
                if (s == null)
                    throw new ArgumentNullException("s");

                GregorianDate res;
                FormatException exception = null;
                if (!CoreParse(s, provider, out res, true, ref exception))
                    throw exception;

                return res;
            }

            public static GregorianDate ParseExact(string s, string[] format, IFormatProvider provider)
            {
                if (s == null)
                    throw new ArgumentNullException("s");
                if (format == null)
                    throw new ArgumentNullException("format");

                DateTimeFormatInfo dfi = DateTimeFormatInfo.GetInstance(provider);

                GregorianDate result;
                bool longYear = false;
                FormatException e = null;
                if (!ParseExact(s, format, dfi, out result, true, ref longYear, true, ref e))
                    throw e;
                return result;
            }

            public static bool TryParse(string s, IFormatProvider provider, out GregorianDate result)
            {
                if (s != null)
                {
                    try
                    {
                        FormatException exception = null;
                        return CoreParse(s, provider, out result, false, ref exception);
                    }
                    catch
                    {
                    }
                }
                result = MinValue;
                return false;
            }

            private static bool ParseExact(string s, string[] formats, DateTimeFormatInfo dfi, out GregorianDate ret, bool exact, ref bool longYear,
                                           bool setExceptionOnError, ref FormatException exception)
            {
                int i;
                bool incompleteFormat = false;
                for (i = 0; i < formats.Length; i++)
                {
                    GregorianDate result;
                    string format = formats[i];
                    if (string.IsNullOrEmpty(format))
                        break;

                    if (DoParse(s, formats[i], null, exact, out result, dfi, ref incompleteFormat, ref longYear))
                    {
                        ret = result;
                        return true;
                    }
                }

                if (setExceptionOnError)
                    exception = new FormatException(CesiumLocalization.GregorianDateFormatInvalid);
                ret = MinValue;
                return false;
            }

            private static bool CoreParse(string s, IFormatProvider provider, out GregorianDate result, bool setExceptionOnError,
                                          ref FormatException exception)
            {
                if (string.IsNullOrEmpty(s))
                {
                    if (setExceptionOnError)
                        exception = new FormatException(CesiumLocalization.GregorianDateFormatInvalid);
                    result = MinValue;
                    return false;
                }

                if (provider == null)
                    provider = CultureInfo.CurrentCulture;

                DateTimeFormatInfo dfi = DateTimeFormatInfo.GetInstance(provider);

                // Try first all the combinations of ParseAllDateFormats & ParseTimeFormats
                string[] allDateFormats = YearMonthDayFormats(dfi, setExceptionOnError, ref exception);
                if (allDateFormats == null)
                {
                    result = MinValue;
                    return false;
                }

                bool longYear = false;
                for (int i = 0; i < allDateFormats.Length; i++)
                {
                    string firstPart = allDateFormats[i];
                    bool incompleteFormat = false;
                    if (DoParse(s, firstPart, "", false, out result, dfi, ref incompleteFormat, ref longYear))
                        return true;

                    if (!incompleteFormat)
                        continue;

                    for (int j = 0; j < s_parseTimeFormats.Length; j++)
                    {
                        if (DoParse(s, firstPart, s_parseTimeFormats[j], false, out result, dfi, ref incompleteFormat, ref longYear))
                            return true;
                    }
                }

                //
                // Month day formats
                //
                int dayIndex = dfi.MonthDayPattern.IndexOf('d');
                int monthIndex = dfi.MonthDayPattern.IndexOf('M');
                if (dayIndex == -1 || monthIndex == -1)
                {
                    result = MinValue;
                    if (setExceptionOnError)
                        exception = new FormatException(string.Format(CesiumLocalization.GregorianDateOrderOfMonthAndDateNotDefined, dfi.MonthDayPattern));
                    return false;
                }
                bool isDayBeforeMonth = dayIndex < monthIndex;
                string[] monthDayFormats = isDayBeforeMonth ? s_dayMonthShortFormats : s_monthDayShortFormats;
                for (int i = 0; i < monthDayFormats.Length; i++)
                {
                    bool incompleteFormat = false;
                    if (DoParse(s, monthDayFormats[i], "", false, out result, dfi, ref incompleteFormat, ref longYear))
                        return true;
                }

                for (int j = 0; j < s_parseTimeFormats.Length; j++)
                {
                    string firstPart = s_parseTimeFormats[j];
                    bool incompleteFormat = false;
                    if (DoParse(s, firstPart, "", false, out result, dfi, ref incompleteFormat, ref longYear))
                        return true;
                    if (!incompleteFormat)
                        continue;

                    for (int i = 0; i < monthDayFormats.Length; i++)
                    {
                        if (DoParse(s, firstPart, monthDayFormats[i], false, out result, dfi, ref incompleteFormat, ref longYear))
                            return true;
                    }
                    for (int i = 0; i < allDateFormats.Length; i++)
                    {
                        string dateFormat = allDateFormats[i];
                        if (dateFormat[dateFormat.Length - 1] == 'T')
                            continue; // T formats must be before the time part
                        if (DoParse(s, firstPart, dateFormat, false, out result, dfi, ref incompleteFormat, ref longYear))
                            return true;
                    }
                }

#if !SILVERLIGHT
                // Try as a last resort all the patterns
                if (ParseExact(s, dfi.GetAllDateTimePatterns(), dfi, out result, false, ref longYear, setExceptionOnError, ref exception))
                    return true;
#endif

                //then try the extra patterns that aren't listed in GetAllDateTimePatterns()
                if (ParseExact(s, s_extraDateTimePatterns, dfi, out result, false, ref longYear, setExceptionOnError, ref exception))
                    return true;

                // Since the above formats (.NET formatting) can't handle "day-of-year" very well,
                // try parsing it here as a last resort
                if (ParseIso8601DayOfYear(s, dfi, out result, setExceptionOnError, ref exception))
                    return true;

                if (!setExceptionOnError)
                    return false;

                exception = new FormatException(string.Format(CesiumLocalization.GregorianDateStringNotRecognized, s));
                return false;
            }

            private static string[] YearMonthDayFormats(DateTimeFormatInfo dfi, bool setExceptionOnError, ref FormatException ex)
            {
                int dayIndex = dfi.ShortDatePattern.IndexOf('d');
                int monthIndex = dfi.ShortDatePattern.IndexOf('M');
                int yearIndex = dfi.ShortDatePattern.IndexOf('y');
                if (dayIndex == -1 || monthIndex == -1 || yearIndex == -1)
                {
                    if (setExceptionOnError)
                        ex = new FormatException(string.Format(CesiumLocalization.GregorianDateOrderOfYearMonthAndDateNotDefined, dfi.ShortDatePattern));
                    return null;
                }

                if (yearIndex < monthIndex)
                    if (monthIndex < dayIndex)
                        return s_parseYearMonthDayFormats;
                    else if (yearIndex < dayIndex)
                        return s_parseYearDayMonthFormats;
                    else
                    {
                        // The year cannot be between the date and the month
                        if (setExceptionOnError)
                        {
                            string msg = string.Format(CesiumLocalization.GregorianDateOrderOfYearMonthAndDateNotSupported, dfi.ShortDatePattern);
                            ex = new FormatException(msg);
                        }
                        return null;
                    }

                if (dayIndex < monthIndex)
                    return s_parseDayMonthYearFormats;

                if (dayIndex < yearIndex)
                    return s_parseMonthDayYearFormats;

                // The year cannot be between the month and the date
                if (setExceptionOnError)
                {
                    string msg = string.Format(CesiumLocalization.GregorianDateOrderOfYearMonthAndDateNotSupported, dfi.ShortDatePattern);
                    ex = new FormatException(msg);
                }
                return null;
            }

            private static bool ParseDateSeparator(string s, int sPos, DateTimeFormatInfo dfi, bool exact, out int numParsed)
            {
                numParsed = -1;
                if (exact && s[sPos] != '/')
                    return false;

                if (ParseTimeSeparator(s, sPos, dfi, exact, out numParsed) ||
                    Char.IsDigit(s[sPos]) || Char.IsLetter(s[sPos]))
                    return (false);

                numParsed = 1;
                return true;
            }

            private static long ParseNumber(string s, int valuePos, int minDigits, int digits, bool leadingzero, out int numParsed)
            {
                long number = 0;
                int i;

                if (!leadingzero)
                {
                    int realDigits = 0;
                    for (i = valuePos; i < s.Length && i < digits + valuePos; i++)
                    {
                        if (!Char.IsDigit(s[i]))
                            break;

                        realDigits++;
                    }

                    digits = realDigits;
                }
                if (digits < minDigits)
                {
                    numParsed = -1;
                    return 0;
                }

                if (s.Length - valuePos < digits)
                {
                    numParsed = -1;
                    return 0;
                }

                for (i = valuePos; i < digits + valuePos; i++)
                {
                    char c = s[i];
                    if (!Char.IsDigit(c))
                    {
                        numParsed = -1;
                        return 0;
                    }

                    number = number * 10 + (byte) (c - '0');
                }

                numParsed = digits;
                return number;
            }

            private static int ParseEnum(string s, int sPos, string[] values, string[] invValues, bool exact, out int numParsed)
            {
                // FIXME: I know this is somehow lame code. Probably
                // it should iterate all the enum value and return
                // the longest match. However right now I don't see
                // anything but "1" and "10" - "12" that might match
                // two or more values. (They are only abbrev month
                // names, so do reverse order search). See bug #80094.
                for (int i = values.Length - 1; i >= 0; i--)
                {
                    if (!exact && invValues[i].Length > values[i].Length)
                    {
                        if (invValues[i].Length > 0 && ParseString(s, sPos, 0, invValues[i], out numParsed))
                            return i;
                        if (values[i].Length > 0 && ParseString(s, sPos, 0, values[i], out numParsed))
                            return i;
                    }
                    else
                    {
                        if (values[i].Length > 0 && ParseString(s, sPos, 0, values[i], out numParsed))
                            return i;
                        if (!exact && invValues[i].Length > 0 && ParseString(s, sPos, 0, invValues[i], out numParsed))
                            return i;
                    }
                }

                numParsed = -1;
                return -1;
            }

            private static bool ParseString(string s, int sPos, int maxlength, string value, out int numParsed)
            {
                if (maxlength <= 0)
                    maxlength = value.Length;

                if (sPos + maxlength <= s.Length && String.Compare(s, sPos, value, 0, maxlength, StringComparison.InvariantCultureIgnoreCase) == 0)
                {
                    numParsed = maxlength;
                    return true;
                }

                numParsed = -1;
                return false;
            }

            // Note that in case of Parse (exact == false) we check both for AM/PM
            // and the culture specific AM/PM strings.
            private static bool ParseAmPm(string s, int valuePos, int num, DateTimeFormatInfo dfi, bool exact, out int numParsed, ref int ampm)
            {
                numParsed = -1;
                if (ampm != -1)
                    return false;

                if (!IsLetter(s, valuePos))
                {
                    if (dfi.AMDesignator != "")
                        return false;
                    if (exact)
                        ampm = 0;
                    numParsed = 0;
                    return true;
                }
                DateTimeFormatInfo invInfo = DateTimeFormatInfo.InvariantInfo;
                if (!exact && ParseString(s, valuePos, num, invInfo.PMDesignator, out numParsed) ||
                    dfi.PMDesignator != "" && ParseString(s, valuePos, num, dfi.PMDesignator, out numParsed))
                    ampm = 1;
                else if (!exact && ParseString(s, valuePos, num, invInfo.AMDesignator, out numParsed) ||
                         ParseString(s, valuePos, num, dfi.AMDesignator, out numParsed))
                {
                    if (exact || numParsed != 0)
                        ampm = 0;
                }
                else
                    return false;
                return true;
            }

            // Note that in case of Parse (exact == false) we check both for ':'
            // and the culture specific TimeSperator
            private static bool ParseTimeSeparator(string s, int sPos, DateTimeFormatInfo dfi, bool exact, out int numParsed)
            {
#if SILVERLIGHT
                string timeSeparator = ":";
#else
                string timeSeparator = dfi.TimeSeparator;
#endif
                return ParseString(s, sPos, 0, timeSeparator, out numParsed) || !exact && ParseString(s, sPos, 0, ":", out numParsed);
            }

            // Accept any character for DateSeparator, except TimeSeparator,
            // a digit or a letter.
            // Not documented, but seems to be MS behaviour here.  See bug 54047.

            private static bool IsLetter(string s, int pos)
            {
                return pos < s.Length && Char.IsLetter(s[pos]);
            }

            // To implement better GregorianDate.Parse we use two format strings one
            // for Date and one for Time. This allows us to define two different
            // arrays of formats for Time and Dates and to combine them more or less
            // efficiently. When this mode is used flexibleTwoPartsParsing is true.
            private static bool DoParse(string s, string firstPart, string secondPart, bool exact, out GregorianDate result, DateTimeFormatInfo dfi,
                                        ref bool incompleteFormat, ref bool longYear)
            {
                bool useInvariant = false;
                bool flexibleTwoPartsParsing = !exact && secondPart != null;
                incompleteFormat = false;
                int valuePos = 0;
                string format = firstPart;
                bool afterTFormat = false;
                DateTimeFormatInfo invInfo = DateTimeFormatInfo.InvariantInfo;
                if (format.Length == 1)
                    format = GetStandardPattern(format[0], dfi, out useInvariant);

                result = new GregorianDate();
                if (format == null)
                    return false;

                if (useInvariant)
                    dfi = invInfo;

                string chars = format;
                int len = format.Length, pos = 0, num = 0;
                if (len == 0)
                    return false;

                int day = -1, dayofweek = -1, month = -1, year = -1;
                int hour = -1, minute = -1, second = -1;
                double fractionalSeconds = -1;
                int ampm = -1;
                bool isFirstPart = true;

                for (;;)
                {
                    if (valuePos == s.Length)
                        break;

                    int numParsed;
                    if (flexibleTwoPartsParsing && pos + num == 0)
                    {
                        bool isLetter = IsLetter(s, valuePos);
                        if (isLetter)
                        {
                            if (s[valuePos] == 'Z')
                                numParsed = 1;
                            else
                                ParseString(s, valuePos, 0, "GMT", out numParsed);
                            if (numParsed > 0 && !IsLetter(s, valuePos + numParsed))
                            {
                                valuePos += numParsed;
                                continue;
                            }
                        }
                        if (!afterTFormat && ParseAmPm(s, valuePos, 0, dfi, false, out numParsed, ref ampm))
                        {
                            if (IsLetter(s, valuePos + numParsed))
                                ampm = -1;
                            else if (numParsed > 0)
                            {
                                valuePos += numParsed;
                                continue;
                            }
                        }

                        if (!afterTFormat && dayofweek == -1 && isLetter)
                        {
                            dayofweek = ParseEnum(s, valuePos, dfi.DayNames, invInfo.DayNames, false, out numParsed);
                            if (dayofweek == -1)
                                dayofweek = ParseEnum(s, valuePos, dfi.AbbreviatedDayNames, invInfo.AbbreviatedDayNames, false, out numParsed);
                            if (dayofweek != -1 && !IsLetter(s, valuePos + numParsed))
                            {
                                valuePos += numParsed;
                                continue;
                            }

                            dayofweek = -1;
                        }

                        if (char.IsWhiteSpace(s[valuePos]) || s[valuePos] == ',')
                        {
                            valuePos += 1;
                            continue;
                        }
                    }

                    if (pos + num >= len)
                    {
                        if (flexibleTwoPartsParsing && num == 0)
                        {
                            afterTFormat = isFirstPart && firstPart[firstPart.Length - 1] == 'T';
                            if (!isFirstPart && format == "")
                                break;

                            pos = 0;
                            if (isFirstPart)
                                format = secondPart;
                            else
                                format = "";
                            chars = format;
                            len = chars.Length;
                            isFirstPart = false;
                            continue;
                        }
                        break;
                    }

                    if (chars[pos] == '\'')
                    {
                        num = 1;
                        while (pos + num < len)
                        {
                            if (chars[pos + num] == '\'')
                                break;

                            if (valuePos == s.Length || s[valuePos] != chars[pos + num])
                                return false;

                            valuePos++;
                            num++;
                        }

                        pos += num + 1;
                        num = 0;
                        continue;
                    }

                    if (chars[pos] == '"')
                    {
                        num = 1;
                        while (pos + num < len)
                        {
                            if (chars[pos + num] == '"')
                                break;

                            if (valuePos == s.Length || s[valuePos] != chars[pos + num])
                                return false;

                            valuePos++;
                            num++;
                        }

                        pos += num + 1;
                        num = 0;
                        continue;
                    }

                    if (chars[pos] == '\\')
                    {
                        pos += num + 1;
                        num = 0;
                        if (pos >= len)
                            return false;
                        if (s[valuePos] != chars[pos])
                            return false;

                        valuePos++;
                        pos++;
                        continue;
                    }

                    if (chars[pos] == '%')
                    {
                        pos++;
                        continue;
                    }

                    if (char.IsWhiteSpace(s[valuePos]) ||
                        s[valuePos] == ',' && (!exact && chars[pos] == '/' || Char.IsWhiteSpace(chars[pos])))
                    {
                        valuePos++;
                        num = 0;

                        int ws = valuePos;
                        while (ws < s.Length)
                        {
                            if (Char.IsWhiteSpace(s[ws]) || s[ws] == ',')
                                ws++;
                            else
                                break;
                        }
                        valuePos = ws;
                        ws = pos;
                        while (ws < chars.Length)
                        {
                            if (Char.IsWhiteSpace(chars[ws]) || chars[ws] == ',')
                                ws++;
                            else
                                break;
                        }
                        pos = ws;
                        // A whitespace may match a '/' in the pattern.
                        if (!exact && pos < chars.Length && chars[pos] == '/')
                            if (!ParseDateSeparator(s, valuePos, dfi, false, out numParsed))
                                pos++;
                        continue;
                    }

                    if ((pos + num + 1 < len) && (chars[pos + num + 1] == chars[pos + num]))
                    {
                        num++;
                        continue;
                    }

                    switch (chars[pos])
                    {
                        case 'd':
                            if (num < 2 && day != -1 || num >= 2 && dayofweek != -1)
                                return false;
                            if (num == 0)
                                day = (int) ParseNumber(s, valuePos, 1, 2, false, out numParsed);
                            else if (num == 1)
                                day = (int) ParseNumber(s, valuePos, 1, 2, true, out numParsed);
                            else if (num == 2)
                                dayofweek = ParseEnum(s, valuePos, dfi.AbbreviatedDayNames, invInfo.AbbreviatedDayNames, exact, out numParsed);
                            else
                                dayofweek = ParseEnum(s, valuePos, dfi.DayNames, invInfo.DayNames, exact, out numParsed);
                            break;
                        case 'M':
                            if (month != -1)
                                return false;

                            if (flexibleTwoPartsParsing)
                            {
                                numParsed = -1;
                                if (num == 0 || num == 3)
                                    month = (int) ParseNumber(s, valuePos, 1, 2, false, out numParsed);
                                if (num > 1 && numParsed == -1)
                                    month = ParseEnum(s, valuePos, dfi.MonthNames, invInfo.MonthNames, false, out numParsed) + 1;
                                if (num > 1 && numParsed == -1)
                                    month = ParseEnum(s, valuePos, dfi.AbbreviatedMonthNames, invInfo.AbbreviatedMonthNames, false, out numParsed) + 1;
                                break;
                            }

                            if (num == 0)
                                month = (int) ParseNumber(s, valuePos, 1, 2, false, out numParsed);
                            else if (num == 1)
                                month = (int) ParseNumber(s, valuePos, 1, 2, true, out numParsed);
                            else if (num == 2)
                                month = ParseEnum(s, valuePos, dfi.AbbreviatedMonthNames, invInfo.AbbreviatedMonthNames, exact, out numParsed) + 1;
                            else
                                month = ParseEnum(s, valuePos, dfi.MonthNames, invInfo.MonthNames, exact, out numParsed) + 1;
                            break;
                        case 'y':
                            if (year != -1)
                                return false;

                            if (num == 0)
                            {
                                year = (int) ParseNumber(s, valuePos, 1, 2, false, out numParsed);
                            }
                            else if (num < 3)
                            {
                                year = (int) ParseNumber(s, valuePos, 1, 2, true, out numParsed);
                            }
                            else
                            {
                                year = (int) ParseNumber(s, valuePos, exact ? 4 : 3, 4, false, out numParsed);
                                if ((year >= 1000) && (numParsed == 4) && (!longYear) && (s.Length > 4 + valuePos))
                                {
                                    int np;
                                    int ly = (int) ParseNumber(s, valuePos, 5, 5, false, out np);
                                    longYear = (ly > 9999);
                                }
                                num = 3;
                            }

                            //FIXME: We should do use dfi.Calendat.TwoDigitYearMax
                            if (numParsed <= 2)
                                year += (year < 30) ? 2000 : 1900;
                            break;
                        case 'h':
                            if (hour != -1)
                                return false;
                            if (num == 0)
                                hour = (int) ParseNumber(s, valuePos, 1, 2, false, out numParsed);
                            else
                                hour = (int) ParseNumber(s, valuePos, 1, 2, true, out numParsed);

                            if (hour > 12)
                                return false;
                            if (hour == 12)
                                hour = 0;

                            break;
                        case 'H':
                            if (hour != -1 || !flexibleTwoPartsParsing && ampm >= 0)
                                return false;
                            if (num == 0)
                                hour = (int) ParseNumber(s, valuePos, 1, 2, false, out numParsed);
                            else
                                hour = (int) ParseNumber(s, valuePos, 1, 2, true, out numParsed);

                            if (hour >= 24)
                                return false;

                            break;
                        case 'm':
                            if (minute != -1)
                                return false;
                            if (num == 0)
                                minute = (int) ParseNumber(s, valuePos, 1, 2, false, out numParsed);
                            else
                                minute = (int) ParseNumber(s, valuePos, 1, 2, true, out numParsed);

                            if (minute >= 60)
                                return false;

                            break;
                        case 's':
                            if (second != -1)
                                return false;
                            if (num == 0)
                                second = (int) ParseNumber(s, valuePos, 1, 2, false, out numParsed);
                            else
                                second = (int) ParseNumber(s, valuePos, 1, 2, true, out numParsed);

                            break;
                        case 'F':
                        case 'f':
                            bool leadingZeros = chars[pos] == 'f';

                            if (fractionalSeconds != -1)
                                return false;
                            double decimalNumber = ParseNumber(s, valuePos, 0, num + 1, leadingZeros, out numParsed);
                            if (numParsed == -1)
                                return false;
                            fractionalSeconds = decimalNumber / Math.Pow(10.0, numParsed);
                            break;
                        case 't':
                            if (!ParseAmPm(s, valuePos, num > 0 ? 0 : 1, dfi, exact, out numParsed, ref ampm))
                                return false;
                            break;
                        case ':':
                            if (!ParseTimeSeparator(s, valuePos, dfi, exact, out numParsed))
                                return false;
                            break;
                        case '/':
                            if (!ParseDateSeparator(s, valuePos, dfi, exact, out numParsed))
                                return false;

                            num = 0;
                            break;
                        default:
                            if (s[valuePos] != chars[pos])
                                return false;

                            num = 0;
                            numParsed = 1;
                            break;
                    }

                    if (numParsed < 0)
                        return false;

                    valuePos += numParsed;

                    if (!exact && !flexibleTwoPartsParsing)
                    {
                        switch (chars[pos])
                        {
                            case 'm':
                            case 's':
                            case 'F':
                            case 'f':
                            case 'z':
                                if (s.Length > valuePos && s[valuePos] == 'Z' &&
                                    (pos + 1 == chars.Length || chars[pos + 1] != 'Z'))
                                {
                                    valuePos++;
                                }
                                break;
                        }
                    }

                    pos = pos + num + 1;
                    num = 0;
                }

                if (pos + 1 < len && chars[pos] == '.' && chars[pos + 1] == 'F')
                {
                    pos++;
                    while (pos < len && chars[pos] == 'F') // '.FFF....' can be mapped to nothing. See bug #444103
                        pos++;
                }
                while (pos < len && chars[pos] == 'K') // 'K' can be mapped to nothing
                    pos++;
                if (pos < len)
                    return false;

                if (s.Length > valuePos) // extraneous tail.
                {
                    if (valuePos == 0)
                        return false;

                    if (Char.IsDigit(s[valuePos]) && Char.IsDigit(s[valuePos - 1]))
                        return false;
                    if (Char.IsLetter(s[valuePos]) && Char.IsLetter(s[valuePos - 1]))
                        return false;
                    incompleteFormat = true;
                    return false;
                }

                if (hour == -1)
                    hour = 0;
                if (minute == -1)
                    minute = 0;

                if (second == -1)
                    second = 0;
                if (fractionalSeconds == -1)
                    fractionalSeconds = 0;

                // If no date was given
                if ((day == -1) && (month == -1) && (year == -1))
                {
                    day = DateTime.Today.Day;
                    month = DateTime.Today.Month;
                    year = DateTime.Today.Year;
                }

                if (day == -1)
                    day = 1;
                if (month == -1)
                    month = 1;
                if (year == -1)
                {
                    year = DateTime.Today.Year;
                }

                if (ampm == 0 && hour == 12)
                    hour = 0;

                if (ampm == 1 && (!flexibleTwoPartsParsing || hour < 12))
                    hour = hour + 12;

                try
                {
                    result = new GregorianDate(year, month, day, hour, minute, second + fractionalSeconds);
                }
                catch (ArgumentException)
                {
                    return false;
                }

                return true;
            }

            private static string GetStandardPattern(char format, DateTimeFormatInfo dfi, out bool useInvariant)
            {
                string pattern;

                useInvariant = false;

                switch (format)
                {
                    case 'd':
                        pattern = dfi.ShortDatePattern;
                        break;
                    case 'D':
                        pattern = dfi.LongDatePattern;
                        break;
                    case 'f':
                        pattern = dfi.LongDatePattern + " " + dfi.ShortTimePattern;
                        break;
                    case 'F':
                        pattern = dfi.FullDateTimePattern;
                        break;
                    case 'g':
                        pattern = dfi.ShortDatePattern + " " + dfi.ShortTimePattern;
                        break;
                    case 'G':
                        pattern = dfi.ShortDatePattern + " " + dfi.LongTimePattern;
                        break;
                    case 'm':
                    case 'M':
                        pattern = dfi.MonthDayPattern;
                        break;
                    case 'r':
                    case 'R':
                        pattern = dfi.RFC1123Pattern;
                        useInvariant = true;
                        break;
                    case 's':
                        pattern = dfi.SortableDateTimePattern;
                        useInvariant = true;
                        break;
                    case 't':
                        pattern = dfi.ShortTimePattern;
                        break;
                    case 'T':
                        pattern = dfi.LongTimePattern;
                        break;
                    case 'u':
                        pattern = dfi.UniversalSortableDateTimePattern;
                        useInvariant = true;
                        break;
                    case 'U':
                        pattern = dfi.FullDateTimePattern;
                        break;
                    case 'y':
                    case 'Y':
                        pattern = dfi.YearMonthPattern;
                        break;
                    default:
                        pattern = null;
                        break;
                }

                return pattern;
            }

            private static int CountRepeat(string fmt, int p, char c)
            {
                int l = fmt.Length;
                int i = p + 1;
                while ((i < l) && (fmt[i] == c))
                    i++;

                return i - p;
            }

            private static void ZeroPad(StringBuilder output, long digits, int len)
            {
                // more than enough for an int
                char[] buffer = new char[16];
                int pos = 16;

                do
                {
                    buffer[--pos] = (char) ('0' + digits % 10);
                    digits /= 10;
                    len--;
                } while (digits > 0);

                while (len-- > 0)
                    buffer[--pos] = '0';

                output.Append(new string(buffer, pos, 16 - pos));
            }

            private static int ParseQuotedString(string fmt, int pos, StringBuilder output)
            {
                // pos == position of " or '

                int len = fmt.Length;
                int start = pos;
                char quoteChar = fmt[pos++];

                while (pos < len)
                {
                    char ch = fmt[pos++];

                    if (ch == quoteChar)
                        return pos - start;

                    if (ch == '\\')
                    {
                        // C-Style escape
                        if (pos >= len)
                            throw new FormatException(CesiumLocalization.GregorianDateQuoteNotTerminated);

                        output.Append(fmt[pos++]);
                    }
                    else
                    {
                        output.Append(ch);
                    }
                }

                throw new FormatException(CesiumLocalization.GregorianDateQuoteNotTerminated);
            }

            // This is intended as a last resort when all the other formats fail to parse a "day of year" format
            // This will throw exceptions if it cannot parse the string
            private static bool ParseIso8601DayOfYear(string isoString, DateTimeFormatInfo dfi, out GregorianDate result, 
                bool setExceptionOnError, ref FormatException exception)
            {
                // This is a last resort case to handle the ISO8601 "day of year" format supported by STK
                // Format: yyyy-dddTHH:mm:ss.f*

                result = default(GregorianDate);
                string[] tokens = isoString.Split('-');
                if (tokens.Length < 2)
                {
                    // In this case we simply have no idea what this format is.
                    // Defer the exception to the surrounding code
                    return false;
                }

                int yr4;
                if (tokens[0].Length != 4 || !int.TryParse(tokens[0], out yr4))
                {
                    exception = new FormatException(string.Format(CesiumLocalization.GregorianDateStringNotRecognized, isoString));
                    if (setExceptionOnError)
                        return false;
                    else
                        throw exception;
                }
                tokens = tokens[1].Split('T');
                int doy;
                // The 366 out-of-range check below will handle cases where there are 4 or more digits
                if (!int.TryParse(tokens[0], out doy))
                {
                    exception = new FormatException(string.Format(CesiumLocalization.GregorianDateStringNotRecognized, isoString));
                    if (setExceptionOnError)
                        return false;
                    else
                        throw exception;
                }

                if (doy > 366)
                {
                    exception = new FormatException(string.Format(CesiumLocalization.DayOfYearOutOfRange, isoString));
                    if (setExceptionOnError)
                        return false;
                    else
                        throw exception;
                }

                if (tokens.Length > 1)
                {
                    // Let the existing code handle the time portion
                    bool incompleteFormat = true, longYear = false;
                    for (int j = 0; j < s_parseTimeFormats.Length; j++)
                    {
                        if (DoParse(tokens[1], s_parseTimeFormats[j], null, false, out result, dfi, ref incompleteFormat, ref longYear))
                            break;
                    }
                }

                result = new GregorianDate(yr4, doy, result.Hour, result.Minute, result.Second);
                return true;
            }

            public static string ToString(GregorianDate dt, string format, IFormatProvider provider)
            {
                DateTimeFormatInfo dfi = DateTimeFormatInfo.GetInstance(provider);

                if (string.IsNullOrEmpty(format))
                    format = "G";

                bool useInvariant = false;

                if (format.Length == 1)
                {
                    char fchar = format[0];
                    format = GetStandardPattern(fchar, dfi, out useInvariant);

                    if (format == null)
                        throw new FormatException(string.Format(CesiumLocalization.GregorianDateInvalidFormatSpecifier, fchar));
                }

                // the length of the format is usually a good guess of the number
                // of chars in the result. Might save us a few bytes sometimes
                // Add + 10 for cases like mmmm dddd
                StringBuilder result = new StringBuilder(format.Length + 10);

                // For some cases, the output should not use culture dependent calendar
                if (useInvariant)
                    dfi = DateTimeFormatInfo.InvariantInfo;

                int i = 0;

                while (i < format.Length)
                {
                    int tokLen;
                    char ch = format[i];

                    switch (ch)
                    {
                            //
                            // Time Formats
                            //
                        case 'h':
                            // hour, [1, 12]
                            tokLen = CountRepeat(format, i, ch);

                            int hr = dt.Hour % 12;
                            if (hr == 0)
                                hr = 12;

                            ZeroPad(result, hr, tokLen == 1 ? 1 : 2);
                            break;
                        case 'H':
                            // hour, [0, 23]
                            tokLen = CountRepeat(format, i, ch);
                            ZeroPad(result, dt.Hour, tokLen == 1 ? 1 : 2);
                            break;
                        case 'm':
                            // minute, [0, 59]
                            tokLen = CountRepeat(format, i, ch);
                            ZeroPad(result, dt.Minute, tokLen == 1 ? 1 : 2);
                            break;
                        case 's':
                            // second [0, 29]
                            tokLen = CountRepeat(format, i, ch);
                            ZeroPad(result, (int)dt.Second, tokLen == 1 ? 1 : 2);
                            break;
                        case 'F':
                        case 'f':
                            // fraction of second, to same number of
                            // digits as there are f's
                            tokLen = CountRepeat(format, i, ch);

                            if (tokLen > 15)
                                throw new FormatException(CesiumLocalization.GregorianDateFormatInvalid);

                            int startLen = result.Length;

                            double fraction = Math.Round(dt.Second - (int)dt.Second, tokLen);
                            long number = (long) (fraction * Math.Pow(10, tokLen));

                            ZeroPad(result, number, tokLen);

                            if (ch == 'F')
                            {
                                while (result.Length > startLen && result[result.Length - 1] == '0')
                                    result.Length = result.Length - 1;
                                // when the value was 0, then trim even preceding '.' (!) It is fixed character.
                                if (number == 0 && startLen > 0 && result[startLen - 1] == '.')
                                    result.Length = result.Length - 1;
                            }

                            break;
                        case 't':
                            // AM/PM. t == first char, tt+ == full
                            tokLen = CountRepeat(format, i, ch);
                            string desig = dt.Hour < 12 ? dfi.AMDesignator : dfi.PMDesignator;

                            if (tokLen == 1)
                            {
                                if (desig.Length >= 1)
                                    result.Append(desig[0]);
                            }
                            else
                                result.Append(desig);

                            break;
                            //
                            // Date tokens
                            //
                        case 'd':
                            // day. d(d?) = day of month (leading 0 if two d's)
                            // ddd = three leter day of week
                            // dddd+ full day-of-week
                            tokLen = CountRepeat(format, i, ch);

                            if (tokLen <= 2)
                                ZeroPad(result, dt.Day, tokLen == 1 ? 1 : 2);
                            else if (tokLen == 3)
                                result.Append(dfi.GetAbbreviatedDayName(dt.DayOfWeek));
                            else
                                result.Append(dfi.GetDayName(dt.DayOfWeek));

                            break;
                        case 'M':
                            // Month.m(m?) = month # (with leading 0 if two mm)
                            // mmm = 3 letter name
                            // mmmm+ = full name
                            tokLen = CountRepeat(format, i, ch);
                            int month = dt.Month;
                            if (tokLen <= 2)
                                ZeroPad(result, month, tokLen);
                            else if (tokLen == 3)
                                result.Append(dfi.GetAbbreviatedMonthName(month));
                            else
                                result.Append(dfi.GetMonthName(month));

                            break;
                        case 'y':
                            // Year. y(y?) = two digit year, with leading 0 if yy
                            // yyy+ full year with leading zeros if needed.
                            tokLen = CountRepeat(format, i, ch);

                            if (tokLen <= 2)
                                ZeroPad(result, dt.Year % 100, tokLen);
                            else
                                ZeroPad(result, dt.Year, tokLen);
                            break;

                        case 'g':
                            // Era name
                            tokLen = CountRepeat(format, i, ch);
                            result.Append(dfi.GetEraName(1));
                            break;

                            //
                            // Other
                            //
                        case ':':
#if SILVERLIGHT
                            result.Append(":");
#else
                            result.Append(dfi.TimeSeparator);
#endif
                            tokLen = 1;
                            break;
                        case '/':
#if SILVERLIGHT
                            result.Append("/");
#else
                            result.Append(dfi.DateSeparator);
#endif
                            tokLen = 1;
                            break;
                        case '\'':
                        case '"':
                            tokLen = ParseQuotedString(format, i, result);
                            break;
                        case '%':
                            if (i >= format.Length - 1)
                                throw new FormatException(string.Format(CesiumLocalization.GregorianDateInvalidCharacterAtEnd, "%"));
                            if (format[i + 1] == '%')
                                throw new FormatException(string.Format(CesiumLocalization.GregorianDateInvalidCharacter, "%%"));

                            // Look for the next char
                            tokLen = 1;
                            break;
                        case '\\':
                            // C-Style escape
                            if (i >= format.Length - 1)
                                throw new FormatException(string.Format(CesiumLocalization.GregorianDateInvalidCharacterAtEnd, "\\"));

                            result.Append(format[i + 1]);
                            tokLen = 2;

                            break;
                        default:
                            // catch all
                            result.Append(ch);
                            tokLen = 1;
                            break;
                    }
                    i += tokLen;
                }
                return result.ToString();
            }
        }

        /// <summary>
        /// Initializes a <see cref="GregorianDate"/> from the provided values.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="month">The month of the year (in the range 1 through 12)</param>
        /// <param name="day">The day of the month (in the range 1 through the number of
        /// days in <paramref name="month"/>)</param>
        /// <param name="hour">The hour (in the range 0 through 23).</param>
        /// <param name="minute">The minute (in the range 0 through 59).</param>
        /// <param name="second">The second, including fractional seconds (in the range 0.0
        /// up to, but not including, 61.0).  A second between 60.0 and 61.0 (a leap
        /// second) is only valid if the overall time is during one of the official leap
        /// seconds. </param>
        /// <exception cref="ArgumentException">
        /// Thrown when one of the provided parameters is outside of its acceptable range.
        /// </exception>
        public GregorianDate(int year, int month, int day, int hour, int minute, double second)
        {
            if (IsValid(year, month, day, hour, minute, second))
            {
                m_yearMonthDay = new YearMonthDay(year, month, day);

                m_hour = hour;
                m_minute = minute;
                m_second = second;
            }
            else
            {
                throw new ArgumentException(CesiumLocalization.HourMinuteSecondInvalidArgument);
            }
        }

        /// <summary>
        /// Initializes a <see cref="GregorianDate"/> from the provided values.  The
        /// remaining values are assumed to be zero.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="month">The month of the year (in the range 1 through 12)</param>
        /// <param name="day">The day of the month (in the range 1 through the number of
        /// days in <paramref name="month"/>)</param>
        /// <exception cref="ArgumentException">
        /// Thrown when one of the provided parameters is outside of its acceptable range.
        /// </exception>
        public GregorianDate(int year, int month, int day) : this(year, month, day, 0, 0, 0)
        {
        }

        /// <summary>
        /// Initializes a <see cref="GregorianDate"/> from the provided values.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="dayOfYear">The day of year
        /// (in the range 1 through the number of days in the given year).</param>
        /// <param name="hour">The hour (in the range 0 through 23).</param>
        /// <param name="minute">The minute (in the range 0 through 59).</param>
        /// <param name="second">The second, including fractional seconds (in the range 0.0
        /// up to, but not including, 61.0).  A second between 60.0 and 61.0 (a leap
        /// second) is only valid if the overall time is during one of the official leap
        /// seconds. </param>
        /// <exception cref="ArgumentException">
        /// Thrown when one of the provided parameters is outside of its acceptable range.
        /// </exception>
        public GregorianDate(int year, int dayOfYear, int hour, int minute, double second)
        {
            YearMonthDay ymd = new YearMonthDay(year, dayOfYear);
            if (IsValid(year, ymd.Month, ymd.Day, hour, minute, second))
            {
                m_yearMonthDay = ymd;
                m_hour = hour;
                m_minute = minute;
                m_second = second;
            }
            else
            {
                throw new ArgumentException(CesiumLocalization.HourMinuteSecondInvalidArgument);
            }
        }

        /// <summary>
        /// Initializes a <see cref="GregorianDate"/> from the provided values.  The
        /// fractional portion of the <paramref name="daysOfYear"/> will be converted into
        /// hours, minutes, and seconds.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="daysOfYear">The day of year plus the fractional portion of the day 
        /// (in the range 1 through the number of days in the given year).</param>
        public GregorianDate(int year, double daysOfYear)
        {
            m_yearMonthDay = new YearMonthDay(year, (int)daysOfYear);

            double fraction = daysOfYear % 1;
            double seconds = fraction * 86400.0;

            m_hour = (int)(seconds / SecondsPerHour);
            seconds -= m_hour * SecondsPerHour;
            m_minute = (int)(seconds / SecondsPerMinute);
            seconds -= m_minute * SecondsPerMinute;
            m_second = seconds;
        }

        /// <summary>
        /// Initializes a <see cref="GregorianDate"/> from the provided 
        /// <see cref="JulianDate"/>.  The new <see cref="GregorianDate"/> will be in the
        /// <see cref="TimeStandard.CoordinatedUniversalTime"/> (UTC) time standard.
        /// </summary>
        /// <param name="julianDate">The <see cref="JulianDate"/>.</param>
        public GregorianDate(JulianDate julianDate) :
            this(julianDate, TimeStandard.CoordinatedUniversalTime)
        {     
        }

        /// <summary>
        /// Initializes a <see cref="GregorianDate"/> from the provided 
        /// <see cref="JulianDate"/>.  The new <see cref="GregorianDate"/> will be in the
        /// provided <see cref="TimeStandard"/>.
        /// </summary>
        /// <param name="julianDate">The <see cref="JulianDate"/>.</param>
        /// <param name="timeStandard">
        /// The <see cref="TimeStandard"/> to represent the new <see cref="GregorianDate"/>
        /// in.
        /// </param>
        public GregorianDate(JulianDate julianDate, TimeStandard timeStandard)
        {
            bool isLeapSecond = false;
            JulianDate convertedJulianDate;
            if (!julianDate.TryConvertTimeStandard(timeStandard, out convertedJulianDate))
            {
                isLeapSecond = true;
                convertedJulianDate = julianDate.SubtractSeconds(1).ToTimeStandard(timeStandard);
            }

            m_yearMonthDay = new YearMonthDay(convertedJulianDate);
            double secondsOfDay = convertedJulianDate.SecondsOfDay;

            m_hour = (int)Math.Floor(secondsOfDay / SecondsPerHour);

            double remainingSeconds = secondsOfDay - (m_hour * SecondsPerHour);
            m_minute = (int)Math.Floor(remainingSeconds / SecondsPerMinute);

            m_second = secondsOfDay - ((m_hour * SecondsPerHour) + (m_minute * SecondsPerMinute));

            if (isLeapSecond)
                m_second += 1;

            // JulianDates are noon-based
            m_hour += 12;
            if (m_hour > 23)
                m_hour -= 24;
        }

        /// <summary>
        /// Initializes a <see cref="GregorianDate"/> from the provided 
        /// <see cref="DateTime"/>.  If the provided <see cref="DateTime"/> is in local
        /// time, it is converted to UTC.
        /// </summary>
        /// <param name="dateTime">The <see cref="DateTime"/>.</param>
        public GregorianDate(DateTime dateTime)
        {
            if (dateTime.Kind == DateTimeKind.Local)
            {
                dateTime = dateTime.ToUniversalTime();
            }

            m_yearMonthDay = new YearMonthDay(dateTime.Year, dateTime.Month, dateTime.Day);

            m_hour = dateTime.Hour;
            m_minute = dateTime.Minute;

            const long ticksPerMinute = 600000000L;
            const double ticksPerSecond = 1.0e7;
            m_second = (dateTime.Ticks % ticksPerMinute) / ticksPerSecond;
        }

        /// <summary>
        /// Gets the year.
        /// </summary>
        public int Year
        {
            get { return m_yearMonthDay.Year; }
        }

        /// <summary>
        /// Gets the month of the year (in the range 1 through 12).
        /// </summary>
        public int Month
        {
            get { return m_yearMonthDay.Month; }
        }

        /// <summary>
        /// Gets the day of the month (in the range 1 through the number of days in the
        /// month).
        /// </summary>
        public int Day
        {
            get { return m_yearMonthDay.Day; }
        }

        /// <summary>
        /// Gets the hour (in the range 0 through 23).
        /// </summary>
        public int Hour
        {
            get { return m_hour; }
        }

        /// <summary>
        /// Gets the minute (in the range 0 through 59).
        /// </summary>
        public int Minute
        {
            get { return m_minute; }
        }

        /// <summary>
        /// Gets the second, including fractional seconds (in the range 0.0 up to, but not
        /// including, 61.0).  A value between 60.0 and 61.0 indicates a leap second.
        /// </summary>
        public double Second
        {
            get { return m_second; }
        }

        /// <summary>
        /// Gets the corresponding seconds past noon for this instance.
        /// </summary>
        public double JulianSecondsOfDay
        {
            get
            {
                // JulianDates are noon-based
                int hour = Hour - 12;
                if (hour < 0)
                    hour += 24;

                return Second + ((hour * SecondsPerHour) + (Minute * SecondsPerMinute));
            }
        }

        /// <summary>Gets the day of the week represented by this instance.</summary>
        /// <returns>A <see cref="DayOfWeek" /> enumerated constant that indicates the day
        /// of the week. This property value ranges from zero, indicating Sunday, to six,
        /// indicating Saturday.</returns>
        public DayOfWeek DayOfWeek
        {
            get { return m_yearMonthDay.DayOfWeek; }
        }

        /// <summary>Gets the day of the year represented by this instance.</summary>
        /// <returns>An integer that indicates the day of the year.
        /// This property value ranges from 1 through the number of days in the year.</returns>
        public int DayOfYear
        {
            get { return m_yearMonthDay.DayOfYear; }
        }

        /// <summary>
        /// Indicates whether or not this <see cref="GregorianDate"/> represents a leap
        /// second.
        /// </summary>
        private bool IsLeapSecond
        {
            get { return Second >= 60.0; }
        }

        /// <summary>
        /// Indicates whether the date values provided are a valid representation of a date
        /// and time.
        /// </summary>
        /// <param name="year">The year.</param>
        /// <param name="month">The month of the year (in the range 1 through 12)</param>
        /// <param name="day">The day of the month (in the range 1 through the number of
        /// days in <paramref name="month"/>)</param>
        /// <param name="hour">The hour (in the range 0 through 23).</param>
        /// <param name="minute">The minute (in the range 0 through 59).</param>
        /// <param name="second">The second, including fractional seconds (in the range 0.0
        /// up to, but not including, 61.0).  A second between 60.0 and 61.0 (a leap
        /// second) is only valid if the overall time is during one of the official leap
        /// seconds. </param>
        /// <returns>true if the representation is valid and false if it is not.</returns>
        public static bool IsValid(int year, int month, int day, int hour, int minute, double second)
        {
            bool hourInvalid = hour < 0 || hour >= 24;
            bool minuteInvalid = minute < 0 || minute >= 60;
            bool secondInvalid = second < 0 || second >= 61;

            if (hourInvalid || minuteInvalid || secondInvalid)
                return false;

            if (!YearMonthDay.IsValidDate(year, month, day))
                return false;

            if (second >= 60 && second < 61)
            {
                //check to see if it's a valid leap second
                bool dayHasLeapSecond = LeapSeconds.Instance.DoesDayHaveLeapSecond(new YearMonthDay(year, month, day).JulianDayNumber);
                return dayHasLeapSecond && hour == 23 && minute == 59;
            }

            return true;
        }

        ///<summary>
        /// Convert this <see cref="GregorianDate"/> to a <see cref="JulianDate"/>. The
        /// time standard will be <see cref="TimeStandard.CoordinatedUniversalTime"/>
        /// (UTC), unless this  <see cref="GregorianDate"/> represents the instant of a
        /// leap second, in which case the <see cref="JulianDate"/> will be in 
        /// <see cref="TimeStandard.InternationalAtomicTime"/> (TAI).
        ///</summary>
        ///<returns>A <see cref="JulianDate"/> representing this date.</returns>
        public JulianDate ToJulianDate()
        {
            return ToJulianDate(TimeStandard.CoordinatedUniversalTime);
        }

        ///<summary>
        /// Convert this <see cref="GregorianDate"/> to a <see cref="JulianDate"/>.  The
        /// <see cref="GregorianDate"/> is assumed to specify a time in the
        /// specified <see cref="TimeStandard"/>.
        ///</summary>
        ///<param name="timeStandard">
        ///The time standard in which this <see cref="GregorianDate"/> is expressed.  The returned
        ///<see cref="JulianDate"/> will be expressed in this time standard as well, if possible.
        ///</param>
        ///<returns>A <see cref="JulianDate"/> representing this date.</returns>
        public JulianDate ToJulianDate(TimeStandard timeStandard)
        {
            int julianDayNumber = m_yearMonthDay.JulianDayNumber;
            double julianSecondsOfDay = JulianSecondsOfDay;

            if (IsLeapSecond)
                julianSecondsOfDay -= 1;
            else if (julianSecondsOfDay >= 43200.0)
                julianDayNumber -= 1;

            JulianDate result = new JulianDate(julianDayNumber, julianSecondsOfDay, timeStandard);

            if (IsLeapSecond)
                result = result.AddSeconds(1);

            return result;
        }

        ///<summary>Convert this <see cref="GregorianDate"/> to a <see cref="DateTime"/>. 
        ///The <see cref="DateTime"/> will be in UTC.
        ///</summary>
        ///<returns>A <see cref="DateTime"/> representing this date.</returns>
        public DateTime ToDateTime()
        {
            DateTime date = new DateTime(m_yearMonthDay.Year, m_yearMonthDay.Month, m_yearMonthDay.Day);
            const long ticksPerHour = 36000000000L;
            const long ticksPerMinute = 600000000L;
            const long ticksPerSecond = 10000000L;

            long ticks = date.Ticks;
            ticks += m_hour * ticksPerHour;
            ticks += m_minute * ticksPerMinute;
            ticks += (long) (Math.Round(m_second, 7) * ticksPerSecond);

            return new DateTime(ticks, DateTimeKind.Utc);
        }

        /// <summary>
        /// Compares this instance with another instance of the same type.
        /// </summary>
        /// <param name="other">An object to compare with this instance.</param>
        /// <returns>
        /// A value indicating the relative order of the objects being compared.  The return value has these meanings:
        /// <list type="table">
        ///   <listheader>
        ///     <term>Value</term>
        ///     <description>Meaning</description>
        ///   </listheader>
        ///   <item>
        ///     <term>Less than zero</term>
        ///     <description>
        ///       This instance is less than <paramref name="other"/>.
        ///     </description>
        ///   </item>
        ///   <item>
        ///     <term>Zero</term>
        ///     <description>
        ///       This instance is equal to <paramref name="other"/>.
        ///     </description>
        ///   </item>
        ///   <item>
        ///     <term>Greater than zero</term>
        ///     <description>
        ///       This instance is greater than <paramref name="other"/>.
        ///     </description>
        ///   </item>
        /// </list>
        /// </returns>
        public int CompareTo(GregorianDate other)
        {
            int result = m_yearMonthDay.CompareTo(other.m_yearMonthDay);

            if (result == 0)
            {
                if (Hour != other.Hour)
                {
                    return Hour < other.Hour ? -1 : 1;
                }

                if (Minute != other.Minute)
                {
                    return Minute < other.Minute ? -1 : 1;
                }

                return Second == other.Second ? 0 : (Second < other.Second ? -1 : 1);
            }
            return result;
        }

        /// <summary>
        /// Compares this instance with another instance of the same type.
        /// </summary>
        /// <param name="obj">An object to compare with this instance.</param>
        /// <returns>
        /// A value indicating the relative order of the objects being compared.  The return value has these meanings:
        /// <list type="table">
        ///   <listheader>
        ///     <term>Value</term>
        ///     <description>Meaning</description>
        ///   </listheader>
        ///   <item>
        ///     <term>Less than zero</term>
        ///     <description>
        ///       This instance is less than <paramref name="obj"/>.
        ///     </description>
        ///   </item>
        ///   <item>
        ///     <term>Zero</term>
        ///     <description>
        ///       This instance is equal to <paramref name="obj"/>.
        ///     </description>
        ///   </item>
        ///   <item>
        ///     <term>Greater than zero</term>
        ///     <description>
        ///       This instance is greater than <paramref name="obj"/>.
        ///     </description>
        ///   </item>
        /// </list>
        /// </returns>
        [CSToJavaExclude("The T in Comparable<T> in Java prevents having an Object overload.")]
        public int CompareTo(object obj)
        {
            if (obj == null)
            {
                return 1;
            }

            if (!(obj is GregorianDate))
            {
                throw new ArgumentException(CesiumLocalization.ArgumentTypeInvalid, "obj");
            }

            return CompareTo((GregorianDate) obj);
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_yearMonthDay.GetHashCode() ^ Hour.GetHashCode() ^ Minute.GetHashCode() ^ Second.GetHashCode();
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(GregorianDate other)
        {
            return CompareTo(other) == 0;
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            if (obj is GregorianDate)
            {
                return Equals((GregorianDate) obj);
            }
            return false;
        }

        /// <summary>Converts the value of this instance to its equivalent string
        /// representation.</summary>
        /// <returns>A string representation of value of this instance.</returns>
        public override string ToString()
        {
            return ToString(null, null);
        }

        /// <summary>Converts the value of this instance to its equivalent string
        /// representation using the specified format.</summary>
        /// <returns>A string representation of value of this instance as specified by
        /// <paramref name="format"/>.</returns>
        /// <param name="format">A format string. </param>
        /// <exception cref="FormatException">The length of <paramref name="format"/> is 1,
        /// and it is not one of the format specifier characters defined for 
        /// <see cref="DateTimeFormatInfo"/>.-or- <paramref name="format"/> does not
        /// contain a valid custom format pattern. </exception>
        public string ToString(string format)
        {
            return ToString(format, null);
        }

        /// <summary>Converts the value of this instance to its equivalent string
        /// representation using the specified culture-specific format information.
        /// </summary>
        /// <returns>A string representation of value of this instance as specified by
        /// <paramref name="provider"/>.</returns>
        /// <param name="provider">An <see cref="IFormatProvider"/> that supplies
        /// culture-specific formatting information. </param>
        public string ToString(IFormatProvider provider)
        {
            return ToString(null, provider);
        }

        /// <summary>Converts the value of this instance to its equivalent string
        /// representation using the specified format and culture-specific format
        /// information.</summary>
        /// <returns>A string representation of value of this instance as specified by
        /// <paramref name="format"/> and <paramref name="provider"/>.</returns>
        /// <param name="format">A format string. </param>
        /// <param name="provider">An <see cref="IFormatProvider"/> that supplies
        /// culture-specific formatting information. </param>
        /// <exception cref="FormatException">The length of <paramref name="format"/> is 1,
        /// and it is not one of the format specifier characters defined for 
        /// <see cref="DateTimeFormatInfo" />.-or- <paramref name="format"/> does not
        /// contain a valid custom format pattern. </exception>
        public string ToString(string format, IFormatProvider provider)
        {
            return Parser.ToString(this, format, provider);
        }

        /// <summary>
        /// Converts the value of this instance to its equivalent ISO8601 string representation,
        /// corresponding to year month day hours minutes and seconds with seconds
        /// represented to machine precision.
        /// </summary>
        /// <returns>A string representing this date and time in ISO8601 format.</returns>
        public string ToIso8601String()
        {
            return ToIso8601String(Iso8601Format.Extended);
        }

        /// <summary>
        /// Converts the value of this instance to its equivalent ISO8601 string representation,
        /// corresponding to year month day hours minutes and seconds with seconds
        /// represented to machine precision.
        /// </summary>
        /// <param name="format">The type of ISO9601 string to create.</param>
        /// <returns>A string representing this date and time in ISO8601 format.</returns>
        public string ToIso8601String(Iso8601Format format)
        {
            switch (format)
            {
                case Iso8601Format.Basic:
                    return string.Format(CultureInfo.InvariantCulture, "{0:0000}{1:00}{2:00}T{3:00}{4:00}{5:00.###############}Z",
                        m_yearMonthDay.Year, m_yearMonthDay.Month, m_yearMonthDay.Day, m_hour, m_minute, m_second);
                case Iso8601Format.Extended:
                    return string.Format(CultureInfo.InvariantCulture, "{0:0000}-{1:00}-{2:00}T{3:00}:{4:00}:{5:00.###############}Z",
                        m_yearMonthDay.Year, m_yearMonthDay.Month, m_yearMonthDay.Day, m_hour, m_minute, m_second);
                case Iso8601Format.Compact:
                    {
                        if (m_second != 0)
                            return string.Format(CultureInfo.InvariantCulture, "{0:0000}{1:00}{2:00}T{3:00}{4:00}{5:00.###############}Z",
                                m_yearMonthDay.Year, m_yearMonthDay.Month, m_yearMonthDay.Day, m_hour, m_minute, m_second);

                        if (m_minute != 0)
                            return string.Format(CultureInfo.InvariantCulture, "{0:0000}{1:00}{2:00}T{3:00}{4:00}Z",
                                m_yearMonthDay.Year, m_yearMonthDay.Month, m_yearMonthDay.Day, m_hour, m_minute);

                        return string.Format(CultureInfo.InvariantCulture, "{0:0000}{1:00}{2:00}T{3:00}Z",
                            m_yearMonthDay.Year, m_yearMonthDay.Month, m_yearMonthDay.Day, m_hour);
                    }
            }

            throw new InvalidOperationException();
        }

        /// <summary>Converts the value of this instance to its equivalent long date string representation.</summary>
        /// <returns>A string containing the name of the day of the week, the name of the month, the numeric day of the month, and the year equivalent to the date value of this instance.</returns>
        public string ToLongDateString()
        {
            return ToString("D");
        }

        /// <summary>Converts the value of this instance to its equivalent long time string
        /// representation.</summary>
        /// <returns>A string containing the name of the day of the week, the name of the
        /// month, the numeric day of the hours, minutes, and seconds equivalent to the
        /// time value of this instance.</returns>
        public string ToLongTimeString()
        {
            return ToString("T");
        }

        /// <summary>Converts the value of this instance to its equivalent short date
        /// string representation.</summary>
        /// <returns>A string containing the numeric month, the numeric day of the month,
        /// and the year equivalent to the date value of this instance.</returns>
        public string ToShortDateString()
        {
            return ToString("d");
        }

        /// <summary>Converts the value of this instance to its equivalent short time
        /// string representation.</summary>
        /// <returns>A string containing the name of the day of the week, the name of the
        /// month, the numeric day of the hours, minutes, and seconds equivalent to the
        /// time value of this instance.</returns>
        public string ToShortTimeString()
        {
            return ToString("t");
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(GregorianDate left, GregorianDate right)
        {
            return left.Equals(right);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are not exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> does not represent the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator !=(GregorianDate left, GregorianDate right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is less than <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> is less than <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator <(GregorianDate left, GregorianDate right)
        {
            return left.CompareTo(right) < 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is greater than <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> is greater than <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator >(GregorianDate left, GregorianDate right)
        {
            return left.CompareTo(right) > 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is less than or equal to <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> is less than or equal to <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator <=(GregorianDate left, GregorianDate right)
        {
            return left.CompareTo(right) <= 0;
        }

        /// <summary>
        /// Returns <see langword="true"/> if <paramref name="left"/> is greater than or equal to <paramref name="right"/>.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> is greater than or equal to <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator >=(GregorianDate left, GregorianDate right)
        {
            return left.CompareTo(right) >= 0;
        }

        /// <summary>
        /// Converts the specified string representation of a date and time to its
        /// <see cref="GregorianDate" /> equivalent.
        /// 
        /// Note: <see cref="GregorianDate"/> is always assumed to be in UTC.  You cannot
        /// parse strings containing time zone information. However, this will handle
        /// two common ISO8601 formats: YYYY-MM-DDThh:mm:ss.sZ (with seconds to machine precision)
        /// and it's "day of year" equivalent: YYYY-DDDThh:mm:ss.sZ
        /// </summary>
        /// <returns>
        /// A <see cref="GregorianDate" /> equivalent to the date and time contained in s.
        /// </returns>
        /// <param name="s">A string containing a date and time to convert.</param>
        /// <exception cref="ArgumentNullException">
        /// <paramref name="s"/> is null. 
        /// </exception>
        /// <exception cref="FormatException">
        /// <paramref name="s"/> does not contain a valid string representation of a date
        /// and time. 
        /// </exception>
        public static GregorianDate Parse(string s)
        {
            return Parse(s, null);
        }

        /// <summary>
        /// Converts the specified string representation of a date and time to its
        /// <see cref="GregorianDate" /> equivalent using the specified culture-specific
        /// format information.
        /// 
        /// Note: <see cref="GregorianDate"/> is always assumed to be in UTC.  You cannot
        /// parse strings containing time zone information. However, this will handle
        /// two common ISO8601 formats: YYYY-MM-DDThh:mm:ss.sZ (with seconds to machine precision)
        /// and it's "day of year" equivalent: YYYY-DDDThh:mm:ss.sZ
        /// </summary>
        /// <returns>
        /// A <see cref="GregorianDate" /> equivalent to the date and time contained in 
        /// <paramref name="s"/> as specified by <paramref name="provider"/>.
        /// </returns>
        /// <param name="s">A string containing a date and time to convert.</param>
        /// <param name="provider">An <see cref="IFormatProvider" /> that supplies
        /// culture-specific format information about <paramref name="s"/>.</param>
        /// <exception cref="ArgumentNullException">
        /// <paramref name="s"/> is null. 
        /// </exception>
        /// <exception cref="FormatException">
        /// <paramref name="s"/> does not contain a valid string representation of a date
        /// and time. 
        /// </exception>
        public static GregorianDate Parse(string s, IFormatProvider provider)
        {
            return Parser.Parse(s, provider);
        }

        /// <summary>
        /// Converts the specified string representation of a date and time to its
        /// <see cref="GregorianDate"/> equivalent using the specified format and
        /// culture-specific format information. The format of the string representation
        /// must match the specified format exactly.
        ///
        /// Note: <see cref="GregorianDate"/> is always assumed to be in UTC.  You cannot
        /// parse strings containing time zone information.
        /// </summary>
        /// <returns>
        /// A <see cref="GregorianDate"/> equivalent to the date and time contained in 
        /// <paramref name="s"/> as specified by <paramref name="format"/> and 
        /// <paramref name="provider"/>.
        /// </returns>
        /// <param name="s">A string containing a date and time to convert. </param>
        /// <param name="format">The expected format of <paramref name="s"/>. </param>
        /// <param name="provider">An <see cref="IFormatProvider" /> that supplies
        /// culture-specific format information about <paramref name="s"/>. </param>
        /// <exception cref="ArgumentNullException">
        /// <paramref name="s"/> or <paramref name="format"/> is null.
        /// </exception>
        /// <exception cref="FormatException">
        /// <paramref name="s"/> or <paramref name="format"/> is an empty string. -or- 
        /// <paramref name="s"/> does not contain a date and time that corresponds to the
        /// pattern specified in
        /// <paramref name="format"/>. 
        /// </exception>
        public static GregorianDate ParseExact(string s, string format, IFormatProvider provider)
        {
            return Parser.ParseExact(s, new[] {format}, provider);
        }

        /// <summary>
        /// Converts the specified string representation of a date and time to its
        /// <see cref="GregorianDate"/> equivalent using the specified format and
        /// culture-specific format information. The format of the string representation
        /// must match the specified format exactly.
        ///
        /// Note: <see cref="GregorianDate"/> is always assumed to be in UTC.  You cannot
        /// parse strings containing time zone information.
        /// </summary>
        /// <returns>
        /// A <see cref="GregorianDate"/> equivalent to the date and time contained in 
        /// <paramref name="s"/> as specified by <paramref name="format"/> and 
        /// <paramref name="provider"/>.
        /// </returns>
        /// <param name="s">A list of strings containing a date and time to convert. </param>
        /// <param name="format">The expected format of <paramref name="s"/>. </param>
        /// <param name="provider">An <see cref="IFormatProvider" /> that supplies
        /// culture-specific format information about <paramref name="s"/>. </param>
        /// <exception cref="ArgumentNullException">
        /// <paramref name="s"/> or <paramref name="format"/> is null.
        /// </exception>
        /// <exception cref="FormatException">
        /// <paramref name="s"/> or <paramref name="format"/> is an empty string. -or- 
        /// <paramref name="s"/> does not contain a date and time that corresponds to the
        /// pattern specified in
        /// <paramref name="format"/>. 
        /// </exception>
        public static GregorianDate ParseExact(string s, string[] format, IFormatProvider provider)
        {
            return Parser.ParseExact(s, format, provider);
        }

        /// <summary>
        /// Converts the specified string representation of a date and time to its
        /// <see cref="GregorianDate" /> equivalent.
        /// 
        /// Note: <see cref="GregorianDate"/> is always assumed to be in UTC.  You cannot
        /// parse strings containing time zone information. However, this will handle
        /// two common ISO8601 formats: YYYY-MM-DDThh:mm:ss.sZ (with seconds to machine precision)
        /// and it's "day of year" equivalent: YYYY-DDDThh:mm:ss.sZ
        /// </summary>
        /// <returns>
        /// true if the <paramref name="s"/> parameter was converted successfully;
        /// otherwise, false.
        /// </returns>
        /// <param name="s">A string containing a date and time to convert.</param>
        /// <param name="result">
        /// <filter name="Java">On input, an array with one element.  On return, the array is populated with</filter>
        /// <filter name="DotNet,Silverlight">On return,</filter>
        /// the <see cref="GregorianDate" /> value equivalent to the date and time contained in
        /// <paramref name="s"/>, if the conversion succeeded, or 
        /// <see cref="GregorianDate.MinValue" /> if the conversion failed. The conversion
        /// fails if the <paramref name="s"/> parameter is null, or does not contain a
        /// valid string representation of a date and time. This parameter is passed
        /// uninitialized. 
        /// </param>
        public static bool TryParse(string s, out GregorianDate result)
        {
            return TryParse(s, null, out result);
        }

        /// <summary>
        /// Converts the specified string representation of a date and time to its
        /// <see cref="GregorianDate" /> equivalent using the specified culture-specific
        /// format information.
        /// 
        /// Note: <see cref="GregorianDate"/> is always assumed to be in UTC.  You cannot
        /// parse strings containing time zone information. However, this will handle
        /// two common ISO8601 formats: YYYY-MM-DDThh:mm:ss.sZ (with seconds to machine precision)
        /// and it's "day of year" equivalent: YYYY-DDDThh:mm:ss.sZ
        /// </summary>
        /// <returns>
        /// true if the <paramref name="s"/> parameter was converted successfully;
        /// otherwise, false.
        /// </returns>
        /// <param name="s">A string containing a date and time to convert.</param>
        /// <param name="provider">An <see cref="IFormatProvider" /> that supplies
        /// culture-specific format information about <paramref name="s"/>. </param>
        /// <param name="result">
        /// <filter name="Java">On input, an array with one element.  On return, the array is populated with</filter>
        /// <filter name="DotNet,Silverlight">On return,</filter>
        /// the <see cref="GregorianDate" /> value equivalent to the date and time contained in
        /// <paramref name="s"/>, if the conversion succeeded, or 
        /// <see cref="GregorianDate.MinValue" /> if the conversion failed. The conversion
        /// fails if the <paramref name="s"/> parameter is null, or does not contain a
        /// valid string representation of a date and time. This parameter is passed
        /// uninitialized. 
        /// </param>
        public static bool TryParse(string s, IFormatProvider provider, out GregorianDate result)
        {
            return Parser.TryParse(s, provider, out result);
        }

        /// <summary>
        /// Represents the largest possible value of <see cref="GregorianDate"/>. 
        /// Corresponds to <see cref="DateTime.MaxValue"/>.
        /// </summary>
        public static readonly GregorianDate MaxValue = new GregorianDate(DateTime.MaxValue);

        /// <summary>
        /// Represents the smallest possible value of <see cref="GregorianDate"/>. 
        /// Corresponds to <see cref="DateTime.MinValue"/>.
        /// </summary>
        public static readonly GregorianDate MinValue = new GregorianDate(DateTime.MinValue);

        private const int SecondsPerHour = 3600;
        private const int SecondsPerMinute = 60;

        private readonly YearMonthDay m_yearMonthDay;
        private readonly int m_hour;
        private readonly int m_minute;
        private readonly double m_second;
    }
}