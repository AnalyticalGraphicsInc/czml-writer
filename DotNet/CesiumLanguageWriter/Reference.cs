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
            : this(GetIdentifier(value), GetProperties(value), value)
        {
        }

        /// <summary>
        /// Creates a new instance from an id and property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public Reference(string identifier, string propertyName)
            : this(identifier, new[] { propertyName }, Escape(identifier, new[] { propertyName }))
        {
        }

        /// <summary>
        /// Creates a new instace from an id and a heirarchy of properties.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">An heirarchy of property names with each property being a sub-property of the previous one.</param>
        public Reference(string identifier, string[] propertyNames)
            : this(identifier, propertyNames, Escape(identifier, propertyNames))
        {

        }

        private Reference(string identfier, string[] propertyNames, string value)
        {
            m_identifier = identfier;
            m_properties = propertyNames;
            m_value = value;
        }

        /// <summary>
        /// Gets the identifier of the object which contains the referenced property.
        /// </summary>
        public string Identifier
        {
            get { return m_identifier; }
        }

        /// <summary>
        /// Gets the heirarchy of properties to be indexed on the referenced object.
        /// </summary>
        public string[] PropertyNames
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

        static private string Escape(string identfier, string[] propertyNames)
        {
            StringBuilder value = new StringBuilder();

            identfier = identfier.Replace(@"\", @"\\").Replace("#", @"\#").Replace(".", @"\.");
            value.Append(identfier);
            value.Append("#");
            for (var i = 0; i < propertyNames.Length; i++)
            {
                string property = propertyNames[i].Replace(@"\", @"\\").Replace("#", @"\#").Replace(".", @"\.");
                value.Append(property);
                if (i != propertyNames.Length - 1)
                {
                    value.Append(".");
                }
            }
            return value.ToString();
        }

        static int FindUnescaped(string value, int start, char delimiter)
        {
            int index;
            do
            {
                index = value.IndexOf(delimiter, start);
                if (index == -1)
                {
                    break;
                }

                var count = 0;
                int place = index - 1;
                while (place != -1 && value[place--] == '\\')
                {
                    count++;
                }
                if (count % 2 == 0)
                {
                    return index;
                }
                start = index + 1;
            } while (index != -1);
            return -1;
        }

        static private string[] TrySplit(string value, char delimiter)
        {
            var indices = new List<int>();
            var start = 0;
            int index;
            do
            {
                index = FindUnescaped(value, start, delimiter);
                if (index != -1)
                {
                    indices.Add(index);
                    start = index + 1;
                }
            } while (index != -1);

            var lastIndex = 0;
            var result = new string[indices.Count + 1];
            for (var i = 0; i < indices.Count; i++)
            {
                index = indices[i];
                result[i] = value.Substring(lastIndex, index - lastIndex).Replace(@"\#", "#").Replace(@"\\", @"\").Replace(@"\.", ".");
                lastIndex = index + 1;
            }
            result[indices.Count] = value.Substring(lastIndex, value.Length - lastIndex).Replace(@"\#", "#").Replace(@"\\", @"\").Replace(@"\.", ".");
            return result;
        }

        static private string GetIdentifier(string value)
        {
            string[] result = TrySplit(value, '#');
            if (result.Length != 2)
            {
                throw new ArgumentException(CesiumLocalization.InvalidReferenceString, "value");
            }
            return result[0];
        }

        static private string[] GetProperties(string value)
        {
            var index = FindUnescaped(value, 0, '#') + 1;
            var values = TrySplit(value.Substring(index, value.Length - index), '.');

            if (values.Length == 0)
            {
                throw new ArgumentException(CesiumLocalization.InvalidReferenceString, "value");
            }

            foreach (var item in values)
            {
                if (string.IsNullOrEmpty(item))
                {
                    throw new ArgumentException(CesiumLocalization.InvalidReferenceString, "value");
                }
            }

            return values;
        }

        private readonly string m_value;
        private readonly string m_identifier;
        private readonly string[] m_properties;
    }
}
