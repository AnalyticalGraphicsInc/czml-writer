using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumIntervalListWriter
    {
        private StringWriter m_stringWriter;
        private CesiumOutputStream m_outputStream;
        private CesiumStreamWriter m_streamWriter;

        [SetUp]
        public void SetUp()
        {
            m_stringWriter = new StringWriter();
            m_outputStream = new CesiumOutputStream(m_stringWriter);
            m_streamWriter = new CesiumStreamWriter();
        }

        [TearDown]
        public void TearDown()
        {
            m_stringWriter.Dispose();
        }

        [Test]
        public void OpenAndCloseIntervalListWritesArrayDelimiters()
        {
            using (m_streamWriter.OpenPacket(m_outputStream))
            using (var propertyWriter = new CustomCesiumWriter("test"))
            {
                propertyWriter.Open(m_outputStream);
                using (var intervalListWriter = new CesiumIntervalListWriter<CustomCesiumWriter>(propertyWriter))
                {
                    intervalListWriter.Open(m_outputStream);
                }
            }

            Assert.AreEqual("{\"test\":[]}", m_stringWriter.ToString());
        }

        [Test]
        public void DelegatesIntervalOpeningToPropertyWriter()
        {
            JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            JulianDate stop = new GregorianDate(2012, 4, 2, 13, 0, 0).ToJulianDate();

            using (m_streamWriter.OpenPacket(m_outputStream))
            using (var propertyWriter = new CustomCesiumWriter("test"))
            {
                propertyWriter.Open(m_outputStream);
                using (var intervalListWriter = new CesiumIntervalListWriter<CustomCesiumWriter>(propertyWriter))
                {
                    intervalListWriter.Open(m_outputStream);
                    using (intervalListWriter.OpenInterval(start, stop))
                    {
                    }
                }
            }

            Assert.AreEqual("{\"test\":[{\"interval\":\"20120402T12Z/20120402T13Z\"}]}", m_stringWriter.ToString());
        }

        [Test]
        public void IntervalListWritesMultipleIntervals()
        {
            JulianDate firstStart = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            JulianDate firstStop = new GregorianDate(2012, 4, 2, 13, 0, 0).ToJulianDate();
            JulianDate secondStart = new GregorianDate(2012, 4, 2, 13, 0, 0).ToJulianDate();
            JulianDate secondStop = new GregorianDate(2012, 4, 2, 14, 0, 0).ToJulianDate();

            using (m_streamWriter.OpenPacket(m_outputStream))
            using (var propertyWriter = new CustomCesiumWriter("test"))
            {
                propertyWriter.Open(m_outputStream);
                using (var intervalListWriter = new CesiumIntervalListWriter<CustomCesiumWriter>(propertyWriter))
                {
                    intervalListWriter.Open(m_outputStream);

                    using (var firstInterval = intervalListWriter.OpenInterval(firstStart, firstStop))
                    {
                        using (var valueWriter = new DoubleCesiumWriter("value"))
                        {
                            valueWriter.Open(firstInterval.Output);
                            valueWriter.WriteNumber(1.0);
                        }
                    }

                    using (var secondInterval = intervalListWriter.OpenInterval(secondStart, secondStop))
                    {
                        using (var valueWriter = new DoubleCesiumWriter("value"))
                        {
                            valueWriter.Open(secondInterval.Output);
                            valueWriter.WriteNumber(2.0);
                        }
                    }
                }
            }

            const string expected =
                "{\"test\":[" +
                "{\"interval\":\"20120402T12Z/20120402T13Z\",\"value\":1}," +
                "{\"interval\":\"20120402T13Z/20120402T14Z\",\"value\":2}" +
                "]}";

            Assert.AreEqual(expected, m_stringWriter.ToString());
        }
    }
}
