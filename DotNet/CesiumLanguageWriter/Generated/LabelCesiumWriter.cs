// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Label</code> to a <see cref="CesiumOutputStream" />.  A <code>Label</code> a string of text.
    /// </summary>
    public class LabelCesiumWriter : CesiumPropertyWriter<LabelCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>eyeOffset</code> property.
        /// </summary>
        public const string EyeOffsetPropertyName = "eyeOffset";

        /// <summary>
        /// The name of the <code>fillColor</code> property.
        /// </summary>
        public const string FillColorPropertyName = "fillColor";

        /// <summary>
        /// The name of the <code>font</code> property.
        /// </summary>
        public const string FontPropertyName = "font";

        /// <summary>
        /// The name of the <code>horizontalOrigin</code> property.
        /// </summary>
        public const string HorizontalOriginPropertyName = "horizontalOrigin";

        /// <summary>
        /// The name of the <code>outlineColor</code> property.
        /// </summary>
        public const string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <code>outlineWidth</code> property.
        /// </summary>
        public const string OutlineWidthPropertyName = "outlineWidth";

        /// <summary>
        /// The name of the <code>pixelOffset</code> property.
        /// </summary>
        public const string PixelOffsetPropertyName = "pixelOffset";

        /// <summary>
        /// The name of the <code>scale</code> property.
        /// </summary>
        public const string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>style</code> property.
        /// </summary>
        public const string StylePropertyName = "style";

        /// <summary>
        /// The name of the <code>text</code> property.
        /// </summary>
        public const string TextPropertyName = "text";

        /// <summary>
        /// The name of the <code>verticalOrigin</code> property.
        /// </summary>
        public const string VerticalOriginPropertyName = "verticalOrigin";

        private readonly Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<EyeOffsetCesiumWriter>(() => new EyeOffsetCesiumWriter(EyeOffsetPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_fillColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(FillColorPropertyName), false);
        private readonly Lazy<FontCesiumWriter> m_font = new Lazy<FontCesiumWriter>(() => new FontCesiumWriter(FontPropertyName), false);
        private readonly Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<HorizontalOriginCesiumWriter>(() => new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);
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
        /// Gets the writer for the <code>eyeOffset</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>eyeOffset</code> property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        public EyeOffsetCesiumWriter EyeOffsetWriter
        {
            get { return m_eyeOffset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>eyeOffset</code> property.  The <code>eyeOffset</code> property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        public EyeOffsetCesiumWriter OpenEyeOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EyeOffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteEyeOffsetProperty(Cartesian value)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteCartesian(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteEyeOffsetProperty(IList<JulianDate> dates, IList<Cartesian> values)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteEyeOffsetProperty(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>fillColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>fillColor</code> property defines the fill color of the label.
        /// </summary>
        public ColorCesiumWriter FillColorWriter
        {
            get { return m_fillColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>fillColor</code> property.  The <code>fillColor</code> property defines the fill color of the label.
        /// </summary>
        public ColorCesiumWriter OpenFillColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FillColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>fillColor</code> property as a <code>rgba</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteFillColorProperty(Color color)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>fillColor</code> property as a <code>rgba</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteFillColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>fillColor</code> property as a <code>rgba</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteFillColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>fillColor</code> property as a <code>rgbaf</code> value.  The <code>fillColor</code> property specifies the fill color of the label.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteFillColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>font</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>font</code> property defines the font to use for the label.
        /// </summary>
        public FontCesiumWriter FontWriter
        {
            get { return m_font.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>font</code> property.  The <code>font</code> property defines the font to use for the label.
        /// </summary>
        public FontCesiumWriter OpenFontProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FontWriter);
        }

        /// <summary>
        /// Writes a value for the <code>font</code> property as a <code>font</code> value.  The <code>font</code> property specifies the font to use for the label.
        /// </summary>
        /// <param name="font">The font.</param>
        public void WriteFontProperty(string font)
        {
            using (var writer = OpenFontProperty())
            {
                writer.WriteFont(font);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>horizontalOrigin</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>horizontalOrigin</code> property defines the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
        /// </summary>
        public HorizontalOriginCesiumWriter HorizontalOriginWriter
        {
            get { return m_horizontalOrigin.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property defines the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
        /// </summary>
        public HorizontalOriginCesiumWriter OpenHorizontalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalOriginWriter);
        }

        /// <summary>
        /// Writes a value for the <code>horizontalOrigin</code> property as a <code>horizontalOrigin</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the `position`.
        /// </summary>
        /// <param name="value">The horizontal origin.</param>
        public void WriteHorizontalOriginProperty(CesiumHorizontalOrigin value)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteHorizontalOrigin(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outlineColor</code> property defines the outline color of the label.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the outline color of the label.
        /// </summary>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteOutlineColorProperty(Color color)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteOutlineColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteOutlineColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the outline color of the label.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteOutlineColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>outlineWidth</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outlineWidth</code> property defines the outline width of the label.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outlineWidth</code> property.  The <code>outlineWidth</code> property defines the outline width of the label.
        /// </summary>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the outline width of the label.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteOutlineWidthProperty(double value)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the outline width of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteOutlineWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>pixelOffset</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>pixelOffset</code> property defines the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
        /// </summary>
        public PixelOffsetCesiumWriter PixelOffsetWriter
        {
            get { return m_pixelOffset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>pixelOffset</code> property.  The <code>pixelOffset</code> property defines the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
        /// </summary>
        public PixelOffsetCesiumWriter OpenPixelOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelOffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePixelOffsetProperty(Rectangular value)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WritePixelOffsetProperty(double x, double y)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(x, y);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePixelOffsetProperty(IList<JulianDate> dates, IList<Rectangular> values)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the label origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the label, relative to the `position`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePixelOffsetProperty(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>scale</code> property defines the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
        /// </summary>
        public DoubleCesiumWriter ScaleWriter
        {
            get { return m_scale.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>scale</code> property.  The <code>scale</code> property defines the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
        /// </summary>
        public DoubleCesiumWriter OpenScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteScaleProperty(double value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteScaleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the label is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the label is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the label is shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowProperty(bool value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>style</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>style</code> property defines the style of the label.
        /// </summary>
        public LabelStyleCesiumWriter StyleWriter
        {
            get { return m_style.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>style</code> property.  The <code>style</code> property defines the style of the label.
        /// </summary>
        public LabelStyleCesiumWriter OpenStyleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(StyleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>style</code> property as a <code>labelStyle</code> value.  The <code>style</code> property specifies the style of the label.
        /// </summary>
        /// <param name="value">The label style.</param>
        public void WriteStyleProperty(CesiumLabelStyle value)
        {
            using (var writer = OpenStyleProperty())
            {
                writer.WriteLabelStyle(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>text</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>text</code> property defines the text displayed by the label.
        /// </summary>
        public StringCesiumWriter TextWriter
        {
            get { return m_text.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>text</code> property.  The <code>text</code> property defines the text displayed by the label.
        /// </summary>
        public StringCesiumWriter OpenTextProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TextWriter);
        }

        /// <summary>
        /// Writes a value for the <code>text</code> property as a <code>string</code> value.  The <code>text</code> property specifies the text displayed by the label.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteTextProperty(string value)
        {
            using (var writer = OpenTextProperty())
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>verticalOrigin</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>verticalOrigin</code> property defines the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
        /// </summary>
        public VerticalOriginCesiumWriter VerticalOriginWriter
        {
            get { return m_verticalOrigin.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>verticalOrigin</code> property.  The <code>verticalOrigin</code> property defines the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
        /// </summary>
        public VerticalOriginCesiumWriter OpenVerticalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalOriginWriter);
        }

        /// <summary>
        /// Writes a value for the <code>verticalOrigin</code> property as a <code>verticalOrigin</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the `position`.
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        public void WriteVerticalOriginProperty(CesiumVerticalOrigin value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteVerticalOrigin(value);
            }
        }

    }
}
