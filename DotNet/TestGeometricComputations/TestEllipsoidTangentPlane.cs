using System;
using System.Collections.Generic;
using NUnit.Framework;
using CesiumLanguageWriter;
using GeometricComputations;

namespace TestGeometricComputations
{
    [TestFixture]
    public class EllipsoidTangentPlaneTests
    {
        [Test]
        [ExpectedException(typeof(ArgumentNullException))]
        public void NullEllipsoid()
        {
            new EllipsoidTangentPlane(null, new List<Cartesian>());
        }

        [Test]
        [ExpectedException(typeof(ArgumentNullException))]
        public void NullPositions()
        {
            new EllipsoidTangentPlane(Ellipsoid.UnitSphere, null);
        }

        [Test]
        [ExpectedException(typeof(ArgumentOutOfRangeException))]
        public void EmptyPositions()
        {
            new EllipsoidTangentPlane(Ellipsoid.UnitSphere, new List<Cartesian>());
        }

        [Test]
        public void TangentPlane()
        {
            new EllipsoidTangentPlane(
                Ellipsoid.UnitSphere, new Cartesian[] { new Cartesian(1, 0, 0) });
        }

        [Test]
        public void TangentPlane2()
        {
            new EllipsoidTangentPlane(
                Ellipsoid.UnitSphere, new Cartesian[] { new Cartesian(0, 0, 1) });
        }
    }
}