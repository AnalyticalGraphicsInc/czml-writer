package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>VerticalOrigin</code> to a  {@link CesiumOutputStream}.  A <code>VerticalOrigin</code> defines the vertical origin of an element, which can optionally vary over time.  It controls whether the element is bottom-, center-, or top-aligned with the `position`.
 

 */
public class VerticalOriginCesiumWriter extends CesiumPropertyWriter<VerticalOriginCesiumWriter> {
	/**
	 *  
	The name of the <code>verticalOrigin</code> property.
	

	 */
	public static final String VerticalOriginPropertyName = "verticalOrigin";
	private Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>> m_asVerticalOrigin;

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
	}

	@Override
	public VerticalOriginCesiumWriter clone() {
		return new VerticalOriginCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>verticalOrigin</code> property.  The <code>verticalOrigin</code> property specifies the vertical origin.  Valid values are "BOTTOM", "CENTER", and "TOP".
	
	

	 * @param value The vertical origin.
	 */
	public final void writeVerticalOrigin(CesiumVerticalOrigin value) {
		String PropertyName = VerticalOriginPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.verticalOriginToString(value));
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
		return new CesiumWriterAdaptor<VerticalOriginCesiumWriter, CesiumVerticalOrigin>(this, new CesiumWriterAdaptorWriteCallback<VerticalOriginCesiumWriter, CesiumVerticalOrigin>() {
			public void invoke(VerticalOriginCesiumWriter me, CesiumVerticalOrigin value) {
				me.writeVerticalOrigin(value);
			}
		});
	}
}