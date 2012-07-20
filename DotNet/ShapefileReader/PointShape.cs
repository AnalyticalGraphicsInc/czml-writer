using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PointShape : Shape
    {
        public PointShape(int recordNumber, StringDictionary metadata, Cartographic position, ShapeType shapeType = ShapeType.Point)
            : base(recordNumber, metadata, shapeType)
        {
            _position = new Cartographic(position.Longitude, position.Latitude, position.Height);
        }

        public Cartographic Position
        {
            get { return _position; }
        }

        protected readonly Cartographic _position;
    }
}
