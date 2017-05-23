using System.IO;
using System.Reflection;

namespace CesiumLanguageWriterTests.Data
{
    public static class EmbeddedData
    {
        public static Stream Read(string file)
        {
            return Assembly.GetExecutingAssembly().GetManifestResourceStream(typeof(EmbeddedData), file);
        }
    }
}