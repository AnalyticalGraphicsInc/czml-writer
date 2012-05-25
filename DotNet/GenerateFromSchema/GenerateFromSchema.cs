using System;
using System.IO;

namespace GenerateFromSchema
{
    public class GenerateFromSchema
    {
        public static void Main(string[] args)
        {
            if (args.Length < 3)
            {
                PrintUsage();
                return;
            }

            string packetSchemaPath = args[0];
            string outputType = args[1];
            string output = args[2];

            Generator generator;

            switch (outputType)
            {
                case "markdown":
                    generator = new MarkdownGenerator(output);
                    break;
                case "csharp":
                    {
                        if (args.Length < 4)
                        {
                            PrintUsage();
                            return;
                        }
                        string configurationFileName = args[3];
                        generator = new CSharpGenerator(output, configurationFileName);
                    }
                    break;
                default:
                    PrintUsage();
                    return;
            }

            // Load the schema
            var schemaLoader = new SchemaLoader(Path.GetDirectoryName(packetSchemaPath));
            Schema packetSchema = schemaLoader.Load(packetSchemaPath);

            // Generate output from the schema.
            generator.Generate(packetSchema);
        }

        private static void PrintUsage()
        {
            Console.WriteLine("Usage:");
            Console.WriteLine("\tGenerateWritersFromSchema <schema> markdown <outputFile>");
            Console.WriteLine("\tGenerateWritersFromSchema <schema> csharp <outputDirectory> <configurationFileName>");
        }
    }
}
