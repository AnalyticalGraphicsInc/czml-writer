using System;
using System.Drawing;
using System.Globalization;
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
                this.PacketWriter.WriteId(Guid.NewGuid().ToString());
                Utility.WriteAvailability(m_placemark, this.PacketWriter, m_document.Namespace);
                this.AddStyleInformation();
                this.Write();
            }
        }

        /// <summary>
        /// Writes the CZML representation of the particular Kml geometry.
        /// </summary>
        protected abstract void Write();

        /// <summary>
        /// Adds the information contained in the Kml IconStyle element to the <see cref="PacketCesiumWriter"/>.
        /// </summary>
        /// <param name="styleElement">The IconStyle element.</param>
        protected virtual void AddIconStyle(XElement styleElement) { }

        /// <summary>
        /// Adds the information contained in the Kml Polystyle element to the <see cref="PacketCesiumWriter"/>.
        /// </summary>
        /// <param name="polyElement">The PolyStyle element.</param>
        protected virtual void AddPolyStyle(XElement polyElement) { }

        /// <summary>
        /// Adds the information contained in the Kml Lolystyle element to the <see cref="PacketCesiumWriter"/>.
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
        protected PacketCesiumWriter PacketWriter { get; private set; }


        private void AddStyleInformation()
        {
            XElement styleElement = m_placemark.Element(m_document.Namespace + "Style");
            if (styleElement == null)
            {
                styleElement = Utility.RetrieveStyleElement(m_placemark, m_placemark.Document, m_document.Namespace);
            }
            AddLabelStyleInformation(styleElement);
            if (styleElement != null)
            {
                AddIconStyleInformation(styleElement);
                AddLineStyleInformation(styleElement);
                AddPolyStyleInformation(styleElement);
            }
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
                                Color color = Utility.HexStringToColor(colorElement.Value);
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
