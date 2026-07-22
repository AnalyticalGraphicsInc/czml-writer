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
    public class TestPolylineVolumeCesiumWriter : TestCesiumPropertyWriter<PolylineVolumeCesiumWriter>
    {
        [Test]
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.ShowPropertyName, expected);
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
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
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

            AssertPropertyJson(PolylineVolumeCesiumWriter.ShowPropertyName, new List<Dictionary<string, object>>
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
        public void TestPositions()
        {
            var expected = new PositionList
            {
                new Cartesian(1.0, 2.0, 3.0),
                new Cartesian(4.0, 5.0, 6.0),
            };

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WritePositionsProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.PositionsPropertyName, expected);
        }

        [Test]
        public void TestShape()
        {
            var expected = new ShapeList
            {
                new Rectangular(-5, -5),
                new Rectangular(6, -6),
                new Rectangular(7, 7),
                new Rectangular(-8, 8),
            };

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            {
                polylineVolume.WriteShapeProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.ShapePropertyName, expected);
        }

        [Test]
        public void TestCornerType()
        {
            const CesiumCornerType expected = CesiumCornerType.Beveled;

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteCornerTypeProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.CornerTypePropertyName, expected);
        }

        [Test]
        public void TestGranularity()
        {
            const double expected = 0.1;

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteGranularityProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.GranularityPropertyName, expected);
        }

        [Test]
        public void TestFill()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteFillProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.FillPropertyName, expected);
        }

        [Test]
        public void TestMaterial()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(expectedColor);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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
        public void TestOutline()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteOutlineProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.OutlinePropertyName, expected);
        }

        [Test]
        public void TestOutlineColor()
        {
            var expected = Color.FromArgb(255, 255, 0, 0);

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.OutlineColorPropertyName, expected);
        }

        [Test]
        public void TestOutlineWidth()
        {
            const double expected = 2.0;

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.OutlineWidthPropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(10, 1234);

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var polylineVolume = packet.OpenPolylineVolumeProperty())
            using (var interval = polylineVolume.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(PolylineVolumeCesiumWriter.ShadowsPropertyName, expected);
        }

        /// <summary>
        /// Create the example CZML file included in the Cesium Sandcastle.
        /// </summary>
        [Test]
        public void WriteExample()
        {
            string outputPath = Path.Combine(TestContext.CurrentContext.TestDirectory, "PolylineVolumeCesiumWriter.czml");
            using (var streamWriter = new StreamWriter(outputPath))
            {
                WriteExample(new CesiumOutputStream(streamWriter, true));
            }
        }

        private static void WriteExample([NotNull] CesiumOutputStream output)
        {
            output.WriteStartSequence();

            var writer = new CesiumStreamWriter();

            using (var packet = writer.OpenPacket(output))
            {
                packet.WriteId("document");
                packet.WriteName("CZML Geometries: Polyline Volume");
                packet.WriteVersion("1.0");
            }

            using (var packet = writer.OpenPacket(output))
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

            using (var packet = writer.OpenPacket(output))
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
                        const int vertexCount = 2 * arms;
                        const double rOuter = 70000.0;
                        const double rInner = 50000.0;
                        const double angle = Math.PI / arms;

                        var vertices = new List<Rectangular>(vertexCount);
                        for (int i = 0; i < vertexCount; ++i)
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

            output.WriteEndSequence();
        }

        private void AssertPropertyJson([NotNull] string propertyName, [NotNull] object value)
        {
            AssertExpectedJson(PacketCesiumWriter.PolylineVolumePropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<PolylineVolumeCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PolylineVolumeCesiumWriter(propertyName);
        }
    }
}
