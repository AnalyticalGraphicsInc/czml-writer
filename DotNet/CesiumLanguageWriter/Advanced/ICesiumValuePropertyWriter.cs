namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// An interface to an object that writes the values of a <topic name="Cesium">Cesium</topic>
    /// property with values over one or more intervals.
    /// </summary>
    /// <typeparam name="T">The type written by the property writer.</typeparam>
    public interface ICesiumValuePropertyWriter<T> : ICesiumPropertyWriter
    {
        /// <summary>
        /// Writes the value of the property for this interval of time.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        void WriteValue(T value);
    }
}