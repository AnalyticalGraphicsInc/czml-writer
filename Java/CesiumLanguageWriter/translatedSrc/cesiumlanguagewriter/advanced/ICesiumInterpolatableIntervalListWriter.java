package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JWarning;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 An interface to an object that writes a list of intervals containing a specific type of value for a CZML property.
 

 */
@SuppressWarnings("unused")
public interface ICesiumInterpolatableIntervalListWriter<TValue> extends ICesiumIntervalListWriter {
    /**
    *  
    Opens a writer to write information about a single interval.
    
    

    * @return The interval writer.
    */
    @CS2JWarning("This method was originally marked 'new' in C#.")
    @Override
    @Nonnull
    ICesiumInterpolatableValuePropertyWriter<TValue> openInterval();

    /**
    *  
    Opens a writer to write information about a single interval.
    
    
    
    

    * @param start The start of the interval of time covered by this interval element.
    * @param stop The end of the interval of time covered by this interval element.
    * @return The interval writer.
    */
    @CS2JWarning("This method was originally marked 'new' in C#.")
    @Override
    @Nonnull
    ICesiumInterpolatableValuePropertyWriter<TValue> openInterval(JulianDate start, JulianDate stop);
}