using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBillboardCesiumWriter : TestCesiumPropertyWriter<BillboardCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteShowProperty(true);
            }

            Assert.AreEqual("{\"billboard\":{\"show\":true}}", StringWriter.ToString());
        }

        [Test]
        public void TestShowPropertyInterval()
        {
            var startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));
            var stopDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 1, 0));

            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var show = billboard.OpenShowProperty())
            using (var showIntervals = show.OpenMultipleIntervals())
            {
                using (var interval = showIntervals.OpenInterval(startDate, startDate.AddSeconds(1)))
                {
                    interval.WriteBoolean(true);
                }

                using (var interval = showIntervals.OpenInterval(startDate.AddSeconds(1), startDate.AddSeconds(2)))
                {
                    interval.WriteBoolean(false);
                }

                using (var interval = showIntervals.OpenInterval(startDate.AddSeconds(2), stopDate))
                {
                    interval.WriteBoolean(true);
                }
            }

            string interval1String = CesiumFormattingHelper.ToIso8601Interval(startDate, startDate.AddSeconds(1), Iso8601Format.Compact);
            string interval2String = CesiumFormattingHelper.ToIso8601Interval(startDate.AddSeconds(1), startDate.AddSeconds(2), Iso8601Format.Compact);
            string interval3String = CesiumFormattingHelper.ToIso8601Interval(startDate.AddSeconds(2), stopDate, Iso8601Format.Compact);

            Assert.AreEqual("{\"billboard\":{\"show\":[{\"interval\":\"" + interval1String + "\",\"boolean\":true}," +
                            "{\"interval\":\"" + interval2String + "\",\"boolean\":false}," +
                            "{\"interval\":\"" + interval3String + "\",\"boolean\":true}" +
                            "]}}", StringWriter.ToString());
        }

        [Test]
        public void TestScaleByDistanceProperty()
        {
            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteScaleByDistanceProperty(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
            }

            Assert.AreEqual("{\"billboard\":{\"scaleByDistance\":{\"nearFarScalar\":[100,1,200,2]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestScaleByDistancePropertySamples()
        {
            var startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            using (var scaleByDistance = interval.OpenScaleByDistanceProperty())
            {
                var dates = new List<JulianDate>();
                var values = new List<NearFarScalar>();

                dates.Add(startDate);
                values.Add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));

                dates.Add(startDate.AddSeconds(60.0));
                values.Add(new NearFarScalar(200.0, 1.0, 300.0, 2.0));

                scaleByDistance.WriteNearFarScalar(dates, values);
            }

            Assert.AreEqual("{\"billboard\":{\"scaleByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestDeleteAlignedAxis()
        {
            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var alignedAxis = billboard.OpenAlignedAxisProperty())
            {
                alignedAxis.WriteDelete(true);
            }

            Assert.AreEqual("{\"billboard\":{\"alignedAxis\":{\"delete\":true}}}", StringWriter.ToString());
        }

        [Test]
        public void TestDeleteScale()
        {
            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var scale = billboard.OpenScaleProperty())
            {
                scale.WriteDelete(true);
            }

            Assert.AreEqual("{\"billboard\":{\"scale\":{\"delete\":true}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<BillboardCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BillboardCesiumWriter(propertyName);
        }
    }
}