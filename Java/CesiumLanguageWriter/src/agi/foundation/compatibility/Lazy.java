package agi.foundation.compatibility;



/**
 *  
 Provides support for lazy initialization.
 
 

 * @param <T> Specifies the type of object that is being lazily initialized.
 */
public class Lazy<T> {
	private T m_instance;
	private Func1<T> m_createCallback;

	/**
	 *  
	Initializes a new instance.
	
	
	

	 * @param valueFactory The callback to use to create the instance.
	 * @param isThreadSafe Must be <see langword="false" />.
	 */
	public Lazy(Func1<T> valueFactory, boolean isThreadSafe) {
		if (isThreadSafe) {
			throw new UnsupportedOperationException();
		}
		m_createCallback = valueFactory;
	}

	/**
	 *  Gets the value, creating it if necessary.
	

	 */
	public final T getValue() {
		if (m_instance == null) {
			m_instance = m_createCallback.invoke();
		}
		return m_instance;
	}
}