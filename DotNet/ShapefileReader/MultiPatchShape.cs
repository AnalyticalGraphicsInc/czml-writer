﻿using System.Collections;
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

            _extent = extent;
            _zRange = new double[] { minimumZ, maximumZ };
            _measureRange = new double[] { minimumMeasure, maximumMeasure};
            _measures = (double[])measures.Clone();

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

        public MultiPatchPartType PartType(int index)
        {
            return _partTypes[index];
        }

        public double[] ZRange
        {
            get { return _zRange; }
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
        private readonly double[] _measureRange;
        private readonly double[] _measures;
    }
}
