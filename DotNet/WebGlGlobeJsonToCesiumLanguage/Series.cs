using System.Drawing;
using CesiumLanguageWriter;

namespace WebGLGlobeJsonToCesiumLanguage
{
    public class Series
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Series"/> class.
        /// </summary>
        /// <param name="id">The ID of the <see cref="Series"/></param>
        /// <param name="coordinatesDegrees">An array of <see cref="Cartographic"/> positions 
        /// where the latitude and longitude are given in degrees.</param>
        /// <param name="color">The color used to visually represent the series.</param>
        /// <example>
        /// CzmlDocument document = new CzmlDocument();
        /// Cartographic[] positions = new Cartographic[] { new Cartographic(45.0, -90.0, 300), new Cartographic(50.0, -100.0, 400) };
        /// Series series = new Series("test", positions, document);
        /// </example>
        public Series(string id, Cartographic[] coordinatesDegrees, CzmlDocument document, Color color)
        {        
            m_id = id;
            m_document = document;
            m_coordinates = (Cartographic[])coordinatesDegrees.Clone();
            m_color = color;
        }

        /// <summary>
        /// Gets the ID.
        /// </summary>
        public string ID 
        {
            get { return m_id; } 
        }

        /// <summary>
        /// Gets the <see cref="Cartographic"/> array of coordinates in degrees.
        /// </summary>
        public Cartographic[] CoordinatesDegrees 
        {
            get { return m_coordinates; } 
        }

        /// <summary>
        /// Gets the array of rgba color values.
        /// </summary>
        public Color Color
        {
            get { return m_color; }
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
                using (PacketCesiumWriter packetWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
                {
                    packetWriter.WriteId(m_id + index);
                    using (PolylineCesiumWriter polyline = packetWriter.OpenPolylineProperty())
                    {
                        polyline.WriteColorProperty(m_color);
                    }
                    using (PositionListCesiumWriter vertexPositions = packetWriter.OpenVertexPositionsProperty())
                    {
                        Cartographic[] positions = new Cartographic[] {
                            new Cartographic(m_coordinates[index].Longitude, m_coordinates[index].Latitude, 0.0),
                            m_coordinates[index] };
                        vertexPositions.WriteCartographicDegrees(positions);
                    }
                }
            }
        }

        private readonly string m_id;
        private readonly Cartographic[] m_coordinates;
        private readonly CzmlDocument m_document;
        private readonly Color m_color;
    }
}