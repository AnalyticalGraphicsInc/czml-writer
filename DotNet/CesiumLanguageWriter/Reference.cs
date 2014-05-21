using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Represents a link to another property.  References can be used to specify that
    /// two properties on different objects are in fact, the same property.  This also
    /// has the added benefit of cutting down on CZML file size.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct Reference : IEquatable<Reference>
    {
        /// <summary>
        /// Creates a new instance.
        /// </summary>
        /// <param name="id">The id of the object which contains the referenced property.</param>
        /// <param name="path">The path to the property in the referenced object.</param>
        public Reference(string id, string path)
        {
            m_identifier = id;
            m_path = path;
        }

        /// <summary>
        /// Gets the id of the object which contains the referenced property.
        /// </summary>
        public string Identifier
        {
            get { return m_identifier; }
        }

        /// <summary>
        /// Gets the path to the property in the referenced object.
        /// </summary>
        public string Path
        {
            get { return m_path; }
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="obj">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="obj"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public override bool Equals(object obj)
        {
            if (obj is Reference)
            {
                return Equals((Reference)obj);
            }
            else
            {
                return false;
            }
        }

        /// <summary>
        /// Indicates whether another object is exactly equal to this instance.
        /// </summary>
        /// <param name="other">The object to compare to this instance.</param>
        /// <returns><see langword="true"/> if <paramref name="other"/> is an instance of this type and represents the same value as this instance; otherwise, <see langword="false"/>.</returns>
        public bool Equals(Reference other)
        {
            return this.m_identifier == other.m_identifier && this.m_path == other.m_path;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_identifier.GetHashCode() ^ m_path.GetHashCode();
        }

        private readonly string m_identifier;
        private readonly string m_path;
    }
}
