﻿// <auto-generated>
// This file was generated automatically by GenerateFromSchema. Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer
// </auto-generated>

using CesiumLanguageWriter.Advanced;
using System;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>HeightReference</c> to a <see cref="CesiumOutputStream"/>. A <c>HeightReference</c> is the height reference of an object, which indicates if the object's position is relative to terrain or not.
    /// </summary>
    public class HeightReferenceCesiumWriter : CesiumPropertyWriter<HeightReferenceCesiumWriter>, ICesiumDeletablePropertyWriter, ICesiumHeightReferenceValuePropertyWriter, ICesiumReferenceValuePropertyWriter
    {
        /// <summary>
        /// The name of the <c>heightReference</c> property.
        /// </summary>
        [NotNull]
        public const string HeightReferencePropertyName = "heightReference";

        /// <summary>
        /// The name of the <c>reference</c> property.
        /// </summary>
        [NotNull]
        public const string ReferencePropertyName = "reference";

        /// <summary>
        /// The name of the <c>delete</c> property.
        /// </summary>
        [NotNull]
        public const string DeletePropertyName = "delete";

        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>> m_asHeightReference;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public HeightReferenceCesiumWriter([NotNull] string propertyName)
            : base(propertyName)
        {
            m_asHeightReference = CreateAsHeightReference();
            m_asReference = CreateAsReference();
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected HeightReferenceCesiumWriter([NotNull] HeightReferenceCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asHeightReference = CreateAsHeightReference();
            m_asReference = CreateAsReference();
        }

        /// <inheritdoc/>
        public override HeightReferenceCesiumWriter Clone()
        {
            return new HeightReferenceCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>heightReference</c>, which is the height reference.
        /// </summary>
        /// <param name="value">The height reference.</param>
        public void WriteHeightReference(CesiumHeightReference value)
        {
            const string PropertyName = HeightReferencePropertyName;
            if (ForceInterval)
            {
                OpenIntervalIfNecessary();
            }
            if (IsInterval)
            {
                Output.WritePropertyName(PropertyName);
            }
            Output.WriteValue(CesiumFormattingHelper.HeightReferenceToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the height reference specified as a reference to another property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteReference(Reference value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the height reference specified as a reference to another property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteReference(string value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the height reference specified as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteReference(string identifier, string propertyName)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyName);
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the height reference specified as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteReference(string identifier, string[] propertyNames)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyNames);
        }

        /// <summary>
        /// Writes the value expressed as a <c>delete</c>, which is whether the client should delete existing samples or interval data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteDelete(bool value)
        {
            const string PropertyName = DeletePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumHeightReferenceValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> AsHeightReference()
        {
            return m_asHeightReference.Value;
        }

        [NotNull]
        private Lazy<CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>> CreateAsHeightReference()
        {
            return new Lazy<CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>>(CreateHeightReference, false);
        }

        [NotNull]
        private CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> CreateHeightReference()
        {
            return CesiumValuePropertyAdaptors.CreateHeightReference(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumReferenceValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> AsReference()
        {
            return m_asReference.Value;
        }

        [NotNull]
        private Lazy<CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>> CreateAsReference()
        {
            return new Lazy<CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>>(CreateReference, false);
        }

        [NotNull]
        private CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> CreateReference()
        {
            return CesiumValuePropertyAdaptors.CreateReference(this);
        }

    }
}
