package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A URI resolver that leaves URIs unchanged.
 

 */
@SuppressWarnings("unused")
public class PassThroughCesiumUriResolver implements ICesiumUriResolver {
    private static PassThroughCesiumUriResolver s_instance = new PassThroughCesiumUriResolver();

    /**
    *  
    Resolves a URI, leaving it unchanged.
    
    
    

    * @param uri The source URI.
    * @return The same URI.
    */
    public final String resolveUri(String uri) {
        return uri;
    }

    /**
    *  
    A static instance of {@link PassThroughCesiumUriResolver} usable from any thread.
    

    */
    public static PassThroughCesiumUriResolver getInstance() {
        return s_instance;
    }
}