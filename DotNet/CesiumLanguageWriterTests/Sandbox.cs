using System;
using System.Drawing;
using System.IO;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class Sandbox
    {
        [Test]
        public void RunExample()
        {
            var stringWriter = new StringWriter();
            var output = new CesiumOutputStream(stringWriter)
            {
                PrettyFormatting = true
            };

            var stream = new CesiumStreamWriter();
            using (var packet = stream.OpenPacket(output))
            {
                packet.WriteId("Test");

                using (var billboard = packet.OpenBillboardProperty())
                {
                    billboard.WriteColorProperty(123, 67, 0, 255);
                    billboard.WriteImageProperty(new Uri("http://cesiumjs.org/images/CesiumHeaderLogo.png"), CesiumResourceBehavior.LinkTo);
                }

                using (var position = packet.OpenPositionProperty())
                {
                    position.WriteCartographicDegrees(new Cartographic(-75.0, 45.0, 100.0));
                }

                using (var model = packet.OpenModelProperty())
                using (var color = model.OpenColorProperty())
                using (var intervals = color.OpenMultipleIntervals())
                {
                    var start = new GregorianDate(2012, 8, 4, 16, 0, 0).ToJulianDate();
                    var stop = new GregorianDate(2012, 8, 4, 16, 1, 0).ToJulianDate();

                    using (var interval = intervals.OpenInterval(start, stop))
                    {
                        interval.WriteRgbaf(Color.Red);
                    }

                    start = new GregorianDate(2012, 8, 4, 16, 1, 0).ToJulianDate();
                    stop = new GregorianDate(2012, 8, 4, 16, 2, 0).ToJulianDate();
                    using (var interval = intervals.OpenInterval(start, stop))
                    {
                        interval.WriteRgbaf(Color.Lime);
                    }
                }
            }

            Console.WriteLine(stringWriter.ToString());
        }
    }
}