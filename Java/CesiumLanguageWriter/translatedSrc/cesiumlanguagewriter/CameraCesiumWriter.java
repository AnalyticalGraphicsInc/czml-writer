package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>Camera</code> to a  {@link CesiumOutputStream}.  A <code>Camera</code> a camera.
 

 */
public class CameraCesiumWriter extends CesiumPropertyWriter<CameraCesiumWriter> {
	/**
	 *  
	The name of the <code>enable</code> property.
	

	 */
	public static final String EnablePropertyName = "enable";
	private Lazy<BooleanCesiumWriter> m_enable = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
		public BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(EnablePropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public CameraCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected CameraCesiumWriter(CameraCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public CameraCesiumWriter clone() {
		return new CameraCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>enable</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>enable</code> property defines whether or not the camera is enabled.
	

	 */
	public final BooleanCesiumWriter getEnableWriter() {
		return m_enable.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>enable</code> property.  The <code>enable</code> property defines whether or not the camera is enabled.
	

	 */
	public final BooleanCesiumWriter openEnableProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getEnableWriter());
	}

	/**
	 *  
	Writes a value for the <code>enable</code> property as a <code>boolean</code> value.  The <code>enable</code> property specifies whether or not the camera is enabled.
	
	

	 * @param value The value.
	 */
	public final void writeEnableProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openEnableProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}