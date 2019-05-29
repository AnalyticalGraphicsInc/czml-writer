package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code Font} to a {@link CesiumOutputStream}. A {@code Font} is a font used to draw text. Fonts are specified using the same syntax as the CSS "font" property.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class FontCesiumWriter extends CesiumPropertyWriter<FontCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumFontValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code font} property.
    

    */
    public static final String FontPropertyName = "font";
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
    private Lazy<CesiumFontValuePropertyAdaptor<FontCesiumWriter>> m_asFont;
    private Lazy<CesiumReferenceValuePropertyAdaptor<FontCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public FontCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asFont = createAsFont();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected FontCesiumWriter(@Nonnull FontCesiumWriter existingInstance) {
        super(existingInstance);
        m_asFont = createAsFont();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public FontCesiumWriter clone() {
        return new FontCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code font}, which is the font, specified using the same syntax as the CSS "font" property.
    
    

    * @param font The font.
    */
    public final void writeFont(String font) {
        final String PropertyName = FontPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(font);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the font specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the font specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the font specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the font specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumFontValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumFontValuePropertyAdaptor<FontCesiumWriter> asFont() {
        return m_asFont.getValue();
    }

    private final Lazy<CesiumFontValuePropertyAdaptor<FontCesiumWriter>> createAsFont() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumFontValuePropertyAdaptor<FontCesiumWriter>>(new Func1<cesiumlanguagewriter.advanced.CesiumFontValuePropertyAdaptor<FontCesiumWriter>>(this,
                "createFont") {
            public cesiumlanguagewriter.advanced.CesiumFontValuePropertyAdaptor<FontCesiumWriter> invoke() {
                return createFont();
            }
        }, false);
    }

    private final CesiumFontValuePropertyAdaptor<FontCesiumWriter> createFont() {
        return CesiumValuePropertyAdaptors.<FontCesiumWriter> createFont(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<FontCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<FontCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<FontCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<FontCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<FontCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<FontCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<FontCesiumWriter> createReference(this);
    }
}