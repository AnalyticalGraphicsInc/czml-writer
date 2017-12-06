package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ObjectHelper;
import agi.foundation.compatibility.PrimitiveHelper;
import agi.foundation.compatibility.StringHelper;

/**
 *  
 A two dimensional region specified as longitude and latitude coordinates.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CartographicExtent implements IEquatable<CartographicExtent> {
    /**
    *  
    Initializes a new instance with the specified extents.
    
    
    
    
    

    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public CartographicExtent(double west, double south, double east, double north) {
        m_west = west;
        m_south = south;
        m_east = east;
        m_north = north;
    }

    /**
    *  Gets the northernmost latitude.
    

    */
    public final double getNorthLatitude() {
        return m_north;
    }

    /**
    *  Gets the southernmost latitude.
    

    */
    public final double getSouthLatitude() {
        return m_south;
    }

    /**
    *  Gets the easternmost longitude.
    

    */
    public final double getEastLongitude() {
        return m_east;
    }

    /**
    *  Gets the westernmost longitude.
    

    */
    public final double getWestLongitude() {
        return m_west;
    }

    /**
    *  
    Returns true if the specified location is inside the extent, otherwise false.
    
    
    
    

    * @param longitude The longitude.
    * @param latitude The latitude.
    * @return 
    {@code true} if the specified location is inside the extent (or on the border),
    otherwise {@code false}.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean isInsideExtent(double longitude, double latitude) {
        return longitude >= m_west && longitude <= m_east && latitude >= m_south && latitude <= m_north;
    }

    /**
    *  
    Computes the union of this extent with another extent.  The union of two extents is
    the smallest extent that includes both.
    
    
    

    * @param other The other extent.
    * @return The union of the two extents.
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final CartographicExtent union(CartographicExtent other) {
        return new CartographicExtent(Math.min(m_west, other.m_west), Math.min(m_south, other.m_south), Math.max(m_east, other.m_east), Math.max(m_north, other.m_north));
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return equalsType((obj instanceof CartographicExtent) ? (CartographicExtent) obj : null);
    }

    /**
    *  
    Indicates whether another {@link CartographicExtent} is exactly equal to this instance.
    
    
    

    * @param other The {@link CartographicExtent} to compare to this instance.
    * @return {@code true} if {@code other} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public final boolean equalsType(CartographicExtent other) {
        if (ObjectHelper.referenceEquals(null, other)) {
            return false;
        }
        if (ObjectHelper.referenceEquals(this, other)) {
            return true;
        }
        return m_north == other.m_north && m_south == other.m_south && m_east == other.m_east && m_west == other.m_west;
    }

    /**
    *  
    Indicates whether each coordinate value of another instance of this type
    is within the required tolerance of the corresponding coordinate value of this instance.
    
    
    
    

    * @param other The set of {@link CartographicExtent} to compare to this instance.
    * @param epsilon The limit at which the absolute differences between the coordinate values will not be considered equal.
    * @return 
    {@code true} if the absolute differences are less than or equal to {@code epsilon}; otherwise, {@code false}.
    
    */
    @CS2JWarning("Unhandled attribute removed: Pure")
    public final boolean equalsEpsilon(CartographicExtent other, double epsilon) {
        return Math.abs(m_north - other.m_north) <= epsilon && Math.abs(m_south - other.m_south) <= epsilon && Math.abs(m_east - other.m_east) <= epsilon && Math.abs(m_west - other.m_west) <= epsilon;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(PrimitiveHelper.hashCode(m_north), PrimitiveHelper.hashCode(m_south), PrimitiveHelper.hashCode(m_east), PrimitiveHelper.hashCode(m_west));
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(CartographicExtent,CartographicExtent)'")
    public static boolean equals(CartographicExtent left, CartographicExtent right) {
        if (ObjectHelper.referenceEquals(left, null)) {
            return ObjectHelper.referenceEquals(right, null);
        }
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
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(CartographicExtent,CartographicExtent)'")
    public static boolean notEquals(CartographicExtent left, CartographicExtent right) {
        return !(CartographicExtent.equals(left, right));
    }

    /**
    *  
    Returns the string representation of the value of this instance.
    
    

    * @return 
    A string that represents the value of this instance in the form
    WestLongitude, SouthLatitude, EastLongitude, NorthLatitude.
    
    */
    @Override
    public String toString() {
        return StringHelper.format("{0}, {1}, {2}, {3}", m_west, m_south, m_east, m_north);
    }

    private double m_north;
    private double m_south;
    private double m_east;
    private double m_west;
}