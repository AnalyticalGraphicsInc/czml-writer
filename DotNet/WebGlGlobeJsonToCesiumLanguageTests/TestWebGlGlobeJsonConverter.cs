using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using System.Text;
using NUnit.Framework;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using CesiumLanguageWriter;
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
            byte[] json = Encoding.ASCII.GetBytes("[['alpha', [180, 360, 1]], ['bravo', [180, 360, 2]]]");
            WebGlGlobeJsonConverter.WebGlGlobeJsonToCesiumLanguage(json, m_document);
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("{\"id\":\"alpha0\",\"position\":{\"cartographicRadians\":[3.141592653589793,6.283185307179586,1.0]}}"));
            Assert.That(result.Contains("{\"id\":\"bravo0\",\"position\":{\"cartographicRadians\":[3.141592653589793,6.283185307179586,2.0]}}"));
        }
    }
}
