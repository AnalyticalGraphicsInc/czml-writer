using CesiumLanguageWriter;
using CesiumLanguageWriterTests.Data;
using NUnit.Framework;
using System.Drawing;
using System.IO;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumResource
    {
        [Test]
        public void TestFromImage()
        {
            var image = new Bitmap(EmbeddedData.Read("satellite.png"));

            var resource = CesiumResource.FromImage(image, CesiumImageFormat.Png);
            Assert.IsNotNull(resource);

            StringAssert.StartsWith("data:image/png;base64,", resource.Uri);
        }

        [Test]
        public void TestFromImageFormats([Values] CesiumImageFormat format)
        {
            var image = new Bitmap(EmbeddedData.Read("satellite.bmp"));

            var resource = CesiumResource.FromImage(image, format);
            Assert.IsNotNull(resource);

            StringAssert.StartsWith("data:", resource.Uri);
            StringAssert.Contains(";base64,", resource.Uri);
        }

        [Test]
        public void TestFromStream()
        {
            // arbitrary bytes
            byte[] contents = { 0, 1, 2, 3, 4 };
            var stream = new MemoryStream(contents);

            var resource = CesiumResource.FromStream(stream, CesiumImageFormat.Png);

            Assert.IsNotNull(resource);

            const string expected = "data:image/png;base64,AAECAwQ=";
            Assert.AreEqual(expected, resource.Uri);
        }

        [Test]
        public void TestFromStreamMimeType()
        {
            // arbitrary bytes
            byte[] contents = { 0, 1, 2, 3, 4 };
            var stream = new MemoryStream(contents);

            var resource = CesiumResource.FromStream(stream, "application/octet-stream");

            Assert.IsNotNull(resource);

            const string expected = "data:application/octet-stream;base64,AAECAwQ=";
            Assert.AreEqual(expected, resource.Uri);
        }
    }
}