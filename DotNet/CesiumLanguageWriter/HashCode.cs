using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Contains static methods for working with hash codes.
    /// </summary>
    public static class HashCode
    {
        /// <summary>
        /// Combines an arbitrary number of hash codes.
        /// </summary>
        /// <param name="hashes">The hash codes.</param>
        /// <returns>The combined hash code.</returns>
        public static int Combine([NotNull] params int[] hashes)
        {
            int result = 17;
            foreach (int hash in hashes)
            {
                result = result * 31 + hash;
            }
            return result;
        }

        /// <summary>
        /// Gets a hash code for a specified object, or zero if the object is <see langword="null"/>.
        /// </summary>
        /// <param name="o">The object for which to get the hash code.</param>
        /// <returns>The hash code of the object, or zero if the object is <see langword="null"/>.</returns>
        public static int GetHashCode([CanBeNull] object o)
        {
            return o == null ? 0 : o.GetHashCode();
        }
    }
}