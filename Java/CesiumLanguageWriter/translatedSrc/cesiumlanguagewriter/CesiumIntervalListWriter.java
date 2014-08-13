package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a list of intervals for which a CZML property is defined.
 
 

 * @param <TPropertyWriter> The type used to represent the value of this property for a single interval.
 */
public class CesiumIntervalListWriter<TPropertyWriter extends CesiumPropertyWriter<TPropertyWriter>> extends CesiumElementWriter implements ICesiumIntervalListWriter {
	private TPropertyWriter m_propertyWriter;

	/**
	 *  
	Initializes a new instance.
	
	

	 * @param propertyWriter The instance used to write the value of this property for a single interval.
	 */
	public CesiumIntervalListWriter(TPropertyWriter propertyWriter) {
		m_propertyWriter = propertyWriter;
	}

	/**
	 *  
	Writes the start of a JSON sequence representing the interval list.
	

	 */
	@Override
	protected void onOpen() {
		getOutput().writeStartSequence();
	}

	/**
	 *  
	Writes the end of a JSON array representing the interval list. 
	

	 */
	@Override
	protected void onClose() {
		getOutput().writeEndSequence();
	}

	/**
	 *  
	Opens a writer to write information about a single interval.
	
	

	 * @return The interval writer.
	 */
	public final TPropertyWriter openInterval() {
		return m_propertyWriter.openInterval();
	}

	/**
	 *  
	Opens a writer to write information about a single interval.
	
	
	
	

	 * @param start The start of the interval of time covered by this interval element.
	 * @param stop The end of the interval of time covered by this interval element.
	 * @return The interval writer.
	 */
	public final TPropertyWriter openInterval(JulianDate start, JulianDate stop) {
		return m_propertyWriter.openInterval(start, stop);
	}
}