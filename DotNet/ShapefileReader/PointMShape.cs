using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PointMShape : Shape
    {
        internal PointMShape(int recordNumber, Rectangular position, double measure)
            : base(recordNumber, ShapeType.PointM)
        {
            _position = position;
            _measure = measure;
        }

        public Rectangular Position
        {
            get { return _position; }
        }

        public double Measure
        {
            get { return _measure; }
        }

        private readonly Rectangular _position;
        private readonly double _measure;
    }
}
