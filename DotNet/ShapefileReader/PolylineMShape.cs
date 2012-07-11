using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PolylineMShape : PolylineShape
    {
        public PolylineMShape(
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
            _minimumMeasure = minimumMeasure;
            _maximumMeasure = maximumMeasure;
            _measures = (double[])measures.Clone();
        }

        public double MinimumMeasure
        {
            get { return _minimumMeasure; }
        }

        public double MaximumMeasure
        {
            get { return _maximumMeasure; }
        }

        public double[] Measures
        {
            get { return _measures; }
        }

        private readonly double _minimumMeasure;
        private readonly double _maximumMeasure;
        private readonly double[] _measures;
    }

}
