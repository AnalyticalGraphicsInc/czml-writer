using System.Collections;
using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class MultiPointZShape : MultiPointMShape
    {
        internal MultiPointZShape(
            int recordNumber,
            CartographicExtent extent,
            Rectangular[] positions,
            double minimumZ,
            double maximumZ,
            double[] zValues,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.MultiPointZ)
            : base(recordNumber, extent, positions, minimumMeasure, maximumMeasure, measures, shapeType)
        {
            _zRange = new double[] { minimumZ, maximumZ };
            _zValues = (double[])zValues.Clone();
        }

        public double[] ZRange
        {
            get { return _zRange; }
        }

        public double[] ZValues
        {
            get { return _zValues; }
        }

        private readonly double[] _zRange;
        private readonly double[] _zValues;
    }
}
