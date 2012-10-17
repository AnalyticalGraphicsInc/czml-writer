using System.Collections.Generic;
using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumPacketWriter
    {
        private StringWriter m_sw;
        private CesiumOutputStream m_output;
        private CesiumStreamWriter m_writer;

        [SetUp]
        public void SetUp()
        {
            m_sw = new StringWriter();
            m_output = new CesiumOutputStream(m_sw);
            m_writer = new CesiumStreamWriter();
        }

        [Test]
        public void OpensObjectLiteralOnOpenAndClosesItOnClose()
        {
            PacketCesiumWriter packet = new PacketCesiumWriter();
            packet.Open(m_output);
            Assert.AreEqual("{", m_sw.ToString());
            packet.Close();
            Assert.AreEqual("{}", m_sw.ToString());
        }

        [Test]
        public void DisposeClosesPacket()
        {
            using (PacketCesiumWriter packet = m_writer.OpenPacket(m_output))
            {
            }
            Assert.AreEqual("{}", m_sw.ToString());
        }

        [Test]
        public void IdValueWritesIdProperty()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_output);
            packet.WriteId("foo");
            packet.Close();
            Assert.AreEqual("{\"id\":\"foo\"}", m_sw.ToString());
        }

        [Test]
        public void AvailabilityValueWritesAvailabilityProperty()
        {
            JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 1, 2, 3));
            JulianDate stop = new JulianDate(new GregorianDate(2012, 4, 3, 1, 2, 3));

            m_output.WriteStartSequence();
            using (PacketCesiumWriter packet = m_writer.OpenPacket(m_output))
            {
                packet.WriteAvailability(start, stop);
            }
            using (PacketCesiumWriter packet = m_writer.OpenPacket(m_output))
            {
                packet.WriteAvailability(new TimeInterval(start, stop));
            }
            using (PacketCesiumWriter packet = m_writer.OpenPacket(m_output))
            {
                var intervals = new List<TimeInterval>();
                intervals.Add(new TimeInterval(start, stop));
                intervals.Add(new TimeInterval(start.AddDays(2.0), stop.AddDays(2.0)));
                packet.WriteAvailability(intervals);
            }
            m_output.WriteEndSequence();

            Assert.AreEqual("[{\"availability\":\"20120402T010203Z/20120403T010203Z\"}," +
                             "{\"availability\":\"20120402T010203Z/20120403T010203Z\"}," +
                             "{\"availability\":[\"20120402T010203Z/20120403T010203Z\",\"20120404T010203Z/20120405T010203Z\"]}]",
                            m_sw.ToString());
        }

        [Test]
        public void PositionWritesPositionProperty()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_output);
            PositionCesiumWriter position = packet.OpenPositionProperty();
            Assert.IsNotNull(position);
            Assert.AreEqual("{\"position\":", m_sw.ToString());
        }

        [Test]
        public void BillboardWritesBillboardProperty()
        {
            PacketCesiumWriter packet = m_writer.OpenPacket(m_output);
            using (BillboardCesiumWriter billboard = packet.OpenBillboardProperty())
            {
                Assert.IsNotNull(billboard);
            }
            Assert.AreEqual("{\"billboard\":", m_sw.ToString());
        }
    }
}
