using System.Collections;
using CesiumLanguageWriter;

namespace ShapefileReader
{
    public class MultiPatchShape : Shape
    {
        internal MultiPatchShape(
            int recordNumber,
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
            : base(recordNumber, shapeType)
        {

            _extent = extent;
            _zRange = new double[] {  };

            _parts = new ShapePart[parts.Length];
            for (int i = 0; i < parts.Length; ++i)
            {
                int count = ((i == parts.Length - 1) ?
                    positions.Length : parts[i + 1]) - parts[i];

                _parts[i] = new ShapePart(positions, parts[i], count);
            }

            _partTypes = (MultiPatchPartType[])partTypes.Clone();
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public ShapePart this[int index]
        {
            get { return _parts[index]; }
        }

        public MultiPatchPartType PartType(int index)
        {
            return _partTypes[index];
        }

        public double[] ZRange
        {
            get { return _zRange; }
        }

        public double[] ZValues
        {
            get { return _zValues; }
        }

        public double[] MeasureRange
        {
            get { return _measureRange; }
        }

        public double[] Measures
        {
            get { return _measures; }
        }

        private readonly CartographicExtent _extent;
        private readonly ShapePart[] _parts;
        private readonly MultiPatchPartType[] _partTypes;
        private readonly double[] _zRange;
        private readonly double[] _zValues;
        private readonly double[] _measureRange;
        private readonly double[] _measures;
    }
}
