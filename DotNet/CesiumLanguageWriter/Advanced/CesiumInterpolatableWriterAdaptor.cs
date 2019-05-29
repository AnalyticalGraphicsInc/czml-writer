using System;
using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumInterpolatablePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for a different type of value.
    /// Typically, the class has a method to write values of the new type, but that method is not exposed via an interface.
    /// This class adapts the method to the interface via a callback delegate.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumInterpolatablePropertyWriter"/> to adapt.</typeparam>
    /// <typeparam name="TValue">The type of value to which to adapt the class to write.</typeparam>
    public class CesiumInterpolatableWriterAdaptor<TFrom, TValue> : ICesiumWriterAdaptor<TFrom>, ICesiumInterpolatableValuePropertyWriter<TValue>, ICesiumDeletablePropertyWriter
        where TFrom : class, ICesiumPropertyWriter, ICesiumInterpolatablePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a value of type <typeparamref name="TValue"/>.</param>
        /// <param name="writeSamplesCallback">The callback to write samples of type <typeparamref name="TValue"/>.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumInterpolatableWriterAdaptor([NotNull] TFrom parent,
                                                 [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, TValue> writeValueCallback,
                                                 [NotNull] CesiumWriterAdaptorWriteSamplesCallback<TFrom, TValue> writeSamplesCallback,
                                                 [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
        {
            if (parent == null)
                throw new ArgumentNullException("parent");
            if (writeValueCallback == null)
                throw new ArgumentNullException("writeValueCallback");
            if (writeSamplesCallback == null)
                throw new ArgumentNullException("writeSamplesCallback");
            if (writeDeleteValueCallback == null)
                throw new ArgumentNullException("writeDeleteValueCallback");

            m_parent = parent;
            m_writeValueCallback = writeValueCallback;
            m_writeSamplesCallback = writeSamplesCallback;
            m_writeDeleteValueCallback = writeDeleteValueCallback;
            m_interval = new Lazy<CesiumInterpolatableWriterAdaptor<TFrom, TValue>>(() => new CesiumInterpolatableWriterAdaptor<TFrom, TValue>((TFrom)m_parent.IntervalWriter, m_writeValueCallback, m_writeSamplesCallback, m_writeDeleteValueCallback), false);
        }

        /// <inheritdoc />
        public void Dispose()
        {
            m_parent.Close();
        }

        /// <summary>
        /// Gets the parent being adapted.
        /// </summary>
        public TFrom Parent
        {
            get { return m_parent; }
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
        public void WriteDelete(bool value)
        {
            m_writeDeleteValueCallback(m_parent);
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
        public void WriteForwardExtrapolationType(CesiumExtrapolationType extrapolationType)
        {
            m_parent.WriteForwardExtrapolationType(extrapolationType);
        }

        /// <inheritdoc />
        public void WriteForwardExtrapolationDuration(Duration duration)
        {
            m_parent.WriteForwardExtrapolationDuration(duration);
        }

        /// <inheritdoc />
        public void WriteBackwardExtrapolationType(CesiumExtrapolationType extrapolationType)
        {
            m_parent.WriteBackwardExtrapolationType(extrapolationType);
        }

        /// <inheritdoc />
        public void WriteBackwardExtrapolationDuration(Duration duration)
        {
            m_parent.WriteBackwardExtrapolationDuration(duration);
        }

        /// <inheritdoc />
        public void WriteInterval(JulianDate start, JulianDate stop)
        {
            m_parent.WriteInterval(start, stop);
        }

        /// <summary>
        /// Opens a writer that is used to write information about this property for a single interval.
        /// </summary>
        /// <returns>The writer.</returns>
        [NotNull]
        public ICesiumInterpolatableValuePropertyWriter<TValue> OpenInterval()
        {
            m_interval.Value.Open(m_parent.Output);
            return m_interval.Value;
        }

        ICesiumPropertyWriter ICesiumPropertyWriter.OpenInterval()
        {
            return OpenInterval();
        }

        /// <summary>
        /// Opens a writer that is used to write information about this property for multiple discrete intervals.
        /// </summary>
        /// <returns>The writer.</returns>
        [NotNull]
        public ICesiumInterpolatableIntervalListWriter<TValue> OpenMultipleIntervals()
        {
            return new MultipleIntervalsAdaptor(this, m_parent.OpenMultipleIntervals());
        }

        ICesiumIntervalListWriter ICesiumPropertyWriter.OpenMultipleIntervals()
        {
            return OpenMultipleIntervals();
        }

        /// <inheritdoc />
        public ICesiumPropertyWriter IntervalWriter
        {
            get { return m_interval.Value; }
        }

        /// <inheritdoc />
        public bool ForceInterval
        {
            get { return m_parent.ForceInterval; }
            set { m_parent.ForceInterval = value; }
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

        [NotNull]
        private readonly TFrom m_parent;
        [NotNull]
        private readonly CesiumWriterAdaptorWriteCallback<TFrom, TValue> m_writeValueCallback;
        [NotNull]
        private readonly CesiumWriterAdaptorWriteSamplesCallback<TFrom, TValue> m_writeSamplesCallback;
        [NotNull]
        private readonly CesiumWriterAdaptorWriteDeleteCallback<TFrom> m_writeDeleteValueCallback;
        [NotNull]
        private readonly Lazy<CesiumInterpolatableWriterAdaptor<TFrom, TValue>> m_interval;

        private class MultipleIntervalsAdaptor : ICesiumInterpolatableIntervalListWriter<TValue>
        {
            public MultipleIntervalsAdaptor([NotNull] CesiumInterpolatableWriterAdaptor<TFrom, TValue> intervalAdaptor, [NotNull] ICesiumIntervalListWriter parent)
            {
                if (intervalAdaptor == null)
                    throw new ArgumentNullException("intervalAdaptor");
                if (parent == null)
                    throw new ArgumentNullException("parent");

                m_intervalAdaptor = intervalAdaptor;
                m_parent = parent;
            }

            public void Dispose()
            {
                m_parent.Dispose();
            }

            public ICesiumInterpolatableValuePropertyWriter<TValue> OpenInterval()
            {
                return m_intervalAdaptor.OpenInterval();
            }

            ICesiumPropertyWriter ICesiumIntervalListWriter.OpenInterval()
            {
                return OpenInterval();
            }

            public ICesiumInterpolatableValuePropertyWriter<TValue> OpenInterval(JulianDate start, JulianDate stop)
            {
                ICesiumInterpolatableValuePropertyWriter<TValue> intervalWriter = m_intervalAdaptor.OpenInterval();
                intervalWriter.WriteInterval(start, stop);
                return intervalWriter;
            }

            ICesiumPropertyWriter ICesiumIntervalListWriter.OpenInterval(JulianDate start, JulianDate stop)
            {
                return OpenInterval(start, stop);
            }

            public bool IsOpen
            {
                get { return m_parent.IsOpen; }
            }

            public CesiumOutputStream Output
            {
                get { return m_parent.Output; }
            }

            public void Open(CesiumOutputStream output)
            {
                m_parent.Open(output);
            }

            public void Close()
            {
                m_parent.Close();
            }

            [NotNull]
            private readonly CesiumInterpolatableWriterAdaptor<TFrom, TValue> m_intervalAdaptor;
            [NotNull]
            private readonly ICesiumIntervalListWriter m_parent;
        }
    }
}