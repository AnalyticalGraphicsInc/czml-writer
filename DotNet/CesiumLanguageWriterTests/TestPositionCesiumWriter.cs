using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestPositionCesiumWriter : TestCesiumInterpolatablePropertyWriter<PositionCesiumWriter>
    {
        [Test]
        public void ReferenceFrameValueWritesReferenceFrameProperty()
        {
            const string expectedReferenceFrame = "myReferenceFrame";

            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                interval.WriteReferenceFrame(expectedReferenceFrame);
            }

            AssertExpectedJson(PacketCesiumWriter.PositionPropertyName, new Dictionary<string, object>
            {
                { PositionCesiumWriter.ReferenceFramePropertyName, expectedReferenceFrame },
            });
        }

        [Test]
        public void CartesianValueWritesSingleCartesianProperty()
        {
            var expectedValue = new Cartesian(1.0, 2.0, 3.0);

            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                interval.WriteCartesian(expectedValue);
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { PacketCesiumWriter.PositionPropertyName, expectedValue },
            });
        }

        [Test]
        public void CartographicRadiansValueWritesSingleCartographicRadiansProperty()
        {
            var expectedValue = new Cartographic(1100.0, 2200.0, 3.0);

            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                interval.WriteCartographicRadians(expectedValue);
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { PacketCesiumWriter.PositionPropertyName, expectedValue },
            });
        }

        [Test]
        public void CartesianValueWritesMultipleCartesianProperty()
        {
            var epoch = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartesian>();

                dates.Add(epoch);
                positions.Add(new Cartesian(1.1, 2.2, 3.3));

                dates.Add(epoch.AddSeconds(60.0));
                positions.Add(new Cartesian(4.4, 5.5, 6.6));

                interval.WriteCartesian(dates, positions);
            }

            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartesian\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", StringWriter.ToString());
        }

        [Test]
        public void CartesianValueSubsetWritesMultipleCartesianProperty()
        {
            var startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartesian>();

                dates.Add(startDate);
                positions.Add(new Cartesian(1.0, 2.0, 3.0));

                dates.Add(startDate.AddSeconds(60.0));
                positions.Add(new Cartesian(4.0, 5.0, 6.0));

                dates.Add(startDate.AddSeconds(120.0));
                positions.Add(new Cartesian(7.0, 8.0, 9.0));

                interval.WriteCartesian(dates, positions, 1, 1);
            }

            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartesian\":[0,4,5,6]}}", StringWriter.ToString());
        }

        [Test]
        public void CartographicRadiansValueWritesMultipleCartographicRadiansProperty()
        {
            var startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartographic>();

                dates.Add(startDate);
                positions.Add(new Cartographic(1.1, 2.2, 3.3));

                dates.Add(startDate.AddSeconds(60.0));
                positions.Add(new Cartographic(4.4, 5.5, 6.6));

                interval.WriteCartographicRadians(dates, positions);
            }

            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartographicRadians\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", StringWriter.ToString());
        }

        [Test]
        public void CartographicRadiansValueSubsetWritesMultipleCartographicRadiansProperty()
        {
            var startDate = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartographic>();

                dates.Add(startDate);
                positions.Add(new Cartographic(1.0, 2.0, 3.0));

                dates.Add(startDate.AddSeconds(60.0));
                positions.Add(new Cartographic(4.0, 5.0, 6.0));

                dates.Add(startDate.AddSeconds(120.0));
                positions.Add(new Cartographic(7.0, 8.0, 9.0));

                interval.WriteCartographicRadians(dates, positions, 1, 1);
            }

            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartographicRadians\":[0,4,5,6]}}", StringWriter.ToString());
        }

        [Test]
        public void CartesianValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection()
        {
            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartesian>();
                interval.WriteCartesian(dates, positions);
            }

            Assert.AreEqual("{\"position\":{\"cartesian\":[]}}", StringWriter.ToString());
        }

        [Test]
        public void CartographicRadiansValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection()
        {
            using (Packet)
            using (var position = Packet.OpenPositionProperty())
            using (var interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartographic>();
                interval.WriteCartographicRadians(dates, positions);
            }

            Assert.AreEqual("{\"position\":{\"cartographicRadians\":[]}}", StringWriter.ToString());
        }

        [Test]
        public void TestDeletePropertyWithStartAndStop()
        {
            var start = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            var stop = start.AddDays(1.0);
            const string expectedId = "id";
            const bool expectedDelete = true;

            using (Packet)
            {
                Packet.WriteId(expectedId);

                using (var position = Packet.OpenPositionProperty())
                using (var interval = position.OpenInterval(start, stop))
                {
                    interval.WriteDelete(expectedDelete);
                }
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { PacketCesiumWriter.IdPropertyName, expectedId },
                {
                    PacketCesiumWriter.PositionPropertyName, new Dictionary<string, object>
                    {
                        { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) },
                        { PositionCesiumWriter.DeletePropertyName, expectedDelete },
                    }
                },
            });
        }

        [Test]
        public void TestDeletePropertyWithNoInterval()
        {
            const string expectedId = "id";
            const bool expectedDelete = true;

            using (Packet)
            {
                Packet.WriteId(expectedId);

                using (var position = Packet.OpenPositionProperty())
                using (var interval = position.OpenInterval())
                {
                    interval.WriteDelete(expectedDelete);
                }
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { PacketCesiumWriter.IdPropertyName, expectedId },
                {
                    PacketCesiumWriter.PositionPropertyName, new Dictionary<string, object>
                    {
                        { PositionCesiumWriter.DeletePropertyName, expectedDelete },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<PositionCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PositionCesiumWriter(propertyName);
        }
    }
}