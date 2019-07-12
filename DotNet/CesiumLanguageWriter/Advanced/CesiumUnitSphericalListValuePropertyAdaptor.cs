using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumUnitSphericalListValuePropertyWriter"/> to implement
    /// <see cref="ICesiumInterpolatableValuePropertyWriter{TValue}"/> for a list of <see cref="UnitSpherical"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitSphericalListValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumUnitSphericalListValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<UnitSpherical>>
        where TFrom : class, ICesiumUnitSphericalListValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of <see cref="UnitSpherical"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumUnitSphericalListValuePropertyAdaptor([NotNull] TFrom parent,
                                                           [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<UnitSpherical>> writeValueCallback,
                                                           [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}