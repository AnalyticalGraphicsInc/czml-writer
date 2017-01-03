using System;
using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumStreamWriter
    {
        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_outputStream = new CesiumOutputStream(m_stringWriter);
            m_writer = new CesiumStreamWriter();
        }

        [Test]
        public void NewPacketWritesObjectLiteral()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream);
            packet.Close();

            Assert.AreEqual("{}", m_stringWriter.ToString());
        }

        [Test]
        public void SuccessiveCallsToNewPacketReturnSameInstance()
        {
            m_outputStream.WriteStartSequence();
            PacketCesiumWriter packet1 = m_writer.OpenPacket(m_outputStream);
            packet1.Close();
            PacketCesiumWriter packet2 = m_writer.OpenPacket(m_outputStream);
            packet2.Close();
            m_outputStream.WriteEndSequence();
            Assert.AreSame(packet1, packet2);
        }

        [Test]
        [ExpectedException(typeof(InvalidOperationException), ExpectedMessage = "already opened", MatchType = MessageMatch.Contains)]
        public void MultipleCallsToNewPacketWithoutCloseThrowInvalidOperationException()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream);
            packet = m_writer.OpenPacket(m_outputStream);
        }

        private StringWriter m_stringWriter;
        private CesiumOutputStream m_outputStream;
        private CesiumStreamWriter m_writer;
    }
}