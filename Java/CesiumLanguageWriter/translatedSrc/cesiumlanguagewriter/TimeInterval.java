package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ObjectHelper;
import agi.foundation.compatibility.StringHelper;

/**
 *  
 An interval defined by a start date and a stop date.  The end points are optionally included
 in the interval.
 

 */
@SuppressWarnings("unused")
public final class TimeInterval implements IEquatable<TimeInterval> {
    /**
    *  
    Initializes a new interval with the specified start date and stop date.
    The new interval is closed, meaning that both end points are included.
    
    
    

    * @param start The first date in the interval.
    * @param stop The last date in the interval.
    */
    public TimeInterval(JulianDate start, JulianDate stop) {
        m_start = start;
        m_stop = stop;
    }

    /**
    *  Gets the start date of the interval.
    

    */
    public final JulianDate getStart() {
        return m_start;
    }

    /**
    *  Gets the stop date of the interval.
    

    */
    public final JulianDate getStop() {
        return m_stop;
    }

    /**
    *  Gets a value indicating whether or not the interval is empty.
    

    */
    public final boolean getIsEmpty() {
        return JulianDate.greaterThanOrEqual(m_start, m_stop);
    }

    /**
    *  
    Returns a {@link Duration} representing the span of time between the
    {@code Start} ({@link #getStart get}) and {@code Stop} ({@link #getStop get}) of the interval.
    
    

    * @return The duration.
    */
    public final Duration toDuration() {
        return JulianDate.subtract(m_stop, m_start);
    }

    /**
    *  
    Returns a {@link TimeInterval} equivalent to this one where the time standard
    of the start and end dates has been converted to the specified standard.
    
    
    

    * @param timeStandard The time standard of the new interval.
    * @return An equivalent interval with the new time standard.
    */
    public final TimeInterval toTimeStandard(TimeStandard timeStandard) {
        if (ObjectHelper.referenceEquals(m_start.getStandard(), timeStandard) && ObjectHelper.referenceEquals(m_stop.getStandard(), timeStandard)) {
            return this;
        }
        return new TimeInterval(m_start.toTimeStandard(timeStandard), m_stop.toTimeStandard(timeStandard));
    }

    /**
    *  
    Determines if the interval contains a specified date.
    
    
    

    * @param date The date to test.
    * @return true if the interval contains the date, otherwise false.
    */
    public final boolean contains(JulianDate date) {
        if (getIsEmpty()) {
            return false;
        }
        int startComparedToDate = m_start.compareTo(date);
        int dateComparedToStop = date.compareTo(m_stop);
        // return start < date && date < stop
        return startComparedToDate <= 0 && dateComparedToStop <= 0;
    }

    /**
    *  
    Determines if this time interval is equal to another time interval, using an epsilon to compare
    the {@code Start} ({@link #getStart get}) and {@code Stop} ({@link #getStop get}) properties of the
    two intervals.  The dates are considered equal if they are within {@code epsilon}
    seconds of each other.  All other properties must be identical.
    
    
    
    

    * @param other The time interval to compare to this time interval.
    * @param epsilon The largest difference between the {@code Start} ({@link #getStart get}) and {@code Stop} ({@link #getStop get}) dates, in seconds, such that they will be considered equal.
    * @return true if the {@code Start} ({@link #getStart get}) and {@code Stop} ({@link #getStop get}) dates of the intervals are equal as defined by the epsilon value and all other properties are identical.
    */
    public final boolean equalsEpsilon(TimeInterval other, double epsilon) {
        if (ObjectHelper.referenceEquals(null, other)) {
            return false;
        }
        if (ObjectHelper.referenceEquals(this, other)) {
            return true;
        }
        if (getIsEmpty() && other.getIsEmpty()) {
            return true;
        }
        return m_start.equalsEpsilon(other.m_start, epsilon) && m_stop.equalsEpsilon(other.m_stop, epsilon);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    public final boolean equalsType(TimeInterval other) {
        if (ObjectHelper.referenceEquals(null, other)) {
            return false;
        }
        if (ObjectHelper.referenceEquals(this, other)) {
            return true;
        }
        if (getIsEmpty() && other.getIsEmpty()) {
            return true;
        }
        return m_start.equalsType(other.m_start) && m_stop.equalsType(other.m_stop);
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return equalsType((obj instanceof TimeInterval) ? (TimeInterval) obj : null);
    }

    /**
    *  
    Returns a string with interval in the format "[Start, Stop)".  Square brackets indicate
    that the end point of the interval is included in the intervals.  Parenthesis indicate that the
    end point is not included.
    
    

    * @return The string.
    */
    @Override
    public String toString() {
        return StringHelper.format(CultureInfoHelper.getCurrentCulture(), "[{0}, {1}]", m_start, m_stop);
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return m_start.hashCode() ^ m_stop.hashCode();
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(TimeInterval,TimeInterval)'")
    public static boolean equals(TimeInterval left, TimeInterval right) {
        if (ObjectHelper.referenceEquals(left, null)) {
            return ObjectHelper.referenceEquals(right, null);
        }
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(TimeInterval,TimeInterval)'")
    public static boolean notEquals(TimeInterval left, TimeInterval right) {
        return !(TimeInterval.equals(left, right));
    }

    /**
    *  Gets an empty interval.
    

    */
    public static TimeInterval getEmpty() {
        return s_empty;
    }

    private static TimeInterval s_empty = new TimeInterval(new JulianDate(0.0), new JulianDate(0.0));
    @CS2JInfo("Initialization of C# struct variable 'm_start' added by translator.")
    private JulianDate m_start = new JulianDate();
    @CS2JInfo("Initialization of C# struct variable 'm_stop' added by translator.")
    private JulianDate m_stop = new JulianDate();
}