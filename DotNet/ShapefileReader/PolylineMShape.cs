using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PolylineMShape : PolylineShape
    {
        internal PolylineMShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            int[] parts,
            Rectangular[] positions,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.PolylineM) 
            : base(recordNumber, metadata, extent, parts, positions, shapeType) 
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
