namespace GenerateFromSchema;

public static class StringExtensions
{
    public static string Join<T>(this IEnumerable<T> values, string separator) =>
        string.Join(separator, values);

    public static string CapitalizeFirstLetter(this string s) =>
        s.Length switch
        {
            0 => s,
            _ => char.ToUpperInvariant(s[0]) + s[1..],
        };

    public static string UncapitalizeFirstLetter(this string s) =>
        s.Length switch
        {
            0 => s,
            _ => char.ToLowerInvariant(s[0]) + s[1..],
        };
}
