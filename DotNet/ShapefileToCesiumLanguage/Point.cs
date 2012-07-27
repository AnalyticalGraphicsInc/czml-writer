using System;
using System.Drawing;
using Shapefile;
using CesiumLanguageWriter;

namespace ShapefileToCesiumLanguage
{
    public class Point : CzmlShape
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Point"/> class.
        /// </summary>
        /// <param name="point">A PointShape object read from a shapefile.</param>
        /// <param name="document">The CzmlDocument to write to.</param>
        /// <param name="color">The points's color.</param>
        public Point(PointShape point, CzmlDocument document, Color color)
            : base(document, color)
        {
            m_shape = point;
        }

        /// <summary>
        /// Writes the point to its <see cref="CzmlDocument"/>.
        /// </summary>
        public override void Write()
        {
            using (PacketCesiumWriter packetWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                packetWriter.WriteId(Guid.NewGuid().ToString());
                PointShape point = (PointShape)m_shape;
                using (PositionCesiumWriter position = packetWriter.OpenPositionProperty())
                {
                    position.WriteCartographicRadians(point.Position);
                }

                using (PointCesiumWriter pointWriter = packetWriter.OpenPointProperty())
                {
                    pointWriter.WriteColorProperty(m_color);
                }
            }           
        }
    }
}
