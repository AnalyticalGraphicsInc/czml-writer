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
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestPositions()
        {
            var expected = new PositionList
            {
                new Cartesian(1.0, 2.0, 3.0),
                new Cartesian(4.0, 5.0, 6.0),
            };

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WritePositionsProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.PositionsPropertyName, expected);
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

            AssertPropertyJson(PolygonCesiumWriter.ShowPropertyName, new List<Dictionary<string, object>>
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
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestOutline()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.5;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestHeight()
        {
            const double expected = 10.0;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteHeightProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.HeightPropertyName, expected);
        }

        [Test]
        public void TestExtrudedHeight()
        {
            const double expected = 20.0;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteExtrudedHeightProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.ExtrudedHeightPropertyName, expected);
        }

        [Test]
        public void TestStRotation()
        {
            const double expected = 0.5;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteStRotationProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.StRotationPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestExtrudedHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.RelativeToGround;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteExtrudedHeightReferenceProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.ExtrudedHeightReferencePropertyName, expected);
        }

        [Test]
        public void TestPerPositionHeight()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WritePerPositionHeightProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.PerPositionHeightPropertyName, expected);
        }

        [Test]
        public void TestCloseTop()
        {
            const bool expected = false;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteCloseTopProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.CloseTopPropertyName, expected);
        }

        [Test]
        public void TestCloseBottom()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteCloseBottomProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.CloseBottomPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1234.0, 5678.0);

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestClassificationType()
        {
            const CesiumClassificationType expected = CesiumClassificationType.Terrain;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteClassificationTypeProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.ClassificationTypePropertyName, expected);
        }

        [Test]
        public void TestArcType()
        {
            const CesiumArcType expected = CesiumArcType.Geodesic;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteArcTypeProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.ArcTypePropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(PolygonCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
            {
                {
                    PolylineMaterialCesiumWriter.SolidColorPropertyName, new Dictionary<string, object>
                    {
                        { SolidColorMaterialCesiumWriter.ColorPropertyName, expectedColor },
                    }
                },
            });
        }

        [Test]
        public void TestZIndex()
        {
            const int expected = 5;

            using (var packet = OpenPacket())
            using (var polygon = packet.OpenPolygonProperty())
            using (var interval = polygon.OpenInterval())
            {
                interval.WriteZIndexProperty(expected);
            }

            AssertPropertyJson(PolygonCesiumWriter.ZIndexPropertyName, expected);
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

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.PolygonPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<PolygonCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolygonCesiumWriter(propertyName);
        }
    }
}
