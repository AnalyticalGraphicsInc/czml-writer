namespace CesiumLanguageWriter
{
    /// <summary>
    /// Helper class to combine hashcodes.
    /// </summary>
    public static class HashCode
    {
        /// <summary>
        /// Combine hashcodes into a single hashcode.
        /// </summary>
        /// <param name="hashcodes">The hashcodes to combine.</param>
        /// <returns>A single overall hashcode.</returns>
        public static int Combine(params int[] hashcodes)
        {
            int hash = 17;
            foreach (int hashcode in hashcodes)
            {
                hash = hash * 31 + hashcode;
            }
            return hash;
        }
    }
}