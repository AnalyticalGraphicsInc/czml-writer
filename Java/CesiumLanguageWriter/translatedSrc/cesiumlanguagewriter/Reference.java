package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.ListHelper;
import agi.foundation.compatibility.ObjectHelper;
import agi.foundation.compatibility.StringHelper;
import java.util.ArrayList;
import java.util.Collection;

/**
 *  
 Represents a link to another property.  References can be used to specify that
 two properties on different objects are in fact, the same property.  This also
 has the added benefit of cutting down on CZML file size.
 
 The formatted reference string contains the identifier of the target object followed
 by a hashtag (#) and one or more property names, each separated by a period (.).
 Any hash symbols or periods that exist in the reference identifier or property must
 be properly escaped with a backslash (\\) in order for the reference to be valid.
 

 */
public class Reference implements IEquatable<Reference>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public Reference() {}

	/**
	 *  
	Creates a new instances from an escaped reference string.
	
	

	 * @param value The 
	 */
	public Reference(String value) {
		m_value = value;
		String[] out$m_identifier_0 = {
			null
		};
		ArrayList<String>[] out$m_properties_1 = new ArrayList[] {
			null
		};
		parse(value, out$m_identifier_0, out$m_properties_1);
		m_properties = out$m_properties_1[0];
		m_identifier = out$m_identifier_0[0];
	}

	/**
	 *  
	Creates a new instance from an id and property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public Reference(String identifier, String propertyName) {
		this(identifier, new String[] {
			propertyName
		});
	}

	/**
	 *  
	Creates a new instace from an id and a heirarchy of properties.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames An heirarchy of property names with each property being a sub-property of the previous one.
	 */
	public Reference(String identifier, Iterable<String> propertyNames) {
		m_identifier = identifier;
		m_properties = ListHelper.create(propertyNames);
		m_value = formatReference(m_identifier, m_properties);
	}

	/**
	 *  Gets the identifier of the object which contains the referenced property.
	

	 */
	public final String getIdentifier() {
		return m_identifier;
	}

	/**
	 *  Gets the heirarchy of properties to be indexed on the referenced object.
	

	 */
	public final Iterable<String> getPropertyNames() {
		return m_properties;
	}

	/**
	 *  Gets the escaped CZML value of the reference.
	

	 */
	public final String getValue() {
		return m_value;
	}

	/**
	 *  
	Gets the escaped CZML value of the reference.
	
	

	 * @return The escaped CZML value of the reference.
	 */
	@Override
	public String toString() {
		return m_value;
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
		return ObjectHelper.equals(this.m_value, other.m_value);
	}

	/**
	 *  
	Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
	
	

	 * @return A hash code for the current object.
	 */
	@Override
	public int hashCode() {
		return m_identifier.hashCode() ^ m_properties.hashCode() ^ m_value.hashCode();
	}

	static private String formatReference(String identfier, Iterable<String> propertyNames) {
		StringBuilder value = new StringBuilder();
		identfier = StringHelper.replace(StringHelper.replace(StringHelper.replace(identfier, "\\", "\\\\"), "#", "\\#"), ".", "\\.");
		value.append(identfier);
		value.append("#");
		for (String propertyName : propertyNames) {
			String property = StringHelper.replace(StringHelper.replace(StringHelper.replace(propertyName, "\\", "\\\\"), "#", "\\#"), ".", "\\.");
			value.append(property);
			value.append(".");
		}
		value.delete(value.length() - 1, 1);
		return value.toString();
	}

	static private void parse(String value, String[] identifier, ArrayList<String>[] values) {
		identifier[0] = StringHelper.empty;
		values[0] = new ArrayList<String>();
		boolean inIdentifier = true;
		boolean isEscaped = false;
		String token = StringHelper.empty;
		for (int i = 0; i < value.length(); ++i) {
			char c = value.charAt(i);
			if (isEscaped) {
				token += c;
				isEscaped = false;
			} else if (c == '\\') {
				isEscaped = true;
			} else if (inIdentifier && c == '#') {
				identifier[0] = token;
				inIdentifier = false;
				token = StringHelper.empty;
			} else if (!inIdentifier && c == '.') {
				if (StringHelper.isNullOrEmpty(token)) {
					throw new ArgumentException(CesiumLocalization.getInvalidReferenceString());
				}
				values[0].add(token);
				token = StringHelper.empty;
			} else {
				token += c;
			}
		}
		values[0].add(token);
		if (StringHelper.isNullOrEmpty(token)) {
			throw new ArgumentException(CesiumLocalization.getInvalidReferenceString());
		}
		if (inIdentifier) {
			throw new ArgumentException(CesiumLocalization.getInvalidReferenceString());
		}
	}

	private String m_value;
	private String m_identifier;
	private ArrayList<String> m_properties;
}