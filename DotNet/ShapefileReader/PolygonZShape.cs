﻿using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PolygonZShape : PolygonMShape
    {
        public PolygonZShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            int[] parts,
            Rectangular[] positions,
            double minimumZ,
            double maximumZ,
            double[] zValues,
            double minimumMeasure,
            double maximumMeasure,
            double[] measures,
            ShapeType shapeType = ShapeType.PolygonZ
            )
            : base(recordNumber, metadata, extent, parts, positions, minimumMeasure, maximumMeasure, measures, shapeType)
        {
            _minimumZ = minimumZ;
            _maximumZ = maximumZ;

            for (int i = 0; i < parts.Length; ++i)
            {
                int count = ((i == parts.Length - 1) ?
                    positions.Length : parts[i + 1]) - parts[i];

                _parts[i] = new ShapePart(positions, zValues, measures, parts[i], count);
            }
        }

        public double MinimumZ
        {
            get { return _minimumZ; }
        }

        public double MaximumZ
        {
            get { return _maximumZ; }
        }

        private readonly double _minimumZ;
        private readonly double _maximumZ;
    }
}
