using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class MultiPointMShape : MultiPointShape
    {
        public MultiPointMShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            Cartesian[] positions,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.MultiPointM)
            : base(recordNumber, metadata, extent, positions, shapeType)
        {
            _measureRange = new double[] { minimumMeasure, maximumMeasure };
            _measures = (double[])measures.Clone();
        }

        /// <summary>
        /// Returns an array containing the minimum and maximum measures.
        /// </summary>
        public double[] MeasureRange
        {
            get { return _measureRange; }
        }

        public double[] Measures
        {
            get { return _measures; }
        }

        private readonly double[] _measureRange;
        private readonly double[] _measures;
    }
}
