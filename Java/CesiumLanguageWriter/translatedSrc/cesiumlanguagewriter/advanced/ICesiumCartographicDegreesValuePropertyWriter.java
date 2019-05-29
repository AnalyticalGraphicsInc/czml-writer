package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as Cartographic WGS84 coordinates, where Longitude and Latitude are in degrees and Height is in meters.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumCartographicDegreesValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    *  
    Writes the value as Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    
    

    * @param value The interval.
    */
    void writeCartographicDegrees(@Nonnull Cartographic value);

    /**
    *  
    Writes the value as Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values);

    /**
    *  
    Writes the value as Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length);
}