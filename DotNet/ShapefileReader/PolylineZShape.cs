using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PolylineZShape : PolylineMShape
    {
        public PolylineZShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            int[] parts,
            Rectangular[] positions,
            double minimumZ,
            double maximumZ,
            double[] zValues,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.PolylineZ
            )
            : base(recordNumber, metadata, extent, parts, positions, minimumMeasure, maximumMeasure, measures, shapeType)
        {
            _minimumZ = minimumZ;
            _maximumZ = maximumZ;

            _parts = new ShapePart[parts.Length];
            for (int i = 0; i < parts.Length; ++i)
            {
                int count = ((i == parts.Length - 1) ?
                    positions.Length : parts[i + 1]) - parts[i];

                _parts[i] = new ShapePart(positions, zValues, parts[i], count);
            }
        }

        public double MinimumZ
        {
            get { return _minimumZ; }
        }

        public double MaximumZ
        {
            get { return _maximumZ; }
        }

        private readonly double _minimumZ;
        private readonly double _maximumZ;
    }
}
