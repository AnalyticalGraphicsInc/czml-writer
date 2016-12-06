// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>DirectionList</c> to a <see cref="CesiumOutputStream" />.  A <c>DirectionList</c> is a list of directions.
    /// </summary>
    public class DirectionListCesiumWriter : CesiumPropertyWriter<DirectionListCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>spherical</c> property.
        /// </summary>
        public const string SphericalPropertyName = "spherical";

        /// <summary>
        /// The name of the <c>unitSpherical</c> property.
        /// </summary>
        public const string UnitSphericalPropertyName = "unitSpherical";

        /// <summary>
        /// The name of the <c>cartesian</c> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <c>unitCartesian</c> property.
        /// </summary>
        public const string UnitCartesianPropertyName = "unitCartesian";

        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<Spherical>>> m_asSpherical;
        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>>> m_asUnitSpherical;
        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartesian>>> m_asCartesian;
        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>>> m_asUnitCartesian;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public DirectionListCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asSpherical = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Spherical>>>(CreateSphericalAdaptor, false);
            m_asUnitSpherical = new Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>>>(CreateUnitSphericalAdaptor, false);
            m_asCartesian = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartesian>>>(CreateCartesianAdaptor, false);
            m_asUnitCartesian = new Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>>>(CreateUnitCartesianAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected DirectionListCesiumWriter(DirectionListCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asSpherical = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Spherical>>>(CreateSphericalAdaptor, false);
            m_asUnitSpherical = new Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>>>(CreateUnitSphericalAdaptor, false);
            m_asCartesian = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartesian>>>(CreateCartesianAdaptor, false);
            m_asUnitCartesian = new Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>>>(CreateUnitCartesianAdaptor, false);
        }

        /// <inheritdoc />
        public override DirectionListCesiumWriter Clone()
        {
            return new DirectionListCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the list of directions specified as spherical values <c>[Clock, Cone, Magnitude, Clock, Cone, Magnitude, ...]</c>, with angles in radians and magnitude in meters.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteSpherical(IEnumerable<Spherical> values)
        {
            const string PropertyName = SphericalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteSphericalList(Output, values);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the list of directions specified as unit spherical values <c>[Clock, Cone, Clock, Cone, ...]</c>, in radians.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteUnitSpherical(IEnumerable<UnitSpherical> values)
        {
            const string PropertyName = UnitSphericalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitSphericalList(Output, values);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the list of directions specified as three-dimensional Cartesian values <c>[X, Y, Z, X, Y, Z, ...]</c>, in world coordinates in meters.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteCartesian(IEnumerable<Cartesian> values)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3List(Output, values);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the list of directions specified as three-dimensional unit magnitude Cartesian values, <c>[X, Y, Z, X, Y, Z, ...]</c>, in world coordinates in meters.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteUnitCartesian(IEnumerable<UnitCartesian> values)
        {
            const string PropertyName = UnitCartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitCartesian3List(Output, values);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Spherical</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<Spherical>> AsSpherical()
        {
            return m_asSpherical.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<Spherical>> CreateSphericalAdaptor()
        {
            return new CesiumWriterAdaptor<DirectionListCesiumWriter, IEnumerable<Spherical>>(this, (me, value) => me.WriteSpherical(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>UnitSpherical</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>> AsUnitSpherical()
        {
            return m_asUnitSpherical.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>> CreateUnitSphericalAdaptor()
        {
            return new CesiumWriterAdaptor<DirectionListCesiumWriter, IEnumerable<UnitSpherical>>(this, (me, value) => me.WriteUnitSpherical(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Cartesian</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<Cartesian>> AsCartesian()
        {
            return m_asCartesian.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<Cartesian>> CreateCartesianAdaptor()
        {
            return new CesiumWriterAdaptor<DirectionListCesiumWriter, IEnumerable<Cartesian>>(this, (me, value) => me.WriteCartesian(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>UnitCartesian</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>> AsUnitCartesian()
        {
            return m_asUnitCartesian.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>> CreateUnitCartesianAdaptor()
        {
            return new CesiumWriterAdaptor<DirectionListCesiumWriter, IEnumerable<UnitCartesian>>(this, (me, value) => me.WriteUnitCartesian(value));
        }

    }
}
