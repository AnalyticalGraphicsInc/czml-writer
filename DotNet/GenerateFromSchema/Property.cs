namespace GenerateFromSchema;

public class Property
{
    public required string Name { get; init; }

    [AllowNull]
    public string Description
    {
        get => m_description ?? ValueType.Description;
        init => m_description = value;
    }

    public required Schema ValueType { get; init; }

    public JsonValue? Default { get; init; }

    public List<string> Examples { get; } = [];

    public bool IsValue => ValueType.IsValue;

    /// <summary>
    /// Indicates that the value must be provided in order for Cesium
    /// to display the graphics.  Because packets can be partial, a valid packet
    /// can omit these properties, so they are not "required" in the schema.
    /// </summary>
    public bool IsRequiredForDisplay { get; init; } = false;

    public string NameWithPascalCase
    {
        get
        {
            if (Name.Length == 0)
                return Name;

            string name = ValueType.ExtensionPrefix switch
            {
                { Length: > 0 and var extensionPrefixLength } => Name[(extensionPrefixLength + 1)..],
                _ => Name,
            };
            return name.CapitalizeFirstLetter();
        }
    }

    public bool IsInterpolatable => ValueType.IsInterpolatable;

    private readonly string? m_description;
}
