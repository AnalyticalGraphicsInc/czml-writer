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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing polyline-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  A polyline is a line in the 3D scene composed of
    /// multiple segments.  Instances of this class should not be created
    /// directly, but should instead be obtained from a <see cref="CesiumPacketWriter"/>.
    /// </summary>
    public class PolylineCesiumWriter : CesiumPropertyWriter<PolylineCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public static readonly string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <code>outlineColor</code> property.
        /// </summary>
        public static readonly string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <code>outlineWidth</code> property.
        /// </summary>
        public static readonly string OutlineWidthPropertyName = "outlineWidth";

        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public static readonly string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>width</code> property.
        /// </summary>
        public static readonly string WidthPropertyName = "width";

        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<PositionListCesiumWriter> m_vertexPositions = new Lazy<PositionListCesiumWriter>(() => new PositionListCesiumWriter("positions"), false);
        private readonly Lazy<DoubleCesiumWriter> m_width = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(WidthPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PolylineCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PolylineCesiumWriter(PolylineCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PolylineCesiumWriter Clone()
        {
            return new PolylineCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>polyline_show</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens a property describing whether or not the polyline is shown.
        /// </summary>
        /// <returns>A writer that is used to write show information.</returns>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>polyline_show</code> property.
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
        /// Gets the writer for the <code>polyline_color</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens a property describing the polyline color.
        /// </summary>
        /// <returns>A writer that is used to write color information.</returns>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>polyline_color</code> property.
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
        /// Gets the writer for the <code>polyline_width</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenWidthProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter WidthWriter
        {
            get { return m_width.Value; }
        }

        /// <summary>
        /// Opens a property describing the polyline width.
        /// </summary>
        /// <returns>A writer that is used to write width information.</returns>
        public DoubleCesiumWriter OpenWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(WidthWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>polyline_width</code> property.
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
        /// Gets the writer for the <code>polyline_color</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenOutlineColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens a property describing the polyline outline color.
        /// </summary>
        /// <returns>A writer that is used to write outline color information.</returns>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>polyline_outlineColor</code> property.
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
        /// Gets the writer for the <code>polyline_outlineWidth</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenOutlineWidthProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens a property describing the polyline outline width.
        /// </summary>
        /// <returns>A writer that is used to write outline width information.</returns>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>polyline_outlineWidth</code> property.
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
        /// Gets the writer for the <code>polyline_positions</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenVertexPositionsProperty"/> method for more information.
        /// </summary>
        public PositionListCesiumWriter VertexPositionsWriter
        {
            get { return m_vertexPositions.Value; }
        }

        /// <summary>
        /// Opens a property describing the polyline positions.
        /// </summary>
        /// <returns>A writer that is used to write positions information.</returns>
        public PositionListCesiumWriter OpenVertexPositionsProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VertexPositionsWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>polyline_positions</code> property in cartesian coordinates.
        /// See the documentation for the <see cref="OpenVertexPositionsProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WritePositionsProperty(IEnumerable<Cartesian> value)
        {
            using (var writer = OpenVertexPositionsProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Writes a constant value for the <code>polyline_positions</code> property in cartographic coordinates.
        /// See the documentation for the <see cref="OpenVertexPositionsProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WritePositionsProperty(IEnumerable<Cartographic> value)
        {
            using (var writer = OpenVertexPositionsProperty())
            {
                writer.WriteValue(value);
            }
        }
    }
}
