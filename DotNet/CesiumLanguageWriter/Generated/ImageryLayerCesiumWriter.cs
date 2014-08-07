// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ImageryLayer</code> to a <see cref="CesiumOutputStream" />.  A <code>ImageryLayer</code> an imagery layer drawn on the terrain surface.
    /// </summary>
    public class ImageryLayerCesiumWriter : CesiumPropertyWriter<ImageryLayerCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>alpha</code> property.
        /// </summary>
        public const string AlphaPropertyName = "alpha";

        /// <summary>
        /// The name of the <code>brightness</code> property.
        /// </summary>
        public const string BrightnessPropertyName = "brightness";

        /// <summary>
        /// The name of the <code>contrast</code> property.
        /// </summary>
        public const string ContrastPropertyName = "contrast";

        /// <summary>
        /// The name of the <code>hue</code> property.
        /// </summary>
        public const string HuePropertyName = "hue";

        /// <summary>
        /// The name of the <code>saturation</code> property.
        /// </summary>
        public const string SaturationPropertyName = "saturation";

        /// <summary>
        /// The name of the <code>gamma</code> property.
        /// </summary>
        public const string GammaPropertyName = "gamma";

        /// <summary>
        /// The name of the <code>webMapService</code> property.
        /// </summary>
        public const string WebMapServicePropertyName = "webMapService";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_alpha = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(AlphaPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_brightness = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(BrightnessPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_contrast = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ContrastPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_hue = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(HuePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_saturation = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(SaturationPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_gamma = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(GammaPropertyName), false);
        private readonly Lazy<WebMapServiceCesiumWriter> m_webMapService = new Lazy<WebMapServiceCesiumWriter>(() => new WebMapServiceCesiumWriter(WebMapServicePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ImageryLayerCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ImageryLayerCesiumWriter(ImageryLayerCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ImageryLayerCesiumWriter Clone()
        {
            return new ImageryLayerCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the imagery layer is shown.  Tiles are not downloaded for imagery layers that are not shown, so it may take a moment for the imagery layer's tiles to appear once it is shown.  To download tiles but not show them, set the alpha property to 0.0 instead of setting show to false.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the imagery layer is shown.  Tiles are not downloaded for imagery layers that are not shown, so it may take a moment for the imagery layer's tiles to appear once it is shown.  To download tiles but not show them, set the alpha property to 0.0 instead of setting show to false.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the imagery layer is shown.  Tiles are not downloaded for imagery layers that are not shown, so it may take a moment for the imagery layer's tiles to appear once it is shown.  To download tiles but not show them, set the alpha property to 0.0 instead of setting show to false.
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
        /// Gets the writer for the <code>alpha</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>alpha</code> property defines the alpha blending value of this layer, from 0.0 to 1.0.  0.0 is fully transparent and 1.0 is fully opaque.  The default is 1.0.  A layer with an alpha of 0.0 will not be shown and will not impact rendering performance, but its tiles will still be downloaded.
        /// </summary>
        public DoubleCesiumWriter AlphaWriter
        {
            get { return m_alpha.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>alpha</code> property.  The <code>alpha</code> property defines the alpha blending value of this layer, from 0.0 to 1.0.  0.0 is fully transparent and 1.0 is fully opaque.  The default is 1.0.  A layer with an alpha of 0.0 will not be shown and will not impact rendering performance, but its tiles will still be downloaded.
        /// </summary>
        public DoubleCesiumWriter OpenAlphaProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(AlphaWriter);
        }

        /// <summary>
        /// Writes a value for the <code>alpha</code> property as a <code>number</code> value.  The <code>alpha</code> property specifies the alpha blending value of this layer, from 0.0 to 1.0.  0.0 is fully transparent and 1.0 is fully opaque.  The default is 1.0.  A layer with an alpha of 0.0 will not be shown and will not impact rendering performance, but its tiles will still be downloaded.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteAlphaProperty(double value)
        {
            using (var writer = OpenAlphaProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alpha</code> property as a <code>number</code> value.  The <code>alpha</code> property specifies the alpha blending value of this layer, from 0.0 to 1.0.  0.0 is fully transparent and 1.0 is fully opaque.  The default is 1.0.  A layer with an alpha of 0.0 will not be shown and will not impact rendering performance, but its tiles will still be downloaded.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteAlphaProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenAlphaProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alpha</code> property as a <code>reference</code> value.  The <code>alpha</code> property specifies the alpha blending value of this layer, from 0.0 to 1.0.  0.0 is fully transparent and 1.0 is fully opaque.  The default is 1.0.  A layer with an alpha of 0.0 will not be shown and will not impact rendering performance, but its tiles will still be downloaded.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteAlphaPropertyReference(Reference value)
        {
            using (var writer = OpenAlphaProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alpha</code> property as a <code>reference</code> value.  The <code>alpha</code> property specifies the alpha blending value of this layer, from 0.0 to 1.0.  0.0 is fully transparent and 1.0 is fully opaque.  The default is 1.0.  A layer with an alpha of 0.0 will not be shown and will not impact rendering performance, but its tiles will still be downloaded.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteAlphaPropertyReference(string value)
        {
            using (var writer = OpenAlphaProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alpha</code> property as a <code>reference</code> value.  The <code>alpha</code> property specifies the alpha blending value of this layer, from 0.0 to 1.0.  0.0 is fully transparent and 1.0 is fully opaque.  The default is 1.0.  A layer with an alpha of 0.0 will not be shown and will not impact rendering performance, but its tiles will still be downloaded.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteAlphaPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenAlphaProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alpha</code> property as a <code>reference</code> value.  The <code>alpha</code> property specifies the alpha blending value of this layer, from 0.0 to 1.0.  0.0 is fully transparent and 1.0 is fully opaque.  The default is 1.0.  A layer with an alpha of 0.0 will not be shown and will not impact rendering performance, but its tiles will still be downloaded.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteAlphaPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenAlphaProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>brightness</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>brightness</code> property defines the brightness of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 make the imagery darker while values greater than 1.0 make it brighter.
        /// </summary>
        public DoubleCesiumWriter BrightnessWriter
        {
            get { return m_brightness.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>brightness</code> property.  The <code>brightness</code> property defines the brightness of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 make the imagery darker while values greater than 1.0 make it brighter.
        /// </summary>
        public DoubleCesiumWriter OpenBrightnessProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(BrightnessWriter);
        }

        /// <summary>
        /// Writes a value for the <code>brightness</code> property as a <code>number</code> value.  The <code>brightness</code> property specifies the brightness of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 make the imagery darker while values greater than 1.0 make it brighter.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBrightnessProperty(double value)
        {
            using (var writer = OpenBrightnessProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>brightness</code> property as a <code>number</code> value.  The <code>brightness</code> property specifies the brightness of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 make the imagery darker while values greater than 1.0 make it brighter.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteBrightnessProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenBrightnessProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>brightness</code> property as a <code>reference</code> value.  The <code>brightness</code> property specifies the brightness of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 make the imagery darker while values greater than 1.0 make it brighter.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteBrightnessPropertyReference(Reference value)
        {
            using (var writer = OpenBrightnessProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>brightness</code> property as a <code>reference</code> value.  The <code>brightness</code> property specifies the brightness of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 make the imagery darker while values greater than 1.0 make it brighter.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteBrightnessPropertyReference(string value)
        {
            using (var writer = OpenBrightnessProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>brightness</code> property as a <code>reference</code> value.  The <code>brightness</code> property specifies the brightness of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 make the imagery darker while values greater than 1.0 make it brighter.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteBrightnessPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenBrightnessProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>brightness</code> property as a <code>reference</code> value.  The <code>brightness</code> property specifies the brightness of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 make the imagery darker while values greater than 1.0 make it brighter.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteBrightnessPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenBrightnessProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>contrast</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>contrast</code> property defines the contrast of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the contrast while values greater than 1.0 increase it.
        /// </summary>
        public DoubleCesiumWriter ContrastWriter
        {
            get { return m_contrast.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>contrast</code> property.  The <code>contrast</code> property defines the contrast of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the contrast while values greater than 1.0 increase it.
        /// </summary>
        public DoubleCesiumWriter OpenContrastProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ContrastWriter);
        }

        /// <summary>
        /// Writes a value for the <code>contrast</code> property as a <code>number</code> value.  The <code>contrast</code> property specifies the contrast of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the contrast while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteContrastProperty(double value)
        {
            using (var writer = OpenContrastProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>contrast</code> property as a <code>number</code> value.  The <code>contrast</code> property specifies the contrast of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the contrast while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteContrastProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenContrastProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>contrast</code> property as a <code>reference</code> value.  The <code>contrast</code> property specifies the contrast of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the contrast while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteContrastPropertyReference(Reference value)
        {
            using (var writer = OpenContrastProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>contrast</code> property as a <code>reference</code> value.  The <code>contrast</code> property specifies the contrast of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the contrast while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteContrastPropertyReference(string value)
        {
            using (var writer = OpenContrastProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>contrast</code> property as a <code>reference</code> value.  The <code>contrast</code> property specifies the contrast of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the contrast while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteContrastPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenContrastProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>contrast</code> property as a <code>reference</code> value.  The <code>contrast</code> property specifies the contrast of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the contrast while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteContrastPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenContrastProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>hue</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>hue</code> property defines the hue of the layer.  0.0, the default, uses the unmodified imagery color.
        /// </summary>
        public DoubleCesiumWriter HueWriter
        {
            get { return m_hue.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>hue</code> property.  The <code>hue</code> property defines the hue of the layer.  0.0, the default, uses the unmodified imagery color.
        /// </summary>
        public DoubleCesiumWriter OpenHueProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HueWriter);
        }

        /// <summary>
        /// Writes a value for the <code>hue</code> property as a <code>number</code> value.  The <code>hue</code> property specifies the hue of the layer.  0.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteHueProperty(double value)
        {
            using (var writer = OpenHueProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>hue</code> property as a <code>number</code> value.  The <code>hue</code> property specifies the hue of the layer.  0.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteHueProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenHueProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>hue</code> property as a <code>reference</code> value.  The <code>hue</code> property specifies the hue of the layer.  0.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteHuePropertyReference(Reference value)
        {
            using (var writer = OpenHueProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>hue</code> property as a <code>reference</code> value.  The <code>hue</code> property specifies the hue of the layer.  0.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteHuePropertyReference(string value)
        {
            using (var writer = OpenHueProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>hue</code> property as a <code>reference</code> value.  The <code>hue</code> property specifies the hue of the layer.  0.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteHuePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenHueProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>hue</code> property as a <code>reference</code> value.  The <code>hue</code> property specifies the hue of the layer.  0.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteHuePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenHueProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>saturation</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>saturation</code> property defines the saturation of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the saturation while values greater than 1.0 increase it.
        /// </summary>
        public DoubleCesiumWriter SaturationWriter
        {
            get { return m_saturation.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>saturation</code> property.  The <code>saturation</code> property defines the saturation of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the saturation while values greater than 1.0 increase it.
        /// </summary>
        public DoubleCesiumWriter OpenSaturationProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SaturationWriter);
        }

        /// <summary>
        /// Writes a value for the <code>saturation</code> property as a <code>number</code> value.  The <code>saturation</code> property specifies the saturation of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the saturation while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteSaturationProperty(double value)
        {
            using (var writer = OpenSaturationProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>saturation</code> property as a <code>number</code> value.  The <code>saturation</code> property specifies the saturation of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the saturation while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteSaturationProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenSaturationProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>saturation</code> property as a <code>reference</code> value.  The <code>saturation</code> property specifies the saturation of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the saturation while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteSaturationPropertyReference(Reference value)
        {
            using (var writer = OpenSaturationProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>saturation</code> property as a <code>reference</code> value.  The <code>saturation</code> property specifies the saturation of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the saturation while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteSaturationPropertyReference(string value)
        {
            using (var writer = OpenSaturationProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>saturation</code> property as a <code>reference</code> value.  The <code>saturation</code> property specifies the saturation of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the saturation while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteSaturationPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenSaturationProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>saturation</code> property as a <code>reference</code> value.  The <code>saturation</code> property specifies the saturation of the layer.  1.0, the default, uses the unmodified imagery color.  Values less than 1.0 reduce the saturation while values greater than 1.0 increase it.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteSaturationPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenSaturationProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>gamma</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>gamma</code> property defines the gamma of the layer.  1.0, the default, uses the unmodified imagery color.
        /// </summary>
        public DoubleCesiumWriter GammaWriter
        {
            get { return m_gamma.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>gamma</code> property.  The <code>gamma</code> property defines the gamma of the layer.  1.0, the default, uses the unmodified imagery color.
        /// </summary>
        public DoubleCesiumWriter OpenGammaProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GammaWriter);
        }

        /// <summary>
        /// Writes a value for the <code>gamma</code> property as a <code>number</code> value.  The <code>gamma</code> property specifies the gamma of the layer.  1.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteGammaProperty(double value)
        {
            using (var writer = OpenGammaProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>gamma</code> property as a <code>number</code> value.  The <code>gamma</code> property specifies the gamma of the layer.  1.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteGammaProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenGammaProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>gamma</code> property as a <code>reference</code> value.  The <code>gamma</code> property specifies the gamma of the layer.  1.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteGammaPropertyReference(Reference value)
        {
            using (var writer = OpenGammaProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>gamma</code> property as a <code>reference</code> value.  The <code>gamma</code> property specifies the gamma of the layer.  1.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteGammaPropertyReference(string value)
        {
            using (var writer = OpenGammaProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>gamma</code> property as a <code>reference</code> value.  The <code>gamma</code> property specifies the gamma of the layer.  1.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteGammaPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenGammaProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>gamma</code> property as a <code>reference</code> value.  The <code>gamma</code> property specifies the gamma of the layer.  1.0, the default, uses the unmodified imagery color.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteGammaPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenGammaProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>webMapService</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>webMapService</code> property defines specifies how the imagery for this layer is obtained from a Web Map Service (WMS) server.  This property may not be combined with any other imagery provider type property.
        /// </summary>
        public WebMapServiceCesiumWriter WebMapServiceWriter
        {
            get { return m_webMapService.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>webMapService</code> property.  The <code>webMapService</code> property defines specifies how the imagery for this layer is obtained from a Web Map Service (WMS) server.  This property may not be combined with any other imagery provider type property.
        /// </summary>
        public WebMapServiceCesiumWriter OpenWebMapServiceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(WebMapServiceWriter);
        }

    }
}
