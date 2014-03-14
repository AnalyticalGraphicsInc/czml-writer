// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>StripeMaterial</code> to a <see cref="CesiumOutputStream" />.  A <code>StripeMaterial</code> fills the surface with alternating colors.
    /// </summary>
    public class StripeMaterialCesiumWriter : CesiumPropertyWriter<StripeMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>horizontal</code> property.
        /// </summary>
        public const string HorizontalPropertyName = "horizontal";

        /// <summary>
        /// The name of the <code>lightColor</code> property.
        /// </summary>
        public const string LightColorPropertyName = "lightColor";

        /// <summary>
        /// The name of the <code>darkColor</code> property.
        /// </summary>
        public const string DarkColorPropertyName = "darkColor";

        /// <summary>
        /// The name of the <code>offset</code> property.
        /// </summary>
        public const string OffsetPropertyName = "offset";

        /// <summary>
        /// The name of the <code>repeat</code> property.
        /// </summary>
        public const string RepeatPropertyName = "repeat";

        private readonly Lazy<BooleanCesiumWriter> m_horizontal = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(HorizontalPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_lightColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(LightColorPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_darkColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(DarkColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_offset = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OffsetPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_repeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RepeatPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public StripeMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected StripeMaterialCesiumWriter(StripeMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override StripeMaterialCesiumWriter Clone()
        {
            return new StripeMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>horizontal</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>horizontal</code> property defines the value indicating if the stripes are horizontal or vertical.
        /// </summary>
        public BooleanCesiumWriter HorizontalWriter
        {
            get { return m_horizontal.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>horizontal</code> property.  The <code>horizontal</code> property defines the value indicating if the stripes are horizontal or vertical.
        /// </summary>
        public BooleanCesiumWriter OpenHorizontalProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalWriter);
        }

        /// <summary>
        /// Writes a value for the <code>horizontal</code> property as a <code>boolean</code> value.  The <code>horizontal</code> property specifies the value indicating if the stripes are horizontal or vertical.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteHorizontalProperty(bool value)
        {
            using (var writer = OpenHorizontalProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>lightColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>lightColor</code> property defines the first color.
        /// </summary>
        public ColorCesiumWriter LightColorWriter
        {
            get { return m_lightColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>lightColor</code> property.  The <code>lightColor</code> property defines the first color.
        /// </summary>
        public ColorCesiumWriter OpenLightColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LightColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>lightColor</code> property as a <code>rgba</code> value.  The <code>lightColor</code> property specifies the first color.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteLightColorProperty(Color color)
        {
            using (var writer = OpenLightColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>lightColor</code> property as a <code>rgba</code> value.  The <code>lightColor</code> property specifies the first color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteLightColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenLightColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>lightColor</code> property as a <code>rgba</code> value.  The <code>lightColor</code> property specifies the first color.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteLightColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenLightColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>lightColor</code> property as a <code>rgbaf</code> value.  The <code>lightColor</code> property specifies the first color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteLightColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenLightColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>darkColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>darkColor</code> property defines the second color.
        /// </summary>
        public ColorCesiumWriter DarkColorWriter
        {
            get { return m_darkColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>darkColor</code> property.  The <code>darkColor</code> property defines the second color.
        /// </summary>
        public ColorCesiumWriter OpenDarkColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DarkColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>darkColor</code> property as a <code>rgba</code> value.  The <code>darkColor</code> property specifies the second color.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteDarkColorProperty(Color color)
        {
            using (var writer = OpenDarkColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>darkColor</code> property as a <code>rgba</code> value.  The <code>darkColor</code> property specifies the second color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteDarkColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenDarkColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>darkColor</code> property as a <code>rgba</code> value.  The <code>darkColor</code> property specifies the second color.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteDarkColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenDarkColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>darkColor</code> property as a <code>rgbaf</code> value.  The <code>darkColor</code> property specifies the second color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteDarkColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenDarkColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>offset</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>offset</code> property defines the offset from the edge.
        /// </summary>
        public DoubleCesiumWriter OffsetWriter
        {
            get { return m_offset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>offset</code> property.  The <code>offset</code> property defines the offset from the edge.
        /// </summary>
        public DoubleCesiumWriter OpenOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <code>offset</code> property as a <code>number</code> value.  The <code>offset</code> property specifies the offset from the edge.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteOffsetProperty(double value)
        {
            using (var writer = OpenOffsetProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>offset</code> property as a <code>number</code> value.  The <code>offset</code> property specifies the offset from the edge.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteOffsetProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenOffsetProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>repeat</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>repeat</code> property defines the number of time the stripes repeat.
        /// </summary>
        public DoubleCesiumWriter RepeatWriter
        {
            get { return m_repeat.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>repeat</code> property.  The <code>repeat</code> property defines the number of time the stripes repeat.
        /// </summary>
        public DoubleCesiumWriter OpenRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RepeatWriter);
        }

        /// <summary>
        /// Writes a value for the <code>repeat</code> property as a <code>number</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRepeatProperty(double value)
        {
            using (var writer = OpenRepeatProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>repeat</code> property as a <code>number</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRepeatProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRepeatProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

    }
}
