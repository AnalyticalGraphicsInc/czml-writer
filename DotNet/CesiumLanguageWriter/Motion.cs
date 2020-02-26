using System;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Describes motion, including a coordinate and optionally one or more derivatives.
    /// </summary>
    /// <typeparam name="T">The coordinate type used to describe the motion.</typeparam>
    [CSToJavaImmutableValueType]
    public struct Motion<T> : IEquatable<Motion<T>>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="motion">The description of the motion.</param>
        /// <remarks>
        /// The first array element describes the value of the coordinate.  The second
        /// describes the first derivative, the third describes the second derivative, and so on.
        /// The array must have at least one element.
        /// </remarks>
        /// <exception cref="ArgumentNullException">
        /// Thrown when the parameter <paramref name="motion"/> is <see langword="null"/>.
        /// </exception>
        /// <exception cref="InvalidOperationException">
        /// Thrown when the <paramref name="motion"/> does not contain any values.
        /// </exception>
        public Motion([NotNull] params T[] motion)
        {
            if (motion == null)
                throw new ArgumentNullException("motion");

            if (motion.Length < 1)
                throw new InvalidOperationException(CesiumLocalization.MotionMustContainValue);

            m_motion = motion;
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        /// <remarks>
        /// For two Motion instances to be considered equal, the value and derivatives of each
        /// must compare as equal.
        /// </remarks>
        public bool Equals(Motion<T> other)
        {
            if (m_motion == null && other.m_motion == null)
            {
                return true;
            }

            if (m_motion == null ||
                other.m_motion == null ||
                m_motion.Length != other.m_motion.Length)
            {
                return false;
            }

            for (int i = 0; i < m_motion.Length; ++i)
            {
                if (!m_motion[i].Equals(other.m_motion[i]))
                {
                    return false;
                }
            }

            return true;
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        /// <remarks>
        /// For two Motion instances to be considered equal, the value and derivatives of each
        /// must compare as equal.
        /// </remarks>
        public override bool Equals(object obj)
        {
            return obj is Motion<T> && Equals((Motion<T>)obj);
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(Order.GetHashCode(),
                                    HashCode.GetHashCode(m_motion));
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        /// <remarks>
        /// For two Motion instances to be considered equal, the value and derivatives of each
        /// must compare as equal.
        /// </remarks>
        public static bool operator ==(Motion<T> left, Motion<T> right)
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
        /// <remarks>
        /// For two Motion instances to be considered equal, the value and derivatives of each
        /// must compare as equal.
        /// </remarks>
        public static bool operator !=(Motion<T> left, Motion<T> right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Gets the value of the coordinate.
        /// </summary>
        public T Value
        {
            get { return this[0]; }
        }

        /// <summary>
        /// Gets the first derivative, if it is available.
        /// </summary>
        /// <exception cref="ArgumentOutOfRangeException">
        /// This motion instance does not contain a first derivative.
        /// </exception>
        public T FirstDerivative
        {
            get { return this[1]; }
        }

        /// <summary>
        /// Gets the second derivative, if it is available.
        /// </summary>
        /// <exception cref="ArgumentOutOfRangeException">
        /// This motion instance does not contain a second derivative.
        /// </exception>
        public T SecondDerivative
        {
            get { return this[2]; }
        }

        /// <summary>
        /// Gets the indicated component of the motion.
        /// Index 0 retrieves the coordinate value.  Index 1 retrieves the first derivative, if it
        /// exists.  Index 2 retrieves the second derivative, if it exists.  The number of available
        /// derivatives is indicated by the <see cref="Order"/> property.
        /// </summary>
        /// <param name="index">The index of the motion component to retrieve.</param>
        /// <returns>The requested motion component.</returns>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when the <paramref name="index"/> is not between zero and the <see cref="Order"/> inclusive.
        /// </exception>
        public T this[int index]
        {
            [CSToJavaUseNullForDefaultGenericTypeValue("T")]
            get
            {
                if (m_motion == null)
                {
                    if (index == 0)
                    {
                        return default(T);
                    }

                    throw new ArgumentOutOfRangeException("index");
                }

                if (index >= 0 && index < m_motion.Length)
                {
                    return m_motion[index];
                }

                throw new ArgumentOutOfRangeException("index");
            }
        }

        /// <summary>
        /// Gets the number of derivatives described by this instance.
        /// </summary>
        public int Order
        {
            get
            {
                if (m_motion == null)
                    return 0;

                return m_motion.Length - 1;
            }
        }

        private readonly T[] m_motion;
    }

    /// <summary>
    /// Describes motion, including a coordinate and optionally one or more derivatives.
    /// </summary>
    /// <typeparam name="T">The coordinate type used to describe the motion.</typeparam>
    /// <typeparam name="TDerivative">The derivative type used to describe the motion.</typeparam>
    [CSToJavaImmutableValueType]
    public struct Motion<T, TDerivative> : IEquatable<Motion<T, TDerivative>>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="value">The value of the coordinate.</param>
        /// <param name="derivatives">The derivatives describing the motion.</param>
        /// <remarks>
        /// The first array element describes the first derivative, the second describes
        /// the second derivative, and so on.
        /// </remarks>
        public Motion(T value, params TDerivative[] derivatives)
        {
            m_value = value;
            m_derivatives = derivatives;
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        /// <remarks>
        /// For two Motion instances to be considered equal, the value and derivatives of each
        /// must compare as equal.
        /// </remarks>
        public bool Equals(Motion<T, TDerivative> other)
        {
            if (m_value == null)
                return other.m_value == null;

            if (!m_value.Equals(other.m_value))
            {
                return false;
            }

            if (m_derivatives == null && other.m_derivatives == null)
            {
                return true;
            }

            if (m_derivatives == null ||
                other.m_derivatives == null ||
                m_derivatives.Length != other.m_derivatives.Length)
            {
                return false;
            }

            for (int i = 0; i < m_derivatives.Length; ++i)
            {
                if (!m_derivatives[i].Equals(other.m_derivatives[i]))
                {
                    return false;
                }
            }

            return true;
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        /// <remarks>
        /// For two Motion instances to be considered equal, the value and derivatives of each
        /// must compare as equal.
        /// </remarks>
        public override bool Equals(object obj)
        {
            return obj is Motion<T, TDerivative> && Equals((Motion<T, TDerivative>)obj);
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return HashCode.Combine(m_value.GetHashCode(),
                                    HashCode.GetHashCode(m_derivatives));
        }

        /// <summary>
        /// Returns <see langword="true"/> if the two instances are exactly equal.
        /// </summary>
        /// <param name="left">The instance to compare to <paramref name="right"/>.</param>
        /// <param name="right">The instance to compare to <paramref name="left"/>.</param>
        /// <returns>
        /// <see langword="true"/> if <paramref name="left"/> represents the same value as <paramref name="right"/>; otherwise, <see langword="false"/>.
        /// </returns>
        /// <remarks>
        /// For two Motion instances to be considered equal, the value and derivatives of each
        /// must compare as equal.
        /// </remarks>
        public static bool operator ==(Motion<T, TDerivative> left, Motion<T, TDerivative> right)
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
        /// <remarks>
        /// For two Motion instances to be considered equal, the value and derivatives of each
        /// must compare as equal.
        /// </remarks>
        public static bool operator !=(Motion<T, TDerivative> left, Motion<T, TDerivative> right)
        {
            return !left.Equals(right);
        }

        /// <summary>
        /// Gets the coordinate value.
        /// </summary>
        public T Value
        {
            get { return m_value; }
        }

        /// <summary>
        /// Gets the first derivative, if it is available.
        /// </summary>
        /// <exception cref="ArgumentOutOfRangeException">
        /// This motion instance does not contain a first derivative.
        /// </exception>
        public TDerivative FirstDerivative
        {
            get { return this[1]; }
        }

        /// <summary>
        /// Gets the second derivative, if it is available.
        /// </summary>
        /// <exception cref="ArgumentOutOfRangeException">
        /// This motion instance does not contain a second derivative.
        /// </exception>
        public TDerivative SecondDerivative
        {
            get { return this[2]; }
        }

        /// <summary>
        /// Gets the indicated derivative of the motion.
        /// Index 1 retrieves the first derivative, if it exists.  Index 2 retrieves the second
        /// derivative, if it exists.  The number of available derivatives is indicated by the
        /// <see cref="Order"/> property.
        /// </summary>
        /// <param name="index">The index of the derivative to retrieve.</param>
        /// <returns>The requested derivative.</returns>
        /// <remarks>Requesting index 0 will result in an <see cref="ArgumentOutOfRangeException"/>.</remarks>
        /// <exception cref="ArgumentOutOfRangeException">
        /// Thrown when the <paramref name="index"/> is less than one or greater than the <see cref="Order"/>.
        /// This exception can also be thrown if this object does not contain any derivatives.
        /// </exception>
        public TDerivative this[int index]
        {
            get
            {
                if (m_derivatives == null ||
                    index < 1 ||
                    index > m_derivatives.Length)
                {
                    throw new ArgumentOutOfRangeException("index");
                }
                return m_derivatives[index - 1];
            }
        }

        /// <summary>
        /// Gets the number of derivatives described by this instance.
        /// </summary>
        public int Order
        {
            get
            {
                if (m_derivatives == null)
                    return 0;

                return m_derivatives.Length;
            }
        }

        private readonly T m_value;
        private readonly TDerivative[] m_derivatives;
    }
}
