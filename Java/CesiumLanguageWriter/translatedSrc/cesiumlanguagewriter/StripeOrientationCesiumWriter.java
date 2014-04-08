package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumStripeOrientation;

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
	private Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>> m_asStripeOrientation;

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