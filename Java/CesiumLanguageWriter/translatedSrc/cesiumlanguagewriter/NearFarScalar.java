package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.StringHelper;
import javax.annotation.Nonnull;

/**
 * A numeric value which will be linearly interpolated between two values based 
 on an object's distance from the camera, in eye coordinates.  The computed value 
 will interpolate between the near value and the far value while the camera distance 
 falls between the near distance and the far distance, and will be clamped to the 
 near or far value while the distance is less than the near distance or greater 
 than the far distance, respectively.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public final class NearFarScalar implements IEquatable<NearFarScalar>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public NearFarScalar() {}

    /**
    * Initializes a new instance.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public NearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue) {
        m_nearDistance = nearDistance;
        m_nearValue = nearValue;
        m_farDistance = farDistance;
        m_farValue = farValue;
    }

    /**
    * Gets the lower bound of the camera distance range.
    */
    public final double getNearDistance() {
        return m_nearDistance;
    }

    /**
    * Gets the value to use at the lower bound of the camera distance range.
    */
    public final double getNearValue() {
        return m_nearValue;
    }

    /**
    * Gets the upper bound of the camera distance range.
    */
    public final double getFarDistance() {
        return m_farDistance;
    }

    /**
    * Gets the value to use at the upper bound of the camera distance range.
    */
    public final double getFarValue() {
        return m_farValue;
    }

    /**
    * Indicates whether another instance of this type is exactly equal to this instance.
    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(@Nonnull NearFarScalar other) {
        return m_nearDistance == other.m_nearDistance && m_nearValue == other.m_nearValue && m_farDistance == other.m_farDistance && m_farValue == other.m_farValue;
    }

    /**
    * Indicates whether another object is exactly equal to this instance.
    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof NearFarScalar && equalsType((NearFarScalar) obj);
    }

    /**
    * Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(Double.hashCode(m_nearDistance), Double.hashCode(m_nearValue), Double.hashCode(m_farDistance), Double.hashCode(m_farValue));
    }

    /**
    * Returns the string representation of the value of this instance.
    * @return A string that represents the value of this instance in the form
    "{@code NearDistance} ({@link #getNearDistance get}), {@code NearValue} ({@link #getNearValue get}), {@code FarDistance} ({@link #getFarDistance get}), {@code FarValue} ({@link #getFarValue get})".
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}, {2}, {3}", m_nearDistance, m_nearValue, m_farDistance, m_farValue);
    }

    /**
    * Returns {@code true} if the two instances are exactly equal.
    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(NearFarScalar,NearFarScalar)'")
    public static boolean equals(@Nonnull NearFarScalar left, @Nonnull NearFarScalar right) {
        return left.equalsType(right);
    }

    /**
    * Returns {@code true} if the two instances are not exactly equal.
    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return {@code true} if {@code left} does not represent the same value as {@code right}; otherwise, {@code false}.
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(NearFarScalar,NearFarScalar)'")
    public static boolean notEquals(@Nonnull NearFarScalar left, @Nonnull NearFarScalar right) {
        return !left.equalsType(right);
    }

    private double m_nearDistance;
    private double m_nearValue;
    private double m_farDistance;
    private double m_farValue;
}