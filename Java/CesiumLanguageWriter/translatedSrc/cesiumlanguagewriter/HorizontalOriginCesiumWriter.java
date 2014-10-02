package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumHorizontalOrigin;
import cesiumlanguagewriter.Reference;

/**
 *  
 Writes a <code>HorizontalOrigin</code> to a  {@link CesiumOutputStream}.  A <code>HorizontalOrigin</code> defines the horizontal origin of an element, which can optionally vary over time.  It controls whether the element is left-, center-, or right-aligned with the `position`.
 

 */
public class HorizontalOriginCesiumWriter extends CesiumPropertyWriter<HorizontalOriginCesiumWriter> {
	/**
	 *  
	The name of the <code>horizontalOrigin</code> property.
	

	 */
	public static final String HorizontalOriginPropertyName = "horizontalOrigin";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>> m_asHorizontalOrigin;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public HorizontalOriginCesiumWriter(String propertyName) {
		super(propertyName);
		m_asHorizontalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(this, "createHorizontalOriginAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin> invoke() {
						return createHorizontalOriginAdaptor();
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
	protected HorizontalOriginCesiumWriter(HorizontalOriginCesiumWriter existingInstance) {
		super(existingInstance);
		m_asHorizontalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(this, "createHorizontalOriginAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin> invoke() {
						return createHorizontalOriginAdaptor();
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
	public HorizontalOriginCesiumWriter clone() {
		return new HorizontalOriginCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property specifies the horizontal origin.  Valid values are "LEFT", "CENTER", and "RIGHT".
	
	

	 * @param value The horizontal origin.
	 */
	public final void writeHorizontalOrigin(CesiumHorizontalOrigin value) {
		String PropertyName = HorizontalOriginPropertyName;
		if (getForceInterval()) {
			openIntervalIfNecessary();
		}
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.horizontalOriginToString(value));
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
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>HorizontalOrigin</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumHorizontalOrigin> asHorizontalOrigin() {
		return m_asHorizontalOrigin.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumHorizontalOrigin> createHorizontalOriginAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.CesiumHorizontalOrigin>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.CesiumHorizontalOrigin>() {
					public void invoke(HorizontalOriginCesiumWriter me, CesiumHorizontalOrigin value) {
						me.writeHorizontalOrigin(value);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(HorizontalOriginCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}