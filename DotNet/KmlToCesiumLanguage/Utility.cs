using System;
using System.Drawing;
using System.IO;
using System.Net;
using CesiumLanguageWriter.Advanced;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System.Globalization;
using System.Linq;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// 
    /// </summary>
    static public class Utility
    {
        /// <summary>
        /// Converts the hex color string to a <see cref="System.Drawing.Color"/>
        /// </summary>
        /// <param name="hex">The hex string to convert.</param>
        /// <returns></returns>
        public static Color HexStringToColor(string hex)
        {
            hex = hex.ToLowerInvariant();
            if (hex.Length == 6)
            {
                hex = "ff" + hex;
            }
            else if (hex.Length != 8)
            {
                throw new Exception(hex + " is not a valid color code");
            }
            int a, r, g, b;
            //https://developers.google.com/kml/documentation/kmlreference#color
            a = Convert.ToInt32(hex.Substring(0, 2), 16);
            b = Convert.ToInt32(hex.Substring(2, 2), 16);
            g = Convert.ToInt32(hex.Substring(4, 2), 16);
            r = Convert.ToInt32(hex.Substring(6, 2), 16);
            return Color.FromArgb(a, r, g, b);
        }

        /// <summary>
        /// Writes the availability intervals from either the TimeSpan or TimeStamp elements from the kml document.
        /// </summary>
        /// <param name="timePrimitiveParentElement">The parent element that contains the kml TimePrimitive element.</param>
        /// <param name="packetWriter">The packet writer.</param>
        /// <param name="docNamespace">The namespace of the kml document.</param>
        public static void WriteAvailability(XElement timePrimitiveParentElement, PacketCesiumWriter packetWriter, XNamespace docNamespace)
        {
            TimeInterval interval = GetInterval(timePrimitiveParentElement, docNamespace);
            if (interval != null)
            {
                packetWriter.WriteAvailability(interval);
            }
        }

        /// <summary>
        /// Retrieves the Style element. This can either be the Style element contained in <paramref name="element"/> or a styleUrl element contained in <paramref name="element"/>.
        /// </summary>
        /// <param name="element">The element that contains the Style element or the styleUrl.</param>
        /// <param name="doc">The kml document.</param>
        /// <param name="docNamespace">The namespace of the kml document.</param>
        /// <returns></returns>
        public static XElement RetrieveStyleElement(XElement element, XDocument doc, XNamespace docNamespace)
        {
            XElement styleUrl = element.Element(docNamespace + "styleUrl");
            if (styleUrl != null)
            {
                string value = styleUrl.Value.Trim();
                if (value.StartsWith("#"))
                {
                    value = value.Substring(1);
                    var referredStyle = doc.Descendants().Where(o => o.Name == docNamespace + "Style").Where(o => (string)o.Attribute("id") == value).FirstOrDefault();
                    if (referredStyle != null)
                    {
                        return referredStyle;
                    }
                    else
                    {
                        referredStyle = doc.Descendants().Where(o => o.Name == docNamespace + "StyleMap").Where(o => (string)o.Attribute("id") == value).FirstOrDefault();
                        if (referredStyle != null)
                        {
                            styleUrl = referredStyle.Elements(docNamespace + "Pair").Where(o => o.Element(docNamespace + "key").Value == "normal").FirstOrDefault();
                            return RetrieveStyleElement(styleUrl, doc, docNamespace);
                        }
                    }
                }
            }
            return null;
        }

        private static TimeInterval GetInterval(XElement placemark, XNamespace docNamespace)
        {
            XElement timespan = placemark.Element(docNamespace + "TimeSpan");
            if (timespan != null)
            {
                return GetTimeSpan(timespan, docNamespace);
            }
            else
            {
                XElement timeStamp = placemark.Element(docNamespace + "TimeStamp");
                if (timeStamp != null)
                {
                    return GetTimeStamp(timeStamp, docNamespace);
                }
            }
            return null;
        }

        private static TimeInterval GetTimeSpan(XElement timespan, XNamespace docNamespace)
        {
            XElement beginElement = timespan.Element(docNamespace + "begin");
            JulianDate begin = new JulianDate(GregorianDate.MinValue);
            JulianDate end = new JulianDate(GregorianDate.MaxValue);
            if (beginElement != null)
            {
                GregorianDate beginDate;
                if (!GregorianDate.TryParse(beginElement.Value, out beginDate))
                {
                    beginDate = GregorianDate.ParseExact(beginElement.Value, s_validIso8601Formats, CultureInfo.CurrentCulture);
                }
                begin = new JulianDate(beginDate);
            }
            XElement endElement = timespan.Element(docNamespace + "end");
            if (endElement != null)
            {
                GregorianDate endDate;
                if (!GregorianDate.TryParse(endElement.Value, out endDate))
                {
                    endDate = GregorianDate.ParseExact(endElement.Value, s_validIso8601Formats, CultureInfo.CurrentCulture);
                }
                end = new JulianDate(endDate);
            }
            return new TimeInterval(begin, end);
        }

        private static TimeInterval GetTimeStamp(XElement timestamp, XNamespace docNamespace)
        {
            XElement whenElement = timestamp.Element(docNamespace + "when");
            if (whenElement != null)
            {
                GregorianDate whenDate;
                if (!GregorianDate.TryParse(whenElement.Value, out whenDate))
                {
                    whenDate = GregorianDate.ParseExact(whenElement.Value, s_validIso8601Formats, CultureInfo.CurrentCulture);
                }
                return new TimeInterval(new JulianDate(whenDate), new JulianDate(GregorianDate.MaxValue));
            }
            return null;
        }

        private static readonly string[] s_validIso8601Formats =
        new[]
                    {
                        "yyyy", 
                        "yyyy-MM", 
                        "yyyy-MM-dd"
                    };
    }
}
