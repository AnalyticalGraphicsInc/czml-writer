using System;
using System.Collections.Generic;
using Newtonsoft.Json.Linq;

namespace GenerateFromSchema
{
    public class Property
    {
        public string Name { get; set; }

        public string Description { get; set; }

        public Schema ValueType { get; set; }

        public JToken Default { get; set; }

        public Scope Scope { get; set; }

        public List<string> Examples { get; set; }

        public bool IsValue { get; set; }

        public string NameWithPascalCase
        {
            get
            {
                if (Name.Length == 0)
                    return Name;

                var tmp = string.IsNullOrEmpty(ValueType.ExtensionPrefix) ? Name : Name.Substring(ValueType.ExtensionPrefix.Length + 1);
                return Char.ToUpperInvariant(tmp[0]) + tmp.Substring(1);
            }
        }

        public bool IsInterpolatable
        {
            get
            {
                return ValueType.Extends != null &&
                       ValueType.Extends.Name == "InterpolatableProperty";
            }
        }
    }
}
