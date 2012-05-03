using System;
using System.Collections.Generic;
using System.Text;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
#else
using CesiumLanguageWriter.Advanced;
#endif
using System.Drawing;

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing properties related to the tie-dye material to a
    /// <topic name="Cesium">Cesium</topic> stream.
    /// </summary>
    public class TieDyeMaterialCesiumWriter : CesiumPropertyWriter<TieDyeMaterialCesiumWriter>
    {
        private readonly Lazy<ColorCesiumWriter> m_darkColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter("darkColor"), false);
        private readonly Lazy<ColorCesiumWriter> m_lightColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter("lightColor"), false);
        private readonly Lazy<DoubleCesiumWriter> m_frequency = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("frequency"), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The base name of properties.</param>
        public TieDyeMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private TieDyeMaterialCesiumWriter(TieDyeMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override TieDyeMaterialCesiumWriter Clone()
        {
            return new TieDyeMaterialCesiumWriter(this);
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
        /// Opens a property describing the dark color of the tie-dye pattern.
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
        /// Opens a property describing the light color of the tie-dye pattern.
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
        /// Gets the writer for the <code>*_frequency</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenFrequencyProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter FrequencyWriter
        {
            get { return m_frequency.Value; }
        }

        /// <summary>
        /// Opens a property describing the frequency of the tie-dye pattern.
        /// </summary>
        /// <returns>The writer that is used to write frequency information.</returns>
        public DoubleCesiumWriter OpenFrequencyProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FrequencyWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>*_frequency</code> property.
        /// See the documentation for the <see cref="OpenFrequencyProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteFrequencyProperty(double value)
        {
            using (var writer = OpenFrequencyProperty())
            {
                writer.WriteValue(value);
            }
        }
    }
}
