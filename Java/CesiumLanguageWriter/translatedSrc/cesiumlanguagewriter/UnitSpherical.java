package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import javax.annotation.Nonnull;

/**
 *  
 A set of curvilinear 3-dimensional coordinates with unit magnitude.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class UnitSpherical implements IEquatable<UnitSpherical>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public UnitSpherical() {}

    /**
    *  
    Initializes a set of {@link UnitSpherical} coordinates from the provided clock angle and cone angle.
    
    
    

    * @param clock The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
    * @param cone The angular coordinate measured from the positive z-axis and toward the negative z-axis.
    */
    public UnitSpherical(double clock, double cone) {
        m_clock = clock;
        m_cone = cone;
    }

    /**
    *  
    Initializes a set of {@link UnitSpherical} coordinates from the provided set of {@link UnitCartesian} coordinates.
    
    

    * @param coordinates The set of {@link UnitCartesian} coordinates.
    */
    public UnitSpherical(@Nonnull UnitCartesian coordinates) {
        double x = coordinates.getX();
        double y = coordinates.getY();
        double z = coordinates.getZ();
        double radialSquared = x * x + y * y;
        m_clock = Math.atan2(y, x);
        m_cone = Math.atan2(Math.sqrt(radialSquared), z);
    }

    /**
    *  
    Initializes a set of {@link UnitSpherical} coordinates from the provided set of
    {@link Spherical} coordinates.
    
    

    * @param coordinates The set of Spherical coordinates.
    */
    public UnitSpherical(@Nonnull Spherical coordinates) {
        m_clock = coordinates.getClock();
        m_cone = coordinates.getCone();
    }

    /**
    *  Gets the angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
    

    */
    public final double getClock() {
        return m_clock;
    }

    /**
    *  Gets the angular coordinate measured from the positive z-axis and toward the negative z-axis.
    

    */
    public final double getCone() {
        return m_cone;
    }

    /**
    *  Gets the linear coordinate measured from the origin.  The value of this property is always 1.0.
    

    */
    public final double getMagnitude() {
        return 1.0;
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnitSpherical && equalsType((UnitSpherical) obj);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull UnitSpherical other) {
        return m_clock == other.m_clock && m_cone == other.m_cone;
    }

    /**
    *  
    Indicates whether each coordinate value of another instance of this type
    is within the required tolerance of the corresponding coordinate value of this instance.
    
    
    
    

    * @param other The set of {@link UnitSpherical} coordinates to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
    * @return 
    {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise, {@code false}.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(@Nonnull UnitSpherical other, double epsilon) {
        return Math.abs(m_clock - other.m_clock) <= epsilon && Math.abs(m_cone - other.m_cone) <= epsilon;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Double.hashCode(m_clock), Double.hashCode(m_cone));
    }

    /**
    *  
    Returns the string representation of the value of this instance.
    
    

    * @return 
    A string that represents the value of this instance in the form
    Clock, Cone.
    
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}", m_clock, m_cone);
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(UnitSpherical,UnitSpherical)'")
    public static boolean equals(@Nonnull UnitSpherical left, @Nonnull UnitSpherical right) {
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(UnitSpherical,UnitSpherical)'")
    public static boolean notEquals(@Nonnull UnitSpherical left, @Nonnull UnitSpherical right) {
        return !left.equalsType(right);
    }

    private double m_clock;
    private double m_cone;
}