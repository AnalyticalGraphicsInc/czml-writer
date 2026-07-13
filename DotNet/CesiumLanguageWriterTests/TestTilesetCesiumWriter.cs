using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestTilesetCesiumWriter : TestCesiumPropertyWriter<TilesetCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (var packet = OpenPacket())
            using (var tileset = packet.OpenTilesetProperty())
            using (var interval = tileset.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.TilesetPropertyName, new Dictionary<string, object>
            {
                { TilesetCesiumWriter.ShowPropertyName, expectedShow },
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
            using (var tileset = packet.OpenTilesetProperty())
            using (var show = tileset.OpenShowProperty())
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

            AssertExpectedJson(PacketCesiumWriter.TilesetPropertyName, new Dictionary<string, object>
            {
                {
                    TilesetCesiumWriter.ShowPropertyName, new List<Dictionary<string, object>>
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
        public void TestUriProperty()
        {
            const string expectedUri = "test.tileset";

            using (var packet = OpenPacket())
            using (var tileset = packet.OpenTilesetProperty())
            using (var interval = tileset.OpenInterval())
            {
                interval.WriteUriProperty(expectedUri, CesiumResourceBehavior.LinkTo);
            }
            AssertExpectedJson(PacketCesiumWriter.TilesetPropertyName, new Dictionary<string, object>
            {
                { TilesetCesiumWriter.UriPropertyName, expectedUri },
            });
        }

        [Test]
        public void TestMaximumScreenSpaceErrorProperty()
        {
            const double expectedMaximumScreenSpaceError = 0.75;

            using (var packet = OpenPacket())
            using (var tileset = packet.OpenTilesetProperty())
            using (var interval = tileset.OpenInterval())
            {
                interval.WriteMaximumScreenSpaceErrorProperty(expectedMaximumScreenSpaceError);
            }

            AssertExpectedJson(PacketCesiumWriter.TilesetPropertyName, new Dictionary<string, object>
            {
                { TilesetCesiumWriter.MaximumScreenSpaceErrorPropertyName, expectedMaximumScreenSpaceError },
            });
        }

        protected override CesiumPropertyWriter<TilesetCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new TilesetCesiumWriter(propertyName);
        }
    }
}
