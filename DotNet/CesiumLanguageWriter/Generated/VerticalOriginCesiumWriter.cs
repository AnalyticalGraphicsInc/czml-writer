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
    /// Writes a <c>VerticalOrigin</c> to a <see cref="CesiumOutputStream"/>. A <c>VerticalOrigin</c> is the vertical origin of an element, which can optionally vary over time. It controls whether the element is bottom-, center-, or top-aligned with the <c>position</c>.
    /// </summary>
    public class VerticalOriginCesiumWriter : CesiumPropertyWriter<VerticalOriginCesiumWriter>, ICesiumDeletablePropertyWriter, ICesiumVerticalOriginValuePropertyWriter, ICesiumReferenceValuePropertyWriter
    {
        /// <summary>
        /// The name of the <c>verticalOrigin</c> property.
        /// </summary>
        [NotNull]
        public const string VerticalOriginPropertyName = "verticalOrigin";

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
        private readonly Lazy<CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter>> m_asVerticalOrigin;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public VerticalOriginCesiumWriter([NotNull] string propertyName)
            : base(propertyName)
        {
            m_asVerticalOrigin = CreateAsVerticalOrigin();
            m_asReference = CreateAsReference();
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected VerticalOriginCesiumWriter([NotNull] VerticalOriginCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asVerticalOrigin = CreateAsVerticalOrigin();
            m_asReference = CreateAsReference();
        }

        /// <inheritdoc/>
        public override VerticalOriginCesiumWriter Clone()
        {
            return new VerticalOriginCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>verticalOrigin</c>, which is the vertical origin.
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        public void WriteVerticalOrigin(CesiumVerticalOrigin value)
        {
            const string PropertyName = VerticalOriginPropertyName;
            if (ForceInterval)
            {
                OpenIntervalIfNecessary();
            }
            if (IsInterval)
            {
                Output.WritePropertyName(PropertyName);
            }
            Output.WriteValue(CesiumFormattingHelper.VerticalOriginToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the vertical origin specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the vertical origin specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the vertical origin specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the vertical origin specified as a reference to another property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumVerticalOriginValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter> AsVerticalOrigin()
        {
            return m_asVerticalOrigin.Value;
        }

        [NotNull]
        private Lazy<CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter>> CreateAsVerticalOrigin()
        {
            return new Lazy<CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter>>(CreateVerticalOrigin, false);
        }

        [NotNull]
        private CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter> CreateVerticalOrigin()
        {
            return CesiumValuePropertyAdaptors.CreateVerticalOrigin(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumReferenceValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter> AsReference()
        {
            return m_asReference.Value;
        }

        [NotNull]
        private Lazy<CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter>> CreateAsReference()
        {
            return new Lazy<CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter>>(CreateReference, false);
        }

        [NotNull]
        private CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter> CreateReference()
        {
            return CesiumValuePropertyAdaptors.CreateReference(this);
        }

    }
}
