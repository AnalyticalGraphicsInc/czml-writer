// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Orientation</code> to a <see cref="CesiumOutputStream" />.  A <code>Orientation</code> defines an orientation.  An orientation is a rotation that takes a vector expressed in the "body" axes of the object and transforms it to the set of axes identified by the `axes` property.
    /// </summary>
    public class OrientationCesiumWriter : CesiumInterpolatableValuePropertyWriter<UnitQuaternion, OrientationCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>axes</code> property.
        /// </summary>
        public const string AxesPropertyName = "axes";

        /// <summary>
        /// The name of the <code>unitQuaternion</code> property.
        /// </summary>
        public const string UnitQuaternionPropertyName = "unitQuaternion";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public OrientationCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected OrientationCesiumWriter(OrientationCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override OrientationCesiumWriter Clone()
        {
            return new OrientationCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>axes</code> property.  The <code>axes</code> property specifies tODO
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteAxes(string value)
        {
            const string PropertyName = AxesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
        /// </summary>
        /// <param name="value">The value.</param>
        public override void WriteValue(UnitQuaternion value)
        {
            const string PropertyName = UnitQuaternionPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitQuaternion(Output, value);
        }

        /// <summary>
        /// Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
        /// </summary>
        /// <param name="dates">The dates at which the rotation is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteValue(IList<JulianDate> dates, IList<UnitQuaternion> values)
        {
            WriteValue(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>unitQuaternion</code> property.  The <code>unitQuaternion</code> property specifies tODO
        /// </summary>
        /// <param name="dates">The dates at which the rotation is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public override void WriteValue(IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length)
        {
            const string PropertyName = UnitQuaternionPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitQuaternion(Output, PropertyName, dates, values, startIndex, length);
        }

    }
}
