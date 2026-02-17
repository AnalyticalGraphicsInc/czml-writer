using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestVerticalOriginCesiumWriter : TestCesiumPropertyWriter<VerticalOriginCesiumWriter>
    {
        [Test]
        public void VerticalOriginCanBeWrittenAsSimpleString()
        {
            const string expectedPropertyName = "foo";
            const CesiumVerticalOrigin expectedValue = CesiumVerticalOrigin.Center;

            using (OpenPacket())
            using (var writer = new VerticalOriginCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteVerticalOrigin(expectedValue);
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { expectedPropertyName, CesiumFormattingHelper.VerticalOriginToString(expectedValue) },
            });
        }

        [Test]
        public void VerticalOriginCanBeWrittenInsideInterval()
        {
            var start = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();
            var stop = start.AddSeconds(100.0);
            const string expectedPropertyName = "foo";
            const CesiumVerticalOrigin expectedValue = CesiumVerticalOrigin.Center;

            using (OpenPacket())
            using (var writer = new VerticalOriginCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(start, stop);
                writer.WriteVerticalOrigin(expectedValue);
            }
            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) },
                { VerticalOriginCesiumWriter.VerticalOriginPropertyName, CesiumFormattingHelper.VerticalOriginToString(expectedValue) },
            });
        }

        protected override CesiumPropertyWriter<VerticalOriginCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new VerticalOriginCesiumWriter(propertyName);
        }
    }
}