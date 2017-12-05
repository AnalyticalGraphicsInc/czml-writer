package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumColorBlendMode;
import cesiumlanguagewriter.Reference;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code ColorBlendMode} to a {@link CesiumOutputStream}.  A {@code ColorBlendMode} is defines different modes for blending between a target color and an entity's source color.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class ColorBlendModeCesiumWriter extends CesiumPropertyWriter<ColorBlendModeCesiumWriter> {
    /**
    *  
    The name of the {@code colorBlendMode} property.
    

    */
    public static final String ColorBlendModePropertyName = "colorBlendMode";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumValuePropertyWriter<CesiumColorBlendMode>> m_asColorBlendMode;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    

    */
    public ColorBlendModeCesiumWriter(String propertyName) {
        super(propertyName);
        m_asColorBlendMode = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode>>(this, "createColorBlendModeAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode> invoke() {
                        return createColorBlendModeAdaptor();
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
    protected ColorBlendModeCesiumWriter(ColorBlendModeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asColorBlendMode = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode>>(this, "createColorBlendModeAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumColorBlendMode> invoke() {
                        return createColorBlendModeAdaptor();
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
    public ColorBlendModeCesiumWriter clone() {
        return new ColorBlendModeCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code colorBlendMode}, which is the color blend mode.
    
    

    * @param value The blend mode.
    */
    public final void writeColorBlendMode(@Nonnull CesiumColorBlendMode value) {
        final String PropertyName = ColorBlendModePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.colorBlendModeToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the color blend mode specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the color blend mode specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the color blend mode specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the color blend mode specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code ColorBlendMode} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumColorBlendMode> asColorBlendMode() {
        return m_asColorBlendMode.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumColorBlendMode> createColorBlendModeAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.ColorBlendModeCesiumWriter, cesiumlanguagewriter.CesiumColorBlendMode>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ColorBlendModeCesiumWriter, cesiumlanguagewriter.CesiumColorBlendMode>() {
                    public void invoke(ColorBlendModeCesiumWriter me, @Nonnull CesiumColorBlendMode value) {
                        me.writeColorBlendMode(value);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.ColorBlendModeCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.ColorBlendModeCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(ColorBlendModeCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}