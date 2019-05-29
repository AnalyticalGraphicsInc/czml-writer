package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code ShadowMode} to a {@link CesiumOutputStream}. A {@code ShadowMode} is whether or not an object casts or receives shadows from each light source when shadows are enabled.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class ShadowModeCesiumWriter extends CesiumPropertyWriter<ShadowModeCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumShadowModeValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code shadowMode} property.
    

    */
    public static final String ShadowModePropertyName = "shadowMode";
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
    private Lazy<CesiumShadowModeValuePropertyAdaptor<ShadowModeCesiumWriter>> m_asShadowMode;
    private Lazy<CesiumReferenceValuePropertyAdaptor<ShadowModeCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public ShadowModeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asShadowMode = createAsShadowMode();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected ShadowModeCesiumWriter(@Nonnull ShadowModeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asShadowMode = createAsShadowMode();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public ShadowModeCesiumWriter clone() {
        return new ShadowModeCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code shadowMode}, which is the shadow mode.
    
    

    * @param value The shadow mode.
    */
    public final void writeShadowMode(@Nonnull CesiumShadowMode value) {
        final String PropertyName = ShadowModePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.shadowModeToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the shadow mode specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the shadow mode specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the shadow mode specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the shadow mode specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumShadowModeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumShadowModeValuePropertyAdaptor<ShadowModeCesiumWriter> asShadowMode() {
        return m_asShadowMode.getValue();
    }

    private final Lazy<CesiumShadowModeValuePropertyAdaptor<ShadowModeCesiumWriter>> createAsShadowMode() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumShadowModeValuePropertyAdaptor<ShadowModeCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumShadowModeValuePropertyAdaptor<ShadowModeCesiumWriter>>(this, "createShadowMode") {
                    public cesiumlanguagewriter.advanced.CesiumShadowModeValuePropertyAdaptor<ShadowModeCesiumWriter> invoke() {
                        return createShadowMode();
                    }
                }, false);
    }

    private final CesiumShadowModeValuePropertyAdaptor<ShadowModeCesiumWriter> createShadowMode() {
        return CesiumValuePropertyAdaptors.<ShadowModeCesiumWriter> createShadowMode(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<ShadowModeCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<ShadowModeCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<ShadowModeCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<ShadowModeCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<ShadowModeCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<ShadowModeCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<ShadowModeCesiumWriter> createReference(this);
    }
}