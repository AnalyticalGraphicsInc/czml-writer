using System.Collections;
using System.Collections.Generic;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class ShapePart : IEnumerable<Cartographic>
    {
        public ShapePart(Cartographic[] positions, int offset, int count)
        {
            _positions = new List<Cartographic>();

            for (int i = 0; i < count; ++i)
            {
                _positions.Add(new Cartographic(positions[offset + i].Longitude, positions[offset + i].Latitude, positions[offset + i].Height));
            }
        }

        public ShapePart(Rectangular[] positions, int offset, int count)
        {
            _positions = new List<Cartographic>();

            for (int i = 0; i < count; ++i)
            {
                _positions.Add(new Cartographic(positions[offset + i].X, positions[offset + i].Y, 0.0));
            }
        }

        public ShapePart(Rectangular[] positions, double[] measures, int offset, int count)
        {
            _positions = new List<Cartographic>();
            _measures = new double[count];

            for (int i = 0; i < count; ++i)
            {
                _positions.Add(new Cartographic(positions[offset + i].X, positions[offset + i].Y, 0.0));
                _measures[i] = measures[offset + i];
            }
        }

        public ShapePart(Rectangular[] positions, double[] zValues, double[] measures, int offset, int count)
        {
            _positions = new List<Cartographic>();
            _measures = new double[count];
          
            for (int i = 0; i < count; ++i)
            {
                _positions.Add(new Cartographic(positions[offset + i].X, positions[offset + i].Y, zValues[offset + i]));
                _measures[i] = measures[offset + i];
            }
        }

        public Cartographic this[int index]
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

        public IEnumerator<Cartographic> GetEnumerator()
        {
            return (IEnumerator<Cartographic>)_positions.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }

        private readonly List<Cartographic> _positions;
        private readonly double[] _measures;
    }
}
