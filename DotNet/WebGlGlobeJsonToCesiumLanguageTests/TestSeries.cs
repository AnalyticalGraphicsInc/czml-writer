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
            Series series = new Series("test", new[] { new Cartographic(90.0, 45.0, 3.0) }, m_document);
            series.Write();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"cartographicDegrees\":"));
            Assert.That(result.Contains("[90.0,45.0,0.0,90.0,45.0,3.0]"));
        }

        [Test]
        public void GeneratesIndexedIds()
        {
            Series series = new Series("test", new[] { new Cartographic(1.0, 2.0, 3.0), new Cartographic(4.0, 5.0, 6.0) }, m_document);
            series.Write();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"id\":\"test0\""));
            Assert.That(result.Contains("\"id\":\"test1\""));
        }

        [Test]
        public void ListsVertexPositionsForBothEndPoints()
        {
            Series series = new Series("test", new[] { new Cartographic(1.0, 2.0, 3.0) }, m_document);
            series.Write();

            string result = m_stringWriter.ToString();
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicDegrees\":[1.0,2.0,0.0,1.0,2.0,3.0]}"));
        }
    }
}