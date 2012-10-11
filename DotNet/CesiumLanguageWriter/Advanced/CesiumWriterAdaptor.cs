﻿using System;

#if StkComponents
using AGI.Foundation.Time;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium.Advanced
#else
namespace CesiumLanguageWriter.Advanced
#endif
{
    /// <summary>
    /// A callback to write a value to a <see cref="CesiumOutputStream"/> using a given
    /// wrapped property writer.
    /// </summary>
    /// <typeparam name="TWrappedWriter">The type of the wrapped writer.</typeparam>
    /// <typeparam name="TValue">The type of the value to write.</typeparam>
    /// <param name="wrappedWriter">The wrapper writer.</param>
    /// <param name="value">The value.</param>
    public delegate void CesiumWriterAdaptorWriteCallback<TWrappedWriter, TValue>(TWrappedWriter wrappedWriter, TValue value);

    /// <summary>
    /// Adapts a class derived from <see cref="CesiumPropertyWriter{TDerived}"/> to implement
    /// <see cref="ICesiumValuePropertyWriter{TValue}"/> for a different type of value.  Typically, the
    /// class has a method to write values of the new type, but that method is not exposed via an interface.
    /// This class adapts the method to the interface via a callback delegate.
    /// </summary>
    /// <typeparam name="TFrom">The class derived from <see cref="CesiumPropertyWriter{TDerived}"/> to adapt.</typeparam>
    /// <typeparam name="TValue">The type of value to which to adapt the class to write.</typeparam>
    public class CesiumWriterAdaptor<TFrom, TValue> : ICesiumValuePropertyWriter<TValue>
        where TFrom : ICesiumPropertyWriter
    {
        private readonly TFrom m_parent;
        private readonly CesiumWriterAdaptorWriteCallback<TFrom, TValue> m_writeValueCallback;
        private readonly Lazy<CesiumWriterAdaptor<TFrom, TValue>> m_interval;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write values of type <typeparamref name="TValue"/>.</param>
        public CesiumWriterAdaptor(TFrom parent, CesiumWriterAdaptorWriteCallback<TFrom, TValue> writeValueCallback)
        {
            if (parent == null)
                throw new ArgumentNullException("parent");
            if (writeValueCallback == null)
                throw new ArgumentNullException("writeValueCallback");

            m_parent = parent;
            m_writeValueCallback = writeValueCallback;
            m_interval = new Lazy<CesiumWriterAdaptor<TFrom, TValue>>(() => new CesiumWriterAdaptor<TFrom, TValue>((TFrom)m_parent.IntervalWriter, m_writeValueCallback), false);
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