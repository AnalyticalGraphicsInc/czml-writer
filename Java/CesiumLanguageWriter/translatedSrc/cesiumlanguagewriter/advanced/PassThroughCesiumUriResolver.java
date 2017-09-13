package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 A URI resolver that leaves URIs unchanged.
 

 */
@SuppressWarnings("unused")
public class PassThroughCesiumUriResolver implements ICesiumUriResolver {
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
    *  Gets a static instance of {@link PassThroughCesiumUriResolver} usable from any thread.
    

    */
    @Nonnull
    public static PassThroughCesiumUriResolver getInstance() {
        return s_instance;
    }

    @Nonnull
    private static PassThroughCesiumUriResolver s_instance = new PassThroughCesiumUriResolver();
}