namespace GenerateFromSchema;

public class MarkdownGenerator(string outputDirectory) : Generator(outputDirectory)
{
    public override void Generate(Schema schema)
    {
        Generate(schema, false);
    }

    public void Generate(Schema schema, bool isValue)
    {
        if (!WrittenSchemas.Add(schema))
            return;

        string fileName = schema.Name;
        if (isValue)
            fileName += "Value";

        string filename = Path.Join(OutputDirectory, $"{fileName}.md");

        using var output = new StreamWriter(filename);

        output.WriteLine("This page describes the possible content of a CZML document or stream. Please read [[CZML Structure]] for an explanation of how a CZML document is put together.");
        output.WriteLine();

        output.WriteLine("# {0}{1}", schema.Name, isValue ? " (value)" : "");
        output.WriteLine();

        output.WriteLine(schema.Description);
        output.WriteLine();

        if (schema is { ExtensionPrefix.Length: > 0 })
        {
            output.WriteLine("_Note: This type is an extension and may not be implemented by all CZML clients._");
            output.WriteLine();
        }

        foreach (var extends in schema.Extends.Where(s => s.Properties is { Count: > 0 }))
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

        if (schema is { Examples.Count: > 0 })
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

        if (schema is { EnumValues.Count: > 0 })
        {
            output.WriteLine("## Values");
            output.WriteLine();

            foreach (SchemaEnumValue enumValue in schema.EnumValues)
            {
                output.WriteLine("* `{0}` - {1}", enumValue.Name, enumValue.Description);
                output.WriteLine();
            }
        }

        if (schema is { AllProperties.Count: > 0 })
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

                if (property.Default is { } defaultValue)
                {
                    string defaultText = defaultValue switch
                    {
                        _ when defaultValue.TryGetValue(out bool boolValue) => boolValue ? "true" : "false",
                        _ when defaultValue.TryGetValue(out int intValue) => intValue.ToString(CultureInfo.InvariantCulture),
                        _ when defaultValue.TryGetValue(out double doubleValue) => doubleValue.ToString("0.0###############", CultureInfo.InvariantCulture),
                        _ => defaultValue.GetValue<string>(),
                    };

                    output.WriteLine("Default: `{0}`", defaultText);
                    output.WriteLine();
                }

                if (property is { Examples.Count: > 0 })
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

        return types switch
        {
            [] => "",
            [var single] => single,
            [var first, var second] => $"{first} or {second}",
            [.. var rest, var last] => $"{rest.Join(", ")}, or {last}",
        };
    }

    private HashSet<Schema> WrittenSchemas { get; } = [];
}
