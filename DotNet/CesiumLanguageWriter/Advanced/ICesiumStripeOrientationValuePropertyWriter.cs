namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a stripe orientation.
    /// </summary>
    public interface ICesiumStripeOrientationValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a stripe orientation.
        /// </summary>
        /// <param name="value">The orientation.</param>
        void WriteStripeOrientation(CesiumStripeOrientation value);
    }
}