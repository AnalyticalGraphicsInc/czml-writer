using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace CesiumLanguageWriterTests.Advanced
{
    [TestFixture]
    public class TestPropertyBagCesiumWriter
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
        public void CanWriteBasicProperties()
        {
            var packet = new PacketCesiumWriter();
            packet.Open(m_output);

            var propertyBag = new PropertyBagCesiumWriter("foo");
            propertyBag.Open(m_output);
            propertyBag.WriteBooleanProperty("myBool", true);
            propertyBag.WriteDoubleProperty("myDouble", 1.23);
            propertyBag.WriteStringProperty("myString", "howdy");
            propertyBag.Close();

            packet.Close();

            Assert.AreEqual("{\"foo\":{\"myBool\":true,\"myDouble\":1.23,\"myString\":\"howdy\"}}", m_sw.ToString());
        }

        [Test]
        public void CanWriteSubPropertyBags()
        {
            var packet = new PacketCesiumWriter();
            packet.Open(m_output);

            var propertyBag = new PropertyBagCesiumWriter("foo");
            propertyBag.Open(m_output);

            using (PropertyBagCesiumWriter subProperty = propertyBag.OpenPropertyBagProperty("sub"))
            {
                subProperty.WriteDoubleProperty("myDouble", 1.23);
            }

            propertyBag.Close();

            packet.Close();

            Assert.AreEqual("{\"foo\":{\"sub\":{\"myDouble\":1.23}}}", m_sw.ToString());
        }

        [Test]
        public void CanWriteSampledNumbers()
        {
            var packet = new PacketCesiumWriter();
            packet.Open(m_output);

            var propertyBag = new PropertyBagCesiumWriter("foo");
            propertyBag.Open(m_output);

            using (DoubleCesiumWriter writer = propertyBag.OpenDoubleProperty("bar"))
            {
                writer.WriteNumber(
                    new[]
                    {
                        new JulianDate(2451545.0),
                        new JulianDate(2451546.0)
                    },
                    new[]
                    {
                        1.0,
                        2.0
                    }, 0, 2);
            }

            propertyBag.Close();

            packet.Close();

            Assert.AreEqual("{\"foo\":{\"bar\":{\"epoch\":\"20000101T115928Z\",\"number\":[0,1,86400,2]}}}", m_sw.ToString());
        }

        [Test]
        public void CanWriteMultipleIntervals()
        {
            var packet = new PacketCesiumWriter();
            packet.Open(m_output);

            var propertyBag = new PropertyBagCesiumWriter("foo");
            propertyBag.Open(m_output);

            using (var intervals = propertyBag.OpenMultipleIntervals())
            {
                using (var interval = intervals.OpenInterval(new JulianDate(2451545.0), new JulianDate(2451546.0)))
                {
                    interval.WriteDoubleProperty("first", 1.0);
                }

                using (var interval = intervals.OpenInterval(new JulianDate(2451546.0), new JulianDate(2451547.0)))
                {
                    interval.WriteDoubleProperty("second", 2.0);
                }
            }

            propertyBag.Close();

            packet.Close();

            Assert.AreEqual("{\"foo\":[{\"interval\":\"20000101T115928Z/20000102T115928Z\",\"first\":1},{\"interval\":\"20000102T115928Z/20000103T115928Z\",\"second\":2}]}", m_sw.ToString());
        }
    }
}
