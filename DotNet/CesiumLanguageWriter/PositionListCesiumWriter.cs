// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>PositionList</code> to a <see cref="CesiumOutputStream" />.  A <code>PositionList</code> a list of positions.
    /// </summary>
    public class PositionListCesiumWriter : CesiumValuePropertyWriter<IEnumerable<Cartesian>, PositionListCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>referenceFrame</code> property.
        /// </summary>
        public const string ReferenceFramePropertyName = "referenceFrame";

        /// <summary>
        /// The name of the <code>cartesian</code> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <code>cartographicRadians</code> property.
        /// </summary>
        public const string CartographicRadiansPropertyName = "cartographicRadians";

        /// <summary>
        /// The name of the <code>cartographicDegrees</code> property.
        /// </summary>
        public const string CartographicDegreesPropertyName = "cartographicDegrees";

        /// <summary>
        /// The name of the <code>references</code> property.
        /// </summary>
        public const string ReferencesPropertyName = "references";


        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PositionListCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PositionListCesiumWriter(PositionListCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PositionListCesiumWriter Clone()
        {
            return new PositionListCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>referenceFrame</code> property.  The <code>referenceFrame</code> property specifies the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL". In addition, the value of this property can be a hash (#) symbol followed by the ID of another object in the same scope whose "position" and "orientation" properties define the reference frame in which this position is defined.  This property is ignored when specifying position with any type other than cartesian. If this property is not specified, the default reference frame is "FIXED".
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
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the list of positions represented as Cartesian `[X, Y, Z, X, Y, Z, ...]` in the meters relative to the `referenceFrame`.
        /// </summary>
        /// <param name="values">The values.</param>
        public override void WriteValue(IEnumerable<Cartesian> values)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3List(Output, values);
        }

        /// <summary>
        /// Writes the <code>cartographicRadians</code> property.  The <code>cartographicRadians</code> property specifies the list of positions represented as WGS 84 `[Longitude, Latitude, Height, Longitude, Latitude, Height, ...]` where longitude and latitude are in radians and height is in meters.
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
        /// Writes the <code>cartographicDegrees</code> property.  The <code>cartographicDegrees</code> property specifies the list of positions represented as WGS 84 `[Longitude, Latitude, Height, Longitude, Latitude, Height, ...]` where longitude and latitude are in degrees and height is in meters.
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
        /// Writes the <code>references</code> property.  The <code>references</code> property specifies the list of positions specified as references.  Each reference is to a property that defines a single position, possible as it changes with time.
        /// </summary>
        /// <param name="references">The list of references.</param>
        public void WriteReferences(IEnumerable<string> references)
        {
            const string PropertyName = ReferencesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReferences(Output, references);
        }

    }
}
