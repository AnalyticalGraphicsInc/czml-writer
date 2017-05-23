package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.PrimitiveHelper;
import javax.annotation.Nonnull;

/**
 *  
 Describes motion, including a coordinate and optionally one or more derivatives.
 
 

 * @param <T> The coordinate type used to describe the motion.
 */
@SuppressWarnings("unused")
public final class Motion1<T> implements IEquatable<Motion1<T>>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public Motion1() {}

    /**
    *  
    Initializes a new instance.
    
    
    
    
    

    * <p>
    The first array element describes the value of the coordinate.  The second
    describes the first derivative, the third describes the second derivative, and so on.
    The array must have at least one element.
    
    * @param motion The description of the motion.
    * @exception ArgumentNullException 
    Thrown when the parameter {@code motion} is {@code null}.
    
    * @exception IllegalStateException 
    Thrown when the {@code motion} does not contain any values.
    
    */
    public Motion1(@Nonnull T... motion) {
        if (motion == null) {
            throw new ArgumentNullException("motion");
        }
        if (motion.length < 1) {
            throw new IllegalStateException(CesiumLocalization.getMotionMustContainValue());
        }
        m_motion = motion;
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    
    

    * <p>
    For two Motion instances to be considered equal, the value and derivatives of each
    must compare as equal.
    
    * @param other The object to compare to this instance.
    * @return {@code true} if {@code other} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    public final boolean equalsType(Motion1<T> other) {
        if (m_motion == null && other.m_motion == null) {
            return true;
        }
        if (m_motion == null || other.m_motion == null || m_motion.length != other.m_motion.length) {
            return false;
        }
        for (int i = 0; i < m_motion.length; ++i) {
            if (!m_motion[i].equals(other.m_motion[i])) {
                return false;
            }
        }
        return true;
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    
    

    * <p>
    For two Motion instances to be considered equal, the value and derivatives of each
    must compare as equal.
    
    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Motion1 && equalsType((Motion1<T>) obj);
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        int hashValue = PrimitiveHelper.hashCode(getOrder());
        if (m_motion != null) {
            for (int i = 0; i < m_motion.length; ++i) {
                hashValue ^= m_motion[i].hashCode();
            }
        }
        return hashValue;
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    
    

    * <p>
    For two Motion instances to be considered equal, the value and derivatives of each
    must compare as equal.
    
    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(Motion,Motion)'")
    public static <T> boolean equals(Motion1<T> left, Motion1<T> right) {
        return left.equalsType(right);
    }

    /**
    *  
    Returns {@code true} if the two instances are not exactly equal.
    
    
    
    
    

    * <p>
    For two Motion instances to be considered equal, the value and derivatives of each
    must compare as equal.
    
    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} does not represent the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(Motion,Motion)'")
    public static <T> boolean notEquals(Motion1<T> left, Motion1<T> right) {
        return !left.equalsType(right);
    }

    /**
    *  Gets the value of the coordinate.
    

    */
    public final T getValue() {
        return get(0);
    }

    /**
    *  Gets the first derivative, if it is available.
    
    

    * @exception ArgumentOutOfRangeException 
    This motion instance does not contain a first derivative.
    
    */
    public final T getFirstDerivative() {
        return get(1);
    }

    /**
    *  Gets the second derivative, if it is available.
    
    

    * @exception ArgumentOutOfRangeException 
    This motion instance does not contain a second derivative.
    
    */
    public final T getSecondDerivative() {
        return get(2);
    }

    /**
    *  Gets the indicated component of the motion.
    Index 0 retrieves the coordinate value.  Index 1 retrieves the first derivative, if it
    exists.  Index 2 retrieves the second derivative, if it exists.  The number of available
    derivatives is indicated by the {@code Order} ({@link #getOrder get}) property.
    
    
    
    

    * @param index The index of the motion component to retrieve.
    * @return The requested motion component.
    * @exception ArgumentOutOfRangeException 
    Thrown when the {@code index} is not between zero and the {@code Order} ({@link #getOrder get}) inclusive.
    
    */
    public final T get(int index) {
        if (m_motion == null) {
            if (index == 0) {
                return (T) null;
            }
            throw new ArgumentOutOfRangeException("index");
        }
        if (index >= 0 && index < m_motion.length) {
            return m_motion[index];
        }
        throw new ArgumentOutOfRangeException("index");
    }

    /**
    *  Gets the number of derivatives described by this instance.
    

    */
    public final int getOrder() {
        if (m_motion == null) {
            return 0;
        }
        return m_motion.length - 1;
    }

    private T[] m_motion;
}