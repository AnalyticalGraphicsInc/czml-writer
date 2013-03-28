using System;
using System.IO;
using NUnit.Framework;
using WebGLGlobeJsonToCesiumLanguage;

namespace WebGLGlobeJsonToCesiumLanguageTests
{
    [TestFixture]
    public class TestWebGLGlobeJsonConverter
    {
        private StringWriter m_stringWriter;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
        }

        [Test]
        public void ConvertsValidJson()
        {
            StringReader json = new StringReader("[['alpha', [45, -90, 1]], ['bravo', [50, -70, 2]]]");
            WebGLGlobeJsonConverter.WebGLGlobeJsonToCesiumLanguage(json, m_stringWriter);

            string result = m_stringWriter.ToString();
            StringAssert.Contains("{\"id\":\"alpha0\",\"polyline\":{\"color\":{\"rgba\":[255,153,0,255]}},\"vertexPositions\":{\"cartographicDegrees\":[-90.0,45.0,0.0,-90.0,45.0,1.0]}}", result);
            StringAssert.Contains("{\"id\":\"bravo0\",\"polyline\":{\"color\":{\"rgba\":[255,0,0,255]}},\"vertexPositions\":{\"cartographicDegrees\":[-70.0,50.0,0.0,-70.0,50.0,2.0]}}", result);
        }

        [Test]
        public void ConvertInvalidWebGLGlobeJson()
        {
            StringReader json = new StringReader("[['alpha', [1, 2, 3, 4]]]");

            Assert.Throws(typeof(ArgumentException), () => WebGLGlobeJsonConverter.WebGLGlobeJsonToCesiumLanguage(json, m_stringWriter));
        }

        [Test]
        public void TestConvertingAnEntireFile()
        {
            using (var reader = new StreamReader("population909500.json"))
            {
                WebGLGlobeJsonConverter.WebGLGlobeJsonToCesiumLanguage(reader, m_stringWriter);
            }

            Assert.IsNotEmpty(m_stringWriter.ToString());
        }
    }
}