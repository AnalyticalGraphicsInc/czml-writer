using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestModelCesiumWriter : TestCesiumPropertyWriter<ModelCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.ShowPropertyName, expectedShow },
            });
        }

        [Test]
        public void TestGltfProperty()
        {
            const string expectedGltf = "test.gltf";

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteGltfProperty(expectedGltf, CesiumResourceBehavior.LinkTo);
            }
            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.GltfPropertyName, expectedGltf },
            });
        }

        [Test]
        public void TestSilhouetteColorProperty()
        {
            var expectedSilhouetteColor = Color.Blue;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteSilhouetteColorProperty(expectedSilhouetteColor);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.SilhouetteColorPropertyName, expectedSilhouetteColor },
            });
        }

        [Test]
        public void TestSilhouetteSizeProperty()
        {
            const double expectedSilhouetteSize = 0.75;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteSilhouetteSizeProperty(expectedSilhouetteSize);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.SilhouetteSizePropertyName, expectedSilhouetteSize },
            });
        }

        [Test]
        public void TestColorProperty()
        {
            var expectedColor = Color.Red;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteColorProperty(expectedColor);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.ColorPropertyName, expectedColor },
            });
        }

        [Test]
        public void TestColorBlendModeProperty()
        {
            const CesiumColorBlendMode expectedColorBlendMode = CesiumColorBlendMode.Replace;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteColorBlendModeProperty(expectedColorBlendMode);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.ColorBlendModePropertyName, expectedColorBlendMode },
            });
        }

        [Test]
        public void TestColorBlendAmountProperty()
        {
            const double expectedColorBlendAmount = 0.75;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteColorBlendAmountProperty(expectedColorBlendAmount);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.ColorBlendAmountPropertyName, expectedColorBlendAmount },
            });
        }

        [Test]
        public void TestScaleProperty()
        {
            const double expectedScale = 2.0;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteScaleProperty(expectedScale);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.ScalePropertyName, expectedScale },
            });
        }

        [Test]
        public void TestMinimumPixelSizeProperty()
        {
            const double expectedMinimumPixelSize = 16.0;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteMinimumPixelSizeProperty(expectedMinimumPixelSize);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.MinimumPixelSizePropertyName, expectedMinimumPixelSize },
            });
        }

        [Test]
        public void TestMaximumScaleProperty()
        {
            const double expectedMaximumScale = 10.0;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteMaximumScaleProperty(expectedMaximumScale);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.MaximumScalePropertyName, expectedMaximumScale },
            });
        }

        [Test]
        public void TestIncrementallyLoadTexturesProperty()
        {
            const bool expectedIncrementallyLoadTextures = true;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteIncrementallyLoadTexturesProperty(expectedIncrementallyLoadTextures);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.IncrementallyLoadTexturesPropertyName, expectedIncrementallyLoadTextures },
            });
        }

        [Test]
        public void TestRunAnimationsProperty()
        {
            const bool expectedRunAnimations = false;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteRunAnimationsProperty(expectedRunAnimations);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.RunAnimationsPropertyName, expectedRunAnimations },
            });
        }

        [Test]
        public void TestShadowsProperty()
        {
            const CesiumShadowMode expectedShadows = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteShadowsProperty(expectedShadows);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.ShadowsPropertyName, expectedShadows },
            });
        }

        [Test]
        public void TestHeightReferenceProperty()
        {
            const CesiumHeightReference expectedHeightReference = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expectedHeightReference);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.HeightReferencePropertyName, expectedHeightReference },
            });
        }

        [Test]
        public void TestDistanceDisplayConditionProperty()
        {
            var expectedBounds = new Bounds(1234.0, 5678.0);

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expectedBounds);
            }

            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { ModelCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds },
            });
        }

        protected override CesiumPropertyWriter<ModelCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ModelCesiumWriter(propertyName);
        }
    }
}
