package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 A writer that can write a value as a spherical.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumSphericalValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    *  
    Writes the value as a spherical value {@code [Clock, Cone, Magnitude]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    

    * @param value The value.
    */
    void writeSpherical(@Nonnull Spherical value);

    /**
    *  
    Writes the value as a spherical value {@code [Clock, Cone, Magnitude]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeSpherical(List<JulianDate> dates, List<Spherical> values);

    /**
    *  
    Writes the value as a spherical value {@code [Clock, Cone, Magnitude]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeSpherical(List<JulianDate> dates, List<Spherical> values, int startIndex, int length);
}