package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code CornerType} to a {@link CesiumOutputStream}. A {@code CornerType} is the style of a corner.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CornerTypeCesiumWriter extends CesiumPropertyWriter<CornerTypeCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumCornerTypeValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code cornerType} property.
    

    */
    public static final String CornerTypePropertyName = "cornerType";
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
    private Lazy<CesiumCornerTypeValuePropertyAdaptor<CornerTypeCesiumWriter>> m_asCornerType;
    private Lazy<CesiumReferenceValuePropertyAdaptor<CornerTypeCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public CornerTypeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCornerType = createAsCornerType();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected CornerTypeCesiumWriter(@Nonnull CornerTypeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCornerType = createAsCornerType();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public CornerTypeCesiumWriter clone() {
        return new CornerTypeCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code cornerType}, which is the corner style.
    
    

    * @param value The style of a corner.
    */
    public final void writeCornerType(@Nonnull CesiumCornerType value) {
        final String PropertyName = CornerTypePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.cornerTypeToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the corner style specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the corner style specified as a reference to another property.
    
    

    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the corner style specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the corner style specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code delete}, which is whether the client should delete existing samples or interval data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumCornerTypeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumCornerTypeValuePropertyAdaptor<CornerTypeCesiumWriter> asCornerType() {
        return m_asCornerType.getValue();
    }

    private final Lazy<CesiumCornerTypeValuePropertyAdaptor<CornerTypeCesiumWriter>> createAsCornerType() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCornerTypeValuePropertyAdaptor<CornerTypeCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCornerTypeValuePropertyAdaptor<CornerTypeCesiumWriter>>(this, "createCornerType") {
                    public cesiumlanguagewriter.advanced.CesiumCornerTypeValuePropertyAdaptor<CornerTypeCesiumWriter> invoke() {
                        return createCornerType();
                    }
                }, false);
    }

    private final CesiumCornerTypeValuePropertyAdaptor<CornerTypeCesiumWriter> createCornerType() {
        return CesiumValuePropertyAdaptors.<CornerTypeCesiumWriter> createCornerType(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<CornerTypeCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<CornerTypeCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<CornerTypeCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<CornerTypeCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<CornerTypeCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<CornerTypeCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<CornerTypeCesiumWriter> createReference(this);
    }
}