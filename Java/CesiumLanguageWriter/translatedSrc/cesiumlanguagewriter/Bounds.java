package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.PrimitiveHelper;
import agi.foundation.compatibility.StringHelper;

/**
 *  
 Holds two values which form the bounds of a range of real numbers.
 

 */
@SuppressWarnings("unused")
public final class Bounds implements IEquatable<Bounds>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public Bounds() {}

    /**
    *  
    Holds the values which form the bounds of a range of real numbers.
    
    
    
    

    * @param lowerBound The minimal value defining the range or numbers.
    * @param upperBound The maximal value defining the range or numbers.
    * @exception ArgumentNullException 
    Thrown when the {@code upperBound} is less than the {@code lowerBound}.
    
    */
    public Bounds(double lowerBound, double upperBound) {
        if (upperBound < lowerBound) {
            throw new ArgumentException(CesiumLocalization.getUpperBoundCannotBeLessThanLowerBound());
        }
        m_lowerBound = lowerBound;
        m_upperBound = upperBound;
    }

    /**
    *  Gets a set of {@link Bounds} representing the full range of real values from negative infinity to positive infinity.
    
    

    * <p>
    Use {@code IsUnbounded} ({@link #getIsUnbounded get}) to test whether a {@link Bounds} instance is unbounded
    since it will return {@code true} if the values range from {@link Double#NEGATIVE_INFINITY} to {@link Double#POSITIVE_INFINITY}.
    
    */
    public static Bounds getUnbounded() {
        return s_unbounded;
    }

    /**
    *  Gets the minimal value defining the range of numbers.
    

    */
    public final double getLowerBound() {
        return m_lowerBound;
    }

    /**
    *  Gets the maximal value defining the range of numbers.
    

    */
    public final double getUpperBound() {
        return m_upperBound;
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Bounds && equalsType((Bounds) obj);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(Bounds other) {
        return m_lowerBound == other.m_lowerBound && m_upperBound == other.m_upperBound;
    }

    /**
    *  
    Indicates whether each value of another instance of this type
    is within the required tolerance of the corresponding value of this instance.
    
    
    
    

    * @param other The set of {@link Bounds} to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the values will not be considered equal.
    * @return 
    {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise, {@code false}.
    
    */
    public final boolean equalsEpsilon(Bounds other, double epsilon) {
        return Math.abs(m_lowerBound - other.m_lowerBound) <= epsilon && Math.abs(m_upperBound - other.m_upperBound) <= epsilon;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(PrimitiveHelper.hashCode(m_lowerBound), PrimitiveHelper.hashCode(m_upperBound));
    }

    /**
    *  
    Returns the string representation of the value of this instance.
    
    

    * @return 
    A string that represents the values of this instance in the form
    "LowerBound, UpperBound".
    
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}", m_lowerBound, m_upperBound);
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Bounds,Bounds)'")
    public static boolean equals(Bounds left, Bounds right) {
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Bounds,Bounds)'")
    public static boolean notEquals(Bounds left, Bounds right) {
        return !left.equalsType(right);
    }

    /**
    *  Gets whether or not this instance has a finite value as either the lower or upper bound.
    

    */
    public final boolean getIsFinite() {
        return !DoubleHelper.isNegativeInfinity(m_lowerBound) && !DoubleHelper.isPositiveInfinity(m_upperBound);
    }

    /**
    *  Gets whether or not this instance ranges from {@link Double#NEGATIVE_INFINITY} to {@link Double#POSITIVE_INFINITY}.
    

    */
    public final boolean getIsUnbounded() {
        return DoubleHelper.isNegativeInfinity(m_lowerBound) && DoubleHelper.isPositiveInfinity(m_upperBound);
    }

    private static Bounds s_unbounded = new Bounds(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    private double m_lowerBound;
    private double m_upperBound;
}