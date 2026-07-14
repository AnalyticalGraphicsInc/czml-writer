using CommandLine;

namespace GenerateFromSchema;

public static class GenerateFromSchema
{
    public static void Main(string[] args)
    {
        using var parser = new Parser(settings =>
        {
            settings.CaseInsensitiveEnumValues = true;
            settings.HelpWriter = Console.Error;
        });
        parser.ParseArguments<Options>(args).WithParsed(Run);
    }

    private static void Run(Options options)
    {
        var generator = CreateGenerator(options);

        // Load the schema
        var schemaLoader = new SchemaLoader(Path.GetDirectoryName(options.PacketSchema)!);
        var packetSchema = schemaLoader.Load(options.PacketSchema);

        // Generate output from the schema.
        generator.Generate(packetSchema);
    }

    private static Generator CreateGenerator(Options options)
    {
        string GetRequiredConfigurationFile() =>
            options.ConfigurationFile ?? throw new Exception("ERROR: Configuration file is required.");

        return options.Type switch
        {
            GeneratorType.MarkDown => new MarkdownGenerator(options.Output),
            GeneratorType.CSharp => new CSharpGenerator(options.Output, GetRequiredConfigurationFile()),
            GeneratorType.Validation => new ValidationDocumentGenerator(options.Output),
        };
    }
}
