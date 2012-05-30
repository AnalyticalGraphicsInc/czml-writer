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
    public class PixelOffsetCesiumWriter : CesiumInterpolatableValuePropertyWriter<Rectangular, PixelOffsetCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>cartesian2</code> property.
        /// </summary>
        public const string Cartesian2PropertyName = "cartesian2";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PixelOffsetCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PixelOffsetCesiumWriter(PixelOffsetCesiumWriter existingInstance)
            : base(existingInstance)
        {
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
        public override void WriteValue(Rectangular value)
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
        public void WriteValue(double x, double y)
        {
            WriteValue(new Rectangular(x, y));
        }

        /// <summary>
        /// Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteValue(IList<JulianDate> dates, IList<Rectangular> values)
        {
            WriteValue(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>cartesian2</code> property.  The <code>cartesian2</code> property specifies the pixel offset specified as a Cartesian `[X, Y]` in viewport coordinates in pixels, where X is pixels to the right and Y is pixels up.  If the array has two elements, the pixel offset is constant.  If it has three or more elements, they are time-tagged samples arranged as `[Time, X, Y, Time, X, Y, Time, X, Y, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public override void WriteValue(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            const string PropertyName = Cartesian2PropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian2(Output, PropertyName, dates, values, startIndex, length);
        }

    }
}
