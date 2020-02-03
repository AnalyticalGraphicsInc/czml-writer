using System;
using System.Collections.Generic;
using System.Drawing;
using System.Globalization;
using System.IO;
using System.Text;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
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

        [NotNull]
        protected abstract CesiumPropertyWriter<TDerived> CreatePropertyWriter([NotNull] string propertyName);

        /// <summary>
        /// Helper method for creating expected JSON output from key-value pairs.
        /// </summary>
        public static string CreateExpectedJson([NotNull] string topLevelPropertyName, [NotNull] IDictionary<string, object> dictionary)
        {
            return CreateExpectedJson(new Dictionary<string, object>
            {
                { topLevelPropertyName, dictionary },
            });
        }

        /// <summary>
        /// Helper method for creating expected JSON output from key-value pairs.
        /// </summary>
        public static string CreateExpectedJson([NotNull] IDictionary<string, object> dictionary)
        {
            var builder = new StringBuilder();
            builder.Append('{');
            foreach (KeyValuePair<string, object> pair in dictionary)
            {
                builder.Append('"')
                       .Append(pair.Key)
                       .Append('"')
                       .Append(':')
                       .Append(FormatValue(pair.Value))
                       .Append(',');
            }
            builder[builder.Length - 1] = '}';
            return builder.ToString();
        }

        private static string FormatValue([NotNull] object value)
        {
            if (value is bool)
            {
                // in C#, booleans format with a capital first letter
                return value.ToString().ToLowerInvariant();
            }
            if (value is double)
            {
                double d = (double)value;
                return d.ToString(CultureInfo.InvariantCulture);
            }
            if (value is string)
            {
                return string.Format("\"{0}\"", value);
            }

            if (value is Color)
            {
                Color color = (Color)value;
                return CreateExpectedJson(new Dictionary<string, object>
                {
                    { "rgba", new List<object> { color.R, color.G, color.B, color.A } },
                });
            }

            if (value is NearFarScalar)
            {
                NearFarScalar nearFarScalar = (NearFarScalar)value;
                return CreateExpectedJson(new Dictionary<string, object>
                {
                    { "nearFarScalar", new List<object> { nearFarScalar.NearDistance, nearFarScalar.NearValue, nearFarScalar.FarDistance, nearFarScalar.FarValue } },
                });
            }

            if (value is Rectangular)
            {
                Rectangular rectangular = (Rectangular)value;
                return CreateExpectedJson(new Dictionary<string, object>
                {
                    { "cartesian2", new List<object> { rectangular.X, rectangular.Y } },
                });
            }

            if (value is Cartesian)
            {
                Cartesian cartesian = (Cartesian)value;
                return CreateExpectedJson(new Dictionary<string, object>
                {
                    { "cartesian", new List<object> { cartesian.X, cartesian.Y, cartesian.Z } },
                });
            }
            if (value is Cartographic)
            {
                Cartographic cartographic = (Cartographic)value;
                return CreateExpectedJson(new Dictionary<string, object>
                {
                    { "cartographicRadians", new List<object> { cartographic.Longitude, cartographic.Latitude, cartographic.Height } },
                });
            }

            if (value is UnitQuaternion)
            {
                UnitQuaternion unitQuaternion = (UnitQuaternion)value;
                return CreateExpectedJson(new Dictionary<string, object>
                {
                    { "unitQuaternion", new List<object> { unitQuaternion.X, unitQuaternion.Y, unitQuaternion.Z, unitQuaternion.W } },
                });
            }

            var dictionary = value as IDictionary<string, object>;
            if (dictionary != null)
            {
                return CreateExpectedJson(dictionary);
            }

            var list = value as IEnumerable<object>;
            if (list != null)
            {
                var builder = new StringBuilder();
                builder.Append('[');
                foreach (object o in list)
                {
                    builder.Append(FormatValue(o))
                           .Append(',');
                }
                builder[builder.Length - 1] = ']';
                return builder.ToString();
            }

            return value.ToString();
        }

        [AssertionMethod]
        public void AssertExpectedJson([NotNull] string topLevelPropertyName, [NotNull] IDictionary<string, object> dictionary)
        {
            string expectedJson = CreateExpectedJson(topLevelPropertyName, dictionary);
            Assert.AreEqual(expectedJson, StringWriter.ToString());
        }

        [AssertionMethod]
        public void AssertExpectedJson([NotNull] IDictionary<string, object> dictionary)
        {
            string expectedJson = CreateExpectedJson(dictionary);
            Assert.AreEqual(expectedJson, StringWriter.ToString());
        }

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
            JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();
            JulianDate stop = new GregorianDate(2012, 4, 2, 13, 0, 0).ToJulianDate();

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
        public void ThrowsWhenWritingToBeforeOpening()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("woot");

            var exception = Assert.Throws<InvalidOperationException>(() => property.OpenInterval());
            StringAssert.Contains("not currently open", exception.Message);
        }

        [Test]
        public void ThrowsWhenWritingToAfterClosed()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("woot");
            property.Open(OutputStream);
            property.Close();

            var exception = Assert.Throws<InvalidOperationException>(() => property.OpenInterval());
            StringAssert.Contains("not currently open", exception.Message);
        }
    }
}