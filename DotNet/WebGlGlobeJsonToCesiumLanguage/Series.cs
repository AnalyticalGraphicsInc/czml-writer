using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CesiumLanguageWriter;

namespace WebGlGlobeJsonToCesiumLanguage
{
    public class Series
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Series"/> class.
        /// </summary>
        /// <param name="id">The ID of the <see cref="Series"/></param>
        /// <param name="coordinates">An array of <see cref="Cartographic"/> positions
        /// where the latitude and longitude are given in degrees.</param>
        public Series(string id, Cartographic[] coordinates, CzmlDocument document)
        {        
            m_id = id;
            m_document = document;            
            m_coordinates = (Cartographic[])coordinates.Clone();
        }

        /// <summary>
        /// Gets the ID.
        /// </summary>
        public string ID 
        {
            get { return m_id; } 
        }

        /// <summary>
        /// Gets the <see cref="Cartographic"/> array of coordinates.
        /// </summary>
        public Cartographic[] Coordinates 
        {
            get { return m_coordinates; } 
        }

        /// <summary>
        ///  Writes the CZML representation of the <see cref="Series"/>.
        ///  Each coordinate is in a separate packet with a unique identifier.
        /// </summary>
        public void Write()
        {
            for (int i = 0; i < m_coordinates.Length; i++)
            {
                WritePacket(i);
            }
        }

        /// <summary>
        /// Writes the czml packet of the given coordinate in the series.
        /// </summary>
        /// <param name="index">The index of the coordinate to write as a packet.</param>
        public void WritePacket(int index)
        {
            if (index < m_coordinates.Length)
            {
                using (CesiumPacketWriter packetWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
                {
                    packetWriter.WriteIdentifier(m_id + index);
                    using (PositionCesiumWriter position = packetWriter.OpenPositionProperty())
                    {
                        position.WriteCartographicDegreesValue(m_coordinates[index]);
                    }
                }
            }
        }

        private readonly string m_id;
        private readonly Cartographic[] m_coordinates;
        private readonly CzmlDocument m_document;
    }
}