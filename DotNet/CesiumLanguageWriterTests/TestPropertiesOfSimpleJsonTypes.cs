using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPropertiesOfSimpleJsonTypes : TestCesiumPropertyWriter<BillboardCesiumWriter>
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

        [Test]
        public void LabelStyleCanBeWrittenAsSimpleString()
        {
            using (Packet)
            using (LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteLabelStyle(CesiumLabelStyle.FillAndOutline);
            }
            Assert.AreEqual("{\"foo\":\"FILL_AND_OUTLINE\"}", StringWriter.ToString());
        }

        [Test]
        public void LabelStyleCanBeWrittenInsideInterval()
        {
            JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(startDate, startDate.AddSeconds(100.0));
                writer.WriteLabelStyle(CesiumLabelStyle.FillAndOutline);
            }
            Assert.AreEqual("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"labelStyle\":\"FILL_AND_OUTLINE\"}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<BillboardCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BillboardCesiumWriter(propertyName);
        }
    }
}