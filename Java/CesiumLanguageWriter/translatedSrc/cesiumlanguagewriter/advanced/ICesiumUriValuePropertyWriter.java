package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.awt.image.RenderedImage;
import java.net.URI;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as a URI.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumUriValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    *  
    Writes the value expressed as a URI.
    
    

    * @param resource A resource object describing external data.
    */
    void writeUri(CesiumResource resource);

    /**
    *  
    Writes the value expressed as a URI.
    
    
    

    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    void writeUri(URI uri, @Nonnull CesiumResourceBehavior resourceBehavior);

    /**
    *  
    Writes the value expressed as a URI.
    
    
    

    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    void writeUri(String uri, @Nonnull CesiumResourceBehavior resourceBehavior);

    /**
    *  
    Writes the value expressed as a URI.
    
    
    

    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    void writeUri(URI uri, ICesiumUriResolver resolver);

    /**
    *  
    Writes the value expressed as a URI.
    
    
    

    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    void writeUri(String uri, ICesiumUriResolver resolver);

    /**
    *  
    Writes the value expressed as a URI.
    
    

    * @param image The image. A data URI will be created for this image, using PNG encoding.
    */
    void writeUri(RenderedImage image);

    /**
    *  
    Writes the value expressed as a URI.
    
    
    

    * @param image The image. A data URI will be created for this image.
    * @param imageFormat The image format to use to encode the image in the data URI.
    */
    void writeUri(RenderedImage image, @Nonnull CesiumImageFormat imageFormat);
}