using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CesiumLanguageWriter;

namespace GeometricComputations
{
    public class Ellipsoid
    {
        public static readonly Ellipsoid Wgs84 = new Ellipsoid(new Cartesian(6378137.0, 6378137.0, 6356752.314245));
        
        public Ellipsoid(Cartesian radii)
        {
            _radiiSquared = new Cartesian(radii.X * radii.X,
                                            radii.Y * radii.Y,
                                            radii.Z * radii.Z);
        }

        public Cartesian GeodeticSurfaceNormal(Cartographic cartographic)
        {
            double cosLatitude = Math.Cos(cartographic.Latitude);
            return new Cartesian(
                cosLatitude * Math.Cos(cartographic.Longitude),
                cosLatitude * Math.Sin(cartographic.Longitude),
                Math.Sin(cartographic.Latitude));
        }

        public Cartesian ToCartesian(Cartographic cartographic)
        {
            Cartesian n = GeodeticSurfaceNormal(cartographic);
            Cartesian k = new Cartesian(
                _radiiSquared.X * n.X,
                _radiiSquared.Y * n.Y,
                _radiiSquared.Z * n.Z);

            double gamma = Math.Sqrt(
                k.X * n.X +
                k.Y * n.Y +
                k.Z * n.Z);
            Cartesian rSurface = k / gamma;
            return rSurface + (cartographic.Height * n);
        }

        private readonly Cartesian _radiiSquared;
    }
}
