using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CesiumLanguageWriter;

namespace WebGLGlobeJsonToCesiumLanguage
{
    public class Series
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Series"/> class.
        /// </summary>
        /// <param name="id">The <see cref="Series"/>'s ide</param>
        /// <param name="coordinates">An array of <see cref="Cartographic"/> coordinates in radians.</param>
        /// <example>
        /// Cartographic[] coordinates = new Cartographic[] { new Cartographic(Constants.HalfPi, Constants.Pi, 1.0) };
        /// Series s = new Series("test", coordinates, new CzmlDocument());
        /// </example>
        public Series(string id, Cartographic[] coordinates, CzmlDocument document)
        {
            m_id = id;
            m_document = document;
            m_coordinates = (Cartographic[])coordinates.Clone();
        }

        /// <summary>
        /// Gets or sets the id.
        /// </summary>
        public string Id { get; set; }

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