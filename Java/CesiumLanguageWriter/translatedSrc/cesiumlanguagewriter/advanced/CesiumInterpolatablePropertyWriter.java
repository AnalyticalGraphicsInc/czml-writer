package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 A <topic name="Cesium">Cesium</topic> writer for a property that represents a value that may be sampled
 and interpolated.  The property may be defined over a single interval or over multiple intervals.
 
 

 * @param <TDerived> The type of the class derived from this one.
 */
public abstract class CesiumInterpolatablePropertyWriter<TDerived extends CesiumInterpolatablePropertyWriter<TDerived>> extends CesiumPropertyWriter<TDerived> implements
		ICesiumInterpolationInformationWriter {
	/**
	 *  
	Initializes a new instance.
	
	

	 * @param propertyName The name of the property.
	 */
	public CesiumInterpolatablePropertyWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected CesiumInterpolatablePropertyWriter(CesiumInterpolatablePropertyWriter<TDerived> existingInstance) {
		super(existingInstance);
	}

	/**
	 *  
	Writes the interpolation algorithm to use to interpolate the sampled data in this interval.
	
	

	 * @param interpolationAlgorithm The interpolation algorithm.
	 */
	public final void writeInterpolationAlgorithm(CesiumInterpolationAlgorithm interpolationAlgorithm) {
		openIntervalIfNecessary();
		getOutput().writePropertyName("interpolationAlgorithm");
		getOutput().writeValue(CesiumFormattingHelper.interpolationAlgorithmToString(interpolationAlgorithm));
	}

	/**
	 *  
	Writes the degree of polynomial to use to interpolate sampled data in this interval.
	
	

	 * @param degree The degree.
	 */
	public final void writeInterpolationDegree(int degree) {
		openIntervalIfNecessary();
		getOutput().writePropertyName("interpolationDegree");
		getOutput().writeValue(degree);
	}
}