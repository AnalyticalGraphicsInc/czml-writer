using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class derived from <see cref="CesiumInterpolatablePropertyWriter{TDerived}"/> to implement
    /// <see cref="ICesiumValuePropertyWriter{TValue}"/> for a different type of value.  Typically, the
    /// class has a method to write values of the new type, but that method is not exposed via an interface.
    /// This class adapts the method to the interface via a callback delegate.
    /// </summary>
    /// <typeparam name="TFrom">The class derived from <see cref="CesiumInterpolatablePropertyWriter{TDerived}"/> to adapt.</typeparam>
    /// <typeparam name="TValue">The type of value to which to adapt the class to write.</typeparam>
    public class CesiumInterpolatableWriterAdaptor<TFrom, TValue> : ICesiumInterpolatableValuePropertyWriter<TValue>
        where TFrom : class, ICesiumPropertyWriter, ICesiumInterpolationInformationWriter
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

        /// <inheritdoc />
        public ICesiumInterpolatableValuePropertyWriter<TValue> OpenInterval()
        {
            m_interval.Value.Open(m_parent.Output);
            return m_interval.Value;
        }

        ICesiumPropertyWriter ICesiumPropertyWriter.OpenInterval()
        {
            return OpenInterval();
        }

        /// <inheritdoc />
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

        /// <inheritdoc />
        public void Dispose()
        {
            m_parent.Close();
        }

        private class MultipleIntervalsAdaptor : ICesiumInterpolatableIntervalListWriter<TValue>
        {
            private readonly CesiumInterpolatableWriterAdaptor<TFrom, TValue> m_intervalAdaptor;
            private readonly ICesiumIntervalListWriter m_parent;

            public MultipleIntervalsAdaptor(CesiumInterpolatableWriterAdaptor<TFrom, TValue> intervalAdaptor, ICesiumIntervalListWriter parent)
            {
                m_intervalAdaptor = intervalAdaptor;
                m_parent = parent;
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

            public void Dispose()
            {
                m_parent.Dispose();
            }
        }
    }
}