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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing path-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  A path is a line in the 3D scene composed of
    /// multiple segments.  Instances of this class should not be created
    /// directly, but should instead be obtained from a <see cref="CesiumPacketWriter"/>.
    /// </summary>
    public class PathCesiumWriter : CesiumPropertyWriter<PathCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public static readonly string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public static readonly string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <code>width</code> property.
        /// </summary>
        public static readonly string WidthPropertyName = "width";

        /// <summary>
        /// The name of the <code>outlineColor</code> property.
        /// </summary>
        public static readonly string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <code>outlineWidth</code> property.
        /// </summary>
        public static readonly string OutlineWidthPropertyName = "outlineWidth";

        /// <summary>
        /// The name of the <code>leadTime</code> property.
        /// </summary>
        public static readonly string LeadTimePropertyName = "leadTime";

        /// <summary>
        /// The name of the <code>trailTime</code> property.
        /// </summary>
        public static readonly string TrailTimePropertyName = "trailTime";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_width = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(WidthPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_leadTime = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(LeadTimePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_trailTime = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(TrailTimePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PathCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PathCesiumWriter(PathCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PathCesiumWriter Clone()
        {
            return new PathCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>path_show</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens a property describing whether or not the path is shown.
        /// </summary>
        /// <returns>A writer that is used to write show information.</returns>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>path_show</code> property.
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
        /// Gets the writer for the <code>path_color</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens a property describing the path color.
        /// </summary>
        /// <returns>A writer that is used to write color information.</returns>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>path_color</code> property.
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
        /// Gets the writer for the <code>path_width</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenWidthProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter WidthWriter
        {
            get { return m_width.Value; }
        }

        /// <summary>
        /// Opens a property describing the path width.
        /// </summary>
        /// <returns>A writer that is used to write width information.</returns>
        public DoubleCesiumWriter OpenWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(WidthWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>path_width</code> property.
        /// See the documentation for the <see cref="OpenWidthProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteWidthProperty(double value)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>path_color</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenOutlineColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens a property describing the path outline color.
        /// </summary>
        /// <returns>A writer that is used to write outline color information.</returns>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>path_outlineColor</code> property.
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
        /// Gets the writer for the <code>path_outlineWidth</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenOutlineWidthProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens a property describing the path outline width.
        /// </summary>
        /// <returns>A writer that is used to write outline width information.</returns>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>path_outlineWidth</code> property.
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
        /// Gets the writer for the <code>path_leadTime</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenLeadTimeProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter LeadTimeWriter
        {
            get { return m_leadTime.Value; }
        }

        /// <summary>
        /// Opens a property describing the path lead time.
        /// </summary>
        /// <returns>A writer that is used to write lead time information.</returns>
        public DoubleCesiumWriter OpenLeadTimeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LeadTimeWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>path_leadTime</code> property.
        /// See the documentation for the <see cref="OpenOutlineWidthProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteLeadTimeProperty(double value)
        {
            using (var writer = OpenLeadTimeProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>path_trailTime</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenTrailTimeProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter TrailTimeWriter
        {
            get { return m_trailTime.Value; }
        }

        /// <summary>
        /// Opens a property describing the path trail time.
        /// </summary>
        /// <returns>A writer that is used to write trail time information.</returns>
        public DoubleCesiumWriter OpenTrailTimeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TrailTimeWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>path_trailTime</code> property.
        /// See the documentation for the <see cref="OpenTrailTimeProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteTrailTimeProperty(double value)
        {
            using (var writer = OpenTrailTimeProperty())
            {
                writer.WriteValue(value);
            }
        }
    }
}
