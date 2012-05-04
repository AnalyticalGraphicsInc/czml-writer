using System.Collections.Generic;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Coordinates;
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
    /// A <see cref="CesiumPropertyWriter{T}"/> used to write the unitspherical coordinates property that
    /// optionally has different values over different intervals of time.  Instances of this class generally should not
    /// be constructed directly, but should instead be obtained from a <see cref="CesiumPropertyWriter{T}"/>.
    /// </summary>
    public class DirectionListCesiumWriter : CesiumValuePropertyWriter<IEnumerable<UnitSpherical>, DirectionListCesiumWriter>
    {
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public DirectionListCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private DirectionListCesiumWriter(DirectionListCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override DirectionListCesiumWriter Clone()
        {
            return new DirectionListCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value of the property for this interval as an array of <see cref="UnitSpherical"/>
        /// </summary>
        /// <param name="coordinates">The coordinates.</param>
        public override void WriteValue(IEnumerable<UnitSpherical> coordinates)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("unitSpherical");
            Output.WriteStartSequence();
            foreach (var coordinate in coordinates)
            {
                Output.WriteValue(coordinate.Clock);
                Output.WriteValue(coordinate.Cone);
            }
            Output.WriteEndSequence();
        }

        /// <summary>
        /// Writes the value of the property for this interval as an array of <see cref="UnitCartesian"/>
        /// </summary>
        /// <param name="coordinates">The coordinates.</param>
        public void WriteValue(IEnumerable<UnitCartesian> coordinates)
        {
            OpenIntervalIfNecessary();

            Output.WritePropertyName("unitCartesian");
            Output.WriteStartSequence();
            foreach (var coordinate in coordinates)
            {
                Output.WriteValue(coordinate.X);
                Output.WriteValue(coordinate.Y);
                Output.WriteValue(coordinate.Z);
            }
            Output.WriteEndSequence();
        }

    }
}
