using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Schema;

namespace GenerateFromSchema
{
    public class MarkdownGenerator : Generator
    {
        private readonly string m_outputDirectory;
        private readonly HashSet<Schema> m_writtenSchemas = new HashSet<Schema>();

        public MarkdownGenerator(string outputDirectory)
        {
            m_outputDirectory = outputDirectory;
        }

        public override void Generate(Schema schema)
        {
            Generate(schema, false);
        }

        public void Generate(Schema schema, bool isValue)
        {
            if (m_writtenSchemas.Contains(schema))
                return;

            m_writtenSchemas.Add(schema);

            string fileName = schema.Name;
            if (isValue)
                fileName += "Value";

            using (var output = new StreamWriter(Path.Combine(m_outputDirectory, $"{fileName}.md")))
            {
                output.WriteLine("This page describes the possible content of a CZML document or stream.  Please read [[CZML Structure]] for an explanation of how a CZML document is put together.");
                output.WriteLine();

                output.WriteLine("# {0}{1}", schema.Name, isValue ? " (value)" : "");
                output.WriteLine();

                output.WriteLine(schema.Description);
                output.WriteLine();

                if (!string.IsNullOrWhiteSpace(schema.ExtensionPrefix))
                {
                    output.WriteLine("_Note: This type is an extension and may not be implemented by all CZML clients._");
                    output.WriteLine();
                }

                if (schema.Extends != null)
                {
                    output.WriteLine("**Extends**: [[{0}]]", schema.Extends.Name);
                    output.WriteLine();

                    Generate(schema.Extends);
                }

                if (isValue)
                {
                    output.WriteLine("**Type**: {0}", JsonSchemaTypesToLabel(schema.JsonTypes));
                    output.WriteLine();
                }
                else
                {
                    output.WriteLine("**Interpolatable**: {0}", schema.IsInterpolatable ? "yes" : "no");
                    output.WriteLine();
                }

                if (schema.Examples != null)
                {
                    output.WriteLine("**Examples**:");
                    output.WriteLine();

                    foreach (string example in schema.Examples)
                    {
                        output.WriteLine("```javascript");
                        output.WriteLine(example);
                        output.WriteLine("```");
                        output.WriteLine();
                    }
                }

                if (schema.EnumValues.Any())
                {
                    output.WriteLine("## Values");
                    output.WriteLine();

                    foreach (SchemaEnumValue enumValue in schema.EnumValues)
                    {
                        output.WriteLine("* `{0}` - {1}", enumValue.Name, enumValue.Description);
                        output.WriteLine();
                    }
                }

                if (schema.Properties.Count > 0)
                {
                    output.WriteLine("## Properties");
                    output.WriteLine();

                    foreach (Property property in schema.Properties)
                    {
                        Schema propertyValueType = property.ValueType;
                        string type =
                            propertyValueType.IsSchemaFromType
                                ? JsonSchemaTypesToLabel(property.ValueType.JsonTypes)
                                : string.Format("[[{0}{1}]]", propertyValueType.Name, property.IsValue ? "Value" : "");

                        output.WriteLine("**{0}** - {1}", property.Name, type);
                        output.WriteLine();
                        output.WriteLine(property.Description);
                        output.WriteLine();

                        JToken defaultToken = property.Default;
                        if (defaultToken != null)
                        {
                            string defaultValue;

                            if (defaultToken.Type == JTokenType.Boolean)
                                defaultValue = defaultToken.Value<bool>() ? "true" : "false";
                            else if (defaultToken.Type == JTokenType.Float)
                                defaultValue = defaultToken.Value<double>().ToString("0.0###############", CultureInfo.InvariantCulture);
                            else
                                defaultValue = defaultToken.Value<string>();

                            output.WriteLine("Default: `{0}`", defaultValue);
                            output.WriteLine();
                        }

                        if (property.Examples != null)
                        {
                            output.WriteLine("**Examples**:");
                            output.WriteLine();

                            foreach (string example in property.Examples)
                            {
                                output.WriteLine("```javascript");
                                output.WriteLine(example);
                                output.WriteLine("```");
                                output.WriteLine();
                            }
                        }

                        output.WriteLine();

                        if (!propertyValueType.IsSchemaFromType)
                        {
                            Generate(propertyValueType, property.IsValue);
                        }
                    }
                }

                if (schema.AdditionalProperties != null)
                {
                    var propertyValueType = schema.AdditionalProperties.ValueType;
                    output.WriteLine("This type represents a key-value mapping, where values are of type [[{0}]].", propertyValueType.Name);
                    output.WriteLine();

                    Generate(propertyValueType);
                }
            }
        }

        private static string JsonSchemaTypesToLabel(JsonSchemaType type)
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

            switch (index)
            {
                case 0:
                    return "";
                case 1:
                    return types[0];
                case 2:
                    return types[0] + " or " + types[1];
                default:
                    return string.Join(", ", types, 0, index - 1) + ", or " + types[index - 1];
            }
        }
    }
}