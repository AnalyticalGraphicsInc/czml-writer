package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.Enumeration;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import cesiumlanguagewriter.Cartesian;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A set of rectilinear 3-dimensional coordinates with unit magnitude.
 * <p>
 <p>
 The normalization of the cartesian components is accomplished in the usual way.
 It should be noted that this does not guarantee a result whose magnitude will be 1.0 in cases where an individual component underflows upon squaring.
 </p>
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class UnitCartesian implements IEquatable<UnitCartesian>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public UnitCartesian() {}

    /**
    * Initializes a set of {@link UnitCartesian} coordinates from the provided values.
    * @param x The linear coordinate along the positive x-axis.
    * @param y The linear coordinate along the positive y-axis.
    * @param z The linear coordinate along the positive z-axis.
    * @exception ArithmeticException The magnitude of the provided coordinates must not be zero.
    * @exception ArithmeticException The magnitude of the provided coordinates must not be infinite.
    */
    public UnitCartesian(double x, double y, double z) {
        this(x, y, z, Normalization.UNNORMALIZED);
    }

    /**
    * Initializes a set of {@link UnitCartesian} coordinates from the provided values.
    * @param x The linear coordinate along the positive x-axis.
    * @param y The linear coordinate along the positive y-axis.
    * @param z The linear coordinate along the positive z-axis.
    * @param magnitude On input, an array with one element.  On return, the array is populated with
    
    the magnitude of the original set of coordinates.
    * @exception ArithmeticException The magnitude of the provided coordinates must not be zero.
    * @exception ArithmeticException The magnitude of the provided coordinates must not be infinite.
    */
    public UnitCartesian(double x, double y, double z, @Nonnull double[] magnitude) {
        final double[] ref$x$0 = {
            x
        };
        final double[] ref$y$1 = {
            y
        };
        final double[] ref$z$2 = {
            z
        };
        normalizeCoordinates(ref$x$0, ref$y$1, ref$z$2, magnitude);
        z = ref$z$2[0];
        y = ref$y$1[0];
        x = ref$x$0[0];
        m_x = x;
        m_y = y;
        m_z = z;
    }

    /**
    * Initializes a set of {@link UnitCartesian} coordinates from the provided set of {@link Cartesian} coordinates.
    * @param coordinates The set of {@link Cartesian} coordinates.
    * @exception ArithmeticException The magnitude of the provided coordinates must not be zero.
    * @exception ArithmeticException The magnitude of the provided coordinates must not be infinite.
    */
    public UnitCartesian(@Nonnull Cartesian coordinates) {
        this(coordinates.getX(), coordinates.getY(), coordinates.getZ(), Normalization.UNNORMALIZED);
    }

    /**
    * Initializes a set of {@link UnitCartesian} coordinates from the provided set of {@link Cartesian} coordinates.
    * @param coordinates The set of {@link Cartesian} coordinates.
    * @param magnitude On input, an array with one element.  On return, the array is populated with
    
    the magnitude of the original set of coordinates.
    * @exception ArithmeticException The magnitude of the provided coordinates must not be zero.
    * @exception ArithmeticException The magnitude of the provided coordinates must not be infinite.
    */
    public UnitCartesian(@Nonnull Cartesian coordinates, @Nonnull double[] magnitude) {
        this(coordinates.getX(), coordinates.getY(), coordinates.getZ(), magnitude);
    }

    /**
    * Initializes a set of {@link UnitCartesian} coordinates from the provided spherical coordinates.
    * @param clock The angular coordinate lying in the xy-plane measured from the positive x-axis and toward the positive y-axis.
    * @param cone The angular coordinate measured from the positive z-axis and toward the negative z-axis.
    */
    public UnitCartesian(double clock, double cone) {
        double s = Math.sin(cone);
        m_x = s * Math.cos(clock);
        m_y = s * Math.sin(clock);
        m_z = Math.cos(cone);
    }

    /**
    * Initializes a set of {@link UnitCartesian} coordinates from the provided set of
    {@link UnitSpherical} coordinates.
    * @param unitSpherical The set of {@link UnitSpherical} coordinates.
    */
    public UnitCartesian(@Nonnull UnitSpherical unitSpherical) {
        this(unitSpherical.getClock(), unitSpherical.getCone());
    }

    private UnitCartesian(double x, double y, double z, @Nonnull Normalization normalization) {
        if (normalization != Normalization.NORMALIZED) {
            double magnitude = 0D;
            final double[] ref$x$3 = {
                x
            };
            final double[] ref$y$4 = {
                y
            };
            final double[] ref$z$5 = {
                z
            };
            final double[] out$magnitude$6 = {
                0D
            };
            normalizeCoordinates(ref$x$3, ref$y$4, ref$z$5, out$magnitude$6);
            magnitude = out$magnitude$6[0];
            z = ref$z$5[0];
            y = ref$y$4[0];
            x = ref$x$3[0];
        }
        m_x = x;
        m_y = y;
        m_z = z;
    }

    /**
    * Gets a set of {@link UnitCartesian} coordinates with values of {@link Double#NaN}.
    * <p>
    Use {@code IsUndefined} ({@link #getIsUndefined get}) to test whether a {@link UnitCartesian} instance
    is undefined since it will return {@code true} if any of the coordinate values
    are {@link Double#NaN}.
    */
    @Nonnull
    public static UnitCartesian getUndefined() {
        return s_undefined;
    }

    /**
    * Gets a set of {@link UnitCartesian} coordinates representing the x-axis.
    */
    @Nonnull
    public static UnitCartesian getUnitX() {
        return s_x;
    }

    /**
    * Gets a set of {@link UnitCartesian} coordinates representing the y-axis.
    */
    @Nonnull
    public static UnitCartesian getUnitY() {
        return s_y;
    }

    /**
    * Gets a set of {@link UnitCartesian} coordinates representing the z-axis.
    */
    @Nonnull
    public static UnitCartesian getUnitZ() {
        return s_z;
    }

    /**
    * Gets the linear coordinate along the positive x-axis.
    */
    public final double getX() {
        return m_x;
    }

    /**
    * Gets the linear coordinate along the positive y-axis.
    */
    public final double getY() {
        return m_y;
    }

    /**
    * Gets the linear coordinate along the positive z-axis.
    */
    public final double getZ() {
        return m_z;
    }

    /**
    * Inverts this instance.
    * @return A set of {@link UnitCartesian} coordinates that represents the inverse of this instance.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final UnitCartesian invert() {
        return new UnitCartesian(-m_x, -m_y, -m_z, Normalization.NORMALIZED);
    }

    /**
    * Multiplies this instance by a scalar.
    * @param scalar The multiplier, or value by which to multiply this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the multiplication.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian multiply(double scalar) {
        return new Cartesian(m_x * scalar, m_y * scalar, m_z * scalar);
    }

    /**
    * Divides this instance by a scalar.
    * @param scalar The divisor, or value by which to divide this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the division.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian divide(double scalar) {
        return new Cartesian(m_x / scalar, m_y / scalar, m_z / scalar);
    }

    /**
    * Adds the specified set of {@link Cartesian} coordinates to this instance.
    * @param other The addend, or value which is to be added to this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the addition.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian add(@Nonnull Cartesian other) {
        return new Cartesian(m_x + other.getX(), m_y + other.getY(), m_z + other.getZ());
    }

    /**
    * Adds the specified set of {@link UnitCartesian} coordinates to this instance.
    * @param other The addend, or value which is to be added to this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the addition.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian add(@Nonnull UnitCartesian other) {
        return new Cartesian(m_x + other.m_x, m_y + other.m_y, m_z + other.m_z);
    }

    /**
    * Subtracts the specified set of {@link Cartesian} coordinates from this instance.
    * @param other The subtrahend, or value which is to be subtracted from this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the subtraction.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian subtract(@Nonnull Cartesian other) {
        return new Cartesian(m_x - other.getX(), m_y - other.getY(), m_z - other.getZ());
    }

    /**
    * Subtracts the specified set of {@link UnitCartesian} coordinates from this instance.
    * @param other The subtrahend, or value which is to be subtracted from this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the subtraction.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian subtract(@Nonnull UnitCartesian other) {
        return new Cartesian(m_x - other.m_x, m_y - other.m_y, m_z - other.m_z);
    }

    /**
    * Forms the cross product of the specified set of {@link Cartesian} coordinates with this instance.
    * @param other The set of {@link Cartesian} coordinates to cross with this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the product.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian cross(@Nonnull Cartesian other) {
        return new Cartesian(m_y * other.getZ() - m_z * other.getY(), m_z * other.getX() - m_x * other.getZ(), m_x * other.getY() - m_y * other.getX());
    }

    /**
    * Forms the cross product of the specified set of {@link UnitCartesian} coordinates with this instance.
    * @param other The set of {@link Cartesian} coordinates to cross with this instance.
    * @return A set of {@link Cartesian} coordinates that represents the result of the product.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final Cartesian cross(@Nonnull UnitCartesian other) {
        return new Cartesian(m_y * other.m_z - m_z * other.m_y, m_z * other.m_x - m_x * other.m_z, m_x * other.m_y - m_y * other.m_x);
    }

    /**
    * Forms the dot product of the specified set of {@link Cartesian} coordinates with this instance.
    * @param other The set of {@link Cartesian} coordinates to dot with this instance.
    * @return A {@code double} that represents the result of the product.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final double dot(@Nonnull Cartesian other) {
        return m_x * other.getX() + m_y * other.getY() + m_z * other.getZ();
    }

    /**
    * Forms the dot product of the specified set of {@link UnitCartesian} coordinates with this instance.
    * @param other The set of {@link Cartesian} coordinates to dot with this instance.
    * @return A {@code double} that represents the result of the product.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final double dot(@Nonnull UnitCartesian other) {
        return m_x * other.m_x + m_y * other.m_y + m_z * other.m_z;
    }

    /**
    * Multiplies a specified set of {@link UnitCartesian} coordinates by a scalar.
    * @param left The multiplicand, or value which is to be multiplied by {@code right}.
    * @param right The multiplier, or value which is to multiply {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the multiplication.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian *(UnitCartesian,System.Double)'")
    @Nonnull
    public static Cartesian multiply(@Nonnull UnitCartesian left, double right) {
        return left.multiply(right);
    }

    /**
    * Multiplies a scalar by a specified set of {@link UnitCartesian} coordinates.
    * @param left The multiplicand, or value to be multiplied by {@code right}.
    * @param right The multiplier, or value which by which {@code left} is to be multiplied.
    * @return A set of {@link Cartesian} coordinates that represents the result of the multiplication.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian *(System.Double,UnitCartesian)'")
    @Nonnull
    public static Cartesian multiply(double left, @Nonnull UnitCartesian right) {
        return right.multiply(left);
    }

    /**
    * Divides a specified set of {@link UnitCartesian} coordinates by a scalar.
    * @param left The dividend, or value to be divided by {@code right}.
    * @param right The divisor, or value by which {@code left} is to be divided.
    * @return A set of {@link Cartesian} coordinates that represents the result of the division.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian /(UnitCartesian,System.Double)'")
    @Nonnull
    public static Cartesian divide(@Nonnull UnitCartesian left, double right) {
        return left.divide(right);
    }

    /**
    * Adds a specified set of {@link UnitCartesian} coordinates to another specified set of {@link UnitCartesian} coordinates.
    * @param left The augend, or value to which {@code right} is to be added.
    * @param right The addend, or value which is to be added to {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the addition.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian +(UnitCartesian,UnitCartesian)'")
    @Nonnull
    public static Cartesian add(@Nonnull UnitCartesian left, @Nonnull UnitCartesian right) {
        return left.add(Cartesian.toCartesian(right));
    }

    /**
    * Adds a specified set of {@link Cartesian} coordinates to a specified set of {@link UnitCartesian} coordinates.
    * @param left The augend, or value to which {@code right} is to be added.
    * @param right The addend, or value which is to be added to {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the addition.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian +(UnitCartesian,Cartesian)'")
    @Nonnull
    public static Cartesian add(@Nonnull UnitCartesian left, @Nonnull Cartesian right) {
        return left.add(right);
    }

    /**
    * Adds a specified set of {@link UnitCartesian} coordinates to a specified set of {@link Cartesian} coordinates.
    * @param left The augend, or value to which {@code right} is to be added.
    * @param right The addend, or value which is to be added to {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the addition.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian +(Cartesian,UnitCartesian)'")
    @Nonnull
    public static Cartesian add(@Nonnull Cartesian left, @Nonnull UnitCartesian right) {
        return right.add(left);
    }

    /**
    * Subtracts a specified set of {@link UnitCartesian} coordinates from another specified set of {@link UnitCartesian} coordinates.
    * @param left The minuend, or value from which {@code right} is to be subtracted.
    * @param right The subtrahend, or value which is to be subtracted from {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the subtraction.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian -(UnitCartesian,UnitCartesian)'")
    @Nonnull
    public static Cartesian subtract(@Nonnull UnitCartesian left, @Nonnull UnitCartesian right) {
        return left.subtract(Cartesian.toCartesian(right));
    }

    /**
    * Subtracts a specified set of {@link Cartesian} coordinates from a specified set of {@link UnitCartesian} coordinates.
    * @param left The minuend, or value from which {@code right} is to be subtracted.
    * @param right The subtrahend, or value which is to be subtracted from {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the subtraction.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian -(UnitCartesian,Cartesian)'")
    @Nonnull
    public static Cartesian subtract(@Nonnull UnitCartesian left, @Nonnull Cartesian right) {
        return left.subtract(right);
    }

    /**
    * Subtracts a specified set of {@link UnitCartesian} coordinates from a specified set of {@link Cartesian} coordinates.
    * @param left The minuend, or value from which {@code right} is to be subtracted.
    * @param right The subtrahend, or value which is to be subtracted from {@code left}.
    * @return A set of {@link Cartesian} coordinates that represents the result of the subtraction.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'Cartesian -(Cartesian,UnitCartesian)'")
    @Nonnull
    public static Cartesian subtract(@Nonnull Cartesian left, @Nonnull UnitCartesian right) {
        return left.subtract(Cartesian.toCartesian(right));
    }

    /**
    * Negates the specified {@link UnitCartesian}, yielding a new {@link UnitCartesian}.
    * @param coordinates The set of coordinates.
    * @return The result of negating the elements of the original {@link UnitCartesian}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'UnitCartesian -(UnitCartesian)'")
    @Nonnull
    public static UnitCartesian negate(@Nonnull UnitCartesian coordinates) {
        return new UnitCartesian(-coordinates.m_x, -coordinates.m_y, -coordinates.m_z, Normalization.NORMALIZED);
    }

    /**
    * Gets a value indicating whether any of the coordinates for this instance have the value {@link Double#NaN}.
    */
    public final boolean getIsUndefined() {
        return Double.isNaN(m_x) || Double.isNaN(m_y) || Double.isNaN(m_z);
    }

    /**
    * Indicates whether another object is exactly equal to this instance.
    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnitCartesian && equalsType((UnitCartesian) obj);
    }

    /**
    * Indicates whether another instance of this type is exactly equal to this instance.
    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull UnitCartesian other) {
        return m_x == other.m_x && m_y == other.m_y && m_z == other.m_z;
    }

    /**
    * Indicates whether each coordinate value of another instance of this type
    is within the required tolerance of the corresponding coordinate value of this instance.
    * @param other The set of {@link UnitCartesian} coordinates to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
    * @return {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(@Nonnull UnitCartesian other, double epsilon) {
        return Math.abs(m_x - other.m_x) <= epsilon && Math.abs(m_y - other.m_y) <= epsilon && Math.abs(m_z - other.m_z) <= epsilon;
    }

    /**
    * Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Double.hashCode(m_x), Double.hashCode(m_y), Double.hashCode(m_z));
    }

    /**
    * Returns the string representation of the value of this instance.
    * @return A string that represents the value of this instance in the form
    "X, Y, Z".
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}, {2}", m_x, m_y, m_z);
    }

    /**
    * Returns {@code true} if the two instances are exactly equal.
    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(UnitCartesian,UnitCartesian)'")
    public static boolean equals(@Nonnull UnitCartesian left, @Nonnull UnitCartesian right) {
        return left.equalsType(right);
    }

    /**
    * Returns {@code true} if the two instances are not exactly equal.
    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return {@code true} if {@code left} does not represent the same value as {@code right}; otherwise, {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(UnitCartesian,UnitCartesian)'")
    public static boolean notEquals(@Nonnull UnitCartesian left, @Nonnull UnitCartesian right) {
        return !left.equalsType(right);
    }

    private static void normalizeCoordinates(@Nonnull double[] x, @Nonnull double[] y, @Nonnull double[] z, @Nonnull double[] magnitude) {
        magnitude[0] = Math.sqrt(x[0] * x[0] + y[0] * y[0] + z[0] * z[0]);
        // ReSharper disable once CompareOfFloatsByEqualityOperator
        if (magnitude[0] == 0.0) {
            throw new ArithmeticException(CesiumLocalization.getMagnitudeMustNotBeZero());
        }
        if (Double.isInfinite(magnitude[0])) {
            throw new ArithmeticException(CesiumLocalization.getMagnitudeMustNotBeInfinite());
        }
        x[0] /= magnitude[0];
        y[0] /= magnitude[0];
        z[0] /= magnitude[0];
    }

    @Nonnull
    private static UnitCartesian s_x = new UnitCartesian(1.0, 0.0, 0.0, Normalization.NORMALIZED);
    @Nonnull
    private static UnitCartesian s_y = new UnitCartesian(0.0, 1.0, 0.0, Normalization.NORMALIZED);
    @Nonnull
    private static UnitCartesian s_z = new UnitCartesian(0.0, 0.0, 1.0, Normalization.NORMALIZED);
    @Nonnull
    private static UnitCartesian s_undefined = new UnitCartesian(Double.NaN, Double.NaN, Double.NaN, Normalization.NORMALIZED);
    private double m_x;
    private double m_y;
    private double m_z;

    private static enum Normalization implements Enumeration {
        UNNORMALIZED(0),
        NORMALIZED(1);
        private final int value;

        Normalization(int value) {
            this.value = value;
        }

        /**
        * Get the numeric value associated with this enum constant.
        * @return A numeric value.
        */
        @Override
        public int getValue() {
            return value;
        }

        /**
        * Get the enum constant that is associated with the given numeric value.
        * @return The enum constant associated with value.
        * @param value a numeric value.
        */
        @Nonnull
        public static Normalization getFromValue(int value) {
            switch (value) {
            case 0:
                return UNNORMALIZED;
            case 1:
                return NORMALIZED;
            default:
                throw new IllegalArgumentException("Undefined enum value.");
            }
        }

        /**
        * Get the enum constant that is considered to be the default.
        * @return The default enum constant.
        */
        @Nonnull
        public static Normalization getDefault() {
            return UNNORMALIZED;
        }
    }
}