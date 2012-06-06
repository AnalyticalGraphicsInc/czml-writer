// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>DirectionList</code> to a <see cref="CesiumOutputStream" />.  A <code>DirectionList</code> a list of directions.
    /// </summary>
    public class DirectionListCesiumWriter : CesiumPropertyWriter<DirectionListCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>unitSpherical</code> property.
        /// </summary>
        public const string UnitSphericalPropertyName = "unitSpherical";

        /// <summary>
        /// The name of the <code>unitCartesian</code> property.
        /// </summary>
        public const string UnitCartesianPropertyName = "unitCartesian";

        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>>> m_asUnitSpherical;
        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>>> m_asUnitCartesian;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public DirectionListCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asUnitSpherical = new Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>>>(CreateUnitSphericalAdaptor, false);
            m_asUnitCartesian = new Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>>>(CreateUnitCartesianAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected DirectionListCesiumWriter(DirectionListCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asUnitSpherical = new Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>>>(CreateUnitSphericalAdaptor, false);
            m_asUnitCartesian = new Lazy<ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>>>(CreateUnitCartesianAdaptor, false);
        }

        /// <inheritdoc />
        public override DirectionListCesiumWriter Clone()
        {
            return new DirectionListCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>unitSpherical</code> property.  The <code>unitSpherical</code> property specifies the list of directions represented as a clock angle and a cone angle, both in radians.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
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
        /// Writes the <code>unitCartesian</code> property.  The <code>unitCartesian</code> property specifies the list of directions represented as Cartesian `[X, Y, Z, X, Y, Z, ...]`.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>UnitSpherical</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>> AsUnitSpherical()
        {
            return m_asUnitSpherical.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<UnitSpherical>> CreateUnitSphericalAdaptor()
        {
            return new CesiumWriterAdaptor<DirectionListCesiumWriter, IEnumerable<UnitSpherical>>(
                this, (me, value) => me.WriteUnitSpherical(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>UnitCartesian</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>> AsUnitCartesian()
        {
            return m_asUnitCartesian.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<UnitCartesian>> CreateUnitCartesianAdaptor()
        {
            return new CesiumWriterAdaptor<DirectionListCesiumWriter, IEnumerable<UnitCartesian>>(
                this, (me, value) => me.WriteUnitCartesian(value));
        }

    }
}
