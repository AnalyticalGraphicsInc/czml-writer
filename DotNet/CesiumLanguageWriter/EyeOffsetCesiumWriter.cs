// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>EyeOffset</code> to a <see cref="CesiumOutputStream" />.  A <code>EyeOffset</code> defines an offset in eye coordinates which can optionally vary over time.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis poitns up, and the Z-axis points into the screen.
    /// </summary>
    public class EyeOffsetCesiumWriter : CesiumInterpolatableValuePropertyWriter<Cartesian, EyeOffsetCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>cartesian</code> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public EyeOffsetCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected EyeOffsetCesiumWriter(EyeOffsetCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override EyeOffsetCesiumWriter Clone()
        {
            return new EyeOffsetCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the eye offset specified as a Cartesian `[X, Y, Z]` position in eye coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="value">The value.</param>
        public override void WriteValue(Cartesian value)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the eye offset specified as a Cartesian `[X, Y, Z]` position in eye coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteValue(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteValue(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the eye offset specified as a Cartesian `[X, Y, Z]` position in eye coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public override void WriteValue(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

    }
}
