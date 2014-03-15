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
    /// Used to combine multiple track elements into a single conceptual unit.
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
            m_altitudeMode = "clampToGround";
            m_document = document;
            XElement altitudeMode = m_element.Element(m_document.Namespace + "altitudeMode");
            if (altitudeMode != null)
            {
                m_altitudeMode = altitudeMode.Value;
            }
            m_gxTracks = m_element.Elements(document.NamespaceDeclarations[Utility.GxPrefix] +  "Track").Select(o=> new GxTrack(o, document, placemark, m_altitudeMode));
            
            XElement gxInterpolate = m_element.Element( document.NamespaceDeclarations[Utility.GxPrefix] +  "interpolate");
            m_interpolate = false;
            if (gxInterpolate != null)
            {
                m_interpolate = Utility.ParseBoolean(gxInterpolate);
            }
        }

        /// <summary>
        /// Writes the CZML representation of the particular Kml geometry.
        /// </summary>
        protected override void Write()
        {
            var timeInterval = GetAvailability(m_gxTracks);
            PacketWriter.WriteAvailability(timeInterval);
            foreach (var track in m_gxTracks)
            {
                var when = track.GetWhen().ToList(); ;
                var positions = track.GetPositions().ToList();
                using (var position = PacketWriter.OpenPositionProperty())
                {
                    position.WriteCartographicRadians(when, positions);
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
                billboard.WriteUriProperty(href, Document.ImageResolver);
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

        private TimeInterval GetAvailability(IEnumerable<GxTrack> tracks)
        {
            var list = new List<JulianDate>();
            foreach (var gxTrack in tracks)
            {
                list = list.Concat(gxTrack.GetWhen()).ToList();
            }
            return new TimeInterval(list[0], list[list.Count - 1]);
        }

        private readonly XElement m_element;
        private readonly CzmlDocument m_document;
        private IEnumerable<GxTrack> m_gxTracks;
        private readonly bool m_interpolate;
        private string m_altitudeMode;
    }
}
