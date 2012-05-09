using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using CesiumLanguageWriter;
using System.Drawing;

namespace KmlToCesiumLanguage
{
    internal class Placemark
    {
        private XElement m_element;
        private CzmlDocument m_document;

        public Placemark(XElement placemark, CzmlDocument document)
        {
            m_document = document;
            m_element = placemark;
            var geometry = placemark.Descendants().Where(o => o.Name == document.Namespace + "Point" || o.Name == document.Namespace + "Polygon" || o.Name == document.Namespace + "LineString").Select(o => GeometryFactory.Create(o, document));
            foreach (var geo in geometry)
            {
                geo.AddTimeSpan(placemark);
                AddStyleInformation(geo);
                geo.Close();
            }
        }

        private void AddStyleInformation(Geometry geo)
        {
            XElement styleElement = m_element.Element(m_document.Namespace + "Style");
            if (styleElement == null)
            {
                styleElement = RetrieveStyleUrl(m_element, m_element.Document);
            }
            if (styleElement != null)
            {
                AddIconStyleInformation(geo, styleElement);
                AddLabelStyleInformation(geo, styleElement);
                AddLineStyleInformation(geo, styleElement);
                AddPolyStyleInformation(geo, styleElement);
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
                        referredStyle = m_element.Document.Descendants().Where(o => o.Name == m_document.Namespace + "StyleMap").Where(o => (string)o.Attribute("id") == value).FirstOrDefault();
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

        private void AddPolyStyleInformation(Geometry geo, XElement styleElement)
        {
            XElement polyElement = styleElement.Element(m_document.Namespace + "PolyStyle");
            if (polyElement != null)
            {
                geo.AddPolyStyle(polyElement);
            }
        }

        private void AddLineStyleInformation(Geometry geo, XElement styleElement)
        {
            XElement lineElement = styleElement.Element(m_document.Namespace + "LineStyle");
            if (lineElement != null)
            {
                geo.AddLineStyle(lineElement);
            }
        }

        private void AddLabelStyleInformation(Geometry geo, XElement styleElement)
        {
            XElement nameElement = m_element.Element(m_document.Namespace + "name");
            if (nameElement != null)
            {
                using (var label = geo.PacketWriter.OpenLabelProperty())
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

        private void AddIconStyleInformation(Geometry geo, XElement styleElement)
        {
            XElement iconElement = styleElement.Element(m_document.Namespace + "IconStyle");
            if (iconElement != null)
            {
                geo.AddIconStyle(iconElement);
            }
        }
    }
}
