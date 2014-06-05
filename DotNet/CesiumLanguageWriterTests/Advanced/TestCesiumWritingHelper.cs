using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests.Advanced
{
    [TestFixture]
    public class TestCesiumWritingHelper
    {
        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_outputStream = new CesiumOutputStream(m_stringWriter);
        }

        [Test]
        public void CanWriteReference()
        {
            CesiumWritingHelper.WriteReference(m_outputStream, new Reference("bar", "color"));
            Assert.AreEqual("\"bar#color\"", m_stringWriter.ToString());
        }

        [Test]
        public void CanWriteReferences()
        {
            CesiumWritingHelper.WriteReferences(m_outputStream, new[] { new Reference("bar", "color"), new Reference("foo", "color2") });
            Assert.AreEqual("[\"bar#color\",\"foo#color2\"]", m_stringWriter.ToString());
        }

        private StringWriter m_stringWriter;
        private CesiumOutputStream m_outputStream;
    }
}
