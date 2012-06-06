package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import cesiumlanguagewriter.*;
import java.awt.image.RenderedImage;

/**
 *  
 Contains static methods for formatting data for writing to a <topic name="Cesium">Cesium</topic> stream.
 

 */
public final class CesiumFormattingHelper {
	private CesiumFormattingHelper() {}

	/**
	 *  
	Converts a  {@link TimeInterval} as an ISO8601 interval string.
	
	
	
	
	

	 * @param start The start of the interval.
	 * @param stop The end of the interval.
	 * @param format The format to use.
	 * @return The interval represented as an ISO8601 interval string.
	 */
	public static String toIso8601Interval(JulianDate start, JulianDate stop, Iso8601Format format) {
		return toIso8601(start, format) + "/" + toIso8601(stop, format);
	}

	/**
	 *  
	Converts a  {@link TimeInterval} as an ISO8601 interval string.
	
	
	
	

	 * @param interval The interval to convert.
	 * @param format The format to use.
	 * @return The interval represented as an ISO8601 interval string.
	 */
	public static String toIso8601Interval(TimeInterval interval, Iso8601Format format) {
		return toIso8601Interval(interval.getStart(), interval.getStop(), format);
	}

	/**
	 *  
	Converts a  {@link JulianDate} to an ISO8601 date string.
	
	
	
	

	 * @param date The date to convert.
	 * @param format The format to use.
	 * @return The date represented as an ISO8601 date string.
	 */
	public static String toIso8601(JulianDate date, Iso8601Format format) {
		return date.toGregorianDate().toIso8601String(format);
	}

	/**
	 *  
	Converts an image to a data URL in the form <code>date:<MimeType>;base64,<ImageData></code>,
	where <code><MimeType></code> is the MIME type of the specified <code>image</code>, and
	<code><ImageData></code> is the image data encoded as a Base 64 string.
	
	
	

	 * @param image The image to convert.
	 * @return A data URL containing the content of the image.
	 */
	public static String imageToDataUrl(RenderedImage image) {
		throw new UnsupportedOperationException();
	}

	/**
	 *  
	Converts a  {@link CesiumHorizontalOrigin} to the corresponding string in a
	<topic name="Cesium">Cesium</topic> stream.
	
	
	

	 * @param horizontalOrigin The horizontal origin to convert.
	 * @return The string representation of the specified  {@link CesiumHorizontalOrigin}.
	 */
	public static String horizontalOriginToString(CesiumHorizontalOrigin horizontalOrigin) {
		switch (horizontalOrigin) {
		case LEFT:
			return "LEFT";
		case CENTER:
			return "CENTER";
		case RIGHT:
			return "RIGHT";
		default:
			throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "horizontalOrigin");
		}
	}

	/**
	 *  
	Converts a  {@link CesiumVerticalOrigin} to the corresponding string in a
	<topic name="Cesium">Cesium</topic> stream.
	
	
	

	 * @param verticalOrigin The vertical origin to convert.
	 * @return The string representation of the specified  {@link CesiumVerticalOrigin}.
	 */
	public static String verticalOriginToString(CesiumVerticalOrigin verticalOrigin) {
		switch (verticalOrigin) {
		case BOTTOM:
			return "BOTTOM";
		case CENTER:
			return "CENTER";
		case TOP:
			return "TOP";
		default:
			throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "verticalOrigin");
		}
	}

	/**
	 *  
	Converts a  {@link CesiumInterpolationAlgorithm} to the corresponding string in a
	<topic name="Cesium">Cesium</topic> stream.
	
	
	

	 * @param interpolationAlgorithm The interpolation algorithm to convert.
	 * @return The string representing the specified  {@link CesiumInterpolationAlgorithm}.
	 */
	public static String interpolationAlgorithmToString(CesiumInterpolationAlgorithm interpolationAlgorithm) {
		switch (interpolationAlgorithm) {
		case LINEAR:
			return "LINEAR";
		case LAGRANGE:
			return "LAGRANGE";
		case HERMITE:
			return "HERMITE";
		default:
			throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "interpolationAlgorithm");
		}
	}

	/**
	 *  
	Converts a  {@link CesiumLabelStyle} to the corresponding string in a
	<topic name="Cesium">Cesium</topic> stream.
	
	
	

	 * @param labelStyle The label style to convert.
	 * @return The string representing the specified  {@link CesiumLabelStyle}.
	 */
	public static String labelStyleToString(CesiumLabelStyle labelStyle) {
		switch (labelStyle) {
		case FILL:
			return "FILL";
		case OUTLINE:
			return "OUTLINE";
		case FILL_AND_OUTLINE:
			return "FILL_AND_OUTLINE";
		default:
			throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "labelStyle");
		}
	}
}