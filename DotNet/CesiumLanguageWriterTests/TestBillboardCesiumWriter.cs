using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;
using System.Drawing;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBillboardCesiumWriter : TestCesiumPropertyWriter<BillboardCesiumWriter>
    {
        [Test]
        public void TestImageProperty()
        {
            const string expectedImage = "image.png";

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteImageProperty(expectedImage, CesiumResourceBehavior.LinkTo);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.ImagePropertyName, expectedImage },
            });
        }

        [Test]
        public void TestScaleProperty()
        {
            const double expectedScale = 2.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteScaleProperty(expectedScale);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.ScalePropertyName, expectedScale },
            });
        }

        [Test]
        public void TestPixelOffsetProperty()
        {
            var expectedPixelOffset = new Rectangular(12.5, 3.5);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WritePixelOffsetProperty(expectedPixelOffset);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.PixelOffsetPropertyName, expectedPixelOffset },
            });
        }

        [Test]
        public void TestEyeOffsetProperty()
        {
            var expectedEyeOffset = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteEyeOffsetProperty(expectedEyeOffset);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.EyeOffsetPropertyName, expectedEyeOffset },
            });
        }

        [Test]
        public void TestHorizontalOriginProperty()
        {
            const CesiumHorizontalOrigin expectedHorizontalOrigin = CesiumHorizontalOrigin.Center;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteHorizontalOriginProperty(expectedHorizontalOrigin);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.HorizontalOriginPropertyName, expectedHorizontalOrigin },
            });
        }

        [Test]
        public void TestVerticalOriginProperty()
        {
            const CesiumVerticalOrigin expectedVerticalOrigin = CesiumVerticalOrigin.Center;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteVerticalOriginProperty(expectedVerticalOrigin);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.VerticalOriginPropertyName, expectedVerticalOrigin },
            });
        }

        [Test]
        public void TestHeightReferenceProperty()
        {
            const CesiumHeightReference expectedHeightReference = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expectedHeightReference);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.HeightReferencePropertyName, expectedHeightReference },
            });
        }

        [Test]
        public void TestColorProperty()
        {
            var expectedColor = Color.FromArgb(0, 255, 0, 255);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteColorProperty(expectedColor);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.ColorPropertyName, expectedColor },
            });
        }

        [Test]
        public void TestRotationProperty()
        {
            const double expectedRotation = 1.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteRotationProperty(expectedRotation);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.RotationPropertyName, expectedRotation },
            });
        }

        [Test]
        public void TestAlignedAxisProperty()
        {
            var expectedAlignedAxis = UnitCartesian.UnitX;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteAlignedAxisProperty(expectedAlignedAxis);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.AlignedAxisPropertyName, expectedAlignedAxis },
            });
        }

        [Test]
        public void TestSizeInMetersProperty()
        {
            const bool expectedSizeInMeters = true;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteSizeInMetersProperty(expectedSizeInMeters);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.SizeInMetersPropertyName, expectedSizeInMeters },
            });
        }

        [Test]
        public void TestWidthProperty()
        {
            const double expectedWidth = 12.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteWidthProperty(expectedWidth);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.WidthPropertyName, expectedWidth },
            });
        }

        [Test]
        public void TestHeightProperty()
        {
            const double expectedHeight = 34.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteHeightProperty(expectedHeight);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.HeightPropertyName, expectedHeight },
            });
        }

        [Test]
        public void TestTranslucencyByDistanceProperty()
        {
            var expectedTranslucencyByDistance = new NearFarScalar(100.0, 1.0, 200.0, 0.5);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteTranslucencyByDistanceProperty(expectedTranslucencyByDistance);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucencyByDistance },
            });
        }

        [Test]
        public void TestPixelOffsetScaleByDistanceProperty()
        {
            var expectedPixelOffsetScaleByDistance = new NearFarScalar(10.0, 1.0, 20.0, 2.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WritePixelOffsetScaleByDistanceProperty(expectedPixelOffsetScaleByDistance);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.PixelOffsetScaleByDistancePropertyName, expectedPixelOffsetScaleByDistance },
            });
        }

        [Test]
        public void TestImageSubRegionProperty()
        {
            var expectedImageSubRegion = new BoundingRectangle(1.0, 2.0, 3.0, 4.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteImageSubRegionProperty(expectedImageSubRegion);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.ImageSubRegionPropertyName, expectedImageSubRegion },
            });
        }

        [Test]
        public void TestDistanceDisplayConditionProperty()
        {
            var expectedDistanceDisplayCondition = new Bounds(10.0, 20.0);

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expectedDistanceDisplayCondition);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.DistanceDisplayConditionPropertyName, expectedDistanceDisplayCondition },
            });
        }

        [Test]
        public void TestDisableDepthTestDistanceProperty()
        {
            const double expectedDisableDepthTestDistance = 1234.0;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
            using (var interval = billboard.OpenInterval())
            {
                interval.WriteDisableDepthTestDistanceProperty(expectedDisableDepthTestDistance);
            }

            AssertExpectedJson(PacketCesiumWriter.BillboardPropertyName, new Dictionary<string, object>
            {
                { BillboardCesiumWriter.DisableDepthTestDistancePropertyName, expectedDisableDepthTestDistance },
            });
        }

        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
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

            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
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
            using (var packet = OpenPacket())
            using (var billboard = packet.OpenBillboardProperty())
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
