package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumLabelStyle;
import cesiumlanguagewriter.ReferenceCesiumWriter;

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
	private Lazy<ReferenceCesiumWriter> m_reference = new Lazy<cesiumlanguagewriter.ReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.ReferenceCesiumWriter>() {
		public cesiumlanguagewriter.ReferenceCesiumWriter invoke() {
			return new ReferenceCesiumWriter(ReferencePropertyName);
		}
	}, false);

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