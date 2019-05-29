using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumUnitCartesian3ListValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for a list of <see cref="UnitCartesian"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitCartesian3ListValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumUnitCartesian3ListValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<UnitCartesian>>
        where TFrom : class, ICesiumUnitCartesian3ListValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of <see cref="UnitCartesian"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumUnitCartesian3ListValuePropertyAdaptor([NotNull] TFrom parent,
                                                            [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<UnitCartesian>> writeValueCallback,
                                                            [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}