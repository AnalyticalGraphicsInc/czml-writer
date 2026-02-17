using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestStringCesiumWriter : TestCesiumPropertyWriter<StringCesiumWriter>
    {
        [Test]
        public void StringCanBeWrittenAsSimpleString()
        {
            const string expectedPropertyName = "foo";
            const string expectedValue = "bar";

            using (OpenPacket())
            using (var writer = new StringCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteString(expectedValue);
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                { expectedPropertyName, expectedValue },
            });
        }

        [Test]
        public void StringCanBeWrittenInsideInterval()
        {
            var start = new GregorianDate(2012, 6, 7, 12, 0, 0).ToJulianDate();
            var stop = start.AddSeconds(100.0);
            const string expectedPropertyName = "foo";
            const string expectedValue = "bar";

            using (OpenPacket())
            using (var writer = new StringCesiumWriter("foo"))
            {
                writer.Open(OutputStream);
                writer.WriteInterval(start, stop);
                writer.WriteString(expectedValue);
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) },
                { StringCesiumWriter.StringPropertyName, expectedValue },
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

            using (var packet = OpenPacket())
            {
                packet.WriteId(expectedId);

                using (var writer = new StringCesiumWriter(expectedPropertyName))
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
                        { StringCesiumWriter.DeletePropertyName, expectedDelete },
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

            using (var packet = OpenPacket())
            {
                packet.WriteId(expectedId);

                using (var writer = new StringCesiumWriter(expectedPropertyName))
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
                        { StringCesiumWriter.DeletePropertyName, expectedDelete },
                    }
                },
            });
        }

        protected override CesiumPropertyWriter<StringCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new StringCesiumWriter(propertyName);
        }
    }
}