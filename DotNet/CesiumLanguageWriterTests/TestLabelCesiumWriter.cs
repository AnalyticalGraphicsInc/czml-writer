using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestLabelCesiumWriter : TestCesiumPropertyWriter<LabelCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestFont()
        {
            const string expected = "30px Helvetica";

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteFontProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.FontPropertyName, expected);
        }

        [Test]
        public void TestStyle()
        {
            const CesiumLabelStyle expected = CesiumLabelStyle.FillAndOutline;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteStyleProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.StylePropertyName, expected);
        }

        [Test]
        public void TestScale()
        {
            const double expected = 2.0;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteScaleProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.ScalePropertyName, expected);
        }

        [Test]
        public void TestPixelOffset()
        {
            var expected = new Rectangular(12.5, 3.5);

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WritePixelOffsetProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.PixelOffsetPropertyName, expected);
        }

        [Test]
        public void TestEyeOffset()
        {
            var expected = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteEyeOffsetProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.EyeOffsetPropertyName, expected);
        }

        [Test]
        public void TestHorizontalOrigin()
        {
            const CesiumHorizontalOrigin expected = CesiumHorizontalOrigin.Center;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteHorizontalOriginProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.HorizontalOriginPropertyName, expected);
        }

        [Test]
        public void TestVerticalOrigin()
        {
            const CesiumVerticalOrigin expected = CesiumVerticalOrigin.Center;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteVerticalOriginProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.VerticalOriginPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestFillColor()
        {
            var expected = Color.Blue;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteFillColorProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.FillColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.Green;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.0;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestPixelOffsetScaleByDistance()
        {
            var expected = new NearFarScalar(10.0, 1.0, 20.0, 2.0);

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WritePixelOffsetScaleByDistanceProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.PixelOffsetScaleByDistancePropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(10.0, 20.0);

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestDisableDepthTestDistance()
        {
            const double expected = 1234.0;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteDisableDepthTestDistanceProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.DisableDepthTestDistancePropertyName, expected);
        }

        [Test]
        public void TestScaleByDistance()
        {
            var expected = new NearFarScalar(100.5, 1.5, 200.5, 2.5);

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteScaleByDistanceProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.ScaleByDistancePropertyName, expected);
        }

        [Test]
        public void TestText()
        {
            const string expected = "asdf";

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteTextProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.TextPropertyName, expected);
        }

        [Test]
        public void TestTextInterval()
        {
            var startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            var stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0).ToJulianDate();

            var interval1Start = startDate;
            var interval1Stop = startDate.AddSeconds(1);
            var interval2Start = interval1Stop;
            var interval2Stop = startDate.AddSeconds(2);
            var interval3Start = interval2Stop;
            var interval3Stop = stopDate;

            const string interval1Value = "A";
            const string interval2Value = "B";
            const string interval3Value = "C";

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var text = label.OpenTextProperty())
            using (var textIntervals = text.OpenMultipleIntervals())
            {
                using (var interval = textIntervals.OpenInterval(interval1Start, interval1Stop))
                {
                    interval.WriteString(interval1Value);
                }

                using (var interval = textIntervals.OpenInterval(interval2Start, interval2Stop))
                {
                    interval.WriteString(interval2Value);
                }

                using (var interval = textIntervals.OpenInterval(interval3Start, interval3Stop))
                {
                    interval.WriteString(interval3Value);
                }
            }

            AssertPropertyJson(LabelCesiumWriter.TextPropertyName, new List<Dictionary<string, object>>
            {
                new Dictionary<string, object>
                {
                    { "interval", CesiumFormattingHelper.ToIso8601Interval(interval1Start, interval1Stop, Iso8601Format.Compact) },
                    { StringCesiumWriter.StringPropertyName, interval1Value },
                },
                new Dictionary<string, object>
                {
                    { "interval", CesiumFormattingHelper.ToIso8601Interval(interval2Start, interval2Stop, Iso8601Format.Compact) },
                    { StringCesiumWriter.StringPropertyName, interval2Value },
                },
                new Dictionary<string, object>
                {
                    { "interval", CesiumFormattingHelper.ToIso8601Interval(interval3Start, interval3Stop, Iso8601Format.Compact) },
                    { StringCesiumWriter.StringPropertyName, interval3Value },
                },
            });
        }

        [Test]
        public void TestShowBackground()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteShowBackgroundProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.ShowBackgroundPropertyName, expected);
        }

        [Test]
        public void TestBackgroundColor()
        {
            var expected = Color.Red;

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteBackgroundColorProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.BackgroundColorPropertyName, expected);
        }

        [Test]
        public void TestBackgroundPadding()
        {
            var expected = new Rectangular(3, 4);

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteBackgroundPaddingProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.BackgroundPaddingPropertyName, expected);
        }

        [Test]
        public void TestTranslucencyByDistance()
        {
            var expected = new NearFarScalar(100.0, 1.0, 200.0, 2.0);

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteTranslucencyByDistanceProperty(expected);
            }

            AssertPropertyJson(LabelCesiumWriter.TranslucencyByDistancePropertyName, expected);
        }

        [Test]
        public void TestTranslucencyByDistanceSamples()
        {
            var epoch = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (var packet = OpenPacket())
            using (var label = packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            using (var scaleByDistance = interval.OpenTranslucencyByDistanceProperty())
            {
                var dates = new List<JulianDate>();
                var values = new List<NearFarScalar>();

                dates.Add(epoch);
                values.Add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));

                dates.Add(epoch.AddSeconds(60.0));
                values.Add(new NearFarScalar(200.0, 1.0, 300.0, 2.0));

                scaleByDistance.WriteNearFarScalar(dates, values);
            }

            Assert.AreEqual("{\"label\":{\"translucencyByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", StringWriter.ToString());
        }

        private void AssertPropertyJson(string propertyName, object value)
        {
            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<LabelCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new LabelCesiumWriter(propertyName);
        }
    }
}
