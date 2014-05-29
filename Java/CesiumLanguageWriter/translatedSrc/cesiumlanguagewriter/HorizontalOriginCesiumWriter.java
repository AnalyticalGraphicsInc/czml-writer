package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumHorizontalOrigin;
import cesiumlanguagewriter.ReferenceCesiumWriter;

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
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>> m_asHorizontalOrigin;
	private Lazy<ReferenceCesiumWriter> m_reference = new Lazy<cesiumlanguagewriter.ReferenceCesiumWriter>(new Func1<cesiumlanguagewriter.ReferenceCesiumWriter>() {
		public cesiumlanguagewriter.ReferenceCesiumWriter invoke() {
			return new ReferenceCesiumWriter(ReferencePropertyName);
		}
	}, false);

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
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>HorizontalOrigin</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumHorizontalOrigin> asHorizontalOrigin() {
		return m_asHorizontalOrigin.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumHorizontalOrigin> createHorizontalOriginAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.CesiumHorizontalOrigin>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.CesiumHorizontalOrigin>() {
					public void invoke(HorizontalOriginCesiumWriter me, CesiumHorizontalOrigin value) {
						me.writeHorizontalOrigin(value);
					}
				});
	}
}