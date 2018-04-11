package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumStripeOrientation;
import cesiumlanguagewriter.Reference;
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
public class StripeOrientationCesiumWriter extends CesiumPropertyWriter<StripeOrientationCesiumWriter> {
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
    private Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>> m_asStripeOrientation;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public StripeOrientationCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asStripeOrientation = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(this, "createStripeOrientationAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation> invoke() {
                        return createStripeOrientationAdaptor();
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
    protected StripeOrientationCesiumWriter(@Nonnull StripeOrientationCesiumWriter existingInstance) {
        super(existingInstance);
        m_asStripeOrientation = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation>>(this, "createStripeOrientationAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumStripeOrientation> invoke() {
                        return createStripeOrientationAdaptor();
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
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code StripeOrientation} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumStripeOrientation> asStripeOrientation() {
        return m_asStripeOrientation.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumStripeOrientation> createStripeOrientationAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.StripeOrientationCesiumWriter, cesiumlanguagewriter.CesiumStripeOrientation>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.StripeOrientationCesiumWriter, cesiumlanguagewriter.CesiumStripeOrientation>() {
                    public void invoke(StripeOrientationCesiumWriter me, @Nonnull CesiumStripeOrientation value) {
                        me.writeStripeOrientation(value);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.StripeOrientationCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.StripeOrientationCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(StripeOrientationCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}