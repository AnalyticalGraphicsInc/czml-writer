using System;
using System.Collections.Generic;
using System.IO;
using Newtonsoft.Json;
using Newtonsoft.Json.Schema;

namespace GenerateFromSchema
{
    public class CSharpGenerator : Generator
    {
        private readonly string m_outputDirectory;
        private readonly Configuration m_configuration;
        private readonly HashSet<Schema> m_writtenSchemas = new HashSet<Schema>();

        public CSharpGenerator(string outputDirectory, string configurationFileName)
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
        }

        private void GenerateWriterClass(Schema schema)
        {
            if (m_writtenSchemas.Contains(schema))
                return;

            m_writtenSchemas.Add(schema);

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

                bool isInterpolatable = schema.Extends != null && schema.Extends.Name == "InterpolatableProperty";
                if (isInterpolatable)
                    writer.WriteLine(m_configuration.Access + " class {0}CesiumWriter : CesiumInterpolatablePropertyWriter<{0}CesiumWriter>", schema.NameWithPascalCase);
                else
                    writer.WriteLine(m_configuration.Access + " class {0}CesiumWriter : CesiumPropertyWriter<{0}CesiumWriter>", schema.NameWithPascalCase);

                writer.OpenScope();

                WritePropertyNameConstants(writer, schema);
                WritePropertyLazyFields(writer, schema);
                WriteConstructorsAndCloneMethod(writer, schema);
                WriteProperties(writer, schema);
                WriteAsTypeMethods(writer, schema);

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
                writer.WriteLine(m_configuration.Access + " class PacketCesiumWriter : CesiumElementWriter");
                writer.OpenScope();

                WritePropertyNameConstants(writer, packetSchema);
                WritePropertyLazyFields(writer, packetSchema);
                WritePacketOpenClose(writer);
                WriteProperties(writer, packetSchema);

                writer.CloseScope();

                writer.CloseScope();
            }
        }

        private static void WriteGeneratedWarning(CodeWriter writer)
        {
            writer.WriteLine("// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.");
            writer.WriteLine("// https://github.com/AnalyticalGraphicsInc/czml-writer");
        }

        private void WriteNamespaces(CodeWriter writer, Schema schema)
        {
            HashSet<string> namespaces = new HashSet<string>();

            namespaces.Add(m_configuration.Namespace + ".Advanced");
            namespaces.Add(m_configuration.LazyNamespace);

            if (schema.Properties != null)
            {
                foreach (Property property in schema.Properties)
                {
                    OverloadInfo[] overloads = GetOverloadsForProperty(property);
                    foreach (OverloadInfo overload in overloads)
                    {
                        if (overload.Namespaces != null)
                        {
                            foreach (string ns in overload.Namespaces)
                            {
                                namespaces.Add(ns);
                            }
                        }
                    }

                    if (property.ValueType.Properties != null)
                    {
                        foreach (Property subProperty in property.ValueType.Properties)
                        {
                            OverloadInfo[] subOverloads = GetOverloadsForProperty(subProperty);
                            foreach (OverloadInfo overload in subOverloads)
                            {
                                if (overload.Namespaces != null)
                                {
                                    foreach (string ns in overload.Namespaces)
                                    {
                                        namespaces.Add(ns);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            foreach (string ns in namespaces)
            {
                writer.WriteLine("using {0};", ns);
            }
        }

        private static void WriteSummaryText(CodeWriter writer, string text)
        {
            writer.WriteLine("/// <summary>");
            writer.WriteLine("/// {0}", text);
            writer.WriteLine("/// </summary>");
        }

        private static void WriteInheritDoc(CodeWriter writer)
        {
            writer.WriteLine("/// <inheritdoc />");
        }

        private static void WriteParameterText(CodeWriter writer, string parameterName, string description)
        {
            writer.WriteLine("/// <param name=\"{0}\">{1}</param>", parameterName, description);
        }

        private static void WriteTypeParameterText(CodeWriter writer, string typeName, string description)
        {
            writer.WriteLine("/// <typeparam name=\"{0}\">{1}</typeparam>", typeName, description);
        }

        private static void WriteReturnsText(CodeWriter writer, string description)
        {
            writer.WriteLine(string.Format("/// <returns>{0}</returns>", description));
        }

        private static void WriteDescriptionAsClassSummary(CodeWriter writer, Schema packetSchema)
        {
            WriteSummaryText(writer, string.Format("Writes a <code>{0}</code> to a <see cref=\"CesiumOutputStream\" />.  A <code>{0}</code> {1}",
                              packetSchema.Name,
                              StringHelper.UncapitalizeFirstLetter(packetSchema.Description)));
        }

        private static void WritePropertyNameConstants(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            foreach (Property property in schema.Properties)
            {
                WriteSummaryText(writer, string.Format("The name of the <code>{0}</code> property.", property.Name));
                writer.WriteLine("public const string {0}PropertyName = \"{1}\";", property.NameWithPascalCase, property.Name);
                writer.WriteLine();
            }
        }

        private void WritePropertyLazyFields(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            foreach (Property property in schema.Properties)
            {
                if (PropertyValueIsIntervals(property))
                {
                    writer.WriteLine("private readonly Lazy<{0}CesiumWriter> m_{1} = new Lazy<{0}CesiumWriter>(() => new {0}CesiumWriter({2}PropertyName), false);",
                                     property.ValueType.NameWithPascalCase,
                                     property.Name,
                                     property.NameWithPascalCase);
                }
                else if (property.IsValue)
                {
                    // Does this property have an overload to write sampled data?
                    // If so, it's interpolatable.
                    OverloadInfo[] overloads = GetOverloadsForProperty(property);
                    if (overloads[0].Parameters.Length == 1)
                    {
                        string interfaceName = "ICesiumValuePropertyWriter";
                        if (FindSampledDataOverload(overloads) != null)
                            interfaceName = "ICesiumInterpolatableValuePropertyWriter";

                        writer.WriteLine("private readonly Lazy<{0}<{1}>> m_as{2};",
                                         interfaceName,
                                         overloads[0].Parameters[0].Type,
                                         property.NameWithPascalCase);
                    }
                }
            }

            writer.WriteLine();
        }

        private static void WritePacketOpenClose(CodeWriter writer)
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

        private static bool PropertyValueIsIntervals(Property property)
        {
            return ((property.ValueType.JsonTypes & (JsonSchemaType.Object | JsonSchemaType.Array)) == (JsonSchemaType.Object | JsonSchemaType.Array)) &&
                   (property.ValueType.JsonTypes & JsonSchemaType.Null) != JsonSchemaType.Null;
        }

        private void WriteProperties(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            bool isFirstValueProperty = true;

            foreach (Property property in schema.Properties)
            {
                if (PropertyValueIsIntervals(property))
                    WriteIntervalsProperty(writer, schema, property);
                else
                    WriteLeafProperty(writer, schema, property, property.IsValue && isFirstValueProperty);

                if (property.IsValue)
                    isFirstValueProperty = false;
            }
        }

        private void WriteIntervalsProperty(CodeWriter writer, Schema schema, Property property)
        {
            GenerateWriterClass(property.ValueType);

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
            if (schema.Name != "Packet")
                writer.WriteLine("OpenIntervalIfNecessary();");
            writer.WriteLine("return OpenAndReturn({0}Writer);", property.NameWithPascalCase);
            writer.CloseScope();
            writer.WriteLine();

            if (property.ValueType.Properties != null)
            {
                bool isFirstValueProperty = true;
                foreach (Property nestedProperty in property.ValueType.Properties)
                {
                    if (!nestedProperty.IsValue)
                        continue;

                    OverloadInfo[] overloads = GetOverloadsForProperty(nestedProperty);

                    foreach (OverloadInfo overload in overloads)
                    {
                        WriteSummaryText(writer, string.Format("Writes a value for the <code>{0}</code> property as a <code>{1}</code> value.  The <code>{0}</code> property specifies {2}", property.Name, nestedProperty.Name, StringHelper.UncapitalizeFirstLetter(property.Description)));
                        foreach (ParameterInfo parameter in overload.Parameters)
                        {
                            if (string.IsNullOrEmpty(parameter.Description))
                                continue;
                            WriteParameterText(writer, parameter.Name, parameter.Description);
                        }

                        string subPropertyName = nestedProperty.NameWithPascalCase;
                        if (subPropertyName == property.NameWithPascalCase || isFirstValueProperty)
                            subPropertyName = "";

                        writer.WriteLine("public void Write{0}Property{1}({2})", property.NameWithPascalCase, subPropertyName, overload.FormattedParameters);
                        writer.OpenScope();

                        writer.WriteLine("using (var writer = Open{0}Property())", property.NameWithPascalCase);
                        writer.OpenScope();
                        writer.WriteLine("writer.Write{0}({1});", nestedProperty.NameWithPascalCase, string.Join(", ", Array.ConvertAll(overload.Parameters, p => p.Name)));
                        writer.CloseScope();

                        writer.CloseScope();
                        writer.WriteLine();
                    }

                    isFirstValueProperty = false;
                }
            }
        }

        private void WriteLeafProperty(CodeWriter writer, Schema schema, Property property, bool isFirstValueProperty)
        {
            OverloadInfo[] overloads = GetOverloadsForProperty(property);

            foreach (OverloadInfo overload in overloads)
            {
                WriteSummaryText(writer, string.Format("Writes the <code>{0}</code> property.  The <code>{0}</code> property specifies {1}", property.Name, StringHelper.UncapitalizeFirstLetter(property.Description)));
                foreach (ParameterInfo parameter in overload.Parameters)
                {
                    if (string.IsNullOrEmpty(parameter.Description))
                        continue;
                    WriteParameterText(writer, parameter.Name, parameter.Description);
                }

                writer.WriteLine("public void Write{0}({1})", property.NameWithPascalCase, overload.FormattedParameters);
                writer.OpenScope();
                if (overload.CallOverload != null)
                {
                    writer.WriteLine("Write{0}({1});", property.NameWithPascalCase, overload.CallOverload);
                }
                else
                {
                    writer.WriteLine("const string PropertyName = {0}PropertyName;", property.NameWithPascalCase);

                    if (schema.Name == "Packet")
                    {
                        writer.WriteLine("Output.WritePropertyName(PropertyName);");
                    }
                    else if (isFirstValueProperty && !overload.NeedsInterval)
                    {
                        // For the first value property only, if an overload is marked 
                        // as not needing an interval, because it writes a simple JSON 
                        // type (string, number, boolean), we can skip opening an interval 
                        // and just write the property value directly.
                        // Unless ForceInterval has been set to true.
                        writer.WriteLine("if (ForceInterval)");
                        writer.WriteLine("    OpenIntervalIfNecessary();");
                        if (overload.WritePropertyName)
                        {
                        writer.WriteLine("if (IsInterval)");
                        writer.WriteLine("    Output.WritePropertyName(PropertyName);");
                    }
                    }
                    else
                    {
                        writer.WriteLine("OpenIntervalIfNecessary();");

                        if (overload.WritePropertyName)
                            writer.WriteLine("Output.WritePropertyName(PropertyName);");
                    }

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
            WriteAsTypeLazyInitialization(writer, schema);
            writer.CloseScope();
            writer.WriteLine();

            WriteSummaryText(writer, "Initializes a new instance as a copy of an existing instance.");
            WriteParameterText(writer, "existingInstance", "The existing instance to copy.");
            writer.WriteLine("protected {0}CesiumWriter({0}CesiumWriter existingInstance)", schema.NameWithPascalCase);
            writer.WriteLine("    : base(existingInstance)");
            writer.OpenScope();
            WriteAsTypeLazyInitialization(writer, schema);
            writer.CloseScope();
            writer.WriteLine();

            WriteInheritDoc(writer);
            writer.WriteLine("public override {0}CesiumWriter Clone()", schema.NameWithPascalCase);
            writer.OpenScope();
            writer.WriteLine("return new {0}CesiumWriter(this);", schema.NameWithPascalCase);
            writer.CloseScope();
            writer.WriteLine();
        }

        private void WriteAsTypeLazyInitialization(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            foreach (Property property in schema.Properties)
            {
                if (!property.IsValue)
                    continue;
                if (PropertyValueIsIntervals(property))
                    continue;

                OverloadInfo[] overloads = GetOverloadsForProperty(property);
                if (overloads[0].Parameters.Length != 1)
                    continue;

                OverloadInfo sampleOverload = FindSampledDataOverload(overloads);

                string interfaceName = "ICesiumValuePropertyWriter";
                if (sampleOverload != null)
                    interfaceName = "ICesiumInterpolatableValuePropertyWriter";

                writer.WriteLine("m_as{0} = new Lazy<{1}<{2}>>(Create{0}Adaptor, false);",
                                 property.NameWithPascalCase,
                                 interfaceName,
                                 overloads[0].Parameters[0].Type);
            }
        }

        private void WriteAsTypeMethods(CodeWriter writer, Schema schema)
        {
            if (schema.Properties == null)
                return;

            foreach (Property property in schema.Properties)
            {
                if (!property.IsValue)
                    continue;
                if (PropertyValueIsIntervals(property))
                    continue;

                OverloadInfo[] overloads = GetOverloadsForProperty(property);

                if (overloads[0].Parameters.Length != 1)
                    continue;

                OverloadInfo sampleOverload = FindSampledDataOverload(overloads);

                string interfaceName = "ICesiumValuePropertyWriter";
                if (sampleOverload != null)
                    interfaceName = "ICesiumInterpolatableValuePropertyWriter";

                WriteSummaryText(writer, string.Format("Returns a wrapper for this instance that implements <see cref=\"{0}{{T}}\" /> to write a value in <code>{1}</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref=\"ICesiumElementWriter.Close\" /> on either this instance or the wrapper, but you must not call it on both.", interfaceName, property.NameWithPascalCase));
                WriteReturnsText(writer, "The wrapper.");
                writer.WriteLine("public {0}<{1}> As{2}()",
                                 interfaceName,
                                 overloads[0].Parameters[0].Type,
                                 property.NameWithPascalCase);
                writer.OpenScope();
                writer.WriteLine("return m_as{0}.Value;", property.NameWithPascalCase);
                writer.CloseScope();
                writer.WriteLine();

                string adaptorName = "CesiumWriterAdaptor";
                if (sampleOverload != null)
                    adaptorName = "CesiumInterpolatableWriterAdaptor";

                writer.WriteLine("private {0}<{1}> Create{2}Adaptor()",
                                 interfaceName,
                                 overloads[0].Parameters[0].Type,
                                 property.NameWithPascalCase);
                writer.OpenScope();
                writer.WriteLine("return new {0}<{1}CesiumWriter, {2}>(",
                                 adaptorName,
                                 schema.NameWithPascalCase,
                                 overloads[0].Parameters[0].Type);
                if (sampleOverload != null)
                {
                    writer.WriteLine("    this, (me, value) => me.Write{0}(value), ({1}CesiumWriter me, IList<JulianDate> dates, IList<{2}> values, int startIndex, int length) => me.Write{0}(dates, values, startIndex, length));",
                                     property.NameWithPascalCase,
                                     schema.NameWithPascalCase,
                                     overloads[0].Parameters[0].Type);
                }
                else
                {
                    writer.WriteLine("    this, (me, value) => me.Write{0}(value));",
                                     property.NameWithPascalCase);
                }
                writer.CloseScope();
                writer.WriteLine();
            }
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
                    overloads = new[] { OverloadInfo.CreateDefault(property.ValueType.NameWithPascalCase) };
                    m_configuration.Types[property.ValueType.Name] = overloads;
                }
            }
            return overloads;
        }

        private OverloadInfo FindSampledDataOverload(OverloadInfo[] overloads)
        {
            return Array.Find(overloads, IsSampledDataOverload);
        }

        private bool IsSampledDataOverload(OverloadInfo overload)
        {
            return overload.Parameters.Length == 4 &&
                   overload.Parameters[0].Type == "IList<JulianDate>" &&
                   overload.Parameters[1].Type.StartsWith("IList<") &&
                   overload.Parameters[2].Type == "int" &&
                   overload.Parameters[3].Type == "int";
        }

        // All the "= null" nonsense is to avoid warnings from Visual Studio, which isn't aware of
        // JSON.NET's treachery.

        private class ParameterInfo
        {
            [JsonProperty("type")]
            public string Type = null;

            [JsonProperty("name")]
            public string Name = null;

            [JsonProperty("description")]
            public string Description = null;

            public static ParameterInfo SimpleValue(string type)
            {
                return new ParameterInfo
                           {
                               Type = type,
                               Name = "value",
                               Description = "The value."
                           };
            }
        }

        private class OverloadInfo
        {
            [JsonProperty("namespaces")]
            public string[] Namespaces = null;

            [JsonProperty("parameters")]
            public ParameterInfo[] Parameters = null;

            [JsonProperty("writeValue")]
            public string WriteValue = null;

            [JsonProperty("callOverload")]
            public string CallOverload = null;

            [JsonProperty("writePropertyName")]
            public bool WritePropertyName = true;

            [JsonProperty("needsInterval")]
            public bool NeedsInterval = true;

            public string FormattedParameters
            {
                get { return string.Join(", ", Array.ConvertAll(Parameters, parameter => parameter.Type + ' ' + parameter.Name)); }
            }

            public static OverloadInfo CreateDefault(string typeName)
            {
                return new OverloadInfo
                           {
                               Parameters = new[]
                                                {
                                                    new ParameterInfo
                                                        {
                                                            Type = typeName,
                                                            Name = "value",
                                                            Description = "The value."
                                                        }
                                                },
                               WriteValue = "Output.WriteValue(value);",
                           };
            }
        }

        private class Configuration
        {
            [JsonProperty("namespace")]
            public string Namespace = null;

            [JsonProperty("access")]
            public string Access = null;

            [JsonProperty("lazyNamespace")]
            public string LazyNamespace = null;

            [JsonProperty("types")]
            public Dictionary<string, OverloadInfo[]> Types = null;
        }

        private static readonly OverloadInfo s_defaultStringOverload = OverloadInfo.CreateDefault("string");
        private static readonly OverloadInfo s_defaultDoubleOverload = OverloadInfo.CreateDefault("double");
        private static readonly OverloadInfo s_defaultIntegerOverload = OverloadInfo.CreateDefault("int");
        private static readonly OverloadInfo s_defaultBooleanOverload = OverloadInfo.CreateDefault("bool");
    }
}