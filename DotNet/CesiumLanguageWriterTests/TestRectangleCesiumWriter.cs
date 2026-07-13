using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestRectangleCesiumWriter : TestCesiumPropertyWriter<RectangleCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.ShowPropertyName, expectedShow },
            });
        }

        [Test]
        public void TestCoordinatesProperty()
        {
            var expectedCoordinates = new CartographicExtent(-1.0, -2.0, 3.0, 4.0);

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteCoordinatesProperty(expectedCoordinates);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.CoordinatesPropertyName, expectedCoordinates },
            });
        }

        [Test]
        public void TestExtrudedHeightProperty()
        {
            const double expectedExtrudedHeight = 10.0;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteExtrudedHeightProperty(expectedExtrudedHeight);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.ExtrudedHeightPropertyName, expectedExtrudedHeight },
            });
        }

        [Test]
        public void TestExtrudedHeightReferenceProperty()
        {
            const CesiumHeightReference expectedExtrudedHeightReference = CesiumHeightReference.RelativeToGround;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteExtrudedHeightReferenceProperty(expectedExtrudedHeightReference);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.ExtrudedHeightReferencePropertyName, expectedExtrudedHeightReference },
            });
        }

        [Test]
        public void TestFillProperty()
        {
            const bool expectedFill = true;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteFillProperty(expectedFill);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.FillPropertyName, expectedFill },
            });
        }

        [Test]
        public void TestOutlineProperty()
        {
            const bool expectedOutline = true;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteOutlineProperty(expectedOutline);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.OutlinePropertyName, expectedOutline },
            });
        }

        [Test]
        public void TestOutlineColorProperty()
        {
            var expectedOutlineColor = Color.FromArgb(128, 10, 20, 30);

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteOutlineColorProperty(expectedOutlineColor);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.OutlineColorPropertyName, expectedOutlineColor },
            });
        }

        [Test]
        public void TestOutlineWidthProperty()
        {
            const double expectedOutlineWidth = 2.5;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteOutlineWidthProperty(expectedOutlineWidth);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.OutlineWidthPropertyName, expectedOutlineWidth },
            });
        }

        [Test]
        public void TestHeightProperty()
        {
            const double expectedHeight = 100.0;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteHeightProperty(expectedHeight);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.HeightPropertyName, expectedHeight },
            });
        }

        [Test]
        public void TestHeightReferenceProperty()
        {
            const CesiumHeightReference expectedHeightReference = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expectedHeightReference);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.HeightReferencePropertyName, expectedHeightReference },
            });
        }

        [Test]
        public void TestRotationProperty()
        {
            const double expectedRotation = 1.234;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteRotationProperty(expectedRotation);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.RotationPropertyName, expectedRotation },
            });
        }

        [Test]
        public void TestStRotationProperty()
        {
            const double expectedStRotation = 0.5;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteStRotationProperty(expectedStRotation);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.StRotationPropertyName, expectedStRotation },
            });
        }

        [Test]
        public void TestGranularityProperty()
        {
            const double expectedGranularity = 0.1;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteGranularityProperty(expectedGranularity);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.GranularityPropertyName, expectedGranularity },
            });
        }

        [Test]
        public void TestMaterialProperty()
        {
            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            using (var material = interval.OpenMaterialProperty())
            using (var solidColor = material.OpenSolidColorProperty())
            {
                solidColor.WriteColorProperty(Color.Red);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                {
                    RectangleCesiumWriter.MaterialPropertyName, new Dictionary<string, object>
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

        [Test]
        public void TestShadowsProperty()
        {
            const CesiumShadowMode expectedShadows = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteShadowsProperty(expectedShadows);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.ShadowsPropertyName, expectedShadows },
            });
        }

        [Test]
        public void TestDistanceDisplayConditionProperty()
        {
            var expectedBounds = new Bounds(1.0, 123.0);

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expectedBounds);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds },
            });
        }

        [Test]
        public void TestClassificationTypeProperty()
        {
            const CesiumClassificationType expectedClassificationType = CesiumClassificationType.Terrain;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteClassificationTypeProperty(expectedClassificationType);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.ClassificationTypePropertyName, expectedClassificationType },
            });
        }

        [Test]
        public void TestZIndexProperty()
        {
            const int expectedZIndex = 5;

            using (var packet = OpenPacket())
            using (var rectangle = packet.OpenRectangleProperty())
            using (var interval = rectangle.OpenInterval())
            {
                interval.WriteZIndexProperty(expectedZIndex);
            }

            AssertExpectedJson(PacketCesiumWriter.RectanglePropertyName, new Dictionary<string, object>
            {
                { RectangleCesiumWriter.ZIndexPropertyName, expectedZIndex },
            });
        }

        protected override CesiumPropertyWriter<RectangleCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new RectangleCesiumWriter(propertyName);
        }
    }
}
