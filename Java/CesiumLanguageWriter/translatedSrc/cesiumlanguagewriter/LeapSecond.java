package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import javax.annotation.Nonnull;

/**
 *  
 Describes a single leap second.
 
 

 * <p>
 The International Earth Rotation Service (IERS) periodically introduces an intercalary adjustment
 to the Coordinated Universal Time (UTC) time scale in order to keep it in close agreement with the
 Universal Time (UT1) time scale.  This adjustment amounts to a one second discontinuity, a leap second,
 in the UTC time scale that, in addition to the UT1 time scales, also affects transformations to
 other continuous time scales.  Since the inception of leap seconds, all adjustments have been
 performed either at the end of 30 June or 31 December UTC though a leap second could, by rule,
 be applied at the end of any month.
 
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class LeapSecond implements IEquatable<LeapSecond>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public LeapSecond() {}

    /**
    *  
    Initializes a new instance.
    
    
    

    * @param date The Julian date of the leap second, in Coordinated Universal Time (UTC).
    * @param totalTaiOffsetFromUtc The offset of TAI from UTC after this leap second.
    */
    public LeapSecond(double date, double totalTaiOffsetFromUtc) {
        this(new JulianDate(date, TimeStandard.COORDINATED_UNIVERSAL_TIME), totalTaiOffsetFromUtc);
    }

    /**
    *  
    Initializes a new instance of a Leap Second.
    
    
    
    

    * @param date The date of the leap second.  This date must be in Coordinated Universal Time (UTC).
    * @param totalTaiOffsetFromUtc The offset of TAI from UTC after this leap second.
    * @exception ArgumentException 
    Thrown if the given date is not in UTC.
    
    */
    public LeapSecond(@Nonnull JulianDate date, double totalTaiOffsetFromUtc) {
        if (date.getStandard() != TimeStandard.COORDINATED_UNIVERSAL_TIME) {
            throw new ArgumentException(CesiumLocalization.getDateMustBeUTC(), "date");
        }
        m_date = date;
        m_totalTaiOffsetFromUtc = totalTaiOffsetFromUtc;
    }

    /**
    *  Gets the date of the leap second.
    

    */
    @Nonnull
    public final JulianDate getDate() {
        return m_date;
    }

    /**
    *  Gets the total difference TAI - UTC after this leap second, in seconds.
    

    */
    public final double getTotalTaiOffsetFromUtc() {
        return m_totalTaiOffsetFromUtc;
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof LeapSecond && equalsType((LeapSecond) obj);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull LeapSecond other) {
        return m_date.isIdentical(other.m_date) && m_totalTaiOffsetFromUtc == other.m_totalTaiOffsetFromUtc;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(m_date.hashCode(), Double.hashCode(m_totalTaiOffsetFromUtc));
    }

    /**
    *  
    Returns the date of this LeapSecond and offset from UTC as a string.
    
    

    * @return The string.
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}", m_date, m_totalTaiOffsetFromUtc);
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(LeapSecond,LeapSecond)'")
    public static boolean equals(@Nonnull LeapSecond left, @Nonnull LeapSecond right) {
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(LeapSecond,LeapSecond)'")
    public static boolean notEquals(@Nonnull LeapSecond left, @Nonnull LeapSecond right) {
        return !left.equalsType(right);
    }

    @CS2JInfo("Initialization of C# struct variable 'm_date' added by translator.")
    @Nonnull
    private JulianDate m_date = new JulianDate();
    private double m_totalTaiOffsetFromUtc;
}