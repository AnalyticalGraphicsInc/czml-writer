package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.ObjectHelper;

/**
 *  
 Represents a link to another property.  References can be used to specify that
 two properties on different objects are in fact, the same property.  This also
 has the added benefit of cutting down on CZML file size.
 

 */
public class Reference implements IEquatable<Reference>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public Reference() {}

	/**
	 *  
	Creates a new instance.
	
	
	

	 * @param id The id of the object which contains the referenced property.
	 * @param path The path to the property in the referenced object.
	 */
	public Reference(String id, String path) {
		m_identifier = id;
		m_path = path;
	}

	/**
	 *  Gets the id of the object which contains the referenced property.
	

	 */
	public final String getIdentifier() {
		return m_identifier;
	}

	/**
	 *  Gets the path to the property in the referenced object.
	

	 */
	public final String getPath() {
		return m_path;
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param obj The object to compare to this instance.
	 * @return <see langword="true" /> if <code>obj</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Reference) {
			return equalsType((Reference) obj);
		} else {
			return false;
		}
	}

	/**
	 *  
	Indicates whether another object is exactly equal to this instance.
	
	
	

	 * @param other The object to compare to this instance.
	 * @return <see langword="true" /> if <code>other</code> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false" />.
	 */
	public final boolean equalsType(Reference other) {
		return ObjectHelper.equals(this.m_identifier, other.m_identifier) && ObjectHelper.equals(this.m_path, other.m_path);
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return m_identifier.hashCode() ^ m_path.hashCode();
	}

	private String m_identifier;
	private String m_path;
}