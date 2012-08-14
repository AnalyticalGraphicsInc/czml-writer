using System;
using System.Drawing;
using Shapefile;

namespace ShapefileToCesiumLanguage
{
    public class ShapeFactory
    {
        /// <summary>
        /// Given a shapefile <see cref="Shape"/> object, return a <see cref="CzmlShape"/> that can be written to CZML.
        /// </summary>
        /// <param name="shape">Te shapefile <see cref="Shape"/>.</param>
        /// <param name="document">The <see cref="CzmlDocument"/> to which the shape will be written when its Write() method is called.</param>
        /// <param name="color">A color for the shape's visualization.</param>
        /// <returns>A new <see cref="CzmlShape"/>.</returns>
        static public CzmlShape Create(Shape shape, CzmlDocument document, Color color)
        {
            switch (shape.ShapeType)
            {
                case ShapeType.Point:
                case ShapeType.PointM:
                case ShapeType.PointZ:
                    return new Point((PointShape)shape, document, color);
                case ShapeType.MultiPoint:
                case ShapeType.MultiPointM:
                case ShapeType.MultiPointZ:
                    return new MultiPoint((MultiPointShape)shape, document, color);
                case ShapeType.Polyline:
                case ShapeType.PolylineM:
                case ShapeType.PolylineZ:
                    return new Polyline((PolylineShape)shape, document, color);
                case ShapeType.Polygon:
                case ShapeType.PolygonM:
                case ShapeType.PolygonZ:
                    return new Polygon((PolygonShape)shape, document, color);
                case ShapeType.MultiPatch:
                    return new MultiPatch((MultiPatchShape)shape, document, color);
            }
            throw new NotImplementedException();
        }
    }
}
