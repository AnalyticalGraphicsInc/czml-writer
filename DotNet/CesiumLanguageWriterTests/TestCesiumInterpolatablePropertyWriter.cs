#if StkComponents
using AGI.Foundation.Cesium;
using AGI.Foundation.Cesium.Advanced;
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
    public abstract class TestCesiumInterpolatablePropertyWriter<TValue, TDerived> : TestCesiumPropertyWriter<TValue, TDerived>
        where TDerived : CesiumInterpolatableValuePropertyWriter<TValue, TDerived>
    {
        [Test]
        public void InterpolationAlgorithmValueWritesInterpolationAlgorithmProperty()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("foo");
            property.Open(OutputStream);
            using (TDerived interval = property.OpenInterval())
            {
                interval.WriteInterpolationAlgorithm(CesiumInterpolationAlgorithm.Hermite);
            }
            Assert.AreEqual("{\"foo\":{\"interpolationAlgorithm\":\"HERMITE\"}", StringWriter.ToString());
        }

        [Test]
        public void InterpolationDegreeValueWritesInterpolationDegreeProperty()
        {
            CesiumPropertyWriter<TDerived> property = CreatePropertyWriter("foo");
            property.Open(OutputStream);
            using (TDerived interval = property.OpenInterval())
            {
                interval.WriteInterpolationDegree(3);
            }
            Assert.AreEqual("{\"foo\":{\"interpolationDegree\":3}", StringWriter.ToString());
        }
    }
}
