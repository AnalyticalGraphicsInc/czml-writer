package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code HorizontalOrigin} to a {@link CesiumOutputStream}. A {@code HorizontalOrigin} is the horizontal origin of an element, which can optionally vary over time. It controls whether the element is left-, center-, or right-aligned with the {@code position}.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class HorizontalOriginCesiumWriter extends CesiumPropertyWriter<HorizontalOriginCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumHorizontalOriginValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code horizontalOrigin} property.
    

    */
    public static final String HorizontalOriginPropertyName = "horizontalOrigin";
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
    private Lazy<CesiumHorizontalOriginValuePropertyAdaptor<HorizontalOriginCesiumWriter>> m_asHorizontalOrigin;
    private Lazy<CesiumReferenceValuePropertyAdaptor<HorizontalOriginCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public HorizontalOriginCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asHorizontalOrigin = createAsHorizontalOrigin();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected HorizontalOriginCesiumWriter(@Nonnull HorizontalOriginCesiumWriter existingInstance) {
        super(existingInstance);
        m_asHorizontalOrigin = createAsHorizontalOrigin();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public HorizontalOriginCesiumWriter clone() {
        return new HorizontalOriginCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code horizontalOrigin}, which is the horizontal origin.
    
    

    * @param value The horizontal origin.
    */
    public final void writeHorizontalOrigin(@Nonnull CesiumHorizontalOrigin value) {
        final String PropertyName = HorizontalOriginPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.horizontalOriginToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the horizontal origin specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the horizontal origin specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the horizontal origin specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the horizontal origin specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumHorizontalOriginValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumHorizontalOriginValuePropertyAdaptor<HorizontalOriginCesiumWriter> asHorizontalOrigin() {
        return m_asHorizontalOrigin.getValue();
    }

    private final Lazy<CesiumHorizontalOriginValuePropertyAdaptor<HorizontalOriginCesiumWriter>> createAsHorizontalOrigin() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumHorizontalOriginValuePropertyAdaptor<HorizontalOriginCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumHorizontalOriginValuePropertyAdaptor<HorizontalOriginCesiumWriter>>(this, "createHorizontalOrigin") {
                    public cesiumlanguagewriter.advanced.CesiumHorizontalOriginValuePropertyAdaptor<HorizontalOriginCesiumWriter> invoke() {
                        return createHorizontalOrigin();
                    }
                }, false);
    }

    private final CesiumHorizontalOriginValuePropertyAdaptor<HorizontalOriginCesiumWriter> createHorizontalOrigin() {
        return CesiumValuePropertyAdaptors.<HorizontalOriginCesiumWriter> createHorizontalOrigin(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<HorizontalOriginCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<HorizontalOriginCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<HorizontalOriginCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<HorizontalOriginCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<HorizontalOriginCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<HorizontalOriginCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<HorizontalOriginCesiumWriter> createReference(this);
    }
}