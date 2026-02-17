using System;
using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
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
        public void TestExample()
        {
            var outputStream = new CesiumOutputStream(StringWriter, true);
            var writer = new CesiumStreamWriter();

            using (var packet = writer.OpenPacket(outputStream))
            {
                packet.WriteId("examplePolygon");

                using (var polygon = packet.OpenPolygonProperty())
                {
                    using (var positions = polygon.OpenPositionsProperty())
                    {
                        var listOfPositions = new List<Cartographic> { new Cartographic(0, 0, 0), new Cartographic(0, 10, 0), new Cartographic(10, 10, 0), new Cartographic(10, 0, 0), };
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

            Console.WriteLine(StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<PolygonCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolygonCesiumWriter(propertyName);
        }
    }
}