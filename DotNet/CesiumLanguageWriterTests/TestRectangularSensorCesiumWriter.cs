using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestRectangularSensorCesiumWriter : TestCesiumPropertyWriter<RectangularSensorCesiumWriter>
    {
        [Test]
        public void TestBasicProperties()
        {
            const bool expectedShow = true;
            const double expectedXHalfAngle = 1.1;
            const double expectedYHalfAngle = 1.2;
            const double expectedRadius = 1234.5;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangularSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
                interval.WriteXHalfAngleProperty(expectedXHalfAngle);
                interval.WriteYHalfAngleProperty(expectedYHalfAngle);
                interval.WriteRadiusProperty(expectedRadius);
            }

            AssertExpectedJson(PacketCesiumWriter.RectangularSensorPropertyName, new Dictionary<string, object>
            {
                { RectangularSensorCesiumWriter.ShowPropertyName, expectedShow },
                { RectangularSensorCesiumWriter.XHalfAnglePropertyName, expectedXHalfAngle },
                { RectangularSensorCesiumWriter.YHalfAnglePropertyName, expectedYHalfAngle },
                { RectangularSensorCesiumWriter.RadiusPropertyName, expectedRadius },
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
            using (var rectangle = packet.OpenRectangularSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowIntersectionProperty(expectedShowIntersection);
                interval.WriteIntersectionColorProperty(expectedIntersectionColor);
                interval.WriteIntersectionWidthProperty(expectedIntersectionWidth);

                interval.WriteShowEnvironmentIntersectionProperty(expectedShowEnvironmentIntersection);
                interval.WriteEnvironmentIntersectionColorProperty(expectedEnvironmentIntersectionColor);
            }

            AssertExpectedJson(PacketCesiumWriter.RectangularSensorPropertyName, new Dictionary<string, object>
            {
                { RectangularSensorCesiumWriter.ShowIntersectionPropertyName, expectedShowIntersection },
                { RectangularSensorCesiumWriter.IntersectionColorPropertyName, expectedIntersectionColor },
                { RectangularSensorCesiumWriter.IntersectionWidthPropertyName, expectedIntersectionWidth },
                { RectangularSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expectedShowEnvironmentIntersection },
                { RectangularSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expectedEnvironmentIntersectionColor },
            });
        }

        [Test]
        public void TestShowThroughEllipsoid()
        {
            const bool expectedShowThroughEllipsoid = true;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangularSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowThroughEllipsoidProperty(expectedShowThroughEllipsoid);
            }

            AssertExpectedJson(PacketCesiumWriter.RectangularSensorPropertyName, new Dictionary<string, object>
            {
                { RectangularSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expectedShowThroughEllipsoid },
            });
        }

        protected override CesiumPropertyWriter<RectangularSensorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new RectangularSensorCesiumWriter(propertyName);
        }
    }
}