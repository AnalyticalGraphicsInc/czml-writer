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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing polygon-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  A polygon is a closed figure on the surface of
    /// the Earth.  Instances of this class should not be created
    /// directly, but should instead be obtained from a <see cref="CesiumPacketWriter"/>.
    /// </summary>
    public class PolygonCesiumWriter : CesiumPropertyWriter<PolygonCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public static readonly string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>material</code> property.
        /// </summary>
        public static readonly string MaterialPropertyName = "material";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter("show"), false);
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter("material"), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PolygonCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PolygonCesiumWriter(PolygonCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PolygonCesiumWriter Clone()
        {
            return new PolygonCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens a property describing whether or not the polygon is shown.
        /// </summary>
        /// <returns>A writer that is used to write show information.</returns>
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
        public MaterialCesiumWriter OpenCapMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }
    }
}
