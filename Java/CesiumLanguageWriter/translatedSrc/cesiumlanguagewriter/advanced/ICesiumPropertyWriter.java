package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 An interface to an object that writes the values of a CZML
 property over one or more intervals.
 

 */
public interface ICesiumPropertyWriter extends ICesiumElementWriter {
	/**
	 *  
	Writes the actual interval of time covered by this CZML interval.
	
	
	

	 * @param start The start of the interval.
	 * @param stop The end of the interval.
	 */
	void writeInterval(JulianDate start, JulianDate stop);

	/**
	 *  
	Opens a writer that is used to write information about this property for a single interval.
	
	

	 * @return The writer.
	 */
	ICesiumPropertyWriter openInterval();

	/**
	 *  
	Opens a writer that is used to write information about this property for multiple discrete intervals.
	
	

	 * @return The writer.
	 */
	ICesiumIntervalListWriter openMultipleIntervals();

	/**
	 *  Gets a writer for intervals of this property.  The returned instance must be opened by calling
	the  {@link ICesiumElementWriter#open} method before it can be used for writing.  Consider
	calling the  {@link #openInterval} or  {@link #openMultipleIntervals} method, which will automatically
	open the writer, instead of accessing this property directly.
	

	 */
	ICesiumPropertyWriter getIntervalWriter();
}