using System;
using System.Collections.Generic;
using CesiumLanguageWriter;

namespace GeometricComputations
{
    public struct AxisAlignedBoundingBox
    {
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

            if (minimum > maximum)
            {
                Utility.Swap(ref minimum, ref maximum);
            }

            _minimum = minimum;
            _maximum = maximum;
        }

        public Cartesian Minimum
        {
            get { return _minimum; }
        }

        public Cartesian Maximum
        {
            get { return _maximum; }
        }

        public Cartesian Center
        {
            get { return (Minimum + Maximum) * 0.5; }
        }

        private readonly Cartesian _minimum;
        private readonly Cartesian _maximum;
    }
}
