// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>SimulationDrivenUpdate</code> to a <see cref="CesiumOutputStream" />.  A <code>SimulationDrivenUpdate</code> use this updater when you want to retrieve data for a specified duration.
    /// </summary>
    public class SimulationDrivenUpdateCesiumWriter : CesiumPropertyWriter<SimulationDrivenUpdateCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>duration</code> property.
        /// </summary>
        public const string DurationPropertyName = "duration";

        /// <summary>
        /// The name of the <code>stepsize</code> property.
        /// </summary>
        public const string StepsizePropertyName = "stepsize";

        private readonly Lazy<DoubleCesiumWriter> m_duration = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(DurationPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_stepsize = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(StepsizePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public SimulationDrivenUpdateCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected SimulationDrivenUpdateCesiumWriter(SimulationDrivenUpdateCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override SimulationDrivenUpdateCesiumWriter Clone()
        {
            return new SimulationDrivenUpdateCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>duration</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>duration</code> property defines the duration of time in seconds to request data.
        /// </summary>
        public DoubleCesiumWriter DurationWriter
        {
            get { return m_duration.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>duration</code> property.  The <code>duration</code> property defines the duration of time in seconds to request data.
        /// </summary>
        public DoubleCesiumWriter OpenDurationProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DurationWriter);
        }

        /// <summary>
        /// Writes a value for the <code>duration</code> property as a <code>number</code> value.  The <code>duration</code> property specifies the duration of time in seconds to request data.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteDurationProperty(double value)
        {
            using (var writer = OpenDurationProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>duration</code> property as a <code>number</code> value.  The <code>duration</code> property specifies the duration of time in seconds to request data.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteDurationProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenDurationProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>stepsize</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>stepsize</code> property defines the sampling stepsize.
        /// </summary>
        public DoubleCesiumWriter StepsizeWriter
        {
            get { return m_stepsize.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>stepsize</code> property.  The <code>stepsize</code> property defines the sampling stepsize.
        /// </summary>
        public DoubleCesiumWriter OpenStepsizeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(StepsizeWriter);
        }

        /// <summary>
        /// Writes a value for the <code>stepsize</code> property as a <code>number</code> value.  The <code>stepsize</code> property specifies the sampling stepsize.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteStepsizeProperty(double value)
        {
            using (var writer = OpenStepsizeProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>stepsize</code> property as a <code>number</code> value.  The <code>stepsize</code> property specifies the sampling stepsize.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteStepsizeProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenStepsizeProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

    }
}
