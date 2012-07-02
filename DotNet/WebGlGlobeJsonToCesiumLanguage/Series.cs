using System;
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
        /// <param name="heightScalar">A value used to scale the magnitude of each coordinate's height.</param>
        /// <example>
        /// CzmlDocument document = new CzmlDocument();
        /// Cartographic[] positions = new Cartographic[] { new Cartographic(45.0, -90.0, 300), new Cartographic(50.0, -100.0, 400) };
        /// Series series = new Series("test", positions, document);
        /// </example>
        public Series(string id, Cartographic[] coordinatesDegrees, CzmlDocument document, double heightScalar = 1.0)
        {        
            m_id = id;
            m_document = document;
            m_coordinates = (Cartographic[])coordinatesDegrees.Clone();
            m_scalar = heightScalar;
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
        /// Gets the height scalar.
        /// </summary>
        public double Scalar
        {
            get { return m_scalar; }
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
                        polyline.WriteColorProperty(ColorFromHSV(0.6 - (m_coordinates[index].Height * 0.5), 1.0, 1.0));
                    }
                    using (PositionListCesiumWriter vertexPositions = packetWriter.OpenVertexPositionsProperty())
                    {
                        Cartographic[] positions = new Cartographic[] {
                            new Cartographic(m_coordinates[index].Longitude, m_coordinates[index].Latitude, 0.0),
                            new Cartographic(m_coordinates[index].Longitude, m_coordinates[index].Latitude, m_coordinates[index].Height * m_scalar)};
                        vertexPositions.WriteCartographicDegrees(positions);
                    }
                }
            }
        }

        private Color ColorFromHSV(double hue, double saturation, double value)
        {
            int i = Convert.ToInt32(Math.Floor(hue * 6));
            double f = hue * 6 - i;

            value = value * 255;
            int v = Convert.ToInt32(value);
            int p = Convert.ToInt32(value * (1 - saturation));
            int q = Convert.ToInt32(value * (1 - f * saturation));
            int t = Convert.ToInt32(value * (1 - (1 - f) * saturation));

            Color color = Color.Red;
            switch (i % 6)
            {
                case 0: color = Color.FromArgb(255, v, t, p); break;
                case 1: color = Color.FromArgb(255, q, v, p); break;
                case 2: color = Color.FromArgb(255, p, v, t); break;
                case 3: color = Color.FromArgb(255, p, q, v); break;
                case 4: color = Color.FromArgb(255, t, p, v); break;
                case 5: color = Color.FromArgb(255, v, p, q); break;
            }
            return color;
        }

        private readonly string m_id;
        private readonly Cartographic[] m_coordinates;
        private readonly CzmlDocument m_document;
        private readonly double m_scalar;
    }
}