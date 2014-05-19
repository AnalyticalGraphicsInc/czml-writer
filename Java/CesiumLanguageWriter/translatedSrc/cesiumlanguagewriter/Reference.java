package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;

/**
 *  
 
 

 */
public class Reference implements IEquatable<Reference>, ImmutableValueType {
	/**
	 * Initializes a new instance.
	 */
	public Reference() {}

	/**
	 *  
	
	
	
	

	 * @param id 
	 * @param path 
	 */
	public Reference(String id, String path) {
		m_identifier = id;
		m_path = path;
	}

	/**
	 *  
	
	

	 */
	public final String getIdentifier() {
		return m_identifier;
	}

	/**
	 *  
	
	

	 */
	public final String getPath() {
		return m_path;
	}

	/**
	 *  
	
	
	
	

	 * @param other 
	 */
	public final boolean equalsType(Reference other) {
		throw new UnsupportedOperationException();
	}

	private String m_identifier;
	private String m_path;

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + (m_identifier == null ? 0 : m_identifier.hashCode());
		result = 31 * result + (m_path == null ? 0 : m_path.hashCode());
		return result;
	}
}