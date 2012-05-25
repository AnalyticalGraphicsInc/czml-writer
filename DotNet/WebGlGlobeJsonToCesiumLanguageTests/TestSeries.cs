using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using CesiumLanguageWriter;
using WebGLGlobeJsonToCesiumLanguage;

namespace WebGlGlobeJsonToCesiumLanguageTests
{
    [TestFixture]
    class TestSeries
    {
        CzmlDocument m_document;

        public TestSeries()
        {
            m_document = new CzmlDocument();
        }
        
        [Test]
        public void GeneratesIndexedIds()
        {
            Series series = new Series("test", new Cartographic[] { new Cartographic(1.0, 2.0, 3.0), new Cartographic(4.0, 5.0, 6.0) }, m_document);
            series.Write();
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("\"id\":\"test0\""));
            Assert.That(result.Contains("\"id\":\"test1\""));
        }
    }
}
