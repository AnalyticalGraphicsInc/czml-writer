using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Net;
using System.Text;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Contains static methods for formatting data for writing to a CZML stream.
    /// </summary>
    public static class CesiumFormattingHelper
    {
        static private JulianDate s_minimumGregorianDate = GregorianDate.MinValue.ToJulianDate();
        static private JulianDate s_maximumGregorianDate = GregorianDate.MaxValue.ToJulianDate();

        /// <summary>
        /// Converts a <see cref="TimeInterval"/> as an ISO8601 interval string.
        /// </summary>
        /// <param name="start">The start of the interval.</param>
        /// <param name="stop">The end of the interval.</param>
        /// <param name="format">The format to use.</param>
        /// <returns>The interval represented as an ISO8601 interval string.</returns>
        public static string ToIso8601Interval(JulianDate start, JulianDate stop, Iso8601Format format)
        {
            return ToIso8601(start, format) + "/" + ToIso8601(stop, format);
        }

        /// <summary>
        /// Converts a <see cref="TimeInterval"/> as an ISO8601 interval string.
        /// </summary>
        /// <param name="interval">The interval to convert.</param>
        /// <param name="format">The format to use.</param>
        /// <returns>The interval represented as an ISO8601 interval string.</returns>
        public static string ToIso8601Interval(TimeInterval interval, Iso8601Format format)
        {
            return ToIso8601Interval(interval.Start, interval.Stop, format);
        }

        /// <summary>
        /// Converts a <see cref="JulianDate"/> to an ISO8601 date string.
        /// </summary>
        /// <param name="date">The date to convert.</param>
        /// <param name="format">The format to use.</param>
        /// <returns>The date represented as an ISO8601 date string.</returns>
        public static string ToIso8601(JulianDate date, Iso8601Format format)
        {
            //If the JulianDate is outside the range of supported CZML values,
            //clamp it to the minimum/maximum CZML ISO8601 value.
            if (date <= s_minimumGregorianDate)
            {
                switch (format)
                {
                    case Iso8601Format.Basic:
                        return "00000101T000000Z";

                    case Iso8601Format.Compact:
                        return "00000101T00Z";

                    case Iso8601Format.Extended:
                        return "0000-01-01T00:00:00Z";
                }
            }
            if (date >= s_maximumGregorianDate)
            {
                switch (format)
                {
                    case Iso8601Format.Basic:
                        return "99991231T240000Z";

                    case Iso8601Format.Compact:
                        return "99991231T24Z";

                    case Iso8601Format.Extended:
                        return "9999-12-31T24:00:00Z";
                }
            }
            return date.ToGregorianDate().ToIso8601String(format);
        }

        /// <summary>
        /// Downloads and converts a remote resource URI into a data URI in the form
        /// <code>data:&lt;MimeType&gt;;base64,&lt;ImageData&gt;</code>, where
        /// <code>&lt;MimeType&gt;</code> is the MIME type of the specified resource, and
        /// <code>&lt;ImageData&gt;</code> is the data encoded as a Base 64 string.
        /// </summary>
        /// <param name="uri">The URI of the resource to convert.</param>
        /// <returns>A data URI containing the content of the resource.</returns>
        public static Uri DownloadUriIntoDataUri(Uri uri)
        {
            if (uri.Scheme == "data")
                return uri;

            WebRequest request = WebRequest.Create(uri);
            HttpWebRequest httpWebRequest = request as HttpWebRequest;
            if (httpWebRequest != null)
            {
                httpWebRequest.UserAgent = "CesiumWriter";
            }

            using (WebResponse webResponse = request.GetResponse())
            using (Stream responseStream = webResponse.GetResponseStream())
            {
                string mimeType = webResponse.ContentType;
                return BuildDataUri(mimeType, responseStream);
            }
        }

        /// <summary>
        /// Reads from a stream containing an image into a data URI in the form
        /// <code>data:&lt;MimeType&gt;;base64,&lt;ImageData&gt;</code>, where
        /// <code>&lt;MimeType&gt;</code> is the MIME type of the specified image format, and
        /// <code>&lt;ImageData&gt;</code> is the image data encoded as a Base 64 string.
        /// This method does not attempt to decode the image data, but simply writes it directly to the data URI.
        /// </summary>
        /// <param name="stream">The stream containing the image to encode into a data URI.</param>
        /// <param name="imageFormat">The format of the image, which controls the mime type.</param>
        /// <returns>A data URI containing the content of the image.</returns>
        public static Uri ImageToDataUri(Stream stream, CesiumImageFormat imageFormat)
        {
            string mimeType = GetMimeTypeFromCesiumImageFormat(imageFormat);
            return BuildDataUri(mimeType, stream);
        }

        /// <summary>
        /// Converts an image to a data URI in the form
        /// <code>data:&lt;MimeType&gt;;base64,&lt;ImageData&gt;</code>, where
        /// <code>&lt;MimeType&gt;</code> is the MIME type of the specified <paramref name="image"/>, and
        /// <code>&lt;ImageData&gt;</code> is the image data encoded as a Base 64 string.
        /// </summary>
        /// <param name="image">The image to convert.</param>
        /// <param name="imageFormat">The format of the image, which controls the mime type.</param>
        /// <returns>A data URI containing the content of the image.</returns>
        public static Uri ImageToDataUri(Image image, CesiumImageFormat imageFormat)
        {
            string mimeType = GetMimeTypeFromCesiumImageFormat(imageFormat);
            using (MemoryStream stream = new MemoryStream())
            {
                image.Save(stream, CesiumImageFormatToImageFormat(imageFormat));
                stream.Position = 0;
                return BuildDataUri(mimeType, stream);
            }
        }

        private static ImageFormat CesiumImageFormatToImageFormat(CesiumImageFormat imageFormat)
        {
            switch (imageFormat)
            {
                case CesiumImageFormat.Jpeg:
                    return ImageFormat.Jpeg;

                case CesiumImageFormat.Png:
                    return ImageFormat.Png;

                case CesiumImageFormat.Bmp:
                    return ImageFormat.Bmp;

                case CesiumImageFormat.Gif:
                    return ImageFormat.Gif;

                default:
                    throw new ArgumentException(CesiumLocalization.ArgumentTypeInvalid, "imageFormat");
            }
        }

        private static Uri BuildDataUri(string mimeType, Stream dataStream)
        {
            StringBuilder builder = new StringBuilder();
            builder.Append("data:");
            builder.Append(mimeType);
            builder.Append(";base64,");

            using (MemoryStream memoryStream = new MemoryStream())
            {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = dataStream.Read(buffer, 0, buffer.Length)) > 0)
                    memoryStream.Write(buffer, 0, bytesRead);

                builder.Append(Convert.ToBase64String(memoryStream.GetBuffer(), 0, (int)memoryStream.Length));
            }

            return new Uri(builder.ToString());
        }

        private static string GetMimeTypeFromCesiumImageFormat(CesiumImageFormat imageFormat)
        {
            switch (imageFormat)
            {
                case CesiumImageFormat.Jpeg:
                    return "image/jpeg";

                case CesiumImageFormat.Png:
                    return "image/png";

                case CesiumImageFormat.Bmp:
                    return "image/bmp";

                case CesiumImageFormat.Gif:
                    return "image/gif";

                default:
                    throw new ArgumentException(CesiumLocalization.ArgumentTypeInvalid, "imageFormat");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumStripeOrientation"/> to the corresponding string in a
        /// CZML stream.
        /// </summary>
        /// <param name="orientation">The orientation to convert.</param>
        /// <returns>The string representation of the specified <see cref="CesiumStripeOrientation"/>.</returns>
        public static string StripeOrientationToString(CesiumStripeOrientation orientation)
        {
            switch (orientation)
            {
                case CesiumStripeOrientation.Horizontal:
                    return "HORIZONTAL";

                case CesiumStripeOrientation.Vertical:
                    return "VERTICAL";

                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "orientation");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumHorizontalOrigin"/> to the corresponding string in a
        /// CZML stream.
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
        /// CZML stream.
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
        /// CZML stream.
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
        /// Converts a <see cref="CesiumExtrapolationType"/> to the corresponding string in a
        /// CZML stream.
        /// </summary>
        /// <param name="extrapolationType">The value to convert.</param>
        /// <returns>The string representing the specified <see cref="CesiumExtrapolationType"/>.</returns>
        public static string ExtrapolationTypeToString(CesiumExtrapolationType extrapolationType)
        {
            switch (extrapolationType)
            {
                case CesiumExtrapolationType.None:
                    return "NONE";

                case CesiumExtrapolationType.Hold:
                    return "HOLD";

                case CesiumExtrapolationType.Extrapolate:
                    return "EXTRAPOLATE";

                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "extrapolationType");
            }
        }

        /// <summary>
        /// Converts a <see cref="ClockRange"/> to the corresponding string in a
        /// CZML stream.
        /// </summary>
        /// <param name="clockRange">The label style to convert.</param>
        /// <returns>The string representing the specified <see cref="CesiumLabelStyle"/>.</returns>
        public static string ClockRangeToString(ClockRange clockRange)
        {
            switch (clockRange)
            {
                case ClockRange.Clamped:
                    return "CLAMPED";

                case ClockRange.Unbounded:
                    return "UNBOUNDED";

                case ClockRange.LoopStop:
                    return "LOOP_STOP";

                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "clockRange");
            }
        }

        /// <summary>
        /// Converts a <see cref="ClockStep"/> to the corresponding string in a
        /// CZML stream.
        /// </summary>
        /// <param name="clockStep">The label style to convert.</param>
        /// <returns>The string representing the specified <see cref="CesiumLabelStyle"/>.</returns>
        public static string ClockStepToString(ClockStep clockStep)
        {
            switch (clockStep)
            {
                case ClockStep.SystemClock:
                    return "SYSTEM_CLOCK";

                case ClockStep.SystemClockMultiplier:
                    return "SYSTEM_CLOCK_MULTIPLIER";

                case ClockStep.TickDependent:
                    return "TICK_DEPENDENT";

                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "clockStep");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumLabelStyle"/> to the corresponding string in a
        /// CZML stream.
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

        /// <summary>
        /// Converts a <see cref="CesiumLabelStyle"/> to the corresponding string in a
        /// CZML stream.
        /// </summary>
        /// <param name="portionToDisplay">The value to convert.</param>
        /// <returns>The string representing the specified <see cref="CesiumSensorVolumePortionToDisplay"/>.</returns>
        public static string SensorVolumePortionToDisplayToString(CesiumSensorVolumePortionToDisplay portionToDisplay)
        {
            switch (portionToDisplay)
            {
                case CesiumSensorVolumePortionToDisplay.Complete:
                    return "COMPLETE";

                case CesiumSensorVolumePortionToDisplay.AboveEllipsoidHorizon:
                    return "ABOVE_ELLIPSOID_HORIZON";

                case CesiumSensorVolumePortionToDisplay.BelowEllipsoidHorizon:
                    return "BELOW_ELLIPSOID_HORIZON";

                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "portionToDisplay");
            }
        }

        /// <summary>
        /// Returns a resolved url, using the given <see cref="CesiumResourceBehavior"/>.
        /// </summary>
        /// <param name="uri">The url of the resource.</param>
        /// <param name="resourceBehavior">A <see cref="CesiumResourceBehavior"/> specifying how include the resource into a CZML document.</param>
        /// <returns>The resolved url.</returns>
        public static Uri GetResourceUri(Uri uri, CesiumResourceBehavior resourceBehavior)
        {
            if (resourceBehavior == CesiumResourceBehavior.Embed)
                return CachingCesiumUriResolver.ThreadLocalInstance.ResolveUri(uri);

            return uri;
        }
    }
}