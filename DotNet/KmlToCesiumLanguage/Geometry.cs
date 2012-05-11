using System;
using System.Drawing;
using System.Linq;
using System.Xml.Linq;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// This class provides a placeholder object for all derived Geometry objects.
    /// </summary>
    public abstract class Geometry
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Geometry"/> class.
        /// </summary>
        /// <param name="document">The document.</param>
        /// <param name="placemark">The placemark.</param>
        protected Geometry(CzmlDocument document, XElement placemark)
        {
            m_document = document;
            m_placemark = placemark;
        }

        /// <summary>
        /// Writes the czml packet of the Kml geometry.
        /// </summary>
        public void WritePacket()
        {
            using (this.PacketWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                this.PacketWriter.WriteIdentifier(Guid.NewGuid().ToString());
                this.AddTimeSpan(m_placemark);
                this.AddStyleInformation();
                this.Write();
            }
        }

        /// <summary>
        /// Writes the CZML representation of the particular Kml geometry.
        /// </summary>
        protected abstract void Write();

        /// <summary>
        /// Adds the information contained in the Kml IconStyle element to the <see cref="CesiumPacketWriter"/>.
        /// </summary>
        /// <param name="styleElement">The IconStyle element.</param>
        protected virtual void AddIconStyle(XElement styleElement) { }

        /// <summary>
        /// Adds the information contained in the Kml Polystyle element to the <see cref="CesiumPacketWriter"/>.
        /// </summary>
        /// <param name="polyElement">The PolyStyle element.</param>
        protected virtual void AddPolyStyle(XElement polyElement) { }

        /// <summary>
        /// Adds the information contained in the Kml Lolystyle element to the <see cref="CesiumPacketWriter"/>.
        /// </summary>
        /// <param name="lineElement">The LineStyle element.</param>
        protected virtual void AddLineStyle(XElement lineElement) { }

        /// <summary>
        /// Gets the document.
        /// </summary>
        protected CzmlDocument Document { get { return m_document; } }

        /// <summary>
        /// Gets the packet writer.
        /// </summary>
        protected CesiumPacketWriter PacketWriter { get; private set; }

        private void AddTimeSpan(XElement placemark)
        {
            TimeInterval interval = GetInterval(placemark);
            if (interval != null)
            {
                this.PacketWriter.WriteAvailability(interval);
            }
        }

        private TimeInterval GetInterval(XElement placemark)
        {
            XElement timespan = placemark.Element(Document.Namespace + "TimeSpan");
            if (timespan != null)
            {
                return GetTimeSpan(timespan);
            }
            else
            {
                XElement timeStamp = placemark.Element(Document.Namespace + "TimeStamp");
                if (timeStamp != null)
                {
                    return GetTimeStamp(timeStamp);
                }
            }
            return null;
        }

        private TimeInterval GetTimeSpan(XElement timespan)
        {
            XElement beginElement = timespan.Element(Document.Namespace + "begin");
            JulianDate begin =JulianDate.MinValue;
            JulianDate end = JulianDate.MaxValue;
            if (beginElement != null)
            {
                begin = new JulianDate(GregorianDate.Parse(beginElement.Value));
                if (m_document.MinimumTime == null || m_document.MinimumTime > begin)
                {
                    m_document.MinimumTime = begin;
                }
                if (m_document.MaximumTime == null || m_document.MaximumTime < begin)
                {
                    m_document.MaximumTime = begin;
                }
            }
            XElement endElement = timespan.Element(Document.Namespace + "end");
            if (endElement != null)
            {
                end = new JulianDate(GregorianDate.Parse(endElement.Value));

                if (m_document.MaximumTime == null || end > m_document.MaximumTime)
                {
                    m_document.MaximumTime = end;
                }
                if (m_document.MinimumTime == null || m_document.MinimumTime > end)
                {
                    m_document.MinimumTime = end;
                }
            }

            return new TimeInterval(begin, end);
        }

        private TimeInterval GetTimeStamp(XElement timestamp)
        {
            XElement whenElement = timestamp.Element(Document.Namespace + "when");
            if (whenElement != null)
            {
                JulianDate beginJulian = new JulianDate(GregorianDate.Parse(whenElement.Value));

                if (m_document.MinimumTime == null || m_document.MinimumTime > beginJulian)
                {
                    m_document.MinimumTime = beginJulian;
                }
                if (m_document.MaximumTime == null || m_document.MaximumTime < beginJulian)
                {
                    m_document.MaximumTime = beginJulian;
                }
                return new TimeInterval(beginJulian, JulianDate.MaxValue);
            }
            return null;
        }

        private void AddStyleInformation()
        {
            XElement styleElement = m_placemark.Element(m_document.Namespace + "Style");
            if (styleElement == null)
            {
                styleElement = RetrieveStyleUrl(m_placemark, m_placemark.Document);
            }
            AddLabelStyleInformation(styleElement);
            if (styleElement != null)
            {
                AddIconStyleInformation(styleElement);
                AddLineStyleInformation(styleElement);
                AddPolyStyleInformation(styleElement);
            }
        }

        private XElement RetrieveStyleUrl(XElement element, XDocument doc)
        {
            XElement styleUrl = element.Element(m_document.Namespace + "styleUrl");
            if (styleUrl != null)
            {
                string value = styleUrl.Value.Trim();
                if (value.StartsWith("#"))
                {
                    value = value.Substring(1);
                    var referredStyle = doc.Descendants().Where(o => o.Name == m_document.Namespace + "Style").Where(o => (string)o.Attribute("id") == value).FirstOrDefault();
                    if (referredStyle != null)
                    {
                        return referredStyle;
                    }
                    else
                    {
                        referredStyle = m_placemark.Document.Descendants().Where(o => o.Name == m_document.Namespace + "StyleMap").Where(o => (string)o.Attribute("id") == value).FirstOrDefault();
                        if (referredStyle != null)
                        {
                            styleUrl = referredStyle.Elements(m_document.Namespace + "Pair").Where(o => o.Element(m_document.Namespace + "key").Value == "normal").FirstOrDefault();
                            return RetrieveStyleUrl(styleUrl, doc);
                        }
                    }
                }
            }
            return null;
        }

        private void AddPolyStyleInformation(XElement styleElement)
        {
            XElement polyElement = styleElement.Element(m_document.Namespace + "PolyStyle");
            if (polyElement != null)
            {
                AddPolyStyle(polyElement);
            }
        }

        private void AddLineStyleInformation(XElement styleElement)
        {
            XElement lineElement = styleElement.Element(m_document.Namespace + "LineStyle");
            if (lineElement != null)
            {
                AddLineStyle(lineElement);
            }
        }

        private void AddLabelStyleInformation(XElement styleElement)
        {
            XElement nameElement = m_placemark.Element(m_document.Namespace + "name");
            if (nameElement != null)
            {
                using (var label = PacketWriter.OpenLabelProperty())
                {
                    label.WriteShowProperty(false);
                    label.WriteTextProperty(nameElement.Value);
                    if (styleElement != null)
                    {
                        XElement labelElement = styleElement.Element(m_document.Namespace + "LabelStyle");
                        if (labelElement != null)
                        {
                            XElement colorElement = labelElement.Element(m_document.Namespace + "color");
                            if (colorElement != null)
                            {
                                string hexColor = colorElement.Value;
                                Color color = ColorTranslator.FromHtml("#" + hexColor);
                                label.WriteFillColorProperty(color);
                            }
                            XElement scaleElement = labelElement.Element(m_document.Namespace + "scale");
                            if (scaleElement != null)
                            {
                                label.WriteScaleProperty(double.Parse(scaleElement.Value));
                            }
                        }
                    }
                }
            }
        }

        private void AddIconStyleInformation(XElement styleElement)
        {
            XElement iconElement = styleElement.Element(m_document.Namespace + "IconStyle");
            if (iconElement != null)
            {
                AddIconStyle(iconElement);
            }
        }

        private XElement m_placemark;
        private CzmlDocument m_document;
    }
}
