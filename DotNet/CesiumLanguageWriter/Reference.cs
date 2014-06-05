using System;
using System.Collections.Generic;
using System.Text;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Represents a link to another property.  References can be used to specify that
    /// two properties on different objects are in fact, the same property.  This also
    /// has the added benefit of cutting down on CZML file size.
    /// 
    /// The formatted reference string contains the identifier of the target object followed
    /// by a hashtag (#) and one or more property names, each separated by a period (.).
    /// Any hash symbols or periods that exist in the reference identifier or property must
    /// be properly escaped with a backslash (\\) in order for the reference to be valid.
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct Reference : IEquatable<Reference>
    {
        /// <summary>
        /// Creates a new instances from an escaped reference string.
        /// </summary>
        /// <param name="value">The </param>
        public Reference(string value)
        {
            m_value = value;
            Parse(value, out m_identifier, out m_properties);
        }

        /// <summary>
        /// Creates a new instance from an id and property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public Reference(string identifier, string propertyName)
        {
            m_identifier = identifier;
            m_properties = new List<string>();
            m_properties.Add(propertyName);
            m_value = FormatReference(m_identifier, m_properties);
        }

        /// <summary>
        /// Creates a new instace from an id and a hierarchy of properties.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">An hierarchy of property names with each property being a sub-property of the previous one.</param>
        public Reference(string identifier, IEnumerable<string> propertyNames)
        {
            m_identifier = identifier;
            m_properties = new List<string>(propertyNames);
            m_value = FormatReference(m_identifier, m_properties);
        }

        /// <summary>
        /// Gets the identifier of the object which contains the referenced property.
        /// </summary>
        public string Identifier
        {
            get { return m_identifier; }
        }

        /// <summary>
        /// Gets the hierarchy of properties to be indexed on the referenced object.
        /// </summary>
        public IEnumerable<string> PropertyNames
        {
            get { return m_properties; }
        }

        /// <summary>
        /// Gets the escaped CZML value of the reference.
        /// </summary>
        public string Value
        {
            get { return m_value; }
        }

        /// <summary>
        /// Gets the escaped CZML value of the reference.
        /// </summary>
        /// <returns>The escaped CZML value of the reference.</returns>
        public override string ToString()
        {
            return m_value;
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
            return m_identifier.GetHashCode() ^ m_properties.GetHashCode() ^ m_value.GetHashCode();
        }

        static private string FormatReference(string identifier, IEnumerable<string> propertyNames)
        {
            StringBuilder value = new StringBuilder();

            identifier = identifier.Replace(@"\", @"\\").Replace("#", @"\#").Replace(".", @"\.");
            value.Append(identifier);
            value.Append("#");
            foreach (var propertyName in propertyNames)
            {
                string property = propertyName.Replace(@"\", @"\\").Replace("#", @"\#").Replace(".", @"\.");
                value.Append(property);
                value.Append(".");
            }
            value.Remove(value.Length - 1, 1);
            return value.ToString();
        }

        static private void Parse(string value, out string identifier, out List<string> values)
        {
            identifier = string.Empty;
            values = new List<string>();

            var inIdentifier = true;
            var isEscaped = false;
            var token = string.Empty;
            for (var i = 0; i < value.Length; ++i)
            {
                var c = value[i];

                if (isEscaped)
                {
                    token += c;
                    isEscaped = false;
                }
                else if (c == '\\')
                {
                    isEscaped = true;
                }
                else if (inIdentifier && c == '#')
                {
                    identifier = token;
                    inIdentifier = false;
                    token = string.Empty;
                }
                else if (!inIdentifier && c == '.')
                {
                    if (string.IsNullOrEmpty(token))
                        throw new ArgumentException(CesiumLocalization.InvalidReferenceString);

                    values.Add(token);
                    token = string.Empty;
                }
                else
                {
                    token += c;
                }
            }
            values.Add(token);

            if (string.IsNullOrEmpty(token))
                throw new ArgumentException(CesiumLocalization.InvalidReferenceString);

            if (inIdentifier)
                throw new ArgumentException(CesiumLocalization.InvalidReferenceString);
        }

        private readonly string m_value;
        private readonly string m_identifier;
        private readonly List<string> m_properties;
    }
}
