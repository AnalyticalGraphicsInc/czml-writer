using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumResource
    {
        [Test]
        public void TestFromImage()
        {
            var image = new Bitmap(5, 5);
            var resource = CesiumResource.FromImage(image, CesiumImageFormat.Png);

            Assert.IsNotNull(resource);

            StringAssert.StartsWith("data:image/png;base64,", resource.Uri);
        }

        [Test]
        [TestCaseSource("ImageFormatValues")]
        public void TestFromImageFormats(CesiumImageFormat format)
        {
            var image = new Bitmap(5, 5);
            var resource = CesiumResource.FromImage(image, format);

            Assert.IsNotNull(resource);

            StringAssert.StartsWith("data:", resource.Uri);
            StringAssert.Contains(";base64,", resource.Uri);
        }

        public IEnumerable<CesiumImageFormat> ImageFormatValues
        {
            get { return (CesiumImageFormat[])Enum.GetValues(typeof(CesiumImageFormat)); }
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