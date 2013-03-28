using System;
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

    /// <summary>
    /// Adapts a class derived from <see cref="CesiumInterpolatablePropertyWriter{TDerived}"/> to implement
    /// <see cref="ICesiumValuePropertyWriter{TValue}"/> for a different type of value.  Typically, the
    /// class has a method to write values of the new type, but that method is not exposed via an interface.
    /// This class adapts the method to the interface via a callback delegate.
    /// </summary>
    /// <typeparam name="TFrom">The class derived from <see cref="CesiumInterpolatablePropertyWriter{TDerived}"/> to adapt.</typeparam>
    /// <typeparam name="TValue">The type of value to which to adapt the class to write.</typeparam>
    public class CesiumInterpolatableWriterAdaptor<TFrom, TValue> : ICesiumInterpolatableValuePropertyWriter<TValue>
        where TFrom : ICesiumPropertyWriter, ICesiumInterpolationInformationWriter
    {
        private readonly TFrom m_parent;
        private readonly CesiumWriterAdaptorWriteCallback<TFrom, TValue> m_writeValueCallback;
        private readonly CesiumWriterAdaptorWriteSamplesCallback<TFrom, TValue> m_writeSamplesCallback;
        private readonly Lazy<CesiumInterpolatableWriterAdaptor<TFrom, TValue>> m_interval;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a value of type <typeparamref name="TValue"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <typeparamref name="TValue"/>.</param>
        public CesiumInterpolatableWriterAdaptor(
            TFrom parent,
            CesiumWriterAdaptorWriteCallback<TFrom, TValue> writeValueCallback,
            CesiumWriterAdaptorWriteSamplesCallback<TFrom, TValue> writeSamplesCallback)
        {
            if (parent == null)
                throw new ArgumentNullException("parent");
            if (writeValueCallback == null)
                throw new ArgumentNullException("writeValueCallback");
            if (writeSamplesCallback == null)
                throw new ArgumentNullException("writeSamplesCallback");

            m_parent = parent;
            m_writeValueCallback = writeValueCallback;
            m_writeSamplesCallback = writeSamplesCallback;
            m_interval = new Lazy<CesiumInterpolatableWriterAdaptor<TFrom, TValue>>(() => new CesiumInterpolatableWriterAdaptor<TFrom, TValue>((TFrom)m_parent.IntervalWriter, m_writeValueCallback, m_writeSamplesCallback), false);
        }

        /// <inheritdoc />
        public bool IsOpen
        {
            get { return m_parent.IsOpen; }
        }

        /// <inheritdoc />
        public CesiumOutputStream Output
        {
            get { return m_parent.Output; }
        }

        /// <inheritdoc />
        public void WriteValue(TValue value)
        {
            m_writeValueCallback(m_parent, value);
        }

        /// <inheritdoc />
        public void WriteValue(IList<JulianDate> dates, IList<TValue> values, int startIndex, int length)
        {
            m_writeSamplesCallback(m_parent, dates, values, startIndex, length);
        }

        /// <inheritdoc />
        public void WriteInterpolationAlgorithm(CesiumInterpolationAlgorithm interpolationAlgorithm)
        {
            m_parent.WriteInterpolationAlgorithm(interpolationAlgorithm);
        }

        /// <inheritdoc />
        public void WriteInterpolationDegree(int degree)
        {
            m_parent.WriteInterpolationDegree(degree);
        }

        /// <inheritdoc />
        public void WriteInterval(JulianDate start, JulianDate stop)
        {
            m_parent.WriteInterval(start, stop);
        }

        /// <inheritdoc />
        public ICesiumPropertyWriter OpenInterval()
        {
            m_interval.Value.Open(m_parent.Output);
            return m_interval.Value;
        }

        /// <inheritdoc />
        public ICesiumIntervalListWriter OpenMultipleIntervals()
        {
            return m_parent.OpenMultipleIntervals();
        }

        /// <inheritdoc />
        public ICesiumPropertyWriter IntervalWriter
        {
            get { return m_interval.Value; }
        }

        /// <inheritdoc />
        public void Open(CesiumOutputStream output)
        {
            m_parent.Open(output);
        }

        /// <inheritdoc />
        public void Close()
        {
            m_parent.Close();
        }

        /// <inheritdoc />
        public void Dispose()
        {
            m_parent.Close();
        }
    }
}