package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumHorizontalOrigin;
import cesiumlanguagewriter.Reference;
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
public class HorizontalOriginCesiumWriter extends CesiumPropertyWriter<HorizontalOriginCesiumWriter> {
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
    private Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>> m_asHorizontalOrigin;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public HorizontalOriginCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asHorizontalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(this, "createHorizontalOriginAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin> invoke() {
                        return createHorizontalOriginAdaptor();
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
    protected HorizontalOriginCesiumWriter(@Nonnull HorizontalOriginCesiumWriter existingInstance) {
        super(existingInstance);
        m_asHorizontalOrigin = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(this, "createHorizontalOriginAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHorizontalOrigin> invoke() {
                        return createHorizontalOriginAdaptor();
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
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code HorizontalOrigin} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumHorizontalOrigin> asHorizontalOrigin() {
        return m_asHorizontalOrigin.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumHorizontalOrigin> createHorizontalOriginAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.CesiumHorizontalOrigin>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.CesiumHorizontalOrigin>() {
                    public void invoke(HorizontalOriginCesiumWriter me, @Nonnull CesiumHorizontalOrigin value) {
                        me.writeHorizontalOrigin(value);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.HorizontalOriginCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(HorizontalOriginCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}