package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;

/**
 *  
 Writes a <code>Reference</code> to a  {@link CesiumOutputStream}.  A <code>Reference</code> represents a reference to another property.  References can be used to specify that two properties on different objects are in fact, the same property.
 

 */
public class ReferenceCesiumWriter extends CesiumPropertyWriter<ReferenceCesiumWriter> {
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ReferenceCesiumWriter(String propertyName) {
		super(propertyName);
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
	protected ReferenceCesiumWriter(ReferenceCesiumWriter existingInstance) {
		super(existingInstance);
		m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
				"createReferenceAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
				return createReferenceAdaptor();
			}
		}, false);
	}

	@Override
	public ReferenceCesiumWriter clone() {
		return new ReferenceCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies the formatted reference string containing the identifier of the target object followed by a hashtag (#) and one or more property names, each separated by a period (.).  Any hash symbols or periods that exist in the reference identifier or property must be properly escaped with a backslash (\) in order for the reference to be valid.
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies the formatted reference string containing the identifier of the target object followed by a hashtag (#) and one or more property names, each separated by a period (.).  Any hash symbols or periods that exist in the reference identifier or property must be properly escaped with a backslash (\) in order for the reference to be valid.
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies the formatted reference string containing the identifier of the target object followed by a hashtag (#) and one or more property names, each separated by a period (.).  Any hash symbols or periods that exist in the reference identifier or property must be properly escaped with a backslash (\) in order for the reference to be valid.
	
	
	

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
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies the formatted reference string containing the identifier of the target object followed by a hashtag (#) and one or more property names, each separated by a period (.).  Any hash symbols or periods that exist in the reference identifier or property must be properly escaped with a backslash (\) in order for the reference to be valid.
	
	
	

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
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Reference</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Reference> asReference() {
		return m_asReference.getValue();
	}

	final private ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.ReferenceCesiumWriter, cesiumlanguagewriter.Reference>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ReferenceCesiumWriter, cesiumlanguagewriter.Reference>() {
					public void invoke(ReferenceCesiumWriter me, Reference value) {
						me.writeReference(value);
					}
				});
	}
}