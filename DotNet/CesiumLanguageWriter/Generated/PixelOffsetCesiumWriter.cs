// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>PixelOffset</code> to a <see cref="CesiumOutputStream" />.  A <code>PixelOffset</code> defines a pixel offset in viewport coordinates.  A pixel offset is the number of pixels up and to the right to place an element relative to an origin.
    /// </summary>
    public class PixelOffsetCesiumWriter : CesiumInterpolatablePropertyWriter<PixelOffsetCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>cartesian2</code> property.
        /// </summary>
        public const string Cartesian2PropertyName = "cartesian2";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>> m_asCartesian2;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PixelOffsetCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asCartesian2 = new Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>>(CreateCartesian2Adaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PixelOffsetCesiumWriter(PixelOffsetCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asCartesian2 = new Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>>(CreateCartesian2Adaptor, false);
        }

        /// <inheritdoc />
        public override PixelOffsetCesiumWriter Clone()
        {
            return new PixelOffsetCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCartesian2(Rectangular value)
        {
            const string PropertyName = Cartesian2PropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian2(Output, value);
        }

        /// <summary>
        /// Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WriteCartesian2(double x, double y)
        {
            WriteCartesian2(new Rectangular(x, y));
        }

        /// <summary>
        /// Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian2(IList<JulianDate> dates, IList<Rectangular> values)
        {
            WriteCartesian2(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteCartesian2(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            const string PropertyName = Cartesian2PropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian2(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteReference(Reference value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteReference(string value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference.
        /// </summary>
        /// <param name="id">The earliest date of the interval.</param>
        /// <param name="path">The latest date of the interval.</param>
        public void WriteReference(string id, string path)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, id, path);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Cartesian2</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Rectangular> AsCartesian2()
        {
            return m_asCartesian2.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Rectangular> CreateCartesian2Adaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<PixelOffsetCesiumWriter, Rectangular>(
                this, (me, value) => me.WriteCartesian2(value), (PixelOffsetCesiumWriter me, IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length) => me.WriteCartesian2(dates, values, startIndex, length));
        }

    }
}
