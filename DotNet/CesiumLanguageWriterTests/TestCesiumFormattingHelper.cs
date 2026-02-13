using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumFormattingHelper
    {
        [Test]
        public void TestClockRangeToString([Values] ClockRange value)
        {
            string s = CesiumFormattingHelper.ClockRangeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestClockStepToString([Values] ClockStep value)
        {
            string s = CesiumFormattingHelper.ClockStepToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestColorBlendModeToString([Values] CesiumColorBlendMode value)
        {
            string s = CesiumFormattingHelper.ColorBlendModeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestCornerTypeToString([Values] CesiumCornerType value)
        {
            string s = CesiumFormattingHelper.CornerTypeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestExtrapolationTypeToString([Values] CesiumExtrapolationType value)
        {
            string s = CesiumFormattingHelper.ExtrapolationTypeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestHeightReferenceToString([Values] CesiumHeightReference value)
        {
            string s = CesiumFormattingHelper.HeightReferenceToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestHorizontalOriginToString([Values] CesiumHorizontalOrigin value)
        {
            string s = CesiumFormattingHelper.HorizontalOriginToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestInterpolationAlgorithmToString([Values] CesiumInterpolationAlgorithm value)
        {
            string s = CesiumFormattingHelper.InterpolationAlgorithmToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestLabelStyleToString([Values] CesiumLabelStyle value)
        {
            string s = CesiumFormattingHelper.LabelStyleToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestSensorVolumePortionToDisplayToString([Values] CesiumSensorVolumePortionToDisplay value)
        {
            string s = CesiumFormattingHelper.SensorVolumePortionToDisplayToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestShadowModeToString([Values] CesiumShadowMode value)
        {
            string s = CesiumFormattingHelper.ShadowModeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestStripeOrientationToString([Values] CesiumStripeOrientation value)
        {
            string s = CesiumFormattingHelper.StripeOrientationToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void TestVerticalOriginToString([Values] CesiumVerticalOrigin value)
        {
            string s = CesiumFormattingHelper.VerticalOriginToString(value);
            Assert.IsNotNull(s);
        }
    }
}