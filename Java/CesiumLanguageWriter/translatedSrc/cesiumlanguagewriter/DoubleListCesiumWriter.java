package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>DoubleList</code> to a  {@link CesiumOutputStream}.  A <code>DoubleList</code> is a list of floating-point numbers.
 

 */
public class DoubleListCesiumWriter extends CesiumPropertyWriter<DoubleListCesiumWriter> {
	/**
	 *  
	The name of the <code>array</code> property.
	

	 */
	public static final String ArrayPropertyName = "array";
	/**
	 *  
	The name of the <code>references</code> property.
	

	 */
	public static final String ReferencesPropertyName = "references";
	private Lazy<ICesiumValuePropertyWriter<Iterable<Double>>> m_asArray;
	private Lazy<ICesiumValuePropertyWriter<Iterable<Reference>>> m_asReferences;

	/**
	 *  
	Initializes a new instance.
	

	 */
	public DoubleListCesiumWriter(String propertyName) {
		super(propertyName);
		m_asArray = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Double>>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Double>>>(this,
				"createArrayAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Double>> invoke() {
				return createArrayAdaptor();
			}
		}, false);
		m_asReferences = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>>>(this, "createReferencesAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>> invoke() {
						return createReferencesAdaptor();
					}
				}, false);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected DoubleListCesiumWriter(DoubleListCesiumWriter existingInstance) {
		super(existingInstance);
		m_asArray = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Double>>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Double>>>(this,
				"createArrayAdaptor", new Class[] {}) {
			public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Double>> invoke() {
				return createArrayAdaptor();
			}
		}, false);
		m_asReferences = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>>>(
				new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>>>(this, "createReferencesAdaptor", new Class[] {}) {
					public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>> invoke() {
						return createReferencesAdaptor();
					}
				}, false);
	}

	@Override
	public DoubleListCesiumWriter clone() {
		return new DoubleListCesiumWriter(this);
	}

	/**
	 *  
	Writes the value expressed as a <code>array</code>, which is the list of values specified as an array of numbers.
	
	

	 * @param values The values.
	 */
	public final void writeArray(Iterable<Double> values) {
		String PropertyName = ArrayPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeDoubleList(getOutput(), values);
	}

	/**
	 *  
	Writes the value expressed as a <code>references</code>, which is the list of values specified as references.  Each reference is to a property that defines a single value, which may change with time.
	
	

	 * @param references The list of references.
	 */
	public final void writeReferences(Iterable<Reference> references) {
		String PropertyName = ReferencesPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReferences(getOutput(), references);
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>Array</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Iterable<Double>> asArray() {
		return m_asArray.getValue();
	}

	final private ICesiumValuePropertyWriter<Iterable<Double>> createArrayAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.DoubleListCesiumWriter, Iterable<Double>>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DoubleListCesiumWriter, Iterable<Double>>() {
					public void invoke(DoubleListCesiumWriter me, Iterable<Double> value) {
						me.writeArray(value);
					}
				});
	}

	/**
	 *  
	Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in <code>References</code> format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
	
	

	 * @return The wrapper.
	 */
	public final ICesiumValuePropertyWriter<Iterable<Reference>> asReferences() {
		return m_asReferences.getValue();
	}

	final private ICesiumValuePropertyWriter<Iterable<Reference>> createReferencesAdaptor() {
		return new CesiumWriterAdaptor<cesiumlanguagewriter.DoubleListCesiumWriter, Iterable<Reference>>(this,
				new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DoubleListCesiumWriter, Iterable<Reference>>() {
					public void invoke(DoubleListCesiumWriter me, Iterable<Reference> value) {
						me.writeReferences(value);
					}
				});
	}
}