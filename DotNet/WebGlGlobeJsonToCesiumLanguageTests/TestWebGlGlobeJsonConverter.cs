using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using System.Text;
using NUnit.Framework;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using CesiumLanguageWriter;
using WebGLGlobeJsonToCesiumLanguage;

namespace WebGLGlobeJsonToCesiumLanguageTests
{
    [TestFixture]
    class TestWebGLGlobeJsonConverter
    {
        CzmlDocument m_document;

        public TestWebGLGlobeJsonConverter()
        {
            m_document = new CzmlDocument();
        }
        
        [Test]
        public void ConvertsToCartographicRadians()
        {
            byte[] json = Encoding.ASCII.GetBytes("[['test', [90, 45, 1.0]]]]");
            WebGlGlobeJsonConverter.WebGLGlobeJsonToCesiumLanguage(json, m_document);
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("\"cartographicRadians\":"));
            Assert.That(result.Contains("[1.5707963267948966,0.7853981633974483,1.0]"));
        }

        [Test]
        public void ExpectAnArgumentException()
        {
            Assert.Throws(typeof(System.ArgumentException), convertWithoutEnoughCoordinateComponents);
        }

        void convertWithoutEnoughCoordinateComponents()
        {
            byte[] json = Encoding.ASCII.GetBytes("[['test', [1, 2]]]");
            WebGlGlobeJsonConverter.WebGLGlobeJsonToCesiumLanguage(json, m_document);
        }

        [Test]
        public void ConvertsValidJson()
        {
            byte[] json = Encoding.ASCII.GetBytes("[['alpha', [180, 360, 1]], ['bravo', [180, 360, 2]]]");
            WebGlGlobeJsonConverter.WebGLGlobeJsonToCesiumLanguage(json, m_document);
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("{\"id\":\"alpha0\",\"position\":{\"cartographicRadians\":[3.141592653589793,6.283185307179586,1.0]}}"));
            Assert.That(result.Contains("{\"id\":\"bravo0\",\"position\":{\"cartographicRadians\":[3.141592653589793,6.283185307179586,2.0]}}"));
        }
    }
}
