using System;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.Text;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A set of curvilinear 3-dimensional coordinates.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct Cartographic : IEquatable<Cartographic>
    {
        /// <summary>
        /// Gets a set of <see cref="Cartographic"/> coordinates representing the zero vector.
        /// </summary>
        public static Cartographic Zero
        {
            get
            {
                return s_zero;
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartographic"/> coordinates from the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <param name="startIndex">The index of the first element in the array to use.</param>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the array of <paramref name="elements"/> is null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when an object of this type is constructed from an array with less than 3 <paramref name="elements"/>.
        /// </exception>
        public Cartographic(double[] elements, int startIndex)
        {
            if (elements == null)
            {
                throw new ArgumentNullException("elements");
            }
            else if (startIndex >= elements.Length ||
                     elements.Length - startIndex < s_length)
            {
                throw new ArgumentOutOfRangeException("elements", String.Format(CultureInfo.CurrentCulture, CesiumLocalization.MustBeConstructedFromSpecificNumberOfElements, typeof(Cartographic), 3));
            }
            else
            {
                m_longitude = elements[startIndex + 0];
                m_latitude = elements[startIndex + 1];
                m_height = elements[startIndex + 2];
            }
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartographic"/> coordinates from the first 3 consecutive elements in the provided array.
        /// </summary>
        /// <param name="elements">The array of coordinate values.</param>
        /// <exception cref="ArgumentNullException">
        /// The array of <paramref name="elements"/> cannot be null.
        /// </exception>
        /// <exception cref="ArgumentOutOfRangeException">
        /// An object of this type must be constructed from an array with at least 3 <paramref name="elements"/>.
        /// </exception>
        public Cartographic(double[] elements)
            : this(elements, 0)
        {
        }

        /// <summary>
        /// Initializes a set of <see cref="Cartographic"/> coordinates from the provided values.
        /// </summary>
        /// <param name="longitude">The angular coordinate lying in the equatorial plane of the ellipsoid and measured from the prime meridian.</param>
        /// <param name="latitude">The angular coordinate measured perpendicular to the equatorial plane.</param>
        /// <param name="height">The linear coordinate measured perpendicular to the surface of the ellipsoid and positive above the surface.</param>
        public Cartographic(double longitude, double latitude, double height)
        {
            m_longitude = longitude;
            m_latitude = latitude;
            m_height = height;
        }

        /// <summary>
        /// Gets the angular coordinate lying in the equatorial plane of the ellipsoid and measured from the prime meridian.
        /// </summary>
        public double Longitude
        {
            get { return m_longitude; }
        }

        /// <summary>
        /// Gets the angular coordinate measured perpendicular to the equatorial plane.
        /// </summary>
        public double Latitude
        {
            get { return m_latitude; }
        }

        /// <summary>
        /// Gets the linear coordinate measured perpendicular to the surface of the ellipsoid and positive above the surface.
        /// </summary>
        public double Height
        {
            get { return m_height; }
        }

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/ValueType/Method[@name="Equals"]/*'/>
        public override bool Equals(object obj)
        {
            if (obj is Cartographic)
            {
                return Equals((Cartographic)obj);
            }
            else
            {
                return false;
            }
        }

        /// <summary>
        /// Indicates whether each coordinate value of another instance of this type
        /// is within the required tolerance of the corresponding coordinate value of this instance.
        /// </summary>
        /// <param name="other">The set of <see cref="Cartographic"/> coordinates to compare to this instance.</param>
        /// <param name="epsilon">The limit at which the absolute differences between the coordinate values will not be considered equal.</param>
        /// <returns>
        /// <see langword="true"/> if the absolute differences are less than <paramref name="epsilon"/>; otherwise, <see langword="false"/>.
        /// </returns>
        public bool EqualsEpsilon(Cartographic other, double epsilon)
        {
            return Math.Abs(Longitude - other.Longitude) < epsilon &&
                   Math.Abs(Latitude - other.Latitude) < epsilon &&
                   Math.Abs(Height - other.Height) < epsilon;
        }

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/ValueType/Method[@name="GetHashCode"]/*'/>
        public override int GetHashCode()
        {
            return m_longitude.GetHashCode() ^ m_latitude.GetHashCode() ^ m_height.GetHashCode();
        }

        /// <summary>
        /// Returns the string representation of the value of this instance.
        /// </summary>
        /// <returns>
        /// A string that represents the value of this instance in the form
        /// "Longitude, Latitude, Height".
        /// </returns>
        public override string ToString()
        {
            StringBuilder build = new StringBuilder(80);
            build.Append(m_longitude.ToString(CultureInfo.CurrentCulture));
            build.Append(", ");
            build.Append(m_latitude.ToString(CultureInfo.CurrentCulture));
            build.Append(", ");
            build.Append(m_height.ToString(CultureInfo.CurrentCulture));
            return build.ToString();
        }

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/ValueType/Operator[@name="Equality"]/*'/>
        public static bool operator ==(Cartographic left, Cartographic right)
        {
            return left.Equals(right);
        }

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/ValueType/Operator[@name="Inequality"]/*'/>
        public static bool operator !=(Cartographic left, Cartographic right)
        {
            return !left.Equals(right);
        }

        /// <include file='../Documentation/StandardMethods.xml' path='StandardMethods/IEquatableOfT/Method[@name="Equals"]/*'/>
        public bool Equals(Cartographic other)
        {
            return Longitude == other.Longitude && Latitude == other.Latitude && Height == other.Height;
        }

        /// <summary>
        /// Gets the number of elements in this set of coordinates.
        /// </summary>
        public int Length
        {
            get
            {
                return s_length;
            }
        }

        /// <summary>
        /// Gets the value of the specified element with <paramref name="index"/> of 0, 1, and 2 corresponding to the coordinates
        /// "Longitude, Latitude, Height".
        /// </summary>
        /// <param name="index">Either a 0, 1, or 2 corresponding to the coordinates "Longitude, Latitude, Height".</param>
        /// <returns>The coordinate associated with the specified <paramref name="index"/>.</returns>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when the <paramref name="index"/> is less than 0 or greater than or equal to the <see cref="Length"/>.
        /// </exception>
        public double this[int index]
        {
            get
            {
                switch (index)
                {
                    case 0:
                        return Longitude;
                    case 1:
                        return Latitude;
                    case 2:
                        return Height;
                    default:
                        throw new ArgumentOutOfRangeException("index");
                }
            }
        }
        private readonly double m_latitude;
        private readonly double m_longitude;
        private readonly double m_height;

        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        private static readonly int s_length = 3;

        private static readonly Cartographic s_zero = new Cartographic(0.0, 0.0, 0.0);
    }
}
