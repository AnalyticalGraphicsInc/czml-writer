package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;

/**
 *  
 Writes a <code>String</code> to a  {@link CesiumOutputStream}.  A <code>String</code> a string value.  The string can optionally vary with time.
 

 */
public class StringCesiumWriter extends CesiumPropertyWriter<StringCesiumWriter> {
	/**
	 *  
	The name of the <code>string</code> property.
	

	 */
	public static final String StringPropertyName = "string";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<String>> m_asString;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public StringCesiumWriter(String propertyName) {
		super(propertyName);
		m_asString = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this,
				"createStringAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
				return createStringAdaptor();
			}
		}, false);
		m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
				"createReferenceAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
				return createReferenceAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected StringCesiumWriter(StringCesiumWriter existingInstance) {
		super(existingInstance);
		m_asString = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this,
				"createStringAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
				return createStringAdaptor();
			}
		}, false);
		m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
				"createReferenceAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
				return createReferenceAdaptor();
			}
		}, false);
	}

	@Override
	public StringCesiumWriter clone() {
		return new StringCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>string</code> property.  The <code>string</code> property specifies the string value.
	
	

	 * @param value The value.
	 */
	public final void writeString(String value) {
		String PropertyName = StringPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(value);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	

	 * @param value The reference.
	 */
	public final void writeReference(Reference value) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeReference(String value) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeReference(String identifier, String propertyName) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeReference(String identifier, String[] propertyNames) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>String</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<String> asString() {
		return m_asString.getValue();
	}

	final private ICesiumValuePropertyWriter<String> createStringAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.StringCesiumWriter, String>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.StringCesiumWriter, String>() {
			public void invoke(StringCesiumWriter me, String value) {
				me.writeString(value);
			}
		});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Reference</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Reference> asReference() {
		return m_asReference.getValue();
	}

	final private ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.StringCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.StringCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(StringCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}