using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class MultiPointShape : Shape
    {
        public MultiPointShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            Cartesian[] positions,
            ShapeType shapeType = ShapeType.MultiPoint)
            : base(recordNumber, metadata, shapeType)
        {
            _extent = extent;
            _positions = (Cartesian[])positions.Clone();
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public Cartesian this[int index]
        {
            get { return _positions[index]; }
        }

        public int Count
        {
            get { return _positions.Length; }
        }

        private readonly CartographicExtent _extent;
        private readonly Cartesian[] _positions;
    }
}
