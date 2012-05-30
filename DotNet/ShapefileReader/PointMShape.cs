using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PointMShape : PointShape
    {
        internal PointMShape(
            int recordNumber, 
            Rectangular position, 
            double measure, 
            ShapeType shapeType = ShapeType.PointM)
            : base(recordNumber, position, shapeType)
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
