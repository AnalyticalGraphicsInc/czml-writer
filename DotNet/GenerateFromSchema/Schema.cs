namespace GenerateFromSchema;

public class Schema
{
    public required string Name { get; init; }
    public required string Description { get; init; }
    public bool IsValue { get; init; } = false;
    public string? ExtensionPrefix { get; init; }
    public SchemaType JsonTypes { get; init; }

    public List<Schema> Extends { get; } = [];
    public List<Property> Properties { get; } = [];
    public Property? AdditionalProperties { get; set; }
    public List<SchemaEnumValue> EnumValues { get; } = [];
    public List<string> Examples { get; } = [];

    public bool IsArray => JsonTypes.HasFlag(SchemaType.Array);
    public bool IsSchemaFromType => Name == SchemaFromTypeName;
    public string NameWithPascalCase => Name.CapitalizeFirstLetter();
    public bool IsInterpolatable => Extends.Any(schema => schema.Name == InterpolatableProperty);

    /// <summary>
    /// Mixins are other schemas whose properties we inherit.  Because we can't use multiple
    /// inheritance, this defines a set of interfaces we implement, but the implementations
    /// are generated in each class.
    /// </summary>
    public IEnumerable<Schema> Mixins => Extends.Where(schema => schema.Name != InterpolatableProperty);

    public IEnumerable<string> Interfaces => Mixins.Select(schema => $"ICesium{schema.Name}Writer");

    /// <summary>
    /// All properties to be generated, including those properties defined by mixins.
    /// </summary>
    public List<Property> AllProperties => Properties.Concat(Mixins.SelectMany(schema => schema.Properties)).ToList();

    private const string InterpolatableProperty = "InterpolatableProperty";
    public const string SchemaFromTypeName = "<Schema from Type>";
}
