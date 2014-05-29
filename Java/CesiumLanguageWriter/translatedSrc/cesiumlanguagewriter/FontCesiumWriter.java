package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;

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
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<String>> m_asFont;
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

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
	protected FontCesiumWriter(FontCesiumWriter existingInstance) {
		super(existingInstance);
		m_asFont = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String>>(this, "createFontAdaptor",
				new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<String> invoke() {
				return createFontAdaptor();
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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeReference(String identifier, String[] propertyNames) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.FontCesiumWriter, String>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.FontCesiumWriter, String>() {
			public void invoke(FontCesiumWriter me, String value) {
				me.writeFont(value);
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
		return new CesiumWriterAdaptor<cesiumlanguagewriter.FontCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.FontCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(FontCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}