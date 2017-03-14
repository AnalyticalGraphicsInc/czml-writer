using System;
using System.IO;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    public abstract class TestCesiumPropertyWriter<TDerived>
        where TDerived : CesiumPropertyWriter<TDerived>
    {
        public StringWriter StringWriter { get; private set; }

        public CesiumOutputStream OutputStream { get; private set; }

        public CesiumStreamWriter Writer { get; private set; }

        public PacketCesiumWriter Packet { get; private set; }

        [SetUp]
        public void TestCesiumPropertyWriterSetUp()
        {
            StringWriter = new StringWriter();
            OutputStream = new CesiumOutputStream(StringWriter);
            Writer = new CesiumStreamWriter();
            Packet = Writer.OpenPacket(OutputStream);
        }

        protected abstract CesiumPropertyWriter<TDerived> CreatePropertyWriter(string propertyName);

        [Test]
        public void WritesPropertyNameOnOpenAndNothingOnClose()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("foobar");
            property.Open(OutputStream);
            Assert.AreEqual("{\"foobar\":", StringWriter.ToString());
            property.Close();
            Assert.AreEqual("{\"foobar\":", StringWriter.ToString());
        }

        [Test]
        public void SingleIntervalWritesOpenObjectLiteral()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("woot");
            property.Open(OutputStream);
            TDerived interval = property.OpenInterval();
            Assert.IsNotNull(interval);
            Assert.AreEqual("{\"woot\":{", StringWriter.ToString());
        }

        [Test]
        public void MultipleIntervalsWritesOpenArray()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("woot");
            property.Open(OutputStream);
            CesiumIntervalListWriter<TDerived> intervalList = property.OpenMultipleIntervals();
            Assert.IsNotNull(intervalList);
            Assert.AreEqual("{\"woot\":[", StringWriter.ToString());
        }

        [Test]
        public void ClosingMultipleIntervalsWritesCloseArray()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("woot");
            property.Open(OutputStream);
            CesiumIntervalListWriter<TDerived> intervalList = property.OpenMultipleIntervals();
            intervalList.Close();
            Assert.AreEqual("{\"woot\":[]", StringWriter.ToString());
        }

        [Test]
        public void MultipleIntervalsAllowsWritingMultipleIntervals()
        {
            JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));
            JulianDate stop = new JulianDate(new GregorianDate(2012, 4, 2, 13, 0, 0));

            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("woot");
            property.Open(OutputStream);
            CesiumIntervalListWriter<TDerived> intervalList = property.OpenMultipleIntervals();
            using (TDerived interval = intervalList.OpenInterval())
            {
                interval.WriteInterval(start, stop);
            }
            using (TDerived interval = intervalList.OpenInterval())
            {
                interval.WriteInterval(new TimeInterval(start, stop));
            }
            intervalList.Close();
            Assert.AreEqual("{\"woot\":[{\"interval\":\"20120402T12Z/20120402T13Z\"},{\"interval\":\"20120402T12Z/20120402T13Z\"}]", StringWriter.ToString());
        }

        [Test]
        [ExpectedException(typeof(InvalidOperationException), ExpectedMessage = "not currently open", MatchType = MessageMatch.Contains)]
        public void ThrowsWhenWritingToBeforeOpening()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("woot");
            property.OpenInterval();
        }

        [Test]
        [ExpectedException(typeof(InvalidOperationException), ExpectedMessage = "not currently open", MatchType = MessageMatch.Contains)]
        public void ThrowsWhenWritingToAfterClosed()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("woot");
            property.Open(OutputStream);
            property.Close();
            property.OpenInterval();
        }
    }
}