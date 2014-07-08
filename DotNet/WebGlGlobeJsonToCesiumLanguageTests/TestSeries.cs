using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;
using WebGLGlobeJsonToCesiumLanguage;

namespace WebGLGlobeJsonToCesiumLanguageTests
{
    [TestFixture]
    public class TestSeries
    {
        private StringWriter m_stringWriter;
        private CzmlDocument m_document;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_document = new CzmlDocument(m_stringWriter);
        }

        [Test]
        public void UsesCartographicDegrees()
        {
            Series series = new Series("test", new[] { new Cartographic(90, 45, 3) }, m_document);
            series.Write();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"cartographicDegrees\":", result);
            StringAssert.Contains("[90,45,0,90,45,3]", result);
        }

        [Test]
        public void GeneratesIndexedIds()
        {
            Series series = new Series("test", new[] { new Cartographic(1, 2, 3), new Cartographic(4, 5, 6) }, m_document);
            series.Write();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"id\":\"test0\"", result);
            StringAssert.Contains("\"id\":\"test1\"", result);
        }

        [Test]
        public void ListsPositionsForBothEndPoints()
        {
            Series series = new Series("test", new[] { new Cartographic(1, 2, 3) }, m_document);
            series.Write();

            string result = m_stringWriter.ToString();
            StringAssert.Contains("\"positions\":{\"cartographicDegrees\":[1,2,0,1,2,3]}", result);
        }
    }
}