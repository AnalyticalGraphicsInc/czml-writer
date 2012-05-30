using System.Collections;
using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PolygonMShape : PolygonShape
    {
        internal PolygonMShape(
            int recordNumber,
            CartographicExtent extent,
            int[] parts,
            Rectangular[] positions,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.PolygonM)
            : base(recordNumber, extent, parts, positions, shapeType)
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
