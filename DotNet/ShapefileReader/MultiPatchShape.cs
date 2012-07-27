using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class MultiPatchShape : Shape
    {
        public MultiPatchShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            int[] parts,
            MultiPatchPartType[] partTypes,
            Rectangular[] positions,
            double minimumZ,
            double maximumZ,
            double[] zValues,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.MultiPatch)
            : base(recordNumber, metadata, shapeType)
        {
            _extent = new CartographicExtent(
               extent.WestLongitude * Constants.RadiansPerDegree,
               extent.SouthLatitude * Constants.RadiansPerDegree,
               extent.EastLongitude * Constants.RadiansPerDegree,
               extent.NorthLatitude * Constants.RadiansPerDegree);

            _minimumZ = minimumZ;
            _maximumZ = maximumZ;
            _minimumMeasure = minimumMeasure;
            _maximumMeasure = maximumMeasure;
            _measures = (double[])measures.Clone();

            for (int i = 0; i < positions.Length; i++)
            {
                positions[i] = new Rectangular(positions[i].X * Constants.RadiansPerDegree, positions[i].Y * Constants.RadiansPerDegree);
            }

            _parts = new ShapePart[parts.Length];
            for (int i = 0; i < parts.Length; ++i)
            {
                int count = ((i == parts.Length - 1) ?
                    positions.Length : parts[i + 1]) - parts[i];

                _parts[i] = new ShapePart(positions, zValues, parts[i], count);
            }

            _partTypes = (MultiPatchPartType[])partTypes.Clone();
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public int Count
        {
            get { return _parts.Length; }
        }

        public ShapePart this[int index]
        {
            get { return _parts[index]; }
        }

        public MultiPatchPartType GetPartType(int index)
        {
            return _partTypes[index];
        }

        public double MinimumZ
        {
            get { return _minimumZ; }
        }

        public double MaximumZ
        {
            get { return _maximumZ; }
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

        private readonly CartographicExtent _extent;
        private readonly ShapePart[] _parts;
        private readonly MultiPatchPartType[] _partTypes;
        private readonly double _minimumZ;
        private readonly double _maximumZ;
        private readonly double _minimumMeasure;
        private readonly double _maximumMeasure;
        private readonly double[] _measures;
    }
}
