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
            Cartographic[] positions,
            ShapeType shapeType = ShapeType.MultiPoint)
            : base(recordNumber, metadata, shapeType)
        {
            _extent = extent;
            _positions = (Cartographic[])positions.Clone();
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public Cartographic this[int index]
        {
            get { return _positions[index]; }
        }

        public int Count
        {
            get { return _positions.Length; }
        }

        private readonly CartographicExtent _extent;
        private readonly Cartographic[] _positions;
    }
}
