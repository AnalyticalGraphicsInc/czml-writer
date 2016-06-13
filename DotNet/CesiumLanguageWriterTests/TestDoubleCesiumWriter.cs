using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestDoubleCesiumWriter : TestCesiumPropertyWriter<DoubleCesiumWriter>
    {
        [Test]
        public void DoubleCanBeWrittenAsSimpleNumber()
        {
            using (Packet)
            using (DoubleCesiumWriter writer = new DoubleCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteNumber(1.23);
            }
            Assert.AreEqual("{\"foo\":1.23}", StringWriter.ToString());
        }

        [Test]
        public void DoubleCanBeWrittenInsideInterval()
        {
            JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (DoubleCesiumWriter writer = new DoubleCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(startDate, startDate.AddSeconds(100.0));
                writer.WriteNumber(1.23);
            }
            Assert.AreEqual("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"number\":1.23}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<DoubleCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new DoubleCesiumWriter(propertyName);
        }
    }
}