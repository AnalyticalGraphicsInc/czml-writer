namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// An interface to a writer that writes information about how to interpolate sampled values.
    /// </summary>
    public interface ICesiumInterpolatablePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the interpolation algorithm to use to interpolate the sampled data in this interval.
        /// </summary>
        /// <param name="interpolationAlgorithm">The interpolation algorithm.</param>
        void WriteInterpolationAlgorithm(CesiumInterpolationAlgorithm interpolationAlgorithm);

        /// <summary>
        /// Writes the degree of polynomial to use to interpolate sampled data in this interval.
        /// </summary>
        /// <param name="degree">The degree.</param>
        void WriteInterpolationDegree(int degree);

        /// <summary>
        /// Writes the type of extrapolation to perform when a value is requested at a time after any available samples.
        /// </summary>
        /// <param name="extrapolationType">The extrapolation type.</param>
        void WriteForwardExtrapolationType(CesiumExtrapolationType extrapolationType);

        /// <summary>
        /// Writes the amount of time to extrapolate forward before the property becomes undefined.  A value of 0 will extrapolate forever.
        /// </summary>
        /// <param name="duration">The duration.</param>
        void WriteForwardExtrapolationDuration(Duration duration);

        /// <summary>
        /// Writes the type of extrapolation to perform when a value is requested at a time before any available samples.
        /// </summary>
        /// <param name="extrapolationType">The extrapolation type.</param>
        void WriteBackwardExtrapolationType(CesiumExtrapolationType extrapolationType);

        /// <summary>
        /// Writes the amount of time to extrapolate backward before the property becomes undefined.  A value of 0 will extrapolate forever.
        /// </summary>
        /// <param name="duration">The duration.</param>
        void WriteBackwardExtrapolationDuration(Duration duration);
    }
}