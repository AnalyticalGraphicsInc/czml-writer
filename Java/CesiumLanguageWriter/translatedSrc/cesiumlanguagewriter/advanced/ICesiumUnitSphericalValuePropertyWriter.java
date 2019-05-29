package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as a unit spherical.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumUnitSphericalValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    *  
    Writes the value expressed as a unit spherical value.
    
    

    * @param value The value.
    */
    void writeUnitSpherical(@Nonnull UnitSpherical value);

    /**
    *  
    Writes the value expressed as a unit spherical value.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values);

    /**
    *  
    Writes the value expressed as a unit spherical value.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length);
}