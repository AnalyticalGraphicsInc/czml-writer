package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>ExternalDocumentSourceType</code> to a  {@link CesiumOutputStream}.  A <code>ExternalDocumentSourceType</code> defines the type of data to retrieve.
 

 */
public class ExternalDocumentSourceTypeCesiumWriter extends CesiumPropertyWriter<ExternalDocumentSourceTypeCesiumWriter> {
	/**
	 *  
	The name of the <code>sourceType</code> property.
	

	 */
	public static final String SourceTypePropertyName = "sourceType";
	private Lazy<ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType>> m_asSourceType;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ExternalDocumentSourceTypeCesiumWriter(String propertyName) {
		super(propertyName);
		m_asSourceType = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType>>(this, "createSourceTypeAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType> invoke() {
						return createSourceTypeAdaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ExternalDocumentSourceTypeCesiumWriter(ExternalDocumentSourceTypeCesiumWriter existingInstance) {
		super(existingInstance);
		m_asSourceType = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType>>(this, "createSourceTypeAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType> invoke() {
						return createSourceTypeAdaptor();
					}
				}, false);
	}

	@Override
	public ExternalDocumentSourceTypeCesiumWriter clone() {
		return new ExternalDocumentSourceTypeCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>sourceType</code> property.  The <code>sourceType</code> property specifies defines the type of data to retrieve. Valid values are "json" and "eventstream".
	
	

	 * @param value The data transport type to use.
	 */
	public final void writeSourceType(CesiumExternalDocumentSourceType value) {
		String PropertyName = SourceTypePropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.externalDocumentSourceTypeToString(value));
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>SourceType</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType> asSourceType() {
		return m_asSourceType.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumExternalDocumentSourceType> createSourceTypeAdaptor() {
		return new CesiumWriterAdaptor<ExternalDocumentSourceTypeCesiumWriter, CesiumExternalDocumentSourceType>(this,
				new CesiumWriterAdaptorWriteCallback<ExternalDocumentSourceTypeCesiumWriter, CesiumExternalDocumentSourceType>() {
					public void invoke(ExternalDocumentSourceTypeCesiumWriter me, CesiumExternalDocumentSourceType value) {
						me.writeSourceType(value);
					}
				});
	}
}