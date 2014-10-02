package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>Boolean</code> to a  {@link CesiumOutputStream}.  A <code>Boolean</code> a boolean value.
 

 */
public class BooleanCesiumWriter extends CesiumPropertyWriter<BooleanCesiumWriter> {
	/**
	 *  
	The name of the <code>boolean</code> property.
	

	 */
	public static final String BooleanPropertyName = "boolean";
	private Lazy<ICesiumValuePropertyWriter<Boolean>> m_asBoolean;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public BooleanCesiumWriter(String propertyName) {
		super(propertyName);
		m_asBoolean = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(this,
				"createBooleanAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean> invoke() {
				return createBooleanAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected BooleanCesiumWriter(BooleanCesiumWriter existingInstance) {
		super(existingInstance);
		m_asBoolean = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(this,
				"createBooleanAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean> invoke() {
				return createBooleanAdaptor();
			}
		}, false);
	}

	@Override
	public BooleanCesiumWriter clone() {
		return new BooleanCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>boolean</code> property.  The <code>boolean</code> property specifies the boolean value.
	
	

	 * @param value The value.
	 */
	public final void writeBoolean(boolean value) {
		String PropertyName = BooleanPropertyName;
		if (getForceInterval()) {
			openIntervalIfNecessary();
		}
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(value);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Boolean</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Boolean> asBoolean() {
		return m_asBoolean.getValue();
	}

	final private ICesiumValuePropertyWriter<Boolean> createBooleanAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.BooleanCesiumWriter, Boolean>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.BooleanCesiumWriter, Boolean>() {
			public void invoke(BooleanCesiumWriter me, Boolean value) {
				me.writeBoolean(value);
			}
		});
	}
}