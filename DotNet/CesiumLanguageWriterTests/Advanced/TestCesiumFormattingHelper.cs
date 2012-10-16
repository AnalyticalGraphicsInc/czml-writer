using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests.Advanced
{
    [TestFixture]
    public class TestCesiumFormattingHelper
    {
        [Test]
        public void PassToIso8601Interval()
        {
            //Since ToIso8601Interval is just a simple wrapper around two calls to
            //CesiumFormattingHelper.ToIso8601, this test is just a smoke screen.
            string expectedBasicInterval = "19800801T000000Z/20720703T000000Z";
            string expectedExtendedInterval = "1980-08-01T00:00:00Z/2072-07-03T00:00:00Z";
            string expectedCompactInterval = "19800801T00Z/20720703T00Z";

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
            string expectedMinimumBasic = "00000101T000000Z";
            string minStringBasic = CesiumFormattingHelper.ToIso8601(JulianDate.MinValue, Iso8601Format.Basic);
            Assert.AreEqual(expectedMinimumBasic, minStringBasic);

            string expectedMaximumBasic = "99991231T240000Z";
            string maxStringBasic = CesiumFormattingHelper.ToIso8601(JulianDate.MaxValue, Iso8601Format.Basic);
            Assert.AreEqual(expectedMaximumBasic, maxStringBasic);

            string expectedMinimumExtended = "0000-01-01T00:00:00Z";
            string minStringExtended = CesiumFormattingHelper.ToIso8601(JulianDate.MinValue, Iso8601Format.Extended);
            Assert.AreEqual(expectedMinimumExtended, minStringExtended);

            string expectedMaximumExtended = "9999-12-31T24:00:00Z";
            string maxStringExtended = CesiumFormattingHelper.ToIso8601(JulianDate.MaxValue, Iso8601Format.Extended);
            Assert.AreEqual(expectedMaximumExtended, maxStringExtended);

            string expectedMinimumCompact = "00000101T00Z";
            string minStringCompact = CesiumFormattingHelper.ToIso8601(JulianDate.MinValue, Iso8601Format.Compact);
            Assert.AreEqual(expectedMinimumCompact, minStringCompact);

            string expectedMaximumCompact = "99991231T24Z";
            string maxStringCompact = CesiumFormattingHelper.ToIso8601(JulianDate.MaxValue, Iso8601Format.Compact);
            Assert.AreEqual(expectedMaximumCompact, maxStringCompact);
        }
    }
}
