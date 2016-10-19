// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>DoubleList</c> to a <see cref="CesiumOutputStream" />.  A <c>DoubleList</c> is a list of floating-point numbers.
    /// </summary>
    public class DoubleListCesiumWriter : CesiumPropertyWriter<DoubleListCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>array</c> property.
        /// </summary>
        public const string ArrayPropertyName = "array";

        /// <summary>
        /// The name of the <c>references</c> property.
        /// </summary>
        public const string ReferencesPropertyName = "references";

        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<double>>> m_asArray;
        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<Reference>>> m_asReferences;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public DoubleListCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asArray = new Lazy<ICesiumValuePropertyWriter<IEnumerable<double>>>(CreateArrayAdaptor, false);
            m_asReferences = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Reference>>>(CreateReferencesAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected DoubleListCesiumWriter(DoubleListCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asArray = new Lazy<ICesiumValuePropertyWriter<IEnumerable<double>>>(CreateArrayAdaptor, false);
            m_asReferences = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Reference>>>(CreateReferencesAdaptor, false);
        }

        /// <inheritdoc />
        public override DoubleListCesiumWriter Clone()
        {
            return new DoubleListCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>array</c>, which is the list of values specified as an array of numbers.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteArray(IEnumerable<double> values)
        {
            const string PropertyName = ArrayPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteDoubleList(Output, values);
        }

        /// <summary>
        /// Writes the value expressed as a <c>references</c>, which is the list of values specified as references.  Each reference is to a property that defines a single value, which may change with time.
        /// </summary>
        /// <param name="references">The list of references.</param>
        public void WriteReferences(IEnumerable<Reference> references)
        {
            const string PropertyName = ReferencesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReferences(Output, references);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Array</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<double>> AsArray()
        {
            return m_asArray.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<double>> CreateArrayAdaptor()
        {
            return new CesiumWriterAdaptor<DoubleListCesiumWriter, IEnumerable<double>>(this, (me, value) => me.WriteArray(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>References</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<Reference>> AsReferences()
        {
            return m_asReferences.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<Reference>> CreateReferencesAdaptor()
        {
            return new CesiumWriterAdaptor<DoubleListCesiumWriter, IEnumerable<Reference>>(this, (me, value) => me.WriteReferences(value));
        }

    }
}
