using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public abstract class TestCesiumInterpolatablePropertyWriter<TDerived> : TestCesiumPropertyWriter<TDerived>
        where TDerived : CesiumInterpolatablePropertyWriter<TDerived>
    {
        [Test]
        public void InterpolationAlgorithmValueWritesInterpolationAlgorithmProperty()
        {
            const string expectedPropertyName = "foo";
            const CesiumInterpolationAlgorithm expectedInterpolationAlgorithm = CesiumInterpolationAlgorithm.Hermite;

            using (OpenPacket())
            using (var propertyWriter = CreatePropertyWriter(expectedPropertyName))
            {
                propertyWriter.Open(OutputStream);
                using (TDerived intervalWriter = propertyWriter.OpenInterval())
                {
                    intervalWriter.WriteInterpolationAlgorithm(expectedInterpolationAlgorithm);
                }
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "interpolationAlgorithm", CesiumFormattingHelper.InterpolationAlgorithmToString(expectedInterpolationAlgorithm) },
            });
        }

        [Test]
        public void InterpolationDegreeValueWritesInterpolationDegreeProperty()
        {
            const string expectedPropertyName = "foo";
            const int expectedInterpolationDegree = 3;

            using (OpenPacket())
            using (var propertyWriter = CreatePropertyWriter(expectedPropertyName))
            {
                propertyWriter.Open(OutputStream);
                using (TDerived intervalWriter = propertyWriter.OpenInterval())
                {
                    intervalWriter.WriteInterpolationDegree(expectedInterpolationDegree);
                }
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "interpolationDegree", expectedInterpolationDegree },
            });
        }

        [Test]
        public void WritesForwardExtrapolationType()
        {
            const string expectedPropertyName = "foo";
            const CesiumExtrapolationType expectedForwardExtrapolationType = CesiumExtrapolationType.Extrapolate;

            using (OpenPacket())
            using (var propertyWriter = CreatePropertyWriter(expectedPropertyName))
            {
                propertyWriter.Open(OutputStream);
                using (TDerived intervalWriter = propertyWriter.OpenInterval())
                {
                    intervalWriter.WriteForwardExtrapolationType(expectedForwardExtrapolationType);
                }
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "forwardExtrapolationType", CesiumFormattingHelper.ExtrapolationTypeToString(expectedForwardExtrapolationType) },
            });
        }

        [Test]
        public void WritesBackwardExtrapolationType()
        {
            const string expectedPropertyName = "foo";
            const CesiumExtrapolationType expectedBackwardExtrapolationType = CesiumExtrapolationType.Extrapolate;

            using (OpenPacket())
            using (var propertyWriter = CreatePropertyWriter(expectedPropertyName))
            {
                propertyWriter.Open(OutputStream);
                using (TDerived intervalWriter = propertyWriter.OpenInterval())
                {
                    intervalWriter.WriteBackwardExtrapolationType(expectedBackwardExtrapolationType);
                }
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "backwardExtrapolationType", CesiumFormattingHelper.ExtrapolationTypeToString(expectedBackwardExtrapolationType) },
            });
        }

        [Test]
        public void WritesForwardExtrapolationDuration()
        {
            const string expectedPropertyName = "foo";
            var expectedForwardExtrapolationDuration = Duration.FromSeconds(12);

            using (OpenPacket())
            using (var propertyWriter = CreatePropertyWriter(expectedPropertyName))
            {
                propertyWriter.Open(OutputStream);
                using (TDerived intervalWriter = propertyWriter.OpenInterval())
                {
                    intervalWriter.WriteForwardExtrapolationDuration(expectedForwardExtrapolationDuration);
                }
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "forwardExtrapolationDuration", expectedForwardExtrapolationDuration },
            });
        }

        [Test]
        public void WritesBackwardExtrapolationDuration()
        {
            const string expectedPropertyName = "foo";
            var expectedBackwardExtrapolationDuration = Duration.FromSeconds(12);

            using (OpenPacket())
            using (var propertyWriter = CreatePropertyWriter(expectedPropertyName))
            {
                propertyWriter.Open(OutputStream);
                using (TDerived intervalWriter = propertyWriter.OpenInterval())
                {
                    intervalWriter.WriteBackwardExtrapolationDuration(expectedBackwardExtrapolationDuration);
                }
            }

            AssertExpectedJson(expectedPropertyName, new Dictionary<string, object>
            {
                { "backwardExtrapolationDuration", expectedBackwardExtrapolationDuration },
            });
        }
    }
}