package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;

/**
 *  
 An interface to a property that writes a sampled, interpolatable value.
 
 

 * @param <TValue> The type of the value.
 */
public interface ICesiumInterpolatableValuePropertyWriter<TValue> extends ICesiumValuePropertyWriter<TValue>, ICesiumInterpolationInformationWriter {
    /**
    *  
    Writes time-tagged samples for this property.  Clients will interpolate over the samples
    to determine the property value at a given time.  The {@code dates} need not all
    fall within the  {@link CesiumPropertyWriter#writeInterval(TimeInterval)}, because having samples
    outside the interval is often useful for interpolation.  However, the samples within an interval
    will never be used to determine the value within another interval.
    
    
    
    
    

    * @param dates The dates of the samples.  This collection must have the same number of elements as the {@code values} collection.
    * @param values The values corresponding to the {@code dates}.  This collection must have the same number of elements as the {@code dates} collection.
    * @param startIndex The first index in the collections to write.
    * @param length The number of elements from the collections to write.
    */
    void writeValue(List<JulianDate> dates, List<TValue> values, int startIndex, int length);
}