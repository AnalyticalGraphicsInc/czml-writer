using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// A callback to write a value to a <see cref="CesiumOutputStream"/> using a given
    /// wrapped property writer.
    /// </summary>
    /// <typeparam name="TWrappedWriter">The type of the wrapped writer.</typeparam>
    /// <typeparam name="TValue">The type of the value to write.</typeparam>
    /// <param name="wrappedWriter">The wrapper writer.</param>
    /// <param name="dates">The dates at which samples are provided.</param>
    /// <param name="values">The sampled value corresponding to each date.</param>
    /// <param name="startIndex">The index of the first sample to write.</param>
    /// <param name="length">The number of samples to write.</param>
    public delegate void CesiumWriterAdaptorWriteSamplesCallback<TWrappedWriter, TValue>(TWrappedWriter wrappedWriter, IList<JulianDate> dates, IList<TValue> values, int startIndex, int length);
}