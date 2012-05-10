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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing properties related to the vertical stripe material to a
    /// <topic name="Cesium">Cesium</topic> stream.
    /// </summary>
    public class VerticalStripeMaterialCesiumWriter : CesiumPropertyWriter<VerticalStripeMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>darkColor</code> property.
        /// </summary>
        public static readonly string DarkColorPropertyName = "darkColor";

        /// <summary>
        /// The name of the <code>lightColor</code> property.
        /// </summary>
        public static readonly string LightColorPropertyName = "lightColor";

        /// <summary>
        /// The name of the <code>offset</code> property.
        /// </summary>
        public static readonly string OffsetPropertyName = "offset";

        /// <summary>
        /// The name of the <code>repeat</code> property.
        /// </summary>
        public static readonly string RepeatPropertyName = "repeat";

        private readonly Lazy<ColorCesiumWriter> m_darkColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(DarkColorPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_lightColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(LightColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_offset = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OffsetPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_repeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RepeatPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The base name of properties.</param>
        public VerticalStripeMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private VerticalStripeMaterialCesiumWriter(VerticalStripeMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override VerticalStripeMaterialCesiumWriter Clone()
        {
            return new VerticalStripeMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>*_darkColor</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenDarkColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter DarkColorWriter
        {
            get { return m_darkColor.Value; }
        }

        /// <summary>
        /// Opens a property describing the dark color of the vertical stripe pattern.
        /// </summary>
        /// <returns>The writer that is used to write dark color information.</returns>
        public ColorCesiumWriter OpenDarkColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DarkColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>*_darkColor</code> property.
        /// See the documentation for the <see cref="OpenDarkColorProperty"/> method for more information.
        /// </summary>
        /// <param name="color">The value of the property.</param>
        public void WriteDarkColorProperty(Color color)
        {
            using (var writer = OpenDarkColorProperty())
            {
                writer.WriteValue(color);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>*_lightColor</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenLightColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter LightColorWriter
        {
            get { return m_lightColor.Value; }
        }

        /// <summary>
        /// Opens a property describing the light color of the vertical stripe pattern.
        /// </summary>
        /// <returns>The writer that is used to write light color information.</returns>
        public ColorCesiumWriter OpenLightColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LightColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>*_lightColor</code> property.
        /// See the documentation for the <see cref="OpenLightColorProperty"/> method for more information.
        /// </summary>
        /// <param name="color">The value of the property.</param>
        public void WriteLightColorProperty(Color color)
        {
            using (var writer = OpenLightColorProperty())
            {
                writer.WriteValue(color);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>*_offset</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenOffsetProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter OffsetWriter
        {
            get { return m_offset.Value; }
        }

        /// <summary>
        /// Opens a property describing the offset of the vertical stripe pattern.
        /// </summary>
        /// <returns>The writer that is used to write offset information.</returns>
        public DoubleCesiumWriter OpenOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OffsetWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>*_offset</code> property.
        /// See the documentation for the <see cref="OpenOffsetProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteOffsetProperty(double value)
        {
            using (var writer = OpenOffsetProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>*_repeat</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenRepeatProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter RepeatWriter
        {
            get { return m_repeat.Value; }
        }

        /// <summary>
        /// Opens a property describing the repeat of the vertical stripe pattern.
        /// </summary>
        /// <returns>The writer that is used to write repeat information.</returns>
        public DoubleCesiumWriter OpenRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RepeatWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>*_repeat</code> property.
        /// See the documentation for the <see cref="OpenRepeatProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteRepeatProperty(double value)
        {
            using (var writer = OpenRepeatProperty())
            {
                writer.WriteValue(value);
            }
        }
    }
}
