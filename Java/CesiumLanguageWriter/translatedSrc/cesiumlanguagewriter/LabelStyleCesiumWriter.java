package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumLabelStyle;

/**
 *  
 Writes a <code>LabelStyle</code> to a  {@link CesiumOutputStream}.  A <code>LabelStyle</code> the style of a label.
 

 */
public class LabelStyleCesiumWriter extends CesiumPropertyWriter<LabelStyleCesiumWriter> {
	/**
	 *  
	The name of the <code>labelStyle</code> property.
	

	 */
	public static final String LabelStylePropertyName = "labelStyle";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<CesiumLabelStyle>> m_asLabelStyle;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public LabelStyleCesiumWriter(String propertyName) {
		super(propertyName);
		m_asLabelStyle = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle>>(
				this, "createLabelStyleAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle> invoke() {
				return createLabelStyleAdaptor();
			}
		}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected LabelStyleCesiumWriter(LabelStyleCesiumWriter existingInstance) {
		super(existingInstance);
		m_asLabelStyle = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle>>(
				this, "createLabelStyleAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumLabelStyle> invoke() {
				return createLabelStyleAdaptor();
			}
		}, false);
	}

	@Override
	public LabelStyleCesiumWriter clone() {
		return new LabelStyleCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>labelStyle</code> property.  The <code>labelStyle</code> property specifies the label style.  Valid values are "FILL", "OUTLINE", and "FILL_AND_OUTLINE".
	
	

	 * @param value The label style.
	 */
	public final void writeLabelStyle(CesiumLabelStyle value) {
		String PropertyName = LabelStylePropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.labelStyleToString(value));
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference.
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>LabelStyle</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumLabelStyle> asLabelStyle() {
		return m_asLabelStyle.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumLabelStyle> createLabelStyleAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.LabelStyleCesiumWriter, cesiumlanguagewriter.CesiumLabelStyle>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.LabelStyleCesiumWriter, cesiumlanguagewriter.CesiumLabelStyle>() {
					public void invoke(LabelStyleCesiumWriter me, CesiumLabelStyle value) {
						me.writeLabelStyle(value);
					}
				});
	}
}