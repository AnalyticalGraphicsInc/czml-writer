// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>PositionList</c> to a <see cref="CesiumOutputStream" />.  A <c>PositionList</c> is a list of positions.
    /// </summary>
    public class PositionListCesiumWriter : CesiumPropertyWriter<PositionListCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>referenceFrame</c> property.
        /// </summary>
        public const string ReferenceFramePropertyName = "referenceFrame";

        /// <summary>
        /// The name of the <c>cartesian</c> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <c>cartographicRadians</c> property.
        /// </summary>
        public const string CartographicRadiansPropertyName = "cartographicRadians";

        /// <summary>
        /// The name of the <c>cartographicDegrees</c> property.
        /// </summary>
        public const string CartographicDegreesPropertyName = "cartographicDegrees";

        /// <summary>
        /// The name of the <c>references</c> property.
        /// </summary>
        public const string ReferencesPropertyName = "references";

        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartesian>>> m_asCartesian;
        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartographic>>> m_asCartographicRadians;
        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartographic>>> m_asCartographicDegrees;
        private readonly Lazy<ICesiumValuePropertyWriter<IEnumerable<Reference>>> m_asReferences;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PositionListCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asCartesian = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartesian>>>(CreateCartesianAdaptor, false);
            m_asCartographicRadians = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartographic>>>(CreateCartographicRadiansAdaptor, false);
            m_asCartographicDegrees = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartographic>>>(CreateCartographicDegreesAdaptor, false);
            m_asReferences = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Reference>>>(CreateReferencesAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PositionListCesiumWriter(PositionListCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asCartesian = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartesian>>>(CreateCartesianAdaptor, false);
            m_asCartographicRadians = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartographic>>>(CreateCartographicRadiansAdaptor, false);
            m_asCartographicDegrees = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Cartographic>>>(CreateCartographicDegreesAdaptor, false);
            m_asReferences = new Lazy<ICesiumValuePropertyWriter<IEnumerable<Reference>>>(CreateReferencesAdaptor, false);
        }

        /// <inheritdoc />
        public override PositionListCesiumWriter Clone()
        {
            return new PositionListCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>referenceFrame</c>, which is the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL".  If not specified, the default value is FIXED.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteReferenceFrame(string value)
        {
            const string PropertyName = ReferenceFramePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the list of positions specified as three-dimensional Cartesian values, `[X, Y, Z, X, Y, Z, ...]`, in meters relative to the `referenceFrame`.
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
        /// Writes the value expressed as a <c>cartographicRadians</c>, which is the list of positions specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height, Longitude, Latitude, Height, ...]`, where Longitude and Latitude are in radians and Height is in meters.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteCartographicRadians(IEnumerable<Cartographic> values)
        {
            const string PropertyName = CartographicRadiansPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographicList(Output, values);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartographicDegrees</c>, which is the list of positions specified in Cartographic WGS84 coordinates, `[Longitude, Latitude, Height, Longitude, Latitude, Height, ...]`, where Longitude and Latitude are in degrees and Height is in meters.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteCartographicDegrees(IEnumerable<Cartographic> values)
        {
            const string PropertyName = CartographicDegreesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographicList(Output, values);
        }

        /// <summary>
        /// Writes the value expressed as a <c>references</c>, which is the list of positions specified as references.  Each reference is to a property that defines a single position, which may change with time.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Cartesian</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<Cartesian>> AsCartesian()
        {
            return m_asCartesian.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<Cartesian>> CreateCartesianAdaptor()
        {
            return new CesiumWriterAdaptor<PositionListCesiumWriter, IEnumerable<Cartesian>>(this, (me, value) => me.WriteCartesian(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>CartographicRadians</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<Cartographic>> AsCartographicRadians()
        {
            return m_asCartographicRadians.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<Cartographic>> CreateCartographicRadiansAdaptor()
        {
            return new CesiumWriterAdaptor<PositionListCesiumWriter, IEnumerable<Cartographic>>(this, (me, value) => me.WriteCartographicRadians(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>CartographicDegrees</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<IEnumerable<Cartographic>> AsCartographicDegrees()
        {
            return m_asCartographicDegrees.Value;
        }

        private ICesiumValuePropertyWriter<IEnumerable<Cartographic>> CreateCartographicDegreesAdaptor()
        {
            return new CesiumWriterAdaptor<PositionListCesiumWriter, IEnumerable<Cartographic>>(this, (me, value) => me.WriteCartographicDegrees(value));
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
            return new CesiumWriterAdaptor<PositionListCesiumWriter, IEnumerable<Reference>>(this, (me, value) => me.WriteReferences(value));
        }

    }
}
