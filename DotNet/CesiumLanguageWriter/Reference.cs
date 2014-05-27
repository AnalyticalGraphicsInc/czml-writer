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
            : this(id, path, Escape(id, path))
        {
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="value"></param>
        public Reference(string value)
            : this(GetId(value), GetPath(value), value)
        {
        }

        private Reference(string id, string path, string value)
        {
            m_identifier = id;
            m_path = path;
            m_value = value;
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
        /// Gets the escaped CZML value of the reference.
        /// </summary>
        public string Value
        {
            get { return m_value; }
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
            return this.m_value == other.m_value;
        }

        /// <summary>
        /// Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
        /// </summary>
        /// <returns>A hash code for the current object.</returns>
        public override int GetHashCode()
        {
            return m_identifier.GetHashCode() ^ m_path.GetHashCode() ^ m_value.GetHashCode();
        }

        static private string Escape(string id, string path)
        {
            return id + "#" + path;
        }

        private static string GetPath(string value)
        {
            return value.Split(new[] { '#' })[0];
        }

        private static string GetId(string value)
        {
            return value.Split(new[] { '#' })[1];
        }

        private readonly string m_identifier;
        private readonly string m_path;
        private readonly string m_value;
    }
}
