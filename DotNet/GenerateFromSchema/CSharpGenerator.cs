using System;
using Newtonsoft.Json.Linq;
using System.IO;
using Newtonsoft.Json;
using Newtonsoft.Json.Schema;
using System.Text;
using System.Collections.Generic;

namespace GenerateFromSchema
{
    public class CSharpGenerator : Generator
    {
        private readonly string m_outputDirectory;
        private readonly Configuration m_configuration;

        public CSharpGenerator(
            string outputDirectory,
            string configurationFileName)
        {
            if (outputDirectory == null)
                throw new ArgumentNullException("outputDirectory");
            if (configurationFileName == null)
                throw new ArgumentNullException("configurationFileName");

            m_outputDirectory = outputDirectory;

            string configuration = File.ReadAllText(configurationFileName);
            m_configuration = JsonConvert.DeserializeObject<Configuration>(configuration);
        }

        public override void Generate(Schema packetSchema)
        {
            GeneratePacketWriter(packetSchema);

            HashSet<Schema> generated = new HashSet<Schema>();

            foreach (Property property in packetSchema.Properties)
            {
                if (!PropertyValueIsIntervals(property))
                    continue;

                if (generated.Contains(property.ValueType))
                    continue;

                generated.Add(property.ValueType);

                GenerateWriterClass(property.ValueType);
            }
        }

        private void GenerateWriterClass(Schema schema)
        {
            string writerFilename = Path.Combine(m_outputDirectory, schema.NameWithPascalCase + "CesiumWriter.cs");
            using (CodeWriter writer = new CodeWriter(writerFilename))
            {
                WriteGeneratedWarning(writer);
                writer.WriteLine();
                WriteNamespaces(writer, schema);
                writer.WriteLine();

                writer.WriteLine("namespace {0}", m_configuration.Namespace);
                writer.OpenScope();

                WriteDescriptionAsClassSummary(writer, schema);
                writer.WriteLine("public class {0}CesiumWriter : CesiumPropertyWriter<{0}CesiumWriter>", schema.NameWithPascalCase);
                writer.OpenScope();

                WritePropertyNameConstants(writer, schema);
                WritePropertyLazyFields(writer, schema);
                WriteConstructorsAndCloneMethod(writer, schema);
                WriteProperties(writer, schema);

                writer.CloseScope();

                writer.CloseScope();
            }
        }

        private void GeneratePacketWriter(Schema packetSchema)
        {
            string packetWriterFilename = Path.Combine(m_outputDirectory, "PacketCesiumWriter.cs");
            using (CodeWriter writer = new CodeWriter(packetWriterFilename))
            {
                WriteGeneratedWarning(writer);
                writer.WriteLine();
                WriteNamespaces(writer, packetSchema);
                writer.WriteLine();

                writer.WriteLine("namespace {0}", m_configuration.Namespace);
                writer.OpenScope();

                WriteDescriptionAsClassSummary(writer, packetSchema);
                writer.WriteLine("public class PacketCesiumWriter : CesiumElementWriter");
                writer.OpenScope();

                WritePropertyNameConstants(writer, packetSchema);
                WritePropertyLazyFields(writer, packetSchema);
                WritePacketOpenClose(writer);
                WriteProperties(writer, packetSchema);

                writer.CloseScope();
                
                writer.CloseScope();
            }
        }

        private void WriteGeneratedWarning(CodeWriter writer)
        {
            writer.WriteLine("// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.");
            writer.WriteLine("// https://github.com/AnalyticalGraphicsInc/czml-writer");
        }

        private void WriteNamespaces(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            foreach (Property property in schema.Properties)
            {
                OverloadInfo[] overloads = GetOverloadsForProperty(property);
                foreach (OverloadInfo overload in overloads)
                {
                    if (overload.Namespaces != null)
                    {
                        foreach (string ns in overload.Namespaces)
                        {
                            writer.WriteLine("using {0};", ns);
                        }
                    }
                }
            }
        }

        private void WriteSummaryText(CodeWriter writer, string text)
        {
            writer.WriteLine("/// <summary>");
            writer.WriteLine("/// {0}", text);
            writer.WriteLine("/// </summary>");
        }

        private void WriteDescriptionAsClassSummary(CodeWriter writer, Schema packetSchema)
        {
            WriteSummaryText(
                writer, 
                string.Format("Writes a <code>{0}</code> to a <see cref=\"CesiumOutputStream\" />.  A <code>{0}</code> {1}",
                    packetSchema.Name,
                    StringHelper.UncapitalizeFirstLetter(packetSchema.Description)));
        }

        private void WritePropertyNameConstants(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            foreach (Property property in schema.Properties)
            {
                WriteSummaryText(writer, string.Format("The name of the <code>{0}</code> property.", property.Name));
                writer.WriteLine("public static readonly string {0}PropertyName = \"{1}\";", property.NameWithPascalCase, property.Name);
                writer.WriteLine();
            }
        }

        private void WritePropertyLazyFields(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            foreach (Property property in schema.Properties)
            {
                if (!PropertyValueIsIntervals(property))
                    continue;

                writer.WriteLine("private readonly Lazy<{0}CesiumWriter> m_{1} = new Lazy<{0}CesiumWriter>(() => new {0}CesiumWriter({2}PropertyName), false);",
                    property.ValueType.NameWithPascalCase,
                    property.Name,
                    property.NameWithPascalCase);
            }

            writer.WriteLine();
        }

        private void WritePacketOpenClose(CodeWriter writer)
        {
            WriteSummaryText(writer, "Writes the start of a new JSON object representing the packet.");
            writer.WriteLine("protected override void OnOpen()");
            writer.OpenScope();
            writer.WriteLine("Output.WriteStartObject();");
            writer.CloseScope();
            
            writer.WriteLine();

            WriteSummaryText(writer, "Writes the end of the JSON object representing the packet.");
            writer.WriteLine("protected override void OnClose()");
            writer.OpenScope();
            writer.WriteLine("Output.WriteEndObject();");
            writer.CloseScope();

            writer.WriteLine();
        }

        private bool PropertyValueIsIntervals(Property property)
        {
            return ((property.ValueType.JsonTypes & (JsonSchemaType.Object | JsonSchemaType.Array)) == (JsonSchemaType.Object | JsonSchemaType.Array)) &&
                    (property.ValueType.JsonTypes & JsonSchemaType.Null) != JsonSchemaType.Null;
        }

        private void WriteProperties(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            foreach (Property property in schema.Properties)
            {
                if (PropertyValueIsIntervals(property))
                    WriteIntervalsProperty(writer, schema, property);
                else
                    WriteSimpleProperty(writer, schema, property);
            }
        }

        private void WriteIntervalsProperty(CodeWriter writer, Schema schema, Property property)
        {
            WriteSummaryText(writer, string.Format("Gets the writer for the <code>{0}</code> property.  The returned instance must be opened by calling the <see cref=\"CesiumElementWriter.Open\"/> method before it can be used for writing.  The <code>{0}</code> property defines {1}",
                property.Name, StringHelper.UncapitalizeFirstLetter(property.Description)));
            writer.WriteLine("public {0}CesiumWriter {1}Writer", property.ValueType.NameWithPascalCase, property.NameWithPascalCase);
            writer.OpenScope();
            writer.WriteLine("get {{ return m_{0}.Value; }}", property.Name);
            writer.CloseScope();
            writer.WriteLine();

            WriteSummaryText(writer, string.Format("Opens and returns the writer for the <code>{0}</code> property.  The <code>{0}</code> property defines {1}",
                property.Name, StringHelper.UncapitalizeFirstLetter(property.Description)));
            writer.WriteLine("public {0}CesiumWriter Open{1}Property()", property.ValueType.NameWithPascalCase, property.NameWithPascalCase);
            writer.OpenScope();
            writer.WriteLine("return OpenAndReturn({0}Writer);", property.NameWithPascalCase);
            writer.CloseScope();
            writer.WriteLine();
        }

        private void WriteSimpleProperty(CodeWriter writer, Schema schema, Property property)
        {
            OverloadInfo[] overloads = GetOverloadsForProperty(property);

            foreach (OverloadInfo overload in overloads)
            {
                WriteSummaryText(writer, string.Format("Writes the <code>{0}</code> property.  The <code>{0}</code> property specifies {1}", property.Name, StringHelper.UncapitalizeFirstLetter(property.Description)));
                writer.WriteLine("public void Write{0}({1})", property.NameWithPascalCase, overload.Parameters);
                writer.OpenScope();
                if (overload.CallOverload != null)
                {
                    writer.WriteLine("Write{0}({1});", property.NameWithPascalCase, overload.CallOverload);
                }
                else
                {
                    writer.WriteLine("Output.WritePropertyName({0}PropertyName);", property.NameWithPascalCase);
                    writer.WriteLine(overload.WriteValue);
                }
                writer.CloseScope();
                writer.WriteLine();
            }
        }

        private void WriteConstructorsAndCloneMethod(CodeWriter writer, Schema schema)
        {
            WriteSummaryText(writer, "Initializes a new instance.");
            writer.WriteLine("public {0}CesiumWriter(string propertyName)", schema.NameWithPascalCase);
            writer.WriteLine("    : base(propertyName)");
            writer.OpenScope();
            writer.CloseScope();
            writer.WriteLine();

            WriteSummaryText(writer, "Initializes a new instance as a copy of an existing instance.");
            writer.WriteLine("/// <param name=\"existingInstance\">The existing instance to copy.</param> ");
            writer.WriteLine("protected {0}CesiumWriter({0}CesiumWriter existingInstance)", schema.NameWithPascalCase);
            writer.WriteLine("    : base(existingInstance)");
            writer.OpenScope();
            writer.CloseScope();
            writer.WriteLine();

            writer.WriteLine("/// <inheritdoc />");
            writer.WriteLine("public override {0}CesiumWriter Clone()", schema.NameWithPascalCase);
            writer.OpenScope();
            writer.WriteLine("return new {0}CesiumWriter(this);", schema.NameWithPascalCase);
            writer.CloseScope();
            writer.WriteLine();
        }

        private OverloadInfo[] GetOverloadsForProperty(Property property)
        {
            OverloadInfo[] overloads;

            if (property.ValueType.IsSchemaFromType)
            {
                overloads = new OverloadInfo[4];

                int index = 0;
                JsonSchemaType type = property.ValueType.JsonTypes;

                if ((type & JsonSchemaType.String) == JsonSchemaType.String)
                    overloads[index++] = s_defaultStringOverload;
                if ((type & JsonSchemaType.Float) == JsonSchemaType.Float)
                    overloads[index++] = s_defaultDoubleOverload;
                if ((type & JsonSchemaType.Float) == JsonSchemaType.Integer)
                    overloads[index++] = s_defaultIntegerOverload;
                if ((type & JsonSchemaType.Boolean) == JsonSchemaType.Boolean)
                    overloads[index++] = s_defaultBooleanOverload;
                if ((type & JsonSchemaType.Object) == JsonSchemaType.Object ||
                    (type & JsonSchemaType.Array) == JsonSchemaType.Array ||
                    (type & JsonSchemaType.Null) == JsonSchemaType.Null ||
                    (type & JsonSchemaType.Any) == JsonSchemaType.Any ||
                    type == JsonSchemaType.None)
                {
                    throw new Exception(string.Format("Property '{0}' does not specify a $ref to a schema, nor is it a simple JSON type.", property.Name));
                }

                Array.Resize(ref overloads, index);
            }
            else
            {
                if (!m_configuration.Types.TryGetValue(property.ValueType.Name, out overloads))
                {
                    overloads = CreateDefaultOverload(property.ValueType);
                    m_configuration.Types[property.ValueType.Name] = overloads;
                }
            }
            return overloads;
        }

        private OverloadInfo[] CreateDefaultOverload(Schema schema)
        {
            return new[]
            {
                new OverloadInfo()
                {
                    Parameters = schema.Name + " value",
                    WriteValue = "Output.WriteValue(value);"
                }
            };
        }

        // All the "= null" nonsense is to avoid warnings from Visual Studio, which isn't aware of
        // JSON.NET's treachery.

        private class OverloadInfo
        {
            [JsonProperty("namespaces")]
            public string[] Namespaces = null;
            [JsonProperty("parameters")]
            public string Parameters = null;
            [JsonProperty("writeValue")]
            public string WriteValue = null;
            [JsonProperty("callOverload")]
            public string CallOverload = null;
        }

        private class Configuration
        {
            [JsonProperty("namespace")]
            public string Namespace = null;
            [JsonProperty("types")]
            public Dictionary<string, OverloadInfo[]> Types = null;
        }

        private static readonly OverloadInfo s_defaultStringOverload = new OverloadInfo() { Parameters = "string value", WriteValue = "Output.WriteValue(value)" };
        private static readonly OverloadInfo s_defaultDoubleOverload = new OverloadInfo() { Parameters = "double value", WriteValue = "Output.WriteValue(value)" };
        private static readonly OverloadInfo s_defaultIntegerOverload = new OverloadInfo() { Parameters = "int value", WriteValue = "Output.WriteValue(value)" };
        private static readonly OverloadInfo s_defaultBooleanOverload = new OverloadInfo() { Parameters = "bool value", WriteValue = "Output.WriteValue(value)" };
    }
}
