using System.Collections.Generic;
using System.IO;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using Newtonsoft.Json.Schema;

namespace GenerateFromSchema
{
    public class SchemaLoader
    {
        private readonly Dictionary<string, Schema> m_schemas = new Dictionary<string, Schema>();
        private readonly string m_schemaDirectory;

        public SchemaLoader(string schemaDirectory)
        {
            m_schemaDirectory = schemaDirectory;
        }

        public Schema Load(string schemaFileName)
        {
            Schema result;
            if (m_schemas.TryGetValue(schemaFileName, out result))
                return result;

            using (var streamReader = new StreamReader(schemaFileName))
            using (var jsonReader = new JsonTextReader(streamReader))
            {
                result = new Schema();
                m_schemas[schemaFileName] = result;
                JObject schemaJson = JObject.Load(jsonReader);
                LoadSchema(schemaJson, result);
                return result;
            }
        }

        private void LoadSchema(JObject schemaJson, Schema schema)
        {
            schema.Name = GetValue<string>(schemaJson, "title", null);
            schema.Description = GetValue<string>(schemaJson, "description", null);
            schema.ExtensionPrefix = GetValue<string>(schemaJson, "extensionPrefix", null);

            string extends = GetValue<string>(schemaJson, "extends.$ref", null);
            if (extends != null)
                schema.Extends = Load(Path.Combine(m_schemaDirectory, extends));

            schema.JsonTypes = LoadJsonSchemaType(schemaJson);

            JProperty propertiesProperty = schemaJson.Property("properties");
            if (propertiesProperty != null)
            {
                JObject propertiesPropertyValue = (JObject)propertiesProperty.Value;
                foreach (JProperty propertyProperty in propertiesPropertyValue.Properties())
                {
                    schema.Properties.Add(LoadProperty(propertyProperty));
                }
            }

            JProperty additionalPropertiesProperty = schemaJson.Property("additionalProperties");
            if (additionalPropertiesProperty != null)
            {
                schema.AdditionalProperties = LoadProperty(additionalPropertiesProperty);
            }
        }

        private Property LoadProperty(JProperty propertyProperty)
        {
            JObject propertySchema = (JObject)propertyProperty.Value;

            Property result = new Property
                              {
                                  Name = propertyProperty.Name,
                                  Description = GetValue<string>(propertySchema, "description", null),
                                  IsValue = GetValue<bool>(propertySchema, "czmlValue", false)
                              };

            string refString = GetValue<string>(propertySchema, "$ref", null);
            if (refString != null)
            {
                result.ValueType = Load(Path.Combine(m_schemaDirectory, refString));
            }
            else
            {
                result.ValueType = new Schema
                                   {
                                       Name = Schema.SchemaFromTypeName,
                                       JsonTypes = LoadJsonSchemaType(propertySchema)
                                   };
            }

            JProperty examplesProperty = propertySchema.Property("czmlExamples");
            if (examplesProperty != null)
            {
                result.Examples = new List<string>();

                JArray examples = (JArray)examplesProperty.Value;
                foreach (string filename in examples.Values<string>())
                {
                    result.Examples.Add(File.ReadAllText(Path.Combine(m_schemaDirectory, filename)));
                }
            }

            return result;
        }

        private JsonSchemaType LoadJsonSchemaType(JObject schema)
        {
            JProperty type = schema.Property("type");
            if (type == null)
                return JsonSchemaType.Any;

            var arrayOfTypes = type.Value as JArray;
            if (arrayOfTypes != null)
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