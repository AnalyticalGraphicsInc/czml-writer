using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestLabelStyleCesiumWriter : TestCesiumPropertyWriter<LabelStyleCesiumWriter>
    {
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

        protected override CesiumPropertyWriter<LabelStyleCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new LabelStyleCesiumWriter(propertyName);
        }
    }
}