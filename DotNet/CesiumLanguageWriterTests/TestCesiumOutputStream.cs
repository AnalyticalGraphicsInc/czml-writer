using System;
using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumOutputStream
    {
        private StringWriter m_stringWriter;
        private CesiumOutputStream m_outputStream;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_outputStream = new CesiumOutputStream(m_stringWriter);
        }

        [TearDown]
        public void TearDown()
        {
            m_stringWriter.Dispose();
        }

        [Test]
        public void WritesObject()
        {
            m_outputStream.WriteStartObject();
            m_outputStream.WritePropertyName("test");
            m_outputStream.WriteValue("value");
            m_outputStream.WriteEndObject();

            Assert.AreEqual("{\"test\":\"value\"}", m_stringWriter.ToString());
        }

        [Test]
        public void WritesSequence()
        {
            m_outputStream.WriteStartSequence();
            m_outputStream.WriteValue(1);
            m_outputStream.WriteValue(2);
            m_outputStream.WriteValue(3);
            m_outputStream.WriteEndSequence();

            Assert.AreEqual("[1,2,3]", m_stringWriter.ToString());
        }

        [Test]
        public void WritesNull()
        {
            m_outputStream.WriteStartObject();
            m_outputStream.WritePropertyName("test");
            m_outputStream.WriteValue((string)null);
            m_outputStream.WriteEndObject();

            Assert.AreEqual("{\"test\":null}", m_stringWriter.ToString());
        }

        [Test]
        public void WritesBoolean()
        {
            m_outputStream.WriteStartSequence();
            m_outputStream.WriteValue(true);
            m_outputStream.WriteValue(false);
            m_outputStream.WriteEndSequence();

            Assert.AreEqual("[true,false]", m_stringWriter.ToString());
        }

        [Test]
        public void WritesUri()
        {
            var uri = new Uri("http://example.com/path?query=1");

            m_outputStream.WriteStartSequence();
            m_outputStream.WriteValue(uri);
            m_outputStream.WriteEndSequence();

            Assert.AreEqual("[\"http://example.com/path?query=1\"]", m_stringWriter.ToString());
        }

        [Test]
        public void PrettyFormattingAddsNewLinesAndIndent()
        {
            m_outputStream = new CesiumOutputStream(m_stringWriter, true);

            m_outputStream.WriteStartSequence();
            m_outputStream.WriteValue(1);
            m_outputStream.WriteLineBreak();
            m_outputStream.WriteValue(2);
            m_outputStream.WriteEndSequence();

            string expected =
                "[" + Environment.NewLine +
                "  1," + Environment.NewLine +
                "  2" + Environment.NewLine +
                "]";
            Assert.AreEqual(expected, m_stringWriter.ToString());
        }

        [Test]
        public void EscapesSpecialCharactersInString()
        {
            const string input = "\t\n\r\f\b\\\"";

            m_outputStream.WriteStartSequence();
            m_outputStream.WriteValue(input);
            m_outputStream.WriteEndSequence();

            Assert.AreEqual("[\"\\t\\n\\r\\f\\b\\\\\\\"\"]", m_stringWriter.ToString());
        }

        [Test]
        public void EscapesControlCharactersAsUnicode()
        {
            string input = new string(new[] { (char)0x0001, (char)0x001F });

            m_outputStream.WriteStartSequence();
            m_outputStream.WriteValue(input);
            m_outputStream.WriteEndSequence();

            Assert.AreEqual("[\"\\u0001\\u001f\"]", m_stringWriter.ToString());
        }
    }
}
