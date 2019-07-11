package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A writer that can write a value as a list of lists of Cartographic WGS84 coordinates, where Longitude and Latitude are in degrees and Height is in meters.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumCartographicDegreesListOfListsValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    *  
    Writes the value expressed as a list of lists of Cartographic WGS84 coordinates, where Longitude and Latitude are in degrees and Height is in meters.
    
    

    * @param values The values.
    */
    void writeCartographicDegrees(Iterable<? extends Iterable<Cartographic>> values);
}