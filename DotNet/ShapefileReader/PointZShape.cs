using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PointZShape : PointMShape
    {
        internal PointZShape(
            int recordNumber, 
            Rectangular position,
            double z,
            double measure, 
            ShapeType shapeType = ShapeType.PointZ)
            : base(recordNumber, position, measure, shapeType)
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
