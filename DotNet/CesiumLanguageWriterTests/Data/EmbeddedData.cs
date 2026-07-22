using System.IO;
using System.Reflection;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests.Data
{
    public static class EmbeddedData
    {
        [NotNull]
        public static Stream Read([NotNull] string file)
        {
            var stream = Assembly.GetExecutingAssembly().GetManifestResourceStream(typeof(EmbeddedData), file);
            Assert.IsNotNull(stream);
            return stream;
        }
    }
}
