using System.Collections.Generic;
using Newtonsoft.Json.Linq;

namespace GenerateFromSchema
{
    public class Property
    {
        public string Name { get; set; }

        public string Description
        {
            get
            {
                if (m_description != null)
                    return m_description;
                if (ValueType != null)
                    return ValueType.Description;
                return null;
            }
            set { m_description = value; }
        }

        public Schema ValueType { get; set; }

        public JToken Default { get; set; }

        public List<string> Examples { get; set; }

        public bool IsValue { get; set; }

        public string NameWithPascalCase
        {
            get
            {
                if (Name.Length == 0)
                    return Name;

                string name = string.IsNullOrEmpty(ValueType.ExtensionPrefix) ? Name : Name.Substring(ValueType.ExtensionPrefix.Length + 1);
                return name.CapitalizeFirstLetter();
            }
        }

        public bool IsInterpolatable
        {
            get { return ValueType.IsInterpolatable; }
        }

        private string m_description;
    }
}