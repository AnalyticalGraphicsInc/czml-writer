using System;
using System.Collections;
using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using GeometricComputations;
using Shapefile;

namespace ShapefileToCesiumLanguage
{
    public class Polygon : CzmlShape
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
            simplifiedRings = new List<ShapePart>();
        }
        
        /// <summary>
        /// Writes the polygon to its <see cref="CzmlDocument"/>. Each outer ring is joined to its inner rings
        /// to form a single polygon and is written as a separate czml packet.
        /// </summary>
        public override void Write()
        {
            PolygonShape polygon = (PolygonShape)m_shape;

            JoinInnerRings();

            for (int i = 0; i < simplifiedRings.Count; i++)
            {
                this.WritePacket(i);
            }
        }

        private void WritePacket(int index)
        {
            ShapePart part = simplifiedRings[index];

            using (PacketCesiumWriter packetWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                packetWriter.WriteId(Guid.NewGuid().ToString());

                using (PositionListCesiumWriter positionWriter = packetWriter.OpenVertexPositionsProperty())
                {
                    PolygonShape polygon = (PolygonShape)m_shape;
                    List<Cartographic> positions = new List<Cartographic>();
                    for (int i = 0; i < part.Count; i++)
                    {
                        var pos = part[i];
                        positions.Add(new Cartographic(pos.X, pos.Y, pos.Z));
                    }
                    positionWriter.WriteCartographicDegrees(positions);
                }

                using (PolygonCesiumWriter polygonWriter = packetWriter.OpenPolygonProperty())
                {
                    using (MaterialCesiumWriter materialWriter = polygonWriter.OpenMaterialProperty())
                    {
                        using (SolidColorMaterialCesiumWriter colorWriter = materialWriter.OpenSolidColorProperty())
                        {
                            colorWriter.WriteColorProperty(m_color);
                        }
                    }
                }
            }
        }

        private void JoinInnerRings()
        {
            PolygonShape polygon = (PolygonShape)m_shape;

            List<int> outerRingIndices = new List<int>();

            if (polygon.Count > 1)
            {
                List<CartographicExtent> ringExtents = new List<CartographicExtent>();
                for (int i = 0; i < polygon.Count; i++)
                {
                    double south, west, east, north;
                    south = north = polygon[i][0].Y;
                    west = east = polygon[i][0].X;
                    foreach (Cartesian point in polygon[i])
                    {
                        if (point.X > east)
                        {
                            east = point.X;
                        }
                        if (point.X < west)
                        {
                            east = point.X;
                        }
                        if (point.Y > north)
                        {
                            north = point.Y;
                        }
                        if (point.Y < south)
                        {
                            south = point.Y;
                        }
                    }
                    ringExtents.Add(new CartographicExtent(west, south, east, north));
                }

                for (int i = 0; i < ringExtents.Count; i++)
                {
                    for (int j = 0; j < ringExtents.Count; j++)
                    {
                        if (i != j && ringExtents[i].IsInsideExtent(ringExtents[j].EastLongitude, ringExtents[j].NorthLatitude))
                        {
                            outerRingIndices.Add(i);
                            break;
                        }
                    }
                }

                for (int i = 0; i < outerRingIndices.Count; i++)
                {
                    int outerRingIndex = outerRingIndices[i];
                    List<List<Cartesian>> innerRings = new List<List<Cartesian>>();
                    for (int j = 0; j < ringExtents.Count; j++)
                    {
                        if (outerRingIndex != j && ringExtents[outerRingIndex].IsInsideExtent(ringExtents[j].EastLongitude, ringExtents[j].NorthLatitude))
                        {
                            List<Cartesian> innerRing = new List<Cartesian>();
                            foreach (Cartesian point in polygon[j])
                            {
                                innerRing.Add(point);
                            }
                            innerRings.Add(innerRing);
                        }
                    }

                    List<Cartesian> outerRing = new List<Cartesian>();
                    foreach (Cartesian point in polygon[outerRingIndex])
                    {
                        outerRing.Add(point);
                    }

                    while (innerRings.Count > 0)
                    {
                        outerRing = PolygonAlgorithms.EliminateHole(outerRing, ref innerRings);
                    }

                    simplifiedRings.Add(new ShapePart(outerRing.ToArray(), 0, outerRing.Count));
                }
            }
            else
            {
                simplifiedRings.Add(polygon[0]);
            }
        }
        
        private List<ShapePart> simplifiedRings { get; set; }
    }
}
