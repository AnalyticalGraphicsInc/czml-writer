using System;
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
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing label-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  The label is positioned in the scene
    /// by the <see cref="CesiumPacketWriter.OpenPositionProperty">Position</see> property.  Instances of this class should not be created
    /// directly, but should instead be obtained from a <see cref="CesiumPacketWriter"/>.
    /// </summary>
    public class LabelCesiumWriter : CesiumPropertyWriter<LabelCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>eyeOffset</code> property.
        /// </summary>
        public static readonly string EyeOffsetPropertyName = "eyeOffset";

        /// <summary>
        /// The name of the <code>fillColor</code> property.
        /// </summary>
        public static readonly string FillColorPropertyName = "fillColor";

        /// <summary>
        /// The name of the <code>font</code> property.
        /// </summary>
        public static readonly string FontPropertyName = "font";

        /// <summary>
        /// The name of the <code>horizontalOrigin</code> property.
        /// </summary>
        public static readonly string HorizontalOriginPropertyName = "horizontalOrigin";

        /// <summary>
        /// The name of the <code>outlineColor</code> property.
        /// </summary>
        public static readonly string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <code>pixelOffset</code> property.
        /// </summary>
        public static readonly string PixelOffsetPropertyName = "pixelOffset";

        /// <summary>
        /// The name of the <code>scale</code> property.
        /// </summary>
        public static readonly string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public static readonly string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>style</code> property.
        /// </summary>
        public static readonly string StylePropertyName = "style";
        
        /// <summary>
        /// The name of the <code>text</code> property.
        /// </summary>
        public static readonly string TextPropertyName = "text";

        /// <summary>
        /// The name of the <code>verticalOrigin</code> property.
        /// </summary>
        public static readonly string VerticalOriginPropertyName = "verticalOrigin";

        private readonly Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<EyeOffsetCesiumWriter>(() => new EyeOffsetCesiumWriter(EyeOffsetPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_fillColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(FillColorPropertyName), false);
        private readonly Lazy<FontCesiumWriter> m_font = new Lazy<FontCesiumWriter>(() => new FontCesiumWriter(FontPropertyName), false);
        private readonly Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<HorizontalOriginCesiumWriter>(() => new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<PixelOffsetCesiumWriter>(() => new PixelOffsetCesiumWriter(PixelOffsetPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ScalePropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<LabelStyleCesiumWriter> m_style = new Lazy<LabelStyleCesiumWriter>(() => new LabelStyleCesiumWriter(StylePropertyName), false);
        private readonly Lazy<StringCesiumWriter> m_text = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(TextPropertyName), false);
        private readonly Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<VerticalOriginCesiumWriter>(() => new VerticalOriginCesiumWriter(VerticalOriginPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public LabelCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected LabelCesiumWriter(LabelCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override LabelCesiumWriter Clone()
        {
            return new LabelCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>label_eyeOffset</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenEyeOffsetProperty"/> method for more information.
        /// </summary>
        public EyeOffsetCesiumWriter EyeOffsetWriter
        {
            get { return m_eyeOffset.Value; }
        }

        /// <summary>
        /// Opens a property describing the offset in eye coordinates of the label origin from the
        /// <see cref="CesiumPacketWriter.OpenPositionProperty"/>.
        /// </summary>
        /// <returns>The writer that is used to write eye offset information.</returns>
        public EyeOffsetCesiumWriter OpenEyeOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EyeOffsetWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_eyeOffset</code> property.
        /// See the documentation for the <see cref="OpenEyeOffsetProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteEyeOffsetProperty(Cartesian3 value)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>label_fillColor</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenFillColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter FillColorWriter
        {
            get { return m_fillColor.Value; }
        }

        /// <summary>
        /// Opens a property describing the fill color of the label.
        /// </summary>
        /// <returns>The writer that is used to write fill color information.</returns>
        public ColorCesiumWriter OpenFillColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FillColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_fillColor</code> property.
        /// See the documentation for the <see cref="OpenFillColorProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteFillColorProperty(Color value)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>label_font</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenFontProperty"/> method for more information.
        /// </summary>
        public FontCesiumWriter FontWriter
        {
            get { return m_font.Value; }
        }

        /// <summary>
        /// Opens a property describing the font of the label.
        /// </summary>
        /// <returns>The writer that is used to write font information.</returns>
        public FontCesiumWriter OpenFontProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FontWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_font</code> property.
        /// See the documentation for the <see cref="OpenFontProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteFontProperty(string value)
        {
            using (var writer = OpenFontProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>label_horizontalOrigin</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenHorizontalOriginProperty"/> method for more information.
        /// </summary>
        public HorizontalOriginCesiumWriter HorizontalOriginWriter
        {
            get { return m_horizontalOrigin.Value; }
        }

        /// <summary>
        /// Opens a property describing the horizontal origin of the label.  It controls whether the
        /// label image is left-, center-, or right-aligned with the <see cref="CesiumPacketWriter.OpenPositionProperty"/>.
        /// </summary>
        /// <returns>A writer that is used to write horizontal origin information.</returns>
        public HorizontalOriginCesiumWriter OpenHorizontalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalOriginWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_horizontalOrigin</code> property.
        /// See the documentation for the <see cref="OpenHorizontalOriginProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteHorizontalOriginProperty(CesiumHorizontalOrigin value)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenOutlineColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens a property describing the outline color of the label.
        /// </summary>
        /// <returns>The writer that is used to write outline color information.</returns>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_outlineColor</code> property.
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
        /// Gets the writer for the <code>label_pixelOffset</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenPixelOffsetProperty"/> method for more information.
        /// </summary>
        public PixelOffsetCesiumWriter PixelOffsetWriter
        {
            get { return m_pixelOffset.Value; }
        }

        /// <summary>
        /// Opens a property describing the offset, in viewport pixels, of the label origin from the
        /// <see cref="CesiumPacketWriter.OpenPositionProperty"/>.
        /// </summary>
        /// <returns>The writer that is used to write pixel offset information.</returns>
        public PixelOffsetCesiumWriter OpenPixelOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelOffsetWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_pixelOffset</code> property.
        /// See the documentation for the <see cref="OpenPixelOffsetProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WritePixelOffsetProperty(Cartesian2 value)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>label_scale</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenScaleProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter ScaleWriter
        {
            get { return m_scale.Value; }
        }

        /// <summary>
        /// Opens a property describing the uniform scale of the label.  For example, if the scale is 2.0, the label will
        /// cover twice the number of pixels, in each direction.
        /// </summary>
        /// <returns>A writer that is used to write scale information.</returns>
        public DoubleCesiumWriter OpenScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_scale</code> property.
        /// See the documentation for the <see cref="OpenScaleProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteScaleProperty(double value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>label_show</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens a property describing whether or not the label is shown.
        /// </summary>
        /// <returns>A writer that is used to write show information.</returns>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_show</code> property.
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
        /// Gets the writer for the <code>label_style</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenStyleProperty"/> method for more information.
        /// </summary>
        public LabelStyleCesiumWriter StyleWriter
        {
            get { return m_style.Value; }
        }

        /// <summary>
        /// Opens a property describing the style of the label.
        /// </summary>
        /// <returns>A writer that is used to write style information.</returns>
        public LabelStyleCesiumWriter OpenStyleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(StyleWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_style</code> property.
        /// See the documentation for the <see cref="OpenStyleProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteStyleProperty(CesiumLabelStyle value)
        {
            using (var writer = OpenStyleProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>label_text</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenTextProperty"/> method for more information.
        /// </summary>
        public StringCesiumWriter TextWriter
        {
            get { return m_text.Value; }
        }

        /// <summary>
        /// Opens a property describing the text of the label.
        /// </summary>
        /// <returns>The writer that is used to write text information.</returns>
        public StringCesiumWriter OpenTextProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TextWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_text</code> property.
        /// See the documentation for the <see cref="OpenTextProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteTextProperty(string value)
        {
            using (var writer = OpenTextProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>label_verticalOrigin</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenVerticalOriginProperty"/> method for more information.
        /// </summary>
        public VerticalOriginCesiumWriter VerticalOriginWriter
        {
            get { return m_verticalOrigin.Value; }
        }

        /// <summary>
        /// Opens a property describing the vertical origin of the label.  It controls whether the
        /// label image is bottom-, center-, or top-aligned with the <see cref="CesiumPacketWriter.OpenPositionProperty"/>.
        /// </summary>
        /// <returns>A writer that is used to write vertical origin information.</returns>
        public VerticalOriginCesiumWriter OpenVerticalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalOriginWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>label_verticalOrigin</code> property.
        /// See the documentation for the <see cref="OpenVerticalOriginProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteVerticalOriginProperty(CesiumVerticalOrigin value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteValue(value);
            }
        }
    }
}
