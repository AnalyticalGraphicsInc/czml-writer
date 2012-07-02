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
            Cartesian[] positions,
            double minimumZ,
            double maximumZ,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.MultiPointZ)
            : base(recordNumber, metadata, extent, positions, minimumMeasure, maximumMeasure, measures, shapeType)
        {
            _zRange = new double[] { minimumZ, maximumZ };
        }

        public double[] ZRange
        {
            get { return _zRange; }
        }

        private readonly double[] _zRange;
    }
}
