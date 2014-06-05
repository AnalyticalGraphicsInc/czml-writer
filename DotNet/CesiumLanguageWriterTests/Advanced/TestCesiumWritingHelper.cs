using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests.Advanced
{
    [TestFixture]
    public class TestCesiumWritingHelper
    {
        public StringWriter StringWriter { get; private set; }

        public CesiumOutputStream OutputStream { get; private set; }

        [SetUp]
        public void SetUp()
        {
            StringWriter = new StringWriter();
            OutputStream = new CesiumOutputStream(StringWriter);
        }

        [Test]
        public void CanWriteReference()
        {
            CesiumWritingHelper.WriteReference(OutputStream, new Reference("bar", "color"));
            Assert.AreEqual("\"bar#color\"", StringWriter.ToString());
        }

        [Test]
        public void CanWriteReferences()
        {
            CesiumWritingHelper.WriteReferences(OutputStream, new[] { new Reference("bar", "color"), new Reference("foo", "color2") });
            Assert.AreEqual("[\"bar#color\",\"foo#color2\"]", StringWriter.ToString());
        }
    }
}
