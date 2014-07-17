namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A <topic name="Cesium">Cesium</topic> writer for a property that represents a value that may be sampled
    /// and interpolated.  The property may be defined over a single interval or over multiple intervals.
    /// </summary>
    /// <typeparam name="TDerived">The type of the class derived from this one.</typeparam>
    public abstract class CesiumInterpolatablePropertyWriter<TDerived> : CesiumPropertyWriter<TDerived>, ICesiumInterpolationInformationWriter
        where TDerived : CesiumInterpolatablePropertyWriter<TDerived>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public CesiumInterpolatablePropertyWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CesiumInterpolatablePropertyWriter(CesiumInterpolatablePropertyWriter<TDerived> existingInstance)
            : base(existingInstance)
        {
        }

        /// <summary>
        /// Writes the interpolation algorithm to use to interpolate the sampled data in this interval.
        /// </summary>
        /// <param name="interpolationAlgorithm">The interpolation algorithm.</param>
        public void WriteInterpolationAlgorithm(CesiumInterpolationAlgorithm interpolationAlgorithm)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("interpolationAlgorithm");
            Output.WriteValue(CesiumFormattingHelper.InterpolationAlgorithmToString(interpolationAlgorithm));
        }

        /// <summary>
        /// Writes the degree of polynomial to use to interpolate sampled data in this interval.
        /// </summary>
        /// <param name="degree">The degree.</param>
        public void WriteInterpolationDegree(int degree)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("interpolationDegree");
            Output.WriteValue(degree);
        }

        /// <summary>
        /// Writes the type of extrapolation to perform when a value is requested at a time after any available samples.
        /// </summary>
        /// <param name="extrapolationType">The extrapolation type.</param>
        public void WriteForwardExtrapolationType(CesiumExtrapolationType extrapolationType)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("forwardExtrapolationType");
            Output.WriteValue(CesiumFormattingHelper.ExtrapolationTypeToString(extrapolationType));
        }

        /// <summary>
        /// Writes the amount of time to extrapolate forward before the property becomes undefined.  A value of 0 will extrapolate forever.
        /// </summary>
        /// <param name="duration">The duration.</param>
        public void WriteForwardExtrapolationDuration(Duration duration)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("forwardExtrapolationDuration");
            Output.WriteValue(duration.TotalSeconds);
        }

        /// <summary>
        /// Writes the type of extrapolation to perform when a value is requested at a time before any available samples.
        /// </summary>
        /// <param name="extrapolationType">The extrapolation type.</param>
        public void WriteBackwardExtrapolationType(CesiumExtrapolationType extrapolationType)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("backwardExtrapolationType");
            Output.WriteValue(CesiumFormattingHelper.ExtrapolationTypeToString(extrapolationType));
        }

        /// <summary>
        /// Writes the amount of time to extrapolate backward before the property becomes undefined.  A value of 0 will extrapolate forever.
        /// </summary>
        /// <param name="duration">The duration.</param>
        public void WriteBackwardExtrapolationDuration(Duration duration)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("backwardExtrapolationDuration");
            Output.WriteValue(duration.TotalSeconds);
        }
    }
}