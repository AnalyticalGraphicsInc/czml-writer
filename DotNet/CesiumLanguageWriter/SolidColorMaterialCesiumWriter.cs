using System;
using System.Drawing;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing properties related to the solid-color material to a
    /// <topic name="Cesium">Cesium</topic> stream.
    /// </summary>
    public class SolidColorMaterialCesiumWriter : CesiumPropertyWriter<SolidColorMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public static readonly string ColorPropertyName = "color";

        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The base name of properties.</param>
        public SolidColorMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private SolidColorMaterialCesiumWriter(SolidColorMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override SolidColorMaterialCesiumWriter Clone()
        {
            return new SolidColorMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets a writer for writing the <code>color</code> property.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens and returns a writer for the the <code>color</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>color</code> property.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteColorProperty(Color color)
        {
            using (ColorCesiumWriter writer = OpenColorProperty())
            {
                writer.WriteValue(color);
            }
        }
    }
}
