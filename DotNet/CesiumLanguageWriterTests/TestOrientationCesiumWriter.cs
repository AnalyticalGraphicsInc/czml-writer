using System;
#if StkComponents
using AGI.Foundation.Coordinates;
using AGI.Foundation.Cesium;
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Time;
using AGI.Foundation;
#else
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
#endif
using NUnit.Framework;
using System.IO;
using System.Collections.Generic;

#if StkComponents
namespace Cesium.Tests.Cesium
#else
namespace CesiumLanguageWriterTests
#endif
{
    [TestFixture]
    class TestOrientationCesiumWriter : TestCesiumInterpolatablePropertyWriter<UnitQuaternion, OrientationAxesCesiumWriter>
    {
        protected override CesiumPropertyWriter<OrientationAxesCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new OrientationAxesCesiumWriter(propertyName);
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

                using (CesiumPacketWriter packet = writer.OpenPacket(output))
                {
                    packet.WriteIdentifier("MyID");
                    packet.WriteAvailability(date, date.AddDays(1.0));

                    using (PositionCesiumWriter position = packet.OpenPositionProperty())
                    using (CesiumIntervalListWriter<PositionCesiumWriter> intervalList = position.OpenMultipleIntervals())
                    {
                        using (PositionCesiumWriter interval = intervalList.OpenInterval())
                        {
                            interval.WriteInterval(new TimeInterval(date, date.AddDays(1.0)));
                            interval.WriteValue(new Cartesian(1.0, 2.0, 3.0));
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

                            interval.WriteCartographicRadiansValue(dates, positions);
                        }
                    }
                    using (OrientationAxesCesiumWriter orientation = packet.OpenOrientationProperty())
                    using (CesiumIntervalListWriter<OrientationAxesCesiumWriter> intervalList = orientation.OpenMultipleIntervals())
                    {
                        using (OrientationAxesCesiumWriter interval = intervalList.OpenInterval())
                        {
                            interval.WriteAxes("MyMadeUpAxes");
                            interval.WriteInterval(new TimeInterval(date, date.AddDays(1.0)));
                            interval.WriteValue(new UnitQuaternion(1, 0, 0, 0));
                        }
                        using (OrientationAxesCesiumWriter interval = intervalList.OpenInterval())
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

                            interval.WriteValue(dates, orientations);
                        }
                    }

                    
                    
                }

                Console.WriteLine(sw.ToString());
            }
            
        }

    }
}
