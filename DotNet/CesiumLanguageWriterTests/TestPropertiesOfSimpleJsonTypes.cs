using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPropertiesOfSimpleJsonTypes : TestCesiumPropertyWriter<BillboardCesiumWriter>
    {
        protected override CesiumPropertyWriter<BillboardCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BillboardCesiumWriter(propertyName);
        }

        [Test]
        public void StringWrittenAsSimpleString()
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
        public void DoubleWrittenAsSimpleNumber()
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
        public void BooleanWrittenAsSimpleBoolean()
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
        public void VerticalOriginWrittenAsSimpleString()
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
        public void HorizontalOriginWrittenAsSimpleString()
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
        public void LabelStyleWrittenAsSimpleString()
        {
            using (Packet)
            using (LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteLabelStyle(CesiumLabelStyle.FillAndOutline);
            }
            Assert.AreEqual("{\"foo\":\"FILL_AND_OUTLINE\"}", StringWriter.ToString());
        }
    }
}
