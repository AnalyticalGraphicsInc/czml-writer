using System;
using System.Collections.Generic;
using System.IO;
using Newtonsoft.Json.Schema;

namespace GenerateWritersFromSchema
{
    public class MarkdownGenerator
    {
        public void Generate(Schema packetSchema, TextWriter output)
        {
            output.WriteLine("This page describes the possible content of a CZML document or stream.  Please read [[CZML Structure]] for an explanation of how a CZML document is put together.");
            output.WriteLine();
            output.WriteLine("_NOTE: This is a work in progress and reflects our plans NOT our current capabilities._");
            output.WriteLine();

            foreach (Property property in packetSchema.Properties)
            {
                GenerateProperty(2, "", property, output);
            }

        }

        private void GenerateProperty(int level, string prefix, Property property, TextWriter output)
        {
            output.WriteLine("{0} {1}{2}", new string('#', level), prefix, property.NameWithPascalCase);
            output.WriteLine();

            output.WriteLine(property.Description);
            output.WriteLine();

            output.WriteLine("**Property Name**: `{0}`", property.Name);
            output.WriteLine();
            output.WriteLine("**Interpolatable**: {0}", property.IsInterpolatable ? "yes" : "no");
            output.WriteLine();

            if (property.ValueType != null && property.ValueType.Properties != null)
            {
                bool propertiesAreLeaf = property.ValueType.Properties.Find(subProperty => subProperty.ValueType.Properties != null) == null;

                if (propertiesAreLeaf)
                    GenerateLeafProperties(property.ValueType, output);
                else
                {
                    foreach (Property nestedProperty in property.ValueType.Properties)
                    {
                        string newPrefix = property.NameWithPascalCase + ".";
                        if (prefix.Length != 0)
                            newPrefix = prefix + "." + newPrefix;
                        GenerateProperty(level + 1, newPrefix, nestedProperty, output);
                    }
                }

                Console.WriteLine();
            }

            if (property.Examples != null)
            {
                output.WriteLine("Examples:");
                output.WriteLine();

                foreach (string example in property.Examples)
                {
                    output.WriteLine("```javascript");
                    output.WriteLine(example);
                    output.WriteLine("```");
                    output.WriteLine();
                }
            }
        }

        private void GenerateLeafProperties(Schema schema, TextWriter output)
        {
            IEnumerable<Property> properties = schema.Properties;

            output.WriteLine("**Sub-properties**:");
            output.WriteLine();

            output.WriteLine("| Name | Scope | Type | Description |");
            output.WriteLine("|:-----|:------|:-----|:------------|");

            Schema current = schema;
            do
            {
                foreach (Property nestedProperty in current.Properties)
                {
                    output.WriteLine("| `{0}` | {1} | {2} | {3} |",
                                     nestedProperty.Name,
                                     nestedProperty.Scope,
                                     JsonSchemaTypesToLabel(nestedProperty.ValueType.JsonTypes),
                                     nestedProperty.Description);
                }

                current = current.Extends;
            } while (current != null);
        }

        private string JsonSchemaTypesToLabel(JsonSchemaType type)
        {
            var types = new string[6];

            int index = 0;

            if ((type & JsonSchemaType.String) == JsonSchemaType.String)
                types[index++] = "string";
            if ((type & JsonSchemaType.Float) == JsonSchemaType.Float || (type & JsonSchemaType.Integer) == JsonSchemaType.Integer)
                types[index++] = "number";
            if ((type & JsonSchemaType.Boolean) == JsonSchemaType.Boolean)
                types[index++] = "boolean";
            if ((type & JsonSchemaType.Object) == JsonSchemaType.Object)
                types[index++] = "object";
            if ((type & JsonSchemaType.Array) == JsonSchemaType.Array)
                types[index++] = "array";
            if ((type & JsonSchemaType.Null) == JsonSchemaType.Null)
                types[index++] = "null";

            if (index == 0)
                return "";
            else if (index == 1)
                return types[0];
            else if (index == 2)
                return types[0] + " or " + types[1];
            else
                return String.Join(", ", types, 0, index - 1) + ", or " + types[index - 1];
        }
    }
}
