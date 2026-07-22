using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBillboardCesiumWriter : TestCesiumPropertyWriter<BillboardCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestShowInterval()
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

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
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

            AssertPropertyJson(BillboardCesiumWriter.ShowPropertyName, new List<Dictionary<string, object>>
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
            });
        }

        [Test]
        public void TestImage()
        {
            const string expected = "image.png";

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteImageProperty(expected, CesiumResourceBehavior.LinkTo);
            }

            AssertPropertyJson(BillboardCesiumWriter.ImagePropertyName, expected);
        }

        [Test]
        public void TestScale()
        {
            const double expected = 2.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteScaleProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.ScalePropertyName, expected);
        }

        [Test]
        public void TestPixelOffset()
        {
            var expected = new Rectangular(12.5, 3.5);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WritePixelOffsetProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.PixelOffsetPropertyName, expected);
        }

        [Test]
        public void TestEyeOffset()
        {
            var expected = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteEyeOffsetProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.EyeOffsetPropertyName, expected);
        }

        [Test]
        public void TestHorizontalOrigin()
        {
            const CesiumHorizontalOrigin expected = CesiumHorizontalOrigin.Center;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteHorizontalOriginProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.HorizontalOriginPropertyName, expected);
        }

        [Test]
        public void TestVerticalOrigin()
        {
            const CesiumVerticalOrigin expected = CesiumVerticalOrigin.Center;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteVerticalOriginProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.VerticalOriginPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestColor()
        {
            var expected = Color.FromArgb(0, 255, 0, 255);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteColorProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.ColorPropertyName, expected);
        }

        [Test]
        public void TestRotation()
        {
            const double expected = 1.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteRotationProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.RotationPropertyName, expected);
        }

        [Test]
        public void TestAlignedAxis()
        {
            var expected = UnitCartesian.UnitX;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteAlignedAxisProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.AlignedAxisPropertyName, expected);
        }

        [Test]
        public void TestSizeInMeters()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteSizeInMetersProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.SizeInMetersPropertyName, expected);
        }

        [Test]
        public void TestWidth()
        {
            const double expected = 12.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteWidthProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.WidthPropertyName, expected);
        }

        [Test]
        public void TestHeight()
        {
            const double expected = 34.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteHeightProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.HeightPropertyName, expected);
        }

        [Test]
        public void TestTranslucencyByDistance()
        {
            var expected = new NearFarScalar(100.0, 1.0, 200.0, 0.5);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteTranslucencyByDistanceProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.TranslucencyByDistancePropertyName, expected);
        }

        [Test]
        public void TestPixelOffsetScaleByDistance()
        {
            var expected = new NearFarScalar(10.0, 1.0, 20.0, 2.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WritePixelOffsetScaleByDistanceProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.PixelOffsetScaleByDistancePropertyName, expected);
        }

        [Test]
        public void TestImageSubRegion()
        {
            var expected = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteImageSubRegionProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.ImageSubRegionPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(10.0, 20.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestDisableDepthTestDistance()
        {
            const double expected = 1234.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteDisableDepthTestDistanceProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.DisableDepthTestDistancePropertyName, expected);
        }

        [Test]
        public void TestScaleByDistance()
        {
            var expected = new NearFarScalar(100.5, 1.5, 200.5, 2.5);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteScaleByDistanceProperty(expected);
            }

            AssertPropertyJson(BillboardCesiumWriter.ScaleByDistancePropertyName, expected);
        }

        [Test]
        public void TestScaleByDistanceSamples()
        {
            var epoch = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
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
            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var alignedAxis = billboard.OpenAlignedAxisProperty())
            {
                alignedAxis.WriteDelete(true);
            }

            AssertPropertyJson(BillboardCesiumWriter.AlignedAxisPropertyName, new Dictionary<string, object>
            {
                { "delete", true },
            });
        }

        [Test]
        public void TestDeleteScale()
        {
            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var scale = billboard.OpenScaleProperty())
            {
                scale.WriteDelete(true);
            }

            AssertPropertyJson(BillboardCesiumWriter.ScalePropertyName, new Dictionary<string, object>
            {
                { "delete", true },
            });
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<BillboardCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BillboardCesiumWriter(propertyName);
        }
    }
}
