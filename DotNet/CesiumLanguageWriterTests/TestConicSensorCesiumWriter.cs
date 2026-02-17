using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestConicSensorCesiumWriter : TestCesiumPropertyWriter<ConicSensorCesiumWriter>
    {
        [Test]
        public void TestBasicProperties()
        {
            const bool expectedShow = true;
            const double expectedInnerHalfAngle = 1.1;
            const double expectedOuterHalfAngle = 1.2;
            const double expectedMinimumClockAngle = 1.3;
            const double expectedMaximumClockAngle = 1.4;
            const double expectedRadius = 1234.5;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenConicSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
                interval.WriteInnerHalfAngleProperty(expectedInnerHalfAngle);
                interval.WriteOuterHalfAngleProperty(expectedOuterHalfAngle);
                interval.WriteMinimumClockAngleProperty(expectedMinimumClockAngle);
                interval.WriteMaximumClockAngleProperty(expectedMaximumClockAngle);
                interval.WriteRadiusProperty(expectedRadius);
            }

            AssertExpectedJson(PacketCesiumWriter.ConicSensorPropertyName, new Dictionary<string, object>
            {
                { ConicSensorCesiumWriter.ShowPropertyName, expectedShow },
                { ConicSensorCesiumWriter.InnerHalfAnglePropertyName, expectedInnerHalfAngle },
                { ConicSensorCesiumWriter.OuterHalfAnglePropertyName, expectedOuterHalfAngle },
                { ConicSensorCesiumWriter.MinimumClockAnglePropertyName, expectedMinimumClockAngle },
                { ConicSensorCesiumWriter.MaximumClockAnglePropertyName, expectedMaximumClockAngle },
                { ConicSensorCesiumWriter.RadiusPropertyName, expectedRadius },
            });
        }

        [Test]
        public void TestIntersectionProperties()
        {
            const bool expectedShowIntersection = true;
            Color expectedIntersectionColor = Color.Blue;
            const double expectedIntersectionWidth = 2.1;
            const bool expectedShowEnvironmentIntersection = true;
            Color expectedEnvironmentIntersectionColor = Color.Red;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenConicSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowIntersectionProperty(expectedShowIntersection);
                interval.WriteIntersectionColorProperty(expectedIntersectionColor);
                interval.WriteIntersectionWidthProperty(expectedIntersectionWidth);

                interval.WriteShowEnvironmentIntersectionProperty(expectedShowEnvironmentIntersection);
                interval.WriteEnvironmentIntersectionColorProperty(expectedEnvironmentIntersectionColor);
            }

            AssertExpectedJson(PacketCesiumWriter.ConicSensorPropertyName, new Dictionary<string, object>
            {
                { ConicSensorCesiumWriter.ShowIntersectionPropertyName, expectedShowIntersection },
                { ConicSensorCesiumWriter.IntersectionColorPropertyName, expectedIntersectionColor },
                { ConicSensorCesiumWriter.IntersectionWidthPropertyName, expectedIntersectionWidth },
                { ConicSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expectedShowEnvironmentIntersection },
                { ConicSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expectedEnvironmentIntersectionColor },
            });
        }

        [Test]
        public void TestShowThroughEllipsoid()
        {
            const bool expectedShowThroughEllipsoid = true;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenConicSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowThroughEllipsoidProperty(expectedShowThroughEllipsoid);
            }

            AssertExpectedJson(PacketCesiumWriter.ConicSensorPropertyName, new Dictionary<string, object>
            {
                { ConicSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expectedShowThroughEllipsoid },
            });
        }

        protected override CesiumPropertyWriter<ConicSensorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ConicSensorCesiumWriter(propertyName);
        }
    }
}