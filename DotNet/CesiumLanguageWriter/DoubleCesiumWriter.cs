using System;
using System.Collections.Generic;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Time;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write a double-precision, floating-point property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class DoubleCesiumWriter : CesiumInterpolatableValuePropertyWriter<double, DoubleCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public DoubleCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private DoubleCesiumWriter(DoubleCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override DoubleCesiumWriter Clone()
        {
            return new DoubleCesiumWriter(this);
        }

        /// <inheritdoc />
        public override void WriteValue(double value)
        {
            if (IsInterval)
                Output.WritePropertyName("number");
            Output.WriteValue(value);
        }

        /// <inheritdoc />
        public override void WriteValue(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            if (dates.Count != values.Count)
                throw new ArgumentException(CesiumLocalization.MismatchedNumberOfDatesAndValues, "values");

            JulianDate epoch = GetAndWriteEpoch(dates, startIndex, length);

            Output.WritePropertyName("number");
            Output.WriteStartSequence();
            int last = startIndex + length;
            for (int i = startIndex; i < last; ++i)
            {
                Output.WriteValue(epoch.SecondsDifference(dates[i]));
                Output.WriteValue(values[i]);
                Output.WriteLineBreak();
            }
            Output.WriteEndSequence();
        }
    }
}
