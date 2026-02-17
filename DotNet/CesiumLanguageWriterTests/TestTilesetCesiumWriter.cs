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