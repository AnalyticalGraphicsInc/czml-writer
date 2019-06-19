using System.Collections.Generic;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Adapts a class that implements <see cref="ICesiumSphericalListValuePropertyWriter"/> to implement
    /// <see cref="ICesiumPropertyWriter"/> for a list of <see cref="Spherical"/> values.
    /// </summary>
    /// <typeparam name="TFrom">The class that implements <see cref="ICesiumSphericalListValuePropertyWriter"/> to adapt.</typeparam>
    public class CesiumSphericalListValuePropertyAdaptor<TFrom> : CesiumWriterAdaptor<TFrom, IEnumerable<Spherical>>
        where TFrom : class, ICesiumSphericalListValuePropertyWriter
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="parent">The instance to wrap.</param>
        /// <param name="writeValueCallback">The callback to write a list of <see cref="Spherical"/> values.</param>
        /// <param name="writeDeleteValueCallback">The callback to write an indication that the client should delete existing data.</param>
        public CesiumSphericalListValuePropertyAdaptor([NotNull] TFrom parent,
                                                       [NotNull] CesiumWriterAdaptorWriteCallback<TFrom, IEnumerable<Spherical>> writeValueCallback,
                                                       [NotNull] CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback)
            : base(parent, writeValueCallback, writeDeleteValueCallback)
        {
        }
    }
}