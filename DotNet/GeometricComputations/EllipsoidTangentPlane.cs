using System;
using System.Collections.Generic;
using CesiumLanguageWriter;

namespace GeometricComputations
{
    public class EllipsoidTangentPlane
    {
        public EllipsoidTangentPlane(Ellipsoid ellipsoid, IList<Cartesian> positions)
        {
            if (ellipsoid == null)
            {
                throw new ArgumentNullException("ellipsoid");
            }

            if (positions == null)
            {
                throw new ArgumentNullException("positions");
            }

            if (positions.Count < 1)
            {
                throw new ArgumentOutOfRangeException("positions", "At least one position is required.");
            }

            AxisAlignedBoundingBox box = new AxisAlignedBoundingBox(positions);

            _origin = ellipsoid.ScaleToGeodeticSurface(box.Center);
            _normal = ellipsoid.GeodeticSurfaceNormal(_origin);
            _d = -_origin.Dot(_origin);
            _yAxis = _origin.Cross(_origin.MostOrthogonalAxis).Normalize();
            _xAxis = _yAxis.Cross(_origin).Normalize();
        }

        public IList<Cartesian> ComputePositionsOnPlane(IList<Cartesian> positions)
        {
            if (positions == null)
            {
                throw new ArgumentNullException("positions");
            }

            IList<Cartesian> positionsOnPlane = new List<Cartesian>(positions.Count);

            foreach (Cartesian position in positions)
            {
                Cartesian intersectionPoint;

                if (IntersectionTests.TryRayPlane(Cartesian.Zero, position.Normalize(), _normal, _d, out intersectionPoint))
                {
                    Cartesian v = intersectionPoint - _origin;
                    positionsOnPlane.Add(new Cartesian(_xAxis.Dot(v), _yAxis.Dot(v), 0.0));
                }
                else
                {
                    // Ray does not intersect plane
                }
            }

            return positionsOnPlane;
        }

        public Cartesian Origin { get { return _origin; } }
        public Cartesian Normal { get { return _normal; } }
        public double D { get { return _d; } }
        public Cartesian XAxis { get { return _xAxis; } }
        public Cartesian YAxis { get { return _yAxis; } }

        private Cartesian _origin;
        private Cartesian _normal;
        private double _d;
        private Cartesian _xAxis;
        private Cartesian _yAxis;
    }
}
