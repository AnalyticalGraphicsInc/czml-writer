using System.Collections.Generic;
using System.IO;
using System.Linq;
using JetBrains.Annotations;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Schema;

namespace GenerateFromSchema
{
    public class SchemaLoader
    {
        [NotNull]
        private readonly Dictionary<string, Schema> m_schemas = new Dictionary<string, Schema>();
        private readonly string m_schemaDirectory;

        public SchemaLoader(string schemaDirectory)
        {
            m_schemaDirectory = schemaDirectory;
        }

        public Schema Load(string schemaFileName)
        {
            if (m_schemas.TryGetValue(schemaFileName, out var schema))
                return schema;

            using (var streamReader = new StreamReader(schemaFileName))
            using (var jsonReader = new JsonTextReader(streamReader))
            {
                schema = new Schema();
                m_schemas[schemaFileName] = schema;
                var schemaJson = JObject.Load(jsonReader);
                LoadSchema(schemaFileName, schemaJson, schema);
                return schema;
            }
        }

        private void LoadSchema(string schemaFileName, JObject schemaJson, Schema schema)
        {
            schema.Name = GetValue<string>(schemaJson, "title", null);
            schema.Description = GetValue<string>(schemaJson, "description", null);
            schema.ExtensionPrefix = GetValue<string>(schemaJson, "extensionPrefix", null);

            string extends = GetValue<string>(schemaJson, "extends.$ref", null);
            if (extends != null)
            {
                schema.Extends = Load(Path.Combine(Path.GetDirectoryName(schemaFileName), extends));
            }

            schema.JsonTypes = LoadJsonSchemaType(schemaJson);

            if (schemaJson.Property("properties")?.Value is JObject properties)
            {
                foreach (var property in properties.Properties())
                {
                    schema.Properties.Add(LoadProperty(schemaFileName, property));
                }
            }

            if (schemaJson.Property("required")?.Value is JArray requiredProperties)
            {
                foreach (string requiredPropertyName in requiredProperties.Values<string>())
                {
                    var property = schema.Properties.Find(p => p.Name == requiredPropertyName);
                    if (property != null)
                    {
                        property.IsRequired = true;
                    }
                }
            }

            var additionalProperties = schemaJson.Property("additionalProperties");
            if (additionalProperties != null)
            {
                schema.AdditionalProperties = LoadProperty(schemaFileName, additionalProperties);
            }

            schema.EnumValues = schemaJson.SelectTokens("oneOf[?(@.const)]")
                                          .Cast<JObject>()
                                          .Select(obj => new SchemaEnumValue
                                          {
                                              Name = obj.SelectToken("const").Value<string>(),
                                              Description = obj.SelectToken("description").Value<string>()
                                          }).ToList();

            if (schemaJson.Property("czmlExamples")?.Value is JArray czmlExamples)
            {
                schema.Examples = czmlExamples.Values<string>()
                                              .Select(filename => File.ReadAllText(Path.Combine(m_schemaDirectory, filename)))
                                              .ToList();
            }
        }

        private Property LoadProperty(string schemaFileName, JProperty property)
        {
            JObject propertySchema = (JObject)property.Value;

            Property result = new Property
            {
                Name = property.Name,
                Description = GetValue<string>(propertySchema, "description", null),
                Default = propertySchema.SelectToken("default"),
                IsValue = GetValue<bool>(propertySchema, "czmlValue", false)
            };

            string refString = GetValue<string>(propertySchema, "$ref", null);
            if (refString != null)
            {
                result.ValueType = Load(Path.Combine(Path.GetDirectoryName(schemaFileName), refString));
            }
            else
            {
                result.ValueType = new Schema
                {
                    Name = Schema.SchemaFromTypeName,
                    JsonTypes = LoadJsonSchemaType(propertySchema)
                };
            }

            if (propertySchema.Property("czmlExamples")?.Value is JArray czmlExamples)
            {
                result.Examples = czmlExamples.Values<string>()
                                              .Select(filename => File.ReadAllText(Path.Combine(m_schemaDirectory, filename)))
                                              .ToList();
            }

            return result;
        }

        private static JsonSchemaType LoadJsonSchemaType(JObject schema)
        {
            JProperty type = schema.Property("type");
            if (type == null)
                return JsonSchemaType.Any;

            if (type.Value is JArray arrayOfTypes)
            {
                JsonSchemaType result = JsonSchemaType.None;
                foreach (string typeName in arrayOfTypes.Values<string>())
                {
                    result |= s_jsonSchemaTypeMapping[typeName];
                }

                return result;
            }

            return s_jsonSchemaTypeMapping[type.Value.Value<string>()];
        }

        private static T GetValue<T>(JObject obj, string path, T defaultValue)
        {
            JToken token = obj.SelectToken(path);
            if (token == null)
                return defaultValue;
            return token.Value<T>();
        }

        [NotNull]
        private static readonly Dictionary<string, JsonSchemaType> s_jsonSchemaTypeMapping = new Dictionary<string, JsonSchemaType>
        {
            { "string", JsonSchemaType.String },
            { "object", JsonSchemaType.Object },
            { "integer", JsonSchemaType.Integer },
            { "number", JsonSchemaType.Float },
            { "null", JsonSchemaType.Null },
            { "boolean", JsonSchemaType.Boolean },
            { "array", JsonSchemaType.Array },
            { "any", JsonSchemaType.Any }
        };
    }
}