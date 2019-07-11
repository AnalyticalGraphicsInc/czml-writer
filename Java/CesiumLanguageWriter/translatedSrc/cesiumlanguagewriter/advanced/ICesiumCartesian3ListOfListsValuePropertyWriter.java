package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A writer that can write a value as a list of lists of three-dimensional Cartesian values.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumCartesian3ListOfListsValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    *  
    Writes the value as a list of lists of three-dimensional Cartesian values.
    
    

    * @param values The values.
    */
    void writeCartesian(Iterable<? extends Iterable<Cartesian>> values);
}