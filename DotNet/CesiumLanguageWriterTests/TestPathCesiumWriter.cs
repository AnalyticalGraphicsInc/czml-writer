using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using CesiumLanguageWriterTests.Data;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPathCesiumWriter : TestCesiumPropertyWriter<PathCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (var packet = OpenPacket())
            using (var path = packet.OpenPathProperty())
            using (var interval = path.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.PathPropertyName, new Dictionary<string, object>
            {
                { PathCesiumWriter.ShowPropertyName, expectedShow },
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
            using (var path = packet.OpenPathProperty())
            using (var show = path.OpenShowProperty())
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

            AssertExpectedJson(PacketCesiumWriter.PathPropertyName, new Dictionary<string, object>
            {
                {
                    PathCesiumWriter.ShowPropertyName, new List<Dictionary<string, object>>
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
        public void TestRelativeToProperty()
        {
            const string expectedRelativeTo = "INERTIAL";

            using (var packet = OpenPacket())
            using (var path = packet.OpenPathProperty())
            using (var interval = path.OpenInterval())
            {
                interval.WriteRelativeToProperty(expectedRelativeTo);
            }
            AssertExpectedJson(PacketCesiumWriter.PathPropertyName, new Dictionary<string, object>
            {
                { PathCesiumWriter.RelativeToPropertyName, expectedRelativeTo },
            });
        }

        [Test]
        public void TestMaterialMode()
        {
            const string expectedMaterialMode = "PORTIONS";

            using (var packet = OpenPacket())
            using (var path = packet.OpenPathProperty())
            using (var interval = path.OpenInterval())
            {
                interval.WriteMaterialModeProperty(CesiumPathMode.Portions);
            }
            AssertExpectedJson(PacketCesiumWriter.PathPropertyName, new Dictionary<string, object>
            {
                { PathCesiumWriter.MaterialModePropertyName, expectedMaterialMode },
            });
        }

        [Test]
        public void TestLeadAndTrailTimeProperties()
        {
            const double expectedLeadTime = 10.0;
            const double expectedTrailTime = 20.0;

            using (var packet = OpenPacket())
            using (var path = packet.OpenPathProperty())
            using (var interval = path.OpenInterval())
            {
                interval.WriteLeadTimeProperty(expectedLeadTime);
                interval.WriteTrailTimeProperty(expectedTrailTime);
            }

            AssertExpectedJson(PacketCesiumWriter.PathPropertyName, new Dictionary<string, object>
            {
                { PathCesiumWriter.LeadTimePropertyName, expectedLeadTime },
                { PathCesiumWriter.TrailTimePropertyName, expectedTrailTime },
            });
        }

        [Test]
        public void TestDistanceDisplayConditionProperty()
        {
            var expectedBounds = new Bounds(1234.0, 5678.0);

            using (var packet = OpenPacket())
            using (var path = packet.OpenPathProperty())
            using (var interval = path.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expectedBounds);
            }

            AssertExpectedJson(PacketCesiumWriter.PathPropertyName, new Dictionary<string, object>
            {
                { PathCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds },
            });
        }

        [Test]
        public void PathPortionMaterialExample()
        {
            string outputPath = Path.Combine(TestContext.CurrentContext.TestDirectory, "PathCesiumWriter.czml");
            using (var streamWriter = new StreamWriter(outputPath))
            {
                PathPortionMaterialExample(new CesiumOutputStream(streamWriter, true));
            }
        }

        private static void PathPortionMaterialExample([NotNull] CesiumOutputStream output)
        {
            output.WriteStartSequence();

            var startDate = GregorianDate.Parse("2026/04/01").ToJulianDate();

            var dates = new List<JulianDate>
            {
                startDate,
                startDate.AddSeconds(1 * 60.0),
                startDate.AddSeconds(2 * 60.0),
                startDate.AddSeconds(3 * 60.0),
            };
            var positions = new List<Cartographic>
            {
                new Cartographic(-70, 20, 150000),
                new Cartographic(-75, 15, 160000),
                new Cartographic(-78, 24, 140000),
                new Cartographic(-83, 10, 170000),
            };

            var writer = new CesiumStreamWriter();

            using (var packet = writer.OpenPacket(output))
            {
                packet.WriteId("document");
                packet.WriteVersion("1.0");

                using (var clock = packet.OpenClockProperty())
                {
                    using (var interval = clock.OpenInterval(dates.First(), dates.Last()))
                    {
                        interval.WriteCurrentTime(dates.First());
                    }
                }
            }

            using (var packet = writer.OpenPacket(output))
            {
                packet.WriteAvailability(dates.First(), dates.Last());

                using (var position = packet.OpenPositionProperty())
                {
                    position.WriteCartographicDegrees(dates, positions);
                }

                using (var billboard = packet.OpenBillboardProperty())
                {
                    billboard.WriteImageProperty(CesiumResource.FromStream(EmbeddedData.Read("satellite.png"), CesiumImageFormat.Png));
                }

                using (var path = packet.OpenPathProperty())
                {
                    path.WriteWidthProperty(8.0);
                    path.WriteMaterialModeProperty(CesiumPathMode.Portions);

                    using (var material = path.OpenMaterialProperty())
                    using (var intervals = material.OpenMultipleIntervals())
                    {
                        using (var interval = intervals.OpenInterval(dates[0], dates[1]))
                        using (var solidColor = interval.OpenSolidColorProperty())
                        {
                            solidColor.WriteColorProperty(Color.Red);
                        }

                        using (var interval = intervals.OpenInterval(dates[1], dates[2]))
                        using (var polylineGlow = interval.OpenPolylineGlowProperty())
                        {
                            polylineGlow.WriteColorProperty(Color.Purple);
                            polylineGlow.WriteGlowPowerProperty(new List<JulianDate> { dates[1], dates[2] },
                                                                new List<double> { 0.0, 1.0 });
                        }

                        using (var interval = intervals.OpenInterval(dates[2], dates[3]))
                        using (var polylineDash = interval.OpenPolylineDashProperty())
                        {
                            using (var color = polylineDash.OpenColorProperty())
                            using (var colorIntervals = color.OpenMultipleIntervals())
                            {
                                using (var colorInterval = colorIntervals.OpenInterval(dates[2], dates[2].AddSeconds(30.0)))
                                {
                                    colorInterval.WriteRgba(Color.LightGreen);
                                }
                                using (var colorInterval = colorIntervals.OpenInterval(dates[2].AddSeconds(30.0), dates[3]))
                                {
                                    colorInterval.WriteRgba(Color.LightCoral);
                                }
                            }
                        }
                    }
                }
            }

            output.WriteEndSequence();
        }

        protected override CesiumPropertyWriter<PathCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PathCesiumWriter(propertyName);
        }
    }
}
