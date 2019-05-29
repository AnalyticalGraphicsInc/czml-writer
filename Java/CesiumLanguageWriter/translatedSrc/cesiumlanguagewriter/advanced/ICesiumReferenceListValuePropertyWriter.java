package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A writer that can write a value as a list of references to other properties.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumReferenceListValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    *  
    Writes the value as a list of references.
    
    

    * @param references The list of references.
    */
    void writeReferences(Iterable<Reference> references);
}