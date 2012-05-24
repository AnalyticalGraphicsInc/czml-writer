
namespace GenerateFromSchema
{
    public static class StringHelper
    {
        public static string CapitalizeFirstLetter(string s)
        {
            if (s.Length == 0)
                return s;

            return char.ToUpperInvariant(s[0]) + s.Substring(1);
        }

        public static string UncapitalizeFirstLetter(string s)
        {
            if (string.IsNullOrEmpty(s))
                return s;

            return char.ToLowerInvariant(s[0]) + s.Substring(1);
        }
    }
}
