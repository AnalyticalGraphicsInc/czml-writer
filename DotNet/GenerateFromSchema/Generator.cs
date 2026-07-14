namespace GenerateFromSchema;

public abstract class Generator(string? outputDirectory)
{
    public string OutputDirectory { get; } = outputDirectory ?? throw new ArgumentNullException(nameof(outputDirectory));

    public abstract void Generate(Schema schema);
}
