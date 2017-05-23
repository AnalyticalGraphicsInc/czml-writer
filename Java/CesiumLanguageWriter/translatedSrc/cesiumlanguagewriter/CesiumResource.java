package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.image.RenderedImage;
import java.io.InputStream;
import java.net.URI;

/**
 *  
 A resource to be linked from or embedded into a CZML document.
 

 */
@SuppressWarnings("unused")
public class CesiumResource {
    private String m_uri;
    private CesiumResourceBehavior m_behavior = CesiumResourceBehavior.getDefault();

    /**
    *  
    Initializes a new instance.
    
    
    

    * @param uri The URI of the resource.
    * @param behavior The enumeration describing how the resource is to be included in the document.
    */
    public CesiumResource(URI uri, CesiumResourceBehavior behavior) {
        this(uri.toString(), behavior);
    }

    /**
    *  
    Initializes a new instance.
    
    
    

    * @param uri The URI of the resource.
    * @param behavior The enumeration describing how the resource is to be included in the document.
    */
    public CesiumResource(String uri, CesiumResourceBehavior behavior) {
        m_uri = uri;
        m_behavior = behavior;
    }

    /**
    *  Gets the URI of the resource.
    

    */
    public final String getUri() {
        return m_uri;
    }

    /**
    *  Gets how the resource is to be included in the document.
    

    */
    public final CesiumResourceBehavior getBehavior() {
        return m_behavior;
    }

    /**
    *  
    Create a CZML resource from an image loaded into memory.  The image data will 
    be embedded in the CZML document using a data URI.
    
    
    
    

    * @param image The image to write.
    * @param imageFormat The format of the image.
    * @return A new {@link CesiumResource} containing the image data as a data URI.
    */
    public static CesiumResource fromImage(RenderedImage image, CesiumImageFormat imageFormat) {
        String dataUri = CesiumFormattingHelper.imageToDataUri(image, imageFormat);
        return new CesiumResource(dataUri, CesiumResourceBehavior.EMBED);
    }

    /**
    *  
    Create a CZML resource from a stream containing image data.  The image data will 
    be embedded in the CZML document using a data URI.
    
    
    
    

    * @param stream The stream containing image data to write.
    * @param imageFormat The format of the image.
    * @return A new {@link CesiumResource} containing the image data as a data URI.
    */
    public static CesiumResource fromStream(InputStream stream, CesiumImageFormat imageFormat) {
        String dataUri = CesiumFormattingHelper.imageToDataUri(stream, imageFormat);
        return new CesiumResource(dataUri, CesiumResourceBehavior.EMBED);
    }

    /**
    *  
    Create a CZML resource from a stream.  The data will 
    be embedded in the CZML document using a data URI.
    
    
    
    

    * @param stream The stream containing data to write.
    * @param mimeType The mime type of the data.
    * @return A new {@link CesiumResource} containing the data as a data URI.
    */
    public static CesiumResource fromStream(InputStream stream, String mimeType) {
        String dataUri = CesiumFormattingHelper.streamToDataUri(stream, mimeType);
        return new CesiumResource(dataUri, CesiumResourceBehavior.EMBED);
    }
}