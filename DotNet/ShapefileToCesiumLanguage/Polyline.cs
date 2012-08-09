using System;
using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using Shapefile;

namespace ShapefileToCesiumLanguage
{
    public class Polyline : CzmlShape
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Polyline"/> class.
        /// </summary>
        /// <param name="polyline">A PolylineShape object read from a shapefile.</param>
        /// <param name="document">The CzmlDocument to write to.</param>
        /// <param name="color">The polyline's color.</param>
        public Polyline(PolylineShape polyline, CzmlDocument document, Color color)
            : base(document, color)
        {
            m_shape = polyline;
        }

        /// <summary>
        /// Writes the polyline to its <see cref="CzmlDocument"/>.
        /// </summary>
        public override void Write()
        {
            PolylineShape polyline = (PolylineShape)m_shape;
            for (int part = 0; part < polyline.Count; part++)
            {
                this.WritePacket(polyline[part]);
            }
        }

        /// <summary>
        /// Writes a new polyline packet for each part of the shape.
        /// </summary>
        /// <param name="part">The <see cref="ShapePart"/> of the <see cref="PolylineShape"/> to write</param>
        private void WritePacket(ShapePart part)
        {
            using (PacketCesiumWriter packetWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                packetWriter.WriteId(Guid.NewGuid().ToString());
                using (PositionListCesiumWriter position = packetWriter.OpenVertexPositionsProperty())
                {
                    PolylineShape polyline = (PolylineShape)m_shape;
                    List<Cartographic> positions = new List<Cartographic>();
                    for (int i = 0; i < part.Count; i++)
                    {
                        positions.Add(part[i]);
                    }
                    position.WriteCartographicRadians(positions);
                }
                using (PolylineCesiumWriter polylineWriter = packetWriter.OpenPolylineProperty())
                {
                    polylineWriter.WriteColorProperty(m_color);
                }
            }
        }
    }
}
