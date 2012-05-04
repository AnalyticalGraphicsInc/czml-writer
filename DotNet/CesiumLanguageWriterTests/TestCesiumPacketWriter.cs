using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
#if StkComponents
using AGI.Foundation;
using AGI.Foundation.Cesium;
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Coordinates;
using AGI.Foundation.Time;
using AGI.Test;
#else
using CesiumLanguageWriter;
#endif
using NUnit.Framework;

#if StkComponents
namespace Cesium.Tests.Cesium
#else
namespace CesiumLanguageWriterTests
#endif
{
    [TestFixture]
    public class TestCesiumPacketWriter
#if StkComponents
        : ComponentsTestBase
#endif
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
            CesiumPacketWriter packet = new CesiumPacketWriter();
            packet.Open(m_output);
            Assert.AreEqual("{", m_sw.ToString());
            packet.Close();
            Assert.AreEqual("{}", m_sw.ToString());
        }

        [Test]
        public void DisposeClosesPacket()
        {
            using (CesiumPacketWriter packet = m_writer.OpenPacket(m_output))
            {
            }
            Assert.AreEqual("{}", m_sw.ToString());
        }

        [Test]
        public void IdValueWritesIdProperty()
        {
            CesiumPacketWriter packet = m_writer.OpenPacket(m_output);
            packet.WriteIdentifier("foo");
            packet.Close();
            Assert.AreEqual("{\"id\":\"foo\"}", m_sw.ToString());
        }

        [Test]
        public void AvailabilityValueWritesAvailabilityProperty()
        {
            JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 1, 2, 3));
            JulianDate stop = new JulianDate(new GregorianDate(2012, 4, 3, 1, 2, 3));

            m_output.WriteStartSequence();
            using (CesiumPacketWriter packet = m_writer.OpenPacket(m_output))
            {
                packet.WriteAvailability(start, stop);
            }
            using (CesiumPacketWriter packet = m_writer.OpenPacket(m_output))
            {
                packet.WriteAvailability(new TimeInterval(start, stop));
            }
            using (CesiumPacketWriter packet = m_writer.OpenPacket(m_output))
            {
                var intervals = new List<TimeInterval>();
                intervals.Add(new TimeInterval(start, stop));
                intervals.Add(new TimeInterval(start.AddDays(2.0), stop.AddDays(2.0)));
                packet.WriteAvailability(intervals);
            }
            m_output.WriteEndSequence();

            Assert.AreEqual("[{\"availability\":\"2012-04-02T01:02:03Z/2012-04-03T01:02:03Z\"}," +
                             "{\"availability\":\"2012-04-02T01:02:03Z/2012-04-03T01:02:03Z\"}," +
                             "{\"availability\":[\"2012-04-02T01:02:03Z/2012-04-03T01:02:03Z\",\"2012-04-04T01:02:03Z/2012-04-05T01:02:03Z\"]}]",
                            m_sw.ToString());
        }

        [Test]
        public void PositionWritesPositionProperty()
        {
            CesiumPacketWriter packet = m_writer.OpenPacket(m_output);
            PositionCesiumWriter position = packet.OpenPositionProperty();
            Assert.IsNotNull(position);
            Assert.AreEqual("{\"position\":", m_sw.ToString());
        }

        [Test]
        public void BillboardWritesBillboardProperty()
        {
            CesiumPacketWriter packet = m_writer.OpenPacket(m_output);
            using (BillboardCesiumWriter billboard = packet.OpenBillboardProperty())
            {
                Assert.IsNotNull(billboard);
            }
            Assert.AreEqual("{\"billboard\":", m_sw.ToString());
        }
    }
}
