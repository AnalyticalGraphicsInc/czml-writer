using System.Collections.Generic;
using System.IO;
#if StkComponents
using AGI.Foundation;
using AGI.Foundation.Cesium;
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Coordinates;
using AGI.Foundation.Time;
#else
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
#endif
using NUnit.Framework;

#if StkComponents
namespace Cesium.Tests.Cesium
#else
namespace CesiumLanguageWriterTests
#endif
{
    [TestFixture]
    public class TestPositionCesiumWriter : TestCesiumInterpolatablePropertyWriter<Cartesian, PositionCesiumWriter>
    {
        protected override CesiumPropertyWriter<PositionCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new PositionCesiumWriter(propertyName);
        }

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
                interval.WriteValue(new Cartesian(1.0, 2.0, 3.0));
            }
            Assert.AreEqual("{\"position\":{\"cartesian\":[1.0,2.0,3.0]}}", StringWriter.ToString());
        }

        [Test]
        public void CartographicRadiansValueWritesSingleCartographicRadiansProperty()
        {
            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
            {
                interval.WriteCartographicRadians(new Cartographic(1.0, 2.0, 3.0));
            }
            Assert.AreEqual("{\"position\":{\"cartographicRadians\":[1.0,2.0,3.0]}}", StringWriter.ToString());
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
                positions.Add(new Cartesian(1.0, 2.0, 3.0));

                dates.Add(startDate.AddSeconds(60.0));
                positions.Add(new Cartesian(4.0, 5.0, 6.0));

                interval.WriteValue(dates, positions);
            }
            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartesian\":[0.0,1.0,2.0,3.0,60.0,4.0,5.0,6.0]}}", StringWriter.ToString());
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

                interval.WriteValue(dates, positions, 1, 1);
            }
            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartesian\":[0.0,4.0,5.0,6.0]}}", StringWriter.ToString());
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
                positions.Add(new Cartographic(1.0, 2.0, 3.0));

                dates.Add(startDate.AddSeconds(60.0));
                positions.Add(new Cartographic(4.0, 5.0, 6.0));

                interval.WriteCartographicRadians(dates, positions);
            }
            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartographicRadians\":[0.0,1.0,2.0,3.0,60.0,4.0,5.0,6.0]}}", StringWriter.ToString());
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
            Assert.AreEqual("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartographicRadians\":[0.0,4.0,5.0,6.0]}}", StringWriter.ToString());
        }

        [Test]
        public void CartesianValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection()
        {
            JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

            using (Packet)
            using (PositionCesiumWriter position = Packet.OpenPositionProperty())
            using (PositionCesiumWriter interval = position.OpenInterval())
            {
                var dates = new List<JulianDate>();
                var positions = new List<Cartesian>();
                interval.WriteValue(dates, positions);
            }
            Assert.AreEqual("{\"position\":{\"cartesian\":[]}}", StringWriter.ToString());
        }

        [Test]
        public void CartographicRadiansValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection()
        {
            JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

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
    }
}
