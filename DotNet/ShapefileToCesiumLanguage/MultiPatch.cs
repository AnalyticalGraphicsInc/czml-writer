using System;
using System.Drawing;
using System.Collections.Generic;
using System.Collections.Specialized;
using Shapefile;
using CesiumLanguageWriter;

namespace ShapefileToCesiumLanguage
{
    /// <summary>
    /// A MultiPatch <see cref="CzmlShape"/>. 
    /// </summary>
    public class MultiPatch : CzmlShape
    {
        /// <summary>
        /// Constructs a new multipatch <see cref="CzmlShape"/> from a <see cref="MultiPatchShape"/>.
        /// </summary>
        /// <param name="multiPatch">The shapefile multipatch shape</param>.
        /// <param name="document">The <see cref="CzmlDocument"/> to which the shape's CZML is written.</param>
        /// <param name="color">A color for the shape's visualization.</param>
        public MultiPatch(MultiPatchShape multiPatch, CzmlDocument document, Color color)
            : base(document, color)
        {
            m_shape = multiPatch;
        }

        /// <summary>
        /// Writes the MultiPatch shape to its <see cref="CzmlDocument"/> as a series of polygon packets.
        /// </summary>
        public override void Write()
        {
            MultiPatchShape multipatch = (MultiPatchShape)m_shape;
            List<Polygon> polygons = new List<Polygon>();

            StringDictionary metadata = new StringDictionary();
            var fields = multipatch.GetMetadataFields();
            foreach (String field in fields)
            {
                metadata.Add(field, multipatch.GetMetadataValue(field));
            }

            for (int i = 0; i < multipatch.Count; i++)
            {
                List<ShapePart> polygonParts = new List<ShapePart>();
                PolygonShape temp;

                switch (multipatch.GetPartType(i))
                {
                    case MultiPatchPartType.TriangleFan:
                    case MultiPatchPartType.TriangleStrip:
                        for (int j = 2; j < multipatch[i].Count; j++)
                        {
                            int firstIndex = (multipatch.GetPartType(i) == MultiPatchPartType.TriangleFan) ? 0 : j - 2;
                            Cartographic[] vertices = new Cartographic[] { multipatch[i][firstIndex], multipatch[i][j - 1], multipatch[i][j] };
                            ShapePart triangle = new ShapePart(vertices, 0, vertices.Length);
                            PolygonShape p = new PolygonShape(multipatch.RecordNumber, metadata, multipatch.Extent, new ShapePart[] { triangle });
                            (new Polygon(p, m_document, m_color)).Write();
                        }
                        break;

                    case MultiPatchPartType.Ring:
                        while (i < multipatch.Count && multipatch.GetPartType(i) == MultiPatchPartType.Ring)
                        {
                            temp = new PolygonShape(multipatch.RecordNumber, metadata, multipatch.Extent, new ShapePart[] { multipatch[i] });
                            (new Polygon(temp, m_document, m_color)).Write();
                            i++;
                        }
                        i--;
                        break;

                    case MultiPatchPartType.OuterRing:
                    case MultiPatchPartType.FirstRing:
                        polygonParts.Add(multipatch[i]);
                        MultiPatchPartType comparisonType = (multipatch.GetPartType(i) == MultiPatchPartType.OuterRing) ? MultiPatchPartType.InnerRing : MultiPatchPartType.Ring;
                        while (++i < multipatch.Count && multipatch.GetPartType(i) == comparisonType)
                        {
                            polygonParts.Add(multipatch[i]);
                        }
                        temp = new PolygonShape(multipatch.RecordNumber, metadata, multipatch.Extent, polygonParts.ToArray());
                        (new Polygon(temp, m_document, m_color)).Write();
                        i--;
                        break;
                }
            }
        }
    }
}
