package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import javax.annotation.Nonnull;

/**
 * A bounding rectangle in a two-dimensional plane given by two corner points.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class BoundingRectangle implements IEquatable<BoundingRectangle>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public BoundingRectangle() {}

    /**
    * Initializes a new instance.
    * @param left The x coordinate of the lower-left corner.
    * @param bottom The y coordinate of the lower-left corner.
    * @param right The x coordinate of the upper-right corner.
    * @param top The y coordinate of the upper-right corner.
    * @exception ArgumentException Thrown when the right parameter is less than the left parameter or when the top parameter is less than the bottom parameter.
    */
    public BoundingRectangle(double left, double bottom, double right, double top) {
        if (right < left) {
            throw new ArgumentException("right must be greater than or equal to left");
        }
        if (top < bottom) {
            throw new ArgumentException("top must be greater than or equal to bottom");
        }
        m_left = left;
        m_bottom = bottom;
        m_right = right;
        m_top = top;
    }

    /**
    * Gets a {@link BoundingRectangle} with all values set to zero.
    */
    @Nonnull
    public static BoundingRectangle getEmpty() {
        return s_empty;
    }

    /**
    * Initializes a new instance.
    * @param x The x coordinate of the lower-left corner.
    * @param y The y coordinate of the lower-left corner.
    * @param width The width of the rectangle.
    * @param height The height of the rectangle.
    * @return A new {@link BoundingRectangle}.
    */
    @Nonnull
    public static BoundingRectangle fromWidthHeight(double x, double y, double width, double height) {
        return new BoundingRectangle(x, y, x + width, y + height);
    }

    /**
    * Gets the x-coordinate of the left edge of the rectangle.
    */
    public final double getLeft() {
        return m_left;
    }

    /**
    * Gets the y-coordinate of the top edge of the rectangle.
    */
    public final double getTop() {
        return m_top;
    }

    /**
    * Gets the y-coordinate of the bottom edge of the rectangle.
    */
    public final double getBottom() {
        return m_bottom;
    }

    /**
    * Gets the x-coordinate of the right edge of the rectangle.
    */
    public final double getRight() {
        return m_right;
    }

    /**
    * Gets the width of the rectangle.
    */
    public final double getWidth() {
        return m_right - m_left;
    }

    /**
    * Gets the height of the rectangle.
    */
    public final double getHeight() {
        return m_top - m_bottom;
    }

    /**
    * Indicates whether another object is exactly equal to this instance.
    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof BoundingRectangle && equalsType((BoundingRectangle) obj);
    }

    /**
    * Indicates whether another instance of this type is exactly equal to this instance.
    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull BoundingRectangle other) {
        return m_left == other.m_left && m_bottom == other.m_bottom && m_right == other.m_right && m_top == other.m_top;
    }

    /**
    * Indicates whether each coordinate value of another instance of this type
    is within the required tolerance of the corresponding coordinate value of this instance.
    * @param other The set of {@link BoundingRectangle} coordinates to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
    * @return {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(@Nonnull BoundingRectangle other, double epsilon) {
        return Math.abs(m_left - other.m_left) <= epsilon && Math.abs(m_bottom - other.m_bottom) <= epsilon && Math.abs(m_right - other.m_right) <= epsilon && Math.abs(m_top - other.m_top) <= epsilon;
    }

    /**
    * Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Double.hashCode(m_left), Double.hashCode(m_bottom), Double.hashCode(m_right), Double.hashCode(m_top));
    }

    /**
    * Returns the string representation of the value of this instance.
    * @return A string that represents the value of this instance in the form
    "Left, Bottom, Right, Top".
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}, {2}, {3}", m_left, m_bottom, m_right, m_top);
    }

    /**
    * Returns {@code true} if the two instances are exactly equal.
    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(BoundingRectangle,BoundingRectangle)'")
    public static boolean equals(@Nonnull BoundingRectangle left, @Nonnull BoundingRectangle right) {
        return left.equalsType(right);
    }

    /**
    * Returns {@code true} if the two instances are not exactly equal.
    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return {@code true} if {@code left} does not represent the same value as {@code right}; otherwise, {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(BoundingRectangle,BoundingRectangle)'")
    public static boolean notEquals(@Nonnull BoundingRectangle left, @Nonnull BoundingRectangle right) {
        return !left.equalsType(right);
    }

    @Nonnull
    private static BoundingRectangle s_empty = new BoundingRectangle(0D, 0D, 0D, 0D);
    private double m_left;
    private double m_right;
    private double m_bottom;
    private double m_top;
}