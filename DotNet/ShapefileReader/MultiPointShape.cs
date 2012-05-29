using System.Collections;
using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class MultiPointShape : Shape
    {
        internal MultiPointShape(
            int recordNumber,
            CartographicExtent extent,
            Rectangular[] positions,
            ShapeType shapeType = ShapeType.MultiPoint)
            : base(recordNumber, shapeType)
        {
            _extent = extent;
            _positions = (Rectangular[])positions.Clone();
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public Rectangular[] Positions
        {
            get { return _positions; }
        }

        public int Count
        {
            get { return _positions.Length; }
        }

        private readonly CartographicExtent _extent;
        private readonly Rectangular[] _positions;
    }
}
