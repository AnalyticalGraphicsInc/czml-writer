using System;
using System.Collections.Generic;
using System.Linq;
using CesiumLanguageWriter;

namespace GeometricComputations
{
    /// <summary>
    /// A class containing methods for manipulating polygons, including simplifying polygons with holes.
    /// </summary>
    public static class PolygonAlgorithms
    {
        /// <summary>
        /// Determines if a given point lies inside or on the boundary of the triangle formed by three points.
        /// </summary>
        /// <param name="a">The first vertex of the triangle.</param>
        /// <param name="b">The second vertex of the triangle.</param>
        /// <param name="c">The third vertex of the triangle.</param>
        /// <param name="point">The point to test.</param>
        /// <returns>True if the point lies within the triangle formed by a, b, and c, false otherwise.</returns>
        public static bool IsPointInTriangle(Cartesian a, Cartesian b, Cartesian c, Cartesian point)
        {
            Cartesian v0 = c - a;
            Cartesian v1 = b - a;
            Cartesian v2 = point - a;

            double dot00 = v0.Dot(v0);
            double dot01 = v0.Dot(v1);
            double dot02 = v0.Dot(v2);
            double dot11 = v1.Dot(v1);
            double dot12 = v1.Dot(v2);

            double inverseDenominator = 1.0 / (dot00 * dot11 - dot01 * dot01);
            double u = (dot11 * dot02 - dot01 * dot12) * inverseDenominator;
            double v = (dot00 * dot12 - dot01 * dot02) * inverseDenominator;

            return (u >= 0) && (v >= 0) && (u + v < 1);
        }

        /// <summary>
        /// Returns the index of the vertex with the maximum X-coordinate.
        /// </summary>
        /// <param name="vertices">The list of vertices.</param>
        /// <returns>The index of the vertex with the maximum X-coordinate.</returns>
        public static int GetRightmostVertexIndex(List<Cartesian> vertices)
        {
            double maximumX = vertices[0].X;
            int rightmostVertexIndex = 0;
            for (int i = 0; i < vertices.Count; i++)
            {
                if (vertices[i].X > maximumX)
                {
                    maximumX = vertices[i].X;
                    rightmostVertexIndex = i;
                }
            }
            return rightmostVertexIndex;
        }

        public static double ComputeArea2D(List<Cartesian> positions)
        {
            if (positions == null)
                throw new ArgumentNullException("positions");
            var length = positions.Count;
            if (length < 3)
                throw new ArgumentException("At least three positions are required.");
            var area = 0.0;
            for (int i0 = length - 1, i1 = 0; i1 < length; i0 = i1++)
            {
                var v0 = positions[i0];
                var v1 = positions[i1];
                area += (v0.X * v1.Y) - (v1.X * v0.Y);
            }
            return area * 0.5;
        }

        /// <summary>
        /// Returns the index of the inner ring that contains the rightmost vertex.
        /// </summary>
        /// <param name="innerRings">A list containing the vertex lists for each inner ring of the polygon.</param>
        /// <returns></returns>
        public static int GetRightmostRingIndex(List<List<Cartesian>> rings)
        {
            double rightmostX = rings[0][0].X;
            int rightmostRingIndex = 0;
            for (int ring = 0; ring < rings.Count; ring++)
            {
                double maximumX = rings[ring].Max(vertex => vertex.X);
                if (maximumX > rightmostX)
                {
                    rightmostX = maximumX;
                    rightmostRingIndex = ring;
                }
            }

            return rightmostRingIndex;
        }

        /// <summary>
        /// Returns a list containing the reflex vertices for a given polygon.
        /// </summary>
        /// <param name="polygon">A list of Cartesian points composing a polygon.</param>
        /// <returns>A list of Cartesians that are reflex vertices.</returns>
        public static List<Cartesian> GetReflexVertices(List<Cartesian> polygon)
        {
            List<Cartesian> reflexVertices = new List<Cartesian>();
            for (int i = 0; i < polygon.Count; i++)
            {
                Cartesian p0 = polygon[(i + 1) % polygon.Count];
                Cartesian p1 = polygon[i];
                Cartesian p2 = polygon[((i - 1) + polygon.Count) % polygon.Count];

                Cartesian u = p1 - p0;
                Cartesian v = p2 - p1;
                if (((u.X * v.Y) - (u.Y * v.X)) < 0.0)
                {
                    reflexVertices.Add(p1);
                }
            }
            return reflexVertices;
        }

        /// <summary>
        /// Checks whether a point is a vertex of a specific polygon.
        /// </summary>
        /// <param name="polygon">A list of vertices defining a polygon.</param>
        /// <param name="point">The point to test.</param>
        /// <returns></returns>
        public static bool IsVertex(List<Cartesian> polygon, Cartesian point)
        {
            foreach (Cartesian vertex in polygon)
            {
                if (vertex.Equals(point))
                {
                    return true;
                }
            }
            return false;
        }

        /// <summary>
        /// Given a point inside a polygon, find the nearest point directly to the right that lies on one of the polygon's edges.
        /// </summary>
        /// <param name="point">A point inside the ring.</param>
        /// <param name="ring">A list of <see cref="Cartesian">Cartesian</see> points defining a polygon.</param>
        /// <returns>The intersected point on the ring.</returns>
        public static Cartesian IntersectPointWithRing(Cartesian point, List<Cartesian> ring)
        {
            Cartesian[] temp;
            return IntersectPointWithRing(point, ring, out temp);
        }

        /// <summary>
        /// Given a point inside a polygon, find the nearest point directly to the right that lies on one of the polygon's edges.
        /// </summary>
        /// <param name="point">A point inside the ring.</param>
        /// <param name="ring">A list of <see cref="Cartesian">Cartesian</see> points defining a polygon.</param>
        /// <param name="edge">An array containing the two endpoints of the edge containing the intersection.</param>
        /// <returns>The intersected point on the ring.</returns>
        public static Cartesian IntersectPointWithRing(Cartesian point, List<Cartesian> ring, out Cartesian[] edge)
        {
            double minDistance = System.Double.MaxValue;
            int rightmostVertexIndex = GetRightmostVertexIndex(ring);
            Cartesian intersection = new Cartesian(ring[rightmostVertexIndex].X, point.Y, 0.0);
            edge = new Cartesian[] {ring[rightmostVertexIndex], ring[rightmostVertexIndex + 1]};

            double boundaryMinX = ring[0].X;
            double boundaryMaxX = boundaryMinX;
            for (int i = 1; i < ring.Count; ++i)
            {
                if (ring[i].X < boundaryMinX)
                {
                    boundaryMinX = ring[i].X;
                }
                else if (ring[i].X > boundaryMaxX)
                {
                    boundaryMaxX = ring[i].X;
                }
            }
            boundaryMaxX += (boundaryMaxX - boundaryMinX);
            Cartesian point2 = new Cartesian(boundaryMaxX, point.Y, 0.0);

            // Find the nearest intersection.
            for (int i = 0; i < ring.Count; i++)
            {
                Cartesian v1 = ring[i];
                Cartesian v2 = ring[(i + 1) % ring.Count];

                if (((v1.X >= point.X) || (v2.X >= point.X)) && (((v1.Y >= point.Y) && (v2.Y <= point.Y)) ||
                ((v1.Y <= point.Y) && (v2.Y >= point.Y))))
                {
                    double temp = ((v2.Y - v1.Y) * (point2.X - point.X)) - ((v2.X - v1.X) * (point2.Y - point.Y));
                    if (temp != 0.0)
                    {
                        temp = 1.0 / temp;
                        double ua = (((v2.X - v1.X) * (point.Y - v1.Y)) - ((v2.Y - v1.Y) * (point.X - v1.X))) * temp;
                        double ub = (((point2.X - point.X) * (point.Y - v1.Y)) - ((point2.Y - point.Y) * (point.X - v1.X))) * temp;
                        if ((ua >= 0.0) && (ua <= 1.0) && (ub >= 0.0) && (ub <= 1.0))
                        {
                            Cartesian tempIntersection = new Cartesian(point.X + ua * (point2.X - point.X), point.Y + ua * (point2.Y - point.Y), 0.0);
                            Cartesian dist = tempIntersection - point;
                            temp = dist.MagnitudeSquared;
                            if (temp < minDistance)
                            {
                                intersection = tempIntersection;
                                minDistance = temp;
                                edge = new Cartesian[] { v1, v2 };
                            }
                        }
                    }

                }
            }

            return intersection;
        }

        /// <summary>
        /// Given an outer ring and multiple inner rings, determine the point on the outer ring that is visible
        /// to the rightmost vertex of the rightmost inner ring.
        /// </summary>
        /// <param name="outerRing">A list of Cartesian points defining the outer polygon.</param>
        /// <param name="innerRings">A list of lists of Cartesian points, each list defining a "hole" in the outer polygon.</param>
        /// <returns>The index of the vertex in <paramref name="outerRing"/> that is mutually visible to the rightmost vertex in <paramref name="innerRings"/></returns>
        public static int GetMutuallyVisibleVertexIndex(List<Cartesian> outerRing, List<List<Cartesian>> innerRings)
        {
            int innerRingIndex = GetRightmostRingIndex(innerRings);
            List<Cartesian> innerRing = innerRings[innerRingIndex];
            int innerRingVertexIndex = GetRightmostVertexIndex(innerRing);
            Cartesian innerRingVertex = innerRing[innerRingVertexIndex];
            Cartesian[] edge = new Cartesian[2];
            Cartesian intersection = IntersectPointWithRing(innerRingVertex, outerRing, out edge);

            Cartesian visibleVertex;
            if (IsVertex(outerRing, intersection))
            {
                visibleVertex = intersection;
            }
            else
            {
                // Set P to be the edge endpoint closest to the inner ring vertex
                var d1 = (edge[0] - innerRingVertex).MagnitudeSquared;
                var d2 = (edge[1] - innerRingVertex).MagnitudeSquared;
                Cartesian p = (d1 < d2) ? edge[0] : edge[1];

                List<Cartesian> reflexVertices = GetReflexVertices(outerRing);
                reflexVertices.Remove(p); // Do not include p if it happens to be reflex.

                List<Cartesian> pointsInside = new List<Cartesian>();
                foreach (Cartesian vertex in reflexVertices)
                {
                    if (PolygonAlgorithms.IsPointInTriangle(innerRingVertex, intersection, p, vertex))
                    {
                        pointsInside.Add(vertex);
                    }
                }

                // If all reflexive vertices are outside the triangle formed by points 
                // innerRingVertex, intersection and P, then P is the visible vertex.
                // Otherwise, return the reflex vertex that minimizes the angle between <1,0> and <k, reflex>.
                double minAngle = Math.PI;
                if (pointsInside.Count > 0)
                {
                    Cartesian v1 = new Cartesian(1.0, 0.0, 0.0);
                    for (int i = 0; i < pointsInside.Count; i++)
                    {
                        Cartesian v2 = pointsInside[i] - innerRingVertex;
                        double angle = Math.Abs(Math.Acos(v1.Dot(v2) / (v1.Magnitude * v2.Magnitude)));
                        if (angle < minAngle)
                        {
                            minAngle = angle;
                            p = pointsInside[i];
                        }
                    }
                }
                visibleVertex = p;
            }

            return outerRing.FindIndex(delegate(Cartesian point)
            {
                return point.Equals(visibleVertex);
            });
        }

        /// <summary>
        /// Given a polygon defined by an outer ring with one or more inner rings (holes), return a single list of points representing
        /// a polygon with a hole added to it. The added hole is removed from <paramref name="innerRings"/>.
        /// </summary>
        /// <param name="outerRing">A list of Cartographic points defining the outer polygon.</param>
        /// <param name="innerRings">A list of lists of Cartographic points, each list defining a "hole" in the outer polygon.</param>
        /// <returns>A single list of Cartographic points defining the polygon, including the eliminated inner ring.</returns>
        public static List<Cartographic> EliminateHole(List<Cartographic> outerRing, List<List<Cartographic>> innerRings)
        {
            // Convert from LLA -> XYZ and project points onto a tangent plane to find the mutually visible vertex.
            List<Cartesian> cartesianOuterRing = new List<Cartesian>();
            foreach (Cartographic point in outerRing)
            {
                cartesianOuterRing.Add(Ellipsoid.Wgs84.ToCartesian(point));
            }
            var windingOrder = ComputeArea2D(cartesianOuterRing) >= 0.0 ? 0 : 1;
            List<List<Cartesian>> cartesianInnerRings = new List<List<Cartesian>>();
            for(int i = 0; i < innerRings.Count; ++i)
            {
                var ring = innerRings[i];
                List<Cartesian> cartesianInnerRing = new List<Cartesian>();
                foreach (Cartographic point in ring)
                {
                    cartesianInnerRing.Add(Ellipsoid.Wgs84.ToCartesian(point));
                }
                var innerWindingOrder = ComputeArea2D(cartesianInnerRing) >= 0.0 ? 0 : 1;
                if (innerWindingOrder == windingOrder)
                {
                    ring.Reverse();
                    cartesianInnerRing.Reverse();
                }
                cartesianInnerRings.Add(cartesianInnerRing);
            }

            EllipsoidTangentPlane tangentPlane = new EllipsoidTangentPlane(Ellipsoid.Wgs84, cartesianOuterRing);
            cartesianOuterRing = (List<Cartesian>)(tangentPlane.ComputePositionsOnPlane(cartesianOuterRing));
            for (int i = 0; i < cartesianInnerRings.Count; i++)
            {
                cartesianInnerRings[i] = (List<Cartesian>)(tangentPlane.ComputePositionsOnPlane(cartesianInnerRings[i]));
            }

            int visibleVertexIndex = GetMutuallyVisibleVertexIndex(cartesianOuterRing, cartesianInnerRings);
            int innerRingIndex = GetRightmostRingIndex(cartesianInnerRings);
            int innerRingVertexIndex = GetRightmostVertexIndex(cartesianInnerRings[innerRingIndex]);

            List<Cartographic> innerRing = innerRings[innerRingIndex];
            List<Cartographic> newPolygonVertices = new List<Cartographic>();

            for (int i = 0; i < outerRing.Count; i++)
            {
                newPolygonVertices.Add(outerRing[i]);
            }

            List<Cartographic> holeVerticesToAdd = new List<Cartographic>();

            // If the rightmost inner vertex is not the starting and ending point of the ring,
            // then some other point is duplicated in the inner ring and should be skipped once.
            if (innerRingVertexIndex != 0)
            {
                for (int j = 0; j <= innerRing.Count; j++)
                {
                    int index = (j + innerRingVertexIndex) % innerRing.Count;
                    if (index != 0)
                    {
                        holeVerticesToAdd.Add(innerRing[index]);
                    }
                }
            }
            else
            {
                for (int j = 0; j < innerRing.Count; j++)
                {
                    holeVerticesToAdd.Add(innerRing[(j + innerRingVertexIndex) % innerRing.Count]);
                }
            }

            int lastVisibleVertexIndex = newPolygonVertices.FindLastIndex(delegate(Cartographic point)
            {
                return point.Equals(outerRing[visibleVertexIndex]);
            });

            holeVerticesToAdd.Add(outerRing[lastVisibleVertexIndex]);
            newPolygonVertices.InsertRange(lastVisibleVertexIndex + 1, holeVerticesToAdd);
            innerRings.RemoveAt(innerRingIndex);

            return newPolygonVertices;
        }
    }
}