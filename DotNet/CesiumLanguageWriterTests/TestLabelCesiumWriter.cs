using System.Collections.Generic;
using System.Drawing;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestLabelCesiumWriter : TestCesiumPropertyWriter<LabelCesiumWriter>
    {
        [Test]
        public void TestShowProperty()
        {
            const bool expectedShow = true;

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteShowProperty(expectedShow);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.ShowPropertyName, expectedShow },
            });
        }

        [Test]
        public void TestTextProperty()
        {
            const string expectedText = "asdf";

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteTextProperty(expectedText);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.TextPropertyName, expectedText },
            });
        }

        [Test]
        public void TestShowBackgroundProperty()
        {
            const bool expectedShowBackground = true;

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteShowBackgroundProperty(expectedShowBackground);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.ShowBackgroundPropertyName, expectedShowBackground },
            });
        }

        [Test]
        public void TestBackgroundColorProperty()
        {
            var expectedBackgroundColor = Color.Red;

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteBackgroundColorProperty(expectedBackgroundColor);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.BackgroundColorPropertyName, expectedBackgroundColor },
            });
        }

        [Test]
        public void TestBackgroundPaddingProperty()
        {
            var expectedBackgroundPadding = new Rectangular(3, 4);

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteBackgroundPaddingProperty(expectedBackgroundPadding);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.BackgroundPaddingPropertyName, expectedBackgroundPadding },
            });
        }

        [Test]
        public void TestTranslucencyByDistanceProperty()
        {
            var expectedTranslucencyByDistance = new NearFarScalar(100.0, 1.0, 200.0, 2.0);

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            {
                interval.WriteTranslucencyByDistanceProperty(expectedTranslucencyByDistance);
            }

            AssertExpectedJson(PacketCesiumWriter.LabelPropertyName, new Dictionary<string, object>
            {
                { LabelCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucencyByDistance },
            });
        }

        [Test]
        public void TestTranslucencyByDistancePropertySamples()
        {
            var epoch = new GregorianDate(2012, 4, 2, 12, 0, 0).ToJulianDate();

            using (Packet)
            using (var label = Packet.OpenLabelProperty())
            using (var interval = label.OpenInterval())
            using (var scaleByDistance = interval.OpenTranslucencyByDistanceProperty())
            {
                var dates = new List<JulianDate>();
                var values = new List<NearFarScalar>();

                dates.Add(epoch);
                values.Add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));

                dates.Add(epoch.AddSeconds(60.0));
                values.Add(new NearFarScalar(200.0, 1.0, 300.0, 2.0));

                scaleByDistance.WriteNearFarScalar(dates, values);
            }

            Assert.AreEqual("{\"label\":{\"translucencyByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", StringWriter.ToString());
        }

        protected override CesiumPropertyWriter<LabelCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new LabelCesiumWriter(propertyName);
        }
    }
}