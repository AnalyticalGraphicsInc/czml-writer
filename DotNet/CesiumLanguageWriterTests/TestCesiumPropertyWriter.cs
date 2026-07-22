using System;
using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public abstract class TestCesiumPropertyWriter<TDerived> : TestWriterBase
        where TDerived : CesiumPropertyWriter<TDerived>
    {
        [NotNull]
        protected abstract CesiumPropertyWriter<TDerived> CreatePropertyWriter([NotNull] string propertyName);

        [Test]
        public void WritesPropertyNameOnOpenAndNothingOnClose()
        {
            const string propertyName = "foobar";
            var propertyWriter = CreatePropertyWriter(propertyName);
            propertyWriter.Open(OutputStream);

            const string expected = "\"" + propertyName + "\":";
            Assert.AreEqual(expected, StringWriter.ToString());

            propertyWriter.Close();

            Assert.AreEqual(expected, StringWriter.ToString());
        }

        [Test]
        public void SingleIntervalWritesOpenObjectLiteral()
        {
            const string propertyName = "testObj";
            var propertyWriter = CreatePropertyWriter(propertyName);
            propertyWriter.Open(OutputStream);

            var intervalWriter = propertyWriter.OpenInterval();
            Assert.IsNotNull(intervalWriter);

            const string expected = "\"" + propertyName + "\":{";
            Assert.AreEqual(expected, StringWriter.ToString());
        }

        [Test]
        public void MultipleIntervalsWritesOpenArray()
        {
            const string propertyName = "testArr";
            var propertyWriter = CreatePropertyWriter(propertyName);
            propertyWriter.Open(OutputStream);

            var intervalListWriter = propertyWriter.OpenMultipleIntervals();
            Assert.IsNotNull(intervalListWriter);

            const string expected = "\"" + propertyName + "\":[";
            Assert.AreEqual(expected, StringWriter.ToString());
        }

        [Test]
        public void ClosingMultipleIntervalsWritesCloseArray()
        {
            const string propertyName = "testArr";
            var propertyWriter = CreatePropertyWriter(propertyName);
            propertyWriter.Open(OutputStream);

            var intervalListWriter = propertyWriter.OpenMultipleIntervals();
            Assert.IsNotNull(intervalListWriter);
            intervalListWriter.Close();

            const string expected = "\"" + propertyName + "\":[]";
            Assert.AreEqual(expected, StringWriter.ToString());
        }

        [Test]
        public void MultipleIntervalsAllowsWritingMultipleIntervals()
        {
            const string expectedPropertyName = "woot";

            JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            JulianDate stop = new GregorianDate(2012, 4, 2, 13, 0, 0).ToJulianDate();

            using (OpenPacket())
            using (var propertyWriter = CreatePropertyWriter(expectedPropertyName))
            {
                propertyWriter.Open(OutputStream);
                using (var intervalListWriter = propertyWriter.OpenMultipleIntervals())
                {
                    using (TDerived intervalWriter = intervalListWriter.OpenInterval())
                    {
                        intervalWriter.WriteInterval(start, stop);
                    }

                    using (TDerived intervalWriter = intervalListWriter.OpenInterval())
                    {
                        intervalWriter.WriteInterval(new TimeInterval(start, stop));
                    }
                }
            }

            AssertExpectedJson(new Dictionary<string, object>
            {
                {
                    expectedPropertyName, new List<object>
                    {
                        new Dictionary<string, object> { { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) } },
                        new Dictionary<string, object> { { "interval", CesiumFormattingHelper.ToIso8601Interval(start, stop, Iso8601Format.Compact) } },
                    }
                },
            });
        }

        [Test]
        public void ThrowsWhenWritingToBeforeOpening()
        {
            var propertyWriter = CreatePropertyWriter("woot");

            var exception = Assert.Throws<InvalidOperationException>(() => propertyWriter.OpenInterval());
            StringAssert.Contains("not currently open", exception.Message);
        }

        [Test]
        public void ThrowsWhenWritingToAfterClosed()
        {
            var propertyWriter = CreatePropertyWriter("woot");
            propertyWriter.Open(OutputStream);
            propertyWriter.Close();

            var exception = Assert.Throws<InvalidOperationException>(() => propertyWriter.OpenInterval());
            StringAssert.Contains("not currently open", exception.Message);
        }
    }
}
