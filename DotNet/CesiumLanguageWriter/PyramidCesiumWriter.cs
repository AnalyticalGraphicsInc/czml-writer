using System;
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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing pyramid-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  
    /// </summary>
    public class PyramidCesiumWriter : CesiumPropertyWriter<PyramidCesiumWriter>
    {
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter("material"), false);
        private readonly Lazy<DirectionListCesiumWriter> m_directions = new Lazy<DirectionListCesiumWriter>(() => new DirectionListCesiumWriter("directions"), false);
        private readonly Lazy<DoubleCesiumWriter> m_radius = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("radius"), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PyramidCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PyramidCesiumWriter(PyramidCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PyramidCesiumWriter Clone()
        {
            return new PyramidCesiumWriter(this);
        }

        /// <summary>
        /// Gets a writer for writing the <code>material</code> property.
        /// </summary>
        public MaterialCesiumWriter MaterialWriter
        {
            get { return m_material.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>material</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public MaterialCesiumWriter OpenMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }

        /// <summary>
        /// Gets a writer for writing the <code>directions</code> property.
        /// </summary>
        public DirectionListCesiumWriter DirectionsWriter
        {
            get { return m_directions.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>directions</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DirectionListCesiumWriter OpenDirectionsProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DirectionsWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>directions</code> property.
        /// See the documentation for the <see cref="OpenDirectionsProperty"/> method for more information.
        /// </summary>
        /// <param name="coordinates">The <see cref="UnitSpherical"/> coordinates of the property.</param>
        public void WriteDirectionsProperty(IEnumerable<UnitSpherical> coordinates)
        {
            using (var writer = OpenDirectionsProperty())
            {
                writer.WriteValue(coordinates);
            }
        }

        /// <summary>
        /// Writes a constant value for the <code>directions</code> property.
        /// See the documentation for the <see cref="OpenDirectionsProperty"/> method for more information.
        /// </summary>
        /// <param name="coordinates">The <see cref="UnitCartesian3"/> coordinates of the property.</param>
        public void WriteDirectionsProperty(IEnumerable<UnitCartesian3> coordinates)
        {
            using (var writer = OpenDirectionsProperty())
            {
                writer.WriteValue(coordinates);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>radius</code> property.
        /// </summary>
        public DoubleCesiumWriter RadiusWriter
        {
            get { return m_radius.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>radius</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DoubleCesiumWriter OpenRadiusProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RadiusWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>radius</code> property.
        /// See the documentation for the <see cref="OpenRadiusProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteRadiusProperty(double value)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteValue(value);
            }
        }

    }
}
