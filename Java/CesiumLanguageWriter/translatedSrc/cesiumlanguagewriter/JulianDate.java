package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.IntHelper;
import agi.foundation.compatibility.StringHelper;
import org.joda.time.DateTime;

/**
 *  
 An astronomical Julian Date, which is the number of days since noon on January 1, -4712 (4713 BC).
 For increased precision, this class stores the whole number part of the date as an  <code>int</code>
 and the seconds into the day as a  <code>double</code>.
 
 

 * 
 This type assumes that days always have  {@link TimeConstants#SecondsPerDay} (86400.0) seconds.
 When using a  {@link JulianDate} with the  {@link TimeStandard#COORDINATED_UNIVERSAL_TIME} (UTC) time standard,
 a day with a leap second actually has 86401.0 seconds.  The end result is that  {@link JulianDate} cannot
 represent the moment of a leap second with the UTC time standard.  It CAN represent the moment of a
 leap second in  {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI), however.  Also, subtracting two
 UTC dates that are on opposite sides of a leap second will correctly take the leap second into account.
 
 */
public class JulianDate implements Comparable<JulianDate>, IEquatable<JulianDate>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public JulianDate() {}

	/**
	 *  
	Initializes a  {@link JulianDate} from a  {@link DateTime}.
	The time standard will be Coordinated Universal Time (UTC).
	
	

	 * @param dateTime The  {@link DateTime}.
	 */
	public JulianDate(DateTime dateTime) {
		this(new GregorianDate(dateTime));
	}

	/**
	 *  
	Initializes a  {@link JulianDate} from a  {@link GregorianDate}.
	The time standard will be  {@link TimeStandard#COORDINATED_UNIVERSAL_TIME} (UTC), except when
	the <code>gregorianDate</code> represents time during a leap second.  During a leap second,
	the  {@link JulianDate} will be in the  {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI)
	standard.
	
	

	 * @param gregorianDate The  {@link GregorianDate} to use to specify the 
	{@link JulianDate}.
	 */
	public JulianDate(GregorianDate gregorianDate) {
		JulianDate converted = gregorianDate.toJulianDate();
		m_day = converted.m_day;
		m_secondsOfDay = converted.m_secondsOfDay;
		m_timeStandard = converted.m_timeStandard;
	}

	/**
	 *  
	Initializes a  {@link JulianDate} from a  {@link DateTime} and specified time standard.
	
	
	

	 * @param dateTime The  {@link DateTime}.
	 * @param standard 
	The time standard to use for this Julian Date.  The <code>dateTime</code> is assumed to be expressed
	in this time standard.
	
	 */
	public JulianDate(DateTime dateTime, TimeStandard standard) {
		this(new GregorianDate(dateTime), standard);
	}

	/**
	 *  
	Initializes a  {@link JulianDate} from a  {@link GregorianDate} where the  {@link GregorianDate} 
	is expressed in the given  {@link TimeStandard}.  If the date is during a leap second, the 
	{@link JulianDate} will be expressed in  {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI).
	
	
	

	 * @param gregorianDate The  {@link GregorianDate}.
	 * @param standard 
	The time standard in which the <code>gregorianDate</code> is expressed.  
	
	 */
	public JulianDate(GregorianDate gregorianDate, TimeStandard standard) {
		JulianDate converted = gregorianDate.toJulianDate(standard);
		m_day = converted.m_day;
		m_secondsOfDay = converted.m_secondsOfDay;
		m_timeStandard = converted.getStandard();
	}

	/**
	 *  
	Initializes a  {@link JulianDate} from the provided values.  The values will be
	normalized so that the <code>SecondsOfDay</code> ({@link #getSecondsOfDay get}) property is less than the length of a day.
	The time standard will be International Atomic Time (TAI).
	
	
	

	 * @param day The whole number part of the date.
	 * @param secondsOfDay The time of day, expressed as seconds past noon on the given whole-number day.
	 */
	public JulianDate(int day, double secondsOfDay) {
		this(day, secondsOfDay, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
	}

	/**
	 *  
	Initializes a  {@link JulianDate} from the provided values.  The values will be
	normalized so that the <code>SecondsOfDay</code> ({@link #getSecondsOfDay get}) property is less than the length of the day.
	
	
	
	

	 * @param day The whole number part of the date.
	 * @param secondsOfDay The time of day, expressed as seconds past noon on the given whole-number day.
	 * @param timeStandard The time standard to use for this Julian Date.
	 */
	public JulianDate(int day, double secondsOfDay, TimeStandard timeStandard) {
		m_timeStandard = timeStandard;
		m_day = day;
		m_secondsOfDay = secondsOfDay;
		// Normalize so that the number of seconds is >= 0 and < a day.
		if (m_secondsOfDay < 0) {
			int wholeDays = (int) (m_secondsOfDay / TimeConstants.SecondsPerDay) - 1;
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
	Initializes a  {@link JulianDate} from a double expressing the complete astronomical Julian Date.
	The time standard will be  {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME International Atomic Time (TAI)}.
	
	

	 * @param dayCount The complete astronomical Julian date.
	 */
	public JulianDate(double dayCount) {
		this(dayCount, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
	}

	/**
	 *  
	Initializes a  {@link JulianDate} from a double expressing the complete astronomical Julian Date.
	
	
	

	 * @param dayCount The complete Julian date.
	 * @param timeStandard The time standard to use for this Julian Date.
	 */
	public JulianDate(double dayCount, TimeStandard timeStandard) {
		m_timeStandard = timeStandard;
		m_day = (int) dayCount;
		m_secondsOfDay = (dayCount - m_day) * TimeConstants.SecondsPerDay;
	}

	/**
	 *  Gets the smallest value possible of  {@link JulianDate}.
	

	 */
	public static JulianDate getMinValue() {
		return s_minValue;
	}

	/**
	 *  Gets the largest possible value of  {@link JulianDate}.
	

	 */
	public static JulianDate getMaxValue() {
		return s_maxValue;
	}

	/**
	 *  Gets the total number of whole and fractional days represented by this astronomical Julian date.
	

	 */
	public final double getTotalDays() {
		return (double) getDay() + getSecondsOfDay() / TimeConstants.SecondsPerDay;
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
	 *  Gets the  {@link TimeStandard} that this astronomical Julian date is based upon.
	

	 */
	public final TimeStandard getStandard() {
		return m_timeStandard;
	}

	/**
	 *  
	Converts this  {@link JulianDate} to the specified time standard.
	
	
	
	

	 * @param timeStandard The requested time standard.
	 * @return An equivalent  {@link JulianDate} using the requested time
	standard.
	 * @exception ArgumentOutOfRangeException 
	Thrown if the specified  {@link TimeStandard} is is not capable of
	representing this  {@link JulianDate}.
	
	 */
	public final JulianDate toTimeStandard(TimeStandard timeStandard) {
		@CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
		JulianDate result = new JulianDate();
		JulianDate[] out$result_1 = {
			null
		};
		boolean temp_0 = tryConvertTimeStandard(timeStandard, out$result_1);
		result = out$result_1[0];
		if (!temp_0) {
			throw new ArgumentOutOfRangeException(CesiumLocalization.getCannotRepresentLeapSecondAsUTCJulianDate());
		}
		return result;
	}

	/**
	 *  
	Try to convert this  {@link JulianDate} to the specified 
	{@link TimeStandard}, if the specified  {@link TimeStandard} is
	capable of representing this time.
	
	
	
	

	 * @param timeStandard The requested time standard.
	 * @param result 
	On input, an array with one element.  On return, the array is populated with
	
	an equivalent
	{@link JulianDate} using the requested  {@link TimeStandard}, if it
	is capable  of representing this time, otherwise <code>MinValue</code> ({@link JulianDate#getMinValue get}).
	
	 * @return <see langword="true" /> if this date could be converted to the
	requested  {@link TimeStandard}, otherwise false.
	 */
	public final boolean tryConvertTimeStandard(TimeStandard timeStandard, JulianDate[] result) {
		if (timeStandard == m_timeStandard) {
			result[0] = this;
			return true;
		}
		if (timeStandard == TimeStandard.INTERNATIONAL_ATOMIC_TIME && m_timeStandard == TimeStandard.COORDINATED_UNIVERSAL_TIME) {
			result[0] = new JulianDate(getDay(), getSecondsOfDay() + LeapSeconds.getInstance().getTaiMinusUtc(this), timeStandard);
			return true;
		}
		if (timeStandard == TimeStandard.COORDINATED_UNIVERSAL_TIME && m_timeStandard == TimeStandard.INTERNATIONAL_ATOMIC_TIME) {
			return LeapSeconds.getInstance().tryConvertTaiToUtc(this, result);
		}
		result[0] = JulianDate.getMinValue();
		return false;
	}

	/**
	 *  
	Converts this date to  {@link TimeStandard#INTERNATIONAL_ATOMIC_TIME} (TAI).
	
	

	 * @return An equivalent date expressed in TAI.
	 */
	public final JulianDate toInternationalAtomicTime() {
		if (m_timeStandard == TimeStandard.INTERNATIONAL_ATOMIC_TIME) {
			return this;
		}
		return new JulianDate(getDay(), getSecondsOfDay() + LeapSeconds.getInstance().getTaiMinusUtc(this), TimeStandard.INTERNATIONAL_ATOMIC_TIME);
	}

	/**
	 *  
	Computes the number of seconds that have elapsed from this Julian date to the
	<code>other</code> Julian date.
	
	
	
	

	 * 
	This method subtracts the Julian date on which it is called from the <code>other</code>
	Julian date and returns the number of seconds between them.  The computation is done in the time
	standard of this Julian date, or the closest standard that is safe for arithmetic if this
	Julian date's time standard is not safe.  For best performance, this Julian date and the
	<code>other</code> Julian date should have the same time standard and it should be
	safe for arithmetic.
	
	 * @param other The other Julian date, which is the end of the interval.
	 * @return The number of seconds that have elapsed from this Julian date to the other Julian date.
	 */
	public final double secondsDifference(JulianDate other) {
		JulianDate start = toInternationalAtomicTime();
		JulianDate end = other.toInternationalAtomicTime();
		return ((end.getDay() - start.getDay()) * (TimeConstants.SecondsPerDay) + (end.getSecondsOfDay() - start.getSecondsOfDay()));
	}

	/**
	 *  
	Computes the number of minutes that have elapsed from this Julian date to the
	<code>other</code> Julian date.
	
	
	
	

	 * 
	This method subtracts the Julian date on which it is called from the <code>other</code>
	Julian date and returns the number of minutes between them.  The computation is done in the time
	standard of this Julian date, or the closest standard that is safe for arithmetic if this
	Julian date's time standard is not safe.  For best performance, this Julian date and the
	<code>other</code> Julian date should have the same time standard and it should be
	safe for arithmetic.
	
	 * @param other The other Julian date, which is the end of the interval.
	 * @return The number of minutes that have elapsed from this Julian date to the other Julian date.
	 */
	public final double minutesDifference(JulianDate other) {
		JulianDate start = toInternationalAtomicTime();
		JulianDate end = other.toInternationalAtomicTime();
		return ((end.getDay() - start.getDay()) * (TimeConstants.MinutesPerDay) + (end.getSecondsOfDay() - start.getSecondsOfDay()) / (TimeConstants.SecondsPerMinute));
	}

	/**
	 *  
	Computes the number of days that have elapsed from this Julian date to the
	<code>other</code> Julian date.
	
	
	
	

	 * 
	This method subtracts the Julian date on which it is called from the <code>other</code>
	Julian date and returns the number of days between them.  The computation is done in the time
	standard of this Julian date, or the closest standard that is safe for arithmetic if this
	Julian date's time standard is not safe.  For best performance, this Julian date and the
	<code>other</code> Julian date should have the same time standard and it should be
	safe for arithmetic.
	
	 * @param other The other Julian date, which is the end of the interval.
	 * @return The number of days that have elapsed from this Julian date to the other Julian date.
	 */
	public final double daysDifference(JulianDate other) {
		JulianDate start = toInternationalAtomicTime();
		JulianDate end = other.toInternationalAtomicTime();
		return ((end.getDay() - start.getDay()) + (end.getSecondsOfDay() - start.getSecondsOfDay()) / (TimeConstants.SecondsPerDay));
	}

	/**
	 *  
	Adds a  {@link Duration} to this Julian date, producing a new Julian date.
	
	
	

	 * @param duration The duration to add.
	 * @return 
	A new  {@link JulianDate} that is the result of the addition.
	
	 */
	public final JulianDate add(Duration duration) {
		if (m_timeStandard == TimeStandard.COORDINATED_UNIVERSAL_TIME) {
			// Do the addition in the addition time standard
			JulianDate resultInAdditionStandard = toTimeStandard(TimeStandard.INTERNATIONAL_ATOMIC_TIME).addIgnoringTimeStandard(duration);
			//then convert back if possible
			@CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
			JulianDate result = new JulianDate();
			JulianDate[] out$result_3 = {
				null
			};
			boolean temp_2 = resultInAdditionStandard.tryConvertTimeStandard(m_timeStandard, out$result_3);
			result = out$result_3[0];
			if (temp_2) {
				return result;
			}
			//if we couldn't convert back, then use the valid result in the addition standard
			return resultInAdditionStandard;
		}
		// Time standards match up, so do the addition directly.
		return addIgnoringTimeStandard(duration);
	}

	final private JulianDate addIgnoringTimeStandard(Duration duration) {
		int days = getDay() + duration.getDays();
		double seconds = getSecondsOfDay() + duration.getSeconds();
		return new JulianDate(days, seconds, getStandard());
	}

	/**
	 *  
	Subtracts another Julian date from this Julian date.
	
	
	
	

	 * 
	This method subtracts the <code>subtrahend</code> Julian date from this
	Julian date and returns the  {@link Duration} between them.  The computation is done in
	the time standard of the <code>subtrahend</code>, or the closest standard that is safe for
	arithmetic if the subtrahend's time standard is not safe.  For best performance, this Julian date
	and the subtrahend Julian date should have the same time standard and it should be
	safe for arithmetic.
	
	 * @param subtrahend The Julian Date to subtract from this Julian Date.
	 * @return The Duration that is the result of the subtraction.  The time standard will be the same as the time standard of the subtrahend.
	 */
	public final Duration subtract(JulianDate subtrahend) {
		if (getStandard() != TimeStandard.INTERNATIONAL_ATOMIC_TIME && subtrahend.getStandard() != TimeStandard.INTERNATIONAL_ATOMIC_TIME) {
			// Convert both the subtrahend and the minuend to the subtraction time standard.
			return toInternationalAtomicTime().subtractIgnoringTimeStandard(subtrahend.toInternationalAtomicTime(), subtrahend.getStandard());
		} else if (getStandard() != TimeStandard.INTERNATIONAL_ATOMIC_TIME) {
			return toInternationalAtomicTime().subtractIgnoringTimeStandard(subtrahend, subtrahend.getStandard());
		} else if (subtrahend.getStandard() != TimeStandard.INTERNATIONAL_ATOMIC_TIME) {
			return subtractIgnoringTimeStandard(subtrahend.toInternationalAtomicTime(), subtrahend.getStandard());
		} else {
			// Convert the minuend to the subtraction time standard - subtrahend is already in the correct standard.
			// Convert the subtrahend to the subtraction time standard - minuend is already in the correct standard.
			// Time standards match up, so do the subtraction directly.
			return subtractIgnoringTimeStandard(subtrahend, subtrahend.getStandard());
		}
	}

	final private Duration subtractIgnoringTimeStandard(JulianDate value, TimeStandard standard) {
		int days = getDay() - value.getDay();
		double seconds = getSecondsOfDay() - value.getSecondsOfDay();
		return new Duration(days, seconds);
	}

	/**
	 *  
	Subtracts a  {@link Duration} from this Julian date, producing a new
	Julian date.
	
	
	

	 * @param duration The duration to subtract.
	 * @return 
	A new  {@link JulianDate} that is the result of the subtraction.
	
	 */
	public final JulianDate subtract(Duration duration) {
		return add(new Duration(-duration.getDays(), -duration.getSeconds()));
	}

	/**
	 *  
	Adds the specified number of seconds to this date and returns the new date.
	
	
	

	 * @param seconds The number of seconds.
	 * @return The new date.
	 */
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
	public final JulianDate subtractSeconds(double seconds) {
		return subtract(Duration.fromSeconds(seconds));
	}

	/**
	 *  
	Adds the specified number of days to this date and returns the new date.
	
	
	

	 * @param days The number of days.
	 * @return The new date.
	 */
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
	<code>left</code> minus <code>right</code>.  The time standard will
	be the same as the time standard of the subtrahend.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'Duration -(JulianDate,JulianDate)'")
	public static Duration subtract(JulianDate left, JulianDate right) {
		return left.subtract(right);
	}

	/**
	 *  
	Subtracts a  {@link Duration} from a Julian date, yielding a new 
	{@link JulianDate}.
	
	
	
	

	 * @param left The minuend.
	 * @param right The subtrahend.
	 * @return 
	A new Julian Date that is the result of the subtraction; that is, 
	<code>left</code> minus <code>right</code>.
	
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'JulianDate -(JulianDate,Duration)'")
	public static JulianDate subtract(JulianDate left, Duration right) {
		return left.subtract(right);
	}

	/**
	 *  
	Adds a  {@link Duration} to a  {@link JulianDate}, producing a new
	Julian date.
	
	
	
	

	 * @param left The Julian date.
	 * @param right The duration.
	 * @return A new Julian Date that is the result of the addition.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'JulianDate +(JulianDate,Duration)'")
	public static JulianDate add(JulianDate left, Duration right) {
		return left.add(right);
	}

	/**
	 *  
	Returns true if the two dates are exactly equal.  To be considered equal, the <code>Day</code> ({@link #getDay get})
	and <code>SecondsOfDay</code> ({@link #getSecondsOfDay get}) properties must be identical when converted to a common time standard.
	It is highly recommended that you use  {@link #equalsEpsilon} or  {@link #isIdentical}
	instead of this method.
	
	
	
	

	 * @param left The date on the left side.
	 * @param right The date on the right side.
	 * @return <see langword="true" /> if the dates are equal, otherwise <see langword="false" />.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(JulianDate,JulianDate)'")
	public static boolean equals(JulianDate left, JulianDate right) {
		return left.equalsType(right);
	}

	/**
	 *  
	Returns true if the two dates are NOT exactly equal.  To be considered equal, the <code>Day</code> ({@link #getDay get})
	and <code>SecondsOfDay</code> ({@link #getSecondsOfDay get}) properties must be identical when converted to a common time standard.
	It is highly recommended that you use  {@link #equalsEpsilon} or  {@link #isIdentical}
	instead of this method.
	
	
	
	

	 * @param left The date on the left side.
	 * @param right The date on the right side.
	 * @return <see langword="true" /> if the dates are not equal, otherwise <see langword="false" />.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(JulianDate,JulianDate)'")
	public static boolean notEquals(JulianDate left, JulianDate right) {
		return !left.equalsType(right);
	}

	/**
	 *  
	Returns true if <code>left</code> occurs before <code>right</code>.
	
	
	
	

	 * @param left The date on the left side.
	 * @param right The date on the right side.
	 * @return <see langword="true" /> if the <code>left</code> is less than <code>right</code>, otherwise <see langword="false" />.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <(JulianDate,JulianDate)'")
	public static boolean lessThan(JulianDate left, JulianDate right) {
		return left.compareTo(right) < 0;
	}

	/**
	 *  
	Returns true if <code>left</code> occurs after <code>right</code>.
	
	
	
	

	 * @param left The date on the left side.
	 * @param right The date on the right side.
	 * @return <see langword="true" /> if the <code>left</code> is greater than <code>right</code>, otherwise <see langword="false" />.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >(JulianDate,JulianDate)'")
	public static boolean greaterThan(JulianDate left, JulianDate right) {
		return left.compareTo(right) > 0;
	}

	/**
	 *  
	Returns true if <code>left</code> occurs before or at the same time as <code>right</code>.
	
	
	
	

	 * @param left The date on the left side.
	 * @param right The date on the right side.
	 * @return <see langword="true" /> if the <code>left</code> is less than or equal to <code>right</code>, otherwise <see langword="false" />.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <=(JulianDate,JulianDate)'")
	public static boolean lessThanOrEqual(JulianDate left, JulianDate right) {
		return left.compareTo(right) <= 0;
	}

	/**
	 *  
	Returns true if <code>left</code> occurs after or at the same time as <code>right</code>.
	
	
	
	

	 * @param left The date on the left side.
	 * @param right The date on the right side.
	 * @return <see langword="true" /> if the <code>left</code> is greater than or equal to <code>right</code>, otherwise <see langword="false" />.
	 */
	@CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >=(JulianDate,JulianDate)'")
	public static boolean greaterThanOrEqual(JulianDate left, JulianDate right) {
		return left.compareTo(right) >= 0;
	}

	/**
	 *  
	Returns true if this date exactly equals another date.  To be considered equal, the <code>Day</code> ({@link #getDay get})
	and <code>SecondsOfDay</code> ({@link #getSecondsOfDay get}) properties must be identical when converted to a common time standard.
	It is highly recommended that you use  {@link #equalsEpsilon} or  {@link #isIdentical}
	instead of this method.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JulianDate) {
			return equalsType((JulianDate) obj);
		} else {
			return false;
		}
	}

	/**
	 *  
	Returns true if this date exactly equals another date.  To be considered equal, the <code>Day</code> ({@link #getDay get})
	and <code>SecondsOfDay</code> ({@link #getSecondsOfDay get}) properties must be identical when converted to a common time standard.
	It is highly recommended that you use  {@link #equalsEpsilon} or  {@link #isIdentical}
	instead of this method.
	
	
	

	 * @param other The date to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(JulianDate other) {
		return compareTo(other) == 0;
	}

	/**
	 *  
	Returns true if this date is identical to another date.  Unlike  {@link #equalsType(JulianDate)}, this method will
	consider two dates with different time standards to be different even if the dates represent the same
	moment when expressed in the same time standard.
	
	
	

	 * @param other The date to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> is identical to this instance; otherwise, <see langword="false" />.
	 */
	public final boolean isIdentical(JulianDate other) {
		return m_day == other.m_day && m_secondsOfDay == other.m_secondsOfDay && m_timeStandard == other.m_timeStandard;
	}

	/**
	 *  
	Returns true if this date is within <code>epsilon</code> seconds of the
	specified date.  That is, in order for the dates to be considered equal (and for
	this function to return true), the absolute value of the difference between them, in
	seconds, must be less than <code>epsilon</code>.
	
	
	
	

	 * @param other The Julian Date to compare to this date.
	 * @param epsilon The smallest difference between the dates, in seconds, such that they will NOT be considered equal.
	 * @return true if the dates are equal as defined by the epsilon value.
	 */
	public final boolean equalsEpsilon(JulianDate other, double epsilon) {
		return Math.abs(other.secondsDifference(this)) < epsilon;
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return IntHelper.hashCode(getDay()) ^ DoubleHelper.hashCode(getSecondsOfDay()) ^ getStandard().hashCode();
	}

	/**
	 *  
	Returns the value of this  {@link JulianDate} in the standard format.
	
	

	 * @return The string.
	 */
	@Override
	public String toString() {
		return StringHelper.format(CultureInfoHelper.getCurrentCulture(), "{0}:{1} ({2})", getDay(), getSecondsOfDay(), getStandard() == TimeStandard.COORDINATED_UNIVERSAL_TIME ? "UTC" : "TAI");
	}

	/**
	 *  
	Compares this instance with another instance of the same type.
	
	
	

	 * @param other An object to compare with this instance.
	 * @return 
	A value indicating the relative order of the objects being compared.  The return value has these meanings:
	<table border='1'><tr></tr><tr><th></th><th>Value</th><th></th><th>Meaning</th><th></th></tr><tr></tr><tr><td></td><td>Less than zero</td><td></td><td>
	This instance is less than <code>other</code>.
	</td><td></td></tr><tr></tr><tr><td></td><td>Zero</td><td></td><td>
	This instance is equal to <code>other</code>.
	</td><td></td></tr><tr></tr><tr><td></td><td>Greater than zero</td><td></td><td>
	This instance is greater than <code>other</code>.
	</td><td></td></tr><tr></tr></table>
	
	 */
	public final int compareTo(JulianDate other) {
		// If the days aren't even close, don't bother thinking about the time standard.
		int isClose = isClose(other);
		if (isClose != 0) {
			return isClose;
		}
		@CS2JInfo("Initialization of C# struct variable 'self' added by translator.")
		JulianDate self = new JulianDate();
		@CS2JInfo("Initialization of C# struct variable 'otherDate' added by translator.")
		JulianDate otherDate = new JulianDate();
		JulianDate[] out$otherDate_5 = {
			null
		};
		boolean temp_4 = other.tryConvertTimeStandard(getStandard(), out$otherDate_5);
		otherDate = out$otherDate_5[0];
		if (temp_4) {
			self = this;
		} else {
			//if we can't convert the other date to our time standard, then try our ArithmeticSafeStandard
			self = toInternationalAtomicTime();
			otherDate = other.toInternationalAtomicTime();
		}
		if (self.getDay() != otherDate.getDay()) {
			return self.getDay() < otherDate.getDay() ? -1 : 1;
		}
		if (self.getSecondsOfDay() != otherDate.getSecondsOfDay()) {
			return self.getSecondsOfDay() < otherDate.getSecondsOfDay() ? -1 : 1;
		}
		return 0;
	}

	/**
	 *  
	Converts this  {@link JulianDate} to a 
	{@link DateTime} with a default time standard of Coordinated Universal
	Time.
	
	

	 * @return The  {@link DateTime}.
	 */
	public final DateTime toDateTime() {
		return toGregorianDate().toDateTime();
	}

	/**
	 *  
	Converts this  {@link JulianDate} to a 
	{@link DateTime} expressed in the specified time standard.
	
	
	

	 * @param standard The time standard in which to express the returned
	{@link DateTime}.
	 * @return The  {@link DateTime}.
	 */
	public final DateTime toDateTime(TimeStandard standard) {
		return toGregorianDate(standard).toDateTime();
	}

	/**
	 *  
	Converts this  {@link JulianDate} to a  {@link GregorianDate} with a
	default time standard of Coordinated Universal Time.
	
	

	 * @return The  {@link GregorianDate}.
	 */
	public final GregorianDate toGregorianDate() {
		return new GregorianDate(this, TimeStandard.COORDINATED_UNIVERSAL_TIME);
	}

	/**
	 *  
	Converts this  {@link JulianDate} to a  {@link GregorianDate}
	expressed in the specified time standard.
	
	
	

	 * @param standard The time standard in which to express the returned
	{@link GregorianDate}.
	 * @return The  {@link GregorianDate}.
	 */
	public final GregorianDate toGregorianDate(TimeStandard standard) {
		return new GregorianDate(this, standard);
	}

	/**
	 *  
	Returns 0 if this date is anywhere near the specified date such that time
	standard conversions might affect their equality or ordering.  Otherwise
	returns the difference Day - other.Day.  This is helpful for optimizations.
	

	 */
	final private int isClose(JulianDate other) {
		int dayDifference = m_day - other.m_day;
		if (dayDifference > 1 || dayDifference < -1) {
			return (m_day < other.m_day) ? -1 : 1;
		} else {
			return 0;
		}
	}

	//#endregion
	private int m_day;
	private double m_secondsOfDay;
	private TimeStandard m_timeStandard = TimeStandard.getDefault();
	private static JulianDate s_maxValue = new JulianDate(Integer.MAX_VALUE, 0.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
	private static JulianDate s_minValue = new JulianDate(Integer.MIN_VALUE, 0.0, TimeStandard.INTERNATIONAL_ATOMIC_TIME);
}