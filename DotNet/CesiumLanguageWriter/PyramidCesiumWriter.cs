using System;
using System.Collections.Generic;
using System.Drawing;
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
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public static readonly string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>directions</code> property.
        /// </summary>
        public static readonly string DirectionsPropertyName = "directions";

        /// <summary>
        /// The name of the <code>radius</code> property.
        /// </summary>
        public static readonly string RadiusPropertyName = "radius";

        /// <summary>
        /// The name of the <code>showIntersection</code> property.
        /// </summary>
        public static readonly string ShowIntersectionPropertyName = "showIntersection";

        /// <summary>
        /// The name of the <code>intersectionColor</code> property.
        /// </summary>
        public static readonly string IntersectionColorPropertyName = "intersectionColor";

        /// <summary>
        /// The name of the <code>erosion</code> property.
        /// </summary>
        public static readonly string ErosionPropertyName = "erosion";

        /// <summary>
        /// The name of the <code>material</code> property.
        /// </summary>
        public static readonly string MaterialPropertyName = "material";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);

        private readonly Lazy<DirectionListCesiumWriter> m_directions = new Lazy<DirectionListCesiumWriter>(() => new DirectionListCesiumWriter(DirectionsPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_radius = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RadiusPropertyName), false);

        private readonly Lazy<BooleanCesiumWriter> m_showIntersection = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowIntersectionPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_intersectionColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(IntersectionColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_erosion = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ErosionPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(MaterialPropertyName), false);

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
        /// Gets a writer for writing the <code>show</code> property.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>show</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>show</code> property.
        /// See the documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteShowProperty(bool value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteValue(value);
            }
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
        /// <param name="coordinates">The <see cref="UnitCartesian"/> coordinates of the property.</param>
        public void WriteDirectionsProperty(IEnumerable<UnitCartesian> coordinates)
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

        /// <summary>
        /// Gets a writer for writing the <code>showIntersection</code> property.
        /// </summary>
        public BooleanCesiumWriter ShowIntersectionWriter
        {
            get { return m_showIntersection.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>showIntersection</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public BooleanCesiumWriter OpenShowIntersectionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowIntersectionWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>showIntersection</code> property.
        /// See the documentation for the <see cref="OpenShowIntersectionProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteShowIntersectionProperty(bool value)
        {
            using (var writer = OpenShowIntersectionProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>intersectionColor</code> property.
        /// </summary>
        public ColorCesiumWriter IntersectionColorWriter
        {
            get { return m_intersectionColor.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>intersectionColor</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public ColorCesiumWriter OpenIntersectionColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(IntersectionColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>intersectionColor</code> property.
        /// See the documentation for the <see cref="OpenIntersectionColorProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteIntersectionColorProperty(Color value)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>erosion</code> property.
        /// </summary>
        public DoubleCesiumWriter ErosionWriter
        {
            get { return m_erosion.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>erosion</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DoubleCesiumWriter OpenErosionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ErosionWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>erosion</code> property.
        /// See the documentation for the <see cref="OpenErosionProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteErosionProperty(double value)
        {
            using (var writer = OpenErosionProperty())
            {
                writer.WriteValue(value);
            }
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
    }
}
