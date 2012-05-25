using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using CesiumLanguageWriter;
using WebGlGlobeJsonToCesiumLanguage;

namespace WebGlGlobeJsonToCesiumLanguageTests
{
    [TestFixture]
    public class TestSeries
    {
        CzmlDocument m_document;

        public TestSeries()
        {
            m_document = new CzmlDocument();
        }

        [Test]
        public void ConvertsToCartographicRadians()
        {
            Series series = new Series("test", new double[] {90.0, 45.0, 3.0}, m_document);
            series.Write();
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("\"cartographicRadians\":"));
            Assert.That(result.Contains("[1.5707963267948966,0.7853981633974483,3.0]"));
        }

        [Test]
        public void GeneratesIndexedIds()
        {
            Series series = new Series("test", new double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 }, m_document);
            series.Write();
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("\"id\":\"test0\""));
            Assert.That(result.Contains("\"id\":\"test1\""));
        }

        [Test]
        public void ExpectAnArgumentException()
        {
            Assert.Throws(typeof(System.ArgumentException), constructSeriesWithoutEnoughCoordinates);
        }

        void constructSeriesWithoutEnoughCoordinates()
        {
            new Series("id", new double[] { 1 }, m_document);
        }
    }
}
