package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>ExternalDocumentScope</code> to a  {@link CesiumOutputStream}.  A <code>ExternalDocumentScope</code> defines the scope of the document.  It controls whether the document is shared or private. A shared scope merges all objects with the same id into the parent document. A private scope creates a separate document.
 

 */
public class ExternalDocumentScopeCesiumWriter extends CesiumPropertyWriter<ExternalDocumentScopeCesiumWriter> {
	/**
	 *  
	The name of the <code>scope</code> property.
	

	 */
	public static final String ScopePropertyName = "scope";
	private Lazy<ICesiumValuePropertyWriter<CesiumExternalDocumentScope>> m_asScope;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ExternalDocumentScopeCesiumWriter(String propertyName) {
		super(propertyName);
		m_asScope = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentScope>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentScope>>(this, "createScopeAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentScope> invoke() {
						return createScopeAdaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ExternalDocumentScopeCesiumWriter(ExternalDocumentScopeCesiumWriter existingInstance) {
		super(existingInstance);
		m_asScope = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentScope>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentScope>>(this, "createScopeAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumExternalDocumentScope> invoke() {
						return createScopeAdaptor();
					}
				}, false);
	}

	@Override
	public ExternalDocumentScopeCesiumWriter clone() {
		return new ExternalDocumentScopeCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>scope</code> property.  The <code>scope</code> property specifies the document's scope.  Valid values are "SHARED" and "PRIVATE".
	
	

	 * @param value The scope of the document.
	 */
	public final void writeScope(CesiumExternalDocumentScope value) {
		String PropertyName = ScopePropertyName;
		if (getIsInterval()) {
			getOutput().writePropertyName(PropertyName);
		}
		getOutput().writeValue(CesiumFormattingHelper.externalDocumentScopeToString(value));
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Scope</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<CesiumExternalDocumentScope> asScope() {
		return m_asScope.getValue();
	}

	final private ICesiumValuePropertyWriter<CesiumExternalDocumentScope> createScopeAdaptor() {
		return new CesiumWriterAdaptor<ExternalDocumentScopeCesiumWriter, CesiumExternalDocumentScope>(this,
				new CesiumWriterAdaptorWriteCallback<ExternalDocumentScopeCesiumWriter, CesiumExternalDocumentScope>() {
					public void invoke(ExternalDocumentScopeCesiumWriter me, CesiumExternalDocumentScope value) {
						me.writeScope(value);
					}
				});
	}
}