using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PointShape : Shape
    {
        internal PointShape(int recordNumber, StringDictionary metadata, Rectangular position, ShapeType shapeType = ShapeType.Point)
            : base(recordNumber, metadata, shapeType)
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
