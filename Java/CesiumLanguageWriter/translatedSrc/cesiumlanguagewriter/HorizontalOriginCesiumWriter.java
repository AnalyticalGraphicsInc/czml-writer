package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

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
	private Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>> m_asHorizontalOrigin;

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
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.horizontalOriginToString(value));
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
		return new CesiumWriterAdaptor<HorizontalOriginCesiumWriter, CesiumHorizontalOrigin>(this, new CesiumWriterAdaptorWriteCallback<HorizontalOriginCesiumWriter, CesiumHorizontalOrigin>() {
			public void invoke(HorizontalOriginCesiumWriter me, CesiumHorizontalOrigin value) {
				me.writeHorizontalOrigin(value);
			}
		});
	}
}