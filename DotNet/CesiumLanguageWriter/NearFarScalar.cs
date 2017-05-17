using System;
using System.Diagnostics.CodeAnalysis;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A numeric value which will be linearly interpolated between two values based 
    /// on an object's distance from the camera, in eye coordinates.  The computed value 
    /// will interpolate between the near value and the far value while the camera distance 
    /// falls between the near distance and the far distance, and will be clamped to the 
    /// near or far value while the distance is less than the near distance or greater 
    /// than the far distance, respectively.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct NearFarScalar : IEquatable<NearFarScalar>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        public NearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue)
        {
            m_nearDistance = nearDistance;
            m_nearValue = nearValue;
            m_farDistance = farDistance;
            m_farValue = farValue;
        }

        /// <summary>
        /// Gets the lower bound of the camera distance range.
        /// </summary>
        public double NearDistance
        {
            get { return m_nearDistance; }
        }

        /// <summary>
        /// Gets the value to use at the lower bound of the camera distance range.
        /// </summary>
        public double NearValue
        {
            get { return m_nearValue; }
        }

        /// <summary>
        /// Gets the upper bound of the camera distance range.
        /// </summary>
        public double FarDistance
        {
            get { return m_farDistance; }
        }

        /// <summary>
        /// Gets the value to use at the upper bound of the camera distance range.
        /// </summary>
        public double FarValue
        {
            get { return m_farValue; }
        }

        /// <summary>
        /// Indicates whether another instance of this type is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The instance to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        [SuppressMessage("ReSharper", "CompareOfFloatsByEqualityOperator")]
        public bool Equals(NearFarScalar other)
        {
            return m_nearDistance == other.m_nearDistance &&
                   m_nearValue == other.m_nearValue &&
                   m_farDistance == other.m_farDistance &&
                   m_farValue == other.m_farValue;
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            return obj is NearFarScalar && Equals((NearFarScalar)obj);
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_nearDistance.GetHashCode(),
                                    m_nearValue.GetHashCode(),
                                    m_farDistance.GetHashCode(),
                                    m_farValue.GetHashCode());
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// "NearDistance, NearValue, FarDistance, FarValue".
        /// </returns>
        public override string ToString()
        {
            return string.Format("{0}, {1}, {2}, {3}", m_nearDistance, m_nearValue, m_farDistance, m_farValue);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator ==(NearFarScalar left, NearFarScalar right)
        {
            return left.Equals(right);
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are not exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> does not represent the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public static bool operator !=(NearFarScalar left, NearFarScalar right)
        {
            return !left.Equals(right);
        }

        private readonly double m_nearDistance;
        private readonly double m_nearValue;
        private readonly double m_farDistance;
        private readonly double m_farValue;
    }
}
