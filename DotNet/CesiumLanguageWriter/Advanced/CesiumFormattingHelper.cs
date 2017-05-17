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
        private static readonly JulianDate s_minimumDate = GregorianDate.MinValue.ToJulianDate();
        private static readonly JulianDate s_maximumDate = GregorianDate.MaxValue.ToJulianDate();

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
            if (date <= s_minimumDate)
            {
                return GregorianDate.MinValue.ToIso8601String(format);
            }

            if (date >= s_maximumDate)
            {
                return GregorianDate.MaxValue.ToIso8601String(format);
            }

            return date.ToGregorianDate().ToIso8601String(format);
        }

        /// <summary>
        /// Downloads and converts a remote resource URI into a data URI in the form
        /// <c>data:&lt;MimeType&gt;;base64,&lt;ImageData&gt;</c>, where
        /// <c>&lt;MimeType&gt;</c> is the MIME type of the specified resource, and
        /// <c>&lt;ImageData&gt;</c> is the data encoded as a Base 64 string.
        /// </summary>
        /// <param name="uri">The URI of the resource to convert.</param>
        /// <returns>A data URI containing the content of the resource.</returns>
        public static string DownloadUriIntoDataUri(string uri)
        {
            if (uri.StartsWith("data:"))
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
        /// <c>data:&lt;MimeType&gt;;base64,&lt;ImageData&gt;</c>, where
        /// <c>&lt;MimeType&gt;</c> is the MIME type of the specified image format, and
        /// <c>&lt;ImageData&gt;</c> is the image data encoded as a Base 64 string.
        /// This method does not attempt to decode the image data, but simply writes it directly to the data URI.
        /// </summary>
        /// <param name="stream">The stream containing the image to encode into a data URI.</param>
        /// <param name="imageFormat">The format of the image, which controls the mime type.</param>
        /// <returns>A data URI containing the content of the image.</returns>
        public static string ImageToDataUri(Stream stream, CesiumImageFormat imageFormat)
        {
            string mimeType = GetMimeTypeFromCesiumImageFormat(imageFormat);
            return BuildDataUri(mimeType, stream);
        }

        /// <summary>
        /// Converts an image to a data URI in the form
        /// <c>data:&lt;MimeType&gt;;base64,&lt;ImageData&gt;</c>, where
        /// <c>&lt;MimeType&gt;</c> is the MIME type of the specified <paramref name="image"/>, and
        /// <c>&lt;ImageData&gt;</c> is the image data encoded as a Base 64 string.
        /// </summary>
        /// <param name="image">The image to convert.</param>
        /// <param name="imageFormat">The format of the image, which controls the mime type.</param>
        /// <returns>A data URI containing the content of the image.</returns>
        public static string ImageToDataUri(Image image, CesiumImageFormat imageFormat)
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

        private static string BuildDataUri(string mimeType, Stream dataStream)
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

            return builder.ToString();
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
        /// Converts a <see cref="CesiumStripeOrientation"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string StripeOrientationToString(CesiumStripeOrientation value)
        {
            switch (value)
            {
                case CesiumStripeOrientation.Horizontal:
                    return "HORIZONTAL";
                case CesiumStripeOrientation.Vertical:
                    return "VERTICAL";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumHorizontalOrigin"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string HorizontalOriginToString(CesiumHorizontalOrigin value)
        {
            switch (value)
            {
                case CesiumHorizontalOrigin.Left:
                    return "LEFT";
                case CesiumHorizontalOrigin.Center:
                    return "CENTER";
                case CesiumHorizontalOrigin.Right:
                    return "RIGHT";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumVerticalOrigin"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string VerticalOriginToString(CesiumVerticalOrigin value)
        {
            switch (value)
            {
                case CesiumVerticalOrigin.Bottom:
                    return "BOTTOM";
                case CesiumVerticalOrigin.Center:
                    return "CENTER";
                case CesiumVerticalOrigin.Top:
                    return "TOP";
                case CesiumVerticalOrigin.Baseline:
                    return "BASELINE";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumHeightReference"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string HeightReferenceToString(CesiumHeightReference value)
        {
            switch (value)
            {
                case CesiumHeightReference.None:
                    return "NONE";
                case CesiumHeightReference.ClampToGround:
                    return "CLAMP_TO_GROUND";
                case CesiumHeightReference.RelativeToGround:
                    return "RELATIVE_TO_GROUND";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumShadowMode"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string ShadowModeToString(CesiumShadowMode value)
        {
            switch (value)
            {
                case CesiumShadowMode.Disabled:
                    return "DISABLED";
                case CesiumShadowMode.Enabled:
                    return "ENABLED";
                case CesiumShadowMode.CastOnly:
                    return "CAST_ONLY";
                case CesiumShadowMode.ReceiveOnly:
                    return "RECEIVE_ONLY";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumInterpolationAlgorithm"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string InterpolationAlgorithmToString(CesiumInterpolationAlgorithm value)
        {
            switch (value)
            {
                case CesiumInterpolationAlgorithm.Linear:
                    return "LINEAR";
                case CesiumInterpolationAlgorithm.Lagrange:
                    return "LAGRANGE";
                case CesiumInterpolationAlgorithm.Hermite:
                    return "HERMITE";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumExtrapolationType"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string ExtrapolationTypeToString(CesiumExtrapolationType value)
        {
            switch (value)
            {
                case CesiumExtrapolationType.None:
                    return "NONE";
                case CesiumExtrapolationType.Hold:
                    return "HOLD";
                case CesiumExtrapolationType.Extrapolate:
                    return "EXTRAPOLATE";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="ClockRange"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string ClockRangeToString(ClockRange value)
        {
            switch (value)
            {
                case ClockRange.Clamped:
                    return "CLAMPED";
                case ClockRange.Unbounded:
                    return "UNBOUNDED";
                case ClockRange.LoopStop:
                    return "LOOP_STOP";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="ClockStep"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string ClockStepToString(ClockStep value)
        {
            switch (value)
            {
                case ClockStep.SystemClock:
                    return "SYSTEM_CLOCK";
                case ClockStep.SystemClockMultiplier:
                    return "SYSTEM_CLOCK_MULTIPLIER";
                case ClockStep.TickDependent:
                    return "TICK_DEPENDENT";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumLabelStyle"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string LabelStyleToString(CesiumLabelStyle value)
        {
            switch (value)
            {
                case CesiumLabelStyle.Fill:
                    return "FILL";
                case CesiumLabelStyle.Outline:
                    return "OUTLINE";
                case CesiumLabelStyle.FillAndOutline:
                    return "FILL_AND_OUTLINE";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumCornerType"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string CornerTypeToString(CesiumCornerType value)
        {
            switch (value)
            {
                case CesiumCornerType.Rounded:
                    return "ROUNDED";
                case CesiumCornerType.Mitered:
                    return "MITERED";
                case CesiumCornerType.Beveled:
                    return "BEVELED";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumColorBlendMode"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string ColorBlendModeToString(CesiumColorBlendMode value)
        {
            switch (value)
            {
                case CesiumColorBlendMode.Highlight:
                    return "HIGHLIGHT";
                case CesiumColorBlendMode.Replace:
                    return "REPLACE";
                case CesiumColorBlendMode.Mix:
                    return "MIX";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Converts a <see cref="CesiumSensorVolumePortionToDisplay"/> to the corresponding string in a CZML stream.
        /// </summary>
        /// <param name="value">The value to convert.</param>
        /// <returns>The string representing the specified value.</returns>
        public static string SensorVolumePortionToDisplayToString(CesiumSensorVolumePortionToDisplay value)
        {
            switch (value)
            {
                case CesiumSensorVolumePortionToDisplay.Complete:
                    return "COMPLETE";
                case CesiumSensorVolumePortionToDisplay.AboveEllipsoidHorizon:
                    return "ABOVE_ELLIPSOID_HORIZON";
                case CesiumSensorVolumePortionToDisplay.BelowEllipsoidHorizon:
                    return "BELOW_ELLIPSOID_HORIZON";
                default:
                    throw new ArgumentException(CesiumLocalization.UnknownEnumerationValue, "value");
            }
        }

        /// <summary>
        /// Returns a resolved url, using the given <see cref="CesiumResourceBehavior"/>.
        /// </summary>
        /// <param name="uri">The url of the resource.</param>
        /// <param name="resourceBehavior">A <see cref="CesiumResourceBehavior"/> specifying how include the resource into a CZML document.</param>
        /// <returns>The resolved url.</returns>
        public static string GetResourceUri(string uri, CesiumResourceBehavior resourceBehavior)
        {
            if (resourceBehavior == CesiumResourceBehavior.Embed)
                return CachingCesiumUriResolver.ThreadLocalInstance.ResolveUri(uri);

            return uri;
        }
    }
}