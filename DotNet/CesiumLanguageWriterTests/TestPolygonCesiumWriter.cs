using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPolygonCesiumWriter : TestCesiumPropertyWriter<PolygonCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.ShowPropertyName, expectedShow },
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
            using (var polygon = packet.OpenPolygonProperty())
            using (var show = polygon.OpenShowProperty())
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

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                {
                    PolygonCesiumWriter.ShowPropertyName, new List<Dictionary<string, object>>
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
        public void TestHoles()
        {
            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var holes = polygon.OpenHolesProperty())
            {
                var listOfHoles = new List<List<Cartographic>>
                {
                    new List<Cartographic> { new Cartographic(1, 1, 0), new Cartographic(1, 2, 0), new Cartographic(2, 2, 0), },
                    new List<Cartographic> { new Cartographic(4, 4, 0), new Cartographic(4, 5, 0), new Cartographic(5, 5, 0), new Cartographic(5, 4, 0), },
                };
                holes.WriteCartographicDegrees(listOfHoles);
            }

            Assert.AreEqual("{\"polygon\":{\"holes\":{\"cartographicDegrees\":[[1,1,0,1,2,0,2,2,0],[4,4,0,4,5,0,5,5,0,5,4,0]]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestHolesIntervals()
        {
            var startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            var stopDate = new GregorianDate(2012, 4, 2, 13, 0, 0).ToJulianDate();

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var holes = polygon.OpenHolesProperty())
            {
                using (var holesIntervals = holes.OpenMultipleIntervals())
                {
                    using (var interval = holesIntervals.OpenInterval(startDate, startDate.AddSeconds(60 * 30)))
                    {
                        var listOfHoles = new List<List<Cartographic>>
                        {
                            new List<Cartographic> { new Cartographic(1, 1, 0), new Cartographic(1, 2, 0), new Cartographic(2, 2, 0), },
                            new List<Cartographic> { new Cartographic(4, 4, 0), new Cartographic(4, 5, 0), new Cartographic(5, 5, 0), new Cartographic(5, 4, 0), },
                        };
                        interval.WriteCartographicDegrees(listOfHoles);
                    }

                    using (var interval = holesIntervals.OpenInterval(startDate.AddSeconds(60 * 30), stopDate))
                    {
                        var listOfHoles = new List<List<Cartographic>>
                        {
                            new List<Cartographic> { new Cartographic(11, 1, 0), new Cartographic(11, 2, 0), new Cartographic(12, 2, 0), },
                            new List<Cartographic> { new Cartographic(14, 4, 0), new Cartographic(14, 5, 0), new Cartographic(15, 5, 0), new Cartographic(15, 4, 0), },
                        };
                        interval.WriteCartographicDegrees(listOfHoles);
                    }
                }
            }

            Assert.AreEqual("{\"polygon\":{\"holes\":[" +
                            "{\"interval\":\"20120402T12Z/20120402T1230Z\",\"cartographicDegrees\":[[1,1,0,1,2,0,2,2,0],[4,4,0,4,5,0,5,5,0,5,4,0]]}," +
                            "{\"interval\":\"20120402T1230Z/20120402T13Z\",\"cartographicDegrees\":[[11,1,0,11,2,0,12,2,0],[14,4,0,14,5,0,15,5,0,15,4,0]]}" +
                            "]}}", StringWriter.ToString());
        }

        [Test]
        public void TestFillProperty()
        {
            const bool expectedFill = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteFillProperty(expectedFill);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.FillPropertyName, expectedFill },
            });
        }

        [Test]
        public void TestOutlineProperty()
        {
            const bool expectedOutline = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteOutlineProperty(expectedOutline);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.OutlinePropertyName, expectedOutline },
            });
        }

        [Test]
        public void TestOutlineColorProperty()
        {
            var expectedOutlineColor = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expectedOutlineColor);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.OutlineColorPropertyName, expectedOutlineColor },
            });
        }

        [Test]
        public void TestOutlineWidthProperty()
        {
            const double expectedOutlineWidth = 2.5;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expectedOutlineWidth);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.OutlineWidthPropertyName, expectedOutlineWidth },
            });
        }

        [Test]
        public void TestHeightProperty()
        {
            const double expectedHeight = 10.0;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteHeightProperty(expectedHeight);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.HeightPropertyName, expectedHeight },
            });
        }

        [Test]
        public void TestExtrudedHeightProperty()
        {
            const double expectedExtrudedHeight = 20.0;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteExtrudedHeightProperty(expectedExtrudedHeight);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.ExtrudedHeightPropertyName, expectedExtrudedHeight },
            });
        }

        [Test]
        public void TestHeightReferenceProperty()
        {
            const CesiumHeightReference expectedHeightReference = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expectedHeightReference);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.HeightReferencePropertyName, expectedHeightReference },
            });
        }

        [Test]
        public void TestExtrudedHeightReferenceProperty()
        {
            const CesiumHeightReference expectedExtrudedHeightReference = CesiumHeightReference.RelativeToGround;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteExtrudedHeightReferenceProperty(expectedExtrudedHeightReference);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.ExtrudedHeightReferencePropertyName, expectedExtrudedHeightReference },
            });
        }

        [Test]
        public void TestPerPositionHeightProperty()
        {
            const bool expectedPerPositionHeight = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WritePerPositionHeightProperty(expectedPerPositionHeight);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.PerPositionHeightPropertyName, expectedPerPositionHeight },
            });
        }

        [Test]
        public void TestCloseTopProperty()
        {
            const bool expectedCloseTop = false;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteCloseTopProperty(expectedCloseTop);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.CloseTopPropertyName, expectedCloseTop },
            });
        }

        [Test]
        public void TestCloseBottomProperty()
        {
            const bool expectedCloseBottom = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteCloseBottomProperty(expectedCloseBottom);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.CloseBottomPropertyName, expectedCloseBottom },
            });
        }

        [Test]
        public void TestShadowsProperty()
        {
            const CesiumShadowMode expectedShadows = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteShadowsProperty(expectedShadows);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.ShadowsPropertyName, expectedShadows },
            });
        }

        [Test]
        public void TestDistanceDisplayConditionProperty()
        {
            var expectedBounds = new Bounds(1234.0, 5678.0);

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expectedBounds);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds },
            });
        }

        [Test]
        public void TestClassificationTypeProperty()
        {
            const CesiumClassificationType expectedClassificationType = CesiumClassificationType.Terrain;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteClassificationTypeProperty(expectedClassificationType);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.ClassificationTypePropertyName, expectedClassificationType },
            });
        }

        [Test]
        public void TestArcTypeProperty()
        {
            const CesiumArcType expectedArcType = CesiumArcType.Geodesic;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteArcTypeProperty(expectedArcType);
            }

            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { PolygonCesiumWriter.ArcTypePropertyName, expectedArcType },
            });
        }

        [Test]
        public void WriteExample()
        {
            string outputPath = Path.Combine(TestContext.CurrentContext.TestDirectory, "PolygonCesiumWriter.czml");
            using (var streamWriter = new StreamWriter(outputPath))
            {
                WriteExample(new CesiumOutputStream(streamWriter, true));
            }
        }

        private static void WriteExample([NotNull] CesiumOutputStream output)
        {
            var writer = new CesiumStreamWriter();

            using (var packet = writer.OpenPacket(output))
            {
                packet.WriteId("examplePolygon");

                using (var polygon = packet.OpenPolygonProperty())
                {
                    using (var positions = polygon.OpenPositionsProperty())
                    {
                        var listOfPositions = new List<Cartographic>
                        {
                            new Cartographic(0, 0, 0),
                            new Cartographic(0, 10, 0),
                            new Cartographic(10, 10, 0),
                            new Cartographic(10, 0, 0),
                        };
                        positions.WriteCartographicDegrees(listOfPositions);
                    }

                    using (var holes = polygon.OpenHolesProperty())
                    {
                        var listOfHoles = new List<List<Cartographic>>
                        {
                            new List<Cartographic> { new Cartographic(1, 1, 0), new Cartographic(1, 2, 0), new Cartographic(2, 2, 0), },
                            new List<Cartographic> { new Cartographic(4, 4, 0), new Cartographic(4, 5, 0), new Cartographic(5, 5, 0), new Cartographic(5, 4, 0), },
                        };
                        holes.WriteCartographicDegrees(listOfHoles);
                    }

                    using (var material = polygon.OpenMaterialProperty())
                    {
                        using (var solidColor = material.OpenSolidColorProperty())
                        {
                            solidColor.WriteColorProperty(Color.Red);
                        }
                    }
                }
            }
        }

        protected override CesiumPropertyWriter<PolygonCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolygonCesiumWriter(propertyName);
        }
    }
}
