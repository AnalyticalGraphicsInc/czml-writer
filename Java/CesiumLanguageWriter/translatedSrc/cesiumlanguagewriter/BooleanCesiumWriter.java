package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code Boolean} to a {@link CesiumOutputStream}. A {@code Boolean} is a boolean value.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class BooleanCesiumWriter extends CesiumPropertyWriter<BooleanCesiumWriter> {
    /**
    *  
    The name of the {@code boolean} property.
    

    */
    public static final String BooleanPropertyName = "boolean";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumValuePropertyWriter<Boolean>> m_asBoolean;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public BooleanCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asBoolean = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(this,
                "createBooleanAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean> invoke() {
                return createBooleanAdaptor();
            }
        }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor") {
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
    protected BooleanCesiumWriter(@Nonnull BooleanCesiumWriter existingInstance) {
        super(existingInstance);
        m_asBoolean = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean>>(this,
                "createBooleanAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Boolean> invoke() {
                return createBooleanAdaptor();
            }
        }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createReferenceAdaptor();
            }
        }, false);
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public BooleanCesiumWriter clone() {
        return new BooleanCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code boolean}, which is the boolean value.
    
    

    * @param value The value.
    */
    public final void writeBoolean(boolean value) {
        final String PropertyName = BooleanPropertyName;
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
    Writes the value expressed as a {@code reference}, which is the boolean specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the boolean specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the boolean specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the boolean specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Boolean} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Boolean> asBoolean() {
        return m_asBoolean.getValue();
    }

    private final ICesiumValuePropertyWriter<Boolean> createBooleanAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.BooleanCesiumWriter, Boolean>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.BooleanCesiumWriter, Boolean>() {
            public void invoke(BooleanCesiumWriter me, Boolean value) {
                me.writeBoolean(value);
            }
        });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Reference} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Reference> asReference() {
        return m_asReference.getValue();
    }

    private final ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.BooleanCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.BooleanCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(BooleanCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}