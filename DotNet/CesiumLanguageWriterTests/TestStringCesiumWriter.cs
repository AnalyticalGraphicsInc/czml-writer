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
            using (StringCesiumWriter writer = new StringCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteString("bar");
            }
            Assert.AreEqual("{\"foo\":\"bar\"}", StringWriter.ToString());
        }

        [Test]
        public void StringCanBeWrittenInsideInterval()
        {
            JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (StringCesiumWriter writer = new StringCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(startDate, startDate.AddSeconds(100.0));
                writer.WriteString("bar");
            }
            Assert.AreEqual("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"string\":\"bar\"}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<StringCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new StringCesiumWriter(propertyName);
        }
    }
}