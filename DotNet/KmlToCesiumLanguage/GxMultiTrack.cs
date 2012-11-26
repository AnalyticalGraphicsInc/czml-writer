using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System.Globalization;
using System.Drawing;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// 
    /// </summary>
    public class GxMultiTrack : Geometry
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="GxMultiTrack"/> class.
        /// </summary>
        /// <param name="element">The element.</param>
        /// <param name="document">The document.</param>
        /// <param name="placemark">The placemark.</param>
        public GxMultiTrack(XElement element, CzmlDocument document, XElement placemark)
            : base(document, placemark)
        {
            m_element = element;
            m_gxTracks = m_element.Descendants().Where(o => o.GetNamespaceOfPrefix(Utility.GxPrefix) + "Track" == o.Name);
            m_document = document;
            //TODO. support altitudeMode, interpolate. also add GxTrack class and use it in this class.
            //GxTrack needs to support altitudeMode, when, coord, possibly gx:altitudeMode
            //move s_validIso8601Formats out of this class and use it from Utility class.
            //can't do anything with angles yet
            //or model
            //or extended data. will be useful when we have popup support in czml.
        }

        /// <summary>
        /// Writes the CZML representation of the particular Kml geometry.
        /// </summary>
        protected override void Write()
        {
            
            foreach (var gxTrack in m_gxTracks)
            {
                var gxPositions = gxTrack.Descendants().Where(o => o.GetNamespaceOfPrefix(Utility.GxPrefix) + "coord" == o.Name).Select(o => ToCartographicRadians(o.Value)).ToList();
                var when = gxTrack.Descendants().Where(o => o.Name == m_document.Namespace + "when").Select(o => ToJulianDate(o.Value)).ToList();
                PacketWriter.WriteAvailability(new TimeInterval(when[0], when[when.Count - 1]));
                using (PositionCesiumWriter position = PacketWriter.OpenPositionProperty())
                {
                    position.WriteCartographicRadians(when, gxPositions);
                }
                using (PointCesiumWriter point = PacketWriter.OpenPointProperty())
                {
                    point.WritePixelSizeProperty(5);
                    point.WriteColorProperty(Color.Yellow);
                }
            }
        }

        /// <inheritdoc/>
        protected override void AddIconStyle(XElement iconElement)
        {
            using (var billboard = PacketWriter.OpenBillboardProperty())
            {
                XElement scaleElement = iconElement.Element(Document.Namespace + "scale");
                if (scaleElement != null)
                    billboard.WriteScaleProperty(double.Parse(scaleElement.Value));
                
                string href = iconElement.Element(Document.Namespace + "Icon").Element(Document.Namespace + "href").Value;
                billboard.WriteImageProperty(href, Document.ImageResolver);
            }
        }

        /// <inheritdoc/>
        protected override void AddLineStyle(XElement lineElement)
        {
            using (var pathWriter = PacketWriter.OpenPathProperty())
            {
                XElement colorElement = lineElement.Element(Document.Namespace + "color");
                if (colorElement != null)
                {
                    Color color = Utility.HexStringToColor(colorElement.Value);
                    pathWriter.WriteColorProperty(color);
                }
                XElement widthElement = lineElement.Element(Document.Namespace + "width");
                if (widthElement != null)
                {
                    pathWriter.WriteWidthProperty(double.Parse(widthElement.Value));
                }
                pathWriter.WriteLeadTimeProperty(0);
            }
            
        }

        private Cartographic ToCartographicRadians(string coord)
        {
            char[] separator = { ' ' };
            var coords = coord.Split(separator);
            return new Cartographic(double.Parse(coords[0]) * Constants.RadiansPerDegree, double.Parse(coords[1]) * Constants.RadiansPerDegree, double.Parse(coords[2]));
        }

        private JulianDate ToJulianDate(string when)
        {
            GregorianDate whenDate;
            if (!GregorianDate.TryParse(when, out whenDate))
            {
                whenDate = GregorianDate.ParseExact(when, s_validIso8601Formats, CultureInfo.CurrentCulture);
            }
            return new JulianDate(whenDate);
        }

        private readonly XElement m_element;
        private readonly CzmlDocument m_document;
        private IEnumerable<XElement> m_gxTracks;
        private static readonly string[] s_validIso8601Formats =
        new[]
                    {
                        "yyyy", 
                        "yyyy-MM", 
                        "yyyy-MM-dd"
                    };
    }
}
