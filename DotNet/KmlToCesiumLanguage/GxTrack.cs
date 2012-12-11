using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System.Drawing;
using System.Globalization;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// Describes how an object moves through the world over a given time period.
    /// </summary>
    public class GxTrack : Geometry
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="GxTrack"/> class.
        /// </summary>
        /// <param name="element">The element.</param>
        /// <param name="document">The document.</param>
        /// <param name="placemark">The placemark.</param>
        public GxTrack(XElement element, CzmlDocument document, XElement placemark)
            : base(document, placemark)
        {
            m_element = element;
            m_document = document;
            m_altitudeMode = "clampToGround";
            XElement altitudeMode = m_element.Element(m_document.Namespace + "altitudeMode");
            if (altitudeMode != null)
            {
                m_altitudeMode = altitudeMode.Value;
            }
            //ignoring gx:angles for now;
            //ignoring model for now;
            //and extended data. will be useful when we have popup support in czml
            m_when = m_element.Elements(m_document.Namespace+"when");
            m_positions = m_element.Elements( document.NamespaceDeclarations[Utility.GxPrefix] +  "coord");
        }

        /// <summary>
        /// Gets the position.
        /// </summary>
        /// <returns></returns>
        public IEnumerable<Cartographic> GetPositions()
        {
            return m_positions.Select(o => ToCartographicRadians(o.Value));
        }

        /// <summary>
        /// Gets the times associated with this track.
        /// </summary>
        /// <returns></returns>
        public IEnumerable<JulianDate> GetWhen()
        {
            return m_when.Select(o => ToJulianDate(o.Value));
        }

        /// <inheritdoc/>
        protected override void Write()
        {
            var when = GetWhen().ToList();
            PacketWriter.WriteAvailability(new TimeInterval(when[0], when[when.Count - 1]));
            using (var position = PacketWriter.OpenPositionProperty())
            {
                position.WriteCartographicRadians(when, GetPositions().ToList());
            }
        }

        /// <inheritdoc/>
        protected override void AddIconStyle(XElement iconElement)
        {
            using (var point = PacketWriter.OpenPointProperty())
            {
                point.WritePixelSizeProperty(5.0);
                XElement colorElement = iconElement.Element(Document.Namespace + "color");
                if (colorElement != null)
                {
                    Color color = Utility.HexStringToColor(colorElement.Value);
                    point.WriteColorProperty(color);
                }
                else
                {
                    point.WriteColorProperty(Color.Red);
                }
            }
        }

        private Cartographic ToCartographicRadians(string coord)
        {
            char[] separator = { ' ' };
            var coords = coord.Split(separator);
            var altitude = 0.0;
            if (m_altitudeMode == "absolute")
                altitude = double.Parse(coords[2]);
            return new Cartographic(double.Parse(coords[0]) * Constants.RadiansPerDegree, double.Parse(coords[1]) * Constants.RadiansPerDegree, altitude);
        }

        private JulianDate ToJulianDate(string when)
        {
            GregorianDate whenDate;
            if (!GregorianDate.TryParse(when, out whenDate))
            {
                whenDate = GregorianDate.ParseExact(when, Utility.ValidIso8601Formats, CultureInfo.CurrentCulture);
            }
            return new JulianDate(whenDate);
        }


        private XElement m_element;
        private IEnumerable<XElement> m_when;
        private IEnumerable<XElement> m_positions;
        private string m_altitudeMode;
        private CzmlDocument m_document;
    }
}
