using System;
using System.Collections.Generic;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Coordinates;
using AGI.Foundation.Infrastructure;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write the Cartesian3 positions property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class PositionListCesiumWriter : CesiumValuePropertyWriter<IEnumerable<Cartesian3>, PositionListCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public PositionListCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private PositionListCesiumWriter(PositionListCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PositionListCesiumWriter Clone()
        {
            return new PositionListCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value of the property for this interval as an array of <see cref="Cartesian3"/>
        /// </summary>
        /// <param name="positions">The positions.</param>
        public override void WriteValue(IEnumerable<Cartesian3> positions)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("Cartesian3");
            Output.WriteStartSequence();
            foreach (var position in positions)
            {
                Output.WriteValue(position.X);
                Output.WriteValue(position.Y);
                Output.WriteValue(position.Z);
            }
            Output.WriteEndSequence();
        }

        /// <summary>
        /// Writes the value of the property for this interval as an array of <see cref="Cartographic"/>
        /// </summary>
        /// <param name="positions">The positions.</param>
        public void WriteValue(IEnumerable<Cartographic> positions)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("cartographicRadians");
            Output.WriteStartSequence();
            foreach (var position in positions)
            {
                Output.WriteValue(position.Longitude);
                Output.WriteValue(position.Latitude);
                Output.WriteValue(position.Height);
            }
            Output.WriteEndSequence();
        }
    }
}
