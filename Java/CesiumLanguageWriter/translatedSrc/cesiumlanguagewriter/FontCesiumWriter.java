package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>Font</code> to a  {@link CesiumOutputStream}.  A <code>Font</code> tODO
 

 */
public class FontCesiumWriter extends CesiumPropertyWriter<FontCesiumWriter> {
	/**
	 *  
	The name of the <code>font</code> property.
	

	 */
	public static final String FontPropertyName = "font";
	private Lazy<ICesiumValuePropertyWriter<String>> m_asFont;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public FontCesiumWriter(String propertyName) {
		super(propertyName);
		m_asFont = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this, "createFontAdaptor",
				new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
				return createFontAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected FontCesiumWriter(FontCesiumWriter existingInstance) {
		super(existingInstance);
		m_asFont = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this, "createFontAdaptor",
				new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
				return createFontAdaptor();
			}
		}, false);
	}

	@Override
	public FontCesiumWriter clone() {
		return new FontCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>font</code> property.  The <code>font</code> property specifies the font.
	
	

	 * @param font The font.
	 */
	public final void writeFont(String font) {
		String PropertyName = FontPropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(font);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Font</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<String> asFont() {
		return m_asFont.getValue();
	}

	final private ICesiumValuePropertyWriter<String> createFontAdaptor() {
		return new CesiumWriterAdaptor<FontCesiumWriter, String>(this, new CesiumWriterAdaptorWriteCallback<FontCesiumWriter, String>() {
			public void invoke(FontCesiumWriter me, String value) {
				me.writeFont(value);
			}
		});
	}
}