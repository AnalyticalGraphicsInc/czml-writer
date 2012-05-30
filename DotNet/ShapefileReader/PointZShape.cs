using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PointZShape : Shape
    {
        internal PointZShape(
            int recordNumber, 
            Cartesian position, 
            double measure, 
            ShapeType shapeType = ShapeType.PointZ)
            : base(recordNumber, shapeType)
        {
            _position = position;
            _measure = measure;
        }

        public Cartesian Position
        {
            get { return _position; }
        }

        public double Measure
        {
            get { return _measure; }
        }

        private readonly Cartesian _position;
        private readonly double _measure;
    }
}
