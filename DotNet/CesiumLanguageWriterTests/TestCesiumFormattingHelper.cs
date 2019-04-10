using System;
using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestCesiumFormattingHelper
    {
        [Test]
        [TestCaseSource("ClockRangeValues")]
        public void TestClockRangeToString(ClockRange value)
        {
            string s = CesiumFormattingHelper.ClockRangeToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<ClockRange> ClockRangeValues
        {
            get { return (ClockRange[])Enum.GetValues(typeof(ClockRange)); }
        }

        [Test]
        [TestCaseSource("ClockStepValues")]
        public void TestClockStepToString(ClockStep value)
        {
            string s = CesiumFormattingHelper.ClockStepToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<ClockStep> ClockStepValues
        {
            get { return (ClockStep[])Enum.GetValues(typeof(ClockStep)); }
        }

        [Test]
        [TestCaseSource("ColorBlendModeValues")]
        public void TestColorBlendModeToString(CesiumColorBlendMode value)
        {
            string s = CesiumFormattingHelper.ColorBlendModeToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumColorBlendMode> ColorBlendModeValues
        {
            get { return (CesiumColorBlendMode[])Enum.GetValues(typeof(CesiumColorBlendMode)); }
        }

        [Test]
        [TestCaseSource("CornerTypeValues")]
        public void TestCornerTypeToString(CesiumCornerType value)
        {
            string s = CesiumFormattingHelper.CornerTypeToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumCornerType> CornerTypeValues
        {
            get { return (CesiumCornerType[])Enum.GetValues(typeof(CesiumCornerType)); }
        }

        [Test]
        [TestCaseSource("ExtrapolationTypeValues")]
        public void TestExtrapolationTypeToString(CesiumExtrapolationType value)
        {
            string s = CesiumFormattingHelper.ExtrapolationTypeToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumExtrapolationType> ExtrapolationTypeValues
        {
            get { return (CesiumExtrapolationType[])Enum.GetValues(typeof(CesiumExtrapolationType)); }
        }

        [Test]
        [TestCaseSource("HeightReferenceValues")]
        public void TestHeightReferenceToString(CesiumHeightReference value)
        {
            string s = CesiumFormattingHelper.HeightReferenceToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumHeightReference> HeightReferenceValues
        {
            get { return (CesiumHeightReference[])Enum.GetValues(typeof(CesiumHeightReference)); }
        }

        [Test]
        [TestCaseSource("HorizontalOriginValues")]
        public void TestHorizontalOriginToString(CesiumHorizontalOrigin value)
        {
            string s = CesiumFormattingHelper.HorizontalOriginToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumHorizontalOrigin> HorizontalOriginValues
        {
            get { return (CesiumHorizontalOrigin[])Enum.GetValues(typeof(CesiumHorizontalOrigin)); }
        }

        [Test]
        [TestCaseSource("InterpolationAlgorithmValues")]
        public void TestInterpolationAlgorithmToString(CesiumInterpolationAlgorithm value)
        {
            string s = CesiumFormattingHelper.InterpolationAlgorithmToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumInterpolationAlgorithm> InterpolationAlgorithmValues
        {
            get { return (CesiumInterpolationAlgorithm[])Enum.GetValues(typeof(CesiumInterpolationAlgorithm)); }
        }

        [Test]
        [TestCaseSource("LabelStyleValues")]
        public void TestLabelStyleToString(CesiumLabelStyle value)
        {
            string s = CesiumFormattingHelper.LabelStyleToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumLabelStyle> LabelStyleValues
        {
            get { return (CesiumLabelStyle[])Enum.GetValues(typeof(CesiumLabelStyle)); }
        }

        [Test]
        [TestCaseSource("SensorVolumePortionToDisplayValues")]
        public void TestSensorVolumePortionToDisplayToString(CesiumSensorVolumePortionToDisplay value)
        {
            string s = CesiumFormattingHelper.SensorVolumePortionToDisplayToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumSensorVolumePortionToDisplay> SensorVolumePortionToDisplayValues
        {
            get { return (CesiumSensorVolumePortionToDisplay[])Enum.GetValues(typeof(CesiumSensorVolumePortionToDisplay)); }
        }

        [Test]
        [TestCaseSource("ShadowModeValues")]
        public void TestShadowModeToString(CesiumShadowMode value)
        {
            string s = CesiumFormattingHelper.ShadowModeToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumShadowMode> ShadowModeValues
        {
            get { return (CesiumShadowMode[])Enum.GetValues(typeof(CesiumShadowMode)); }
        }

        [Test]
        [TestCaseSource("StripeOrientationValues")]
        public void TestStripeOrientationToString(CesiumStripeOrientation value)
        {
            string s = CesiumFormattingHelper.StripeOrientationToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumStripeOrientation> StripeOrientationValues
        {
            get { return (CesiumStripeOrientation[])Enum.GetValues(typeof(CesiumStripeOrientation)); }
        }

        [Test]
        [TestCaseSource("VerticalOriginValues")]
        public void TestVerticalOriginToString(CesiumVerticalOrigin value)
        {
            string s = CesiumFormattingHelper.VerticalOriginToString(value);
            Assert.IsNotNull(s);
        }

        public static IEnumerable<CesiumVerticalOrigin> VerticalOriginValues
        {
            get { return (CesiumVerticalOrigin[])Enum.GetValues(typeof(CesiumVerticalOrigin)); }
        }
    }
}