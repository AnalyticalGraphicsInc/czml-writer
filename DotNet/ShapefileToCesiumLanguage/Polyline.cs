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
                this.WritePacket(part);
            }
        }

        /// <summary>
        /// Writes a new polyline packet for each part of the shape.
        /// </summary>
        /// <param name="part">The index of the part to write</param>
        private void WritePacket(int part)
        {
            using (this.PacketWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                this.PacketWriter.WriteId(Guid.NewGuid().ToString());
                using (PositionListCesiumWriter position = this.PacketWriter.OpenVertexPositionsProperty())
                {
                    PolylineShape polyline = (PolylineShape)m_shape;
                    List<Cartographic> positions = new List<Cartographic>();
                    for (int i = 0; i < polyline[part].Count; i++)
                    {
                        var pos = polyline[part][i];
                        positions.Add(new Cartographic(pos.X, pos.Y, pos.Z));
                    }
                    position.WriteCartographicDegrees(positions);
                }
                using (PolylineCesiumWriter polylineWriter = this.PacketWriter.OpenPolylineProperty())
                {
                    polylineWriter.WriteColorProperty(m_color);
                }
            }
        }
    }
}
