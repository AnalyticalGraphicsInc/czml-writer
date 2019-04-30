package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import java.time.ZonedDateTime;
import javax.annotation.Nonnull;

/**
 *  
 An astronomical Julian Date, which is the number of days since noon on January 1, -4712 (4713 BC).
 For increased precision, this class stores the whole number part of the date as an {@code int}
 and the seconds into the day as a {@code double}.
 
 

 * <p>
 This type assumes that days always have {@link TimeConstants#SecondsPerDay} (86400.0) seconds.
 When using a {@link JulianDate} with the {@link TimeStandard#COORDINATED_UNIVERSAL_TIME} (UTC) time standard,
 a day with a leap second actually has 86401.0 seconds.  The end result is that {@link JulianDate} cannot
 represent the moment of a leap second with the UTC time standard.  It CAN represent the moment of a
 leap second in {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI), however.  Also, subtracting two
 UTC dates that are on opposite sides of a leap second will correctly take the leap second into account.
 
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class JulianDate implements Comparable<JulianDate>, IEquatable<JulianDate>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public JulianDate() {}

    /**
    *  
    Initializes a {@link JulianDate} from a {@link ZonedDateTime}.
    The time standard will be Coordinated Universal Time (UTC).
    
    

    * @param dateTime The {@link ZonedDateTime}.
    */
    public JulianDate(@Nonnull ZonedDateTime dateTime) {
        this(new GregorianDate(dateTime));
    }

    /**
    *  
    Initializes a {@link JulianDate} from a {@link GregorianDate}.
    The time standard will be {@link TimeStandard#COORDINATED_UNIVERSAL_TIME} (UTC), except when
    the {@code gregorianDate} represents time during a leap second.  During a leap second,
    the {@link JulianDate} will be in the {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI)
    standard.
    
    

    * @param gregorianDate The {@link GregorianDate} to use to specify the
    {@link JulianDate}.
    */
    public JulianDate(@Nonnull GregorianDate gregorianDate) {
        JulianDate converted = gregorianDate.toJulianDate();
        m_day = converted.m_day;
        m_secondsOfDay = converted.m_secondsOfDay;
        m_timeStandard = converted.m_timeStandard;
    }

    /**
    *  
    Initializes a {@link JulianDate} from a {@link ZonedDateTime} and specified time standard.
    
    
    

    * @param dateTime The {@link ZonedDateTime}.
    * @param standard 
    The time standard to use for this Julian Date.  The {@code dateTime} is assumed to be expressed
    in this time standard.
    
    */
    public JulianDate(@Nonnull ZonedDateTime dateTime, @Nonnull TimeStandard standard) {
        this(new GregorianDate(dateTime), standard);
    }

    /**
    *  
    Initializes a {@link JulianDate} from a {@link GregorianDate} where the {@link GregorianDate}
    is expressed in the given {@link TimeStandard}.  If the date is during a leap second, the
    {@link JulianDate} will be expressed in {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI).
    
    
    

    * @param gregorianDate The {@link GregorianDate}.
    * @param standard 
    The time standard in which the {@code gregorianDate} is expressed.
    
    */
    public JulianDate(@Nonnull GregorianDate gregorianDate, @Nonnull TimeStandard standard) {
        JulianDate converted = gregorianDate.toJulianDate(standard);
        m_day = converted.m_day;
        m_secondsOfDay = converted.m_secondsOfDay;
        m_timeStandard = converted.getStandard();
    }

    /**
    *  
    Initializes a {@link JulianDate} from the provided values.  The values will be
    normalized so that the {@code SecondsOfDay} ({@link #getSecondsOfDay get}) property is less than the length of a day.
    The time standard will be International Atomic Time (TAI).
    
    
    

    * @param day The whole number part of the date.
    * @param secondsOfDay The time of day, expressed as seconds past noon on the given whole-number day.
    */
    public JulianDate(int day, double secondsOfDay) {
        this(day, secondsOfDay, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
    }

    /**
    *  
    Initializes a {@link JulianDate} from the provided values.  The values will be
    normalized so that the {@code SecondsOfDay} ({@link #getSecondsOfDay get}) property is less than the length of the day.
    
    
    
    

    * @param day The whole number part of the date.
    * @param secondsOfDay The time of day, expressed as seconds past noon on the given whole-number day.
    * @param timeStandard The time standard to use for this Julian Date.
    */
    public JulianDate(int day, double secondsOfDay, @Nonnull TimeStandard timeStandard) {
        m_timeStandard = timeStandard;
        m_day = day;
        m_secondsOfDay = secondsOfDay;
        // Normalize so that the number of seconds is >= 0 and < a day.
        if (m_secondsOfDay < 0) {
            int wholeDays = (int) (m_secondsOfDay / TimeConstants.SecondsPerDay);
            --wholeDays;
            m_day += wholeDays;
            m_secondsOfDay -= TimeConstants.SecondsPerDay * wholeDays;
            if (m_secondsOfDay > TimeConstants.NextBefore86400) {
                ++m_day;
                m_secondsOfDay = 0.0;
            }
        } else if (m_secondsOfDay >= TimeConstants.SecondsPerDay) {
            int wholeDays = (int) (m_secondsOfDay / TimeConstants.SecondsPerDay);
            m_day += wholeDays;
            m_secondsOfDay -= TimeConstants.SecondsPerDay * wholeDays;
        }
    }

    /**
    *  
    Initializes a {@link JulianDate} from a double expressing the complete astronomical Julian Date.
    The time standard will be {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME International Atomic Time (TAI)}.
    
    

    * @param dayCount The complete astronomical Julian date.
    */
    public JulianDate(double dayCount) {
        this(dayCount, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
    }

    /**
    *  
    Initializes a {@link JulianDate} from a double expressing the complete astronomical Julian Date.
    
    
    

    * @param dayCount The complete Julian date.
    * @param timeStandard The time standard to use for this Julian Date.
    */
    public JulianDate(double dayCount, @Nonnull TimeStandard timeStandard) {
        m_timeStandard = timeStandard;
        m_day = (int) dayCount;
        m_secondsOfDay = (dayCount - m_day) * TimeConstants.SecondsPerDay;
    }

    /**
    *  Gets the smallest value possible of {@link JulianDate}.
    

    */
    @Nonnull
    public static JulianDate getMinValue() {
        return s_minValue;
    }

    /**
    *  Gets the largest possible value of {@link JulianDate}.
    

    */
    @Nonnull
    public static JulianDate getMaxValue() {
        return s_maxValue;
    }

    /**
    *  Gets the total number of whole and fractional days represented by this astronomical Julian date.
    

    */
    public final double getTotalDays() {
        return m_day + m_secondsOfDay / TimeConstants.SecondsPerDay;
    }

    /**
    *  Gets the integer portion of the Julian Date (or astronomical Julian day number).
    

    */
    public final int getDay() {
        return m_day;
    }

    /**
    *  Gets the number of seconds past noon on the whole-number Julian Day.
    

    */
    public final double getSecondsOfDay() {
        return m_secondsOfDay;
    }

    /**
    *  Gets the {@link TimeStandard} that this astronomical Julian date is based upon.
    

    */
    @Nonnull
    public final TimeStandard getStandard() {
        return m_timeStandard;
    }

    /**
    *  Gets the {@link JulianDate} that represents the current date and time. The time standard will be Coordinated Universal Time (UTC).
    

    */
    @Nonnull
    public static JulianDate getNow() {
        return new JulianDate(DateTimeHelper.utcNow());
    }

    /**
    *  
    Converts this {@link JulianDate} to the specified time standard.
    
    
    
    

    * @param timeStandard The requested time standard.
    * @return An equivalent {@link JulianDate} using the requested time standard.
    * @exception ArgumentOutOfRangeException 
    Thrown if the specified {@link TimeStandard} is not capable of
    representing this {@link JulianDate}.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final JulianDate toTimeStandard(@Nonnull TimeStandard timeStandard) {
        @CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
        JulianDate result = new JulianDate();
        final JulianDate[] out$result$1 = {
            null
        };
        final boolean temp$0 = tryConvertTimeStandard(timeStandard, out$result$1);
        result = out$result$1[0];
        if (!temp$0) {
            throw new ArgumentOutOfRangeException(CesiumLocalization.getCannotRepresentLeapSecondAsUTCJulianDate());
        }
        return result;
    }

    /**
    *  
    Try to convert this {@link JulianDate} to the specified
    {@link TimeStandard}, if the specified {@link TimeStandard} is
    capable of representing this time.
    
    
    
    

    * @param timeStandard The requested time standard.
    * @param result 
    On input, an array with one element.  On return, the array is populated with
    
    an equivalent
    {@link JulianDate} using the requested {@link TimeStandard}, if it
    is capable of representing this time, otherwise {@code MinValue} ({@link #getMinValue get}).
    
    * @return {@code true} if this date could be converted to the
    requested {@link TimeStandard}, otherwise false.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean tryConvertTimeStandard(@Nonnull TimeStandard timeStandard, @Nonnull JulianDate[] result) {
        if (timeStandard == getStandard()) {
            result[0] = this;
            return true;
        }
        if (timeStandard == TimeStandard.INTERNATIONAL_ATOMIC_TIME && getStandard() == TimeStandard.COORDINATED_UNIVERSAL_TIME) {
            result[0] = new JulianDate(getDay(), getSecondsOfDay() + LeapSeconds.getInstance().getTaiMinusUtc(this), timeStandard);
            return true;
        }
        if (timeStandard == TimeStandard.COORDINATED_UNIVERSAL_TIME && getStandard() == TimeStandard.INTERNATIONAL_ATOMIC_TIME) {
            return LeapSeconds.getInstance().tryConvertTaiToUtc(this, result);
        }
        result[0] = getMinValue();
        return false;
    }

    /**
    *  
    Converts this date to {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI).
    
    

    * @return An equivalent date expressed in TAI.
    */
    @Nonnull
    public final JulianDate toInternationalAtomicTime() {
        if (getStandard() == TimeStandard.INTERNATIONAL_ATOMIC_TIME) {
            return this;
        }
        return new JulianDate(getDay(), getSecondsOfDay() + LeapSeconds.getInstance().getTaiMinusUtc(this), TimeStandard.INTERNATIONAL_ATOMIC_TIME);
    }

    /**
    *  
    Computes the number of seconds that have elapsed from this Julian date to the
    {@code other} Julian date.
    
    
    
    

    * <p>
    This method subtracts the Julian date on which it is called from the {@code other}
    Julian date and returns the number of seconds between them.  The computation is done in the time
    standard of this Julian date, or the closest standard that is safe for arithmetic if this
    Julian date's time standard is not safe.  For best performance, this Julian date and the
    {@code other} Julian date should have the same time standard and it should be
    safe for arithmetic.
    
    * @param other The other Julian date, which is the end of the interval.
    * @return The number of seconds that have elapsed from this Julian date to the other Julian date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final double secondsDifference(@Nonnull JulianDate other) {
        JulianDate start = toInternationalAtomicTime();
        JulianDate end = other.toInternationalAtomicTime();
        long startDay = start.getDay();
        long endDay = end.getDay();
        return (endDay - startDay) * TimeConstants.SecondsPerDay + (end.getSecondsOfDay() - start.getSecondsOfDay());
    }

    /**
    *  
    Computes the number of minutes that have elapsed from this Julian date to the
    {@code other} Julian date.
    
    
    
    

    * <p>
    This method subtracts the Julian date on which it is called from the {@code other}
    Julian date and returns the number of minutes between them.  The computation is done in the time
    standard of this Julian date, or the closest standard that is safe for arithmetic if this
    Julian date's time standard is not safe.  For best performance, this Julian date and the
    {@code other} Julian date should have the same time standard and it should be
    safe for arithmetic.
    
    * @param other The other Julian date, which is the end of the interval.
    * @return The number of minutes that have elapsed from this Julian date to the other Julian date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final double minutesDifference(@Nonnull JulianDate other) {
        JulianDate start = toInternationalAtomicTime();
        JulianDate end = other.toInternationalAtomicTime();
        long startDay = start.getDay();
        long endDay = end.getDay();
        return (endDay - startDay) * TimeConstants.MinutesPerDay + (end.getSecondsOfDay() - start.getSecondsOfDay()) / TimeConstants.SecondsPerMinute;
    }

    /**
    *  
    Computes the number of days that have elapsed from this Julian date to the
    {@code other} Julian date.
    
    
    
    

    * <p>
    This method subtracts the Julian date on which it is called from the {@code other}
    Julian date and returns the number of days between them.  The computation is done in the time
    standard of this Julian date, or the closest standard that is safe for arithmetic if this
    Julian date's time standard is not safe.  For best performance, this Julian date and the
    {@code other} Julian date should have the same time standard and it should be
    safe for arithmetic.
    
    * @param other The other Julian date, which is the end of the interval.
    * @return The number of days that have elapsed from this Julian date to the other Julian date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final double daysDifference(@Nonnull JulianDate other) {
        JulianDate start = toInternationalAtomicTime();
        JulianDate end = other.toInternationalAtomicTime();
        long startDay = start.getDay();
        long endDay = end.getDay();
        return endDay - startDay + (end.getSecondsOfDay() - start.getSecondsOfDay()) / TimeConstants.SecondsPerDay;
    }

    /**
    *  
    Adds a {@link Duration} to this Julian date, producing a new Julian date.
    
    
    

    * @param duration The duration to add.
    * @return 
    A new {@link JulianDate} that is the result of the addition.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final JulianDate add(@Nonnull Duration duration) {
        final TimeStandard additionTimeStandard = TimeStandard.INTERNATIONAL_ATOMIC_TIME;
        if (additionTimeStandard != getStandard()) {
            // Do the addition in the addition time standard
            JulianDate resultInAdditionStandard = toInternationalAtomicTime().addIgnoringTimeStandard(duration);
            //then convert back if possible
            @CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
            JulianDate result = new JulianDate();
            final JulianDate[] out$result$3 = {
                null
            };
            final boolean temp$2 = resultInAdditionStandard.tryConvertTimeStandard(getStandard(), out$result$3);
            result = out$result$3[0];
            if (temp$2) {
                return result;
            }
            //if we couldn't convert back, then use the valid result in the addition standard
            return resultInAdditionStandard;
        }
        // Time standards match up, so do the addition directly.
        return addIgnoringTimeStandard(duration);
    }

    @Nonnull
    private final JulianDate addIgnoringTimeStandard(@Nonnull Duration duration) {
        int days = getDay() + duration.getDays();
        double seconds = getSecondsOfDay() + duration.getSeconds();
        return new JulianDate(days, seconds, getStandard());
    }

    /**
    *  
    Subtracts another Julian date from this Julian date.
    
    
    
    

    * <p>
    This method subtracts the {@code subtrahend} Julian date from this
    Julian date and returns the {@link Duration} between them.  The computation is done in
    the time standard of the {@code subtrahend}, or the closest standard that is safe for
    arithmetic if the subtrahend's time standard is not safe.  For best performance, this Julian date
    and the subtrahend Julian date should have the same time standard and it should be
    safe for arithmetic.
    
    * @param subtrahend The Julian Date to subtract from this Julian Date.
    * @return The Duration that is the result of the subtraction.  The time standard will be the same as the time standard of the subtrahend.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Duration subtract(@Nonnull JulianDate subtrahend) {
        final TimeStandard subtractionTimeStandard = TimeStandard.INTERNATIONAL_ATOMIC_TIME;
        if (subtractionTimeStandard != getStandard() && subtractionTimeStandard != subtrahend.getStandard()) {
            // Convert both the subtrahend and the minuend to the subtraction time standard.
            return toInternationalAtomicTime().subtractIgnoringTimeStandard(subtrahend.toInternationalAtomicTime());
        }
        if (subtractionTimeStandard != getStandard()) {
            // Convert the minuend to the subtraction time standard - subtrahend is already in the correct standard.
            return toInternationalAtomicTime().subtractIgnoringTimeStandard(subtrahend);
        }
        if (subtractionTimeStandard != subtrahend.getStandard()) {
            // Convert the subtrahend to the subtraction time standard - minuend is already in the correct standard.
            return subtractIgnoringTimeStandard(subtrahend.toInternationalAtomicTime());
        }
        // Time standards match up, so do the subtraction directly.
        return subtractIgnoringTimeStandard(subtrahend);
    }

    @Nonnull
    private final Duration subtractIgnoringTimeStandard(@Nonnull JulianDate subtrahend) {
        int days = getDay() - subtrahend.getDay();
        double seconds = getSecondsOfDay() - subtrahend.getSecondsOfDay();
        return new Duration(days, seconds);
    }

    /**
    *  
    Subtracts a {@link Duration} from this Julian date, producing a new
    Julian date.
    
    
    

    * @param duration The duration to subtract.
    * @return 
    A new {@link JulianDate} that is the result of the subtraction.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final JulianDate subtract(@Nonnull Duration duration) {
        return add(new Duration(-duration.getDays(), -duration.getSeconds()));
    }

    /**
    *  
    Adds the specified number of seconds to this date and returns the new date.
    
    
    

    * @param seconds The number of seconds.
    * @return The new date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final JulianDate addSeconds(double seconds) {
        return add(Duration.fromSeconds(seconds));
    }

    /**
    *  
    Subtracts the specified number of seconds to this date and returns the new
    date.
    
    
    

    * @param seconds The number of seconds.
    * @return The new date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final JulianDate subtractSeconds(double seconds) {
        return subtract(Duration.fromSeconds(seconds));
    }

    /**
    *  
    Adds the specified number of days to this date and returns the new date.
    
    
    

    * @param days The number of days.
    * @return The new date.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final JulianDate addDays(double days) {
        return add(Duration.fromDays(days));
    }

    /**
    *  
    Subtracts a Julian date from another Julian date, yielding a
    {@link Duration}.
    
    
    
    

    * @param left The minuend.
    * @param right The subtrahend.
    * @return 
    The Duration that is the result of the subtraction; that is,
    {@code left} minus {@code right}.  The time standard will
    be the same as the time standard of the subtrahend.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Duration -(JulianDate,JulianDate)'")
    @Nonnull
    public static Duration subtract(@Nonnull JulianDate left, @Nonnull JulianDate right) {
        return left.subtract(right);
    }

    /**
    *  
    Subtracts a {@link Duration} from a Julian date, yielding a new
    {@link JulianDate}.
    
    
    
    

    * @param left The minuend.
    * @param right The subtrahend.
    * @return 
    A new Julian Date that is the result of the subtraction; that is,
    {@code left} minus {@code right}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'JulianDate -(JulianDate,Duration)'")
    @Nonnull
    public static JulianDate subtract(@Nonnull JulianDate left, @Nonnull Duration right) {
        return left.subtract(right);
    }

    /**
    *  
    Adds a {@link Duration} to a {@link JulianDate}, producing a new
    Julian date.
    
    
    
    

    * @param left The Julian date.
    * @param right The duration.
    * @return A new Julian Date that is the result of the addition.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'JulianDate +(JulianDate,Duration)'")
    @Nonnull
    public static JulianDate add(@Nonnull JulianDate left, @Nonnull Duration right) {
        return left.add(right);
    }

    /**
    *  
    Returns true if the two dates are exactly equal.  To be considered equal, the {@code Day} ({@link #getDay get})
    and {@code SecondsOfDay} ({@link #getSecondsOfDay get}) properties must be identical when converted to a common time standard.
    It is highly recommended that you use {@link #equalsEpsilon} or {@link #isIdentical}
    instead of this method.
    
    
    
    

    * @param left The date on the left side.
    * @param right The date on the right side.
    * @return {@code true} if the dates are equal, otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(JulianDate,JulianDate)'")
    public static boolean equals(@Nonnull JulianDate left, @Nonnull JulianDate right) {
        return left.equalsType(right);
    }

    /**
    *  
    Returns true if the two dates are NOT exactly equal.  To be considered equal, the {@code Day} ({@link #getDay get})
    and {@code SecondsOfDay} ({@link #getSecondsOfDay get}) properties must be identical when converted to a common time standard.
    It is highly recommended that you use {@link #equalsEpsilon} or {@link #isIdentical}
    instead of this method.
    
    
    
    

    * @param left The date on the left side.
    * @param right The date on the right side.
    * @return {@code true} if the dates are not equal, otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(JulianDate,JulianDate)'")
    public static boolean notEquals(@Nonnull JulianDate left, @Nonnull JulianDate right) {
        return !left.equalsType(right);
    }

    /**
    *  
    Returns true if {@code left} occurs before {@code right}.
    
    
    
    

    * @param left The date on the left side.
    * @param right The date on the right side.
    * @return {@code true} if the {@code left} is less than {@code right}, otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <(JulianDate,JulianDate)'")
    public static boolean lessThan(@Nonnull JulianDate left, @Nonnull JulianDate right) {
        return left.compareTo(right) < 0;
    }

    /**
    *  
    Returns true if {@code left} occurs after {@code right}.
    
    
    
    

    * @param left The date on the left side.
    * @param right The date on the right side.
    * @return {@code true} if the {@code left} is greater than {@code right}, otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >(JulianDate,JulianDate)'")
    public static boolean greaterThan(@Nonnull JulianDate left, @Nonnull JulianDate right) {
        return left.compareTo(right) > 0;
    }

    /**
    *  
    Returns true if {@code left} occurs before or at the same time as {@code right}.
    
    
    
    

    * @param left The date on the left side.
    * @param right The date on the right side.
    * @return {@code true} if the {@code left} is less than or equal to {@code right}, otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <=(JulianDate,JulianDate)'")
    public static boolean lessThanOrEqual(@Nonnull JulianDate left, @Nonnull JulianDate right) {
        return left.compareTo(right) <= 0;
    }

    /**
    *  
    Returns true if {@code left} occurs after or at the same time as {@code right}.
    
    
    
    

    * @param left The date on the left side.
    * @param right The date on the right side.
    * @return {@code true} if the {@code left} is greater than or equal to {@code right}, otherwise {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >=(JulianDate,JulianDate)'")
    public static boolean greaterThanOrEqual(@Nonnull JulianDate left, @Nonnull JulianDate right) {
        return left.compareTo(right) >= 0;
    }

    /**
    *  
    Returns true if this date exactly equals another date.  To be considered equal, the {@code Day} ({@link #getDay get})
    and {@code SecondsOfDay} ({@link #getSecondsOfDay get}) properties must be identical when converted to a common time standard.
    It is highly recommended that you use {@link #equalsEpsilon} or {@link #isIdentical}
    instead of this method.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof JulianDate && equalsType((JulianDate) obj);
    }

    /**
    *  
    Returns true if this date exactly equals another date.  To be considered equal, the {@code Day} ({@link #getDay get})
    and {@code SecondsOfDay} ({@link #getSecondsOfDay get}) properties must be identical when converted to a common time standard.
    It is highly recommended that you use {@link #equalsEpsilon} or {@link #isIdentical}
    instead of this method.
    
    
    

    * @param other The date to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    public final boolean equalsType(@Nonnull JulianDate other) {
        return compareTo(other) == 0;
    }

    /**
    *  
    Returns true if this date is identical to another date.  Unlike {@link #equalsType(JulianDate)}, this method will
    consider two dates with different time standards to be different even if the dates represent the same
    moment when expressed in the same time standard.
    
    
    

    * @param other The date to compare to this instance.
    * @return {@code true} if {@code other} is identical to this instance; otherwise, {@code false}.
    */
    @CS2JWarning( {
            "Unhandled attribute removed: Pure",
            "Unhandled attribute removed: SuppressMessage"
    })
    public final boolean isIdentical(@Nonnull JulianDate other) {
        return m_day == other.m_day && m_secondsOfDay == other.m_secondsOfDay && m_timeStandard == other.m_timeStandard;
    }

    /**
    *  
    Returns true if this date is within {@code epsilon} seconds of the
    specified date.  That is, in order for the dates to be considered equal (and for
    this function to return true), the absolute value of the difference between them, in
    seconds, must be less than or equal to {@code epsilon}.
    
    
    
    

    * @param other The Julian Date to compare to this date.
    * @param epsilon The largest difference between the dates, in seconds, such that they will be considered equal.
    * @return true if the dates are equal as defined by the epsilon value.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(@Nonnull JulianDate other, double epsilon) {
        return Math.abs(other.secondsDifference(this)) <= epsilon;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Integer.hashCode(m_day), Double.hashCode(m_secondsOfDay), getStandard().hashCode());
    }

    /**
    *  
    Returns the value of this {@link JulianDate} in the standard format.
    
    

    * @return The string.
    */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        StringHelper.appendFormat(builder, CultureInfoHelper.getCurrentCulture(), "{0}:{1} ", m_day, m_secondsOfDay);
        builder.append(getStandard() == TimeStandard.COORDINATED_UNIVERSAL_TIME ? "UTC" : "TAI");
        if (JulianDate.lessThan(this, GregorianDate.MinValue.toJulianDate())) {
            StringHelper.appendFormat(builder, CultureInfoHelper.getCurrentCulture(), " (before {0})", GregorianDate.MinValue);
        } else if (JulianDate.greaterThan(this, GregorianDate.MaxValue.toJulianDate())) {
            StringHelper.appendFormat(builder, CultureInfoHelper.getCurrentCulture(), " (after {0})", GregorianDate.MaxValue);
        } else {
            StringHelper.appendFormat(builder, CultureInfoHelper.getCurrentCulture(), " ({0})", toGregorianDate());
        }
        return builder.toString();
    }

    /**
    *  
    Compares this instance with another instance of the same type.
    
    
    

    * @param other An object to compare with this instance.
    * @return 
    A value indicating the relative order of the objects being compared.  The return value has these meanings:
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
    public final int compareTo(@Nonnull JulianDate other) {
        // If the days aren't even close, don't bother thinking about the time standard.
        long dayDifference = (long) m_day - other.m_day;
        if (dayDifference > 1 || dayDifference < -1) {
            // just compare the days for ordering
            return Integer.compare(m_day, other.m_day);
        }
        // convert time standards
        @CS2JInfo("Initialization of C# struct variable 'self' added by translator.")
        JulianDate self = new JulianDate();
        @CS2JInfo("Initialization of C# struct variable 'otherDate' added by translator.")
        JulianDate otherDate = new JulianDate();
        final JulianDate[] out$otherDate$5 = {
            null
        };
        final boolean temp$4 = other.tryConvertTimeStandard(getStandard(), out$otherDate$5);
        otherDate = out$otherDate$5[0];
        if (temp$4) {
            // if we can convert the other date to our time standard, then we're done
            self = this;
        } else {
            // otherwise if we can't convert the other date to our time standard, then convert both to our ArithmeticSafeStandard
            self = toInternationalAtomicTime();
            otherDate = other.toInternationalAtomicTime();
        }
        int result = Integer.compare(self.m_day, otherDate.m_day);
        if (result == 0) {
            result = Double.compare(self.m_secondsOfDay, otherDate.m_secondsOfDay);
        }
        return result;
    }

    /**
    *  
    Converts this {@link JulianDate} to a 
    {@link ZonedDateTime} with a default time standard of Coordinated Universal
    Time.
    
    

    * @return The {@link ZonedDateTime}.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final ZonedDateTime toDateTime() {
        return toGregorianDate().toDateTime();
    }

    /**
    *  
    Converts this {@link JulianDate} to a 
    {@link ZonedDateTime} expressed in the specified time standard.
    
    
    

    * @param standard The time standard in which to express the returned
    {@link ZonedDateTime}.
    * @return The {@link ZonedDateTime}.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final ZonedDateTime toDateTime(@Nonnull TimeStandard standard) {
        return toGregorianDate(standard).toDateTime();
    }

    /**
    *  
    Converts this {@link JulianDate} to a {@link GregorianDate} with a
    default time standard of Coordinated Universal Time.
    
    

    * @return The {@link GregorianDate}.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final GregorianDate toGregorianDate() {
        return toGregorianDate(TimeStandard.COORDINATED_UNIVERSAL_TIME);
    }

    /**
    *  
    Converts this {@link JulianDate} to a {@link GregorianDate}
    expressed in the specified time standard.
    
    
    

    * @param standard The time standard in which to express the returned
    {@link GregorianDate}.
    * @return The {@link GregorianDate}.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final GregorianDate toGregorianDate(@Nonnull TimeStandard standard) {
        return new GregorianDate(this, standard);
    }

    @Nonnull
    private static final JulianDate s_maxValue = new JulianDate(Integer.MAX_VALUE, 0.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
    @Nonnull
    private static final JulianDate s_minValue = new JulianDate(Integer.MIN_VALUE, 0.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
    private int m_day;
    private double m_secondsOfDay;
    @Nonnull
    private TimeStandard m_timeStandard = TimeStandard.getDefault();
}