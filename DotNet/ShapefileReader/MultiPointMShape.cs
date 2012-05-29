using System;
using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class MultiPointMShape : Shape
    {
        internal MultiPointMShape(
            int recordNumber,
            CartographicExtent extent,
            Rectangular[] positions,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures)
            : base(recordNumber, ShapeType.PointM)
        {
            _extent = extent;
            _positions = positions;
            _measuresRange = new double[] { minimumMeasure, maximumMeasure };
            _measures = (double[])measures.Clone();
        }

        public Rectangular[] Positions
        {
            get { return _positions; }
        }

        public double[] MeasuresRange
        {
            get { return _measuresRange; }
        }

        public double[] Measures
        {
            get { return _measures; }
        }

        private readonly CartographicExtent _extent;
        private readonly Rectangular[] _positions;
        private readonly double[] _measuresRange;
        private readonly double[] _measures;
    }
}
