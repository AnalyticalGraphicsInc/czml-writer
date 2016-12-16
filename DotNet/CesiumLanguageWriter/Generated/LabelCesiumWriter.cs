// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>Label</c> to a <see cref="CesiumOutputStream" />.  A <c>Label</c> is a string of text.
    /// </summary>
    public class LabelCesiumWriter : CesiumPropertyWriter<LabelCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>show</c> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <c>text</c> property.
        /// </summary>
        public const string TextPropertyName = "text";

        /// <summary>
        /// The name of the <c>font</c> property.
        /// </summary>
        public const string FontPropertyName = "font";

        /// <summary>
        /// The name of the <c>style</c> property.
        /// </summary>
        public const string StylePropertyName = "style";

        /// <summary>
        /// The name of the <c>scale</c> property.
        /// </summary>
        public const string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <c>showBackground</c> property.
        /// </summary>
        public const string ShowBackgroundPropertyName = "showBackground";

        /// <summary>
        /// The name of the <c>backgroundColor</c> property.
        /// </summary>
        public const string BackgroundColorPropertyName = "backgroundColor";

        /// <summary>
        /// The name of the <c>backgroundPadding</c> property.
        /// </summary>
        public const string BackgroundPaddingPropertyName = "backgroundPadding";

        /// <summary>
        /// The name of the <c>pixelOffset</c> property.
        /// </summary>
        public const string PixelOffsetPropertyName = "pixelOffset";

        /// <summary>
        /// The name of the <c>eyeOffset</c> property.
        /// </summary>
        public const string EyeOffsetPropertyName = "eyeOffset";

        /// <summary>
        /// The name of the <c>horizontalOrigin</c> property.
        /// </summary>
        public const string HorizontalOriginPropertyName = "horizontalOrigin";

        /// <summary>
        /// The name of the <c>verticalOrigin</c> property.
        /// </summary>
        public const string VerticalOriginPropertyName = "verticalOrigin";

        /// <summary>
        /// The name of the <c>heightReference</c> property.
        /// </summary>
        public const string HeightReferencePropertyName = "heightReference";

        /// <summary>
        /// The name of the <c>fillColor</c> property.
        /// </summary>
        public const string FillColorPropertyName = "fillColor";

        /// <summary>
        /// The name of the <c>outlineColor</c> property.
        /// </summary>
        public const string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <c>outlineWidth</c> property.
        /// </summary>
        public const string OutlineWidthPropertyName = "outlineWidth";

        /// <summary>
        /// The name of the <c>translucencyByDistance</c> property.
        /// </summary>
        public const string TranslucencyByDistancePropertyName = "translucencyByDistance";

        /// <summary>
        /// The name of the <c>pixelOffsetScaleByDistance</c> property.
        /// </summary>
        public const string PixelOffsetScaleByDistancePropertyName = "pixelOffsetScaleByDistance";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<StringCesiumWriter> m_text = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(TextPropertyName), false);
        private readonly Lazy<FontCesiumWriter> m_font = new Lazy<FontCesiumWriter>(() => new FontCesiumWriter(FontPropertyName), false);
        private readonly Lazy<LabelStyleCesiumWriter> m_style = new Lazy<LabelStyleCesiumWriter>(() => new LabelStyleCesiumWriter(StylePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ScalePropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showBackground = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowBackgroundPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_backgroundColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(BackgroundColorPropertyName), false);
        private readonly Lazy<BackgroundPaddingCesiumWriter> m_backgroundPadding = new Lazy<BackgroundPaddingCesiumWriter>(() => new BackgroundPaddingCesiumWriter(BackgroundPaddingPropertyName), false);
        private readonly Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<PixelOffsetCesiumWriter>(() => new PixelOffsetCesiumWriter(PixelOffsetPropertyName), false);
        private readonly Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<EyeOffsetCesiumWriter>(() => new EyeOffsetCesiumWriter(EyeOffsetPropertyName), false);
        private readonly Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<HorizontalOriginCesiumWriter>(() => new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName), false);
        private readonly Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<VerticalOriginCesiumWriter>(() => new VerticalOriginCesiumWriter(VerticalOriginPropertyName), false);
        private readonly Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<HeightReferenceCesiumWriter>(() => new HeightReferenceCesiumWriter(HeightReferencePropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_fillColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(FillColorPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);
        private readonly Lazy<NearFarScalarCesiumWriter> m_translucencyByDistance = new Lazy<NearFarScalarCesiumWriter>(() => new NearFarScalarCesiumWriter(TranslucencyByDistancePropertyName), false);
        private readonly Lazy<NearFarScalarCesiumWriter> m_pixelOffsetScaleByDistance = new Lazy<NearFarScalarCesiumWriter>(() => new NearFarScalarCesiumWriter(PixelOffsetScaleByDistancePropertyName), false);

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
        /// Gets the writer for the <c>show</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>show</c> property defines whether or not the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>show</c> property.  The <c>show</c> property defines whether or not the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>boolean</c> value.  The <c>show</c> property specifies whether or not the label is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowPropertyReference(Reference value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowPropertyReference(string value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>text</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>text</c> property defines the text displayed by the label.  The newline character (\n) indicates line breaks.
        /// </summary>
        public StringCesiumWriter TextWriter
        {
            get { return m_text.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>text</c> property.  The <c>text</c> property defines the text displayed by the label.  The newline character (\n) indicates line breaks.
        /// </summary>
        public StringCesiumWriter OpenTextProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TextWriter);
        }

        /// <summary>
        /// Writes a value for the <c>text</c> property as a <c>string</c> value.  The <c>text</c> property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
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
        /// Writes a value for the <c>text</c> property as a <c>reference</c> value.  The <c>text</c> property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteTextPropertyReference(Reference value)
        {
            using (var writer = OpenTextProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>text</c> property as a <c>reference</c> value.  The <c>text</c> property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteTextPropertyReference(string value)
        {
            using (var writer = OpenTextProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>text</c> property as a <c>reference</c> value.  The <c>text</c> property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteTextPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenTextProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>text</c> property as a <c>reference</c> value.  The <c>text</c> property specifies the text displayed by the label.  The newline character (\n) indicates line breaks.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteTextPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenTextProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>font</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>font</c> property defines the font to use for the label.
        /// </summary>
        public FontCesiumWriter FontWriter
        {
            get { return m_font.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>font</c> property.  The <c>font</c> property defines the font to use for the label.
        /// </summary>
        public FontCesiumWriter OpenFontProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FontWriter);
        }

        /// <summary>
        /// Writes a value for the <c>font</c> property as a <c>font</c> value.  The <c>font</c> property specifies the font to use for the label.
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
        /// Writes a value for the <c>font</c> property as a <c>reference</c> value.  The <c>font</c> property specifies the font to use for the label.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteFontPropertyReference(Reference value)
        {
            using (var writer = OpenFontProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>font</c> property as a <c>reference</c> value.  The <c>font</c> property specifies the font to use for the label.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteFontPropertyReference(string value)
        {
            using (var writer = OpenFontProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>font</c> property as a <c>reference</c> value.  The <c>font</c> property specifies the font to use for the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteFontPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenFontProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>font</c> property as a <c>reference</c> value.  The <c>font</c> property specifies the font to use for the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteFontPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenFontProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>style</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>style</c> property defines the style of the label.
        /// </summary>
        public LabelStyleCesiumWriter StyleWriter
        {
            get { return m_style.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>style</c> property.  The <c>style</c> property defines the style of the label.
        /// </summary>
        public LabelStyleCesiumWriter OpenStyleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(StyleWriter);
        }

        /// <summary>
        /// Writes a value for the <c>style</c> property as a <c>labelStyle</c> value.  The <c>style</c> property specifies the style of the label.
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
        /// Writes a value for the <c>style</c> property as a <c>reference</c> value.  The <c>style</c> property specifies the style of the label.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteStylePropertyReference(Reference value)
        {
            using (var writer = OpenStyleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>style</c> property as a <c>reference</c> value.  The <c>style</c> property specifies the style of the label.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteStylePropertyReference(string value)
        {
            using (var writer = OpenStyleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>style</c> property as a <c>reference</c> value.  The <c>style</c> property specifies the style of the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteStylePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenStyleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>style</c> property as a <c>reference</c> value.  The <c>style</c> property specifies the style of the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteStylePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenStyleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>scale</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>scale</c> property defines the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter ScaleWriter
        {
            get { return m_scale.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>scale</c> property.  The <c>scale</c> property defines the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter OpenScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleWriter);
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>number</c> value.  The <c>scale</c> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
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
        /// Writes a value for the <c>scale</c> property as a <c>number</c> value.  The <c>scale</c> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteScaleProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>number</c> value.  The <c>scale</c> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteScaleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>reference</c> value.  The <c>scale</c> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteScalePropertyReference(Reference value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>reference</c> value.  The <c>scale</c> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteScalePropertyReference(string value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>reference</c> value.  The <c>scale</c> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteScalePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>reference</c> value.  The <c>scale</c> property specifies the scale of the label.  The scale is multiplied with the pixel size of the label's text.  For example, if the scale is 2.0, the label will be rendered with twice the number of pixels, in each direction, of the text.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteScalePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>showBackground</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>showBackground</c> property defines whether or not a background behind the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter ShowBackgroundWriter
        {
            get { return m_showBackground.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>showBackground</c> property.  The <c>showBackground</c> property defines whether or not a background behind the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenShowBackgroundProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowBackgroundWriter);
        }

        /// <summary>
        /// Writes a value for the <c>showBackground</c> property as a <c>boolean</c> value.  The <c>showBackground</c> property specifies whether or not a background behind the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowBackgroundProperty(bool value)
        {
            using (var writer = OpenShowBackgroundProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>showBackground</c> property as a <c>reference</c> value.  The <c>showBackground</c> property specifies whether or not a background behind the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowBackgroundPropertyReference(Reference value)
        {
            using (var writer = OpenShowBackgroundProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>showBackground</c> property as a <c>reference</c> value.  The <c>showBackground</c> property specifies whether or not a background behind the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowBackgroundPropertyReference(string value)
        {
            using (var writer = OpenShowBackgroundProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>showBackground</c> property as a <c>reference</c> value.  The <c>showBackground</c> property specifies whether or not a background behind the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowBackgroundPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowBackgroundProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>showBackground</c> property as a <c>reference</c> value.  The <c>showBackground</c> property specifies whether or not a background behind the label is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowBackgroundPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowBackgroundProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>backgroundColor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>backgroundColor</c> property defines the color of the background behind the label.
        /// </summary>
        public ColorCesiumWriter BackgroundColorWriter
        {
            get { return m_backgroundColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>backgroundColor</c> property.  The <c>backgroundColor</c> property defines the color of the background behind the label.
        /// </summary>
        public ColorCesiumWriter OpenBackgroundColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(BackgroundColorWriter);
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>rgba</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteBackgroundColorProperty(Color color)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>rgba</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteBackgroundColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>rgba</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteBackgroundColorProperty(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteRgba(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>rgba</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteBackgroundColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>rgbaf</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteBackgroundColorPropertyRgbaf(Color color)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteRgbaf(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>rgbaf</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteBackgroundColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>rgbaf</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteBackgroundColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteRgbaf(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>rgbaf</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteBackgroundColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>reference</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteBackgroundColorPropertyReference(Reference value)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>reference</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteBackgroundColorPropertyReference(string value)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>reference</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteBackgroundColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundColor</c> property as a <c>reference</c> value.  The <c>backgroundColor</c> property specifies the color of the background behind the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteBackgroundColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenBackgroundColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>backgroundPadding</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>backgroundPadding</c> property defines the amount of padding between the text and the label's background.
        /// </summary>
        public BackgroundPaddingCesiumWriter BackgroundPaddingWriter
        {
            get { return m_backgroundPadding.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>backgroundPadding</c> property.  The <c>backgroundPadding</c> property defines the amount of padding between the text and the label's background.
        /// </summary>
        public BackgroundPaddingCesiumWriter OpenBackgroundPaddingProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(BackgroundPaddingWriter);
        }

        /// <summary>
        /// Writes a value for the <c>backgroundPadding</c> property as a <c>cartesian2</c> value.  The <c>backgroundPadding</c> property specifies the amount of padding between the text and the label's background.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBackgroundPaddingProperty(Rectangular value)
        {
            using (var writer = OpenBackgroundPaddingProperty())
            {
                writer.WriteCartesian2(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundPadding</c> property as a <c>cartesian2</c> value.  The <c>backgroundPadding</c> property specifies the amount of padding between the text and the label's background.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WriteBackgroundPaddingProperty(double x, double y)
        {
            using (var writer = OpenBackgroundPaddingProperty())
            {
                writer.WriteCartesian2(x, y);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundPadding</c> property as a <c>cartesian2</c> value.  The <c>backgroundPadding</c> property specifies the amount of padding between the text and the label's background.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteBackgroundPaddingProperty(IList<JulianDate> dates, IList<Rectangular> values)
        {
            using (var writer = OpenBackgroundPaddingProperty())
            {
                writer.WriteCartesian2(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundPadding</c> property as a <c>cartesian2</c> value.  The <c>backgroundPadding</c> property specifies the amount of padding between the text and the label's background.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteBackgroundPaddingProperty(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            using (var writer = OpenBackgroundPaddingProperty())
            {
                writer.WriteCartesian2(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundPadding</c> property as a <c>reference</c> value.  The <c>backgroundPadding</c> property specifies the amount of padding between the text and the label's background.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteBackgroundPaddingPropertyReference(Reference value)
        {
            using (var writer = OpenBackgroundPaddingProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundPadding</c> property as a <c>reference</c> value.  The <c>backgroundPadding</c> property specifies the amount of padding between the text and the label's background.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteBackgroundPaddingPropertyReference(string value)
        {
            using (var writer = OpenBackgroundPaddingProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundPadding</c> property as a <c>reference</c> value.  The <c>backgroundPadding</c> property specifies the amount of padding between the text and the label's background.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteBackgroundPaddingPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenBackgroundPaddingProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>backgroundPadding</c> property as a <c>reference</c> value.  The <c>backgroundPadding</c> property specifies the amount of padding between the text and the label's background.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteBackgroundPaddingPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenBackgroundPaddingProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>pixelOffset</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>pixelOffset</c> property defines the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
        /// </summary>
        public PixelOffsetCesiumWriter PixelOffsetWriter
        {
            get { return m_pixelOffset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>pixelOffset</c> property.  The <c>pixelOffset</c> property defines the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
        /// </summary>
        public PixelOffsetCesiumWriter OpenPixelOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelOffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffset</c> property as a <c>cartesian2</c> value.  The <c>pixelOffset</c> property specifies the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
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
        /// Writes a value for the <c>pixelOffset</c> property as a <c>cartesian2</c> value.  The <c>pixelOffset</c> property specifies the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
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
        /// Writes a value for the <c>pixelOffset</c> property as a <c>cartesian2</c> value.  The <c>pixelOffset</c> property specifies the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePixelOffsetProperty(IList<JulianDate> dates, IList<Rectangular> values)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffset</c> property as a <c>cartesian2</c> value.  The <c>pixelOffset</c> property specifies the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WritePixelOffsetProperty(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffset</c> property as a <c>reference</c> value.  The <c>pixelOffset</c> property specifies the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WritePixelOffsetPropertyReference(Reference value)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffset</c> property as a <c>reference</c> value.  The <c>pixelOffset</c> property specifies the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WritePixelOffsetPropertyReference(string value)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffset</c> property as a <c>reference</c> value.  The <c>pixelOffset</c> property specifies the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WritePixelOffsetPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffset</c> property as a <c>reference</c> value.  The <c>pixelOffset</c> property specifies the offset, in viewport pixels, of the label origin from the <c>position</c>.  A pixel offset is the number of pixels up and to the right to place the label, relative to the <c>position</c>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WritePixelOffsetPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>eyeOffset</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>eyeOffset</c> property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        public EyeOffsetCesiumWriter EyeOffsetWriter
        {
            get { return m_eyeOffset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>eyeOffset</c> property.  The <c>eyeOffset</c> property defines the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        public EyeOffsetCesiumWriter OpenEyeOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EyeOffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <c>eyeOffset</c> property as a <c>cartesian</c> value.  The <c>eyeOffset</c> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
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
        /// Writes a value for the <c>eyeOffset</c> property as a <c>cartesian</c> value.  The <c>eyeOffset</c> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteEyeOffsetProperty(IList<JulianDate> dates, IList<Cartesian> values)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>eyeOffset</c> property as a <c>cartesian</c> value.  The <c>eyeOffset</c> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteEyeOffsetProperty(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>eyeOffset</c> property as a <c>reference</c> value.  The <c>eyeOffset</c> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteEyeOffsetPropertyReference(Reference value)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>eyeOffset</c> property as a <c>reference</c> value.  The <c>eyeOffset</c> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteEyeOffsetPropertyReference(string value)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>eyeOffset</c> property as a <c>reference</c> value.  The <c>eyeOffset</c> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteEyeOffsetPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>eyeOffset</c> property as a <c>reference</c> value.  The <c>eyeOffset</c> property specifies the eye offset of the label, which is the offset in eye coordinates at which to place the label relative to the <c>position</c> property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteEyeOffsetPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>horizontalOrigin</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>horizontalOrigin</c> property defines the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        public HorizontalOriginCesiumWriter HorizontalOriginWriter
        {
            get { return m_horizontalOrigin.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>horizontalOrigin</c> property.  The <c>horizontalOrigin</c> property defines the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        public HorizontalOriginCesiumWriter OpenHorizontalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalOriginWriter);
        }

        /// <summary>
        /// Writes a value for the <c>horizontalOrigin</c> property as a <c>horizontalOrigin</c> value.  The <c>horizontalOrigin</c> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
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
        /// Writes a value for the <c>horizontalOrigin</c> property as a <c>reference</c> value.  The <c>horizontalOrigin</c> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteHorizontalOriginPropertyReference(Reference value)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>horizontalOrigin</c> property as a <c>reference</c> value.  The <c>horizontalOrigin</c> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteHorizontalOriginPropertyReference(string value)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>horizontalOrigin</c> property as a <c>reference</c> value.  The <c>horizontalOrigin</c> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteHorizontalOriginPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>horizontalOrigin</c> property as a <c>reference</c> value.  The <c>horizontalOrigin</c> property specifies the horizontal origin of the label.  It controls whether the label is left-, center-, or right-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteHorizontalOriginPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>verticalOrigin</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>verticalOrigin</c> property defines the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        public VerticalOriginCesiumWriter VerticalOriginWriter
        {
            get { return m_verticalOrigin.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>verticalOrigin</c> property.  The <c>verticalOrigin</c> property defines the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        public VerticalOriginCesiumWriter OpenVerticalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalOriginWriter);
        }

        /// <summary>
        /// Writes a value for the <c>verticalOrigin</c> property as a <c>verticalOrigin</c> value.  The <c>verticalOrigin</c> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        public void WriteVerticalOriginProperty(CesiumVerticalOrigin value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteVerticalOrigin(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>verticalOrigin</c> property as a <c>reference</c> value.  The <c>verticalOrigin</c> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteVerticalOriginPropertyReference(Reference value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>verticalOrigin</c> property as a <c>reference</c> value.  The <c>verticalOrigin</c> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteVerticalOriginPropertyReference(string value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>verticalOrigin</c> property as a <c>reference</c> value.  The <c>verticalOrigin</c> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteVerticalOriginPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>verticalOrigin</c> property as a <c>reference</c> value.  The <c>verticalOrigin</c> property specifies the vertical origin of the label.  It controls whether the label image is bottom-, center-, or top-aligned with the <c>position</c>.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteVerticalOriginPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>heightReference</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>heightReference</c> property defines the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        public HeightReferenceCesiumWriter HeightReferenceWriter
        {
            get { return m_heightReference.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>heightReference</c> property.  The <c>heightReference</c> property defines the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        public HeightReferenceCesiumWriter OpenHeightReferenceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HeightReferenceWriter);
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>heightReference</c> value.  The <c>heightReference</c> property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="value">The height reference.</param>
        public void WriteHeightReferenceProperty(CesiumHeightReference value)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteHeightReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>reference</c> value.  The <c>heightReference</c> property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteHeightReferencePropertyReference(Reference value)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>reference</c> value.  The <c>heightReference</c> property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteHeightReferencePropertyReference(string value)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>reference</c> value.  The <c>heightReference</c> property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteHeightReferencePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>reference</c> value.  The <c>heightReference</c> property specifies the height reference of the label, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteHeightReferencePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>fillColor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>fillColor</c> property defines the fill color of the label.
        /// </summary>
        public ColorCesiumWriter FillColorWriter
        {
            get { return m_fillColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>fillColor</c> property.  The <c>fillColor</c> property defines the fill color of the label.
        /// </summary>
        public ColorCesiumWriter OpenFillColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FillColorWriter);
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>rgba</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
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
        /// Writes a value for the <c>fillColor</c> property as a <c>rgba</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
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
        /// Writes a value for the <c>fillColor</c> property as a <c>rgba</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteFillColorProperty(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgba(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>rgba</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteFillColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>rgbaf</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteFillColorPropertyRgbaf(Color color)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgbaf(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>rgbaf</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
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
        /// Writes a value for the <c>fillColor</c> property as a <c>rgbaf</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteFillColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgbaf(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>rgbaf</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteFillColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>reference</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteFillColorPropertyReference(Reference value)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>reference</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteFillColorPropertyReference(string value)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>reference</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteFillColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fillColor</c> property as a <c>reference</c> value.  The <c>fillColor</c> property specifies the fill color of the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteFillColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenFillColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>outlineColor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>outlineColor</c> property defines the outline color of the label.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>outlineColor</c> property.  The <c>outlineColor</c> property defines the outline color of the label.
        /// </summary>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteOutlineColorProperty(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteOutlineColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteOutlineColorPropertyRgbaf(Color color)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteOutlineColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteOutlineColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteOutlineColorPropertyReference(Reference value)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteOutlineColorPropertyReference(string value)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteOutlineColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the outline color of the label.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteOutlineColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>outlineWidth</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>outlineWidth</c> property defines the outline width of the label.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>outlineWidth</c> property.  The <c>outlineWidth</c> property defines the outline width of the label.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the outline width of the label.  If not specified, the default value is 1.0.
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
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the outline width of the label.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteOutlineWidthProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the outline width of the label.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteOutlineWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the outline width of the label.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteOutlineWidthPropertyReference(Reference value)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the outline width of the label.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteOutlineWidthPropertyReference(string value)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the outline width of the label.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteOutlineWidthPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the outline width of the label.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteOutlineWidthPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>translucencyByDistance</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>translucencyByDistance</c> property defines how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        public NearFarScalarCesiumWriter TranslucencyByDistanceWriter
        {
            get { return m_translucencyByDistance.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>translucencyByDistance</c> property.  The <c>translucencyByDistance</c> property defines how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        public NearFarScalarCesiumWriter OpenTranslucencyByDistanceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TranslucencyByDistanceWriter);
        }

        /// <summary>
        /// Writes a value for the <c>translucencyByDistance</c> property as a <c>nearFarScalar</c> value.  The <c>translucencyByDistance</c> property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteTranslucencyByDistanceProperty(NearFarScalar value)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>translucencyByDistance</c> property as a <c>nearFarScalar</c> value.  The <c>translucencyByDistance</c> property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        public void WriteTranslucencyByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            }
        }

        /// <summary>
        /// Writes a value for the <c>translucencyByDistance</c> property as a <c>nearFarScalar</c> value.  The <c>translucencyByDistance</c> property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteTranslucencyByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>translucencyByDistance</c> property as a <c>nearFarScalar</c> value.  The <c>translucencyByDistance</c> property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteTranslucencyByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>translucencyByDistance</c> property as a <c>reference</c> value.  The <c>translucencyByDistance</c> property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteTranslucencyByDistancePropertyReference(Reference value)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>translucencyByDistance</c> property as a <c>reference</c> value.  The <c>translucencyByDistance</c> property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteTranslucencyByDistancePropertyReference(string value)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>translucencyByDistance</c> property as a <c>reference</c> value.  The <c>translucencyByDistance</c> property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteTranslucencyByDistancePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>translucencyByDistance</c> property as a <c>reference</c> value.  The <c>translucencyByDistance</c> property specifies how the label's translucency should change based on the label's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteTranslucencyByDistancePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>pixelOffsetScaleByDistance</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>pixelOffsetScaleByDistance</c> property defines how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        public NearFarScalarCesiumWriter PixelOffsetScaleByDistanceWriter
        {
            get { return m_pixelOffsetScaleByDistance.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>pixelOffsetScaleByDistance</c> property.  The <c>pixelOffsetScaleByDistance</c> property defines how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        public NearFarScalarCesiumWriter OpenPixelOffsetScaleByDistanceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelOffsetScaleByDistanceWriter);
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffsetScaleByDistance</c> property as a <c>nearFarScalar</c> value.  The <c>pixelOffsetScaleByDistance</c> property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePixelOffsetScaleByDistanceProperty(NearFarScalar value)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffsetScaleByDistance</c> property as a <c>nearFarScalar</c> value.  The <c>pixelOffsetScaleByDistance</c> property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        public void WritePixelOffsetScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffsetScaleByDistance</c> property as a <c>nearFarScalar</c> value.  The <c>pixelOffsetScaleByDistance</c> property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePixelOffsetScaleByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffsetScaleByDistance</c> property as a <c>nearFarScalar</c> value.  The <c>pixelOffsetScaleByDistance</c> property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WritePixelOffsetScaleByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffsetScaleByDistance</c> property as a <c>reference</c> value.  The <c>pixelOffsetScaleByDistance</c> property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WritePixelOffsetScaleByDistancePropertyReference(Reference value)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffsetScaleByDistance</c> property as a <c>reference</c> value.  The <c>pixelOffsetScaleByDistance</c> property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WritePixelOffsetScaleByDistancePropertyReference(string value)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffsetScaleByDistance</c> property as a <c>reference</c> value.  The <c>pixelOffsetScaleByDistance</c> property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WritePixelOffsetScaleByDistancePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>pixelOffsetScaleByDistance</c> property as a <c>reference</c> value.  The <c>pixelOffsetScaleByDistance</c> property specifies how the label's pixel offset should change based on the label's distance from the camera.  This scalar value will be multiplied by <c>pixelOffset</c>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WritePixelOffsetScaleByDistancePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

    }
}
