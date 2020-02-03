using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestDoubleCesiumWriter : TestCesiumPropertyWriter<DoubleCesiumWriter>
    {
        [Test]
        public void DoubleCanBeWrittenAsSimpleNumber()
        {
            const string expectedPropertyName = "foo";
            const double expectedValue = 1.23;

            using (Packet)
            using (var writer = new DoubleCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteNumber(expectedValue);
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { expectedPropertyName, expectedValue },
            });
        }

        [Test]
        public void DoubleCanBeWrittenInsideInterval()
        {
            var start = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();
            var stop = start.AddSeconds(100.0);
            const string expectedPropertyName = "foo";
            const double expectedValue = 1.23;

            using (Packet)
            using (var writer = new DoubleCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(start, stop);
                writer.WriteNumber(expectedValue);
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) },
                { DoubleCesiumWriter.NumberPropertyName, expectedValue },
            });
        }

        [Test]
        public void TestDeletePropertyWithStartAndStop()
        {
            var start = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            var stop = start.AddDays(1.0);
            const string expectedId = "id";
            const string expectedPropertyName = "foo";
            const bool expectedDelete = true;

            using (Packet)
            {
                Packet.WriteId(expectedId);

                using (var writer = new DoubleCesiumWriter(expectedPropertyName))
                {
                    writer.Open(OutputStream);
                    writer.WriteInterval(start, stop);
                    writer.WriteDelete(expectedDelete);
                }
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { PacketCesiumWriter.IdPropertyName, expectedId },
                {
                    expectedPropertyName, new Dictionary<string, object>
                    {
                        { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) },
                        { DoubleCesiumWriter.DeletePropertyName, expectedDelete },
                    }
                },
            });
        }

        [Test]
        public void TestDeletePropertyWithNoInterval()
        {
            const string expectedId = "id";
            const string expectedPropertyName = "foo";
            const bool expectedDelete = true;

            using (Packet)
            {
                Packet.WriteId(expectedId);

                using (var writer = new DoubleCesiumWriter(expectedPropertyName))
                {
                    writer.Open(OutputStream);
                    writer.WriteDelete(expectedDelete);
                }
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { PacketCesiumWriter.IdPropertyName, expectedId },
                {
                    expectedPropertyName, new Dictionary<string, object>
                    {
                        { DoubleCesiumWriter.DeletePropertyName, expectedDelete },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<DoubleCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new DoubleCesiumWriter(propertyName);
        }
    }
}