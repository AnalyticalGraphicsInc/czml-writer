using System;
using System.IO;

namespace GenerateFromSchema
{
    public class GenerateFromSchema
    {
        public static void Main(string[] args)
        {
            if (args.Length < 1)
            {
                Console.WriteLine("Usage:");
                Console.WriteLine("\tGenerateWritersFromSchema <full path to Packet.jsonschema>");
                return;
            }

            string packetSchemaPath = args[0];

            var schemaLoader = new SchemaLoader(Path.GetDirectoryName(packetSchemaPath));
            Schema packetSchema = schemaLoader.Load(packetSchemaPath);

            var documentation = new MarkdownGenerator();
            documentation.Generate(packetSchema, Console.Out);
        }
    }
}
