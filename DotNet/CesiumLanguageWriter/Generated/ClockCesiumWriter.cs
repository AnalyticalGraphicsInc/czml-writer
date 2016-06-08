// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Clock</code> to a <see cref="CesiumOutputStream" />.  A <code>Clock</code> is initial settings for a simulated clock when a document is loaded.  The start and stop time are configured using the interval property.
    /// </summary>
    public class ClockCesiumWriter : CesiumPropertyWriter<ClockCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>currentTime</code> property.
        /// </summary>
        public const string CurrentTimePropertyName = "currentTime";

        /// <summary>
        /// The name of the <code>multiplier</code> property.
        /// </summary>
        public const string MultiplierPropertyName = "multiplier";

        /// <summary>
        /// The name of the <code>range</code> property.
        /// </summary>
        public const string RangePropertyName = "range";

        /// <summary>
        /// The name of the <code>step</code> property.
        /// </summary>
        public const string StepPropertyName = "step";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ClockCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected ClockCesiumWriter(ClockCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ClockCesiumWriter Clone()
        {
            return new ClockCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>currentTime</code>, which is the current time, specified in ISO8601 format.
        /// </summary>
        /// <param name="value">The time.</param>
        public void WriteCurrentTime(JulianDate value)
        {
            const string PropertyName = CurrentTimePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteDate(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>multiplier</code>, which is the multiplier.  When `step` is set to `TICK_DEPENDENT`, this is the number of seconds to advance each tick.  When `step` is set to `SYSTEM_CLOCK_DEPENDENT`, this is multiplied by the elapsed system time between ticks.  This value is ignored in `SYSTEM_CLOCK` mode.  The default value is 1.0.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteMultiplier(double value)
        {
            const string PropertyName = MultiplierPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>range</code>, which is the behavior when the current time reaches its start or end times.  The default value is `LOOP_STOP`.
        /// </summary>
        /// <param name="value">The clock range.</param>
        public void WriteRange(ClockRange value)
        {
            const string PropertyName = RangePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.ClockRangeToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <code>step</code>, which is how the current time advances each tick.  The default value is `SYSTEM_CLOCK_MULTIPLIER`.
        /// </summary>
        /// <param name="value">The clock step.</param>
        public void WriteStep(ClockStep value)
        {
            const string PropertyName = StepPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.ClockStepToString(value));
        }

    }
}
