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
            for (int i = 0; i < polyline.Count; i++)
            {
                ShapePart part = polyline[i];
                using (PacketCesiumWriter packetWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
                {
                    packetWriter.WriteId(Guid.NewGuid().ToString());
                    using (PolylineCesiumWriter polylineWriter = packetWriter.OpenPolylineProperty())
                    {
                        polylineWriter.WriteColorProperty(m_color);

                        List<Cartographic> positions = new List<Cartographic>();
                        for (int x = 0; x < part.Count; x++)
                        {
                            positions.Add(part[x]);
                        }
                        polylineWriter.WritePositionsPropertyCartographicRadians(positions);
                    }
                }
            }
        }
    }
}
