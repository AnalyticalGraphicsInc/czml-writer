using System.Collections;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class ShapePart
    {
        internal ShapePart(Rectangular[] positions, int offset, int count)
        {
            _positions = new Rectangular[count];

            for (int i = 0; i < count; ++i)
            {
                _positions[i] = positions[offset + i];
            }
        }

        public Rectangular this[int index]
        {
            get { return _positions[index]; }
        }

        public int Count
        {
            get { return _positions.Length; }
        }

        public IEnumerator GetEnumerator()
        {
            return _positions.GetEnumerator();
        }

        private readonly Rectangular[] _positions;
    }
}
