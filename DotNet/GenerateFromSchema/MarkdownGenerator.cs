﻿using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using Newtonsoft.Json.Linq;

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
                output.WriteLine("This page describes the possible content of a CZML document or stream. Please read [[CZML Structure]] for an explanation of how a CZML document is put together.");
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

                foreach (var extends in schema.Extends.Where(s => s.Properties.Any()))
                {
                    output.WriteLine("**Extends**: [[{0}]]", extends.Name);
                    output.WriteLine();

                    Generate(extends);
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

                if (schema.AllProperties.Any())
                {
                    output.WriteLine("## Properties");
                    output.WriteLine();

                    foreach (var property in schema.Properties)
                    {
                        Schema propertyValueType = property.ValueType;
                        string type =
                            propertyValueType.IsSchemaFromType
                                ? JsonSchemaTypesToLabel(property.ValueType.JsonTypes)
                                : string.Format("[[{0}{1}]]", propertyValueType.Name, property.IsValue ? "Value" : "");

                        output.Write("**{0}** - {1}", property.Name, type);
                        if (property.IsRequiredForDisplay)
                        {
                            output.Write(" - **Required**");
                        }
                        output.WriteLine();
                        output.WriteLine();

                        output.WriteLine(property.Description);
                        output.WriteLine();

                        JToken defaultToken = property.Default;
                        if (defaultToken != null)
                        {
                            string defaultValue;

                            switch (defaultToken.Type)
                            {
                                case JTokenType.Boolean:
                                    defaultValue = defaultToken.Value<bool>() ? "true" : "false";
                                    break;
                                case JTokenType.Float:
                                    defaultValue = defaultToken.Value<double>().ToString("0.0###############", CultureInfo.InvariantCulture);
                                    break;
                                default:
                                    defaultValue = defaultToken.Value<string>();
                                    break;
                            }

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

        private static string JsonSchemaTypesToLabel(SchemaType type)
        {
            var types = new List<string>();
            if (type.HasFlag(SchemaType.String))
                types.Add("string");
            if (type.HasFlag(SchemaType.Float) || type.HasFlag(SchemaType.Integer))
                types.Add("number");
            if (type.HasFlag(SchemaType.Boolean))
                types.Add("boolean");
            if (type.HasFlag(SchemaType.Object))
                types.Add("object");
            if (type.HasFlag(SchemaType.Array))
                types.Add("array");
            if (type.HasFlag(SchemaType.Null))
                types.Add("null");

            switch (types.Count)
            {
                case 0:
                    return "";
                case 1:
                    return types[0];
                case 2:
                    return types[0] + " or " + types[1];
                default:
                    return string.Join(", ", types.Take(types.Count - 1)) + ", or " + types.Last();
            }
        }
    }
}