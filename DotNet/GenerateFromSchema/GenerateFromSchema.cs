using System;
using System.IO;
using CommandLine;
using CommandLine.Text;

namespace GenerateFromSchema
{
    public class GenerateFromSchema
    {
        public enum GeneratorType
        {
            CSharp,
            MarkDown,
            Validation
        }

        public class Options
        {
            [Option('p', "packet", Required = true, HelpText = "The path to the Packet schema file.")]
            public string PacketSchema { get; set; }

            [Option('t', "type", Required = true, HelpText = "The type of output to generate.")]
            public GeneratorType Type { get; set; }

            [Option('o', "output", Required = true, HelpText = "The output location.")]
            public string Output { get; set; }

            [Option("configuration", HelpText = "The configuration file for the CSharp generator.")]
            public string ConfigurationFile { get; set; }

            [HelpOption]
            public string Usage()
            {
                var help = new HelpText { AddDashesToOption = true };
                help.AddOptions(this);
                return help;
            }
        }

        public static void Main(string[] args)
        {
            var options = new Options();
            if (!Parser.Default.ParseArgumentsStrict(args, options))
            {
                return;
            }

            Generator generator;

            switch (options.Type)
            {
                case GeneratorType.MarkDown:
                    generator = new MarkdownGenerator(options.Output);
                    break;
                case GeneratorType.CSharp:
                    if (options.ConfigurationFile == null)
                    {
                        Console.Error.WriteLine("ERROR: When type is CSharp, a configuration file is required.");
                        return;
                    }

                    generator = new CSharpGenerator(options.Output, options.ConfigurationFile);
                    break;
                case GeneratorType.Validation:
                    generator = new ValidationDocumentGenerator(options.Output);
                    break;
                default:
                    return;
            }

            // Load the schema
            var schemaLoader = new SchemaLoader(Path.GetDirectoryName(options.PacketSchema));
            Schema packetSchema = schemaLoader.Load(options.PacketSchema);

            // Generate output from the schema.
            generator.Generate(packetSchema);
        }
    }
}