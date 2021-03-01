package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static java.lang.Math.abs;
import static java.lang.Math.floor;
import static java.lang.Math.log10;

/**
 * Helper methods related to Formats.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class FormatHelper {
    private FormatHelper() {}

    @Nonnull
    private static final ThreadLocal<HashMap<FormatCacheKey, Format>> formatCache = ThreadLocal.withInitial(HashMap::new);

    /**
     * Custom Format subclass that splits a format string into separate parts for
     * positive, negative, and zero pattern strings
     */
    private static final class MultiDecimalFormat extends Format {
        private static final long serialVersionUID = 7691469299119613557L;
        @Nonnull
        private final PaddingDecimalFormat positiveFormat;
        @Nonnull
        private final PaddingDecimalFormat negativeFormat;
        @Nullable
        private final PaddingDecimalFormat zeroFormat;

        public MultiDecimalFormat(@Nonnull Locale locale, @Nonnull String pattern, int width) {
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

    private static final class HexNumberFormat extends NumberFormat {
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
    private static final class PaddingDecimalFormat extends Format {
        private static final long serialVersionUID = 7323738994538516253L;
        private final int width;
        @Nonnull
        private final NumberFormat subFormat;
        @Nullable
        private transient FieldPosition exponentSymbolFieldPosition;
        private final boolean forceExponentSign;
        @Nullable
        private final String forceExponentSymbol;

        public PaddingDecimalFormat(@Nonnull Locale locale, @Nullable String pattern, int width) {
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

        public PaddingDecimalFormat(@Nonnull NumberFormat subFormat, int width) {
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

        private static void replace(@Nonnull StringBuffer buffer, @Nonnull String from, @Nonnull String to) {
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

            FieldPosition exponentSymbolFieldPosition = this.exponentSymbolFieldPosition;
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
                for (int i = 0; i < extraPadding; ++i) {
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

    private static final class GeneralNumberFormat extends NumberFormat {
        private static final long serialVersionUID = -5819015933095511219L;
        private final PaddingDecimalFormat format;
        private final PaddingDecimalFormat scientificFormat;

        public GeneralNumberFormat(@Nonnull Locale locale, int width, boolean uppercase) {
            format = new PaddingDecimalFormat(locale, null, width);
            format.setMaximumFractionDigits(Integer.MAX_VALUE);
            scientificFormat = new PaddingDecimalFormat(locale, createExponentPattern(uppercase ? 'E' : 'e', 1, 2), width);
            scientificFormat.setMaximumFractionDigits(Integer.MAX_VALUE);
        }

        @Override
        public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
            double exponentDigits = number == 0.0 ? 0.0 : floor(log10(abs(number)));

            if (exponentDigits > -5 && exponentDigits < 17) {
                return format.format(number, toAppendTo, pos);
            } else {
                return scientificFormat.format(number, toAppendTo, pos);
            }
        }

        @Override
        public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
            return format.format(number, toAppendTo, pos);
        }

        @Override
        public Number parse(String source, ParsePosition parsePosition) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Build a Format for a C# pattern
     */
    @Nonnull
    public static Format buildFormat(@Nullable Locale locale, @Nullable String pattern) {
        return buildFormat(locale, pattern, 0);
    }

    /**
     * Build a Format for a C# pattern, with a specific width
     */
    @Nonnull
    public static Format buildFormat(@Nullable Locale locale, @Nullable String pattern, int width) {
        Format format = getFormatCache().computeIfAbsent(new FormatCacheKey(locale, pattern, width), FormatHelper::createFormat);
        assert format != null;
        return format;
    }

    @Nonnull
    private static HashMap<FormatCacheKey, Format> getFormatCache() {
        HashMap<FormatCacheKey, Format> cache = formatCache.get();
        assert cache != null;
        return cache;
    }

    private static final class FormatCacheKey {
        @Nullable
        public final Locale locale;
        @Nullable
        public final String pattern;
        public final int width;

        public FormatCacheKey(@Nullable Locale locale, @Nullable String pattern, int width) {
            this.locale = locale;
            this.pattern = pattern;
            this.width = width;
        }

        @Override
        public int hashCode() {
            return HashCodeHelper.combine(Objects.hashCode(locale), Objects.hashCode(pattern), Integer.hashCode(width));
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof FormatCacheKey))
                return false;

            FormatCacheKey other = (FormatCacheKey) obj;
            return Objects.equals(locale, other.locale) && Objects.equals(pattern, other.pattern) && width == other.width;
        }
    }

    @Nonnull
    private static Format createFormat(@Nonnull FormatCacheKey key) {
        return createFormat(key.locale, key.pattern, key.width);
    }

    @Nonnull
    private static Format createFormat(@Nullable Locale locale, @Nullable String pattern, int width) {
        if (locale == null) {
            locale = CultureInfoHelper.getCurrentCulture();
        }

        if (pattern == null || pattern.length() == 0) {
            return createCustomFormat(locale, pattern, width);
        }

        if (Character.isLetter(pattern.charAt(0))) {
            char firstChar = pattern.charAt(0);

            pattern = pattern.substring(1);
            int precision = -1;
            if (pattern.length() > 0) {
                try {
                    precision = Integer.parseInt(pattern);
                } catch (NumberFormatException e) {}
            }

            switch (firstChar) {
            case 'r':
            case 'g':
            case 'R':
            case 'G': {
                return new GeneralNumberFormat(locale, width, firstChar == 'R' || firstChar == 'G');
            }
            case 'f':
            case 'F': {
                PaddingDecimalFormat format = new PaddingDecimalFormat(locale, null, width);
                if (precision != -1) {
                    format.setMinimumFractionDigits(precision);
                    format.setMaximumFractionDigits(precision);
                }
                return format;
            }
            case 'd':
            case 'D': {
                PaddingDecimalFormat format = new PaddingDecimalFormat(locale, null, width);
                if (precision != -1) {
                    format.setMinimumIntegerDigits(precision);
                }
                return format;
            }
            case 'e':
            case 'E': {
                if (precision == -1) {
                    precision = 6;
                }

                PaddingDecimalFormat format = new PaddingDecimalFormat(locale, createExponentPattern(firstChar, precision, 3), width);
                format.setMinimumFractionDigits(precision);
                format.setMaximumFractionDigits(precision);
                return format;
            }
            case 'x':
            case 'X': {
                PaddingDecimalFormat format = new PaddingDecimalFormat(new HexNumberFormat(firstChar == 'X'), width);
                format.setMinimumIntegerDigits(precision);
                return format;
            }
            default: {
                String m = MessageFormat.format("Unsupported format specifier \"{0}\" for format string \"{1}\"", firstChar, pattern);
                throw new UnsupportedOperationException(m);
            }
            }
        } else {
            return createCustomFormat(locale, pattern, width);
        }
    }

    private static String createExponentPattern(char exponentChar, int precision, int exponentDigits) {
        StringBuilder builder = new StringBuilder("0.");
        for (int i = 0; i < precision; ++i) {
            builder.append("#");
        }
        builder.append(exponentChar);
        builder.append("+");
        for (int i = 0; i < exponentDigits; ++i) {
            builder.append("0");
        }
        return builder.toString();
    }

    @Nonnull
    private static Format createCustomFormat(@Nonnull Locale locale, @Nullable String pattern, int width) {
        if (pattern != null && pattern.contains(";")) {
            return new MultiDecimalFormat(locale, pattern, width);
        } else {
            return new PaddingDecimalFormat(locale, pattern, width);
        }
    }
}
