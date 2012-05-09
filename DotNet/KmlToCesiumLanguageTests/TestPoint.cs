using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using KmlToCesiumLanguage;
using System.Xml.Linq;

namespace KmlToCesiumLanguageTests
{
    [TestFixture]
    public class TestPoint
    {
        [Test]
        public void BasicPoint()
        {
            CzmlDocument document = new CzmlDocument();
            XDocument kml = XDocument.Load(@"C:\dev\Astrolib\Slide18\Development\Babbage\WebResources\DoNotPublish\KML\STS-122-STS-122Ascent.kml");
            KmlConverter.ConvertToCZML(kml, document);
            Console.WriteLine(document.StringWriter.ToString());
        }
    }
}
