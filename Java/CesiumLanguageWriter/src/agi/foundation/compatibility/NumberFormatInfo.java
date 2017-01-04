package agi.foundation.compatibility;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Defines how numeric values are formatted and displayed, depending on the culture.
 */
public final class NumberFormatInfo {
    private final DecimalFormatSymbols decimalFormatSymbols;

    /**
     * Returns the NumberFormatInfo associated with the specified Locale.
     */
    public static NumberFormatInfo getInstance(Locale locale) {
        if (locale == null)
            locale = CultureInfoHelper.getCurrentCulture();
        return new NumberFormatInfo(locale, DecimalFormatSymbols.getInstance(locale));
    }

    /**
     * Gets the default read-only NumberFormatInfo that is culture-independent
     * (invariant).
     */
    public static NumberFormatInfo getInvariantInfo() {
        return getInstance(CultureInfoHelper.getInvariantCulture());
    }

    private NumberFormatInfo(Locale locale, DecimalFormatSymbols decimalFormatSymbols) {
        this.decimalFormatSymbols = decimalFormatSymbols;
    }

    /**
     * Gets the string to use as the decimal separator in numeric values.
     */
    public String getNumberDecimalSeparator() {
        return String.valueOf(decimalFormatSymbols.getDecimalSeparator());
    }
}
