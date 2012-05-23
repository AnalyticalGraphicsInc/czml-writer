using System;
using Newtonsoft.Json.Linq;
using System.IO;
using Newtonsoft.Json;
using Newtonsoft.Json.Schema;
using System.Text;

namespace GenerateFromSchema
{
    public class CSharpGenerator : Generator
    {
        private readonly string m_outputDirectory;
        private readonly string m_advancedOutputDirectory;
        private readonly string m_namespace;
        private readonly string m_advancedNamespace;

        public CSharpGenerator(
            string outputDirectory,
            string configurationFileName)
        {
            if (outputDirectory == null)
                throw new ArgumentNullException("outputDirectory");
            if (configurationFileName == null)
                throw new ArgumentNullException("configurationFileName");

            m_outputDirectory = outputDirectory;

            using (var packetStream = new StreamReader(configurationFileName))
            using (var packetJsonReader = new JsonTextReader(packetStream))
            {
                JObject schemaJson = JObject.Load(packetJsonReader);

                string advancedRelativeDirectory = schemaJson.Value<string>("advancedRelativeDirectory");
                m_advancedOutputDirectory = Path.Combine(m_outputDirectory, advancedRelativeDirectory);
                m_namespace = schemaJson.Value<string>("namespace");
                m_advancedNamespace = schemaJson.Value<string>("advancedNamespace");
            }
        }

        public override void Generate(Schema packetSchema)
        {
            GeneratePacketWriter(packetSchema);
        }

        private void GeneratePacketWriter(Schema packetSchema)
        {
            string packetWriterFilename = Path.Combine(m_outputDirectory, "PacketCesiumWriter.cs");
            using (CodeWriter writer = new CodeWriter(packetWriterFilename))
            {
                WriteGeneratedWarning(writer);
                writer.WriteLine();
                WritePacketNamespaces(writer, packetSchema);
                writer.WriteLine();

                writer.WriteLine("namespace {0}", m_namespace);
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

        private void WritePacketNamespaces(CodeWriter writer, Schema packetSchema)
        {
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
            foreach (Property property in schema.Properties)
            {
                WriteSummaryText(writer, string.Format("The name of the <code>{0}</code> property.", property.Name));
                writer.WriteLine("public static readonly string {0}PropertyName = \"{1}\";", property.NameWithPascalCase, property.Name);
                writer.WriteLine();
            }
        }

        private void WritePropertyLazyFields(CodeWriter writer, Schema schema)
        {
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
            return ((property.ValueType.JsonTypes & (JsonSchemaType.Object | JsonSchemaType.Array)) == (JsonSchemaType.Object | JsonSchemaType.Array));
        }

        private void WriteProperties(CodeWriter writer, Schema schema)
        {
            foreach (Property property in schema.Properties)
            {
                if (property.ValueType.JsonTypes == JsonSchemaType.Any)
                    return;

                if (PropertyValueIsIntervals(property))
                    WriteIntervalsProperty(writer, schema, property);
                else
                    WriteSimpleProperty(writer, schema, property);
            }
        }

        private void WriteIntervalsProperty(CodeWriter writer, Schema schema, Property property)
        {
            WriteSummaryText(writer, string.Format("Gets the writer for the <code>{0}</code> property.  The returned instance must be opened by calling the <see cref=\"CesiumElementWriter.Open\"/> method before it can be used for writing.  The <code>{0}</code> property {1}",
                property.Name, StringHelper.UncapitalizeFirstLetter(property.Description)));
            writer.WriteLine("public {0}CesiumWriter {1}Writer", property.ValueType.NameWithPascalCase, property.NameWithPascalCase);
            writer.OpenScope();
            writer.WriteLine("get {{ return m_{0}.Value; }}", property.Name);
            writer.CloseScope();
            writer.WriteLine();

            WriteSummaryText(writer, string.Format("Opens and returns the writer for the <code>{0}</code> property.  The <code>{0}</code> property {1}",
                property.Name, StringHelper.UncapitalizeFirstLetter(property.Description)));
            writer.WriteLine("public {0}CesiumWriter Open{1}Property()", property.ValueType.NameWithPascalCase, property.NameWithPascalCase);
            writer.OpenScope();
            writer.WriteLine("return OpenAndReturn({0}Writer);", property.NameWithPascalCase);
            writer.CloseScope();
            writer.WriteLine();
        }

        private void WriteSimpleProperty(CodeWriter writer, Schema schema, Property property)
        {
            WriteSummaryText(writer, string.Format("Writes {0}", StringHelper.UncapitalizeFirstLetter(property.Description)));
            writer.WriteLine("public void Write{0}({1} value)", property.NameWithPascalCase, property.ValueType.NameWithPascalCase);
            writer.OpenScope();
            writer.WriteLine("Output.WritePropertyName(\"{0}\");", property.Name);
            writer.WriteLine("Output.WriteValue(value)");
            writer.CloseScope();
            writer.WriteLine();
        }

    }
}
