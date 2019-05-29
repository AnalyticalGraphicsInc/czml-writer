package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.awt.image.RenderedImage;
import java.net.URI;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code Uri} to a {@link CesiumOutputStream}. A {@code Uri} is a URI value. The URI can optionally vary with time.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class UriCesiumWriter extends CesiumPropertyWriter<UriCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumUriValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code uri} property.
    

    */
    public static final String UriPropertyName = "uri";
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
    private Lazy<CesiumUriValuePropertyAdaptor<UriCesiumWriter>> m_asUri;
    private Lazy<CesiumReferenceValuePropertyAdaptor<UriCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public UriCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asUri = createAsUri();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected UriCesiumWriter(@Nonnull UriCesiumWriter existingInstance) {
        super(existingInstance);
        m_asUri = createAsUri();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public UriCesiumWriter clone() {
        return new UriCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the URI value.
    
    

    * @param resource A resource object describing external data.
    */
    public final void writeUri(CesiumResource resource) {
        writeUri(resource.getUri(), resource.getBehavior());
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the URI value.
    
    
    

    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeUri(URI uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        writeUri(uri.toString(), resourceBehavior);
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the URI value.
    
    
    

    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeUri(String uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        final String PropertyName = UriPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.getResourceUri(uri, resourceBehavior));
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the URI value.
    
    
    

    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeUri(URI uri, ICesiumUriResolver resolver) {
        writeUri(uri.toString(), resolver);
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the URI value.
    
    
    

    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeUri(String uri, ICesiumUriResolver resolver) {
        final String PropertyName = UriPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(resolver.resolveUri(uri));
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the URI value.
    
    

    * @param image The image. A data URI will be created for this image, using PNG encoding.
    */
    public final void writeUri(RenderedImage image) {
        writeUri(image, CesiumImageFormat.PNG);
    }

    /**
    *  
    Writes the value expressed as a {@code uri}, which is the URI value.
    
    
    

    * @param image The image. A data URI will be created for this image.
    * @param imageFormat The image format to use to encode the image in the data URI.
    */
    public final void writeUri(RenderedImage image, @Nonnull CesiumImageFormat imageFormat) {
        final String PropertyName = UriPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.imageToDataUri(image, imageFormat));
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the URI specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the URI specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the URI specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the URI specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumUriValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumUriValuePropertyAdaptor<UriCesiumWriter> asUri() {
        return m_asUri.getValue();
    }

    private final Lazy<CesiumUriValuePropertyAdaptor<UriCesiumWriter>> createAsUri() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumUriValuePropertyAdaptor<UriCesiumWriter>>(new Func1<cesiumlanguagewriter.advanced.CesiumUriValuePropertyAdaptor<UriCesiumWriter>>(this,
                "createUri") {
            public cesiumlanguagewriter.advanced.CesiumUriValuePropertyAdaptor<UriCesiumWriter> invoke() {
                return createUri();
            }
        }, false);
    }

    private final CesiumUriValuePropertyAdaptor<UriCesiumWriter> createUri() {
        return CesiumValuePropertyAdaptors.<UriCesiumWriter> createUri(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<UriCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<UriCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<UriCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<UriCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<UriCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<UriCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<UriCesiumWriter> createReference(this);
    }
}