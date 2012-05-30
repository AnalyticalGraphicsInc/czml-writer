// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Double</code> to a <see cref="CesiumOutputStream" />.  A <code>Double</code> a floating-point value.
    /// </summary>
    public class DoubleCesiumWriter : CesiumInterpolatableValuePropertyWriter<double, DoubleCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>number</code> property.
        /// </summary>
        public const string NumberPropertyName = "number";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public DoubleCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected DoubleCesiumWriter(DoubleCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override DoubleCesiumWriter Clone()
        {
            return new DoubleCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>number</code> property.  The <code>number</code> property specifies the floating-point value. The value may be a single number, in which case the value is constant over the interval, or it may be an array.  If it is an array and the array has one element, the value is constant over the interval. If it has two or more elements, they are time-tagged samples arranged as [Time, Value, Time, Value, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="value">The value.</param>
        public override void WriteValue(double value)
        {
            const string PropertyName = NumberPropertyName;
            if (IsInterval)
                Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the <code>number</code> property.  The <code>number</code> property specifies the floating-point value. The value may be a single number, in which case the value is constant over the interval, or it may be an array.  If it is an array and the array has one element, the value is constant over the interval. If it has two or more elements, they are time-tagged samples arranged as [Time, Value, Time, Value, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public override void WriteValue(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            const string PropertyName = NumberPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteDouble(Output, PropertyName, dates, values, startIndex, length);
        }

    }
}
