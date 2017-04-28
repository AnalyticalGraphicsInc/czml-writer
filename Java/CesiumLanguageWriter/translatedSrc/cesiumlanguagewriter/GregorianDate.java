package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DateTimeFormatInfo;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.IntHelper;
import agi.foundation.compatibility.MathHelper;
import agi.foundation.compatibility.NumberFormatInfo;
import agi.foundation.compatibility.ObjectHelper;
import agi.foundation.compatibility.PrimitiveHelper;
import agi.foundation.compatibility.StringComparison;
import agi.foundation.compatibility.StringHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 *  
 Represents a calendar date in the Gregorian calendar.  A
 {@link GregorianDate} does not include a {@link TimeStandard} as {@link JulianDate}
 does.  However, without explicitly specifying a {@link TimeStandard} for the date, the {@link GregorianDate}
 is assumed to be represented in {@link TimeStandard#COORDINATED_UNIVERSAL_TIME}. {@link GregorianDate} is
 also capable of representing leap seconds, which are represented as the second measured from 60 to 61.  In this case,
 the {@link GregorianDate} is assumed to be the {@link TimeStandard#COORDINATED_UNIVERSAL_TIME} represented
 in {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} which can represent leap seconds exactly.
 

 */
public final class GregorianDate implements Comparable<GregorianDate>, IEquatable<GregorianDate>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public GregorianDate() {}

    /**
    *  
    This class was taken from the Mono {@link DateTime} class, and
    substantially altered to fit the needs of Gregorian Date.  Gregorian Date
    assumes UTC, so all time-zone handling was ripped out.  The "f" parsing was
    also changed to allow more precision than the 7 digits that
    {@link DateTime} mandates.

    Note: any comment from here on is taken from the Mono source, so any references
    to bug numbers refer to their bugs.
    

    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    private static class Parser {
        /**
        *  
        Build an array of date/time patterns that support up to the number of
        fractional second digits specified.  {@link DateTime} will only parse up
        to seven.
        
        
        
        

        * @param patterns The set of formats to use as a template.
        * @param maximumFractionalSeconds The maximum number of fractional second
        digits to include in the pattern set.
        * @return An array of date/time patterns that can be used for parsing.
        */
        private static String[] buildDateTimePatterns(String[] patterns, int maximumFractionalSeconds) {
            ArrayList<String> result = new ArrayList<String>(patterns.length * (maximumFractionalSeconds + 1));
            for (final String s : patterns) {
                if (s.endsWith(".f*")) {
                    result.add(StringHelper.replace(s, ".f*", ""));
                    StringBuilder newStr = new StringBuilder(maximumFractionalSeconds);
                    for (int i = 1; i <= maximumFractionalSeconds; i++) {
                        newStr.append("f");
                        result.add(StringHelper.replace(s, "f*", newStr.toString()));
                    }
                } else {
                    result.add(s);
                }
            }
            return result.toArray(new String[result.size()]);
        }

        public static GregorianDate parse(String s, Locale provider) {
            if (s == null) {
                throw new ArgumentNullException("s");
            }
            @CS2JInfo("Initialization of C# struct variable 'res' added by translator.")
            GregorianDate res = new GregorianDate();
            NumberFormatException exception = null;
            final GregorianDate[] out$res$1 = {
                null
            };
            final NumberFormatException[] ref$exception$2 = {
                exception
            };
            final boolean temp$0 = coreParse(s, provider, out$res$1, true, ref$exception$2);
            exception = ref$exception$2[0];
            res = out$res$1[0];
            if (!temp$0) {
                throw exception;
            }
            return res;
        }

        public static GregorianDate parseExact(String s, String[] format, Locale provider) {
            if (s == null) {
                throw new ArgumentNullException("s");
            }
            if (format == null) {
                throw new ArgumentNullException("format");
            }
            DateTimeFormatInfo dfi = DateTimeFormatInfo.getInstance(provider);
            @CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
            GregorianDate result = new GregorianDate();
            boolean longYear = false;
            NumberFormatException e = null;
            final GregorianDate[] out$result$4 = {
                null
            };
            final boolean[] ref$longYear$5 = {
                longYear
            };
            final NumberFormatException[] ref$e$6 = {
                e
            };
            final boolean temp$3 = parseExact(s, format, dfi, out$result$4, true, ref$longYear$5, true, ref$e$6);
            e = ref$e$6[0];
            longYear = ref$longYear$5[0];
            result = out$result$4[0];
            if (!temp$3) {
                throw e;
            }
            return result;
        }

        public static boolean tryParse(String s, Locale provider, GregorianDate[] result) {
            if (s != null) {
                try {
                    NumberFormatException exception = null;
                    final NumberFormatException[] ref$exception$8 = {
                        exception
                    };
                    final boolean temp$7 = coreParse(s, provider, result, false, ref$exception$8);
                    exception = ref$exception$8[0];
                    return temp$7;
                } catch (RuntimeException _ex) {}
            }
            result[0] = MinValue;
            return false;
        }

        private static boolean parseExact(String s, String[] formats, DateTimeFormatInfo dfi, GregorianDate[] ret, boolean exact, boolean[] longYear, boolean setExceptionOnError,
                NumberFormatException[] exception) {
            int i;
            boolean incompleteFormat = false;
            for (i = 0; i < formats.length; i++) {
                @CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
                GregorianDate result = new GregorianDate();
                String format = formats[i];
                if (StringHelper.isNullOrEmpty(format)) {
                    break;
                }
                final GregorianDate[] out$result$10 = {
                    null
                };
                final boolean[] ref$incompleteFormat$11 = {
                    incompleteFormat
                };
                final boolean temp$9 = doParse(s, formats[i], null, exact, out$result$10, dfi, ref$incompleteFormat$11, longYear);
                incompleteFormat = ref$incompleteFormat$11[0];
                result = out$result$10[0];
                if (temp$9) {
                    ret[0] = result;
                    return true;
                }
            }
            if (setExceptionOnError) {
                exception[0] = new NumberFormatException(CesiumLocalization.getGregorianDateFormatInvalid());
            }
            ret[0] = MinValue;
            return false;
        }

        private static boolean coreParse(String s, Locale provider, GregorianDate[] result, boolean setExceptionOnError, NumberFormatException[] exception) {
            if (StringHelper.isNullOrEmpty(s)) {
                if (setExceptionOnError) {
                    exception[0] = new NumberFormatException(CesiumLocalization.getGregorianDateFormatInvalid());
                }
                result[0] = MinValue;
                return false;
            }
            if (provider == null) {
                provider = CultureInfoHelper.getCurrentCulture();
            }
            DateTimeFormatInfo dfi = DateTimeFormatInfo.getInstance(provider);
            // Try first all the combinations of ParseAllDateFormats & ParseTimeFormats
            String[] allDateFormats = yearMonthDayFormats(dfi, setExceptionOnError, exception);
            if (allDateFormats == null) {
                result[0] = MinValue;
                return false;
            }
            boolean longYear = false;
            for (int i = 0; i < allDateFormats.length; i++) {
                String firstPart = allDateFormats[i];
                boolean incompleteFormat = false;
                final boolean[] ref$incompleteFormat$13 = {
                    incompleteFormat
                };
                final boolean[] ref$longYear$14 = {
                    longYear
                };
                final boolean temp$12 = doParse(s, firstPart, "", false, result, dfi, ref$incompleteFormat$13, ref$longYear$14);
                longYear = ref$longYear$14[0];
                incompleteFormat = ref$incompleteFormat$13[0];
                if (temp$12) {
                    return true;
                }
                if (!incompleteFormat) {
                    continue;
                }
                for (int j = 0; j < s_parseTimeFormats.length; j++) {
                    final boolean[] ref$incompleteFormat$16 = {
                        incompleteFormat
                    };
                    final boolean[] ref$longYear$17 = {
                        longYear
                    };
                    final boolean temp$15 = doParse(s, firstPart, s_parseTimeFormats[j], false, result, dfi, ref$incompleteFormat$16, ref$longYear$17);
                    longYear = ref$longYear$17[0];
                    incompleteFormat = ref$incompleteFormat$16[0];
                    if (temp$15) {
                        return true;
                    }
                }
            }
            //
            // Month day formats
            //
            int dayIndex = dfi.getMonthDayPattern().indexOf('d');
            int monthIndex = dfi.getMonthDayPattern().indexOf('M');
            if (dayIndex == -1 || monthIndex == -1) {
                result[0] = MinValue;
                if (setExceptionOnError) {
                    exception[0] = new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateOrderOfMonthAndDateNotDefined(), dfi.getMonthDayPattern()));
                }
                return false;
            }
            boolean isDayBeforeMonth = dayIndex < monthIndex;
            String[] monthDayFormats = isDayBeforeMonth ? s_dayMonthShortFormats : s_monthDayShortFormats;
            for (int i = 0; i < monthDayFormats.length; i++) {
                boolean incompleteFormat = false;
                final boolean[] ref$incompleteFormat$19 = {
                    incompleteFormat
                };
                final boolean[] ref$longYear$20 = {
                    longYear
                };
                final boolean temp$18 = doParse(s, monthDayFormats[i], "", false, result, dfi, ref$incompleteFormat$19, ref$longYear$20);
                longYear = ref$longYear$20[0];
                incompleteFormat = ref$incompleteFormat$19[0];
                if (temp$18) {
                    return true;
                }
            }
            for (int j = 0; j < s_parseTimeFormats.length; j++) {
                String firstPart = s_parseTimeFormats[j];
                boolean incompleteFormat = false;
                final boolean[] ref$incompleteFormat$22 = {
                    incompleteFormat
                };
                final boolean[] ref$longYear$23 = {
                    longYear
                };
                final boolean temp$21 = doParse(s, firstPart, "", false, result, dfi, ref$incompleteFormat$22, ref$longYear$23);
                longYear = ref$longYear$23[0];
                incompleteFormat = ref$incompleteFormat$22[0];
                if (temp$21) {
                    return true;
                }
                if (!incompleteFormat) {
                    continue;
                }
                for (int i = 0; i < monthDayFormats.length; i++) {
                    final boolean[] ref$incompleteFormat$25 = {
                        incompleteFormat
                    };
                    final boolean[] ref$longYear$26 = {
                        longYear
                    };
                    final boolean temp$24 = doParse(s, firstPart, monthDayFormats[i], false, result, dfi, ref$incompleteFormat$25, ref$longYear$26);
                    longYear = ref$longYear$26[0];
                    incompleteFormat = ref$incompleteFormat$25[0];
                    if (temp$24) {
                        return true;
                    }
                }
                for (int i = 0; i < allDateFormats.length; i++) {
                    String dateFormat = allDateFormats[i];
                    if (dateFormat.charAt(dateFormat.length() - 1) == 'T') {
                        continue;
                    }
                    final boolean[] ref$incompleteFormat$28 = {
                        incompleteFormat
                    };
                    final boolean[] ref$longYear$29 = {
                        longYear
                    };
                    final boolean temp$27 = doParse(s, firstPart, dateFormat, false, result, dfi, ref$incompleteFormat$28, ref$longYear$29);
                    longYear = ref$longYear$29[0];
                    incompleteFormat = ref$incompleteFormat$28[0];
                    // T formats must be before the time part
                    if (temp$27) {
                        return true;
                    }
                }
            }
            final boolean[] ref$longYear$31 = {
                longYear
            };
            final boolean temp$30 = parseExact(s, dfi.getAllDateTimePatterns(), dfi, result, false, ref$longYear$31, setExceptionOnError, exception);
            longYear = ref$longYear$31[0];
            // Try as a last resort all the patterns
            if (temp$30) {
                return true;
            }
            final boolean[] ref$longYear$33 = {
                longYear
            };
            final boolean temp$32 = parseExact(s, s_extraDateTimePatterns, dfi, result, false, ref$longYear$33, setExceptionOnError, exception);
            longYear = ref$longYear$33[0];
            //then try the extra patterns that aren't listed in GetAllDateTimePatterns()
            if (temp$32) {
                return true;
            }
            // Since the above formats (.NET formatting) can't handle "day-of-year" very well,
            // try parsing it here as a last resort
            if (parseIso8601DayOfYear(s, dfi, result, setExceptionOnError, exception)) {
                return true;
            }
            if (!setExceptionOnError) {
                return false;
            }
            exception[0] = new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateStringNotRecognized(), s));
            return false;
        }

        private static String[] yearMonthDayFormats(DateTimeFormatInfo dfi, boolean setExceptionOnError, NumberFormatException[] ex) {
            int dayIndex = dfi.getShortDatePattern().indexOf('d');
            int monthIndex = dfi.getShortDatePattern().indexOf('M');
            int yearIndex = dfi.getShortDatePattern().indexOf('y');
            if (dayIndex == -1 || monthIndex == -1 || yearIndex == -1) {
                if (setExceptionOnError) {
                    ex[0] = new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateOrderOfYearMonthAndDateNotDefined(), dfi.getShortDatePattern()));
                }
                return null;
            }
            if (yearIndex < monthIndex) {
                if (monthIndex < dayIndex) {
                    return s_parseYearMonthDayFormats;
                } else if (yearIndex < dayIndex) {
                    return s_parseYearDayMonthFormats;
                } else {
                    // The year cannot be between the date and the month
                    if (setExceptionOnError) {
                        String msg = StringHelper.format(CesiumLocalization.getGregorianDateOrderOfYearMonthAndDateNotSupported(), dfi.getShortDatePattern());
                        ex[0] = new NumberFormatException(msg);
                    }
                    return null;
                }
            }
            if (dayIndex < monthIndex) {
                return s_parseDayMonthYearFormats;
            }
            if (dayIndex < yearIndex) {
                return s_parseMonthDayYearFormats;
            }
            // The year cannot be between the month and the date
            if (setExceptionOnError) {
                String msg = StringHelper.format(CesiumLocalization.getGregorianDateOrderOfYearMonthAndDateNotSupported(), dfi.getShortDatePattern());
                ex[0] = new NumberFormatException(msg);
            }
            return null;
        }

        private static boolean parseDateSeparator(String s, int sPos, DateTimeFormatInfo dfi, boolean exact, int[] numParsed) {
            numParsed[0] = -1;
            if (exact && s.charAt(sPos) != '/') {
                return false;
            }
            if (parseTimeSeparator(s, sPos, dfi, exact, numParsed) || Character.isDigit(s.charAt(sPos)) || Character.isLetter(s.charAt(sPos))) {
                return false;
            }
            numParsed[0] = 1;
            return true;
        }

        private static long parseNumber(String s, int valuePos, int minDigits, int digits, boolean leadingzero, int[] numParsed) {
            long number = 0;
            int i;
            if (!leadingzero) {
                int realDigits = 0;
                for (i = valuePos; i < s.length() && i < digits + valuePos; i++) {
                    if (!Character.isDigit(s.charAt(i))) {
                        break;
                    }
                    realDigits++;
                }
                digits = realDigits;
            }
            if (digits < minDigits) {
                numParsed[0] = -1;
                return 0;
            }
            if (s.length() - valuePos < digits) {
                numParsed[0] = -1;
                return 0;
            }
            for (i = valuePos; i < digits + valuePos; i++) {
                char c = s.charAt(i);
                if (!Character.isDigit(c)) {
                    numParsed[0] = -1;
                    return 0;
                }
                number = number * 10 + (byte) (c - '0');
            }
            numParsed[0] = digits;
            return number;
        }

        private static int parseEnum(String s, int sPos, String[] values, String[] invValues, boolean exact, int[] numParsed) {
            // FIXME: I know this is somehow lame code. Probably
            // it should iterate all the enum value and return
            // the longest match. However right now I don't see
            // anything but "1" and "10" - "12" that might match
            // two or more values. (They are only abbrev month
            // names, so do reverse order search). See bug #80094.
            for (int i = values.length - 1; i >= 0; i--) {
                if (!exact && invValues[i].length() > values[i].length()) {
                    if (invValues[i].length() > 0 && parseString(s, sPos, 0, invValues[i], numParsed)) {
                        return i;
                    }
                    if (values[i].length() > 0 && parseString(s, sPos, 0, values[i], numParsed)) {
                        return i;
                    }
                } else {
                    if (values[i].length() > 0 && parseString(s, sPos, 0, values[i], numParsed)) {
                        return i;
                    }
                    if (!exact && invValues[i].length() > 0 && parseString(s, sPos, 0, invValues[i], numParsed)) {
                        return i;
                    }
                }
            }
            numParsed[0] = -1;
            return -1;
        }

        private static boolean parseString(String s, int sPos, int maxlength, String value, int[] numParsed) {
            if (maxlength <= 0) {
                maxlength = value.length();
            }
            if (sPos + maxlength <= s.length() && StringHelper.compare(s, sPos, value, 0, maxlength, StringComparison.INVARIANT_CULTURE_IGNORE_CASE) == 0) {
                numParsed[0] = maxlength;
                return true;
            }
            numParsed[0] = -1;
            return false;
        }

        // Note that in case of Parse (exact == false) we check both for AM/PM
        // and the culture specific AM/PM strings.
        private static boolean parseAmPm(String s, int valuePos, int num, DateTimeFormatInfo dfi, boolean exact, int[] numParsed, int[] ampm) {
            numParsed[0] = -1;
            if (ampm[0] != -1) {
                return false;
            }
            if (!isLetter(s, valuePos)) {
                if (ObjectHelper.notEquals(dfi.getAMDesignator(), "")) {
                    return false;
                }
                if (exact) {
                    ampm[0] = 0;
                }
                numParsed[0] = 0;
                return true;
            }
            DateTimeFormatInfo invInfo = DateTimeFormatInfo.getInvariantInfo();
            if (!exact && parseString(s, valuePos, num, invInfo.getPMDesignator(), numParsed) || ObjectHelper.notEquals(dfi.getPMDesignator(), "")
                    && parseString(s, valuePos, num, dfi.getPMDesignator(), numParsed)) {
                ampm[0] = 1;
            } else if (!exact && parseString(s, valuePos, num, invInfo.getAMDesignator(), numParsed) || parseString(s, valuePos, num, dfi.getAMDesignator(), numParsed)) {
                if (exact || numParsed[0] != 0) {
                    ampm[0] = 0;
                }
            } else {
                return false;
            }
            return true;
        }

        // Note that in case of Parse (exact == false) we check both for ':'
        // and the culture specific TimeSperator
        private static boolean parseTimeSeparator(String s, int sPos, DateTimeFormatInfo dfi, boolean exact, int[] numParsed) {
            String timeSeparator = dfi.getTimeSeparator();
            return parseString(s, sPos, 0, timeSeparator, numParsed) || !exact && parseString(s, sPos, 0, ":", numParsed);
        }

        // Accept any character for DateSeparator, except TimeSeparator,
        // a digit or a letter.
        // Not documented, but seems to be MS behaviour here.  See bug 54047.
        private static boolean isLetter(String s, int pos) {
            return pos < s.length() && Character.isLetter(s.charAt(pos));
        }

        private static boolean doParse(String s, String firstPart, String secondPart, boolean exact, GregorianDate[] result, DateTimeFormatInfo dfi, boolean[] incompleteFormat, boolean[] longYear) {
            boolean useInvariant = false;
            boolean flexibleTwoPartsParsing = !exact && secondPart != null;
            incompleteFormat[0] = false;
            int valuePos = 0;
            String format = firstPart;
            boolean afterTFormat = false;
            DateTimeFormatInfo invInfo = DateTimeFormatInfo.getInvariantInfo();
            if (format.length() == 1) {
                final boolean[] out$useInvariant$35 = {
                    false
                };
                final String temp$34 = getStandardPattern(format.charAt(0), dfi, out$useInvariant$35);
                useInvariant = out$useInvariant$35[0];
                format = temp$34;
            }
            result[0] = new GregorianDate();
            if (format == null) {
                return false;
            }
            if (useInvariant) {
                dfi = invInfo;
            }
            String chars = format;
            int len = format.length(), pos = 0, num = 0;
            if (len == 0) {
                return false;
            }
            int day = -1, dayofweek = -1, month = -1, year = -1;
            int hour = -1, minute = -1, second = -1;
            double fractionalSeconds = -1D;
            int ampm = -1;
            boolean isFirstPart = true;
            for (;;) {
                if (valuePos == s.length()) {
                    break;
                }
                int numParsed = 0;
                if (flexibleTwoPartsParsing && pos + num == 0) {
                    boolean isLetter = isLetter(s, valuePos);
                    if (isLetter) {
                        if (s.charAt(valuePos) == 'Z') {
                            numParsed = 1;
                        } else {
                            final int[] out$numParsed$36 = {
                                0
                            };
                            parseString(s, valuePos, 0, "GMT", out$numParsed$36);
                            numParsed = out$numParsed$36[0];
                        }
                        if (numParsed > 0 && !isLetter(s, valuePos + numParsed)) {
                            valuePos += numParsed;
                            continue;
                        }
                    }
                    boolean temp$37 = !afterTFormat;
                    if (temp$37) {
                        final int[] out$numParsed$38 = {
                            0
                        };
                        final int[] ref$ampm$39 = {
                            ampm
                        };
                        temp$37 = parseAmPm(s, valuePos, 0, dfi, false, out$numParsed$38, ref$ampm$39);
                        ampm = ref$ampm$39[0];
                        numParsed = out$numParsed$38[0];
                    }
                    if (temp$37) {
                        if (isLetter(s, valuePos + numParsed)) {
                            ampm = -1;
                        } else if (numParsed > 0) {
                            valuePos += numParsed;
                            continue;
                        }
                    }
                    if (!afterTFormat && dayofweek == -1 && isLetter) {
                        final int[] out$numParsed$41 = {
                            0
                        };
                        final int temp$40 = parseEnum(s, valuePos, dfi.getDayNames(), invInfo.getDayNames(), false, out$numParsed$41);
                        numParsed = out$numParsed$41[0];
                        dayofweek = temp$40;
                        if (dayofweek == -1) {
                            final int[] out$numParsed$43 = {
                                0
                            };
                            final int temp$42 = parseEnum(s, valuePos, dfi.getAbbreviatedDayNames(), invInfo.getAbbreviatedDayNames(), false, out$numParsed$43);
                            numParsed = out$numParsed$43[0];
                            dayofweek = temp$42;
                        }
                        if (dayofweek != -1 && !isLetter(s, valuePos + numParsed)) {
                            valuePos += numParsed;
                            continue;
                        }
                        dayofweek = -1;
                    }
                    if (Character.isWhitespace(s.charAt(valuePos)) || s.charAt(valuePos) == ',') {
                        valuePos += 1;
                        continue;
                    }
                }
                if (pos + num >= len) {
                    if (flexibleTwoPartsParsing && num == 0) {
                        afterTFormat = isFirstPart && firstPart.charAt(firstPart.length() - 1) == 'T';
                        if (!isFirstPart && ObjectHelper.equals(format, "")) {
                            break;
                        }
                        pos = 0;
                        if (isFirstPart) {
                            format = secondPart;
                        } else {
                            format = "";
                        }
                        chars = format;
                        len = chars.length();
                        isFirstPart = false;
                        continue;
                    }
                    break;
                }
                if (chars.charAt(pos) == '\'') {
                    num = 1;
                    while (pos + num < len) {
                        if (chars.charAt(pos + num) == '\'') {
                            break;
                        }
                        if (valuePos == s.length() || s.charAt(valuePos) != chars.charAt(pos + num)) {
                            return false;
                        }
                        valuePos++;
                        num++;
                    }
                    pos += num + 1;
                    num = 0;
                    continue;
                }
                if (chars.charAt(pos) == '"') {
                    num = 1;
                    while (pos + num < len) {
                        if (chars.charAt(pos + num) == '"') {
                            break;
                        }
                        if (valuePos == s.length() || s.charAt(valuePos) != chars.charAt(pos + num)) {
                            return false;
                        }
                        valuePos++;
                        num++;
                    }
                    pos += num + 1;
                    num = 0;
                    continue;
                }
                if (chars.charAt(pos) == '\\') {
                    pos += num + 1;
                    num = 0;
                    if (pos >= len) {
                        return false;
                    }
                    if (s.charAt(valuePos) != chars.charAt(pos)) {
                        return false;
                    }
                    valuePos++;
                    pos++;
                    continue;
                }
                if (chars.charAt(pos) == '%') {
                    pos++;
                    continue;
                }
                if (Character.isWhitespace(s.charAt(valuePos)) || s.charAt(valuePos) == ',' && (!exact && chars.charAt(pos) == '/' || Character.isWhitespace(chars.charAt(pos)))) {
                    valuePos++;
                    num = 0;
                    int ws = valuePos;
                    while (ws < s.length()) {
                        if (Character.isWhitespace(s.charAt(ws)) || s.charAt(ws) == ',') {
                            ws++;
                        } else {
                            break;
                        }
                    }
                    valuePos = ws;
                    ws = pos;
                    while (ws < chars.length()) {
                        if (Character.isWhitespace(chars.charAt(ws)) || chars.charAt(ws) == ',') {
                            ws++;
                        } else {
                            break;
                        }
                    }
                    pos = ws;
                    // A whitespace may match a '/' in the pattern.
                    if (!exact && pos < chars.length() && chars.charAt(pos) == '/') {
                        final int[] out$numParsed$45 = {
                            0
                        };
                        final boolean temp$44 = parseDateSeparator(s, valuePos, dfi, false, out$numParsed$45);
                        numParsed = out$numParsed$45[0];
                        if (!temp$44) {
                            pos++;
                        }
                    }
                    continue;
                }
                if ((pos + num + 1 < len) && (chars.charAt(pos + num + 1) == chars.charAt(pos + num))) {
                    num++;
                    continue;
                }
                switch (chars.charAt(pos)) {
                case 'd': {
                    if (num < 2 && day != -1 || num >= 2 && dayofweek != -1) {
                        return false;
                    }
                    if (num == 0) {
                        final int[] out$numParsed$47 = {
                            0
                        };
                        final long temp$46 = parseNumber(s, valuePos, 1, 2, false, out$numParsed$47);
                        numParsed = out$numParsed$47[0];
                        day = (int) temp$46;
                    } else if (num == 1) {
                        final int[] out$numParsed$51 = {
                            0
                        };
                        final long temp$50 = parseNumber(s, valuePos, 1, 2, true, out$numParsed$51);
                        numParsed = out$numParsed$51[0];
                        day = (int) temp$50;
                    } else if (num == 2) {
                        final int[] out$numParsed$53 = {
                            0
                        };
                        final int temp$52 = parseEnum(s, valuePos, dfi.getAbbreviatedDayNames(), invInfo.getAbbreviatedDayNames(), exact, out$numParsed$53);
                        numParsed = out$numParsed$53[0];
                        dayofweek = temp$52;
                    } else {
                        final int[] out$numParsed$49 = {
                            0
                        };
                        final int temp$48 = parseEnum(s, valuePos, dfi.getDayNames(), invInfo.getDayNames(), exact, out$numParsed$49);
                        numParsed = out$numParsed$49[0];
                        dayofweek = temp$48;
                    }
                    break;
                }
                case 'M': {
                    if (month != -1) {
                        return false;
                    }
                    if (flexibleTwoPartsParsing) {
                        numParsed = -1;
                        if (num == 0 || num == 3) {
                            final int[] out$numParsed$55 = {
                                0
                            };
                            final long temp$54 = parseNumber(s, valuePos, 1, 2, false, out$numParsed$55);
                            numParsed = out$numParsed$55[0];
                            month = (int) temp$54;
                        }
                        if (num > 1 && numParsed == -1) {
                            final int[] out$numParsed$57 = {
                                0
                            };
                            final int temp$56 = parseEnum(s, valuePos, dfi.getMonthNames(), invInfo.getMonthNames(), false, out$numParsed$57);
                            numParsed = out$numParsed$57[0];
                            month = temp$56 + 1;
                        }
                        if (num > 1 && numParsed == -1) {
                            final int[] out$numParsed$59 = {
                                0
                            };
                            final int temp$58 = parseEnum(s, valuePos, dfi.getAbbreviatedMonthNames(), invInfo.getAbbreviatedMonthNames(), false, out$numParsed$59);
                            numParsed = out$numParsed$59[0];
                            month = temp$58 + 1;
                        }
                        break;
                    }
                    if (num == 0) {
                        final int[] out$numParsed$61 = {
                            0
                        };
                        final long temp$60 = parseNumber(s, valuePos, 1, 2, false, out$numParsed$61);
                        numParsed = out$numParsed$61[0];
                        month = (int) temp$60;
                    } else if (num == 1) {
                        final int[] out$numParsed$65 = {
                            0
                        };
                        final long temp$64 = parseNumber(s, valuePos, 1, 2, true, out$numParsed$65);
                        numParsed = out$numParsed$65[0];
                        month = (int) temp$64;
                    } else if (num == 2) {
                        final int[] out$numParsed$67 = {
                            0
                        };
                        final int temp$66 = parseEnum(s, valuePos, dfi.getAbbreviatedMonthNames(), invInfo.getAbbreviatedMonthNames(), exact, out$numParsed$67);
                        numParsed = out$numParsed$67[0];
                        month = temp$66 + 1;
                    } else {
                        final int[] out$numParsed$63 = {
                            0
                        };
                        final int temp$62 = parseEnum(s, valuePos, dfi.getMonthNames(), invInfo.getMonthNames(), exact, out$numParsed$63);
                        numParsed = out$numParsed$63[0];
                        month = temp$62 + 1;
                    }
                    break;
                }
                case 'y': {
                    if (year != -1) {
                        return false;
                    }
                    if (num == 0) {
                        final int[] out$numParsed$69 = {
                            0
                        };
                        final long temp$68 = parseNumber(s, valuePos, 1, 2, false, out$numParsed$69);
                        numParsed = out$numParsed$69[0];
                        year = (int) temp$68;
                    } else if (num < 3) {
                        final int[] out$numParsed$75 = {
                            0
                        };
                        final long temp$74 = parseNumber(s, valuePos, 1, 2, true, out$numParsed$75);
                        numParsed = out$numParsed$75[0];
                        year = (int) temp$74;
                    } else {
                        final int[] out$numParsed$71 = {
                            0
                        };
                        final long temp$70 = parseNumber(s, valuePos, exact ? 4 : 3, 4, false, out$numParsed$71);
                        numParsed = out$numParsed$71[0];
                        year = (int) temp$70;
                        if ((year >= 1000) && (numParsed == 4) && !longYear[0] && (s.length() > 4 + valuePos)) {
                            int np = 0;
                            final int[] out$np$73 = {
                                0
                            };
                            final long temp$72 = parseNumber(s, valuePos, 5, 5, false, out$np$73);
                            np = out$np$73[0];
                            int ly = (int) temp$72;
                            longYear[0] = ly > 9999;
                        }
                        num = 3;
                    }
                    //FIXME: We should do use dfi.Calendat.TwoDigitYearMax
                    if (numParsed <= 2) {
                        year += year < 30 ? 2000 : 1900;
                    }
                    break;
                }
                case 'h': {
                    if (hour != -1) {
                        return false;
                    }
                    if (num == 0) {
                        final int[] out$numParsed$77 = {
                            0
                        };
                        final long temp$76 = parseNumber(s, valuePos, 1, 2, false, out$numParsed$77);
                        numParsed = out$numParsed$77[0];
                        hour = (int) temp$76;
                    } else {
                        final int[] out$numParsed$79 = {
                            0
                        };
                        final long temp$78 = parseNumber(s, valuePos, 1, 2, true, out$numParsed$79);
                        numParsed = out$numParsed$79[0];
                        hour = (int) temp$78;
                    }
                    if (hour > 12) {
                        return false;
                    }
                    if (hour == 12) {
                        hour = 0;
                    }
                    break;
                }
                case 'H': {
                    if (hour != -1 || !flexibleTwoPartsParsing && ampm >= 0) {
                        return false;
                    }
                    if (num == 0) {
                        final int[] out$numParsed$81 = {
                            0
                        };
                        final long temp$80 = parseNumber(s, valuePos, 1, 2, false, out$numParsed$81);
                        numParsed = out$numParsed$81[0];
                        hour = (int) temp$80;
                    } else {
                        final int[] out$numParsed$83 = {
                            0
                        };
                        final long temp$82 = parseNumber(s, valuePos, 1, 2, true, out$numParsed$83);
                        numParsed = out$numParsed$83[0];
                        hour = (int) temp$82;
                    }
                    if (hour >= 24) {
                        return false;
                    }
                    break;
                }
                case 'm': {
                    if (minute != -1) {
                        return false;
                    }
                    if (num == 0) {
                        final int[] out$numParsed$85 = {
                            0
                        };
                        final long temp$84 = parseNumber(s, valuePos, 1, 2, false, out$numParsed$85);
                        numParsed = out$numParsed$85[0];
                        minute = (int) temp$84;
                    } else {
                        final int[] out$numParsed$87 = {
                            0
                        };
                        final long temp$86 = parseNumber(s, valuePos, 1, 2, true, out$numParsed$87);
                        numParsed = out$numParsed$87[0];
                        minute = (int) temp$86;
                    }
                    if (minute >= 60) {
                        return false;
                    }
                    break;
                }
                case 's': {
                    if (second != -1) {
                        return false;
                    }
                    if (num == 0) {
                        final int[] out$numParsed$89 = {
                            0
                        };
                        final long temp$88 = parseNumber(s, valuePos, 1, 2, false, out$numParsed$89);
                        numParsed = out$numParsed$89[0];
                        second = (int) temp$88;
                    } else {
                        final int[] out$numParsed$91 = {
                            0
                        };
                        final long temp$90 = parseNumber(s, valuePos, 1, 2, true, out$numParsed$91);
                        numParsed = out$numParsed$91[0];
                        second = (int) temp$90;
                    }
                    break;
                }
                case 'F':
                case 'f': {
                    boolean leadingZeros = chars.charAt(pos) == 'f';
                    if (fractionalSeconds != -1) {
                        return false;
                    }
                    final int[] out$numParsed$92 = {
                        0
                    };
                    double decimalNumber = parseNumber(s, valuePos, 0, num + 1, leadingZeros, out$numParsed$92);
                    numParsed = out$numParsed$92[0];
                    if (numParsed == -1) {
                        return false;
                    }
                    fractionalSeconds = decimalNumber / Math.pow(10.0, numParsed);
                    break;
                }
                case 't': {
                    final int[] out$numParsed$94 = {
                        0
                    };
                    final int[] ref$ampm$95 = {
                        ampm
                    };
                    final boolean temp$93 = parseAmPm(s, valuePos, num > 0 ? 0 : 1, dfi, exact, out$numParsed$94, ref$ampm$95);
                    ampm = ref$ampm$95[0];
                    numParsed = out$numParsed$94[0];
                    if (!temp$93) {
                        return false;
                    }
                    break;
                }
                case ':': {
                    final int[] out$numParsed$97 = {
                        0
                    };
                    final boolean temp$96 = parseTimeSeparator(s, valuePos, dfi, exact, out$numParsed$97);
                    numParsed = out$numParsed$97[0];
                    if (!temp$96) {
                        return false;
                    }
                    break;
                }
                case '/': {
                    final int[] out$numParsed$99 = {
                        0
                    };
                    final boolean temp$98 = parseDateSeparator(s, valuePos, dfi, exact, out$numParsed$99);
                    numParsed = out$numParsed$99[0];
                    if (!temp$98) {
                        return false;
                    }
                    num = 0;
                    break;
                }
                default: {
                    if (s.charAt(valuePos) != chars.charAt(pos)) {
                        return false;
                    }
                    num = 0;
                    numParsed = 1;
                    break;
                }
                }
                if (numParsed < 0) {
                    return false;
                }
                valuePos += numParsed;
                if (!exact && !flexibleTwoPartsParsing) {
                    switch (chars.charAt(pos)) {
                    case 'm':
                    case 's':
                    case 'F':
                    case 'f':
                    case 'z': {
                        if (s.length() > valuePos && s.charAt(valuePos) == 'Z' && (pos + 1 == chars.length() || chars.charAt(pos + 1) != 'Z')) {
                            valuePos++;
                        }
                        break;
                    }
                    }
                }
                pos = pos + num + 1;
                num = 0;
            }
            if (pos + 1 < len && chars.charAt(pos) == '.' && chars.charAt(pos + 1) == 'F') {
                pos++;
                // '.FFF....' can be mapped to nothing. See bug #444103
                while (pos < len && chars.charAt(pos) == 'F')
                    pos++;
            }
            // 'K' can be mapped to nothing
            while (pos < len && chars.charAt(pos) == 'K')
                pos++;
            if (pos < len) {
                return false;
            }
            if (s.length() > valuePos) {
                // extraneous tail.
                if (valuePos == 0) {
                    return false;
                }
                if (Character.isDigit(s.charAt(valuePos)) && Character.isDigit(s.charAt(valuePos - 1))) {
                    return false;
                }
                if (Character.isLetter(s.charAt(valuePos)) && Character.isLetter(s.charAt(valuePos - 1))) {
                    return false;
                }
                incompleteFormat[0] = true;
                return false;
            }
            if (hour == -1) {
                hour = 0;
            }
            if (minute == -1) {
                minute = 0;
            }
            if (second == -1) {
                second = 0;
            }
            if (fractionalSeconds == -1) {
                fractionalSeconds = 0D;
            }
            // If no date was given
            if ((day == -1) && (month == -1) && (year == -1)) {
                day = DateTimeHelper.today().getDayOfMonth();
                month = DateTimeHelper.today().getMonthOfYear();
                year = DateTimeHelper.today().getYear();
            }
            if (day == -1) {
                day = 1;
            }
            if (month == -1) {
                month = 1;
            }
            if (year == -1) {
                year = DateTimeHelper.today().getYear();
            }
            if (ampm == 0 && hour == 12) {
                hour = 0;
            }
            if (ampm == 1 && (!flexibleTwoPartsParsing || hour < 12)) {
                hour = hour + 12;
            }
            try {
                result[0] = new GregorianDate(year, month, day, hour, minute, second + fractionalSeconds);
            } catch (ArgumentException _ex) {
                return false;
            }
            return true;
        }

        private static String getStandardPattern(char format, DateTimeFormatInfo dfi, boolean[] useInvariant) {
            String pattern;
            useInvariant[0] = false;
            switch (format) {
            case 'd': {
                pattern = dfi.getShortDatePattern();
                break;
            }
            case 'D': {
                pattern = dfi.getLongDatePattern();
                break;
            }
            case 'f': {
                pattern = dfi.getLongDatePattern() + " " + dfi.getShortTimePattern();
                break;
            }
            case 'F': {
                pattern = dfi.getFullDateTimePattern();
                break;
            }
            case 'g': {
                pattern = dfi.getShortDatePattern() + " " + dfi.getShortTimePattern();
                break;
            }
            case 'G': {
                pattern = dfi.getShortDatePattern() + " " + dfi.getLongTimePattern();
                break;
            }
            case 'm':
            case 'M': {
                pattern = dfi.getMonthDayPattern();
                break;
            }
            case 'r':
            case 'R': {
                pattern = dfi.getRFC1123Pattern();
                useInvariant[0] = true;
                break;
            }
            case 's': {
                pattern = dfi.getSortableDateTimePattern();
                useInvariant[0] = true;
                break;
            }
            case 't': {
                pattern = dfi.getShortTimePattern();
                break;
            }
            case 'T': {
                pattern = dfi.getLongTimePattern();
                break;
            }
            case 'u': {
                pattern = dfi.getUniversalSortableDateTimePattern();
                useInvariant[0] = true;
                break;
            }
            case 'U': {
                pattern = dfi.getFullDateTimePattern();
                break;
            }
            case 'y':
            case 'Y': {
                pattern = dfi.getYearMonthPattern();
                break;
            }
            default: {
                pattern = null;
                break;
            }
            }
            return pattern;
        }

        private static int countRepeat(String fmt, int p, char c) {
            int l = fmt.length();
            int i = p + 1;
            while ((i < l) && (fmt.charAt(i) == c))
                i++;
            return i - p;
        }

        private static void zeroPad(StringBuilder output, long digits, int len) {
            // more than enough for an int
            char[] buffer = new char[16];
            int pos = 16;
            do {
                buffer[--pos] = (char) ('0' + digits % 10);
                digits /= 10L;
                len--;
            } while (digits > 0);
            while (len-- > 0)
                buffer[--pos] = '0';
            output.append(new String(buffer, pos, 16 - pos));
        }

        private static int parseQuotedString(String fmt, int pos, StringBuilder output) {
            // pos == position of " or '
            int len = fmt.length();
            int start = pos;
            char quoteChar = fmt.charAt(pos++);
            while (pos < len) {
                char ch = fmt.charAt(pos++);
                if (ch == quoteChar) {
                    return pos - start;
                }
                if (ch == '\\') {
                    // C-Style escape
                    if (pos >= len) {
                        throw new NumberFormatException(CesiumLocalization.getGregorianDateQuoteNotTerminated());
                    }
                    output.append(fmt.charAt(pos++));
                } else {
                    output.append(ch);
                }
            }
            throw new NumberFormatException(CesiumLocalization.getGregorianDateQuoteNotTerminated());
        }

        // This is intended as a last resort when all the other formats fail to parse a "day of year" format
        // This will throw exceptions if it cannot parse the string
        private static boolean parseIso8601DayOfYear(String isoString, DateTimeFormatInfo dfi, GregorianDate[] result, boolean setExceptionOnError, NumberFormatException[] exception) {
            // This is a last resort case to handle the ISO8601 "day of year" format supported by STK
            // Format: yyyy-dddTHH:mm:ss.f*
            result[0] = new GregorianDate();
            String[] tokens = StringHelper.split(isoString, '-');
            if (tokens.length != 2) {
                // In this case we simply have no idea what this format is.
                // Defer the exception to the surrounding code
                return false;
            }
            int yr4 = 0;
            boolean temp$100 = tokens[0].length() != 4;
            if (!temp$100) {
                final int[] out$yr4$101 = {
                    0
                };
                temp$100 = !IntHelper.tryParse(tokens[0], out$yr4$101);
                yr4 = out$yr4$101[0];
            }
            if (temp$100) {
                exception[0] = new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateStringNotRecognized(), isoString));
                if (setExceptionOnError) {
                    return false;
                } else {
                    throw exception[0];
                }
            }
            tokens = StringHelper.split(tokens[1], 'T');
            int doy = 0;
            final int[] out$doy$103 = {
                0
            };
            final boolean temp$102 = IntHelper.tryParse(tokens[0], out$doy$103);
            doy = out$doy$103[0];
            // The 366 out-of-range check below will handle cases where there are 4 or more digits
            if (!temp$102) {
                exception[0] = new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateStringNotRecognized(), isoString));
                if (setExceptionOnError) {
                    return false;
                } else {
                    throw exception[0];
                }
            }
            if (doy > 366) {
                exception[0] = new NumberFormatException(StringHelper.format(CesiumLocalization.getDayOfYearOutOfRange(), isoString));
                if (setExceptionOnError) {
                    return false;
                } else {
                    throw exception[0];
                }
            }
            if (tokens.length > 1) {
                // Let the existing code handle the time portion
                boolean incompleteFormat = true, longYear = false;
                for (int j = 0; j < s_parseTimeFormats.length; j++) {
                    final boolean[] ref$incompleteFormat$105 = {
                        incompleteFormat
                    };
                    final boolean[] ref$longYear$106 = {
                        longYear
                    };
                    final boolean temp$104 = doParse(tokens[1], s_parseTimeFormats[j], null, false, result, dfi, ref$incompleteFormat$105, ref$longYear$106);
                    longYear = ref$longYear$106[0];
                    incompleteFormat = ref$incompleteFormat$105[0];
                    if (temp$104) {
                        break;
                    }
                }
            }
            result[0] = new GregorianDate(yr4, doy, result[0].getHour(), result[0].getMinute(), result[0].getSecond());
            return true;
        }

        public static String toString(GregorianDate dt, String format, Locale provider) {
            DateTimeFormatInfo dfi = DateTimeFormatInfo.getInstance(provider);
            NumberFormatInfo nfi = NumberFormatInfo.getInstance(provider);
            if (StringHelper.isNullOrEmpty(format)) {
                format = "G";
            }
            boolean useInvariant = false;
            if (format.length() == 1) {
                char fchar = format.charAt(0);
                final boolean[] out$useInvariant$108 = {
                    false
                };
                final String temp$107 = getStandardPattern(fchar, dfi, out$useInvariant$108);
                useInvariant = out$useInvariant$108[0];
                format = temp$107;
                if (format == null) {
                    throw new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateInvalidFormatSpecifier(), fchar));
                }
            }
            // the length of the format is usually a good guess of the number
            // of chars in the result. Might save us a few bytes sometimes
            // Add + 10 for cases like mmmm dddd
            StringBuilder result = new StringBuilder(format.length() + 10);
            // For some cases, the output should not use culture dependent calendar
            if (useInvariant) {
                dfi = DateTimeFormatInfo.getInvariantInfo();
                nfi = NumberFormatInfo.getInvariantInfo();
            }
            int i = 0;
            while (i < format.length()) {
                int tokLen;
                char ch = format.charAt(i);
                // catch all
                switch (ch) {
                case 'h': {
                    tokLen = countRepeat(format, i, ch);
                    int hr = dt.getHour() % 12;
                    if (hr == 0) {
                        hr = 12;
                    }
                    zeroPad(result, hr, tokLen == 1 ? 1 : 2);
                    break;
                }
                case 'H': {
                    tokLen = countRepeat(format, i, ch);
                    zeroPad(result, dt.getHour(), tokLen == 1 ? 1 : 2);
                    break;
                }
                case 'm': {
                    tokLen = countRepeat(format, i, ch);
                    zeroPad(result, dt.getMinute(), tokLen == 1 ? 1 : 2);
                    break;
                }
                case 's': {
                    tokLen = countRepeat(format, i, ch);
                    zeroPad(result, (int) dt.getSecond(), tokLen == 1 ? 1 : 2);
                    break;
                }
                case 'F':
                case 'f': {
                    tokLen = countRepeat(format, i, ch);
                    if (tokLen > 15) {
                        throw new NumberFormatException(CesiumLocalization.getGregorianDateFormatInvalid());
                    }
                    int startLen = result.length();
                    String formattedSeconds = DoubleHelper.toString(dt.getSecond(), "R", provider);
                    formattedSeconds = StringFormatting.toNonExponentialNotation(nfi, formattedSeconds);
                    int indexOfDecimalPoint = formattedSeconds.indexOf(nfi.getNumberDecimalSeparator());
                    if (indexOfDecimalPoint == -1) {
                        indexOfDecimalPoint = formattedSeconds.length();
                    }
                    int digitsAfterDecimalPoint = formattedSeconds.length() - indexOfDecimalPoint - 1;
                    if (digitsAfterDecimalPoint > tokLen) {
                        formattedSeconds = StringHelper.substring(formattedSeconds, 0, tokLen + indexOfDecimalPoint + 1);
                    } else if (digitsAfterDecimalPoint < tokLen) {
                        formattedSeconds = StringHelper.padRight(formattedSeconds, tokLen + indexOfDecimalPoint + 1, '0');
                    }
                    StringHelper.append(result, formattedSeconds, indexOfDecimalPoint + nfi.getNumberDecimalSeparator().length(), formattedSeconds.length() - indexOfDecimalPoint
                            - nfi.getNumberDecimalSeparator().length());
                    if (ch == 'F') {
                        while (result.length() > startLen && result.charAt(result.length() - 1) == '0')
                            result.setLength(result.length() - 1);
                        // when the value was 0, then trim even preceding '.' (!) It is fixed character.
                        if (result.length() == startLen && startLen >= nfi.getNumberDecimalSeparator().length()) {
                            boolean matchesSeparator = true;
                            for (int separatorIndex = 0; matchesSeparator && separatorIndex < nfi.getNumberDecimalSeparator().length(); ++separatorIndex) {
                                matchesSeparator = result.charAt(result.length() - nfi.getNumberDecimalSeparator().length() + separatorIndex) == nfi.getNumberDecimalSeparator().charAt(separatorIndex);
                            }
                            if (matchesSeparator) {
                                result.setLength(result.length() - nfi.getNumberDecimalSeparator().length());
                            }
                        }
                    }
                    break;
                }
                case 't': {
                    tokLen = countRepeat(format, i, ch);
                    String desig = dt.getHour() < 12 ? dfi.getAMDesignator() : dfi.getPMDesignator();
                    if (tokLen == 1) {
                        if (desig.length() >= 1) {
                            result.append(desig.charAt(0));
                        }
                    } else {
                        result.append(desig);
                    }
                    break;
                }
                case 'd': {
                    tokLen = countRepeat(format, i, ch);
                    if (tokLen <= 2) {
                        zeroPad(result, dt.getDay(), tokLen == 1 ? 1 : 2);
                    } else if (tokLen == 3) {
                        result.append(dfi.getAbbreviatedDayName(dt.getDayOfWeek()));
                    } else {
                        result.append(dfi.getDayName(dt.getDayOfWeek()));
                    }
                    break;
                }
                case 'M': {
                    tokLen = countRepeat(format, i, ch);
                    int month = dt.getMonth();
                    if (tokLen <= 2) {
                        zeroPad(result, month, tokLen);
                    } else if (tokLen == 3) {
                        result.append(dfi.getAbbreviatedMonthName(month));
                    } else {
                        result.append(dfi.getMonthName(month));
                    }
                    break;
                }
                case 'y': {
                    tokLen = countRepeat(format, i, ch);
                    if (tokLen <= 2) {
                        zeroPad(result, dt.getYear() % 100, tokLen);
                    } else {
                        zeroPad(result, dt.getYear(), tokLen);
                    }
                    break;
                }
                case 'g': {
                    tokLen = countRepeat(format, i, ch);
                    result.append(dfi.getEraName(1));
                    break;
                }
                case ':': {
                    result.append(dfi.getTimeSeparator());
                    tokLen = 1;
                    break;
                }
                case '/': {
                    result.append(dfi.getDateSeparator());
                    tokLen = 1;
                    break;
                }
                case '\'':
                case '"': {
                    tokLen = parseQuotedString(format, i, result);
                    break;
                }
                case '%': {
                    if (i >= format.length() - 1) {
                        throw new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateInvalidCharacterAtEnd(), "%"));
                    }
                    if (format.charAt(i + 1) == '%') {
                        throw new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateInvalidCharacter(), "%%"));
                    }
                    // Look for the next char
                    tokLen = 1;
                    break;
                }
                case '\\': {
                    if (i >= format.length() - 1) {
                        throw new NumberFormatException(StringHelper.format(CesiumLocalization.getGregorianDateInvalidCharacterAtEnd(), "\\"));
                    }
                    result.append(format.charAt(i + 1));
                    tokLen = 2;
                    break;
                }
                case '.': {
                    result.append(nfi.getNumberDecimalSeparator());
                    tokLen = nfi.getNumberDecimalSeparator().length();
                    break;
                }
                default: {
                    result.append(ch);
                    tokLen = 1;
                    break;
                }
                }
                i += tokLen;
            }
            return result.toString();
        }

        /**
        *  
        Don't use these patterns directly.  Instead get your patterns from
        {@link #buildDateTimePatterns}.
        

        */
        private static String[] s_extraDateTimePatternTemplates = {
                "M/d/yyyy H:mm:ss.f*",
                "d MMM yyyy H:mm:ss.f*",
                "yyyy-M-dTHH:mm:ss.f*",
                "M-yyyy-dTH:mm:ss.f*",
                "M-yyyy-d H:mm:ss.f*",
                "yyyyMMddTHHmmss.f*"
        };
        // DateTime.Parse patterns
        // Patterns are divided to date and time patterns. The algorithm will
        // try combinations of these patterns. The algorithm also looks for
        // day of the week, AM/PM GMT and Z independently of the patterns.
        private static String[] s_parseTimeFormatsTemplate = {
                "H:m:s.f*",
                "H:m:s",
                "H:m",
                "H tt",
                "H'\u6642'm'\u5206's'\u79d2'"
        };
        // Specifies AM to disallow '8'.
        private static String[] s_extraDateTimePatterns = buildDateTimePatterns(s_extraDateTimePatternTemplates, 17);
        private static String[] s_parseTimeFormats = buildDateTimePatterns(s_parseTimeFormatsTemplate, 17);
        // DateTime.Parse date patterns extend ParseExact patterns as follows:
        //   MMM - month short name or month full name
        //   MMMM - month number or short name or month full name
        // Parse behaves differently according to the ShortDatePattern of the
        // DateTimeFormatInfo. The following define the date patterns for
        // different orders of day, month and year in ShortDatePattern.
        // Note that the year cannot go between the day and the month.
        private static String[] s_parseYearDayMonthFormats = {
                "yyyy/M/dT",
                "M/yyyy/dT",
                "yyyy'\u5e74'M'\u6708'd'\u65e5",
                "yyyy/d/MMMM",
                "yyyy/MMM/d",
                "d/MMMM/yyyy",
                "MMM/d/yyyy",
                "d/yyyy/MMMM",
                "MMM/yyyy/d",
                "yy/d/M"
        };
        private static String[] s_parseYearMonthDayFormats = {
                "yyyy/M/dT",
                "M/yyyy/dT",
                "yyyy'\u5e74'M'\u6708'd'\u65e5",
                "yyyy/MMMM/d",
                "yyyy/d/MMM",
                "MMMM/d/yyyy",
                "d/MMM/yyyy",
                "MMMM/yyyy/d",
                "d/yyyy/MMM",
                "yy/MMMM/d",
                "yy/d/MMM",
                "MMM/yy/d"
        };
        private static String[] s_parseDayMonthYearFormats = {
                "yyyy/M/dT",
                "M/yyyy/dT",
                "yyyy'\u5e74'M'\u6708'd'\u65e5",
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
                "MMM/yy/d"
        };
        private static String[] s_parseMonthDayYearFormats = {
                "yyyy/M/dT",
                "M/yyyy/dT",
                "yyyy'\u5e74'M'\u6708'd'\u65e5",
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
                "yy/d/MMM"
        };
        // Patterns influenced by the MonthDayPattern in DateTimeFormatInfo.
        // Note that these patterns cannot be followed by the time.
        private static String[] s_monthDayShortFormats = {
                "MMMM/d",
                "d/MMM",
                "yyyy/MMMM"
        };
        private static String[] s_dayMonthShortFormats = {
                "d/MMMM",
                "MMM/yy",
                "yyyy/MMMM"
        };
    }

    /**
    *  
    Initializes a {@link GregorianDate} from the provided values.
    
    
    
    
    
    
    
    

    * @param year The year.
    * @param month The month of the year (in the range 1 through 12)
    * @param day The day of the month (in the range 1 through the number of
    days in {@code month})
    * @param hour The hour (in the range 0 through 23).
    * @param minute The minute (in the range 0 through 59).
    * @param second The second, including fractional seconds (in the range 0.0
    up to, but not including, 61.0).  A second between 60.0 and 61.0 (a leap
    second) is only valid if the overall time is during one of the official leap
    seconds. 
    * @exception ArgumentException 
    Thrown when one of the provided parameters is outside of its acceptable range.
    
    */
    public GregorianDate(int year, int month, int day, int hour, int minute, double second) {
        if (isValid(year, month, day, hour, minute, second)) {
            m_yearMonthDay = new YearMonthDay(year, month, day);
            m_hour = hour;
            m_minute = minute;
            m_second = second;
        } else {
            throw new ArgumentException(CesiumLocalization.getHourMinuteSecondInvalidArgument());
        }
    }

    /**
    *  
    Initializes a {@link GregorianDate} from the provided values.  The
    remaining values are assumed to be zero.
    
    
    
    
    

    * @param year The year.
    * @param month The month of the year (in the range 1 through 12)
    * @param day The day of the month (in the range 1 through the number of
    days in {@code month})
    * @exception ArgumentException 
    Thrown when one of the provided parameters is outside of its acceptable range.
    
    */
    public GregorianDate(int year, int month, int day) {
        this(year, month, day, 0, 0, 0);
    }

    /**
    *  
    Initializes a {@link GregorianDate} from the provided values.
    
    
    
    
    
    
    

    * @param year The year.
    * @param dayOfYear The day of year
    (in the range 1 through the number of days in the given year).
    * @param hour The hour (in the range 0 through 23).
    * @param minute The minute (in the range 0 through 59).
    * @param second The second, including fractional seconds (in the range 0.0
    up to, but not including, 61.0).  A second between 60.0 and 61.0 (a leap
    second) is only valid if the overall time is during one of the official leap
    seconds. 
    * @exception ArgumentException 
    Thrown when one of the provided parameters is outside of its acceptable range.
    
    */
    public GregorianDate(int year, int dayOfYear, int hour, int minute, double second) {
        YearMonthDay ymd = new YearMonthDay(year, dayOfYear);
        if (isValid(year, ymd.getMonth(), ymd.getDay(), hour, minute, second)) {
            m_yearMonthDay = ymd;
            m_hour = hour;
            m_minute = minute;
            m_second = second;
        } else {
            throw new ArgumentException(CesiumLocalization.getHourMinuteSecondInvalidArgument());
        }
    }

    /**
    *  
    Initializes a {@link GregorianDate} from the provided values.  The
    fractional portion of the {@code daysOfYear} will be converted into
    hours, minutes, and seconds.
    
    
    

    * @param year The year.
    * @param daysOfYear The day of year plus the fractional portion of the day
    (in the range 1 through the number of days in the given year).
    */
    public GregorianDate(int year, double daysOfYear) {
        m_yearMonthDay = new YearMonthDay(year, (int) daysOfYear);
        double fraction = daysOfYear % 1;
        double seconds = fraction * 86400.0;
        m_hour = (int) (seconds / SecondsPerHour);
        seconds -= m_hour * SecondsPerHour;
        m_minute = (int) (seconds / SecondsPerMinute);
        seconds -= m_minute * SecondsPerMinute;
        m_second = seconds;
    }

    /**
    *  
    Initializes a {@link GregorianDate} from the provided
    {@link JulianDate}.  The new {@link GregorianDate} will be in the
    {@link TimeStandard#COORDINATED_UNIVERSAL_TIME} (UTC) time standard.
    
    

    * @param julianDate The {@link JulianDate}.
    */
    public GregorianDate(JulianDate julianDate) {
        this(julianDate, TimeStandard.COORDINATED_UNIVERSAL_TIME);
    }

    /**
    *  
    Initializes a {@link GregorianDate} from the provided
    {@link JulianDate}.  The new {@link GregorianDate} will be in the
    provided {@link TimeStandard}.
    
    
    

    * @param julianDate The {@link JulianDate}.
    * @param timeStandard 
    The {@link TimeStandard} to represent the new {@link GregorianDate}
    in.
    
    */
    public GregorianDate(JulianDate julianDate, TimeStandard timeStandard) {
        boolean isLeapSecond = false;
        @CS2JInfo("Initialization of C# struct variable 'convertedJulianDate' added by translator.")
        JulianDate convertedJulianDate = new JulianDate();
        final JulianDate[] out$convertedJulianDate$110 = {
            null
        };
        final boolean temp$109 = julianDate.tryConvertTimeStandard(timeStandard, out$convertedJulianDate$110);
        convertedJulianDate = out$convertedJulianDate$110[0];
        if (!temp$109) {
            isLeapSecond = true;
            convertedJulianDate = julianDate.subtractSeconds(1D).toTimeStandard(timeStandard);
        }
        m_yearMonthDay = new YearMonthDay(convertedJulianDate);
        double secondsOfDay = convertedJulianDate.getSecondsOfDay();
        m_hour = (int) Math.floor(secondsOfDay / SecondsPerHour);
        double remainingSeconds = secondsOfDay - m_hour * SecondsPerHour;
        m_minute = (int) Math.floor(remainingSeconds / SecondsPerMinute);
        m_second = secondsOfDay - (m_hour * SecondsPerHour + m_minute * SecondsPerMinute);
        if (isLeapSecond) {
            m_second += 1D;
        }
        // JulianDates are noon-based
        m_hour += 12;
        if (m_hour > 23) {
            m_hour -= 24;
        }
    }

    /**
    *  
    Initializes a {@link GregorianDate} from the provided
    {@link DateTime}.  If the provided {@link DateTime} is in local
    time, it is converted to UTC.
    
    

    * @param dateTime The {@link DateTime}.
    */
    public GregorianDate(DateTime dateTime) {
        if (dateTime.getZone() == DateTimeZone.getDefault()) {
            dateTime = dateTime.withZone(org.joda.time.DateTimeZone.UTC);
        }
        m_yearMonthDay = new YearMonthDay(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth());
        m_hour = dateTime.getHourOfDay();
        m_minute = dateTime.getMinuteOfHour();
        final long ticksPerMinute = 600000000L;
        final double ticksPerSecond = 1.0e7;
        m_second = DateTimeHelper.getTicks(dateTime) % ticksPerMinute / ticksPerSecond;
    }

    /**
    *  Gets the year.
    

    */
    public final int getYear() {
        return m_yearMonthDay.getYear();
    }

    /**
    *  Gets the month of the year (in the range 1 through 12).
    

    */
    public final int getMonth() {
        return m_yearMonthDay.getMonth();
    }

    /**
    *  Gets the day of the month (in the range 1 through the number of days in the
    month).
    

    */
    public final int getDay() {
        return m_yearMonthDay.getDay();
    }

    /**
    *  Gets the hour (in the range 0 through 23).
    

    */
    public final int getHour() {
        return m_hour;
    }

    /**
    *  Gets the minute (in the range 0 through 59).
    

    */
    public final int getMinute() {
        return m_minute;
    }

    /**
    *  Gets the second, including fractional seconds (in the range 0.0 up to, but not
    including, 61.0).  A value between 60.0 and 61.0 indicates a leap second.
    

    */
    public final double getSecond() {
        return m_second;
    }

    /**
    *  Gets the corresponding seconds past midnight for this instance.
    

    */
    public final double getSecondsOfDay() {
        return m_second + m_hour * SecondsPerHour + m_minute * SecondsPerMinute;
    }

    /**
    *  Gets the corresponding seconds past noon for this instance.
    

    */
    public final double getJulianSecondsOfDay() {
        // JulianDates are noon-based
        int hour = m_hour - 12;
        if (hour < 0) {
            hour += 24;
        }
        return m_second + hour * SecondsPerHour + m_minute * SecondsPerMinute;
    }

    /**
    *  Gets the day of the week represented by this instance.
    

    * @return A {@code DayOfWeek} ({@link #getDayOfWeek get}) enumerated constant that indicates the day
    of the week. This property value ranges from zero, indicating Sunday, to six,
    indicating Saturday.
    */
    public final int getDayOfWeek() {
        return m_yearMonthDay.getDayOfWeek();
    }

    /**
    *  Gets the day of the year represented by this instance.
    

    * @return An integer that indicates the day of the year.
    This property value ranges from 1 through the number of days in the year.
    */
    public final int getDayOfYear() {
        return m_yearMonthDay.getDayOfYear();
    }

    /**
    *  
    Indicates whether or not this {@link GregorianDate} represents a leap
    second.
    

    */
    private final boolean getIsLeapSecond() {
        return m_second >= 60.0;
    }

    /**
    *  
    Indicates whether the date values provided are a valid representation of a date
    and time.
    
    
    
    
    
    
    
    

    * @param year The year.
    * @param month The month of the year (in the range 1 through 12)
    * @param day The day of the month (in the range 1 through the number of
    days in {@code month})
    * @param hour The hour (in the range 0 through 23).
    * @param minute The minute (in the range 0 through 59).
    * @param second The second, including fractional seconds (in the range 0.0
    up to, but not including, 61.0).  A second between 60.0 and 61.0 (a leap
    second) is only valid if the overall time is during one of the official leap
    seconds. 
    * @return true if the representation is valid and false if it is not.
    */
    public static boolean isValid(int year, int month, int day, int hour, int minute, double second) {
        boolean hourInvalid = hour < 0 || hour >= 24;
        boolean minuteInvalid = minute < 0 || minute >= 60;
        boolean secondInvalid = second < 0 || second >= 61;
        if (hourInvalid || minuteInvalid || secondInvalid) {
            return false;
        }
        if (!YearMonthDay.isValidDate(year, month, day)) {
            return false;
        }
        if (second >= 60 && second < 61) {
            //check to see if it's a valid leap second
            boolean dayHasLeapSecond = LeapSeconds.getInstance().doesDayHaveLeapSecond(new YearMonthDay(year, month, day).getJulianDayNumber());
            return dayHasLeapSecond && hour == 23 && minute == 59;
        }
        return true;
    }

    /**
    * 
    Convert this {@link GregorianDate} to a {@link JulianDate}. The
    time standard will be {@link TimeStandard#COORDINATED_UNIVERSAL_TIME}
    (UTC), unless this  {@link GregorianDate} represents the instant of a
    leap second, in which case the {@link JulianDate} will be in
    {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI).



    * @return A {@link JulianDate} representing this date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final JulianDate toJulianDate() {
        return toJulianDate(TimeStandard.COORDINATED_UNIVERSAL_TIME);
    }

    /**
    * 
    Convert this {@link GregorianDate} to a {@link JulianDate}.  The
    {@link GregorianDate} is assumed to specify a time in the
    specified {@link TimeStandard}.




    * @param timeStandard 
    The time standard in which this {@link GregorianDate} is expressed.  The returned
    {@link JulianDate} will be expressed in this time standard as well, if possible.

    * @return A {@link JulianDate} representing this date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final JulianDate toJulianDate(TimeStandard timeStandard) {
        int julianDayNumber = m_yearMonthDay.getJulianDayNumber();
        double julianSecondsOfDay = getJulianSecondsOfDay();
        if (getIsLeapSecond()) {
            julianSecondsOfDay -= 1D;
        } else if (julianSecondsOfDay >= 43200.0) {
            julianDayNumber -= 1;
        }
        JulianDate result = new JulianDate(julianDayNumber, julianSecondsOfDay, timeStandard);
        if (getIsLeapSecond()) {
            result = result.addSeconds(1D);
        }
        return result;
    }

    /**
    * Convert this {@link GregorianDate} to a {@link DateTime}.
    The {@link DateTime} will be in UTC.



    * @return A {@link DateTime} representing this date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final DateTime toDateTime() {
        DateTime date = new DateTime(m_yearMonthDay.getYear(), m_yearMonthDay.getMonth(), m_yearMonthDay.getDay(), 0, 0, 0, 0, org.joda.time.DateTimeZone.UTC);
        final long ticksPerHour = 36000000000L;
        final long ticksPerMinute = 600000000L;
        final long ticksPerSecond = 10000000L;
        long ticks = DateTimeHelper.getTicks(date);
        ticks += m_hour * ticksPerHour;
        ticks += m_minute * ticksPerMinute;
        ticks += (long) (MathHelper.round(m_second, 7) * ticksPerSecond);
        return DateTimeHelper.fromTicks(ticks, DateTimeZone.UTC);
    }

    /**
    *  
    Rounds this instance to the specified number of decimal digits in the seconds, rolling over to minutes, hours, days,
    etc. as necessary.  This instance is assumed to express a time in the {@link TimeStandard#COORDINATED_UNIVERSAL_TIME}
    (UTC) time standard so the {@code Second} ({@link #getSecond get}) will be allowed to go above 60 during a leap second.
    
    
    

    * @param digits The number of digits after the decimal point to include in the seconds.
    * @return The rounded date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final GregorianDate roundSeconds(int digits) {
        return roundSeconds(digits, TimeStandard.COORDINATED_UNIVERSAL_TIME);
    }

    /**
    *  
    Rounds this instance to the specified number of decimal digits in the seconds, rolling over to minutes, hours, days,
    etc. as necessary.  If the specified {@code timeStandard} is {@link TimeStandard#COORDINATED_UNIVERSAL_TIME},
    (UTC), the seconds will be allowed to go above 60 during a leap second.  For any other time standard, the
    {@code Second} ({@link #getSecond get}) will be below 60.
    
    
    
    

    * @param digits The number of digits after the decimal point to include in the seconds.
    * @param timeStandard The time standard in which this {@link GregorianDate} is expressed.
    * @return The rounded date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final GregorianDate roundSeconds(int digits, TimeStandard timeStandard) {
        double maxSeconds = 60.0;
        if (timeStandard == TimeStandard.COORDINATED_UNIVERSAL_TIME && m_hour == 23 && m_minute == 59
                && LeapSeconds.getInstance().doesDayHaveLeapSecond(new YearMonthDay(getYear(), getMonth(), getDay()).getJulianDayNumber())) {
            maxSeconds = 61.0;
        }
        int year = getYear();
        int month = getMonth();
        int day = getDay();
        int hour = m_hour;
        int minute = m_minute;
        double roundedSeconds = MathHelper.round(m_second, digits);
        if (roundedSeconds >= maxSeconds) {
            roundedSeconds = 0.0;
            ++minute;
        }
        if (minute > 59) {
            minute = 0;
            ++hour;
        }
        if (hour > 23) {
            hour = 0;
            ++day;
        }
        if (!YearMonthDay.isValidDate(year, month, day)) {
            day = 1;
            ++month;
        }
        if (!YearMonthDay.isValidDate(year, month, day)) {
            month = 1;
            ++year;
        }
        return new GregorianDate(year, month, day, hour, minute, roundedSeconds);
    }

    /**
    *  
    Compares this instance with another instance of the same type.
    
    
    

    * @param other An object to compare with this instance.
    * @return 
    A value indicating the relative order of the objects being compared.  The return value has these meanings:
    <table border="1"><tr></tr><tr><th></th><th>Value</th><th></th><th>Meaning</th><th></th></tr><tr></tr><tr><td></td><td>Less than zero</td><td></td><td>
    This instance is less than {@code other}.
    </td><td></td></tr><tr></tr><tr><td></td><td>Zero</td><td></td><td>
    This instance is equal to {@code other}.
    </td><td></td></tr><tr></tr><tr><td></td><td>Greater than zero</td><td></td><td>
    This instance is greater than {@code other}.
    </td><td></td></tr><tr></tr></table>
    
    */
    public final int compareTo(GregorianDate other) {
        int result = m_yearMonthDay.compareTo(other.m_yearMonthDay);
        if (result == 0) {
            if (m_hour != other.m_hour) {
                return m_hour < other.m_hour ? -1 : 1;
            }
            if (m_minute != other.m_minute) {
                return m_minute < other.m_minute ? -1 : 1;
            }
            return m_second == other.m_second ? 0 : (m_second < other.m_second ? -1 : 1);
        }
        return result;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(m_yearMonthDay.hashCode(), PrimitiveHelper.hashCode(m_hour), PrimitiveHelper.hashCode(m_minute), PrimitiveHelper.hashCode(m_second));
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof GregorianDate && equalsType((GregorianDate) obj);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    public final boolean equalsType(GregorianDate other) {
        return compareTo(other) == 0;
    }

    /**
    *  Converts the value of this instance to its equivalent string
    representation.
    

    * @return A string representation of value of this instance.
    */
    @Override
    public String toString() {
        return toString(null, null);
    }

    /**
    *  Converts the value of this instance to its equivalent string
    representation using the specified format.
    
    
    

    * @param format A format string. 
    * @return A string representation of value of this instance as specified by
    {@code format}.
    * @exception NumberFormatException The length of {@code format} is 1,
    and it is not one of the format specifier characters defined for
    {@link DateTimeFormatInfo}.-or- {@code format} does not
    contain a valid custom format pattern. 
    */
    public final String toString(String format) {
        return toString(format, null);
    }

    /**
    *  Converts the value of this instance to its equivalent string
    representation using the specified culture-specific format information.
    
    
    

    * @param provider An {@link Locale} that supplies
    culture-specific formatting information. 
    * @return A string representation of value of this instance as specified by
    {@code provider}.
    */
    public final String toString(Locale provider) {
        return toString(null, provider);
    }

    /**
    *  Converts the value of this instance to its equivalent string
    representation using the specified format and culture-specific format
    information.
    
    
    
    

    * @param format A format string. 
    * @param provider An {@link Locale} that supplies
    culture-specific formatting information. 
    * @return A string representation of value of this instance as specified by
    {@code format} and {@code provider}.
    * @exception NumberFormatException The length of {@code format} is 1,
    and it is not one of the format specifier characters defined for
    {@link DateTimeFormatInfo}.-or- {@code format} does not
    contain a valid custom format pattern. 
    */
    public final String toString(String format, Locale provider) {
        return Parser.toString(this, format, provider);
    }

    /**
    *  
    Converts the value of this instance to its equivalent ISO8601 extended string
    representation, corresponding to year month day hours minutes and seconds with
    seconds represented to machine precision.
    
    

    * @return A string representing this date and time in ISO8601 format.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final String toIso8601String() {
        return toIso8601String(Iso8601Format.EXTENDED);
    }

    /**
    *  
    Converts the value of this instance to its equivalent ISO8601 string representation,
    corresponding to year month day hours minutes and seconds with seconds
    represented to machine precision.
    
    
    

    * @param format The type of ISO8601 string to create.
    * @return A string representing this date and time in ISO8601 format.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final String toIso8601String(Iso8601Format format) {
        return toIso8601String(format, StringHelper.create('#', 15));
    }

    /**
    *  
    Converts the value of this instance to its equivalent ISO8601 string representation,
    corresponding to year month day hours minutes and seconds with seconds
    rounded to and formatted with the specified number of decimal digits.
    
    
    
    

    * @param format The type of ISO8601 string to create.
    * @param digitsOfFractionalSeconds The number of digits after the decimal point in the 'seconds' portion of the time.
    * @return A string representing this date and time in ISO8601 format.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final String toIso8601String(Iso8601Format format, int digitsOfFractionalSeconds) {
        String fractionalSecondsFormatString = StringHelper.create('0', digitsOfFractionalSeconds);
        return roundSeconds(digitsOfFractionalSeconds).toIso8601String(format, fractionalSecondsFormatString);
    }

    private final String toIso8601String(Iso8601Format format, String fractionalSecondsFormatString) {
        switch (format) {
        case BASIC: {
            return StringHelper.format(CultureInfoHelper.getInvariantCulture(), "{0:0000}{1:00}{2:00}T{3:00}{4:00}{5:00." + fractionalSecondsFormatString + "}Z", m_yearMonthDay.getYear(),
                    m_yearMonthDay.getMonth(), m_yearMonthDay.getDay(), m_hour, m_minute, m_second);
        }
        case EXTENDED: {
            return StringHelper.format(CultureInfoHelper.getInvariantCulture(), "{0:0000}-{1:00}-{2:00}T{3:00}:{4:00}:{5:00." + fractionalSecondsFormatString + "}Z", m_yearMonthDay.getYear(),
                    m_yearMonthDay.getMonth(), m_yearMonthDay.getDay(), m_hour, m_minute, m_second);
        }
        case COMPACT: {
            if (m_second != 0) {
                return StringHelper.format(CultureInfoHelper.getInvariantCulture(), "{0:0000}{1:00}{2:00}T{3:00}{4:00}{5:00." + fractionalSecondsFormatString + "}Z", m_yearMonthDay.getYear(),
                        m_yearMonthDay.getMonth(), m_yearMonthDay.getDay(), m_hour, m_minute, m_second);
            }
            if (m_minute != 0) {
                return StringHelper.format(CultureInfoHelper.getInvariantCulture(), "{0:0000}{1:00}{2:00}T{3:00}{4:00}Z", m_yearMonthDay.getYear(), m_yearMonthDay.getMonth(), m_yearMonthDay.getDay(),
                        m_hour, m_minute);
            }
            return StringHelper.format(CultureInfoHelper.getInvariantCulture(), "{0:0000}{1:00}{2:00}T{3:00}Z", m_yearMonthDay.getYear(), m_yearMonthDay.getMonth(), m_yearMonthDay.getDay(), m_hour);
        }
        }
        throw new IllegalStateException();
    }

    /**
    *  Converts the value of this instance to its equivalent long date string representation.
    

    * @return A string containing the name of the day of the week, the name of the month, the numeric day of the month, and the year equivalent to the date value of this instance.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final String toLongDateString() {
        return toString("D");
    }

    /**
    *  Converts the value of this instance to its equivalent long time string
    representation.
    

    * @return A string containing the name of the day of the week, the name of the
    month, the numeric day of the hours, minutes, and seconds equivalent to the
    time value of this instance.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final String toLongTimeString() {
        return toString("T");
    }

    /**
    *  Converts the value of this instance to its equivalent short date
    string representation.
    

    * @return A string containing the numeric month, the numeric day of the month,
    and the year equivalent to the date value of this instance.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final String toShortDateString() {
        return toString("d");
    }

    /**
    *  Converts the value of this instance to its equivalent short time
    string representation.
    

    * @return A string containing the name of the day of the week, the name of the
    month, the numeric day of the hours, minutes, and seconds equivalent to the
    time value of this instance.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final String toShortTimeString() {
        return toString("t");
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(GregorianDate,GregorianDate)'")
    public static boolean equals(GregorianDate left, GregorianDate right) {
        return left.equalsType(right);
    }

    /**
    *  
    Returns {@code true} if the two instances are not exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} does not represent the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(GregorianDate,GregorianDate)'")
    public static boolean notEquals(GregorianDate left, GregorianDate right) {
        return !left.equalsType(right);
    }

    /**
    *  
    Returns {@code true} if {@code left} is less than {@code right}.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} is less than {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <(GregorianDate,GregorianDate)'")
    public static boolean lessThan(GregorianDate left, GregorianDate right) {
        return left.compareTo(right) < 0;
    }

    /**
    *  
    Returns {@code true} if {@code left} is greater than {@code right}.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} is greater than {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >(GregorianDate,GregorianDate)'")
    public static boolean greaterThan(GregorianDate left, GregorianDate right) {
        return left.compareTo(right) > 0;
    }

    /**
    *  
    Returns {@code true} if {@code left} is less than or equal to {@code right}.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} is less than or equal to {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <=(GregorianDate,GregorianDate)'")
    public static boolean lessThanOrEqual(GregorianDate left, GregorianDate right) {
        return left.compareTo(right) <= 0;
    }

    /**
    *  
    Returns {@code true} if {@code left} is greater than or equal to {@code right}.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} is greater than or equal to {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >=(GregorianDate,GregorianDate)'")
    public static boolean greaterThanOrEqual(GregorianDate left, GregorianDate right) {
        return left.compareTo(right) >= 0;
    }

    /**
    *  
    Converts the specified string representation of a date and time to its
    {@link GregorianDate} equivalent.

    Note: {@link GregorianDate} is always assumed to be in UTC.  You cannot
    parse strings containing time zone information. However, this will handle
    three common ISO8601 formats: the extended format YYYY-MM-DDThh:mm:ss.sZ
    (with seconds to machine precision), it's "day of year" equivalent YYYY-DDDThh:mm:ss.sZ,
    and the basic format YYYYMMDDThhmmss.sZ.
    
    
    
    
    

    * @param s A string containing a date and time to convert.
    * @return 
    A {@link GregorianDate} equivalent to the date and time contained in s.
    
    * @exception ArgumentNullException 
    {@code s} is null.
    
    * @exception NumberFormatException 
    {@code s} does not contain a valid string representation of a date
    and time.
    
    */
    public static GregorianDate parse(String s) {
        return parse(s, null);
    }

    /**
    *  
    Converts the specified string representation of a date and time to its
    {@link GregorianDate} equivalent using the specified culture-specific
    format information.

    Note: {@link GregorianDate} is always assumed to be in UTC.  You cannot
    parse strings containing time zone information. However, this will handle
    three common ISO8601 formats: the extended format YYYY-MM-DDThh:mm:ss.sZ
    (with seconds to machine precision), it's "day of year" equivalent YYYY-DDDThh:mm:ss.sZ,
    and the basic format YYYYMMDDThhmmss.sZ.
    
    
    
    
    
    

    * @param s A string containing a date and time to convert.
    * @param provider An {@link Locale} that supplies
    culture-specific format information about {@code s}.
    * @return 
    A {@link GregorianDate} equivalent to the date and time contained in
    {@code s} as specified by {@code provider}.
    
    * @exception ArgumentNullException 
    {@code s} is null.
    
    * @exception NumberFormatException 
    {@code s} does not contain a valid string representation of a date
    and time.
    
    */
    public static GregorianDate parse(String s, Locale provider) {
        return Parser.parse(s, provider);
    }

    /**
    *  
    Converts the specified string representation of a date and time to its
    {@link GregorianDate} equivalent using the specified format and
    culture-specific format information. The format of the string representation
    must match the specified format exactly.

    Note: {@link GregorianDate} is always assumed to be in UTC.  You cannot
    parse strings containing time zone information.
    
    
    
    
    
    
    

    * @param s A string containing a date and time to convert. 
    * @param format The expected format of {@code s}. 
    * @param provider An {@link Locale} that supplies
    culture-specific format information about {@code s}. 
    * @return 
    A {@link GregorianDate} equivalent to the date and time contained in
    {@code s} as specified by {@code format} and
    {@code provider}.
    
    * @exception ArgumentNullException 
    {@code s} or {@code format} is null.
    
    * @exception NumberFormatException 
    {@code s} or {@code format} is an empty string. -or-
    {@code s} does not contain a date and time that corresponds to the
    pattern specified in
    {@code format}.
    
    */
    public static GregorianDate parseExact(String s, String format, Locale provider) {
        return Parser.parseExact(s, new String[] {
            format
        }, provider);
    }

    /**
    *  
    Converts the specified string representation of a date and time to its
    {@link GregorianDate} equivalent using the specified format and
    culture-specific format information. The format of the string representation
    must match the specified format exactly.

    Note: {@link GregorianDate} is always assumed to be in UTC.  You cannot
    parse strings containing time zone information.
    
    
    
    
    
    
    

    * @param s A list of strings containing a date and time to convert. 
    * @param format The expected format of {@code s}. 
    * @param provider An {@link Locale} that supplies
    culture-specific format information about {@code s}. 
    * @return 
    A {@link GregorianDate} equivalent to the date and time contained in
    {@code s} as specified by {@code format} and
    {@code provider}.
    
    * @exception ArgumentNullException 
    {@code s} or {@code format} is null.
    
    * @exception NumberFormatException 
    {@code s} or {@code format} is an empty string. -or-
    {@code s} does not contain a date and time that corresponds to the
    pattern specified in
    {@code format}.
    
    */
    public static GregorianDate parseExact(String s, String[] format, Locale provider) {
        return Parser.parseExact(s, format, provider);
    }

    /**
    *  
    Converts the specified string representation of a date and time to its
    {@link GregorianDate} equivalent.

    Note: {@link GregorianDate} is always assumed to be in UTC.  You cannot
    parse strings containing time zone information. However, this will handle
    three common ISO8601 formats: the extended format YYYY-MM-DDThh:mm:ss.sZ
    (with seconds to machine precision), it's "day of year" equivalent YYYY-DDDThh:mm:ss.sZ,
    and the basic format YYYYMMDDThhmmss.sZ.
    
    
    
    

    * @param s A string containing a date and time to convert.
    * @param result 
    On input, an array with one element.  On return, the array is populated with
    
    the {@link GregorianDate} value equivalent to the date and time contained in
    {@code s}, if the conversion succeeded, or
    {@link GregorianDate#MinValue} if the conversion failed. The conversion
    fails if the {@code s} parameter is null, or does not contain a
    valid string representation of a date and time. This parameter is passed
    uninitialized.
    
    * @return 
    true if the {@code s} parameter was converted successfully;
    otherwise, false.
    
    */
    public static boolean tryParse(String s, GregorianDate[] result) {
        return tryParse(s, null, result);
    }

    /**
    *  
    Converts the specified string representation of a date and time to its
    {@link GregorianDate} equivalent using the specified culture-specific
    format information.

    Note: {@link GregorianDate} is always assumed to be in UTC.  You cannot
    parse strings containing time zone information. However, this will handle
    three common ISO8601 formats: the extended format YYYY-MM-DDThh:mm:ss.sZ
    (with seconds to machine precision), it's "day of year" equivalent YYYY-DDDThh:mm:ss.sZ,
    and the basic format YYYYMMDDThhmmss.sZ.
    
    
    
    
    

    * @param s A string containing a date and time to convert.
    * @param provider An {@link Locale} that supplies
    culture-specific format information about {@code s}. 
    * @param result 
    On input, an array with one element.  On return, the array is populated with
    
    the {@link GregorianDate} value equivalent to the date and time contained in
    {@code s}, if the conversion succeeded, or
    {@link GregorianDate#MinValue} if the conversion failed. The conversion
    fails if the {@code s} parameter is null, or does not contain a
    valid string representation of a date and time. This parameter is passed
    uninitialized.
    
    * @return 
    true if the {@code s} parameter was converted successfully;
    otherwise, false.
    
    */
    public static boolean tryParse(String s, Locale provider, GregorianDate[] result) {
        return Parser.tryParse(s, provider, result);
    }

    /**
    *  
    Represents the largest possible value of {@link GregorianDate}.
    Corresponds to {@link DateTimeHelper#maxValue()}.
    

    */
    public static final GregorianDate MaxValue = new GregorianDate(DateTimeHelper.maxValue());
    /**
    *  
    Represents the smallest possible value of {@link GregorianDate}.
    Corresponds to {@link DateTimeHelper#minValue()}.
    

    */
    public static final GregorianDate MinValue = new GregorianDate(DateTimeHelper.minValue());
    private static final int SecondsPerHour = 3600;
    private static final int SecondsPerMinute = 60;
    @CS2JInfo("Initialization of C# struct variable 'm_yearMonthDay' added by translator.")
    private YearMonthDay m_yearMonthDay = new YearMonthDay();
    private int m_hour;
    private int m_minute;
    private double m_second;
}