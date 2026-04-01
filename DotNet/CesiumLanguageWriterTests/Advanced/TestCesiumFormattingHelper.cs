using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests.Advanced
{
    [TestFixture]
    public class TestCesiumFormattingHelper
    {
        [Test]
        [Combinatorial]
        public void TestClockRangeToString([Values] ClockRange value)
        {
            string s = CesiumFormattingHelper.ClockRangeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestClockStepToString([Values] ClockStep value)
        {
            string s = CesiumFormattingHelper.ClockStepToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestColorBlendModeToString([Values] CesiumColorBlendMode value)
        {
            string s = CesiumFormattingHelper.ColorBlendModeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestCornerTypeToString([Values] CesiumCornerType value)
        {
            string s = CesiumFormattingHelper.CornerTypeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestExtrapolationTypeToString([Values] CesiumExtrapolationType value)
        {
            string s = CesiumFormattingHelper.ExtrapolationTypeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestHeightReferenceToString([Values] CesiumHeightReference value)
        {
            string s = CesiumFormattingHelper.HeightReferenceToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestHorizontalOriginToString([Values] CesiumHorizontalOrigin value)
        {
            string s = CesiumFormattingHelper.HorizontalOriginToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestInterpolationAlgorithmToString([Values] CesiumInterpolationAlgorithm value)
        {
            string s = CesiumFormattingHelper.InterpolationAlgorithmToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestLabelStyleToString([Values] CesiumLabelStyle value)
        {
            string s = CesiumFormattingHelper.LabelStyleToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestSensorVolumePortionToDisplayToString([Values] CesiumSensorVolumePortionToDisplay value)
        {
            string s = CesiumFormattingHelper.SensorVolumePortionToDisplayToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestPathModeToString([Values] CesiumPathMode value)
        {
            string s = CesiumFormattingHelper.PathModeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestShadowModeToString([Values] CesiumShadowMode value)
        {
            string s = CesiumFormattingHelper.ShadowModeToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestStripeOrientationToString([Values] CesiumStripeOrientation value)
        {
            string s = CesiumFormattingHelper.StripeOrientationToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        [Combinatorial]
        public void TestVerticalOriginToString([Values] CesiumVerticalOrigin value)
        {
            string s = CesiumFormattingHelper.VerticalOriginToString(value);
            Assert.IsNotNull(s);
        }

        [Test]
        public void PassToIso8601Interval()
        {
            // Since ToIso8601Interval is just a simple wrapper around two calls to
            // CesiumFormattingHelper.ToIso8601, this test is just a smoke screen.
            const string expectedBasicInterval = "19800801T000000Z/20720703T000000Z";
            const string expectedExtendedInterval = "1980-08-01T00:00:00Z/2072-07-03T00:00:00Z";
            const string expectedCompactInterval = "19800801T00Z/20720703T00Z";

            JulianDate start = new GregorianDate(1980, 08, 01).ToJulianDate();
            JulianDate stop = new GregorianDate(2072, 07, 03).ToJulianDate();

            string basicInterval = CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Basic);
            Assert.AreEqual(expectedBasicInterval, basicInterval);

            string extendedInterval = CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Extended);
            Assert.AreEqual(expectedExtendedInterval, extendedInterval);

            string compactInterval = CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact);
            Assert.AreEqual(expectedCompactInterval, compactInterval);

            TimeInterval interval = new TimeInterval(start, stop);
            basicInterval = CesiumFormattingHelper.ToIso8601Interval(interval, Iso8601Format.Basic);
            Assert.AreEqual(expectedBasicInterval, basicInterval);

            extendedInterval = CesiumFormattingHelper.ToIso8601Interval(interval, Iso8601Format.Extended);
            Assert.AreEqual(expectedExtendedInterval, extendedInterval);

            compactInterval = CesiumFormattingHelper.ToIso8601Interval(interval, Iso8601Format.Compact);
            Assert.AreEqual(expectedCompactInterval, compactInterval);
        }

        [Test]
        public void PassClampToIso8601()
        {
            string expected = GregorianDate.MinValue.ToIso8601String(Iso8601Format.Basic);
            string actual = CesiumFormattingHelper.ToIso8601(JulianDate.MinValue, Iso8601Format.Basic);
            Assert.AreEqual(expected, actual);

            actual = CesiumFormattingHelper.ToIso8601(GregorianDate.MinValue.ToJulianDate(), Iso8601Format.Basic);
            Assert.AreEqual(expected, actual);

            expected = GregorianDate.MaxValue.ToIso8601String(Iso8601Format.Basic);
            actual = CesiumFormattingHelper.ToIso8601(JulianDate.MaxValue, Iso8601Format.Basic);
            Assert.AreEqual(expected, actual);

            actual = CesiumFormattingHelper.ToIso8601(GregorianDate.MaxValue.ToJulianDate(), Iso8601Format.Basic);
            Assert.AreEqual(expected, actual);

            expected = GregorianDate.MinValue.ToIso8601String(Iso8601Format.Extended);
            actual = CesiumFormattingHelper.ToIso8601(JulianDate.MinValue, Iso8601Format.Extended);
            Assert.AreEqual(expected, actual);

            expected = GregorianDate.MaxValue.ToIso8601String(Iso8601Format.Extended);
            actual = CesiumFormattingHelper.ToIso8601(JulianDate.MaxValue, Iso8601Format.Extended);
            Assert.AreEqual(expected, actual);

            expected = GregorianDate.MinValue.ToIso8601String(Iso8601Format.Compact);
            actual = CesiumFormattingHelper.ToIso8601(JulianDate.MinValue, Iso8601Format.Compact);
            Assert.AreEqual(expected, actual);

            expected = GregorianDate.MaxValue.ToIso8601String(Iso8601Format.Compact);
            actual = CesiumFormattingHelper.ToIso8601(JulianDate.MaxValue, Iso8601Format.Compact);
            Assert.AreEqual(expected, actual);
        }
    }
}
