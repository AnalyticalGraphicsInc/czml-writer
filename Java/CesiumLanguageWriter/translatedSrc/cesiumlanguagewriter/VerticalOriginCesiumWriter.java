package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumVerticalOrigin;
import cesiumlanguagewriter.Reference;

/**
 *  
 Writes a <code>VerticalOrigin</code> to a  {@link CesiumOutputStream}.  A <code>VerticalOrigin</code> is the vertical origin of an element, which can optionally vary over time.  It controls whether the element is bottom-, center-, or top-aligned with the `position`.
 

 */
public class VerticalOriginCesiumWriter extends CesiumPropertyWriter<VerticalOriginCesiumWriter> {
	/**
	 *  
	The name of the <code>verticalOrigin</code> property.
	

	 */
	public static final String VerticalOriginPropertyName = "verticalOrigin";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>> m_asVerticalOrigin;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public VerticalOriginCesiumWriter(String propertyName) {
		super(propertyName);
		m_asVerticalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(this, "createVerticalOriginAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin> invoke() {
						return createVerticalOriginAdaptor();
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
	protected VerticalOriginCesiumWriter(VerticalOriginCesiumWriter existingInstance) {
		super(existingInstance);
		m_asVerticalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(this, "createVerticalOriginAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumVerticalOrigin> invoke() {
						return createVerticalOriginAdaptor();
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
	public VerticalOriginCesiumWriter clone() {
		return new VerticalOriginCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>verticalOrigin</code>, which is the vertical origin.
	
	

	 * @param value The vertical origin.
	 */
	public final void writeVerticalOrigin(CesiumVerticalOrigin value) {
		String PropertyName = VerticalOriginPropertyName;
		if (getForceInterval()) {
			openIntervalIfNecessary();
		}
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.verticalOriginToString(value));
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the vertical origin specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the vertical origin specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the vertical origin specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the vertical origin specified as a reference to another property.
	
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>VerticalOrigin</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumVerticalOrigin> asVerticalOrigin() {
		return m_asVerticalOrigin.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumVerticalOrigin> createVerticalOriginAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.VerticalOriginCesiumWriter, cesiumlanguagewriter.CesiumVerticalOrigin>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.VerticalOriginCesiumWriter, cesiumlanguagewriter.CesiumVerticalOrigin>() {
					public void invoke(VerticalOriginCesiumWriter me, CesiumVerticalOrigin value) {
						me.writeVerticalOrigin(value);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.VerticalOriginCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.VerticalOriginCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(VerticalOriginCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}