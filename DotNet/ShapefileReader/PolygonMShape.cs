using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PolygonMShape : PolygonShape
    {
        public PolygonMShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            int[] parts,
            Rectangular[] positions,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.PolygonM)
            : base(recordNumber, metadata, extent, parts, positions, shapeType)
        {
            _minimumMeasure = minimumMeasure;
            _maximumMeasure = maximumMeasure;

            for (int i = 0; i < parts.Length; ++i)
            {
                int count = ((i == parts.Length - 1) ?
                    positions.Length : parts[i + 1]) - parts[i];

                _parts[i] = new ShapePart(positions, measures, parts[i], count);
            }
        }

        public double MinimumMeasure
        {
            get { return _minimumMeasure; }
        }

        public double MaximumMeasure
        {
            get { return _maximumMeasure; }
        }

        private readonly double _minimumMeasure;
        private readonly double _maximumMeasure;
    }

}
