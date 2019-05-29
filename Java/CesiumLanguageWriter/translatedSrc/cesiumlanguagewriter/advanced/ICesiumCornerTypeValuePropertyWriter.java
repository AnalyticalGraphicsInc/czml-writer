package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as a type of a corner.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumCornerTypeValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    *  
    Writes the value expressed as a corner type.
    
    

    * @param value The type of a corner.
    */
    void writeCornerType(@Nonnull CesiumCornerType value);
}