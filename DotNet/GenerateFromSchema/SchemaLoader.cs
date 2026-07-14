namespace GenerateFromSchema;

public class SchemaLoader(string schemaDirectory)
{
    public Schema Load(string schemaFileName)
    {
        if (Schemas.TryGetValue(schemaFileName, out var schema))
            return schema;

        JsonNode ReadSchemaJson()
        {
            using var stream = File.OpenRead(schemaFileName);
            return JsonNode.Parse(stream) ?? throw new InvalidOperationException("Invalid schema JSON.");
        }

        var schemaJson = ReadSchemaJson();

        schema = new Schema
        {
            Name = schemaJson.GetRequiredProperty("title"),
            Description = schemaJson.GetRequiredProperty("description"),
            ExtensionPrefix = schemaJson.GetProperty<string?>("czmlExtensionPrefix"),
            IsValue = schemaJson.GetProperty("czmlValue", false),
            JsonTypes = LoadJsonSchemaType(schemaJson),
        };

        Schemas[schemaFileName] = schema;

        if (schemaJson["allOf"] is JsonArray allOfArray)
        {
            schema.Extends.AddRange(from extend in allOfArray.OfType<JsonNode>()
                                    select extend.GetRequiredProperty("$ref")
                                    into refString
                                    select LoadRelativeSchema(schemaFileName, refString));
        }

        if (schemaJson["properties"] is JsonObject properties)
        {
            foreach (var (propertyName, propertyValue) in properties)
            {
                if (propertyValue is JsonObject propertySchema)
                {
                    schema.Properties.Add(LoadProperty(schemaFileName, propertyName, propertySchema));
                }
            }
        }

        if (schemaJson["additionalProperties"] is JsonObject additionalProperties)
        {
            schema.AdditionalProperties = LoadProperty(schemaFileName, "additionalProperties", additionalProperties);
        }

        if (schemaJson["oneOf"] is JsonArray oneOfArray)
        {
            schema.EnumValues.AddRange(from jsonNode in oneOfArray.OfType<JsonNode>()
                                       select new SchemaEnumValue
                                       {
                                           Name = jsonNode.GetRequiredProperty("const"),
                                           Description = jsonNode.GetRequiredProperty("description"),
                                       });
        }

        if (schemaJson["czmlExamples"] is JsonArray czmlExamples)
        {
            schema.Examples.AddRange(LoadExamples(czmlExamples));
        }

        return schema;
    }

    private Schema LoadRelativeSchema(string baseFileName, string fileName)
    {
        return Load(Path.Join(Path.GetDirectoryName(baseFileName)!, fileName));
    }

    private Property LoadProperty(string schemaFileName, string propertyName, JsonObject propertySchema)
    {
        var result = new Property
        {
            Name = propertyName,
            Description = propertySchema.GetProperty<string?>("description"),
            Default = propertySchema["default"]?.AsValue(),
            IsRequiredForDisplay = propertySchema.GetProperty("czmlRequiredForDisplay", false),
            ValueType = LoadValueType(),
        };

        if (propertySchema["czmlExamples"] is JsonArray czmlExamples)
        {
            result.Examples.AddRange(LoadExamples(czmlExamples));
        }

        return result;

        Schema LoadValueType() =>
            propertySchema.GetProperty<string?>("$ref") switch
            {
                { } refString => LoadRelativeSchema(schemaFileName, refString),
                _ => new Schema
                {
                    Name = Schema.SchemaFromTypeName,
                    JsonTypes = LoadJsonSchemaType(propertySchema),
                    Description = Schema.SchemaFromTypeName,
                },
            };
    }

    private IEnumerable<string> LoadExamples(JsonArray examples) =>
        from jsonValue in examples.OfType<JsonValue>()
        select jsonValue.GetValue<string>()
        into filename
        select File.ReadAllText(GetRelativePath(filename));

    private static SchemaType LoadJsonSchemaType(JsonNode schema)
    {
        return schema["type"] switch
        {
            JsonArray arrayOfTypes => LoadArrayOfTypes(arrayOfTypes),
            JsonValue singleType => GetSchemaType(singleType.GetValue<string>()),
            _ => SchemaType.Any,
        };

        static SchemaType LoadArrayOfTypes(JsonArray arrayOfTypes) =>
            arrayOfTypes.OfType<JsonValue>()
                        .Select(node => node.GetValue<string>())
                        .Aggregate(SchemaType.None, (current, typeName) => current | GetSchemaType(typeName));

        static SchemaType GetSchemaType(string typeName) =>
            typeName switch
            {
                "string" => SchemaType.String,
                "object" => SchemaType.Object,
                "integer" => SchemaType.Integer,
                "number" => SchemaType.Float,
                "null" => SchemaType.Null,
                "boolean" => SchemaType.Boolean,
                "array" => SchemaType.Array,
                "any" => SchemaType.Any,
                _ => throw new InvalidOperationException($"Invalid schema type '{typeName}'"),
            };
    }

    private string GetRelativePath(string path) => Path.Join(SchemaDirectory, path);

    private Dictionary<string, Schema> Schemas { get; } = [];
    private string SchemaDirectory { get; } = schemaDirectory;
}
