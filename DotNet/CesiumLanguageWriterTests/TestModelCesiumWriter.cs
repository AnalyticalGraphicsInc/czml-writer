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
        public void TestShow()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteShowProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.ShowPropertyName, expected);
        }

        [Test]
        public void TestGltf()
        {
            const string expected = "test.gltf";

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteGltfProperty(expected, CesiumResourceBehavior.LinkTo);
            }
            AssertPropertyJson(ModelCesiumWriter.GltfPropertyName, expected);
        }

        [Test]
        public void TestSilhouetteColor()
        {
            var expected = Color.Blue;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteSilhouetteColorProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.SilhouetteColorPropertyName, expected);
        }

        [Test]
        public void TestSilhouetteSize()
        {
            const double expected = 0.75;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteSilhouetteSizeProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.SilhouetteSizePropertyName, expected);
        }

        [Test]
        public void TestColor()
        {
            var expected = Color.Red;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteColorProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.ColorPropertyName, expected);
        }

        [Test]
        public void TestColorBlendMode()
        {
            const CesiumColorBlendMode expected = CesiumColorBlendMode.Replace;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteColorBlendModeProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.ColorBlendModePropertyName, expected);
        }

        [Test]
        public void TestColorBlendAmount()
        {
            const double expected = 0.75;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteColorBlendAmountProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.ColorBlendAmountPropertyName, expected);
        }

        [Test]
        public void TestScale()
        {
            const double expected = 2.0;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteScaleProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.ScalePropertyName, expected);
        }

        [Test]
        public void TestMinimumPixelSize()
        {
            const double expected = 16.0;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteMinimumPixelSizeProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.MinimumPixelSizePropertyName, expected);
        }

        [Test]
        public void TestMaximumScale()
        {
            const double expected = 10.0;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteMaximumScaleProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.MaximumScalePropertyName, expected);
        }

        [Test]
        public void TestIncrementallyLoadTextures()
        {
            const bool expected = true;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteIncrementallyLoadTexturesProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.IncrementallyLoadTexturesPropertyName, expected);
        }

        [Test]
        public void TestRunAnimations()
        {
            const bool expected = false;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteRunAnimationsProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.RunAnimationsPropertyName, expected);
        }

        [Test]
        public void TestShadows()
        {
            const CesiumShadowMode expected = CesiumShadowMode.Enabled;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteShadowsProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.ShadowsPropertyName, expected);
        }

        [Test]
        public void TestHeightReference()
        {
            const CesiumHeightReference expected = CesiumHeightReference.ClampToGround;

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteHeightReferenceProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.HeightReferencePropertyName, expected);
        }

        [Test]
        public void TestDistanceDisplayCondition()
        {
            var expected = new Bounds(1234.0, 5678.0);

            using (var packet = OpenPacket())
            using (var model = packet.OpenModelProperty())
            using (var interval = model.OpenInterval())
            {
                interval.WriteDistanceDisplayConditionProperty(expected);
            }

            AssertPropertyJson(ModelCesiumWriter.DistanceDisplayConditionPropertyName, expected);
        }

        private void AssertPropertyJson(string propertyName, object value)
        {
            AssertExpectedJson(PacketCesiumWriter.ModelPropertyName, new Dictionary<string, object>
            {
                { propertyName, value },
            });
        }

        protected override CesiumPropertyWriter<ModelCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ModelCesiumWriter(propertyName);
        }
    }
}
