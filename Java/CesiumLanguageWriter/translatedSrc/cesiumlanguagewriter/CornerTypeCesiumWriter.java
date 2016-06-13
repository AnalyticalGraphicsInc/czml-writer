package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumCornerType;
import cesiumlanguagewriter.Reference;

/**
 *  
 Writes a <code>CornerType</code> to a  {@link CesiumOutputStream}.  A <code>CornerType</code> is the style of a corner.
 

 */
public class CornerTypeCesiumWriter extends CesiumPropertyWriter<CornerTypeCesiumWriter> {
	/**
	 *  
	The name of the <code>CornerType</code> property.
	

	 */
	public static final String CornerTypePropertyName = "CornerType";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<CesiumCornerType>> m_asCornerType;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public CornerTypeCesiumWriter(String propertyName) {
		super(propertyName);
		m_asCornerType = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType>>(
				this, "createCornerTypeAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType> invoke() {
				return createCornerTypeAdaptor();
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
	protected CornerTypeCesiumWriter(CornerTypeCesiumWriter existingInstance) {
		super(existingInstance);
		m_asCornerType = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType>>(
				this, "createCornerTypeAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumCornerType> invoke() {
				return createCornerTypeAdaptor();
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
	public CornerTypeCesiumWriter clone() {
		return new CornerTypeCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>CornerType</code>, which is the corner style.  Valid values are "ROUNDED", "MITERED", and "BEVELED".
	
	

	 * @param value The style of a corner.
	 */
	public final void writeCornerType(CesiumCornerType value) {
		String PropertyName = CornerTypePropertyName;
		if (getForceInterval()) {
			openIntervalIfNecessary();
		}
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.cornerTypeToString(value));
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the corner style specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the corner style specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the corner style specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the corner style specified as a reference to another property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeReference(String identifier, String[] propertyNames) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>CornerType</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumCornerType> asCornerType() {
		return m_asCornerType.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumCornerType> createCornerTypeAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.CornerTypeCesiumWriter, cesiumlanguagewriter.CesiumCornerType>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CornerTypeCesiumWriter, cesiumlanguagewriter.CesiumCornerType>() {
					public void invoke(CornerTypeCesiumWriter me, CesiumCornerType value) {
						me.writeCornerType(value);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.CornerTypeCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.CornerTypeCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(CornerTypeCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}