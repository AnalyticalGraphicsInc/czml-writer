using System;
using System.Drawing;
using CesiumLanguageWriter;
using Shapefile;

namespace ShapefileToCesiumLanguage
{
    public class PointZ : Point
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="PointZ"/> class.
        /// </summary>
        /// <param name="point">A PointZShape object read from a shapefile.</param>
        /// <param name="document">The CzmlDocument to write to.</param>
        /// <param name="color">The point's color.</param>
        public PointZ(PointZShape point, CzmlDocument document, Color color)
            : base(point, document, color)
        {
        }

        /// <summary>
        /// Writes the point to its <see cref="CzmlDocument"/>.
        /// </summary>
        public override void Write()
        {
            using (this.PacketWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                this.PacketWriter.WriteId(Guid.NewGuid().ToString());
                PointZShape point = (PointZShape)m_shape;
                using (PositionCesiumWriter position = this.PacketWriter.OpenPositionProperty())
                {
                    position.WriteCartographicDegrees(new Cartographic(point.Position.X, point.Position.Y, point.Z));
                }

                using (PointCesiumWriter pointWriter = this.PacketWriter.OpenPointProperty())
                {
                    pointWriter.WriteColorProperty(m_color);
                }
            }            
        }
    }
}
