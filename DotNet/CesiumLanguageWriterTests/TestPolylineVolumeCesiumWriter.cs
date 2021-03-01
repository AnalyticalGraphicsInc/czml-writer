using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPolylineVolumeCesiumWriter : TestCesiumPropertyWriter<PolylineVolumeCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (Packet)
            using (var polylineVolume = Packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, new Dictionary<string, object>
            {
                { PolylineVolumeCesiumWriter.ShowPropertyName, expectedShow },
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
            using (var polylineVolume = Packet.OpenPolylineVolumeProperty())
            using (var show = polylineVolume.OpenShowProperty())
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

            AssertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, new Dictionary<string, object>
            {
                {
                    PolylineVolumeCesiumWriter.ShowPropertyName, new List<Dictionary<string, object>>
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
        public void TestShape()
        {
            using (Packet)
            using (var polylineVolume = Packet.OpenPolylineVolumeProperty())
            {
                var shape = new List<Rectangular>
                {
                    new Rectangular(-5, -5),
                    new Rectangular(6, -6),
                    new Rectangular(7, 7),
                    new Rectangular(-8, 8),
                };
                polylineVolume.WriteShapeProperty(shape);
            }

            Assert.AreEqual("{\"polylineVolume\":{\"shape\":{\"cartesian2\":[-5,-5,6,-6,7,7,-8,8]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expectedBounds = new Bounds(10, 1234);

            using (Packet)
            using (var polylineVolume = Packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expectedBounds);
            }

            AssertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, new Dictionary<string, object>
            {
                { PolylineVolumeCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds },
            });
        }

        /// <summary>
        /// Create the example CZML file included in the Cesium Sandcastle.
        /// </summary>
        [Test]
        public void TestExample()
        {
            var stringWriter = new StringWriter();
            var outputStream = new CesiumOutputStream(stringWriter)
            {
                PrettyFormatting = true
            };
            var writer = new CesiumStreamWriter();

            outputStream.WriteStartSequence();

            using (var packet = writer.OpenPacket(outputStream))
            {
                packet.WriteId("document");
                packet.WriteName("CZML Geometries: Polyline Volume");
                packet.WriteVersion("1.0");
            }

            using (var packet = writer.OpenPacket(outputStream))
            {
                packet.WriteId("greenBox");
                packet.WriteName("Green box with beveled corners and outline");

                using (var polylineVolume = packet.OpenPolylineVolumeProperty())
                {
                    using (var positions = polylineVolume.OpenPositionsProperty())
                    {
                        positions.WriteCartographicDegrees(new List<Cartographic>
                        {
                            new Cartographic(-90.0, 32.0, 0),
                            new Cartographic(-90.0, 36.0, 100000),
                            new Cartographic(-94.0, 36.0, 0),
                        });
                    }

                    using (var shape = polylineVolume.OpenShapeProperty())
                    {
                        shape.WriteCartesian2(new List<Rectangular>
                        {
                            new Rectangular(-50000, -50000),
                            new Rectangular(50000, -50000),
                            new Rectangular(50000, 50000),
                            new Rectangular(-50000, 50000),
                        });
                    }

                    polylineVolume.WriteCornerTypeProperty(CesiumCornerType.Beveled);

                    using (var material = polylineVolume.OpenMaterialProperty())
                    {
                        using (var solidColor = material.OpenSolidColorProperty())
                        {
                            solidColor.WriteColorProperty(Color.FromArgb(128, Color.Lime));
                        }
                    }

                    polylineVolume.WriteOutlineProperty(true);
                    polylineVolume.WriteOutlineColorProperty(Color.Black);
                }
            }

            using (var packet = writer.OpenPacket(outputStream))
            {
                packet.WriteId("blueStar");
                packet.WriteName("Blue star with mitered corners and outline");

                using (var polylineVolume = packet.OpenPolylineVolumeProperty())
                {
                    using (var positions = polylineVolume.OpenPositionsProperty())
                    {
                        positions.WriteCartographicDegrees(new List<Cartographic>
                        {
                            new Cartographic(-95.0, 32.0, 0),
                            new Cartographic(-95.0, 36.0, 100000),
                            new Cartographic(-99.0, 36.0, 200000),
                        });
                    }

                    using (var shape = polylineVolume.OpenShapeProperty())
                    {
                        const int arms = 7;
                        const double rOuter = 70000.0;
                        const double rInner = 50000.0;

                        const double angle = Math.PI / arms;
                        var vertices = new List<Rectangular>();
                        for (int i = 0; i < 2 * arms; i++)
                        {
                            double r = i % 2 == 0 ? rOuter : rInner;
                            vertices.Add(new Rectangular(Math.Cos(i * angle) * r, Math.Sin(i * angle) * r));
                        }

                        shape.WriteCartesian2(vertices);
                    }

                    polylineVolume.WriteCornerTypeProperty(CesiumCornerType.Mitered);

                    using (var material = polylineVolume.OpenMaterialProperty())
                    {
                        using (var solidColor = material.OpenSolidColorProperty())
                        {
                            solidColor.WriteColorProperty(Color.Blue);
                        }
                    }
                }
            }

            outputStream.WriteEndSequence();

            Console.WriteLine(stringWriter.ToString());
        }

        protected override CesiumPropertyWriter<PolylineVolumeCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineVolumeCesiumWriter(propertyName);
        }
    }
}