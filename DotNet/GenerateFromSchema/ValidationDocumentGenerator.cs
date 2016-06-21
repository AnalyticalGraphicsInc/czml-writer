using System;
using System.IO;
using System.Linq;
using Newtonsoft.Json.Schema;

namespace GenerateFromSchema
{
    public class ValidationDocumentGenerator : Generator
    {
        private readonly string m_outputDirectory;

        public ValidationDocumentGenerator(string outputDirectory)
        {
            if (outputDirectory == null)
                throw new ArgumentNullException("outputDirectory");

            m_outputDirectory = outputDirectory;
        }

        public override void Generate(Schema schema)
        {
            using (CodeWriter writer = new CodeWriter(Path.Combine(m_outputDirectory, "TestGenerateValidationDocument.cs")))
            {
                writer.WriteLine("// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.");
                writer.WriteLine("// https://github.com/AnalyticalGraphicsInc/czml-writer");
                writer.WriteLine();

                writer.WriteLine("using System.Collections.Generic;");
                writer.WriteLine("using System.Drawing;");
                writer.WriteLine("using System.IO;");
                writer.WriteLine("using CesiumLanguageWriter;");
                writer.WriteLine("using NUnit.Framework;");
                writer.WriteLine();

                writer.WriteLine("namespace {0}", "CesiumLanguageWriterTests");

                using (writer.OpenScope())
                {
                    writer.WriteLine("[TestFixture]");
                    writer.WriteLine("public class TestGenerateValidationDocument");

                    using (writer.OpenScope())
                    {
                        writer.WriteLine("[Test]");
                        writer.WriteLine("public void GenerateValidationDocument()");

                        using (writer.OpenScope())
                        {
                            writer.WriteLine("JulianDate documentStartDate = new GregorianDate(2016, 6, 17, 12, 0, 0).ToJulianDate();");
                            writer.WriteLine("JulianDate documentStopDate = new GregorianDate(2016, 6, 17, 13, 0, 0).ToJulianDate();");

                            writer.WriteLine("using (var streamWriter = new StreamWriter(\"ValidationDocument.czml\"))");
                            writer.WriteLine("using (var assertionsStreamWriter = new StreamWriter(\"ValidationDocumentAssertions.js\"))");
                            using (writer.OpenScope())
                            {
                                WriteAssertion(writer, "return CzmlDataSource.load('Data/CZML/ValidationDocument.czml').then(function(dataSource) {");
                                s_assertionIndent++;
                                WriteAssertion(writer, "/*jshint -W030, -W120 */");
                                WriteAssertion(writer, "var e;");
                                WriteAssertion(writer, "var checkExtensions = false;");
                                WriteAssertion(writer, "var date;");
                                WriteAssertion(writer, "var documentStartDate = JulianDate.fromIso8601('2016-06-17T12:00:00Z');");
                                WriteAssertion(writer, "var documentStopDate = JulianDate.fromIso8601('2016-06-17T13:00:00Z');");

                                writer.WriteLine("var output = new CesiumOutputStream(streamWriter) { PrettyFormatting = true };");
                                writer.WriteLine("var writer = new CesiumStreamWriter();");

                                writer.WriteLine("output.WriteStartSequence();");

                                writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                using (writer.OpenScope())
                                {
                                    writer.WriteLine("packet.WriteId(\"document\");");
                                    writer.WriteLine("packet.WriteName(\"ValidationDocument\");");
                                    writer.WriteLine("packet.WriteVersion(\"1.0\");");

                                    writer.WriteLine("using (var clock = packet.OpenClockProperty())");
                                    using (writer.OpenScope())
                                    {
                                        writer.WriteLine("clock.WriteInterval(documentStartDate, documentStopDate);");
                                        WriteAssertion(writer, "expect(dataSource.clock.startTime).toEqual(documentStartDate);");
                                        WriteAssertion(writer, "expect(dataSource.clock.stopTime).toEqual(documentStopDate);");

                                        writer.WriteLine("clock.WriteCurrentTime(documentStartDate);");
                                        WriteAssertion(writer, "expect(dataSource.clock.currentTime).toEqual(documentStartDate);");

                                        writer.WriteLine("clock.WriteMultiplier(1.0);");
                                        WriteAssertion(writer, "expect(dataSource.clock.multiplier).toEqual(1.0);");

                                        writer.WriteLine("clock.WriteRange(ClockRange.Unbounded);");
                                        WriteAssertion(writer, "expect(dataSource.clock.clockRange).toEqual(ClockRange.UNBOUNDED);");

                                        writer.WriteLine("clock.WriteStep(ClockStep.SystemClockMultiplier);");
                                        WriteAssertion(writer, "expect(dataSource.clock.clockStep).toEqual(ClockStep.SYSTEM_CLOCK_MULTIPLIER);");
                                    }
                                }

                                var schemaProperties = schema.Properties
                                                             .Where(p => p.Name != "clock" && p.Name != "availability" && !p.ValueType.IsSchemaFromType)
                                                             .ToList();

                                writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                using (writer.OpenScope())
                                {
                                    writer.WriteLine("packet.WriteId(\"Constant\");");

                                    WriteAssertion(writer, "var constant = e = dataSource.entities.getById('Constant');");
                                    WriteAssertion(writer, "expect(e).toBeDefined();");
                                    WriteAssertion(writer, "date = JulianDate.now();");

                                    foreach (var property in schemaProperties)
                                    {
                                        string propertyName = property.Name;

                                        bool isExtension = !string.IsNullOrEmpty(property.ValueType.ExtensionPrefix);
                                        if (isExtension)
                                            propertyName = propertyName.Substring(property.ValueType.ExtensionPrefix.Length + 1);

                                        writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                        using (writer.OpenScope())
                                        {
                                            var properties = property.ValueType.Properties;

                                            var firstValueProperty = properties.FirstOrDefault(p => p.IsValue);
                                            if (firstValueProperty != null)
                                            {
                                                WriteValue(writer, "w", firstValueProperty, isExtension, propertyName);
                                            }
                                            else
                                            {
                                                foreach (var subProperty in properties.Where(p => !p.IsValue))
                                                {
                                                    writer.WriteLine("using (var w2 = w.Open{0}Property())", subProperty.NameWithPascalCase);
                                                    using (writer.OpenScope())
                                                    {
                                                        properties = subProperty.ValueType.Properties;
                                                        firstValueProperty = properties.FirstOrDefault(p => p.IsValue);

                                                        string subPropertyName = GetSubPropertyName(propertyName, subProperty);

                                                        if (firstValueProperty != null)
                                                        {
                                                            WriteValue(writer, "w2", firstValueProperty, isExtension, string.Format("{0}.{1}", propertyName, subPropertyName));
                                                        }
                                                        else if (subProperty.ValueType.Name.Contains("Material"))
                                                        {
                                                            int materialIndex = s_counter++ % properties.Count;
                                                            Property materialProperty = properties[materialIndex];
                                                            writer.WriteLine("using (var m = w2.Open{0}Property())", materialProperty.NameWithPascalCase);
                                                            using (writer.OpenScope())
                                                            {
                                                                properties = materialProperty.ValueType.Properties;
                                                                foreach (var materialSubProperty in properties.Where(p => !p.IsValue))
                                                                {
                                                                    writer.WriteLine("using (var m2 = m.Open{0}Property())", materialSubProperty.NameWithPascalCase);
                                                                    using (writer.OpenScope())
                                                                    {
                                                                        properties = materialSubProperty.ValueType.Properties;
                                                                        firstValueProperty = properties.FirstOrDefault(p => p.IsValue);
                                                                        if (firstValueProperty != null)
                                                                        {
                                                                            WriteValue(writer, "m2", firstValueProperty, isExtension, string.Format("{0}.{1}.{2}", propertyName, subPropertyName, materialSubProperty.Name));
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        else
                                                        {
                                                            var additionalProperties = subProperty.ValueType.AdditionalProperties;
                                                            if (additionalProperties != null)
                                                            {
                                                                string propName = string.Format("prop{0}", s_counter++);
                                                                writer.WriteLine("using (var a = w2.Open{0}Property(\"{1}\"))", additionalProperties.ValueType.NameWithPascalCase, propName);
                                                                using (writer.OpenScope())
                                                                {
                                                                    foreach (var additionalProperty in additionalProperties.ValueType.Properties.Where(p => !p.IsValue))
                                                                    {
                                                                        writer.WriteLine("using (var w3 = a.Open{0}Property())", additionalProperty.NameWithPascalCase);
                                                                        using (writer.OpenScope())
                                                                        {
                                                                            properties = additionalProperty.ValueType.Properties;
                                                                            firstValueProperty = properties.FirstOrDefault(p => p.IsValue);
                                                                            if (firstValueProperty != null)
                                                                            {
                                                                                WriteValue(writer, "w3", firstValueProperty, isExtension, string.Format("{0}.{1}.{2}.{3}", propertyName, subPropertyName, propName, additionalProperty.Name));
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                // create entities using references

                                foreach (var property in schemaProperties)
                                {
                                    string propertyName = property.Name;

                                    bool isExtension = !string.IsNullOrEmpty(property.ValueType.ExtensionPrefix);
                                    if (isExtension)
                                        propertyName = propertyName.Substring(property.ValueType.ExtensionPrefix.Length + 1);

                                    var properties = property.ValueType.Properties;

                                    var referenceProperty = properties.FirstOrDefault(p => p.ValueType.Name == "Reference");
                                    if (referenceProperty != null)
                                    {
                                        writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                        using (writer.OpenScope())
                                        {
                                            string id = string.Format("reference{0}", s_counter++);
                                            writer.WriteLine("packet.WriteId(\"{0}\");", id);
                                            WriteAssertion(writer, "e = dataSource.entities.getById('{0}');", id);
                                            WriteAssertion(writer, "expect(e).toBeDefined();");
                                            writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                            using (writer.OpenScope())
                                            {
                                                writer.WriteLine("w.WriteReference(new Reference(\"Constant\", \"{0}\"));", propertyName);
                                                WriteAssertion(writer, isExtension, "expect(e.{0}.getValue(date)).toEqual(constant.{0}.getValue(date));", propertyName);
                                            }
                                        }
                                    }
                                    else
                                    {
                                        foreach (var subProperty in properties.Where(p => !p.IsValue))
                                        {
                                            string subPropertyName = GetSubPropertyName(propertyName, subProperty);

                                            properties = subProperty.ValueType.Properties;

                                            referenceProperty = properties.FirstOrDefault(p => p.ValueType.Name == "Reference");
                                            if (referenceProperty != null)
                                            {
                                                writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                                using (writer.OpenScope())
                                                {
                                                    string id = string.Format("reference{0}", s_counter++);
                                                    writer.WriteLine("packet.WriteId(\"{0}\");", id);
                                                    WriteAssertion(writer, "e = dataSource.entities.getById('{0}');", id);
                                                    WriteAssertion(writer, "expect(e).toBeDefined();");
                                                    writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                                    writer.WriteLine("using (var w2 = w.Open{0}Property())", subProperty.NameWithPascalCase);
                                                    using (writer.OpenScope())
                                                    {
                                                        writer.WriteLine("w2.WriteReference(new Reference(\"Constant\", new List<string> {{ \"{0}\", \"{1}\" }}));", propertyName, subPropertyName);
                                                        WriteAssertion(writer, isExtension, "expect(e.{0}.{1}.getValue(date)).toEqual(constant.{0}.{1}.getValue(date));", propertyName, subPropertyName);
                                                    }
                                                }
                                            }
                                            else if (subProperty.ValueType.Name.Contains("Material"))
                                            {
                                                foreach (var materialProperty in properties)
                                                {
                                                    string materialId = string.Format("material{0}", s_counter++);

                                                    writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                                    using (writer.OpenScope())
                                                    {
                                                        writer.WriteLine("packet.WriteId(\"{0}\");", materialId);

                                                        WriteAssertion(writer, "var {0} = e = dataSource.entities.getById('{0}');", materialId);
                                                        WriteAssertion(writer, "expect(e).toBeDefined();");

                                                        writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                                        writer.WriteLine("using (var w2 = w.Open{0}Property())", subProperty.NameWithPascalCase);
                                                        writer.WriteLine("using (var m = w2.Open{0}Property())", materialProperty.NameWithPascalCase);
                                                        using (writer.OpenScope())
                                                        {
                                                            properties = materialProperty.ValueType.Properties;
                                                            foreach (var materialSubProperty in properties.Where(p => !p.IsValue))
                                                            {
                                                                writer.WriteLine("using (var m2 = m.Open{0}Property())", materialSubProperty.NameWithPascalCase);
                                                                using (writer.OpenScope())
                                                                {
                                                                    properties = materialSubProperty.ValueType.Properties;
                                                                    var firstValueProperty = properties.FirstOrDefault(p => p.IsValue);
                                                                    if (firstValueProperty != null)
                                                                    {
                                                                        WriteValue(writer, "m2", firstValueProperty, isExtension, string.Format("{0}.{1}.{2}", propertyName, subPropertyName, materialSubProperty.Name));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                    writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                                    using (writer.OpenScope())
                                                    {
                                                        string referenceId = string.Format("reference{0}", s_counter++);
                                                        writer.WriteLine("packet.WriteId(\"{0}\");", referenceId);

                                                        WriteAssertion(writer, "e = dataSource.entities.getById('{0}');", referenceId);
                                                        WriteAssertion(writer, "expect(e).toBeDefined();");

                                                        writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                                        writer.WriteLine("using (var w2 = w.Open{0}Property())", subProperty.NameWithPascalCase);
                                                        writer.WriteLine("using (var m = w2.Open{0}Property())", materialProperty.NameWithPascalCase);
                                                        using (writer.OpenScope())
                                                        {
                                                            properties = materialProperty.ValueType.Properties;
                                                            foreach (var materialSubProperty in properties.Where(p => !p.IsValue))
                                                            {
                                                                writer.WriteLine("using (var m2 = m.Open{0}Property())", materialSubProperty.NameWithPascalCase);
                                                                using (writer.OpenScope())
                                                                {
                                                                    writer.WriteLine("m2.WriteReference(new Reference(\"{0}\", new List<string> {{ \"{1}\", \"{2}\", \"{3}\" }}));", materialId, propertyName, subPropertyName, materialSubProperty.Name);
                                                                    WriteAssertion(writer, isExtension, "expect(e.{1}.{2}.{3}.getValue(date)).toEqual({0}.{1}.{2}.{3}.getValue(date));", materialId, propertyName, subPropertyName, materialSubProperty.Name);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            else
                                            {
                                                var additionalProperties = subProperty.ValueType.AdditionalProperties;
                                                if (additionalProperties != null)
                                                {
                                                    string targetId = string.Format("obj{0}", s_counter++);
                                                    string targetPropName = string.Format("prop{0}", s_counter++);

                                                    writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                                    using (writer.OpenScope())
                                                    {
                                                        writer.WriteLine("packet.WriteId(\"{0}\");", targetId);

                                                        WriteAssertion(writer, "var {0} = e = dataSource.entities.getById('{0}');", targetId);
                                                        WriteAssertion(writer, "expect(e).toBeDefined();");

                                                        writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                                        writer.WriteLine("using (var w2 = w.Open{0}Property())", subProperty.NameWithPascalCase);
                                                        writer.WriteLine("using (var a = w2.Open{0}Property(\"{1}\"))", additionalProperties.ValueType.NameWithPascalCase, targetPropName);
                                                        using (writer.OpenScope())
                                                        {
                                                            foreach (var additionalProperty in additionalProperties.ValueType.Properties.Where(p => !p.IsValue))
                                                            {
                                                                writer.WriteLine("using (var w3 = a.Open{0}Property())", additionalProperty.NameWithPascalCase);
                                                                using (writer.OpenScope())
                                                                {
                                                                    properties = additionalProperty.ValueType.Properties;
                                                                    var firstValueProperty = properties.FirstOrDefault(p => p.IsValue);
                                                                    if (firstValueProperty != null)
                                                                    {
                                                                        WriteValue(writer, "w3", firstValueProperty, isExtension, string.Format("{0}.{1}.{2}.{3}", propertyName, subPropertyName, targetPropName, additionalProperty.Name));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                    writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                                    using (writer.OpenScope())
                                                    {
                                                        string referenceId = string.Format("reference{0}", s_counter++);
                                                        string propName = string.Format("prop{0}", s_counter++);
                                                        writer.WriteLine("packet.WriteId(\"{0}\");", referenceId);

                                                        WriteAssertion(writer, "e = dataSource.entities.getById('{0}');", referenceId);
                                                        WriteAssertion(writer, "expect(e).toBeDefined();");

                                                        writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                                        writer.WriteLine("using (var w2 = w.Open{0}Property())", subProperty.NameWithPascalCase);
                                                        writer.WriteLine("using (var a = w2.Open{0}Property(\"{1}\"))", additionalProperties.ValueType.NameWithPascalCase, propName);
                                                        using (writer.OpenScope())
                                                        {
                                                            foreach (var additionalProperty in additionalProperties.ValueType.Properties.Where(p => !p.IsValue))
                                                            {
                                                                writer.WriteLine("using (var w3 = a.Open{0}Property())", additionalProperty.NameWithPascalCase);
                                                                using (writer.OpenScope())
                                                                {
                                                                    writer.WriteLine("w3.WriteReference(new Reference(\"{0}\", new List<string> {{ \"{1}\", \"{2}\", \"{3}\", \"{4}\" }}));", targetId, propertyName, subPropertyName, targetPropName, additionalProperty.Name);
                                                                    WriteAssertion(writer, isExtension, "expect(e.{1}.{2}.{3}.{5}.getValue(date)).toEqual({0}.{1}.{2}.{4}.{5}.getValue(date));", targetId, propertyName, subPropertyName, propName, targetPropName, additionalProperty.Name);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                // test sampled properties

                                foreach (var property in schemaProperties)
                                {
                                    string propertyName = property.Name;

                                    bool isExtension = !string.IsNullOrEmpty(property.ValueType.ExtensionPrefix);
                                    if (isExtension)
                                        propertyName = propertyName.Substring(property.ValueType.ExtensionPrefix.Length + 1);

                                    var properties = property.ValueType.Properties;

                                    if (property.IsInterpolatable)
                                    {
                                        foreach (var valueProperty in properties.Where(p => p.IsValue && (p.ValueType.JsonTypes & JsonSchemaType.Array) == JsonSchemaType.Array))
                                        {
                                            writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                            using (writer.OpenScope())
                                            {
                                                string id = string.Format("sampled{0}", s_counter++);
                                                writer.WriteLine("packet.WriteId(\"{0}\");", id);
                                                WriteAssertion(writer, "e = dataSource.entities.getById('{0}');", id);
                                                WriteAssertion(writer, "expect(e).toBeDefined();");
                                                writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                                using (writer.OpenScope())
                                                {
                                                    WriteValues(writer, "w", valueProperty, isExtension, propertyName);
                                                }
                                            }
                                        }
                                    }
                                    else
                                    {
                                        foreach (var subProperty in properties.Where(p => !p.IsValue))
                                        {
                                            string subPropertyName = GetSubPropertyName(propertyName, subProperty);

                                            properties = subProperty.ValueType.Properties;

                                            if (subProperty.IsInterpolatable)
                                            {
                                                foreach (var valueProperty in properties.Where(p => p.IsValue && (p.ValueType.JsonTypes & JsonSchemaType.Array) == JsonSchemaType.Array))
                                                {
                                                    writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                                    using (writer.OpenScope())
                                                    {
                                                        string id = string.Format("sampled{0}", s_counter++);
                                                        writer.WriteLine("packet.WriteId(\"{0}\");", id);

                                                        WriteAssertion(writer, "e = dataSource.entities.getById('{0}');", id);
                                                        WriteAssertion(writer, "expect(e).toBeDefined();");

                                                        writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                                        writer.WriteLine("using (var w2 = w.Open{0}Property())", subProperty.NameWithPascalCase);
                                                        using (writer.OpenScope())
                                                        {
                                                            WriteValues(writer, "w2", valueProperty, isExtension, string.Format("{0}.{1}", propertyName, subPropertyName));
                                                        }
                                                    }
                                                }
                                            }
                                            else if (subProperty.ValueType.Name.Contains("Material"))
                                            {
                                                foreach (var materialProperty in properties)
                                                {
                                                    properties = materialProperty.ValueType.Properties;
                                                    foreach (var materialSubProperty in properties.Where(p => p.IsInterpolatable))
                                                    {
                                                        properties = materialSubProperty.ValueType.Properties;
                                                        foreach (var valueProperty in properties.Where(p => p.IsValue && (p.ValueType.JsonTypes & JsonSchemaType.Array) == JsonSchemaType.Array))
                                                        {
                                                            writer.WriteLine("using (var packet = writer.OpenPacket(output))");
                                                            using (writer.OpenScope())
                                                            {
                                                                string id = string.Format("sampledmaterial{0}", s_counter++);
                                                                writer.WriteLine("packet.WriteId(\"{0}\");", id);

                                                                WriteAssertion(writer, "e = dataSource.entities.getById('{0}');", id);
                                                                WriteAssertion(writer, "expect(e).toBeDefined();");

                                                                writer.WriteLine("using (var w = packet.Open{0}Property())", property.NameWithPascalCase);
                                                                writer.WriteLine("using (var w2 = w.Open{0}Property())", subProperty.NameWithPascalCase);
                                                                writer.WriteLine("using (var m = w2.Open{0}Property())", materialProperty.NameWithPascalCase);
                                                                writer.WriteLine("using (var m2 = m.Open{0}Property())", materialSubProperty.NameWithPascalCase);
                                                                using (writer.OpenScope())
                                                                {
                                                                    WriteValues(writer, "m2", valueProperty, isExtension, string.Format("{0}.{1}.{2}", propertyName, subPropertyName, materialSubProperty.Name));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                writer.WriteLine("output.WriteEndSequence();");

                                s_assertionIndent--;
                                WriteAssertion(writer, "});");
                            }
                        }
                    }
                }
            }
        }

        private static string GetSubPropertyName(string propertyName, Property subProperty)
        {
            string subPropertyName = subProperty.Name;
            if (subPropertyName == "gltf")
                subPropertyName = "uri";
            else if (propertyName == "polygon" && subPropertyName == "positions")
                subPropertyName = "hierarchy";
            return subPropertyName;
        }

        private static void WriteValue(CodeWriter writer, string openWriterName, Property property, bool isExtension, string propertyName)
        {
            string value;
            string assertionValue;
            string assertionEpsilon;
            GetUniqueValue(property, out value, out assertionValue, out assertionEpsilon);
            writer.WriteLine("{0}.Write{1}({2});", openWriterName, property.NameWithPascalCase, value);
            WriteAssertion(writer, "{0}expect(e.{1}.getValue(date)).toEqual{2}({3}{4});",
                           isExtension ? "checkExtensions && " : "",
                           propertyName,
                           assertionEpsilon == null ? "" : "Epsilon",
                           assertionValue,
                           assertionEpsilon == null ? "" : string.Format(", {0}", assertionEpsilon));
        }

        private static void WriteValues(CodeWriter writer, string openWriterName, Property property, bool isExtension, string propertyName)
        {
            string value1;
            string assertionValue1;
            string assertionEpsilon1;
            GetUniqueValue(property, out value1, out assertionValue1, out assertionEpsilon1);
            string value2;
            string assertionValue2;
            string assertionEpsilon2;
            GetUniqueValue(property, out value2, out assertionValue2, out assertionEpsilon2);
            writer.WriteLine("{0}.Write{1}(new [] {{ documentStartDate, documentStopDate, }}, new [] {{ {2}, {3} }});", openWriterName, property.NameWithPascalCase, value1, value2);
            WriteAssertion(writer, "{0}expect(e.{1}.getValue(documentStartDate)).toEqual{2}({3}{4});",
                           isExtension ? "checkExtensions && " : "",
                           propertyName,
                           assertionEpsilon1 == null ? "" : "Epsilon",
                           assertionValue1,
                           assertionEpsilon1 == null ? "" : string.Format(", {0}", assertionEpsilon1));
            WriteAssertion(writer, "{0}expect(e.{1}.getValue(documentStopDate)).toEqual{2}({3}{4});",
                           isExtension ? "checkExtensions && " : "",
                           propertyName,
                           assertionEpsilon2 == null ? "" : "Epsilon",
                           assertionValue2,
                           assertionEpsilon2 == null ? "" : string.Format(", {0}", assertionEpsilon2));
        }

        private static int s_counter = 0;

        private static void GetUniqueValue(Property property, out string value, out string assertionValue, out string assertionEpsilon)
        {
            value = "";
            assertionValue = "";
            assertionEpsilon = null;

            switch (property.ValueType.Name)
            {
                case "Boolean":
                {
                    value = assertionValue = "true";
                    return;
                }
                case "Double":
                {
                    value = assertionValue = s_counter++.ToString("#.0");
                    return;
                }
                case "DoubleList":
                {
                    int v1 = s_counter++;
                    int v2 = s_counter++;
                    value = string.Format("new List<double> {{ {0}, {1} }}", v1, v2);
                    assertionValue = string.Format("[ {0}, {1} ]", v1, v2);
                    return;
                }
                case "String":
                {
                    string v = string.Format("string{0}", s_counter++);
                    value = string.Format("\"{0}\"", v);
                    assertionValue = string.Format("'{0}'", v);
                    return;
                }
                case "Cartesian3":
                {
                    int x = s_counter++;
                    int y = s_counter++;
                    int z = s_counter++;
                    value = string.Format("new Cartesian({0}, {1}, {2})", x, y, z);
                    assertionValue = string.Format("new Cartesian3({0}, {1}, {2})", x, y, z);
                    return;
                }
                case "UnitCartesian3":
                {
                    double x = s_counter++;
                    double y = s_counter++;
                    double z = s_counter++;

                    double magnitude = Math.Sqrt(x * x + y * y + z * z);

                    x /= magnitude;
                    y /= magnitude;
                    z /= magnitude;

                    value = string.Format("new UnitCartesian({0}, {1}, {2})", x, y, z);
                    assertionValue = string.Format("new Cartesian3({0}, {1}, {2})", x, y, z);
                    return;
                }
                case "Cartesian3Velocity":
                {
                    int x = s_counter++;
                    int y = s_counter++;
                    int z = s_counter++;
                    int dX = s_counter++;
                    int dY = s_counter++;
                    int dZ = s_counter++;
                    value = string.Format("new Motion<Cartesian>(new Cartesian({0}, {1}, {2}), new Cartesian({3}, {4}, {5}))", x, y, z, dX, dY, dZ);
                    assertionValue = string.Format("new Cartesian3({0}, {1}, {2})", x, y, z);
                    return;
                }
                case "Cartographic":
                {
                    bool isDegrees = property.Name == "cartographicDegrees";
                    double longitude = s_counter++ % (isDegrees ? 45 : Math.PI / 2);
                    double latitude = s_counter++ % (isDegrees ? 45 : Math.PI / 2);
                    double height = s_counter++;
                    value = string.Format("new Cartographic({0}, {1}, {2})", longitude, latitude, height);
                    assertionValue = string.Format("Cartesian3.from{0}({1}, {2}, {3})", isDegrees ? "Degrees" : "Radians", longitude, latitude, height);
                    return;
                }
                case "Cartesian3List":
                {
                    int x1 = s_counter++;
                    int y1 = s_counter++;
                    int z1 = s_counter++;
                    int x2 = s_counter++;
                    int y2 = s_counter++;
                    int z2 = s_counter++;
                    value = string.Format("new List<Cartesian> {{ new Cartesian({0}, {1}, {2}), new Cartesian({3}, {4}, {5}) }}", x1, y1, z1, x2, y2, z2);
                    assertionValue = string.Format("[ new Cartesian3({0}, {1}, {2}), new Cartesian3({3}, {4}, {5}) ]", x1, y1, z1, x2, y2, z2);
                    return;
                }
                case "Cartesian2":
                {
                    int x = s_counter++;
                    int y = s_counter++;
                    value = string.Format("new Rectangular({0}, {1})", x, y);
                    assertionValue = string.Format("new Cartesian2({0}, {1})", x, y);
                    return;
                }
                case "Spherical":
                {
                    int clock = s_counter++;
                    int cone = s_counter++;
                    int magnitude = s_counter++;
                    value = string.Format("new Spherical({0}, {1}, {2})", clock, cone, magnitude);
                    assertionValue = string.Format("new Spherical({0}, {1}, {2})", clock, cone, magnitude);
                    return;
                }
                case "UnitSpherical":
                {
                    int clock = s_counter++;
                    int cone = s_counter++;
                    value = string.Format("new UnitSpherical({0}, {1})", clock, cone);
                    assertionValue = string.Format("new Spherical({0}, {1})", clock, cone);
                    return;
                }
                case "SphericalList":
                {
                    int clock1 = s_counter++;
                    int cone1 = s_counter++;
                    int magnitude1 = s_counter++;
                    int clock2 = s_counter++;
                    int cone2 = s_counter++;
                    int magnitude2 = s_counter++;
                    value = string.Format("new List<Spherical> {{ new Spherical({0}, {1}, {2}), new Spherical({3}, {4}, {5}) }}", clock1, cone1, magnitude1, clock2, cone2, magnitude2);
                    assertionValue = string.Format("[ new Spherical({0}, {1}, {2}), new Spherical({3}, {4}, {5}) ]", clock1, cone1, magnitude1, clock2, cone2, magnitude2);
                    return;
                }
                case "UnitQuaternion":
                {
                    double w = s_counter++;
                    double x = s_counter++;
                    double y = s_counter++;
                    double z = s_counter++;

                    double magnitude = Math.Sqrt(w * w + x * x + y * y + z * z);

                    w /= magnitude;
                    x /= magnitude;
                    y /= magnitude;
                    z /= magnitude;
                    value = string.Format("new UnitQuaternion({0}, {1}, {2}, {3})", w, x, y, z);
                    assertionValue = string.Format("new Quaternion({0}, {1}, {2}, {3})", x, y, z, w);
                    assertionEpsilon = "1e-14";
                    return;
                }
                case "Rgba":
                {
                    int a = s_counter++ % 255;
                    int r = s_counter++ % 255;
                    int g = s_counter++ % 255;
                    int b = s_counter++ % 255;

                    value = string.Format("Color.FromArgb({0}, {1}, {2}, {3})", a, r, g, b);
                    assertionValue = string.Format("Color.fromBytes({0}, {1}, {2}, {3})", r, g, b, a);
                    return;
                }
                case "Rgbaf":
                {
                    int a = s_counter++ % 255;
                    int r = s_counter++ % 255;
                    int g = s_counter++ % 255;
                    int b = s_counter++ % 255;

                    value = string.Format("Color.FromArgb({0}, {1}, {2}, {3})", a, r, g, b);
                    assertionValue = string.Format("new Color({0}, {1}, {2}, {3})", r / 255.0, g / 255.0, b / 255.0, a / 255.0);
                    assertionEpsilon = "1e-6";
                    return;
                }
                case "VerticalOrigin":
                {
                    value = "CesiumVerticalOrigin.Bottom";
                    assertionValue = "VerticalOrigin.BOTTOM";
                    return;
                }
                case "HorizontalOrigin":
                {
                    value = "CesiumHorizontalOrigin.Left";
                    assertionValue = "HorizontalOrigin.LEFT";
                    return;
                }
                case "LabelStyle":
                {
                    value = "CesiumLabelStyle.FillAndOutline";
                    assertionValue = "LabelStyle.FILL_AND_OUTLINE";
                    return;
                }
                case "CornerType":
                {
                    value = "CesiumCornerType.Beveled";
                    assertionValue = "CornerType.BEVELED";
                    return;
                }
                case "StripeOrientation":
                {
                    value = "CesiumStripeOrientation.Vertical";
                    assertionValue = "StripeOrientation.VERTICAL";
                    return;
                }
                case "SensorVolumePortionToDisplay":
                {
                    value = "CesiumSensorVolumePortionToDisplay.BelowEllipsoidHorizon";
                    assertionValue = "SensorVolumePortionToDisplay.BELOW_ELLIPSOID_HORIZON";
                    return;
                }
                case "Font":
                {
                    string s = string.Format("{0}px sans-serif", s_counter++ % 25);
                    value = string.Format("\"{0}\"", s);
                    assertionValue = string.Format("'{0}'", s);
                    return;
                }
                case "Uri":
                {
                    string s = string.Format("http://example.com/{0}", s_counter++);
                    value = string.Format("\"{0}\", CesiumResourceBehavior.LinkTo", s);
                    assertionValue = string.Format("'{0}'", s);
                    return;
                }
                case "NearFarScalar":
                {
                    int nearDistance = s_counter++;
                    int nearValue = s_counter++;
                    int farDistance = s_counter++;
                    int farValue = s_counter++;

                    value = string.Format("new NearFarScalar({0}, {1}, {2}, {3})", nearDistance, nearValue, farDistance, farValue);
                    assertionValue = string.Format("new NearFarScalar({0}, {1}, {2}, {3})", nearDistance, nearValue, farDistance, farValue);
                    return;
                }
                case "BoundingRectangle":
                {
                    int x = s_counter++;
                    int y = s_counter++;
                    int width = s_counter++;
                    int height = s_counter++;

                    value = string.Format("BoundingRectangle.FromWidthHeight({0}, {1}, {2}, {3})", x, y, width, height);
                    assertionValue = string.Format("new BoundingRectangle({0}, {1}, {2}, {3})", x, y, width, height);
                    return;
                }
                case "CartographicRectangle":
                {
                    bool isDegrees = property.Name == "wsenDegrees";
                    double w = s_counter++ % (isDegrees ? 45 : Math.PI / 2);
                    double s = s_counter++ % (isDegrees ? 45 : Math.PI / 2);
                    double e = s_counter++ % (isDegrees ? 45 : Math.PI / 2);
                    double n = s_counter++ % (isDegrees ? 45 : Math.PI / 2);

                    value = string.Format("new CartographicExtent({0}, {1}, {2}, {3})", w, s, e, n);
                    assertionValue = string.Format("{0}({1}, {2}, {3}, {4})", isDegrees ? "Rectangle.fromDegrees" : "new Rectangle", w, s, e, n);
                    return;
                }
            }
        }

        private static int s_assertionIndent = 0;

        private static void WriteAssertion(CodeWriter writer, string assertion, params object[] args)
        {
            WriteAssertion(writer, false, string.Format(assertion, args));
        }

        private static void WriteAssertion(CodeWriter writer, bool isExtension, string assertion, params object[] args)
        {
            WriteAssertion(writer, isExtension, string.Format(assertion, args));
        }

        private static void WriteAssertion(CodeWriter writer, string assertion)
        {
            WriteAssertion(writer, false, assertion);
        }

        private static void WriteAssertion(CodeWriter writer, bool isExtension, string assertion)
        {
            string indent = new string(' ', s_assertionIndent * 4);
            writer.WriteLine(string.Format("assertionsStreamWriter.WriteLine(\"{0}{1}{2}\");", indent, isExtension ? "checkExtensions && " : "", assertion));
        }
    }
}