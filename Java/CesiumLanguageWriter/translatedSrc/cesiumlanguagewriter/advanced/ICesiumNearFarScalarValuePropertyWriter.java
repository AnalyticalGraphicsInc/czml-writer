package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumNearFarScalarValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    *  
    Writes the value expressed as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    
    

    * @param value The value.
    */
    void writeNearFarScalar(@Nonnull NearFarScalar value);

    /**
    *  
    Writes the value expressed as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    
    
    
    
    

    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    void writeNearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue);

    /**
    *  
    Writes the value expressed as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values);

    /**
    *  
    Writes the value expressed as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length);
}