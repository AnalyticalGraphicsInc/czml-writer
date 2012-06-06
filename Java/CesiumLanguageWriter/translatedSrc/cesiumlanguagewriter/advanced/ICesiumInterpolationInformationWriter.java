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
}