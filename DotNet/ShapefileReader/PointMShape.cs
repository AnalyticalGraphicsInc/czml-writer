using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PointMShape : PointShape
    {
        internal PointMShape(int recordNumber, Rectangular position, double measure)
            : base(recordNumber, position, ShapeType.PointM)
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
