namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A writer that can write a value as a part of a sensor to display.
    /// </summary>
    public interface ICesiumSensorVolumePortionToDisplayValuePropertyWriter : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value as a part of a sensor to display.
        /// </summary>
        /// <param name="value">The portion of the sensor to display.</param>
        void WritePortionToDisplay(CesiumSensorVolumePortionToDisplay value);
    }
}