using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PointShape : Shape
    {
        public PointShape(int recordNumber, StringDictionary metadata, Rectangular position, ShapeType shapeType = ShapeType.Point)
            : base(recordNumber, metadata, shapeType)
        {
            _position = new Cartesian(position.X, position.Y, 0.0);
        }

        public Cartesian Position
        {
            get { return _position; }
        }

        protected readonly Cartesian _position;
    }
}
