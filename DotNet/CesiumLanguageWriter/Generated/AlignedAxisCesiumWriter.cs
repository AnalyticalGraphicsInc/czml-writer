﻿// <auto-generated>
// This file was generated automatically by GenerateFromSchema. Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer
// </auto-generated>

using CesiumLanguageWriter.Advanced;
using System;
using JetBrains.Annotations;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>AlignedAxis</c> to a <see cref="CesiumOutputStream"/>. A <c>AlignedAxis</c> is an aligned axis represented by a unit vector which can optionally vary over time.
    /// </summary>
    public class AlignedAxisCesiumWriter : CesiumInterpolatablePropertyWriter<AlignedAxisCesiumWriter>, ICesiumDeletablePropertyWriter, ICesiumUnitCartesian3ValuePropertyWriter, ICesiumUnitSphericalValuePropertyWriter, ICesiumReferenceValuePropertyWriter, ICesiumVelocityReferenceValuePropertyWriter
    {
        /// <summary>
        /// The name of the <c>unitCartesian</c> property.
        /// </summary>
        [NotNull]
        public const string UnitCartesianPropertyName = "unitCartesian";

        /// <summary>
        /// The name of the <c>unitSpherical</c> property.
        /// </summary>
        [NotNull]
        public const string UnitSphericalPropertyName = "unitSpherical";

        /// <summary>
        /// The name of the <c>reference</c> property.
        /// </summary>
        [NotNull]
        public const string ReferencePropertyName = "reference";

        /// <summary>
        /// The name of the <c>velocityReference</c> property.
        /// </summary>
        [NotNull]
        public const string VelocityReferencePropertyName = "velocityReference";

        /// <summary>
        /// The name of the <c>delete</c> property.
        /// </summary>
        [NotNull]
        public const string DeletePropertyName = "delete";

        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter>> m_asUnitCartesian;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter>> m_asUnitSpherical;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>> m_asReference;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>> m_asVelocityReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public AlignedAxisCesiumWriter([NotNull] string propertyName)
            : base(propertyName)
        {
            m_asUnitCartesian = CreateAsUnitCartesian();
            m_asUnitSpherical = CreateAsUnitSpherical();
            m_asReference = CreateAsReference();
            m_asVelocityReference = CreateAsVelocityReference();
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected AlignedAxisCesiumWriter([NotNull] AlignedAxisCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asUnitCartesian = CreateAsUnitCartesian();
            m_asUnitSpherical = CreateAsUnitSpherical();
            m_asReference = CreateAsReference();
            m_asVelocityReference = CreateAsVelocityReference();
        }

        /// <inheritdoc/>
        public override AlignedAxisCesiumWriter Clone()
        {
            return new AlignedAxisCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the axis specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>, in world coordinates.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUnitCartesian(UnitCartesian value)
        {
            const string PropertyName = UnitCartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the axis specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>, in world coordinates.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values)
        {
            WriteUnitCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the axis specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>, in world coordinates.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values, int startIndex, int length)
        {
            const string PropertyName = UnitCartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the axis specified as a unit spherical value <c>[Clock, Cone]</c>, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUnitSpherical(UnitSpherical value)
        {
            const string PropertyName = UnitSphericalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitSpherical(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the axis specified as a unit spherical value <c>[Clock, Cone]</c>, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values)
        {
            WriteUnitSpherical(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the axis specified as a unit spherical value <c>[Clock, Cone]</c>, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values, int startIndex, int length)
        {
            const string PropertyName = UnitSphericalPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitSpherical(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>reference</c>, which is the axis specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the axis specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the axis specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the axis specified as a reference to another property.
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
        /// Writes the value expressed as a <c>velocityReference</c>, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a <c>position</c> property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteVelocityReference(Reference value)
        {
            const string PropertyName = VelocityReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>velocityReference</c>, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a <c>position</c> property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteVelocityReference(string value)
        {
            const string PropertyName = VelocityReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>velocityReference</c>, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a <c>position</c> property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteVelocityReference(string identifier, string propertyName)
        {
            const string PropertyName = VelocityReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyName);
        }

        /// <summary>
        /// Writes the value expressed as a <c>velocityReference</c>, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a <c>position</c> property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteVelocityReference(string identifier, string[] propertyNames)
        {
            const string PropertyName = VelocityReferencePropertyName;
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumUnitCartesian3ValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter> AsUnitCartesian()
        {
            return m_asUnitCartesian.Value;
        }

        [NotNull]
        private Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter>> CreateAsUnitCartesian()
        {
            return new Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter>>(CreateUnitCartesian3, false);
        }

        [NotNull]
        private CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter> CreateUnitCartesian3()
        {
            return CesiumValuePropertyAdaptors.CreateUnitCartesian3(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumUnitSphericalValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter> AsUnitSpherical()
        {
            return m_asUnitSpherical.Value;
        }

        [NotNull]
        private Lazy<CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter>> CreateAsUnitSpherical()
        {
            return new Lazy<CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter>>(CreateUnitSpherical, false);
        }

        [NotNull]
        private CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter> CreateUnitSpherical()
        {
            return CesiumValuePropertyAdaptors.CreateUnitSpherical(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumReferenceValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> AsReference()
        {
            return m_asReference.Value;
        }

        [NotNull]
        private Lazy<CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>> CreateAsReference()
        {
            return new Lazy<CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>>(CreateReference, false);
        }

        [NotNull]
        private CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> CreateReference()
        {
            return CesiumValuePropertyAdaptors.CreateReference(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumVelocityReferenceValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> AsVelocityReference()
        {
            return m_asVelocityReference.Value;
        }

        [NotNull]
        private Lazy<CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>> CreateAsVelocityReference()
        {
            return new Lazy<CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>>(CreateVelocityReference, false);
        }

        [NotNull]
        private CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> CreateVelocityReference()
        {
            return CesiumValuePropertyAdaptors.CreateVelocityReference(this);
        }

    }
}
