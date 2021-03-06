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
    /// Writes a <c>Direction</c> to a <see cref="CesiumOutputStream"/>. A <c>Direction</c> is a unit vector, in world coordinates, that defines a direction.
    /// </summary>
    public class DirectionCesiumWriter : CesiumInterpolatablePropertyWriter<DirectionCesiumWriter>, ICesiumDeletablePropertyWriter, ICesiumSphericalValuePropertyWriter, ICesiumUnitSphericalValuePropertyWriter, ICesiumCartesian3ValuePropertyWriter, ICesiumUnitCartesian3ValuePropertyWriter, ICesiumReferenceValuePropertyWriter
    {
        /// <summary>
        /// The name of the <c>spherical</c> property.
        /// </summary>
        [NotNull]
        public const string SphericalPropertyName = "spherical";

        /// <summary>
        /// The name of the <c>unitSpherical</c> property.
        /// </summary>
        [NotNull]
        public const string UnitSphericalPropertyName = "unitSpherical";

        /// <summary>
        /// The name of the <c>cartesian</c> property.
        /// </summary>
        [NotNull]
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <c>unitCartesian</c> property.
        /// </summary>
        [NotNull]
        public const string UnitCartesianPropertyName = "unitCartesian";

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
        private readonly Lazy<CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter>> m_asSpherical;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter>> m_asUnitSpherical;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>> m_asCartesian;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>> m_asUnitCartesian;
        [NotNull]
        [CSToJavaFinalField]
        private readonly Lazy<CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public DirectionCesiumWriter([NotNull] string propertyName)
            : base(propertyName)
        {
            m_asSpherical = CreateAsSpherical();
            m_asUnitSpherical = CreateAsUnitSpherical();
            m_asCartesian = CreateAsCartesian();
            m_asUnitCartesian = CreateAsUnitCartesian();
            m_asReference = CreateAsReference();
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected DirectionCesiumWriter([NotNull] DirectionCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asSpherical = CreateAsSpherical();
            m_asUnitSpherical = CreateAsUnitSpherical();
            m_asCartesian = CreateAsCartesian();
            m_asUnitCartesian = CreateAsUnitCartesian();
            m_asReference = CreateAsReference();
        }

        /// <inheritdoc/>
        public override DirectionCesiumWriter Clone()
        {
            return new DirectionCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the direction specified as a spherical value <c>[Clock, Cone, Magnitude]</c>, with angles in radians and magnitude in meters. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteSpherical(Spherical value)
        {
            const string PropertyName = SphericalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteSpherical(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the direction specified as a spherical value <c>[Clock, Cone, Magnitude]</c>, with angles in radians and magnitude in meters. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values)
        {
            WriteSpherical(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the direction specified as a spherical value <c>[Clock, Cone, Magnitude]</c>, with angles in radians and magnitude in meters. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values, int startIndex, int length)
        {
            const string PropertyName = SphericalPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteSpherical(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the direction specified as a unit spherical value <c>[Clock, Cone]</c>, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
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
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the direction specified as a unit spherical value <c>[Clock, Cone]</c>, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values)
        {
            WriteUnitSpherical(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the direction specified as a unit spherical value <c>[Clock, Cone]</c>, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
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
        /// Writes the value expressed as a <c>cartesian</c>, which is the direction specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>, in world coordinates in meters.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCartesian(Cartesian value)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the direction specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>, in world coordinates in meters.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the direction specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>, in world coordinates in meters.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the direction specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>, in world coordinates in meters.
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
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the direction specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>, in world coordinates in meters.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values)
        {
            WriteUnitCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the direction specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>, in world coordinates in meters.
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
        /// Writes the value expressed as a <c>reference</c>, which is the direction specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the direction specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the direction specified as a reference to another property.
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
        /// Writes the value expressed as a <c>reference</c>, which is the direction specified as a reference to another property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumSphericalValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter> AsSpherical()
        {
            return m_asSpherical.Value;
        }

        [NotNull]
        private Lazy<CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter>> CreateAsSpherical()
        {
            return new Lazy<CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter>>(CreateSpherical, false);
        }

        [NotNull]
        private CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter> CreateSpherical()
        {
            return CesiumValuePropertyAdaptors.CreateSpherical(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumUnitSphericalValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter> AsUnitSpherical()
        {
            return m_asUnitSpherical.Value;
        }

        [NotNull]
        private Lazy<CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter>> CreateAsUnitSpherical()
        {
            return new Lazy<CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter>>(CreateUnitSpherical, false);
        }

        [NotNull]
        private CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter> CreateUnitSpherical()
        {
            return CesiumValuePropertyAdaptors.CreateUnitSpherical(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumCartesian3ValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> AsCartesian()
        {
            return m_asCartesian.Value;
        }

        [NotNull]
        private Lazy<CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>> CreateAsCartesian()
        {
            return new Lazy<CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>>(CreateCartesian3, false);
        }

        [NotNull]
        private CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> CreateCartesian3()
        {
            return CesiumValuePropertyAdaptors.CreateCartesian3(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumUnitCartesian3ValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> AsUnitCartesian()
        {
            return m_asUnitCartesian.Value;
        }

        [NotNull]
        private Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>> CreateAsUnitCartesian()
        {
            return new Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>>(CreateUnitCartesian3, false);
        }

        [NotNull]
        private CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> CreateUnitCartesian3()
        {
            return CesiumValuePropertyAdaptors.CreateUnitCartesian3(this);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumReferenceValuePropertyWriter"/>. Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close"/> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        [NotNull]
        public CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter> AsReference()
        {
            return m_asReference.Value;
        }

        [NotNull]
        private Lazy<CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter>> CreateAsReference()
        {
            return new Lazy<CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter>>(CreateReference, false);
        }

        [NotNull]
        private CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter> CreateReference()
        {
            return CesiumValuePropertyAdaptors.CreateReference(this);
        }

    }
}
