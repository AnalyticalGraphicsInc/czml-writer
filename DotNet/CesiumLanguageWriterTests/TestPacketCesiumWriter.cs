using System.Collections.Generic;
using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPacketCesiumWriter
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

        [Test]
        public void OpensObjectLiteralOnOpenAndClosesItOnClose()
        {
            PacketCesiumWriter packet = new PacketCesiumWriter();
            packet.Open(m_outputStream);
            Assert.AreEqual("{", m_stringWriter.ToString());
            packet.Close();
            Assert.AreEqual("{}", m_stringWriter.ToString());
        }

        [Test]
        public void DisposeClosesPacket()
        {
            using (m_writer.OpenPacket(m_outputStream))
            {
            }

            Assert.AreEqual("{}", m_stringWriter.ToString());
        }

        [Test]
        public void TestIdProperty()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream);
            packet.WriteId("foo");
            packet.Close();
            Assert.AreEqual("{\"id\":\"foo\"}", m_stringWriter.ToString());
        }

        [Test]
        public void TestDeleteProperty()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream);
            packet.WriteId("foo");
            packet.WriteDelete(true);
            packet.Close();
            Assert.AreEqual("{\"id\":\"foo\",\"delete\":true}", m_stringWriter.ToString());
        }

        [Test]
        public void TestDescriptionProperty()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream);
            packet.WriteDescriptionProperty("blah");
            packet.Close();
            Assert.AreEqual("{\"description\":\"blah\"}", m_stringWriter.ToString());
        }

        [Test]
        public void TestAvailabilityProperty()
        {
            JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 1, 2, 3));
            JulianDate stop = new JulianDate(new GregorianDate(2012, 4, 3, 1, 2, 3));

            m_outputStream.WriteStartSequence();
            using (PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream))
            {
                packet.WriteAvailability(start, stop);
            }

            using (PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream))
            {
                packet.WriteAvailability(new TimeInterval(start, stop));
            }

            using (PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream))
            {
                var intervals = new List<TimeInterval>
                {
                    new TimeInterval(start, stop),
                    new TimeInterval(start.AddDays(2.0), stop.AddDays(2.0))
                };
                packet.WriteAvailability(intervals);
            }

            m_outputStream.WriteEndSequence();

            const string expected =
                "[" +
                "{\"availability\":\"20120402T010203Z/20120403T010203Z\"}," +
                "{\"availability\":\"20120402T010203Z/20120403T010203Z\"}," +
                "{\"availability\":[\"20120402T010203Z/20120403T010203Z\",\"20120404T010203Z/20120405T010203Z\"]}" +
                "]";
            Assert.AreEqual(expected, m_stringWriter.ToString());
        }

        [Test]
        public void TestPositionProperty()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream);
            PositionCesiumWriter position = packet.OpenPositionProperty();
            Assert.IsNotNull(position);
            Assert.AreEqual("{\"position\":", m_stringWriter.ToString());
        }

        [Test]
        public void TestBillboardProperty()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_outputStream);
            using (BillboardCesiumWriter billboard = packet.OpenBillboardProperty())
            {
                Assert.IsNotNull(billboard);
            }

            Assert.AreEqual("{\"billboard\":", m_stringWriter.ToString());
        }
    }
}