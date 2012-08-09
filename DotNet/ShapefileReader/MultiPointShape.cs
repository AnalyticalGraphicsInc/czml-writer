using System.Collections;
using System.Collections.Specialized;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class MultiPointShape : Shape
    {
        public MultiPointShape(
            int recordNumber,
            StringDictionary metadata,
            CartographicExtent extent,
            Cartographic[] positions,
            ShapeType shapeType = ShapeType.MultiPoint)
            : base(recordNumber, metadata, shapeType)
        {
            _extent = new CartographicExtent(
                extent.WestLongitude * Constants.RadiansPerDegree,
                extent.SouthLatitude * Constants.RadiansPerDegree,
                extent.EastLongitude * Constants.RadiansPerDegree,
                extent.NorthLatitude * Constants.RadiansPerDegree);

            _positions = new Cartographic[positions.Length];
            for (int i = 0; i < positions.Length; i++)
            {
                _positions[i] = new Cartographic(
                    positions[i].Longitude * Constants.RadiansPerDegree,
                    positions[i].Latitude * Constants.RadiansPerDegree,
                    positions[i].Height);
            }
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public Cartographic this[int index]
        {
            get { return _positions[index]; }
        }

        public int Count
        {
            get { return _positions.Length; }
        }

        private readonly CartographicExtent _extent;
        private readonly Cartographic[] _positions;
    }
}
