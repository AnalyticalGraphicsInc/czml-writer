// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Point</code> to a <see cref="CesiumOutputStream" />.  A <code>Point</code> is a point, or viewport-aligned circle.
    /// </summary>
    public class PointCesiumWriter : CesiumPropertyWriter<PointCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>pixelSize</code> property.
        /// </summary>
        public const string PixelSizePropertyName = "pixelSize";

        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public const string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <code>outlineColor</code> property.
        /// </summary>
        public const string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <code>outlineWidth</code> property.
        /// </summary>
        public const string OutlineWidthPropertyName = "outlineWidth";

        /// <summary>
        /// The name of the <code>scaleByDistance</code> property.
        /// </summary>
        public const string ScaleByDistancePropertyName = "scaleByDistance";

        /// <summary>
        /// The name of the <code>translucencyByDistance</code> property.
        /// </summary>
        public const string TranslucencyByDistancePropertyName = "translucencyByDistance";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_pixelSize = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(PixelSizePropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);
        private readonly Lazy<NearFarScalarCesiumWriter> m_scaleByDistance = new Lazy<NearFarScalarCesiumWriter>(() => new NearFarScalarCesiumWriter(ScaleByDistancePropertyName), false);
        private readonly Lazy<NearFarScalarCesiumWriter> m_translucencyByDistance = new Lazy<NearFarScalarCesiumWriter>(() => new NearFarScalarCesiumWriter(TranslucencyByDistancePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PointCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PointCesiumWriter(PointCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PointCesiumWriter Clone()
        {
            return new PointCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the point is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the point is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the point is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Gets the writer for the <code>pixelSize</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>pixelSize</code> property defines the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter PixelSizeWriter
        {
            get { return m_pixelSize.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>pixelSize</code> property.  The <code>pixelSize</code> property defines the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter OpenPixelSizeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelSizeWriter);
        }

        /// <summary>
        /// Writes a value for the <code>pixelSize</code> property as a <code>number</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePixelSizeProperty(double value)
        {
            using (var writer = OpenPixelSizeProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelSize</code> property as a <code>number</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePixelSizeProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenPixelSizeProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelSize</code> property as a <code>number</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePixelSizeProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenPixelSizeProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelSize</code> property as a <code>reference</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WritePixelSizePropertyReference(Reference value)
        {
            using (var writer = OpenPixelSizeProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelSize</code> property as a <code>reference</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WritePixelSizePropertyReference(string value)
        {
            using (var writer = OpenPixelSizeProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelSize</code> property as a <code>reference</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WritePixelSizePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenPixelSizeProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelSize</code> property as a <code>reference</code> value.  The <code>pixelSize</code> property specifies the size of the point, in pixels.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WritePixelSizePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenPixelSizeProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>color</code> property defines the color of the point.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the point.
        /// </summary>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteColorProperty(Color color)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteColorProperty(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteColorPropertyRgbaf(Color color)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteColorPropertyReference(Reference value)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteColorPropertyReference(string value)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the point.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outlineColor</code> property defines the color of the outline of the point.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the color of the outline of the point.
        /// </summary>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteOutlineColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the point.
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
        /// Gets the writer for the <code>outlineWidth</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outlineWidth</code> property defines the width of the outline of the point.  If not specified, the default value is 0.0.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outlineWidth</code> property.  The <code>outlineWidth</code> property defines the width of the outline of the point.  If not specified, the default value is 0.0.
        /// </summary>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the point.  If not specified, the default value is 0.0.
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
        /// Gets the writer for the <code>scaleByDistance</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>scaleByDistance</code> property defines how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        public NearFarScalarCesiumWriter ScaleByDistanceWriter
        {
            get { return m_scaleByDistance.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>scaleByDistance</code> property.  The <code>scaleByDistance</code> property defines how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        public NearFarScalarCesiumWriter OpenScaleByDistanceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleByDistanceWriter);
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteScaleByDistanceProperty(NearFarScalar value)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        public void WriteScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteScaleByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteScaleByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteScaleByDistancePropertyReference(Reference value)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteScaleByDistancePropertyReference(string value)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteScaleByDistancePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the point's scale should change based on the point's distance from the camera.  This scalar value will be multiplied by `pixelSize`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteScaleByDistancePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>translucencyByDistance</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>translucencyByDistance</code> property defines how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        public NearFarScalarCesiumWriter TranslucencyByDistanceWriter
        {
            get { return m_translucencyByDistance.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>translucencyByDistance</code> property.  The <code>translucencyByDistance</code> property defines how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        public NearFarScalarCesiumWriter OpenTranslucencyByDistanceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TranslucencyByDistanceWriter);
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
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
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
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
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
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
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteTranslucencyByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
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
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
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
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
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
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the point's translucency should change based on the point's distance from the camera.  This scalar value should range from 0 to 1.
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

    }
}
