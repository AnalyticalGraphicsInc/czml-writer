using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestVerticalOriginCesiumWriter : TestCesiumPropertyWriter<VerticalOriginCesiumWriter>
    {
        [Test]
        public void VerticalOriginCanBeWrittenAsSimpleString()
        {
            using (Packet)
            using (VerticalOriginCesiumWriter writer = new VerticalOriginCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteVerticalOrigin(CesiumVerticalOrigin.Center);
            }
            Assert.AreEqual("{\"foo\":\"CENTER\"}", StringWriter.ToString());
        }

        [Test]
        public void VerticalOriginCanBeWrittenInsideInterval()
        {
            JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (VerticalOriginCesiumWriter writer = new VerticalOriginCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(startDate, startDate.AddSeconds(100.0));
                writer.WriteVerticalOrigin(CesiumVerticalOrigin.Center);
            }
            Assert.AreEqual("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"verticalOrigin\":\"CENTER\"}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<VerticalOriginCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new VerticalOriginCesiumWriter(propertyName);
        }
    }
}