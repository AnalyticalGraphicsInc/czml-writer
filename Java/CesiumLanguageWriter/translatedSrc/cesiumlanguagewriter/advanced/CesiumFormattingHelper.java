package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ConvertHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.HttpWebRequest;
import agi.foundation.compatibility.ImageFormat;
import agi.foundation.compatibility.ImageHelper;
import agi.foundation.compatibility.MemoryStream;
import agi.foundation.compatibility.StreamHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.WebRequest;
import agi.foundation.compatibility.WebResponse;
import cesiumlanguagewriter.*;
import java.awt.image.RenderedImage;
import java.io.InputStream;

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
	Downloads and converts a remote resource URL into a data URI in the form
	<code>data:<MimeType>;base64,<ImageData></code>, where
	<code><MimeType></code> is the MIME type of the specified resource, and
	<code><ImageData></code> is the data encoded as a Base 64 string.
	
	
	

	 * @param url The URL of the resource to convert.
	 * @return A data URI containing the content of the resource.
	 */
	public static String downloadUrlIntoDataUri(String url) {
		if (StringHelper.startsWith(url, "data:")) {
			return url;
		}
		WebRequest request = WebRequest.create(url);
		HttpWebRequest httpWebRequest = (request instanceof HttpWebRequest) ? (HttpWebRequest) request : null;
		if (httpWebRequest != null) {
			httpWebRequest.setUserAgent("CesiumWriter");
		}
		{
			WebResponse webResponse = request.getResponse();
			try {
				{
					InputStream responseStream = webResponse.getResponseStream();
					try {
						String mimeType = webResponse.getContentType();
						return buildDataUri(mimeType, responseStream);
					} finally {
						DisposeHelper.dispose(responseStream);
					}
				}
			} finally {
				DisposeHelper.dispose(webResponse);
			}
		}
	}

	/**
	 *  
	Reads from a stream containing an image into a data URI in the form
	<code>data:<MimeType>;base64,<ImageData></code>, where
	<code><MimeType></code> is the MIME type of the specified image format, and
	<code><ImageData></code> is the image data encoded as a Base 64 string.
	This method does not attempt to decode the image data, but simply writes it directly to the data URI.
	
	
	
	

	 * @param stream The stream containing the image to encode into a data URI.
	 * @param imageFormat The format of the image, which controls the mime type.
	 * @return A data URI containing the content of the image.
	 */
	public static String imageToDataUri(InputStream stream, CesiumImageFormat imageFormat) {
		String mimeType = getMimeTypeFromCesiumImageFormat(imageFormat);
		return buildDataUri(mimeType, stream);
	}

	/**
	 *  
	Converts an image to a data URI in the form
	<code>data:<MimeType>;base64,<ImageData></code>, where
	<code><MimeType></code> is the MIME type of the specified <code>image</code>, and
	<code><ImageData></code> is the image data encoded as a Base 64 string.
	
	
	
	

	 * @param image The image to convert.
	 * @param imageFormat The format of the image, which controls the mime type.
	 * @return A data URI containing the content of the image.
	 */
	public static String imageToDataUri(RenderedImage image, CesiumImageFormat imageFormat) {
		String mimeType = getMimeTypeFromCesiumImageFormat(imageFormat);
		{
			MemoryStream stream = new MemoryStream();
			try {
				ImageHelper.save(image, stream, cesiumImageFormatToImageFormat(imageFormat));
				stream.setPosition(0L);
				return buildDataUri(mimeType, stream);
			} finally {
				DisposeHelper.dispose(stream);
			}
		}
	}

	static private ImageFormat cesiumImageFormatToImageFormat(CesiumImageFormat imageFormat) {
		switch (imageFormat) {
		case JPEG:
			return ImageFormat.getJpeg();
		case PNG:
			return ImageFormat.getPng();
		case BMP:
			return ImageFormat.getBmp();
		case GIF:
			return ImageFormat.getGif();
		default:
			throw new ArgumentException(CesiumLocalization.getArgumentTypeInvalid(), "imageFormat");
		}
	}

	static private String buildDataUri(String mimeType, InputStream dataStream) {
		StringBuilder builder = new StringBuilder();
		builder.append("data:");
		builder.append(mimeType);
		builder.append(";base64,");
		{
			MemoryStream memoryStream = new MemoryStream();
			try {
				byte[] buffer = new byte[8192];
				int bytesRead;
				while ((bytesRead = StreamHelper.read(dataStream, buffer, 0, buffer.length)) > 0)
					memoryStream.write(buffer, 0, bytesRead);
				builder.append(ConvertHelper.toBase64String(memoryStream.getBuffer(), 0, (int) memoryStream.getLength()));
			} finally {
				DisposeHelper.dispose(memoryStream);
			}
		}
		return builder.toString();
	}

	static private String getMimeTypeFromCesiumImageFormat(CesiumImageFormat imageFormat) {
		switch (imageFormat) {
		case JPEG:
			return "image/jpeg";
		case PNG:
			return "image/png";
		case BMP:
			return "image/bmp";
		case GIF:
			return "image/gif";
		default:
			throw new ArgumentException(CesiumLocalization.getArgumentTypeInvalid(), "imageFormat");
		}
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