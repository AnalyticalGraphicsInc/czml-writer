using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestWallCesiumWriter : TestCesiumPropertyWriter<WallCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = false;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { WallCesiumWriter.ShowPropertyName, expectedShow },
            });
        }

        [Test]
        public void TestGranularityProperty()
        {
            const double expectedGranularity = 0.1;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteGranularityProperty(expectedGranularity);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { WallCesiumWriter.GranularityPropertyName, expectedGranularity },
            });
        }

        [Test]
        public void TestFillProperty()
        {
            const bool expectedFill = false;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteFillProperty(expectedFill);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { WallCesiumWriter.FillPropertyName, expectedFill },
            });
        }

        [Test]
        public void TestOutlineProperty()
        {
            const bool expectedOutline = true;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteOutlineProperty(expectedOutline);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { WallCesiumWriter.OutlinePropertyName, expectedOutline },
            });
        }

        [Test]
        public void TestOutlineColorProperty()
        {
            var expectedColor = Color.FromArgb(255, 255, 0, 0);

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expectedColor);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { WallCesiumWriter.OutlineColorPropertyName, expectedColor },
            });
        }

        [Test]
        public void TestOutlineWidthProperty()
        {
            const double expectedOutlineWidth = 2.0;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expectedOutlineWidth);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { WallCesiumWriter.OutlineWidthPropertyName, expectedOutlineWidth },
            });
        }

        [Test]
        public void TestShadowsProperty()
        {
            const CesiumShadowMode expectedShadows = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteShadowsProperty(expectedShadows);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { WallCesiumWriter.ShadowsPropertyName, expectedShadows },
            });
        }

        [Test]
        public void TestDistanceDisplayConditionProperty()
        {
            var expectedBounds = new Bounds(1234.0, 5678.0);

            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expectedBounds);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                { WallCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds },
            });
        }

        [Test]
        public void TestMaterialProperty()
        {
            using (var packet = OpenPacket())
            using (var wall = packet.OpenWallProperty())
            using (var interval = wall.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(Color.Red);
            }

            AssertExpectedJson(PacketCesiumWriter.WallPropertyName, new Dictionary<string, object>
            {
                {
                    WallCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
                    {
                        {
                            PolylineMaterialCesiumWriter.SolidColorPropertyName, new Dictionary<string, object>
                            {
                                { SolidColorMaterialCesiumWriter.ColorPropertyName, Color.Red },
                            }
                        },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<WallCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new WallCesiumWriter(propertyName);
        }
    }
}
