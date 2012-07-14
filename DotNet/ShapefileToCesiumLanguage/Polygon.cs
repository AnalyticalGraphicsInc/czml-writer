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

                // Add new edges and vertices to each outer ring to eliminate holes and form a single polygon.
                for (int i = 0; i < this.OuterRingIndices.Count; i++)
                {
                    int outerRingIndex = this.OuterRingIndices[i];
                    List<int> innerRingIndices = new List<int>();
                    for (int j = 0; j < ringExtents.Count; j++)
                    {
                        if (outerRingIndex != j && ringExtents[outerRingIndex].IsInsideExtent(ringExtents[j].EastLongitude, ringExtents[j].NorthLatitude))
                        {
                            innerRingIndices.Add(j);
                        }
                    }

                    while (innerRingIndices.Count > 0)
                    {
                        int innerRingIndex;
                        Cartesian innerVertex;
                        Cartesian visibleVertex = this.findMutuallyVisibleVertex(outerRingIndex, innerRingIndices, out innerRingIndex, out innerVertex);

                        ShapePart innerRing = polygon[innerRingIndex];
                        ShapePart outerRing = polygon[outerRingIndex];

                        List<Cartesian> outerPositions = new List<Cartesian>();
                        for (int k = 0; k < outerRing.Count; k++)
                        {
                            if (outerRing[k].Equals(visibleVertex))
                            {
                                outerPositions.Add(visibleVertex);
                                int innerVertexIndex = 0;
                                for (int j = 0; j < innerRing.Count; j++)
                                {
                                    if (innerRing[j].Equals(innerVertex))
                                    {
                                        innerVertexIndex = j;
                                        break;
                                    }
                                }

                                // If the rightmost inner vertex is not the starting and ending point of the ring,
                                // then some other point is duplicated in the inner ring and should be skipped once.
                                if (innerVertexIndex != 0)
                                {
                                    for (int j = 0; j <= innerRing.Count; j++)
                                    {
                                        int index = (j + innerVertexIndex) % innerRing.Count;
                                        if (index != 0)
                                        {
                                            outerPositions.Add(innerRing[index]);
                                        }
                                    }
                                }
                                else
                                {
                                    for (int j = 0; j < innerRing.Count; j++)
                                    {
                                        outerPositions.Add(innerRing[(j + innerVertexIndex) % innerRing.Count]);
                                    }
                                }
                            }
                            outerPositions.Add(outerRing[k]);
                        }

                        polygon[outerRingIndex] = new ShapePart(outerPositions.ToArray(), 0, outerPositions.Count);
                        innerRingIndices.Remove(innerRingIndex);
                    }
                }
            }
            else
            {
                this.OuterRingIndices.Add(0);
            }
        }

        private Cartesian findMutuallyVisibleVertex(int outerRingIndex, List<int> innerRingIndices, out int innerRingIndex, out Cartesian innerVertex)
        {
            PolygonShape polygon = (PolygonShape)m_shape;
            ShapePart outerRing = polygon[outerRingIndex];

            // Let point k = the inner ring vertex with the maximum x-value.
            ShapePart innerRing = polygon[innerRingIndices[0]];
            Cartesian k = innerRing[0];
            double xMax = innerRing[0].X;
            innerRingIndex = innerRingIndices[0];
            for (int i = 0; i < innerRingIndices.Count; i++)
            {
                for (int j = 0; j < polygon[innerRingIndices[i]].Count; j++)
                {
                    if (polygon[innerRingIndices[i]][j].X > xMax)
                    {
                        xMax = polygon[innerRingIndices[i]][j].X;
                        k = polygon[innerRingIndices[i]][j];
                        innerRingIndex = innerRingIndices[i];
                        innerRing = polygon[innerRingIndices[i]];
                    }
                }
            }
            innerVertex = k;
          
            // Intersect K + t(1,0) with all edges of the outer ring
            // for which K is to the left of the line containing the edge.
            List<double> intersections = new List<double>();
            List<Cartesian[]> edges = new List<Cartesian[]>();
            for (int i = 0; i < outerRing.Count; i++)
            {
                Cartesian v1 = outerRing[i];
                Cartesian v2 = outerRing[(i + 1) % outerRing.Count];

                double m = (v2.Y - v1.Y) / (v2.X - v1.X);
                if (m != 0.0)
                {
                    double x = v1.X + (k.Y - v1.Y) / m;
                    if ((x >= k.X)) 
                    {
                        intersections.Add(x);
                        edges.Add(new Cartesian[] {v1, v2});
                    }
                }
            }

            // Let point l = the closest intersection.
            int minDistanceIndex = 0;
            double minDistance = intersections[0] - k.X;
            for (int i = 0; i < intersections.Count; i++)
            {
                double distance = intersections[i] - k.X;
                if (distance < minDistance)
                {
                    minDistance = distance;
                    minDistanceIndex = i;
                }
            }
            Cartesian l = new Cartesian(intersections[minDistanceIndex], k.Y, 0.0);

            // If l is a vertex point, we're done.
            for (int i = 0; i < outerRing.Count; i++)
            {
                if(outerRing[i].Equals(l))
                {
                    return outerRing[i];
                }
            }

            // Let point P = the endpoint of maximum x-value on the edge containing l.
            Cartesian[] edge = edges[minDistanceIndex];
            Cartesian p = (edge[0].X > edge[1].X) ? edge[0] : edge[1];

            List<Cartesian> reflexVertices = new List<Cartesian>();
            for (int i = 0; i < outerRing.Count; i++)
            {
                Cartesian p0 = outerRing[(i - 1 + outerRing.Count) % outerRing.Count];
                Cartesian p1 = outerRing[i];
                Cartesian p2 = outerRing[(i + 1) % outerRing.Count];

                Cartesian v0 = p0 - p1;
                Cartesian v1 = p2 - p1;

                Cartesian v0_perp = new Cartesian(-v0.Y, v0.X, 0.0);
                double angle = Math.Atan2(v0_perp.Dot(v1), v0.Dot(v1));     // Signed angle from v0 to v1
                double perpDotProduct = v0.Magnitude * v1.Magnitude * Math.Sin(angle);
                if (perpDotProduct < 0 && !p1.Equals(p))
                {
                    reflexVertices.Add(p1);
                }
            }

            List<Cartesian> pointsInside = new List<Cartesian>();
            foreach (Cartesian vertex in reflexVertices)
            {
                if(PolygonAlgorithms.IsPointInTriangle(k, l, p, vertex))
                {
                    pointsInside.Add(vertex);
                }
            }

            // If all reflexive vertices are outside the triangle formed by points k, l, and p, then p is the visible vertex.
            // Otherwise, return the reflex vertex that minimizes the angle between <1,0> and <k, reflex>.
            double minAngle = Math.PI;
            if (pointsInside.Count > 0)
            {
                Cartesian v1 = new Cartesian(1.0, 0.0, 0.0);
                for (int i = 0; i < pointsInside.Count; i++)
                {
                    Cartesian v2 = pointsInside[i] - k;
                    double angle = Math.Abs(Math.Acos(v1.Dot(v2) / (v1.Magnitude * v2.Magnitude)));
                    if (angle < minAngle)
                    {
                        minAngle = angle;
                        p = pointsInside[i];
                    }
                }
            }

            return p;    
        }
        
        private List<int> OuterRingIndices { get; set; }
    }
}
