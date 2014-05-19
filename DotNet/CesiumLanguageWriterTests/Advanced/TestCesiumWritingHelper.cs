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
            Assert.AreEqual("{\"id\":\"bar\",\"path\":\"color\"}", StringWriter.ToString());
        }
    }
}
