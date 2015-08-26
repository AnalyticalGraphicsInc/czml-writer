using System;
using System.Collections.Generic;
using Newtonsoft.Json.Schema;

namespace GenerateFromSchema
{
    public class Schema
    {
        public string Name { get; set; }

        public string Description { get; set; }

        public string ExtensionPrefix { get; set; }

        public Schema Extends { get; set; }

        public JsonSchemaType JsonTypes { get; set; }

        public List<Property> Properties { get; set; }

        public bool GenerateWriter { get; set; }

        public List<Schema> CustomReferences { get; set; } 

        public bool IsSchemaFromType
        {
            get { return Name == SchemaFromTypeName; }
        }

        public string NameWithPascalCase
        {
            get
            {
                if (Name.Length == 0)
                    return Name;

                return Char.ToUpperInvariant(Name[0]) + Name.Substring(1);
            }
        }

        public Property FindFirstValueProperty()
        {
            if (Properties == null)
                return null;
            return Properties.Find(property => property.IsValue);
        }

        public static readonly string SchemaFromTypeName = "<Schema from Type>";
    }
}
