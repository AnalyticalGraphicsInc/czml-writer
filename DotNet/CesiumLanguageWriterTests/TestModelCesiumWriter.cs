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
                { ModelCesiumWriter.ColorBlendModePropertyName, CesiumFormattingHelper.ColorBlendModeToString(expectedColorBlendMode) },
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

        protected override CesiumPropertyWriter<ModelCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ModelCesiumWriter(propertyName);
        }
    }
}