using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestHorizontalOriginCesiumWriter : TestCesiumPropertyWriter<HorizontalOriginCesiumWriter>
    {
        [Test]
        public void HorizontalOriginCanBeWrittenAsSimpleString()
        {
            using (Packet)
            using (HorizontalOriginCesiumWriter writer = new HorizontalOriginCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteHorizontalOrigin(CesiumHorizontalOrigin.Center);
            }

            Assert.AreEqual("{\"foo\":\"CENTER\"}", StringWriter.ToString());
        }

        [Test]
        public void HorizontalOriginCanBeWrittenInsideInterval()
        {
            JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (HorizontalOriginCesiumWriter writer = new HorizontalOriginCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(startDate, startDate.AddSeconds(100.0));
                writer.WriteHorizontalOrigin(CesiumHorizontalOrigin.Center);
            }

            Assert.AreEqual("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"horizontalOrigin\":\"CENTER\"}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<HorizontalOriginCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new HorizontalOriginCesiumWriter(propertyName);
        }
    }
}