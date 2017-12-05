package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 An interface to an object that writes a list of intervals for a CZML
 property.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumIntervalListWriter extends ICesiumElementWriter {
    /**
    *  
    Opens a writer to write information about a single interval.
    
    

    * @return The interval writer.
    */
    @Nonnull
    ICesiumPropertyWriter openInterval();

    /**
    *  
    Opens a writer to write information about a single interval.
    
    
    
    

    * @param start The start of the interval of time covered by this interval element.
    * @param stop The end of the interval of time covered by this interval element.
    * @return The interval writer.
    */
    @Nonnull
    ICesiumPropertyWriter openInterval(@Nonnull JulianDate start, @Nonnull JulianDate stop);
}