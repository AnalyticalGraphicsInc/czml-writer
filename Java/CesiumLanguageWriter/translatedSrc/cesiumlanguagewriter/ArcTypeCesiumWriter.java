package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumArcType;
import cesiumlanguagewriter.Reference;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code ArcType} to a {@link CesiumOutputStream}. A {@code ArcType} is the type of an arc.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class ArcTypeCesiumWriter extends CesiumPropertyWriter<ArcTypeCesiumWriter> {
    /**
    *  
    The name of the {@code ArcType} property.
    

    */
    public static final String ArcTypePropertyName = "ArcType";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    /**
    *  
    The name of the {@code delete} property.
    

    */
    public static final String DeletePropertyName = "delete";
    private Lazy<ICesiumValuePropertyWriter<CesiumArcType>> m_asArcType;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public ArcTypeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asArcType = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumArcType>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumArcType>>(this,
                "createArcTypeAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumArcType> invoke() {
                return createArcTypeAdaptor();
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
    protected ArcTypeCesiumWriter(@Nonnull ArcTypeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asArcType = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumArcType>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumArcType>>(this,
                "createArcTypeAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumArcType> invoke() {
                return createArcTypeAdaptor();
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
    public ArcTypeCesiumWriter clone() {
        return new ArcTypeCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code ArcType}, which is the arc type.
    
    

    * @param value The style of an arc.
    */
    public final void writeArcType(@Nonnull CesiumArcType value) {
        final String PropertyName = ArcTypePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.arcTypeToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the arc type specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the arc type specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the arc type specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the arc type specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code delete}, which is whether the client should delete existing data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
    
    

    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        final String PropertyName = DeletePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code ArcType} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumArcType> asArcType() {
        return m_asArcType.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumArcType> createArcTypeAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.ArcTypeCesiumWriter, cesiumlanguagewriter.CesiumArcType>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ArcTypeCesiumWriter, cesiumlanguagewriter.CesiumArcType>() {
                    public void invoke(ArcTypeCesiumWriter me, @Nonnull CesiumArcType value) {
                        me.writeArcType(value);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.ArcTypeCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ArcTypeCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(ArcTypeCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}