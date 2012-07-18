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
            _radiiSquared = new Cartesian(
                radii.X * radii.X,
                radii.Y * radii.Y,
                radii.Z * radii.Z);
            _radiiToTheFourth = new Cartesian(
                _radiiSquared.X * _radiiSquared.X,
                _radiiSquared.Y * _radiiSquared.Y,
                _radiiSquared.Z * _radiiSquared.Z);
            _oneOverRadiiSquared = new Cartesian(
                1.0 / (radii.X * radii.X),
                1.0 / (radii.Y * radii.Y),
                1.0 / (radii.Z * radii.Z));
        }

        public Cartesian ScaleToGeodeticSurface(Cartesian position)
        {
            double beta = 1.0 / Math.Sqrt(
                (position.X * position.X) * _oneOverRadiiSquared.X +
                (position.Y * position.Y) * _oneOverRadiiSquared.Y +
                (position.Z * position.Z) * _oneOverRadiiSquared.Z);
            double n = new Cartesian(
                beta * position.X * _oneOverRadiiSquared.X,
                beta * position.Y * _oneOverRadiiSquared.Y,
                beta * position.Z * _oneOverRadiiSquared.Z).Magnitude;
            double alpha = (1.0 - beta) * (position.Magnitude / n);

            double x2 = position.X * position.X;
            double y2 = position.Y * position.Y;
            double z2 = position.Z * position.Z;

            double da = 0.0;
            double db = 0.0;
            double dc = 0.0;

            double s = 0.0;
            double dSdA = 1.0;

            do
            {
                alpha -= (s / dSdA);

                da = 1.0 + (alpha * _oneOverRadiiSquared.X);
                db = 1.0 + (alpha * _oneOverRadiiSquared.Y);
                dc = 1.0 + (alpha * _oneOverRadiiSquared.Z);

                double da2 = da * da;
                double db2 = db * db;
                double dc2 = dc * dc;

                double da3 = da * da2;
                double db3 = db * db2;
                double dc3 = dc * dc2;

                s = x2 / (_radiiSquared.X * da2) +
                    y2 / (_radiiSquared.Y * db2) +
                    z2 / (_radiiSquared.Z * dc2) - 1.0;

                dSdA = -2.0 *
                    (x2 / (_radiiToTheFourth.X * da3) +
                     y2 / (_radiiToTheFourth.Y * db3) +
                     z2 / (_radiiToTheFourth.Z * dc3));
            }
            while (Math.Abs(s) > 1e-10);

            return new Cartesian(
                position.X / da,
                position.Y / db,
                position.Z / dc);
        }

        public Cartesian GeodeticSurfaceNormal(Cartographic cartographic)
        {
            double cosLatitude = Math.Cos(cartographic.Latitude);
            return new Cartesian(
                cosLatitude * Math.Cos(cartographic.Longitude),
                cosLatitude * Math.Sin(cartographic.Longitude),
                Math.Sin(cartographic.Latitude));
        }

        public Cartesian GeodeticSurfaceNormal(Cartesian positionOnEllipsoid)
        {
            return new Cartesian(
                positionOnEllipsoid.X * _oneOverRadiiSquared.X, 
                positionOnEllipsoid.Y * _oneOverRadiiSquared.Y, 
                positionOnEllipsoid.Z * _oneOverRadiiSquared.Z).Normalize();
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
        private readonly Cartesian _radiiToTheFourth;
        private readonly Cartesian _oneOverRadiiSquared;
    }
}
