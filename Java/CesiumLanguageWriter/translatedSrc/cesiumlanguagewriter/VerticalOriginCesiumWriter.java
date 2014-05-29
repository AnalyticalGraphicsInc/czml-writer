package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumVerticalOrigin;
import cesiumlanguagewriter.ReferenceCesiumWriter;

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
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>> m_asVerticalOrigin;
	private Lazy<ReferenceCesiumWriter> m_reference = new Lazy<cesiumlanguagewriter.ReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.ReferenceCesiumWriter>() {
		public cesiumlanguagewriter.ReferenceCesiumWriter invoke() {
			return new ReferenceCesiumWriter(ReferencePropertyName);
		}
	}, false);

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
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>VerticalOrigin</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumVerticalOrigin> asVerticalOrigin() {
		return m_asVerticalOrigin.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumVerticalOrigin> createVerticalOriginAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.VerticalOriginCesiumWriter, cesiumlanguagewriter.CesiumVerticalOrigin>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.VerticalOriginCesiumWriter, cesiumlanguagewriter.CesiumVerticalOrigin>() {
					public void invoke(VerticalOriginCesiumWriter me, CesiumVerticalOrigin value) {
						me.writeVerticalOrigin(value);
					}
				});
	}
}