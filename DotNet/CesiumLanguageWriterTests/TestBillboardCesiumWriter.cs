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
            const bool expectedShow = true;

            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.ShowPropertyName, expectedShow },
            });
        }

        [Test]
        public void TestShowPropertyInterval()
        {
            var startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            var stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0).ToJulianDate();

            var interval1Start = startDate;
            var interval1Stop = startDate.AddSeconds(1);
            var interval2Start = interval1Stop;
            var interval2Stop = startDate.AddSeconds(2);
            var interval3Start = interval2Stop;
            var interval3Stop = stopDate;

            const bool interval1Value = true;
            const bool interval2Value = false;
            const bool interval3Value = true;

            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var show = billboard.OpenShowProperty())
            using (var showIntervals = show.OpenMultipleIntervals())
            {
                using (var interval = showIntervals.OpenInterval(interval1Start, interval1Stop))
                {
                    interval.WriteBoolean(interval1Value);
                }

                using (var interval = showIntervals.OpenInterval(interval2Start, interval2Stop))
                {
                    interval.WriteBoolean(interval2Value);
                }

                using (var interval = showIntervals.OpenInterval(interval3Start, interval3Stop))
                {
                    interval.WriteBoolean(interval3Value);
                }
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                {
                    BillboardCesiumWriter.ShowPropertyName, new List<Dictionary<string, object>>
                    {
                        new Dictionary<string, object>
                        {
                            { "interval", CesiumFormattingHelper.ToIso8601Interval(interval1Start, interval1Stop, Iso8601Format.Compact) },
                            { BooleanCesiumWriter.BooleanPropertyName, interval1Value },
                        },
                        new Dictionary<string, object>
                        {
                            { "interval", CesiumFormattingHelper.ToIso8601Interval(interval2Start, interval2Stop, Iso8601Format.Compact) },
                            { BooleanCesiumWriter.BooleanPropertyName, interval2Value },
                        },
                        new Dictionary<string, object>
                        {
                            { "interval", CesiumFormattingHelper.ToIso8601Interval(interval3Start, interval3Stop, Iso8601Format.Compact) },
                            { BooleanCesiumWriter.BooleanPropertyName, interval3Value },
                        },
                    }
                },
            });
        }

        [Test]
        public void TestScaleByDistanceProperty()
        {
            var expectedScaleByDistance = new NearFarScalar(100.5, 1.5, 200.5, 2.5);

            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteScaleByDistanceProperty(expectedScaleByDistance);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.ScaleByDistancePropertyName, expectedScaleByDistance },
            });
        }

        [Test]
        public void TestScaleByDistancePropertySamples()
        {
            var epoch = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (var billboard = Packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            using (var scaleByDistance = interval.OpenScaleByDistanceProperty())
            {
                var dates = new List<JulianDate>();
                var values = new List<NearFarScalar>();

                dates.Add(epoch);
                values.Add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));

                dates.Add(epoch.AddSeconds(60.0));
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

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                {
                    BillboardCesiumWriter.AlignedAxisPropertyName, new Dictionary<string, object>
                    {
                        { "delete", true },
                    }
                },
            });
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

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                {
                    BillboardCesiumWriter.ScalePropertyName, new Dictionary<string, object>
                    {
                        { "delete", true },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<BillboardCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BillboardCesiumWriter(propertyName);
        }
    }
}