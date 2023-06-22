using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using JetBrains.Annotations;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

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

        private Schema LoadRelativeSchema(string baseFileName, string fileName)
        {
            return Load(Path.Combine(Path.GetDirectoryName(baseFileName), fileName));
        }

        private void LoadSchema(string schemaFileName, JObject schemaJson, Schema schema)
        {
            schema.Name = GetValue<string>(schemaJson, "title", null);
            schema.Description = GetValue<string>(schemaJson, "description", null);
            schema.ExtensionPrefix = GetValue<string>(schemaJson, "czmlExtensionPrefix", null);
            schema.IsValue = GetValue<bool>(schemaJson, "czmlValue", false);
            schema.Extends.AddRange(GetValues<string>(schemaJson, "allOf..$ref").Select(extend => LoadRelativeSchema(schemaFileName, extend)));
            schema.JsonTypes = LoadJsonSchemaType(schemaJson);

            if (schemaJson.Property("properties")?.Value is JObject properties)
            {
                schema.Properties.AddRange(properties.Properties().Select(property => LoadProperty(schemaFileName, property)));
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
                IsRequiredForDisplay = GetValue<bool>(propertySchema, "czmlRequiredForDisplay", false),
            };

            string refString = GetValue<string>(propertySchema, "$ref", null);
            if (refString != null)
            {
                result.ValueType = LoadRelativeSchema(schemaFileName, refString);
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

        private static SchemaType LoadJsonSchemaType(JObject schema)
        {
            JProperty type = schema.Property("type");
            if (type == null)
                return SchemaType.Any;

            if (type.Value is JArray arrayOfTypes)
            {
                SchemaType result = SchemaType.None;
                foreach (string typeName in arrayOfTypes.Values<string>())
                {
                    result |= GetSchemaType(typeName);
                }

                return result;
            }

            return GetSchemaType(type.Value.Value<string>());
        }

        private static T GetValue<T>([NotNull] JObject obj, string path, T defaultValue)
        {
            JToken token = obj.SelectToken(path);
            if (token == null)
                return defaultValue;
            return token.Value<T>();
        }

        private static IEnumerable<T> GetValues<T>([NotNull] JObject obj, string path)
        {
            return obj.SelectTokens(path).Select(token => token.Value<T>());
        }

        private static SchemaType GetSchemaType(string typeName)
        {
            switch (typeName)
            {
                case "string": return SchemaType.String;
                case "object": return SchemaType.Object;
                case "integer": return SchemaType.Integer;
                case "number": return SchemaType.Float;
                case "null": return SchemaType.Null;
                case "boolean": return SchemaType.Boolean;
                case "array": return SchemaType.Array;
                case "any": return SchemaType.Any;
                default: throw new InvalidOperationException();
            }
        }
    }
}