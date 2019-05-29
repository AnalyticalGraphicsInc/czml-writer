package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as a part of a sensor to display.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumSensorVolumePortionToDisplayValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    *  
    Writes the value as a part of a sensor to display.
    
    

    * @param value The portion of the sensor to display.
    */
    void writePortionToDisplay(@Nonnull CesiumSensorVolumePortionToDisplay value);
}