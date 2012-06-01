using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PointMShape : PointShape
    {
        internal PointMShape(
            int recordNumber,
            StringDictionary metadata,
            Rectangular position, 
            double measure, 
            ShapeType shapeType = ShapeType.PointM)
            : base(recordNumber, metadata, position, shapeType)
        {
            _measure = measure;
        }

        public double Measure
        {
            get { return _measure; }
        }

        private readonly double _measure;
    }
}
