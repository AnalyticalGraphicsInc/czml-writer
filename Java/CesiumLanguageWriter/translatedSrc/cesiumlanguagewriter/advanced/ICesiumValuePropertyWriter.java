package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 An interface to an object that writes the values of a CZML
 property with values over one or more intervals.
 
 

 * @param <T> The type written by the property writer.
 */
public interface ICesiumValuePropertyWriter<T> extends ICesiumPropertyWriter {
    /**
    *  
    Writes the value of the property for this interval of time.
    
    

    * @param value The value of the property.
    */
    void writeValue(T value);
}