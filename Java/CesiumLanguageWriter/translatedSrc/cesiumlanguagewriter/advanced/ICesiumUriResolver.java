package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A URI resolver transforms URIs into another form for inclusion in a CZML document.
 For example,  {@link CachingCesiumUriResolver} downloads files and converts them to data URIs,
 while  {@link PassThroughCesiumUriResolver} leaves URIs unchanged.
 

 */
public interface ICesiumUriResolver {
    /**
    *  
    Resolves a URI, producing a new URI for inclusion in a CZML document.
    
    
    

    * @param uri The source URI.
    * @return A URI suitable for CZML.
    */
    String resolveUri(String uri);
}