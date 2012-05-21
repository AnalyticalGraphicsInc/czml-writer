using System;
using System.Collections.Generic;
using Newtonsoft.Json.Schema;

namespace GenerateFromSchema
{
    public class Schema
    {
        public string Name { get; set; }

        public string Description { get; set; }

        public Schema Extends { get; set; }

        public JsonSchemaType JsonTypes { get; set; }

        public List<Property> Properties { get; set; }

        public string NameWithPascalCase
        {
            get
            {
                if (Name.Length == 0)
                    return Name;

                return Char.ToUpperInvariant(Name[0]) + Name.Substring(1);
            }
        }
    }
}
