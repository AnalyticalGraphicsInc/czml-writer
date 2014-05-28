package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.ObjectHelper;
import agi.foundation.compatibility.StringHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
	Creates a new instances from an escaped reference string.
	
	

	 * @param value The 
	 */
	public Reference(String value) {
		this(getIdentifier(value), getProperties(value), value);
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
		}, escape(identifier, new String[] {
			propertyName
		}));
	}

	/**
	 *  
	Creates a new instace from an id and a heirarchy of properties.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames An heirarchy of property names with each property being a sub-property of the previous one.
	 */
	public Reference(String identifier, String[] propertyNames) {
		this(identifier, propertyNames, escape(identifier, propertyNames));
	}

	private Reference(String identfier, String[] propertyNames, String value) {
		m_identifier = identfier;
		m_properties = propertyNames;
		m_value = value;
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
	public final String[] getPropertyNames() {
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

	static private String escape(String identfier, String[] propertyNames) {
		StringBuilder value = new StringBuilder();
		identfier = StringHelper.replace(StringHelper.replace(StringHelper.replace(identfier, "\\", "\\\\"), "#", "\\#"), ".", "\\.");
		value.append(identfier);
		value.append("#");
		for (int i = 0; i < propertyNames.length; i++) {
			String property = StringHelper.replace(StringHelper.replace(StringHelper.replace(propertyNames[i], "\\", "\\\\"), "#", "\\#"), ".", "\\.");
			value.append(property);
			if (i != propertyNames.length - 1) {
				value.append(".");
			}
		}
		return value.toString();
	}

	static private int findUnescaped(String value, int start, char delimiter) {
		int index;
		do {
			index = value.indexOf(delimiter, start);
			if (index == -1) {
				break;
			}
			int count = 0;
			int place = index - 1;
			while (place != -1 && value.charAt(place--) == '\\') {
				count++;
			}
			if (count % 2 == 0) {
				return index;
			}
			start = index + 1;
		} while (index != -1);
		return -1;
	}

	static private String[] trySplit(String value, char delimiter) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int start = 0;
		int index;
		do {
			index = findUnescaped(value, start, delimiter);
			if (index != -1) {
				indices.add(index);
				start = index + 1;
			}
		} while (index != -1);
		int lastIndex = 0;
		String[] result = new String[indices.size() + 1];
		for (int i = 0; i < indices.size(); i++) {
			index = indices.get(i);
			result[i] = StringHelper.replace(StringHelper.replace(StringHelper.replace(StringHelper.substring(value, lastIndex, index - lastIndex), "\\#", "#"), "\\\\", "\\"), "\\.", ".");
			lastIndex = index + 1;
		}
		result[indices.size()] = StringHelper.replace(StringHelper.replace(StringHelper.replace(StringHelper.substring(value, lastIndex, value.length() - lastIndex), "\\#", "#"), "\\\\", "\\"),
				"\\.", ".");
		return result;
	}

	static private String getIdentifier(String value) {
		String[] result = trySplit(value, '#');
		if (result.length == 2) {
			return result[0];
		}
		throw new ArgumentException("Reference string was not in the correct format.", "value");
	}

	static private String[] getProperties(String value) {
		int index = findUnescaped(value, 0, '#') + 1;
		String[] values = trySplit(StringHelper.substring(value, index, value.length() - index), '.');
		if (values.length == 0) {
			throw new ArgumentException("Reference string was not in the correct format.", "value");
		}
		for (String item : values) {
			if (StringHelper.isNullOrEmpty(item)) {
				throw new ArgumentException("Reference string was not in the correct format.", "value");
			}
		}
		return values;
	}

	private String m_value;
	private String m_identifier;
	private String[] m_properties;
}