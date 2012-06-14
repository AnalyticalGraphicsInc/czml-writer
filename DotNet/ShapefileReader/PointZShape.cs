using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PointZShape : PointMShape
    {
        public PointZShape(
            int recordNumber, 
            StringDictionary metadata,
            Rectangular position,
            double z,
            double measure, 
            ShapeType shapeType = ShapeType.PointZ)
            : base(recordNumber, metadata, position, measure, shapeType)
        {
            _z = z;
        }

        public double Z
        {
            get { return _z; }
        }

        private readonly double _z;
    }
}
