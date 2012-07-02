using System.Collections;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class ShapePart
    {
        public ShapePart(Rectangular[] positions, int offset, int count)
        {
            _positions = new Cartesian[count];

            for (int i = 0; i < count; ++i)
            {
                _positions[i] = new Cartesian(positions[offset + i].X, positions[offset + i].Y, 0.0);
            }
        }

        public ShapePart(Cartesian[] positions, int offset, int count)
        {
            _positions = new Cartesian[count];

            for (int i = 0; i < count; ++i)
            {
                _positions[i] = new Cartesian(positions[offset + i].X, positions[offset + i].Y, positions[offset + i].Z);
            }
        }

        public ShapePart(Rectangular[] positions, double[] zValues, int offset, int count)
        {
            _positions = new Cartesian[count];
          
            for (int i = 0; i < count; ++i)
            {
                _positions[i] = new Cartesian(positions[offset + i].X, positions[offset + i].Y, zValues[offset + i]);
            }
        }

        public Cartesian this[int index]
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

        private readonly Cartesian[] _positions;
    }
}
