using System;
using System.Collections.Generic;
using CesiumLanguageWriter;

namespace GeometricComputations
{
    /// <summary>
    /// Describes a bounding volume determined by finding the points spaced the farthest apart on the x-, y-, and z-axes.
    /// </summary>
    public struct AxisAlignedBoundingBox
    {
        /// <summary>
        /// Creates an instance of an AxisAlignedBoundingBox.
        /// </summary>
        /// <param name="positions">The <see cref="Cartesian"/> points to be contained within the bounding box.</param>
        public AxisAlignedBoundingBox(IEnumerable<Cartesian> positions)
        {
            if (positions == null)
            {
                throw new ArgumentNullException("positions");
            }

            double minimumX = double.MaxValue;
            double minimumY = double.MaxValue;
            double minimumZ = double.MaxValue;

            double maximumX = -double.MaxValue;
            double maximumY = -double.MaxValue;
            double maximumZ = -double.MaxValue;

            foreach (Cartesian position in positions)
            {
                if (position.X < minimumX)
                {
                    minimumX = position.X;
                }

                if (position.X > maximumX)
                {
                    maximumX = position.X;
                }

                if (position.Y < minimumY)
                {
                    minimumY = position.Y;
                }

                if (position.Y > maximumY)
                {
                    maximumY = position.Y;
                }

                if (position.Z < minimumZ)
                {
                    minimumZ = position.Z;
                }

                if (position.Z > maximumZ)
                {
                    maximumZ = position.Z;
                }
            }

            Cartesian minimum = new Cartesian(minimumX, minimumY, minimumZ);
            Cartesian maximum = new Cartesian(maximumX, maximumY, maximumZ);

            if (minimum.AllComponentsAreGreaterThan(maximum))
            {
                Cartesian temp = minimum;
                minimum = maximum;
                maximum = temp;
            }

            _minimum = minimum;
            _maximum = maximum;
        }

        /// <summary>
        /// Gets the minimum point defining the bounding box.
        /// </summary>
        public Cartesian Minimum
        {
            get { return _minimum; }
        }

        /// <summary>
        /// Gets the maximum point defining the bounding box.
        /// </summary>
        public Cartesian Maximum
        {
            get { return _maximum; }
        }

        /// <summary>
        /// Gets the center point of the bounding box.
        /// </summary>
        public Cartesian Center
        {
            get { return (Minimum + Maximum) * 0.5; }
        }

        private readonly Cartesian _minimum;
        private readonly Cartesian _maximum;
    }
}
