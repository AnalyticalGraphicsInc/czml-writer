package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.PrimitiveHelper;
import agi.foundation.compatibility.StringHelper;
import javax.annotation.Nonnull;

/**
 *  
 A set of rectilinear 3-dimensional coordinates.
 
 

 * <p>
 The corresponding 2-dimensional coordinates are {@link Rectangular} coordinates.
 
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@CS2JWarning("Unhandled attribute removed: SuppressMessage")
public final class Cartesian implements IEquatable<Cartesian>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public Cartesian() {}

    /**
    *  Gets a set of {@link Cartesian} coordinates with values of zero.
    

    */
    @Nonnull
    public static Cartesian getZero() {
        return s_zero;
    }

    /**
    *  Gets a set of {@link Cartesian} coordinates with values of {@link Double#NaN}.
    
    

    * <p>
    Use {@code IsUndefined} ({@link #getIsUndefined get}) to test whether a {@link Cartesian} instance
    is undefined since it will return {@code true} if any of the coordinate values
    are {@link Double#NaN}.
    
    */
    @Nonnull
    public static Cartesian getUndefined() {
        return s_undefined;
    }

    /**
    *  
    Initializes a set of {@link Cartesian} coordinates from the provided values.
    
    
    
    

    * @param x The linear coordinate along the positive x-axis.
    * @param y The linear coordinate along the positive y-axis.
    * @param z The linear coordinate along the positive z-axis.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public Cartesian(double x, double y, double z) {
        m_x = x;
        m_y = y;
        m_z = z;
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
    *  Gets the linear coordinate along the positive z-axis.
    

    */
    public final double getZ() {
        return m_z;
    }

    /**
    *  
    Multiplies this instance by a scalar.
    
    
    

    * @param scalar The multiplier, or value which is to multiply this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the multiplication.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian multiply(double scalar) {
        return new Cartesian(m_x * scalar, m_y * scalar, m_z * scalar);
    }

    /**
    *  
    Divides this instance by a scalar.
    
    
    

    * @param scalar The divisor, or value which is to divide this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the division.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian divide(double scalar) {
        return new Cartesian(m_x / scalar, m_y / scalar, m_z / scalar);
    }

    /**
    *  
    Adds the specified set of {@link Cartesian} coordinates to this instance.
    
    
    

    * @param other The addend, or value which is to be added to this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the addition.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian add(@Nonnull Cartesian other) {
        return new Cartesian(m_x + other.m_x, m_y + other.m_y, m_z + other.m_z);
    }

    /**
    *  
    Subtracts the specified set of {@link Cartesian} coordinates from this instance.
    
    
    

    * @param other The subtrahend, or value which is to be subtracted from this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the subtraction.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian subtract(@Nonnull Cartesian other) {
        return new Cartesian(m_x - other.m_x, m_y - other.m_y, m_z - other.m_z);
    }

    /**
    *  
    Forms the cross product of the specified set of {@link Cartesian} coordinates with this instance.
    
    
    

    * @param other The set of {@link Cartesian} coordinates to cross with this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the product.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian cross(@Nonnull Cartesian other) {
        return new Cartesian(m_y * other.m_z - m_z * other.m_y, m_z * other.m_x - m_x * other.m_z, m_x * other.m_y - m_y * other.m_x);
    }

    /**
    *  
    Forms the dot product of the specified set of {@link Cartesian} coordinates with this instance.
    
    
    

    * @param other The set of {@link Cartesian} coordinates to dot with this instance.
    * @return A {@code double} that represents the result of the product.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final double dot(@Nonnull Cartesian other) {
        return m_x * other.m_x + m_y * other.m_y + m_z * other.m_z;
    }

    /**
    *  
    Multiplies a specified set of {@link Cartesian} coordinates by a scalar.
    
    
    
    

    * @param left The multiplicand, or value which is to be multiplied by {@code right}.
    * @param right The multiplier, or value which is to multiply {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the multiplication.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian *(Cartesian,System.Double)'")
    @Nonnull
    public static Cartesian multiply(@javax.annotation.Nonnull Cartesian left, double right) {
        return left.multiply(right);
    }

    /**
    *  
    Multiplies a scalar by a specified set of set of {@link Cartesian} coordinates.
    
    
    
    

    * @param left The multiplicand, or value which is to be multiplied by {@code right}.
    * @param right The multiplier, or value which is to multiply {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the multiplication.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian *(System.Double,Cartesian)'")
    @Nonnull
    public static Cartesian multiply(double left, @javax.annotation.Nonnull Cartesian right) {
        return right.multiply(left);
    }

    /**
    *  
    Divides a specified set of {@link Cartesian} coordinates by a scalar.
    
    
    
    

    * @param left The dividend, or value which is to be divided by {@code right}.
    * @param right The divisor, or value which is to divide {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the division.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian /(Cartesian,System.Double)'")
    @Nonnull
    public static Cartesian divide(@javax.annotation.Nonnull Cartesian left, double right) {
        return left.divide(right);
    }

    /**
    *  
    Adds a specified set of {@link Cartesian} coordinates to another specified set of {@link Cartesian} coordinates.
    
    
    
    

    * @param left The augend, or value to which {@code right} is to be added.
    * @param right The addend, or value which is to be added to {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the addition.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian +(Cartesian,Cartesian)'")
    @Nonnull
    public static Cartesian add(@javax.annotation.Nonnull Cartesian left, @javax.annotation.Nonnull Cartesian right) {
        return left.add(right);
    }

    /**
    *  
    Subtracts a specified set of {@link Cartesian} coordinates from another specified set of {@link Cartesian} coordinates.
    
    
    
    

    * @param left The minuend, or value from which {@code right} is to be subtracted.
    * @param right The subtrahend, or value which is to be subtracted from {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the subtraction.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian -(Cartesian,Cartesian)'")
    @Nonnull
    public static Cartesian subtract(@javax.annotation.Nonnull Cartesian left, @javax.annotation.Nonnull Cartesian right) {
        return left.subtract(right);
    }

    /**
    *  
    Negates the specified set of {@link Cartesian} coordinates, yielding a new set of {@link Cartesian} coordinates.
    
    
    

    * @param coordinates The set of coordinates.
    * @return The result of negating the elements of the original set of {@link Cartesian} coordinates.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian -(Cartesian)'")
    @Nonnull
    public static Cartesian negate(@javax.annotation.Nonnull Cartesian coordinates) {
        return new Cartesian(-coordinates.m_x, -coordinates.m_y, -coordinates.m_z);
    }

    /**
    *  
    Produces a set of {@link Cartesian} coordinates representing this instance which results from rotating
    the original axes used to represent this instance by the provided {@link Matrix3By3} rotation.
    This type of rotation is sometimes referred to as an "alias rotation".
    
    
    

    * @param rotation The {@link Matrix3By3} rotation.
    * @return A set of {@link Cartesian} coordinates which is the result of the rotation.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian rotate(@Nonnull Matrix3By3 rotation) {
        return new Cartesian(rotation.getM11() * m_x + rotation.getM12() * m_y + rotation.getM13() * m_z, rotation.getM21() * m_x + rotation.getM22() * m_y + rotation.getM23() * m_z, rotation
                .getM31()
                * m_x + rotation.getM32() * m_y + rotation.getM33() * m_z);
    }

    /**
    *  
    Produces a set of {@link Cartesian} coordinates representing this instance which results from rotating
    the original axes used to represent this instance by the provided {@link UnitQuaternion} rotation.
    This type of rotation is sometimes referred to as an "alias rotation".
    
    
    

    * @param rotation The {@link UnitQuaternion} rotation.
    * @return A set of {@link Cartesian} coordinates which is the result of the rotation.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian rotate(@Nonnull UnitQuaternion rotation) {
        double w = rotation.getW();
        double difference = w * w - rotation.getX() * rotation.getX() - rotation.getY() * rotation.getY() - rotation.getZ() * rotation.getZ();
        double dot = m_x * rotation.getX() + m_y * rotation.getY() + m_z * rotation.getZ();
        return new Cartesian(difference * m_x + 2.0 * (w * (m_y * rotation.getZ() - m_z * rotation.getY()) + dot * rotation.getX()), difference * m_y + 2.0
                * (w * (m_z * rotation.getX() - m_x * rotation.getZ()) + dot * rotation.getY()), difference * m_z + 2.0 * (w * (m_x * rotation.getY() - m_y * rotation.getX()) + dot * rotation.getZ()));
    }

    /**
    *  Gets the axis which is most orthogonal to this instance.
    

    */
    @Nonnull
    public final UnitCartesian getMostOrthogonalAxis() {
        double x = Math.abs(m_x);
        double y = Math.abs(m_y);
        double z = Math.abs(m_z);
        if (x <= y) {
            return x <= z ? UnitCartesian.getUnitX() : UnitCartesian.getUnitZ();
        } else {
            return y <= z ? UnitCartesian.getUnitY() : UnitCartesian.getUnitZ();
        }
    }

    /**
    *  Gets whether or not any of the coordinates for this instance have the value {@link Double#NaN}.
    

    */
    public final boolean getIsUndefined() {
        return Double.isNaN(m_x) || Double.isNaN(m_y) || Double.isNaN(m_z);
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Cartesian && equalsType((Cartesian) obj);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull Cartesian other) {
        return m_x == other.m_x && m_y == other.m_y && m_z == other.m_z;
    }

    /**
    *  
    Indicates whether each coordinate value of another instance of this type
    is within the required tolerance of the corresponding coordinate value of this instance.
    
    
    
    

    * @param other The set of {@link Cartesian} coordinates to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
    * @return 
    {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise, {@code false}.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(@Nonnull Cartesian other, double epsilon) {
        return Math.abs(m_x - other.m_x) <= epsilon && Math.abs(m_y - other.m_y) <= epsilon && Math.abs(m_z - other.m_z) <= epsilon;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(PrimitiveHelper.hashCode(m_x), PrimitiveHelper.hashCode(m_y), PrimitiveHelper.hashCode(m_z));
    }

    /**
    *  
    Returns the string representation of the value of this instance.
    
    

    * @return 
    A string that represents the value of this instance in the form
    "X, Y, Z".
    
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}, {2}", m_x, m_y, m_z);
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Cartesian,Cartesian)'")
    public static boolean equals(@javax.annotation.Nonnull Cartesian left, @javax.annotation.Nonnull Cartesian right) {
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Cartesian,Cartesian)'")
    public static boolean notEquals(@javax.annotation.Nonnull Cartesian left, @javax.annotation.Nonnull Cartesian right) {
        return !left.equalsType(right);
    }

    /**
    *  Gets the magnitude of this instance.
    

    */
    public final double getMagnitude() {
        return Math.sqrt(getMagnitudeSquared());
    }

    /**
    *  Gets the square of the {@code Magnitude} ({@link #getMagnitude get}) of this instance.
    

    */
    public final double getMagnitudeSquared() {
        return m_x * m_x + m_y * m_y + m_z * m_z;
    }

    /**
    *  
    Forms a set of {@link UnitCartesian} coordinates from this instance.
    
    
    
    
    

    * <p>
    The normalization of the cartesian components is accomplished in the usual way.
    It should be noted that this does not guarantee a result whose magnitude will be 1.0 in cases where an individual component underflows upon squaring.
    
    * @return The resulting set of {@link UnitCartesian} coordinates.
    * @exception ArithmeticException 
    The magnitude of the provided coordinates must not be zero.
    
    * @exception ArithmeticException 
    The magnitude of the provided coordinates must not be infinite.
    
    */
    @Nonnull
    public final UnitCartesian normalize() {
        double magnitude = 0D;
        final double[] out$magnitude$1 = {
            0D
        };
        final UnitCartesian temp$0 = normalize(out$magnitude$1);
        magnitude = out$magnitude$1[0];
        return temp$0;
    }

    /**
    *  
    Forms a set of {@link UnitCartesian} coordinates from this instance
    and returns the {@code Magnitude} ({@link #getMagnitude get}) of the original instance in the provided parameter.
    
    
    
    
    
    

    * <p>
    The normalization of the cartesian components is accomplished in the usual way.
    It should be noted that this does not guarantee a result whose magnitude will be 1.0 in cases where an individual component underflows upon squaring.
    
    * @param magnitude 
    On input, an array with one element.  On return, the array is populated with
    
    the magnitude of the original set of {@link Cartesian} coordinates.
    
    * @return The resulting set of {@link UnitCartesian} coordinates.
    * @exception ArithmeticException 
    The magnitude of the provided coordinates must not be zero.
    
    * @exception ArithmeticException 
    The magnitude of the provided coordinates must not be infinite.
    
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    @Nonnull
    public final UnitCartesian normalize(@Nonnull double[] magnitude) {
        return new UnitCartesian(m_x, m_y, m_z, magnitude);
    }

    /**
    *  
    Converts a set of {@link UnitCartesian} coordinates to a set of {@link Cartesian} coordinates.
    
    
    

    * @param coordinates The set of {@link UnitCartesian} coordinates.
    * @return The resulting set of {@link Cartesian} coordinates.
    */
    @CS2JInfo("This method implements the functionality of the implicit conversion operation 'Cartesian <= UnitCartesian'")
    @Nonnull
    public static Cartesian toCartesian(@javax.annotation.Nonnull UnitCartesian coordinates) {
        return new Cartesian(coordinates.getX(), coordinates.getY(), coordinates.getZ());
    }

    private double m_x;
    private double m_y;
    private double m_z;
    @Nonnull
    private static Cartesian s_zero = new Cartesian(0.0, 0.0, 0.0);
    @Nonnull
    private static Cartesian s_undefined = new Cartesian(Double.NaN, Double.NaN, Double.NaN);
}