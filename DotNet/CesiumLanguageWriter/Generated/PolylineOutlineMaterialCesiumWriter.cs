// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>PolylineOutlineMaterial</c> to a <see cref="CesiumOutputStream" />.  A <c>PolylineOutlineMaterial</c> is a material that fills the surface of a line with an outlined color.
    /// </summary>
    public class PolylineOutlineMaterialCesiumWriter : CesiumPropertyWriter<PolylineOutlineMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>color</c> property.
        /// </summary>
        public const string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <c>outlineColor</c> property.
        /// </summary>
        public const string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <c>outlineWidth</c> property.
        /// </summary>
        public const string OutlineWidthPropertyName = "outlineWidth";

        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PolylineOutlineMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PolylineOutlineMaterialCesiumWriter(PolylineOutlineMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PolylineOutlineMaterialCesiumWriter Clone()
        {
            return new PolylineOutlineMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <c>color</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>color</c> property defines the color of the surface.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>color</c> property.  The <c>color</c> property defines the color of the surface.
        /// </summary>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>rgba</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>rgba</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>rgba</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>rgba</c> value.  The <c>color</c> property specifies the color of the surface.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>rgbaf</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>rgbaf</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>rgbaf</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>rgbaf</c> value.  The <c>color</c> property specifies the color of the surface.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>reference</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>reference</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>reference</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Writes a value for the <c>color</c> property as a <c>reference</c> value.  The <c>color</c> property specifies the color of the surface.
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
        /// Gets the writer for the <c>outlineColor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>outlineColor</c> property defines the color of the surface outline.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>outlineColor</c> property.  The <c>outlineColor</c> property defines the color of the surface outline.
        /// </summary>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the color of the surface outline.
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
        /// Gets the writer for the <c>outlineWidth</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>outlineWidth</c> property defines the width of the outline.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>outlineWidth</c> property.  The <c>outlineWidth</c> property defines the width of the outline.
        /// </summary>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the width of the outline.
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
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the width of the outline.
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
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the width of the outline.
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
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the width of the outline.
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
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the width of the outline.
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
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the width of the outline.
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
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the width of the outline.
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

    }
}
