using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CesiumLanguageWriter;

namespace GeometricComputations
{
    /// <summary>
    /// Describes an ellipsoid and contains functions for coordinate transformations and scaling. 
    /// </summary>
    public class Ellipsoid
    {
        /// <summary>
        /// Represents the Earth as a WGS84 ellipsoid.
        /// </summary>
        public static readonly Ellipsoid Wgs84 = new Ellipsoid(new Cartesian(6378137.0, 6378137.0, 6356752.314245));

        /// <summary>
        /// The unit sphere.
        /// </summary>
        public static readonly Ellipsoid UnitSphere = new Ellipsoid(new Cartesian(1.0, 1.0, 1.0));
        
        /// <summary>
        /// Constructs a new instance of an Ellipsoid with specific radii.
        /// </summary>
        /// <param name="radii">The ellipsoid's radius in the x, y, and z directions</param>
        public Ellipsoid(Cartesian radii)
        {
            _radii = radii;
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

        /// <summary>
        /// Gets the Ellipsoid's radii.
        /// </summary>
        public Cartesian Radii 
        {
            get { return _radii; }
        }

        /// <summary>
        /// Gets the Ellipsoid's radii squared.
        /// </summary>
        public Cartesian RadiiSquared
        {
            get { return _radiiSquared; }
        }

        /// <summary>
        /// Gets the Ellipsoid's radii raise to the fourth.
        /// </summary>
        public Cartesian RadiiToTheFourth
        {
            get { return _radiiToTheFourth; }
        }

        /// <summary>
        /// Gets one over the Ellipsoid's radii squared.
        /// </summary>
        public Cartesian OneOverRadiiSquared
        {
            get { return _oneOverRadiiSquared; }
        }
        
        /// <summary>
        /// Scales a <see cref="Cartesian"/> point to the surface of the ellipsoid along the geodetic surface normal.
        /// </summary>
        /// <param name="position">The point to scale.</param>
        /// <returns>The position of the point on the ellipsoid's surface.</returns>
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

        /// <summary>
        /// Calculates the geodetic surface normal at a <see cref="Cartographic"/> point on the ellipsoid.
        /// </summary>
        /// <param name="positionOnEllipsoid">A <see cref="Cartographic"/> point on the Ellipsoid.</param>
        /// <returns>The geodetic surface normal at <paramref name="positionOnEllipsoid"/>.</returns>
        public Cartesian GeodeticSurfaceNormal(Cartographic cartographic)
        {
            double cosLatitude = Math.Cos(cartographic.Latitude);
            return new Cartesian(
                cosLatitude * Math.Cos(cartographic.Longitude),
                cosLatitude * Math.Sin(cartographic.Longitude),
                Math.Sin(cartographic.Latitude));
        }

        /// <summary>
        /// Calculates the geodetic surface normal at a point on the ellipsoid.
        /// </summary>
        /// <param name="positionOnEllipsoid">A <see cref="Cartesian"/> point on the Ellipsoid.</param>
        /// <returns>The geodetic surface normal at <paramref name="positionOnEllipsoid"/>.</returns>
        public Cartesian GeodeticSurfaceNormal(Cartesian positionOnEllipsoid)
        {
            return new Cartesian(
                positionOnEllipsoid.X * _oneOverRadiiSquared.X, 
                positionOnEllipsoid.Y * _oneOverRadiiSquared.Y, 
                positionOnEllipsoid.Z * _oneOverRadiiSquared.Z).Normalize();
        }
        
        /// <summary>
        /// Converts a <see cref="Cartographic"/> point to a <see cref="Cartesian"/> point based on the Ellipsoid.
        /// </summary>
        /// <param name="cartographic">The point to convert.</param>
        /// <returns>The transformed <see cref="Cartesian"/> point.</returns>
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

        private readonly Cartesian _radii;
        private readonly Cartesian _radiiSquared;
        private readonly Cartesian _radiiToTheFourth;
        private readonly Cartesian _oneOverRadiiSquared;
    }
}
