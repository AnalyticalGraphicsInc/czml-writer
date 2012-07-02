using CesiumLanguageWriter;
using NUnit.Framework;
using System.Drawing;
using WebGLGlobeJsonToCesiumLanguage;

namespace WebGLGlobeJsonToCesiumLanguageTests
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
        public void UsesCartographicDegrees()
        {
            Series series = new Series("test", new Cartographic[] { new Cartographic(90.0, 45.0, 3.0) }, m_document);
            series.Write();
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("\"cartographicDegrees\":"));
            Assert.That(result.Contains("[90.0,45.0,0.0,90.0,45.0,3.0]"));
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

        [Test]
        public void ListsVertexPositionsForBothEndPoints()
        {
            Series series = new Series("test", new Cartographic[] { new Cartographic(1.0, 2.0, 3.0) }, m_document);
            series.Write();
            string result = m_document.StringWriter.ToString();
            Assert.That(result.Contains("\"vertexPositions\":{\"cartographicDegrees\":[1.0,2.0,0.0,1.0,2.0,3.0]}"));
        }
    }
}