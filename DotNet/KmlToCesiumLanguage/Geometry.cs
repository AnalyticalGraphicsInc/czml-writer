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
            this.PacketWriter = document.CesiumStreamWriter.OpenPacket(document.CesiumOutputStream);
        }

        public CesiumPacketWriter PacketWriter { get; private set; }

        public void AddTimeSpan(XElement placemark)
        {
            TimeInterval interval = GetInterval(placemark);
            if (interval != null)
            {
                this.PacketWriter.WriteAvailability(GetInterval(placemark));
            }
        }

        public void Close()
        {
            this.PacketWriter.Close();
        }

        public virtual void AddIconStyle(XElement styleElement) { }
        public virtual void AddPolyStyle(XElement polyElement) { }
        public virtual void AddLineStyle(XElement lineElement) { }

        protected CzmlDocument Document { get { return m_document; } }

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

        private CzmlDocument m_document;
    }
}
