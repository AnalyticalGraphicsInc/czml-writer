package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code LabelStyle} to a {@link CesiumOutputStream}. A {@code LabelStyle} is the style of a label.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class LabelStyleCesiumWriter extends CesiumPropertyWriter<LabelStyleCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumLabelStyleValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code labelStyle} property.
    

    */
    public static final String LabelStylePropertyName = "labelStyle";
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
    private Lazy<CesiumLabelStyleValuePropertyAdaptor<LabelStyleCesiumWriter>> m_asLabelStyle;
    private Lazy<CesiumReferenceValuePropertyAdaptor<LabelStyleCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public LabelStyleCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asLabelStyle = createAsLabelStyle();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected LabelStyleCesiumWriter(@Nonnull LabelStyleCesiumWriter existingInstance) {
        super(existingInstance);
        m_asLabelStyle = createAsLabelStyle();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public LabelStyleCesiumWriter clone() {
        return new LabelStyleCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code labelStyle}, which is the label style.
    
    

    * @param value The label style.
    */
    public final void writeLabelStyle(@Nonnull CesiumLabelStyle value) {
        final String PropertyName = LabelStylePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.labelStyleToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the label style specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the label style specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the label style specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the label style specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumLabelStyleValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumLabelStyleValuePropertyAdaptor<LabelStyleCesiumWriter> asLabelStyle() {
        return m_asLabelStyle.getValue();
    }

    private final Lazy<CesiumLabelStyleValuePropertyAdaptor<LabelStyleCesiumWriter>> createAsLabelStyle() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumLabelStyleValuePropertyAdaptor<LabelStyleCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumLabelStyleValuePropertyAdaptor<LabelStyleCesiumWriter>>(this, "createLabelStyle") {
                    public cesiumlanguagewriter.advanced.CesiumLabelStyleValuePropertyAdaptor<LabelStyleCesiumWriter> invoke() {
                        return createLabelStyle();
                    }
                }, false);
    }

    private final CesiumLabelStyleValuePropertyAdaptor<LabelStyleCesiumWriter> createLabelStyle() {
        return CesiumValuePropertyAdaptors.<LabelStyleCesiumWriter> createLabelStyle(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<LabelStyleCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<LabelStyleCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<LabelStyleCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<LabelStyleCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<LabelStyleCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<LabelStyleCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<LabelStyleCesiumWriter> createReference(this);
    }
}