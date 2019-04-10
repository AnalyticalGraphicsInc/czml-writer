using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBooleanCesiumWriter : TestCesiumPropertyWriter<BooleanCesiumWriter>
    {
        [Test]
        public void BooleanCanBeWrittenAsSimpleBoolean()
        {
            using (Packet)
            using (BooleanCesiumWriter writer = new BooleanCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteBoolean(false);
            }

            Assert.AreEqual("{\"foo\":false}", StringWriter.ToString());
        }

        [Test]
        public void BooleanCanBeWrittenInsideInterval()
        {
            JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (BooleanCesiumWriter writer = new BooleanCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(startDate, startDate.AddSeconds(100.0));
                writer.WriteBoolean(false);
            }

            Assert.AreEqual("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"boolean\":false}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<BooleanCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BooleanCesiumWriter(propertyName);
        }
    }
}