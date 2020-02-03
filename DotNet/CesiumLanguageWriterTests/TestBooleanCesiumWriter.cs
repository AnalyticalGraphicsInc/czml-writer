using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBooleanCesiumWriter : TestCesiumPropertyWriter<BooleanCesiumWriter>
    {
        [Test]
        public void BooleanCanBeWrittenAsSimpleBoolean()
        {
            const string expectedPropertyName = "foo";
            const bool expectedValue = false;

            using (Packet)
            using (var writer = new BooleanCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteBoolean(expectedValue);
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { expectedPropertyName, expectedValue },
            });
        }

        [Test]
        public void BooleanCanBeWrittenInsideInterval()
        {
            var start = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();
            var stop = start.AddSeconds(100.0);
            const string expectedPropertyName = "foo";
            const bool expectedValue = false;

            using (Packet)
            using (var writer = new BooleanCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(start, stop);
                writer.WriteBoolean(expectedValue);
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) },
                { BooleanCesiumWriter.BooleanPropertyName, expectedValue },
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

                using (var writer = new BooleanCesiumWriter(expectedPropertyName))
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
                        { BooleanCesiumWriter.DeletePropertyName, expectedDelete },
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

                using (var writer = new BooleanCesiumWriter(expectedPropertyName))
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
                        { BooleanCesiumWriter.DeletePropertyName, expectedDelete },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<BooleanCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BooleanCesiumWriter(propertyName);
        }
    }
}