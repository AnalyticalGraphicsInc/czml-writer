using CommandLine;

namespace GenerateFromSchema;

public class Options
{
    [Option('p', "packet", Required = true, HelpText = "The path to the Packet schema file.")]
    public required string PacketSchema { get; set; }

    [Option('t', "type", Required = true, HelpText = "The type of output to generate.")]
    public required GeneratorType Type { get; set; }

    [Option('o', "output", Required = true, HelpText = "The output location.")]
    public required string Output { get; set; }

    [Option("configuration", HelpText = "The configuration file for the CSharp generator.")]
    public string? ConfigurationFile { get; set; }
}
