package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Helper methods related to Math.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class MathHelper {
    private MathHelper() {}

    /**
     * Rounds a double-precision floating-point value to the nearest integral value.
     *
     * @param a
     *            A double-precision floating-point number to be rounded.
     * @return The integer nearest a. If the fractional component of a is halfway between
     *         two integers, one of which is even and the other odd, then the even number
     *         is returned.
     */
    public static double round(double a) {
        return Math.rint(a);
    }

    /**
     * Rounds a double-precision floating-point value to a specified number of fractional
     * digits.
     *
     * @param value
     *            A double-precision floating-point number to be rounded.
     * @param digits
     *            The number of fractional digits in the return value.
     * @return The number nearest to value that contains a number of fractional digits
     *         equal to digits.
     */
    public static double round(double value, int digits) {
        return round(value, digits, MidpointRounding.TO_EVEN);
    }

    /**
     * Rounds a double-precision floating-point value to the specified number of
     * fractional digits. A parameter specifies how to round the value if it is midway
     * between two other numbers.
     *
     * @param value
     *            A double-precision floating-point number to be rounded.
     * @param digits
     *            The number of fractional digits in the return value.
     * @param mode
     *            Specification for how to round value if it is midway between two other
     *            numbers.
     * @return The number nearest to value that has a number of fractional digits equal to
     *         digits. If the number of fractional digits in value is less than digits,
     *         value is returned unchanged.
     */
    public static double round(double value, int digits, MidpointRounding mode) {
        RoundingMode roundingMode;
        switch (mode) {
        case TO_EVEN:
            roundingMode = RoundingMode.HALF_EVEN;
            break;
        case AWAY_FROM_ZERO:
            roundingMode = RoundingMode.HALF_UP;
            break;
        default:
            throw new ArgumentException("Unknown MidpointRounding: " + mode);
        }

        return BigDecimal.valueOf(value).setScale(digits, roundingMode).doubleValue();
    }
}
