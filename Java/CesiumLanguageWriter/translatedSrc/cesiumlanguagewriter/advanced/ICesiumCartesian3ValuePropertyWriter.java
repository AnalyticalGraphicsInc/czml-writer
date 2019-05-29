package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as a three-dimensional Cartesian.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumCartesian3ValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    *  
    Writes the value expressed as a three-dimensional Cartesian value.
    
    

    * @param value The value.
    */
    void writeCartesian(@Nonnull Cartesian value);

    /**
    *  
    Writes the value expressed as a three-dimensional Cartesian value.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeCartesian(List<JulianDate> dates, List<Cartesian> values);

    /**
    *  
    Writes the value expressed as a three-dimensional Cartesian value.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeCartesian(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length);
}