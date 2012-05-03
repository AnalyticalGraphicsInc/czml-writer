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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing properties related to the checkerboard material to a
    /// <topic name="Cesium">Cesium</topic> stream.
    /// </summary>
    public class CheckerboardMaterialCesiumWriter : CesiumPropertyWriter<CheckerboardMaterialCesiumWriter>
    {
        private readonly Lazy<ColorCesiumWriter> m_darkColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter("darkColor"), false);
        private readonly Lazy<ColorCesiumWriter> m_lightColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter("lightColor"), false);
        private readonly Lazy<DoubleCesiumWriter> m_sRepeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("sRepeat"), false);
        private readonly Lazy<DoubleCesiumWriter> m_tRepeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("tRepeat"), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The base name of properties.</param>
        public CheckerboardMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private CheckerboardMaterialCesiumWriter(CheckerboardMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override CheckerboardMaterialCesiumWriter Clone()
        {
            return new CheckerboardMaterialCesiumWriter(this);
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
        /// Opens a property describing the dark color of the checkerboard pattern.
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
        /// Opens a property describing the light color of the checkerboard pattern.
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
        /// Gets the writer for the <code>*_sRepeat</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenSRepeatProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter SRepeatWriter
        {
            get { return m_sRepeat.Value; }
        }

        /// <summary>
        /// Opens a property describing the S repeat of the checkboard pattern.
        /// </summary>
        /// <returns>The writer that is used to write S repeat information.</returns>
        public DoubleCesiumWriter OpenSRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SRepeatWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>*_sRepeat</code> property.
        /// See the documentation for the <see cref="OpenSRepeatProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteSRepeatProperty(double value)
        {
            using (var writer = OpenSRepeatProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>*_tRepeat</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenTRepeatProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter TRepeatWriter
        {
            get { return m_tRepeat.Value; }
        }

        /// <summary>
        /// Opens a property describing the repeat of the checkerboard pattern.
        /// </summary>
        /// <returns>The writer that is used to write T repeat information.</returns>
        public DoubleCesiumWriter OpenTRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TRepeatWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>*_tRepeat</code> property.
        /// See the documentation for the <see cref="OpenTRepeatProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteTRepeatProperty(double value)
        {
            using (var writer = OpenTRepeatProperty())
            {
                writer.WriteValue(value);
            }
        }
    }
}
