using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestStringCesiumWriter : TestCesiumPropertyWriter<StringCesiumWriter>
    {
        [Test]
        public void StringCanBeWrittenAsSimpleString()
        {
            using (Packet)
            using (var writer = new StringCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteString("bar");
            }

            Assert.AreEqual("{\"foo\":\"bar\"}", StringWriter.ToString());
        }

        [Test]
        public void StringCanBeWrittenInsideInterval()
        {
            var startDate = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (var writer = new StringCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(startDate, startDate.AddSeconds(100.0));
                writer.WriteString("bar");
            }

            Assert.AreEqual("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"string\":\"bar\"}}", StringWriter.ToString());
        }

        [Test]
        public void TestDeletePropertyWithStartAndStop()
        {
            var start = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));
            var stop = start.AddDays(1.0);

            using (Packet)
            {
                Packet.WriteId("id");

                using (var writer = new StringCesiumWriter("foo"))
                {
                    writer.Open(OutputStream);
                    writer.WriteInterval(start, stop);
                    writer.WriteDelete(true);
                }
            }

            Assert.AreEqual("{\"id\":\"id\",\"foo\":{\"interval\":\"20120402T12Z/20120403T12Z\",\"delete\":true}}", StringWriter.ToString());
        }

        [Test]
        public void TestDeletePropertyWithNoInterval()
        {
            using (Packet)
            {
                Packet.WriteId("id");

                using (var writer = new StringCesiumWriter("foo"))
                {
                    writer.Open(OutputStream);
                    writer.WriteDelete(true);
                }
            }

            Assert.AreEqual("{\"id\":\"id\",\"foo\":{\"delete\":true}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<StringCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new StringCesiumWriter(propertyName);
        }
    }
}