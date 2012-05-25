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
        /// <param name="id">The <see cref="Series"/>'s ide</param>
        /// <param name="coordinates">An array of coordinate components. 
        /// e.g. [latitude, longitude, magnitude, latitude, longitude, magnitude, ... ] 
        /// where the latitude and longitude are given in degrees.</param>
        public Series(string id, double[] coordinates, CzmlDocument document)
        {
            if (coordinates.Length % 3 != 0)
            {
                throw new System.ArgumentException("coordinates must contain a multiple of 3 element", "coordinates");
            }
            
            m_id = id;
            m_document = document;            
            m_coordinates = new Cartographic[coordinates.Length / 3];

            for (int i = 0, j = 0; i < coordinates.Length; i+=3, j++)
            {
                m_coordinates[j] = new Cartographic(Constants.RadiansPerDegree * coordinates[i], 
                                                    Constants.RadiansPerDegree * coordinates[i+1],
                                                    coordinates[i+2]);
            }
        }

        /// <summary>
        /// Gets or sets the id.
        /// </summary>
        public string Id { get; set; }

        /// <summary>
        /// Gets the <see cref="Cartographic"/> array of coordinates.
        /// </summary>
        public Cartographic[] getCoordinates 
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
                        position.WriteCartographicRadiansValue(m_coordinates[index]);
                    }
                }
            }
        }

        private string m_id;
        private Cartographic[] m_coordinates;
        private CzmlDocument m_document;
    }
}