using System.Collections;
using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class MultiPointMShape : MultiPointShape
    {
        internal MultiPointMShape(
            int recordNumber,
            CartographicExtent extent,
            Rectangular[] positions,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.MultiPointM)
            : base(recordNumber, extent, positions, shapeType)
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
