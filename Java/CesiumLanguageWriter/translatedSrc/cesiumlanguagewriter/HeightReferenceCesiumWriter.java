package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CesiumHeightReference;
import cesiumlanguagewriter.Reference;

/**
 *  
 Writes a {@code HeightReference} to a  {@link CesiumOutputStream}.  A {@code HeightReference} is the height reference of an object, which indicates if the object's position is relative to terrain or not.
 

 */
public class HeightReferenceCesiumWriter extends CesiumPropertyWriter<HeightReferenceCesiumWriter> {
    /**
    *  
    The name of the {@code heightReference} property.
    

    */
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumValuePropertyWriter<CesiumHeightReference>> m_asHeightReference;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    

    */
    public HeightReferenceCesiumWriter(String propertyName) {
        super(propertyName);
        m_asHeightReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference>>(this, "createHeightReferenceAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference> invoke() {
                        return createHeightReferenceAdaptor();
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
    protected HeightReferenceCesiumWriter(HeightReferenceCesiumWriter existingInstance) {
        super(existingInstance);
        m_asHeightReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference>>(this, "createHeightReferenceAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<CesiumHeightReference> invoke() {
                        return createHeightReferenceAdaptor();
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
    public HeightReferenceCesiumWriter clone() {
        return new HeightReferenceCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code heightReference}, which is the height reference.
    
    

    * @param value The height reference.
    */
    public final void writeHeightReference(CesiumHeightReference value) {
        final String PropertyName = HeightReferencePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.heightReferenceToString(value));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the height reference specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the height reference specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the height reference specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the height reference specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in {@code HeightReference} format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<CesiumHeightReference> asHeightReference() {
        return m_asHeightReference.getValue();
    }

    private final ICesiumValuePropertyWriter<CesiumHeightReference> createHeightReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.HeightReferenceCesiumWriter, cesiumlanguagewriter.CesiumHeightReference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.HeightReferenceCesiumWriter, cesiumlanguagewriter.CesiumHeightReference>() {
                    public void invoke(HeightReferenceCesiumWriter me, CesiumHeightReference value) {
                        me.writeHeightReference(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements  {@link ICesiumValuePropertyWriter} to write a value in {@code Reference} format.  Because the returned instance is a wrapper for this instance, you may call  {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Reference> asReference() {
        return m_asReference.getValue();
    }

    private final ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.HeightReferenceCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.HeightReferenceCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(HeightReferenceCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}