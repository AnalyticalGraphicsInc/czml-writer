using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class MultiPointZShape : MultiPointMShape
    {
        public MultiPointZShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            Cartographic[] positions,
            double minimumZ,
            double maximumZ,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.MultiPointZ)
            : base(recordNumber, metadata, extent, positions, minimumMeasure, maximumMeasure, measures, shapeType)
        {
            _minimumZ = minimumZ;
            _maximumZ = maximumZ;
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
