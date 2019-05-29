package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as a two-dimensional Cartesian.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumCartesian2ValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    *  
    Writes the value expressed as a two-dimensional Cartesian value.
    
    

    * @param value The value.
    */
    void writeCartesian2(@Nonnull Rectangular value);

    /**
    *  
    Writes the value expressed as a two-dimensional Cartesian value.
    
    
    

    * @param x The X component.
    * @param y The Y component.
    */
    void writeCartesian2(double x, double y);

    /**
    *  
    Writes the value expressed as a two-dimensional Cartesian value.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeCartesian2(List<JulianDate> dates, List<Rectangular> values);

    /**
    *  
    Writes the value expressed as a two-dimensional Cartesian value.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeCartesian2(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length);
}