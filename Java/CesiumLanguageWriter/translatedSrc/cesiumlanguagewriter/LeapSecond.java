package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;

/**
 *  
 Describes a single leap second.
 
 

 * 
 The International Earth Rotation Service (IERS) periodically introduces an intercalary adjustment
 to the Coordinated Universal Time (UTC) time scale in order to keep it in close agreement with the
 Universal Time (UT1) time scale.  This adjustment amounts to a one second discontinuity, a leap second,
 in the UTC time scale that, in addition to the UT1 time scales, also affects transformations to
 other continuous time scales.  Since the inception of leap seconds, all adjustments have been
 performed either at the end of 30 June or 31 December UTC though a leap second could, by rule,
 be applied at the end of any month.
 
 */
public class LeapSecond implements IEquatable<LeapSecond>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public LeapSecond() {}

	/**
	 *  
	Initializes a new instance of a Leap Second.
	
	
	

	 * @param date The Julian date of the leap second, in Coordinated Universal Time (UTC).
	 * @param totalTaiOffsetFromUtc The offset of TAI from UTC after this leap second.
	 */
	public LeapSecond(double date, double totalTaiOffsetFromUtc) {
		this(new JulianDate(date, TimeStandard.COORDINATED_UNIVERSAL_TIME), totalTaiOffsetFromUtc);
	}

	/**
	 *  
	Initializes a new instance of a Leap Second.
	
	
	

	 * @param date The date of the leap second.  This will be assumed to be Coordinated Universal Time (UTC) regardless of the actual time standard associated with the date.
	 * @param totalTaiOffsetFromUtc The offset of TAI from UTC after this leap second.
	 */
	public LeapSecond(JulianDate date, double totalTaiOffsetFromUtc) {
		// Force the time standard to be UTC.
		m_date = new JulianDate(date.getDay(), date.getSecondsOfDay(), TimeStandard.COORDINATED_UNIVERSAL_TIME);
		m_totalTaiOffsetFromUtc = totalTaiOffsetFromUtc;
	}

	/**
	 *  Gets the date of the leap second.
	

	 */
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
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof LeapSecond && equalsType((LeapSecond) obj);
	}

	/**
	 *  
	Indicates whether another instance of this type is exactly equal to this instance.
	
	
	

	 * @param other The instance to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(LeapSecond other) {
		return m_date.isIdentical(other.m_date) && m_totalTaiOffsetFromUtc == other.m_totalTaiOffsetFromUtc;
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return HashCode.combine(m_date.hashCode(), DoubleHelper.hashCode(m_totalTaiOffsetFromUtc));
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
	Returns <see langword="true" /> if the two instances are exactly equal.
	
	
	
	

	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> represents the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(LeapSecond,LeapSecond)'")
	public static boolean equals(LeapSecond left, LeapSecond right) {
		return left.equalsType(right);
	}

	/**
	 *  
	Returns <see langword="true" /> if the two instances are not exactly equal.
	
	
	
	

	 * @param left The instance to compare to <code>right</code>.
	 * @param right The instance to compare to <code>left</code>.
	 * @return 
	<see langword="true" /> if <code>left</code> does not represent the same value as <code>right</code>; otherwise, <see langword="false" />.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(LeapSecond,LeapSecond)'")
	public static boolean notEquals(LeapSecond left, LeapSecond right) {
		return !left.equalsType(right);
	}

	@CS2JInfo("Initialization of C# struct variable 'm_date' added by translator.")
	private JulianDate m_date = new JulianDate();
	private double m_totalTaiOffsetFromUtc;
}