package agi.foundation.compatibility;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Helper methods related to Formats.
 */
public final class FormatHelper {
    private FormatHelper() {}

    /**
     * Custom Format subclass that splits a format string into separate parts for
     * positive, negative, and zero pattern strings
     */
    private static class MultiDecimalFormat extends Format {
        private static final long serialVersionUID = 7691469299119613557L;
        private final PaddingDecimalFormat positiveFormat;
        private final PaddingDecimalFormat negativeFormat;
        private final PaddingDecimalFormat zeroFormat;

        public MultiDecimalFormat(Locale locale, String pattern, int width) {
            String[] patterns = pattern.split(";");
            positiveFormat = new PaddingDecimalFormat(locale, patterns[0], width);

            // build a fake positive version of the negative pattern
            String negativePattern = "+" + patterns[1] + ";" + patterns[1];
            negativeFormat = new PaddingDecimalFormat(locale, negativePattern, width);

            if (patterns.length > 2) {
                zeroFormat = new PaddingDecimalFormat(locale, patterns[2], width);
            } else {
                zeroFormat = null;
            }
        }

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            if (obj instanceof Number) {
                Number n = (Number) obj;
                double doubleValue = n.doubleValue();

                if (doubleValue == 0 && zeroFormat != null) {
                    return zeroFormat.format(obj, toAppendTo, pos);
                } else if (doubleValue >= 0) {
                    return positiveFormat.format(obj, toAppendTo, pos);
                } else {
                    return negativeFormat.format(obj, toAppendTo, pos);
                }
            } else {
                throw new IllegalArgumentException("can only format Numbers");
            }
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            throw new UnsupportedOperationException();
        }
    }

    private static class HexNumberFormat extends NumberFormat {
        private static final long serialVersionUID = 3699466498715722514L;
        private final boolean uppercase;

        public HexNumberFormat(boolean uppercase) {
            this.uppercase = uppercase;
        }

        @Override
        public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
            return format((long) number, toAppendTo, pos);
        }

        @Override
        public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
            String hex = Long.toHexString(number);
            if (uppercase) {
                hex = hex.toUpperCase(Locale.ENGLISH);
            }

            int numZeroPad = getMinimumIntegerDigits() - hex.length();
            for (int i = 0; i < numZeroPad; ++i) {
                toAppendTo.append('0');
            }

            return toAppendTo.append(hex);
        }

        @Override
        public Number parse(String source, ParsePosition parsePosition) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Custom Format subclass to handle differences in format strings between C# and Java.
     */
    private static class PaddingDecimalFormat extends Format {
        private static final long serialVersionUID = 7323738994538516253L;
        private final int width;
        private final NumberFormat subFormat;
        private transient FieldPosition exponentSymbolFieldPosition;
        private final boolean forceExponentSign;
        private final String forceExponentSymbol;

        public PaddingDecimalFormat(Locale locale, String pattern, int width) {
            DecimalFormat decimalFormat;
            NumberFormat nf = NumberFormat.getNumberInstance(locale);
            if (nf instanceof DecimalFormat) {
                decimalFormat = (DecimalFormat) nf;
            } else {
                throw new UnsupportedOperationException("the locale " + locale + " did not return a decimal format!");
            }

            decimalFormat.setGroupingUsed(false);
            decimalFormat.setMaximumFractionDigits(Integer.MAX_VALUE);

            boolean forceExponentSign = false;
            String forceExponentSymbol = null;
            FieldPosition exponentSymbolFieldPosition = null;
            if (pattern != null) {
                exponentSymbolFieldPosition = new FieldPosition(NumberFormat.Field.EXPONENT_SYMBOL);

                if (pattern.contains("e")) {
                    // Java uses "E" for the exponent symbol, not "e"
                    pattern = pattern.replace("e", "E");
                    forceExponentSymbol = "e";
                }

                if (pattern.contains("E+")) {
                    // Java does not produce the sign for a positive exponent
                    pattern = pattern.replace("E+", "E");
                    forceExponentSign = true;
                }

                if (pattern.contains("E-")) {
                    // E- means use a sign for only negative exponents, which is normal.
                    pattern = pattern.replace("E-", "E");
                }

                decimalFormat.applyPattern(pattern);
            }

            this.width = width;
            this.subFormat = decimalFormat;
            this.exponentSymbolFieldPosition = exponentSymbolFieldPosition;
            this.forceExponentSign = forceExponentSign;
            this.forceExponentSymbol = forceExponentSymbol;
        }

        public PaddingDecimalFormat(NumberFormat subFormat, int width) {
            this.width = width;
            this.subFormat = subFormat;
            this.exponentSymbolFieldPosition = null;
            this.forceExponentSign = false;
            this.forceExponentSymbol = null;
        }

        public void setMaximumFractionDigits(int newValue) {
            subFormat.setMaximumFractionDigits(newValue);
        }

        public void setMinimumFractionDigits(int newValue) {
            subFormat.setMinimumFractionDigits(newValue);
        }

        public void setMinimumIntegerDigits(int newValue) {
            subFormat.setMinimumIntegerDigits(newValue);
        }

        private static void replace(StringBuffer buffer, String from, String to) {
            int fromIndex = buffer.indexOf(from);
            while (fromIndex != -1) {
                buffer.replace(fromIndex, fromIndex + from.length(), to);
                fromIndex += to.length();
                fromIndex = buffer.indexOf(from, fromIndex);
            }
        }

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            // normalize negative zero to positive zero
            // so that it formats properly.
            if (obj instanceof Double) {
                if ((Double) obj == -0.0d)
                    obj = 0.0d;
            } else if (obj instanceof Float) {
                if ((Float) obj == -0.0f)
                    obj = 0.0f;
            }

            StringBuffer result;
            if (exponentSymbolFieldPosition != null) {
                result = subFormat.format(obj, toAppendTo, exponentSymbolFieldPosition);
            } else {
                result = subFormat.format(obj, toAppendTo, pos);
            }

            // the default formatter uses unusual unicode characters for NaN/Infinity
            replace(result, "\uFFFD", "NaN");
            replace(result, "\u221E", "Infinity");

            int extraPadding = width - result.length();
            if (extraPadding > 0) {
                StringBuilder padding = new StringBuilder(extraPadding);
                for (int i = 0; i < extraPadding; i++) {
                    padding.append(" ");
                }
                result.insert(0, padding);
            }

            if (exponentSymbolFieldPosition != null) {
                int beginIndex = exponentSymbolFieldPosition.getBeginIndex();
                int endIndex = exponentSymbolFieldPosition.getEndIndex();

                if (forceExponentSign && result.length() >= endIndex + 1) {
                    // if we need to, add the exponent symbol for positive
                    // exponents
                    if (!"-".equals(result.substring(endIndex, endIndex + 1))) {
                        result.insert(endIndex, "+");
                    }
                }

                if (forceExponentSymbol != null) {
                    // if we need to, replace the exponent symbol "E" with the
                    // expected symbol (generally "e")
                    result.replace(beginIndex, endIndex, forceExponentSymbol);
                }
            }

            return result;
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Build a Format for a C# pattern
     */
    public static Format buildFormat(Locale locale, String pattern) {
        return buildFormat(locale, pattern, 0);
    }

    /**
     * Build a Format for a C# pattern, with a specific width
     */
    public static Format buildFormat(Locale locale, String pattern, int width) {
        FormatCacheKey key = new FormatCacheKey(locale, pattern, width);
        Format format = cache.get(key);
        if (format == null) {
            format = createFormat(locale, pattern, width);

            Format existingFormat = cache.putIfAbsent(key, format);
            if (existingFormat != null) {
                format = existingFormat;
            }
        }
        return format;
    }

    private static final class FormatCacheKey {
        private final Locale locale;
        private final String pattern;
        private final int width;

        public FormatCacheKey(final Locale locale, final String pattern, final int width) {
            this.locale = locale;
            this.pattern = pattern;
            this.width = width;
        }

        @Override
        public final int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (locale == null ? 0 : locale.hashCode());
            result = prime * result + (pattern == null ? 0 : pattern.hashCode());
            result = prime * result + width;
            return result;
        }

        @Override
        public final boolean equals(final Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof FormatCacheKey))
                return false;

            final FormatCacheKey other = (FormatCacheKey) obj;
            if (!ObjectHelper.equals(locale, other.locale))
                return false;
            if (!ObjectHelper.equals(pattern, other.pattern))
                return false;
            if (width != other.width)
                return false;
            return true;
        }
    }

    private static ConcurrentHashMap<FormatCacheKey, Format> cache = new ConcurrentHashMap<FormatHelper.FormatCacheKey, Format>();

    private static Format createFormat(Locale locale, String pattern, int width) {
        if (pattern == null || pattern.length() == 0) {
            return createCustomFormat(locale, pattern, width);
        }

        if (Character.isLetter(pattern.charAt(0))) {
            char firstChar = pattern.charAt(0);
            char upperCaseFirstChar = Character.toUpperCase(firstChar);

            if (upperCaseFirstChar == 'R') {
                return new PaddingDecimalFormat(locale, null, width);
            }

            pattern = pattern.substring(1);
            int precision;
            try {
                precision = Integer.parseInt(pattern);
            } catch (NumberFormatException e) {
                precision = -1;
            }

            if (upperCaseFirstChar == 'F' && precision != -1) {
                PaddingDecimalFormat format = new PaddingDecimalFormat(locale, null, width);
                format.setMinimumFractionDigits(precision);
                format.setMaximumFractionDigits(precision);
                return format;
            } else if (upperCaseFirstChar == 'D' && precision != -1) {
                PaddingDecimalFormat format = new PaddingDecimalFormat(locale, null, width);
                format.setMinimumIntegerDigits(precision);
                return format;
            } else if (upperCaseFirstChar == 'E') {
                if (precision == -1) {
                    precision = 6;
                }
                StringBuilder sb = new StringBuilder("0.");
                for (int i = 0; i < precision; i++) {
                    sb.append("#");
                }
                sb.append(firstChar);
                sb.append("+000");
                PaddingDecimalFormat format = new PaddingDecimalFormat(locale, sb.toString(), width);
                format.setMinimumFractionDigits(precision);
                format.setMaximumFractionDigits(precision);
                return format;
            } else if (upperCaseFirstChar == 'X') {
                PaddingDecimalFormat format = new PaddingDecimalFormat(new HexNumberFormat(firstChar == 'X'), width);
                format.setMinimumIntegerDigits(precision);
                return format;
            } else {
                String m = MessageFormat.format("Unsupported format specifier \"{0}\" for format string \"{1}\"", firstChar, pattern);
                throw new UnsupportedOperationException(m);
            }
        } else {
            return createCustomFormat(locale, pattern, width);
        }
    }

    private static Format createCustomFormat(Locale locale, String pattern, int width) {
        if (pattern != null && pattern.contains(";")) {
            return new MultiDecimalFormat(locale, pattern, width);
        } else {
            return new PaddingDecimalFormat(locale, pattern, width);
        }
    }
}
