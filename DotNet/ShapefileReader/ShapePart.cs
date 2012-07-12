using System.Collections;
using System.Collections.Generic;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class ShapePart : IEnumerable<Cartesian>
    {
        public ShapePart(Cartesian[] positions, int offset, int count)
        {
            _positions = new List<Cartesian>();

            for (int i = 0; i < count; ++i)
            {
                _positions.Add(new Cartesian(positions[offset + i].X, positions[offset + i].Y, positions[offset + i].Z));
            }
        }

        public ShapePart(Rectangular[] positions, int offset, int count)
        {
            _positions = new List<Cartesian>();

            for (int i = 0; i < count; ++i)
            {
                _positions.Add(new Cartesian(positions[offset + i].X, positions[offset + i].Y, 0.0));
            }
        }

        public ShapePart(Rectangular[] positions, double[] measures, int offset, int count)
        {
            _positions = new List<Cartesian>();
            _measures = new double[count];

            for (int i = 0; i < count; ++i)
            {
                _positions.Add(new Cartesian(positions[offset + i].X, positions[offset + i].Y, 0.0));
                _measures[i] = measures[offset + i];
            }
        }

        public ShapePart(Rectangular[] positions, double[] zValues, double[] measures, int offset, int count)
        {
            _positions = new List<Cartesian>();
            _measures = new double[count];
          
            for (int i = 0; i < count; ++i)
            {
                _positions.Add(new Cartesian(positions[offset + i].X, positions[offset + i].Y, zValues[offset + i]));
                _measures[i] = measures[offset + i];
            }
        }

        public Cartesian this[int index]
        {
            get { return _positions[index]; }
        }

        public double GetMeasure(int index)
        {
            return _measures[index];
        }

        public int Count
        {
            get { return _positions.Count; }
        }

        public IEnumerator<Cartesian> GetEnumerator()
        {
            return (IEnumerator<Cartesian>)_positions.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }

        private readonly List<Cartesian> _positions;
        private readonly double[] _measures;
    }
}
