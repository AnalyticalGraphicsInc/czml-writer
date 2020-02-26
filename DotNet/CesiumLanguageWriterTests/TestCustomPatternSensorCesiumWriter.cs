using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCustomPatternSensorCesiumWriter : TestCesiumPropertyWriter<CustomPatternSensorCesiumWriter>
    {
        [Test]
        public void TestBasicProperties()
        {
            const bool expectedShow = true;
            const double expectedRadius = 1234.5;

            using (Packet)
            using (var rectangle = Packet.OpenCustomPatternSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
                interval.WriteRadiusProperty(expectedRadius);
            }

            AssertExpectedJson(PacketCesiumWriter.CustomPatternSensorPropertyName, new Dictionary<string, object>
            {
                { CustomPatternSensorCesiumWriter.ShowPropertyName, expectedShow },
                { CustomPatternSensorCesiumWriter.RadiusPropertyName, expectedRadius },
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

            using (Packet)
            using (var rectangle = Packet.OpenCustomPatternSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowIntersectionProperty(expectedShowIntersection);
                interval.WriteIntersectionColorProperty(expectedIntersectionColor);
                interval.WriteIntersectionWidthProperty(expectedIntersectionWidth);

                interval.WriteShowEnvironmentIntersectionProperty(expectedShowEnvironmentIntersection);
                interval.WriteEnvironmentIntersectionColorProperty(expectedEnvironmentIntersectionColor);
            }

            AssertExpectedJson(PacketCesiumWriter.CustomPatternSensorPropertyName, new Dictionary<string, object>
            {
                { CustomPatternSensorCesiumWriter.ShowIntersectionPropertyName, expectedShowIntersection },
                { CustomPatternSensorCesiumWriter.IntersectionColorPropertyName, expectedIntersectionColor },
                { CustomPatternSensorCesiumWriter.IntersectionWidthPropertyName, expectedIntersectionWidth },
                { CustomPatternSensorCesiumWriter.ShowEnvironmentIntersectionPropertyName, expectedShowEnvironmentIntersection },
                { CustomPatternSensorCesiumWriter.EnvironmentIntersectionColorPropertyName, expectedEnvironmentIntersectionColor },
            });
        }

        [Test]
        public void TestShowThroughEllipsoid()
        {
            const bool expectedShowThroughEllipsoid = true;

            using (Packet)
            using (var rectangle = Packet.OpenCustomPatternSensorProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowThroughEllipsoidProperty(expectedShowThroughEllipsoid);
            }

            AssertExpectedJson(PacketCesiumWriter.CustomPatternSensorPropertyName, new Dictionary<string, object>
            {
                { CustomPatternSensorCesiumWriter.ShowThroughEllipsoidPropertyName, expectedShowThroughEllipsoid },
            });
        }

        protected override CesiumPropertyWriter<CustomPatternSensorCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new CustomPatternSensorCesiumWriter(propertyName);
        }
    }
}