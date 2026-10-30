package agi.foundation.compatibility;

import static java.lang.Math.abs;
import static java.lang.Math.copySign;
import static java.lang.Math.rint;

import javax.annotation.Nonnull;

import agi.foundation.compatibility.annotations.Internal;

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
    public static double round(double value, int digits, @Nonnull MidpointRounding mode) {
        if (digits < 0 || digits > 15)
            ArgumentOutOfRangeException._throw("digits", "Rounding digits must be between 0 and 15, inclusive.");

        // This is the .NET algorithm, which is faster, but less precise than BigDecimal
        if (abs(value) >= roundingLimit) {
            return value;
        }

        double powerOfTen = powerOfTenCache[digits];
        value *= powerOfTen;

        // if/else with two cases produces smaller bytecode than a switch.
        if (mode == MidpointRounding.TO_EVEN) {
            value = rint(value);
        } else if (mode == MidpointRounding.AWAY_FROM_ZERO) {
            value = truncate(value + copySign(1.0 / 2.0, value));
        } else {
            ArgumentOutOfRangeException._throw();
        }

        return value / powerOfTen;
    }

    private static final double roundingLimit = 1e16;
    @Nonnull
    private static final double[] powerOfTenCache = {
        1e0,
        1e1,
        1e2,
        1e3,
        1e4,
        1e5,
        1e6,
        1e7,
        1e8,
        1e9,
        1e10,
        1e11,
        1e12,
        1e13,
        1e14,
        1e15,
    };

    /**
     * Calculates the integral part of a specified double-precision floating-point number.
     *
     * @param value
     *            A number to truncate.
     * @return The integral part of d; that is, the number that remains after any
     *         fractional digits have been discarded.
     */
    public static double truncate(double value) {
        return value > 0.0 ? Math.floor(value) : Math.ceil(value);
    }
}
