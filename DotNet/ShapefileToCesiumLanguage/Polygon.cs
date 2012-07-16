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
        }
        
        /// <summary>
        /// Writes the polygon to its <see cref="CzmlDocument"/>. Each outer ring is joined to its inner rings
        /// to form a single polygon and is written as a separate czml packet.
        /// </summary>
        public override void Write()
        {
            PolygonShape polygon = (PolygonShape)m_shape;

            this.joinInnerRings();

            for (int i = 0; i < this.OuterRingIndices.Count; i++)
            {
                this.WritePacket(this.OuterRingIndices[i]);
            }
        }

        private void WritePacket(int part)
        {
            using (PacketCesiumWriter packetWriter = m_document.CesiumStreamWriter.OpenPacket(m_document.CesiumOutputStream))
            {
                packetWriter.WriteId(Guid.NewGuid().ToString());

                using (PositionListCesiumWriter positionWriter = packetWriter.OpenVertexPositionsProperty())
                {
                    PolygonShape polygon = (PolygonShape)m_shape;
                    List<Cartographic> positions = new List<Cartographic>();
                    for (int i = 0; i < polygon[part].Count; i++)
                    {
                        var pos = polygon[part][i];
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

        private void joinInnerRings()
        {
            PolygonShape polygon = (PolygonShape)m_shape;

            this.OuterRingIndices = new List<int>();

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
                            this.OuterRingIndices.Add(i);
                            break;
                        }
                    }
                }

                for (int i = 0; i < this.OuterRingIndices.Count; i++)
                {
                    int outerRingIndex = this.OuterRingIndices[i];
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

                    while (innerRings.Count > 0)
                    {
                        List<Cartesian> outerRing = new List<Cartesian>();
                        foreach (Cartesian point in polygon[outerRingIndex])
                        {
                            outerRing.Add(point);
                        }
                        List<Cartesian> outerPositions = PolygonAlgorithms.EliminateHole(outerRing, ref innerRings);
                        polygon[outerRingIndex] = new ShapePart(outerPositions.ToArray(), 0, outerPositions.Count);
                    }
                }
            }
            else
            {
                this.OuterRingIndices.Add(0);
            }
        }
        
        private List<int> OuterRingIndices { get; set; }
    }
}
