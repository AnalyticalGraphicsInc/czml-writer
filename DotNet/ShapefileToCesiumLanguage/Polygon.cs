using System;
using System.Collections.Generic;
using System.Drawing;
using Shapefile;
using CesiumLanguageWriter;

namespace ShapefileToCesiumLanguage
{
    internal class Polygon : CzmlShape
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Polygon"/> class.
        /// </summary>
        /// <param name="polygon">A PolygonShape object read from a shapefile.</param>
        /// <param name="document">The CzmlDocument to write to.</param>
        /// <param name="color">The polygon's color.</param>
        public Polygon(PolygonShape polygon, CzmlDocument document, Color color)
            : base(document, color)
        {
            m_shape = polygon;
        }

        /// <summary>
        /// Writes the polygon to its <see cref="CzmlDocument"/>.
        /// </summary>
        protected override void Write()
        {
            using (PositionListCesiumWriter position = this.PacketWriter.OpenVertexPositionsProperty())
            {
                PolygonShape polygon = (PolygonShape)m_shape;
                List<Cartographic> positions = new List<Cartographic>();
                for (int part = 0; part < polygon.Count; part++)
                {
                    for (int i = 0; i < polygon[part].Count; i++)
                    {
                        var pos = polygon[part][i];
                        positions.Add(new Cartographic(pos.X, pos.Y, 0.0));
                    }
                }
                position.WriteCartographicDegrees(positions);
            }

            using (PolygonCesiumWriter polygon = this.PacketWriter.OpenPolygonProperty())
            {
                using ( MaterialCesiumWriter material = polygon.OpenMaterialProperty())
                {
                    using (SolidColorMaterialCesiumWriter color =  material.OpenSolidColorProperty()) 
                    {
                        color.WriteColorProperty(m_color);
                    }
                }
            }
        }
    }
}
