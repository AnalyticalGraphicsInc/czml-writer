﻿using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Runtime.CompilerServices;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class PolygonShape : Shape, IEnumerable<ShapePart>
    {
        public PolygonShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            int[] parts,
            Rectangular[] positions,
            ShapeType shapeType = ShapeType.Polygon)
            : base(recordNumber, metadata, shapeType)
        {
            _extent = new CartographicExtent(
                extent.WestLongitude * Constants.RadiansPerDegree,
                extent.SouthLatitude * Constants.RadiansPerDegree,
                extent.EastLongitude * Constants.RadiansPerDegree,
                extent.NorthLatitude * Constants.RadiansPerDegree);

            for (int i = 0; i < positions.Length; i++)
            {
                positions[i] = new Rectangular(positions[i].X * Constants.RadiansPerDegree, positions[i].Y * Constants.RadiansPerDegree);
            }

            _parts = new List<ShapePart>(parts.Length);
            for (int i = 0; i < parts.Length; ++i)
            {
                int count = ((i == parts.Length - 1) ?
                    positions.Length : parts[i + 1]) - parts[i];

                _parts.Add(new ShapePart(positions, parts[i], count));
            }
        }

        public PolygonShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            ShapePart[] parts,
            ShapeType shapeType = ShapeType.Polygon)
            : base(recordNumber, metadata, shapeType)
        {
            _extent = extent;
            _parts = new List<ShapePart>(parts);
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public ShapePart this[int index]
        {
            get { return _parts[index]; }
        }

        public int Count
        {
            get { return _parts.Count; }
        }

        public IEnumerator<ShapePart> GetEnumerator()
        {
            return _parts.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }

        private readonly CartographicExtent _extent;
        protected List<ShapePart> _parts;
    }
}
