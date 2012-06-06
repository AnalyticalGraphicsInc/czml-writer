using System;
using System.Collections.Generic;
using System.Drawing;
using Shapefile;
using CesiumLanguageWriter;

namespace ShapefileToCesiumLanguage
{
    internal class Polyline : CzmlShape
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
        protected override void Write()
        {
            using (PositionListCesiumWriter position = this.PacketWriter.OpenVertexPositionsProperty())
            {
                PolylineShape polyline = (PolylineShape)m_shape;
                List<Cartographic> positions = new List<Cartographic>();
                for (int part = 0; part < polyline.Count; part++)
                {
                    for (int i = 0; i < polyline[part].Count; i++)
                    {
                        var pos = polyline[part][i];
                        positions.Add(new Cartographic(pos.X, pos.Y, 0.0));
                    }
                }
                position.WriteCartographicDegrees(positions);
            }

            using (PolylineCesiumWriter polyline = this.PacketWriter.OpenPolylineProperty())
            {
                polyline.WriteColorProperty(m_color);
            }
        }
    }
}
