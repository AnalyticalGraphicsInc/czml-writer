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
 A set of rectilinear 2-dimensional coordinates.
 
 

 * <p>
 The corresponding 3-dimensional coordinates are {@link Cartesian} coordinates.
 
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@CS2JWarning("Unhandled attribute removed: SuppressMessage")
public final class Rectangular implements IEquatable<Rectangular>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public Rectangular() {}

    /**
    *  Gets a set of {@link Rectangular} coordinates with values of zero.
    

    */
    @Nonnull
    public static Rectangular getZero() {
        return s_zero;
    }

    /**
    *  Gets a set of {@link Rectangular} coordinates with values of {@link Double#NaN}.
    
    

    * <p>
    Use {@code IsUndefined} ({@link Rectangular#getIsUndefined get}) to test whether a {@link Rectangular} instance
    is undefined since it will return {@code true} if any of the coordinate values
    are {@link Double#NaN}.
    
    */
    @Nonnull
    public static Rectangular getUndefined() {
        return s_undefined;
    }

    /**
    *  
    Initializes a set of {@link Rectangular} coordinates from the provided values.
    
    
    

    * @param x The linear coordinate along the positive x-axis.
    * @param y The linear coordinate along the positive y-axis.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public Rectangular(double x, double y) {
        m_x = x;
        m_y = y;
    }

    /**
    *  Gets the linear coordinate along the positive x-axis.
    

    */
    public final double getX() {
        return m_x;
    }

    /**
    *  Gets the linear coordinate along the positive y-axis.
    

    */
    public final double getY() {
        return m_y;
    }

    /**
    *  
    Inverts this instance.
    
    

    * @return A set of {@link Rectangular} coordinates that represents the inverse of this instance.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Rectangular invert() {
        return new Rectangular(-m_x, -m_y);
    }

    /**
    *  
    Multiplies this instance by a scalar.
    
    
    

    * @param scalar The multiplier, or value which is to multiply this instance.
    * @return A set of {@link Rectangular} coordinates that represents the result of the multiplication.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Rectangular multiply(double scalar) {
        return new Rectangular(m_x * scalar, m_y * scalar);
    }

    /**
    *  
    Divides this instance by a scalar.
    
    
    

    * @param scalar The divisor, or value which is to divide this instance.
    * @return A set of {@link Rectangular} coordinates that represents the result of the division.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Rectangular divide(double scalar) {
        return new Rectangular(m_x / scalar, m_y / scalar);
    }

    /**
    *  
    Adds the specified set of {@link Rectangular} coordinates to this instance.
    
    
    

    * @param other The addend, or value which is to be added to this instance.
    * @return A set of {@link Rectangular} coordinates that represents the result of the addition.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Rectangular add(@Nonnull Rectangular other) {
        return new Rectangular(m_x + other.m_x, m_y + other.m_y);
    }

    /**
    *  
    Subtracts the specified set of {@link Rectangular} coordinates from this instance.
    
    
    

    * @param other The subtrahend, or value which is to be subtracted from this instance.
    * @return A set of {@link Rectangular} coordinates that represents the result of the subtraction.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Rectangular subtract(@Nonnull Rectangular other) {
        return new Rectangular(m_x - other.m_x, m_y - other.m_y);
    }

    /**
    *  
    Forms the dot product of the specified set of {@link Rectangular} coordinates with this instance.
    
    
    

    * @param other The set of {@link Rectangular} coordinates to dot with this instance.
    * @return A {@code double} that represents the result of the product.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final double dot(@Nonnull Rectangular other) {
        return m_x * other.m_x + m_y * other.m_y;
    }

    /**
    *  
    Multiplies a specified set of {@link Rectangular} coordinates by a scalar.
    
    
    
    

    * @param left The multiplicand, or value which is to be multiplied by {@code right}.
    * @param right The multiplier, or value which is to multiply {@code left}.
    * @return A set of {@link Rectangular} coordinates that represents the result of the multiplication.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular *(Rectangular,System.Double)'")
    @Nonnull
    public static Rectangular multiply(@javax.annotation.Nonnull Rectangular left, double right) {
        return left.multiply(right);
    }

    /**
    *  
    Multiplies a scalar by a specified set of set of {@link Rectangular} coordinates.
    
    
    
    

    * @param left The multiplicand, or value which is to be multiplied by {@code right}.
    * @param right The multiplier, or value which is to multiply {@code left}.
    * @return A set of {@link Rectangular} coordinates that represents the result of the multiplication.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular *(System.Double,Rectangular)'")
    @Nonnull
    public static Rectangular multiply(double left, @javax.annotation.Nonnull Rectangular right) {
        return right.multiply(left);
    }

    /**
    *  
    Divides a specified set of {@link Rectangular} coordinates by a scalar.
    
    
    
    

    * @param left The dividend, or value which is to be divided by {@code right}.
    * @param right The divisor, or value which is to divide {@code left}.
    * @return A set of {@link Rectangular} coordinates that represents the result of the division.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular /(Rectangular,System.Double)'")
    @Nonnull
    public static Rectangular divide(@javax.annotation.Nonnull Rectangular left, double right) {
        return left.divide(right);
    }

    /**
    *  
    Adds a specified set of {@link Rectangular} coordinates to another specified set of {@link Cartesian} coordinates.
    
    
    
    

    * @param left The augend, or value to which {@code right} is to be added.
    * @param right The addend, or value which is to be added to {@code left}.
    * @return A set of {@link Rectangular} coordinates that represents the result of the addition.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular +(Rectangular,Rectangular)'")
    @Nonnull
    public static Rectangular add(@javax.annotation.Nonnull Rectangular left, @javax.annotation.Nonnull Rectangular right) {
        return left.add(right);
    }

    /**
    *  
    Subtracts a specified set of {@link Rectangular} coordinates from another specified set of {@link Rectangular} coordinates.
    
    
    
    

    * @param left The minuend, or value from which {@code right} is to be subtracted.
    * @param right The subtrahend, or value which is to be subtracted from {@code left}.
    * @return A set of {@link Rectangular} coordinates that represents the result of the subtraction.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular -(Rectangular,Rectangular)'")
    @Nonnull
    public static Rectangular subtract(@javax.annotation.Nonnull Rectangular left, @javax.annotation.Nonnull Rectangular right) {
        return left.subtract(right);
    }

    /**
    *  
    Negates the specified set of {@link Rectangular} coordinates, yielding a new set of {@link Rectangular} coordinates.
    
    
    

    * @param coordinates The set of coordinates.
    * @return The result of negating the elements of the original set of {@link Rectangular} coordinates.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Rectangular -(Rectangular)'")
    @Nonnull
    public static Rectangular negate(@javax.annotation.Nonnull Rectangular coordinates) {
        return new Rectangular(-coordinates.m_x, -coordinates.m_y);
    }

    /**
    *  
    Produces a set of {@link Rectangular} coordinates representing this instance which results from rotating
    the original axes used to represent this instance by the provided angle.
    
    
    
    

    * <p>
    This type of rotation is sometimes referred to as an "alias rotation".
    
    * @param angle The angle of rotation.
    * @return A set of {@link Rectangular} coordinates which is the result of the rotation.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Rectangular rotate(double angle) {
        double c = Math.cos(angle);
        double s = Math.sin(angle);
        return new Rectangular(c * m_x - s * m_y, s * m_x + c * m_y);
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Rectangular && equalsType((Rectangular) obj);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull Rectangular other) {
        return m_x == other.m_x && m_y == other.m_y;
    }

    /**
    *  
    Indicates whether each coordinate value of another instance of this type
    is within the required tolerance of the corresponding coordinate value of this instance.
    
    
    
    

    * @param other The set of {@link Rectangular} coordinates to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
    * @return 
    {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise, {@code false}.
    
    */
    public final boolean equalsEpsilon(@Nonnull Rectangular other, double epsilon) {
        return Math.abs(m_x - other.m_x) <= epsilon && Math.abs(m_y - other.m_y) <= epsilon;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Double.hashCode(m_x), Double.hashCode(m_y));
    }

    /**
    *  
    Returns the string representation of the value of this instance.
    
    

    * @return 
    A string that represents the value of this instance in the form
    "X, Y".
    
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}", m_x, m_y);
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Rectangular,Rectangular)'")
    public static boolean equals(@javax.annotation.Nonnull Rectangular left, @javax.annotation.Nonnull Rectangular right) {
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Rectangular,Rectangular)'")
    public static boolean notEquals(@javax.annotation.Nonnull Rectangular left, @javax.annotation.Nonnull Rectangular right) {
        return !left.equalsType(right);
    }

    /**
    *  Gets whether or not any of the coordinates for this instance have the value {@link Double#NaN}.
    

    */
    public final boolean getIsUndefined() {
        return Double.isNaN(m_x) || Double.isNaN(m_y);
    }

    private double m_x;
    private double m_y;
    @Nonnull
    private static Rectangular s_zero = new Rectangular(0.0, 0.0);
    @Nonnull
    private static Rectangular s_undefined = new Rectangular(Double.NaN, Double.NaN);
}