package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 An interface to a writer that writes information about how to interpolate sampled values.
 

 */
public interface ICesiumInterpolationInformationWriter {
	/**
	 *  
	Writes the interpolation algorithm to use to interpolate the sampled data in this interval.
	
	

	 * @param interpolationAlgorithm The interpolation algorithm.
	 */
	void writeInterpolationAlgorithm(CesiumInterpolationAlgorithm interpolationAlgorithm);

	/**
	 *  
	Writes the degree of polynomial to use to interpolate sampled data in this interval.
	
	

	 * @param degree The degree.
	 */
	void writeInterpolationDegree(int degree);

	/**
	 *  
	Writes the type of extrapolation to perform when a value is requested at a time after any available samples.
	
	

	 * @param extrapolationType The extrapolation type.
	 */
	void writeForwardExtrapolationType(CesiumExtrapolationType extrapolationType);

	/**
	 *  
	Writes the amount of time to extrapolate forward before the property becomes undefined.  A value of 0 will extrapolate forever.
	
	

	 * @param duration The duration.
	 */
	void writeForwardExtrapolationDuration(Duration duration);

	/**
	 *  
	Writes the type of extrapolation to perform when a value is requested at a time before any available samples.
	
	

	 * @param extrapolationType The extrapolation type.
	 */
	void writeBackwardExtrapolationType(CesiumExtrapolationType extrapolationType);

	/**
	 *  
	Writes the amount of time to extrapolate backward before the property becomes undefined.  A value of 0 will extrapolate forever.
	
	

	 * @param duration The duration.
	 */
	void writeBackwardExtrapolationDuration(Duration duration);
}