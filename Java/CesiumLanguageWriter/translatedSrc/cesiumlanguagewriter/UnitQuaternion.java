package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.Enumeration;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *  
 A set of 4-dimensional coordinates used to represent rotation in 3-dimensional space.  This
 represents an 'alias' rotation which transforms coordinates by modifying the underlying coordinate
 basis rather than modifying the coordinates themselves. To transform a {@link Cartesian} 
 with this rotation, see {@link Cartesian#rotate(UnitQuaternion)}.
 
 
 

 * <p>
 <p>
 The normalization of the quaternion is accomplished in the usual way.
 It should be noted that this does not guarantee a result whose magnitude will be 1.0 in cases where an individual component underflows upon squaring.
 </p>
 
 * @see Matrix3By3
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@CS2JWarning("Unhandled attribute removed: SuppressMessage")
public final class UnitQuaternion implements IEquatable<UnitQuaternion>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public UnitQuaternion() {}

    /**
    *  
    Initializes a set of {@link UnitQuaternion} coordinates from the provided values.
    
    
    
    
    
    
    
    

    * <p>The given values will be normalized to ensure a unit magnitude.
    * @param w The W coordinate.
    * @param x The X coordinate.
    * @param y The Y coordinate.
    * @param z The Z coordinate.
    * @exception ArithmeticException 
    The magnitude of the provided coordinates must not be zero.
    
    * @exception ArithmeticException 
    The magnitude of the provided coordinates must not be infinite.
    
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public UnitQuaternion(double w, double x, double y, double z) {
        this(w, x, y, z, Normalization.UNNORMALIZED);
    }

    /**
    *  
    Initializes a set of {@link UnitQuaternion} coordinates from the provided values.
    
    
    
    
    
    
    
    
    

    * <p>The given values will be normalized to ensure a unit magnitude.
    * @param w The W coordinate.
    * @param x The X coordinate.
    * @param y The Y coordinate.
    * @param z The Z coordinate.
    * @param magnitude 
    On input, an array with one element.  On return, the array is populated with
    
    the magnitude of the original set of coordinates.
    
    * @exception ArithmeticException 
    The magnitude of the provided coordinates must not be zero.
    
    * @exception ArithmeticException 
    The magnitude of the provided coordinates must not be infinite.
    
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public UnitQuaternion(double w, double x, double y, double z, @Nonnull double[] magnitude) {
        final double[] ref$w$0 = {
            w
        };
        final double[] ref$x$1 = {
            x
        };
        final double[] ref$y$2 = {
            y
        };
        final double[] ref$z$3 = {
            z
        };
        normalizeCoordinates(ref$w$0, ref$x$1, ref$y$2, ref$z$3, magnitude);
        z = ref$z$3[0];
        y = ref$y$2[0];
        x = ref$x$1[0];
        w = ref$w$0[0];
        m_w = w;
        m_x = x;
        m_y = y;
        m_z = z;
    }

    /**
    *  
    Initializes a set of {@link UnitQuaternion} coordinates from the provided rotation matrix ({@link Matrix3By3}).
    Note that if the given {@code matrix} is not an orthogonal rotation matrix,
    it will create a non-unit {@link UnitQuaternion} and could cause problems in code which assumes that the {@link UnitQuaternion} represents a rotation.
    
    
    

    * <p>For performance reasons, there is no check to ensure that the {@code matrix} is a unit rotation prior
    to converting to a unit quaternion.  If necessary, the surrounding code is responsible for ensuring that the given
    {@code matrix} is a valid orthogonal rotation matrix.
    * @param matrix The 3-by-3 rotation matrix.
    */
    public UnitQuaternion(@Nonnull Matrix3By3 matrix) {
        double factor = matrix.getM11() + matrix.getM22() + matrix.getM33();
        int type = 0;
        if (matrix.getM11() > factor) {
            type = 1;
            factor = matrix.getM11();
        }
        if (matrix.getM22() > factor) {
            type = 2;
            factor = matrix.getM22();
        }
        if (matrix.getM33() > factor) {
            type = 3;
            factor = matrix.getM33();
        }
        if (type == 1) {
            m_x = 0.5 * Math.sqrt(1.0 + matrix.getM11() - matrix.getM22() - matrix.getM33());
            factor = 1.0 / (4.0 * m_x);
            m_w = factor * (matrix.getM23() - matrix.getM32());
            if (m_w < 0) {
                m_w = -m_w;
                m_x = -m_x;
                factor = -factor;
            }
            m_y = factor * (matrix.getM12() + matrix.getM21());
            m_z = factor * (matrix.getM13() + matrix.getM31());
        } else if (type == 2) {
            m_y = 0.5 * Math.sqrt(1.0 - matrix.getM11() + matrix.getM22() - matrix.getM33());
            factor = 1.0 / (4.0 * m_y);
            m_w = factor * (matrix.getM31() - matrix.getM13());
            if (m_w < 0) {
                m_w = -m_w;
                m_y = -m_y;
                factor = -factor;
            }
            m_x = factor * (matrix.getM12() + matrix.getM21());
            m_z = factor * (matrix.getM23() + matrix.getM32());
        } else if (type == 3) {
            m_z = 0.5 * Math.sqrt(1.0 - matrix.getM11() - matrix.getM22() + matrix.getM33());
            factor = 1.0 / (4.0 * m_z);
            m_w = factor * (matrix.getM12() - matrix.getM21());
            if (m_w < 0) {
                m_w = -m_w;
                m_z = -m_z;
                factor = -factor;
            }
            m_x = factor * (matrix.getM13() + matrix.getM31());
            m_y = factor * (matrix.getM23() + matrix.getM32());
        } else {
            m_w = 0.5 * Math.sqrt(1.0 + factor);
            factor = 1.0 / (4.0 * m_w);
            m_x = factor * (matrix.getM23() - matrix.getM32());
            m_y = factor * (matrix.getM31() - matrix.getM13());
            m_z = factor * (matrix.getM12() - matrix.getM21());
        }
    }

    /**
    *  Gets a set of {@link UnitQuaternion} coordinates with values of {@link Double#NaN}.
    
    

    * <p>
    Use {@code IsUndefined} ({@link UnitQuaternion#getIsUndefined get}) to test whether a {@link UnitQuaternion} instance
    is undefined since it will return {@code true} if any of the coordinate values
    are {@link Double#NaN}.
    
    */
    @Nonnull
    public static UnitQuaternion getUndefined() {
        return s_undefined;
    }

    /**
    *  Gets a set of {@link UnitQuaternion} coordinates representing the identity vector.
    

    */
    @Nonnull
    public static UnitQuaternion getIdentity() {
        return s_identity;
    }

    /**
    *  Gets the W coordinate.
    

    */
    public final double getW() {
        return m_w;
    }

    /**
    *  Gets the X coordinate.
    

    */
    public final double getX() {
        return m_x;
    }

    /**
    *  Gets the Y coordinate.
    

    */
    public final double getY() {
        return m_y;
    }

    /**
    *  Gets the Z coordinate.
    

    */
    public final double getZ() {
        return m_z;
    }

    /**
    *  
    Forms the conjugate of this instance.
    
    

    * @return A set of {@link UnitQuaternion} coordinates that represents the conjugate of this instance.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final UnitQuaternion conjugate() {
        return new UnitQuaternion(m_w, -m_x, -m_y, -m_z, Normalization.NORMALIZED);
    }

    /**
    *  
    Multiplies this instance by the specified {@link UnitQuaternion}, yielding a new {@link UnitQuaternion}.
    
    
    

    * @param quaternion The quaternion by which to multiply this quaternion.
    * @return The result of the multiplication.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    @Nonnull
    public final UnitQuaternion multiply(@Nonnull UnitQuaternion quaternion) {
        return new UnitQuaternion(m_w * quaternion.m_w - m_x * quaternion.m_x - m_y * quaternion.m_y - m_z * quaternion.m_z, m_w * quaternion.m_x + m_x * quaternion.m_w - m_y * quaternion.m_z + m_z
                * quaternion.m_y, m_w * quaternion.m_y + m_x * quaternion.m_z + m_y * quaternion.m_w - m_z * quaternion.m_x, m_w * quaternion.m_z - m_x * quaternion.m_y + m_y * quaternion.m_x + m_z
                * quaternion.m_w);
    }

    /**
    *  
    Multiplies a specified {@link UnitQuaternion} by another specified {@link UnitQuaternion}, yielding a new {@link UnitQuaternion}.
    
    
    
    

    * @param left The first unit quaternion.
    * @param right The second unit quaternion.
    * @return The result of the multiplication.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'UnitQuaternion *(UnitQuaternion,UnitQuaternion)'")
    @Nonnull
    public static UnitQuaternion multiply(@Nonnull UnitQuaternion left, @Nonnull UnitQuaternion right) {
        return left.multiply(right);
    }

    /**
    *  
    Negates the specified {@link UnitQuaternion}, yielding a new {@link UnitQuaternion}.
    
    
    

    * @param coordinates The set of coordinates.
    * @return The result of negating the elements of the original {@link UnitQuaternion}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'UnitQuaternion -(UnitQuaternion)'")
    @Nonnull
    public static UnitQuaternion negate(@Nonnull UnitQuaternion coordinates) {
        return new UnitQuaternion(-coordinates.m_w, -coordinates.m_x, -coordinates.m_y, -coordinates.m_z, Normalization.NORMALIZED);
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof UnitQuaternion && equalsType((UnitQuaternion) obj);
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull UnitQuaternion other) {
        return m_w == other.m_w && m_x == other.m_x && m_y == other.m_y && m_z == other.m_z;
    }

    /**
    *  
    Indicates whether each coordinate value of another instance of this type
    is within the required tolerance of the corresponding coordinate value of this instance.
    
    
    
    

    * @param other The set of {@link UnitQuaternion} coordinates to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
    * @return 
    {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise, {@code false}.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(@Nonnull UnitQuaternion other, double epsilon) {
        return Math.abs(m_w - other.m_w) <= epsilon && Math.abs(m_x - other.m_x) <= epsilon && Math.abs(m_y - other.m_y) <= epsilon && Math.abs(m_z - other.m_z) <= epsilon;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Double.hashCode(m_w), Double.hashCode(m_x), Double.hashCode(m_y), Double.hashCode(m_z));
    }

    /**
    *  
    Returns the string representation of the value of this instance.
    
    

    * @return 
    A string that represents the value of this instance in the form
    "W, X, Y, Z".
    
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}, {2}, {3}", m_w, m_x, m_y, m_z);
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(UnitQuaternion,UnitQuaternion)'")
    public static boolean equals(@Nonnull UnitQuaternion left, @Nonnull UnitQuaternion right) {
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(UnitQuaternion,UnitQuaternion)'")
    public static boolean notEquals(@Nonnull UnitQuaternion left, @Nonnull UnitQuaternion right) {
        return !left.equalsType(right);
    }

    /**
    *  Gets a value indicating whether or not any of the coordinates for this instance have the value {@link Double#NaN}.
    

    */
    public final boolean getIsUndefined() {
        return Double.isNaN(m_w) || Double.isNaN(m_x) || Double.isNaN(m_y) || Double.isNaN(m_z);
    }

    private UnitQuaternion(double w, double x, double y, double z, @Nonnull Normalization normalization) {
        if (normalization == Normalization.NORMALIZED) {
            m_w = w;
            m_x = x;
            m_y = y;
            m_z = z;
        } else {
            double magnitude = 0D;
            final double[] ref$w$4 = {
                w
            };
            final double[] ref$x$5 = {
                x
            };
            final double[] ref$y$6 = {
                y
            };
            final double[] ref$z$7 = {
                z
            };
            final double[] out$magnitude$8 = {
                0D
            };
            normalizeCoordinates(ref$w$4, ref$x$5, ref$y$6, ref$z$7, out$magnitude$8);
            magnitude = out$magnitude$8[0];
            z = ref$z$7[0];
            y = ref$y$6[0];
            x = ref$x$5[0];
            w = ref$w$4[0];
            m_w = w;
            m_x = x;
            m_y = y;
            m_z = z;
        }
    }

    private static void normalizeCoordinates(@Nonnull double[] w, @Nonnull double[] x, @Nonnull double[] y, @Nonnull double[] z, @Nonnull double[] magnitude) {
        magnitude[0] = Math.sqrt(w[0] * w[0] + x[0] * x[0] + y[0] * y[0] + z[0] * z[0]);
        // ReSharper disable once CompareOfFloatsByEqualityOperator
        if (magnitude[0] == 0.0) {
            throw new ArithmeticException(CesiumLocalization.getMagnitudeMustNotBeZero());
        }
        if (Double.isInfinite(magnitude[0])) {
            throw new ArithmeticException(CesiumLocalization.getMagnitudeMustNotBeInfinite());
        }
        w[0] /= magnitude[0];
        x[0] /= magnitude[0];
        y[0] /= magnitude[0];
        z[0] /= magnitude[0];
    }

    @Nonnull
    private static UnitQuaternion s_identity = new UnitQuaternion(1.0, 0.0, 0.0, 0.0);
    @Nonnull
    private static UnitQuaternion s_undefined = new UnitQuaternion(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Normalization.NORMALIZED);
    private double m_w;
    private double m_x;
    private double m_y;
    private double m_z;

    private static enum Normalization implements Enumeration {
        UNNORMALIZED(0), NORMALIZED(1);
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