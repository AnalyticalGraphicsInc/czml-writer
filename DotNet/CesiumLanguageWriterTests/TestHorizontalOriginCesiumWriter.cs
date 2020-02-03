using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestHorizontalOriginCesiumWriter : TestCesiumPropertyWriter<HorizontalOriginCesiumWriter>
    {
        [Test]
        public void HorizontalOriginCanBeWrittenAsSimpleString()
        {
            const string expectedPropertyName = "foo";
            const CesiumHorizontalOrigin expectedValue = CesiumHorizontalOrigin.Center;

            using (Packet)
            using (var writer = new HorizontalOriginCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteHorizontalOrigin(expectedValue);
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { expectedPropertyName, CesiumFormattingHelper.HorizontalOriginToString(expectedValue) },
            });
        }

        [Test]
        public void HorizontalOriginCanBeWrittenInsideInterval()
        {
            var start = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();
            var stop = start.AddSeconds(100.0);
            const string expectedPropertyName = "foo";
            const CesiumHorizontalOrigin expectedValue = CesiumHorizontalOrigin.Center;

            using (Packet)
            using (var writer = new HorizontalOriginCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(start, stop);
                writer.WriteHorizontalOrigin(expectedValue);
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) },
                { HorizontalOriginCesiumWriter.HorizontalOriginPropertyName, CesiumFormattingHelper.HorizontalOriginToString(expectedValue) },
            });
        }

        protected override CesiumPropertyWriter<HorizontalOriginCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new HorizontalOriginCesiumWriter(propertyName);
        }
    }
}