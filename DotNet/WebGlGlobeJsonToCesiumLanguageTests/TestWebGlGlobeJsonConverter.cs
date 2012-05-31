using System.IO;
using System.Text;
using NUnit.Framework;
using WebGlGlobeJsonToCesiumLanguage;

namespace WebGlGlobeJsonToCesiumLanguageTests
{
    [TestFixture]
    public class TestWebGlGlobeJsonConverter
    {
        CzmlDocument m_document;

        public TestWebGlGlobeJsonConverter()
        {
            m_document = new CzmlDocument();
        }

        [Test]
        public void ConvertsValidJson()
        {
            StringReader json = new StringReader("[['alpha', [45, -90, 1]], ['bravo', [50, -70, 2]]]");
            WebGlGlobeJsonConverter.WebGlGlobeJsonToCesiumLanguage(json, m_document);
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("{\"id\":\"alpha0\",\"position\":{\"cartographicDegrees\":[45.0,-90.0,1.0]}}"));
            Assert.That(result.Contains("{\"id\":\"bravo0\",\"position\":{\"cartographicDegrees\":[50.0,-70.0,2.0]}}"));
        }

        [Test]
        public void ExpectAnArgumentException()
        {
            Assert.Throws(typeof(System.ArgumentException), convertInvalidWebGLGlobeJson);
        }

        void convertInvalidWebGLGlobeJson()
        {
            StringReader json = new StringReader("[['alpha', [1, 2, 3, 4]]]");
            WebGlGlobeJsonConverter.WebGlGlobeJsonToCesiumLanguage(json, m_document);
        }
    }
}
