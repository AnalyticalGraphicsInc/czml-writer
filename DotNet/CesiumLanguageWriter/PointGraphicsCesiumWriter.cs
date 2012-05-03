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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing point-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  A point is a viewport-aligned image positioned
    /// in the 3D scene, and is sometimes called a marker.  The point is positioned in the scene
    /// by the <see cref="CesiumPacketWriter.OpenPositionProperty">Position</see> property.  Instances of this class should not be created
    /// directly, but should instead be obtained from a <see cref="CesiumPacketWriter"/>.
    /// </summary>
    public class PointGraphicsCesiumWriter : CesiumPropertyWriter<PointGraphicsCesiumWriter>
    {
        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter("color"), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter("outlineColor"), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("outlineWidth"), false);
        private readonly Lazy<DoubleCesiumWriter> m_pixelSize = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("pixelSize"), false);
        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter("show"), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PointGraphicsCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PointGraphicsCesiumWriter(PointGraphicsCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PointGraphicsCesiumWriter Clone()
        {
            return new PointGraphicsCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>point_color</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens a property describing the color of the point.
        /// </summary>
        /// <returns>The writer that is used to write color information.</returns>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>point_color</code> property.
        /// See the documentation for the <see cref="OpenColorProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteColorProperty(Color value)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>point_outlineColor</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenOutlineColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens a property describing the ouline color of the point.
        /// </summary>
        /// <returns>The writer that is used to write color information.</returns>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>point_outlineColor</code> property.
        /// See the documentation for the <see cref="OpenOutlineColorProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteOutlineColorProperty(Color value)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>point_outlineWidth</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenOutlineWidthProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens a property describing the width of the point.
        /// </summary>
        /// <returns>The writer that is used to write width information.</returns>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>point_outlineWidth</code> property.
        /// See the documentation for the <see cref="OpenOutlineWidthProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteOutlineWidthProperty(double value)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>point_pixelSize</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenPixelSizeProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter PixelSizeWriter
        {
            get { return m_pixelSize.Value; }
        }

        /// <summary>
        /// Opens a property describing the pixelSize of the point.
        /// </summary>
        /// <returns>The writer that is used to write pixel sizeinformation.</returns>
        public DoubleCesiumWriter OpenPixelSizeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelSizeWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>point_pixelSize</code> property.
        /// See the documentation for the <see cref="OpenPixelSizeProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WritePixelSizeProperty(double value)
        {
            using (var writer = OpenPixelSizeProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>point_show</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens a property describing whether or not the point is shown.
        /// </summary>
        /// <returns>A writer that is used to write show information.</returns>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>point_show</code> property.
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
    }
}
