using System;
using System.Drawing;
using Shapefile;
using CesiumLanguageWriter;

namespace ShapefileToCesiumLanguage
{
    internal class ShapeFactory
    {
        static public CzmlShape Create(Shape shape, CzmlDocument document, Color color)
        {
            switch (shape.ShapeType)
            {
                case ShapeType.Point:
                    return new Point((PointShape)shape, document, color);
                case ShapeType.Polyline:
                    return new Polyline((PolylineShape)shape, document, color);
                case ShapeType.Polygon:
                    return new Polygon((PolygonShape)shape, document, color);
            }
            throw new NotImplementedException();
        }
    }
}
