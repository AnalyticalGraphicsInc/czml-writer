package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a {@code Integer} to a {@link CesiumOutputStream}.  A {@code Integer} is an integer number.
 

 */
public class IntegerCesiumWriter extends CesiumInterpolatablePropertyWriter<IntegerCesiumWriter> {
    /**
    *  
    The name of the {@code number} property.
    

    */
    public static final String NumberPropertyName = "number";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Integer>> m_asNumber;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    

    */
    public IntegerCesiumWriter(String propertyName) {
        super(propertyName);
        m_asNumber = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Integer>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Integer>>(this, "createNumberAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Integer> invoke() {
                        return createNumberAdaptor();
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
    protected IntegerCesiumWriter(IntegerCesiumWriter existingInstance) {
        super(existingInstance);
        m_asNumber = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Integer>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Integer>>(this, "createNumberAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Integer> invoke() {
                        return createNumberAdaptor();
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
    public IntegerCesiumWriter clone() {
        return new IntegerCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the integer.
    
    

    * @param value The value.
    */
    public final void writeNumber(int value) {
        final String PropertyName = NumberPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(value);
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the integer.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNumber(List<JulianDate> dates, List<Integer> values) {
        writeNumber(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the integer.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNumber(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        final String PropertyName = NumberPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeInteger(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the integer specified as a reference to another property.
    
    

    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the integer specified as a reference to another property.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the integer specified as a reference to another property.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeReference(String identifier, String propertyName) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the integer specified as a reference to another property.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeReference(String identifier, String[] propertyNames) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Number} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Integer> asNumber() {
        return m_asNumber.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Integer> createNumberAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.IntegerCesiumWriter, Integer>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.IntegerCesiumWriter, Integer>() {
                    public void invoke(IntegerCesiumWriter me, Integer value) {
                        me.writeNumber(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.IntegerCesiumWriter, Integer>() {
                    public void invoke(IntegerCesiumWriter me, List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
                        me.writeNumber(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Reference} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Reference> asReference() {
        return m_asReference.getValue();
    }

    private final ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.IntegerCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.IntegerCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(IntegerCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}