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
            using (Packet)
            using (LabelCesiumWriter label = Packet.OpenLabelProperty())
            using (LabelCesiumWriter interval = label.OpenInterval())
            {
                interval.WriteShowProperty(true);
            }

            Assert.AreEqual("{\"label\":{\"show\":true}}", StringWriter.ToString());
        }

        [Test]
        public void TestTextProperty()
        {
            using (Packet)
            using (LabelCesiumWriter label = Packet.OpenLabelProperty())
            using (LabelCesiumWriter interval = label.OpenInterval())
            {
                interval.WriteTextProperty("asdf");
            }

            Assert.AreEqual("{\"label\":{\"text\":\"asdf\"}}", StringWriter.ToString());
        }

        [Test]
        public void TestShowBackgroundProperty()
        {
            using (Packet)
            using (LabelCesiumWriter label = Packet.OpenLabelProperty())
            using (LabelCesiumWriter interval = label.OpenInterval())
            {
                interval.WriteShowBackgroundProperty(true);
            }

            Assert.AreEqual("{\"label\":{\"showBackground\":true}}", StringWriter.ToString());
        }

        [Test]
        public void TestBackgroundColorProperty()
        {
            using (Packet)
            using (LabelCesiumWriter label = Packet.OpenLabelProperty())
            using (LabelCesiumWriter interval = label.OpenInterval())
            {
                interval.WriteBackgroundColorProperty(Color.Red);
            }

            Assert.AreEqual("{\"label\":{\"backgroundColor\":{\"rgba\":[255,0,0,255]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestBackgroundPaddingProperty()
        {
            using (Packet)
            using (LabelCesiumWriter label = Packet.OpenLabelProperty())
            using (LabelCesiumWriter interval = label.OpenInterval())
            {
                interval.WriteBackgroundPaddingProperty(new Rectangular(3, 4));
            }

            Assert.AreEqual("{\"label\":{\"backgroundPadding\":{\"cartesian2\":[3,4]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestTranslucencyByDistanceProperty()
        {
            using (Packet)
            using (LabelCesiumWriter label = Packet.OpenLabelProperty())
            using (LabelCesiumWriter interval = label.OpenInterval())
            {
                interval.WriteTranslucencyByDistanceProperty(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
            }

            Assert.AreEqual("{\"label\":{\"translucencyByDistance\":{\"nearFarScalar\":[100,1,200,2]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestTranslucencyByDistancePropertySamples()
        {
            JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

            using (Packet)
            using (LabelCesiumWriter label = Packet.OpenLabelProperty())
            using (LabelCesiumWriter interval = label.OpenInterval())
            using (NearFarScalarCesiumWriter scaleByDistance = interval.OpenTranslucencyByDistanceProperty())
            {
                var dates = new List<JulianDate>();
                var values = new List<NearFarScalar>();

                dates.Add(startDate);
                values.Add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));

                dates.Add(startDate.AddSeconds(60.0));
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