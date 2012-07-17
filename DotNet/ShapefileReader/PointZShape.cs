using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PointZShape : PointMShape
    {
        public PointZShape(
            int recordNumber, 
            StringDictionary metadata,
            Cartographic position,
            double measure, 
            ShapeType shapeType = ShapeType.PointZ)
            : base(recordNumber, metadata, position, measure, shapeType)
        {
        }
    }
}
