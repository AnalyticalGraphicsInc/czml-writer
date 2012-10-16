using System;
using System.Collections.Generic;
using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    class TestOrientationCesiumWriter : TestCesiumInterpolatablePropertyWriter<OrientationCesiumWriter>
    {
        protected override CesiumPropertyWriter<OrientationCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new OrientationCesiumWriter(propertyName);
        }

        [Test]
        [Explicit]
        public void Sandbox()
        {
            JulianDate date = new JulianDate(2451545.0);

            using (StringWriter sw = new StringWriter())
            {
                CesiumOutputStream output = new CesiumOutputStream(sw);
                output.PrettyFormatting = true;
                CesiumStreamWriter writer = new CesiumStreamWriter();

                using (PacketCesiumWriter packet = writer.OpenPacket(output))
                {
                    packet.WriteId("MyID");
                    packet.WriteAvailability(date, date.AddDays(1.0));

                    using (PositionCesiumWriter position = packet.OpenPositionProperty())
                    using (CesiumIntervalListWriter<PositionCesiumWriter> intervalList = position.OpenMultipleIntervals())
                    {
                        using (PositionCesiumWriter interval = intervalList.OpenInterval())
                        {
                            interval.WriteInterval(new TimeInterval(date, date.AddDays(1.0)));
                            interval.WriteCartesian(new Cartesian(1.0, 2.0, 3.0));
                        }

                        using (PositionCesiumWriter interval = intervalList.OpenInterval(date.AddDays(1.0), date.AddDays(2.0)))
                        {
                            var dates = new List<JulianDate>();
                            var positions = new List<Cartographic>();

                            dates.Add(date.AddDays(1.0));
                            positions.Add(Cartographic.Zero);

                            dates.Add(date.AddDays(1.5));
                            positions.Add(new Cartographic(1.0, 0.0, 0.0));

                            dates.Add(date.AddDays(2.0));
                            positions.Add(new Cartographic(0.0, 1.0, 0.0));

                            interval.WriteCartographicRadians(dates, positions);
                        }
                    }
                    using (OrientationCesiumWriter orientation = packet.OpenOrientationProperty())
                    using (CesiumIntervalListWriter<OrientationCesiumWriter> intervalList = orientation.OpenMultipleIntervals())
                    {
                        using (OrientationCesiumWriter interval = intervalList.OpenInterval())
                        {
                            interval.WriteAxes("MyMadeUpAxes");
                            interval.WriteInterval(new TimeInterval(date, date.AddDays(1.0)));
                            interval.WriteUnitQuaternion(new UnitQuaternion(1, 0, 0, 0));
                        }
                        using (OrientationCesiumWriter interval = intervalList.OpenInterval())
                        {
                            interval.WriteInterpolationAlgorithm(CesiumInterpolationAlgorithm.Linear);
                            interval.WriteInterpolationDegree(1);

                            var dates = new List<JulianDate>();
                            var orientations = new List<UnitQuaternion>();

                            dates.Add(date.AddDays(1.0));
                            orientations.Add(UnitQuaternion.Identity);

                            dates.Add(date.AddDays(1.5));
                            orientations.Add(new UnitQuaternion(0.0, 1.0, 0.0, 0.0));

                            dates.Add(date.AddDays(2.0));
                            orientations.Add(new UnitQuaternion(0.0, 0.0, 1.0, 0.0));

                            interval.WriteUnitQuaternion(dates, orientations);
                        }
                    }



                }

                Console.WriteLine(sw.ToString());
            }

        }

    }
}
