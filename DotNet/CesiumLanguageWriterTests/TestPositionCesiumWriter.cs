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
            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
            {
                interval.WriteReferenceFrame("myReferenceFrame");
            }
            Assert.AreEqual("{\"position\":{\"referenceFrame\":\"myReferenceFrame\"}}", StringWriter.ToString());
        }

        [Test]
        public void CartesianValueWritesSingleCartesianProperty()
        {
            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
            {
                interval.WriteCartesian(new Cartesian(1.0, 2.0, 3.0));
            }
            Assert.AreEqual("{\"position\":{\"cartesian\":[1,2,3]}}", StringWriter.ToString());
        }

        [Test]
        public void CartographicRadiansValueWritesSingleCartographicRadiansProperty()
        {
            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
            {
                interval.WriteCartographicRadians(new Cartographic(1100.0, 2200.0, 3.0));
            }
            Assert.AreEqual("{\"position\":{\"cartographicRadians\":[1100,2200,3]}}", StringWriter.ToString());
        }

        [Test]
        public void CartesianValueWritesMultipleCartesianProperty()
        {
            JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartesian>();

                dates.Add(startDate);
                positions.Add(new Cartesian(1.1, 2.2, 3.3));

                dates.Add(startDate.AddSeconds(60.0));
                positions.Add(new Cartesian(4.4, 5.5, 6.6));

                interval.WriteCartesian(dates, positions);
            }
            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartesian\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", StringWriter.ToString());
        }

        [Test]
        public void CartesianValueSubsetWritesMultipleCartesianProperty()
        {
            JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
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
            JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
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
            JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
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
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
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
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartographic>();
                interval.WriteCartographicRadians(dates, positions);
            }
            Assert.AreEqual("{\"position\":{\"cartographicRadians\":[]}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<PositionCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PositionCesiumWriter(propertyName);
        }
    }
}