
#if StkComponents
namespace AGI.Foundation.Cesium.Advanced
#else
namespace CesiumLanguageWriter.Advanced
#endif
{
    /// <summary>
    /// An interface to a writer that writes information about how to interpolate sampled values.
    /// </summary>
    public interface ICesiumInterpolationInformationWriter
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
    }
}