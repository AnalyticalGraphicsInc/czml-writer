using System;
using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumStreamWriter
    {
        private StringWriter m_stringWriter;
        private CesiumOutputStream m_outputStream;
        private CesiumStreamWriter m_writer;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_outputStream = new CesiumOutputStream(m_stringWriter);
            m_writer = new CesiumStreamWriter();
        }

        [TearDown]
        public void TearDown()
        {
            m_stringWriter.Dispose();
        }

        [Test]
        public void NewPacketWritesObjectLiteral()
        {
            var packet = m_writer.OpenPacket(m_outputStream);
            packet.Close();

            Assert.AreEqual("{}", m_stringWriter.ToString());
        }

        [Test]
        public void SuccessiveCallsToNewPacketReturnSameInstance()
        {
            m_outputStream.WriteStartSequence();
            var packet1 = m_writer.OpenPacket(m_outputStream);
            packet1.Close();
            var packet2 = m_writer.OpenPacket(m_outputStream);
            packet2.Close();
            m_outputStream.WriteEndSequence();
            Assert.AreSame(packet1, packet2);
        }

        [Test]
        public void MultipleCallsToNewPacketWithoutCloseThrowInvalidOperationException()
        {
            var unused = m_writer.OpenPacket(m_outputStream);
            var exception = Assert.Throws<InvalidOperationException>(() => m_writer.OpenPacket(m_outputStream));
            StringAssert.Contains("already opened", exception.Message);
        }
    }
}