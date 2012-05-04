using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Text;
#if StkComponents
using AGI.Foundation.Time;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium.Advanced
#else
namespace CesiumLanguageWriter.Advanced
#endif
{
    /// <summary>
    /// Contains static methods for formatting data for writing to a <topic name="Cesium">Cesium</topic> stream.
    /// </summary>
    public static class CesiumFormattingHelper
    {
        /// <summary>
        /// Converts a <see cref="TimeInterval"/> as an ISO8601 interval string.
        /// </summary>
        /// <param name="start">The start of the interval.</param>
        /// <param name="stop">The end of the interval.</param>
        /// <returns>The interval represented as an ISO8601 interval string.</returns>
        public static string ToIso8601Interval(JulianDate start, JulianDate stop)
        {
            return ToIso8601(start) + "/" + ToIso8601(stop);
        }

#if StkComponents
        /// <summary>
        /// Converts a <see cref="TimeInterval"/> as an ISO8601 interval string.  The <see cref="TimeInterval.IsStartIncluded"/>
        /// and <see cref="TimeInterval.IsStopIncluded"/> properties of the interval are ignored.
        /// </summary>
        /// <param name="interval">The interval to convert.</param>
        /// <returns>The interval represented as an ISO8601 interval string.</returns>
        public static string ToIso8601Interval(TimeInterval interval)
        {
            return ToIso8601Interval(interval.Start, interval.Stop);
        }
#else
        /// <summary>
        /// Converts a <see cref="TimeInterval"/> as an ISO8601 interval string.
        /// </summary>
        /// <param name="interval">The interval to convert.</param>
        /// <returns>The interval represented as an ISO8601 interval string.</returns>
        public static string ToIso8601Interval(TimeInterval interval)
        {
            return ToIso8601Interval(interval.Start, interval.Stop);
        }
#endif

        /// <summary>
        /// Converts a <see cref="JulianDate"/> to an ISO8601 date string.
        /// </summary>
        /// <param name="date">The date to convert.</param>
        /// <returns>The date represented as an ISO8601 date string.</returns>
        public static string ToIso8601(JulianDate date)
        {
            return date.ToGregorianDate().ToIso8601String();
        }

        /// <summary>
        /// Converts an image to a data URL in the form <code>date:&lt;MimeType&gt;;base64,&lt;ImageData&gt;</code>,
        /// where <code>&lt;MimeType&gt;</code> is the MIME type of the specified <paramref name="imageFormat"/>, and
        /// <code>&lt;ImageData&gt;</code> is the image data encoded as a Base 64 string.
        /// </summary>
        /// <param name="image">The image to convert.</param>
        /// <param name="imageFormat">The format of image to encode in the data URL.</param>
        /// <returns>A data URL containing the content of the image.</returns>
        public static string ImageToDataUrl(Image image, CesiumImageFormat imageFormat)
        {
            ImageFormat format;
            string mimeType;
            switch (imageFormat)
            {
                case CesiumImageFormat.Png:
                    format = ImageFormat.Png;
                    mimeType = "image/png";
                    break;
                case CesiumImageFormat.Jpeg:
                    format = ImageFormat.Jpeg;
                    mimeType = "image/jpeg";
                    break;
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "imageFormat");
            }

            using (MemoryStream stream = new MemoryStream())
            {
                image.Save(stream, format);
                byte[] imageData = stream.GetBuffer();

                StringBuilder builder = new StringBuilder();
                builder.Append("data:");
                builder.Append(mimeType);
                builder.Append(";base64,");
                builder.Append(Convert.ToBase64String(imageData, Base64FormattingOptions.None));
                return builder.ToString();
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumHorizontalOrigin"/> to the corresponding string in a
        /// <topic name="Cesium">Cesium</topic> stream.
        /// </summary>
        /// <param name="horizontalOrigin">The horizontal origin to convert.</param>
        /// <returns>The string representation of the specified <see cref="CesiumHorizontalOrigin"/>.</returns>
        public static string HorizontalOriginToString(CesiumHorizontalOrigin horizontalOrigin)
        {
            switch (horizontalOrigin)
            {
                case CesiumHorizontalOrigin.Left:
                    return "LEFT";
                case CesiumHorizontalOrigin.Center:
                    return "CENTER";
                case CesiumHorizontalOrigin.Right:
                    return "RIGHT";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "horizontalOrigin");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumVerticalOrigin"/> to the corresponding string in a
        /// <topic name="Cesium">Cesium</topic> stream.
        /// </summary>
        /// <param name="verticalOrigin">The vertical origin to convert.</param>
        /// <returns>The string representation of the specified <see cref="CesiumVerticalOrigin"/>.</returns>
        public static string VerticalOriginToString(CesiumVerticalOrigin verticalOrigin)
        {
            switch (verticalOrigin)
            {
                case CesiumVerticalOrigin.Bottom:
                    return "BOTTOM";
                case CesiumVerticalOrigin.Center:
                    return "CENTER";
                case CesiumVerticalOrigin.Top:
                    return "TOP";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "verticalOrigin");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumInterpolationAlgorithm"/> to the corresponding string in a
        /// <topic name="Cesium">Cesium</topic> stream.
        /// </summary>
        /// <param name="interpolationAlgorithm">The interpolation algorithm to convert.</param>
        /// <returns>The string representing the specified <see cref="CesiumInterpolationAlgorithm"/>.</returns>
        public static string InterpolationAlgorithmToString(CesiumInterpolationAlgorithm interpolationAlgorithm)
        {
            switch (interpolationAlgorithm)
            {
                case CesiumInterpolationAlgorithm.Linear:
                    return "LINEAR";
                case CesiumInterpolationAlgorithm.Lagrange:
                    return "LAGRANGE";
                case CesiumInterpolationAlgorithm.Hermite:
                    return "HERMITE";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "interpolationAlgorithm");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumLabelStyle"/> to the corresponding string in a
        /// <topic name="Cesium">Cesium</topic> stream.
        /// </summary>
        /// <param name="labelStyle">The label style to convert.</param>
        /// <returns>The string representing the specified <see cref="CesiumLabelStyle"/>.</returns>
        public static string LabelStyleToString(CesiumLabelStyle labelStyle)
        {
            switch (labelStyle)
            {
                case CesiumLabelStyle.Fill:
                    return "FILL";
                case CesiumLabelStyle.Outline:
                    return "OUTLINE";
                case CesiumLabelStyle.FillAndOutline:
                    return "FILL_AND_OUTLINE";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "labelStyle");
            }
        }
    }
}
