package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumStripeOrientation;
import cesiumlanguagewriter.ReferenceCesiumWriter;

/**
 *  
 Writes a <code>StripeOrientation</code> to a  {@link CesiumOutputStream}.  A <code>StripeOrientation</code> defines the orientation of stripes in the stripe material.
 

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
	private Lazy<ReferenceCesiumWriter> m_reference = new Lazy<cesiumlanguagewriter.ReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.ReferenceCesiumWriter>() {
		public cesiumlanguagewriter.ReferenceCesiumWriter invoke() {
			return new ReferenceCesiumWriter(ReferencePropertyName);
		}
	}, false);

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
	}

	@Override
	public StripeOrientationCesiumWriter clone() {
		return new StripeOrientationCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>StripeOrientation</code> property.  The <code>StripeOrientation</code> property specifies the orientation of stripes in the stripe material. Valid values are "HORIZONTAL" or "VERTICAL".
	
	

	 * @param value The orientation.
	 */
	public final void writeStripeOrientation(CesiumStripeOrientation value) {
		String PropertyName = StripeOrientationPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.stripeOrientationToString(value));
	}

	/**
	 *  Gets the writer for the <code>reference</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>reference</code> property defines a reference property.
	

	 */
	public final ReferenceCesiumWriter getReferenceWriter() {
		return m_reference.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>reference</code> property.  The <code>reference</code> property defines a reference property.
	

	 */
	public final ReferenceCesiumWriter openReferenceProperty() {
		openIntervalIfNecessary();
		return this.<ReferenceCesiumWriter> openAndReturn(getReferenceWriter());
	}

	/**
	 *  
	Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
	
	

	 * @param value The reference.
	 */
	public final void writeReferenceProperty(Reference value) {
		{
			cesiumlanguagewriter.ReferenceCesiumWriter writer = openReferenceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeReferenceProperty(String value) {
		{
			cesiumlanguagewriter.ReferenceCesiumWriter writer = openReferenceProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeReferenceProperty(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ReferenceCesiumWriter writer = openReferenceProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeReferenceProperty(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ReferenceCesiumWriter writer = openReferenceProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
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
}