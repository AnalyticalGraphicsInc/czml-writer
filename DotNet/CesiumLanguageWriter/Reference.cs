using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// 
    /// </summary>
    [CSToJavaImmutableValueType]
    public struct Reference : IEquatable<Reference>
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="id"></param>
        /// <param name="path"></param>
        public Reference(string id, string path)
        {
            m_identifier = id;
            m_path = path;
        }

        /// <summary>
        /// 
        /// </summary>
        public string Identifier
        {
            get { return m_identifier; }
        }

        /// <summary>
        /// 
        /// </summary>
        public string Path
        {
            get { return m_path; }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="other"></param>
        /// <returns></returns>
        public bool Equals(Reference other)
        {
            throw new NotImplementedException();
        }

        private readonly string m_identifier;
        private readonly string m_path;
    }
}
