using System.IO;
using KmlToCesiumLanguage;
using NUnit.Framework;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestKmlConverter
    {
        private StringWriter m_stringWriter;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
        }

        [Test]
        public void ConvertKmlFile()
        {
            using (var textReader = File.OpenText(@"KmlDocs\STS-122-STS-122Ascent.kml"))
            {
                KmlConverter.KmlToCesiumLanguage(textReader, m_stringWriter);
            }

            string czml = m_stringWriter.ToString();
            Assert.IsNotEmpty(czml);
        }

        [Test]
        public void ConvertKmzFile()
        {
            using (var stream = File.OpenRead(@"KmlDocs\I&W KML.kmz"))
            {
                KmlConverter.KmzToCesiumLanguage(stream, m_stringWriter);
            }

            string czml = m_stringWriter.ToString();
            Assert.IsNotEmpty(czml);
        }
    }
}