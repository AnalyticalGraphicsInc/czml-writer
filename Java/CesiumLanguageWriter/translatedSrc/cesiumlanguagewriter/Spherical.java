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
 A set of curvilinear 3-dimensional coordinates.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class Spherical implements IEquatable<Spherical>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public Spherical() {}

    /**
    *  Gets a set of {@link Spherical} coordinates with values of zero.
    

    */
    @Nonnull
    public static Spherical getZero() {
        return s_zero;
    }

    /**
    *  
    Initializes a set of {@link Spherical} coordinates from the provided clock angle, cone angle, and magnitude.
    
    
    
    

    * @param clock The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
    * @param cone The angular coordinate measured from the positive z-axis and toward the negative z-axis.
    * @param magnitude The linear coordinate measured from the origin.
    */
    public Spherical(double clock, double cone, double magnitude) {
        m_clock = clock;
        m_cone = cone;
        m_magnitude = magnitude;
    }

    /**
    *  
    Initializes a set of {@link Spherical} coordinates from the provided set of {@link Cartesian} coordinates.
    
    
    

    * <p>
    The radius and magnitude for spherical coordinates are computed using the standard methods. Note that if a component of the cartesian components underflows upon squaring the
    resulting spherical coordinates may not be correct.
    
    * @param coordinates The set of Cartesian coordinates.
    */
    public Spherical(@Nonnull Cartesian coordinates) {
        double x = coordinates.getX();
        double y = coordinates.getY();
        double z = coordinates.getZ();
        double radialSquared = x * x + y * y;
        m_clock = Math.atan2(y, x);
        m_cone = Math.atan2(Math.sqrt(radialSquared), z);
        m_magnitude = Math.sqrt(radialSquared + z * z);
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
    *  Gets the linear coordinate measured from the origin.
    

    */
    public final double getMagnitude() {
        return m_magnitude;
    }

    /**
    *  
    Forms a set of {@link UnitSpherical} coordinates from this instance.
    
    

    * @return The resulting set of {@link UnitSpherical} coordinates.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final UnitSpherical normalize() {
        return new UnitSpherical(this);
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Spherical && equalsType((Spherical) obj);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull Spherical other) {
        return m_clock == other.m_clock && m_cone == other.m_cone && m_magnitude == other.m_magnitude;
    }

    /**
    *  
    Indicates whether each coordinate value of another instance of this type
    is within the required tolerance of the corresponding coordinate value of this instance.
    
    
    
    

    * @param other The set of {@link Spherical} coordinates to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
    * @return 
    {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise, {@code false}.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(@Nonnull Spherical other, double epsilon) {
        return Math.abs(m_clock - other.m_clock) <= epsilon && Math.abs(m_cone - other.m_cone) <= epsilon && Math.abs(m_magnitude - other.m_magnitude) <= epsilon;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Double.hashCode(m_clock), Double.hashCode(m_cone), Double.hashCode(m_magnitude));
    }

    /**
    *  
    Returns the string representation of the value of this instance.
    
    

    * @return 
    A string that represents the value of this instance in the form
    Clock, Cone, and Magnitude.
    
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}, {2}", m_clock, m_cone, m_magnitude);
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Spherical,Spherical)'")
    public static boolean equals(@Nonnull Spherical left, @Nonnull Spherical right) {
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Spherical,Spherical)'")
    public static boolean notEquals(@Nonnull Spherical left, @Nonnull Spherical right) {
        return !left.equalsType(right);
    }

    private double m_clock;
    private double m_cone;
    private double m_magnitude;
    @Nonnull
    private static Spherical s_zero = new Spherical(0.0, 0.0, 0.0);
}