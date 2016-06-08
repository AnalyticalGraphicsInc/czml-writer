package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumStripeOrientation;
import cesiumlanguagewriter.Reference;

/**
 *  
 Writes a <code>StripeOrientation</code> to a  {@link CesiumOutputStream}.  A <code>StripeOrientation</code> is the orientation of stripes in a stripe material.
 

 */
public class StripeOrientationCesiumWriter extends CesiumPropertyWriter<StripeOrientationCesiumWriter> {
	/**
	 *  
	The name of the <code>StripeOrientation</code> property.
	

	 */
	public static final String StripeOrientationPropertyName = "StripeOrientation";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>> m_asStripeOrientation;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public StripeOrientationCesiumWriter(String propertyName) {
		super(propertyName);
		m_asStripeOrientation = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(this, "createStripeOrientationAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation> invoke() {
						return createStripeOrientationAdaptor();
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
	protected StripeOrientationCesiumWriter(StripeOrientationCesiumWriter existingInstance) {
		super(existingInstance);
		m_asStripeOrientation = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(this, "createStripeOrientationAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation> invoke() {
						return createStripeOrientationAdaptor();
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
	public StripeOrientationCesiumWriter clone() {
		return new StripeOrientationCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>StripeOrientation</code>, which is the orientation of stripes in the stripe material. Valid values are "HORIZONTAL" or "VERTICAL".
	
	

	 * @param value The orientation.
	 */
	public final void writeStripeOrientation(CesiumStripeOrientation value) {
		String PropertyName = StripeOrientationPropertyName;
		if (getForceInterval()) {
			openIntervalIfNecessary();
		}
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.stripeOrientationToString(value));
	}

	/**
	 *  
	Writes the value expressed as a <code>reference</code>, which is the orientation of stripes specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the orientation of stripes specified as a reference to another property.
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the orientation of stripes specified as a reference to another property.
	
	
	

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
	Writes the value expressed as a <code>reference</code>, which is the orientation of stripes specified as a reference to another property.
	
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>StripeOrientation</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumStripeOrientation> asStripeOrientation() {
		return m_asStripeOrientation.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumStripeOrientation> createStripeOrientationAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.StripeOrientationCesiumWriter, cesiumlanguagewriter.CesiumStripeOrientation>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.StripeOrientationCesiumWriter, cesiumlanguagewriter.CesiumStripeOrientation>() {
					public void invoke(StripeOrientationCesiumWriter me, CesiumStripeOrientation value) {
						me.writeStripeOrientation(value);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.StripeOrientationCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.StripeOrientationCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(StripeOrientationCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}