using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.Drawing;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguage
{
    internal abstract class Geometry
    {
        protected Geometry(CzmlDocument document)
        {
            m_document = document;
        }

        public abstract Dictionary<string, object> Properties { get; }
        public abstract void AddProperty(object property);
        public abstract void AddTimeSpan(XElement placemark);

        public virtual void AddIconStyle(XElement styleElement)
        {
        }

        public virtual void AddPolyStyle(XElement polyElement) { }
        public virtual void AddLineStyle(XElement lineElement) { }
        public virtual void AddLabelStyle(XElement labelElement)
        {
            XElement colorElement = labelElement.Element(Document.Namespace + "color");
            if (colorElement != null)
            {
                string hexColor = colorElement.Value;
                Color color = ColorTranslator.FromHtml("#" + hexColor);
                //B and R intentionally switched
                AddProperty(new { name = "label_color", value = new { a = color.A, r = color.B, g = color.G, b = color.R } });
            }
            XElement scaleElement = labelElement.Element(Document.Namespace + "scale");
            if (scaleElement != null)
            {
                AddProperty(new { name = "label_scale", value = scaleElement.Value });
            }
        }

        protected CzmlDocument Document { get { return m_document; } }

        protected void InternalAddTimeSpan(string propertyName, XElement placemark)
        {
            XElement timespan = placemark.Element(Document.Namespace + "TimeSpan");
            if (timespan != null)
            {
                AddProperty(new { name = propertyName, intervals = GetIntervals(timespan) });
            }
            else
            {
                XElement timeStamp = placemark.Element(Document.Namespace + "TimeStamp");
                if (timeStamp != null)
                {
                    AddProperty(new { name = propertyName, intervals = GetTimeStamp(timeStamp) });
                }
                else
                {
                    AddProperty(new { name = propertyName, value = true });
                }
            }
        }

        private List<object> GetIntervals(XElement timespan)
        {
            XElement beginElement = timespan.Element(Document.Namespace + "begin");
            double startTotalDays = JulianDate.MinValue.TotalDays;
            double startSecondsOfDay = 0;
            double endTotalDays = JulianDate.MaxValue.TotalDays;
            double endSecondsOfDay = 0;
            if (beginElement != null)
            {
                JulianDate beginJulian = new JulianDate(GregorianDate.Parse(beginElement.Value));
                startTotalDays = beginJulian.Day;
                startSecondsOfDay = beginJulian.SecondsOfDay;
                if (m_document.MinimumTime == null || m_document.MinimumTime > beginJulian)
                {
                    m_document.MinimumTime = beginJulian;
                }
                if (m_document.MaximumTime == null || m_document.MaximumTime < beginJulian)
                {
                    m_document.MaximumTime = beginJulian;
                }
            }
            XElement endElement = timespan.Element(Document.Namespace + "end");
            if (endElement != null)
            {
                JulianDate endJulian = new JulianDate(GregorianDate.Parse(endElement.Value));
                endTotalDays = endJulian.Day;
                endSecondsOfDay = endJulian.SecondsOfDay;
                if (m_document.MaximumTime == null || endJulian > m_document.MaximumTime)
                {
                    m_document.MaximumTime = endJulian;
                }
                if (m_document.MinimumTime == null || m_document.MinimumTime > endJulian)
                {
                    m_document.MinimumTime = endJulian;
                }
            }

            return new List<object> { new 
                { start = new { day = startTotalDays, secondsOfDay = startSecondsOfDay }, 
                    stop = new { day = endTotalDays, secondsOfDay = endSecondsOfDay }, 
                    isStartIncluded = true, 
                    isStopIncluded = true, 
                    value = true 
                }
            };
        }

        private List<object> GetTimeStamp(XElement timestamp)
        {
            XElement whenElement = timestamp.Element(Document.Namespace + "when");
            double startTotalDays = JulianDate.MinValue.TotalDays;
            double startSecondsOfDay = 0;
            double endTotalDays = JulianDate.MaxValue.TotalDays;
            double endSecondsOfDay = 0;
            if (whenElement != null)
            {
                JulianDate beginJulian = new JulianDate(GregorianDate.Parse(whenElement.Value));
                startTotalDays = beginJulian.TotalDays;
                startSecondsOfDay = beginJulian.SecondsOfDay;
                if (m_document.MinimumTime == null || m_document.MinimumTime > beginJulian)
                {
                    m_document.MinimumTime = beginJulian;
                }
                if (m_document.MaximumTime == null || m_document.MaximumTime < beginJulian)
                {
                    m_document.MaximumTime = beginJulian;
                }
            }

            return new List<object> { new 
                { start = new { day = startTotalDays, secondsOfDay = startSecondsOfDay }, 
                    stop = new { day = endTotalDays, secondsOfDay = endSecondsOfDay }, 
                    isStartIncluded = true, 
                    isStopIncluded = true, 
                    value = true 
                }
            };
        }

        private CzmlDocument m_document;
    }
}
