using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestLabelStyleCesiumWriter : TestCesiumPropertyWriter<LabelStyleCesiumWriter>
    {
        [Test]
        public void LabelStyleCanBeWrittenAsSimpleString()
        {
            const string expectedPropertyName = "foo";
            const CesiumLabelStyle expectedValue = CesiumLabelStyle.FillAndOutline;

            using (OpenPacket())
            using (var writer = new LabelStyleCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteLabelStyle(expectedValue);
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { expectedPropertyName, CesiumFormattingHelper.LabelStyleToString(expectedValue) },
            });
        }

        [Test]
        public void LabelStyleCanBeWrittenInsideInterval()
        {
            var start = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();
            var stop = start.AddSeconds(100.0);
            const string expectedPropertyName = "foo";
            const CesiumLabelStyle expectedValue = CesiumLabelStyle.FillAndOutline;

            using (OpenPacket())
            using (var writer = new LabelStyleCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(start, stop);
                writer.WriteLabelStyle(expectedValue);
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) },
                { LabelStyleCesiumWriter.LabelStylePropertyName, CesiumFormattingHelper.LabelStyleToString(expectedValue) },
            });
        }

        protected override CesiumPropertyWriter<LabelStyleCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new LabelStyleCesiumWriter(propertyName);
        }
    }
}