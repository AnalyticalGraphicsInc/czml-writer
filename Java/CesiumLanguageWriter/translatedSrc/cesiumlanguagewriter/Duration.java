package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import javax.annotation.Nonnull;

/**
 * Represents a span of time.
 
 This class
 offers the same precision as the {@link JulianDate} type.  It stores a
 number of days as an {@code int} and a number of seconds as a {@code double}.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public final class Duration implements Comparable<Duration>, IEquatable<Duration>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public Duration() {}

    /**
    * Initializes a new instance of {@link Duration} from a specified number
    of days, hours, minutes, and seconds.
    * @param days The number of days in the new {@link Duration}.
    * @param hours The number of hours in the new {@link Duration}.
    * @param minutes The number of minutes in the new {@link Duration}.
    * @param seconds The number of seconds in the new {@link Duration}.
    */
    public Duration(int days, int hours, int minutes, double seconds) {
        this(days, hoursMinutesSecondsToSeconds(hours, minutes, seconds));
    }

    /**
    * Initializes a new instance of {@link Duration} from a specified number
    of days and seconds.
    * @param days The number of days in the new {@link Duration}.
    * @param seconds The number of seconds in the new {@link Duration}.
    */
    public Duration(int days, double seconds) {
        // Ensure that the number of seconds is less than a whole (positive or negative) day.
        if (seconds >= TimeConstants.SecondsPerDay || seconds <= -TimeConstants.SecondsPerDay) {
            int newDays = (int) (seconds / TimeConstants.SecondsPerDay);
            days += newDays;
            seconds -= TimeConstants.SecondsPerDay * newDays;
        }
        // Ensure that days and seconds are either both negative or both positive
        if (days < 0 && seconds > 0) {
            ++days;
            seconds -= TimeConstants.SecondsPerDay;
            if (seconds < -TimeConstants.NextBefore86400) {
                --days;
                seconds = 0.0;
            }
        } else if (days > 0 && seconds < 0) {
            --days;
            seconds += TimeConstants.SecondsPerDay;
            if (seconds > TimeConstants.NextBefore86400) {
                ++days;
                seconds = 0.0;
            }
        }
        m_days = days;
        m_seconds = seconds;
    }

    /**
    * Converts the specified number of hours, minutes, and seconds to total duration in seconds.
    * @param hours The number of hours.
    * @param minutes The number of minutes.
    * @param seconds The number of seconds.
    * @return The corresponding duration in seconds.
    */
    public static double hoursMinutesSecondsToSeconds(int hours, int minutes, double seconds) {
        return hours * TimeConstants.SecondsPerHour + minutes * TimeConstants.SecondsPerMinute + seconds;
    }

    /**
    * Gets the largest possible value of a {@link Duration}.
    * <p>
    The value is {@link Integer#MAX_VALUE} days and 86399.0 seconds.
    */
    @Nonnull
    public static Duration getMaxValue() {
        return s_maxValue;
    }

    /**
    * Gets the smallest possible value of a {@link Duration}.
    * <p>
    The value is {@link Integer#MIN_VALUE} days and -86399.0 seconds.
    */
    @Nonnull
    public static Duration getMinValue() {
        return s_minValue;
    }

    /**
    * Gets a {@link Duration} of 0 days and seconds.
    */
    @Nonnull
    public static Duration getZero() {
        return s_zero;
    }

    /**
    * Gets the day component of this {@link Duration}.
    */
    public final int getDays() {
        return m_days;
    }

    /**
    * Gets the seconds component of this {@link Duration}.  This is the number of seconds represented by
    this {@link Duration} in addition to the {@code Days} ({@link #getDays get}), so it will always be less than
    {@link TimeConstants#SecondsPerDay}.
    */
    public final double getSeconds() {
        return m_seconds;
    }

    /**
    * Gets the total number of whole and fractional days represented by this {@link Duration}.
    */
    public final double getTotalDays() {
        return m_days + m_seconds / TimeConstants.SecondsPerDay;
    }

    /**
    * Gets the total number of seconds represented by this {@link Duration}, including the seconds
    that compose the days returned by the {@code Days} ({@link #getDays get}) property.
    */
    public final double getTotalSeconds() {
        return m_days * TimeConstants.SecondsPerDay + m_seconds;
    }

    /**
    * Returns the value of the {@link Duration} in {@code Days} ({@link #getDays get}):{@code Seconds} ({@link #getSeconds get}).
    * @return The string.
    */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        StringHelper.appendFormat(builder, CultureInfoHelper.getCurrentCulture(), "{0}:{1}", m_days, m_seconds);
        return builder.toString();
    }

    /**
    * Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Integer.hashCode(m_days), Double.hashCode(m_seconds));
    }

    /**
    * Returns {@code true} if this {@link Duration} exactly equals another {@link Duration}, within the limits
    of floating point precision.  To be considered equal, the {@code Days} ({@link #getDays get})
    property must be identical and the
    difference between the {@code Seconds} ({@link #getSeconds get}) properties must be less than 1.0e-10.
    * @param other The other {@link Duration}.
    * @return {@code true} if this {@link Duration} exactly equals the {@code other} {@link Duration}, within the limits of floating point precision.
    */
    public final boolean equalsType(@Nonnull Duration other) {
        return m_days == other.m_days && Math.abs(m_seconds - other.m_seconds) < Constants.Epsilon10;
    }

    /**
    * Returns {@code true} if this {@link Duration} exactly equals another {@link Duration}, within the limits
    of floating point precision.  To be considered equal, the {@code Days} ({@link #getDays get})
    property must be identical and the
    difference between the {@code Seconds} ({@link #getSeconds get}) properties must be less than 1.0e-10.
    * @param obj The other {@link Duration}.
    * @return {@code true} if this {@link Duration} exactly equals the {@code obj} {@link Duration}, within the limits of floating point precision.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Duration && equalsType((Duration) obj);
    }

    /**
    * Returns {@code true} if this {@link Duration} is within {@code epsilon} seconds of the
    specified {@link Duration}.  That is, in order for the {@link Duration Durations} to be considered equal (and for
    this function to return {@code true}), the absolute value of the difference between them, in
    seconds, must be less than or equal to {@code epsilon}.
    * @param other The {@link Duration} to compare to this {@link Duration}.
    * @param epsilon The largest difference between the {@link Duration Durations}, in seconds, such that they will be considered equal.
    * @return {@code true} if the dates are equal as defined by the epsilon value.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(@Nonnull Duration other, double epsilon) {
        return Math.abs(subtract(other).getTotalSeconds()) <= epsilon;
    }

    /**
    * Compares this instance with another instance of the same type.
    * @param other An object to compare with this instance.
    * @return A value indicating the relative order of the objects being compared.  The return value has these meanings:
    <table border="1">
    <tr>
    <th>Value</th>
    <th>Meaning</th>
    </tr>
    <tr>
    <td>Less than zero</td>
    <td>
    This instance is less than {@code other}.
    </td>
    </tr>
    <tr>
    <td>Zero</td>
    <td>
    This instance is equal to {@code other}.
    </td>
    </tr>
    <tr>
    <td>Greater than zero</td>
    <td>
    This instance is greater than {@code other}.
    </td>
    </tr>
    </table>
    */
    public final int compareTo(@Nonnull Duration other) {
        int result = Integer.compare(m_days, other.m_days);
        if (result == 0) {
            result = Double.compare(m_seconds, other.m_seconds);
        }
        return result;
    }

    /**
    * Adds the specified {@link Duration} to this instance.
    * @param other The {@link Duration} to add to this instance.
    * @return A {@link Duration} that represents the value of this instance plus the value of {@code other}.
    */
    @Nonnull
    public final Duration add(@Nonnull Duration other) {
        int days = m_days + other.m_days;
        double seconds = m_seconds + other.m_seconds;
        return new Duration(days, seconds);
    }

    /**
    * Subtracts the specified {@link Duration} from this instance.
    * @param other The {@link Duration} to subtract from this instance.
    * @return A {@link Duration} that represents the value of this instance minus the value of {@code other}.
    */
    @Nonnull
    public final Duration subtract(@Nonnull Duration other) {
        int days = m_days - other.m_days;
        double seconds = m_seconds - other.m_seconds;
        return new Duration(days, seconds);
    }

    /**
    * Multiplies the {@link Duration} by a constant.
    * @param constant The constant by which to multiply the {@link Duration}.
    * @return A {@link Duration} that represents the value of this instance multiplied by the constant.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Duration multiply(double constant) {
        double days = m_days * constant;
        int wholeDays = (int) days;
        double fractionOfDay = days - wholeDays;
        double seconds = fractionOfDay * TimeConstants.SecondsPerDay + m_seconds * constant;
        return new Duration(wholeDays, seconds);
    }

    /**
    * Divides the {@link Duration} by another {@link Duration}, yield a constant.
    * @param divisor The {@link Duration} by which to divide this {@link Duration}.
    * @return The result of dividing this {@link Duration} by another.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final double divide(@Nonnull Duration divisor) {
        return getTotalSeconds() / divisor.getTotalSeconds();
    }

    /**
    * Divides the {@link Duration} by a constant.
    * @param constant The constant by which to divide the {@link Duration}.
    * @return A {@link Duration} that represents the value of this instance divided by the constant.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Duration divide(double constant) {
        double days = m_days / constant;
        int wholeDays = (int) days;
        double fractionOfDay = days - wholeDays;
        double seconds = fractionOfDay * TimeConstants.SecondsPerDay + m_seconds / constant;
        return new Duration(wholeDays, seconds);
    }

    /**
    * Adds a specified number of seconds to this {@link Duration} and returns the new {@link Duration}.
    * @param seconds The number of seconds to add.
    * @return A new {@link Duration} which is the sum of the original {@link Duration} and the specified number of seconds.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Duration addSeconds(double seconds) {
        return add(fromSeconds(seconds));
    }

    /**
    * Adds a specified number of days to this {@link Duration} and returns the new {@link Duration}.
    * @param days The number of days to add.
    * @return A new {@link Duration} which is the sum of the original {@link Duration} and the specified number of days.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Duration addDays(double days) {
        return add(fromDays(days));
    }

    /**
    * Returns {@code true} if two {@link Duration Durations} are exactly equal, within the limits
    of floating point precision.  To be considered equal, the {@code Days} ({@link #getDays get})
    property must be identical and the
    difference between the {@code Seconds} ({@link #getSeconds get}) properties must be less than 1.0e-10.
    * @param left The left {@link Duration}.
    * @param right The second {@link Duration}.
    * @return {@code true} if the {@link Duration Durations} are equal, otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Duration,Duration)'")
    public static boolean equals(@Nonnull Duration left, @Nonnull Duration right) {
        return left.equalsType(right);
    }

    /**
    * Returns {@code true} if two {@link Duration Durations} are NOT exactly equal, within the limits
    of floating point precision.  To be considered equal, the {@code Days} ({@link #getDays get})
    property must be identical (or one must be null) and the
    difference between the {@code Seconds} ({@link #getSeconds get}) properties must be less than 1.0e-10.
    * @param left The first {@link Duration}.
    * @param right The second {@link Duration}.
    * @return {@code true} if the {@link Duration Durations} are not equal, otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Duration,Duration)'")
    public static boolean notEquals(@Nonnull Duration left, @Nonnull Duration right) {
        return !left.equalsType(right);
    }

    /**
    * Returns {@code true} if {@code left} is shorter than {@code right}.
    * @param left The left {@link Duration}.
    * @param right The right {@link Duration}.
    * @return {@code true} if left is less than right; otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <(Duration,Duration)'")
    public static boolean lessThan(@Nonnull Duration left, @Nonnull Duration right) {
        return left.compareTo(right) < 0;
    }

    /**
    * Returns {@code true} if {@code left} is longer than {@code right}.
    * @param left The left {@link Duration}.
    * @param right The right {@link Duration}.
    * @return {@code true} if left is greater than right; otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >(Duration,Duration)'")
    public static boolean greaterThan(@Nonnull Duration left, @Nonnull Duration right) {
        return left.compareTo(right) > 0;
    }

    /**
    * Returns {@code true} if {@code left} is shorter than or exactly equal to {@code right}.
    * @param left The left {@link Duration}.
    * @param right The right {@link Duration}.
    * @return {@code true} if left is less than or equal to right; otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <=(Duration,Duration)'")
    public static boolean lessThanOrEqual(@Nonnull Duration left, @Nonnull Duration right) {
        return left.compareTo(right) <= 0;
    }

    /**
    * Returns {@code true} if {@code left} is longer than or exactly equal to {@code right}.
    * @param left The left {@link Duration}.
    * @param right The right {@link Duration}.
    * @return {@code true} if left is greater than or equal to right; otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >=(Duration,Duration)'")
    public static boolean greaterThanOrEqual(@Nonnull Duration left, @Nonnull Duration right) {
        return left.compareTo(right) >= 0;
    }

    /**
    * Adds two specified {@link Duration} instances.
    * @param left The first {@link Duration} to add.
    * @param right The second {@link Duration} to add.
    * @return The sum of {@code left} and {@code right}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Duration +(Duration,Duration)'")
    @Nonnull
    public static Duration add(@Nonnull Duration left, @Nonnull Duration right) {
        return left.add(right);
    }

    /**
    * Subtracts a specified {@link Duration} from another specified {@link Duration}.
    * @param left The subtrahend.
    * @param right The minuend.
    * @return The difference {@code left} minus {@code right}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Duration -(Duration,Duration)'")
    @Nonnull
    public static Duration subtract(@Nonnull Duration left, @Nonnull Duration right) {
        return left.subtract(right);
    }

    /**
    * Inverts a specified {@link Duration}.  For example, if the {@code value} represents a positive
    quantity of time, the returned {@link Duration} will be a negative quantity of time.
    * @param value The value to invert.
    * @return The inverted {@link Duration}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Duration -(Duration)'")
    @Nonnull
    public static Duration negate(@Nonnull Duration value) {
        return new Duration(-value.m_days, -value.m_seconds);
    }

    /**
    * Multiplies the {@link Duration} by a constant.
    * @param left The {@link Duration} to multiply.
    * @param right The constant by which to multiply the {@link Duration}.
    * @return A {@link Duration} that represents the value of this instance multiplied by the constant.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Duration *(Duration,System.Double)'")
    @Nonnull
    public static Duration multiply(@Nonnull Duration left, double right) {
        return left.multiply(right);
    }

    /**
    * Divides the {@link Duration} by another duration.
    * @param dividend The {@link Duration} to divide.
    * @param divisor The {@link Duration} by which to divide the {@link Duration}.
    * @return The result of dividing the dividend by the divisor.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Double /(Duration,Duration)'")
    public static double divide(@Nonnull Duration dividend, @Nonnull Duration divisor) {
        return dividend.divide(divisor);
    }

    /**
    * Divides the {@link Duration} by a constant.
    * @param dividend The {@link Duration} to divide.
    * @param divisor The constant by which to divide the {@link Duration}.
    * @return The result of dividing the dividend by the divisor.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Duration /(Duration,System.Double)'")
    @Nonnull
    public static Duration divide(@Nonnull Duration dividend, double divisor) {
        return dividend.divide(divisor);
    }

    /**
    * Returns a {@link Duration} that represents the specified number of days.
    * @param days The number of days to be represented by the returned {@link Duration}.
    * @return A {@link Duration} representing the specified number of days.
    */
    @Nonnull
    public static Duration fromDays(double days) {
        int wholeDays = (int) days;
        double seconds = (days - wholeDays) * TimeConstants.SecondsPerDay;
        return new Duration(wholeDays, seconds);
    }

    /**
    * Returns a {@link Duration} that represents the specified number of seconds.
    * @param seconds The number of seconds to be represented by the returned {@link Duration}.
    * @return A {@link Duration} representing the specified number of seconds.
    */
    @Nonnull
    public static Duration fromSeconds(double seconds) {
        return new Duration(0, seconds);
    }

    @Nonnull
    private static final Duration s_maxValue = new Duration(Integer.MAX_VALUE, 0.0);
    @Nonnull
    private static final Duration s_minValue = new Duration(Integer.MIN_VALUE, 0.0);
    @Nonnull
    private static final Duration s_zero = new Duration(0, 0.0);
    private int m_days;
    private double m_seconds;
}