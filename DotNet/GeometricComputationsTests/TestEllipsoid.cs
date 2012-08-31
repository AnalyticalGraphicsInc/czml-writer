using System;
using NUnit.Framework;
using System.Collections.Generic;
using CesiumLanguageWriter;
using GeometricComputations;

namespace GeometricComputationsTests
{
    [TestFixture]
    public class EllipsoidTests
    {
        [Test]
        public void Construct()
        {
            Ellipsoid ellipsoid = new Ellipsoid(new Cartesian(1, 2, 3));
            Assert.AreEqual(1, ellipsoid.Radii.X);
            Assert.AreEqual(2, ellipsoid.Radii.Y);
            Assert.AreEqual(3, ellipsoid.Radii.Z);

            Ellipsoid ellipsoid2 = new Ellipsoid(new Cartesian(4, 5, 6));
            Assert.AreEqual(new Cartesian(4, 5, 6), ellipsoid2.Radii);

            Ellipsoid sphere = Ellipsoid.UnitSphere;
            Assert.IsTrue(sphere.RadiiSquared.Equals((new Cartesian(1, 1, 1))));
            Assert.IsTrue(sphere.OneOverRadiiSquared.Equals((new Cartesian(1, 1, 1))));
        }

        [Test]
        public void GeodeticSurfaceNormal()
        {
            Assert.IsTrue(new Cartesian(1, 0, 0).Equals(Ellipsoid.UnitSphere.GeodeticSurfaceNormal(new Cartesian(1, 0, 0))));
            Assert.IsTrue(new Cartesian(0, 0, 1).Equals(Ellipsoid.UnitSphere.GeodeticSurfaceNormal(new Cartesian(0, 0, 1))));
        }

        [Test]
        public void GeodeticSurfaceNormal2()
        {
            Assert.IsTrue(new Cartesian(1, 0, 0).EqualsEpsilon(
                Ellipsoid.UnitSphere.GeodeticSurfaceNormal(new Cartographic(0, 0, 0)), 1e-10));
            Assert.IsTrue(new Cartesian(0, 0, 1).EqualsEpsilon(
                Ellipsoid.UnitSphere.GeodeticSurfaceNormal(new Cartographic(0, Constants.HalfPi, 0)), 1e-10));
        }

        [Test]
        public void ToCartesian()
        {
            Ellipsoid ellipsoid = new Ellipsoid(new Cartesian(1, 1, 0.7));
            Assert.IsTrue(((Cartesian)UnitCartesian.UnitX).EqualsEpsilon(ellipsoid.ToCartesian(new Cartographic(0, 0, 0)), Constants.Epsilon10));
            Assert.IsTrue(((Cartesian)UnitCartesian.UnitY).EqualsEpsilon(ellipsoid.ToCartesian(new Cartographic(Constants.HalfPi, 0, 0)), Constants.Epsilon10));
            Assert.IsTrue(new Cartesian(0, 0, 0.7).EqualsEpsilon(ellipsoid.ToCartesian(new Cartographic(0, Constants.HalfPi, 0)), Constants.Epsilon10));
        }

        [Test]
        public void ScaleToGeodeticSurface()
        {
            Assert.IsTrue(new Cartesian(1, 0, 0).EqualsEpsilon(
                Ellipsoid.UnitSphere.ScaleToGeodeticSurface(new Cartesian(3, 0, 0)), 1e-10));
            Assert.IsTrue(new Cartesian(0, 0, 1).EqualsEpsilon(
                Ellipsoid.UnitSphere.ScaleToGeodeticSurface(new Cartesian(0, 0, 0.5)), 1e-10));
        }       
    }
}