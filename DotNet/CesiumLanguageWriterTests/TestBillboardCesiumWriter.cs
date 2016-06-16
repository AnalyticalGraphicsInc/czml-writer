using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestBillboardCesiumWriter : TestCesiumPropertyWriter<BillboardCesiumWriter>
    {
        protected override CesiumPropertyWriter<BillboardCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new BillboardCesiumWriter(propertyName);
        }

        [Test]
        public void TestShowProperty()
        {
            using (Packet)
            using (BillboardCesiumWriter billboard = Packet.OpenBillboardProperty())
            using (BillboardCesiumWriter interval = billboard.OpenInterval())
            {
                interval.WriteShowProperty(true);
            }
            Assert.AreEqual("{\"billboard\":{\"show\":true}}", StringWriter.ToString());
        }

        [Test]
        public void TestScaleByDistanceProperty()
        {
            using (Packet)
            using (BillboardCesiumWriter billboard = Packet.OpenBillboardProperty())
            using (BillboardCesiumWriter interval = billboard.OpenInterval())
            {
                interval.WriteScaleByDistanceProperty(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
            }
            Assert.AreEqual("{\"billboard\":{\"scaleByDistance\":{\"nearFarScalar\":[100,1,200,2]}}}", StringWriter.ToString());
        }

        [Test]
        public void TestScaleByDistancePropertySamples()
        {
            JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0));

            using (Packet)
            using (BillboardCesiumWriter billboard = Packet.OpenBillboardProperty())
            using (BillboardCesiumWriter interval = billboard.OpenInterval())
            using (NearFarScalarCesiumWriter scaleByDistance = interval.OpenScaleByDistanceProperty())
            {
                var dates = new List<JulianDate>();
                var values = new List<NearFarScalar>();

                dates.Add(startDate);
                values.Add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));

                dates.Add(startDate.AddSeconds(60.0));
                values.Add(new NearFarScalar(200.0, 1.0, 300.0, 2.0));

                scaleByDistance.WriteNearFarScalar(dates, values);
            }
            Assert.AreEqual("{\"billboard\":{\"scaleByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", StringWriter.ToString());
        }
    }
}