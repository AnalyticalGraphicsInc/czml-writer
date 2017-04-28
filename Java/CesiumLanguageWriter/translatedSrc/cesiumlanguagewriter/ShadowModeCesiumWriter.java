package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumShadowMode;
import cesiumlanguagewriter.Reference;

/**
 *  
 Writes a {@code ShadowMode} to a {@link CesiumOutputStream}.  A {@code ShadowMode} is whether or not an object casts or receives shadows from each light source when shadows are enabled.
 

 */
public class ShadowModeCesiumWriter extends CesiumPropertyWriter<ShadowModeCesiumWriter> {
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
    private Lazy<ICesiumValuePropertyWriter<CesiumShadowMode>> m_asShadowMode;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    

    */
    public ShadowModeCesiumWriter(String propertyName) {
        super(propertyName);
        m_asShadowMode = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode>>(
                this, "createShadowModeAdaptor", new Class[] {}) {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode> invoke() {
                return createShadowModeAdaptor();
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
    protected ShadowModeCesiumWriter(ShadowModeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asShadowMode = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode>>(
                this, "createShadowModeAdaptor", new Class[] {}) {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumShadowMode> invoke() {
                return createShadowModeAdaptor();
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
    public ShadowModeCesiumWriter clone() {
        return new ShadowModeCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code shadowMode}, which is the shadow mode.
    
    

    * @param value The shadow mode.
    */
    public final void writeShadowMode(CesiumShadowMode value) {
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
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code ShadowMode} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumShadowMode> asShadowMode() {
        return m_asShadowMode.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumShadowMode> createShadowModeAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.ShadowModeCesiumWriter, cesiumlanguagewriter.CesiumShadowMode>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ShadowModeCesiumWriter, cesiumlanguagewriter.CesiumShadowMode>() {
                    public void invoke(ShadowModeCesiumWriter me, CesiumShadowMode value) {
                        me.writeShadowMode(value);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.ShadowModeCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ShadowModeCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(ShadowModeCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}