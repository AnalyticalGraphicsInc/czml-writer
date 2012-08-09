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
            Cartographic[] positions,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.MultiPointM)
            : base(recordNumber, metadata, extent, positions, shapeType)
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

        public double GetMeasure(int index)
        {
            return _measures[index];
        }

        private readonly double _minimumMeasure;
        private readonly double _maximumMeasure;
        private readonly double[] _measures;
    }
}
