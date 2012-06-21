using System;
using System.Drawing;
using System.Collections.Generic;
using Shapefile;
using CesiumLanguageWriter;

namespace ShapefileToCesiumLanguage
{
    public class MultiPatch : CzmlShape
    {
        public MultiPatch(MultiPatchShape multiPatch, CzmlDocument document, Color color)
            : base(document, color)
        {
            m_shape = multiPatch;
        }

        public override void Write()
        {
            MultiPatchShape multipatch = (MultiPatchShape)m_shape;
            List<Polygon> polygons = new List<Polygon>();

            for (int i = 0; i < multipatch.Count; i++)
            {
                List<ShapePart> polygonParts = new List<ShapePart>();

                if (multipatch.PartType(i) == MultiPatchPartType.Ring)
                {
                    while (i < multipatch.Count && multipatch.PartType(i) == MultiPatchPartType.Ring)
                    {
                        PolygonShape p = new PolygonShape(multipatch.RecordNumber, multipatch.Metadata, multipatch.Extent, new ShapePart[] { multipatch[i] });
                        polygons.Add(new Polygon(p, m_document, m_color));
                        i++;
                    }
                }
                else
                {
                    polygonParts.Add(multipatch[i]);
                    MultiPatchPartType comparisonType = (multipatch.PartType(i) == MultiPatchPartType.OuterRing) ?  MultiPatchPartType.InnerRing : MultiPatchPartType.Ring;
                    while (++i < multipatch.Count && multipatch.PartType(i) == comparisonType)
                    {
                        polygonParts.Add(multipatch[i]);
                    }
                    PolygonShape p = new PolygonShape(multipatch.RecordNumber, multipatch.Metadata, multipatch.Extent, polygonParts.ToArray());
                    polygons.Add(new Polygon(p, m_document, m_color));
                }
                i--;
            }

            foreach (Polygon polygon in polygons)
            {
                polygon.Write();
            }
        }
    }
}
