﻿using System;
using System.IO;
#if StkComponents
using AGI.Foundation.Cesium;
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Time;
using AGI.Test;
#else
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
#endif
using NUnit.Framework;

#if StkComponents
namespace Cesium.Tests.Cesium
#else
namespace CesiumLanguageWriterTests
#endif
{
    public abstract class TestCesiumPropertyWriter<TValue, TDerived>
#if StkComponents
        : ComponentsTestBase
#endif
        where TDerived : CesiumValuePropertyWriter<TValue, TDerived>
    {
        public StringWriter StringWriter
        {
            get;
            private set;
        }

        public CesiumOutputStream OutputStream
        {
            get;
            private set;
        }

        public CesiumStreamWriter Writer
        {
            get;
            private set;
        }

        public CesiumPacketWriter Packet
        {
            get;
            private set;
        }

        [SetUp]
        public void SetUp()
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
            Assert.AreEqual("{\"woot\":[{\"interval\":\"2012-04-02T12:00:00Z/2012-04-02T13:00:00Z\"},{\"interval\":\"2012-04-02T12:00:00Z/2012-04-02T13:00:00Z\"}]", StringWriter.ToString());
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
