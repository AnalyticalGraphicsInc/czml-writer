using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PointShape : Shape
    {
        internal PointShape(int recordNumber, Rectangular position, ShapeType shapeType = ShapeType.Point)
            : base(recordNumber, shapeType)
        {
            _position = position;
        }

        public Rectangular Position
        {
            get { return _position; }
        }

        private readonly Rectangular _position;
    }
}
