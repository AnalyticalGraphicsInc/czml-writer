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

            using (var packetStream = new StreamReader(schemaFileName))
            using (var packetJsonReader = new JsonTextReader(packetStream))
            {
                JObject schemaJson = JObject.Load(packetJsonReader);
                result = new Schema();
                m_schemas[schemaFileName] = result;
                LoadSchema(schemaJson, result);
                return result;
            }
        }

        private void LoadSchema(JObject schemaJson, Schema schema)
        {
            schema.Name = GetValue<string>(schemaJson, "title", null);
            schema.Description = GetValue<string>(schemaJson, "description", null);

            string extends = GetValue<string>(schemaJson, "extends.$ref", null);
            if (extends != null)
                schema.Extends = Load(Path.Combine(m_schemaDirectory, extends));

            schema.JsonTypes = LoadJsonSchemaType(schemaJson);

            JProperty propertiesProperty = schemaJson.Property("properties");
            if (propertiesProperty != null)
            {
                schema.Properties = new List<Property>();
                JObject propertiesJson = (JObject)propertiesProperty.Value;
                foreach (JProperty propertyJson in propertiesJson.Properties())
                {
                    Property property = new Property();
                    LoadProperty(propertyJson, property);
                    schema.Properties.Add(property);
                }
            }
        }

        private void LoadProperty(JProperty propertyJson, Property property)
        {
            var propertyObject = (JObject)propertyJson.Value;
            property.Name = GetValue<string>(propertyObject, "title", propertyJson.Name);
            property.Description = GetValue<string>(propertyObject, "description", null);
            property.Scope = GetValue<string>(propertyObject, "czmlScope", "INTERVAL") == "PACKET"
                                 ? Scope.Packet
                                 : Scope.Interval;

            string refString = GetValue<string>(propertyObject, "$ref", null);
            if (refString != null)
            {
                property.ValueType = Load(Path.Combine(m_schemaDirectory, refString));
            }
            else
            {
                var valueSchema = new Schema();
                valueSchema.Name = "<Schema from Type>";
                valueSchema.JsonTypes = LoadJsonSchemaType(propertyObject);
                property.ValueType = valueSchema;
            }

            JProperty examplesProperty = propertyObject.Property("czmlExamples");
            if (examplesProperty != null)
            {
                var examplesJson = (JArray)examplesProperty.Value;
                property.Examples = new List<string>();
                
                foreach (string filename in examplesJson.Values<string>())
                {
                    property.Examples.Add(File.ReadAllText(Path.Combine(m_schemaDirectory, filename)));
                }
            }
        }

        private JsonSchemaType LoadJsonSchemaType(JObject schema)
        {
            JsonSchemaType result = JsonSchemaType.Any;

            JProperty type = schema.Property("type");
            if (type != null)
            {
                var arrayOfTypes = type.Value as JArray;
                if (arrayOfTypes == null)
                {
                    result = JsonSchemaTypeMapping[type.Value.Value<string>()];
                }
                else
                {
                    result = 0;
                    foreach (string typeName in arrayOfTypes.Values<string>())
                    {
                        result |= JsonSchemaTypeMapping[typeName];
                    }
                }
            }

            return result;
        }

        private static T GetValue<T>(JObject obj, string path, T defaultValue)
        {
            JToken token = obj.SelectToken(path);
            if (token == null)
                return defaultValue;
            else
                return token.Value<T>();
        }

        private static readonly Dictionary<string, JsonSchemaType> JsonSchemaTypeMapping = new Dictionary<string, JsonSchemaType>
            {
                {"string", JsonSchemaType.String},
                {"object", JsonSchemaType.Object},
                {"integer", JsonSchemaType.Integer},
                {"number", JsonSchemaType.Float},
                {"null", JsonSchemaType.Null},
                {"boolean", JsonSchemaType.Boolean},
                {"array", JsonSchemaType.Array},
                {"any", JsonSchemaType.Any}
            };
    }
}
