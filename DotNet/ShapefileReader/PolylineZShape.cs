using System.Collections;
using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class PolylineZShape : PolylineMShape
    {
        internal PolylineZShape(
            int recordNumber,
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
            : base(recordNumber, extent, parts, positions, minimumMeasure, maximumMeasure, measures, shapeType)
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
