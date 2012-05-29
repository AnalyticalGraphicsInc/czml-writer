using System.Collections;
using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PolygonShape : Shape
    {
        internal PolygonShape(
            int recordNumber,
            CartographicExtent extent,
            int[] parts,
            Rectangular[] positions)
            : base(recordNumber, ShapeType.Polygon)
        {
            _extent = extent;

            _parts = new ShapePart[parts.Length];
            for (int i = 0; i < parts.Length; ++i)
            {
                int count = ((i == parts.Length - 1) ?
                    positions.Length : parts[i + 1]) - parts[i];

                _parts[i] = new ShapePart(positions, parts[i], count);
            }
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public ShapePart this[int index]
        {
            get { return _parts[index]; }
        }

        public int Count
        {
            get { return _parts.Length; }
        }

        public IEnumerator GetEnumerator()
        {
            return _parts.GetEnumerator();
        }

        private readonly CartographicExtent _extent;
        private readonly ShapePart[] _parts;
    }
}
