package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code StripeOrientation} to a {@link CesiumOutputStream}. A {@code StripeOrientation} is the orientation of stripes in a stripe material.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class StripeOrientationCesiumWriter extends CesiumPropertyWriter<StripeOrientationCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumStripeOrientationValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code stripeOrientation} property.
    

    */
    public static final String StripeOrientationPropertyName = "stripeOrientation";
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
    private Lazy<CesiumStripeOrientationValuePropertyAdaptor<StripeOrientationCesiumWriter>> m_asStripeOrientation;
    private Lazy<CesiumReferenceValuePropertyAdaptor<StripeOrientationCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public StripeOrientationCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asStripeOrientation = createAsStripeOrientation();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected StripeOrientationCesiumWriter(@Nonnull StripeOrientationCesiumWriter existingInstance) {
        super(existingInstance);
        m_asStripeOrientation = createAsStripeOrientation();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public StripeOrientationCesiumWriter clone() {
        return new StripeOrientationCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code stripeOrientation}, which is the orientation of stripes in the stripe material.
    
    

    * @param value The orientation.
    */
    public final void writeStripeOrientation(@Nonnull CesiumStripeOrientation value) {
        final String PropertyName = StripeOrientationPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.stripeOrientationToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the orientation of stripes specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the orientation of stripes specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the orientation of stripes specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the orientation of stripes specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumStripeOrientationValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumStripeOrientationValuePropertyAdaptor<StripeOrientationCesiumWriter> asStripeOrientation() {
        return m_asStripeOrientation.getValue();
    }

    private final Lazy<CesiumStripeOrientationValuePropertyAdaptor<StripeOrientationCesiumWriter>> createAsStripeOrientation() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumStripeOrientationValuePropertyAdaptor<StripeOrientationCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumStripeOrientationValuePropertyAdaptor<StripeOrientationCesiumWriter>>(this, "createStripeOrientation") {
                    public cesiumlanguagewriter.advanced.CesiumStripeOrientationValuePropertyAdaptor<StripeOrientationCesiumWriter> invoke() {
                        return createStripeOrientation();
                    }
                }, false);
    }

    private final CesiumStripeOrientationValuePropertyAdaptor<StripeOrientationCesiumWriter> createStripeOrientation() {
        return CesiumValuePropertyAdaptors.<StripeOrientationCesiumWriter> createStripeOrientation(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<StripeOrientationCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<StripeOrientationCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<StripeOrientationCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<StripeOrientationCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<StripeOrientationCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<StripeOrientationCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<StripeOrientationCesiumWriter> createReference(this);
    }
}