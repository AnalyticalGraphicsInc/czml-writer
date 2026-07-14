namespace GenerateFromSchema;

public static class JsonExtensions
{
    public static string GetRequiredProperty(this JsonNode node, string propertyName) =>
        node[propertyName] switch
        {
            JsonValue value => value.GetValue<string>(),
            _ => throw new InvalidOperationException($"Required property '{propertyName}' is missing or null."),
        };

    [return: NotNullIfNotNull("defaultValue")]
    public static T? GetProperty<T>(this JsonNode node, string propertyName, T? defaultValue = default) =>
        node[propertyName] switch
        {
            JsonValue value => value.GetValue<T>(),
            _ => defaultValue,
        };
}
