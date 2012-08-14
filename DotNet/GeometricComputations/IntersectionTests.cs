using System;
using CesiumLanguageWriter;

namespace GeometricComputations
{
    public static class IntersectionTests
    {
        public static bool TryIntersectRayPlane(
            Cartesian rayOrigin,
            Cartesian rayDirection,
            Cartesian planeNormal,
            double planeD,
            out Cartesian intersectionPoint)
        {
            double denominator = planeNormal.Dot(rayDirection);

            if (Math.Abs(denominator) < 0.00000000000000000001)
            {
                // Ray is parallel to plane.  The ray may be in the polygon's plane.
                intersectionPoint = Cartesian.Zero;
                return false;
            }

            double t = (-planeD - planeNormal.Dot(rayOrigin)) / denominator;

            if (t < 0)
            {
                intersectionPoint = Cartesian.Zero;
                return false;
            }

            intersectionPoint = rayOrigin + (t * rayDirection);
            return true;
        }
    }
}
