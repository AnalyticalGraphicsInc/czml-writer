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
                
                using (PolygonCesiumWriter polygonWriter = packetWriter.OpenPolygonProperty())
                {
                    using (MaterialCesiumWriter materialWriter = polygonWriter.OpenMaterialProperty())
                    {
                        using (SolidColorMaterialCesiumWriter colorWriter = materialWriter.OpenSolidColorProperty())
                        {
                            colorWriter.WriteColorProperty(m_color);
                        }
                    }

                    PolygonShape polygon = (PolygonShape)m_shape;
                    List<Cartographic> positions = new List<Cartographic>();
                    for (int i = 0; i < part.Count; i++)
                    {
                        positions.Add(part[i]);
                    }
                    polygonWriter.WritePositionsPropertyCartographicRadians(positions);
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
                    south = north = polygon[i][0].Latitude;
                    west = east = polygon[i][0].Longitude;
                    foreach (Cartographic point in polygon[i])
                    {
                        if (point.Longitude > east)
                        {
                            east = point.Longitude;
                        }
                        if (point.Longitude < west)
                        {
                            east = point.Longitude;
                        }
                        if (point.Latitude > north)
                        {
                            north = point.Latitude;
                        }
                        if (point.Latitude < south)
                        {
                            south = point.Latitude;
                        }
                    }
                    ringExtents.Add(new CartographicExtent(west, south, east, north));
                }

                for (int i = 0; i < ringExtents.Count; i++)
                {
                    for (int j = 0; j < ringExtents.Count; j++)
                    {
                        if (i != j 
                            && ringExtents[j].WestLongitude >= ringExtents[i].WestLongitude
                            && ringExtents[j].EastLongitude <= ringExtents[i].EastLongitude
                            && ringExtents[j].NorthLatitude <= ringExtents[i].NorthLatitude
                            && ringExtents[j].SouthLatitude >= ringExtents[i].SouthLatitude)
                        {
                            outerRingIndices.Add(i);
                            break;
                        }
                    }
                }

                for (int i = 0; i < outerRingIndices.Count; i++)
                {
                    int outerRingIndex = outerRingIndices[i];
                    List<List<Cartographic>> innerRings = new List<List<Cartographic>>();
                    for (int j = 0; j < ringExtents.Count; j++)
                    {
                        if (outerRingIndex != j
                            && ringExtents[j].WestLongitude >= ringExtents[outerRingIndex].WestLongitude
                            && ringExtents[j].EastLongitude <= ringExtents[outerRingIndex].EastLongitude
                            && ringExtents[j].NorthLatitude <= ringExtents[outerRingIndex].NorthLatitude
                            && ringExtents[j].SouthLatitude >= ringExtents[outerRingIndex].SouthLatitude)
                        {
                            List<Cartographic> innerRing = new List<Cartographic>();
                            foreach (Cartographic point in polygon[j])
                            {
                                innerRing.Add(point);
                            }
                            innerRings.Add(innerRing);
                        }
                    }

                    List<Cartographic> outerRing = new List<Cartographic>();
                    foreach (Cartographic point in polygon[outerRingIndex])
                    {
                        outerRing.Add(point);
                    }

                    while (innerRings.Count > 0)
                    {
                        outerRing = PolygonAlgorithms.EliminateHole(outerRing, innerRings);
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
