using System;
using System.Drawing;
using Shapefile;
using CesiumLanguageWriter;

namespace ShapefileToCesiumLanguage
{
    internal class Point : CzmlShape
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
        protected override void Write()
        {
            using (PositionCesiumWriter position = this.PacketWriter.OpenPositionProperty())
            {
                position.WriteCartographicDegrees(new Cartographic(((PointShape)m_shape).Position.X,
                                                                        ((PointShape)m_shape).Position.Y,
                                                                        0.0));
            }

            using (PointCesiumWriter point = this.PacketWriter.OpenPointProperty())
            {
                point.WriteColorProperty(m_color);
            }
        }
    }
}
